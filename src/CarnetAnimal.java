// Esta línea importa TODAS las clases de Swing (JFrame, JLabel, JButton, etc.).
import javax.swing.*;
// Importa clases para manejar diseños y colores (layouts, fuentes, dimensiones).
import java.awt.*;
// Importa las clases para manejar EVENTOS (clics de botón, selección, etc.).
import java.awt.event.*;
// Importa el filtro de extensiones para el JFileChooser.
import javax.swing.filechooser.FileNameExtensionFilter;
/*
"public class" = la clase es pública, cualquiera puede acceder a ella.
"CarnetAnimal" = Nombre de nuestra clase.
"extends JFrame" = Nuestra clase Hereda de JFrame.
:)
*/
public class CarnetAnimal extends JFrame {
    /*
    _______________________________________________________________________________________
    1. ETIQUETAS (JLabel)
    JLabel = Componente que muestra texto estático (el usuario NO puede editarlo).
    Sintaxis: New JLabel("texto que quieres mostrar") :)
    _______________________________________________________________________________________
     */
    // Etiqueta principal: Muestra el título en la ventana.
    JLabel lblCva = new JLabel("Carnet de Vacunacion Animal");
    // Etiqueta vacía: Aquí se mostrará la IMAGEN del animal que el usuario cargue.:)
    // Está vacía porque la imagen se asignará después.
    JLabel lblImg = new JLabel();
    // Cada una de estas etiquetas es el Nombre del campo que va al lado de su caja de texto.
    JLabel lblNombre = new JLabel("Nombre:");
    JLabel lblEspecie = new JLabel("Especie:");
    JLabel lblRaza = new JLabel("Raza:");
    JLabel lblEdad = new JLabel("Edad:");
    JLabel lblPeso = new JLabel("Peso:");
    JLabel lblColor = new JLabel("Color:");
    JLabel lblSexo = new JLabel("Sexo:");
    JLabel lblChip = new JLabel("Chip:");
    JLabel lblAntecedentes = new JLabel("Antecedentes:");
    /* ;)
     _______________________________________________________________________________________
      2. CAJAS DE TEXTO (JTextField).
      JTextField = Caja donde el usuario puede escribir texto (una sola línea).
      Se usa para capturar datos como nombre, peso, color, etc.
      Para obtener lo que el usuario escribio, "txtNombre.getText()"
      Para poner texto desde el código, "txtNombre.setText("Hola.:)")"
      _______________________________________________________________________________________
    */
    // 1.Caja de texto para que el usuario escriba el nombre del animal.
    JTextField txtNombre = new JTextField();
    // 2.Caja de texto para la raza del animal.
    JTextField txtRaza = new JTextField();
    // 3.Caja de texto para el peso del animal.
    JTextField txtPeso = new JTextField();
    // 4.Caja de texto para el color del animal.
    JTextField txtColor = new JTextField();
    // 5.Caja de texto para el número de chip del animal.
    JTextField txtChip = new JTextField();
    /* :)
    _______________________________________________________________________________________
     3. MENU DESPLEGABLE (JComboBox).
     JComboBox = lista desplegable donde el usuario selecciona una opción.
     String> indica que las opciones son de tipo "Texto".
     Para agregar opciones, "cmbEspecie.addItem("Perro")".
     Para obtener la opción seleccionada, "cmbEspecie.getSelectedItem().toString()".
    _______________________________________________________________________________________
     */
    // ComboBox para seleccionar la especie (Perro, Gato, etc.)
    // Se llenará con opciones en el constructor usando "addItem()"
    JComboBox<String> cmbEspecie = new JComboBox<>();
    // ComboBox para seleccionar la edad (1, 2, 3...50).
    JComboBox<String> cmbEdad = new JComboBox<>();
    /* :)
    _______________________________________________________________________________________
     4. RADIO BOTON (JRadioButton).
     JRadioButton = Botón circular donde solo puedes elegir una opción.
     Se usa para opciones excluyentes.
     ButtonGroup = Agrupa los radio buttons para que solo uno pueda estar seleccionado.
    _______________________________________________________________________________________
     */
    // 1.Radio botón para la opción "Macho".
    JRadioButton rbMacho = new JRadioButton("Macho");
    // 2.Radio botón para la opción "Hembra".
    JRadioButton rbHembra = new JRadioButton("Hembra");
    // ButtonGroup: agrupa rbMacho y rbHembra para que solo uno pueda estar activo.
    ButtonGroup grupoSexo = new ButtonGroup();
    /* :)
    _______________________________________________________________________________________
     5. AREA DE TEXTO (JTextArea).
     JTextArea = área grande donde el usuario puede escribir Multiples lineas.
     Para obtener el texto, "txtAntecedentes.getText()".
     Para poner texto, "txtAntecedentes.setText("algo")".
    _______________________________________________________________________________________
     */
    // Área de texto para que el usuario escriba los antecedentes médicos del animal.
    JTextArea txtAntecedentes = new JTextArea();
    /* :)
    _______________________________________________________________________________________
     6. BOTONES (JButton).
     JButton = Botón que el usuario puede presionar para ejecutar una acción.
    _______________________________________________________________________________________
     */
    // Botón para abrir el JFileChooser y seleccionar una imagen del animal.
    JButton btnCargarImagen = new JButton("Cargar Imagen");
    // Botón para enviar/guardar todos los datos del formulario.
    JButton btnEnviar = new JButton("Enviar");
    // Botón para limpiar todos los campos del formulario y empezar de nuevo.
    JButton btnLimpiar = new JButton("Limpiar");
    /* :)
    _______________________________________________________________________________________
     7. IMAGEN (ImageIcon).
     ImageIcon = Clase que permite cargar y mostrar imágenes (.jpg, .png).
     Se usa junto con JLabel, "lblImg.setIcon(imagenAnimal)".
     La imagen se cargará cuando el usuario seleccione un archivo con JFileChooser.
    _______________________________________________________________________________________
     */
    // Variable que guardará la imagen seleccionada por el usuario.
    ImageIcon imagenAnimal;
    /* :)
    _______________________________________________________________________________________
     8. JFileChooser.
     JFileChooser = Ventana emergente que permite al usuario buscar y seleccionar
     un archivo de su computadora.
    _______________________________________________________________________________________
     */
    // Selector de archivos: Abrirá una ventana para navegar carpetas y elegir un archivo.
    JFileChooser fileChooser = new JFileChooser();
    /* :)
    _______________________________________________________________________________________
    9.CONSTRUCTOR.
    Aun no hay, jijiji. :)
    _______________________________________________________________________________________
     */
    public CarnetAnimal() {
        /*
        Aquí configuraremos el tamaño, layout y agregaremos componentes.
        */
    }
    public static void main(String[] args) {
        CarnetAnimal ventana = new CarnetAnimal();
        // Hace visible la ventana (sin esto, la ventana existe pero no se muestra). :)
        ventana.setVisible(true);
    }
}