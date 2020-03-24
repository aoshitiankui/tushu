package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 75155953
 *图片辅助类 用于生成验证码或者生成本地图片响应到客户端
 */
public class ImagerHelp {
	public static char getChar(Random random){
		//48-57 数字  97-122小写字母 65-90大写字母
		int res = 0;
		while(true){
			res = random.nextInt(123);
			if((res>=48&&res<=57)||(res>=97&&res<=122)||(res>=65&&res<=90)){
				break;
			}
		}
		return (char)res;
	}
	/**
	 * @param filePath
	 * @param response
	 * @param watermark
	 * @throws Exception
	 * 展现本地图片
	 */
	public static void createImage(String filePath, HttpServletResponse response,String watermark)
			throws Exception {
		File file = new File(filePath);
		BufferedImage image = ImageIO.read(file);
		response.setDateHeader("Expires", 0);
		if(watermark!=null){
			Graphics g = image.getGraphics();
			g.setColor(Color.white);
			FontMetrics m = g.getFontMetrics();
			int len = m.stringWidth(watermark);
			//System.out.println(m.getHeight());
			g.drawString(watermark, image.getWidth()-len-20, image.getHeight()-20);
		}
		ImageIO.write(image, "JPEG", response.getOutputStream());    
	}

	/**
	 * @param response
	 * @param req
	 * @param width
	 * @param height
	 * @param strLenth
	 * @throws Exception
	 * 生成图片验证码
	 */
	public static void createImage(HttpServletResponse response,HttpServletRequest req,int width,int height,int strLenth)
	throws Exception {
		response.setHeader("Pragma", "No-cache");    
	    response.setHeader("Cache-Control", "no-cache");    
	    response.setDateHeader("Expires", 0);    
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();    
	    Random random = new Random();    
	    g.setColor(getColor(200, 250));  
	    g.fillRect(0, 0, width, height);    
	    g.setFont(new Font("Times New Roman", Font.PLAIN, 18));     
	    g.setColor(getColor(160, 200));    
	    for (int i = 0; i < 100; i++) {    
	        int x = random.nextInt(width);    
	        int y = random.nextInt(height);    
	        int xl = random.nextInt(12);    
	        int yl = random.nextInt(12);    
	        g.drawLine(x, y, x + xl, y + yl);    
	    }    
	    String sRand = "";    
	    for (int i = 0; i < strLenth; i++) {    
//	        String rand = getChar(random)+"";    
	    	String rand = random.nextInt(10)+"";
	        sRand += rand;    
	        g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
	        g.drawString(rand, 13 * i + 6, 16);    
	    }    
	    req.getSession().setAttribute("code", sRand);  
	    g.dispose();    
	    ImageIO.write(image, "JPEG", response.getOutputStream());    
	}
	
	public static Color getColor(int fc, int bc){
	        Random random = new Random();    
	        if (fc > 255)    
	            fc = 255;    
	        if (bc > 255)    
	            bc = 255;    
	        int r = fc + random.nextInt(bc - fc);    
	        int g = fc + random.nextInt(bc - fc);    
	        int b = fc + random.nextInt(bc - fc);    
	        return new Color(r, g, b);    

	}

	public static void main(String[] args) throws Exception {
		
		System.out.println((int)'Z');
	}
}
