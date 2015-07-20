package com.miracle.web.controller.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miracle.lotteryutils.Lottery;
import com.miracle.model.ticket.TicketThen;
import com.miracle.orm.Page;
import com.miracle.orm.PropertyFilter;
import com.miracle.orm.hibernate.HibernateWebUtils;

/**

 * <b>function:</b> FreeMarker示例控制器

 * @author hoojo

 * @createDate 2011-3-3 下午04:50:10

 * @file HelloWorldController.java

 * @package com.miracle.web.controller.demo

 * @project SpringFreemarker

 * @version 1.0

 */

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/test")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        map.addAttribute("name", " World!");
        return "/hello.ftl";
    }
	@RequestMapping(value = "/test/v")
	public ModelAndView queryPageTickets() {
		final ModelAndView mav = new ModelAndView("/test/hello.ftl");
		mav.addObject("name", "World!!!!!");
		return mav;
	}
}