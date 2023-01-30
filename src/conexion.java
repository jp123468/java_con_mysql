import java.sql.*;


public class conexion {

        public conexion(){
            try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sakila", "root", "POObjetos1.");
                Statement s = conexion.createStatement();

                ResultSet rs =  s.executeQuery("select * from actor");
                while (rs.next()){
                    System.out.println(rs.getString("actor_id")+ " "+ rs.getString(2));
                }
                conexion.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}

