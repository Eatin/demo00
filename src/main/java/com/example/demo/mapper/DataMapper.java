package com.example.demo.mapper;

import com.example.demo.domain.Data;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DataMapper {

    @Select("select * from data where id=#{id}")
    public Data getDataById(Integer id);

    @Delete("delect from data where id=#{id}")
    public int deleteDataById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into data(aid,author,play,title) values(#{aid},#{author},#{play},#{title})")
    public int insertData(Data data);

    @Update("update data set title=#{title} where id=#{id} ")
    public int updataData(Data data);
}
