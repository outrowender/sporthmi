/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final InstalledKeys installedKeys = new InstalledKeys();

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.installedKeys.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.installedKeys.equalTo(fSG_Setup_Status.installedKeys);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - InstalledKeys - ");
        stringBuffer.append(this.installedKeys.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.installedKeys.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.installedKeys.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.installedKeys.deserialize(bitStream);
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }

    public static final class InstalledKeys
    implements BAPEntity {
        private static final int RESERVED_BIT_5__7_BITSIZE = 3;
        public boolean jokerKey5Installed;
        public boolean jokerKey4Installed;
        public boolean jokerKey3Installed;
        public boolean jokerKey2Installed;
        public boolean jokerKey1Installed;
        private static final int INSTALLED_KEYS_BITSIZE = 8;

        public InstalledKeys() {
            this.internalReset();
            this.customInitialization();
        }

        public InstalledKeys(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.jokerKey5Installed = false;
            this.jokerKey4Installed = false;
            this.jokerKey3Installed = false;
            this.jokerKey2Installed = false;
            this.jokerKey1Installed = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            InstalledKeys installedKeys = (InstalledKeys)bAPEntity;
            return this.jokerKey5Installed == installedKeys.jokerKey5Installed && this.jokerKey4Installed == installedKeys.jokerKey4Installed && this.jokerKey3Installed == installedKeys.jokerKey3Installed && this.jokerKey2Installed == installedKeys.jokerKey2Installed && this.jokerKey1Installed == installedKeys.jokerKey1Installed;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("InstalledKeys:");
            stringBuffer.append("\n - Bit 4: ");
            if (this.jokerKey5Installed) {
                stringBuffer.append("true  (JokerKey5 installed");
            } else {
                stringBuffer.append("false  (JokerKey5 not installed");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.jokerKey4Installed) {
                stringBuffer.append("true  (JokerKey4 installed");
            } else {
                stringBuffer.append("false  (JokerKey4 not installed");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.jokerKey3Installed) {
                stringBuffer.append("true  (JokerKey3 installed");
            } else {
                stringBuffer.append("false  (JokerKey3 not installed");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.jokerKey2Installed) {
                stringBuffer.append("true  (JokerKey2 installed");
            } else {
                stringBuffer.append("false  (JokerKey2 not installed");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.jokerKey1Installed) {
                stringBuffer.append("true  (JokerKey1 installed");
            } else {
                stringBuffer.append("false  (JokerKey1 not installed");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(3);
            bitStream.pushBoolean(this.jokerKey5Installed);
            bitStream.pushBoolean(this.jokerKey4Installed);
            bitStream.pushBoolean(this.jokerKey3Installed);
            bitStream.pushBoolean(this.jokerKey2Installed);
            bitStream.pushBoolean(this.jokerKey1Installed);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(3);
            this.jokerKey5Installed = bitStream.popFrontBoolean();
            this.jokerKey4Installed = bitStream.popFrontBoolean();
            this.jokerKey3Installed = bitStream.popFrontBoolean();
            this.jokerKey2Installed = bitStream.popFrontBoolean();
            this.jokerKey1Installed = bitStream.popFrontBoolean();
        }
    }
}

