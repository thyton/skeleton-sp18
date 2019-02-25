import java.util.concurrent.DelayQueue;

public class Palindrome {
    public boolean isPalindrome(String word) {
        if(word.length() < 2)
            return true;
        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1){
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public Deque<Character> wordToDeque(String word) {
        if (word == null)
            return null;
        Deque<Character> deque = new ArrayDeque<Character>();
        for(int i = 0; i < word.length(); ++i)
        {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) {
            return true;
        }
        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1){
            if (!cc.equalChars(deque.removeFirst(),deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}