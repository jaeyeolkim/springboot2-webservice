package com.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 메소드의 파라미터로 선언된 객체에서 사용할 수 있도록 설정
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface : 어노테이션 클래스로 지정, LoginUser라는 이름을 가진 어노테이션이 생성되었다고 보면 된다
}
