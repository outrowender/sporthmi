/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IWriteable;

public class StreamSerializerProxy
implements IStreamSerializer {
    protected IStreamSerializer serializer;

    public StreamSerializerProxy(IStreamSerializer iStreamSerializer) {
        this.serializer = iStreamSerializer;
    }

    public void attachBuffer(IWriteable iWriteable) {
        this.serializer.attachBuffer(iWriteable);
    }

    public void beginSizeCalc() {
        this.serializer.beginSizeCalc();
    }

    public IWriteable getAttachedBuffer() {
        return this.serializer.getAttachedBuffer();
    }

    public int getDirectPos() {
        return this.serializer.getDirectPos();
    }

    public int detachBuffer() {
        return this.serializer.detachBuffer();
    }

    public int endSizeCalc() {
        return this.serializer.endSizeCalc();
    }

    public byte getSerializerId() {
        return this.serializer.getSerializerId();
    }

    public void putBool(boolean bl) throws SerializerException {
        this.serializer.putBool(bl);
    }

    public void putBoolArray(boolean[] blArray) throws SerializerException {
        this.serializer.putBoolArray(blArray);
    }

    public void putUChar16(char c2) throws SerializerException {
        this.serializer.putUChar16(c2);
    }

    public void putUChar16Array(char[] cArray) throws SerializerException {
        this.serializer.putUChar16Array(cArray);
    }

    public void putDouble(double d2) throws SerializerException {
        this.serializer.putDouble(d2);
    }

    public void putDoubleArray(double[] dArray) throws SerializerException {
        this.serializer.putDoubleArray(dArray);
    }

    public void putFlags(byte by, int n) throws SerializerException {
        this.serializer.putFlags(by, n);
    }

    public void putFloat(float f2) throws SerializerException {
        this.serializer.putFloat(f2);
    }

    public void putFloatArray(float[] fArray) throws SerializerException {
        this.serializer.putFloatArray(fArray);
    }

    public void putInt16(short s) throws SerializerException {
        this.serializer.putInt16(s);
    }

    public void putInt16Array(short[] sArray) throws SerializerException {
        this.serializer.putInt16Array(sArray);
    }

    public void putInt32(int n) throws SerializerException {
        this.serializer.putInt32(n);
    }

    public void putInt32Array(int[] nArray) throws SerializerException {
        this.serializer.putInt32Array(nArray);
    }

    public void putInt64(long l) throws SerializerException {
        this.serializer.putInt64(l);
    }

    public void putInt64Array(long[] lArray) throws SerializerException {
        this.serializer.putInt64Array(lArray);
    }

    public void putInt8(byte by) throws SerializerException {
        this.serializer.putInt8(by);
    }

    public void putInt8Array(byte[] byArray) throws SerializerException {
        this.serializer.putInt8Array(byArray);
    }

    public void putUInt16(int n) throws SerializerException {
        this.serializer.putUInt16(n);
    }

    public void putUInt16Array(int[] nArray) throws SerializerException {
        this.serializer.putUInt16Array(nArray);
    }

    public void putUInt32(long l) throws SerializerException {
        this.serializer.putUInt32(l);
    }

    public void putUInt32Array(long[] lArray) throws SerializerException {
        this.serializer.putUInt32Array(lArray);
    }

    public void putUInt64(long l) throws SerializerException {
        this.serializer.putUInt64(l);
    }

    public void putUInt64Array(long[] lArray) throws SerializerException {
        this.serializer.putUInt64Array(lArray);
    }

    public void putUInt8(short s) throws SerializerException {
        this.serializer.putUInt8(s);
    }

    public void putUInt8Array(short[] sArray) throws SerializerException {
        this.serializer.putUInt8Array(sArray);
    }

    public void putRawBytes(byte[] byArray) throws SerializerException {
        this.serializer.putRawBytes(byArray);
    }

    public String getDescription() {
        return "[Proxy:" + this.serializer.getDescription() + "]";
    }

    public byte getId() {
        return this.serializer.getId();
    }

    public IStreamSerializer createCompatibleStreamSerializer() {
        return this.serializer.createCompatibleStreamSerializer();
    }

    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return this.serializer.createCompatibleStreamDeserializer();
    }
}

