package Views;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import Models.CaktoTerminin;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShfaqTermininDitor extends javax.swing.JFrame {

    private JFrame frame;
    private ArrayList<String> emriList;
    private ArrayList<String> ditaList;
    private ArrayList<String> oraList;
    private ArrayList<Boolean> weeklyList;
    private ArrayList<ArrayList<String>> ListOfArrayLists = new ArrayList<ArrayList<String>>();
    private String emri;
    public String CaktoDiten;
    private JTable table;

    public ShfaqTermininDitor() {
        initialize();
    }

    public ShfaqTermininDitor(ArrayList<ArrayList<String>> ListOfArrayLists, ArrayList<Boolean> weeklyList, String caktoDiten) {
        this.ListOfArrayLists = ListOfArrayLists;
        this.weeklyList = weeklyList;
        this.CaktoDiten = caktoDiten;
        initialize();
    }

    public ShfaqTermininDitor(ArrayList<String> emri, ArrayList<String> dita, ArrayList<String> ora,
            ArrayList<Boolean> weekly, String emriTermin) {

        this.emriList = emri;
        this.ditaList = dita;
        this.oraList = ora;
        this.weeklyList = weekly;

        this.emri = emriTermin;

        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setSize(700, 500);
        // frame.setBounds(100, 100, 450, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Lista e Termineve");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        panel_1.add(lblNewLabel);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        String[] col = {"Id", "Emri", "Dita", "Ora", "Weekly"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        // The 0 argument is number rows.

        JTable table = new JTable(tableModel);
        // table.setCellRenderer(new RowHeaderRenderer(col));
        tableModel.addRow(col);
        for (int i = 0; i < ListOfArrayLists.get(0).size(); i++) {

            if (ListOfArrayLists.get(1).get(i).contains(CaktoDiten)) {
                if (i != 0) {
                    Object[] data = {i, ListOfArrayLists.get(0).get(i), ListOfArrayLists.get(1).get(i), ListOfArrayLists.get(2).get(i), weeklyList.get(i)};
                    tableModel.addRow(data);
                }
            }
        }
        panel.add(table);

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("New Termin");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListOfArrayLists.add(emriList);
                ListOfArrayLists.add(ditaList);
                ListOfArrayLists.add(oraList);
                frame.dispose();
                CaktoTerminin info = new CaktoTerminin(ListOfArrayLists, weeklyList);
                info.setVisible(true);

            }
        });

        JButton btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int numri = Integer.parseInt(JOptionPane.showInputDialog("Shenoni id e terminit:"));
                    if (numri <= emriList.size()) {
                        emriList.remove(numri);
                        ditaList.remove(numri);
                        oraList.remove(numri);
                        weeklyList.remove(numri);
                        ShfaqTermininDitor terminDel = new ShfaqTermininDitor(emriList, ditaList, oraList, weeklyList, emri);
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Nuk keni termin me ate id");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Sheno numerin e id-se!");
                }

            }
        });
        panel_2.add(btnNewButton_1);
        panel_2.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Back");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShfaqTerminin info = new ShfaqTerminin(ListOfArrayLists.get(0), ListOfArrayLists.get(1), ListOfArrayLists.get(2), weeklyList, "");
                frame.dispose();

            }

        });
        panel_2.add(btnNewButton_2);

        frame.setVisible(true);

    }

}
