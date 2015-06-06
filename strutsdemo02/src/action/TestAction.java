package action;

import java.io.File;

import org.apache.catalina.Contained;

import pojo.User;
import service.WorkService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.impl.ActionConfigMatcher;

public class TestAction extends ActionSupport{
	private User u;
	private File head;
	private String headFileName;
	private String headContentType;
	private WorkService ws;
	
	
	
	public void setWs(WorkService ws) {
		this.ws = ws;
	}

	public String getHeadContentType() {
		return headContentType;
	}

	public void setHeadContentType(String headContentType) {
		this.headContentType = headContentType;
	}

	public String getHeadFileName() {
		return headFileName;
	}

	public void setHeadFileName(String headFileName) {
		this.headFileName = headFileName;
	}

	public File getHead() {
		return head;
	}

	public void setHead(File head) {
		this.head = head;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	
	
	@Override
	public void validate() {
		String loginName=u.getLoginName();
		if(loginName==null || loginName.trim().length()==0){
			addFieldError("u.loginName", "名字是必填项目！");
		}
	}

	public String execute(){
		System.out.println(u.getLoginName());
		System.out.println(u.getPsd());
		System.out.println(headFileName);
		System.out.println("contentType:"+headContentType);
		ws.work();
		return SUCCESS;
	}
}