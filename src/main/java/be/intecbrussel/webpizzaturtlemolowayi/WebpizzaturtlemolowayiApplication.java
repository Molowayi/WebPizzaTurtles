package be.intecbrussel.webpizzaturtlemolowayi;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.PizzaImpl;
import be.intecbrussel.webpizzaturtlemolowayi.services.tortoise.Tortoise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebpizzaturtlemolowayiApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebpizzaturtlemolowayiApplication.class, args);
	}

	@Bean(name = "michelangelo")
	@Scope("singleton")
	public Tortoise michelangelo() {
		Tortoise michelangelo = new Tortoise();
		michelangelo.setName("Michelangelo");
		return michelangelo;
	}

	@Bean(name = "donatello")
	@Scope("singleton")
	public Tortoise donatello() {
		Tortoise donatello = new Tortoise();
		donatello.setName("Donatello");
		return donatello;
	}

	@Bean(name = "leonardo")
	@Scope("singleton")
	public Tortoise leonardo() {
		Tortoise leonardo = new Tortoise();
		leonardo.setName("Leonardo");
		return leonardo;
	}

	@Bean(name = "raphael")
	@Scope("singleton")
	public Tortoise raphael() {
		Tortoise raphael = new Tortoise();
		raphael.setName("Raphael");
		return raphael;
	}

	@Bean
	@Scope("prototype")
	public Pizza makeEmptyPizza() {
		Pizza newEmplyPizza = new PizzaImpl();
		return newEmplyPizza;
	}

	@Bean
	public WebSecurityConfigurer<WebSecurity> securityConfigurer() {
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder(8))
						.withUser("homer")
						.password("$2a$08$UKA2iyUEJUypmPoI1eR86uxpCVk6NmPKhKD3mBV7hGcUXfMliefXu")
						.roles("ADMIN")
						.and()
						.withUser("guest")
						.password("$2a$08$xoY2wtgRDjKPDACuTOh4ae2F4ala2ZDqFUvabjQtCPv0RSalXp6bq").roles("USER");
			}

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.httpBasic();
				http.authorizeRequests()
						.antMatchers("/leonardo", "/donatello")
						.hasRole("ADMIN");
				http.csrf().disable();
//                        .and()
//                        .authorizeRequests()
//                        .antMatchers("/leonardo", "/donatello","/michelangelo", "/raphael")
//                        .hasRole("USER");
			}
		};
	}

	@PostConstruct
	public void startThreads() {
		michelangelo().start();
		donatello().start();
		leonardo().start();
		raphael().start();
	}
}
