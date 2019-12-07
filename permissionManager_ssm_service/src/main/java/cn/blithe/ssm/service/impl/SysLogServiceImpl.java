package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.SysLogDao;
import cn.blithe.ssm.pojo.SysLog;
import cn.blithe.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName SysLogServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/7
 * @Version 1.0
 **/
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> querySysLogList() {
        return sysLogDao.querySysLogList();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}