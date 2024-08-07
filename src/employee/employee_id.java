package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class employee_id {
    public static Connection getconnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/harapriya", "root", "root");
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
    public static int allemployee(connection c){
        int status = 0;
        Connection con = getconnection();
        try{
            String query = "insert into priya(name,email,address,pincode) values(?,?,?,?)";
            String query2 = "select emp_id from priya where emp_id=last_insert_id()";
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,c.getName());
            ps.setString(2,c.getMail());
            ps.setString(3,c.getAddress());
            ps.setInt(4,c.getPincode());
            ps.executeUpdate();
            ps=con.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                status = rs.getInt("emp_id");
            }
            con.commit();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
