package config.auth;

import com.studying.stella.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//@RequiredArgsConstructor
//@EnableWebSecurity

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerOAuth2UserService customerOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception{

        http.
                csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customerOAuth2UserService);
    }

}
