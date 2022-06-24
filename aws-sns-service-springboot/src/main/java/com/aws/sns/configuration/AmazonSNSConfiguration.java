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
	
	@Primary
	@Bean
	public AmazonSNSClient amazonSNSClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder.
				standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(
										"AKIAVHCXJOQKT3MMCADO", 
										"CA1WGM3Ra492kn1mleA2i088suU9Lgo1pekMuE2R"
										)
						)
				).
				build();
	}
}
