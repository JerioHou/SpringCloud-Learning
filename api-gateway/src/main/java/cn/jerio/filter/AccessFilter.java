package cn.jerio.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jerio on 2018/09/29
 */
public class AccessFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String accessToken = request.getParameter("accessToken");
        if (StringUtils.isEmpty(accessToken)){
            currentContext.getResponse().setContentType("application/json;charset=UTF-8");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("fail 失败");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
