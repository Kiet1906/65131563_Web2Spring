package ntu.kiet.demobaomatcoban;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CauHinhBaoMat {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Chỉ cho phép vào trang chủ và trang hello không cần đăng nhập
                .requestMatchers("/", "/hello").permitAll()   
                // Vào trang sản phẩm bắt buộc phải có quyền USER
                .requestMatchers("/products/**").hasRole("USER") 
                // Vào trang Admincp bắt buộc phải có quyền ADMIN
                .requestMatchers("/admincp").hasRole("ADMIN")   
                // Tất cả các trang khác nếu có đều phải đăng nhập
                .anyRequest().authenticated()                  
            )
            .formLogin(form -> form
                .loginPage("/login")          
                .permitAll()                  
            )
            .logout(logout -> logout
                .permitAll()
                .logoutSuccessUrl("/login?logout")
            );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}123") 
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}123456")
                .roles("ADMIN", "USER") // Admin được cấp cả 2 quyền để xem cả trang sản phẩm
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}