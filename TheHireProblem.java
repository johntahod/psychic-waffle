import java.util.Random;

public class TheHireProblem {



	static int countTot = 0;



	//1. Output ∑ 1/i
	static float harmSeries (int n ) {

		float sum = 0;
		for (float i = 1 ; i <= n ; ++i) {

			sum = sum + ( 1 / i);


		}
		return sum;

	}

	public  void enumerPerm(int size ) {

		float ave ;
		int num[] =  new int[size];

		for ( int i = 0 ; i < num.length ; ++i) {

			num[i] = i+1 ;

		}


		factorialN(size);
		permuteArr(0,num);

		//System.out.println("total count  "+ countTot);

		ave = (float) (countTot / factorialN(size));
		//System.out.println("total count  "+ countTot);
		System.out.println("total ave from enum : "+ ave);






	}

	public double factorialN(int n ) {


		double factorial = 1;

		for ( double i =1 ;i <= n;  ++i) {
			factorial = factorial * i;

		}
		return factorial;

	}


	public static void permuteArr(int start, int [] input ) {




		if ( start == input.length) {
			countTot+=hireAssistant(input);
			//System.out.println("Hire count :"+hireAssistant(input));

			//printArray(input);

			return;

		}


		for (int i = start ; i < input.length ; i++) {

			//swapping
			int temp = input[i];
			input [i] = input[start];
			input[start] = temp;

			//swapping (input[i],input[start]);
			permuteArr(start + 1 , input);
			//call again AKA recursion . . .

			int temp1 = input[i];
			input[i] = input[start];
			input[start] = temp1;


		}



	}
	public static int hireAssistant (int [] candidates) {

		int best =0;
		int numberOfHired  = 1 ;
		best = candidates[0];

		//interview candidates i 
		for(int i = 0; i < candidates.length ; ++i) {

			if( candidates[i] < best){

				best = candidates[i];
				numberOfHired += 1;

			}
		}


		return numberOfHired;



	}

	static void tenKMethod(int n) {

		int arr[] = new int[n];
		for (int i = 0 ; i < arr.length;++i) {

			arr[i] = i+1;
		}
		randomizeInPlace(arr);




	}
	private static void randomizeInPlace(int [] arr) {

		Random random = new Random();
		int hiredCount [] = new int [10000];

		for(int i =0; i < arr.length;++i) {
			//System.out.println();
			//printArray(arr);

			//System.out.println("Hire count : "+hireAssistant(arr));

			swap(arr,i,random.nextInt(arr.length-1) + 1);
		}



	}
	

	private static void swap (int [] arr, int a, int b ) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;


	}


	static void tenKenum(int t)//function for 2nd method
	{
		Random rand=new Random();//rand object of random class for random values
		int arr[]=new int[10000];//array of 10000 for storing number of hires for each array
		for(int i=0;i<10000;i++)
		{
			int count=0;
			int a[]=new int[t];
			for(int j=0;j<t;j++)
				//				randomizedHireAssistant	(a);	
				//	randomizeInPlace(a);

				a[j]= (int)(Math.random() * ((t - 1) + 1)) + 1;

			//a[j]=rand.nextInt(t - 1 )+ t;//this will store random values into array
			randomizeInPlace(a);


			//randomizedHireAssistant	(a);	
			for(int j=1;j<t;j++)
				if(a[j]<a[j-1])
					count++;
			arr[i]=count;


		}
		float sum1=0;
		for(int i=0;i<10000;i++)//for average output
		{
			sum1=sum1+arr[i];
		}
		sum1=sum1/10000;
		//	printArray(arr);
		System.out.println("OUTPUT FROM 10,000  IS:= "+sum1);
	}



	static double lnN (int n ) {

		double num = Math.log(n);

		return num;
	}

	public static void printArray (int [] arr) {

		for (int i  =  0 ; i <arr.length;++i) {

			System.out.print(" "+arr[i]+" ,");
		}
	}



	public static void main ( String args [] ) {

		TheHireProblem hp = new TheHireProblem();


		System.out.println(hp.harmSeries(8));
		hp.tenKenum(8);

		hp.enumerPerm(8);


		//System.out.println(hp.factorialN(3));

		//hp.tenKMethod(3);
		System.out.println(hp.lnN(8));



	}

}
