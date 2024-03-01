import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException  {
	
	int op1, op2, op3, op4, op5;
	do{
	op1=ImprimirMP();
	switch(op1){//menu principal

		case 1: {
			do{
		      op2=ImprimirMA(); //menu altas
			
		     switch(op2){
			 case 1:{ //articulo
				int Id_a=Integer.parseInt(JOptionPane.showInputDialog("ID Articulo:"));
				String nombre=JOptionPane.showInputDialog("Nombre:");
				String marca=JOptionPane.showInputDialog("Marca:");
				int num_ref=Integer.parseInt(JOptionPane.showInputDialog("Numero de referencia:"));
				int Id_p=Integer.parseInt(JOptionPane.showInputDialog("ID Proveedor:"));
				int s=Integer.parseInt(JOptionPane.showInputDialog("Stock:"));
				Articulo a=new Articulo(Id_a, nombre, marca, num_ref, Id_p, s);
				a.Ingresar();
				break;}
				

		     case 2:{ //cliente
		     		int Id_c=Integer.parseInt(JOptionPane.showInputDialog("ID Cliente:"));
				String nombreC=JOptionPane.showInputDialog("Nombre:");
				int telf=Integer.parseInt(JOptionPane.showInputDialog("Telefono:"));
				String documentoC=JOptionPane.showInputDialog("Nombre Documento:");
				String correoC=JOptionPane.showInputDialog("Correo:");
				String direccionC=JOptionPane.showInputDialog("Direccion: ");
				Cliente c=new Cliente(Id_c, nombreC,documentoC , correoC,telf, direccionC );
				c.Ingresar();
				break;}
				
				
			 case 3:{  //proveedor
				int Id_p=Integer.parseInt(JOptionPane.showInputDialog("ID Proveedor:"));
				String nombreP=JOptionPane.showInputDialog("Nombre:");
				String direccionP=JOptionPane.showInputDialog("Direccion:");
				int docP=Integer.parseInt(JOptionPane.showInputDialog("No. Documento:"));
				String correP=JOptionPane.showInputDialog("Correo:");
				int tel_p=Integer.parseInt(JOptionPane.showInputDialog("Telefono:"));
				Proveedor p=new Proveedor(Id_p, nombreP, direccionP, docP, correP, tel_p);
				p.Ingresar();
				break;}
				
				
			 case 4:{ //salida 
				int Id_s=Integer.parseInt(JOptionPane.showInputDialog("ID Salida:"));
				int Cant_S=Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
				double v_u=Double.parseDouble(JOptionPane.showInputDialog("Valor unidad:"));
				String fecha_s=JOptionPane.showInputDialog("Fecha de salida:");
				int Id_aS=Integer.parseInt(JOptionPane.showInputDialog("ID Articulo:"));
				Salida s =new Salida(Id_s,  v_u, fecha_s, Cant_S, Id_aS);
				s.Ingresar();
				break;}
				
				
			 case 5:{//entrada
			 	int Id_e=Integer.parseInt(JOptionPane.showInputDialog("ID Entrada:"));
			 	double v_uE=Double.parseDouble(JOptionPane.showInputDialog("Valor unidad:"));
			 	String fecha_e=JOptionPane.showInputDialog("Fecha de entrada:");
			 	int fac_e=Integer.parseInt(JOptionPane.showInputDialog("Factura:"));
				int Cant_E=Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
				int Id_aE=Integer.parseInt(JOptionPane.showInputDialog("ID Articulo:"));
				Entrada e =new Entrada(Id_e, v_uE, fecha_e, fac_e, Cant_E, Id_aE);
				e.Ingresar();
				break;}
				
				
			 case 6:{//venta
			 	int Id_v=Integer.parseInt(JOptionPane.showInputDialog("ID Venta:"));
			 	int docV=Integer.parseInt(JOptionPane.showInputDialog("No. Documento: "));
			 	int Id_aV=Integer.parseInt(JOptionPane.showInputDialog("ID Articulo:"));
			 	String fecha_v=JOptionPane.showInputDialog("Fecha de venta:");
			 	double v_uV=Double.parseDouble(JOptionPane.showInputDialog("Valor unidad:"));
			 	int Id_cV=Integer.parseInt(JOptionPane.showInputDialog("ID Cliente:"));
				Venta v = new Venta(Id_v, docV, Id_aV, v_uV, Id_cV, fecha_v);
				//output.println(vt.getIDv()+"\t"+vt.getDoc()+"\t"+vt.getIDa()+"\t"+vt.getValorU()+"\t"+vt.getIDc()+"\t"+vt.getFecha());
				v.Ingresar();
			    break;}
			    
			 case 7:{//devolucion
			    int Id_d=Integer.parseInt(JOptionPane.showInputDialog("ID Devolución:"));
			 	int Cant_D=Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
			 	int Id_aD=Integer.parseInt(JOptionPane.showInputDialog("ID Articulo:"));
			    	double v_uD=Double.parseDouble(JOptionPane.showInputDialog("Valor unidad:"));
			 	String fecha_d=JOptionPane.showInputDialog("Fecha de devolucion:");
				Devolucion d =new Devolucion(Id_d,v_uD,fecha_d, Cant_D,Id_aD);
				d.Ingresar();
			    break;} 
			    	
		         }//llave de switch op2
		       }while(op2!=8); 
		break; } //break y llave del case 1 del menu principal

		case 2:{//menu bajas
			do{
		      op3=ImprimirMB();
		    	
			 switch(op3){
			 case 1:{  //articuloclienteproveedorsalidaentradaventadevolucion
				Articulo artb=new Articulo();
				artb.Eliminar();
				break;}
			case 2:{ 
				Cliente cb=new Cliente();
				cb.Eliminar();
				break;}
			case 3:{  
				Proveedor pb =new Proveedor();
				pb.Eliminar();
				break;}
			case 4:{  
				Salida sb=new Salida();
				sb.Eliminar();
				break;}
			case 5:{  
				Entrada eb=new Entrada();
				eb.Eliminar();
				break;}
			case 6:{ 
				Venta vb=new Venta();
				vb.Eliminar();
				break;}

			case 7:{  
				Devolucion db=new Devolucion();
				db.Eliminar();
				break;}



			}//llave de switch op3
			}while(op3!=8);
		break;
		}//llave de case 2 del menu principal
		case 3:{
			do{
			op4=ImprimirMC();
			switch(op4){

			case 1:{
			Articulo a=new Articulo();
			int Id_ab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Articulo:"));
			a.Consultar(Id_ab);
			break;}


			case 2:{
			Cliente cc=new Cliente();
			int Id_cb=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
			cc.Consultar(Id_cb);
			break;}


			case 3:{//proveedor
			Proveedor pc=new Proveedor();
			int Id_pb=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proveedor:"));
			pc.Consultar(Id_pb);
			break;}
			

			case 4:{//salida
			Salida sc=new Salida();
			int Id_sb=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Salida:"));
			sc.Consultar(Id_sb);
			break;}

			case 5:{//entrada
			Entrada ec=new Entrada();
			int Id_eb=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la entrada:"));
			ec.Consultar(Id_eb);
			break;}

			case 6:{//venta
			Venta vc=new Venta();
			int Id_vb=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la venta:"));
			vc.Consultar(Id_vb);
			break;}

			case 7:{
			Devolucion dc=new Devolucion();
			int Id_db=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Devolucion:"));
			dc.Consultar(Id_db);
			break;}


		}//llave switch
		
		}while(op4!=8);
		break;
		}//llave case 3 menu principal




		case 4:{
				do{
			 op5=ImprimirMM();

			switch (op5){//articuloclienteproveedorsalidaentradaventadevolucion
			case 1:{
			Articulo art1=new Articulo();
			art1.Modificar();
			break;
			}

			case 2:{
			Cliente c1=new Cliente();
			c1.Modificar();
			break;
			}

			case 3:{
			Proveedor p1=new Proveedor();
			p1.Modificar();
			break;
			}

			case 4:{
			Salida s1=new Salida();
			s1.Modificar();
			break;
			}

			case 5:{
			Entrada e1=new Entrada();
			e1.Modificar();
			break;
			}

			case 6:{
			Venta v1=new Venta();
			v1.Modificar();
			break;
			}

			case 7:{
			Devolucion d1=new Devolucion();
			d1.Modificar();
			break;
			}
		}//llave switch
		}while(op5!=8);
		break;
		}//llve xcase 4 menu principal

	}

	}while(op1!=5);


    }//llave del main


   public static int ImprimirMP(){

   	int Op=Integer.parseInt(JOptionPane.showInputDialog("::::::MENU PRINCIPAL:::::::\n\n1. Altas\n2. Bajas\n3. Consultas\n4. Modificaciones\n5. Salir\n\nElige una opción:"));
	return Op;
   }

   public static int ImprimirMA(){
   	int Opc=Integer.parseInt(JOptionPane.showInputDialog("Menu Altas\n\n1. Articulo\n2. Cliente\n3. Proveedor\n4. Salidas\n5. Entradas\n6. Venta\n7. Devolución\n8. Regresar al menu principal\n\nElige una opción:"));
	return Opc;
   }

  public static int ImprimirMB(){
   	int Opci=Integer.parseInt(JOptionPane.showInputDialog("Menu Bajas\n\n1. Articulo\n2. Cliente\n3. Proveedor\n4. Salidas\n5. Entradas\n6. Venta\n7. Devolución\n8. Regresar al menu principal\n\nElige una opción:"));
	return Opci;
   }

  public static int ImprimirMC(){
   	int Opcio=Integer.parseInt(JOptionPane.showInputDialog("Menu Consultas\n\n1. Articulo\n2. Cliente\n3. Proveedor\n4. Salidas\n5. Entradas\n6. Venta\n7. Devolución\n8. Regresar al menu principal\n\nElige una opción:"));
	return Opcio;
   }

  public static int ImprimirMM(){
   	int Opcion=Integer.parseInt(JOptionPane.showInputDialog("Menu Modificaciones\n\n1. Articulo\n2. Cliente\n3. Proveedor\n4. Salidas\n5. Entradas\n6. Venta\n7. Devolución\n8. Regresar al menu principal\n\nElige una opción:"));
	return Opcion;
   }
}