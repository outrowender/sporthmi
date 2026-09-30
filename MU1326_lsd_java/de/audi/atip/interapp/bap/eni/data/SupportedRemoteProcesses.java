/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class SupportedRemoteProcesses {
    private final boolean updateUserListSupported;
    private final boolean deleteUserListSupported;
    private final boolean pairMainUserUsingPairingCodeSupported;
    private final boolean pairMainUserUsingVehiclePinSupported;
    private final boolean confirmServiceExpirationWarningSupported;
    private final boolean terminateRemoteProcessSupported;

    public static Builder builder() {
        return new Builder();
    }

    private SupportedRemoteProcesses(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.updateUserListSupported = bl;
        this.deleteUserListSupported = bl2;
        this.pairMainUserUsingPairingCodeSupported = bl3;
        this.pairMainUserUsingVehiclePinSupported = bl4;
        this.confirmServiceExpirationWarningSupported = bl5;
        this.terminateRemoteProcessSupported = bl6;
    }

    public boolean isUpdateUserListSupported() {
        return this.updateUserListSupported;
    }

    public boolean isDeleteUserListSupported() {
        return this.deleteUserListSupported;
    }

    public boolean isPairMainUserUsingPairingCodeSupported() {
        return this.pairMainUserUsingPairingCodeSupported;
    }

    public boolean isPairMainUserUsingVehiclePinSupported() {
        return this.pairMainUserUsingVehiclePinSupported;
    }

    public boolean isConfirmServiceExpirationWarningSupported() {
        return this.confirmServiceExpirationWarningSupported;
    }

    public boolean isTerminateRemoteProcessSupported() {
        return this.terminateRemoteProcessSupported;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.confirmServiceExpirationWarningSupported ? 1231 : 1237);
        n = 31 * n + (this.deleteUserListSupported ? 1231 : 1237);
        n = 31 * n + (this.pairMainUserUsingPairingCodeSupported ? 1231 : 1237);
        n = 31 * n + (this.pairMainUserUsingVehiclePinSupported ? 1231 : 1237);
        n = 31 * n + (this.terminateRemoteProcessSupported ? 1231 : 1237);
        n = 31 * n + (this.updateUserListSupported ? 1231 : 1237);
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
        SupportedRemoteProcesses supportedRemoteProcesses = (SupportedRemoteProcesses)object;
        if (this.confirmServiceExpirationWarningSupported != supportedRemoteProcesses.confirmServiceExpirationWarningSupported) {
            return false;
        }
        if (this.deleteUserListSupported != supportedRemoteProcesses.deleteUserListSupported) {
            return false;
        }
        if (this.pairMainUserUsingPairingCodeSupported != supportedRemoteProcesses.pairMainUserUsingPairingCodeSupported) {
            return false;
        }
        if (this.pairMainUserUsingVehiclePinSupported != supportedRemoteProcesses.pairMainUserUsingVehiclePinSupported) {
            return false;
        }
        if (this.terminateRemoteProcessSupported != supportedRemoteProcesses.terminateRemoteProcessSupported) {
            return false;
        }
        return this.updateUserListSupported == supportedRemoteProcesses.updateUserListSupported;
    }

    public String toString() {
        return new StringBuffer().append("SupportedRemoteProcesses [updateUserListSupported=").append(this.updateUserListSupported).append(", deleteUserListSupported=").append(this.deleteUserListSupported).append(", pairMainUserUsingPairingCodeSupported=").append(this.pairMainUserUsingPairingCodeSupported).append(", pairMainUserUsingVehiclePinSupported=").append(this.pairMainUserUsingVehiclePinSupported).append(", confirmServiceExpirationWarningSupported=").append(this.confirmServiceExpirationWarningSupported).append(", terminateRemoteProcessSupported=").append(this.terminateRemoteProcessSupported).append("]").toString();
    }

    public static final class Builder {
        private boolean updateUserListSupported;
        private boolean deleteUserListSupported;
        private boolean pairMainUserUsingPairingCodeSupported;
        private boolean pairMainUserUsingVehiclePinSupported;
        private boolean confirmServiceExpirationWarningSupported;
        private boolean terminateRemoteProcessSupported;

        public Builder setUpdateUserListSupported(boolean bl) {
            this.updateUserListSupported = bl;
            return this;
        }

        public Builder setDeleteUserListSupported(boolean bl) {
            this.deleteUserListSupported = bl;
            return this;
        }

        public Builder setPairMainUserUsingPairingCodeSupported(boolean bl) {
            this.pairMainUserUsingPairingCodeSupported = bl;
            return this;
        }

        public Builder setPairMainUserUsingVehiclePinSupported(boolean bl) {
            this.pairMainUserUsingVehiclePinSupported = bl;
            return this;
        }

        public Builder setConfirmServiceExpirationWarningSupported(boolean bl) {
            this.confirmServiceExpirationWarningSupported = bl;
            return this;
        }

        public Builder setTerminateRemoteProcessSupported(boolean bl) {
            this.terminateRemoteProcessSupported = bl;
            return this;
        }

        public SupportedRemoteProcesses build() {
            return new SupportedRemoteProcesses(this.updateUserListSupported, this.deleteUserListSupported, this.pairMainUserUsingPairingCodeSupported, this.pairMainUserUsingVehiclePinSupported, this.confirmServiceExpirationWarningSupported, this.terminateRemoteProcessSupported);
        }
    }
}

