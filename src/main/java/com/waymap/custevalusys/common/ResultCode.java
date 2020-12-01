/**
 * 公司:
 * 文件名:ResultCode
 * 作者：asus
 * 时间：2020/8/13 14:45
 * 描述：
 */
package com.waymap.custevalusys.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/8/13
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
public enum ResultCode implements ErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;
    @Override
    public long getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
