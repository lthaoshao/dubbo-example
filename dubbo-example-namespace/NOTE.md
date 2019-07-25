# Dubbo rest 接口调用问题记录

## postman调用dubbo rest
外放rest接口后,调用不通,对一些注解使用不熟悉.
采用的是jboos的resteasy

两个接口:
1. 普通接口, 接收 String , 响应String 
    
    处理起来没问题.
    
2. 接收Body , 响应 Body
    
* 未设置`@Consumes` 和 `@Produces`, 报错: `415 Unsupported Media Type`    
* 设置`@Consumes(MediaType.APPLICATION_JSON)`, 报错: `415 Unsupported Media Type`   
    最后发现是因为没有导入JSON处理的包导致的
* 加入fastjson包:
```xml
<dependency>
    <groupId>cn.com.bsfit.resteasy</groupId>
    <artifactId>resteasy-fastjson-provider</artifactId>
    <version>1.0.3</version>
</dependency>
<!--需要同时引入fastjson的包-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.51</version>
</dependency>
```
或者直接引入jackson的包:
```xml
 <dependency>
    <groupId>org.jboss.resteasy</groupId>
    <artifactId>resteasy-jackson-provider</artifactId>
    <version>3.0.19.Final</version>
</dependency>
```

结果下面的错:
```text
Could not find MessageBodyWriter for response object of type: com.lthaoshao.dubbo.response.BaseResponse of media type: application/octet-stream
```
这里的意思就很明确了, 响应的Body, 需要设置响应类型.
* 添加了  `@Produces(MediaType.APPLICATION_JSON)`


以上都是采用postman的形式调用的. 下面采用client调用报错:

## 采用dubbo调用dubbo rest
```text
Exception in thread "main" java.lang.RuntimeException: RESTEASY004530: Could not find a method for: public abstract com.lthaoshao.dubbo.response.BaseResponse com.lthaoshao.dubbo.api.TradeServiceFacade.createOrder(com.lthaoshao.dubbo.request.BaseRequest)
```
之前的@Path等注解都是加在了实现类上, 通过http形式的访问是没有问题的, 但是使用dubbo形式的访问就不行了.
原因就是dubbo注册的是接口,接口上没有对应的注解信息, 所以找不到.

* 解决办法就是将所有的注解都转移到接口上, 这样才能通过接口访问.
* 如果某些方法只对外放REST, 则可以只在具体的实现类上加对应的注解, 接口不加, 这样也是可以的.
* 当接口上和实现类上都有注解时, 会以实现类的为主, 这是如果采用client的形式调用,即dubbo调用dubbo, 这时候有可能有问题的.
比如修改了path, client调用就会报出404的错误, 而其他方式调用, 则需要使用正确的路径即可.
```java
@Path("/trade")
public interface TradeServiceFacade {

    @Path("/create")
    @POST               // 限制只能用post形式请求
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})// 接受JSON格式, xml
    BaseResponse createOrder(BaseRequest baseRequest);

    // @Path("/query/{id:\\d+}")
    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    BaseResponse query( String id);
}
```
