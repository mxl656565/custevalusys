/**
 * 公司:
 * 文件名:Asserts
 * 作者：Tiger
 * 时间：2020/12/1 15:58
 * 描述：
 */
package com.waymap.custevalusys.common;

import com.waymap.custevalusys.exception.ApiException;

/**
 * @author : tiger
 * @description : 断言处理类，抛出异常
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
public class Asserts {
    public static void fail(String message){
        throw new ApiException(message);
    }
    public static void fail(ErrorCode errorCode){
        throw new ApiException(errorCode);
    }
}
