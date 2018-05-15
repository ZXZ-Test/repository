package ssm.controller;

import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.entity.SsmEntityVO;
import ssm.service.ISsmService;

import javax.annotation.Resource;

/**
 * Ssm控制类
 * Copyright: Copyright (c) 2018
 * Company: UD
 *
 * @author Uncle Drew
 * @version 1.0 2018/5/15 11:16
 */
@Controller
@RequestMapping("/ssm")
public class SsmController {

    /** 日志打印 **/
    private final static Log log = LogFactory.getLog(SsmController.class);

    @Resource(name = "ssmService")
    private ISsmService ssmService;

    /**
     * Ssm接口测试
     * @author MoonLo
     * @version 1.0 2018-5-15 14:06:30
     */
    @RequestMapping(value = "/getInfoById",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryUserInfoById(@RequestParam("userId") Long userId){

        SsmEntityVO ssmUser ;
        JSONObject result = new JSONObject();

        try {
           ssmUser = ssmService.queryUserInfoById(userId);
           if(null != ssmUser){
               result.put("state","success");
               result.put("userId",ssmUser.getUserId());
               result.put("userName",ssmUser.getUserName());
               result.put("userPwd",ssmUser.getUserPwd());
               result.put("userCode",ssmUser.getUserCode());
           } else {
               result.put("state","success");
               result.put("userInfo","用户信息不存在!");
           }
        } catch (Exception e){
            result.put("state","error");
            log.error("Ssm框架数据访问测试异常",e);
        }

        return result;
    }

}
