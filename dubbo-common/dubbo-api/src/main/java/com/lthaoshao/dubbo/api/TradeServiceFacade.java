package com.lthaoshao.dubbo.api;

import com.lthaoshao.dubbo.request.BaseRequest;
import com.lthaoshao.dubbo.response.BaseResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * <p> 交易服务 </p>
 *
 * @author lijinghao
 * @version : TradeServiceFacade.java, v 0.1 2019年07月22日 14:13:13 lijinghao Exp $
 */
@Path("/trade")
public interface TradeServiceFacade {

    @Path("/create")
    @POST               // 限制只能用post形式请求
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})// 接受JSON格式, xml
    BaseResponse createOrder(BaseRequest baseRequest);

    @Path("/query/{id:\\d+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    BaseResponse query(@PathParam("id") String id);
}
