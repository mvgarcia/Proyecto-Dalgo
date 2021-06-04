package ProblemaB;
//package ProblemaB;
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//
//public class ProblemaB {
//	
//	//Autores: Pedro Vallejo, Valentina Garcia
//	
//	public int balanceoCarga(int[]t, int p)
//	{
//		int camin=0;
//		int tamanio= Math.floorDiv(t.length, p);
//		int res=t.length%p;
//		if(res>0)tamanio+=1;
//		ArrayDeque<Integer>[] a = new ArrayDeque[p];	
//		//ArrayList<ArrayDeque<Integer>> a= new ArrayList<ArrayDeque<Integer>>()
//		
//		int i=0;
//		int[] valores = new int[p];
//		for(int j=0;j<p && i<t.length;j++)
//		{
//			int cota=0;
//			if(res>0) {cota= tamanio+1;res--;}
//			else {cota=tamanio;}
//			for(int k=0;k<cota;k++)
//			{
//				System.out.println(a[j]+" "+i);
//				a[j].addLast(t[i]);
//				valores[j]+=t[i];
//				i++;
//			}
//		}
//		
//		boolean subio= false;
//		while(subio)
//		{
//			int [] maxs=darMax(valores);
//			int max=maxs[0];
//			int posMax=maxs[1];
//			if(posMax==0)
//			{
//				int cambio=a[posMax+1].getFirst()+a[posMax].getLast();
//				valores[posMax]-=cambio;
//				valores[posMax+1]+=cambio;
//				a[posMax+1].addFirst(a[posMax].removeLast());
//			}
//			else if(posMax==valores.length-1)
//			{
//				int cambio=a[posMax].getFirst()+a[posMax-1].getLast();
//				valores[posMax-1]+=cambio;
//				valores[posMax]-=cambio;
//				a[posMax-1].addLast(a[posMax].removeFirst());
//			}
//			else
//			{
//				int cambio1=a[posMax].getFirst()+a[posMax-1].getLast();
//				valores[posMax-1]+=cambio1;
//				valores[posMax]-=cambio1;
//				a[posMax-1].addLast(a[posMax].removeFirst());
//				int nuevoMax1=darMax(valores)[0];
//				valores[posMax-1]-=cambio1;
//				valores[posMax]+=cambio1;
//				
//		
//				int cambio2=a[posMax+1].getFirst()+a[posMax].getLast();
//				valores[posMax]-=cambio2;
//				valores[posMax+1]+=cambio2;
//				a[posMax+1].addFirst(a[posMax].removeLast());
//				int nuevoMax2=darMax(valores)[0];
//				valores[posMax]+=cambio2;
//				valores[posMax+1]-=cambio2;
//				
//				if(nuevoMax2>=nuevoMax1)
//				{
//					a[posMax].addLast(a[posMax+1].removeFirst());
//					valores[posMax-1]+=cambio1;
//					valores[posMax]-=cambio1;
//				}
//				else
//				{
//					a[posMax].addFirst(a[posMax-1].removeLast());
//					valores[posMax]-=cambio2;
//					valores[posMax+1]+=cambio2;
//				}
//				
//			}
//			int nuevoMax=darMax(valores)[0];
//			if(nuevoMax>max)subio=true;
//			camin=max;
//		}
//		
//		return camin;
//	}
//	
//	public int[] darMax(int[]valores)
//	{
//		int [] max=new int[2];
//		for(int v=0;v<valores.length;v++) {
//			if(v>max[0]) {
//				max[0]=valores[v];
//				max[1]=v;
//			}
//		}
//		return max;
//	}
//
//	public static void main(String[] args) throws Exception {
//		ProblemaB instancia = new ProblemaB();
//		try ( 
//			InputStreamReader is= new InputStreamReader(System.in);
//			BufferedReader br = new BufferedReader(is);
//		) { 
//			String line = br.readLine();
//			
//			while(line!=null && line.length()>0 && !"0 0".equals(line)) {
//				final String [] dataStr = line.split(" ");
//				int n=Integer.parseInt(dataStr[0]);
//				int p= Integer.parseInt(dataStr[1]);
//				line = br.readLine();
//				final String [] dataStr1 = line.split(" ");
//				final int[] t = Arrays.stream(dataStr1).mapToInt(f->Integer.parseInt(f)).toArray();
//				
//				int camin = instancia.balanceoCarga(t, p);
//				System.out.println(camin);
//				line = br.readLine();
//			}
//		}
//	}
//
//}
