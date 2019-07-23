package com.lthaoshao.dubbo.service;

import com.lthaoshao.dubbo.api.TradeServiceFacade;
import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 实现交易服务 </p>
 *
 * @author lijinghao
 * @version : TradeServiceImpl.java, v 0.1 2019年07月22日 14:20:20 lijinghao Exp $
 */
@Slf4j
public class TradeServiceImpl implements TradeServiceFacade {

    @Override
    public BaseResponse createOrder(BaseRequest baseRequest) {
        log.info("create order request:{} ", baseRequest);
        return BaseResponse.build("0000", "创建成功");
    }
}
