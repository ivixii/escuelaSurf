
package material;

/**
 *
 * @author Ivan
 */
public class TablaSurf implements IReservable{
    //Declaración de variables
    private String marca, tipo;
    private int volumen, construccion;
    private static int[] precios = {10, 15, 25, 40, 70, 90};
    private double talla, suplemento; // suplemento tiene un caracter multiplicador sobre el precio
                                      // Por ejemplo Precio = 10, suplemento 0.5 --> Precio = 15

    final int POLIESTER = 1;
    final int EPOXY = 2;
    final int SOFTBOARD = 3;
    final int HINCHABLE = 4;
    final int INDETERMINADA = 5;

    public TablaSurf(String marca, String tipo, int volumen, int talla, int construccion, double suplemento) {
        this.marca = marca;
        this.tipo = tipo;
        this.volumen = volumen;
        this.construccion = construccion;
        this.talla = talla;
        this.suplemento = suplemento;
    }
    
    
    //Constructor

    public TablaSurf(String marca, String tipo, int volumen, double talla, int construccion, double suplemento) {
        this.marca = marca;
        this.tipo = tipo;
        this.volumen = volumen;
        this.construccion = construccion;
        this.talla = talla;
        this.suplemento = suplemento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        if(volumen < 10){
            volumen = 10;
        }
        
        if(volumen > 100){
            volumen = 100;
        }
        
        this.volumen = volumen;
    }

    public int getConstruccion() {
        return construccion;
    }

    public void setConstruccion(int construccion) {
        if(construccion < 1 || construccion > 5){
            construccion = 5;
        }
        this.construccion = construccion;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(double suplemento) {
        if(suplemento < 0){
            suplemento = 0;
        }
        
        if(suplemento > 1){
            suplemento = 1;
        }
        this.suplemento = suplemento;
    }
    
    @Override
    public double getPrecio(int opcionTiempo) {
        double precioTotal;
        if(opcionTiempo < 0){
            opcionTiempo = 0;
        }
        if(opcionTiempo > 5){
            opcionTiempo = 5;
        }
        precioTotal = this.precios[opcionTiempo];
        precioTotal += precioTotal * this.getSuplemento();
        return precioTotal;
    }
    
    @Override
    public String getDenominacion(){
        return this.getMarca() + ", " + this.getTipo();
    }
    
    @Override
    public String getObservaciones(){
        String cadena;
        cadena = "Suplemento: " + Double.toString(this.getSuplemento()) + ", ";
        cadena += "Talla: " + Double.toString(this.getTalla()) + ", ";
        cadena += "Volumen: " + Integer.toString(this.getVolumen()) + ", ";
        cadena += "Contrucción: " + this.getConstruccionToString();
        return cadena;
    }
    
    @Override
    public String toString(){
        return this.getMarca() + ", " + this.getTipo() + " - volumen:" + this.getVolumen() + ", talla:"
                + this.getTalla() + ", construcción: " + this.getConstruccionToString();
    }
    
    @Override
    public boolean equals(Object object){
        boolean areSame = false;
        if(object instanceof TablaSurf){
            TablaSurf other = (TablaSurf)object;
            if(this.getConstruccion() == other.getConstruccion()){
                if(this.getMarca().equals(other.getMarca())){
                    if(this.getTalla() == other.getTalla()){
                        if(this.getTipo().equals(other.getTipo())){
                            if(this.getVolumen() == other.getVolumen()){
                                areSame = true;
                            }
                        }
                    }
                }
            }
        }
        return areSame;
    }
    
    private String getConstruccionToString(){
        String material;
        switch(this.getConstruccion()){
            case POLIESTER:
                material = "POLIESTER";
                break;
            case EPOXY:
                material = "EPOXY";
                break;
            case SOFTBOARD:
                material = "SOFTBOARD";
                break;
            case HINCHABLE:
                material = "HINCHABLE";
                break;
            default:
                material = "INDETERMINADA"; 
        }
        return material;
    }
    
    
}
