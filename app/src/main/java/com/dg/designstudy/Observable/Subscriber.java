package com.dg.designstudy.Observable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscriber {
    /**
     * tag
     */
    String tag() default EventType.DEFAULT_TAG;

    /**
     * 执行线程
     */
    ThreadMode mode() default ThreadType.MAIN;
}
