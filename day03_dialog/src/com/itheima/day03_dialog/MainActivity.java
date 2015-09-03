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
	 * ���ڶԻ���
	 * @param view
	 */
	public void click01(View view){
		AlertDialog.Builder builder = new Builder(this);
		//���ñ���
		builder.setTitle("���棺");
		//�����ı������Ϣ
		builder.setMessage("�����˹��������Թ����Ƿ������");
		//����ȷ����ť
		builder.setPositiveButton("ȷ���Թ�", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "������", 0).show();
			}
		});
		//����ȡ����ť
		builder.setNegativeButton("������˵��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�㵱����κ�����ˣ�", 0).show();
			}
		});
		//����dialog����
		AlertDialog dialog = builder.create();
		//����dialog�����show����
		dialog.show();
	}
	
	/**
	 * ��ѡ�Ի���
	 * @param v
	 */
	public void click02(View v){
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("��ѡ�������Ա�");
		final String[] items = {"��","Ů","����"};
		
		builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�����Ա�"+items[which], 0).show();
			}
		});
		builder.setNegativeButton("ȡ��ѡ��", null);
		builder.show();
	}
	
	/**
	 * ��ѡ�Ի���
	 * @param v
	 */
	public void click03(View v){
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("��ѡ�����������Ϸ");
		final String[] items = {"dota","lol","dota2","cf"};
		final boolean[] checkedItems = new boolean[]{true,true,false,false};
		builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				Toast.makeText(MainActivity.this,items[which]+isChecked, 0).show();
				checkedItems[which] = isChecked;
			}
		});
			
		builder.setNegativeButton("ȡ��ѡ��", null);
		builder.show();
	}
	
	
	/**
	 * ���ȶԻ���
	 * @param v
	 */
	public void click04(View v){
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setTitle("downloading");
		pd.setMessage("���ڼ������ݣ����Ժ󡭡�");
		pd.show();
		//���һ����������������֮��ص�
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
	 * �������Ի���
	 * @param v
	 */
	public void click05(View v){
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setMax(100);
		pd.setTitle("click05");
		pd.setMessage("���ڼ������ݡ������Ժ�");
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
