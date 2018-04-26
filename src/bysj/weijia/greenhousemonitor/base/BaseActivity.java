package bysj.weijia.greenhousemonitor.base;

import com.support.R;
import com.support.util.T;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends FragmentActivity implements View.OnClickListener {

	private boolean doubleClickExit = false;
	private ImageView ivBack, ivRight;
	private TextView tvBack, tvTitle, tvRight;

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		if (layoutResID != bysj.weijia.greenhousemonitor.R.layout.activity_welcome)
			findView();
	}

	protected void findView() {
		ivBack = (ImageView) findViewById(R.id.iv_back);
		ivBack.setOnClickListener(this);
		ivBack.setRotation(180);
		ivRight = (ImageView) findViewById(R.id.iv_right);
		ivRight.setVisibility(View.GONE);
		tvBack = (TextView) findViewById(R.id.tv_back);
		tvBack.setVisibility(View.GONE);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvRight = (TextView) findViewById(R.id.tv_right);
		tvRight.setVisibility(View.GONE);
	}

	protected void setHeader(String title) {
		tvTitle.setText(title);
	}

	protected void setImgBack(int imgId, View.OnClickListener l) {
		ivBack.setVisibility(l == null ? View.GONE : View.VISIBLE);
		if (l != null)
			ivBack.setImageResource(imgId);
		ivBack.setOnClickListener(l);
	}

	protected void setTextBack(String text, View.OnClickListener l) {
		tvBack.setVisibility(text == null ? View.GONE : View.VISIBLE);
		tvBack.setText(text);
		tvBack.setOnClickListener(l);
	}

	protected void setTitle(String title, View.OnClickListener l) {
		tvTitle.setVisibility(title == null ? View.GONE : View.VISIBLE);
		tvTitle.setText(title);
		tvTitle.setOnClickListener(l);
	}

	protected void setTextRight(String text, View.OnClickListener l) {
		tvRight.setVisibility(text == null ? View.GONE : View.VISIBLE);
		tvRight.setText(text);
		tvRight.setOnClickListener(l);
	}

	protected void setImgRight(int imgId, View.OnClickListener l) {
		ivRight.setVisibility(l == null ? View.GONE : View.VISIBLE);
		if (l != null)
			ivRight.setImageResource(imgId);
		ivRight.setOnClickListener(l);
	}

	protected void setTitle(String title) {
		setHeader(title);
	}

	public void setNoBack() {
		findViewById(R.id.iv_back).setVisibility(View.GONE);
	}

	public void tos(String str) {
		T.show(str);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_back:
			onBackClick();
			break;
		case R.id.iv_right:
			onRightClick();
			break;

		default:
			onChildClick(v);
			break;
		}
	}

	public void onChildClick(View v) {

	}

	public void onBackClick() {
		finish();
	}

	public void onRightClick() {

	}
	
	public void setDoubleClickExit(boolean b){
		doubleClickExit = b;
	}

	private long prevBackClickMillis = 0;

	@Override
	public void onBackPressed() {
		if (doubleClickExit) {
			if (System.currentTimeMillis() - prevBackClickMillis > 1000) {
				tos("再按一次退出");
				Handler h = new Handler();
				h.postDelayed(new Runnable() {
					@Override
					public void run() {
						T.cancle();
					}
				}, 1000);
			} else {
				T.cancle();
				finish();
			}
			prevBackClickMillis = System.currentTimeMillis();
		}else {
			super.onBackPressed();
		}
	}

}
