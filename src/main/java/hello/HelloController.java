package hello;

import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public JsonResponse index() {
        String message = "Hello world!";
        JsonResponse response = new JsonResponse();
        response.Id = UUID.randomUUID();
        response.Message = message;
        return response;
    }

}