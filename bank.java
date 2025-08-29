//only two things are left to fetch no of transactions and to keep work looted and to make the data insert in table of credit card and loan
//to store value of aadhar no and phone no using map data structure 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

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
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";

        JFrame frame = new JFrame("Previous Transactions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Ammount");
        tableModel.addColumn("Medium");
        String koi;
        koi = "SELECT Date,ammount,medium FROM c" + co_id;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(koi)) {

            while (resultSet.next()) {
                String Date = resultSet.getString("Date");
                int Ammount = resultSet.getInt("ammount");
                String medium = resultSet.getString("medium");
                tableModel.addRow(new Object[] { Date, String.format("%,d", Ammount), medium });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error found");
            return;
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    // it will give the table of transaction of his

    public static Boolean eligible_CREC(int co_id) {
        Random rand=new Random();
        int n=rand.nextInt(100000000,999999999);
        if(eligble_(co_id)){
             LocalDate cuu = LocalDate.now();
        String da = cuu.toString();
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        JOptionPane.showMessageDialog(null, "New user founded Sucessfully");
       
        String gmail = "";

        long mob_no = 0;
        String name = "";

        JOptionPane.showMessageDialog(null, "Kindly give all the information correctly");
        name = JOptionPane.showInputDialog("Enter your Full name");
        mob_no = Long.parseLong(JOptionPane.showInputDialog("Enter your registered phone no"));
        adh_no = Long.parseLong(JOptionPane.showInputDialog("Enter your Aadhar no "));
        gmail = JOptionPane.showInputDialog("Enter your registered gmail id");
       

        // code to send all the data to to database and create one table with the mob_no
        // of constumer
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO crecar(dateof,name,co_id,creno,interest,Monthly_due) VALUES(  ?,?, ?, ?,?,?);")) {

            preparedStatement.setString(1, da);
            preparedStatement.setLong(2, name);
            preparedStatement.setString(3, co_id);

            preparedStatement.setLong(4, n);
            preparedStatement.setString(5, interest);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User details added Sucessfully");
                create_tab(get_cons_id(mob_no));

            }

        } catch (SQLException e) {
            e.printStackTrace(); // print in console

            JOptionPane.showMessageDialog(null, "Error found");

        }

        }
        
        return false;
    }
    public static Boolean eligible_cc(int co_id){
         if(eligble_(co_id)){
             LocalDate cuu = LocalDate.now();
        String da = cuu.toString();
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        JOptionPane.showMessageDialog(null, "New user founded Sucessfully");
        long adh_no = 0;
        String gmail = "";

        long mob_no = 0;
        String name = "";

        JOptionPane.showMessageDialog(null, "Kindly give all the information correctly");
        name = JOptionPane.showInputDialog("Enter your Full name");
        mob_no = Long.parseLong(JOptionPane.showInputDialog("Enter your registered phone no"));
        adh_no = Long.parseLong(JOptionPane.showInputDialog("Enter your Aadhar no "));
        gmail = JOptionPane.showInputDialog("Enter your registered gmail id");

        // code to send all the data to to database and create one table with the mob_no
        // of constumer
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO all_cons(name,aadhar_no,gmail,mob_no,enroll_date) VALUES(  ?, ?, ?,?,?);")) {

            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, adh_no);
            preparedStatement.setString(3, gmail);

            preparedStatement.setLong(4, mob_no);
            preparedStatement.setString(5, da);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User details added Sucessfully");
                create_tab(get_cons_id(mob_no));

            }

        } catch (SQLException e) {
            e.printStackTrace(); // print in console

            JOptionPane.showMessageDialog(null, "Error found");

        }
         }
        return false;
    }

    public static Boolean eligble_(int co_id) {
        int count=0;
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM c" + co_id)) {

           
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                count=rs.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("error to fetchoo");
        }
        
        int amm = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT balance FROM all_cons WHERE cons_id = ?")) {

            preparedStatement.setInt(1, co_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                amm = rs.getInt("balance");
            }

        } catch (SQLException e) {
            System.out.println("error to fetch");
        }

        if(amm>5000 && count>2){
            return true;
                  }
        else{

        return false;
    }}

    public static Boolean chk_cons_Exists(int co_id) {
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "select 1 from all_cons where cons_id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, co_id);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void deposit(int co_id) {
        // date
        LocalDate curr = LocalDate.now();
        String da = curr.toString();
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        int ammou = Integer.parseInt(JOptionPane.showInputDialog("Enter Ammount to Deposit"));
        String medi = JOptionPane.showInputDialog("Enter Medium");
        // will be inserted in the user's table
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into c" + co_id + "(Date,ammount,medium) values (?,?,?)")) {
            preparedStatement.setString(1, da);
            preparedStatement.setInt(2, ammou);
            preparedStatement.setString(3, medi);
            int rowsAffected = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deposited Succesfully" + rowsAffected);

        }

        catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Error Found");
        }
        // the ammount will be updated inthe bank_contumer table and the one more row
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = connection
                        .prepareStatement("update  all_cons set balance=balance +? where cons_id=?")) {
            pstmt.setInt(1, ammou);
            pstmt.setInt(2, co_id);
            int rowsAffected = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "rows affected" + rowsAffected);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Found");

        }

    }

    public static void withdraw(int co_id) {
        LocalDate date = LocalDate.now();
        String da = date.toString();
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        int amm = 0;
        String medium;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT balance FROM all_cons WHERE cons_id = ?")) {

            preparedStatement.setInt(1, co_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                amm = rs.getInt("balance");
            }

        } catch (SQLException e) {
            System.out.println("error to fetch");
        }
        int ammou;
        ammou = Integer.parseInt(JOptionPane.showInputDialog("Enter Ammount"));
        if (amm > 2500) {

            if (amm > ammou) {
                ammou = -ammou;
                medium = JOptionPane.showInputDialog("Enter medium");

                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "insert into c" + co_id + "(Date,ammount,medium) values (?,?,?)")) {
                    preparedStatement.setString(1, da);
                    preparedStatement.setInt(2, ammou);
                    preparedStatement.setString(3, medium);
                    int rowsAffected = preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Withdrawl Succesfully" + rowsAffected);

                }

                catch (Exception e) {
                    e.getStackTrace();
                    JOptionPane.showMessageDialog(null, "Error Found");
                }
                // the ammount will be updated inthe bank_contumer table and the one more row
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                        PreparedStatement pstmt = connection
                                .prepareStatement("update  all_cons set balance=balance +? where cons_id=?")) {
                    pstmt.setInt(1, ammou);
                    pstmt.setInt(2, co_id);
                    int rowsAffected = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "rows affected" + rowsAffected);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error Found");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Current Balance avliable is:" + amm);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Balance lesser than Minimum Balance");
        }

        //
        // to check if the ammount is greater than minimum balance then it wil withdraw
        // the ammount the user will say
        // the ammount will be withdrawl from the bank_constumer table and the constumer
        // table

    }

    public static void bank_looted() {
        LocalDate date = LocalDate.now();
        String da = date.toString();
        int co_id = 13;
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        int amm = 0;
        String medium;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT balance FROM all_cons WHERE cons_id = ?")) {

            preparedStatement.setInt(1, co_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                amm = rs.getInt("balance");
            }

        } catch (SQLException e) {
            System.out.println("error to fetch");
        }
        int ammou;
        ammou = -amm;
        medium = "Bank Looted";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into c" + co_id + "(Date,ammount,medium) values (?,?,?)")) {
            preparedStatement.setString(1, da);
            preparedStatement.setInt(2, ammou);
            preparedStatement.setString(3, medium);
            int rowsAffected = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bank Looted Sucessfully" + rowsAffected);

        }

        catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Error Found");
        }
        // the ammount will be updated inthe bank_contumer table and the one more row
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = connection
                        .prepareStatement("update  all_cons set balance=balance +?")) {
            pstmt.setInt(1, ammou);
            pstmt.setInt(2, co_id);
            int rowsAffected = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "rows affected" + rowsAffected);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Found");

        }
        // update table bank_cons set all the balanc as 0
        // retrives the balance of consumer
        // and in the constumer table add one more row wherre medium=looted and
        // ammo=-balancce
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
        LocalDate cuu = LocalDate.now();
        String da = cuu.toString();
        // date
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        JOptionPane.showMessageDialog(null, "New user founded Sucessfully");
        long adh_no = 0;
        String gmail = "";

        long mob_no = 0;
        String name = "";

        JOptionPane.showMessageDialog(null, "Kindly give all the information correctly");
        name = JOptionPane.showInputDialog("Enter your Full name");
        mob_no = Long.parseLong(JOptionPane.showInputDialog("Enter your registered phone no"));
        adh_no = Long.parseLong(JOptionPane.showInputDialog("Enter your Aadhar no "));
        gmail = JOptionPane.showInputDialog("Enter your registered gmail id");

        // code to send all the data to to database and create one table with the mob_no
        // of constumer
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO all_cons(name,aadhar_no,gmail,mob_no,enroll_date) VALUES(  ?, ?, ?,?,?);")) {

            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, adh_no);
            preparedStatement.setString(3, gmail);

            preparedStatement.setLong(4, mob_no);
            preparedStatement.setString(5, da);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User details added Sucessfully");
                create_tab(get_cons_id(mob_no));

            }

        } catch (SQLException e) {
            e.printStackTrace(); // print in console

            JOptionPane.showMessageDialog(null, "Error found");

        }

    }

    // to get table of all constumers;
    public static void getall() {
       
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";

        JFrame frame = new JFrame(" Active Constumers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cons_id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Balance");
        String koi;
        koi = "SELECT cons_id,name,balance FROM all_cons where status='running'";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(koi)) {

            while (resultSet.next()) {
                String Date = resultSet.getString("cons_id");
                int Ammount = resultSet.getInt("balance");
                String name = resultSet.getString("name");
                tableModel.addRow(new Object[] { Date, String.format("%,d", Ammount), name });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error found");
            return;
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    public static void showcc(){
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";

        JFrame frame = new JFrame(" Active Credit Card Users");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cons_id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Balance");
        String koi;
        koi = "SELECT creno,name,ammount FROM crecar";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(koi)) {

            while (resultSet.next()) {
                String  name = resultSet.getString("cons_id");
                Long ccno = resultSet.getLong("balance");
                int ammo=0;
                ammo = resultSet.getInt("name");
                tableModel.addRow(new Object[] { name, String.format("%,f", ccno), String.format("%,d",ammo) });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error found");
            return;
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    public static void showlo(){
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";

        JFrame frame = new JFrame(" Active LOAN takers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cons_id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Balance");
        String koi;
        koi = "SELECT cons_id,name,balance FROM all_cons where status='running'";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(koi)) {

            while (resultSet.next()) {
                String Date = resultSet.getString("cons_id");
                int Ammount = resultSet.getInt("balance");
                String name = resultSet.getString("name");
                tableModel.addRow(new Object[] { Date, String.format("%,d", Ammount), name });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error found");
            return;
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
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
        cid_ = get_cons_id(mob_no);

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
            option = JOptionPane.showConfirmDialog(null, "Do you want to Deposit money in Bank", "Deposit",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                deposit(cid_);

            }
            option = JOptionPane.showConfirmDialog(null, "Do you want to withdraw money from bank", "Withdraw",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                withdraw(cid_);
            }
            option = JOptionPane.showConfirmDialog(null, "Do you want to Get List of previous Transactions",
                    "Previous Transactions", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                get_trasn(cid_);
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

        else if (name.equalsIgnoreCase("devlopharsh")) {
            JOptionPane.showMessageDialog(null, "Developer interface started");
            int pass;
            String sec;
            pass = Integer.parseInt(JOptionPane.showInputDialog("Enter Password"));
            if (pass == 5202) {
                sec = JOptionPane.showInputDialog("Who is your favourate shef");
                if (sec.equalsIgnoreCase("obvme")) {
                    option = JOptionPane.showConfirmDialog(null, "Do you want to Get the Current balance of Bank",
                            "Balance", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        // like he can see the currentl balance of bank}
                    }
                    option = JOptionPane.showConfirmDialog(null,
                            "Do you want to get the data of all the Active User's in tabular form", "Get Data",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        getall();

                    }
                    option=JOptionPane.showConfirmDialog(null,"Do you want to get data off all Credit card user's","CREDIT CARD USERS",JOptionPane.YES_NO_OPTION);
                      if (option == JOptionPane.YES_OPTION) {
                        //function to show all that dat in table

                    }
                    option=JOptionPane.showConfirmDialog(null,"Do you want to get data off all Loan user's","LOAN USERS",JOptionPane.YES_NO_OPTION);
                      if (option == JOptionPane.YES_OPTION) {
                        //function to show all that dat in table

                    }






                } else {
                    option = JOptionPane.showConfirmDialog(null, "Do you really want to loot the bank",
                            "Error code:402", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        bank_looted();

                    } else {
                        JOptionPane.showMessageDialog(null, "Thanks for Testing");
                    }
                }

            }

        }

        else {
            new_user();

        }

    }

}
