/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.BitHelper;
import de.audi.atip.sysapp.carcoding.SperrFlags;
import de.esolutions.fw.util.commons.Buffer;

public class SperrFlagImpl
implements SperrFlags {
    public static final int EXPECTED_SIZE;
    private static final int TUNER_OFFSET;
    private static final int MEDIA_OFFSET;
    private static final int PHONE_OFFSET;
    private static final int NAV_OFFSET;
    private static final int CAR_OFFSET;
    private static final int MISC_OFFSET;
    private static final int TUNER_LIMIT;
    private static final int MEDIA_LIMIT;
    private static final int PHONE_LIMIT;
    private static final int NAV_LIMIT;
    private static final int CAR_LIMIT;
    private static final int MISC_LIMIT;
    private final byte[] flagData;

    public SperrFlagImpl(byte[] byArray) {
        this.flagData = byArray;
    }

    private boolean getBit(int n, int n2, int n3) {
        int n4 = n / 8;
        int n5 = n & 8;
        if (n4 >= 0 && n4 < n3) {
            return BitHelper.getBitsFromByte(this.flagData[n2 + n4], n5, n5) > 0;
        }
        return false;
    }

    @Override
    public boolean getTunerSperrFlag(int n) {
        return this.getBit(n, 0, 2);
    }

    @Override
    public boolean getMediaSperrFlag(int n) {
        return this.getBit(n, 2, 3);
    }

    @Override
    public boolean getPhoneSperrFlag(int n) {
        return this.getBit(n, 5, 2);
    }

    @Override
    public boolean getNavSperrFlag(int n) {
        return this.getBit(n, 7, 5);
    }

    @Override
    public boolean getCarSperrFlag(int n) {
        return this.getBit(n, 12, 3);
    }

    @Override
    public boolean getMiscSperrFlag(int n) {
        return this.getBit(n, 15, 6);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if (this.flagData != null) {
            String string = "[ 0x";
            buffer.append("\n\nSperrFlags");
            for (int i2 = 0; i2 < this.flagData.length; ++i2) {
                buffer.append(string);
                buffer.append(Integer.toHexString(this.flagData[i2]));
                string = ", 0x";
            }
            buffer.append(" ]\n");
        }
        return buffer.toString();
    }
}

