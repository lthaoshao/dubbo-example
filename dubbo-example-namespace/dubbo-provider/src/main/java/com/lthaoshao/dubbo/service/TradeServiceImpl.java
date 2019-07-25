package com.lthaoshao.dubbo.service;

import com.lthaoshao.dubbo.api.TradeServiceFacade;
import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * <p> 实现交易服务 </p>
 *
 * @author lijinghao
 * @version : TradeServiceImpl.java, v 0.1 2019年07月22日 14:20:20 lijinghao Exp $
 */
@Slf4j
@Path("/trade") // 使用rest形式外放接口
public class TradeServiceImpl implements TradeServiceFacade {

    // @Path("/create")    // 方法路径
    // @POST               // 限制只能用post形式请求
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})// 接受JSON格式, xml
    @Override
    public BaseResponse createOrder(BaseRequest baseRequest) {
        log.info("create order request:{} ", baseRequest);
        return BaseResponse.build(baseRequest.getRequestId(), "创建成功");
    }

    @Path("/query1/{id:\\d+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)   // 响应JSON格式
    @Override
    public BaseResponse query(@PathParam("id") String id) {
        System.out.println("************: " + id);
        return BaseResponse.build(id, "ok");
    }
}
