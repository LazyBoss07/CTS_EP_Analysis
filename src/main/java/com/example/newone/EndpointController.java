package com.example.newone;//package com.example.newone;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class EndpointController {
//
//    private final RequestMappingHandlerMapping handlerMapping;
//    @PostConstruct
//    public void initialize() {
//        System.out.println("RequestMappingHandlerMapping: " + handlerMapping);
//    }
//    @Autowired
//    public EndpointController(RequestMappingHandlerMapping handlerMapping) {
//        this.handlerMapping = handlerMapping;
//    }
//
//    @GetMapping("/endpoints")
//    public List<String> getEndpoints() {
//        List<String> endpoints = new ArrayList<>();
//        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
//
//        for (RequestMappingInfo info : handlerMethods.keySet()) {
//            PatternsRequestCondition patternsCondition = info.getPatternsCondition();
//            if (patternsCondition != null) {
//                endpoints.addAll(patternsCondition.getPatterns());
//            }
//        }
//
//        return endpoints;
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/endpoints")
public class EndpointController {

    private final RequestMappingHandlerMapping handlerMapping;

    @Autowired
    public EndpointController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @GetMapping
    public ResponseEntity<List<String>> getEndpoints() {
        List<String> endpoints = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();

        for (RequestMappingInfo info : handlerMethods.keySet()) {
            PatternsRequestCondition patternsCondition = info.getPatternsCondition();
            if (patternsCondition != null) {
                endpoints.addAll(patternsCondition.getPatterns());
            }
        }

        return ResponseEntity.ok(endpoints);
    }
}
