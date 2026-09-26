/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.ETCPaymentHistoryListItem$PaymentListRow;
import de.audi.app.settings.etc.PaymentFormatter;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
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

    ETCPaymentHistoryListItem$PaymentListRow getRow() {
        ETCPaymentHistoryListItem$PaymentListRow eTCPaymentHistoryListItem$PaymentListRow = new ETCPaymentHistoryListItem$PaymentListRow(this, new EvoListRow(this.paymentInfo.getPaymentInfoID(), this.COLUMN_COUNT));
        PaymentFormatter paymentFormatter = new PaymentFormatter(this.paymentInfo, this.env, this.log);
        eTCPaymentHistoryListItem$PaymentListRow.setInteger(0, this.paymentInfo.getPaymentInfoID());
        eTCPaymentHistoryListItem$PaymentListRow.setText(1, paymentFormatter.getDateString());
        if (this.COLUMN_COUNT == 5) {
            eTCPaymentHistoryListItem$PaymentListRow.setText(2, paymentFormatter.getTimeString());
        } else {
            eTCPaymentHistoryListItem$PaymentListRow.setText(2, paymentFormatter.getTimeStringWithoutDecoration());
        }
        eTCPaymentHistoryListItem$PaymentListRow.setText(3, paymentFormatter.getAmountCurrencyString());
        eTCPaymentHistoryListItem$PaymentListRow.setInteger(4, this.paymentInfo.getTollAmount().getAmount() < 0 ? 1 : 0);
        if (this.COLUMN_COUNT == 7) {
            eTCPaymentHistoryListItem$PaymentListRow.setText(5, paymentFormatter.getTimeDecorationString().trim());
            eTCPaymentHistoryListItem$PaymentListRow.setInteger(6, Math.round(Math.abs((float)this.paymentInfo.getTollAmount().getAmount()) / 31300));
        }
        return eTCPaymentHistoryListItem$PaymentListRow;
    }

    static /* synthetic */ int access$000(ETCPaymentHistoryListItem eTCPaymentHistoryListItem) {
        return eTCPaymentHistoryListItem.COLUMN_COUNT;
    }
}

