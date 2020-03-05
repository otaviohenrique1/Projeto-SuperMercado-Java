import java.awt.*;    
import javax.swing.*;
import java.awt.event.*;

public class SuperMercado extends JFrame implements ActionListener{
 //Declaração de variaveis
 JPanel pn1;
 JLabel r1,img,login,senha;
 JTextField l;
 JPasswordField s;
 JButton b1,b2;
 ConectaBD conexao = new ConectaBD();
 public static void main (String args[]){SuperMercado x = new SuperMercado();}
 public SuperMercado(){
   super ("SuperMercado Carrefour"); //titulo
   Container tela = getContentPane();//Intanciando tela
   pn1 = new JPanel();//istanciando painel para uso de divisão
   pn1.setLayout(null);   
   pn1.setBackground(Color.white); 
   conexao.conecta(); // conecta no banco
   //----------------------Declarando JLabels ---------------------------
   r1 = new JLabel("Bem Vindo");
   img = new JLabel("");
   login = new JLabel("Login");
   senha = new JLabel("Senha");
   //--------------------Declarando botões -----------------------------
   b1 = new JButton("Entrar"); b1.addActionListener(this);
   b2 = new JButton("Sair"); b2.addActionListener(this);
   //----------------------Declarando JTextFilds ------------------------
   l = new JTextField(80);
   s = new JPasswordField(20);
   //---------------------Estilizando tela ------------------------------
   r1.setFont(new Font("Georgia",Font.BOLD,35)); r1.setBounds(150,90,200,50); r1.setForeground(new Color(13,48,148));   
   
   img.setBounds(45,10,400,77); img.setIcon(new ImageIcon("logoc.gif"));
   
   login.setBounds(30,160,300,40); login.setFont(new Font("Georgia",Font.BOLD,30)); login.setForeground(new Color(13,48,148)); 
   l.setBounds(135,162,330,35);l.setFont(new Font("Georgia",Font.BOLD,20));l.setBackground(new Color(201,218,206)); //campo Login
  
   senha.setBounds(30,220,300,40); senha.setFont(new Font("Georgia",Font.BOLD,30)); senha.setForeground(new Color(13,48,148));
   s.setBounds(135,224,330,35); s.setFont(new Font("Georgia",Font.BOLD,20));s.setBackground(new Color(201,218,206)); //campo senha
   
   b1.setFont(new Font("Georgia",Font.BOLD,30)); b1.setBounds(30,280,200,45); b1.setForeground(new Color(13,48,148));b1.setBackground(new Color(201,218,206)); 
   b2.setFont(new Font("Georgia",Font.BOLD,30)); b2.setBounds(265,280,200,45);b2.setForeground(new Color(13,48,148));b2.setBackground(new Color(201,218,206));
   
   b1.setToolTipText(" Acessar o menu principal ");
   b2.setToolTipText(" Sair ");
   UIManager.put("ToolTip.background",SystemColor.info); 
   
   //--------------------- Adicionda a tela -----------------------------
   pn1.add(img);
   pn1.add(r1);
   pn1.add(login);  pn1.add(l);
   pn1.add(senha);  pn1.add(s);
   pn1.add(b1);     pn1.add(b2);
   tela.add(pn1);
   this.setSize(500,380);//tamanho da tela
   this.setVisible(true);   
   this.setLocationRelativeTo(null);
 }  
 public void actionPerformed(ActionEvent e){
     
     if(e.getSource()== b1)
       {
        String sql = "SELECT * FROM funcionario";
        conexao.consulta(sql);
        int errologin = 0;
       try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String Login = conexao.resultadobusca().getString("login");
                        String Senha = conexao.resultadobusca().getString("senha");  
                        String usuario = conexao.resultadobusca().getString("Nome");
                        String S = new String (s.getPassword());  
                        if (Login.equals(l.getText()) && Senha.equals(S))
                        {
                          errologin=1;
                          Menu x = new Menu(usuario);
                          setVisible(false); 
                          dispose();
                       }
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
        if(errologin == 0){
            JOptionPane.showMessageDialog(null,"Login ou Senha incorretos");
            l.setText(null);
            s.setText(null);
        }
       }
       else if(e.getSource()== b2)
       {
       setVisible(false); 
       dispose();
        }
      
 } 
}