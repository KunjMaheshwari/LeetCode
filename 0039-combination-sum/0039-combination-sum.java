class Solution {
    public void funct(List<Integer> v, int i, int sum, List<Integer> v2, List<List<Integer>> ans){
        if(sum == 0){
            ans.add(new ArrayList<>(v2));
            return;
        }

        if(sum <0 || i < 0){
            return;
        }

        funct(v, i-1, sum, v2, ans);
        v2.add(v.get(i));
        funct(v, i, sum-v.get(i), v2, ans);
        v2.remove(v2.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        for(int candidate : candidates){
            v.add(candidate);
        }

        funct(v, v.size()-1, target, new ArrayList<>(), ans);

        return ans;
    }
}