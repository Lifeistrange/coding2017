package com.coderising.ood.srp;

/**
 * Created by Universe on 2017/6/20.
 */
class SMTPHostResolver {

    private String smtpHost = null;
    private String altSmtpHost = null;

    SMTPHostResolver(String smtpHost, String altSmtpHost) {
        this.smtpHost = smtpHost;
        this.altSmtpHost = altSmtpHost;
    }

    String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    String getAltSmtpHost() {
        return altSmtpHost;
    }

    public void setAltSmtpHost(String altSmtpHost) {
        this.altSmtpHost = altSmtpHost;
    }
}
