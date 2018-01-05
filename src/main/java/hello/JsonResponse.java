package hello;

import java.util.UUID;
import java.util.ArrayList;

// Class for api responses
public class JsonResponse{
    public UUID Id;
    public String Message;
    public ArrayList<UserEntity> Users;

    public JsonResponse(){
        this.Users = new ArrayList<UserEntity>();
    }

    public JsonResponse(String message){
        this.Users = new ArrayList<UserEntity>();
        this.Id = UUID.randomUUID();
        this.Message = message;
    }

    public void AddUser(UserEntity user){
        this.Users.add(user);
    }
}
