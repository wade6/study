javac AppService.java

javac AppServiceImpl.java

rmic AppServiceImpl 

javac RmiClient.java

javac RmiServer.java

start rmiregistry // 启动Rmi Registry服务器：

java RmiServer  // 启动服务端

java RmiClient  // 启动客户端