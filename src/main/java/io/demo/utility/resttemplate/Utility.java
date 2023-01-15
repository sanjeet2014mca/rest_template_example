package io.demo.utility.resttemplate;

public class Utility {

	public static int getInput(String st){
		int len=st.length();
		int sum=roman_int(st.charAt(0));
		if(len==2)          //if length of string = 2 like IV or VI
		{
			if(roman_int(st.charAt(1))>sum)
				sum=roman_int(st.charAt(1))-sum;
			else
				sum=sum+roman_int(st.charAt(1));
		}
		else {                  //length =1 or more than 2
			int i=0;
			sum=0;
			while(i<len-1)       //length = more than 2
			{    
				if( roman_int(st.charAt(i))>= roman_int(st.charAt(i+1)))
				{
					sum+=roman_int(st.charAt(i));
					i++;
				}

				else
				{      
					sum+=roman_int(st.charAt(i+1))-roman_int(st.charAt(i));
					i+=2;
				}
			}
			if(i==len-1)              //for string len =1
			{ sum+=roman_int(st.charAt(i));

			}
		}
		//System.out.println(Math.abs(sum));
		return Math.abs(sum);
	}
	static int roman_int(char ch) {
		int hi = 0;
		switch(ch) {
		case 'I':hi=1 ; break;
		case 'V':hi=5 ; break;
		case 'X':hi=10; break;
		case 'L':hi=50; break;
		case 'C':hi=100; break;
		case 'D': hi=500;break;
		case 'M': hi=1000; break;
		default: System.out.println("invalid input");
		}
		return hi;
	}
	public static String intToRoman(int num)   
	{  
		System.out.println("Integer: " + num);  
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
		StringBuilder roman = new StringBuilder();  
		for(int i=0;i<values.length;i++)   
		{  
			while(num >= values[i])   
			{  
				num = num - values[i];  
				roman.append(romanLetters[i]);  
			}  
		}  
		System.out.println("Corresponding Roman Numerals is: " + roman.toString());  
		return roman.toString();
				
	}  
}
