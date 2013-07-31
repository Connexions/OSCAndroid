/**
 * Copyright (c) 2013 Rice University
 * 
 * This software is subject to the provisions of the GNU Lesser General
 * Public License Version 2.1 (LGPL).  See LICENSE.txt for details.
 */
package org.openstaxcollege.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Web View to allow hidding of toolbar when user scrolls up
 * @author Ed Woodward
 *
 */
public class ObservableWebView extends WebView
{
    private OnScrollChangedCallback scrollChangedCallback;

    public ObservableWebView(final Context context)
    {
        super(context);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt)
    {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scrollChangedCallback != null) 
    	{
        	scrollChangedCallback.onScroll(l, t);
    	}
    }

    public OnScrollChangedCallback getOnScrollChangedCallback()
    {
        return scrollChangedCallback;
    }

    public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback)
    {
    	scrollChangedCallback = onScrollChangedCallback;
    }

    /**
     * Impliment in the activity/fragment/view that you want to listen to the webview
     */
    public static interface OnScrollChangedCallback
    {
        public void onScroll(int l, int t);
    }
}

