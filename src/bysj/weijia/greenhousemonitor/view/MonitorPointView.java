package bysj.weijia.greenhousemonitor.view;

public interface MonitorPointView {
	public String getPointName();
	public void setPointName(String name);
	public String getPointIp();
	public void setPointIp(String ip);
	public String getPointPort();
	public void setPointPort(int port);
	public void toMonitorActivity();
}


/**
 * 3.视频监控端口确认
  3.1 监控地点名称
  3.2 监控点IP地址
  3.3 监控点端口

 */