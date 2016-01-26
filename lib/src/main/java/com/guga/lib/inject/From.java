package com.guga.lib.inject;

/**
 * Created by pingfu on 16/1/13.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author pingfu
 */
@Retention(RetentionPolicy.RUNTIME) //运行时执行
@Target(ElementType.FIELD)//属性
@Inherited
public @interface From {
    int value() default -1;
    boolean canBeNull() default false;
}
