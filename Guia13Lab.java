
import javax.swing.JOptionPane;

public class Guia13Lab {

    
    public static void main(String[] args) {
        
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de muebles: "));
        muebles vmue[]=new muebles[n];
        muebles a;
        for (int i=0;i<n;i++){
            a=new muebles();
            a.registrar(i);
            vmue[i]=a;
        }
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("\t*******Menu de Opciones*******"
                    + "\n 1-Listado de todos los muebles." 
                    + "\n 2-Cantidad de muebles por origen."
                    + "\n 3-Listado de muebles ordenados por el origen."
                    + "\n 4-Buscar un mueble por su descripcion y actualizar sus datos."
                    + "\n 5-Buscar un mueble por su descripcion y eliminarlo."
                    + "\n 6-Muebles nacionales blancos en oferta."
                    + "\n 7-Listar muebles que necesitan reposicion."
                    + "\n 8-Listado de muebles en oferta."
                    + "\n 9-Buscar un mueble por su codigo y finalizar su oferta."
                    + "\n 10-Incrementar utilidad a mnuebles que no esten en oferta."
                    + "\n 0-Salir."));
            
            switch (op){
                
                case 1: 
                        listado(vmue);break;
                case 2: 
                        cantxor(vmue);break;
                case 3:
                        listxor(vmue);break;
                case 4:
                        actualizar(vmue);break;
                case 5:
                        eliminar(vmue);break;
                case 6:
                        oferta(vmue);break;
                case 7:
                        reposicion(vmue);break;
                case 8:
                        listxoff(vmue);break;
                case 9: 
                        finoff(vmue);break;
                        
            }
                       
            }while(op!=0);            
    }
    
public static void listado(muebles vmue[]){   
    
        for (int i=0;i<vmue.length;i++){
        
         if (vmue[i].getCodigo()!=0)     vmue[i].mostrar(i);        
        }
    }  
public static void cantxor(muebles vmue[]){    
    String nac="nacional";
    String imp="importado";   
    int cnac=0;
    int cimp=0;
    
    for (int i=0;i<vmue.length;i++){
        
        if (vmue[i].getCodigo()!=0){
            if (vmue[i].getOrigen().compareTo(nac)==0) cnac++;
            else cimp++;
        }            
    }
    
JOptionPane.showMessageDialog(null," Cantidad de muebles nacionales: "+cnac+"\n Cantidad de muebles importados: "+cimp);   
    }    
public static void listxor(muebles vmue[]){
        String nac="nacional";
        String imp="importado";
        muebles aux;
        
        for (int i=0;i<vmue.length-1;i++){
        
            if (vmue[i].getCodigo()!=0){
                
                for (int j=i+1;j<vmue.length;j++){
     
                    if (vmue[i].getOrigen().compareTo(vmue[j].getOrigen())<=0){
                        aux=vmue[i];
                        vmue[i]=vmue[j];
                        vmue[j]=aux;
                    }            
                }
            }          
        }
        for (int i=0;i<vmue.length;i++){
            if (vmue[i].getCodigo()!=0) vmue[i].mostrar(i);
        }
    }
public static void actualizar(muebles vmue[]){
    
    String bus=JOptionPane.showInputDialog("Ingrese la descripcion del mueble a buscar: ");
    boolean lol=false;
    for (int i=0;i<vmue.length&&lol==false;i++){
            
            if (vmue[i].getCodigo()!=0){
                
                    if (vmue[i].getDescripcion().compareTo(bus)==0){
                        lol=true;
                        JOptionPane.showMessageDialog(null, "Mueble encontrado, actulize sus datos.");
                        vmue[i].registrar(i);
                    }
            }
        }
    if (lol==false) JOptionPane.showMessageDialog(null,"Mueble no encontrado. ");
    
    
    }
public static void eliminar(muebles vmue[]){
    String bus=JOptionPane.showInputDialog("Ingrese la descripcion del mueble a eliminar: ");
    boolean lol=false;
    for (int i=0;i<vmue.length&&lol==false;i++){
            
            if (vmue[i].getCodigo()!=0){
                
                    if (vmue[i].getDescripcion().compareTo(bus)==0){
                        lol=true;
                        JOptionPane.showMessageDialog(null, "Mueble encontrado, ha sido eliminado.");
                        vmue[i].inicializar();
                    }
            }
        }
    if (lol==false) JOptionPane.showMessageDialog(null,"Mueble no encontrado. ");
    
    
    }
public static void oferta(muebles vmue[]){
    
        String lol="blanco";
        boolean ban=false;
        for (int i=0;i<vmue.length;i++){
            
            if (vmue[i].getCodigo()!=0&&vmue[i].getColor().compareTo(lol)==0&&vmue[i].getOff()==false){
                JOptionPane.showMessageDialog(null, "Muebles blancos encontrados, ahora estan en oferta. ");
                vmue[i].setOff(true);
                int off=vmue[i].getpdv()-( ( 5*vmue[i].getpdv() )/100 );
                vmue[i].setpdv(off);
                ban=true;    
            }
        }    
        if (ban==false) JOptionPane.showMessageDialog(null, "No se encontraron muebles blancos.");
    }
public static void reposicion(muebles vmue[]){    
        for (int i=0;i<vmue.length;i++){
            
            if (vmue[i].getCodigo()!=0&&vmue[i].getStock()<5){
                JOptionPane.showMessageDialog(null,"Hace falta hacer reposicion del siguiente mueble.");
                vmue[i].mostrar(i);
            }            
        }    
    }
public static void listxoff(muebles vmue[]){
    
        boolean lol=false;
        for (int i=0;i<vmue.length;i++){
            
            if (vmue[i].getCodigo()!=0&&vmue[i].getOff()==true){
                vmue[i].mostrar(i);
                lol=true;
            }
        }
        if (lol==false) JOptionPane.showMessageDialog(null, "No hay muebles en oferta para mostrar.");
    }
public static void finoff(muebles vmue[]){
    
        int bus=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del mueble a buscar: "));
        boolean lol=false;
        for (int i=0;i<vmue.length;i++){
            
            if (vmue[i].getCodigo()!=0&&vmue[i].getCodigo()==bus){
                
                
                if (vmue[i].getOff()==false) JOptionPane.showMessageDialog(null, "El mueble no se encuentra en oferta.");
                else{
                     vmue[i].setOff(true);
                     JOptionPane.showMessageDialog(null,"El estadod el mueble a cambiado, ahora está en oferta.");
                }
                lol=true;
            }
        }
        if (lol==false) JOptionPane.showMessageDialog(null, "Codigo no encontrado.");

    }
}
