package com.example.demo.mapper;

import com.example.demo.domain.Application;
import com.example.demo.domain.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;


@Mapper
public interface ApplicationMapper {

    @Select("select * from main where id=#{id}")
    public Application getAppById(Integer id);

    @Select("select * from main where stuNum=#{id}")
    public Application getAppByNum(String id);

    @Select("select * from main")
    @MapKey("id")
    public Map<Integer, Application> getAllApp();

    @Delete("delete from main where id=#{id}")
    public int deleteAppById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into main(userName,stuNum,appName,year,season,sugSys,reward,description) values(#{userName},#{stuNum},#{appName},#{year},#{season},#{sugSys},#{reward},#{description})")
    public int insertData(Application application);

    @Update("update main( set title=#{title} where id=#{id} ")
    public int updataData(Data data);
}
