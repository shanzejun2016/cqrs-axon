package rs.in.staleksit.cqrs.axon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import rs.in.staleksit.cqrs.axon.config.PersistanceJPAConfig;
import rs.in.staleksit.cqrs.axon.config.Swagger2Configuration;


@EnableAutoConfiguration
@ComponentScan("rs.in.staleksit.cqrs.axon.*")
@ImportResource(value = {"classpath:org/jtransfo/spring/jTransfoContext.xml", "classpath:rs/in/staleksit/cqrs/axon/ctx/application-integration-ctx.xml"})
@Import(value = {PersistanceJPAConfig.class, Swagger2Configuration.class})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
