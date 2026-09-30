/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import com.ibm.oti.nio.BufferUtil;
import com.ibm.oti.nio.ByteBufferUtil;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.CharBufferImpl;
import java.nio.DoubleBuffer;
import java.nio.DoubleBufferImpl;
import java.nio.FloatBuffer;
import java.nio.FloatBufferImpl;
import java.nio.IntBuffer;
import java.nio.IntBufferImpl;
import java.nio.InvalidDirectBufferException;
import java.nio.LongBuffer;
import java.nio.LongBufferImpl;
import java.nio.ShortBuffer;
import java.nio.ShortBufferImpl;

class ByteBufferImpl
extends ByteBuffer
implements BufferUtil,
ByteBufferUtil {
    private int pointer = 0;
    private boolean isDirect = false;
    private boolean isExternal = false;
    private ByteBufferImpl parent = null;

    private native int allocateDirectByte(int var1);

    private native int getDirectBytePointer(int var1, int var2);

    private native byte getDirectByte(int var1, int var2);

    private native void getDirectByteArray(int var1, int var2, int var3, byte[] var4, int var5);

    private native void putDirectByte(int var1, int var2, byte var3);

    private native void putDirectByteArray(int var1, int var2, int var3, byte[] var4, int var5);

    private native float getDirectFloat(int var1, int var2, boolean var3);

    private native void getDirectFloatArray(int var1, int var2, int var3, float[] var4, int var5, boolean var6);

    private native void putDirectFloat(int var1, int var2, float var3, boolean var4);

    private native void putDirectFloatArray(int var1, int var2, int var3, float[] var4, int var5, boolean var6);

    private native int getDirectInt(int var1, int var2, boolean var3);

    private native void getDirectIntArray(int var1, int var2, int var3, int[] var4, int var5, boolean var6);

    private native void putDirectInt(int var1, int var2, int var3, boolean var4);

    private native void putDirectIntArray(int var1, int var2, int var3, int[] var4, int var5, boolean var6);

    private native long getDirectLong(int var1, int var2, boolean var3);

    private native void getDirectLongArray(int var1, int var2, int var3, long[] var4, int var5, boolean var6);

    private native void putDirectLong(int var1, int var2, long var3, boolean var5);

    private native void putDirectLongArray(int var1, int var2, int var3, long[] var4, int var5, boolean var6);

    private native double getDirectDouble(int var1, int var2, boolean var3);

    private native void getDirectDoubleArray(int var1, int var2, int var3, double[] var4, int var5, boolean var6);

    private native void putDirectDouble(int var1, int var2, double var3, boolean var5);

    private native void putDirectDoubleArray(int var1, int var2, int var3, double[] var4, int var5, boolean var6);

    private native char getDirectChar(int var1, int var2, boolean var3);

    private native void getDirectCharArray(int var1, int var2, int var3, char[] var4, int var5, boolean var6);

    private native void putDirectChar(int var1, int var2, char var3, boolean var4);

    private native void putDirectCharArray(int var1, int var2, int var3, char[] var4, int var5, boolean var6);

    private native short getDirectShort(int var1, int var2, boolean var3);

    private native void getDirectShortArray(int var1, int var2, int var3, short[] var4, int var5, boolean var6);

    private native void putDirectShort(int var1, int var2, short var3, boolean var4);

    private native void putDirectShortArray(int var1, int var2, int var3, short[] var4, int var5, boolean var6);

    private native byte getMaxByteOfArray(int var1, int var2);

    private native boolean isNoNegativeByteArray(int var1, int var2);

    private native void freePointer(int var1);

    static native boolean isNativeLittleEndian();

    ByteBufferImpl(byte[] byArray, int n, int n2, int n3) {
        super(n, n + n2, n2, byArray, n3);
    }

    ByteBufferImpl(int n) {
        super(0, n, n);
        this.isDirect = true;
        if (n != 0) {
            this.pointer = this.allocateDirectByte(n);
            this.address = this.pointer;
            if (this.pointer == 0) {
                throw new OutOfMemoryError("direct buffer cannot be allocated");
            }
        }
    }

    ByteBufferImpl(long l, int n) {
        super(0, n, n);
        if (n < 0) {
            throw new IllegalArgumentException("the capacity is a negative integer");
        }
        this.isDirect = true;
        this.isExternal = true;
        this.pointer = (int)l;
        this.address = this.pointer;
    }

    ByteBufferImpl(int n, ByteBufferImpl byteBufferImpl, int n2) {
        super(0, n2, n2);
        this.pointer = n;
        this.address = this.pointer;
        this.isDirect = true;
        this.parent = byteBufferImpl;
    }

    public FloatBuffer asFloatBuffer() {
        this.validate();
        int n = this.remaining() / 4;
        return this.isDirect() ? new FloatBufferImpl(this, n, this.position()) : new FloatBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public IntBuffer asIntBuffer() {
        this.validate();
        int n = this.remaining() / 4;
        return this.isDirect() ? new IntBufferImpl(this, n, this.position()) : new IntBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public LongBuffer asLongBuffer() {
        this.validate();
        int n = this.remaining() / 8;
        return this.isDirect() ? new LongBufferImpl(this, n, this.position()) : new LongBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public DoubleBuffer asDoubleBuffer() {
        this.validate();
        int n = this.remaining() / 8;
        return this.isDirect() ? new DoubleBufferImpl(this, n, this.position()) : new DoubleBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public CharBuffer asCharBuffer() {
        this.validate();
        int n = this.remaining() / 2;
        return this.isDirect() ? new CharBufferImpl(this, n, this.position()) : new CharBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public ShortBuffer asShortBuffer() {
        this.validate();
        int n = this.remaining() / 2;
        return this.isDirect() ? new ShortBufferImpl(this, n, this.position()) : new ShortBufferImpl(this, this.array(), n, this.position() + this.arrayOffset());
    }

    public byte get() {
        if (this.position() >= this.limit()) {
            throw new BufferUnderflowException();
        }
        this.validate();
        byte by = 0;
        by = this.isDirect() ? this.getDirectByte(this.pointer, this.position()) : this.array()[this.position() + this.arrayOffset()];
        this.position(this.position() + 1);
        return by;
    }

    public byte get(int n) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        this.validate();
        byte by = 0;
        by = this.isDirect() ? this.getDirectByte(this.pointer, n) : this.array()[n + this.arrayOffset()];
        return by;
    }

    public float getFloat() {
        if (this.remaining() < 4) {
            throw new BufferUnderflowException();
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            this.validate();
            f2 = this.getDirectFloat(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            f2 = this.getFloatFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 4);
        return f2;
    }

    public float getFloat(int n) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        float f2 = 0.0f;
        if (this.isDirect()) {
            this.validate();
            f2 = this.getDirectFloat(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            f2 = this.getFloatFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return f2;
    }

    public int getInt() {
        if (this.remaining() < 4) {
            throw new BufferUnderflowException();
        }
        int n = 0;
        if (this.isDirect()) {
            this.validate();
            n = this.getDirectInt(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n2 = this.position() + this.arrayOffset();
            n = this.getIntFromByteArray(this.order(), byArray, n2);
        }
        this.position(this.position() + 4);
        return n;
    }

    public int getInt(int n) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        int n2 = 0;
        if (this.isDirect()) {
            this.validate();
            n2 = this.getDirectInt(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            n2 = this.getIntFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return n2;
    }

    public long getLong() {
        if (this.remaining() < 8) {
            throw new BufferUnderflowException();
        }
        long l = 0L;
        if (this.isDirect()) {
            this.validate();
            l = this.getDirectLong(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            l = this.getLongFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 8);
        return l;
    }

    public long getLong(int n) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus seven");
        }
        long l = 0L;
        if (this.isDirect()) {
            this.validate();
            l = this.getDirectLong(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            l = this.getLongFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return l;
    }

    public double getDouble() {
        if (this.remaining() < 8) {
            throw new BufferUnderflowException();
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            this.validate();
            d2 = this.getDirectDouble(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            d2 = this.getDoubleFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 8);
        return d2;
    }

    public double getDouble(int n) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus seven");
        }
        double d2 = 0.0;
        if (this.isDirect()) {
            this.validate();
            d2 = this.getDirectDouble(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            d2 = this.getDoubleFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return d2;
    }

    public char getChar() {
        if (this.remaining() < 2) {
            throw new BufferUnderflowException();
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            this.validate();
            c2 = this.getDirectChar(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            c2 = this.getCharFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 2);
        return c2;
    }

    public char getChar(int n) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is negative or not smaller than the buffer's limit, minus three");
        }
        char c2 = '\u0000';
        if (this.isDirect()) {
            this.validate();
            c2 = this.getDirectChar(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            c2 = this.getCharFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return c2;
    }

    public short getShort() {
        if (this.remaining() < 2) {
            throw new BufferUnderflowException();
        }
        short s = 0;
        if (this.isDirect()) {
            this.validate();
            s = this.getDirectShort(this.pointer, this.position(), this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            s = this.getShortFromByteArray(this.order(), byArray, n);
        }
        this.position(this.position() + 2);
        return s;
    }

    public short getShort(int n) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        short s = 0;
        if (this.isDirect()) {
            this.validate();
            s = this.getDirectShort(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            s = this.getShortFromByteArray(this.order(), byArray, n += this.arrayOffset());
        }
        return s;
    }

    public boolean isDirect() {
        return this.isDirect;
    }

    public ByteBuffer put(byte by) {
        if (this.position() >= this.limit()) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectByte(this.pointer, this.position(), by);
        } else {
            this.array()[this.position() + this.arrayOffset()] = by;
        }
        this.position(this.position() + 1);
        return this;
    }

    public ByteBuffer put(int n, byte by) {
        if (n < 0 || n >= this.limit()) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectByte(this.pointer, n, by);
        } else {
            this.array()[n + this.arrayOffset()] = by;
        }
        return this;
    }

    public ByteBuffer putFloat(float f2) {
        if (this.remaining() < 4) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectFloat(this.pointer, this.position(), f2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putFloatToByteArray(this.order(), byArray, n, f2);
        }
        this.position(this.position() + 4);
        return this;
    }

    public ByteBuffer putFloat(int n, float f2) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectFloat(this.pointer, n, f2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putFloatToByteArray(this.order(), byArray, n += this.arrayOffset(), f2);
        }
        return this;
    }

    public ByteBuffer putInt(int n) {
        if (this.remaining() < 4) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectInt(this.pointer, this.position(), n, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n2 = this.position() + this.arrayOffset();
            this.putIntToByteArray(this.order(), byArray, n2, n);
        }
        this.position(this.position() + 4);
        return this;
    }

    public ByteBuffer putInt(int n, int n2) {
        if (n < 0 || n > this.limit() - 4) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectInt(this.pointer, n, n2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putIntToByteArray(this.order(), byArray, n += this.arrayOffset(), n2);
        }
        return this;
    }

    public ByteBuffer putLong(long l) {
        if (this.remaining() < 8) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectLong(this.pointer, this.position(), l, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putLongToByteArray(this.order(), byArray, n, l);
        }
        this.position(this.position() + 8);
        return this;
    }

    public ByteBuffer putLong(int n, long l) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectLong(this.pointer, n, l, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putLongToByteArray(this.order(), byArray, n += this.arrayOffset(), l);
        }
        return this;
    }

    public ByteBuffer putDouble(double d2) {
        if (this.remaining() < 8) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectDouble(this.pointer, this.position(), d2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putDoubleToByteArray(this.order(), byArray, n, d2);
        }
        this.position(this.position() + 8);
        return this;
    }

    public ByteBuffer putDouble(int n, double d2) {
        if (n < 0 || n > this.limit() - 8) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectDouble(this.pointer, n, d2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putDoubleToByteArray(this.order(), byArray, n += this.arrayOffset(), d2);
        }
        return this;
    }

    public ByteBuffer putChar(char c2) {
        if (this.remaining() < 2) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectChar(this.pointer, this.position(), c2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putCharToByteArray(this.order(), byArray, n, c2);
        }
        this.position(this.position() + 2);
        return this;
    }

    public ByteBuffer putChar(int n, char c2) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectChar(this.pointer, n, c2, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putCharToByteArray(this.order(), byArray, n += this.arrayOffset(), c2);
        }
        return this;
    }

    public ByteBuffer putShort(short s) {
        if (this.remaining() < 2) {
            throw new BufferOverflowException();
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectShort(this.pointer, this.position(), s, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            int n = this.position() + this.arrayOffset();
            this.putShortToByteArray(this.order(), byArray, n, s);
        }
        this.position(this.position() + 2);
        return this;
    }

    public ByteBuffer putShort(int n, short s) {
        if (n < 0 || n > this.limit() - 2) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        if (this.isDirect()) {
            this.validate();
            this.putDirectShort(this.pointer, n, s, this.order() != ByteOrder.NATIVE_ORDER);
        } else {
            byte[] byArray = this.array();
            this.putShortToByteArray(this.order(), byArray, n += this.arrayOffset(), s);
        }
        return this;
    }

    public ByteBuffer slice() {
        if (this.isDirect()) {
            this.validate();
            return new ByteBufferImpl(this.getDirectBytePointer(this.pointer, this.position()), this, this.remaining());
        }
        return new ByteBufferImpl(this.array(), 0, this.remaining(), this.position() + this.arrayOffset());
    }

    public synchronized void dispose() {
        if (this.pointer != 0 && this.parent == null && !this.isExternal) {
            this.freePointer(this.pointer);
            this.pointer = 0;
        }
    }

    protected void finalize() throws Throwable {
        try {
            this.dispose();
        }
        finally {
            super.finalize();
        }
    }

    public int getDirectPointer() {
        this.validate();
        return this.getDirectBytePointer(this.pointer, this.position());
    }

    public boolean isByteArray() {
        return this.hasArray();
    }

    public byte getMaxOfArray(int n) {
        if (this.isDirect()) {
            this.validate();
            return this.getMaxByteOfArray(this.getDirectPointer(), n);
        }
        byte[] byArray = this.array();
        int n2 = this.position();
        byte by = byArray[n2];
        int n3 = n2 + 1;
        while (n3 < n2 + n) {
            if (byArray[n3] > by) {
                by = byArray[n3];
            }
            ++n3;
        }
        return by;
    }

    public boolean isNoNegativeArray(int n) {
        int n2;
        if (this.isDirect()) {
            this.validate();
            return this.isNoNegativeByteArray(this.position(), n);
        }
        byte[] byArray = this.array();
        int n3 = n2 = this.position();
        while (n3 < n2 + n) {
            if (byArray[n3] < 0) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    void getDirectByteArray(byte[] byArray, int n, int n2) {
        this.validate();
        this.getDirectByteArray(this.pointer, this.position(), n2, byArray, n);
    }

    float getDirectFloat(int n) {
        this.validate();
        return this.getDirectFloat(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    int getDirectInt(int n) {
        this.validate();
        return this.getDirectInt(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    long getDirectLong(int n) {
        this.validate();
        return this.getDirectLong(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    double getDirectDouble(int n) {
        this.validate();
        return this.getDirectDouble(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    char getDirectChar(int n) {
        this.validate();
        return this.getDirectChar(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    short getDirectShort(int n) {
        this.validate();
        return this.getDirectShort(this.pointer, n, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectByteArray(byte[] byArray, int n, int n2) {
        this.validate();
        this.putDirectByteArray(this.pointer, this.position(), n2, byArray, n);
    }

    int getDirectPointer(int n) {
        this.validate();
        return this.getDirectBytePointer(this.pointer, n);
    }

    void putDirectFloat(int n, float f2) {
        this.validate();
        this.putDirectFloat(this.pointer, n, f2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectInt(int n, int n2) {
        this.validate();
        this.putDirectInt(this.pointer, n, n2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectLong(int n, long l) {
        this.validate();
        this.putDirectLong(this.pointer, n, l, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectDouble(int n, double d2) {
        this.validate();
        this.putDirectDouble(this.pointer, n, d2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectChar(int n, char c2) {
        this.validate();
        this.putDirectChar(this.pointer, n, c2, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectShort(int n, short s) {
        this.validate();
        this.putDirectShort(this.pointer, n, s, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectFloatArray(int n, int n2, float[] fArray, int n3) {
        this.validate();
        this.getDirectFloatArray(this.pointer, n, n2, fArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectIntArray(int n, int n2, int[] nArray, int n3) {
        this.validate();
        this.getDirectIntArray(this.pointer, n, n2, nArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectLongArray(int n, int n2, long[] lArray, int n3) {
        this.validate();
        this.getDirectLongArray(this.pointer, n, n2, lArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectDoubleArray(int n, int n2, double[] dArray, int n3) {
        this.validate();
        this.getDirectDoubleArray(this.pointer, n, n2, dArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectCharArray(int n, int n2, char[] cArray, int n3) {
        this.validate();
        this.getDirectCharArray(this.pointer, n, n2, cArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void getDirectShortArray(int n, int n2, short[] sArray, int n3) {
        this.validate();
        this.getDirectShortArray(this.pointer, n, n2, sArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectFloatArray(int n, int n2, float[] fArray, int n3) {
        this.validate();
        this.putDirectFloatArray(this.pointer, n, n2, fArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectIntArray(int n, int n2, int[] nArray, int n3) {
        this.validate();
        this.putDirectIntArray(this.pointer, n, n2, nArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectLongArray(int n, int n2, long[] lArray, int n3) {
        this.validate();
        this.putDirectLongArray(this.pointer, n, n2, lArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectDoubleArray(int n, int n2, double[] dArray, int n3) {
        this.validate();
        this.putDirectDoubleArray(this.pointer, n, n2, dArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectCharArray(int n, int n2, char[] cArray, int n3) {
        this.validate();
        this.putDirectCharArray(this.pointer, n, n2, cArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    void putDirectShortArray(int n, int n2, short[] sArray, int n3) {
        this.validate();
        this.putDirectShortArray(this.pointer, n, n2, sArray, n3, this.order() != ByteOrder.NATIVE_ORDER);
    }

    private void validate() {
        if (!this.isDirect()) {
            return;
        }
        if (this.parent != null) {
            this.parent.validate();
        } else if (this.pointer == 0) {
            throw new InvalidDirectBufferException();
        }
    }
}

