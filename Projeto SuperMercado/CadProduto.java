import java.awt.*;    
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.*;
import java.sql.*;
import javax.swing.text.*;
public class CadProduto extends JFrame implements ActionListener{
 //Declaração de variaveis
 JPanel pn1;
 JLabel cad,nome,preco,codprod,fotop,img;
 JTextField Tproduto, Tpreco,Tcentavos, Tcodprod;
 JButton cadastrar,voltar,alterar,procura;
 JFileChooser pasta;
 String Destino ="C:/Users/rafael/Desktop/Projeto SuperMercado/produtos/";
 private File copiar;
 private File Origem ;
 MaskFormatter  mascara;
 ConectaBD conexao = new ConectaBD();
 private int i=0; //variavel para saber ual tela o chamou
 private String usuario;
 public CadProduto (int i,String usuario){
   super ("Cadastro de produtos"); //titulo
   Container tela = getContentPane();//Intanciando tela
   pn1 = new JPanel();//istanciando painel para uso de divisão
   pn1.setBackground(Color.white);
   pn1.setLayout(null);   
   this.i = i; // passando tela q o chamou
   conexao.conecta();
   this.usuario = usuario;
   //----------------JFileChosse ----------------------------------
    pasta = new JFileChooser();
   
   //----------------------Declarando JLabels ---------------------------
   cad = new JLabel("Cadastro de Produtos");
   nome = new JLabel("Nome Produto:");
   preco = new JLabel("Preço: R$             ,");
   codprod = new JLabel("Codigo Produto:");
   fotop = new JLabel("Img Produto:");
   img = new JLabel("");
   //--------------------Declarando botões -----------------------------
   voltar = new JButton("Voltar");
   cadastrar = new JButton("Cadastrar");
   alterar = new JButton("Alterar");
   procura = new JButton("Selecione uma Foto");
   //---------------------Declarando JTextField ------------------------
   Tproduto = new JTextField(80);
   Tpreco = new JTextField(80);
   Tcodprod = new JTextField(80);
   Tcentavos = new JTextField(2);
    try{
         mascara = new MaskFormatter("##");
         mascara.setPlaceholderCharacter('0'); 
                  } 
        catch(ParseException excp){} 
    Tpreco.setDocument(new sonumero());
    Tcentavos= new JFormattedTextField(mascara); 
   //---------------------Estilizando tela ------------------------------
   cad.setBounds(80,20,400,50); cad.setFont(new Font("Georgia",Font.BOLD,35)); cad.setForeground(new Color(13,48,148)); 
   nome.setBounds(30,100,200,30); nome.setFont(new Font("Georgia",Font.BOLD,20)); nome.setForeground(new Color(13,48,148));
   codprod.setBounds(30,160,200,30); codprod.setFont(new Font("Georgia",Font.BOLD,20)); codprod.setForeground(new Color(13,48,148));
   preco.setBounds(350,160,250,30); preco.setFont(new Font("Georgia",Font.BOLD,20)); preco.setForeground(new Color(13,48,148));
   fotop.setBounds(30,220,200,30); fotop.setFont(new Font("Georgia",Font.BOLD,20));  fotop.setForeground(new Color(13,48,148));
   Tproduto.setBounds(200,100,360,30); Tproduto.setFont(new Font("Georgia",Font.BOLD,20)); Tproduto.setBackground(new Color(201,218,206)); 
   Tcodprod.setBounds(200,160,140,30); Tcodprod.setFont(new Font("Georgia",Font.BOLD,20)); Tcodprod.setBackground(new Color(201,218,206)); 
   Tpreco.setBounds(450,160,70,30); Tpreco.setFont(new Font("Georgia",Font.BOLD,20));      Tpreco.setBackground(new Color(201,218,206));
   Tcentavos.setBounds(530,160,30,30); Tcentavos.setFont(new Font("Georgia",Font.BOLD,20)); Tcentavos.setBackground(new Color(201,218,206));
   voltar.setBounds(410,280,150,40); voltar.setFont(new Font("Georgia",Font.BOLD,20)); voltar.addActionListener(this);  voltar.setForeground(new Color(13,48,148)); voltar.setBackground(new Color(201,218,206));
   cadastrar.setBounds(30,280,150,40); cadastrar.setFont(new Font("Georgia",Font.BOLD,20)); cadastrar.addActionListener(this); cadastrar.setForeground(new Color(13,48,148)); cadastrar.setBackground(new Color(201,218,206));
   alterar.setBounds(220,280,150,40); alterar.setFont(new Font("Georgia",Font.BOLD,20)); alterar.addActionListener(this); alterar.setForeground(new Color(13,48,148)); alterar.setBackground(new Color(201,218,206));
   procura.setBounds(200,215,360,40); procura.setFont(new Font("Georgia",Font.BOLD,20));procura.addActionListener(this);  procura.setForeground(new Color(13,48,148)); procura.setBackground(new Color(201,218,206));
   img.setBounds(498,16,90,70); img.setIcon(new ImageIcon("cp.gif"));
   
   voltar.setToolTipText(" Retornar ao menu principal ");
   cadastrar.setToolTipText(" Cadastrar produto ");
   alterar.setToolTipText(" Editar informações ");
   procura.setToolTipText(" Selecionar arquivos ");
   UIManager.put("ToolTip.background",SystemColor.info); 
   //----------------------Adicionando a tela ----------------------------
   pn1.add(pasta);
   pn1.add(procura);
   pn1.add(Tcodprod);
   pn1.add(Tproduto);
   pn1.add(Tpreco);
   pn1.add(Tcentavos);
   pn1.add(nome);
   pn1.add(codprod);
   pn1.add(preco);
   pn1.add(fotop);
   pn1.add(voltar);
   pn1.add(cadastrar);
   pn1.add(alterar);
   pn1.add(cad);
   pn1.add(img);
   tela.add(pn1);
   this.setSize(600,380);//tamanho da tela
   this.setVisible(true);   
   this.setLocationRelativeTo(null);
 }  
 public void actionPerformed(ActionEvent e){
     //dando função ao botão
     if(e.getSource()== cadastrar)
       {
       String v = "0";
       String comandosql="INSERT INTO produtos VALUES('"+Tcodprod.getText()+"','"+Tproduto.getText()+"','"+Tpreco.getText()+","+Tcentavos.getText()+"','"+Origem.getName()+"','"+v+"')";
       conexao.grava(comandosql);
       
       Tcodprod.setText(null);
       Tproduto.setText(null);
       Tpreco.setText(null);
       procura.setText("Selecione uma Foto");
       try{
        copy(Origem, copiar, true);}catch (IOException x) {
          x.printStackTrace();
         }
         }
       else if(e.getSource()== alterar)
       {
     
       
      
      
        }
        else if(e.getSource()== procura)
       {
     
        String caminho = "";
        File file = null;
        int retorno = pasta.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
        if (retorno==JFileChooser.APPROVE_OPTION){
        caminho = pasta.getSelectedFile().getAbsolutePath();  // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
       }   
        
        Origem = new File(caminho);
        String novonome = Destino+Origem.getName();
        copiar = new File(novonome);
        procura.setText(Origem.getName());
        }
        else if(e.getSource()== voltar)
       {
       if (i == 1){
        Vendas x = new Vendas(usuario);
        setVisible(false); 
        dispose();}
        else {
        Menu x = new Menu(usuario);
        setVisible(false); 
        dispose();
       }
        }
      
 } 
 public static void copy(File origem, File destino, boolean overwrite) throws IOException{   
       if (destino.exists() && !overwrite){ 
          System.err.println(destino.getName()+" já existe, ignorando..."); 
          return; 
       } 
       FileInputStream fisOrigem = new FileInputStream(origem); 
       FileOutputStream fisDestino = new FileOutputStream(destino); 
       FileChannel fcOrigem = fisOrigem.getChannel();   
       FileChannel fcDestino = fisDestino.getChannel();   
       fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);   
       fisOrigem.close();   
       fisDestino.close(); 
    }
}