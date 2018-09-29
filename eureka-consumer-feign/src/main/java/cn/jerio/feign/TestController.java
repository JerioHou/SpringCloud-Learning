package cn.jerio.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jerio on 2018/09/29
 */
@RestController
public class TestController {

    @Autowired
    private  DcClient dcClient;

    @GetMapping("/testFeign")
    public String testFeign(){
        return dcClient.consumer();
    }
}
