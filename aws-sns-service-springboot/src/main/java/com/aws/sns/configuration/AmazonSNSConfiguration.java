package com.aws.sns.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AmazonSNSConfiguration {
	
	
	// removed accesskeyID and secretAccessKey for security concerns 
	@Primary
	@Bean
	public AmazonSNSClient amazonSNSClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder.
				standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(
										"Access_key_ID", 
										"Secret access key"
										)
						)
				).
				build();
	}
}
