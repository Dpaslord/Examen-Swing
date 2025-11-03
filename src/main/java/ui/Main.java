package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;



/**
 * La clase {@code Main} representa la ventana principal de la aplicación de gestión de usuarios.
 * Contiene una tabla para visualizar usuarios y botones para añadir nuevos registros o salir del programa.
 *
 * <p>La interfaz gráfica se construye utilizando Swing, y se configura con un modelo de tabla
 * que incluye las columnas: Correo, País y Plataforma.</p>
 *
 * <p>Los eventos de los botones están gestionados mediante {@link ActionListener}.</p>
 *
 * @author David Pascual Lorenzo
 */

public class Main extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton BotonAñadir;
    private JButton BotonSalir;

    private static Logger log = Logger.getLogger(Main.class.getName());



    public Main() {

        /**
         * Aqui se esta contruyendo el main con su tabla , modelo y botones
         * */
        this.setTitle("Tabla de usuarios");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);

        log.info("Construyendo tabla de usuarios");

        if (table1 == null) {
            table1 = new JTable();
            panel1.setLayout(new BorderLayout());
            panel1.add(new JScrollPane(table1), BorderLayout.CENTER);
        }

        log.info("Construyendo columnas de la tabla de usuarios");
        var modelo = new DefaultTableModel();
        modelo.addColumn("Correo");
        modelo.addColumn("Pais");
        modelo.addColumn("Plataforma");
        table1.setModel(modelo);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        log.info("Programa listo para funcionar");



        /**
         * Aqui usamos el boton añadir para abrir el dialog de añadir_usuario y añadimos el usuario a la tabla
         * */
        BotonAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Añadir_usuario au = new Añadir_usuario(modelo);
                au.setLocationRelativeTo(null);
                au.setVisible(true);
            }
        });
        /**
         * Aqui usamos el boton salir para finalizar el program
         * */
        BotonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("Saliendo del programa");
                dispose();
                log.info("Salida del programa exitosa");
            }
        });
    }
    /**
     * Aqui este metodo para arrancar el main y que sea visible
     * */
    public void start(){
        setVisible(true);
        log.info("Creando main");
    }
}
