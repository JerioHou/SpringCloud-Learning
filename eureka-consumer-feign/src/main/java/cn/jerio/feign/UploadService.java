package cn.jerio.feign;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jerio on 2018/09/29
 */
@FeignClient(value = "eureka-client", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {


    /**
     * 文件上传的时候，get和post的设置不生效，都可以上传成功
     * @param file
     * @return
     */
//    @GetMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                     method = RequestMethod.GET)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig{

        @Bean
        public Encoder feignFormEncoder(){
            return new SpringFormEncoder();
        }
    }
}
