package bysj.weijia.greenhousemonitor.presenter;

import com.support.util.T;

import android.text.TextUtils;
import bysj.weijia.greenhousemonitor.biz.UserBiz;
import bysj.weijia.greenhousemonitor.listener.LoginListener;
import bysj.weijia.greenhousemonitor.view.SigninView;

public class SigninPresenter {
	private SigninView mView;
	private UserBiz mBiz;

	public SigninPresenter(SigninView mView) {
		this.mView = mView;
		mBiz = new UserBiz();
	}
	
	public void signin(){
		String uid = mView.getUsername();
		String pwd = mView.getPassword();
		
		if( TextUtils.isEmpty(uid.trim()) ){
			T.show("用户名不能为空");
			return;
		}
		
		if( TextUtils.isEmpty(pwd) ){
			T.show("密码不能为空");
			return;
		}
		
		mView.showLogining(true);
		mBiz.login(uid, pwd, new LoginListener() {
			
			@Override
			public void onSuccess() {
				mView.showLogining(false);
				mView.toMonitorPointActivity();
			}
			
			@Override
			public void onFailed() {
				mView.showFailedHint();
				mView.showLogining(false);
			}
		});
	}
	
	public void signup(){
		mView.toSignupActivity();
	}
}
