package com.miracle.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miracle.common.Constant;

public class JcaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 5714185610923340369L;

	protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 在内存中创建图象
		final int width = 60, height = 20;
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		final Graphics g = image.getGraphics();

		// 生成随机类
		final Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 画边框
		// g.setColor(new Color(111, 111, 111));
		// g.drawRect(0, 0, width - 1, height - 1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			final int x = random.nextInt(width);
			final int y = random.nextInt(height);
			final int xl = random.nextInt(12);
			final int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			final String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}

		request.getSession().setAttribute(Constant.LOGIN_CAPTCHA, sRand);
		g.dispose();// 图象生效

		// 输出图象到页面
		final ServletOutputStream stream = response.getOutputStream();
		ImageIO.write(image, "JPEG", stream);

		// 以下关闭输入流！
		stream.flush();
		stream.close();
	}

	/**
	 * 给定范围获得随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	protected Color getRandColor(int fc, int bc) {
		final Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		final int r = fc + random.nextInt(bc - fc);
		final int g = fc + random.nextInt(bc - fc);
		final int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
