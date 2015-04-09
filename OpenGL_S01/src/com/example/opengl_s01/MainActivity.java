package com.example.opengl_s01;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * OpenGL 入门学习，练习01，OpenGL基本框架
 * @author WYL
 *
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyGLSurfaceView view = new MyGLSurfaceView(this);
		view.setRenderer(new MyRenderer());
		setContentView(view);
		
	}
	class MyGLSurfaceView extends GLSurfaceView{

		public MyGLSurfaceView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
	}
	class MyRenderer implements Renderer{

		//绘图
		public void onDrawFrame(GL10 gl) {
			// TODO Auto-generated method stub
			
		}

		//表层size改变时调用
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			//第一次表层创建时，表层的大小改变，会调用本函数
			
			//设置视口
			//glViewport(x, y, width, height)
			//x,y为坐标，屏幕的左下角为原点（0,0）
			//width, height为该视口的宽和高
			gl.glViewport(0,0, width, height);
			
			//设置平截头体
			//gl.glFrustumf(left, right, bottom, top, zNear, zFar)
			//left, right, bottom, top为
			//zNear, zFar
			//gl.glFrustumf(left, right, bottom, top, zNear, zFar);
			
		}

		//表层创建
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			//设置清屏色，即背景色
			gl.glClearColor(255, 0, 0, 1);
			
		}
		
	}
}
