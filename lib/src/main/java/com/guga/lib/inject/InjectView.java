package com.guga.lib.inject;

/**
 * Created by pingfu on 16/1/13.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author pingfu
 */
@Target(ElementType.FIELD)//属性
@Retention(RetentionPolicy.RUNTIME)//运行时执行
@Documented
public @interface InjectView {
    int From() default -1;
}
