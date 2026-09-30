/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Keypad_Status
implements StatusProperty {
    public final KeyStatus keyStatus = new KeyStatus();

    public Keypad_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Keypad_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.keyStatus.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Keypad_Status keypad_Status = (Keypad_Status)bAPEntity;
        return this.keyStatus.equalTo(keypad_Status.keyStatus);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Keypad_Status:");
        stringBuffer.append("\n - KeyStatus - ");
        stringBuffer.append(this.keyStatus.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.keyStatus.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.keyStatus.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.keyStatus.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    public int getFunctionId() {
        return Keypad_Status.functionId();
    }

    public static final class KeyStatus
    implements BAPEntity {
        private static final int RESERVED_BIT_6__7_BITSIZE = 2;
        public boolean eCallLongPressed;
        public boolean eCallPressedTooShort;
        public boolean pannenrufLongPressed;
        public boolean pannenrufPressedTooShort;
        public boolean inforufLongPressed;
        public boolean inforufPressedTooShort;
        private static final int KEY_STATUS_BITSIZE = 8;

        public KeyStatus() {
            this.internalReset();
            this.customInitialization();
        }

        public KeyStatus(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.eCallLongPressed = false;
            this.eCallPressedTooShort = false;
            this.pannenrufLongPressed = false;
            this.pannenrufPressedTooShort = false;
            this.inforufLongPressed = false;
            this.inforufPressedTooShort = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            KeyStatus keyStatus = (KeyStatus)bAPEntity;
            return this.eCallLongPressed == keyStatus.eCallLongPressed && this.eCallPressedTooShort == keyStatus.eCallPressedTooShort && this.pannenrufLongPressed == keyStatus.pannenrufLongPressed && this.pannenrufPressedTooShort == keyStatus.pannenrufPressedTooShort && this.inforufLongPressed == keyStatus.inforufLongPressed && this.inforufPressedTooShort == keyStatus.inforufPressedTooShort;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("KeyStatus:");
            stringBuffer.append("\n - Bit 5: ");
            if (this.eCallLongPressed) {
                stringBuffer.append("true  (eCall long pressed");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.eCallPressedTooShort) {
                stringBuffer.append("true  (eCall pressed too short");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.pannenrufLongPressed) {
                stringBuffer.append("true  (Pannenruf long pressed");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.pannenrufPressedTooShort) {
                stringBuffer.append("true  (Pannenruf pressed too short");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.inforufLongPressed) {
                stringBuffer.append("true  (Inforuf long pressed");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.inforufPressedTooShort) {
                stringBuffer.append("true  (Inforuf pressed too short");
            } else {
                stringBuffer.append("false  (reserved");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.eCallLongPressed);
            bitStream.pushBoolean(this.eCallPressedTooShort);
            bitStream.pushBoolean(this.pannenrufLongPressed);
            bitStream.pushBoolean(this.pannenrufPressedTooShort);
            bitStream.pushBoolean(this.inforufLongPressed);
            bitStream.pushBoolean(this.inforufPressedTooShort);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(2);
            this.eCallLongPressed = bitStream.popFrontBoolean();
            this.eCallPressedTooShort = bitStream.popFrontBoolean();
            this.pannenrufLongPressed = bitStream.popFrontBoolean();
            this.pannenrufPressedTooShort = bitStream.popFrontBoolean();
            this.inforufLongPressed = bitStream.popFrontBoolean();
            this.inforufPressedTooShort = bitStream.popFrontBoolean();
        }
    }
}

