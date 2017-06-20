package com.coderising.ood.srp;

import java.util.List;

/**
 * Created by Universe on 2017/6/20.
 */
public class Product {

    private String productID = null;
    private String productDesc = null;

    Product(String productID, String productDesc) {
        this.productID = productID;
        this.productDesc = productDesc;
    }

    String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    private String getSendMailQuery() {
        String sendMailQuery = "Select name from subscriptions "
                + "where product_id= '" + productID +"' "
                + "and send_mail=1 ";

        System.out.println("loadQuery set");

        return sendMailQuery;
    }

    List loadMailingList() throws Exception {
        return DBUtil.query(getSendMailQuery());
    }
}
