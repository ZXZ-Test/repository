package ssm.service.impl;

import com.thinkjf.service.ServiceException;
import org.springframework.stereotype.Service;
import ssm.dao.ISsmDao;
import ssm.entity.SsmEntityVO;
import ssm.service.ISsmService;

import javax.annotation.Resource;

/**
 * Copyright: Copyright (c) 2018
 * Company: UD
 *
 * @author Uncle Drew
 * @version 1.0 2018/5/15 13:05
 */
@Service("ssmService")
public class SsmServiceImpl implements ISsmService {

    @Resource
    private ISsmDao ssmDao;

    @Override
    public SsmEntityVO queryUserInfoById(Long userId) throws ServiceException {
        return ssmDao.queryUserInfoById(userId);
    }
}
