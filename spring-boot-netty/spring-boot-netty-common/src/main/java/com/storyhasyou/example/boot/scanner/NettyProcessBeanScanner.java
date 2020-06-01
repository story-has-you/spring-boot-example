package com.storyhasyou.example.boot.scanner;

import com.storyhasyou.example.boot.annotion.Cmd;
import com.storyhasyou.example.boot.annotion.Module;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author fangxi created by 2020/5/30
 * 在bean初始化之后，加载带有自定义注解的类
 */
@Component
public class NettyProcessBeanScanner implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 1. 获取当前bean的class
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Module.class)) {
            Method[] methods = beanClass.getMethods();
            if (ArrayUtils.isNotEmpty(methods)) {
                Module module = beanClass.getAnnotation(Module.class);
                Stream.of(methods)
                        .filter(method -> method.isAnnotationPresent(Cmd.class))
                        .forEach(method -> {
                            Cmd cmd = method.getAnnotation(Cmd.class);
                            String moduleValue = module.value();
                            String cmdValue = cmd.value();

                            // 关联value和反射对象
                            if (InvokerCache.get(moduleValue, cmdValue) == null) {
                                InvokerCache.add(moduleValue, cmdValue, Invoker.create(method, bean));
                            }
                        });
            }
        }
        return bean;
    }
}
