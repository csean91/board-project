package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {
    private Set<Class<?>> preInstantiatedBeans;

    private Map<Class<?>, Object> beans = new HashMap<>();  // class type 객체를 key로 생성된 instance를 값으로

    public BeanFactory(Set<Class<?>> preInstantiatedBeans) {
        this.preInstantiatedBeans = preInstantiatedBeans;
        initialize();
    }

    /**
     * beans를 초기화 하는 함수
     */
    @SuppressWarnings("unchecked")
    public void initialize() {
        for (Class<?> clazz : preInstantiatedBeans) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    /**
     * class 객체를 instance 시켜주는 함수
     * @param concreteClass
     * @return
     */
    private Object createInstance(Class<?> concreteClass) {
        // 클래스 타입 객체로 생성자 조회
        Constructor<?> constructor = findConstructor(concreteClass);
        // 생성자에 어떤 파라미터가 있는지
        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass : Objects.requireNonNull(constructor).getParameterTypes()) {
//            parameters.add(getBean(typeClass));
            parameters.add(getParamteterByClass(typeClass));
        }

        // 인스턴스 생성
        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor<?> findConstructor(Class<?> concreteClass) {
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(concreteClass);

        if (Objects.nonNull(constructor)) { //constructor가 존재하면
            return constructor;
        }

        return concreteClass.getConstructors()[0];
    }

    private Object getParamteterByClass(Class<?> typeClass) {
        Object instanceBean = getBean(typeClass);
        if (Objects.nonNull(instanceBean)) {
            return instanceBean;
        }
        return createInstance(typeClass);
    }

    public <T> T getBean(Class<T> requiredType) {
        return (T) beans.get(requiredType);
    }
}

