package in.dhananjaygore.expensetrackerapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
		csrf().disable()
		.authorizeRequests()
		.antMatchers("/login", "/rigister").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
	}
	
	// inMemoryAuthentication approach 1
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("dhananjay").password("1234").authorities("admin")
		.and()
		.withUser("drj").password("1234").authorities("user")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}*/
	
	// inMemoryAuthentication approach 2
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		UserDetails user1=  User.withUsername("Dhananjay").password("12345").authorities("admin").build();
		UserDetails user2=  User.withUsername("dheeraj").password("12345").authorities("user").build();
		
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
		auth.userDetailsService(userDetailsManager);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
