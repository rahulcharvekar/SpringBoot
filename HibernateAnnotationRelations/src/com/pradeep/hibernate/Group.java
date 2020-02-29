package com.pradeep.hibernate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="pc_group")
public class Group {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	  private String name;
	  
	  
	  
	  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	  @JoinColumn(name="groupid")
	  @IndexColumn(name="idx")
	  private List<Story> stories;
	  
	  
	  public Group(){
	  }
	  public Group(String name) {
	    this.name = name;
	  }
	  public void setId(int i) {
	    id = i;
	  }
	  public int getId() {
	    return id;
	  }
	  public void setName(String n) {
	    name = n;
	  }
	  public String getName() {
	    return name;
	  }
	  public void setStories(List<Story> sl) {
	    stories = sl;
	  }
	  public List<Story> getStories() {
	    return stories;
	  }
}