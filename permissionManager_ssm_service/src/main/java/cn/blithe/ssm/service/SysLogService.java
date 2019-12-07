package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.SysLog;

import java.util.List;

/**
 * @ClassName SysLogService
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/7
 * @Version 1.0
 **/
public interface SysLogService {
    public List<SysLog> querySysLogList();

    public void save(SysLog sysLog) throws Exception;
}