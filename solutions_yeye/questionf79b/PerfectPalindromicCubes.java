public class PerfectPalindromicCubes {

    public static void main(String[] args) {
        int x = 0;
        while (x <= 1500) {
            if (isPalindrome(String.valueOf(x*x*x))) {
                System.out.println(x + " cubed is " + x*x*x);
            }
            x++;
        }
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (r > l) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
