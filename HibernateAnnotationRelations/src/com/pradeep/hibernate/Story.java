package com.pradeep.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="pc_story")
public class Story {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	  private String info;
	  
	  @ManyToOne
	  @JoinColumn(name="groupid") 
	  private Group group;
	  
	  
	  public Story(){
	  }
	  
	  public Group getGroup() {
		return group;
	  }

	  public void setGroup(Group group) {
		this.group = group;
	  }
	  
	  public Story(String info) {
	    this.info = info;
	  }
	  public void setId(int i) {
	    id = i;
	  }
	  public int getId() {
	    return id;
	  }
	  public void setInfo(String n) {
	    info = n;
	  }
	  public String getInfo() {
	    return info;
	  }
}