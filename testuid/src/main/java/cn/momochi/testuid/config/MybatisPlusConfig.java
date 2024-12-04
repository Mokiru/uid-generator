package cn.momochi.testuid.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Supplier;

@Component
@Slf4j
public class MybatisPlusConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("createTime", new Date(), metaObject);
//        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
//        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

//        this.setFieldValByName("lastLoginTime", new Date(), metaObject);
//        this.strictUpdateFill(metaObject, "lastLoginTime", LocalDateTime.class, LocalDateTime.now());
//        this.strictUpdateFill(metaObject, "lastLoginTime", Date.class, new Date());
    }

    //修改严格填充策略
    //默认策略是：如果属性有值，则不覆盖；如果填充值为null，则不填充
    @Override
    public MetaObjectHandler strictFillStrategy(MetaObject metaObject, String fieldName, Supplier<?> fieldVal) {
        //每次填充，直接使用填充值
        //获取字段值，封装到Object对象中
        Object obj = fieldVal.get();
        //判断值是否为空
//        if (Objects.nonNull(obj)) {
        metaObject.setValue(fieldName, obj);
//        }
        return this;
    }
}
