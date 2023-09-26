
import javax.swing.JOptionPane;

public class muebles {

    private int codigo;
    private String descripcion;
    private int stock;
    private String color;
    private String origen;
    private int pdc;
    private int pdv;
    private boolean off;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String des) {
        this.descripcion = des;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getPdc() {
        return pdc;
    }

    public void setPdc(int pdc) {
        this.pdc = pdc;
    }
     public int getpdv() {
        return pdv;
    }

    public void setpdv(int pdv) {
        this.pdv = pdv;
    }

    public boolean isOff() {
        return off;
    }

    public void setOff(boolean off) {
        this.off = off;
    }
    public boolean getOff() {
        return off;
    }
public void inicializar(){
     int codigo=0;
     String descripcion="";
     int stock=0;
     String color="";
     String origen="";
     int pdc=0;
     int pdv=0;
     boolean off=false;
     
    this.setCodigo(codigo);
    this.setDescripcion(descripcion);
    this.setColor(color);
    this.setOff(off);
    this.setStock(stock);
    this.setOrigen(origen);
    this.setPdc(pdc);  
    this.setpdv(pdv);
}    
 public void registrar(int i){   
    int cod=100+i+1;
    JOptionPane.showMessageDialog(null, "Codigo del mueble: "+cod);
    String des=JOptionPane.showInputDialog("Ingrese la descripción del mueble: ");
    stock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Stock: "));
    color=JOptionPane.showInputDialog("Ingrese el color del mueble: ");
    origen=JOptionPane.showInputDialog("Ingrese el origen (Nacional o Importado): ");
    pdc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de compra: "));
    pdv=((40*pdc)/100)+pdc;
    int lol=JOptionPane.showConfirmDialog(null, "¿Está de oferta? ");
    if(lol==0) off=true;
    else off=false;
    
    this.setCodigo(cod);
    this.setDescripcion(des);
    this.setColor(color);
    this.setOff(off);
    this.setStock(stock);
    this.setOrigen(origen);
    this.setPdc(pdc);  
    this.setpdv(pdv);
}    

 public void mostrar(int i){
   
     JOptionPane.showMessageDialog(null,
             "\nCodigo del mueble:  "+ this.getCodigo()+
             "\nDescripción: " + this.getDescripcion()+
             "\nStock: "+this.getStock()+
             "\nColor: " + this.getColor()+
             "\nOrigen: " + this.getOrigen()+
             "\nPrecio de venta: " + this.getpdv()+
             "\nOferta: " + this.getOff());    
}   
    
    
    
}