package com.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Getter: get메소드 생성
 * RequiredArgsConstructor: 선언되 모든 final 필드가 포함된 생성자 생성
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
