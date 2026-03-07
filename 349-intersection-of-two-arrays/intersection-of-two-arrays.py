class Solution:
    def intersection(self, nums1, nums2):
        result = []
        
        for num in set(nums1):
            if num in nums2:
                result.append(num)
                
        return result
        