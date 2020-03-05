import java.awt.*;    
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import java.sql.*;
public class Relatorio extends JFrame implements ActionListener{
 //Declaração de variaveis
 JPanel pn1,pn2;
 JLabel titulo,por,na,codOUnome, img;
 JButton buscar,buscac,b1;
 JTextField procura;
 JComboBox j1,j2,j3,j4;
 private JScrollPane barra,barra2;
 private JTable tabela,tabelacomplexa;
 ConectaBD conexao = new ConectaBD();
 private String usuario;
 private ResultSet rs;
 private double Preco =0, Lucro =0;
 public Relatorio(String usuario){
   super ("Relatorio"); //titulo
   Container tela = getContentPane();//Intanciando tela
   pn1 = new JPanel();//istanciando painel para uso de divisão
   pn1.setBackground(Color.white);
   tela.setBackground(Color.white);
   pn1.setLayout(new java.awt.GridLayout(1, 0));  
   pn1.setBorder(new javax.swing.border.TitledBorder("Tabela de Produtos"));
   pn2 = new JPanel();//istanciando painel troca
   pn2.setBackground(Color.white); 
   pn2.setLayout(new java.awt.GridLayout(1, 0));  
   
   pn2.setVisible(false);
   tela.setLayout(null);   
   this.usuario = usuario;
   //------------------Tabela simples---------------------------
   tabela = new JTable();
   barra = new JScrollPane();
 
    tabela.setLayout(new java.awt.GridLayout(1, 0)); tabela.setFont(new Font("Georgia",Font.BOLD,16)); tabela.setForeground(new Color(13,48,148)); tabela.setBackground(new Color(201,218,206)); 
    tabela.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] { },
    new String [] {"Cod", "Nome Produto","Preço","Total Vendido"}
     ){} );
    tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
    tabela.getColumnModel().getColumn(0).setResizable(false);    
    tabela.getColumnModel().getColumn(1).setPreferredWidth(416);
    tabela.getColumnModel().getColumn(1).setResizable(true);    
    tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
    tabela.getColumnModel().getColumn(2).setResizable(true);    
    tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
    tabela.getColumnModel().getColumn(3).setResizable(true);   
    tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
  
   //-----------------------Tabela complexa---------------------------------------
   tabelacomplexa = new JTable();
  
    tabelacomplexa.setLayout(new java.awt.GridLayout(1, 0)); tabelacomplexa.setFont(new Font("Georgia",Font.BOLD,16)); tabelacomplexa.setForeground(new Color(13,48,148)); tabelacomplexa.setBackground(new Color(201,218,206)); 
    tabelacomplexa.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] { },
    new String [] {"Cod","Produto","Preço","Vendidos","Total lucrado"}
     ){} );
     tabelacomplexa.setAutoCreateRowSorter(true);
    barra2 = new JScrollPane();
    tabelacomplexa.getColumnModel().getColumn(0).setPreferredWidth(60);
    tabelacomplexa.getColumnModel().getColumn(0).setResizable(false);    
    tabelacomplexa.getColumnModel().getColumn(1).setPreferredWidth(300);
    tabelacomplexa.getColumnModel().getColumn(1).setResizable(true);    
    tabelacomplexa.getColumnModel().getColumn(2).setPreferredWidth(150);
    tabelacomplexa.getColumnModel().getColumn(2).setResizable(true);    
    tabelacomplexa.getColumnModel().getColumn(3).setPreferredWidth(120);
    tabelacomplexa.getColumnModel().getColumn(3).setResizable(true);   
    tabelacomplexa.getColumnModel().getColumn(4).setPreferredWidth(184);
    tabelacomplexa.getColumnModel().getColumn(4).setResizable(true);   
    tabelacomplexa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
   //-------------------------Dados da tabela ------------
   conexao.conecta();
   String sql = "SELECT * FROM produtos";
   Enchetabela(sql);
   //----------------------Declarando JLabels ---------------------------
   titulo = new JLabel("Analise de Dados");
   por = new JLabel("Pesquizar por: ");
   na = new JLabel("Escolha por:");
   codOUnome = new JLabel("----------------------------------");
   img = new JLabel("");
   img.setBounds(780,0,90,70); img.setIcon(new ImageIcon("cp.gif"));
   //---------------------Delclarando JTextField -----------------------
   procura = new JTextField(80);
   procura.setVisible(false); 
   //--------------------Declarando botões -----------------------------
   buscar = new JButton("Buscar");
   buscac = new JButton("Busca refinada");
   b1 = new JButton("Voltar");
   //--------------------Combo Box ------------------------------------
   j1= new JComboBox();                
   j1.setBounds(175,80,190,40); j1.setFont(new Font("Georgia",Font.BOLD,35));
   j1.setMaximumRowCount(5);
   j1.addItem("Mais Vendido");
   j1.addItem("Menos Vendido");
   j1.addItem("Nome Produto");
   j1.addItem("Cod. Produto");
   j1.setFont(new Font("Georgia",Font.BOLD,15));
   ItemListener faz = new ItemListener(){  
       public void itemStateChanged(ItemEvent e) {  
          if(j1.getSelectedItem().toString().equals("Cod. Produto")){
           codOUnome.setText("Codigo:");
           procura.setVisible(true); 
          }
           else if (j1.getSelectedItem().toString().equals("Nome Produto")) {
           codOUnome.setText("Nome:");
           procura.setVisible(true); 
          }
           else{codOUnome.setText("----------------------------------");procura.setVisible(false); }
       }  
    }  ;
    j1.setBackground(new Color(201,218,206)); 
    j1.addItemListener(faz); 
    
   j2= new JComboBox();                
   j2.setBounds(155,130,230,40);
   j2.setMaximumRowCount(5);
   j2.addItem("Mais vendido por Funcionario");
   j2.addItem("Menos vendido por Funcionarios");
   j2.addItem("Mais vendido por Cidade");
   j2.addItem("Menos vendido por Cidade");
   j2.setFont(new Font("Georgia",Font.BOLD,15));
    ItemListener faz2 = new ItemListener(){  
       public void itemStateChanged(ItemEvent e) {  
        if(j2.getSelectedItem().toString().equals("Mais vendido por Funcionario") || j2.getSelectedItem().toString().equals("Menos vendido por Funcionarios")){
           j3.setVisible(true); 
           j4.setVisible(false); 
          }
           else if (j2.getSelectedItem().toString().equals("Mais vendido por Cidade") || j2.getSelectedItem().toString().equals("Menos vendido por Cidade")) {
           j4.setVisible(true); 
           j3.setVisible(false); 
          }
       }  
    }  ;
    j2.setBackground(new Color(201,218,206)); 
    j2.addItemListener(faz2); 
    
    j3= new JComboBox(); 
    j3.setMaximumRowCount(8);
    j3.setBounds(400,130,230,40);
    j3.setFont(new Font("Georgia",Font.BOLD,15)); 
    String sql2 = "SELECT Nome FROM funcionario order by Nome asc";
        conexao.consulta(sql2);
        try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String Nome = conexao.resultadobusca().getString("Nome");
                        j3.addItem(Nome);                                    
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
    j3.setBackground(new Color(201,218,206)); 
   
    j4= new JComboBox(); 
    j4.setMaximumRowCount(8);
    j4.setBounds(400,130,230,40);
    j4.setFont(new Font("Georgia",Font.BOLD,15));
    String sql3 = "SELECT DISTINCT Cidade FROM funcionario order by Cidade asc";
        conexao.consulta(sql3);
        try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String Cit = conexao.resultadobusca().getString("Cidade");
                        j4.addItem(Cit);                                    
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
   j4.setBackground(new Color(201,218,206)); 
   j4.setVisible(false);  
   //---------------------Estilizando tela ------------------------------
   pn1.setBounds(25,190,829,300);  
   pn2.setBounds(25,190,829,300);
   titulo.setBounds(280,10,400,50); titulo.setFont(new Font("Georgia",Font.BOLD,35));titulo.setForeground(new Color(13,48,148)); 
   por.setBounds(25,80,400,40); por.setFont(new Font("Georgia",Font.BOLD,20)); por.setForeground(new Color(13,48,148)); 
   codOUnome.setBounds(380,80,600,40); codOUnome.setFont(new Font("Georgia",Font.BOLD,20)); codOUnome.setForeground(new Color(13,48,148)); 
   procura.setBounds(464,80,166,40); procura.setFont(new Font("Georgia",Font.BOLD,15)); procura.setBackground(new Color(201,218,206));  
   na.setBounds(25,130,400,40); na.setFont(new Font("Georgia",Font.BOLD,20)); na.setForeground(new Color(13,48,148)); 
   buscar.setBounds(667,80,188,40); buscar.setFont(new Font("Georgia",Font.BOLD,20)); buscar.setForeground(new Color(13,48,148)); buscar.setBackground(new Color(201,218,206)); buscar.addActionListener(this);
   buscac.setBounds(667,130,188,40); buscac.setFont(new Font("Georgia",Font.BOLD,20));buscac.setForeground(new Color(13,48,148)); buscac.setBackground(new Color(201,218,206)); buscac.addActionListener(this);
   b1.setBounds(335,500,200,40); b1.setFont(new Font("Georgia",Font.BOLD,20));b1.setForeground(new Color(13,48,148)); b1.setBackground(new Color(201,218,206)); b1.addActionListener(this); 
   //--------------------- Adicionda a tela -----------------------------
   barra.setViewportView(tabela);
   barra2.setViewportView(tabelacomplexa); 
   pn1.add(barra);
   pn2.add(barra2);
   tela.add(procura);
   tela.add(codOUnome);
   tela.add(buscar);
   tela.add(buscac);
   tela.add(b1);
   tela.add(j1);
   tela.add(j2);
   tela.add(j3);
   tela.add(j4);
   tela.add(na);
   tela.add(por);
   tela.add(titulo);
   tela.add(img);
   tela.add(pn1);
   tela.add(pn2);
   this.setSize(900,595);//tamanho da tela
   this.setVisible(true);   
   this.setLocationRelativeTo(null);
 }  

 public void actionPerformed(ActionEvent e){
     
     if(e.getSource()== buscar)
       {
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
        dtm.setNumRows(0);
        pn2.setVisible(false);
        pn1.setVisible(true);
         if(j1.getSelectedItem().toString().equals("Mais Vendido")){String sql = "SELECT * FROM produtos order by Vendidos desc"; Enchetabela(sql);}
         else if(j1.getSelectedItem().toString().equals("Menos Vendido")){String sql = "SELECT * FROM produtos order by Vendidos asc"; Enchetabela(sql);}
         else if(j1.getSelectedItem().toString().equals("Nome Produto")){String sql = "SELECT * FROM produtos WHERE Produto LIKE '%"+procura.getText()+"%'"; Enchetabela(sql);}
         else if(j1.getSelectedItem().toString().equals("Cod. Produto")){String sql = "SELECT * FROM produtos WHERE Codproduto ='"+procura.getText()+"'"; Enchetabela(sql);}
         
        }
     else if(e.getSource()== buscac)
       {
        pn1.setVisible(false);
        pn2.setVisible(true);
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelacomplexa.getModel();
        dtm.setNumRows(0);
         if(j2.getSelectedItem().toString().equals("Mais vendido por Funcionario") || j2.getSelectedItem().toString().equals("Menos vendido por Funcionarios")){
          pn2.setBorder(new javax.swing.border.TitledBorder(j3.getSelectedItem().toString()));
          String vend ="vendedor";
          Enchetabelacomplexa(j3.getSelectedItem().toString(),vend);
          tabelacomplexa.getColumnModel().getColumn(4).setHeaderValue("Total Lucrado R$ "+Lucro);  
          tabelacomplexa.getTableHeader().resizeAndRepaint(); 
         }
         else{
          pn2.setBorder(new javax.swing.border.TitledBorder(j4.getSelectedItem().toString()));
          String cit ="cidade";
          Enchetabelacomplexa(j4.getSelectedItem().toString(),cit);
          tabelacomplexa.getColumnModel().getColumn(4).setHeaderValue("Total Lucrado R$ "+Lucro);  
          tabelacomplexa.getTableHeader().resizeAndRepaint(); 
         }
         Lucro =0;
        }
       else if(e.getSource()== b1)
       {
       Menu x = new Menu(usuario);
       setVisible(false); 
       dispose();
       }
 } 
 public void Enchetabela(String sql){
   javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
   
   conexao.consulta(sql);
   try{
          if(conexao.resultadobusca() != null){
                   while(conexao.resultadobusca().next())  
                         {  
                        String codproduto = conexao.resultadobusca().getString("Codproduto");
                        String produto = conexao.resultadobusca().getString("Produto");
                        String preco = conexao.resultadobusca().getString("Preco");
                        String vendido = conexao.resultadobusca().getString("Vendidos");
                        dtm.addRow(new Object[]{codproduto,produto,"R$ "+preco,vendido});  
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
    }
    
 public void Enchetabelacomplexa(String v,String citouvend){
   javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelacomplexa.getModel();
   String sql2 = "SELECT * FROM produtos order by Produto asc"; 
   conexao.consulta(sql2);
   rs = conexao.resultadobusca();
   try{
          if(rs != null){
                   while(rs.next())  
                         {  
                        String codproduto = rs.getString("Codproduto");
                        String produto = rs.getString("Produto");
                        String preco = rs.getString("Preco");
                        String sql = "SELECT SUM( nvenda ) AS SOMA FROM vendas WHERE "+citouvend+" =  '"+v+"' AND produto =  '"+produto+"'";
                        conexao.consulta(sql);
                        String vendas="0";
                        if(conexao.resultadobusca() != null){
                         while(conexao.resultadobusca().next())  
                         {  vendas = conexao.resultadobusca().getString("SOMA");}
                        }
                        if (vendas == null){vendas = "0";}
                        Preco = Double.parseDouble(preco.replace(',', '.'));
                        int ve = Integer.parseInt(vendas);
                        double total = Preco *ve;
                        Lucro += total;
                        dtm.addRow(new Object[]{codproduto,produto,"R$ "+preco,ve,"R$ "+total});  
                      } 
                     }
                    } 
              catch (Exception erro){ 
               JOptionPane.showMessageDialog(null,"Error na transferencia de dados","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
             } 
    }
 
 public static void main (String args[]){
     String a ="";
     Relatorio x = new Relatorio(a);}
}