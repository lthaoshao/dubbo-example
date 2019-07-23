package com.lthaoshao.dubbo.api;

import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;

/**
 * <p> 交易服务 </p>
 *
 * @author lijinghao
 * @version : TradeServiceFacade.java, v 0.1 2019年07月22日 14:13:13 lijinghao Exp $
 */
public interface TradeServiceFacade {

    BaseResponse createOrder(BaseRequest baseRequest);
}
