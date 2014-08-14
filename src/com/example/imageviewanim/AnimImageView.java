package com.example.imageviewanim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
/**
 * 实现可以展示连帧图片的imageview控件
 * @author 胡硕
 * @time 20140814 19:35
 * 
 */
public class AnimImageView extends ImageView{
	/**对象---动画线程**/
	private AnimThread mThread;
	/**数值---需要展示的图片id**/
	private int niFame;
	
	private Paint mPaint;
	private Context mContext;
	private int[] arr_Bmp;
	public AnimImageView(Context context,int[] arr_bmp) {
		super(context);
		mContext = context;
		arr_Bmp = arr_bmp;
		Init();
		mThread = new AnimThread();
	}

	/*******************
	 * 函数：数据的初始化
	 ******************/
	private void Init(){
		mPaint = new Paint();
		//抗锯齿
		mPaint.setAntiAlias(true);
	}
	
	/****************************************
	 * 函数：根据id获取资源文件夹下面的bitmap，如果传入的id
	 * 	        生成的bitmap为空，返回默认的图片，避免出现空指针错误
	 * @param id
	 * @return bitmap
	 ****************************************/
	private Bitmap getBitmapFromAsset(int id){
		Bitmap mBmp = BitmapFactory.decodeResource(mContext.getResources(), id);
		Bitmap mDefault = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_launcher);
		if(mBmp != null){
			return mBmp;
		}
		return mDefault;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(getBitmapFromAsset(arr_Bmp[niFame]), 0, 0, mPaint);
	}
	
	
	public void startAnim(){
		mThread.isRun = true;
		mThread.start();
	}
	
	public void stopAnim(){
		mThread.isRun = false;
	}
	/**
	 *	改变连帧图片ID的线程 
	 * @author 胡硕
	 * @time 20140814 19:37
	 */
	class AnimThread extends Thread{
		public boolean isRun;
		@Override
		public void run() {
			while(isRun){
				try {
					niFame++;
					if(niFame % (arr_Bmp.length-1) == 0){
						niFame = 0;
					}
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				postInvalidate();
			}
		}
		
	}
}
