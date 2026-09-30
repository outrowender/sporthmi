/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IReadable;

public class StreamDeserializerProxy
implements IStreamDeserializer,
Cloneable {
    protected IStreamDeserializer deserializer;

    public StreamDeserializerProxy(IStreamDeserializer iStreamDeserializer) {
        this.deserializer = iStreamDeserializer;
    }

    public Object clone() {
        try {
            StreamDeserializerProxy streamDeserializerProxy = (StreamDeserializerProxy)super.clone();
            streamDeserializerProxy.deserializer = (IStreamDeserializer)this.deserializer.clone();
            return streamDeserializerProxy;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean canHandleSerializerId(byte by) {
        return this.deserializer.canHandleSerializerId(by);
    }

    public void attachBuffer(IReadable iReadable) {
        this.deserializer.attachBuffer(iReadable);
    }

    public IReadable getAttachedBuffer() {
        return this.deserializer.getAttachedBuffer();
    }

    public int getDirectPos() {
        return this.deserializer.getDirectPos();
    }

    public int detachBuffer() {
        return this.deserializer.detachBuffer();
    }

    public boolean getBool() throws SerializerException {
        return this.deserializer.getBool();
    }

    public char getUChar16() throws SerializerException {
        return this.deserializer.getUChar16();
    }

    public short getUInt8() throws SerializerException {
        return this.deserializer.getUInt8();
    }

    public byte getInt8() throws SerializerException {
        return this.deserializer.getInt8();
    }

    public int getUInt16() throws SerializerException {
        return this.deserializer.getUInt16();
    }

    public short getInt16() throws SerializerException {
        return this.deserializer.getInt16();
    }

    public long getUInt32() throws SerializerException {
        return this.deserializer.getUInt32();
    }

    public int getInt32() throws SerializerException {
        return this.deserializer.getInt32();
    }

    public long getUInt64() throws SerializerException {
        return this.deserializer.getUInt64();
    }

    public long getInt64() throws SerializerException {
        return this.deserializer.getInt64();
    }

    public float getFloat() throws SerializerException {
        return this.deserializer.getFloat();
    }

    public double getDouble() throws SerializerException {
        return this.deserializer.getDouble();
    }

    public int getFlags(byte by) throws SerializerException {
        return this.deserializer.getFlags(by);
    }

    public void getBoolArray(boolean[] blArray) throws SerializerException {
        this.deserializer.getBoolArray(blArray);
    }

    public void getUChar16Array(char[] cArray) throws SerializerException {
        this.deserializer.getUChar16Array(cArray);
    }

    public void getUInt8Array(short[] sArray) throws SerializerException {
        this.deserializer.getUInt8Array(sArray);
    }

    public void getInt8Array(byte[] byArray) throws SerializerException {
        this.deserializer.getInt8Array(byArray);
    }

    public void getUInt16Array(int[] nArray) throws SerializerException {
        this.deserializer.getUInt16Array(nArray);
    }

    public void getInt16Array(short[] sArray) throws SerializerException {
        this.deserializer.getInt16Array(sArray);
    }

    public void getUInt32Array(long[] lArray) throws SerializerException {
        this.deserializer.getUInt32Array(lArray);
    }

    public void getInt32Array(int[] nArray) throws SerializerException {
        this.deserializer.getInt32Array(nArray);
    }

    public void getUInt64Array(long[] lArray) throws SerializerException {
        this.deserializer.getUInt64Array(lArray);
    }

    public void getInt64Array(long[] lArray) throws SerializerException {
        this.deserializer.getInt64Array(lArray);
    }

    public void getFloatArray(float[] fArray) throws SerializerException {
        this.deserializer.getFloatArray(fArray);
    }

    public void getDoubleArray(double[] dArray) throws SerializerException {
        this.deserializer.getDoubleArray(dArray);
    }

    public void getRawBytes(byte[] byArray) throws SerializerException {
        this.deserializer.getRawBytes(byArray);
    }

    public int bytesLeft() {
        return this.deserializer.bytesLeft();
    }

    public String getDescription() {
        return "[Proxy:" + this.deserializer.getDescription() + "]";
    }

    public byte getId() {
        return this.deserializer.getId();
    }

    public IStreamSerializer createCompatibleStreamSerializer() {
        return this.deserializer.createCompatibleStreamSerializer();
    }

    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return this.deserializer.createCompatibleStreamDeserializer();
    }
}

