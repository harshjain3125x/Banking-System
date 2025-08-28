
//to store value of aadhar no and phone no using map data structure 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class bank {
    public static int get_cons_id(long ph_no) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";

        int id = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT cons_id FROM all_cons WHERE mob_no=?")) {
            preparedStatement.setLong(1, ph_no);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("cons_id");
                return id;
            } else {
                return 0;
            }
        }

        catch (SQLException e) {
            return 0;
        }
    }

    public static void get_trasn(int co_id) {
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // it will give the table of transaction of his
    }

    public static Boolean eligible_loan(int co_id) {
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // to check if no of totaltransactions in constumer account transactions is
        // greater than 10 in 6 months in table cons_transactions in his transactions
        // table

        // to check if balance of consumer id is greater than 500000

        return false;
    }

    public static Boolean eligble_CC(int co_id) {
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // to check if no of totaltransactions in constumer account transactions is
        // greater than 10 in 6 months in table cons_transactions in his transactions
        // table

        // to check if balance of consumer id is greater than 500000

        return false;
    }

    public static Boolean chk_cons_Exists(int co_id) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        try(Connection conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
            String query="select 1 from all_cons where cons_id=?";
            PreparedStatement pstmt=conn.prepareStatement(query);
             pstmt.setInt(1, co_id);
            ResultSet rs=pstmt.executeQuery();
            return rs.next();}
            catch(Exception e){
                e.printStackTrace();
                return false;
            }

    
    }

    public static void deposit(int co_id) {
        // date
        LocalDate curr=LocalDate.now();
        String da=curr.toString();
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        int ammou=Integer.parseInt(JOptionPane.showInputDialog("Enter Ammount to Deposit"));
        String medi=JOptionPane.showInputDialog("Enter Medium");
                        // will be inserted in the user's table
                    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                         PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into c"+co_id+ "(Date,ammount,medium) values (?,?,?)")) {
                    preparedStatement.setString(1,da);
                     preparedStatement.setInt(2,ammou);
                      preparedStatement.setString(3,medi);
                      int rowsAffected = preparedStatement.executeUpdate();
                      JOptionPane.showMessageDialog(null,"Deposited Succesfully"+rowsAffected);

                }
        

        catch(Exception e){
            e.getStackTrace();
            JOptionPane.showMessageDialog(null,"Error Found");
        }
        // the ammount will be updated inthe bank_contumer table and the one more row
        try(Connection connection =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement pstmt=connection.prepareStatement("update  all_cons set balance=balance +? where cons_id=?")){
            pstmt.setInt(1,ammou);
            pstmt.setInt(2,co_id);
            int rowsAffected=pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"rows affected"+rowsAffected);
        }
                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null,"Error Found");
                        
                    }

        

        
    }

    public static String withdraw(int co_id, int amm, String medium, int id) {
        // date
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // first check the contumer balance if it is lower than the minimum balance then
        // it will show that the balance lower than minimumbalance
        // if it is zero it will show it is empty
        // to check if the ammount is greater than minimum balance then it wil withdraw
        // the ammount the user will say
        // the ammount will be withdrawl from the bank_constumer table and the constumer
        // table

        return "Withdraw Sucessfuly";
    }

    public static Boolean bank_looted() {
        // date
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // update table bank_cons set all the balanc as 0
        // retrives the balance of consumer
        // and in the constumer table add one more row wherre medium=looted and
        // ammo=-balancce
        return true;
    }

    public static boolean check_looted() {
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // check if in database if the balance of bank is equals to zero
        return false;
    }

    public static void data_ac() {
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        // give all the data in tabular form

    }

    public static void create_tab(int cid) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        String sqlsta = "CREATE TABLE IF NOT EXISTS " + "C" + cid + " (" +
                "    trans_no INT PRIMARY KEY AUTO_INCREMENT," +
                "    Date DATE," +
                "    ammount INT NOT NULL," +
                "    medium VARCHAR(25) DEFAULT 'CASH'" +
                ")";

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlsta);
            JOptionPane.showMessageDialog(null, "Table Created");
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void new_user() {
        LocalDate cuu=LocalDate.now();
        String da=cuu.toString();
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        JOptionPane.showMessageDialog(null, "New user founded Sucessfully");
        long adh_no = 0;
        String gmail = "";
        int min_bal = 0;
        long mob_no = 0;
        String name = "";

        JOptionPane.showMessageDialog(null, "Kindly give all the information correctly");
        name = JOptionPane.showInputDialog("Enter your Full name");
        mob_no = Long.parseLong(JOptionPane.showInputDialog("Enter your registered phone no"));
        adh_no = Long.parseLong(JOptionPane.showInputDialog("Enter your Aadhar no "));
        gmail = JOptionPane.showInputDialog("Enter your registered gmail id");
        min_bal = Integer.parseInt(JOptionPane.showInputDialog("Enter Minimum balance account"));
        // code to send all the data to to database and create one table with the mob_no
        // of constumer
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO all_cons(name,aadhar_no,gmail,balance,mob_no,enroll_date) VALUES( ?, ?, ?, ?,?,?);")) {

            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, adh_no);
            preparedStatement.setString(3, gmail);
            preparedStatement.setInt(4, min_bal);
            preparedStatement.setLong(5, mob_no);
             preparedStatement.setString(6, da);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User details added Sucessfully");
                create_tab(get_cons_id(mob_no));
                deposit(get_cons_id(mob_no));

        
            }

        } catch (SQLException e) {
            e.printStackTrace(); // print in console

            JOptionPane.showMessageDialog(null, "Error found");

        }

    }

    public static void main(String args[]) {
        int cid_ = 0;
        final String DB_URL = "jdbc:mysql://127.0/0/1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        int option;
        JOptionPane.showMessageDialog(null, "Jai Mahaveera");

        check_looted();

        String name;
        long mob_no;
        name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Welcome to Bank's Backend Project");
        mob_no = Long.parseLong(JOptionPane.showInputDialog("Enter your registered phone no"));
        cid_=get_cons_id(mob_no);

        if (chk_cons_Exists(cid_)) {
            System.out.print(get_cons_id(mob_no));
            option = JOptionPane.showConfirmDialog(null, "Do you want to apply for Credit card",
                    "Apply for Credit Card", JOptionPane.YES_NO_OPTION);
            // check if he/she is eligible for credit card;
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Welcome to HDFC Bank Once Again!!");
            }
            option = JOptionPane.showConfirmDialog(null, "Do you want to Apply for Loan", "Apply for loan",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Welcome to HDFC Bank once Again!!");
                // check if he/she is eligible for loan
            }

            if (eligible_loan(cid_)) {
                JOptionPane.showMessageDialog(null, "Congratulations you are eligible for Pre Approved loan");
                option = JOptionPane.showConfirmDialog(null, "Do you want to Apply", "Congratulations",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // function of apply loan
                }

            }

        }

        else if (name == "devlopharsh") {
            JOptionPane.showMessageDialog(null, "Developer interface started");
            int pass;
            String sec;
            pass = Integer.parseInt(JOptionPane.showInputDialog("Enter Password"));
            if (pass == 5202) {
                sec = JOptionPane.showInputDialog("Who is your favourate shef");
                if (sec == "obvme") {
                    option = JOptionPane.showConfirmDialog(null, "Do you want to Get the Current balance of Bank",
                            "Balance", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        // like he can see the currentl balance of bank}
                    }
                    option = JOptionPane.showConfirmDialog(null,
                            "Do you want to get the data of all the User's in tabular form", "Get Data",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {

                    }
                } else {
                    String want;
                    want = JOptionPane.showInputDialog("Do you want to loot the bank Say Yes !!");
                    if (want.equalsIgnoreCase(want)) {
                        Boolean rsu = bank_looted();
                        if (rsu == true) {
                            JOptionPane.showMessageDialog(null, "Bank Robbed Succesfully");

                        }
                    }
                }

            }

        }

        else {
             new_user();
            

        }

    }

}
