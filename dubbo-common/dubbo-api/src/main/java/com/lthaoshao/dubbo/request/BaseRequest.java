package com.lthaoshao.dubbo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>  </p>
 *
 * @author lijinghao
 * @version : BaseRequest.java, v 0.1 2019年07月22日 14:14:14 lijinghao Exp $
 */
@Getter
@Setter
@ToString
public class BaseRequest implements Serializable {

    private String requestId;
}
