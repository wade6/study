/**
 * Project: study
 * File Created at 2013-5-13下午10:52:21
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-13下午10:52:21
 */
public class AppServiceImpl extends UnicastRemoteObject implements AppService {

    /**   **/
    private static final long serialVersionUID = -8108362354886474324L;

    /**
     * @throws RemoteException
     */
    public AppServiceImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @author zhaoyuanli
     * 2013-5-13下午10:52:21
     */
    @Override
    public String getInfo(String arg) throws RemoteException {
        // TODO Auto-generated method stub
        return "hello" +arg+ "!" ;
    }

}
