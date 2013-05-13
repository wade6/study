/**
 * Project: study
 * File Created at 2013-5-13下午10:59:38
 */

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * 
 * @author zhaoyuanli
 * 2013-5-13下午10:59:38
 */
public class RmiServer {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        AppService app = new AppServiceImpl();
        Naming.bind("getInfo", app);
    }

}
