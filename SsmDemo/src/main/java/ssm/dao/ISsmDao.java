package ssm.dao;

import com.thinkjf.dao.DaoException;
import ssm.entity.SsmEntityVO;

/**
 * Copyright: Copyright (c) 2018
 * Company: UD
 *
 * @author Uncle Drew
 * @version 1.0 2018/5/15 13:07
 */
public interface ISsmDao {

    /**
     * 根据ID获取用户信息
     * @return UserInfo
     * @throws DaoException
     */
    SsmEntityVO queryUserInfoById(Long userId) throws DaoException;

}
