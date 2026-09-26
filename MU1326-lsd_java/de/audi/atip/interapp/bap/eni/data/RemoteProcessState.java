/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.RemoteProcessState$Builder;

public final class RemoteProcessState {
    public static final int REMAINING_PIN_RETRIES_UNKNOWN;
    private final int remoteProcessKind;
    private final int state;
    private final int exceptionState;
    private final int pinRetryRemainingCount;
    private final int userListRequestInfo;

    public static RemoteProcessState$Builder builder() {
        return new RemoteProcessState$Builder();
    }

    private RemoteProcessState(int n, int n2, int n3, int n4) {
        this.remoteProcessKind = n;
        this.state = n2;
        if (n3 > 15 && n3 <= 25) {
            this.exceptionState = 15;
            this.pinRetryRemainingCount = n3 - 15 - 1;
        } else {
            this.exceptionState = n3;
            this.pinRetryRemainingCount = -1;
        }
        this.userListRequestInfo = n4;
    }

    public int getRemoteProcessKind() {
        return this.remoteProcessKind;
    }

    public int getState() {
        return this.state;
    }

    public int getExceptionState() {
        return this.exceptionState;
    }

    public int getPinRetryRemainingCount() {
        return this.pinRetryRemainingCount;
    }

    public int getUserListRequestInfo() {
        return this.userListRequestInfo;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.remoteProcessKind;
        n = 31 * n + this.exceptionState;
        n = 31 * n + this.pinRetryRemainingCount;
        n = 31 * n + this.state;
        n = 31 * n + this.userListRequestInfo;
        return n;
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
        RemoteProcessState remoteProcessState = (RemoteProcessState)object;
        if (this.remoteProcessKind != remoteProcessState.remoteProcessKind) {
            return false;
        }
        if (this.exceptionState != remoteProcessState.exceptionState) {
            return false;
        }
        if (this.pinRetryRemainingCount != remoteProcessState.pinRetryRemainingCount) {
            return false;
        }
        if (this.state != remoteProcessState.state) {
            return false;
        }
        return this.userListRequestInfo == remoteProcessState.userListRequestInfo;
    }

    public String toString() {
        return new StringBuffer().append("RemoteProcessState [remoteProcessKind=").append(this.remoteProcessKind).append(", state=").append(this.state).append(", exceptionState=").append(this.exceptionState).append(", pinRetryRemainingCount=").append(this.pinRetryRemainingCount).append(", userListRequestInfo=").append(this.userListRequestInfo).append("]").toString();
    }
}

