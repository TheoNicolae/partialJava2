/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import model.Artisti;
import model.Users;
import service.ArtistService;

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {

    private Users user;
    private DefaultListModel<Artisti> model = new DefaultListModel<>();
    private Artisti artistSelectat;
    
    public MainFrame(LoginFrame login, Users user) {
        initComponents();
        this.user = user;
        this.jList1.setModel(this.model);
        this.afisare();
        artistSelectat = this.jList1.getSelectedValue();
        
       this.jButton1.addActionListener(ev-> this.addArtist());
       
       this.jList1.addMouseListener(new MouseAdapter(){
       
           public void mouseClicked(MouseEvent e){
               
               if(e.getButton()== MouseEvent.BUTTON3){
               
                   showPopupMenu(e.getX(),e.getY());
                   
               }
           
           }
       
       });
       
       this.jMenuItem1.addActionListener(ev -> {
       
           System.exit(0);
       });
       
       
       this.jMenuItem2.addActionListener(ev->{
       
           this.user = null;
           this.setVisible(false);
           login.setVisible(true);
       
       });
       
       
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Nume Artist:");

        jButton1.setText("Adauga Artist");

        jMenu1.setText("File");

        jMenuItem1.setText("close");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("logout");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void afisare(){
        this.model.clear();
        List<Artisti> artisti = ArtistService.getInstance().getArtisti();
        for(Artisti a:artisti) this.model.addElement(a);
    }
    /**}
     *
     */
    public void addArtist(){
        String nume = jTextField1.getText();
        if(nume.length()>0){
        ArtistService.getInstance().adaugaArtist(nume);
        this.jTextField1.setText("");
        this.afisare();
        
        }
    }
    
    public void showPopupMenu(int x,int y){
       
        JPopupMenu popm = new JPopupMenu();
        JMenuItem mi1 = new JMenuItem("Afisare melodii");
        JMenuItem mi2 = new JMenuItem("Adaugare melodie");
        JMenuItem mi3 = new JMenuItem ("Sterge");
        
        mi1.addActionListener(ev->afisareMelodii());
        mi2.addActionListener(ev->adaugareMelodie());
        mi3.addActionListener(ev->sterge());
        
        popm.add(mi1);
        popm.add(mi2);
        popm.add(mi3);
        popm.show(this.jList1, x, y);
    
    }
    
    public void adaugareMelodie(){
        
        Artisti a = (Artisti)jList1.getSelectedValue();
        if(a!=null){
        
            new AdaugareMelodiiFrame().setVisible(true);
        }
    
    }
    
    public void afisareMelodii(){
          
        Artisti a = this.jList1.getSelectedValue();
      
        if(a!=null){
        
            new AfisareMelodiiFrame(a).setVisible(true);
            
        }
    
    }
    
    public void sterge(){
    
        Artisti a = this.jList1.getSelectedValue();
        if(a!= null){
            ArtistService.getInstance().removeArtist(a);
            afisare();
        }
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Artisti> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
