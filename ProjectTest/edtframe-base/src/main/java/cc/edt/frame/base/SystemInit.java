package cc.edt.frame.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cc.edt.frame.common.constant.StaticDictionary;
import net.sf.ehcache.util.PropertyUtil;

/**
 * 系统启动初始化
 *
 * @author 刘钢
 * @date 2018/6/2113:26
 */
@Component
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger logger = LogManager.getLogger(SystemInit.class);

	/**
	 * spring容器初始化时进行加载
	 *
	 * @author 刘钢
	 * @date 2017/5/17 22:37
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 避免容器多次加载
		if (event.getApplicationContext().getParent() == null) {
			logger.info("###################################################");
			Properties propertiesApplication = readProperties(
					"application.properties");
			if (propertiesApplication != null) {
				Properties properties;
				String active = propertiesApplication
						.getProperty("spring.profiles.active");
				String propertiesFileName = "application-" + active
						+ ".properties";
				properties = readProperties(propertiesFileName);
				Enumeration<?> e = properties.propertyNames();
				while (e.hasMoreElements()) {
					String key = (String) e.nextElement();
					String value = properties.getProperty(key);
					StaticDictionary.configMap.put(key, value);
				}
				for (Map.Entry<String, String> stringEntry : StaticDictionary.configMap
						.entrySet()) {
					logger.info(stringEntry.getKey() + "="
							+ stringEntry.getValue());
				}
			}
			logger.info("###################################################");
		}

	}

	/**
	 * 读取指定properties文件
	 *
	 * @param fileName
	 *            fileName
	 * @author 刘钢
	 * @date 2018/6/21 15:51
	 */
	private Properties readProperties(String fileName) {
		Properties props = null;
		InputStream in = null;
		try {
			props = new Properties();
			in = PropertyUtil.class.getClassLoader()
					.getResourceAsStream(fileName);
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.info(fileName + "读取失败，没有找到对应文件信息");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}
}
