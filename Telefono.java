import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


/**
 * Ésta es la clase Telefono
 * 
 * @author Rocío Martínez Untoria
 * @version 14.04.2015
 */
public class Telefono
{
    //Constantes
    private static final int ESPACIO = 10;  //Espacio entre las teclas
    private static final String MENSAJE_LLAMADA = "#LLAMANDO#";

    // Variables de instancia
    private JFrame telefono;        //Es la ventana que simula el teléfono
    private JTextField display;     //Es el display de la pantalla
    private String numeroMarcado;   //Es el número marcado

    /**
     * Constructor para objetos de la clase Telefono
     */
    public Telefono()
    {
        // Inicializamos las variables de instancia
        crearTelefono();
    }

    //borderLayout y GridLayout 5x3

    /**
     * Metodo principal con el que empezará el proyecto.
     */
    public static void main(String[] args)
    {
        Telefono interfaz = new Telefono();
    }

    /**
     * Creamos la ventana
     */
    private void crearTelefono()
    {
        JFrame telefono = new JFrame("");   //Sin título

        JPanel contenidoTelefono = (JPanel)telefono.getContentPane();
        contenidoTelefono.setLayout(new BorderLayout(ESPACIO, ESPACIO));
        contenidoTelefono.setBorder(new EmptyBorder(ESPACIO, ESPACIO, ESPACIO, ESPACIO));

        display = new JTextField();
        contenidoTelefono.add(display, BorderLayout.NORTH);

        JPanel teclado = new JPanel(new GridLayout(5, 3, ESPACIO, ESPACIO));

        //Agregamos los botones

        agregarBotonNumero(teclado, "1");
        agregarBotonNumero(teclado, "2");
        agregarBotonNumero(teclado, "3");

        agregarBotonNumero(teclado, "4");
        agregarBotonNumero(teclado, "5");
        agregarBotonNumero(teclado, "6");

        agregarBotonNumero(teclado, "7");
        agregarBotonNumero(teclado, "8");
        agregarBotonNumero(teclado, "9");

        agregarBotonBorrar(teclado, "B");
        agregarBotonNumero(teclado, "0");
        agregarBotonLimpiar(teclado, "L");

        agregarBotonRepetir(teclado, "R");
        agregarBotonLlamar(teclado, "LL");
        agregarBotonColgar(teclado, "C");

        contenidoTelefono.add(teclado, BorderLayout.CENTER);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);          //CORREGIR!!
        telefono.setVisible(true);
        
        telefono.pack();
    }

    /**
     * Método para agregar botones
     */
    private void agregarBoton(JPanel panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
    }
    
    /**
     * Método para agregar botones de números
     */
    private void agregarBotonNumero(Container panel, final String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("marca el " + textoBoton);
        boton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evento) {
                   String numTelefono = display.getText();
                   if (!numTelefono.equals(MENSAJE_LLAMADA)) {
                       display.setText (numTelefono + textoBoton);       //Podemos sustituir textoBoton por evento.getActionCommand()
                   }
              }
        });
    }
    
    /**
     * Método para borrar el último número
     * @param panel El panel que recoge el botón
     * @param textoBoton El tecxto que aparece en el botón
     */
    private void agregarBotonBorrar(Container panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("Borra el último dígito introducido");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //String nuevoTextoBoton = "";
                String numMarcado = display.getText();
                int numDigitos = numMarcado.length();
                if (numDigitos > 0 && !numMarcado.equals(MENSAJE_LLAMADA)) {
                    display.setText(numMarcado.substring(0, numDigitos - 1));
                }
            }
        });
    }
    
    /**
     * Método que limpia los números marcados
     */
    private void agregarBotonLimpiar(Container panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("Limpia el display");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                display.setText("");
            }
        });
    }
    
    /**
     * Método para llamar
     */
    private void agregarBotonLlamar(Container panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("Llama al número marcado");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento)
            {
                numeroMarcado = display.getText();      //Guardo el número marcado
                display.setText(MENSAJE_LLAMADA);
            }
        });
    }
    
    /**
     * Método para agregar el botón de repetir
     */
    private void agregarBotonRepetir(Container panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("Llama al número marcado");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento)
            {
                display.setText(numeroMarcado);
            }
        });
    }
    
    /**
     * Método para agregar el botón de repetir
     */
    private void agregarBotonColgar(Container panel, String textoBoton)
    {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        boton.setToolTipText("Finaliza el programa");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento)
            {
                System.exit(0);
            }
        });
    }
}
