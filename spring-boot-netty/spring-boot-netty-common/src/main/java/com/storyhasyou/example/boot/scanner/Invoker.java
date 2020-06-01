package com.storyhasyou.example.boot.scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author fangxi created by 2020/5/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoker {

    private Method method;
    private Object target;

    public static Invoker create(Method method, Object target) {
        return new Invoker(method, target);
    }

    @SneakyThrows
    public Object invoke(Object... params) {
        return method.invoke(target, params);
    }

}
