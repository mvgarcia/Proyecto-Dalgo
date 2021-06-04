package ProblemaB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaB {
	
	public int balanceoCarga(int[]t, int p)
	{
		int camin=0;
		int[][] indices = new int [p][2]; //indices[p][0]:inicio, indices[p][1]:fin
		
		for(int i=1;i<=p;i++)
		{
			indices[p-i][0]=t.length-i;
			indices[p-i][1]=t.length-i;
		}
		indices[0][0]=0;
		
		int []valores= vals(indices,t,p);
		
		int max[]=darMax(valores);
		int mejor=max[0];
		while(max[1]!=p-1)
		{
			indices[max[1]][1]-=1;
			indices[max[1]+1][0]-=1;
			valores=vals(indices,t,p);
			max=darMax(valores);
			if(max[0]<mejor)
			{
				mejor=max[0];
			}
			camin=mejor;
		}
		
		return camin;
	}
	
	
	public int[] vals(int[][]indices, int[]t,int p)
	{
		int valores[]=new int[p];
		for(int i=0;i<p;i++)
		{
			for(int j=indices[i][0];j<=indices[i][1];j++)
			{
				valores[i]+=t[j];
			}
		}
		return valores;
	}
	
	
	public int[] darMax(int[]valores)//max[0]:suma, max[1]:pos
	{
		int [] max=new int[2];
		for(int i=0;i<valores.length;i++) {
			int v=valores[i];
			if(v>max[0]) {
				max[0]=v;
				max[1]=i;
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		ProblemaB instancia = new ProblemaB();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
			
			while(line!=null && line.length()>0 && !"0 0".equals(line)) {
				final String [] dataStr = line.split(" ");
				int n=Integer.parseInt(dataStr[0]);
				int p= Integer.parseInt(dataStr[1]);
				line = br.readLine();
				final String [] dataStr1 = line.split(" ");
				final int[] t = Arrays.stream(dataStr1).mapToInt(f->Integer.parseInt(f)).toArray();
				
				System.out.println();
				int camin = instancia.balanceoCarga(t, p);
				System.out.print(camin);
				line = br.readLine();
			}
		}
	}

}
