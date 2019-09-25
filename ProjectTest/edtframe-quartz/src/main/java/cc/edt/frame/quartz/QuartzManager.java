package cc.edt.frame.quartz;

import java.util.*;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 动态定时器管理
 * 
 * @author 刘钢
 * @date 2017/11/23 15:32
 */
@Component
public class QuartzManager {

	@Resource
	private Scheduler sched;

	/**
	 * 增加一个job
	 *
	 * @param jobClass
	 *            任务实现类
	 * @param jobName
	 *            任务名称
	 * @param jobGroupName
	 *            任务组名
	 * @param jobTime
	 *            时间表达式 （如：0/5 * * * * ? ）
	 * @author 刘钢
	 * @date 2017/11/23 23:02
	 */
	public void addJob(Class<? extends Job> jobClass, String jobName,
			String jobGroupName, String jobTime) {
		try {
			// 创建jobDetail实例，绑定Job实现类
			// 指明job的名称，所在组的名称，以及绑定job类
			// 任务名称和组构成任务key
			JobDetail jobDetail = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			// 定义调度触发规则
			// 使用cornTrigger规则
			// 触发器key
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(jobName, jobGroupName)
					.startAt(DateBuilder.futureDate(1,
							DateBuilder.IntervalUnit.SECOND))
					.withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
					.startNow().build();
			// 把作业和触发器注册到任务调度中
			sched.scheduleJob(jobDetail, trigger);
			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增加一个job
	 *
	 * @param jobClass
	 *            任务实现类
	 * @param jobName
	 *            任务名称
	 * @param jobGroupName
	 *            任务组名
	 * @param jobTime
	 *            时间表达式 (这是每隔多少秒为一次任务)
	 * @author 刘钢
	 * @date 2017/11/23 23:02
	 */
	public void addJob(Class<? extends Job> jobClass, String jobName,
			String jobGroupName, int jobTime) {
		addJob(jobClass, jobName, jobGroupName, jobTime, -1);
	}

	/**
	 * 增加一个job
	 *
	 * @param jobClass
	 *            任务实现类
	 * @param jobName
	 *            任务名称
	 * @param jobGroupName
	 *            任务组名
	 * @param jobTime
	 *            时间表达式 (这是每隔多少秒为一次任务)
	 * @param jobTimes
	 *            运行的次数 （<0:表示不限次数）
	 * @author 刘钢
	 * @date 2017/11/23 23:01
	 */
	public void addJob(Class<? extends Job> jobClass, String jobName,
			String jobGroupName, int jobTime, int jobTimes) {
		try {
			// 任务名称和组构成任务key
			JobDetail jobDetail = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			// 使用simpleTrigger规则
			Trigger trigger = null;
			if (jobTimes < 0) {
				trigger = TriggerBuilder.newTrigger()
						.withIdentity(jobName, jobGroupName)
						.withSchedule(
								SimpleScheduleBuilder.repeatSecondlyForever(1)
										.withIntervalInSeconds(jobTime))
						.startNow().build();
			} else {
				trigger = TriggerBuilder.newTrigger()
						.withIdentity(jobName, jobGroupName)
						.withSchedule(
								SimpleScheduleBuilder.repeatSecondlyForever(1)
										.withIntervalInSeconds(jobTime)
										.withRepeatCount(jobTimes))
						.startNow().build();
			}
			sched.scheduleJob(jobDetail, trigger);
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改 一个job的 时间表达式
	 *
	 * @param jobGroupName
	 *            jobGroupName
	 * @param jobName
	 *            jobName
	 * @param jobTime
	 *            jobTime
	 * @author 刘钢
	 * @date 2017/11/23 22:58
	 */
	public void updateJob(String jobName, String jobGroupName, String jobTime) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName,
					jobGroupName);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
					.withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
					.build();
			// 重启触发器
			sched.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除任务一个job
	 *
	 * @param jobName
	 *            任务名称
	 * @param jobGroupName
	 *            任务组名
	 * @author 刘钢
	 * @date 2017/11/23 22:59
	 */
	public void deleteJob(String jobName, String jobGroupName) {
		try {
			sched.deleteJob(new JobKey(jobName, jobGroupName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param jobGroupName
	 *            jobGroupName
	 * @param jobName
	 *            jobName
	 * @author 刘钢
	 * @date 2017/11/23 22:59
	 */
	public void pauseJob(String jobName, String jobGroupName) {
		try {
			JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
			sched.pauseJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 恢复一个job
	 *
	 * @param jobGroupName
	 *            jobGroupName
	 * @param jobName
	 *            jobName
	 * @author 刘钢
	 * @date 2017/11/23 23:00
	 */
	public void resumeJob(String jobName, String jobGroupName) {
		try {
			JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
			sched.resumeJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 立即执行一个job
	 *
	 * @param jobGroupName
	 *            jobGroupName
	 * @param jobName
	 *            jobName
	 * @author 刘钢
	 * @date 2017/11/23 23:00
	 */
	public void runAJobNow(String jobName, String jobGroupName) {
		try {
			JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
			sched.triggerJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有计划中的任务列表
	 *
	 * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 * @author 刘钢
	 * @date 2017/11/23 23:01
	 */
	public List<Map<String, Object>> queryAllJob() {
		List<Map<String, Object>> jobList = null;
		try {
			GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
			Set<JobKey> jobKeys = sched.getJobKeys(matcher);
			jobList = new ArrayList<>();
			for (JobKey jobKey : jobKeys) {
				List<? extends Trigger> triggers = sched
						.getTriggersOfJob(jobKey);
				for (Trigger trigger : triggers) {
					Map<String, Object> map = new HashMap<>();
					map.put("jobName", jobKey.getName());
					map.put("jobGroupName", jobKey.getGroup());
					map.put("description", "触发器:" + trigger.getKey());
					Trigger.TriggerState triggerState = sched
							.getTriggerState(trigger.getKey());
					map.put("jobStatus", triggerState.name());
					if (trigger instanceof CronTrigger) {
						CronTrigger cronTrigger = (CronTrigger) trigger;
						String cronExpression = cronTrigger.getCronExpression();
						map.put("jobTime", cronExpression);
					}
					jobList.add(map);
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return jobList;
	}

	/**
	 * 获取所有正在运行的job
	 *
	 * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
	 * @author 刘钢
	 * @date 2017/11/23 23:01
	 */
	public List<Map<String, Object>> queryRunJon() {
		List<Map<String, Object>> jobList = null;
		try {
			List<JobExecutionContext> executingJobs = sched
					.getCurrentlyExecutingJobs();
			jobList = new ArrayList<>(executingJobs.size());
			for (JobExecutionContext executingJob : executingJobs) {
				Map<String, Object> map = new HashMap<String, Object>();
				JobDetail jobDetail = executingJob.getJobDetail();
				JobKey jobKey = jobDetail.getKey();
				Trigger trigger = executingJob.getTrigger();
				map.put("jobName", jobKey.getName());
				map.put("jobGroupName", jobKey.getGroup());
				map.put("description", "触发器:" + trigger.getKey());
				Trigger.TriggerState triggerState = sched
						.getTriggerState(trigger.getKey());
				map.put("jobStatus", triggerState.name());
				if (trigger instanceof CronTrigger) {
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					map.put("jobTime", cronExpression);
				}
				jobList.add(map);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return jobList;
	}
}
