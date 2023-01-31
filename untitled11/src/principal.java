import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;

public class principal {
    JFrame frame = new JFrame("");
    private JPanel panel1;
    PreparedStatement ps;
    private JButton button1;
    private JTextField textId;
    private JTextField textnombre;
    private JTextField textcelular;
    private JTextField textcorreo;
    private JLabel JlabelId;


    public principal() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try {
                    con = getConection();
                    ps = con.prepareStatement("INSERT INTO estudiantes (idestudiantes,nombre,celular,correo) VALUES(?,?,?,?)");
                    ps.setString(1, textId.getText());
                    ps.setString(2, textnombre.getText());
                    ps.setString(3, textcelular.getText());
                    ps.setString(4, textcorreo.getText());
                    System.out.println(ps);

                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Persona Guardada");
                    } else {
                        JOptionPane.showMessageDialog(null, "Persona no Guardada");
                    }

                    con.close();//importante!!!!

                } catch (HeadlessException | SQLException f) {
                    System.err.println(f);
                }
            }

        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("insertar");
        frame.setContentPane(new principal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static Connection getConection() {
        Connection con = null;
        String base = "h"; //Nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
        String user = "root"; //Usuario de Acceso a MySQL
        String password = "POObjetos1."; //Password del usuario

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
