package com.lthaoshao.dubbo;

import com.lthaoshao.dubbo.api.TradeServiceFacade;
import com.lthaoshao.dubbo.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>  </p>
 *
 * @author lijinghao
 * @version : DubboConsumerStart.java, v 0.1 2019年07月22日 15:55:55 lijinghao Exp $
 */
@Slf4j
public class DubboConsumerStart {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.start();
        try {
            IOrderService orderService = context.getBean(IOrderService.class);
            String order = orderService.createOrder();
            log.info("order:{}", order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(context.getBean(TradeServiceFacade.class).query("100"));
    }
}
