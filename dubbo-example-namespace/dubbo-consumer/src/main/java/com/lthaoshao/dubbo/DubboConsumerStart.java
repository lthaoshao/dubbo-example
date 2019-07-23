package com.lthaoshao.dubbo;

import com.lthaoshao.dubbo.api.TradeServiceFacade;
import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;
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
        // 1. 直接从context中获取远程服务的实例, 此种方式可以获取到bean
        // TradeServiceFacade tradeServiceFacade = context.getBean(TradeServiceFacade.class);
        // BaseRequest request = new BaseRequest();
        // request.setRequestId(String.valueOf(System.currentTimeMillis()));
        // BaseResponse result = tradeServiceFacade.createOrder(request);
        // log.info("response:{}", result);


        // 2. 通过服务调用, Autowired注入, 此种方式不能获取到实例
        IOrderService orderService = context.getBean(IOrderService.class);
        String order = orderService.createOrder();
        log.info("order:{}", order);
    }
}
