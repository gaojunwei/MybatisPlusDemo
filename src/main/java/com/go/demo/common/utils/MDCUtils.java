package com.go.demo.common.utils;

import org.slf4j.MDC;

/**
 * 日志MDC工具类
 */
public class MDCUtils {
    /**
     * 请求唯一值，key
     */
    public static final String requestId = "requestId";

    /**
     * 设置请求ID
     */
    public static void initReqId(){
        MDC.put(requestId, UuidUtils.getUUID());
    }

    /**
     * 清除请求ID
     */
    public static void removeReqId(){
        MDC.remove(requestId);
    }
}
