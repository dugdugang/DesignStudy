package com.dg.designstudy.SignleInstace;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/2/24 0024.
 * <p>
 * 容器实现单例模式
 */

public class SingletonManager {
    public static HashMap<String, Object> objMap = new HashMap<>();

    private SingletonManager() {

    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}
