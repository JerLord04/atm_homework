import java.util.*;

public class Login {
    private List<Map<Integer, Detail_Info>> userData = new ArrayList<Map<Integer, Detail_Info>>();
    private Integer userKey,i;


    public void setUserData(List<Map<Integer, Detail_Info>> userData){
        this.userData = userData;
    }

    public List<Map<Integer, Detail_Info>> getUserData(){
        return userData;
    }

    public boolean check_login(String username,String password){
        this.i = 0;
        boolean status_login = false;
        for(Map<Integer, Detail_Info> user : userData){
            if(username.equals(user.get(this.i).username) && password.equals(user.get(this.i).password)){
                userKey = this.i;
                status_login = true;
            }
            this.i++;
        }
        return status_login;
        
    }

    public Integer getUserKey(){
        return userKey;
    }
}
