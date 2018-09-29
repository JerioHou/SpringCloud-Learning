package cn.jerio.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jerio on 2018/09/29
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @RequestMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                    method = RequestMethod.POST)
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {
        File newFile = new File("d:\\test.txt");
        file.transferTo(newFile);
        FileWriter fileWriter = new FileWriter(newFile);
        fileWriter.flush();
        fileWriter.close();
        return "上传成功:"+file.getOriginalFilename();
    }
}
