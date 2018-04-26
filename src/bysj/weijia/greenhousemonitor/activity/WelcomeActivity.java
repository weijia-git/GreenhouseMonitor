package bysj.weijia.greenhousemonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.WelcomePresenter;
import bysj.weijia.greenhousemonitor.view.WelcomeView;

public class WelcomeActivity extends BaseActivity implements WelcomeView{

	
	private WelcomePresenter mPresenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		mPresenter = new WelcomePresenter(this);
		mPresenter.onEnter();
	}

	@Override
	public void enterSigninActivity() {
		startActivity(new Intent(this, SigninActivity.class));
		finish();
	}
	@Override
	public void onBackPressed() {
		
	}
}
