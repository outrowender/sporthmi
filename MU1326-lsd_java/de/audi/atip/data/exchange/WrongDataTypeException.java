/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

public class WrongDataTypeException
extends Exception {
    private static final long serialVersionUID;
    private final int expectedDataType;
    private final int currentDataType;

    public WrongDataTypeException(int n, int n2) {
        super(new StringBuffer().append("Expected data type ").append(n).append(", but type was ").append(n2).toString());
        this.expectedDataType = n;
        this.currentDataType = n2;
    }

    WrongDataTypeException(int n, Object object) {
        super(new StringBuffer().append("Expected data type ").append(n).append(", but value was ").append(object).toString());
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

