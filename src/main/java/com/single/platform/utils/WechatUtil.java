package com.single.platform.utils;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: 吴邪
 * @date: 2020/5/18 15:23
 */
@Slf4j
public class WechatUtil {

    /**
     * 用&串接arr参数，生成sha1 digest.
     */
    public static String sha1GenWithAmple(String... arr) {
        log.info("签名参数：{} " , Arrays.toString(arr));

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            sb.append(a);
            if (i != arr.length - 1) {
                sb.append('&');
            }
        }
        return DigestUtil.sha1Hex(sb.toString());
    }
}
