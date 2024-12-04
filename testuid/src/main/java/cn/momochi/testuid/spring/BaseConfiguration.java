package cn.momochi.testuid.spring;

import cn.momochi.uid.UidGenerator;
import cn.momochi.uid.impl.CachedUidGenerator;
import cn.momochi.uid.impl.DefaultUidGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Autowired
    private DisposableWorkerIdAssigner disposableWorkerIdAssigner;

//    @Bean
//    public UidGenerator uidGenerator() {
//        DefaultUidGenerator instance = new DefaultUidGenerator();
//        instance.setWorkerIdAssigner(disposableWorkerIdAssigner);
//        instance.setTimeBits(29);
//        instance.setWorkerBits(21);
//        instance.setSeqBits(13);
//        instance.setEpochStr("2016-09-20");
//        return instance;
//    }

    @Bean
    public UidGenerator uidGenerator() {
        CachedUidGenerator instance = new CachedUidGenerator();
        instance.setTimeBits(29);
        instance.setWorkerBits(21);
        instance.setSeqBits(13);
        instance.setEpochStr("2016-09-20");
        instance.setBoostPower(3);
        instance.setScheduleInterval(60);
        instance.setWorkerIdAssigner(disposableWorkerIdAssigner);
        return instance;
    }
}
