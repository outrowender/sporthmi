/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.PaymentFormatter;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tollcollect.TCPaymentInfo;

public class ETCPaymentHistoryListItem {
    private final int COLUMN_COUNT;
    private final TCPaymentInfo paymentInfo;
    private final LogChannel log;
    private final SettingsEnv env;

    ETCPaymentHistoryListItem(TCPaymentInfo tCPaymentInfo, int n, SettingsEnv settingsEnv, LogChannel logChannel) {
        this.COLUMN_COUNT = n;
        this.env = settingsEnv;
        this.paymentInfo = tCPaymentInfo;
        this.log = logChannel;
    }

    PaymentListRow getRow() {
        PaymentListRow paymentListRow = new PaymentListRow(new EvoListRow(this.paymentInfo.getPaymentInfoID(), this.COLUMN_COUNT));
        PaymentFormatter paymentFormatter = new PaymentFormatter(this.paymentInfo, this.env, this.log);
        paymentListRow.setInteger(0, this.paymentInfo.getPaymentInfoID());
        paymentListRow.setText(1, paymentFormatter.getDateString());
        if (this.COLUMN_COUNT == 5) {
            paymentListRow.setText(2, paymentFormatter.getTimeString());
        } else {
            paymentListRow.setText(2, paymentFormatter.getTimeStringWithoutDecoration());
        }
        paymentListRow.setText(3, paymentFormatter.getAmountCurrencyString());
        paymentListRow.setInteger(4, this.paymentInfo.getTollAmount().getAmount() < 0 ? 1 : 0);
        if (this.COLUMN_COUNT == 7) {
            paymentListRow.setText(5, paymentFormatter.getTimeDecorationString().trim());
            paymentListRow.setInteger(6, Math.round(Math.abs((float)this.paymentInfo.getTollAmount().getAmount()) / 1000.0f));
        }
        return paymentListRow;
    }

    public class PaymentListRow
    extends EvoListRow {
        protected PaymentListRow(EvoListRow evoListRow) {
            super(evoListRow);
        }

        public EvoListRow copy() {
            return new PaymentListRow(this);
        }

        public String toString() {
            Buffer buffer = new Buffer("PaymentListRow:").append(this.getInteger(0)).append(' ').append(this.getText(1)).append(' ').append(this.getText(2)).append(' ').append(this.getText(3)).append(' ').append(this.getInteger(4));
            if (ETCPaymentHistoryListItem.this.COLUMN_COUNT == 7) {
                buffer.append(' ').append(this.getText(5)).append(' ').append(this.getInteger(6));
            }
            return buffer.toString();
        }
    }
}

