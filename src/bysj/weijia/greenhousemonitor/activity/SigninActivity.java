package bysj.weijia.greenhousemonitor.activity;

import com.support.widget.ClearEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.SigninPresenter;
import bysj.weijia.greenhousemonitor.view.SigninView;

public class SigninActivity extends BaseActivity implements SigninView {

	private SigninPresenter mPresenter;
	private ClearEditText cetUid;
	private ClearEditText cetPwd;
	private TextView tvSignin, tvSignup;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_signin);
		initView();
		mPresenter = new SigninPresenter(this);
	}

	public void initView() {
		setDoubleClickExit(true);
		setHeader("登录");
		setNoBack();
		cetUid = (ClearEditText) findViewById(R.id.cet_uid);
		cetPwd = (ClearEditText) findViewById(R.id.cet_pwd);
		tvSignin = (TextView) findViewById(R.id.tv_signin);
		tvSignup = (TextView) findViewById(R.id.tv_signup);
	}

	@Override
	public String getUsername() {
		return cetUid.getText().toString();
	}

	@Override
	public String getPassword() {
		return cetPwd.getText().toString();
	}

	@Override
	public void showFailedHint() {
		tos("登录失败！");
	}

	@Override
	public void toMonitorPointActivity() {
		startActivity(new Intent(this, MonitorPointActivity.class));
		finish();
	}

	@Override
	public void onChildClick(View v) {
		switch (v.getId()) {
		case R.id.tv_signin:
			mPresenter.signin();
			break;
		case R.id.tv_signup:
			mPresenter.signup();
			break;
		default:
			break;
		}
	}

	@Override
	public void toSignupActivity() {
		startActivity(new Intent(this, SignupActivity.class));
		finish();
	}

	@Override
	public void showLogining(boolean isLogining) {
		tvSignin.setEnabled(!isLogining);
		tvSignup.setEnabled(!isLogining);
		tvSignin.setText(isLogining ? "正在登录,请稍等..." : "登录");
	}

}
