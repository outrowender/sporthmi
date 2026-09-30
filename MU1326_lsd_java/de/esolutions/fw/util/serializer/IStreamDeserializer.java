/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IReadable;

public interface IStreamDeserializer
extends Cloneable {
    public Object clone();

    public boolean canHandleSerializerId(byte var1);

    public void attachBuffer(IReadable var1);

    public IReadable getAttachedBuffer();

    public int getDirectPos();

    public int detachBuffer();

    public boolean getBool() throws SerializerException;

    public char getUChar16() throws SerializerException;

    public short getUInt8() throws SerializerException;

    public byte getInt8() throws SerializerException;

    public int getUInt16() throws SerializerException;

    public short getInt16() throws SerializerException;

    public long getUInt32() throws SerializerException;

    public int getInt32() throws SerializerException;

    public long getUInt64() throws SerializerException;

    public long getInt64() throws SerializerException;

    public float getFloat() throws SerializerException;

    public double getDouble() throws SerializerException;

    public int getFlags(byte var1) throws SerializerException;

    public void getBoolArray(boolean[] var1) throws SerializerException;

    public void getUChar16Array(char[] var1) throws SerializerException;

    public void getUInt8Array(short[] var1) throws SerializerException;

    public void getInt8Array(byte[] var1) throws SerializerException;

    public void getUInt16Array(int[] var1) throws SerializerException;

    public void getInt16Array(short[] var1) throws SerializerException;

    public void getUInt32Array(long[] var1) throws SerializerException;

    public void getInt32Array(int[] var1) throws SerializerException;

    public void getUInt64Array(long[] var1) throws SerializerException;

    public void getInt64Array(long[] var1) throws SerializerException;

    public void getFloatArray(float[] var1) throws SerializerException;

    public void getDoubleArray(double[] var1) throws SerializerException;

    public String getDescription();

    public byte getId();

    public int bytesLeft();

    public void getRawBytes(byte[] var1) throws SerializerException;

    public IStreamSerializer createCompatibleStreamSerializer();

    public IStreamDeserializer createCompatibleStreamDeserializer();
}

