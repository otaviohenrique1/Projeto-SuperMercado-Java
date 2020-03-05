import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class ConectaBD
{
    // variáveis para conexão
    Connection con;
    Statement stm;
    private ResultSet rs; // resultado das buscas são colocadas nesta variavel
    
    String url="jdbc:mysql://localhost/mercado"; // local do bd para acessar
    String user="root"; //usuario
    String password=""; // senha 
    String driver="com.mysql.jdbc.Driver";
    
    public void conecta() //utilizado para conectar ao banco
    {
        try
        {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
           // stmt=con.createStatement();
            
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public void grava(String texto)// grava arquivos ou pode tmb ser usado para excluir
    {
        try
        {
           stm = con.createStatement();
           stm.execute(texto);
           JOptionPane.showMessageDialog(null,"Dados gravados com sucesso!","Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
        }
        catch(SQLException erro)
        {
           JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }

    }
     public void consulta(String texto) // efetua uma busca no bd e retorna atraves do metodo resultadobusca()
    {
        try
        {
           stm = con.createStatement();
           rs = stm.executeQuery(texto);
        }
        catch(SQLException erro)
        {
           JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }

    }
    public ResultSet resultadobusca(){return rs;} // retorna o resultado de uma busca efetuada enterior mente
    
 
}
    