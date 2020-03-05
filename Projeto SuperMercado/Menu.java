import java.awt.*;    
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Menu extends JFrame implements ActionListener{
 //Declaração de variaveis
 JPanel pn1;
 JLabel menu,img,img2,user;
 JButton cadastrop,vendas,cadastrof,relatorio,voltar;
 private String usuario;
 public Menu(String usuario){
   super ("Menu"); //titulo
   Container tela = getContentPane();//Intanciando tela
   pn1 = new JPanel();//istanciando painel para uso de divisão
   pn1.setBackground(Color.white);
   pn1.setLayout(null);   
   this.usuario = usuario;
   //----------------------Declarando JLabels ---------------------------
   menu = new JLabel("MENU");
   user = new JLabel("Bem Vindo "+usuario);
   img = new JLabel("");
   img2 = new JLabel("");
   //--------------------Declarando botões -----------------------------
   cadastrof = new JButton("Cadastro Funcionarios");
   vendas = new JButton("Vendas");
   cadastrop = new JButton("Cadastro Produtos");
   relatorio = new JButton("Relatório");
   voltar = new JButton("Deslogar");
   //---------------------Estilizando tela ------------------------------
   user.setBounds(45,5,700,20); user.setFont(new Font("Georgia",Font.BOLD,16)); user.setForeground(new Color(13,48,148));   
   menu.setBounds(240,27,400,40); menu.setFont(new Font("Georgia",Font.BOLD,35)); menu.setForeground(new Color(13,48,148));  
   img.setBounds(500,15,90,70); img.setIcon(new ImageIcon("cp.gif"));
   img2.setBounds(10,0,30,32); img2.setIcon(new ImageIcon("bpower.jpg"));
   cadastrop.setBounds(40,85,500,60); cadastrop.setFont(new Font("Georgia",Font.BOLD,30)); cadastrop.addActionListener(this); cadastrop.setForeground(new Color(13,48,148)); cadastrop.setBackground(new Color(201,218,206));   
   vendas.setBounds(40,155,500,60); vendas.setFont(new Font("Georgia",Font.BOLD,30)); vendas.addActionListener(this); vendas.setForeground(new Color(13,48,148)); vendas.setBackground(new Color(201,218,206)); 
   cadastrof.setBounds(40,225,500,60); cadastrof.setFont(new Font("Georgia",Font.BOLD,30)); cadastrof.addActionListener(this); cadastrof.setForeground(new Color(13,48,148)); cadastrof.setBackground(new Color(201,218,206));   
   relatorio.setBounds(40,295,500,60); relatorio.setFont(new Font("Georgia",Font.BOLD,30)); relatorio.addActionListener(this); relatorio.setForeground(new Color(13,48,148)); relatorio.setBackground(new Color(201,218,206));  
   voltar.setBounds(40,365,500,60); voltar.setFont(new Font("Georgia",Font.BOLD,30)); voltar.addActionListener(this); voltar.setForeground(new Color(13,48,148)); voltar.setBackground(new Color(201,218,206)); 
   
   
   cadastrop.setToolTipText(" Cadastrar produtos ");
   vendas.setToolTipText(" Realizar venda ");
   cadastrof.setToolTipText(" Cadastrar funcionarios ");
   relatorio.setToolTipText(" Emitir relatórios ");
   voltar.setToolTipText(" Retornar a tela de Login ");
   UIManager.put("ToolTip.background",SystemColor.info); 
   
   //----------------------Adicionando a tela ----------------------------
   pn1.add(user);
   pn1.add(img);
   pn1.add(img2);
   pn1.add(cadastrof);
   pn1.add(cadastrop);
   pn1.add(vendas);
   pn1.add(relatorio);
   pn1.add(voltar);
   pn1.add(menu);
   tela.add(pn1);
   this.setSize(600,480);//tamanho da tela
   this.setVisible(true);   
   this.setLocationRelativeTo(null);
 }  
 public void actionPerformed(ActionEvent e){
     //dando função ao botão
     int i=0;
     if(e.getSource()== cadastrop)
       {
       CadProduto x = new CadProduto(i,usuario);
       setVisible(false); 
       dispose();
       }
       else if(e.getSource()== cadastrof)
       {
       CadFuncionario x = new CadFuncionario(usuario);
       setVisible(false); 
       dispose();
        }
        else if(e.getSource()== vendas)
       {
       Vendas x = new Vendas(usuario);
       setVisible(false); 
       dispose();
        }
        else if(e.getSource()== relatorio)
       {
       Relatorio x = new Relatorio(usuario);
       setVisible(false); 
       dispose();
        }
        else if(e.getSource()== voltar)
       {
       SuperMercado x = new SuperMercado();
       setVisible(false); 
       dispose();
        }
      
 } 
}