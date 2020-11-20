package tz.co.softnet.mailgetway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class MailGetWayConfig {
    @Bean
    public Docket mailGetWayAPIDoc(){return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInformation())
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages());
    }
    private ApiInfo getApiInformation() {
        return new ApiInfo("EMAIL GETWAY API DOCUMENTATION",
                "Email get way is service built for receiving  e-statement and sending to zimbra",
                "1.0",
                "API Terms of Service URL",
                new Contact("SoftNet Technologies ltd", "www.softnet.co.tz", "bthomas@softnet.co.tz"),
                "API Licensed Under softnet",
                "www.softnet.co.tz",
                Collections.emptyList()
        );
    }
    private List<ResponseMessage> getCustomizedResponseMessages(){
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(500).message("Server has crashed!!").responseModel(new ModelRef("Error")).build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("You shall not pass!!").build());
        return responseMessages;
    }
}
