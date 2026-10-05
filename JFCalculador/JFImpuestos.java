import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;

public class JFImpuestos extends JFrame
{
    private JLabel lblFoto, lblMarcaVal, lblLineaVal, lblModeloVal, lblValorVal;
    private JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
    private JTextField txtLinea, txtMarca;
    private JButton btnBuscarLinea, btnBuscarMarca, btnBuscarCaro;
    private JCheckBox chkProntoPago, chkTraslado, chkServicioPublico;
    private JButton btnCalcular, btnOpcion1, btnOpcion2;

    public JFImpuestos()
    {
        setTitle("Cálculo impuestos");
        setSize(680, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        estructura();

        setVisible(true);
    }

    private void estructura()
    {
        JPanel principal = new JPanel(new BorderLayout(5, 5));
        principal.setBorder(new EmptyBorder(5, 10, 10, 10));

        // panel norte
        JLabel lblBanner = new JLabel();
        lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon banner = cargarImagen("imagen/encabezado.png", 660, 220);
        if (banner != null) lblBanner.setIcon(banner);
        else lblBanner.setText("CALCULADOR DE IMPUESTOS");
        lblBanner.setPreferredSize(new Dimension(660, 220));
        principal.add(lblBanner, BorderLayout.NORTH);

        //4 BLOQUES APILADOS CENTRO
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(crearPanelDatos());
        centro.add(Box.createVerticalStrut(5));
        centro.add(crearPanelBusquedas());
        centro.add(Box.createVerticalStrut(5));
        centro.add(crearPanelDescuentos());
        centro.add(Box.createVerticalStrut(5));
        centro.add(crearPanelOpciones());
        principal.add(centro, BorderLayout.CENTER);

        add(principal);
    }

    private JPanel crearPanelDatos()
    {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(titulo("Datos del vehículo"));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 280));

        // Foto a la izquierda, datos a la derecha
        JPanel fila = new JPanel(new GridLayout(1, 2, 10, 0));

        lblFoto = new JLabel();
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon foto = cargarImagen("imagen/CarroRojo.png", 300, 180);
        if (foto != null) lblFoto.setIcon(foto);
        else lblFoto.setText("(foto del vehículo)");
        fila.add(lblFoto);

        JPanel datos = new JPanel(new GridLayout(4, 2, 5, 10));
        lblMarcaVal = crearValor("Ford");
        lblLineaVal = crearValor("Taurus");
        lblModeloVal = crearValor("2016");
        lblValorVal = crearValor("$ 136,340,000");
        lblValorVal.setForeground(new Color(0, 0, 150));
        lblValorVal.setBackground(Color.WHITE);

        datos.add(crearEtiqueta("Marca"));  datos.add(lblMarcaVal);
        datos.add(crearEtiqueta("Línea"));  datos.add(lblLineaVal);
        datos.add(crearEtiqueta("Modelo")); datos.add(lblModeloVal);
        datos.add(crearEtiqueta("Valor"));  datos.add(lblValorVal);
        fila.add(datos);

        panel.add(fila, BorderLayout.CENTER);

        // Botones de navegación
        JPanel nav = new JPanel(new GridLayout(1, 4, 2, 0));
        btnPrimero = new JButton("<<");
        btnAnterior = new JButton("<");
        btnSiguiente = new JButton(">");
        btnUltimo = new JButton(">>");
        nav.add(btnPrimero);
        nav.add(btnAnterior);
        nav.add(btnSiguiente);
        nav.add(btnUltimo);
        panel.add(nav, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearPanelBusquedas()
    {
        JPanel panel = new JPanel(new GridLayout(3, 2, 2, 2));
        panel.setBorder(titulo("Búsquedas"));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        txtLinea = new JTextField();
        txtMarca = new JTextField();
        btnBuscarLinea = new JButton("Buscar por línea");
        btnBuscarMarca = new JButton("Buscar por marca");
        btnBuscarCaro = new JButton("Buscar vehículo más Caro");

        panel.add(txtLinea);     panel.add(btnBuscarLinea);
        panel.add(txtMarca);     panel.add(btnBuscarMarca);
        panel.add(new JLabel()); panel.add(btnBuscarCaro);

        return panel;
    }

    private JPanel crearPanelDescuentos()
    {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.setBorder(titulo("Descuentos"));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        chkProntoPago = new JCheckBox("Pronto pago");
        chkTraslado = new JCheckBox("Traslado de cuenta");
        chkServicioPublico = new JCheckBox("Servicio público");

        panel.add(chkProntoPago);
        panel.add(chkTraslado);
        panel.add(chkServicioPublico);

        return panel;
    }

    private JPanel crearPanelOpciones()
    {
        JPanel panel = new JPanel(new GridLayout(1, 3, 2, 0));
        panel.setBorder(titulo("Opciones"));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

        btnCalcular = new JButton("Calcular");
        btnOpcion1 = new JButton("Opción 1");
        btnOpcion2 = new JButton("Opción 2");

        panel.add(btnCalcular);
        panel.add(btnOpcion1);
        panel.add(btnOpcion2);

        return panel;
    }

    // ---------- Auxiliares ----------

    // Devuelve null si el archivo no existe, así el programa no se rompe
    private ImageIcon cargarImagen(String ruta, int ancho, int alto)
    {
        if (!new File(ruta).exists()) return null;
        Image img = new ImageIcon(ruta).getImage()
                        .getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private TitledBorder titulo(String texto)
    {
        TitledBorder borde = BorderFactory.createTitledBorder(texto);
        borde.setTitleColor(new Color(0, 0, 160));
        borde.setTitleFont(new Font("Arial", Font.BOLD, 12));
        return borde;
    }

    private JLabel crearEtiqueta(String texto)
    {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        return lbl;
    }

    private JLabel crearValor(String texto)
    {
        JLabel lbl = new JLabel(" " + texto);
        lbl.setOpaque(true);
        lbl.setBackground(new Color(238, 238, 238));
        lbl.setBorder(BorderFactory.createLineBorder(new Color(190, 200, 215)));
        return lbl;
    }
}