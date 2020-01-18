#questions:
1. 按照之前需求是执行完所有command后返回位置朝向信息
- 掉坑里是直接返回么？ 否则怎么处罚创建新车的命令？
- 地形上触发不能移动， 是不能M， 还是不能MLR？  can B？can unlock?
- 触发不能移动后如何操作？返回， init？
- 触发不能移动后， 旧地的车还在地图上？ 不回收？

2. bus, 转弯的时候， 右侧两格不能是X， 如何理解？



# 假设
结合实际情况， 地图是来到火星时就知道的， 假设地图是所有车共享信息。

- init 随机
- 掉坑里， 忽略后续command， 返回， 并触发factory init 并发送新的。command是后续的
- 不能移动也返回，仅限不能M， 触发即返回， 不执行后续命令
- 假设map 10 * 10
- 车的异常状态： BL（ignore L， B+R）， BR（ignore R， B+ L） BM （ignore M）， BB （ignore B）
BH（for BUS|TRACK， 车头坏了， 忽略任何命令）， BT 
- type： CAR|BUS|TRACK
BUS|TRACK, 占两个，任何一个掉坑里or 触发不能移动都结束


#Tasking：
- init, steup model
- handle m
- add B command,
- inverse MLR when has B
- BB change back
- add radar and map
- radar get is in hole, and mark in map
- init map info with can move range, ignore M when in that range
- add broken status, BL, BR
- add with type.
- bus|track handle L , R 
- track add BH, BT 
- handle unlock command for track
- output and return



