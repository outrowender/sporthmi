/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class WrongDataTypeException
extends Exception {
    private static final long serialVersionUID = 3902036921983547104L;
    private final int expectedDataType;
    private final int currentDataType;

    public WrongDataTypeException(int n, int n2) {
        super("Expected data type " + n + ", but type was " + n2);
        this.expectedDataType = n;
        this.currentDataType = n2;
    }

    WrongDataTypeException(int n, Object object) {
        super("Expected data type " + n + ", but value was " + object);
        this.expectedDataType = n;
        this.currentDataType = -1;
    }

    WrongDataTypeException(String string) {
        super(string);
        this.expectedDataType = -1;
        this.currentDataType = -1;
    }

    public int getExpectedDataType() {
        return this.expectedDataType;
    }

    public int getCurrentDataType() {
        return this.currentDataType;
    }
}

