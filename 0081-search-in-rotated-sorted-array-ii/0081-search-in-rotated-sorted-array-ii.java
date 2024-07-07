class Solution 
{
    public boolean search(int[] nums, int target) 
    {
        if(nums.length==1)
        {
            if(nums[0]==target)
                return true;
            else
                return false;
        }
        else
        {
            int left=0;
            int right=nums.length-1;
                while(left<=right)
                {
                  //  System.out.println("sdf"+left+"fsd"+right);
                    if(nums[left]==target || nums[right]==target)
                        return true;
                    if(target<nums[left] && target>nums[right])
                        return false;
                    if(nums[left]<target)
                        left++;
                    if(nums[right]>target)
                        right--;
                }
                return false;
        }
    
    }
}