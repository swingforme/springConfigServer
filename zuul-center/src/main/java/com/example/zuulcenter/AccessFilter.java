package com.example.zuulcenter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 */
public class AccessFilter extends ZuulFilter {


    /**
     *过滤器类型
     * @return
     * pre 请求路由前被调用
     * routing 路由请求时被调用
     * post 在routing和error 过滤器之后被调用
     * error 处理请求时发生错误调用
     */
    @Override
    public String filterType() {
        return "pre"; //请求被路由之前举行
    }

    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //判断过滤器是否需要被执行
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        info("发送"+request.getMethod()+" request to "+request.getRequestURL().toString());
        String accessToken = request.getParameter("token");
        if(accessToken == null){
            info("token为 null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("对返回的body进行内容编辑");
            return null;
        }
        info("token is OK");
        return null;
    }

    private void info(Object s){
        System.out.println("=====>"+s);
    }
}


