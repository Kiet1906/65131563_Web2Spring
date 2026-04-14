package ntu.kiet.sessionwithspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated() // Yêu cầu đăng nhập để truy cập mọi trang
            )
            .formLogin(form -> form
                .loginPage("/login").permitAll() // Sử dụng trang login tùy chỉnh
                .defaultSuccessUrl("/home", true)
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .sessionManagement(session -> session
                .maximumSessions(1) // Chỉ cho phép 1 session tồn tại (1 thiết bị)
                .maxSessionsPreventsLogin(true) // Ngăn đăng nhập ở nơi khác nếu đang đăng nhập
            );

        return http.build();
    }
}