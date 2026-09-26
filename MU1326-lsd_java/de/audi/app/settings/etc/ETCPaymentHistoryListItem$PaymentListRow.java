/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.ETCPaymentHistoryListItem;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;

public class ETCPaymentHistoryListItem$PaymentListRow
extends EvoListRow {
    private final /* synthetic */ ETCPaymentHistoryListItem this$0;

    protected ETCPaymentHistoryListItem$PaymentListRow(ETCPaymentHistoryListItem eTCPaymentHistoryListItem, EvoListRow evoListRow) {
        this.this$0 = eTCPaymentHistoryListItem;
        super(evoListRow);
    }

    @Override
    public EvoListRow copy() {
        return new ETCPaymentHistoryListItem$PaymentListRow(this.this$0, this);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer("PaymentListRow:").append(this.getInteger(0)).append(' ').append(this.getText(1)).append(' ').append(this.getText(2)).append(' ').append(this.getText(3)).append(' ').append(this.getInteger(4));
        if (ETCPaymentHistoryListItem.access$000(this.this$0) == 7) {
            buffer.append(' ').append(this.getText(5)).append(' ').append(this.getInteger(6));
        }
        return buffer.toString();
    }
}

