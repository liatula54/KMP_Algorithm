package knuth_Morris_Pratt_algorithm;

/*
 * @author Liat Skladman
 * searches for occurrences of a "word" p within a main "text string" t
 */
public class StringSearchingAlgorithm {
	//return a array that maintain the size of prefix which is same as suffix
	private int[] longestsuffixequalprefixArray(char[] pattern){
		int [] lsep =new int[pattern.length];
		int index = 0;

		for(int i = 1; i < pattern.length;){
			if(pattern[i] == pattern[index]){
				lsep[i] = index+1;
				index++;
				i++;
			}
			else{
				if(index != 0){
					lsep[i] = 0 ;
					i++;
				}

			}
		}

		return lsep;
	}

	//pattern matching
	public boolean isSubstring(char[] text,char[] pattern){
		int i=0 , j =0, k = 0 ;
		while(i<text.length && j<pattern.length){
			if(text[i] ==pattern[j]){
				i++;
				j++;
			}
			else{
				j=0;
				k++;
				i=k;
			}
		}
		if(j == pattern.length){
			return true;
		}
		return false;
	}

	public boolean KMP(char[] t,char[] p){

		int[] lsep = longestsuffixequalprefixArray(p);
		int i = 0 ;
		int j = 0 ;

		while(i<t.length && j <p.length){
			if(t[i] ==p[j]){
				i++;
				j++;
			}
			else{
				if(j != 0){
					j = lsep[j-1];
				}
				else{
					i++;
				}
			}
		}
		if(j==p.length){
			return true;
		}
		return false;
	}


	public static void main(String args[]){
		String t = "abcdefgabcdf";
		String p = "cdf";

		StringSearchingAlgorithm ssa = new StringSearchingAlgorithm();
		boolean res = ssa.KMP(t.toCharArray(), p.toCharArray());
		System.out.println(res);
	}

}
