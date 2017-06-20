package com.coderising.ood.srp;

import java.util.HashMap;

/**
 * Created by Universe on 2017/6/21.
 */
public class UserInfo {

    private String name;
    private String toAddress;

    private static final String NAME_KEY = "NAME";
    private static final String EMAIL_KEY = "EMAIL";

    UserInfo(HashMap userInfo) {
        this.name = (String) userInfo.get(NAME_KEY);
        this.toAddress = (String) userInfo.get(EMAIL_KEY);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject(Product product) {
        return "您关注的产品降价了";
    }

    public String getMessage(Product product) {
        return "尊敬的 "+name+", 您关注的产品 " + product.getProductDesc() + " 降价了，欢迎购买!" ;
    }
}
