package com.example.smhiprojectbluegrass;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApiReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration().host("https://opendata-download-metobs.smhi.se/api");

        from("timer:rest-api-consumer?period=10000")
                .log("${body}")
                .to("rest:get:/version/1.0/parameter/1/station/159880/period/latest-hour/data.json")
                .log("${body}");
    }
}
