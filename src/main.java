import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
	
	StringBuilder dec = new StringBuilder();
	
	Scanner in = new Scanner(System.in);
	
	System.out.println("Input text:");
	String text = in.nextLine();
	System.out.println("Input keyword:");
	String keyword = in.nextLine();
	char[][] matr = {	{'a', 'b', 'c', 'd', 'e', 'f'},
						{'g', 'h', 'i', 'j', 'k', 'l'},
						{'m', 'n', 'o', 'p', 'q', 'r'},
						{'s', 't', 'u', 'v', 'w', 'x'},
						{'y', 'z', '0', '1', '2', '3'},
						{'4', '5', '6', '7', '8', '9'}	};
	
	char[] f_key = {'a', 'l', 'h', 'm', 's', 't'};
	int[] f_key_2 = {0, 1, 2, 3, 4, 5};
	
	char[] num_1 = new char[text.length() * 2];
	for (int c = 0; c < text.length(); c++) {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				if (matr[i][j] == text.charAt(c)) {
					num_1[c * 2] = f_key[i];
					num_1[c * 2 + 1] = f_key[j];
					}
				}
			}
		}
	
	System.out.println("Text:");
	System.out.println(text);
	
	System.out.println("First code:");
	for(int i=0;i<text.length()*2;i++)
		System.out.print(num_1[i]);
	
	System.out.println("\nMatrix firt code:");
	char[][] m_f_code = new char [2][text.length()];
	
	for(int i=0; i<2; i++) {
		for(int j=0; j<text.length(); j++) {
			if(i==0)
				m_f_code[i][j]=num_1[j];
			else
				m_f_code[i][j]=num_1[j+text.length()];
			System.out.print(m_f_code[i][j]);
		}
	System.out.println();
	}
	
	System.out.println("Keyword:");
	System.out.println(keyword);
	
	char[] keyword_Arr = keyword.toCharArray();
	char[] sort_keyword_Arr = Arrays.copyOf(keyword_Arr, keyword_Arr.length);
	Arrays.sort(sort_keyword_Arr);
	
	System.out.println("Keyword sort:");
	System.out.println(sort_keyword_Arr);
	
	int[] number = new int[keyword.length()];
	int k = 0;
	for(int j = 0; j < sort_keyword_Arr.length; j++)
		for(int i = 0; i < sort_keyword_Arr.length; i++)
			if(sort_keyword_Arr[j] == keyword_Arr[i]) {
				number[k] = i;
				k++;
			}
	
	System.out.println("Keyword sort num:");
	for(int i = 0; i < sort_keyword_Arr.length; i++)
		System.out.print(number[i]);
	
	char[] num_2 = new char[text.length() * 2];
	System.out.println("\nSort matrix firts code:");
	for(int i = 0; i < 2; i++) {
		for(int j = 0; j < text.length(); j++) {
			System.out.print(m_f_code[i][number[j]]);
			if(i==0)
				num_2[j] = m_f_code[i][number[j]];
			else
				num_2[j + text.length()] = m_f_code[i][number[j]];
		}
		System.out.println();
	}
	
	System.out.println("Second code:");
	for(int i=0; i<text.length()*2; i++)
		System.out.print(num_2[i]);
		
	System.out.println("\nFirst decode:");
	for(int i=0;i<text.length()*2;i++)
		System.out.print(num_2[i]);
	
	System.out.println("\nMatrix firt decode:");
	char[][] m_f_decode = new char [2][text.length()];
	
	for(int i=0; i<2; i++) {
		for(int j=0; j<text.length(); j++) {
			if(i==0)
				m_f_decode[i][j]=num_2[j];
			else
				m_f_decode[i][j]=num_2[j+text.length()];
			System.out.print(m_f_decode[i][j]);
		}
		System.out.println();
	}
	
	System.out.println("Matrix second decode:");
	char[][] dec_matr = new char[2][text.length()];
	for(int i = 0; i < 2; i++) {
		for(int j = 0; j < text.length(); j++)
			dec_matr[i][number[j]] = m_f_decode[i][j];
	}
	
	for(int i=0; i<2; i++) {
		for(int j=0; j<text.length(); j++)
			System.out.print(dec_matr[i][j]);
		System.out.println();
	}
	
	char[] num_4 = new char[text.length() * 2];
	for(int i = 0; i < 2; i++) {
		for(int j = 0; j < text.length(); j++) {
			if(i==0)
				num_4[j] = dec_matr[i][j];
			else
				num_4[j + text.length()] = dec_matr[i][j];
		}
	}
	
	System.out.println("Second decode:");
	for(int i=0; i<text.length()*2; i++)
		System.out.print(num_4[i]);
	
	System.out.println();
	int[] num_d = new int[text.length() * 2];
	for(int i=0; i<text.length()*2; i++) {
		for(int j=0; j<f_key_2.length; j++) {
			if(num_4[i]==f_key[j])
				num_d[i] = f_key_2[j];
		}
	}
	
	System.out.println("\nFinal decode text:");
    for(int i=0;i<num_4.length/2;i++)
    	dec.append(matr[num_d[i*2]][num_d[i*2+1]]);
    String decode = dec.toString();
		System.out.println(decode);
	
	}
}