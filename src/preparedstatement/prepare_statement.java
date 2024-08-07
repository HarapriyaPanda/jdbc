package preparedstatement;

import java.sql.*;

public class prepare_statement {
    public static Connection getconnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/employee", "root", "root");
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
    public static void getemployeeById(String email, int password){
        Connection con = getconnection();
        try{
            String query = "select slno, name, email, password, address from empp where email = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("-----------------------------");
                System.out.println("slno: "+rs.getInt(1));
                System.out.println("name: "+rs.getString(2));
                System.out.println("email: "+rs.getString(3));
                System.out.println("password: "+rs.getInt(4));
                System.out.println("address: "+rs.getString(5));
                System.out.println("--------------------------------------");
                System.out.println();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
    public static int updateemployee(String name, String email, int password, String address,int slno){
            int result =0;
        Connection con = getconnection();
        try{
            String Query="update empp set name=?,email=?,password=?, address=? where slno=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setInt(3,password);
            ps.setString(4,address);
            ps.setInt(5,slno);
            result = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static int deleteemployee(int slno){
        Connection con = getconnection();
        int result =0;
        try{
            String Query="delete from empp where slno = ?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1,slno);
            result = ps.executeUpdate();
            if (result>0){
                System.out.println("Deleted");
            }
            else{
                System.out.println("Not Deleted");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
//   getemployeeById("harapriya@gmail.com", 1234);
       // updateemployee("prasar","prasar@gmail.com",1234,"talcher",2);
        deleteemployee(3);
    }
}
