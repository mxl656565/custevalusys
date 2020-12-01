/**
 * 公司:
 * 文件名:ApiException
 * 作者：Tiger
 * 时间：2020/12/1 16:03
 * 描述：
 */
package com.waymap.custevalusys.exception;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.waymap.custevalusys.common.ErrorCode;

/**
 * @author : tiger
 * @description : 自定义API异常
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
public class ApiException extends RuntimeException{
    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ApiException(String message){
        super(message);
    }
    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
