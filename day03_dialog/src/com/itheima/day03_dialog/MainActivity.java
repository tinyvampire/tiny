package com.itheima.day03_dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * 大众对话框
	 * @param view
	 */
	public void click01(View view){
		AlertDialog.Builder builder = new Builder(this);
		//设置标题
		builder.setTitle("警告：");
		//设置文本框的信息
		builder.setMessage("若练此工，必先自宫，是否继续？");
		//设置确定按钮
		builder.setPositiveButton("确定自宫", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "啊……", 0).show();
			}
		});
		//设置取消按钮
		builder.setNegativeButton("想想再说吧", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你当不了魏忠贤了！", 0).show();
			}
		});
		//创建dialog对象
		AlertDialog dialog = builder.create();
		//调用dialog对象的show方法
		dialog.show();
	}
	
	/**
	 * 单选对话框
	 * @param v
	 */
	public void click02(View v){
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("请选择您的性别");
		final String[] items = {"男","女","中性"};
		
		builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "您的性别："+items[which], 0).show();
			}
		});
		builder.setNegativeButton("取消选择", null);
		builder.show();
	}
	
	/**
	 * 多选对话框
	 * @param v
	 */
	public void click03(View v){
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("请选择您爱玩的游戏");
		final String[] items = {"dota","lol","dota2","cf"};
		final boolean[] checkedItems = new boolean[]{true,true,false,false};
		builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				Toast.makeText(MainActivity.this,items[which]+isChecked, 0).show();
				checkedItems[which] = isChecked;
			}
		});
			
		builder.setNegativeButton("取消选择", null);
		builder.show();
	}
	
	
	/**
	 * 进度对话框
	 * @param v
	 */
	public void click04(View v){
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setTitle("downloading");
		pd.setMessage("正在加载数据，请稍后……");
		pd.show();
		//添加一个方法，让三秒钟之后关掉
		new Thread(){
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				pd.dismiss();
			};
		}.start();
	}
	
	/**
	 * 进度条对话框
	 * @param v
	 */
	public void click05(View v){
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setMax(100);
		pd.setTitle("click05");
		pd.setMessage("正在加载数据……请稍后");
		pd.show();
		new Thread(){
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
					pd.setProgress(i);
				}
				pd.dismiss();
			};
		}.start();
		
	}
}
