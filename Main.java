import java.util.*;
import java.util.concurrent.TimeUnit;

class Main {
    static boolean status = true;
    static Register re = new Register();
    static Login lo = new Login();
    static Account_control ac = new Account_control();
    static Map<Integer, Detail_Info> userDetail;
    static int choice;
    static int times = 0;
    static Integer userKey;

    public static void main(String[] args) throws InterruptedException {

        while (status) {
            try {
                System.out.print("\033[H\033[2J");
                Scanner sc = new Scanner(System.in);
                System.out.println("---Menu---");
                Display_login_regis();
                choice = sc.nextInt();
                if (choice <= 2) {
                    main_menu(choice);
                } else {
                    System.out.println("You can choose between 1 and 2");
                    System.out.println("Wait...");
                    TimeUnit.SECONDS.sleep(3);
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                TimeUnit.SECONDS.sleep(3);
                status = true;
            }
        }

    }

    public static void main_menu(int choice) throws InterruptedException {
        if (choice == 1) {
            if (times == 0) {
                System.out.println("There are no registered users yet.");
                System.out.println("Wait...");
                TimeUnit.SECONDS.sleep(3);
            } else {
                login_menu();
            }
        } else {
            regis_menu();
        }
    }

    public static void login_menu() throws InterruptedException {
        System.out.print("\033[H\033[2J");
        boolean flg = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("---Login---");
        while (flg) {
            System.out.print("Enter Username : ");
            String username = sc.nextLine();
            System.out.print("Enter Password : ");
            String password = sc.nextLine();
            lo.setUserData(re.getUserData());
            boolean status_login = lo.check_login(username, password);
            if (status_login) {
                userKey = lo.getUserKey();
                System.out.println("Login Completed");
                TimeUnit.SECONDS.sleep(3);
                login_pass_menu();
                flg = false;
            } else {
                System.out.println("Login failed");
                TimeUnit.SECONDS.sleep(3);
                flg = false;
            }
        }
    }

    public static boolean deposit() throws InterruptedException {
        boolean status = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("---Deposit---");
        System.out.print("How many baht do you want to deposit? : ");
        float money_income = sc.nextFloat();
        System.out.println("Are you sure ?  : ");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Enter : ");
        int awn = sc.nextInt();
        if (awn == 1) {

            ac.Deposit(money_income);
            status = true;
            TimeUnit.SECONDS.sleep(3);
        } else {
            status = false;
        }
        return status;
    }

    public static boolean Withdraw() throws InterruptedException {
        boolean status = false, check = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("---Withdraw---");
        System.out.print("How many baht do you want to withdraw? : ");
        float money_withdraw = sc.nextFloat();
        check = ac.check_balance(money_withdraw);
        TimeUnit.SECONDS.sleep(5);
        if (check) {
            System.out.println("Are you sure ?  : ");
            System.out.println("1.Yes");
            System.out.println("2.No");
            System.out.print("Enter : ");
            int awn = sc.nextInt();
            if (awn == 1) {
                ac.Withdraw(money_withdraw);
                status = true;
            }
            TimeUnit.SECONDS.sleep(3);
        }
        return status;
    }

    public static void login_pass_menu() {
        ac.setUserKey(userKey);
        ac.setUserData(re.getUserData());
        System.out.print("\033[H\033[2J");
        boolean flg = true;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("---Menu---");
        try {
            while (flg) {
                System.out.print("\033[H\033[2J");
                System.out.println("---Menu---");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Transfer");
                System.out.println("4.Deactivate an account");
                System.out.println("5.Accout infomation");
                System.out.println("6.Log out");
                System.out.print("Enter : ");
                choice = sc.nextInt();
                if (choice == 1) {
                    boolean check = deposit();
                    if (check) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Deposit cmpleted wait...");
                        TimeUnit.SECONDS.sleep(3);
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Deposit incmpleted wait...");
                        TimeUnit.SECONDS.sleep(3);
                    }
                } else if (choice == 2) {
                    boolean check = Withdraw();
                    if (check) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Withdraw cmpleted wait...");
                        TimeUnit.SECONDS.sleep(3);
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Withdraw incmpleted wait...");
                        TimeUnit.SECONDS.sleep(3);
                    }
                } else if (choice == 3) {
                    tranfer();
                    TimeUnit.SECONDS.sleep(3);

                } else if (choice == 4) {
                    remove();
                    flg = false;
                    userKey = null;
                    System.out.println("Wait...");
                    TimeUnit.SECONDS.sleep(3);
                } else if (choice == 5) {
                    account_info();
                    TimeUnit.SECONDS.sleep(10);
                } else {
                    System.out.println("Are you sure ?  : ");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    System.out.print("Enter : ");
                    int awn = sc.nextInt();
                    if (awn == 1) {
                        flg = false;
                        userKey = null;
                        System.out.println("Logging out...");
                        TimeUnit.SECONDS.sleep(3);
                    } else {
                        System.out.println("Cancel...");
                        TimeUnit.SECONDS.sleep(3);
                        flg = true;
                    }
                }
            }
        } catch (Exception e) {
            flg = true;
        }

    }

    public static void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure to deleted this account ?  : ");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Enter : ");
        int awn = sc.nextInt();
        if (awn == 1) {
            boolean status = ac.remove_account();
            if (status) {
                System.out.println("Account deletion completed");
            } else {
                System.out.println("Account deletion error");
            }
        } else {
            System.out.println("Cancelled");
        }
    }

    public static void tranfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Tranfer Money---");
        System.out.print("Account : ");
        String username = sc.nextLine();
        if (ac.check_dupicated_user(username)) {
            System.out.print("How many baht would you like to transfer? : ");
            float money_tranfer = sc.nextFloat();
            System.out.println("Are you sure ?  : ");
            System.out.println("1.Yes");
            System.out.println("2.No");
            System.out.print("Enter : ");
            int awn = sc.nextInt();
            if (awn == 1) {
                // boolean status = ac.tranfer_money(money_tranfer, username);
                if (ac.check_balance(money_tranfer)) {
                    if (ac.tranfer_money(money_tranfer, username)) {
                        ac.Withdraw(money_tranfer);
                        System.out.println("Transfer Completed");
                        ac.printBill();
                    } else {
                        System.out.println("The transfer could not be made because the account could not be found.");
                    }
                    // ac.Withdraw(money_tranfer);
                } else {
                    System.out.println("Transfer error. You don't have enough money.");

                }
            }
        } else {
            System.out.println("The deposit function is recommended.");
        }

    }

    public static void account_info() {
        System.out.println("---Account Information---");
        ac.show_all();
    }

    public static void regis_menu() throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.println("---Register---");
        boolean flg = true;
        Scanner sc = new Scanner(System.in);
        while (flg) {
            if (times == 0) {
                System.out.print("Enter Username : ");
                String username = sc.nextLine();
                System.out.print("Enter Password : ");
                String password = sc.nextLine();
                System.out.print("Enter firstName : ");
                String firstName = sc.nextLine();
                System.out.print("Enter lastName : ");
                String lastName = sc.nextLine();
                System.out.print("Enter email : ");
                String email = sc.nextLine();
                System.out.print("Enter telephone number : ");
                String telephone = sc.nextLine();

                // Float wallet_money = sc.nextFloat();
                re.setUserDetail(firstName, lastName, telephone, email, username, password, (float) 1000.00);
                System.out.println("***Success***");
                times++;
                TimeUnit.SECONDS.sleep(3);
                System.out.print("\033[H\033[2J");
            } else {
                System.out.print("Enter Username : ");
                String username = sc.nextLine();
                boolean check_user = re.check_username(username);
                if (!check_user) {
                    continue;
                } else {
                    System.out.print("Enter Password : ");
                    String password = sc.nextLine();
                    System.out.print("Enter firstName : ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter lastName : ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter email : ");
                    String email = sc.nextLine();
                    System.out.print("Enter telephone number : ");
                    String telephone = sc.nextLine();

                    re.setUserDetail(firstName, lastName, telephone, email, username, password, (float) 1000.00);
                    System.out.println("***Success***");
                    times++;
                    TimeUnit.SECONDS.sleep(3);
                    System.out.print("\033[H\033[2J");
                }
            }
            flg = false;
        }
    }

    public static void Display_login_regis() {
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.print("Enter : ");
    }

}