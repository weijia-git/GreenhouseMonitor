package bysj.weijia.greenhousemonitor.activity;

import android.content.Intent;
import android.os.Bundle;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.MonitorPresenter;
import bysj.weijia.greenhousemonitor.view.MonitorView;

public class MonitorActivity extends BaseActivity implements MonitorView {
	private MonitorPresenter mPresenter;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_monitor);
		initView();
		mPresenter = new MonitorPresenter(this);
		mPresenter.monitor();
	}

	private void initView() {
		setDoubleClickExit(true);
		setHeader("监控中");
		setNoBack();
		setImgRight(R.drawable.ic_analyze, this);
	}

	@Override
	public void onBackClick() {
		tos("setting");
	}

	@Override
	public void onRightClick() {
		startActivity(new Intent(this, AnalyzeActivity.class));
	}
}
