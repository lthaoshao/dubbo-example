package com.lthaoshao.dubbo;

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

        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("application.xml");
        classPathXmlApplicationContext.start();
        System.out.println("启动完成, 输入回车结束");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
