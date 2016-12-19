package fr.nimrod.ilv;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class IlvApplication extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(IlvApplication.class, args);
	}
	
	@Override
   public Executor getAsyncExecutor() {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(2);
      executor.setMaxPoolSize(2);
      executor.setQueueCapacity(500);
      executor.setThreadNamePrefix("facialManipulation-");
      executor.initialize();
      return executor;
   }
}
