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

public class ShfaqTerminin extends javax.swing.JFrame {

    private JFrame frame;
    private ArrayList<String> emriList = new ArrayList<String>();
    private ArrayList<String> ditaList = new ArrayList<String>();
    ;
	private ArrayList<String> oraList = new ArrayList<String>();
    ;
	private ArrayList<Boolean> weeklyList = new ArrayList<Boolean>();
    ;
	private ArrayList<ArrayList<String>> ListOfArrayLists = new ArrayList<ArrayList<String>>();
    private String emri;
    private JTable table;
    private String ditaTerminit;
    private static boolean contain = false;

    public static void main(String args[]) {
        if (contain == false) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ShfaqTerminin();
                }
            });
        }
    }

    public ShfaqTerminin() {

        this.emriList.add("");
        this.ditaList.add("");
        this.oraList.add("");
        this.weeklyList.add(true);

        initialize();
    }

    public ShfaqTerminin(ArrayList<String> emri, ArrayList<String> dita, ArrayList<String> ora,
            ArrayList<Boolean> weekly, String emriTermin) {

        this.emriList = emri;
        this.ditaList = dita;
        this.oraList = ora;
        this.weeklyList = weekly;

        this.emri = emriTermin;
        contain = true;
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

        tableModel.addRow(col);
        for (int i = 0; i < emriList.size(); i++) {
            if (contain == true) {
                if (i != 0) {
                    Object[] data = {i, emriList.get(i), ditaList.get(i), oraList.get(i), weeklyList.get(i)};
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
                        frame.dispose();
                        ShfaqTerminin terminDel = new ShfaqTerminin(emriList, ditaList, oraList, weeklyList, emri);

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

        JButton btnNewButton_2 = new JButton("Shiko terminet ditore");

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"E hënë", "E martë", "E mërkurë", "E enjte", "E premte", "E shtunë",
                    "E diel"};
                // ...and passing `frame` instead of `null` as first parameter
                Object selectionObject = JOptionPane.showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
                String selectionString = selectionObject.toString();
                ListOfArrayLists.add(emriList);
                ListOfArrayLists.add(ditaList);
                ListOfArrayLists.add(oraList);
                if (selectionString != null) {
                    ShfaqTermininDitor terminiDitor = new ShfaqTermininDitor(ListOfArrayLists, weeklyList,
                            selectionString);
                    frame.dispose();
                }

            }

        });
        panel_2.add(btnNewButton_2);
        frame.repaint();
        frame.setVisible(true);

    }

}
