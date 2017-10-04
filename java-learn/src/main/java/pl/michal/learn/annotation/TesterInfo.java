package pl.michal.learn.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface TesterInfo {

	public enum Priority {
		HIGHT, MEDIUM, LOW
	}
	
	Priority priority() default Priority.MEDIUM;
	String[] tags() default "";
	String createBy() default "Michael";
	String createDate() default "";
}
