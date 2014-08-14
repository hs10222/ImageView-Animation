package com.example.imageviewanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
/**
 * ≤‚ ‘ΩÁ√Ê
 * @author ∫˙À∂
 * @time 20140814 19:54
 */
public class MainActivity extends Activity {

	private LinearLayout ll_main;
	private AnimImageView mView;
	private int[] arr_bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll_main = new LinearLayout(this);
        LinearLayout.LayoutParams llp_main = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ll_main.setLayoutParams(llp_main);
        	
        arr_bmp = new int[]{R.drawable.a21,R.drawable.a23,R.drawable.a25,R.drawable.a26,R.drawable.a28,R.drawable.a29};
        mView = new AnimImageView(this, arr_bmp);
        mView.startAnim();
        
        
        
        LinearLayout.LayoutParams llp_view = new LinearLayout.LayoutParams(200, 200);
        ll_main.setGravity(Gravity.CENTER);
        ll_main.addView(mView, llp_view);
        setContentView(ll_main);
    }
}
