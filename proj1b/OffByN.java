public class OffByN implements CharacterComparator {
    private int N;
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x-y) == N;
    }
    public OffByN(int N) {
        this.N = N;
    }
}