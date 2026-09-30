/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.KeyNotFoundException;
import de.audi.atip.data.exchange.UnsupportedVersionException;
import de.audi.atip.data.exchange.WrongDataTypeException;

public interface ImportData {
    public boolean getBoolean(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public byte getByte(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public short getShort(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public int getInteger(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public long getLong(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public float getFloat(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public double getDouble(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;

    public String getString(int var1, int var2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException;
}

