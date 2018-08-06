package com.example.Springbootcrud.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditListener.class)
@Entity
@Table(name = "student")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedNativeQuery(name = "deleteById", query = ("delete from Student where id in"
		+ "(select max(id) from Student where " + "id not in(select max(id) from Student))"))
@EnableJpaAuditing
public class Student {

	@Id
	Integer id;
	String name;
	byte age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
