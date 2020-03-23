package com.baieapp;

import com.baieapp.properties.SystemProperties;
import com.baieapp.properties.PropertiesManager;
import com.google.inject.name.Names;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.druid.DruidDataSourceProvider;

import java.util.Arrays;
/**
 * @Author dengmin
 * @Created 2020/3/21 19:21
 */
@Slf4j
public class AppModule extends MyBatisModule {
    @Override
    protected void initialize() {
        //绑定数据库的配置
        Names.bindProperties(binder(), new SystemProperties());
        //数据库连接池
        bindDataSourceProvider(new DruidDataSourceProvider());
        // 事务
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        String[] packageName = PropertiesManager.getString(SystemProperties.MAPPER_PACKAGE).split(",");
        Arrays.stream(packageName).forEach(x -> {
            super.addMapperClasses(x);
        });
    }
}
