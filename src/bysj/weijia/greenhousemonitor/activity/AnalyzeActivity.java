package bysj.weijia.greenhousemonitor.activity;

import android.os.Bundle;
import bysj.weijia.greenhousemonitor.R;
import bysj.weijia.greenhousemonitor.base.BaseActivity;
import bysj.weijia.greenhousemonitor.presenter.AnalyzePresenter;
import bysj.weijia.greenhousemonitor.view.AnalyzeView;

public class AnalyzeActivity extends BaseActivity implements AnalyzeView {

	private AnalyzePresenter mPresenter;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_analyze);
		mPresenter = new AnalyzePresenter(this);
	}
	
}
