/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

public class CL3Exception
extends RuntimeException {
    public static final int BER = -2147483627;
    public static final int VERSION = -2147483647;
    public static final int OID = -2147483646;
    public static final int PARAM = -2147483645;
    public static final int RANGE = -2147483640;
    public static final int INVALID = -2147483643;
    public static final int NOTIMPL = -2147483626;
    public static final int ILLUSE = -2147483625;
    public static final int OBJECT = -2147483636;
    public static final int NOALG = -2147483624;
    public static final int SELFFAIL = -2147483623;
    public int reason;
    private static String[] reasonCodes = new String[64];

    static {
        CL3Exception.reasonCodes[21] = "Illegal ASN.1/BER encoding";
        CL3Exception.reasonCodes[1] = "Unknown data version";
        CL3Exception.reasonCodes[2] = "Unknown OID";
        CL3Exception.reasonCodes[3] = "Illegal parameter";
        CL3Exception.reasonCodes[8] = "Value out of range";
        CL3Exception.reasonCodes[5] = "Invalid data/parameter";
        CL3Exception.reasonCodes[22] = "Not implemented";
        CL3Exception.reasonCodes[23] = "Illegal use";
        CL3Exception.reasonCodes[12] = "Illegal object";
        CL3Exception.reasonCodes[24] = "Algorithm not supported";
        CL3Exception.reasonCodes[25] = "Internal self test failed";
    }

    public CL3Exception() {
    }

    public CL3Exception(int n) {
        this.reason = n;
    }

    public String getMessage() {
        int n = this.reason ^ Integer.MIN_VALUE;
        return "reason=0x" + Long.toString((long)this.reason & 0xFFFFFFFFL, 16) + " (" + (n < 0 || n > reasonCodes.length ? "?" : reasonCodes[n]) + ")";
    }
}

