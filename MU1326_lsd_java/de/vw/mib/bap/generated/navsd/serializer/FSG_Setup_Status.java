/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final VoiceGuidance voiceGuidance = new VoiceGuidance();
    public final Supported_POI_Types supported_Poi_Types = new Supported_POI_Types();
    public final FunctionSupport functionSupport = new FunctionSupport();
    public static final int DUMMY2_MAX = 0;
    public static final int DUMMY2_MIN = 0;
    public int dummy2;
    private static final int DUMMY2_BITSIZE = 8;
    public static final int DUMMY3_MAX = 0;
    public static final int DUMMY3_MIN = 0;
    public int dummy3;
    private static final int DUMMY3_BITSIZE = 8;
    public static final int DUMMY4_MAX = 0;
    public static final int DUMMY4_MIN = 0;
    public int dummy4;
    private static final int DUMMY4_BITSIZE = 8;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dummy2 = 0;
        this.dummy3 = 0;
        this.dummy4 = 0;
    }

    public void reset() {
        this.internalReset();
        this.voiceGuidance.reset();
        this.supported_Poi_Types.reset();
        this.functionSupport.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.voiceGuidance.equalTo(fSG_Setup_Status.voiceGuidance) && this.supported_Poi_Types.equalTo(fSG_Setup_Status.supported_Poi_Types) && this.functionSupport.equalTo(fSG_Setup_Status.functionSupport) && this.dummy2 == fSG_Setup_Status.dummy2 && this.dummy3 == fSG_Setup_Status.dummy3 && this.dummy4 == fSG_Setup_Status.dummy4;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - VoiceGuidance - ");
        stringBuffer.append(this.voiceGuidance.toString());
        stringBuffer.append("\n - Supported_POI_Types - ");
        stringBuffer.append(this.supported_Poi_Types.toString());
        stringBuffer.append("\n - FunctionSupport - ");
        stringBuffer.append(this.functionSupport.toString());
        stringBuffer.append("\n - Dummy2 - ");
        stringBuffer.append(this.dummy2);
        stringBuffer.append("\n - Dummy3 - ");
        stringBuffer.append(this.dummy3);
        stringBuffer.append("\n - Dummy4 - ");
        stringBuffer.append(this.dummy4);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.voiceGuidance.bitSize();
        n += this.supported_Poi_Types.bitSize();
        n += this.functionSupport.bitSize();
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        this.voiceGuidance.serialize(bitStream);
        this.supported_Poi_Types.serialize(bitStream);
        this.functionSupport.serialize(bitStream);
        bitStream.pushByte((byte)this.dummy2);
        bitStream.pushByte((byte)this.dummy3);
        bitStream.pushByte((byte)this.dummy4);
    }

    public void deserialize(BitStream bitStream) {
        this.voiceGuidance.deserialize(bitStream);
        this.supported_Poi_Types.deserialize(bitStream);
        this.functionSupport.deserialize(bitStream);
        this.dummy2 = bitStream.popFrontByte();
        this.dummy3 = bitStream.popFrontByte();
        this.dummy4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 53;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }

    public static final class VoiceGuidance
    implements BAPEntity {
        private static final int RESERVED_BIT_3__7_BITSIZE = 5;
        public boolean voiceGuidanceOnTrafficAvailable;
        public boolean voiceGuidanceOnReducedAvailable;
        public boolean voiceGuidanceOnAvailable;
        private static final int VOICE_GUIDANCE_BITSIZE = 8;

        public VoiceGuidance() {
            this.internalReset();
            this.customInitialization();
        }

        public VoiceGuidance(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.voiceGuidanceOnTrafficAvailable = false;
            this.voiceGuidanceOnReducedAvailable = false;
            this.voiceGuidanceOnAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            VoiceGuidance voiceGuidance = (VoiceGuidance)bAPEntity;
            return this.voiceGuidanceOnTrafficAvailable == voiceGuidance.voiceGuidanceOnTrafficAvailable && this.voiceGuidanceOnReducedAvailable == voiceGuidance.voiceGuidanceOnReducedAvailable && this.voiceGuidanceOnAvailable == voiceGuidance.voiceGuidanceOnAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("VoiceGuidance:");
            stringBuffer.append("\n - Bit 2: ");
            if (this.voiceGuidanceOnTrafficAvailable) {
                stringBuffer.append("true  (VoiceGuidance ON traffic (reduced announcement traffic) available");
            } else {
                stringBuffer.append("false  (VoiceGuidance ON traffic (reduced announcement traffic) (DF4.1) not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.voiceGuidanceOnReducedAvailable) {
                stringBuffer.append("true  (VoiceGuidance ON reduced (reduced announcements / reduced mode) available");
            } else {
                stringBuffer.append("false  (VoiceGuidance ON reduced (reduced announcements / reduced mode) not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.voiceGuidanceOnAvailable) {
                stringBuffer.append("true  (VoiceGuidance ON (full / complete announcements)  available");
            } else {
                stringBuffer.append("false  (VoiceGuidance ON (full / complete announcements) not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(5);
            bitStream.pushBoolean(this.voiceGuidanceOnTrafficAvailable);
            bitStream.pushBoolean(this.voiceGuidanceOnReducedAvailable);
            bitStream.pushBoolean(this.voiceGuidanceOnAvailable);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(5);
            this.voiceGuidanceOnTrafficAvailable = bitStream.popFrontBoolean();
            this.voiceGuidanceOnReducedAvailable = bitStream.popFrontBoolean();
            this.voiceGuidanceOnAvailable = bitStream.popFrontBoolean();
        }
    }

    public static final class FunctionSupport
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean activationDeactivationOfTheVideoNavigationSupported;
        private static final int FUNCTION_SUPPORT_BITSIZE = 8;

        public FunctionSupport() {
            this.internalReset();
            this.customInitialization();
        }

        public FunctionSupport(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.activationDeactivationOfTheVideoNavigationSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FunctionSupport functionSupport = (FunctionSupport)bAPEntity;
            return this.activationDeactivationOfTheVideoNavigationSupported == functionSupport.activationDeactivationOfTheVideoNavigationSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FunctionSupport:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.activationDeactivationOfTheVideoNavigationSupported) {
                stringBuffer.append("true  (activation/deactivation of the video navigation supported (DF4.4)");
            } else {
                stringBuffer.append("false  (activation/deactivation of the video navigation not supported (DF4.4)");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.activationDeactivationOfTheVideoNavigationSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.activationDeactivationOfTheVideoNavigationSupported = bitStream.popFrontBoolean();
        }
    }

    public static final class Supported_POI_Types
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean fuelStationAndParkingAreaSupported;
        private static final int SUPPORTED_POI_TYPES_BITSIZE = 8;

        public Supported_POI_Types() {
            this.internalReset();
            this.customInitialization();
        }

        public Supported_POI_Types(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.fuelStationAndParkingAreaSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Supported_POI_Types supported_POI_Types = (Supported_POI_Types)bAPEntity;
            return this.fuelStationAndParkingAreaSupported == supported_POI_Types.fuelStationAndParkingAreaSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Supported_POI_Types:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.fuelStationAndParkingAreaSupported) {
                stringBuffer.append("true  (fuel station and parking area supported");
            } else {
                stringBuffer.append("false  (fuel station parking area not supported");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.fuelStationAndParkingAreaSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.fuelStationAndParkingAreaSupported = bitStream.popFrontBoolean();
        }
    }
}

