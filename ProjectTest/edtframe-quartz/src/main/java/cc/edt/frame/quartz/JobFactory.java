package cc.edt.frame.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * quartz任务工程
 * 
 * @author ajax
 * @date 2017/11/23 21:05
 */
@Component
public class JobFactory extends AdaptableJobFactory {
	@Resource
	private AutowireCapableBeanFactory capableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle)
			throws Exception {
		// 调用父类的方法
		Object jobInstance = super.createJobInstance(bundle);
		// 进行注入
		capableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
}
