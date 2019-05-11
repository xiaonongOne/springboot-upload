package com.example.springbootupload;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)
public class SpringbootUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUploadApplication.class, args);
    }

}
