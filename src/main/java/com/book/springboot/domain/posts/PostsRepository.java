package com.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<Posts, Long> : 상속 시 기본적인 CRUD 메소드 자동 생성
 * Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없으므로 Entity Repository는 함께 위치해야 한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
