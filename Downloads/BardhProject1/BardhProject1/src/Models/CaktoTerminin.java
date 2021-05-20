package Models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CaktoTerminin extends javax.swing.JFrame {

    private String emriTerminit;
    private String ditaTerminit;
    private ArrayList<ArrayList<String>> ListOfArrayLists = new ArrayList<ArrayList<String>>();
    private ArrayList<Boolean> weeklyList;

    public CaktoTerminin() {
        emriTerminit();
        initComponents();
    }

    public CaktoTerminin(String emriTerminit, String ditaTerminit, ArrayList<ArrayList<String>> ListOfArrayLists,
            ArrayList<Boolean> weeklyList) {
        this.ditaTerminit = ditaTerminit;
        this.ListOfArrayLists = ListOfArrayLists;
        this.weeklyList = weeklyList;
        emriTerminit();
        initComponents();

    }

    public CaktoTerminin(ArrayList<ArrayList<String>> ListOfArrayLists,
            ArrayList<Boolean> weeklyList) {
        this.ListOfArrayLists = ListOfArrayLists;
        this.weeklyList = weeklyList;
        emriTerminit();
        initComponents();
    }

    private void initComponents() {

        CaktoDiten = new java.awt.Choice();
        titulliDita = new javax.swing.JLabel();
        caktoDitenOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CaktoDiten.add("E hënë");
        CaktoDiten.add("E martë");
        CaktoDiten.add("E mërkurë");
        CaktoDiten.add("E enjte");
        CaktoDiten.add("E premte");
        CaktoDiten.add("E shtunë");
        CaktoDiten.add("E diel");

        titulliDita.setText("Caktoni Diten e Terminit:");

        caktoDitenOK.setText("OK");
        caktoDitenOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ditaTerminit = CaktoDiten.getSelectedItem();
                caktoDitenOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(55, 55, 55).addComponent(titulliDita)
                        .addContainerGap(64, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(CaktoDiten, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(caktoDitenOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap().addComponent(titulliDita).addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CaktoDiten, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(caktoDitenOK, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(14, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void caktoDitenOKActionPerformed(java.awt.event.ActionEvent evt) {
        CaktoOren obj = new CaktoOren(ditaTerminit, emriTerminit, ListOfArrayLists, weeklyList);

        this.dispose();
        obj.setVisible(true);

    }

    public void emriTerminit() {
        emriTerminit = JOptionPane.showInputDialog("Jepni emrin tuaj:");
    }

    public String getEmri() {
        return emriTerminit;
    }

    public String getDita() {
        return ditaTerminit;
    }
    
    private java.awt.Choice CaktoDiten;
    private javax.swing.JButton caktoDitenOK;
    private javax.swing.JLabel titulliDita;
    // End of variables declaration//GEN-END:variables
}
