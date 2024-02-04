package Backtrack;

import java.util.*;

public class DessertCost {

//    public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppingCosts, int target) {
//        int diff=Integer.MAX_VALUE;
//        int ans=Integer.MAX_VALUE;
//        for(int base  : baseCosts){
//            int res= helper(0,toppingCosts,base,target);
//            int absDiff=Math.abs(target-res);
//            if(diff>absDiff){
//                diff=absDiff;
//                ans=res;
//            }
//            else if(diff==absDiff){
//                ans=Math.min(ans,res);
//            }
//        }
//        return ans;
//    }
//    public static int helper(int idx,ArrayList<Integer> toppingCost,int cost,int target){
//        if(idx==toppingCost.size()){
//            return cost;
//        }
//        int diff=Integer.MAX_VALUE;
//        int rtrnVal=Integer.MAX_VALUE;
//        for(int take=0;take<=2;take++){
//            int res=helper(idx+1,toppingCost,cost+take*toppingCost.get(idx),target);
//            int absDiff=Math.abs(target-res);
//            if(diff>absDiff){
//                diff=absDiff;
//                rtrnVal=res;
//            }
//            else if(diff==absDiff){
//                rtrnVal=Math.min(rtrnVal,res);
//            }
//        }
//        return rtrnVal;
//    }


    static int result;
    public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppingCosts, int target) {
        result = baseCosts.get(0);
        for(int base: baseCosts)
            helper(base, toppingCosts, 0, target);
        return result;
    }
    private static void helper(int current, ArrayList<Integer> toppingCosts, int index, int target) {
        if( Math.abs(target - current) < Math.abs(target - result) || Math.abs(target - current) == Math.abs(target - result) && current < result)
            result = current;
        if(index==toppingCosts.size() || current >= target) return;
        helper(current, toppingCosts, index + 1, target);
        helper(current + toppingCosts.get(index), toppingCosts, index + 1, target);
        helper(current + toppingCosts.get(index)*2, toppingCosts, index + 1, target);
    }

    public static void main(String[] args) {

        int N = 2;
        int M = 2;
        int K = 10;

        ArrayList<Integer> flavors = new ArrayList<>();
        ArrayList<Integer> toppings = new ArrayList<>();

        flavors.add(1);
        flavors.add(7);
        toppings.add(3);
        toppings.add(4);

        int result = closestCost(N,M, flavors, toppings, K);
        System.out.println("Closest possible cost to the target: " + result);
    }
}
