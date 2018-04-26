package bysj.weijia.greenhousemonitor;

import com.support.util.LogUtil;
import com.support.util.SPUtil;
import com.support.util.T;

import android.app.Application;

public class App extends Application {
	public static App context;
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		LogUtil.DEBUG = Config.debug;
		T.init(this);
		SPUtil.init(this);
	}
}
