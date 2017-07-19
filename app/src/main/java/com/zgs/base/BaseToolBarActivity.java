package com.zgs.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zgs.R;

/**
 * Created by zgsHighwin on 2017/7/19 0019.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public abstract class BaseToolBarActivity extends AppCompatActivity {


    @LayoutRes
    private int mLayout;
    private View mContentView;
    private Toolbar mToolbar;
    private TextView mTextView;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = getLayoutId();
        if (mLayout == 0) {
            setContentView(R.layout.layout_frame_error);
        } else {
            LayoutInflater systemService = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mContentView = systemService.from(this).inflate(mLayout, null);
            setContentView(mContentView);
        }

        initToolbar();
    }

    private void initToolbar() {
        mToolbar = ((Toolbar) mContentView.findViewById(R.id.toolbar));
        mTextView = ((TextView) mContentView.findViewById(R.id.toolbar_title));
        if (mToolbar != null && mTextView != null) {
            mToolbar.setTitle("");
            mTextView.setText(toolbarTitle());
        } else return;

        mToolbar.setNavigationIcon(R.mipmap.ic_arrow_left);
        setSupportActionBar(mToolbar);
    }

    protected abstract CharSequence toolbarTitle();

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("BaseToolBarActivity", "onOptionsItemSelected");
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public final void finish() {
        super.finish();
        exitActivity();
    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/19 0019 下午 5:00
     * @Description: 退出activity
     */
    protected void exitActivity() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
        enterActivity();
    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/19 0019 下午 4:58
     * @Description: 进入
     */
    protected void enterActivity() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}
