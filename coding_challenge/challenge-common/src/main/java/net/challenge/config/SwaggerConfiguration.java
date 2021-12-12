package net.challenge.config;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
@Data
@EnableOpenApi
public class SwaggerConfiguration {

    /**
     * This is for Client users
     *
     * @return
     */
    @Bean
    public Docket webApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("User Side Interface Document")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.challenge"))
                //正则匹配请求路径，并分配至当前分组
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .globalRequestParameters(globalRequestParameters())
                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
                .globalResponses(HttpMethod.POST, getGlobalResponseMessage());

    }

    /**
     * This is for Management users
     *
     * @return
     */
    @Bean
    public Docket adminApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("Management Side Interface Document")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.challenge"))
                //正则匹配请求路径，并分配至当前分组
                .paths(PathSelectors.ant("/admin/**"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("net.challenge").description(" interface document")
                .contact(new Contact("Peiran", "peiranliu.com", "liupeiran9324@outlook.com"))
                .version("v1.0")
                .build();
    }


    /**
     * global paramater configuration
     *
     * @return
     */
    private List<RequestParameter> globalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder().name("token").description("logging token").
                in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());

        return parameters;
    }

    /**
     * generate union response info
     */

    private List<Response> getGlobalResponseMessage() {
        List<Response> list = new ArrayList<>();
        list.add(new ResponseBuilder().code("4xx").description("wrong request, check on code and msg").build());
        return list;
    }


}
