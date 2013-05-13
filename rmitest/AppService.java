/**
 * Project: study
 * File Created at 2013-5-13下午10:49:02
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-13下午10:49:02
 */
public interface AppService extends Remote {

    public String getInfo(String arg) throws RemoteException;
}
