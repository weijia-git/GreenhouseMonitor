package bysj.weijia.greenhousemonitor.view;

public interface SigninView {
	public String getUsername();
	public String getPassword();
	public void showFailedHint();
	public void toMonitorPointActivity();
	public void toSignupActivity();
	public void showLogining(boolean isLogining);
}
/*
2.1 用户登录名
2.2 用户密码
2.3 登陆按钮
2.4 注册按钮
*/