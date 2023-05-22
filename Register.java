import java.text.Format;
import java.util.*;

public class Register {
    private List<Map<Integer, Detail_Info>> userData;
    private Map<Integer, Detail_Info> userDetail;
    private Integer i,runKeyNum = 0;

    public Register(){
        init();
    }

    public void init(){
        userData = new ArrayList<Map<Integer, Detail_Info>>();
        userDetail = new HashMap<Integer, Detail_Info>();
    }


    public void setUserDetail(
        String firstName,
        String lastName,
        String tel,
        String email,
        String username,
        String password,
        Float wallet_money
    ){
        Random rnd = new Random();
        int number = rnd.nextInt(9999999);
        String numberAccount = String.format("%07d",number);
        numberAccount = "AB-" + numberAccount;
        this.userDetail.put(runKeyNum,new Detail_Info(
            firstName, 
            lastName, 
            numberAccount, 
            tel, 
            email, 
            username, 
            password,
            wallet_money
            ) 
        );
        this.userData.add(userDetail);
        this.runKeyNum++;
    }
    
    public Map<Integer, Detail_Info> getUserDetail(){
        return userDetail;
    }

    public boolean check_username(String username){
        boolean status_remain = true;
        String msg = "";
        this.i = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(username.equals(x.get(this.i).username)){
                msg = "Find another username";
                status_remain = false;
                break;
            }else{
                msg = "Can use this username";
                status_remain = true;
            }
            
            this.i++;
        }
        System.out.println(msg);
        return status_remain;
    }

    public List<Map<Integer, Detail_Info>> getUserData(){
        return this.userData;
    }

}
