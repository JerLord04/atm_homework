import java.util.*;

public class Account_control {
    private Integer userKey;
    private List<Map<Integer, Detail_Info>> userData = new ArrayList<Map<Integer, Detail_Info>>();

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
