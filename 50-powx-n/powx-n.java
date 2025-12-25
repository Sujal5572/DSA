class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            N=-N;
            x=1/x;
        }
        double ans =1.00;
        double curr = x;
        while(N>0){
            if(N%2==1)
            ans = ans* curr;

            curr = curr*curr;
            N = N/2;
        }
        return ans;

        // tc = Olog(n) ->using divide and conquer(16->8->4->2->1)  and sc is Olog(n)->due to recursive call stack
        // if(n==0)
        // return 1;
        // long N =n;
        // if(N<0){
        //     N=-N;
        //     x=1/x;
        // }

        // if(N%2==0)
        // return myPow(x*x,(int)(N/2));
        // else
        // return x*myPow(x,(int)(N-1));
        
    }
}