package com.dg.designstudy.Observable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2018/3/5 0005.
 */

public final class EventBus {
    /**
     * 订阅map
     */
    private final Map<EventType, CopyOnWriteArrayList<Subscription>> mSubscriberMap = new ConcurrentHashMap<EventType, CopyOnWriteArrayList>();

    SubsciberMethodHunter mMethodHunter = new SubsciberMethodHunter(mSubscriberMap);

    /**
     * 注册订阅对象
     */
    public void register(Object subscriber) {
        if (subscriber == null) {
            return;
        }
        synchronized (this){
            mMethodHunter.findSubcribeMethods(subscriber);
        }
    }
}
