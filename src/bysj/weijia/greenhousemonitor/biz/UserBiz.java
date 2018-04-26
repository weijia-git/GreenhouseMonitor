package bysj.weijia.greenhousemonitor.biz;

import java.util.Random;

import bysj.weijia.greenhousemonitor.biz.handler.LoginHandler;
import bysj.weijia.greenhousemonitor.listener.LoginListener;

public class UserBiz{
	
	public void login(String uid, String pwd, final LoginListener lis){
		final LoginHandler mh = new LoginHandler(lis);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mh.obtainMessage(new Random().nextInt(100) > 50 ? LoginHandler.MSG_SIGNIN_SUCCESS : LoginHandler.MSG_SIGNIN_FAILED).sendToTarget();
			}
		}).start();
	}
	
	
	
}