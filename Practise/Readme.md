#需求
对于一个给定的字符串，如果其中元音字母数目在整个字符串中的比例超过了30%，则将该元音字母替换成字符串mommy，额外的，在替换时，如果有连续的元音出现，则仅替换一次。

#分析
- 输入： string
- 输出： string
- 功能： 按需替换元音字母

- 过程中需要得到的信息：
    - 元音字母： a e i o u, 替换成：mommy
    - 是否可替换： Length(yuanyin) / Length(input) > 0.3    
    - 元音是否连续
        - yes: 替换一次
        - no: 每个元音都替换
    - 边界条件： 数字， 大小写
        
#Example
- Input: hmm  -> hmm
- Input: she -> shmommy
- Input: hear -> hmommyr 

#Tasking
- 判断是否为元音
- 判断是否可替换
- 判断元音是否连续
- 不连续元音， 可逐个替换mommy
- 连续元音， 仅替换一次


#Notes:
- mark dic as source folder first, then use refactor tool to generate file and put it into target folder



