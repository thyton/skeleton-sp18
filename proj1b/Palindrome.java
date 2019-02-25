import java.util.concurrent.DelayQueue;

public class Palindrome {
    public Deque<String> wordToDeque(String word) {
        if (word == null)
            return null;
        Deque<String> deque = new ArrayDeque<String>();
        for(int i = 0; i < word.length(); ++i)
        {
            deque.addLast(String.valueOf(word.charAt(i)));
        }
        return deque;
    }

    private static boolean isPalindrome(Deque<String> deque) {
        return false;
    }

    public boolean isPalindrome(String word) {
        if(word.length() < 2)
            return true;
        Deque<String> deque = wordToDeque(word);
        while(deque.size() > 1){
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) {
            return true;
        }
        int j = word.length() - 1;
        for(int i = 0; j - i > 0; ++i, --j)
        {
            if(!cc.equalChars(word.charAt(i), word.charAt(j))) {
                 return false;
            }
        }
        return true;
    }
}