package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import dao.TestDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Control{
	@Autowired
	private TestDao testDao;
	
	@GetMapping("/")
	public String index() {
		System.out.println("服务器启动");
		return "index";
	}
	
	@RequestMapping(value="/androidpost",method=RequestMethod.POST)
	public void post(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		System.out.println("客户端传递过来:"+a+","+b);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("成功");
		out.flush();
		out.close();
		
		
	}
	
	@RequestMapping("/getUserNum")
	public void getAllUserName(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html);charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject outobject = new JSONObject();
		outobject.put("count",testDao.selectCount());
		out.write(outobject.toString());
		out.flush();
		out.close();
		
	}
	//注册模块
	@RequestMapping("/register")
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//登录模块 //还需要设置不能同时登录两台设备才是，也就是记录一个字段，
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//修改模块
	@RequestMapping("/change")
	public void change(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//索取用户信息部分
	@RequestMapping("/getUserInfo")
	public void getUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//客户端传来头像
	@RequestMapping("/getUserPortrait")
	public void getUserPortrait(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//客户端索取头像
	@RequestMapping("/GiveUserPortrait")
	public void giveUserPortrait(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	//用户传来学习项目信息部分，需要添加一个学习项目
	@RequestMapping("/setLearnItem")
	public void setLearnItem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取所有学习项目的标题和今天是否学习过的信息
	@RequestMapping("/getAllItemTitles")
	public void getAllItemTitles(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取某个学习项目信息
	@RequestMapping("/giveSingleItemInfo")
	public void giveSingleItemInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户设置学习次数或者练习次数
	@RequestMapping("/setLearnOrPracticeRecord")
	public void setLearnOrPracticeRecord(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取详细学习记录信息
	@RequestMapping("/getDetailInfo")
	public void getDetailInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户点错了，要回退到上一次的信息
	@RequestMapping("/deleteLastDetailInfo")
	public void deleteLastDetailInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取单个学习项目历史记录
	@RequestMapping("/singleItemRecordInfo")
	public void singleItemRecordInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取藏宝阁中的项目信息
	@RequestMapping("/getcompleteiteminfo")
	public void getcompleteiteminfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取藏宝阁中的项目的详细信息
	@RequestMapping("/gettreasuredetailinfo")
	public void gettreasuredetailinfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户添加课表
	@RequestMapping("/addclasstable")
	public void addclasstable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取课表数据
	@RequestMapping("/getclasstabledata")
	public void getclasstabledata(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户索取日记数据
	@RequestMapping("/getdiary")
	public void getdiary(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户保存日记数据
	@RequestMapping("/savediary")
	public void savediary(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//staticshow页面索取信息
	@RequestMapping("/recordInfo")
	public void recordInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求删除某个学习记录
	@RequestMapping("/deleteitem")
	public void deleteitem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求排行榜数据
	@RequestMapping("/getranklistdataP")
	public void getranklistdataP(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求修改密码
	@RequestMapping("/changepsw")
	public void changepsw(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求获取三个排行榜的内容
	@RequestMapping("/getthreerank")
	public void getthreerank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求更新版本号
	@RequestMapping("/checkversion")
	public void checkversion(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求排行榜上某个大哥的信息
	@RequestMapping("/getRankListUserInfo")
	public void GetRankListUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求自己的勋章
	@RequestMapping("/getUserSigns")
	public void getUserSigns(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求修改佩戴的勋章
	@RequestMapping("/changeUserSign")
	public void changeUserSign(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求健康知识技术这三个数据
	@RequestMapping("/getThreePartDate")
	public void getThreePartDate(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求设置信息
	@RequestMapping("/requestSetting")
	public void requestSetting(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求设置设置信息
	@RequestMapping("/setProperty")
	public void setProperty(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求荣誉之地的数据
	@RequestMapping("/getSendSignData")
	public void getSendSignData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求月度报告的数据
	@RequestMapping("/getMonthReport")
	public void getMonthReport(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求查看详细月度报告
	@RequestMapping("/getAnalyseMonthData")
	public void getAnalyseMonthData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	//用户进入自习室
	@RequestMapping("/inClassRoom")
	public void inClassRoom(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户请求注销账户
	@RequestMapping("/cancellation")
	public void cancellation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户获取官方活动列表
	@RequestMapping("/getOfficialtasks")
	public void getOfficialtasks(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户接受任务
	@RequestMapping("/acceptTask")
	public void acceptTask(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//用户领取奖励
	@RequestMapping("/getReward")
	public void getReward(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	
}