package com.bd17kaka.autopaper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bd17kaka.autopaper.po.KeyValue;
import com.bd17kaka.autopaper.po.example.KeyValueExample;

@Mapper
public interface KeyValueMapper {
	int countByExample(KeyValueExample example);

	int deleteByExample(KeyValueExample example);

	int deleteByPrimaryKey(Long id);

	int insert(KeyValue record);

	int insertSelective(KeyValue record);

	List<KeyValue> selectByExample(KeyValueExample example);

	KeyValue selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") KeyValue record, @Param("example") KeyValueExample example);

	int updateByExample(@Param("record") KeyValue record, @Param("example") KeyValueExample example);

	int updateByPrimaryKeySelective(KeyValue record);

	int updateByPrimaryKey(KeyValue record);
}