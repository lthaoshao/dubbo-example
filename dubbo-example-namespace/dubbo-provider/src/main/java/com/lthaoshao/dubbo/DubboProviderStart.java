package com.lthaoshao.dubbo;

import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <p> 启动类 </p>
 *
 * @author lijinghao
 * @version : DubboProviderStart.java, v 0.1 2019年07月22日 14:54:54 lijinghao Exp $
 */
public class DubboProviderStart {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext classPathXmlApplicationContext
        //         = new ClassPathXmlApplicationContext("META-INF/spring/application.xml");
        // classPathXmlApplicationContext.start();
        //
        // System.out.println("启动完成, 输入回车结束");
        //
        // try {
        //     System.in.read();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // 另外一种启动方式, 需要把配置文件放到 dubbo.spring.config或者META-INF/spring下
        Main.main(args);


    }
}
