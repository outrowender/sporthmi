/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

public final class EtcStatus {
    private final int cardStatus;

    public static EtcStatus getInstance(int n) {
        return new EtcStatus(n);
    }

    private EtcStatus(int n) {
        this.cardStatus = n;
    }

    public int getCardStatus() {
        return this.cardStatus;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        EtcStatus etcStatus = (EtcStatus)object;
        return this.cardStatus == etcStatus.cardStatus;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.cardStatus;
        return n;
    }

    public String toString() {
        return new StringBuffer().append("EtcStatus [cardStatus=").append(this.cardStatus).append("]").toString();
    }
}

