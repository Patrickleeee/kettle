package com.kettle.job;

import com.kettle.uitl.KettleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Desciption kettle任务Job
 * Create By  li.bo
 * CreateTime 2018/4/20 18:54
 * UpdateTime 2018/4/20 18:54
 */
@Component
@EnableScheduling
public class KettleTaskJob {

    private static Logger LOGGER = LoggerFactory.getLogger(KettleTaskJob.class.getName());

    @Value("${kettle.task1}")
    private String task1;

    @Value("${kettle.task2}")
    private String task2;

    /**
     * 每天凌晨1点进行数据同步更新
     * @throws Exception
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void runTask1() throws Exception {
        LOGGER.info("*****kettle定时任务运行开始******");
        String transFileName = this.task1;
        KettleUtil.callNativeJob(transFileName);
        LOGGER.info("*****kettle定时任务运行结束******");
    }

    /**
     * 每周六凌晨1点进行商户每年月数据同步更新
     * @throws Exception
     */
    @Scheduled(cron = "0 0 1 ? * SAT")
    public void runTask2() throws Exception {
        LOGGER.info("*****kettle定时任务运行开始******");
        String transFileName = this.task2;
        LOGGER.info("task2:{}", this.task2);
        KettleUtil.callNativeTrans(transFileName);
        LOGGER.info("*****kettle定时任务运行结束******");
    }

//    public static void main(String[] args) throws Exception {
//        KettleTaskJob job = new KettleTaskJob();
//        job.runTask2();
//    }
}
