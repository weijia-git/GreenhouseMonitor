package bysj.weijia.greenhousemonitor.view;

public interface SignupView {
	public String getUsername();

	public String getPassword();

	public String getMonitorName();

	public String getMonitorIp();

	public String getMonitorPort();

	public void toSigninActivity();
	
}