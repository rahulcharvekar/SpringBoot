package com.pradeep.banking.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pradeep.banking.model.Account;

public enum AccountMap {
INSTANCE;
	
private Map<Integer, Account> map;


private AccountMap() {
map=new HashMap<>();
Account a1=new Account
   ("Pradeep",12000,"9158672627","Pradeep@gmail.com",
		   "AMXPC9856D",new Date(1982, 7, 31));

Account a2=new Account
("Sachin",12000,"8858672627","Sachin@gmail.com",
		   "AMXPC9856D",new Date(1982, 7, 31));

Account a3=new Account
("Ram",12000,"7158672627","Ram@gmail.com",
		   "AMXPC9856D",new Date(1982, 7, 31));

Account a4=new Account
("Mohan",12000,"8158672627","Mohan@gmail.com",
		   "AMXPC9856D",new Date(1982, 7, 31));

map.put(a1.getAccno(), a1);
map.put(a2.getAccno(), a2);
map.put(a3.getAccno(), a3);
map.put(a4.getAccno(), a4);
}


public Map<Integer, Account> getMap() {
	return map;
}

	
}
