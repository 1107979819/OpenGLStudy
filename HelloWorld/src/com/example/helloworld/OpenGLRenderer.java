package com.example.helloworld;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class OpenGLRenderer implements Renderer {

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		// 设置背景颜色（rgba）
		gl.glClearColor(0f, 255f, 0f, 0.5f);
		// 设置平滑底纹，默认不需要设置
		gl.glShadeModel(GL10.GL_SMOOTH);
		// 缓存深度设置
		gl.glClearDepthf(1.0f);
		// 开启深度测试
		gl.glEnable(GL10.GL_DEPTH_TEST);
		// 深度测试的类型。
		gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.
		// 非常好的角度计算。
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, // OpenGL docs.
				GL10.GL_NICEST);
	}

	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | // OpenGL docs.
				GL10.GL_DEPTH_BUFFER_BIT);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		System.out.println("w:"+width+" h:"+height);
		
		//将当前视图端口设置为新的大小
		gl.glViewport(0, 0, width, height);// OpenGL docs.
		//选择投影矩阵
		gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.
		// 重置影射矩阵 
		gl.glLoadIdentity();// OpenGL docs.
		//计算窗口的长宽比
		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
				100.0f);
		// 选择Modelview矩阵 
		gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.
		// 重置视点矩阵
		gl.glLoadIdentity();// OpenGL docs.
	}

}
