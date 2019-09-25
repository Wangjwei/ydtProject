package cc.edt.frame.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防止表单重复提交的注解TOKEN
 *
 * @author 刘钢
 * @date 2017-05-18 11:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormToken {

	boolean save() default false;

	boolean remove() default false;
}
