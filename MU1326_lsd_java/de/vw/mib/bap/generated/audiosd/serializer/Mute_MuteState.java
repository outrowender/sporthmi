/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Mute_MuteState
implements BAPEntity {
    public boolean onlineRadioMutingLowSignal;
    public boolean ibocMutingLowSignal;
    public boolean mutingDueToActivePhoneCall;
    public boolean ibocIsNotInSync;
    public boolean sdarsMutingLowSignal;
    public boolean dvbTvMutingLowSignal;
    public boolean dabMutingLowSignal;
    public boolean muting;
    private static final int MUTE_MUTE_STATE_BITSIZE = 8;

    public Mute_MuteState() {
        this.internalReset();
        this.customInitialization();
    }

    public Mute_MuteState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineRadioMutingLowSignal = false;
        this.ibocMutingLowSignal = false;
        this.mutingDueToActivePhoneCall = false;
        this.ibocIsNotInSync = false;
        this.sdarsMutingLowSignal = false;
        this.dvbTvMutingLowSignal = false;
        this.dabMutingLowSignal = false;
        this.muting = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Mute_MuteState mute_MuteState = (Mute_MuteState)bAPEntity;
        return this.onlineRadioMutingLowSignal == mute_MuteState.onlineRadioMutingLowSignal && this.ibocMutingLowSignal == mute_MuteState.ibocMutingLowSignal && this.mutingDueToActivePhoneCall == mute_MuteState.mutingDueToActivePhoneCall && this.ibocIsNotInSync == mute_MuteState.ibocIsNotInSync && this.sdarsMutingLowSignal == mute_MuteState.sdarsMutingLowSignal && this.dvbTvMutingLowSignal == mute_MuteState.dvbTvMutingLowSignal && this.dabMutingLowSignal == mute_MuteState.dabMutingLowSignal && this.muting == mute_MuteState.muting;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mute_MuteState:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.onlineRadioMutingLowSignal) {
            stringBuffer.append("true  (OnlineRadio muting / low signal (DF4.1)");
        } else {
            stringBuffer.append("false  (OnlineRadio not muted / signal OK or OnlineRadio not built-in (DF4.1)");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.ibocMutingLowSignal) {
            stringBuffer.append("true  (IBOC muting / low signal");
        } else {
            stringBuffer.append("false  (IBOC not muting / signal OK / IBOC not built-in");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.mutingDueToActivePhoneCall) {
            stringBuffer.append("true  (muting due to active phone call");
        } else {
            stringBuffer.append("false  (not muting due to active phone call");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.ibocIsNotInSync) {
            stringBuffer.append("true  (IBOC is not in sync (digital signal cannot be decoded)");
        } else {
            stringBuffer.append("false  (IBOC is in sync (signal OK) or not broadcast at all / IBOC not supported by FSG");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.sdarsMutingLowSignal) {
            stringBuffer.append("true  (SDARS muting / low signal");
        } else {
            stringBuffer.append("false  (SDARS not muted / signal OK / SDARS not built-in");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.dvbTvMutingLowSignal) {
            stringBuffer.append("true  (DVB / TV  muting / low signal");
        } else {
            stringBuffer.append("false  (DVB / TV not muted / signal OK / DVB or TV not built-in");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.dabMutingLowSignal) {
            stringBuffer.append("true  (DAB muting / low signal");
        } else {
            stringBuffer.append("false  (DAB not muted / signal OK / FSG not tuned to DAB");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.muting) {
            stringBuffer.append("true  ((entertainment) muting");
        } else {
            stringBuffer.append("false  (demuting / not muted");
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.onlineRadioMutingLowSignal);
        bitStream.pushBoolean(this.ibocMutingLowSignal);
        bitStream.pushBoolean(this.mutingDueToActivePhoneCall);
        bitStream.pushBoolean(this.ibocIsNotInSync);
        bitStream.pushBoolean(this.sdarsMutingLowSignal);
        bitStream.pushBoolean(this.dvbTvMutingLowSignal);
        bitStream.pushBoolean(this.dabMutingLowSignal);
        bitStream.pushBoolean(this.muting);
    }

    public void deserialize(BitStream bitStream) {
        this.onlineRadioMutingLowSignal = bitStream.popFrontBoolean();
        this.ibocMutingLowSignal = bitStream.popFrontBoolean();
        this.mutingDueToActivePhoneCall = bitStream.popFrontBoolean();
        this.ibocIsNotInSync = bitStream.popFrontBoolean();
        this.sdarsMutingLowSignal = bitStream.popFrontBoolean();
        this.dvbTvMutingLowSignal = bitStream.popFrontBoolean();
        this.dabMutingLowSignal = bitStream.popFrontBoolean();
        this.muting = bitStream.popFrontBoolean();
    }
}

