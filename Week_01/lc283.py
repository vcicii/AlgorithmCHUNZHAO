nums = [1,2,0,2,0,3,4]
l = len(nums)
idx = 0 #1
for i in range(l):
    if nums[i] != 0:
        nums[idx] = nums[i]
        if i != idx:
        # 因为在 第一个零出现前的数都是正确的，并不需要跟0换位，
        # idx始终等于i。只有出现过一次o0之后，idx与i逐渐岔开
            print(f'i {i} idx {idx}')
            nums[i] = 0
            print(nums)
        idx += 1

