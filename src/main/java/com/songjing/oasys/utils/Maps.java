package com.songjing.oasys.utils;

import java.util.Map;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/2/1 17:55
 */
public class Maps {
    public Maps() {
    }

    public static boolean isEmpty(Map<?, ?> map, Object key) {
        if (map == null) {
            return true;
        } else if (!map.containsKey(key)) {
            return true;
        } else {
            Object obj = map.get(key);
            if (obj == null) {
                return true;
            } else {
                return obj instanceof String ? isBlank((String) obj) : false;
            }
        }
    }

    public static boolean isNotEmpty(Map<?, ?> map, Object key) {
        return !isEmpty(map, key);
    }

    public static Object get(Map<?, ?> map, Object key, Object defValue) {
        if (map == null) {
            return defValue;
        } else {
            Object obj = map.get(key);
            return obj == null ? defValue : obj;
        }
    }

    public static <K, V> boolean isEmptyMap(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <K, V> boolean isNotEmptyMap(Map<K, V> map) {
        return !isEmptyMap(map);
    }

    public static boolean isBlank(String value) {
        return value == null || value.trim().length() == 0;
    }


}

