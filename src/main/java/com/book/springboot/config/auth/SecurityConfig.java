package com.book.springboot.config.auth;

import com.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 사용을 위해 disable
            .and()
                .authorizeRequests() //  URL별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/index", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // POST 메소드이면서 "/api/v1/**" 주소를 API는 USER 권한을 가진 사람만 가능
                .anyRequest().authenticated() // 나머지 URL들은 모두 로그인한 사용자에게 허용
            .and()
                .logout()
                    .logoutSuccessUrl("/");
//            .and()
//                .oauth2Login() // OAuth 2 로그인 기능 설정의 진입점
//                    .userInfoEndpoint() // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정
//                        .userService(customOAuth2UserService); // 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록, 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시
    }
}
