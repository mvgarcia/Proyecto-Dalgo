package ProblemaA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Autores: Pedro Vallejo, Valentina Garcia

public class ProblemaA {
	
	public ProblemaA()
	{
		
	}
	
	public int[][] calculoPotencia(int[][] A, int r, int m)
	{
		int [][] s = new int[A.length][A.length];
		
		String binary = Integer.toBinaryString(r);
		
		int[][][] parcial = new int [binary.length()][A.length][A.length];
		parcial[binary.length()-1]=A;
		
		int it=1;
		for(int z=binary.length()-2;z>=0 && it<r;z--)
		{
			it*=2;
			parcial[z]=multMatrix(parcial[z+1], parcial[z+1],m);
		}
		
		s=parcial[0];
		
		for(int i=1;i<binary.length();i++)
		{
			if(binary.charAt(i)=='1')s=multMatrix(s, parcial[i],m);
		}
		
		
//		if(zm%2==0)
//		{
//			int[][] m2=multMatrix(A, A);
//			int[][] last=m2;
//			for(int z=2;z<zm;z+=2)
//			{
//				last=multMatrix(last, m2);
//			}
//			r=last;
//		}
//		else
//		{
//			int[][] m2=multMatrix(A, A);
//			int[][] last=m2;
//			for(int z=2;z<zm-1;z+=2)
//			{
//				last=multMatrix(last, m2);
//			}
//			r=multMatrix(last, A);
//		}
		
//		for(int z=1;z<=zm;z++)
//		{
//			int prime= maxPrime(z);
//			if(z==1)
//			{
//				parcial[z-1]=A;
//			}
//			else if(prime==z)
//			{
//				parcial[z-1]=multMatrix(parcial[z-2],A);
//			}
//			
//			else
//			{
//				parcial[z-1]=multMatrix(parcial[prime-1],parcial[(z/prime)-1]);
//			}
		
//			if(z==1)
//			{
//				parcial[z-1]=A;
//			}
//			else
//			{
//				parcial[z-1]=multMatrix(parcial[z-2],A);
//			}
			
			
			
//		}
//		r=parcial[zm-1];
		
		return s;
	}

	public int[][] multMatrix(int[][] A, int[][]B, int m)
	{
		int [][] s = new int[A.length][A.length];

		for (int i=0; i<A.length;i++)
		{
			for (int j=0; j<B.length;j++)
			{
				
				for (int k=0; k<A.length;k++)
				{
					s[i][j]+=A[i][k]*B[k][j];
				}
				
				s[i][j]=s[i][j]%m;
			}
		}

		return s;
	}

//	public static void main(String[] args) {
//		
//		ProblemaA p= new ProblemaA();
//		
//		int n=50;
//		int [][]A = new int[n][n];
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<n;j++) {A[i][j]=i+j;System.out.print(A[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		int [][]r = new int[n][n];
//		int zm=1000;
//		long startTime = System.currentTimeMillis();
//		int m=1000;
//		r=p.calculoPotencia(A, zm,m);
//		long endTime = System.currentTimeMillis();
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<n;j++)System.out.print(r[i][j]+" ");
//			System.out.println();
//		}
//		System.out.println("Total time spent (milliseconds): "+(endTime-startTime));
//
//	}
	
	public static void main(String[] args) throws Exception {
		ProblemaA instancia = new ProblemaA();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
			
			while(line!=null && line.length()>0 && !"0 0 0".equals(line)) {
				final String [] dataStr = line.split(" ");
				int n=Integer.parseInt(dataStr[0]);
				int r= Integer.parseInt(dataStr[1]);
				int m=Integer.parseInt(dataStr[2]);
				int[][]A=new int[n][n];
				
				for(int i=0;i<n;i++)
				{
					line = br.readLine();
					final String [] dataStr1 = line.split(" ");
					final int[] fila = Arrays.stream(dataStr1).mapToInt(f->Integer.parseInt(f)).toArray();
					A[i]=fila;
				}
				
				int [][] s = instancia.calculoPotencia(A, r, m);
				System.out.println();
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n;j++)System.out.print(s[i][j]+" ");
					if(i!=n-1)System.out.println();
				}
				line = br.readLine();
			}
		}
	}
}
