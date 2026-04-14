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
                // 1. Các trang cụ thể ai cũng vào được
                .requestMatchers("/", "/hello", "/login").permitAll() 
                // 2. Phải có quyền USER mới vào được /products/
                .requestMatchers("/products/**").hasRole("USER") 
                // 3. Phải có quyền ADMIN mới vào được /admincp
                .requestMatchers("/admincp").hasRole("ADMIN")   
                // 4. Các request khác bắt buộc phải đăng nhập (dù là quyền gì)
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
                .password("{noop}123") // {noop} để không mã hóa (chỉ demo)
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}123456")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}