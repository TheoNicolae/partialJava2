/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Artisti;
import model.Melodii;
import model.Playlist;
import service.ArtistService;
import service.MelodiiService;
import service.PlaylistService;

/**
 *
 * @author user
 */
public class AfisareMelodiiFrame extends javax.swing.JFrame {

  
    private DefaultListModel<Melodii> model = new DefaultListModel<>();
    private Artisti artist;
    
    
    public AfisareMelodiiFrame(Artisti artist) {
        initComponents();
        this.artist = artist;
        this.jList1.setModel(model);
        this.afisare();
        
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    
    private void afisare(){
        
        this.model.clear();
        
        List<Playlist> melPlaylist = PlaylistService.getInstace().afisareMelByArtist(this.artist.getId());
        List<Melodii> melMelodii = null;
        for(int i = 0;i<melPlaylist.size();i++){
        
            Integer x = melPlaylist.get(i).getId();
            melMelodii = MelodiiService.getInstance().getMelodiiById(x);
            
            for(Melodii m:melMelodii)
                model.addElement(m);
           
            
        }
       
       
       }
            
    
    
//    0213051200
//    0750100101

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Melodii> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
