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

    @Value("${kettle.taskJobOne}")
    private String taskJobOne;

    @Value("${kettle.taskJobTwo}")
    private String taskJobTwo;

    @Value("${kettle.taskTransTwo}")
    private String taskTransTwo;

    /**
     * 周六凌晨1点进行merchant_full数据同步更新
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 18 ? * SAT")
    public void runTaskJobOne() throws Exception {
        LOGGER.info("kettle定时任务[{}]运行开始", this.taskJobOne);
        String transFileName = this.taskJobOne;
        KettleUtil.callNativeJob(transFileName);
        LOGGER.info("kettle定时任务[{}]运行结束", this.taskJobOne);
    }

    /**
     * 周六凌晨1点进行merchant_sale数据同步更新
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 18 ? * SAT")
    public void runTaskJobTwo() throws Exception {
        LOGGER.info("kettle定时任务[{}]运行开始", this.taskJobTwo);
        String transFileName = this.taskJobTwo;
        KettleUtil.callNativeJob(transFileName);
        LOGGER.info("kettle定时任务[{}]运行结束", this.taskJobTwo);
    }

    /**
     * 每周六凌晨1点进行Hana中除merchant_full外的其他表同步
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 18 ? * SAT")
//    @Scheduled(cron = "0 00 22 * * ?")
    public void runTaskTransTwo() throws Exception {
        LOGGER.info("kettle定时任务[{}]运行开始", this.taskTransTwo);
        String transFileName = this.taskTransTwo;
        LOGGER.info("task:{}", this.taskTransTwo);
        KettleUtil.callNativeTrans(transFileName);
        LOGGER.info("kettle定时任务[{}]运行结束", this.taskTransTwo);
    }
}
