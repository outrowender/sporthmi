/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.stream;

import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerBufferOverflowException;
import de.esolutions.fw.util.serializer.stream.DefaultDeserializerBase;
import de.esolutions.fw.util.transport.IWriteable;

public class DefaultSerializerBase
implements IStreamSerializer {
    protected int dpos;
    protected IWriteable writeable;
    protected byte[] ddata;
    protected boolean hasWriteable = false;
    protected IMiniIntSerializer intSer;
    protected byte id;

    public DefaultSerializerBase(IMiniIntSerializer iMiniIntSerializer, byte by) {
        this.intSer = iMiniIntSerializer;
        this.id = by;
    }

    public byte getSerializerId() {
        return this.id;
    }

    public void attachBuffer(IWriteable iWriteable) {
        this.writeable = iWriteable;
        this.ddata = iWriteable.getDirectData();
        this.dpos = iWriteable.getDirectOffset();
        this.hasWriteable = true;
    }

    public IWriteable getAttachedBuffer() {
        return this.writeable;
    }

    public int getDirectPos() {
        return this.dpos;
    }

    public void beginSizeCalc() {
        this.writeable = null;
        this.ddata = null;
        this.dpos = 0;
        this.hasWriteable = false;
    }

    public int detachBuffer() {
        int n = this.dpos;
        this.hasWriteable = false;
        this.writeable = null;
        this.ddata = null;
        this.dpos = 0;
        return n;
    }

    public int endSizeCalc() {
        int n = this.dpos;
        this.hasWriteable = false;
        this.writeable = null;
        this.dpos = 0;
        return n;
    }

    public void putBool(boolean bl) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.ddata[this.dpos] = bl ? -1 : 0;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        ++this.dpos;
    }

    public void putBoolArray(boolean[] blArray) throws SerializerBufferOverflowException {
        int n = blArray.length;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < blArray.length; ++i2) {
                    this.ddata[this.dpos] = blArray[i2] ? -1 : 0;
                    ++this.dpos;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n;
        }
    }

    public void putDouble(double d2) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                long l = Double.doubleToLongBits(d2);
                this.intSer.storeLong(l, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 8;
    }

    public void putDoubleArray(double[] dArray) throws SerializerBufferOverflowException {
        int n = dArray.length;
        int n2 = n << 3;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeLong(Double.doubleToLongBits(dArray[i2]), this.ddata, this.dpos);
                    this.dpos += 8;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putFlags(byte by, int n) throws SerializerBufferOverflowException {
        int n2;
        int[] nArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        if (by < 32) {
            n2 = (1 << by) - 1;
            n &= n2;
        }
        n2 = nArray[by - 1];
        if (this.hasWriteable) {
            try {
                int n3 = this.dpos + n2 - 1;
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.ddata[n3] = (byte)(n & 0xFF);
                    n >>= 8;
                    --n3;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += n2;
    }

    public void putFloat(float f2) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                int n = Float.floatToIntBits(f2);
                this.intSer.storeInt(n, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 4;
    }

    public void putFloatArray(float[] fArray) throws SerializerBufferOverflowException {
        int n = fArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeInt(Float.floatToIntBits(fArray[i2]), this.ddata, this.dpos);
                    this.dpos += 4;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putInt16(short s) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.intSer.storeShort(s, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 2;
    }

    public void putInt16Array(short[] sArray) throws SerializerBufferOverflowException {
        int n = sArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeShort(sArray[i2], this.ddata, this.dpos);
                    this.dpos += 2;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putUChar16(char c2) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.intSer.storeShort((short)c2, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 2;
    }

    public void putUChar16Array(char[] cArray) throws SerializerBufferOverflowException {
        int n = cArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeShort((short)cArray[i2], this.ddata, this.dpos);
                    this.dpos += 2;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putInt32(int n) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.intSer.storeInt(n, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 4;
    }

    public void putInt32Array(int[] nArray) throws SerializerBufferOverflowException {
        int n = nArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeInt(nArray[i2], this.ddata, this.dpos);
                    this.dpos += 4;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putInt64(long l) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.intSer.storeLong(l, this.ddata, this.dpos);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += 8;
    }

    public void putInt64Array(long[] lArray) throws SerializerBufferOverflowException {
        int n = lArray.length;
        int n2 = n << 3;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    this.intSer.storeLong(lArray[i2], this.ddata, this.dpos);
                    this.dpos += 8;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putInt8(byte by) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                this.ddata[this.dpos] = by;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        ++this.dpos;
    }

    public void putInt8Array(byte[] byArray) throws SerializerBufferOverflowException {
        int n = byArray.length;
        if (this.hasWriteable) {
            try {
                System.arraycopy((Object)byArray, 0, (Object)this.ddata, this.dpos, n);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new SerializerBufferOverflowException(indexOutOfBoundsException.toString());
            }
        }
        this.dpos += n;
    }

    public void putUInt16(int n) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                if (n < 0 || n > 65535) {
                    throw new Exception("Can't serialize unsigned short value: int=" + n);
                }
                this.intSer.storeShort((short)n, this.ddata, this.dpos);
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        this.dpos += 2;
    }

    public void putUInt16Array(int[] nArray) throws SerializerBufferOverflowException {
        int n = nArray.length;
        int n2 = n << 1;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    if (nArray[i2] >= 0 && nArray[i2] <= 65535) {
                        this.intSer.storeShort((short)nArray[i2], this.ddata, this.dpos);
                        this.dpos += 2;
                        continue;
                    }
                    throw new Exception("Can't serialize unsigned short value: int=" + nArray[i2]);
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putUInt32(long l) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                if (l < 0L || l > 0xFFFFFFFFL) {
                    throw new Exception("Can't serialize unsigned int value: long=" + l);
                }
                this.intSer.storeInt((int)l, this.ddata, this.dpos);
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        this.dpos += 4;
    }

    public void putUInt32Array(long[] lArray) throws SerializerBufferOverflowException {
        int n = lArray.length;
        int n2 = n << 2;
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    if (lArray[i2] >= 0L && lArray[i2] <= 0xFFFFFFFFL) {
                        this.intSer.storeInt((int)lArray[i2], this.ddata, this.dpos);
                        this.dpos += 4;
                        continue;
                    }
                    throw new Exception("Can't serialize unsigned int value: long=" + lArray[i2]);
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += n2;
        }
    }

    public void putUInt64(long l) throws SerializerBufferOverflowException {
        this.putInt64(l);
    }

    public void putUInt64Array(long[] lArray) throws SerializerBufferOverflowException {
        this.putInt64Array(lArray);
    }

    public void putUInt8(short s) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                if (s < 0 || s > 255) {
                    throw new Exception("Can't serialize unsigned byte value: short=" + s);
                }
                this.ddata[this.dpos] = (byte)s;
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        }
        ++this.dpos;
    }

    public void putUInt8Array(short[] sArray) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    if (sArray[i2] >= 0 || sArray[i2] <= 255) {
                        this.ddata[this.dpos] = (byte)sArray[i2];
                        ++this.dpos;
                        continue;
                    }
                    throw new Exception("Can't serialize unsigned byte value: short=" + sArray[i2]);
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += sArray.length;
        }
    }

    public void putRawBytes(byte[] byArray) throws SerializerBufferOverflowException {
        if (this.hasWriteable) {
            try {
                for (int i2 = 0; i2 < byArray.length; ++i2) {
                    this.ddata[this.dpos] = byArray[i2];
                    ++this.dpos;
                }
            }
            catch (Exception exception) {
                throw new SerializerBufferOverflowException(exception.toString());
            }
        } else {
            this.dpos += byArray.length;
        }
    }

    public String getDescription() {
        return this.intSer.getDescription();
    }

    public byte getId() {
        return this.id;
    }

    public IStreamSerializer createCompatibleStreamSerializer() {
        return new DefaultSerializerBase(this.intSer.createCompatibleSerializer(), this.id);
    }

    public IStreamDeserializer createCompatibleStreamDeserializer() {
        return new DefaultDeserializerBase(this.intSer.createCompatibleDeserializer(), this.id);
    }
}

