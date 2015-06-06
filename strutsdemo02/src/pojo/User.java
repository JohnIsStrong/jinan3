package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;



@Entity
@Table(name="user")

public class User {
	@Column(name="id")
	@Id
	@GeneratedValue(generator="nav")
	@GenericGenerator(strategy="native",name="nav")
	
	private Integer id;
	
	private String loginName;
	
	private String psd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sen=sf.openSession();
		Transaction tx=sen.beginTransaction();
		User u=new User();
		u.setLoginName("john");
		u.setPsd("123");
		
		sen.save(u);
		tx.commit();
		sen.close();
		
		
	}
	
}
