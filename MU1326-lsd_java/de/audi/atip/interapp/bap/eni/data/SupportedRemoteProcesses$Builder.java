/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;

public final class SupportedRemoteProcesses$Builder {
    private boolean updateUserListSupported;
    private boolean deleteUserListSupported;
    private boolean pairMainUserUsingPairingCodeSupported;
    private boolean pairMainUserUsingVehiclePinSupported;
    private boolean confirmServiceExpirationWarningSupported;
    private boolean terminateRemoteProcessSupported;

    public SupportedRemoteProcesses$Builder setUpdateUserListSupported(boolean bl) {
        this.updateUserListSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses$Builder setDeleteUserListSupported(boolean bl) {
        this.deleteUserListSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses$Builder setPairMainUserUsingPairingCodeSupported(boolean bl) {
        this.pairMainUserUsingPairingCodeSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses$Builder setPairMainUserUsingVehiclePinSupported(boolean bl) {
        this.pairMainUserUsingVehiclePinSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses$Builder setConfirmServiceExpirationWarningSupported(boolean bl) {
        this.confirmServiceExpirationWarningSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses$Builder setTerminateRemoteProcessSupported(boolean bl) {
        this.terminateRemoteProcessSupported = bl;
        return this;
    }

    public SupportedRemoteProcesses build() {
        return new SupportedRemoteProcesses(this.updateUserListSupported, this.deleteUserListSupported, this.pairMainUserUsingPairingCodeSupported, this.pairMainUserUsingVehiclePinSupported, this.confirmServiceExpirationWarningSupported, this.terminateRemoteProcessSupported);
    }
}

