package com.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity: JPA의 어노테이션, 필수 어노테이션을 가까이 선언하자
 * NoArgsConstructor: 기본 생성자 자동 추가
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // spring boot2.0에서는 IDENTITY 선언해야 auto_increment 가 된다
    private Long id;

    @Column(length = 500, nullable = false) // Column 은 굳이 선언하지 않아도 되고, 옵션이 필요한 경우에만 선언 varchar(255)가 기본값
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
