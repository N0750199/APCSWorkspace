package apTerm1ExamFiles;
//Jack Croft
//Problem 5


public class MyArrayList {
   // Declare fields required to manage this class here.

	private int[] arrayList;
	private boolean[] added;

	public MyArrayList()
	{	
		arrayList=new int[10];
		added=new boolean[10];
	}

	public MyArrayList(int capacity)
	{	
		arrayList=new int[capacity];
		added=new boolean[capacity]; 
	}

	public int size()
	{	
		int trues=0;
		for(int i=0;i<added.length;i++)
		{
			if(added[i])
				trues++;
		}
		return trues;
	}

	public boolean isEmpty()
	{	
		for(int i=0;i<arrayList.length;i++)
		{
			if(added[i])
				return false;
		}
		return true;
	}
	
	public boolean add(int item)
	{	
		int temp=arrayList.length;
		for(int i=0;i<arrayList.length;i++)
		{
			if(added[i]==false)
			{
				arrayList[i]=item;
				added[i]=true;
				return true;
			}
		}
		growList();
		
		arrayList[temp]=item;
		added[temp]=true;
		return true;
	}

	public boolean add(int i, int item)
	{
		if(!added[i-1])
			return false;
			
		if(added[i]==false)
		{
			arrayList[i]=item;
			added[i]=true;
			return true;
		}
		else
		{
			int[] temp=new int[arrayList.length+1];
			
			for(int j=0;j<arrayList.length;j++)
			{
				if(j==i)
					temp[j]=item;
				if(j<i)
					temp[j]=arrayList[j];
				if(j>i)
					temp[j]=arrayList[j-1];
			}
			arrayList=temp;
			
			boolean[] temp2= new boolean[added.length+1];
			for(int j=0;j<added.length;j++)
			{
				if(j==i)
					temp2[j]=true;
				if(j<i)
					temp2[j]=added[j];
				if(j>i)
					temp2[j]=added[j-1];
			}
			added=temp2;
			
			return true;
		}
		
	}

	public int get(int i) 
	{
		return arrayList[i];
		
	}

	public int set(int i, int val) 
	{
		if(!added[val])
			return 0;
		
		int temp=arrayList[i];
		arrayList[i]=val;
		added[i]=true;
		return temp;
	}

	public int remove(int i) 
	{
		int temp=arrayList[i];
		
		for(int j=i;j<arrayList.length-1;j++)
		{
			arrayList[j]=arrayList[j+1];
		}
		arrayList[arrayList.length-1]=0;
		
		
		for(int j=i;j<added.length-1;j++)
		{
			added[j]=added[j+1];
		}
		added[added.length-1]=false;
		
		return temp;
	}

	//Private Helper Methods
	private void growList()
	{
		int[] temp=new int[arrayList.length*2];
		for(int i=0;i<arrayList.length;i++)
		{
			temp[i]=arrayList[i];
		}
		arrayList=temp;
		
		boolean[] temp2=new boolean[added.length*2];
		for(int i=0;i<added.length;i++)
		{
			temp2[i]=added[i];
		}
		added=temp2;
		
	}



}
