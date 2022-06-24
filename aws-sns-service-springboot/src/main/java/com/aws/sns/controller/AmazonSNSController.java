package com.aws.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class AmazonSNSController {

	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	private String TOPIC_ARN = "arn:aws:sns:us-east-1:358812840981:my-sns-topic";

	@GetMapping("/subscribe/{email}")
	public String subscribeToSNSTopic(@PathVariable("email") String email) {
		
		SubscribeRequest subscribeRequest =new SubscribeRequest(TOPIC_ARN, "email", email);
		
		amazonSNSClient.subscribe(subscribeRequest);
		return "Please check your email !!";
	}
	
	@GetMapping("/publish/{msg}")
	public String publishToTopic(@PathVariable("msg") String msg) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, msg,"SNS SpringBoot");
		
		amazonSNSClient.publish(publishRequest);
		return "Message Published !!!";
	}
}
