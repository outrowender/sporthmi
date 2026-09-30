/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class RemoteProcessState {
    public static final int REMAINING_PIN_RETRIES_UNKNOWN = -1;
    private final int remoteProcessKind;
    private final int state;
    private final int exceptionState;
    private final int pinRetryRemainingCount;
    private final int userListRequestInfo;

    public static Builder builder() {
        return new Builder();
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
        if (this.getClass() != object.getClass()) {
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

    public static final class State {
        public static final int UNKNOWN = 0;
        public static final int IDLE = 1;
        public static final int IN_PROGRESS = 2;
        public static final int SUCCEEDED = 3;
        public static final int FAILED_SEE_EXCEPTION_STATE = 4;
        public static final int SEARCHING_NETWORK = 5;
        public static final int CONNECTING_TO_SERVER = 6;
        public static final int WAITING_FOR_AUTHENTICATION = 7;
        public static final int TRANSMITTING_DATA = 8;
        public static final int TERMINATED_BY_USER = 9;

        private State() {
            throw new AssertionError((Object)"RemoteProcessState.State is not intended to be instantiated.");
        }
    }

    public static final class Builder {
        private int remoteProcessKind;
        private int state;
        private int exceptionState;
        private int userListRequestInfo;

        public Builder setRemoteProcessKind(int n) {
            this.remoteProcessKind = n;
            return this;
        }

        public Builder setState(int n) {
            this.state = n;
            return this;
        }

        public Builder setExceptionState(int n) {
            this.exceptionState = n;
            return this;
        }

        public Builder setUserListRequestInfo(int n) {
            this.userListRequestInfo = n;
            return this;
        }

        public RemoteProcessState build() {
            return new RemoteProcessState(this.remoteProcessKind, this.state, this.exceptionState, this.userListRequestInfo);
        }
    }

    public static final class ExceptionState {
        public static final int NONE = 0;
        public static final int ERROR = 1;
        public static final int ERROR_COMMAND_NOT_SUPPORTED = 7;
        public static final int ERROR_PARAMETER_MISMATCH = 8;
        public static final int ERROR_NO_NETWORK_CONNECTION = 9;
        public static final int ERROR_NO_VERIFIED_ACCOUNT = 10;
        public static final int ERROR_BACKEND_AUTHENTICATION_FAILED = 11;
        public static final int ERROR_BACKEND_SERVICE_NOT_AVAILABLE = 12;
        public static final int ERROR_BACKEND = 13;
        public static final int ERROR_TIMEOUT = 14;
        public static final int ERROR_WRONG_PIN = 15;
        public static final int ERROR_VTAN_NOT_AVAILABLE = 26;

        private ExceptionState() {
            throw new AssertionError((Object)"RemoteProcessState.ExceptionState is not intended to be instantiated.");
        }
    }

    public static final class UserListRequestInfo {
        public static final int NONE = 0;
        public static final int REQUESTED_FROM_BACKEND = 1;
        public static final int REQUEST_FROM_BACKEND_FAILED = 2;
        public static final int AVAILABLE_IN_OCU_GW = 3;

        private UserListRequestInfo() {
            throw new AssertionError((Object)"RemoteProcessState.UserListRequestInfo is not intended to be instantiated.");
        }
    }
}

