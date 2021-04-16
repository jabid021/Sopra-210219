package formation.sopra.formationSrpingBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// regle pour url open
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/public", "/public/**");
	}

	// regle pour url secure
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//// @formatter:off
		http.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/admin","/admin/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated()
			.and()
			.formLogin();
		// @formatter:on
	}

	// user
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("toto").password("{noop}toto").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("tutu").password("{noop}tutu").roles("USER");
	}
}
