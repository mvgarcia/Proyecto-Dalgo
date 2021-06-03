package ProblemaB;


import java.util.ArrayDeque;
public class ProblemaB {
	
	//Autores: Pedro Vallejo, Valentina Garcia
	
	public int balanceoCarga(int[]t, int p)
	{
		int camin=0;
		int tamanio= Math.floorDiv(t.length, p);
		int res=t.length%p;
		if(res>0)tamanio+=1;
		ArrayDeque<Integer>[] a = new ArrayDeque[p];		
		
		int i=0;
		int[] valores = new int[p];
		for(int j=0;j<p && i<t.length;j++)
		{
			int cota=0;
			if(res>0) {cota= tamanio+1;res--;}
			else {cota=tamanio;}
			for(int k=0;k<cota;k++)
			{
				a[j].addLast(t[i]);
				valores[j]+=t[i];
				i++;
			}
		}
		
		boolean subio= false;
		while(subio)
		{
			int [] maxs=darMax(valores);
			int max=maxs[0];
			int posMax=maxs[1];
			if(posMax==0)
			{
				int cambio=a[posMax+1].getFirst()+a[posMax].getLast();
				valores[posMax]-=cambio;
				valores[posMax+1]+=cambio;
				a[posMax+1].addFirst(a[posMax].removeLast());
			}
			else if(posMax==valores.length-1)
			{
				int cambio=a[posMax].getFirst()+a[posMax-1].getLast();
				valores[posMax-1]+=cambio;
				valores[posMax]-=cambio;
				a[posMax-1].addLast(a[posMax].removeFirst());
			}
			else
			{
				int menor=valores[posMax-1];
				if(valores[posMax+1]<menor)menor=valores[posMax+1];
				if(menor==valores[posMax-1])
				{
					int cambio=a[posMax].getFirst()+a[posMax-1].getLast();
					valores[posMax-1]+=cambio;
					valores[posMax]-=cambio;
					a[posMax-1].addLast(a[posMax].removeFirst());
				}
				else
				{
					int cambio=a[posMax+1].getFirst()+a[posMax].getLast();
					valores[posMax]-=cambio;
					valores[posMax+1]+=cambio;
					a[posMax+1].addFirst(a[posMax].removeLast());
				}
			}
			int nuevoMax=darMax(valores)[0];
			if(nuevoMax>max)subio=true;
			camin=max;
		}
		
		return camin;
	}
	
	public int[] darMax(int[]valores)
	{
		int [] max=new int[2];
		for(int v=0;v<valores.length;v++) {
			if(v>max[0]) {
				max[0]=valores[v];
				max[1]=v;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
