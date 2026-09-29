/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Keypad_Status$KeyStatus
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean eCallLongPressed;
    public boolean eCallPressedTooShort;
    public boolean pannenrufLongPressed;
    public boolean pannenrufPressedTooShort;
    public boolean inforufLongPressed;
    public boolean inforufPressedTooShort;
    private static final int KEY_STATUS_BITSIZE;

    public Keypad_Status$KeyStatus() {
        this.internalReset();
        this.customInitialization();
    }

    public Keypad_Status$KeyStatus(BitStream bitStream) {
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Keypad_Status$KeyStatus keypad_Status$KeyStatus = (Keypad_Status$KeyStatus)bAPEntity;
        return this.eCallLongPressed == keypad_Status$KeyStatus.eCallLongPressed && this.eCallPressedTooShort == keypad_Status$KeyStatus.eCallPressedTooShort && this.pannenrufLongPressed == keypad_Status$KeyStatus.pannenrufLongPressed && this.pannenrufPressedTooShort == keypad_Status$KeyStatus.pannenrufPressedTooShort && this.inforufLongPressed == keypad_Status$KeyStatus.inforufLongPressed && this.inforufPressedTooShort == keypad_Status$KeyStatus.inforufPressedTooShort;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.eCallLongPressed);
        bitStream.pushBoolean(this.eCallPressedTooShort);
        bitStream.pushBoolean(this.pannenrufLongPressed);
        bitStream.pushBoolean(this.pannenrufPressedTooShort);
        bitStream.pushBoolean(this.inforufLongPressed);
        bitStream.pushBoolean(this.inforufPressedTooShort);
    }

    @Override
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

