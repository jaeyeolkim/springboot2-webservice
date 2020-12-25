package com.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 이 클래스가 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS가 실행된다
        SpringApplication.run(Application.class, args);
    }
}
