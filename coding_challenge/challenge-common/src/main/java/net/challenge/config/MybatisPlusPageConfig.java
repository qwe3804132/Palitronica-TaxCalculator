package net.challenge.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusPageConfig {

  //旧版写法
//  @Bean
//  public PaginationInterceptor paginationInnerInterceptor() {
//    return new PaginationInterceptor();
//  }

  /**
   * 新式分页插件配置
   * @return
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
    mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    return mybatisPlusInterceptor;
  }

}
