package bysj.weijia.greenhousemonitor.presenter;

import android.os.Handler;
import bysj.weijia.greenhousemonitor.view.WelcomeView;

public class WelcomePresenter {
	private WelcomeView mView;
	private final int welcomeMillis = 500;

	public WelcomePresenter(WelcomeView mView) {
		this.mView = mView;
	}
	
	public void onEnter(){
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				mView.enterSigninActivity();
			}
		}, welcomeMillis);
	}
	
}
