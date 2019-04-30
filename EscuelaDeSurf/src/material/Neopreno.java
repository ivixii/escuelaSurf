package material;

/**
 *
 * @author Ivan
 */
public class Neopreno implements IReservable{
    private String marca, categoria;
    private int talla, cremallera;
    private boolean mangasLargas, piernasLargas;
    private static int[] precios = {5, 8, 12, 20, 32, 40};
    private double suplemento;
    
    final int DELANTERA = 1;
    final int TRASERA = 2;
    final int SIN = 3;

    public Neopreno(String marca, String categoria, int talla, int cremallera, boolean mangasLargas, boolean piernasLargas, double suplemento) {
        this.marca = marca;
        this.categoria = categoria;
        this.talla = talla;
        this.cremallera = cremallera;
        this.mangasLargas = mangasLargas;
        this.piernasLargas = piernasLargas;
        this.suplemento = suplemento;
    }
    
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getCremallera() {
        return cremallera;
    }

    public void setCremallera(int cremallera) {
        if(cremallera < 1 || cremallera > 3){
            cremallera = 3;
        }
        this.cremallera = cremallera;
    }

    public boolean isMangasLargas() {
        return mangasLargas;
    }

    public void setMangasLargas(boolean mangasLargas) {
        this.mangasLargas = mangasLargas;
    }

    public boolean isPiernasLargas() {
        return piernasLargas;
    }

    public void setPiernasLargas(boolean piernasLargas) {
        this.piernasLargas = piernasLargas;
    }

    public static int[] getPrecios() {
        return precios;
    }

    public static void setPrecios(int[] precios) {
        Neopreno.precios = precios;
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
    
    private String getCremalleraToString(){
        String crem;
        switch(this.getCremallera()){
            case DELANTERA:
                crem = "DELANTERA";
                break;
            case TRASERA:
                crem = "TRASERA";
                break;
            default:
                crem = "SIN"; 
        }
        return crem;
    }
    
    @Override
    public String getDenominacion(){
        return this.getMarca() + ", " + this.getCategoria();
    }

    @Override
    public String getObservaciones(){
        String cremallera = "";
        if(this.getCremallera() == 1){
            
        }
        String cadena;
        cadena = "Suplemento: " + Double.toString(this.getSuplemento()) + ", ";
        cadena += "Talla: " + Double.toString(this.getTalla()) + ", ";
        cadena += "Cremallera: " + this.getCremalleraToString() + ", ";
        cadena += "Mangas largas: " + ((this.isMangasLargas())?"Sí":"No") + ", ";
        cadena += "Piernas largas: " + ((this.isPiernasLargas())?"Sí":"No");
        return cadena;
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
    public String toString(){
        String cadena;
        cadena =  this.getMarca() + ", " + this.getCategoria() + " - talla:" + this.getTalla() + ", "
                + ((this.mangasLargas)?"mangas largas, ":"")
                + ((this.piernasLargas)?"piernas largas, ":"");
        String crem;
        switch(this.getCremallera()){
            case DELANTERA:
                crem = "con cremallera delantera";
                break;
            case TRASERA:
                crem = "con cremallera trasera";
                break;
            default:
                crem = "sin cremallera"; 
        }
        cadena += crem;
        return cadena;
    }
    

    @Override
    public boolean equals(Object object){
        boolean areSame = false;
        if(object instanceof Neopreno){
            Neopreno other = (Neopreno)object;
            if(this.getCategoria().equals(other.getCategoria())){
                if(this.getCremallera() == other.getCremallera()){
                    if(this.getTalla() == other.getTalla()){
                        if(this.isMangasLargas() == other.isMangasLargas()){
                            if(this.isPiernasLargas() == other.isPiernasLargas()){
                                areSame = true;
                            }
                        }
                    }
                }
            }
        }
        return areSame;
    }
    
}
