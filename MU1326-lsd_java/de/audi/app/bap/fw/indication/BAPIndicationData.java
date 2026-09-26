/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

public final class BAPIndicationData {
    public static final int INDICATION_DATATYPE_INT;
    public static final int INDICATION_DATATYPE_BYTEARRAY;
    private final int parameterType;
    private final int dataType;
    private final int dataInt;
    private final byte[] dataByteArray;

    public BAPIndicationData(int n, int n2) {
        this.parameterType = 0;
        this.dataType = n;
        this.dataInt = n2;
        this.dataByteArray = null;
    }

    public BAPIndicationData(byte[] byArray) {
        this.parameterType = 1;
        this.dataType = 0;
        this.dataInt = 0;
        this.dataByteArray = byArray;
    }

    public int getParameterType() {
        return this.parameterType;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getDataInt() {
        return this.dataInt;
    }

    public byte[] getDataByteArray() {
        return this.dataByteArray;
    }
}

