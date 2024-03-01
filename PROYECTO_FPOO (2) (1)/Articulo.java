import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
public class Articulo {
	
	
	private int Id_articulo=0;
	private String nombre= " ";
	private String marca=" ";
	private int referencia=0;
	private int Id_proveedor=0;
	private int stock=0;

    public Articulo() {
    }

    public Articulo(int Id_articulo, String nombre, String marca, int referencia, int Id_proveedor, int stock) {
    	this.Id_articulo= Id_articulo;
    	this.nombre=nombre;
    	this.marca=marca;
    	this.referencia=referencia;
    	this.Id_proveedor= Id_proveedor;
    	this.stock=stock;
    }

    public void setIDa(int Id_articulo){
    	this.Id_articulo=Id_articulo;
    }

    public void setNombre(String nombre){
    	this.nombre=nombre;
    }

    public void setMarca(String marca){
    	this.marca=marca;

    }

    public void setRef(int referencia){
    	this.referencia=referencia;
    }

    public void setIDp(int Id_proveedor){
    	this.Id_proveedor=Id_proveedor;
    }

    public void setStock(int stock){
    	this.stock=stock;
    }

    public int getIDa(){
    	return Id_articulo;
    }

     public String getNombre(){
    	return nombre;
    }

    public String getMarca(){
    	return marca;
    }

    public int getRef(){
    	return referencia;
    }

     public int getIDp(){
    	return Id_proveedor;
    }

     public int getStock(){
    	return stock;
    }

    

   public void Ingresar() throws IOException {
	File salida= new File("Articulos.txt");
	PrintWriter output = new PrintWriter(new FileWriter(salida, true));
	
	
	output.println(this.getIDa()+"\t"+this.getNombre()+"\t"+this.getMarca()+"\t"+this.getRef()+"\t"+this.getIDp()+"\t"+this.getStock());
	
	output.close();
	}


	public void Consultar(int id)throws IOException{
	File salida= new File("Articulos.txt");
	String nid=Integer.toString(id);
	Scanner entrada = null;
        String linea;
      	int encontrado=0;
	
           
            entrada = new Scanner(salida);
           
            while(entrada.hasNext()&&encontrado==0) { 
                linea = entrada.next();  
                if (linea.contains(nid)) {   
                  encontrado++;
		
		Articulo a=new Articulo(Integer.parseInt(linea), entrada.next(), entrada.next(),Integer.parseInt(linea), Integer.parseInt(linea), Integer.parseInt(linea) );
		
		JOptionPane.showMessageDialog(null,"ID Articulo: "+a.getIDa()+ "\nNombre: "+a.getNombre()+"\nMarca:"+ a.getMarca()+"\nReferencia: "+a.getRef()+"\nID Proveedor: "+a.getIDp()+"\nStock: "+a.getStock() );
                }
               
            }
            if(encontrado==0){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
		linea="NO HAY ARTICULOS RELACIONADOS";
                JOptionPane.showMessageDialog(null, linea); 
   
        }
	entrada.close();

}


	public void Modificar()throws IOException{
	
	File salida= new File("Articulos.txt");
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
		
		Articulo a=new Articulo(Integer.parseInt(linea), entrada.next(), entrada.next(),Integer.parseInt(linea), Integer.parseInt(linea), Integer.parseInt(linea) );
		
		do{
		op7=Integer.parseInt(JOptionPane.showInputDialog(null,"1. ID Articulo: "+a.getIDa()+ "\n2. Nombre: "+a.getNombre()+"\n3. Marca:"+ a.getMarca()+"\n4. Referencia: "+a.getRef()+"\n5. ID Proveedor: "+a.getIDp()+"\n6. Stock: "+a.getStock()+"\n7. Cancelar"+"\n\nIngrese el numero del dato que desee:"));
		
		switch (op7){
		case 1:{
			
			int idc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDa()+"\n"+"Introduzca el nuevo dato: "));
			System.out.println(idc);
			a.setIDa(idc);
			break;
                }
		case 2:{
			String nc=JOptionPane.showInputDialog("Dato actual: "+ a.getNombre()+"\n"+"Introduzca el nuevo dato: ");
			a.setNombre(nc);
			break;
                }
		case 3:{
			String mc=JOptionPane.showInputDialog("Dato actual: "+ a.getMarca()+"\n"+"Introduzca el nuevo dato: ");
			a.setMarca(mc);
			break;
                }
		case 4:{
			int refc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getRef()+"\n"+"Introduzca el nuevo dato: "));
			a.setRef(refc);
			break;
                }
		case 5:{
			int idpc=Integer.parseInt(JOptionPane.showInputDialog( "Dato actual: "+ a.getIDp()+"\n"+"Introduzca el nuevo dato: "));
			a.setIDp(idpc);
			break;
                }
		case 6:{
			int sc=Integer.parseInt(JOptionPane.showInputDialog("Dato actual: "+ a.getStock()+"\n"+"Introduzca el nuevo dato: "));
			a.setStock(sc);
			break;
                }
		
		
     }//llave switch
		output.println(a.getIDa()+"\t"+a.getNombre()+"\t"+a.getMarca()+"\t"+a.getRef()+"\t"+a.getIDp()+"\t"+a.getStock());
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
	File salida= new File("Articulos.txt");
	int idc=Integer.parseInt(JOptionPane.showInputDialog( "Ingrese el ID del articulo que desee eliminar: "));
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
		
		Articulo a=new Articulo(Integer.parseInt(linea), entrada.next(), entrada.next(),Integer.parseInt(linea), Integer.parseInt(linea), Integer.parseInt(linea) );
		
		int el=Integer.parseInt(JOptionPane.showInputDialog(null,"ID Articulo: "+a.getIDa()+ "\nNombre: "+a.getNombre()+"\nMarca:"+ a.getMarca()+"\nReferencia: "+a.getRef()+"\nID Proveedor: "+a.getIDp()+"\nStock: "+a.getStock()+"\n\n¿Desea eliminar este articulo? 1=SI / 0=NO"));
		if(el==1){
		
		a.setIDa(0);
		a.setNombre("");
		a.setMarca("");
		a.setRef(0);
		a.setIDp(0);
		a.setStock(0);
		
       		}
		
		else {
		JOptionPane.showMessageDialog(null, "Proceso cancelado");}
		System.out.println(a.getIDa()+"\t"+a.getNombre()+"\t"+a.getMarca()+"\t"+a.getRef()+"\t"+a.getIDp()+"\t"+a.getStock());
		output.println(a.getIDa()+"\t"+a.getNombre()+"\t"+a.getMarca()+"\t"+a.getRef()+"\t"+a.getIDp()+"\t"+a.getStock());
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