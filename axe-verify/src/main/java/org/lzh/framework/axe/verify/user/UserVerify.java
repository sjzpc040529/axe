package org.lzh.framework.axe.verify.user;
import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.common.web.result.Result;

/**
 * @Description: 用户调用server层代码校验层
 * @author: lizhaohua
 * @date: 15/11/9 下午3:03
 * @version: V1.0
 */
public interface UserVerify {
    /**
     * 保存用户
     * @param user
     * @return
     */
    public Result save(User user);
}
