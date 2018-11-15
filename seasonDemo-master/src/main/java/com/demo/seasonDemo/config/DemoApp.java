package com.demo.seasonDemo.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.demo.seasonDemo.handler.ContextHandler;
import com.season.config.Constants;
import com.season.config.Handlers;
import com.season.config.Interceptors;
import com.season.core.db.SlaverDao;
import com.season.core.db.tx.TxByRegex;
import com.season.core.spring.SeasonApplication;
import com.season.core.spring.SeasonRunner;
import com.season.interceptor.ExceptionInterceptor;
import com.season.render.ActionExceptionRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import com.demo.seasonDemo.handler.PathHandler;
import com.demo.interceptor.BBSGlobalInterceptor;

/**
 * Title:
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: seasonDemo
 * Author: Joy
 * Create Time:2017/11/1 09:18
 */
public class DemoApp extends SeasonApplication {

//    public static void main(String[] args) {
//        SeasonRunner.run(DemoApp.class);
//    }
   
    @Autowired
    ContextHandler contextHandler;
    @Autowired




    
    public PathHandler pathHandler;

    public static void main(String[] args) {
        SeasonRunner.run(DemoApp.class);
    }
    public void configHandler(Handlers me) {
        me.add(contextHandler);
        me.add(pathHandler);
        super.configHandler(me);
    }
    public void configConstant(Constants me) {
        super.configConstant(me);
    }

    //设置slaverDao的数据源
    @Override
    public void setSlaverDao(SlaverDao slaverDao) {
        slaverDao.setDsName("slaver");
    }

    /**
     * 拦截器配置，社区所有应用都用此配置，manage应用除外（详见manage启动类）
     *
     * @param me
     */
    public void configInterceptor(Interceptors me) {
        //构建出错拦截器
        ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor();

        //默认所有异常都走MyExceptionRender处理
        exceptionInterceptor.setDefault(new ActionExceptionRender("系统内部错误,请稍后再试!"));

        //对于DbException异常，走MyExceptionRender（你可以自己写自己的） 处理，可以添加多个
        // edit by joy 暂时没有业务需求处理特殊异常，这里注释，全局统一处理异常
//        exceptionInterceptor.addMapping(PageException.class,new PageExceptionRender(constantsProperties.getError500View()));

        me.addGlobalActionInterceptor(exceptionInterceptor);

        me.addGlobalActionInterceptor(new BBSGlobalInterceptor());
        me.addGlobalActionInterceptor(new TxByRegex(
                ".*save.*|.*update.*|.*delete.*|.*insert.*|.*add.*|.*remove.*|.*execute.*|.*audit.*|.*reset.*|.*commit.*"));
    }

    /**
     * 慢sql统计
     *
     * @return
     */
    @Bean
    public StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setSlowSqlMillis(2000);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    /**
     * restTemplate  设置
     *
     * @return
     */
    @Bean
    public SimpleClientHttpRequestFactory initRequestFactory() {
        // 毫秒
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(20000);
        simpleClientHttpRequestFactory.setConnectTimeout(20000);
        return simpleClientHttpRequestFactory;
    }
}
