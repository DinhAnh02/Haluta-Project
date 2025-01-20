package Haluta.example.demo.config; // Thay đổi package theo cấu trúc của bạn
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @Deprecated(since = "6.1", forRemoval = true)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/public/**")).permitAll() // Các endpoint bắt đầu với "/public/" không cần xác thực
                .anyRequest().authenticated() // Các endpoint khác yêu cầu xác thực
                .and()
                .httpBasic(); // Kích hoạt xác thực cơ bản
        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/signup") // Đường dẫn API của bạn
                .allowedOrigins("http://localhost:4200") // Địa chỉ frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP được phép
                .allowedHeaders("*"); // Tất cả các header được phép
    }



}
