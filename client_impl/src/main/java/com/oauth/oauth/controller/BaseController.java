package com.oauth.oauth.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@AllArgsConstructor
public class BaseController {

    @GetMapping("/")
    public String index(){
        log.info("index 호출");
        return "/index";
    }

    @GetMapping("/user")
    public String user(){
        return "/user";
    }

    private static final String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
    private final ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/login/{oauth2}")
    public String loginGoogle(@PathVariable String oauth2, HttpServletResponse response){
        System.out.println("BaseController.loginGoogle");
        return "redirect:/oauth2/authorization/"+oauth2;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) throws Exception {

        log.info("getLoginPage 호출");
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        for (ClientRegistration registration : clientRegistrations) {
            oauth2AuthenticationUrls.put(registration.getClientName(),
                    authorizationRequestBaseUri + "/" + registration.getRegistrationId());
            System.out.println("key = " + registration.getClientName());
            System.out.println("val = " + authorizationRequestBaseUri + "/" + registration.getRegistrationId());
        }
        model.addAttribute("urls", oauth2AuthenticationUrls);

        return "/login";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "/accessDenied";
    }
}
