public class Binomial { 
    public static void main(String[] args) {
      
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        

        System.out.println(binomial(n, k));
    }

    public static int binomial1(int n, int k) { 
        if (k > n) return 0;
        if (k == 0 || n == 0) return 1;
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }
    

    public static int binomial(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        

        int[][] memo = new int[n + 1][k + 1];
        
       
        return binomial(n, k, memo);
    }


    private static int binomial(int n, int k, int[][] memo) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n || n == 0) return 1;
               if (memo[n][k] > 0) {
            return memo[n][k];
        }
        
    
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}