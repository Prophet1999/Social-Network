package com.social.network.constants;

import com.social.network.connection.impl.ConnectionPool;
import org.apache.log4j.Logger;

/**
 * Created by Dmitrii on 18.11.2018.
 */
public enum Role {
    ADMIN("admin", 1), MEMBER("member", 2), UNKNOWN("unknown", 3);

    private static final Logger logger = Logger.getLogger(ConnectionPool.class);
    private static final String CAN_T_RECOGNIZE_USER_ROLE_WITH_KEY = "Can't recognize user role with key = ";

    private String role;
    private int key;

    Role(String role, int key) {
        this.role = role;
        this.key = key;
    }

    public String getRoleString() {
        return role;
    }

    public static Role getRoleByKey(int key){
        for (Role value : Role.values()) {
            if(value.key == key){
                return value;
            }
        }
        logger.info(CAN_T_RECOGNIZE_USER_ROLE_WITH_KEY + key);
        return UNKNOWN;
    }
}
