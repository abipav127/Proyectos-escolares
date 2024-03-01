import java.util.Date;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
public class Devolucion{
	
	private int Id_devolucion;
	private int cantidad;
	private int Id_articulo;
	private double valor_unidad;
	private String fecha ="";
	
	
    public Devolucion() {
    }
    
    public Devolucion(int Id_devolucion, double valor_unidad, String fecha, int cantidad, int Id_articulo) {
    	this.Id_devolucion= Id_devolucion;
    	this.valor_unidad=valor_unidad;
    	this.Id_articulo= Id_articulo;
    	this.cantidad=cantidad;
	this.fecha=fecha;
    }
    
    public void setIDd(int Id_devolucion){
    	this.Id_devolucion=Id_devolucion;
    }
	public void setFecha(String fecha){
	this.fecha=fecha;
	}
    
    public void setValorU(double valor_unidad){
    	this.valor_unidad=valor_unidad;
    }
    
    
    public void setCant(int cantidad){
    	this.cantidad=cantidad;
    }
    
    public void setIDa(int Id_articulo){
    	this.Id_articulo=Id_articulo;
    }
    
    public int getIDd(){
    	return this.Id_devolucion;
    }
    
     public double getValorU(){
    	return this.valor_unidad;
    }
    
    public String getFecha(){
    	return fecha;
    }
    
    public int getCant(){
    	return this.cantidad;
    }	
    
     public int getIDa(){
    	return this.Id_articulo;
    }
     public void Ingresar() throws IOException {

	File salida= new File("Devoluciones.txt");
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	
	
	output.println(this.getIDd()+"\t"+this.getValorU()+"\t\t"+this.getFecha()+"\t"+this.getCant()+"\t"+this.getIDa());


	output.close();
	}

	public void Consultar(int id)throws IOException{
	File salida= new File("Devoluciones.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		 //Devolucion(int Id_devolucion, double valor_unidad, int cantidad, int Id_articulo 
		Devolucion a=new Devolucion(Integer.parseInt(linea), entrada.nextDouble() ,entrada.next(), entrada.nextInt(),entrada.nextInt());
		
		JOptionPane.showMessageDialog(null,"ID Devolucion: "+a.getIDd()+ "\nValor Unidad: "+a.getValorU()+"\nCantidad:"+ a.getCant()+"\nID Articulo: "+a.getIDa()+"\nFecha: "+a.getFecha());
                }
               
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}
	public void Modificar()throws IOException{
	
	File salida= new File("Devoluciones.txt");
	String ida=JOptionPane.showInputDialog("Ingrese el ID de la devolucion que desea modificar: ");
	Scanner entrada = new Scanner(salida);
	
		PrintWriter output = new PrintWriter(new FileWriter(salida, true));
        String linea;
      	int encontrado=0;
	
            while (entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(ida)) {   
                  encontrado++;
		int op7;
		
		Devolucion a=new Devolucion(Integer.parseInt(linea), entrada.nextDouble() ,entrada.next(), entrada.nextInt(),entrada.nextInt());
				
		do{
		
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Devolucion: "+a.getIDd()+ "\n2. Valor Unidad: "+a.getValorU()+"\n3. Cantidad:"+ a.getCant()+"\n4. ID Articulo: "+a.getIDa()+"\n5. Fecha: "+a.getFecha()+"\n6. Cancelar"+ "\n\nIngrese el numero del dato que desee:"));
		switch (op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDd()+"\n"+"Introduzca el nuevo dato: "));
			a.setIDd(idc);
			break;
                }
		case 2:{
			double nc=Double.parseDouble(JOptionPane.showInputDialog("Dato actual: "+ a.getValorU()+"\n"+"Introduzca el nuevo dato: "));
			a.setValorU(nc);
			break;
                }
		case 3:{
			int mc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ a.getCant()+"\n"+"Introduzca el nuevo dato: "));
			a.setCant(mc);
			break;
                }
		case 4:{
			int refc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDa()+"\n"+"Introduzca el nuevo dato: "));
			a.setIDa(refc);
			break;
                }
		case 5:{
			String dc=JOptionPane.showInputDialog("Dato actual: "+ a.getFecha()+"\n"+"Introduzca el nuevo dato: ");
			a.setFecha(dc);
			break;
			}
		
		
		
		
     }//llave switch
		output.println(a.getIDd()+"\t"+a.getValorU()+"\t\t"+a.getFecha()+"\t"+a.getCant()+"\t"+a.getIDa());

	
		output.close();
	
     }while(op7!=6); 
	
}         
            }//llave while
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();
	
 }  

	public void Eliminar()throws IOException{
	File salida= new File("Devoluciones.txt");
	int idc=Integer.parseInt(JOptionPane.showInputDialog( "Ingrese el ID de la devolucion que desee eliminar: "));
	String nid=Integer.toString(idc);
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		
		
		Devolucion a=new Devolucion(Integer.parseInt(linea), entrada.nextDouble() ,entrada.next(), entrada.nextInt(),entrada.nextInt());
				
		
		int el=Integer.parseInt(JOptionPane.showInputDialog(null,"ID Devolucion: "+a.getIDd()+ "\nValor Unidad: "+a.getValorU()+"\nCantidad:"+ a.getCant()+"\nID Articulo: "+a.getIDa()+"\nFecha:"+a.getFecha()+ "\n\n¿Desea eliminar esta Devolucion? 1=SI / 0=NO"));
		if(el==1){
		
		a.setIDd(0);
		a.setCant(0);
		a.setIDa(0);
		a.setValorU(0.0);
		a.setFecha("");
		
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
		output.println(a.getIDd()+"\t"+a.getValorU()+"\t\t"+a.getFecha()+"\t"+a.getCant()+"\t"+a.getIDa());

			
		output.close();
            }   
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();
			
	}
}
