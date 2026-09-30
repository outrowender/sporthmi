/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class InstrumentClusterFunctions_ConfigurationOptions
implements BAPEntity {
    private static final int RESERVED_BIT_6__15_BITSIZE = 10;
    public boolean contextSwitchToDigitalSpeedAvailable;
    public boolean contextSwitchToTrafficSignInformationAvailable;
    public boolean contextSwitchToLastDestinationsListAvailable;
    public boolean contextSwitchToPhoneBookAvailable;
    public boolean trafficSignsOnOffAvailable;
    public boolean screensaverOnOffAvailable;
    private static final int INSTRUMENT_CLUSTER_FUNCTIONS_CONFIGURATION_OPTIONS_BITSIZE = 16;

    public InstrumentClusterFunctions_ConfigurationOptions() {
        this.internalReset();
        this.customInitialization();
    }

    public InstrumentClusterFunctions_ConfigurationOptions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.contextSwitchToDigitalSpeedAvailable = false;
        this.contextSwitchToTrafficSignInformationAvailable = false;
        this.contextSwitchToLastDestinationsListAvailable = false;
        this.contextSwitchToPhoneBookAvailable = false;
        this.trafficSignsOnOffAvailable = false;
        this.screensaverOnOffAvailable = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        InstrumentClusterFunctions_ConfigurationOptions instrumentClusterFunctions_ConfigurationOptions = (InstrumentClusterFunctions_ConfigurationOptions)bAPEntity;
        return this.contextSwitchToDigitalSpeedAvailable == instrumentClusterFunctions_ConfigurationOptions.contextSwitchToDigitalSpeedAvailable && this.contextSwitchToTrafficSignInformationAvailable == instrumentClusterFunctions_ConfigurationOptions.contextSwitchToTrafficSignInformationAvailable && this.contextSwitchToLastDestinationsListAvailable == instrumentClusterFunctions_ConfigurationOptions.contextSwitchToLastDestinationsListAvailable && this.contextSwitchToPhoneBookAvailable == instrumentClusterFunctions_ConfigurationOptions.contextSwitchToPhoneBookAvailable && this.trafficSignsOnOffAvailable == instrumentClusterFunctions_ConfigurationOptions.trafficSignsOnOffAvailable && this.screensaverOnOffAvailable == instrumentClusterFunctions_ConfigurationOptions.screensaverOnOffAvailable;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstrumentClusterFunctions_ConfigurationOptions:");
        stringBuffer.append("\n - Bit 5: ");
        if (this.contextSwitchToDigitalSpeedAvailable) {
            stringBuffer.append("true  (context switch to digital speed available");
        } else {
            stringBuffer.append("false  (context switch to digital speed NOT available");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.contextSwitchToTrafficSignInformationAvailable) {
            stringBuffer.append("true  (context switch to traffic sign information available");
        } else {
            stringBuffer.append("false  (context switch to traffic sign information NOT available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.contextSwitchToLastDestinationsListAvailable) {
            stringBuffer.append("true  (context switch to last destinations list available");
        } else {
            stringBuffer.append("false  (context switch to last destinations list NOT available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.contextSwitchToPhoneBookAvailable) {
            stringBuffer.append("true  (context switch to phone book available");
        } else {
            stringBuffer.append("false  (context switch to phone book NOT available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.trafficSignsOnOffAvailable) {
            stringBuffer.append("true  (traffic signs on/off available");
        } else {
            stringBuffer.append("false  (traffic signs on/off NOT available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.screensaverOnOffAvailable) {
            stringBuffer.append("true  (screensaver on/off available");
        } else {
            stringBuffer.append("false  (screensaver on/off NOT available");
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(10);
        bitStream.pushBoolean(this.contextSwitchToDigitalSpeedAvailable);
        bitStream.pushBoolean(this.contextSwitchToTrafficSignInformationAvailable);
        bitStream.pushBoolean(this.contextSwitchToLastDestinationsListAvailable);
        bitStream.pushBoolean(this.contextSwitchToPhoneBookAvailable);
        bitStream.pushBoolean(this.trafficSignsOnOffAvailable);
        bitStream.pushBoolean(this.screensaverOnOffAvailable);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(10);
        this.contextSwitchToDigitalSpeedAvailable = bitStream.popFrontBoolean();
        this.contextSwitchToTrafficSignInformationAvailable = bitStream.popFrontBoolean();
        this.contextSwitchToLastDestinationsListAvailable = bitStream.popFrontBoolean();
        this.contextSwitchToPhoneBookAvailable = bitStream.popFrontBoolean();
        this.trafficSignsOnOffAvailable = bitStream.popFrontBoolean();
        this.screensaverOnOffAvailable = bitStream.popFrontBoolean();
    }
}

