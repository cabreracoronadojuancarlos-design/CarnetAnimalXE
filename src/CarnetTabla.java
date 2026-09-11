// Importa todas las clases de Swing.
import javax.swing.*;
// Importa clases de tablas (JTable usa modelos de datos de este paquete).
import javax.swing.table.DefaultTableModel;
// Importa clases de diseño.
import java.awt.*;
// Esta clase muestra una tabla con todos los animales registrados.
// Cada vez que se presiona "Enviar" en la Interfaz 1, se agrega una fila aquí.
public class CarnetTabla extends JFrame {
    /* :)
    _______________________________________________________________________________________
     JTable = Componente que muestra datos en filas y columnas.
     DefaultTableModel = El "modelo de datos" que controla qué hay en la tabla.
     La JTable muestra los datos, el DefaultTableModel los almacena.
    _______________________________________________________________________________________
    */
    // Nombres de las columnas de la tabla.
    // Cada String es el encabezado de una columna.
    String[] columnas = {
            "Nombre", "Especie", "Raza", "Edad",
            "Peso", "Color", "Sexo", "Chip"
    };
    // DefaultTableModel = Modelo de datos de la tabla.
    // El primer parámetro (null) indica que al inicio no hay filas (tabla vacía).
    // El segundo parámetro (columnas) define los nombres de las columnas.
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);
    // JTable = La tabla visual que el usuario ve en pantalla.
    // Recibe el "modelo" para saber qué datos mostrar.
    JTable tabla = new JTable(modelo);
    // Botón para cerrar esta ventana.
    JButton btnCerrar = new JButton("Cerrar");
    /* :)
    _______________________________________________________________________________________
     CONSTRUCTOR.
    _______________________________________________________________________________________
    */
    public CarnetTabla() {
        // Título de la ventana.
        setTitle("Registro de Animales");
        // Tamaño amplio para que la tabla se vea bien.
        setSize(800, 400);
        // Centra la ventana.
        setLocationRelativeTo(null);
        // Cierra solo esta ventana, no el programa.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        // BorderLayout = Organiza componentes en 5 zonas: NORTH, CENTER, SOUTH, EAST, WEST.
        // Usamos BorderLayout porque la tabla debe ocupar tod0 el centro.
        // y el botón va abajo (SOUTH).
        setLayout(new BorderLayout());
        //TITULO.
        // Etiqueta de título en la parte superior (NORTH).
        JLabel lblTitulo = new JLabel("Registro de Animales");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        // setBorder con EmptyBorder = Agrega espacio alrededor del componente.
        // (arriba, izquierda, abajo, derecha) en píxeles.
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        // add(componente, posición) = Agrega en una zona específica del BorderLayout.
        // BorderLayout.NORTH = Parte superior.
        add(lblTitulo, BorderLayout.NORTH);
        //TABLA.
        // JScrollPane envuelve la JTable para agregar scroll si hay muchas filas.
        // También muestra los encabezados de columna (sin JScrollPane no se ven).
        JScrollPane scrollTabla = new JScrollPane(tabla);
        // BorderLayout.CENTER = La tabla ocupa tod0 el espacio central disponible.
        add(scrollTabla, BorderLayout.CENTER);
        //PANEL INFERIOR CON BOTON.
        // JPanel = Contenedor que agrupa componentes.
        // Usamos un panel para poner el botón centrado en la parte inferior.
        JPanel panelInferior = new JPanel();
        // Agrega el botón al panel.
        panelInferior.add(btnCerrar);
        // Agrega el panel en la parte inferior (SOUTH).
        add(panelInferior, BorderLayout.SOUTH);
        // Acción del botón cerrar.
        btnCerrar.addActionListener(e -> {
            dispose(); // Cierra solo esta ventana
        });
    }
    // ============================================
    // METODO: agregarAnimal
    // Este método agrega UNA FILA nueva a la tabla
    // Se llama desde la Interfaz 1 cuando el usuario presiona "Enviar"
    // Recibe los datos como parámetros y los agrega como una nueva fila
    // ============================================
    /* :)
    _______________________________________________________________________________________
     METODO: agregarAnimal.
     Este métod0 agrega una FILA nueva a la tabla.
     Se llama desde la Interfaz 1 cuando el usuario presiona "Enviar",
     Recibe los datos como parámetros y los agrega como una nueva fila.
    _______________________________________________________________________________________
    */
    public void agregarAnimal(String nombre, String especie, String raza,
                              String edad, String peso, String color,
                              String sexo, String chip) {

        // Crea un arreglo con los datos de una fila.
        // El orden debe coincidir con el orden de las columnas.
        String[] fila = {nombre, especie, raza, edad, peso, color, sexo, chip};
        // addRow() = Agrega una nueva fila al modelo de datos.
        // La tabla se actualiza AUTOMATICAMENTE cuando se modifica el modelo.
        modelo.addRow(fila);
    }

} // :)