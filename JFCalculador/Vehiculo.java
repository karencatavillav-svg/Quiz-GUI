public class Vehiculo
{
    private String marca, linea, foto;
    private int modelo;
    private double valor;

    public Vehiculo(String marca, String linea, int modelo, double valor, String foto)
    {
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.valor = valor;
        this.foto = foto;
    }

    public String getMarca()  { return marca; }
    public String getLinea()  { return linea; }
    public int getModelo()    { return modelo; }
    public double getValor()  { return valor; }
    public String getFoto()   { return foto; }
}