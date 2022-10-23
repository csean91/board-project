package com.example;

import com.example.annotation.Controller;
import com.example.annotation.Service;
import com.example.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.sql.DataSourceDefinition;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example
 * fileName       : ReflectionTest
 * author         : swch
 * date           : 2022-10-04
 * description    :
 */
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScanTest() {
//        // 기존 코드. 아래는 리팩토링
//        Reflections reflections = new Reflections("com.example");   // com.example 아래에서 reflection
//        Set<Class<?>> beans = new HashSet<>();
//        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
//        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        
        
        Set<Class<?>> beans = getTypesAnnotationWith(List.of(Controller.class, Service.class));
        logger.info("beans {}", beans);
    }

    private Set<Class<?>> getTypesAnnotationWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("com.example");   // com.example 아래에서 reflection
        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }

    @DisplayName("class 정보 출력")
    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug("name : {}", clazz.getName());

        logger.debug("User all declared fields : [{}]",
                Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors : [{}]",
                Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods : [{}]",
                Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }


    @DisplayName("heap 영역에 로드되어 있는 클래스")
    @Test
    public void loadClass() throws ClassNotFoundException {
        // heap 영역에 로드되어 있는 클래스 객체 가져오는 방법 1
        Class<User> clazz = User.class;

        // 방법2
        User user = new User("testId", "testName");
        Class<? extends User> clazz2 = user.getClass() ;

        // 방법3
        Class<?> clazz3 = Class.forName("com.example.model.User");

        logger.debug("clazz1 : [{}]", clazz);
        logger.debug("clazz2 : [{}]", clazz2);
        logger.debug("clazz3 : [{}]", clazz3);

        // test가 통과하면 아래 코드 즉 3개의 객체가 같다는 의미
        assertThat(clazz == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz3 == clazz).isTrue();
    }
}
