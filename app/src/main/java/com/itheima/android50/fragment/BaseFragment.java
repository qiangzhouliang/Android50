package com.itheima.android50.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.itheima.android50.R;

public abstract class BaseFragment extends Fragment {

	protected View mRootView;
	protected View mDemoView;
	protected WebView mWebView;
	protected boolean isDemoShow = true;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mRootView == null) {
			mRootView = initView();
			mDemoView = mRootView.findViewById(R.id.demo);
			mWebView = (WebView) mRootView.findViewById(R.id.web);
			mWebView.getSettings().setDisplayZoomControls(false);
			mWebView.loadUrl(getUrl());
		}
		refreshView();
		//Toast.makeText(getActivity(), isDemoShow + "", Toast.LENGTH_SHORT).show();
		return mRootView;
	}

	protected abstract View initView();

	protected void refreshView() {
		mDemoView.setVisibility(isDemoShow ? View.VISIBLE : View.INVISIBLE);
		mWebView.setVisibility(isDemoShow ? View.INVISIBLE : View.VISIBLE);
	}

	public boolean onOptionsItemSelected(MenuItem menu) {
		if (menu.getItemId() == R.id.action_example) {
			isDemoShow = !isDemoShow;
			refreshView();
			return true;
		}
		return false;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	public abstract String getUrl();
}
