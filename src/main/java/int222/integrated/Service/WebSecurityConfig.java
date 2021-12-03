package int222.integrated.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@CrossOrigin
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("#{'${integrated.origin.method}'.split(',')}")
	private String[] methodList;
	@Value("#{'${integrated.origin.host}'.split(',')}")
	private String[] hostList;
	@Value("#{'${integrated.origin.header}'.split(',')}")
	private String[] headerList;

	@Autowired
	JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
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

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors(
			config -> {
					CorsConfiguration cors = new CorsConfiguration();
					cors.setAllowCredentials(true);
					cors.setAllowedOrigins(Arrays.asList(hostList));
					cors.setAllowedMethods(Arrays.asList(methodList));
					cors.setAllowedHeaders(Arrays.asList(headerList));

					UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
					source.registerCorsConfiguration("/**", cors);

					config.configurationSource(source);
			}).csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/brand","/brand/**","/color","/color/**","/product","/product/**","/Files/**","/login","/register","/me").permitAll()
				.antMatchers("/record","/addRecord","/deleteRecord/**").hasAnyAuthority("ROLE_USER")
				.antMatchers("/addbrand","/updatebrand","/addcolor","/updatecolor","/shop","/shop/**","/addShopWithImage","/onlineshop","/onlineshop/**"
				,"/addonline","/addProductWithImage","/updateProductWithImage/**","/role","/user","/user/**","/updateRole").hasAnyAuthority("ROLE_ADMIN")
				.antMatchers("/editProfile").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated();

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

}
