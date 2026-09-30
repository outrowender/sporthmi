/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_SupportedCommands0
implements BAPEntity {
    public boolean getMobileDeviceKeyCountSupportedDf3_4;
    public boolean terminationByUserSupported;
    public boolean confirmServiceExpiryWarningSupported;
    public boolean pairMainUserVehiclePinSupported;
    public boolean pairMainUserPairingCodeSupported;
    public boolean remoteDeleteUserListSupported;
    public boolean remoteUpdateUserListSupported;
    public boolean reserved_bit_0;

    public RemoteProcessCommands_SupportedCommands0() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_SupportedCommands0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.getMobileDeviceKeyCountSupportedDf3_4 = false;
        this.terminationByUserSupported = false;
        this.confirmServiceExpiryWarningSupported = false;
        this.pairMainUserVehiclePinSupported = false;
        this.pairMainUserPairingCodeSupported = false;
        this.remoteDeleteUserListSupported = false;
        this.remoteUpdateUserListSupported = false;
        this.reserved_bit_0 = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_SupportedCommands0 remoteProcessCommands_SupportedCommands0 = (RemoteProcessCommands_SupportedCommands0)bAPEntity;
        return this.getMobileDeviceKeyCountSupportedDf3_4 == remoteProcessCommands_SupportedCommands0.getMobileDeviceKeyCountSupportedDf3_4 && this.terminationByUserSupported == remoteProcessCommands_SupportedCommands0.terminationByUserSupported && this.confirmServiceExpiryWarningSupported == remoteProcessCommands_SupportedCommands0.confirmServiceExpiryWarningSupported && this.pairMainUserVehiclePinSupported == remoteProcessCommands_SupportedCommands0.pairMainUserVehiclePinSupported && this.pairMainUserPairingCodeSupported == remoteProcessCommands_SupportedCommands0.pairMainUserPairingCodeSupported && this.remoteDeleteUserListSupported == remoteProcessCommands_SupportedCommands0.remoteDeleteUserListSupported && this.remoteUpdateUserListSupported == remoteProcessCommands_SupportedCommands0.remoteUpdateUserListSupported && this.reserved_bit_0 == remoteProcessCommands_SupportedCommands0.reserved_bit_0;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RemoteProcessCommands_SupportedCommands0");
        stringBuffer.append("\n - getMobileDeviceKeyCountSupportedDf3_4:" + this.getMobileDeviceKeyCountSupportedDf3_4);
        stringBuffer.append("\n - terminationByUserSupported:" + this.terminationByUserSupported);
        stringBuffer.append("\n - confirmServiceExpiryWarningSupported:" + this.confirmServiceExpiryWarningSupported);
        stringBuffer.append("\n - pairMainUserVehiclePinSupported:" + this.pairMainUserVehiclePinSupported);
        stringBuffer.append("\n - pairMainUserPairingCodeSupported:" + this.pairMainUserPairingCodeSupported);
        stringBuffer.append("\n - remoteDeleteUserListSupported:" + this.remoteDeleteUserListSupported);
        stringBuffer.append("\n - remoteUpdateUserListSupported:" + this.remoteUpdateUserListSupported);
        stringBuffer.append("\n - reserved_bit_0:" + this.reserved_bit_0);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.getMobileDeviceKeyCountSupportedDf3_4);
        bitStream.pushBoolean(this.terminationByUserSupported);
        bitStream.pushBoolean(this.confirmServiceExpiryWarningSupported);
        bitStream.pushBoolean(this.pairMainUserVehiclePinSupported);
        bitStream.pushBoolean(this.pairMainUserPairingCodeSupported);
        bitStream.pushBoolean(this.remoteDeleteUserListSupported);
        bitStream.pushBoolean(this.remoteUpdateUserListSupported);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    public void deserialize(BitStream bitStream) {
        this.getMobileDeviceKeyCountSupportedDf3_4 = bitStream.popFrontBoolean();
        this.terminationByUserSupported = bitStream.popFrontBoolean();
        this.confirmServiceExpiryWarningSupported = bitStream.popFrontBoolean();
        this.pairMainUserVehiclePinSupported = bitStream.popFrontBoolean();
        this.pairMainUserPairingCodeSupported = bitStream.popFrontBoolean();
        this.remoteDeleteUserListSupported = bitStream.popFrontBoolean();
        this.remoteUpdateUserListSupported = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

