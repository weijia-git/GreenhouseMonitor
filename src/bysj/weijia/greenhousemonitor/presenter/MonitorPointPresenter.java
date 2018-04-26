package bysj.weijia.greenhousemonitor.presenter;

import com.support.util.SPUtil;
import com.support.util.T;

import android.text.TextUtils;
import bysj.weijia.greenhousemonitor.Config;
import bysj.weijia.greenhousemonitor.view.MonitorPointView;

public class MonitorPointPresenter {
	private MonitorPointView mView;

	public MonitorPointPresenter(MonitorPointView view) {
		this.mView = view;
	}

	public void init() {
		String name = (String) SPUtil.get(Config.SP_MOINTOR_POINT, "");
		mView.setPointName(name);
		String ip = (String) SPUtil.get(Config.SP_MOINTOR_IP, "");
		mView.setPointIp(ip);
		String port = (String) SPUtil.get(Config.SP_MONITOR_PORT, "");
		if (!TextUtils.isEmpty(port))
			mView.setPointPort(Integer.valueOf(port));
	}

	public void confirm() {
		String name = mView.getPointName();
		String ip = mView.getPointIp();
		String port = mView.getPointPort();

		if (TextUtils.isEmpty(name)) {
			T.show("监控点名称不能为空");
			return;
		}
		SPUtil.put(Config.SP_MOINTOR_POINT, name);
		if (TextUtils.isEmpty(ip)) {
			T.show("监控点ip不能为空");
			return;
		}
		SPUtil.put(Config.SP_MOINTOR_IP, ip);
		if (TextUtils.isEmpty(port)) {
			T.show("监控端口不能为空");
			return;
		}
		SPUtil.put(Config.SP_MONITOR_PORT, port);

		mView.toMonitorActivity();
	}
}
