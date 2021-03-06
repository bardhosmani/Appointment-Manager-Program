package Models;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import Cotrollers.StoreCheckAppointment;
import Views.ShfaqTerminin;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CaktoOren extends javax.swing.JFrame {
    
    private java.awt.Choice CaktoOrenChoice;
    private javax.swing.JButton caktoOrenOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JCheckBox poJavor;
    private final Action action = new SwingAction();
    private StoreCheckAppointment obj = new StoreCheckAppointment();
    private String oraTerminit;
    private boolean weekly;
    private String termin;
    private String emriTermin;
    private ArrayList<ArrayList<String>> ListOfArrayLists = new ArrayList<ArrayList<String>>();
    public ArrayList<Boolean> weeklyList;

    public CaktoOren() {
        getOra();
        getWeekly();
        initComponents();
    }

    public CaktoOren(String termin,
            String emriTermin, ArrayList<ArrayList<String>> ListOfArrayLists, ArrayList<Boolean> weeklyList) {
        getOra();
        getWeekly();
        initComponents();

        this.emriTermin = emriTermin;
        this.termin = termin;
        this.ListOfArrayLists = ListOfArrayLists;
        this.weeklyList = weeklyList;
    }

//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CaktoOrenChoice = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        poJavor = new javax.swing.JCheckBox();
        caktoOrenOK = new javax.swing.JButton();
        caktoOrenOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oraTerminit = CaktoOrenChoice.getSelectedItem();

                if (ListOfArrayLists.size() > 0) {
                    obj.setEmriTerminiList(ListOfArrayLists.get(0));
                    obj.setDitaTerminiList(ListOfArrayLists.get(1));
                    obj.setOraTerminiList(ListOfArrayLists.get(2));
                    obj.setWeeklyTermini(weeklyList);
                }

                obj.setEmriTermini(emriTermin);
                obj.setDitaTermini(termin);
                obj.setOraTermini(oraTerminit);
                obj.setWeeklyTermini(weekly);
                boolean isValid = obj.isValidTermin(termin, oraTerminit);
                if (isValid) {
                    obj.termini();

                    new ShfaqTerminin(obj.getEmriTermini(), obj.getDitaTermini(),
                            obj.getOraTermini(), obj.getWeeklyTermini(), emriTermin);
                    dispose();

                    ListOfArrayLists.add(obj.getEmriTermini());
                    ListOfArrayLists.add(obj.getDitaTermini());
                    ListOfArrayLists.add(obj.getOraTermini());
                    weeklyList = obj.getWeeklyTermini();

                    JOptionPane.showMessageDialog(null, "Termini eshte caktuar, loje te kendeshme!", "",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Ka termin te caktuar ne kete interval kohor", "",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        caktoOrenOK.setAction(action);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cakto or??n e terminit:");

        CaktoOrenChoice.add("10:00 - 11:00");
        CaktoOrenChoice.add("11:00 - 12:00");
        CaktoOrenChoice.add("12:00 - 13:00");
        CaktoOrenChoice.add("13:00 - 14:00");
        CaktoOrenChoice.add("14:00 - 15:00");
        CaktoOrenChoice.add("15:00 - 16:00");
        CaktoOrenChoice.add("16:00 - 17:00");
        CaktoOrenChoice.add("17:00 - 18:00");
        CaktoOrenChoice.add("18:00 - 19:00");
        CaktoOrenChoice.add("19:00 - 20:00");
        CaktoOrenChoice.add("20:00 - 21:00");
        CaktoOrenChoice.add("21:00 - 22:00");
        CaktoOrenChoice.add("22:00 - 23:00");

        jLabel2.setText("D??shironi t?? leni terminin javor?");

        poJavor.setText("Po");
        poJavor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poJavorActionPerformed(evt);
            }
        });

        caktoOrenOK.setText("OK");

        JButton Back = new JButton();
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CaktoTerminin info1 = new CaktoTerminin(emriTermin, termin, ListOfArrayLists, weeklyList);
                info1.setVisible(true);

            }
        });
        Back.setAutoscrolls(true);
        Back.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(21)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(CaktoOrenChoice, GroupLayout.PREFERRED_SIZE, 178,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup().addGap(10).addComponent(jLabel2))))
                        .addGroup(layout.createSequentialGroup().addGap(51).addComponent(jLabel1)))
                        .addContainerGap(22, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addGap(0, 71, Short.MAX_VALUE)
                        .addComponent(poJavor, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE).addGap(63))
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(Back, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(caktoOrenOK, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(CaktoOrenChoice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel2)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(poJavor)
                        .addPreferredGap(ComponentPlacement.RELATED).addGroup(layout
                        .createParallelGroup(Alignment.BASELINE).addComponent(caktoOrenOK).addComponent(Back))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void poJavorActionPerformed(java.awt.event.ActionEvent evt) {

        if (poJavor.isSelected()) {
            weekly = true;
        } else {
            weekly = false;
        }

    }

    public String getOra() {
        return oraTerminit;
    }

    public boolean getWeekly() {
        return weekly;
    }

    private class SwingAction extends AbstractAction {

        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {
        }
    }
}
