package ui;

import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Objects;
import java.util.logging.Logger;

public class Añadir_usuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBoxPais;
    private JComboBox comboBoxPlataforma;
    private JTextField textField1;

    DefaultTableModel modeloañadir;

    private static Logger log = Logger.getLogger(Main.class.getName());


    public Añadir_usuario(DefaultTableModel modelo) {


        /**
         * Aqui creamos los diferentes campos y le añadimos los valores por defecto a los combobox
         * */
        modeloañadir = modelo;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
        setSize(400, 300);

        comboBoxPais.addItem("España");
        comboBoxPais.addItem("Italia");
        comboBoxPais.addItem("Francia");
        comboBoxPais.addItem("Alemania");


        comboBoxPlataforma.addItem("Windows");
        comboBoxPlataforma.addItem("MacOS");
        comboBoxPlataforma.addItem("Linux");



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Aqui al usar el boton okey creamos el usuario y seteamos los campos del usuario para liego añadirlo
     * */
    private void onOK() {
        Usuario usuario = new Usuario();
        usuario.setCorreo(textField1.getText());
        usuario.setPais(Objects.requireNonNull(comboBoxPais.getSelectedItem()).toString());
        usuario.setPlataforma(Objects.requireNonNull(comboBoxPlataforma.getSelectedItem()).toString());

        if (textField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el correo del usuario");
        } else {
            var fila =  new Object[]{ usuario.getCorreo(), usuario.getPais(),usuario.getPlataforma() };
            modeloañadir.addRow(fila);
            log.info("Usuario creado con exito: " + fila);
            dispose();
        }




    }
    /**
     * Aqui salimos del programa
     * */
    private void onCancel() {
        // add your code here if necessary
        dispose();

        log.info("Saliendo de la creacion de usuario");
    }

}
