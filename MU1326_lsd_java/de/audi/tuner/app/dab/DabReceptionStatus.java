/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

public class DabReceptionStatus {
    public final int syncStatus;
    public final int linkStatus;
    public static final int RECEPTION_MUTE = 2;
    public static final int RECEPTION_FM_LINKED = 1;
    public static final int RECEPTION_OK = 0;

    public DabReceptionStatus(int n, int n2) {
        this.syncStatus = n;
        this.linkStatus = n2;
    }

    public boolean equals(Object object) {
        return object instanceof DabReceptionStatus && ((DabReceptionStatus)object).syncStatus == this.syncStatus && ((DabReceptionStatus)object).linkStatus == this.linkStatus;
    }

    public int hashCode() {
        return this.syncStatus ^ this.linkStatus;
    }

    public int getReception() {
        if (this.linkStatus == 2) {
            return 1;
        }
        if (this.syncStatus == 4) {
            return 0;
        }
        return 2;
    }
}

