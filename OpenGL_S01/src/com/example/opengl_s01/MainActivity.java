package com.example.opengl_s01;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
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
			//清除颜色缓冲区
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			//设置为模型视图矩阵模式
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			
			//加载单位矩阵
			gl.glLoadIdentity();
			
			//设置摄像机的位置参数
			//GLU.gluLookAt(gl, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ)
			//eyeX, eyeY, eyeZ			:放置摄像机的位置
			//centerX, centerY, centerZ	:摄像机的前方朝向位置
			// upX, upY, upZ			:摄像机的上方朝向位置
			GLU.gluLookAt(gl, 0, 0, 5, 0, 0, 0, 0, 1,0);
			
			//画三角形
			//设置三角形三个点的x,y,z坐标数组
			float coords[] ={
					0f,0.5f,0f,
					-0.5f,-0.5f,0f,
					0.5f,-0.5f,0f}
			;
			//把数组放进字节缓冲区
			//创建字节缓冲区，因为每个float类型占4个字节，所以缓冲区的大小为float数组的长度*4
			//(注意，这里别写成ByteBuffer.allocate(coords.length*4)，否则会报Must use a native order direct Buffer错误)
			ByteBuffer bb = ByteBuffer.allocateDirect(coords.length*4);
			//设置字节缓冲区的顺序,设置为本地顺序，也就是说CPU处理数据的顺序如何就如何
			bb.order(ByteOrder.nativeOrder());
			//创建此字节缓冲区的视图，作为 float 缓冲区。
			FloatBuffer fb = bb.asFloatBuffer();
			//把三角形的坐标数组放进缓冲区
			fb.put(coords);
			//设置缓冲区的起始位置
			bb.position(0);
			
			//设置画图颜色red, green, blue, alpha
			gl.glColor4f(255f,0f, 0f, 1f);
			
			//设置画图需要的缓冲区数据
			//glVertexPointer(size, type, stride, pointer)
			//size		: 指定了每个顶点对应的坐标个数，只能是2,3,4中的一个，默认值是4（下面设置为3，就表示三维，如果是2的话，就表示二维）
			//type		: 指定了数组中每个顶点坐标的数据类型
			//stride	: 指定了连续顶点间的字节排列方式，如果为0，数组中的顶点就会被认为是按照紧凑方式排列的，默认值为0
			//pointer	: 目标缓冲区
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bb);
			
			//画数组
			//glDrawArrays(mode, first, count)
			//mode		:画图模式
			//first		:开始位置
			//count		:画点的数量
			//glDrawArrays(GL10.GL_TRIANGLES, 0, 3);   //绘制三角形  
			//glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);  //绘制四边形 
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);//绘制三角形
			
		}

		//表层size改变时调用
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			//第一次表层创建时，表层的大小改变，会调用本函数
			
			//设置视口
			//glViewport(x, y, width, height)
			//x,y为坐标，屏幕的左下角为原点（0,0）
			//width, height为该视口的宽和高
			gl.glViewport(0,0, width, height);
			
			//设置矩阵模式，投影矩阵
			gl.glMatrixMode(GL10.GL_PROJECTION);
			
			//加载单位矩阵
			gl.glLoadIdentity();
			
			//设置平截头体
			//计算宽高比
			float ratio  = (float)width/ (float)height;
			//glFrustumf(left, right, bottom, top, zNear, zFar)
			//left, right, bottom, top为平截头体的左右上下的相对位置
			//zNear, zFar为平截头体的近平面和远平面与摄像机的距离
			gl.glFrustumf(-1, 1, -1*ratio, 1*ratio, 3, 7);
			
		}

		//表层创建
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			//设置清屏色，即背景色，r,g,b,a
			gl.glClearColor(0, 0,255, 1);
			//启用顶点缓冲区，
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			
		}
		
	}
}
