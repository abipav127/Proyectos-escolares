import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Proveedor {
	
	private int Id_proveedor;
	private String nombre;
	private String direccion;
	private int documento;
	private String correo;
	private int telefono;
	
    public Proveedor() {
    }
    
    public Proveedor(int Id_proveedor, String nombre, String direccion, int documento, String correo, int telefono) {
    	this.Id_proveedor= Id_proveedor;
    	this.nombre=nombre;
    	this.direccion=direccion;
    	this.documento=documento;
    	this.correo=correo;
    	this.telefono=telefono;
    }
    
    public void setIDp(int Id_proveedor){
    	this.Id_proveedor=Id_proveedor;
    }
    
    public void setNombre(String nombre){
    	this.nombre=nombre;
    }
    
    public void setDireccion(String direccion){
    	this.direccion=direccion;
    
    }
    
    public void setDoc(int documento){
    	this.documento=documento;
    }
    
    public void setCorreo(String correo){
    	this.correo=correo;
    }
    
    public void setTel(int telefono){
    	this.telefono=telefono;
    }
    
    public int getIDp(){
    	return this.Id_proveedor;
    }
    
     public String getNombre(){
    	return this.nombre;
    }
    
    public String getDireccion(){
    	return this.direccion;
    }
    
    public int getDoc(){
    	return this.documento;
    }	
    
    public String getCorreo(){
    	return this.correo;
    }
    
     public int getTel(){
    	return this.telefono;
    }
    
      public void Ingresar() throws IOException {

	File salida= new File("Proveedores.txt");
	PrintWriter titulo=new PrintWriter(salida);
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	
	titulo.println("ID Proveedor\tNombre\tDireccion\tDocumento\tCorreo\tTelefono");
	output.println(this.getIDp()+"\t"+this.getNombre()+"\t"+this.getDireccion()+"\t"+this.getDoc()+"\t"+this.getCorreo()+"\t"+this.getTel());
	
	output.close();
	}

	public void Consultar(int id)throws IOException{
	File salida= new File("Proveedores.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		
		Proveedor pr=new Proveedor(Integer.parseInt(linea), entrada.next(), entrada.next(),entrada.nextInt(), entrada.next(),  entrada.nextInt());
		
		JOptionPane.showMessageDialog(null,"ID Proveedor: "+pr.getIDp()+ "\nNombre: "+pr.getNombre()+"\nDireccion:"+ pr.getDireccion()+"\nDocumento: "+pr.getDoc()+"\nCorreo: "+pr.getCorreo()+"\nTelefono: "+pr.getTel() );
                }
               
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}
	public void Modificar()throws IOException{
	
	File salida= new File("Proveedores.txt");
	String ida=JOptionPane.showInputDialog("Ingrese el ID del proveedor que desea modificar: ");
	Scanner entrada = new Scanner(salida);
	
		PrintWriter output = new PrintWriter(new FileWriter(salida, true));
        String linea;
      	int encontrado=0;
	
            while (entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(ida)) {   
                  encontrado++;
		int op7;
		
		Proveedor pr=new Proveedor(Integer.parseInt(linea), entrada.next(), entrada.next(),entrada.nextInt(), entrada.next(),  entrada.nextInt());
		
		do{
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Proveedor: "+pr.getIDp()+ "\n2. Nombre: "+pr.getNombre()+"\n3. Direccion:"+ pr.getDireccion()+"\n4. Documento: "+pr.getDoc()+"\n5. Correo: "+pr.getCorreo()+"\n6. Telefono: "+pr.getTel()+ "\n7. Cancelar"+"\n\nIngrese el numero del dato que desee:"));
		
		switch (op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ pr.getIDp()+"\n"+"Introduzca el nuevo dato: "));
			pr.setIDp(idc);
			break;
                }
		case 2:{
			String nc=JOptionPane.showInputDialog("Dato actual: "+ pr.getNombre()+"\n"+"Introduzca el nuevo dato: ");
			pr.setNombre(nc);
			break;
                }
		case 3:{
			String mc=JOptionPane.showInputDialog("Dato actual: "+ pr.getDireccion()+"\n"+"Introduzca el nuevo dato: ");
			pr.setDireccion(mc);
			break;
                }
		case 4:{
			int refc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ pr.getDoc()+"\n"+"Introduzca el nuevo dato: "));
			pr.setDoc(refc);
			break;
                }
		case 5:{
			String idpc=JOptionPane.showInputDialog( "Dato actual: "+ pr.getCorreo()+"\n"+"Introduzca el nuevo dato: ");
			pr.setCorreo(idpc);
			break;
                }
		case 6:{
			int sc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ pr.getTel()+"\n"+"Introduzca el nuevo dato: "));
			pr.setTel(sc);
			break;
                }
		
		
     }//llave switch
		output.println(pr.getIDp()+"\t"+pr.getNombre()+"\t"+pr.getDireccion()+"\t"+pr.getDoc()+"\t"+pr.getCorreo()+"\t"+pr.getTel());
	
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
	File salida= new File("Proveedores.txt");
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
		
		Proveedor pr=new Proveedor(Integer.parseInt(linea), entrada.next(), entrada.next(),entrada.nextInt(), entrada.next(),  entrada.nextInt());
		
		int el=Integer.parseInt(JOptionPane.showInputDialog(null, "ID Proveedor: "+pr.getIDp()+ "\nNombre: "+pr.getNombre()+"\nDireccion:"+ pr.getDireccion()+"\nDocumento: "+pr.getDoc()+"\nCorreo: "+pr.getCorreo()+"\nTelefono: "+pr.getTel()+ "\n7. Cancelar"+"\n\n¿Desea eliminar este articulo? 1=SI / 0=NO"));
		if(el==1){
		
		pr.setIDp(0);
		pr.setNombre("");
		pr.setDireccion("");
		pr.setDoc(0);
		pr.setCorreo("");
		pr.setTel(0);
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
		
		output.println(pr.getIDp()+"\t"+pr.getNombre()+"\t"+pr.getDireccion()+"\t"+pr.getDoc()+"\t"+pr.getCorreo()+"\t"+pr.getTel());
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

	
 
    
