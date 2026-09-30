/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerBufferUnderrunException;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.serializer.stream.DefaultSerializerBase;
import de.esolutions.fw.util.transport.IReadable;

public class DefaultDeserializerBase
implements IStreamDeserializer,
Cloneable {
    protected IReadable readable;
    protected int dpos;
    protected byte[] ddata;
    protected IMiniIntDeserializer intDeser;
    protected byte id;

    public DefaultDeserializerBase(IMiniIntDeserializer iMiniIntDeserializer, byte by) {
        this.intDeser = iMiniIntDeserializer;
        this.id = by;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean canHandleSerializerId(byte by) {
        return by == this.id;
    }

    public void attachBuffer(IReadable iReadable) {
        this.readable = iReadable;
        this.dpos = iReadable.getDirectOffset();
        this.ddata = iReadable.getDirectData();
    }

    public IReadable getAttachedBuffer() {
        return this.readable;
    }

    public int getDirectPos() {
        return this.dpos;
    }

    public int detachBuffer() {
        this.ddata = null;
        this.readable = null;
        return this.dpos;
    }

    public boolean getBool() throws SerializerBufferUnderrunException {
        try {
            byte by = this.ddata[this.dpos];
            ++this.dpos;
            return by != 0;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getBoolArray(boolean[] blArray) throws SerializerBufferUnderrunException {
        try {
            int n = blArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                blArray[i2] = this.ddata[this.dpos] != 0;
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public double getDouble() throws SerializerBufferUnderrunException {
        try {
            long l = this.intDeser.retrieveLong(this.ddata, this.dpos);
            this.dpos += 8;
            return Double.longBitsToDouble(l);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getDoubleArray(double[] dArray) throws SerializerBufferUnderrunException {
        try {
            int n = dArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                dArray[i2] = Double.longBitsToDouble(this.intDeser.retrieveLong(this.ddata, this.dpos));
                this.dpos += 8;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public int getFlags(byte by) throws SerializerBufferUnderrunException {
        int[] nArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        try {
            int n = nArray[by - 1];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                n2 <<= 8;
                n2 |= this.ddata[this.dpos] & 0xFF;
                ++this.dpos;
            }
            return n2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public float getFloat() throws SerializerBufferUnderrunException {
        try {
            float f2 = Float.intBitsToFloat(this.intDeser.retrieveInt(this.ddata, this.dpos));
            this.dpos += 4;
            return f2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getFloatArray(float[] fArray) throws SerializerBufferUnderrunException {
        try {
            int n = fArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                fArray[i2] = Float.intBitsToFloat(this.intDeser.retrieveInt(this.ddata, this.dpos));
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public short getInt16() throws SerializerBufferUnderrunException {
        try {
            short s = this.intDeser.retrieveShort(this.ddata, this.dpos);
            this.dpos += 2;
            return s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getInt16Array(short[] sArray) throws SerializerBufferUnderrunException {
        try {
            int n = sArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                sArray[i2] = this.intDeser.retrieveShort(this.ddata, this.dpos);
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public char getUChar16() throws SerializerBufferUnderrunException {
        try {
            short s = this.intDeser.retrieveShort(this.ddata, this.dpos);
            this.dpos += 2;
            return (char)s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getUChar16Array(char[] cArray) throws SerializerBufferUnderrunException {
        try {
            int n = cArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                cArray[i2] = (char)this.intDeser.retrieveShort(this.ddata, this.dpos);
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public int getInt32() throws SerializerBufferUnderrunException {
        try {
            int n = this.intDeser.retrieveInt(this.ddata, this.dpos);
            this.dpos += 4;
            return n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getInt32Array(int[] nArray) throws SerializerBufferUnderrunException {
        try {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = this.intDeser.retrieveInt(this.ddata, this.dpos);
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public long getInt64() throws SerializerBufferUnderrunException {
        try {
            long l = this.intDeser.retrieveLong(this.ddata, this.dpos);
            this.dpos += 8;
            return l;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getInt64Array(long[] lArray) throws SerializerBufferUnderrunException {
        try {
            int n = lArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = this.intDeser.retrieveLong(this.ddata, this.dpos);
                this.dpos += 8;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public byte getInt8() throws SerializerBufferUnderrunException {
        try {
            byte by = this.ddata[this.dpos];
            ++this.dpos;
            return by;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getInt8Array(byte[] byArray) throws SerializerBufferUnderrunException {
        try {
            int n = byArray.length;
            System.arraycopy((Object)this.ddata, this.dpos, (Object)byArray, 0, n);
            this.dpos += n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public int getUInt16() throws SerializerBufferUnderrunException {
        try {
            int n = this.intDeser.retrieveUnsignedShort(this.ddata, this.dpos) & 0xFFFF;
            this.dpos += 2;
            return n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getUInt16Array(int[] nArray) throws SerializerBufferUnderrunException {
        try {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = this.intDeser.retrieveUnsignedShort(this.ddata, this.dpos) & 0xFFFF;
                this.dpos += 2;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public long getUInt32() throws SerializerBufferUnderrunException {
        try {
            long l = this.intDeser.retrieveUnsignedInt(this.ddata, this.dpos) & 0xFFFFFFFFL;
            this.dpos += 4;
            return l;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getUInt32Array(long[] lArray) throws SerializerBufferUnderrunException {
        try {
            int n = lArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = this.intDeser.retrieveUnsignedInt(this.ddata, this.dpos) & 0xFFFFFFFFL;
                this.dpos += 4;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public long getUInt64() throws SerializerBufferUnderrunException {
        return this.getInt64();
    }

    public void getUInt64Array(long[] lArray) throws SerializerBufferUnderrunException {
        this.getInt64Array(lArray);
    }

    public short getUInt8() throws SerializerBufferUnderrunException {
        try {
            short s = (short)(this.ddata[this.dpos] & 0xFF);
            ++this.dpos;
            return s;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getUInt8Array(short[] sArray) throws SerializerBufferUnderrunException {
        try {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                sArray[i2] = (short)(this.ddata[this.dpos] & 0xFF);
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public void getRawBytes(byte[] byArray) throws SerializerException {
        try {
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                byArray[i2] = this.ddata[this.dpos];
                ++this.dpos;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new SerializerBufferUnderrunException(indexOutOfBoundsException.toString());
        }
    }

    public int bytesLeft() {
        return this.ddata.length - this.dpos;
    }

    public String getDescription() {
        return this.intDeser.getDescription();
    }

    public byte getId() {
        return this.id;
    }

    public IStreamSerializer createCompatibleStreamSerializer() {
        return new DefaultSerializerBase(this.intDeser.createCompatibleSerializer(), this.id);
    }

    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return new DefaultDeserializerBase(this.intDeser.createCompatibleDeserializer(), this.id);
    }
}

