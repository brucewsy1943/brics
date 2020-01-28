package com.xcz.object.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"com.xcz.object.dao.localhostdao"}, sqlSessionTemplateRef = "localhostSqlSessionTemplate")
public class MysqlLocalhostMyBatisConfig {

	@Bean(name = "localhostDataSource")
	@ConfigurationProperties(prefix="mysqllocalhost.datasource")
	public DataSource localhostDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean
	public SqlSessionFactory localhostSqlSessionFactory(@Qualifier("localhostDataSource")DataSource dataSource ) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource); 
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        try {
			bean.setMapperLocations(resolver.getResources("classpath*:com/xcz/object/dao/localhostdao/mapper/*.xml"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bean.getObject();
   
		
	}
	
	
	@Bean
	public SqlSessionTemplate localhostSqlSessionTemplate(@Qualifier("localhostSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
	}
	

}
