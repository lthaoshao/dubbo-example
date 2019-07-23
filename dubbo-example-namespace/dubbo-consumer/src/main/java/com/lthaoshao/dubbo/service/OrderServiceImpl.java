package com.lthaoshao.dubbo.service;

import com.lthaoshao.dubbo.api.TradeServiceFacade;
import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>  </p>
 *
 * @author lijinghao
 * @version : OrderServiceImpl.java, v 0.1 2019年07月22日 15:49:49 lijinghao Exp $
 */
@Slf4j
// @Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private TradeServiceFacade tradeService;


    public OrderServiceImpl() {
    }

    @Override
    public String createOrder() {

        BaseRequest request = new BaseRequest();
        request.setRequestId(String.valueOf(System.currentTimeMillis()));

        BaseResponse result = tradeService.createOrder(request);

        log.info("response:{}", result);
        return result.getMsg();
    }
}
