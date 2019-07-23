package com.lthaoshao.dubbo.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>  </p>
 *
 * @author lijinghao
 * @version : BaseResponse.java, v 0.1 2019年07月22日 14:14:14 lijinghao Exp $
 */
@Getter
@Setter
public class BaseResponse implements Serializable {

    private String code;

    private String msg;

    public BaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse() {
    }

    public static BaseResponse build(String code, String msg) {
        return new BaseResponse(code, msg);
    }


}
