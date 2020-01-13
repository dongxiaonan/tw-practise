# Mars Rover  

## Requirements:
假想你在火星探索团队中负责软件开发。现在你要给登陆火星的探索小车编写控制程序，根据地球发送的控制指令来控制火星车的行动。
- 火星车收到的指令分为：
    - 初始化信息：火星车的降落地点（x, y）和朝向（N, S, E, W）信息；
    - 移动指令：火星车可以前进（M）,一次移动一格；
    - 转向指令：火星车可以左转90度（L）或右转90度（R）。

由于地球和火星之间的距离很远，指令必须批量发送，火星车执行完整批指令之后，再回报自己所在的位置坐标和朝向。
## Understanding:
- input: List<Order>   output: point and direction -> Extract an model
- Direction could be enum: N S W E, easy switch
- Point is (x, y)
- Order could be :
    - INIT -  point and direction
    - MOVE -  based on direction +1, for example (0, 0)
        - N (0, 1)
        - S (0, -1)
        - W (-1, 0)
        - E (1, 0)
    - TURN :
        - L: N -> W; 
        - R: N -> E;
        
- Assumption:
    - Order:INIT could only run at first, and once, must have
    - No boundary info. Int is enough?

## Tasking:
- setup init order, init with point and direction, and return point and direction
- can move
- can turn

## Note:
1. Why could not auto download and install pkg by maven? -- mockito

