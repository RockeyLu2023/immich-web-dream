package com.immich.dreamscreensaver;

import android.service.dreams.DreamService;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebDreamService extends DreamService {
    // ✅ 【编译前务必改成你的ImmichFrame内网HTTP地址】
    private static final String TARGET_URL = "http://192.168.2.77:2284";

    private WebView mWebView;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFullscreen(true);
        setInteractive(false);
        mWebView = new WebView(this);
        setContentView(mWebView);
        WebSettings cfg = mWebView.getSettings();
        cfg.setJavaScriptEnabled(true);
        cfg.setDomStorageEnabled(true);
        cfg.setLoadWithOverviewMode(true);
        cfg.setUseWideViewPort(true);
        cfg.setMediaPlaybackRequiresUserGesture(false);
        mWebView.loadUrl(TARGET_URL);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mWebView != null){
            mWebView.destroy();
            mWebView = null;
        }
    }
}
