public class Binomial { 
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide n and k.");
            return;
        }
        try {
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            
       
            if (n < 0 || k < 0) {
                System.out.println("n and k must be non-negative.");
                return;
            }

            System.out.println("Result: " + binomial(n, k));
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers.");
        }
    }

   
    public static long binomial(int n, int k) {
       
        if (k < 0 || k > n) return 0;
        
   
        long[][] memo = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return binomialRecursive(n, k, memo);
    }

    private static long binomialRecursive(int n, int k, long[][] memo) {
   
        if (k == 0 || k == n) {
            return 1;
        }
        
     
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

      
        memo[n][k] = binomialRecursive(n - 1, k, memo) + binomialRecursive(n - 1, k - 1, memo);
        return memo[n][k];
    }
}