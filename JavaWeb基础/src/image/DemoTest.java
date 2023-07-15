package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;


import javax.imageio.ImageIO;

import org.junit.Test;

public class DemoTest {
	@Test
	public void fun1() throws Exception {
		//得到图片缓冲区
		BufferedImage bImage = new BufferedImage(120, 40, BufferedImage.TYPE_INT_RGB);
		
		//得到绘制环境(这张图片的笔)
		Graphics2D graphics2d = (Graphics2D) bImage.getGraphics();
		
		//设置颜色
		graphics2d.setColor(Color.WHITE);
		
		//填充整张图片(设置背景颜色)
		graphics2d.fillRect(0, 0, 120, 40);
		
		//设置边框及颜色
		graphics2d.setColor(Color.RED);
		
		graphics2d.drawRect(0, 0, 120-1, 40-1);
		
		graphics2d.setFont(new Font("隶书",Font.BOLD,12));
		
		graphics2d.setColor(Color.BLACK);
		
		graphics2d.drawString("helloJavaWeb", 5, 30);
		
		ImageIO.write(bImage, "JPEG", new FileOutputStream("demo.jpg"));
		

	}
	
	@Test
	public void fun2() throws Exception {
		DrawDemo drawD = new DrawDemo();
		BufferedImage bImage = drawD.getImage();
		DrawDemo.output(bImage, new FileOutputStream("xxx.jpg"));
		
		System.out.println(drawD.getText());
	}

}
