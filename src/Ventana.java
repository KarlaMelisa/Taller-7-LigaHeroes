import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel principal;
    private JList lstHeroes;
    private JButton btnMostrar;
    private JTextField txtNombre;
    private JComboBox cbSuper;
    private JTextField txtId;
    private JTextField txtSueldo;
    private JTextField txtMision;
    private JSpinner spDificultad;
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JButton btnGenerar;
    private JTextArea txtInformes;
    private JButton btnEditar;
    private JButton btnLimpiar2;
    private JTextField txtIdEditar;
    private JTextField txtNombreEditar;
    private JComboBox cbSuperEditar;
    private JTextField txtMisionEditar;
    private JSpinner spDificultadEditar;
    private JTextField txtSueldoEditar;
    private JLabel lblInformes;

    Liga liga = new Liga();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void limpiarAgregar() {
        txtNombre.setText("");
        txtId.setText("");
        txtSueldo.setText("");
        txtMision.setText("");
        cbSuper.setSelectedIndex(0);
        spDificultad.setValue(1);
    }

    public Ventana() {
        //MODELADO DE SPINNERS
        SpinnerNumberModel snm = new SpinnerNumberModel(1, 1, 5, 1);
        spDificultad.setModel(snm);
        spDificultadEditar.setModel(snm);

        //BOTON MOSTRAR HEROES DENTRO DE LISTADO
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm = new DefaultListModel();
                for (Heroe h : liga.getHeroes()) {
                    dlm.addElement(h);
                }
                lstHeroes.setModel(dlm);
            }
        });

        //BOTON AGREGAR HEROE
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                for (Heroe h : liga.getHeroes()) {
                    if (h.getId() == id) {
                        JOptionPane.showMessageDialog(null, "Ya existe un heroe con ese ID");
                        return;
                    } else if (id < 0 ) {
                        JOptionPane.showMessageDialog(null, "ID no valido");
                        return;
                    }
                }
                String nombre = txtNombre.getText();
                String superpoder = (String) cbSuper.getSelectedItem();
                String mision = txtMision.getText();
                int dificultad = (int) spDificultad.getValue();
                float sueldo = Float.parseFloat(txtSueldo.getText());
                if (nombre.isEmpty() || mision.isEmpty() || sueldo == 0) {
                    JOptionPane.showMessageDialog(null, "Error en los datos");
                    return;
                }
                Heroe h = new Heroe(id, nombre, superpoder, mision, dificultad, sueldo);
                liga.getHeroes().add(h);
                JOptionPane.showMessageDialog(null, "Heroe agregado");
                limpiarAgregar();
            }
        });

        //BOTON LIMPIAR
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarAgregar();
            }
        });

        //BOTON GENERAR INFORME
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Heroe h = (Heroe) lstHeroes.getSelectedValue();
                if (h == null) {
                    JOptionPane.showMessageDialog(null, "No hay heroe seleccionado");
                    return;
                }
                String informe = h.toString() + "\n Aporte al fondo de héroes: " + h.calcularAporte() +
                                                "\n Impuesto del gobierno mensual: " + h.calcularImpuesto() +
                                                "\n Sueldo mensual NETO " + h.calcularSueldoNeto();
                txtInformes.setText(informe);
                JOptionPane.showMessageDialog(null, "Informe generado\n Véase apartado INFORMES");
            }
        });

        //BOTON EDITAR
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Heroe h : liga.getHeroes()) {
                    if (h.getId() == Integer.parseInt(txtIdEditar.getText())) {
                        if (h.getNombre().isEmpty() || h.getMision().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Error en los datos");
                            return;
                        }
                        h.setNombre(txtNombreEditar.getText());
                        h.setSuperpoder((String) cbSuperEditar.getSelectedItem());
                        h.setMision(txtMisionEditar.getText());
                        h.setDificultad((int) spDificultadEditar.getValue());
                        h.setSueldo(Float.parseFloat(txtSueldoEditar.getText()));
                        JOptionPane.showMessageDialog(null, "Heroe editado");
                        return;
                    } else JOptionPane.showMessageDialog(null, "No existe un heroe con ese ID");
                }
            }
        });

        //BOTON LIMPIAR EN EDITAR
        btnLimpiar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombreEditar.setText("");
                txtIdEditar.setText("");
                txtSueldoEditar.setText("");
                txtMisionEditar.setText("");
                cbSuperEditar.setSelectedIndex(0);
                spDificultadEditar.setValue(1);
            }
        });
    }
}

