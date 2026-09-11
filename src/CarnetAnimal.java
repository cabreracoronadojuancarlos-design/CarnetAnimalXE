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
     REFERENCIA A LA INTERFAZ 3 (Tabla).
     Creamos una sola instancia de CarnetTabla que se reutiliza.
     Así todos los registros se acumulan en la misma tabla.
     Si creáramos una nueva cada vez, cada "Enviar" abriría una tabla vacía.
    _______________________________________________________________________________________
     */
    CarnetTabla tablaRegistros = new CarnetTabla();
    /* :)
    _______________________________________________________________________________________
    9.CONSTRUCTOR.
    _______________________________________________________________________________________
     */
    public CarnetAnimal() {
        /* :)
        _______________________________________________________________________________________
         1.CONFIGURACION DE LA VENTANA (JFrame).
        _______________________________________________________________________________________
        */
        // setTitle = Pone el título que aparece en la barra superior de la ventana.
        setTitle("Carnet de Vacunacion Animal");
        // setSize(ancho, alto) = Define el tamaño de la ventana en píxeles.
        setSize(700, 600);
        // setLocationRelativeTo(null) = Centra la ventana en la pantallA.
        setLocationRelativeTo(null);
        // setDefaultCloseOperation = Define qué pasa cuando el usuario cierra la ventana (la X).
        // EXIT_ON_CLOSE = Cierra la ventana Y termina el programa completamente.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false) = Impide que el usuario cambie el tamaño de la ventana.
        setResizable(false);
        // setLayout(null) = Desactiva el layout automático.
        // Esto nos permite colocar cada componente en una posición exacta con "setBounds()"
        // setBounds(x, y, ancho, alto). Lo usaremos para cada componente.
        setLayout(null);
         /* :)
        _______________________________________________________________________________________
         2.CONFIGURAR EL TITULO PRINCIPAL
        _______________________________________________________________________________________
        */
        // setBounds(x, y, ancho, alto) = Posiciona el componente en la ventana.
        // x = distancia desde la izquierda, y = distancia desde arriba.
        lblCva.setBounds(200, 10, 300, 30);
        // setFont = cambia la fuente del texto.
        // Font("Arial", Font.BOLD, 18) = fuente Arial, negrita, tamaño 18.
        lblCva.setFont(new Font("Arial", Font.BOLD, 18));
        // setHorizontalAlignment = Alinea el texto dentro de la etiqueta.
        // SwingConstants.CENTER = Centra el texto horizontalmente.
        lblCva.setHorizontalAlignment(SwingConstants.CENTER);
        // add() = Agrega el componente a la ventana.
        add(lblCva);
        /* :)
        _______________________________________________________________________________________
         3.CONFIGURAR LA IMAGEN (JLabel para mostrar foto).
        _______________________________________________________________________________________
        */
        // Posiciona el espacio de la imagen: Esquina superior izquierda, 150x150 píxeles.
        lblImg.setBounds(20, 50, 150, 150);
        // setBorder = Agrega un borde visible alrededor de la etiqueta.
        lblImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Centra la imagen dentro de la etiqueta (horizontal y verticalmente).
        lblImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg.setVerticalAlignment(SwingConstants.CENTER);
        // Agrega la etiqueta de imagen a la ventana.
        add(lblImg);
         /* :)
        _______________________________________________________________________________________
         4.BOTON CARGAR IMAGEN (usa JFileChooser).
        _______________________________________________________________________________________
        */
        // Posiciona el botón debajo del espacio de imagen.
        btnCargarImagen.setBounds(20, 210, 150, 30);
        // Agrega el botón a la ventana.
        add(btnCargarImagen);
         /* :)
        _______________________________________________________________________________________
         5.CAMPO: NOMBRE (Etiqueta + Caja de texto).
        _______________________________________________________________________________________
        */
        // Posiciona la etiqueta "Nombre:" Al lado derecho de la imagen.
        lblNombre.setBounds(200, 50, 80, 25);
        // Agrega la etiqueta a la ventana.
        add(lblNombre);
        // Posiciona la caja de texto al lado de su etiqueta.
        // El usuario escribirá aquí el nombre del animal.
        txtNombre.setBounds(290, 50, 180, 25);
        // Agrega la caja de texto a la ventana.
        add(txtNombre);
         /* :)
        _______________________________________________________________________________________
         6.CAMPO: ESPECIE (Etiqueta + ComboBox).
        _______________________________________________________________________________________
        */
        lblEspecie.setBounds(200, 90, 80, 25);
        add(lblEspecie);
        // Posiciona el ComboBox de especie.
        cmbEspecie.setBounds(290, 90, 180, 25);

        // addItem() = Agrega opciones al menú desplegable.
        // Cada addItem es una opción que el usuario podrá seleccionar.
        // Opción por defecto (El usuario elige).
        cmbEspecie.addItem("Seleccionar...");
        cmbEspecie.addItem("Perro");
        cmbEspecie.addItem("Gato");
        cmbEspecie.addItem("Conejo");
        cmbEspecie.addItem("Huron");
        cmbEspecie.addItem("Ave");
        cmbEspecie.addItem("Bovinos");
        cmbEspecie.addItem("Porcinos");
        cmbEspecie.addItem("Ovinos o Caprinos");
        cmbEspecie.addItem("Equinos");
        cmbEspecie.addItem("Otro...");
        // Agrega el ComboBox a la ventana.
        add(cmbEspecie);
        /* :)
        _______________________________________________________________________________________
         7.CAMPO: RAZA (Etiqueta + Caja de texto).
        _______________________________________________________________________________________
        */
        lblRaza.setBounds(200, 130, 80, 25);
        add(lblRaza);
        txtRaza.setBounds(290, 130, 180, 25);
        add(txtRaza);
         /* :)
        _______________________________________________________________________________________
         8.CAMPO: EDAD (Etiqueta + ComboBox).
        _______________________________________________________________________________________
        */
        lblEdad.setBounds(200, 170, 80, 25);
        add(lblEdad);
        cmbEdad.setBounds(290, 170, 180, 25);
        // Llena el ComboBox de edad con opciones del 1 al 50.
        // Usamos un ciclo for para no escribir 20 líneas de addItem.
        cmbEdad.addItem("Seleccionar...");
        for (int i = 1; i <= 50; i++) {
            // Cada iteración agrega "1 año", "2 años", etc.
            cmbEdad.addItem(i + (i == 1 ? " año" : " años"));
        }
        add(cmbEdad);
        /* :)
        _______________________________________________________________________________________
         9.CAMPO: PESO (Etiqueta + Caja de texto).
        _______________________________________________________________________________________
        */
        lblPeso.setBounds(200, 210, 80, 25);
        add(lblPeso);
        txtPeso.setBounds(290, 210, 180, 25);
        add(txtPeso);
        /* :)
        _______________________________________________________________________________________
         10.CAMPO: COLOR (Etiqueta + Caja de texto).
        _______________________________________________________________________________________
        */
        lblColor.setBounds(200, 250, 80, 25);
        add(lblColor);
        txtColor.setBounds(290, 250, 180, 25);
        add(txtColor);
        /* :)
        _______________________________________________________________________________________
         11.CAMPO: SEXO (Etiqueta + RadioButtons).
        _______________________________________________________________________________________
        */
        lblSexo.setBounds(200, 290, 80, 25);
        add(lblSexo);
        // Posiciona los radio buttons uno al lado del otro.
        rbMacho.setBounds(290, 290, 80, 25);
        rbHembra.setBounds(380, 290, 90, 25);
        // Se agrega a ambos a radio buttons al ButtonGroup para evitar que ambos se seleccionen.
        grupoSexo.add(rbMacho);
        grupoSexo.add(rbHembra);
        // Se agrega los radio buttons a la ventana, no con el grupo.
        // grupoSexo.add() = Lógica (solo uno seleccionado).
        // add() al JFrame = Visual (que se vean en pantalla).
        add(rbMacho);
        add(rbHembra);
        /* :)
        _______________________________________________________________________________________
         12.CAMPO: CHIP (Etiqueta + Caja de texto).
        _______________________________________________________________________________________
        */
        lblChip.setBounds(200, 330, 80, 25);
        add(lblChip);
        txtChip.setBounds(290, 330, 180, 25);
        add(txtChip);
        /* :)
        _______________________________________________________________________________________
         13.CAMPO: ANTECEDENTES (Etiqueta + TextArea con scroll).
        _______________________________________________________________________________________
        */
        lblAntecedentes.setBounds(200, 370, 100, 25);
        add(lblAntecedentes);
        // JScrollPane = Envuelve el JTextArea para agregarle barras de desplazamiento.
        JScrollPane scrollAntecedentes = new JScrollPane(txtAntecedentes);
        // Posiciona el área de texto con scroll.
        scrollAntecedentes.setBounds(310, 370, 160, 80);
        // setLineWrap(true) = Hace que el texto salte a la siguiente línea automáticamente.
        txtAntecedentes.setLineWrap(true);
        // setWrapStyleWord(true) = El salto de línea ocurre entre palabras, no a mitad de palabra.
        txtAntecedentes.setWrapStyleWord(true);
        // Agrega el ScrollPane (NO el JTextArea directamente) a la ventana.
        add(scrollAntecedentes);
         /* :)
        _______________________________________________________________________________________
         14.BOTONES DE ACCION (Enviar y Limpiar).
        _______________________________________________________________________________________
        */
        // Se Posiciona el botón "Enviar" en la parte inferior.
        btnEnviar.setBounds(200, 470, 120, 35);
        add(btnEnviar);
        // Se Posiciona el botón "Limpiar" al lado de "Enviar".
        btnLimpiar.setBounds(350, 470, 120, 35);
        add(btnLimpiar);
         /* :)
        _______________________________________________________________________________________
         15.ACCION DEL BOTON: CARGAR IMAGEN (JFileChooser).
        _______________________________________________________________________________________
        */
        // addActionListener = Le dice al botón que se ejecute.
        // e -> { } Es una "expresión lambda", una forma corta de escribir la acción.
        btnCargarImagen.addActionListener(e -> {
            // Configura el filtro del JFileChooser para que solo muestre archivos de imagen.
            // FileNameExtensionFilter("descripción", extensiones...).
            // Así el usuario no ve archivos .txt, .pdf, etc., solo imágenes.
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                    "Imágenes (jpg, png, gif)", "jpg", "jpeg", "png", "gif"
            );// :)
            // Se aplica el filtro al JFileChooser.
            fileChooser.setFileFilter(filtro);
            // showOpenDialog(this) = Abre la ventana del explorador de archivos.
            // "this" Significa que la ventana del explorador aparece centrada sobre nuestra ventana.
            // El resultado se guarda en "resultado" para saber qué hizo el usuario.
            int resultado = fileChooser.showOpenDialog(this);
            // JFileChooser.APPROVE_OPTION = El usuario seleccionó un archivo y presionó "Abrir".
            // Si el usuario presionó "Cancelar", NO entra a este if.
            if (resultado == JFileChooser.APPROVE_OPTION) {
                // getSelectedFile().getPath() = Obtiene la ruta completa del archivo seleccionado.
                String rutaImagen = fileChooser.getSelectedFile().getPath();
                // Crea un ImageIcon con la ruta del archivo seleccionado.
                // "ImageIcon" Carga la imagen en memoria para poder mostrarla.
                imagenAnimal = new ImageIcon(rutaImagen);
                // Redimensiona la imagen para que quepa en el espacio de 150x150 del lblImg.
                // getImage() = Obtiene la imagen Original.
                // getScaledInstance(ancho, alto, suavizado) = Le Modifica el tamaño.
                // Image.SCALE_SMOOTH = Usa suavizado para que no se vea pixelada.
                Image imagenEscalada = imagenAnimal.getImage().getScaledInstance(
                        150, 150, Image.SCALE_SMOOTH
                );// :)
                // setIcon() = Asigna La imagen redimensionada al JLabel.
                // Ahora lblImg muestra la foto del animal.
                lblImg.setIcon(new ImageIcon(imagenEscalada));
                // setText("") = Limpia cualquier texto que tuviera el JLabel.
                // Por si antes decía "Sin imagen" o algo así
                lblImg.setText("");
            }
        });
        /* :)
        _______________________________________________________________________________________
         16.ACCION DEL BOTON: ENVIAR.
        _______________________________________________________________________________________
         */
         /* :)
        _______________________________________________________________________________________
         ACCION DEL BOTON: ENVIAR (abre Interfaz 2 + agrega a Interfaz 3).
        _______________________________________________________________________________________
         */
    btnEnviar.addActionListener(e -> {
        //VALIDACION.
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingresa el nombre del animal",
                "Campo requerido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        //OBTENER DATOS.
        String nombre = txtNombre.getText().trim();
        String especie = cmbEspecie.getSelectedItem().toString();
        String raza = txtRaza.getText().trim();
        String edad = cmbEdad.getSelectedItem().toString();
        String peso = txtPeso.getText().trim();
        String color = txtColor.getText().trim();
        String sexo = "";
        if (rbMacho.isSelected()) {
            sexo = "Macho";
        } else if (rbHembra.isSelected()) {
            sexo = "Hembra";
        } else {
            sexo = "No especificado";
        }
        String chip = txtChip.getText().trim();
        String antecedentes = txtAntecedentes.getText().trim();
        //ABRIR INTERFAZ 2 (Vista del Carnet).
        CarnetVista vista = new CarnetVista(
            nombre, especie, raza, edad, peso, color,
            sexo, chip, antecedentes, imagenAnimal
        );
        vista.setVisible(true);
        //AGREGAR A LA INTERFAZ 3 (Tabla de registros).
        // Llama al métod0 agregarAnimal() de la tabla.
        // Esto agrega una nueva FILA con los datos del animal.
        tablaRegistros.agregarAnimal(
            nombre, especie, raza, edad, peso, color, sexo, chip
        );
        // Hace visible la tabla (si ya está visible, no pasa nada).
        tablaRegistros.setVisible(true);
        // Muestra mensaje de confirmación.
        JOptionPane.showMessageDialog(this,
            "Animal '" + nombre + "' registrado exitosamente",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);
    });
        /*
        _______________________________________________________________________________________
         17.ACCION DEL BOTON: LIMPIAR.
        _______________________________________________________________________________________
        */
        btnLimpiar.addActionListener(e -> {
            // setText("") = Pone texto vacío, "BORRA".
            txtNombre.setText("");
            txtRaza.setText("");
            txtPeso.setText("");
            txtColor.setText("");
            txtChip.setText("");
            txtAntecedentes.setText("");
            // setSelectedIndex(0) = Selecciona la primera opción del ComboBox ("Seleccionar...").
            // Esto "reinicia" el ComboBox a su estado inicial.
            cmbEspecie.setSelectedIndex(0);
            cmbEdad.setSelectedIndex(0);
            // clearSelection() = Deselecciona todos los radio buttons del grupo.
            // Esto quita la selección de Macho y Hembra.
            grupoSexo.clearSelection();
            // setIcon(null) = Quita la imagen del JLabel.
            // null significa "nada", es decir, borra la imagen.
            lblImg.setIcon(null);
            // Pone el cursor en el primer campo para que el usuario empiece de nuevo.
            // requestFocus() = Pone el "foco" (cursor parpadeante) en esa caja de texto.
            txtNombre.requestFocus();
        });
    } // Fin del constructor. :)
    public static void main(String[] args) {
        CarnetAnimal ventana = new CarnetAnimal();
        // Hace visible la ventana (sin esto, la ventana existe pero no se muestra). :)
        ventana.setVisible(true);
    }
}