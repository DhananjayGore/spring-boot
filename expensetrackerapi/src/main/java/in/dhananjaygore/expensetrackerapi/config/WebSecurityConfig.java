package in.dhananjaygore.expensetrackerapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.dhananjaygore.expensetrackerapi.security.CustomUserDetailsService;
import in.dhananjaygore.expensetrackerapi.security.JwtRequestFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private CustomUserDetailsService userDetailsManager;
	
	@Bean
	public JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
		csrf().disable()
		.authorizeRequests()
		.antMatchers("/login", "/rigister").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.httpBasic();
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
		/*InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		UserDetails user1=  User.withUsername("Dhananjay").password("12345").authorities("admin").build();
		UserDetails user2=  User.withUsername("dheeraj").password("12345").authorities("user").build();
		
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);*/
		auth.userDetailsService(userDetailsManager);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
