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
 * OpenGL ����ѧϰ����ϰ01��OpenGL�������
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

		//��ͼ
		public void onDrawFrame(GL10 gl) {
			// TODO Auto-generated method stub
			
		}

		//���size�ı�ʱ����
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			// TODO Auto-generated method stub
			//��һ�α�㴴��ʱ�����Ĵ�С�ı䣬����ñ�����
			
			//glViewport(x, y, width, height)
			//x,yΪ���꣬��Ļ�����½�Ϊԭ�㣨0,0��
			//width, heightΪ���ӿڵĿ�͸�
			gl.glViewport(0,0, width, height);
			
			
			
		}

		//��㴴��
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			//��������ɫ��������ɫ
			gl.glClearColor(255, 0, 0, 1);
			
		}
		
	}
}
