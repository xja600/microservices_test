

```powershell
@echo off
REM 声明采用UTF-8编码
chcp 65001
echo ------------开始启动apollo多环境服务---记得用管理员权限运行-------
start "dev-apollo-configservice" /D "E:\software\apollo2\dev\apollo-configservice-1.9.2-github" java -jar apollo-configservice-1.9.2.jar --server.port=8185 &
start "dev-apollo-adminservice"  /D  "E:\software\apollo2\dev\apollo-adminservice-1.9.2-github" java -jar apollo-adminservice-1.9.2.jar --server.port=8186 &
start "pro-apollo-configservice" /D "E:\software\apollo2\pro\apollo-configservice-1.9.2-github" java -jar apollo-configservice-1.9.2.jar --server.port=8287 &
start "pro-apollo-adminservice"  /D  "E:\software\apollo2\pro\apollo-adminservice-1.9.2-github" java -jar apollo-adminservice-1.9.2.jar --server.port=8288
echo ------------启动所有服务完成---------------------

pause
