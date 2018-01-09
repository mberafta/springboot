package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UserEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String Username;

    private String Role;

    private Date Created;

    @Transient // => Propriété non persistente
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public UserEntity(){
        setCreated(new Date());
    }

    public UserEntity(String username, String role){
        this.Username = username;
        this.Role = role;
        setCreated(new Date());
    }

    public Long getId(){
        return Id;
    }

    public String getUsername(){
        return Username;
    }

    public Date getCreated(){
        return Created;
    }

    public String getRole(){
        return Role;
    }

    public void setUsername(String username){
        this.Username = username;
    }

    public void setCreated(Date date){
        this.Created = date;
    }

    public void setRole(String role){
        this.Role = role;
    }

    public String getShortCreated(){
        return format.format(this.Created);
    }

    public String toString(){
        StringBuilder str = new StringBuilder("User entity : \n");
        str.append(" - name : ");
        str.append(this.Username);
        return this.toString();
    }
}
