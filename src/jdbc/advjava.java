package jdbc;
import java.sql.*;
import java.util.Scanner;

public class advjava {
    public static Connection getconnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/school", "root", "root");
            if (con != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }
        } catch (Exception e) {
            System.out.println("Driver not found in catch method");
        }
        return con;
    }
    public static  void students(String slno, String name, String regno){
        int result =0;
        try{
            Connection con = getconnection();
            String query="insert into SBD(slno,name,regno) values('"+slno+"','"+name+"','"+regno+"')";
            Statement st = con.createStatement();
            result = st.executeUpdate(query);
            st.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(result>0){
            System.out.println("Student Added");
        }
        else{
            System.out.println("Student Not Added");
        }

    }
    public static void main(String[] args) {
        advjava.getconnection();
        //advjava.students();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student no");
        String slno = sc.next();
        System.out.println("Enter student name");
        String name = sc.next();
        System.out.println("Enter student regno");
        String regno = sc.next();
        students(slno,name,regno);

    }
}
