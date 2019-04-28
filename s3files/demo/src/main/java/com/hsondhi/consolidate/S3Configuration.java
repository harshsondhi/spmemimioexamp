package com.hsondhi.consolidate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;

@Configuration
public class S3Configuration {
	
	@Value("${s3.accessKey}")
	private String accessKey;
	
	@Value("${s3.secretKey}")
	private String secretKey;
	
	@Value("${s3.url}")
	private String url;
	
	
	@Bean
	public MinioClient s3client() throws InvalidEndpointException, InvalidPortException {
		MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
		return minioClient;
	}

}
