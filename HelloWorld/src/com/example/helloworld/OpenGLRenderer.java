package com.example.helloworld;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class OpenGLRenderer implements Renderer {

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		// ���ñ�����ɫ��rgba��
		gl.glClearColor(0f, 255f, 0f, 0.5f);
		// ����ƽ�����ƣ�Ĭ�ϲ���Ҫ����
		gl.glShadeModel(GL10.GL_SMOOTH);
		// �����������
		gl.glClearDepthf(1.0f);
		// ������Ȳ���
		gl.glEnable(GL10.GL_DEPTH_TEST);
		// ��Ȳ��Ե����͡�
		gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.
		// �ǳ��õĽǶȼ��㡣
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
		
		//����ǰ��ͼ�˿�����Ϊ�µĴ�С
		gl.glViewport(0, 0, width, height);// OpenGL docs.
		//ѡ��ͶӰ����
		gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.
		// ����Ӱ����� 
		gl.glLoadIdentity();// OpenGL docs.
		//���㴰�ڵĳ����
		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
				100.0f);
		// ѡ��Modelview���� 
		gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.
		// �����ӵ����
		gl.glLoadIdentity();// OpenGL docs.
	}

}
