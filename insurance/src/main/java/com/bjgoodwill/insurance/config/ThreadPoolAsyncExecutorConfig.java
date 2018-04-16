package com.bjgoodwill.insurance.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Package: com.bjgoodwill.insurance.config
 * @Description: 线程池实例和配置
 * @author li_jun 
 * @date 2018年4月13日 下午1:10:14
 * @GUID {deee400b-0128-4068-95b8-c1c38ade5205}
 */
@Component
public class ThreadPoolAsyncExecutorConfig extends ThreadPoolTaskExecutor {

    private static final long serialVersionUID = 1L;

    public ThreadPoolAsyncExecutorConfig() {
        setCorePoolSize(2);//当前线程数
        setMaxPoolSize(120);// 最大线程数
        setQueueCapacity(10);//线程池所使用的缓冲队列
        setWaitForTasksToCompleteOnShutdown(true);//等待任务在关机时完成--表明等待所有线程执行完
        setAwaitTerminationSeconds(60 * 20);// 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        setThreadNamePrefix("InsuranceAsync-");//  线程名称前缀
        this.setKeepAliveSeconds(200);//允许的空闲时间
        initialize(); // 初始化
    }
}
