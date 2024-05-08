package se.distansakademin.spring_security_cognito_240424.contollers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.distansakademin.spring_security_cognito_240424.configurations.Cognito;
import se.distansakademin.spring_security_cognito_240424.configurations.CognitoLogoutSuccessHandler;
import se.distansakademin.spring_security_cognito_240424.models.SignUpRequest;

@Controller
public class SignUpController {

    @Value("${aws.cognito.poolId}")
    private String poolId;
    @Value("${aws.cognito.registration.clientId}")
    private String clientId;

    @GetMapping("/sign-up")
    public String getSignUp(Model model){
        model.addAttribute("signUp", new SignUpRequest());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String postSignUp(@ModelAttribute SignUpRequest request) {

        var username = request.getUserName();

        var success = Cognito.signUp(clientId, username, request.getPassword(), request.getEmail());

        if (success) {
            Cognito.confirmUser(poolId, username);
        }
        return "redirect:/";

    }
}
