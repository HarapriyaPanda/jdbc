package jdbc;
import java.sql.*;
import java.util.Scanner;


public class jdbc {
        public static Connection getconnection() {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "root");
                if (con != null) {
                    System.out.println("Connected");
                } else {
                    System.out.println("Not Connected");
                }
            } catch (Exception e) {
                System.out.println("not connected in catch block");
                e.printStackTrace();
            }
            return con;
        }
        public static void saveemployee(String empid, String empname, String empsalary){
            int result =0;
            try {
                Connection con = getconnection();
                String query = "insert into emp values('" + empid + "','" + empname + "','" + empsalary + "'";
                Statement st = con.createStatement();
                result = st.executeUpdate(query);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(result>0){
                System.out.println("employee inserted");
            }
            else{
                System.out.println("employee not inserted");
            }
        }
        public static void getAllemployee(){
            Connection con = getconnection();
            try{
                Statement st = con.createStatement();
                String query = "select slno,name,salary from emp;";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    System.out.println("-----------------------------");
                    System.out.println("slno: "+rs.getString(1));
                    System.out.println("name: "+rs.getString(2));
                    System.out.println("salary: "+rs.getString(3));
                    System.out.println("--------------------------------------");
                    System.out.println();

                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    public static void getemployeeById(int slno){
        Connection con = getconnection();
        try{
            Statement st = con.createStatement();
            String query = "select slno, name, salary from emp where slno="+slno;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("-----------------------------");
                System.out.println("slno: "+rs.getString(1));
                System.out.println("name: "+rs.getString(2));
                System.out.println("salary: "+rs.getString(3));
                System.out.println("--------------------------------------");
                System.out.println();

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public static int updatemployeeId(String name,int salary, int slno){
            int result=0;
            Connection con = getconnection();
            try{
                Statement st = con.createStatement();
                String query= "update amp set name='"+name+"', salary="+salary+" where slno="+slno;
                result = st.executeUpdate(query);
                if(result>0){
                    System.out.println("employee updated");
                }
                else{
                    System.out.println("employee not updated");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return result;

    }
    public static int deleteemployeeId(int slno){
            int result=0;
            Connection con = getconnection();
            try{
                Statement st = con.createStatement();
                String query = "delete from amp where slno="+slno;
                result = st.executeUpdate(query);
                if(result>0){
                    System.out.println("employee deleted");
                }
                else{
                    System.out.println("employee not deleted");
                }
            }

            catch(Exception e){
                e.printStackTrace();
            }
            return result;
    }


        public static void main(String[] args) {
            //jdbc.getconnection();
            //jdbc.saveemployee();
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter the employee id");
//            String empid = sc.next();
//            System.out.println("Enter the employee name");
//            String empname = sc.next();
//            System.out.println("Enter the employee salary");
//            String empsalary = sc.next();
//            jdbc.saveemployee(empid, empname, empsalary);
           // getAllemployee();
            //getemployeeById(102);
           // updatemployeeId("gennu",100,2);
            deleteemployeeId(1);

        }
}
