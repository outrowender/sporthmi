/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.esolutions.fw.util.commons.Buffer;

public class OnlineServiceListState {
    public static final int BIT_MASK_SERVICELIST_PENDING = 16;
    public static final int BIT_MASK_CONNECTIVITY_AVAILABLE = 1;
    public static final int BIT_MASK_SERVICELIST_ONLINE = 4;
    public static final int BIT_MASK_SERVICELIST_OFFLINE = 2;
    public static final int BIT_MASK_OWNERVERIFICATION_OK = 256;
    public static final int BIT_MASK_OWNERVERIFICATION_AVAILABLE = 65536;
    public static final int EMPTY_SERVICE_STATE = 0;
    private int serviceState;
    private int validFlag;

    public OnlineServiceListState(int n, int n2) {
        this.serviceState = n;
        this.validFlag = n2;
    }

    public void setValues(int n, int n2) {
        this.serviceState = n;
        this.validFlag = n2;
    }

    public boolean checkServiceStateBit(int n) {
        return (this.serviceState & n) != 0;
    }

    public boolean isValid() {
        return this.validFlag == 1;
    }

    public boolean isOnline() {
        return this.checkServiceStateBit(4);
    }

    public boolean isPending() {
        return this.checkServiceStateBit(16);
    }

    public boolean isOffline() {
        return this.checkServiceStateBit(2);
    }

    public boolean isConnectivityAvailable() {
        return this.checkServiceStateBit(1);
    }

    public boolean isOwnerVerificationOK() {
        return this.checkServiceStateBit(256);
    }

    public boolean isOwnerVerificationAvailable() {
        return this.checkServiceStateBit(65536);
    }

    public String getCurrentServiceStateAsText() {
        Buffer buffer = new Buffer();
        if (this.checkServiceStateBit(1)) {
            buffer.append("CONNECTIVITY");
        }
        if (this.checkServiceStateBit(2)) {
            if (buffer.length() != 0) {
                buffer.append(", ");
            }
            buffer.append("SL_OFFLINE");
        }
        if (this.checkServiceStateBit(4)) {
            if (buffer.length() != 0) {
                buffer.append(", ");
            }
            buffer.append("SL_ONLINE");
        }
        if (this.checkServiceStateBit(16)) {
            if (buffer.length() != 0) {
                buffer.append(", ");
            }
            buffer.append("SL_PENDING");
        }
        if (this.checkServiceStateBit(65536)) {
            if (buffer.length() != 0) {
                buffer.append(", ");
            }
            buffer.append("OWNERVERIFICATION_AVAILABLE");
        }
        if (this.checkServiceStateBit(256)) {
            if (buffer.length() != 0) {
                buffer.append(", ");
            }
            buffer.append("OWNERVERIFICATION_OK");
        }
        return buffer.toString();
    }

    public String toString() {
        return "OnlineServiceListState [serviceState=" + this.getCurrentServiceStateAsText() + ", isValid=" + this.isValid() + "( " + this.validFlag + " )]";
    }

    public boolean equals(OnlineServiceListState onlineServiceListState) {
        return onlineServiceListState.serviceState == this.serviceState;
    }

    public boolean equalsIgnorePending(OnlineServiceListState onlineServiceListState) {
        return this.checkServiceStateBit(1) == onlineServiceListState.checkServiceStateBit(1) && this.checkServiceStateBit(2) == onlineServiceListState.checkServiceStateBit(2) && this.checkServiceStateBit(4) == onlineServiceListState.checkServiceStateBit(4);
    }
}

