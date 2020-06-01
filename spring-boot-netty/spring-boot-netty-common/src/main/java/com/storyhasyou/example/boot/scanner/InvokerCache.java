package com.storyhasyou.example.boot.scanner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fangxi created by 2020/5/30
 */
public class InvokerCache {

    private final static Map<String /*module + cmd*/,Invoker> CACHE = new ConcurrentHashMap<>();

    public static void add(String module, String cmd, Invoker invoker) {
        String key = module + "#" + cmd;
        CACHE.putIfAbsent(key, invoker);
    }

    public static Invoker get(String module, String cmd) {
        return CACHE.get(module + "#" + cmd);
    }


}
