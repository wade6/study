/**
 * Project: study
 * File Created at 2013-5-13下午11:01:35
 */


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * 
 * @author zhaoyuanli
 * 2013-5-13下午11:01:35
 */
public class RmiClient {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String url = "rmi://127.0.0.1/getInfo";
        
        AppService app;
        
        app = (AppService)Naming.lookup(url);
        
        String result = app.getInfo("test");
        
        System.out.println(result);
    }

}
