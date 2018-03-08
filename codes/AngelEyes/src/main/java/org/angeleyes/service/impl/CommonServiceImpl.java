package org.angeleyes.service.impl;

import org.angeleyes.dao.CommonDao;
import org.angeleyes.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommonServiceImpl implements CommonService{

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CommonDao commonDao;


    /**
     * 批量删除
     * @param tableName
     * @param rowName
     * @param rowIds
     */
    public void deleteBatchs(String tableName, String rowName, long[] rowIds) {
        for(long rowid : rowIds) {
            int del_res = commonDao.deleteOne(tableName, rowName, rowid);
            if (del_res > 0)
                logger.info("delete from " + tableName + "记录" + rowName + ":" + rowid + "成功");
            else {
                logger.info("delete from " + tableName + "记录" + rowName + ":" + rowid + "失败");

            }
        }
    }
}
