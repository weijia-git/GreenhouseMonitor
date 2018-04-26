package bysj.weijia.greenhousemonitor.presenter;

import bysj.weijia.greenhousemonitor.biz.UserBiz;
import bysj.weijia.greenhousemonitor.view.SignupView;

public class SignupPresenter {
	private SignupView mView;
	private UserBiz mBiz;

	public SignupPresenter(SignupView view) {
		this.mView = view;
	}

	public void signup() {
		mView.toSigninActivity();
	}
}
