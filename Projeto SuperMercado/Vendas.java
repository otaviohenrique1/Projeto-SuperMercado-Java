import java.util.*;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.sql.*;
import javax.swing.text.*; 

public class Vendas extends JFrame implements ActionListener
{
    JLabel r1,r2,r3,r4,r5,r6,r7,r8,r9,ra,rb,rc,rd,cidade,tcidade,img1;
    JButton b1,b2,b3,efetuar;
    JComboBox j1;
    JTextField t1;
    ResultSet rs;
    ConectaBD conexao = new ConectaBD();
    private double Preco =0;
    private String usuario;
    private double multiplica;
    public Vendas(String usuario)
    {
        super("Vendas");
        Container tela= getContentPane();
        setLayout(null);
        tela.setBackground(Color.white);
        conexao.conecta();//conecta com o bd
        this.usuario = usuario;
        //-------------------------------------Label----------------------
        r1=new JLabel("Vendas");
        r1.setBounds(250,10,200,50);
        r1.setFont(new Font("Georgia", Font.BOLD, 30)); r1.setForeground(new Color(13,48,148));
        tela.add(r1);
        
        r2=new JLabel("Produto:");
        r2.setBounds(20,200,100,20);
        r2.setFont(new Font("Georgia", Font.BOLD, 19)); r2.setForeground(new Color(13,48,148));
        tela.add(r2);
        
        r3=new JLabel("Preço:");
        r3.setBounds(20,250,100,20);
        r3.setFont(new Font("Georgia", Font.BOLD, 19)); r3.setForeground(new Color(13,48,148));
        tela.add(r3);
        
        r4=new JLabel("Codigo:");
        r4.setBounds(20,300,100,20);
        r4.setFont(new Font("Georgia", Font.BOLD, 19)); r4.setForeground(new Color(13,48,148));
        tela.add(r4);
        
        r5=new JLabel("Total:");
        r5.setBounds(20,500,200,20); r5.setForeground(new Color(13,48,148));
        r5.setFont(new Font("Georgia", Font.BOLD, 19));
        tela.add(r5);
        
        r6=new JLabel("xxxxxxxx");
        r6.setBounds(115,185,200,50); 
        r6.setFont(new Font("Georgia", Font.BOLD, 18)); r6.setForeground(new Color(13,48,148));
        tela.add(r6);
        
        r7=new JLabel("xxxxxxxx");
        r7.setBounds(115,235,200,50);
        r7.setFont(new Font("Georgia", Font.BOLD, 18)); r7.setForeground(new Color(13,48,148));
        tela.add(r7);
        
        r8=new JLabel("xxxxxxxx");
        r8.setBounds(115,285,200,50);
        r8.setFont(new Font("Georgia", Font.BOLD, 18)); r8.setForeground(new Color(13,48,148));
        tela.add(r8);
        
        r9=new JLabel("");
        r9.setBounds(310,200,250,250);
        r9.setFont(new Font("Georgia", Font.BOLD, 18)); r9.setForeground(new Color(13,48,148));
        r9.setBorder(new javax.swing.border.TitledBorder("Imagem Produto"));
        r9.setIcon(new ImageIcon("produtos/carrefourlogo.jpg"));
        tela.add(r9);
        
        ra=new JLabel("Usuário:");
        ra.setBounds(20,335,200,50);
        ra.setFont(new Font("Georgia", Font.BOLD, 19)); ra.setForeground(new Color(13,48,148));
        tela.add(ra);
        
        rb=new JLabel("Quantidade:");
        rb.setBounds(20,435,200,50);
        rb.setFont(new Font("Georgia", Font.BOLD, 19)); rb.setForeground(new Color(13,48,148));
        tela.add(rb);
        
        rc=new JLabel(usuario);
        rc.setBounds(120,335,200,50);
        rc.setFont(new Font("Georgia", Font.BOLD, 19)); rc.setForeground(new Color(13,48,148));
        tela.add(rc);
        
        rd=new JLabel("xxxxxxxx");
        rd.setBounds(115,485,200,50);
        rd.setFont(new Font("Georgia", Font.BOLD, 18)); rd.setForeground(new Color(13,48,148));
        tela.add(rd);
        
        img1 = new JLabel("");
        img1.setBounds(500,10,90,70); img1.setIcon(new ImageIcon("cp.gif"));
        tela.add(img1);
        
        cidade=new JLabel("Cidade:");
        cidade.setBounds(20,385,200,50);
        cidade.setFont(new Font("Georgia", Font.BOLD, 19)); cidade.setForeground(new Color(13,48,148));
        tela.add(cidade);
        
        tcidade=new JLabel("");
        tcidade.setBounds(115,385,200,50);
        tcidade.setFont(new Font("Georgia", Font.BOLD, 18)); tcidade.setForeground(new Color(13,48,148));
        tela.add(tcidade);
        String sql2 = "SELECT * FROM funcionario WHERE Nome = '"+usuario+"'";
        conexao.consulta(sql2);
        try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String cit = conexao.resultadobusca().getString("Cidade");
                        tcidade.setText(cit);                                  
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
        
        //------------------------------------ComboBox-----------------------
        
        j1= new JComboBox();                
        j1.setBounds(20,80,280,50); j1.setFont(new Font("Georgia", Font.BOLD, 20)); j1.setBackground(new Color(201,218,206));
        j1.setMaximumRowCount(8);
        String sql = "SELECT Produto FROM produtos order by Produto asc";
        conexao.consulta(sql);
        try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String produto = conexao.resultadobusca().getString("Produto");
                        j1.addItem(produto);                                    
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
        j1.setFont(new Font("Georgia", Font.BOLD, 20)); j1.setBackground(new Color(201,218,206));
        tela.add(j1);
        
        
        //------------------------------------TextField----------------------
        t1=new JTextField(100);
        t1.setBounds(150,445,100,30); t1.setFont(new Font("Georgia", Font.BOLD, 18)); t1.setBackground(new Color(201,218,206));
        t1.addActionListener(new ActionListener() {
      
          @Override
         public void actionPerformed(ActionEvent e) {
             int valor = Integer.parseInt(t1.getText()); 
             multiplica = valor * Preco;
             rd.setText("R$ "+multiplica);
         }
        });
        t1.setDocument(new sonumero());
        tela.add(t1);
        //------------------------------------Botao cadastrar--------------------
        b1=new JButton("Cadastrar");
        b1.addActionListener(this);
        b1.setBounds(315,80,105,50); b1.setFont(new Font("Georgia", Font.BOLD, 13)); b1.setForeground(new Color(13,48,148)); b1.setBackground(new Color(201,218,206));
        tela.add(b1);
        //------------------------------------Botao ok-------------
        b2=new JButton("Ok");
        b2.addActionListener(this);
        b2.setBounds(440,80,100,50); b2.setFont(new Font("Georgia", Font.BOLD, 14)); b2.setForeground(new Color(13,48,148)); b2.setBackground(new Color(201,218,206));
        tela.add(b2);
        //------------------------------------Botao voltar-----------------
        b3=new JButton("Voltar");
        b3.addActionListener(this);
        b3.setBounds(440,480,100,50); b3.setFont(new Font("Georgia", Font.BOLD, 14)); b3.setForeground(new Color(13,48,148)); b3.setBackground(new Color(201,218,206));
        tela.add(b3);
        //------------------------------------Botão Efetuar vendas-----
        efetuar=new JButton("Efetuar Venda");
        efetuar.addActionListener(this);
        efetuar.setBounds(280,480,150,50); efetuar.setFont(new Font("Georgia", Font.BOLD, 14)); efetuar.setForeground(new Color(13,48,148)); efetuar.setBackground(new Color(201,218,206));
        tela.add(efetuar);
        
        b1.setToolTipText(" Cadastrar produtos ");
        b2.setToolTipText(" Selecionar produtos para a venda ");
        b3.setToolTipText(" Retornar ao menu principal ");
        efetuar.setToolTipText(" Realizar a venda ");
        j1.setToolTipText(" Escolher produto ");
        UIManager.put("ToolTip.background",SystemColor.info); 
        
        this.setSize(600,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }    
    public void actionPerformed (ActionEvent event)
    {
        int i = 1;
        if (event.getSource()==b1)
        {
            CadProduto x = new CadProduto(i,usuario);
            setVisible(false); 
            dispose();
        }
        else if (event.getSource()==b2)
        {
            String comandosql ="SELECT * FROM produtos WHERE Produto = '"+j1.getSelectedItem().toString()+"'";
            conexao.consulta(comandosql);
              try{
               if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String codproduto = conexao.resultadobusca().getString("Codproduto");r8.setText(codproduto);
                        String produto = conexao.resultadobusca().getString("Produto");r6.setText(produto);
                        String preco = conexao.resultadobusca().getString("Preco");r7.setText("R$ "+preco); 
                        Preco = Double.parseDouble(preco.replace(',', '.')); 
                        String img = conexao.resultadobusca().getString("img");r9.setIcon(new ImageIcon("produtos/"+img));
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
            rd.setText("xxxxxxxx");
            t1.setText(null);
        }
        else if (event.getSource()== efetuar)
        {
          String sql="INSERT INTO vendas VALUES('"+r8.getText()+"','"+r6.getText()+"','"+r7.getText()+"','"+usuario+"','"+tcidade.getText()+"','"+t1.getText()+"','"+multiplica+"')";
          conexao.grava(sql);
          String comandosql ="SELECT * FROM produtos WHERE Produto = '"+j1.getSelectedItem().toString()+"'";
           conexao.consulta(comandosql);
            
              try{
               if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String Vendidos = conexao.resultadobusca().getString("Vendidos");
                        int v = Integer.parseInt(Vendidos);
                        int vatual = Integer.parseInt(t1.getText());
                        v += vatual;
                        String sql2="UPDATE produtos set Vendidos='"+v+"' where Produto='"+j1.getSelectedItem().toString()+"'";
                        conexao.grava(sql2);
                        
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
          r8.setText("xxxxxxxx");
          r6.setText("xxxxxxxx");
          r7.setText("xxxxxxxx");
          t1.setText(null);
          rd.setText("xxxxxxxx");
          r9.setIcon(new ImageIcon("produtos/carrefourlogo.jpg"));
        }
        else if (event.getSource()==b3)
        {
         Menu x = new Menu(usuario);
         setVisible(false); 
         dispose();
        }
    }
   
 
}
