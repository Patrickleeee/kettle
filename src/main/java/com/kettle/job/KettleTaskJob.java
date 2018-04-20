package com.kettle.job;

import com.kettle.uitl.KettleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * 每天凌晨1点进行数据同步更新
     * @throws Exception
     */
    @Scheduled(cron = "0 0 01 * * ?")
    public void run() throws Exception {
        LOGGER.info("*****kettle定时任务运行开始******");
        String transFileName = "D:/数据处理-kettle/小贷/hana数据更新.kjb";
        KettleUtil.callNativeJob(transFileName);
        LOGGER.info("*****kettle定时任务运行结束******");
    }

//    public static void main(String[] args) throws Exception {
//        KettleTaskJob job = new KettleTaskJob();
//        job.run();
//    }
}
