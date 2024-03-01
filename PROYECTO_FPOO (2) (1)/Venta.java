import java.util.Date;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Venta{
	
	private int Id_venta=0;
	private int documenteo=0;
	private int Id_articulo=0;
	private String fecha ="";
	private double valor_unidad=0.0;
	private int Id_cliente=0;
	
	
    public Venta() {
    }
    
    public Venta(int Id_venta, int documenteo, int Id_articulo, double valor_unidad, int Id_cliente, String fecha) {
    	this.Id_venta= Id_venta;
	this.documenteo=documenteo;
	this.Id_articulo=Id_articulo;
    	this.valor_unidad=valor_unidad;
    	this.Id_cliente=Id_cliente;
	this.fecha=fecha;
    }
    
    public void setIDv(int Id_v){
    	this.Id_venta=Id_v;
    }
    public void setFecha(String fecha){
	this.fecha=fecha;
	}
    
    public void setValorU(double valor_unidad){
    	this.valor_unidad=valor_unidad;
    }
    
    
    public void setDoc(int docum){
    	this.documenteo=docum;
    }
    
    public void setIDa(int Id_articulo){
    	this.Id_articulo=Id_articulo;
    }
    public void setIDc(int Id_c){
    	this.Id_cliente=Id_c;
    }
	
    
    public int getIDv(){
    	return this.Id_venta;
    }
    
     public double getValorU(){
    	return this.valor_unidad;
    }
    
    public String getFecha(){
    	return this.fecha;
    }
    
    public int getDoc(){
    	return this.documenteo;
    }	
    
     public int getIDa(){
    	return this.Id_articulo;
    }

     public int getIDc(){
    	return this.Id_cliente;
    }

    public void Ingresar() throws IOException {

	File salida= new File("Ventas.txt");
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	output.println(this.getIDv()+"\t"+this.getDoc()+"\t"+this.getIDa()+"\t"+this.getValorU()+"\t"+this.getIDc()+"\t"+this.getFecha());
	 
	output.close();
	}


	public void Consultar(int id)throws IOException{
	File salida= new File("Ventas.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		
		Venta vt=new Venta(Integer.parseInt(linea),entrada.nextInt(),entrada.nextInt(), entrada.nextDouble(), entrada.nextInt(),  entrada.next());;
		
		
		
		JOptionPane.showMessageDialog(null,"ID Venta: "+vt.getIDv()+ "\nDocumento: "+vt.getDoc()+"\nID Articulo:"+ vt.getIDa()+"\nValor unidad: "+vt.getValorU()+"\nID Cliente: "+vt.getIDc()+"\nFecha: "+vt.getFecha() );
                }
               
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}
	public void Modificar()throws IOException{
	
	File salida= new File("Ventas.txt");
	String ida=JOptionPane.showInputDialog("Ingrese el ID de la venta que desea modificar: ");
	Scanner entrada = new Scanner(salida);
	
		PrintWriter output = new PrintWriter(new FileWriter(salida, true));
        String linea;
      	int encontrado=0;
	
            while (entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(ida)) {   
                  encontrado++;
		int op7;
		
		Venta vt=new Venta(Integer.parseInt(linea),entrada.nextInt(),entrada.nextInt(), entrada.nextDouble(), entrada.nextInt(),  entrada.next());
		
				
		do{
		
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Venta: "+vt.getIDv()+ "\n2. Documento: "+vt.getDoc()+"\n3. ID Articulo:"+ vt.getIDa()+"\n4. Valor unidad: "+vt.getValorU()+"\n5. ID Cliente: "+vt.getIDc()+"\n6. Fecha: "+ vt.getFecha()+"\n7 Cancelar"+"\n\nIngrese el numero del dato que desee:") );
		switch (op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ vt.getIDv()+"\n"+"Introduzca el nuevo dato: "));
			vt.setIDv(idc);
			break;
                }
		case 2:{
			int nc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ vt.getDoc()+"\n"+"Introduzca el nuevo dato: "));
			vt.setDoc(nc);
			break;
                }
		case 3:{
			int mc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ vt.getIDa()+"\n"+"Introduzca el nuevo dato: "));
			vt.setIDa(mc);
			break;
                }
		case 4:{
			double refc=Double.parseDouble(JOptionPane.showInputDialog( "Dato actual: "+ vt.getValorU()+"\n"+"Introduzca el nuevo dato: "));
			vt.setValorU(refc);
			break;
                }
		case 5:{
			int idpc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ vt.getIDc()+"\n"+"Introduzca el nuevo dato: "));
			vt.setIDc(idpc);
			break;
                }
		case 6:{
			String cf=JOptionPane.showInputDialog("Dato actual: "+ vt.getFecha()+"\nIntroduzca un nuevo dato: ");
			vt.setFecha(cf);
			break;}
		
		
		
     }//llave switch
		output.println(vt.getIDv()+"\t"+vt.getDoc()+"\t"+vt.getIDa()+"\t"+vt.getValorU()+"\t"+vt.getIDc()+"\t"+vt.getFecha());
	//output.println(this.getIDv()+"\t"+this.getDoc()+"\t"+this.getIDa()+"\t"+this.getValorU()+"\t"+this.getIDc()+"\t"+this.getFecha());
		output.close();
	
     }while(op7!=7); 
	
}         
            }//llave while
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();
	
 }  

	public void Eliminar()throws IOException{
	File salida= new File("Ventas.txt");
	int idc=Integer.parseInt(JOptionPane.showInputDialog( "Ingrese el ID del proveedor que desee eliminar: "));
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
		
		Venta vt=new Venta(Integer.parseInt(linea),entrada.nextInt(),entrada.nextInt(), entrada.nextDouble(), entrada.nextInt(),  entrada.next());
		
		
	

		int el=Integer.parseInt(JOptionPane.showInputDialog(null,"ID Venta: "+vt.getIDv()+ "\nDocumento: "+vt.getDoc()+"\nID Articulo:"+ vt.getIDa()+"\nValor unidad: "+vt.getValorU()+"\nID Cliente: "+vt.getIDc()+"\nFecha:"+ vt.getFecha()+"\n\n¿Desea eliminar este articulo? 1=SI / 0=NO") );
		if(el==1){
		
		vt.setIDv(0);
		vt.setDoc(0);
		vt.setIDa(0);
		vt.setValorU(0.0);
		vt.setIDc(0);
		vt.setFecha("");
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
		
		output.println(vt.getIDv()+"\t"+vt.getDoc()+"\t"+vt.getIDa()+"\t"+vt.getValorU()+"\t"+vt.getIDc()+"\t"+vt.getFecha());
			
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