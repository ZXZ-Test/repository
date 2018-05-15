package ssm.service;

import com.thinkjf.service.ServiceException;
import ssm.entity.SsmEntityVO;

/**
 * Copyright: Copyright (c) 2018
 * Company: UD
 *
 * @author Uncle Drew
 * @version 1.0 2018/5/15 13:04
 */
public interface ISsmService {

    /**
     * 根据ID获取用户信息
     * @return UserInfo
     * @throws ServiceException
     */
    SsmEntityVO queryUserInfoById(Long userId) throws ServiceException;

}
