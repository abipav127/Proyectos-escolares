import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Cliente {
	
	 private int Id_cliente=0;
	 private String nombre="";
	 private String documenteo="";
	 private String correo="";
	 private int telefono=0;
	 private String direccion="";
	
    public Cliente() {
    }
    
    public Cliente(int Id_cliente, String nombre,  String documenteo ,String correo,int telefono, String direccion) {
    	this.Id_cliente= Id_cliente;
    	this.nombre=nombre;
    	this.documenteo=documenteo;
    	this.correo=correo;
	this.direccion=direccion;
    	this.telefono= telefono;
    	
    }
    
    public void setIDc(int Id_cliente){
    	this.Id_cliente=Id_cliente;
    }
    
    public void setNombre(String nombre){
    	this.nombre=nombre;
    }
    
    public void setDoc(String documenteo){
    	this.documenteo=documenteo;
    
    }
    
    public void setCorreo(String correo){
    	this.correo=correo;
    }
    
    public void setTel(int telefono){
    	this.telefono=telefono;
    }
    
    public void setDireccion(String direccion){
    	this.direccion=direccion;
    }
    
    public int getIDc(){
    	return Id_cliente;
    }
    
     public String getNombre(){
    	return nombre;
    }
    
    public String getDoc(){
    	return documenteo;
    }
    
    public String getCorreo(){
    	return correo;
    }	
    
     public int getTel(){
    	return telefono;
    }
    
     public String getDireccion(){
    	return direccion;
    }
   public void Ingresar() throws IOException {

	File salida= new File("Clientes.txt");
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	
	
	output.println(getIDc()+"\t"+getNombre()+"\t"+getDoc()+"\t"+getCorreo()+"\t"+getTel()+"\t"+getDireccion());

	output.close();
	}


	public void Consultar(int id)throws IOException{
	File salida= new File("Clientes.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		
		Cliente cl=new Cliente(Integer.parseInt(linea), entrada.next(),entrada.next(), entrada.next(),entrada.nextInt(), entrada.next());
		System.out.println(cl.getCorreo()+cl.getTel()+cl.getDireccion());
		JOptionPane.showMessageDialog(null,"ID Cliente: "+cl.getIDc()+ "\nNombre: "+cl.getNombre()+"\nDocumento:"+ cl.getDoc()+"\nCorreo: "+cl.getCorreo()+"\nTelefono: "+cl.getTel()+"\nDireccion: "+cl.getDireccion());
                }
               
            }
            if(encontrado==0){ 
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}


	public void Modificar()throws IOException{
	
	File salida= new File("Clientes.txt");
	String ida=JOptionPane.showInputDialog("Ingrese el ID del articulo que desea modificar: ");
	Scanner entrada = new Scanner(salida);
	
		PrintWriter output = new PrintWriter(new FileWriter(salida, true));
        String linea;
      	int encontrado=0;
	
            while (entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(ida)) {   
                  encontrado++;
		int op7;
		Cliente cl=new Cliente(Integer.parseInt(linea), entrada.next(),entrada.next(), entrada.next(),entrada.nextInt(), entrada.next());
		
		do{
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Cliente: "+cl.getIDc()+ "\n2. Nombre: "+cl.getNombre()+"\n3. Documento:"+ cl.getDoc()+"\n4. Correo: "+cl.getCorreo()+"\n5. Telefono: "+cl.getTel()+"\n6. Direccion: "+cl.getDireccion()+"\n7. Cancelar"+"\n\nIngrese el numero del dato que desee:"));
		
		switch (op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ cl.getIDc()+"\n"+"Introduzca el nuevo dato: "));
			cl.setIDc(idc);
			break;
                }
		case 2:{
			String nc=JOptionPane.showInputDialog("Dato actual: "+ cl.getNombre()+"\n"+"Introduzca el nuevo dato: ");
			cl.setNombre(nc);
			break;
                }
		case 3:{
			String mc=JOptionPane.showInputDialog("Dato actual: "+ cl.getDoc()+"\n"+"Introduzca el nuevo dato: ");
			cl.setDoc(mc);
			break;
                }
		case 4:{
			String refc=JOptionPane.showInputDialog( "Dato actual: "+ cl.getCorreo()+"\n"+"Introduzca el nuevo dato: ");
			cl.setCorreo(refc);
			break;
                }
		case 5:{
			int idpc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ cl.getTel()+"\n"+"Introduzca el nuevo dato: "));
			cl.setTel(idpc);
			break;
                }
		case 6:{
			String sc=JOptionPane.showInputDialog("Dato actual: "+ cl.getDireccion()+"\n"+"Introduzca el nuevo dato: ");
			cl.setDireccion(sc);
			break;
                }
		
		
     }//llave switch
		output.println(cl.getIDc()+"\t"+cl.getNombre()+"\t"+cl.getDoc()+"\t"+cl.getCorreo()+"\t"+cl.getTel()+cl.getDireccion());
		
		output.close();
	
     }while(op7!=7); 
	
 }        
            }//llave while
            if(encontrado==0){ 
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();
	
 }  

	public void Eliminar()throws IOException {
	File salida= new File("Clientes.txt");
	int idc=Integer.parseInt(JOptionPane.showInputDialog( "Ingrese el ID del cliente que desee eliminar: "));
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
		
		Cliente cl=new Cliente(Integer.parseInt(linea), entrada.next(),entrada.next(), entrada.next(),entrada.nextInt(), entrada.next());
		
		int el=Integer.parseInt(JOptionPane.showInputDialog(null,"ID Cliente: "+cl.getIDc()+ "\nNombre: "+cl.getNombre()+"\nDocumento:"+ cl.getDoc()+"\nCorreo: "+cl.getCorreo()+"\nTelefono: "+cl.getTel()+"\nDireccion: "+cl.getDireccion()+"\n\n¿Desea eliminar este articulo? 1=SI / 0=NO"));
		if(el==1){
		
		cl.setIDc(0);
		cl.setNombre("");
		cl.setDireccion("");
		cl.setCorreo("");
		cl.setTel(0);
		cl.setDoc("");
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
		
		output.println(cl.getIDc()+"\t"+cl.getNombre()+"\t"+cl.getDoc()+"\t"+cl.getCorreo()+"\t"+cl.getTel()+"\t"+cl.getDireccion());
		output.close();
            }   
            }
            if(encontrado==0){ 
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
  		 }
	entrada.close();
			
	}


}