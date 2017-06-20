package com.coderising.ood.srp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Universe on 2017/6/20.
 */
class ProductFromFile {

    private BufferedReader br = null;

    ProductFromFile(File file) throws IOException {
        br = new BufferedReader(new FileReader(file));
    }

    List<Product> getProductFromFile() throws IOException {
        try {
            List<Product> productList = new ArrayList<Product>();
            String temp;
            while ((temp=br.readLine())!=null) {
                String[] data = temp.split(" ");

                Product product = new Product(data[0], data[1]);

                productList.add(product);

                System.out.println("产品ID = " + product.getProductID() + "\n");
                System.out.println("产品描述 = " + product.getProductDesc() + "\n");
            }

            return productList;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } finally {
            br.close();
        }
    }
}
