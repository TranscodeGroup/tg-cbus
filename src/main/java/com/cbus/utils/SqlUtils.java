package com.cbus.utils;

import com.s3.po.CodeData;
import com.s3.utils.TGCode;

/**
 * sql工具类
 * @author zhen.lin
 * @date 2019年6月13日
 */
public class SqlUtils {

    public static void sqlExceptionMessage(CodeData cd, Exception e) {
        String className = e.getClass().getName().toString();
        cd.setMsg(className);
        switch (className) {
        case "java.sql.SQLException":
            // 数据库异常
            cd.setCode(TGCode.CODE_ERROR_SQL);
            break;
        case "org.springframework.dao.DuplicateKeyException":
            // 唯一值重复异常
            cd.setCode(TGCode.CODE_ERROR_DUPLICATEKEY);
            break;
        default:
            cd.setCode(TGCode.CODE_ERROR_SQL);
        }
    }
}
