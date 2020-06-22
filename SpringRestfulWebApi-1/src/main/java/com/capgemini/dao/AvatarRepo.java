package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Avatar;

public interface AvatarRepo  extends JpaRepository<Avatar, Integer>{

	boolean findByAidGreaterThan(int i);

}
