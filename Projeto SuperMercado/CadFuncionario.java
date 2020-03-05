import java.awt.*;    
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CadFuncionario extends JFrame implements ActionListener{
 //Declaração de variaveis
 JPanel pn1;
 JLabel cad,nome,cidade,login,senha, img, img2;
 JTextField Tnome, Tcit, Tlogin,Tsenha;
 JButton cadastrar,voltar,alterar;
 ConectaBD conexao = new ConectaBD();
 private String usuario;
 public CadFuncionario  (String usuario){
   super ("Cadastro de Funcionarios"); //titulo
   Container tela = getContentPane();//Intanciando tela
   pn1 = new JPanel();//istanciando painel para uso de divisão
   pn1.setBackground(Color.white);
   pn1.setLayout(null);   
   conexao.conecta();//conecta no banco
   this.usuario = usuario;
   //----------------------Declarando JLabels ---------------------------
   cad = new JLabel("Cadastro");
   nome = new JLabel("Funcionario:");
   cidade = new JLabel("Cidade:");
   login = new JLabel("Login:");
   senha = new JLabel("Senha:");
   img = new JLabel("");
   img2 = new JLabel("");
   //--------------------Declarando botões -----------------------------
   voltar = new JButton("Voltar");
   cadastrar = new JButton("Cadastrar");
   alterar = new JButton("Alterar");
   //---------------------Declarando JTextField ------------------------
   Tnome = new JTextField(80);
   Tcit = new JTextField(80);
   Tlogin = new JTextField(80);
   Tsenha = new JTextField(80);
   //---------------------Estilizando tela ------------------------------
   img2.setBounds(20,15,90,70); img2.setIcon(new ImageIcon("g.jpg"));
   cad.setBounds(210,20,200,50); cad.setFont(new Font("Georgia",Font.BOLD,35)); cad.setForeground(new Color(13,48,148));
   nome.setBounds(20,100,200,30); nome.setFont(new Font("Georgia",Font.BOLD,20)); nome.setForeground(new Color(13,48,148));
   cidade.setBounds(20,160,200,30); cidade.setFont(new Font("Georgia",Font.BOLD,20)); cidade.setForeground(new Color(13,48,148)); 
   login.setBounds(20,220,200,30); login.setFont(new Font("Georgia",Font.BOLD,20)); login.setForeground(new Color(13,48,148));
   senha.setBounds(20,280,200,30); senha.setFont(new Font("Georgia",Font.BOLD,20)); senha.setForeground(new Color(13,48,148));
   Tnome.setBounds(160,100,390,30); Tnome.setFont(new Font("Georgia",Font.BOLD,20)); Tnome.setBackground(new Color(201,218,206));
   Tcit.setBounds(160,160,390,30); Tcit.setFont(new Font("Georgia",Font.BOLD,20));  Tcit.setBackground(new Color(201,218,206));
   Tlogin.setBounds(160,220,390,30); Tlogin.setFont(new Font("Georgia",Font.BOLD,20)); Tlogin.setBackground(new Color(201,218,206));
   Tsenha.setBounds(160,280,390,30); Tsenha.setFont(new Font("Georgia",Font.BOLD,20)); Tsenha.setBackground(new Color(201,218,206));
   voltar.setBounds(400,350,150,40); voltar.setFont(new Font("Georgia",Font.BOLD,20)); voltar.setForeground(new Color(13,48,148)); voltar.setBackground(new Color(201,218,206)); voltar.addActionListener(this);
   cadastrar.setBounds(30,350,150,40); cadastrar.setFont(new Font("Georgia",Font.BOLD,20)); cadastrar.setForeground(new Color(13,48,148)); cadastrar.setBackground(new Color(201,218,206)); cadastrar.addActionListener(this);
   alterar.setBounds(215,350,150,40); alterar.setFont(new Font("Georgia",Font.BOLD,20)); alterar.setForeground(new Color(13,48,148)); alterar.setBackground(new Color(201,218,206)); alterar.addActionListener(this);
   img.setBounds(498,15,90,70); img.setIcon(new ImageIcon("cp.gif"));
   
   voltar.setToolTipText(" Retornar ao menu principal ");
   cadastrar.setToolTipText(" Cadastrar funcionarios ");
   alterar.setToolTipText(" Alterar informações ");
   UIManager.put("ToolTip.background",SystemColor.info);
   //----------------------Adicionando a tela ----------------------------
   pn1.add(Tlogin);
   pn1.add(Tsenha);
   pn1.add(Tnome);
   pn1.add(Tcit);
   pn1.add(nome);
   pn1.add(login);
   pn1.add(cidade);
   pn1.add(voltar);
   pn1.add(cadastrar);
   pn1.add(alterar);
   pn1.add(senha);
   pn1.add(cad);
   pn1.add(img);
   pn1.add(img2);
   tela.add(pn1);
   this.setSize(600,460);//tamanho da tela
   this.setVisible(true);   
   this.setLocationRelativeTo(null);
 }  
 public void actionPerformed(ActionEvent e){
     //dando função ao botão
     if(e.getSource()== cadastrar)
       {
       String sql="INSERT INTO funcionario VALUES('"+Tnome.getText()+"','"+Tcit.getText()+"','"+Tlogin.getText()+"','"+Tsenha.getText()+"')";
       conexao.grava(sql);
       Tnome.setText(null);
       Tcit.setText(null);
       Tlogin.setText(null);
       Tsenha.setText(null);
        }
       else if(e.getSource()== alterar)
       {
     
       
      
      
        }
        else if(e.getSource()== voltar)
       {
       Menu x = new Menu(usuario);
       setVisible(false); 
       dispose();
        }
      
 } 
}
