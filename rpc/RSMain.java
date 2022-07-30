/*
* RMI 서버의 메인 클래스
* RMI 서버 구현을 위해서는 UnicastRemoteObject 를 상속하면 가장 쉽게 만들 수 있다고 한다.
* 이 클래스로 RSMain.class와 RSMain_Stub.class를 만든다.
* */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RSMain extends UnicastRemoteObject implements RSInterface {
    public static final long serialVersionUID = 1L;

    public static final String BIND_NAME = "rs";

    // 메인함수. 바인딩하고 무한 대기한다.
    public static void main(String[] args) {
        System.out.println("[RMI-Server] START");

        try{
            Naming.rebind(BIND_NAME, new RSMain());

            while (true);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{Naming.unbind(BIND_NAME);} catch (Exception e){}
        }

        System.out.println("[RMI-Server] EXIT");
    }

    /**
     * UnicastRemoteObject를 상속했다면 반드시
     * RemoteException을 던지도록 생성자를 만들어 줘야 한다.
     * @throws RemoteException
     */
    public RSMain() throws RemoteException{
        super();
    }

    @Override
    public void println(String msg) throws RemoteException {
        //RMI 호출이 되면 메시지를 프린트한다.
        System.out.println("[RMI-SERVER]" + msg);
    }
}