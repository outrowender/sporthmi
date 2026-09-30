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
        if (this.getClass() != object.getClass()) {
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
        return "EtcStatus [cardStatus=" + this.cardStatus + "]";
    }

    public static final class CardStatus {
        public static final int UNKNOWN = 0;
        public static final int INSERTED = 1;
        public static final int NOT_INSERTED = 2;
        public static final int CARD_READER_NOT_CONNECTED = 3;

        private CardStatus() {
            throw new AssertionError((Object)"PrivacySetup.ModificationReason is not intended to be instantiated.");
        }
    }
}

