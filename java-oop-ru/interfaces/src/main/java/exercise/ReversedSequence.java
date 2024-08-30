package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = this.reverse(str);
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @Override()
    public int length() {
        return str.length();
    }

    @Override()
    public char charAt(int index) {
        return str.toCharArray()[index];
    }

    @Override()
    public CharSequence subSequence(int start, int end) {
        var substr = this.str.substring(start, end);

        return new ReversedSequence(substr);
    }

    @Override()
    public String toString() {
        return this.str;
    }
}
// END
