package Spring.Data.JPA.SpringJPA_Sequrity.SecurityFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true) // we can achive method level role based accesss security also for that we
	
public class SB_Security {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();
//Both of  user details   for  USER ,ADMIN is  for  basic  Authentication security and can  configuare N- number of  user here .
		UserDetails admin = User.withUsername("pushp").password(passwordEncoder.encode("pushp")).roles("ADMIN")
				//.authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")

				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity htps)
	 * throws Exception {
	 * 
	 * return
	 * htps.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((authz) -> {
	 * authz.requestMatchers("/**").permitAll();
	 * 
	 * authz.requestMatchers("/admin/**").hasRole("ADMIN");
	 * authz.requestMatchers("/loginDetails").hasRole("USER");
	 * 
	 * }) // .formLogin(fmlogin->
	 * fmlogin.loginPage("/user/loginUser").permitAll())// ye // sahi h use krna
	 * padega bad m .build();
	 * 
	 * }
	 */
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


	        return http.authorizeHttpRequests(request -> request
	                        .requestMatchers("/**").permitAll()//not   working  with /home so just  /used 
	                        .requestMatchers("/user/**", "/user/**").authenticated()

	                        .requestMatchers("/admin/**").hasRole("ADMIN")
	                        .anyRequest().authenticated())
	                .httpBasic(Customizer.withDefaults())
	                .csrf(AbstractHttpConfigurer::disable)
	                .build();
	    

	    }

		/*
		 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
		 * throws Exception {
		 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()
		 * ); }
		 */


}
