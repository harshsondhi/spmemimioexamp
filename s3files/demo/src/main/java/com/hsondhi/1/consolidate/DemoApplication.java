package com.hsondhi.consolidate;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ResourceUtils;

import com.harsh.sondhi.s3client.MinIOS3ClientService;

@EnableAsync
@SpringBootApplication
public class DemoApplication {
	
   
    
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		try {
//			File resource1 = new ClassPathResource("MyFile\\anytoolname\\harshtestfile.txt").getFile();
//			File resource10 = new ClassPathResource("MyFile\\anytoolname").getFile();
//			System.out.println("1)------------ " + resource1.toString());
//			File resource2 = ResourceUtils.getFile("classpath:MyFile\\anytoolname\\harshtestfile.txt");
//			
//			File resource20 = ResourceUtils.getFile("classpath:MyFile\\anytoolname");
//			System.out.println("2)------------ " + resource2.toString());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  
	}
	
	@Bean(name = "threadPoolExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(7);
		executor.setMaxPoolSize(42);
		executor.setQueueCapacity(11);
		executor.setThreadNamePrefix("threadPoolExecutor-");
		executor.initialize();
		return executor;
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Path targetLocalFile = Paths.get("C:\\\\Users\\\\harsh\\\\AppData\\\\Local\\\\Temp\\\\anytool.jpg");
//		minIOS3ClientService.uploadFileToS3Bucket(targetLocalFile, "ccsnetwork", "harshOne");
//		
//	}

}
