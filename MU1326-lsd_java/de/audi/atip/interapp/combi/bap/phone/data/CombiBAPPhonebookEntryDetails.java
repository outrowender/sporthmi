/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPPhonebookEntryDetails {
    private String telNumber;
    private int numberType;

    public CombiBAPPhonebookEntryDetails(String string, int n) {
        this.telNumber = string;
        this.numberType = n;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPPhonebookEntryDetails {");
        buffer.append("telNumber=");
        buffer.append(this.telNumber);
        buffer.append(", ");
        buffer.append("numberType=");
        buffer.append(this.numberType);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof CombiBAPPhonebookEntryDetails) {
            CombiBAPPhonebookEntryDetails combiBAPPhonebookEntryDetails = (CombiBAPPhonebookEntryDetails)object;
            return this.telNumber.equals(combiBAPPhonebookEntryDetails.telNumber) && this.numberType == combiBAPPhonebookEntryDetails.numberType;
        }
        return false;
    }
}

