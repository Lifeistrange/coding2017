package com.coderising.ood.srp;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PromotionMail {

	public static void main(String[] args) throws Exception {
		File file = new File("F:\\study\\java\\coding2017\\students\\1505586488\\" +
				"ood-assignment\\src\\main\\java\\com\\coderising\\ood\\srp\\product_promotion.txt");
		boolean emailDebug = false;

		ProductFromFile productFromFile = new ProductFromFile(file);
		List<Product> productList = productFromFile.getProductFromFile();

		Configuration config = new Configuration();

		SMTPHostResolver smtpHostResolver = new SMTPHostResolver(config.getProperty(ConfigurationKeys.SMTP_SERVER),
				config.getProperty(ConfigurationKeys.ALT_SMTP_SERVER));

		String fromAddress = config.getProperty(ConfigurationKeys.EMAIL_ADMIN);
		EmailSender emailSender = new EmailSender(smtpHostResolver, fromAddress);

		for(Product product: productList) {
			List mailingList = product.loadMailingList();
			if (mailingList != null) {
				for (Object aMailingList : mailingList) {
					UserInfo userInfo = new UserInfo((HashMap) aMailingList);
					emailSender.sendEMail(userInfo.getToAddress(), userInfo.getSubject(product), userInfo.getMessage(product), emailDebug);
				}
			}
			else {
				System.out.println("没有邮件发送");
			}
		}
	}
}
