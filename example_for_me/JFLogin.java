
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class JFLogin extends JFrame 
{
    private JLabel lblSignIn, lblEmail, lblPassword,lbltexto;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnSignIn, btnFacebook, btnTwitter, btnForgotPass, btnSignUp;
    private Login login;

    public JFLogin()
    {
      login = new Login();
      setTitle("Sign In");
      setSize(350,600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false); 
      
      estructura();
      setVisible(true);
      
    } 
    
    public void estructura(){
        JPanel Fondo = new JPanel();
        Fondo.setLayout(new BorderLayout(15,15));
        Fondo.setBorder(new EmptyBorder(30,25,30,25));
        Fondo.setBackground(new Color(144, 79, 196));
        
        //sing in y logo (encabezado)
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BorderLayout(15,20));
        encabezado.setBackground(new Color(144, 79, 196));
        

        lblSignIn = new JLabel ("Sign In");
        lblSignIn.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,30));
        lblSignIn.setForeground(Color.darkGray);
        
        ImageIcon icono = new ImageIcon("login.png");
        Image img = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconoPequeno = new ImageIcon(img);
        JLabel labelConImagen = new JLabel(iconoPequeno);
        
        encabezado.add(labelConImagen, BorderLayout.NORTH);
        encabezado.add(lblSignIn, BorderLayout.WEST);
        Fondo.add(encabezado,BorderLayout.NORTH);
        
        //CENTRO 
        
        JPanel pcentro = new JPanel();
        pcentro.setLayout(new BoxLayout(pcentro,BoxLayout.Y_AXIS));
        pcentro.setBackground(new Color(144, 79, 196));
        
        lblEmail = new JLabel ("Email");
        lblEmail.setFont(new Font("Times New Roman",Font.BOLD,15));
        lblEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        txtEmail = new JTextField ("");
        txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        
        lblPassword = new JLabel ("Password");
        lblPassword.setFont(new Font("Times New Roman",Font.BOLD,15));
        lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        txtPassword = new JPasswordField ("");
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        
        JPanel panelSingIn = new JPanel(new FlowLayout(FlowLayout.CENTER,8,12));
        btnSignIn = new JButton(" Sign In ");
        panelSingIn.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelSingIn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        panelSingIn.setBackground(new Color(144, 79, 196));
        
        JPanel panelSocial = new JPanel(new FlowLayout(FlowLayout.CENTER,8,12));
        panelSocial.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelSocial.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        panelSocial.setBackground(new Color(144, 79, 196));
        
        btnFacebook = new JButton(" Facebook ");
        btnTwitter = new JButton(" Twitter ");
        
        JPanel panelText = new JPanel(new FlowLayout(FlowLayout.CENTER,8,12));
        JLabel lbltext = new JLabel(" or use one of your social profiles ");
        lbltext.setFont(new Font("Times New Roman",Font.BOLD,10));
        panelText.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        panelText.setBackground(new Color(144, 79, 196));
        
        

        
        btnForgotPass = new JButton("Forgot Password?");
        btnForgotPass.setBorderPainted(false);
        btnForgotPass.setContentAreaFilled(false);
        btnForgotPass.setFocusPainted(false);
        btnForgotPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBorderPainted(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 12));

        
        pcentro.add(lblEmail);
        pcentro.add(txtEmail);
        
        pcentro.add(lblPassword);
        pcentro.add(txtPassword);
        
        panelSingIn.add(btnSignIn);
        
        pcentro.add(panelSingIn);
        
        panelText.add(lbltext);
        pcentro.add(panelText);
        
        panelSocial.add(btnFacebook);
        panelSocial.add(btnTwitter);
        
        
        
        
        pcentro.add(panelSocial);
        Fondo.add(pcentro,BorderLayout.CENTER);
        
        //parte de abajo 
        JPanel pabajo = new JPanel();
        pabajo.setLayout(new BoxLayout(pabajo,BoxLayout.Y_AXIS));
        pabajo.setBackground(new Color(144, 79, 196));
        
        lbltexto = new JLabel(" Made for Karen Villamizar ");
        lbltexto.setFont(new Font("Times New Roman",Font.BOLD,10));
        lbltexto.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        pabajo.add(lbltexto);
        Fondo.add(pabajo,BorderLayout.SOUTH);
        
        
        
        
        add(Fondo);
        
    }
    
    

}