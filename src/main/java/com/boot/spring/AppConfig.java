package com.boot.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.dao.EducationDao;
import com.dao.HobbyDao;
import com.dao.JobDao;
import com.dao.SkillDao;
import com.dao.UserDao;
import com.security.UserSecurityService;

@Configuration
@ComponentScan( {"com.security","com.boot.spring", "com.boot", "com.example"})
@Import({ SecurityConfig.class })
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver
                          = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public EducationDao educationDao(){
		return new EducationDao();
	}
	@Bean
	public HobbyDao hobbyDao(){
		return new HobbyDao();
	}
	@Bean
	public JobDao jobDao(){
		return new JobDao();
	}
	@Bean
	public SkillDao skillDao(){
		return new SkillDao();
	}
	@Bean
	public UserDao userDao(){
		return new UserDao();
	}
	@Bean
	public UserSecurityService userSecurityService(){
		return new UserSecurityService();
	}
	

}
