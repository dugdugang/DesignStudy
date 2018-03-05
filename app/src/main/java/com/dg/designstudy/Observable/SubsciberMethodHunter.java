package com.dg.designstudy.Observable;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2018/3/5 0005.
 */

public class SubsciberMethodHunter {
    Map<EventType, CopyOnWriteArrayList<Subscription>> mSubcriberMap;

    public SubsciberMethodHunter(Map<EventType, CopyOnWriteArrayList<Subscription>> subcriberMap) {
        this.mSubcriberMap = subcriberMap;
    }

    public void findSubcribeMethods(Object subscriber) {
        if (mSubcriberMap == null) {
            throw new NullPointerException("the mSubcriberMap is null");
        }
        Class<?> clazz = subscriber.getClass();
        //查找
        while (clazz != null && !isSystemCalss(clazz.getName())) {
            final Method[] allMethods = clazz.getDeclaredMethods();
            for (int i = 0; i < allMethods.length; i++) {
                Method method = allMethods[i];
                Subscriber annotation = method.getAnnotation(Subscriber.class);
                if (annotation != null) {
                    Class<?>[] paramsTypeClass = method.getParameterTypes();
                    //只支持一个参数的订阅函数
                    if (paramsTypeClass != null && paramsTypeClass.length == 1) {
                        Class<?> paramType = convertType(paramsTypeClass[0]);
                        EventType eventType = new EventType(paramType, annotation.tag());
                        TargetMethod subscribeMethod = new TargetMethod(method, paramType, annotation.mode());
                        subscibe(eventType, subscribeMethod, subscriber);
                    }
                }
            }
        }
        clazz = clazz.getSuperclass();
    }

    public void subscribe(EventType event, TargetMethod method, Object subscriber) {
        CopyOnWriteArrayList<Subscription> subscriptions = mSubcriberMap.get(event);
        if (subscriptions == null) {
            subscriptions=new CopyOnWriteArrayList<>();
        }
        Subscription newSubscription=new Subscription(subscriber,method);
        if (subscriptions.contains(newSubscription)){
            return;
        }
        subscriptions.add(newSubscription);
        mSubcriberMap.put(event,subscriptions);

    }

}
