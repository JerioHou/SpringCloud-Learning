package cn.jerio.feign;

import org.springframework.stereotype.Component;

/**
 * Created by Jerio on 2018/09/29
 */
@Component
public class DcClientFallback implements DcClient {
    @Override
    public String consumer() {
        return "请求失败";
    }
}
