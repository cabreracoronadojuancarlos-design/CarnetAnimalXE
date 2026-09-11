// Importa todas las clases de Swing (JFrame, JLabel, etc.).
import javax.swing.*;
// Importa clases para fuentes, colores y dimensiones.
import java.awt.*;
// "CarnetVista" = La ventana que muestra los datos del animal (solo lectura).
// "extends JFrame" = Esta clase también es una ventana.
public class CarnetVista extends JFrame {
    /* :)
    _______________________________________________________________________________________
     1.ETIQUETAS DE TITULO (texto fijo, nombres de campo).
    _______________________________________________________________________________________
     */
    // Título principal de la ventana de visualización.
    JLabel lblTitulo = new JLabel("Carnet del Animal");
    // Etiqueta fija que dice "Nombre:" (no cambia).
    JLabel lblTituloNombre = new JLabel("Nombre:");
    // Etiqueta fija que dice "Especie:" (no cambia).
    JLabel lblTituloEspecie = new JLabel("Especie:");
    JLabel lblTituloRaza = new JLabel("Raza:");
    JLabel lblTituloEdad = new JLabel("Edad:");
    JLabel lblTituloPeso = new JLabel("Peso:");
    JLabel lblTituloColor = new JLabel("Color:");
    JLabel lblTituloSexo = new JLabel("Sexo:");
    JLabel lblTituloChip = new JLabel("Chip:");
    JLabel lblTituloAntecedentes = new JLabel("Antecedentes:");
     /* :)
    _______________________________________________________________________________________
      2.ETIQUETAS DE DATOS (texto dinámico, muestra lo que el usuario escribió).
      Estas etiquetas se llenan con setText() cuando se abre la ventana.
      Empiezan vacías y se llenan con los datos del formulario.
    _______________________________________________________________________________________
     */
    // Aquí se mostrará el nombre que el usuario escribió.
    JLabel lblDatoNombre = new JLabel();
    // Aquí se mostrará la especie seleccionada.
    JLabel lblDatoEspecie = new JLabel();
    JLabel lblDatoRaza = new JLabel();
    JLabel lblDatoEdad = new JLabel();
    JLabel lblDatoPeso = new JLabel();
    JLabel lblDatoColor = new JLabel();
    JLabel lblDatoSexo = new JLabel();
    JLabel lblDatoChip = new JLabel();
    // Para antecedentes usamos JTextArea porque puede ser texto largo.
    // Pero lo hacemos NO editable para que solo se pueda leer.
    JTextArea txtDatoAntecedentes = new JTextArea();
    // Etiqueta para mostrar la imagen del animal.
    JLabel lblImagen = new JLabel();
    // Botón para cerrar esta ventana y regresar al formulario.
    JButton btnCerrar = new JButton("Cerrar");
    /* :)
    _______________________________________________________________________________________
     CONSTRUCTOR.
     Recibe TODOS los datos como parámetros (los que vienen del formulario).
     Así la Interfaz 1 le "pasa" los datos a la Interfaz 2.
    _______________________________________________________________________________________
     */
    public CarnetVista(String nombre, String especie, String raza,
                       String edad, String peso, String color,
                       String sexo, String chip, String antecedentes,
                       ImageIcon imagen) {
        //CONFIGURACION DE LA VENTANA.
        // Título de la barra superior de esta ventana.
        setTitle("Vista del Carnet - " + nombre);
        // Tamaño de la ventana: 500 de ancho x 550 de alto.
        setSize(500, 550);
        // Centra la ventana en la pantalla.
        setLocationRelativeTo(null);
        /* :)
        _______________________________________________________________________________________
         DISPOSE_ON_CLOSE = Cierra solo esta ventana, no tod0 el programa.
         A diferencia de EXIT_ON_CLOSE que cierra tod0.
         Usamos "DISPOSE" porque queremos que la Interfaz 1 siga abierta.
        _______________________________________________________________________________________
        */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // No se puede redimensionar.
        setResizable(false);
        // Layout nulo para posicionar manualmente.
        setLayout(null);
        //TITULO PRINCIPAL.
        lblTitulo.setBounds(100, 10, 300, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);
        //IMAGEN DEL ANIMAL.
        lblImagen.setBounds(170, 50, 150, 150);
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        // Si el usuario cargó una imagen, la muestra redimensionada.
        // Si no cargó imagen, muestra el texto "Sin imagen".
        if (imagen != null) {
            // Redimensiona la imagen para que quepa en 150x150.
            Image imgEscalada = imagen.getImage().getScaledInstance(
                    150, 150, Image.SCALE_SMOOTH
            );
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        } else {
            // Si no hay imagen, muestra un texto indicándolo.
            lblImagen.setText("Sin imagen");
        }
        add(lblImagen);
        /* :)
        _______________________________________________________________________________________
         3.MOSTRAR LOS DATOS CON setText().
         Los datos que llegaron como parámetros se muestran en las etiquetas
         setText() = "introduce" información en la etiqueta.
        _______________________________________________________________________________________
        */
        // Posición Y donde empiezan los campos.
        int yInicio = 220;
        // Espacio vertical entre cada campo.
        int separacion = 30;
        //NOMBRE.
        lblTituloNombre.setBounds(30, yInicio, 120, 25);
        // setFont con BOLD para que el título del campo resalte.
        lblTituloNombre.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloNombre);
        // setText(nombre) = Pone el valor que vino del formulario.
        // "nombre" es el parámetro que recibimos del constructor.
        lblDatoNombre.setText(nombre);
        lblDatoNombre.setBounds(160, yInicio, 300, 25);
        add(lblDatoNombre);
        //ESPECIE.
        lblTituloEspecie.setBounds(30, yInicio + separacion, 120, 25);
        lblTituloEspecie.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloEspecie);
        lblDatoEspecie.setText(especie); // Muestra la especie seleccionada
        lblDatoEspecie.setBounds(160, yInicio + separacion, 300, 25);
        add(lblDatoEspecie);
        //RAZA.
        lblTituloRaza.setBounds(30, yInicio + separacion * 2, 120, 25);
        lblTituloRaza.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloRaza);
        lblDatoRaza.setText(raza);
        lblDatoRaza.setBounds(160, yInicio + separacion * 2, 300, 25);
        add(lblDatoRaza);
        //EDAD.
        lblTituloEdad.setBounds(30, yInicio + separacion * 3, 120, 25);
        lblTituloEdad.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloEdad);
        lblDatoEdad.setText(edad);
        lblDatoEdad.setBounds(160, yInicio + separacion * 3, 300, 25);
        add(lblDatoEdad);
        //PESO.
        lblTituloPeso.setBounds(30, yInicio + separacion * 4, 120, 25);
        lblTituloPeso.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloPeso);
        lblDatoPeso.setText(peso);
        lblDatoPeso.setBounds(160, yInicio + separacion * 4, 300, 25);
        add(lblDatoPeso);
        //COLOR.
        lblTituloColor.setBounds(30, yInicio + separacion * 5, 120, 25);
        lblTituloColor.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloColor);
        lblDatoColor.setText(color);
        lblDatoColor.setBounds(160, yInicio + separacion * 5, 300, 25);
        add(lblDatoColor);
        //SEXO.
        lblTituloSexo.setBounds(30, yInicio + separacion * 6, 120, 25);
        lblTituloSexo.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloSexo);
        lblDatoSexo.setText(sexo);
        lblDatoSexo.setBounds(160, yInicio + separacion * 6, 300, 25);
        add(lblDatoSexo);
        //CHIP.
        lblTituloChip.setBounds(30, yInicio + separacion * 7, 120, 25);
        lblTituloChip.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloChip);
        lblDatoChip.setText(chip);
        lblDatoChip.setBounds(160, yInicio + separacion * 7, 300, 25);
        add(lblDatoChip);
        //ANTECEDENTES.
        lblTituloAntecedentes.setBounds(30, yInicio + separacion * 8, 120, 25);
        lblTituloAntecedentes.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblTituloAntecedentes);
        // setText(antecedentes) = Muestra los antecedentes escritos por el usuario.
        txtDatoAntecedentes.setText(antecedentes);
        // setEditable(false) = El usuario NO puede modificar el texto en esta ventana.
        // Solo puede LEERLO, no editarlo (es una vista, no un formulario).
        txtDatoAntecedentes.setEditable(false);
        // Configura el salto de línea automático.
        txtDatoAntecedentes.setLineWrap(true);
        txtDatoAntecedentes.setWrapStyleWord(true);
        // Fondo gris claro para indicar visualmente que no es editable.
        txtDatoAntecedentes.setBackground(new Color(240, 240, 240));
        // Envuelve en JScrollPane por si el texto es largo.
        JScrollPane scrollAntecedentes = new JScrollPane(txtDatoAntecedentes);
        scrollAntecedentes.setBounds(160, yInicio + separacion * 8, 300, 50);
        add(scrollAntecedentes);
        //BOTON CERRAR.
        btnCerrar.setBounds(190, yInicio + separacion * 8 + 60, 120, 35);
        add(btnCerrar);
        // Cuando presionas "Cerrar", cierra solo esta ventana.
        // dispose() = Libera los recursos de esta ventana y la cierra.
        // La Interfaz 1 (formulario) sigue abierta.
        btnCerrar.addActionListener(e -> {
            dispose(); // Cierra solo esta ventana
        });

    } // Fin del constructor.:)

}
