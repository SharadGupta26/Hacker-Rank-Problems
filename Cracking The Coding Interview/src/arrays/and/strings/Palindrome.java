package arrays.and.strings;

public class Palindrome {
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String s = palindrome.readInput();
		System.out.println(palindrome.approach_1(s));
		System.out.println(palindrome.approach_2(s));
	}
	
	private String readInput() {
		//return "A man, a plan, a canal: Panama";
		return "race a car";
	}
	
	private boolean approach_1(String s) {
		s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if((c >= 'a' && c<= 'z') || (c >= '0' && c <= '1')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
	}
	
	private boolean approach_2(String s) {
		int start = 0;
		int end = s.length()-1;
		while(start < end) {
			char head = s.charAt(start);
			head = Character.toLowerCase(head);
			if(!Character.isLetterOrDigit(head)) {
				//not a alpha numeric, move on
				start++;
			} else {
				char tail = s.charAt(end);
				tail = Character.toLowerCase(tail);
				if(!Character.isLetterOrDigit(tail)) {
					//not a alpha numeric, move on
					end--;
				} else {
					if (tail != head) {
						return false;
					}
					start++;
					end--;
				}
			}
		}
		return true;
	}
}
