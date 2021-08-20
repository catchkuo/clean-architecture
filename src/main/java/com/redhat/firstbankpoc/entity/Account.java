package com.redhat.firstbankpoc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "USER_ID")
    private Integer userId;
    
    @Column(name = "DEPOSIT", nullable = true, length = 10)
    private Integer deposit;

    @Column(name = "NOTE", nullable = true, length = 255)
    private String note;


    public Account(Integer userId, Integer deposit,String note) {
        this.userId = userId;
        this.deposit = deposit;
        this.note = note;
    }
    
    protected Account() {
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", deposit=" + deposit +
                ", note=" + note +
                '}';
    }
}