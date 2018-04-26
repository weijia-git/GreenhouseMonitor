package bysj.weijia.greenhousemonitor.activity;

import com.support.widget.ClearEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.MonitorPointPresenter;
import bysj.weijia.greenhousemonitor.view.MonitorPointView;

public class MonitorPointActivity extends BaseActivity implements MonitorPointView {
	
	private MonitorPointPresenter mPresenter;
	private ClearEditText cetPointName, cetPointIp, cetPointPort;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_monitorpoint);
		initView();
		mPresenter = new MonitorPointPresenter(this);
		mPresenter.init();
	}

	public void initView() {
		setDoubleClickExit(true);
		setHeader("监控点确认");
		setNoBack();
		cetPointName = (ClearEditText) findViewById(R.id.cet_ptname);
		cetPointIp = (ClearEditText) findViewById(R.id.cet_ptip);
		cetPointPort = (ClearEditText) findViewById(R.id.cet_ptport);
	}

	@Override
	public String getPointName() {
		return cetPointName.getText().toString();
	}

	@Override
	public String getPointIp() {
		return cetPointIp.getText().toString();
	}

	@Override
	public void toMonitorActivity() {
		startActivity(new Intent(this, MonitorActivity.class));
		finish();
	}
	
	@Override
	public void onChildClick(View v) {
		mPresenter.confirm();
	}

	@Override
	public void setPointName(String name) {
		cetPointName.setText(name);
	}

	@Override
	public void setPointIp(String ip) {
		cetPointIp.setText(ip);
	}

	@Override
	public String getPointPort() {
		return cetPointPort.getText().toString();
	}

	@Override
	public void setPointPort(int port) {
		cetPointPort.setText(String.valueOf(port));
	}

}
