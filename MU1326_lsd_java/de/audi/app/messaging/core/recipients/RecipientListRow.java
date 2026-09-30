/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.recipients;

import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MatchedAddress;

public final class RecipientListRow
extends EvoListRow {
    private static final int COLUMN_COUNT = 2;
    private static final int CELL_IDX_RECIPIENT_TYPE = 0;
    private static final int CELL_IDX_RECIPIENT_DESC = 1;
    private final MatchedAddress matchedAddress;
    private final int recipientType;

    public RecipientListRow(MatchedAddress matchedAddress, int n, long l) {
        super(l, 2);
        this.matchedAddress = matchedAddress;
        this.recipientType = n;
        this.setInteger(0, RecipientListRow.getRecipientType(n));
        this.setText(1, RecipientListRow.getRecipientDescription(matchedAddress));
    }

    public MatchedAddress getMatchedAddress() {
        return this.matchedAddress;
    }

    public int getRecipientType() {
        return this.recipientType;
    }

    private static int getRecipientType(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static String getRecipientDescription(MatchedAddress matchedAddress) {
        String string = "";
        string = !Strings.isNullOrEmpty(matchedAddress.getName()) ? matchedAddress.getName() : matchedAddress.getAddress();
        return string;
    }

    public EvoListRow copy() {
        return new RecipientListRow(this.matchedAddress, this.recipientType, this.getUniqueID());
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("RecipientListRow {");
        buffer.append("super.toString()").append(" = ").append(super.toString()).append(", ");
        buffer.append("recipientType").append(" = ").append(this.getRecipientType()).append(", ");
        buffer.append("matchedAddress").append(" = ").append(this.getMatchedAddress());
        buffer.append('}');
        return buffer.toString();
    }
}

