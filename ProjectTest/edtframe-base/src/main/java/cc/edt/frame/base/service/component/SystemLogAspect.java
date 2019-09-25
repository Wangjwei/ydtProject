package cc.edt.frame.base.service.component;

import cc.edt.frame.base.service.SystemLogService;
import cc.edt.frame.common.annotation.Log;
import cc.edt.frame.model.entity.base.SystemLog;
import cc.edt.frame.model.entity.base.User;
import cc.edt.iceutils2.random.IceRandomUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 系统操作日志AOP
 *
 * @author 刘钢
 * @date 2018/6/12 13:22
 */
@Aspect
@Component
public class SystemLogAspect {
	@Resource
	private SystemLogService systemLogService;

	@Pointcut("execution (* cc.edt.frame.*.controller..*.*(..))")
	public void controllerAspect() {
	}

	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		SystemLog systemLog = new SystemLog();

		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass;
		String operationType = "";
		String operationName = "";
		String params = "";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		systemLog.setId(IceRandomUtils.longUUID());
		if (user != null) {
			systemLog.setUserId(user.getLoginId());
		} else {
			systemLog.setUserId("");
		}
		systemLog.setAddTime(new Date());
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			params = Arrays.toString(joinPoint.getArgs());
		}
		try {
			targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						if (method.getAnnotation(Log.class) != null
								&& method.getAnnotation(Log.class) != null) {
							operationType = method.getAnnotation(Log.class)
									.operationType();
							operationName = method.getAnnotation(Log.class)
									.operationName();
							systemLog.setOperationName(operationName);
							systemLog.setOperationType(operationType);
							systemLog.setContent(params);
							systemLogService.saveSystemLog(systemLog);
						}
						break;
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
