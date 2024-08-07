package employee;

public class test {
    public static void main(String[] args) {
       // employee_id.getconnection();
        connection c=new connection();
        c.setName("hp");
        c.setMail("hp@gmail.com");
        c.setAddress("bdk");
        c.setPincode(23);
      int hp=  employee_id.allemployee(c);
        System.out.println("employee id = "+hp);
    }
}
