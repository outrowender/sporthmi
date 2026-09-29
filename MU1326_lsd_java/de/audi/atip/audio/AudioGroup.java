/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

import de.esolutions.fw.util.commons.Buffer;

public final class AudioGroup {
    public static final int MIN_GENERATED_ID;
    public static final int MAX_GENERATED_ID;
    private static final int OFFSET_FIXED_GROUP;
    private static final int OFFSET_TERMINAL;
    private static final int OFFSET_APPLICATION;
    private static final int OFFSET_SOURCE;
    private static final int OFFSET_MEDIUM;
    private static final int OFFSET_SN_NUMBER;
    private static final int FIXED;
    public static final int FRONT;
    public static final int REAR;
    public static final int ALL;
    public static final int TUNER;
    public static final int MEDIA;
    private volatile int groupID;

    public AudioGroup(int n, int n2, int n3, int n4, int n5) {
        if (n != 3 && n != 1 && n != 2) {
            throw new IllegalArgumentException("Wrong terminal.");
        }
        if (n2 != 2 && n2 != 1) {
            throw new IllegalArgumentException("Wrong application.");
        }
        if (n3 < 0 || n3 > 255) {
            throw new IllegalArgumentException("Source must be between 0 and 255.");
        }
        if (n4 < 0 || n4 > 255) {
            throw new IllegalArgumentException("Slot must be between 0 and 255.");
        }
        if (n5 < 0 || n5 > 255) {
            throw new IllegalArgumentException("Serial number must be between 0 and 255.");
        }
        int n6 = n2 << 24;
        int n7 = n << 28;
        int n8 = n3 << 16;
        int n9 = n4 << 8;
        int n10 = n5 << 0;
        this.groupID = 0x40 | n6 | n7 | n8 | n9 | n10;
    }

    public int getID() {
        return this.groupID;
    }

    public void increment() {
        int n = this.groupID & 0xFF;
        int n2 = (n + 1) % 255;
        this.groupID = this.groupID & 0xFFFFFF00 | n2;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        int n = this.groupID & 0xFF;
        int n2 = (this.groupID & 0xFF0000) >> 8;
        int n3 = (this.groupID & 0xFF00) >> 16;
        int n4 = (this.groupID & 0xF) >> 24;
        int n5 = (this.groupID & 0x30) >> 28;
        switch (n4) {
            case 1: {
                buffer.append("TUNER");
                break;
            }
            case 2: {
                buffer.append("MEDIA");
                break;
            }
            default: {
                buffer.append("UNKNOWN_APP_").append(n4);
            }
        }
        buffer.append('.');
        switch (n5) {
            case 1: {
                buffer.append("FRONT");
                break;
            }
            case 2: {
                buffer.append("REAR");
                break;
            }
            case 3: {
                buffer.append("ALL");
                break;
            }
            default: {
                buffer.append("UNKNOWN_TERMINAL_").append(n5);
            }
        }
        buffer.append('.').append("SOURCE_").append(n3);
        buffer.append('.').append("MEDIUM_").append(n2);
        buffer.append('.').append("SERIAL_").append(n);
        return buffer.toString();
    }

    public String getBinaryString() {
        return Integer.toBinaryString(this.groupID);
    }
}

