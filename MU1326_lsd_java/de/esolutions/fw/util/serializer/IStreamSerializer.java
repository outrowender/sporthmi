/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IWriteable;

public interface IStreamSerializer {
    public byte getSerializerId();

    public void attachBuffer(IWriteable var1);

    public IWriteable getAttachedBuffer();

    public int getDirectPos();

    public int detachBuffer();

    public void beginSizeCalc();

    public int endSizeCalc();

    public void putBool(boolean var1) throws SerializerException;

    public void putUChar16(char var1) throws SerializerException;

    public void putUInt8(short var1) throws SerializerException;

    public void putInt8(byte var1) throws SerializerException;

    public void putUInt16(int var1) throws SerializerException;

    public void putInt16(short var1) throws SerializerException;

    public void putUInt32(long var1) throws SerializerException;

    public void putInt32(int var1) throws SerializerException;

    public void putUInt64(long var1) throws SerializerException;

    public void putInt64(long var1) throws SerializerException;

    public void putFloat(float var1) throws SerializerException;

    public void putDouble(double var1) throws SerializerException;

    public void putFlags(byte var1, int var2) throws SerializerException;

    public void putBoolArray(boolean[] var1) throws SerializerException;

    public void putUChar16Array(char[] var1) throws SerializerException;

    public void putUInt8Array(short[] var1) throws SerializerException;

    public void putInt8Array(byte[] var1) throws SerializerException;

    public void putUInt16Array(int[] var1) throws SerializerException;

    public void putInt16Array(short[] var1) throws SerializerException;

    public void putUInt32Array(long[] var1) throws SerializerException;

    public void putInt32Array(int[] var1) throws SerializerException;

    public void putUInt64Array(long[] var1) throws SerializerException;

    public void putInt64Array(long[] var1) throws SerializerException;

    public void putFloatArray(float[] var1) throws SerializerException;

    public void putDoubleArray(double[] var1) throws SerializerException;

    public String getDescription();

    public byte getId();

    public void putRawBytes(byte[] var1) throws SerializerException;

    public IStreamSerializer createCompatibleStreamSerializer();

    public IStreamDeserializer createCompatibleStreamDeserializer();
}

