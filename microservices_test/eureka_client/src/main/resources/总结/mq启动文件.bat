
```powershell
@echo off
REM 声明采用UTF-8编码
chcp 65001
echo ------------切换到rocketMq安装目录---记得用管理员权限运行-------
D:
cd D:\java_file\soft\rocketmq-all-4.4.0-bin-release\bin
echo ------------当前目录%cd%---------------------

echo ------------正在启动NameServer--------------
start mqnamesrv.cmd
echo ------------启动NameServer完成--------------


echo ------------正在启动Broker--------------------
start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
echo ------------启动Broker完成--------------------

pause
rem 没有部署控制台就注释掉下面的代码
echo ------------正在启动RocketMQ控制台---------
java -jar rocketmq-console-ng-1.0.1.jar --server.port=12581 --rocketmq.config.namesrvAddr=127.0.0.1:9876
echo ------------启动控制台完成---------------------


pause
