package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName SysLogDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/7
 * @Version 1.0
 **/
public interface SysLogDao {

    @Select("select * from syslog")
    public List<SysLog> querySysLogList();

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);
}
