package com.codejune.sutaekhighschool.util;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

//웹에서 가져온 이미지 비트맵으로 리턴하는 클래스
public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
	ImageView bmImage;

	public ImageDownloader(ImageView bmImage) {
		this.bmImage = bmImage;
	}

	protected Bitmap doInBackground(String... urls) {
		String url = urls[0];
		Bitmap mIcon = null;
		try {
			InputStream in = new java.net.URL(url).openStream();
			mIcon = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		}
		return mIcon;
	}

	protected void onPostExecute(Bitmap result) {
		bmImage.setImageBitmap(result);
	}

}
