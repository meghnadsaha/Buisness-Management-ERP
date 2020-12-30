package com.jcb.erp.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class JcbSchedularAsyncConfig {

	private static final Logger log = LoggerFactory.getLogger(JcbSchedularAsyncConfig.class);

	@Value("${thread.core.pool.size}")
	private int threadPoolSize;

	@Value("${thread.max.pool.size}")
	private int maxPoolSize;

	@Value("${thread.max.pool.queue}")
	private int maxQueueCapacity;

	@Bean(name = "asyncTaskExecutorForJcb")
	public Executor threadPoolTaskExecutor() {
		log.info("JCB Schedular Thread core pool size is : " + threadPoolSize);
		log.info("JCB Schedular Thread max pool size is : " + maxPoolSize);
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(threadPoolSize);
		threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
		threadPoolTaskExecutor.setQueueCapacity(maxQueueCapacity);
		return threadPoolTaskExecutor;

	}

}
