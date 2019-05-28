import java.util.Arrays;
import java.util.Random;

public class TheHiringProblem2 {


	float count = 0;
	static int countTot;

	 public static double sumOfTheSeries(int n) 
	    { 
	       // Computing sum term by term 
	        double sum = 0.0; 
	        float fract = (float) (1.0/n);

	       // System.out.println(" "+ 1/n);
	        //System.out.println("fract"+ fract);
	        for (int i = 2; i <= n; i++) {  
	            sum += 1.0 / ( (i - 1)); 
	        }
	        return sum*fract; 
	    } 

	public  void makeRandSets(int size ) {

		float ave=0 ;
		int num[] =  new int[size];
		int numOfSets = 10000;

		for ( int i = 0 ; i < num.length ; ++i) {
			num[i] = i+1;
		}
		//printArray(num);

		for ( int i =0; i < numOfSets ; ++i) {
			randomizedHireAssistant(num);
		}
		System.out.println("total number of hires : " +count+"  in "+ numOfSets+" sets");
		ave = count/numOfSets;
		System.out.println("average for "+numOfSets+ "  is "+ ave+"");
	}
	public  void makeRandSets1(int size ) {

		float ave=0 ;
		int num[] =  new int[size];
		int numOfSets = 1000000;

		for ( int i = 0 ; i < num.length ; ++i) {
			num[i] = i+1;
		}
		//printArray(num);

		for ( int i =0; i < numOfSets ; ++i) {
			randomizedHireAssistant(num);
		}
		System.out.println("total number of hires : " +count+"  in "+ numOfSets+" sets");
		ave = count/numOfSets;
		System.out.println("average for "+numOfSets+ "  is "+ ave+"");
	}


	//#2
	public void randomizedHireAssistant(int[] candidates) {
		int[] candidateList = Arrays.copyOf(candidates, candidates.length);

		randomizeInPlace(candidateList);
		//System.out.println("after randomize : ");
		//		printArray(candidateList);

		if(hireAssistant(candidateList)==2) {
			//			printArray(candidateList);
			//			System.out.println();

			count +=1;

		}
		//count +=hireAssistant(candidateList);
		//		System.out.println(" hire count : "+hireAssistant(candidateList));
		//return hireAssistant(candidateList);
	}


	private void randomizeInPlace(int[] array) {
		Random random = new Random();
		int n = array.length;
		for (int i = 0; i < n; ++i) {
			swap(array, i, random.nextInt(n - i) + i);
		}
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
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

	public static void printArray(int arr []) {

		for (int i =0 ; i < arr.length; ++i) {

			System.out.print(" "+arr[i]+ " ,");
		}
	}



	//#3
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
		System.out.println();
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


			if(hireAssistant(input)==2) {

				//System.out.println();
				//printArray(input);

				countTot +=1;

			}
			//countTot+=hireAssistant(input);
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
		//System.out.println();
	}

	public static void main  (String args[]) {




		TheHiringProblem2 hp = new TheHiringProblem2();
		System.out.println(hp.sumOfTheSeries(50));
		hp.makeRandSets(50);
		hp.makeRandSets1(50);

		hp.enumerPerm(8);

	}


}
