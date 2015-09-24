/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VS9 X64Bit
 */
public class Dextorminator extends javax.swing.JFrame {
    String link;
    String out;
    
   public static String STANDARDLIZE(String s){
		while(s.charAt(0)==' '){
			s = s.substring(1);
		}
		return s;
	}
        public static String EXTRACT(String source,String core){
    	String[] replacements ={"<li>","</li>","<br>","<ul class=\"bb_ul\">","<strong>","</br>","</strong>","</ul>","Supported"};
    	source = source.replace(core,"");
    	for(String replacement : replacements){
    		source= source.replace(replacement, "");
    	}
    	return STANDARDLIZE(source);
        }
    public static String HeaderIMG(String s){
        return"[CENTER][IMG]"+s+"[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"";
    }
    public static String Screenshot(String img1,String img2,String img3){
        return"[IMG]http://img42.imageshack.us/img42/4716/screenwbp.png[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[IMG]"+img1+"[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[IMG]"+img2+"[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[IMG]"+img3+"[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"";
    }
    public static String SystemRequirement(String s){
        return "[IMG]http://img594.imageshack.us/img594/1497/infors.png[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[/CENTER]\n" +
"[QUOTE] [B][SIZE=6][I][COLOR=\"#ff3333\"]System Requirements[/COLOR][/I][/SIZE][/B]\n" + s +
"[/QUOTE]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[CENTER]";
    }
    public static String Trailer(String s){
        return"[IMG]http://img40.imageshack.us/img40/6877/trailerw.png[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[video]"+s+"[/video]\n" +
"\n" +
"\n" +
"";
    }
    public static String NormalDownload(String fshare, String fourshare,String mega,String tenlua){
        return"[IMG]http://3.bp.blogspot.com/-xzNFsPGxUjU/UAwFX9LX-rI/AAAAAAAAAGQ/lYizCoFVysw/s1600/download.gif.png[/IMG]\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"[SIZE=4][COLOR=#FF0000][FONT=Comic Sans MS][B][TABLE=\"class: grid, width: 600, align: center\"]\n" +
"[TR]\n" +
"[TD]Host tải[/TD]\n" +
"[TD]Link tải[/TD]\n" +
"[/TR]\n" +
"[TR]\n" +
"[TD][IMG]http://i.imgur.com/kEwTD8O.png[/IMG][/TD]\n" +
"[TD][SIZE=4][COLOR=#FF0000][FONT=Comic Sans MS][B][URL]"+ fshare+"[/URL][/B][/FONT][/COLOR][/SIZE][/TD]\n" +
"[/TR]\n" +
"[TR]\n" +
"[TD][IMG]http://i.imgur.com/vtztzfO.png[/IMG][/TD]\n" +
"[TD][URL]"+fourshare+"[/URL][/TD]\n" +
"[/TR]\n" +
"[TR]\n" +
"[TD][IMG]http://i.imgur.com/vHAW0lK.png[/IMG][/TD]\n" +
"[TD][SIZE=4][COLOR=#FF0000][FONT=Comic Sans MS][B][URL]"+mega+"[/URL][/B][/FONT][/COLOR][/SIZE][/TD]\n" +
"[/TR]\n" +
"[TR]\n" +
"[TD][IMG]http://i.imgur.com/cOur8am.png?1[/IMG][/TD]\n" +
"[TD][B][URL]"+tenlua+"[/URL][/B][/TD]\n" +
"[/TR]\n" +
"[/TABLE]\n" +
"[/B][/FONT][/COLOR][/SIZE]"+"\r"+"\r"+"\r"+"\r"+"\r";
    }
    public static String Signature(){
        return"[RIGHT][SIZE=5][FONT=franklin gothic medium][COLOR=#0000CD]Sản phẩm được Upload bới[/COLOR][SIZE=6][B][URL=\"http://www.vn-zoom.com/1138262--jenty-/\"][COLOR=#FF0000]» JenTy «[/COLOR][/URL][/B][/SIZE][COLOR=#0000CD] - Uploader Vn-zoom[/COLOR][/FONT][/SIZE][/RIGHT]\n" +
"[/CENTER]";
    }
    public static String MEGADOWNLOAD(String mega){
        String result="[IMG]http://3.bp.blogspot.com/-xzNFsPGxUjU/UAwFX9LX-rI/AAAAAAAAAGQ/lYizCoFVysw/s1600/download.gif.png[/IMG]\n" +
"\r" +
"\r" +
"[QUOTE]";
        String[] parts = mega.split("\n");
        for(int i=0;i<parts.length;i++){
            parts[i]= "[CENTER][URL]"+parts[i]+"[/URL][/CENTER]";
            result = result +"\n" + parts[i];
        }
        
        return result+"[/QUOTE]";
    }
    public static String DLC(String name,String link){
        
        return"\r"+"\r"+"\r"+"[CENTER][B][SIZE=6][COLOR=\"#FF0000\"]"+name+"[/COLOR][/SIZE][/B]\n" +
"\n" +
"\n[QUOTE][B][SIZE=5]"+link+"[/SIZE][/B][/QUOTE][/CENTER]";
    }
    

    /**
     * Creates new form Dextorminator
     */
    public Dextorminator() throws IOException {
        super(" Jenty Tool");
        
            initComponents();
           
            // SET BUTTON EVENT
            btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             // HANDLE THE CHECKBOX
            Boolean outHEADER = cbHEADER.isSelected();
            Boolean addMEGASHARE = cbMEGASHARE.isSelected();
            
                // CONNECT TO THE STEAM LINK
                link = inputSTEAM.getText();
                if(link.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Phần này không được để trống");
                    return;
            }
                URL url;
                BufferedReader br = null;
                try {
                    url = new URL(link);
                    URLConnection conn = url.openConnection();
                    br  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane,"Sự cố khi kết nối, vui lòng thử lại");
                }
                System.out.println(link);
                String inputLine; // OUR MAIN CHARACTER.
                
                // HIS JOURNEY BEGINS
                
                // BOSS #1 : HEADER IMG
                String headerimg = "cac";
                try {
                    if(outHEADER){
                        headerimg = inputHEADERIMG.getText();
                    }
                    else{
                    while((inputLine=br.readLine())!=null){
                        if(inputLine.contains("<img class=\"game_header_image_full\" src=\"")){
                            inputLine = inputLine.replace("<img class=\"game_header_image_full\" src=\"","").replace("\">","");
                            headerimg = inputLine.replace("\\s","").trim();
                            break;
                        }
                    }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Dextorminator.class.getName()).log(Level.SEVERE, null, ex);
                }
                // BOSS #2 : SCREENSHOTS
                String[] img = new String[3];
                String STANDARD ="http://cdn.akamai.steamstatic.com/steam/apps/";
                int count = 0;
             //   String[] rep ={"<div class=\"highlight_strip_item highlight_strip_screenshot\" id=\"thumb_screenshot_","\" >"};
                try {
                    while((inputLine = br.readLine())!=null && count < img.length){
                        if(inputLine.contains("highlight_strip_item highlight_strip_screenshot")){
                            img[count]= STANDARD + link.replace("store.steampowered.com/app/","").replace("http://", "")
                                    + inputLine.replace("<div class=\"highlight_strip_item"
                                            + " highlight_strip_screenshot\" id=\"thumb_screenshot_", "").replace("\" >","");
                            img[count] = img[count].replaceAll("\\s+","");
                            System.out.println(img[count]);
                            count++;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Dextorminator.class.getName()).log(Level.SEVERE, null, ex);
                }
                //http://store.steampowered.com/app/15620/
                if(img[0]==null && img[1]==null && img[2]==null)
                    JOptionPane.showMessageDialog(rootPane,"Game bị hệ thống trên Steam chặn bằng Agechecker.." );
                
                //BOSS #3: SYSTEM REQUIREMENT

                String resultsys="\n";
                int open =1;
                try {
                    while((inputLine=br.readLine())!=null){
                        
                        if(inputLine.contains("OS:")){
                            if(open==1){ //System.out.println(" MINIMUM :"); 
                            	resultsys +="[LIST][B]Minimum:[/B]"+"\n";
                                resultsys +="[LIST]"+"\n";
                                
                            }
                            if(open==2) {//System.out.println(" RECOMMENED :");
                            	resultsys +="[LIST][B]Recomended:[/B]"+"\n";
                                resultsys +="[LIST]"+"\n";
                            }
                            //System.out.println("OS: "+EXTRACT(inputLine,"OS:"));
                            //System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"OS:"+EXTRACT(inputLine,"OS:")+"</span></strong></p>");
                        resultsys += "[*][B]OS[/B]: "+EXTRACT(inputLine,"OS:")+"\n";
                        }
                        
                        if(inputLine.contains("Processor:")){
                            //System.out.println("CPU: "+EXTRACT(inputLine,"Processor:"));
                            //System.out.println("<p style=\"text-align: center; \"><strong><span style=\"font-size: 20px;\">"+"Processor:"+EXTRACT(inputLine,"Processor:")+"</span></strong></p>");
                        resultsys += "[*][B]CPU[/B]: "+EXTRACT(inputLine,"Processor:") +"\n";
                        }
                        
                        if(inputLine.contains("Memory:")){
                            //System.out.println("RAM: "+EXTRACT(inputLine,"Memory:"));
                            //System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"Memory: "+EXTRACT(inputLine,"Memory:")+"</span></strong></p>");
                        resultsys +="[*][B]RAM[/B]: "+EXTRACT(inputLine,"Memory:") +"\n";
                        }
                        
                        if(inputLine.contains("Graphics:")){
                            //System.out.println("Graphics: "+EXTRACT(inputLine,"Graphics:"));
                            //System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"GPU: "+EXTRACT(inputLine,"Graphics:")+"</span></strong></p>");
                        resultsys +="[*][B]Graphics:[/B] "+EXTRACT(inputLine,"Graphics:") +"\n";
                        }
                        if(inputLine.contains("DirectX:")){
                            //System.out.println("Graphics: "+EXTRACT(inputLine,"Graphics:"));
                            //System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"GPU: "+EXTRACT(inputLine,"Graphics:")+"</span></strong></p>");
                        resultsys +="[*][B]DirectX:[/B] "+EXTRACT(inputLine,"DirectX:") +"\n";
                        }
                        
                        if(inputLine.contains("Hard Drive:") || inputLine.contains("Hard Disk Space:")){
                            //System.out.println("HDD: "+EXTRACT(inputLine,"Hard Drive:"));
                            //System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"HDD: "+EXTRACT(inputLine,"Hard Drive:")+"</span></strong></p>");
                        resultsys +="[*][B]HDD:[/B] "+EXTRACT(inputLine,"Hard Drive:")+"\n";  
                       
                        resultsys +="[/LIST][/LIST]" +"\n";
                        ++open;
                        if(open>2) break;
                        
                        }
 
                    }       } catch (IOException ex) {
                    Logger.getLogger(Dextorminator.class.getName()).log(Level.SEVERE, null, ex);
                }
                // END
                String dlcc;
                if(inputDLCname.getText().isEmpty()) dlcc ="";
                else
                dlcc = DLC(inputDLCname.getText(),inputDLCLink.getText());
             if(!addMEGASHARE){   
             output.setText(HeaderIMG(headerimg)+Screenshot(img[0],img[1],img[2])+SystemRequirement(resultsys)+Trailer(inputYOUTUBE.getText())+NormalDownload(inputFSHARE.getText(), input4SHARE.getText(), inputMEGA.getText(), inputTENLUA.getText())+dlcc+"\n"+"\n"+"\n"+Signature());
            }
            
                    else{
            output.setText(HeaderIMG(headerimg)+Screenshot(img[0],img[1],img[2])+SystemRequirement(resultsys)+Trailer(inputYOUTUBE.getText())+MEGADOWNLOAD(input_MEGASHARE.getText())+dlcc+"\n"+"\n"+"\n"+Signature());   
            }
            }
        });
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputSTEAM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbHEADER = new javax.swing.JCheckBox();
        inputHEADERIMG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputYOUTUBE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputFSHARE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        input4SHARE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputMEGA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputTENLUA = new javax.swing.JTextField();
        cbMEGASHARE = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        inputDLCname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_MEGASHARE = new javax.swing.JTextArea();
        btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        inputDLCLink = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("STEAM");

        jLabel3.setText("HEADER");

        cbHEADER.setText("Dùng ảnh HEADER ngoài");

        jLabel4.setText("YOUTUBE");

        jLabel5.setText("FSHARE");

        jLabel6.setText("4SHARE");

        jLabel7.setText("MEGA");

        jLabel8.setText("TENLUA");

        cbMEGASHARE.setText("Chế độ POST bài MEGASHARE");

        jLabel9.setText("DLC");

        jLabel10.setText("DÀNH CHO POST MEGASHARE");

        input_MEGASHARE.setColumns(20);
        input_MEGASHARE.setRows(5);
        jScrollPane2.setViewportView(input_MEGASHARE);

        btn.setText("GENERATE");

        output.setColumns(20);
        output.setRows(5);
        jScrollPane3.setViewportView(output);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputMEGA)
                                    .addComponent(inputFSHARE, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputTENLUA, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input4SHARE, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputDLCname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputDLCLink))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputSTEAM, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(inputHEADERIMG))
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbHEADER)
                                .addComponent(cbMEGASHARE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(inputYOUTUBE, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputSTEAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHEADER))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputHEADERIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMEGASHARE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputYOUTUBE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputFSHARE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(input4SHARE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(inputMEGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(inputTENLUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(inputDLCname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDLCLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dextorminator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dextorminator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dextorminator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dextorminator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dextorminator().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Dextorminator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn;
    private javax.swing.JCheckBox cbHEADER;
    private javax.swing.JCheckBox cbMEGASHARE;
    private javax.swing.JTextField input4SHARE;
    private javax.swing.JTextField inputDLCLink;
    private javax.swing.JTextField inputDLCname;
    private javax.swing.JTextField inputFSHARE;
    private javax.swing.JTextField inputHEADERIMG;
    private javax.swing.JTextField inputMEGA;
    private javax.swing.JTextField inputSTEAM;
    private javax.swing.JTextField inputTENLUA;
    private javax.swing.JTextField inputYOUTUBE;
    private javax.swing.JTextArea input_MEGASHARE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea output;
    // End of variables declaration                   
}
