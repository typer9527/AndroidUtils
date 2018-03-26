package com.yl.androidutils.common.exception;

import com.yl.androidutils.common.common.ErrCode;
import com.yl.androidutils.common.utils.StringUtils;

/**
 * 服务器异常
 * Token错误/过期
 */
public class ServerException extends RuntimeException {

    private ErrCode errInfo;
    public ServerException(ErrCode err)
    {
        this.errInfo=err;
    }

    @Override public String getMessage()
    {
        String message=super.getMessage();
        return StringUtils.isNotEmpty(message) ? errInfo.toString() : (errInfo.toString()+message);
    }
    
}
