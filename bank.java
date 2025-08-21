
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class bank {
    
    public static void main(String args[]) {
         final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bank_backend";
        final String DB_USER = "root";
        final String DB_PASSWORD = "5202";
        JOptionPane.showMessageDialog(null, "Jai Mahaveera");

        // credited money added and debited money withdraw

        String name;
        int mob_no;
        name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Welcome to Bank's Backend Project");
        mob_no = Integer.parseInt(JOptionPane.showInputDialog("Enter your registered phone no"));

        // then the program check the name and check if it is not there

        // if name not there
        // will take all his information like name father's name contact no(Unique)
        // annual income and to set his creditlimit and debitlimit
        // then he closes the program

        // then the user logins by giving his name
        // then the bank asks him whether he want to deposit or withdraw
        // if he says deposit then money will be deposited to the bank all employees
        // table
        // and in that constumer table money will be debitied
        // same for withdraw also

        if (name == "devlopharsh") {
            JOptionPane.showMessageDialog(null, "Developer interface started");
            int pass;
            String sec;
            pass = Integer.parseInt(JOptionPane.showInputDialog("Enter Password"));
            if (pass == 5202) {
                sec = JOptionPane.showInputDialog("Who is your favourate shef");
                if (sec == "obvme") {
                    // it the bank if looted then it will show that the bank is looted on date and
                    // time
                    // then it will show all the featured of devlopharsh can do
                    // like he can see the currentl balance of bank
                    // and he can check the data of active constumers of bank
                } else {
                    JOptionPane.showMessageDialog(null, "Bank Robbed Succesfully");
                    // then all active balance of all the constumers willbecome zero and in the
                    // payment mode it will show that the Looted
                    // and then bank's current balance will become zero

                }

            }

        }
        //else if (name in database){
        JOptionPane.showMessageDialog(null,"User found Sucessfully");
        //     String cho;
        //     int amm;

        //     cho=JOptionPane.showInputDialog("Do you want to withdraw or deposit money in bank");
        //     if(cho.equalsIgnoreCase("withdraw")){}
        //     else{
        //         amm=Integer.parseInt(JOptionPane.showInputDialog("Enter the ammount which you want to withdraw from your account"));
        //         //then update this ammount in constumer table with table name as phone no fetch from database in backend
        //         //update also in bank table if name equal

        //     }
        //     //Options will be shown that 
        // }
        else{
            
            JOptionPane.showMessageDialog(null,"New user founded Sucessfully");
            int adh_no;
            String gmail;
            int min_bal;
            JOptionPane.showMessageDialog(null,"Kindly give all the information correctly");
            name=JOptionPane.showInputDialog("Enter your Full name");
            mob_no = Integer.parseInt(JOptionPane.showInputDialog("Enter your registered phone no"));
            adh_no=Integer.parseInt(JOptionPane.showInputDialog("Enter your Aadhar no "));
            gmail=JOptionPane.showInputDialog("Enter your registered gmail id");
            min_bal=Integer.parseInt(JOptionPane.showInputDialog("Enter Minimum balance account"));
            //code to send all the data to to database and create one table with the mob_no of constumer
             try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "INSERT INTO all_cons(name,aadhar_no,gmail,balance,mob_no) VALUES(?, ?, ?, ?, ?)")) {

                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, adh_no);
                    preparedStatement.setString(3, gmail);
                    preparedStatement.setInt(4, min_bal);
                    preparedStatement.setInt(5, mob_no);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "User details added Sucessfully");
                    } else {
                        System.out.println("nothing entered");
                    }

                } catch (SQLException e) {
                    System.out.println("Error found");

                }
           

        }

    }   

}
