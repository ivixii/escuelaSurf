package material;

import java.util.Scanner;

/**
 *
 * @author Ivan
 */
public class VentanaMateriales {
    CentralMateriales materiales;
    VentanaMateriales(CentralMateriales materiales){
        this.materiales = materiales;
    }
    
    public void mostrarMenuGestionMateriales(){
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do { // ¿Que sentido tiene este do while?
            System.out.println("\n\n\n\tMenú Principal:\n");
            System.out.println("\t1. Alta de tabla de surf");
            System.out.println("\t2. Baja de tabla de surf");
            System.out.println("\t3. Listado de tablas de surf");
            System.out.println("\t4. Alta de traje de neopreno");
            System.out.println("\t5. Baja de traje de neopreno");
            System.out.println("\t6. Listado de trajes de neopreno");
            System.out.println("\t---------------------");
            System.out.println("\t\t0. Salir");
            System.out.print("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 3) {
                System.out.print("--> Introduzca una opción valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionMaterial(opc);
            }
        } while (opc != 0);
    }
    
    private void realizarOpcionGestionMaterial(int opc){
        switch(opc){
            case 1:
                mostrarAltaTabla();
                break;
            case 2:
                mostrarBajaTabla();
                break;
            case 3:
                mostrarListadoTablas();
                break;
            case 4:
                mostrarAltaTraje();
                break;
            case 5:
                mostrarBajaTraje();
                break;
            default:
                mostrarListadoTrajes();
        }
    }
    
    private void mostrarAltaTabla(){
        
    }
    
    private void mostrarBajaTabla(){
        
    }
    
    private void mostrarListadoTablas(){
        
    }
    
    private void mostrarAltaTraje(){
        
    }
    
    private void mostrarBajaTraje(){
        
    }
    
    private void mostrarListadoTrajes(){
        
    }
}
