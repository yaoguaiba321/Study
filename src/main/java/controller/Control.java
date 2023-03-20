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
		System.out.println("����������");
		return "index";
	}
	
	@RequestMapping(value="/androidpost",method=RequestMethod.POST)
	public void post(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		System.out.println("�ͻ��˴��ݹ���:"+a+","+b);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("�ɹ�");
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
	//ע��ģ��
	@RequestMapping("/register")
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�޸�ģ��
	@RequestMapping("/change")
	public void change(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//��ȡ�û���Ϣ����
	@RequestMapping("/getUserInfo")
	public void getUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�ͻ��˴���ͷ��
	@RequestMapping("/getUserPortrait")
	public void getUserPortrait(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�ͻ�����ȡͷ��
	@RequestMapping("/GiveUserPortrait")
	public void giveUserPortrait(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	//�û�����ѧϰ��Ŀ��Ϣ���֣���Ҫ���һ��ѧϰ��Ŀ
	@RequestMapping("/setLearnItem")
	public void setLearnItem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ����ѧϰ��Ŀ�ı���ͽ����Ƿ�ѧϰ������Ϣ
	@RequestMapping("/getAllItemTitles")
	public void getAllItemTitles(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡĳ��ѧϰ��Ŀ��Ϣ
	@RequestMapping("/giveSingleItemInfo")
	public void giveSingleItemInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����ѧϰ����������ϰ����
	@RequestMapping("/setLearnOrPracticeRecord")
	public void setLearnOrPracticeRecord(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ��ϸѧϰ��¼��Ϣ
	@RequestMapping("/getDetailInfo")
	public void getDetailInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����ˣ�Ҫ���˵���һ�ε���Ϣ
	@RequestMapping("/deleteLastDetailInfo")
	public void deleteLastDetailInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ����ѧϰ��Ŀ��ʷ��¼
	@RequestMapping("/singleItemRecordInfo")
	public void singleItemRecordInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ�ر����е���Ŀ��Ϣ
	@RequestMapping("/getcompleteiteminfo")
	public void getcompleteiteminfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ�ر����е���Ŀ����ϸ��Ϣ
	@RequestMapping("/gettreasuredetailinfo")
	public void gettreasuredetailinfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ӿα�
	@RequestMapping("/addclasstable")
	public void addclasstable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ�α�����
	@RequestMapping("/getclasstabledata")
	public void getclasstabledata(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ�ռ�����
	@RequestMapping("/getdiary")
	public void getdiary(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������ռ�����
	@RequestMapping("/savediary")
	public void savediary(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//staticshowҳ����ȡ��Ϣ
	@RequestMapping("/recordInfo")
	public void recordInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����ɾ��ĳ��ѧϰ��¼
	@RequestMapping("/deleteitem")
	public void deleteitem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û��������а�����
	@RequestMapping("/getranklistdataP")
	public void getranklistdataP(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������޸�����
	@RequestMapping("/changepsw")
	public void changepsw(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������ȡ�������а������
	@RequestMapping("/getthreerank")
	public void getthreerank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�������°汾��
	@RequestMapping("/checkversion")
	public void checkversion(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û��������а���ĳ��������Ϣ
	@RequestMapping("/getRankListUserInfo")
	public void GetRankListUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������Լ���ѫ��
	@RequestMapping("/getUserSigns")
	public void getUserSigns(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������޸������ѫ��
	@RequestMapping("/changeUserSign")
	public void changeUserSign(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û����󽡿�֪ʶ��������������
	@RequestMapping("/getThreePartDate")
	public void getThreePartDate(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����������Ϣ
	@RequestMapping("/requestSetting")
	public void requestSetting(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���������������Ϣ
	@RequestMapping("/setProperty")
	public void setProperty(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���������֮�ص�����
	@RequestMapping("/getSendSignData")
	public void getSendSignData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û������¶ȱ��������
	@RequestMapping("/getMonthReport")
	public void getMonthReport(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����鿴��ϸ�¶ȱ���
	@RequestMapping("/getAnalyseMonthData")
	public void getAnalyseMonthData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	//�û�������ϰ��
	@RequestMapping("/inClassRoom")
	public void inClassRoom(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û�����ע���˻�
	@RequestMapping("/cancellation")
	public void cancellation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ�ٷ���б�
	@RequestMapping("/getOfficialtasks")
	public void getOfficialtasks(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���������
	@RequestMapping("/acceptTask")
	public void acceptTask(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	//�û���ȡ����
	@RequestMapping("/getReward")
	public void getReward(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
	}
	
	
	
}