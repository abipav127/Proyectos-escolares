import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

publci class Entrada{
	
	private int Id_entrada=0;
	private double valor_unidad=0.0;
	private String fecha="";
	private int factura=0;
	private int cantidad=0;
	private int Id_articulo=0;
	
    public Entrada() {
    }
    
    public Entrada(int Id_entrada, double valor_unidad, String fecha, int factura, int cantidad, int Id_articulo) {
    	this.Id_entrada= Id_entrada;
    	this.valor_unidad=valor_unidad;
    	this.factura=factura;
    	this.Id_articulo= Id_articulo;
    	this.cantidad=cantidad;
	this.fecha=fecha;
    }
    
    public void setIDe(int Id_entrada){
    	this.Id_entrada=Id_entrada;
    }
    public void setFecha(String fecha){
	this.fecha=fecha;
    }
    
    public void setValorU(double valor_unidad){
    	this.valor_unidad=valor_unidad;
    }
    
    public void setFac(int factura){
    	this.factura=factura;
    
    }
    
    public void setCant(int cantidad){
    	this.cantidad=cantidad;
    }
    
    public void setIDa(int Id_articulo){
    	this.Id_articulo=Id_articulo;
    }
    
    public int getIDe(){
    	return this.Id_entrada;
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
    
     public int getFac(){
    	return this.factura;
    }
       public void Ingresar() throws IOException {

	File salida= new File("Entradas.txt");
	PrintWriter o = new PrintWriter(new FileWriter(salida, true));
	o.println("ID Entrada\tValor Unidad\tFecha\tCantidad\tID Articulo\tFactura");
	o.close();
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	output.println(this.getIDe()+"\t"+this.getValorU()+"\t"+this.getFecha()+"\t"+this.getCant()+"\t"+this.getIDa()+"\t"+this.getFac());

	output.close();
	}

	public void Consultar(int id)throws IOException{
	File salida= new File("Entradas.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		  
		Entrada a=new Entrada(Integer.parseInt(linea),entrada.nextDouble() , entrada.next(), entrada.nextInt(),entrada.nextInt(), entrada.nextInt());
	
		JOptionPane.showMessageDialog(null,"ID Entrada: "+a.getIDe()+ "\nValor Unidad: "+a.getValorU()+"\nFactura: "+a.getFac()+"\nCantidad:"+ a.getCant()+"\nID Articulo: "+a.getIDa()+"\nFecha: "+a.getFecha());
                }
               
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}
	public void Modificar()throws IOException{
	
	File salida= new File("Entradas.txt");
	String ida=JOptionPane.showInputDialog("Ingrese el ID de la salida que desea modificar: ");
	Scanner entrada = new Scanner(salida);
	
		PrintWriter output = new PrintWriter(new FileWriter(salida, true));
        String linea;
      	int encontrado=0;
	
            while (entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(ida)) {   
                  encontrado++;
		int op7;
		
		Entrada a=new Entrada(Integer.parseInt(linea),entrada.nextDouble() , entrada.next(), entrada.nextInt(),entrada.nextInt(), entrada.nextInt());
	
		
		
		do{
		
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Entrada: "+a.getIDe()+ "\n2. Valor Unidad: "+a.getValorU()+"\n3. Factura: "+a.getFac()+"\n4. Cantidad:"+ a.getCant()+"\n5. ID Articulo: "+a.getIDa()+"\n6. Fecha: "+ a.getFecha()+"\n7. Cancelar\n\n Ingrese el dato que desee modificar: "));
		switch(op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDe()+"\n"+"Introduzca el nuevo dato: "));
			a.setIDe(idc);
			break;
                }
		case 2:{
			double nc=Double.parseDouble(JOptionPane.showInputDialog("Dato actual: "+ a.getValorU()+"\n"+"Introduzca el nuevo dato: "));
			a.setValorU(nc);
			break;
                }
		case 3:{
			int mc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ a.getFac()+"\n"+"Introduzca el nuevo dato: "));
			a.setFac(mc);
			break;
                }
		case 4:{
			int mc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ a.getCant()+"\n"+"Introduzca el nuevo dato: "));
			a.setCant(mc);
			break;
			}
		case 5:{
			int refc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDa()+"\n"+"Introduzca el nuevo dato: "));
			a.setIDa(refc);
			break;
                }
		case 6:{
		String ec=JOptionPane.showInputDialog("Dato actual: "+a.getFecha()+"\n"+"Introduzca el nuevo dato: ");
			a.setFecha(ec);
			break;
			}
		
		
		
     }//llave switch
		output.println(a.getIDe()+"\t"+a.getValorU()+"\t"+a.getFecha()+"\t"+a.getCant()+"\t"+a.getIDa()+"\t"+a.getFac());
	
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
	File salida= new File("Entradas.txt");
	int idc=Integer.parseInt(JOptionPane.showInputDialog( "Ingrese el ID de la salida que desee eliminar: "));
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
		
		
		Entrada a=new Entrada(Integer.parseInt(linea),entrada.nextDouble() , entrada.next(), entrada.nextInt(),entrada.nextInt(), entrada.nextInt());
		int el=Integer.parseInt(JOptionPane.showInputDialog(null,"ID Entrada: "+a.getIDe()+ "\nValor Unidad: "+a.getValorU()+"\nFactura: "+a.getFac()+"\n Cantidad:"+ a.getCant()+"\nID Articulo: "+a.getIDa()+"\nFecha: "+ a.getFecha()+"\n\n ¿desea eliminar los datos? si=1  no=0"));
		
		if(el==1){
		
		a.setIDe(0);
		a.setCant(0);
		a.setIDa(0);
		a.setValorU(0.0);
		a.setFac(0);
		a.setFecha("");
		
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
	output.println(a.getIDe()+"\t"+a.getValorU()+"\t"+a.getFecha()+"\t"+a.getCant()+"\t"+a.getIDa()+"\t"+a.getFac());
			
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