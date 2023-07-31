class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Brute Force
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        
        # Two-pass Hash Table
        # hash_table = {}
        # for i in range(len(nums)):
        #     hash_table[nums[i]] = i
        # for i in range(len(nums)):
        #     complement = target - nums[i]
        #     if complement in hash_table and hash_table[complement] != i:
        #         return [i, hash_table[complement]]
        
        # One-pass Hash Table
        hash_table = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hash_table:
                return [hash_table[complement], i]
            hash_table[nums[i]] = i
        return []