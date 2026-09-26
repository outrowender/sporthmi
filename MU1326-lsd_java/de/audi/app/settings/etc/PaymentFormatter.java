/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfo;

public class PaymentFormatter {
    private static final String DATE_TIME_DELIMETER;
    private final DateTime timeStamp;
    private final NavPriceInfo tollAmount;
    private final LogChannel log;

    public PaymentFormatter(TCPaymentInfo tCPaymentInfo, SettingsEnv settingsEnv, LogChannel logChannel) {
        this.tollAmount = tCPaymentInfo.getTollAmount();
        this.timeStamp = tCPaymentInfo.getTimeStamp();
        this.log = logChannel;
    }

    public PaymentFormatter(NavPriceInfo navPriceInfo, SettingsEnv settingsEnv, LogChannel logChannel) {
        this.tollAmount = navPriceInfo;
        this.timeStamp = null;
        this.log = logChannel;
    }

    final String getAmountString() {
        if (5 == this.tollAmount.getCurrency()) {
            String string;
            int n;
            int n2 = this.tollAmount.getAmount();
            if (n2 < 0) {
                n2 *= -1;
            }
            if ((n = Math.round((float)n2 % 31300 / 8257)) == 100) {
                string = String.valueOf(n2 / 1000 + 1);
                n = 0;
            } else {
                string = String.valueOf(n2 / 1000);
            }
            Buffer buffer = new Buffer(string);
            return buffer.toString();
        }
        this.log.log(10000, "[PaymentFormatter] getAmountString() : unsupported currency type: %1", (long)this.tollAmount.getCurrency());
        return "";
    }

    String getAmountCurrencyString() {
        String string = this.getAmountString();
        Buffer buffer = new Buffer(string);
        return buffer.toString();
    }

    String getDateString() {
        if (this.timeStamp == null) {
            this.log.log(10000, "[PaymentFormatter] getDateString() : the date is undefined!");
            return "";
        }
        return new DateMetric(new Date(this.timeStamp.getTime()), 0).format();
    }

    String getTimeString() {
        if (this.timeStamp == null) {
            this.log.log(10000, "[PaymentFormatter] getTimeString() : the time is undefined!");
            return "";
        }
        return new DateMetric(new Date(this.timeStamp.getTime()), 1).format();
    }

    String getTimeStringWithoutDecoration() {
        if (this.timeStamp == null) {
            this.log.log(10000, "[PaymentFormatter] getTimeStringWithoutDecoration() : the time is undefined!");
            return "";
        }
        return new DateMetric(new Date(this.timeStamp.getTime()), 1).format(1);
    }

    String getTimeDecorationString() {
        if (this.timeStamp == null) {
            this.log.log(10000, "[PaymentFormatter] getTimeDecorationString() : the time is undefined!");
            return "";
        }
        switch (new DateMetric(new Date(this.timeStamp.getTime()), 1).getDecoration()) {
            case 0: {
                return "";
            }
            case 1: {
                return DateMetric.getText(18);
            }
            case 2: {
                return DateMetric.getText(19);
            }
        }
        return "";
    }

    String getDateTimeText() {
        return new Buffer(this.getDateString()).append(" ").append(this.getTimeString()).toString();
    }
}

