javac AppService.java

javac AppServiceImpl.java

rmic AppServiceImpl 

javac RmiClient.java

javac RmiServer.java

start rmiregistry // ����Rmi Registry��������

java RmiServer  // ���������

java RmiClient  // �����ͻ���