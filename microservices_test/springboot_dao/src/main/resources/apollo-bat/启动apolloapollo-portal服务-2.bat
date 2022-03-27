

```powershell
@echo off
REM 声明采用UTF-8编码
chcp 65001
echo ------------开始启动apollo多环境服务---记得用管理员权限运行-------
echo ------------切换到apollo-portal安装目录-------
E:
cd  E:\software\apollo2\apollo-portal-1.9.2-github
echo ------------当前目录%cd%---------------------

echo ------------正在启动apollo-portal服务--------------
java -jar apollo-portal-1.9.2.jar --server.port=8270
echo ------------启动dev-apollo-configservice服务完成--------------

echo ------------启动所有服务完成---------------------


pause
