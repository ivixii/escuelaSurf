package material;

/**
 *
 * @author Ivan
 */
public class testMaterial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CentralMateriales central;
        central = new CentralMateriales();
        
        
        for (int i = 0; i < 49; i++) {
            central.nuevaTabla("Billabong", "Olas altas", 25, 27, 1, 0.25);
        }
        central.nuevaTabla("QuikSilver", "Olas bajas", 25, 27, 1, 0.25);
        //System.out.println(central.tablasToString());
        central.eliminaTabla(central.getTabla(27));
        central.eliminaTabla(central.getTabla(0));
        central.eliminaTabla(central.getTabla(50));
        System.out.println(central.tablasToString());
    }
    
}
