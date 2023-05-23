import java.util.*;

public class Account_control {
    private Integer userKey;
    private List<Map<Integer, Detail_Info>> userData = new ArrayList<Map<Integer, Detail_Info>>();
    private String tranfer_name;
    private float money_tranfer_user;


    public void setUserKey(Integer userKey){
        this.userKey = userKey;
    }

    public void setUserData(List<Map<Integer, Detail_Info>> userData){
        this.userData = userData;
    }

    public void Deposit(float money_income){
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                x.get(this.userKey).wallet_money += money_income;
            }
            count++;
        }
    }

    public  boolean remove_account(){
        boolean status = false;
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                // x.remove(this.userKey);
                userData.remove(this.userKey);
                status = true;
            }
            count++;
        }
        return status;
    }

    public boolean tranfer_money(float money_tranfer,String username){
        boolean status = false;
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(username.equals(x.get(count).username)){
                x.get(count).wallet_money += money_tranfer;
                this.money_tranfer_user = money_tranfer;
                this.tranfer_name = x.get(count).firstName;
                status = true;
            }
            count++;
        }
        return status;
    }

    public  void printBill(){
        float money_remain = 0;
        String firstname = "";
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                firstname = x.get(this.userKey).firstName;
                money_remain = x.get(this.userKey).wallet_money;
            }
            count++;
        }
        System.out.println("--------------------------------");
        System.out.println(firstname + " ------> " + tranfer_name);
        System.out.println("Amount : " + this.money_tranfer_user + " Bath.");
        System.out.println("Remain : " + money_remain + " Bath.");
        System.out.println("--------------------------------");
    }

    public boolean check_dupicated_user(String username){
        boolean status = true;
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                if( x.get(this.userKey).username.equals(username)){
                    status = false;
                }
            }
            count++;
        }
        return status;
    }


    public void show_all(){
        int count = 0;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                System.out.println("Firstname : " + x.get(this.userKey).firstName);
                System.out.println("Lastname : " + x.get(this.userKey).lastName);
                System.out.println("Account Number : " + x.get(this.userKey).numberAccount);
                System.out.println("Telephone Number : " + x.get(this.userKey).tel);
                System.out.println("Email : " + x.get(this.userKey).email);
                System.out.println("Money : " + x.get(this.userKey).wallet_money + " Bath.");
            }
            count++;
        }
    }

    public boolean check_balance(float money_withdraw){
        int count = 0;
        boolean status = false;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                if( x.get(this.userKey).wallet_money > money_withdraw){
                    status = true;
                }
            }
            count++;
        }
        return status;
    }

    public void Withdraw(float money_withdraw){
        int count = 0;
        boolean status = false;
        for(Map<Integer, Detail_Info> x : userData){
            if(this.userKey == count){
                x.get(this.userKey).wallet_money -= money_withdraw;
            }
            count++;
        }
    }
    
}
