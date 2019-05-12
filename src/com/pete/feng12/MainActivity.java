package com.pete.feng12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pete.custom.CustomSimpleAdapter;
import com.pete.tool.DensityTool;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private final int columnWidthPx = 55;  
	 private final int FLINGVELOCITYPX = 250;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		System.out.println("sssaaas");
		
		
		String []  categoryArray = getResources().getStringArray(R.array.catogories);
		Log.i("Info",categoryArray[0]);
		final int mFlingVelocityDip = DensityTool.px2dip(this, FLINGVELOCITYPX);
		final List<HashMap<String,String>> categories = new ArrayList<HashMap<String,String>>();
		/* for(int i = 0;i < categoryArray.length;i++) {
			HashMap<String,String>  hashMap = new HashMap<String,String>();
			hashMap.put("category_title", categoryArray[i]);
			categories.add(hashMap);
		} */
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("category_title", "中国");
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map);
		categories.add(map); // 测试数据
		
		CustomSimpleAdapter simpleAdapter = new CustomSimpleAdapter(this,categories,R.layout.category_title,new String[] {"category_title"},new int[] { R.id.category_title});
		System.out.println(DensityTool.px2dip(this, columnWidthPx));
		
		GridView category = new GridView(this);
		category.setColumnWidth(DensityTool.px2dip(this, columnWidthPx));
		category.setNumColumns(GridView.AUTO_FIT);
		category.setGravity(Gravity.CENTER);
		category.setSelector(new ColorDrawable(Color.TRANSPARENT));
		
		int layoutWidth = DensityTool.px2dip(this, columnWidthPx) * categories.size();
		System.out.println(layoutWidth);
		LayoutParams  params = new LayoutParams(layoutWidth, LayoutParams.MATCH_PARENT);
		category.setLayoutParams(params);
		category.setAdapter(simpleAdapter);
		
		LinearLayout categoryLayout = (LinearLayout)findViewById(R.id.category_layout);
		categoryLayout.addView(category); //s
		
		// 箭头
		final HorizontalScrollView categoryScrollView = (HorizontalScrollView)findViewById(R.id.category_scrollview);
		Button categoryArrowRight = (Button)findViewById(R.id.category_arrow_right);
		categoryArrowRight.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				System.out.println("hahah");
				categoryScrollView.fling(mFlingVelocityDip);
			}
		});
		
		
	}
}
