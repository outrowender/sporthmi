/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;

public final class RemoteProcessState$Builder {
    private int remoteProcessKind;
    private int state;
    private int exceptionState;
    private int userListRequestInfo;

    public RemoteProcessState$Builder setRemoteProcessKind(int n) {
        this.remoteProcessKind = n;
        return this;
    }

    public RemoteProcessState$Builder setState(int n) {
        this.state = n;
        return this;
    }

    public RemoteProcessState$Builder setExceptionState(int n) {
        this.exceptionState = n;
        return this;
    }

    public RemoteProcessState$Builder setUserListRequestInfo(int n) {
        this.userListRequestInfo = n;
        return this;
    }

    public RemoteProcessState build() {
        return new RemoteProcessState(this.remoteProcessKind, this.state, this.exceptionState, this.userListRequestInfo);
    }
}

