package codingChallenge;

// by Duji Tufail
// for Bioconnect's coding challenge

import java.util.HashSet;
import java.util.Set;

public class CodingChallenge {

	static Set<String> set = new HashSet<String>(); // to avoid duplicates

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String input = "identity";
		Set<String> result = findPerms(input);
		printSet(result);
	}

	
	
	//  Recursive Algorithm:
    //	Lop off last character. Save it as our "moving character"
	//  find all permutations of this string (with the one character popped off)
	//  insert moving character into all possible "spots" for each permutation of strings acquired from previous step
	
	// BIG O Analysis:
	// We multiply the runtime of the size of the string by every single permutation of P(n-1). We do this N times.
	// eg. for P("abx") we insert "x" into all places for all P("ab") which are ["ab","ba"]
	
	private static Set<String> findPerms(String input){

		Set<String> output = new HashSet<String>();

		if(input.length() == 1){
			output.add(input);
			return output;
		}

		if(input.length() >= 2){

			String leftofSplit = "", rightofSplit = "", permutationString = "";
			char moveableCharacter = input.charAt(input.length()-1); // moveable character is the last character of input
			input = input.substring(0,input.length()-1); // now chop off last character of input eg "abc" -> "ab"


			Set<String> previousOutput = findPerms(input); // recursive step

//			System.out.println(previousOutput.size());  // for Test purposes
			
			for(String s: previousOutput){
//				System.out.println("Iterating for string: " + s); // for Test purposes

				for(int i = 0; i < s.length(); i++){
					leftofSplit = s.substring(0,i);
					rightofSplit = s.substring(i);
					permutationString = leftofSplit + moveableCharacter + rightofSplit;
					output.add(permutationString);
				}
				permutationString = leftofSplit + rightofSplit + moveableCharacter;
				output.add(leftofSplit + rightofSplit + moveableCharacter); // corner case
			}
		}
		return output;
	}



	public static  void printSet(Set<String> result){ 

		for(String s: result){
			System.out.println(s);
		}
		System.out.println(result.size());
	}


}
