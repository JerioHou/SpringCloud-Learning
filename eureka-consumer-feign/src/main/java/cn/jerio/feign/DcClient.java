package cn.jerio.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jerio on 2018/09/29
 */
@FeignClient(name = "eureka-client" ,fallback = DcClientFallback.class)
public interface DcClient {

    @GetMapping("/dc")
    String consumer();

}
