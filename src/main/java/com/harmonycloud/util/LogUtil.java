package com.harmonycloud.util;

import com.harmonycloud.log.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2019/3/20
 */
public class LogUtil {
    public static String getRequest(HttpServletRequest request) {
        if (request != null) {
            String ip = IpUtil.getIpAddress(request);
            String correlation = request.getHeader("x-b3-traceid");
            String loginName = request.getHeader("user");
            Log log = new Log(ip, loginName, "CIMS", correlation, "User Application");
            return log.toString();
        }
        return null;
    }

}
