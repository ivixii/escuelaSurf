package material;

/**
 *
 * @author Ivan
 */
public class CentralMateriales {
    TablaSurf[] tablas;
    Neopreno[] trajes;
    static final int MAXMATERIALES = 50;
    private int numTablas; // Numero real de tablas disponibles
    private int numTrajes; // Numero real de trajes disponibles
    
    CentralMateriales(){
        this.tablas = new TablaSurf[MAXMATERIALES];
        this.trajes = new Neopreno[MAXMATERIALES];
        this.numTablas = 0;
        this.numTrajes = 0;
    }
    
    void nuevaTabla(String marca, String tipo, int volumen, double talla, int construccion, double suplemento){
        if(numTablas < MAXMATERIALES){
           TablaSurf nuevaTabla = new TablaSurf(marca, tipo, volumen, talla, construccion, suplemento);
            this.tablas[numTablas] = nuevaTabla;
            this.numTablas ++; 
        }else{
            System.err.println("Número máximo de tablas alcanzado (50), para añadir una nueva tabla elimine una");
        }
    }
    
    TablaSurf getTabla(int index){
        if(index >= 0 && index < MAXMATERIALES ){
            if(index < this.numTablas){
                return this.tablas[index];
            }else{
                System.err.println("No hay ninguna tabla asociada a ese índice");
            }
        }else{
            System.err.println("Numero de índice proporcionado no válido (0-" + (MAXMATERIALES - 1) + ")");
        }
        return null;
    }
    
    void eliminaTabla(TablaSurf t){
        boolean encontrado = false;
        int i = 0;
        while(i < this.numTablas && encontrado == false && t!=null){
            if(t.equals(tablas[i])){
                //Este if else me va a ahorrar problemas para reordenar la tabla una vez eliminado el elemento
                if(i != MAXMATERIALES-1){
                    //Algoritmo para reordenar la tabla y no dejar espacios en blanco cuando borro.
                    for (int j = i; j < numTablas-1; j++) {
                        this.tablas[j] = this.tablas[j+1];
                    }
                    
                }else{
                    tablas[MAXMATERIALES-1] = null;
                }
                encontrado = true;
                this.numTablas--;
            }
            i++;
        }
        if(t==null){
            System.err.println("No ha introducido una tabla válida, ya que está vacía");
        }
        if(encontrado == false){
            System.err.println("No hay ninguna tabla que coincida con la introducida");
        }
    }
    
    void nuevoTraje(String marca, String categoria, int talla, boolean mangasLargas, boolean piernasLargas, int cremallera, double suplemento){
        if(numTrajes < MAXMATERIALES){
           Neopreno nuevoTraje = new Neopreno(marca, categoria, talla, cremallera, mangasLargas, piernasLargas, suplemento);
            this.trajes[numTrajes] = nuevoTraje;
            this.numTrajes ++; 
        }else{
            System.err.println("Número máximo de trajes alcanzado (50), para añadir un nuev traje elimine uno");
        }
    }
    
    Neopreno getTraje(int index){
        if(index >= 0 && index < MAXMATERIALES ){
            if(index < this.numTrajes){
                return this.trajes[index];
            }else{
                System.err.println("No hay ninguna traje asociado a ese índice");
            }
        }else{
            System.err.println("Numero de índice proporcionado no válido (0-" + (MAXMATERIALES - 1) + ")");
        }
        return null;
    }
    
    void eliminaTraje(Neopreno n){
        boolean encontrado = false;
        int i = 0;
        while(i < this.numTrajes && encontrado == false && n!=null){
            if(n.equals(trajes[i])){
                //Este if else me va a ahorrar problemas para reordenar la tabla una vez eliminado el elemento
                if(i != MAXMATERIALES-1){
                    //Algoritmo para reordenar la tabla y no dejar espacios en blanco cuando borro.
                    for (int j = i; j < numTrajes-1; j++) {
                        this.trajes[j] = this.trajes[j+1];
                    }
                }else{
                    trajes[MAXMATERIALES-1] = null;
                }
                encontrado = true;
            }
            i++;
            this.numTrajes--;
        }
        if(n==null){
            System.err.println("No ha introducido una tabla válida, ya que está vacía");
        }
        if(encontrado == false){
            System.err.println("No hay ningun traje que coincida con el introducido");
        }
    }
    
    String tablasToString(){
        String cadena = "";
        if(this.numTablas == 0){
            cadena += "No hay ninguna tabla en la central";
        }else{
            for (int i = 0; i < this.numTablas; i++) {
            cadena += "Tabla Nº" + (i+1) + ":\n\t";
            cadena += tablas[i].toString() + "\n";
            }
        } 
        return cadena;
    }
    
    String trajesToString(){
        String cadena = "";
        if(this.numTrajes == 0){
            cadena += "No hay ninguna tabla en la central";
        }else{
            for (int i = 0; i < this.numTrajes; i++) {
                cadena += "Traje Nº" + (i+1) + ":\n\t";
                cadena += trajes[i].toString() + "\n";
            }
        }    
        return cadena;
    }
    
}
