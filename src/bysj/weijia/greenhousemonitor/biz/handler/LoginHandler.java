package bysj.weijia.greenhousemonitor.biz.handler;

import android.os.Handler;
import android.os.Message;
import bysj.weijia.greenhousemonitor.listener.LoginListener;

public class LoginHandler extends Handler {
	public static final int MSG_SIGNIN_SUCCESS = 0;
	public static final int MSG_SIGNIN_FAILED = 1;
	private LoginListener lis;

	public LoginHandler(LoginListener lis) {
		this.lis = lis;
	}

	@Override
	public void handleMessage(Message msg) {
		if (msg.what == MSG_SIGNIN_SUCCESS) {
			lis.onSuccess();
		} else {
			lis.onFailed();
		}
	}
}
