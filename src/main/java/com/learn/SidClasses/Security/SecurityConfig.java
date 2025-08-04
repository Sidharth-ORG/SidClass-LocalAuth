package com.learn.SidClasses.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.SidClasses.Configs.CustomAcessDeniedHandler;
import com.learn.SidClasses.Configs.CustomAuthenticationEntryPoint;
import com.learn.SidClasses.Customs_Constants.AppConstants;
import com.learn.SidClasses.Customs_Constants.CustomMesssage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) //this enables method level security
public class SecurityConfig {
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private CustomAcessDeniedHandler customAcessDeniedHandler;

    public SecurityConfig(CustomAuthenticationEntryPoint customAuthenticationEntryPoint,CustomAcessDeniedHandler customAcessDeniedHandler) {
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.customAcessDeniedHandler=customAcessDeniedHandler;
    }

    @Bean
    //SecurityFilterChain → This method defines the security rules for HTTP requests.
    public SecurityFilterChain securityfilterchain(HttpSecurity https)throws Exception{
        https.authorizeHttpRequests(auth->
                    auth.requestMatchers("/doc.html","/v3/api-docs/**","swagger-ui/**","/swagger-resource/**").permitAll()
                        .requestMatchers(HttpMethod.GET,AppConstants.Default_base_api).hasAnyRole(AppConstants.Default_Admin,AppConstants.Default_Guest)
                        .requestMatchers(HttpMethod.POST,AppConstants.Default_base_api).hasRole(AppConstants.Default_Admin)
                        .requestMatchers(HttpMethod.PUT,AppConstants.Default_base_api).hasRole(AppConstants.Default_Admin)
                        .requestMatchers(HttpMethod.DELETE,AppConstants.Default_base_api).hasRole(AppConstants.Default_Admin)
                        .requestMatchers("/login","/login-process","/success","/logout").permitAll()
                        .anyRequest().authenticated()

        );


//        https.authorizeHttpRequests(auth->
//            auth.requestMatchers(HttpMethod.GET,AppConstants.Default_video_api,AppConstants.Default_course_api).permitAll()
//                    .requestMatchers("/login","/login-process","/logout").permitAll()
//                    .requestMatchers(HttpMethod.POST,"api/v1/users").permitAll()
//                    .anyRequest().authenticated()
//        );

    //basic auth
        https.httpBasic(Customizer.withDefaults());
    //csrf
        https.csrf(AbstractHttpConfigurer::disable);

//**********Cors used lambda bellow ***********
        https.cors(cors->{
    //Defining CORS rules-This is for defining rules of Cors
            CorsConfiguration config=new CorsConfiguration();
            config.setAllowedOrigins(List.of("http://localhost:5174/","http://localhost:8082/"));
           //config.setAllowedOrigins(List.of("http://localhost:5174/","http://localhost:4200/")); //for all other you can pass multiple using setAllow
            config.addAllowedMethod("*");
            config.addAllowedHeader("*");
            config.setAllowCredentials(true);
            config.setMaxAge(300L);
    //Mapping rules to URLs-This is to define url and set rules
           UrlBasedCorsConfigurationSource urlbasedcorsconfsrc=new UrlBasedCorsConfigurationSource();
           urlbasedcorsconfsrc.registerCorsConfiguration("/**",config); //(api endpoint,rules)
    //Applying it to Spring Security
           cors.configurationSource(urlbasedcorsconfsrc);
        });

    //formbased auth
    //for login page and url costumization
        https.formLogin(form->
                form.loginPage("/login").loginProcessingUrl("/login-process").successForwardUrl("/success"));
              //form.usernameParameter("user-ID");   //you can customize the field names like this
              //form.passwordParameter("Passcode");  //form. esa issliye lekhe hen kyun ki lambda with {} use kr rhe thy phle
    //for logout url
        https.logout(form->form.logoutUrl("/logout"));

    //for exception handaling
        https.exceptionHandling(e->
                e.authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAcessDeniedHandler));

    return https.build();
    }

//    //Creating our own user (in memory management)
//   @Bean
//   public UserDetailsService userdetailsservice(){
//        InMemoryUserDetailsManager inmemoryuserdetailsmanager =new InMemoryUserDetailsManager();
//        inmemoryuserdetailsmanager.createUser(User.withDefaultPasswordEncoder().username("Sid").password("sid").roles("Admin").build());
//        inmemoryuserdetailsmanager.createUser(User.withDefaultPasswordEncoder().username("Nik").password("nik").roles("Admin").build());
//        return inmemoryuserdetailsmanager;
//   }

   //this is encoder
    @Bean
    public PasswordEncoder pwencode(){
        return new BCryptPasswordEncoder();
    }

}
