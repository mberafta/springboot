package hello;

import java.util.UUID;
import org.springframework.*;
import javax.persistence.*;

// Class for api responses
public class JsonResponse{
    public UUID Id;
    public String Message;

    public JsonResponse(){

    }

    public JsonResponse(String message){
        this.Id = UUID.randomUUID();
        this.Message = message;
    }
}
