# dubbo namespace 形式接入


## 多注册中心支持

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://dubbo.apache.org/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
       http://dubbo.apache.org/schema/dubbo
       http://dubbo.apache.org/schema/dubbo/dubbo.xsd">

    <!--应用名称, 用于计算依赖关系-->
    <dubbo:application name="dubbo-example-namespace-provider"/>
    <!-- 用 dubbo 协议在 20880 端口暴露服务 -->
    <dubbo:protocol name="dubbo" port="20880"/>

    <!--注册中心地址, 集群模式:address="zookeeper ://ip:host?backup=ip:host,ip:host"-->
    <dubbo:registry id="reg1"  address="zookeeper://192.168.1.30:2181" file="tmp/dubbo/dubbo-provider/"/>
    <!--多注册中心模式-->
    <dubbo:registry id="reg2" address="zookeeper://192.168.1.31:2181" file="tmp/dubbo/dubbo-provider2/"/>

    <!--注册多不同注册中心 registry="reg1" -->
    <dubbo:service interface="com.lthaoshao.dubbo.api.TradeServiceFacade" ref="tradeService" registry="reg1"/>
    <dubbo:service interface="com.lthaoshao.dubbo.api.TradeServiceFacade" ref="tradeService" registry="reg2"/>

    <bean id="tradeService" class="com.lthaoshao.dubbo.service.TradeServiceImpl"/>
</beans>
```

## 多协议支持
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://dubbo.apache.org/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
       http://dubbo.apache.org/schema/dubbo
       http://dubbo.apache.org/schema/dubbo/dubbo.xsd">

    <!--应用名称, 用于计算依赖关系-->
    <dubbo:application name="dubbo-example-namespace-provider"/>
    <!--注册中心"-->
    <dubbo:registry id="reg1"  address="zookeeper://127.0.0.1:2181" file="tmp/dubbo/dubbo-provider/"/>

    <!-- 用 dubbo 协议在 20880 端口暴露服务 -->
    <dubbo:protocol name="dubbo" port="20880"/>
    <!-- 用 webservice 协议在 8088 端口暴露服务, web服务器采用jetty-->
    <dubbo:protocol name="webservice" port="8088" server="jetty"/>
    <!--用 rest 协议 在8089端口暴露服务, web服务器采用jetty -->
    <dubbo:protocol name="rest" port="8089" server="jetty"/>

    <!--暴露的服务, 可选用单协议, 也可同时支持多个协议-->
    <dubbo:service interface="com.lthaoshao.dubbo.api.TradeServiceFacade" ref="tradeService" protocol="dubbo,webservice,rest"/>
    
    <bean id="tradeService" class="com.lthaoshao.dubbo.service.TradeServiceImpl"/>
</beans>
```