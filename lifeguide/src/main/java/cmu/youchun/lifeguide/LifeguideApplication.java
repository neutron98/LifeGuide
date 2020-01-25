package cmu.youchun.lifeguide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"cmu.youchun.lifeguide"})
@MapperScan("cmu.youchun.lifeguide.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LifeguideApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeguideApplication.class, args);
	}

}
