package bysj.weijia.greenhousemonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.SignupPresenter;
import bysj.weijia.greenhousemonitor.view.SignupView;

public class SignupActivity extends BaseActivity implements SignupView {
	
	private SignupPresenter mPresenter;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_signup);
		mPresenter = new SignupPresenter(this);
		setDoubleClickExit(true);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMonitorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMonitorIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMonitorPort() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onChildClick(View v) {
		mPresenter.signup();
	}

	@Override
	public void toSigninActivity() {
		startActivity(new Intent(this, SigninActivity.class));
		finish();
	}

}
