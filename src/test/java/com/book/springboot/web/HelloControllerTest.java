package com.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * RunWith(SpringRunner.class) : 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
 * WebMvcTest : 스프링 MVC 에 집중할 수 있는 어노테이션, @Controller, @ControllerAdvice 등을 사용 가능하게 합니다
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹 API를 테스트할 때 사용

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 http get 요청을 한다
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증(200, 404, 500등의 상태)
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증("hello"인지)
    }
}