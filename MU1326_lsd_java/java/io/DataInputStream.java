/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.DataInput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class DataInputStream
extends FilterInputStream
implements DataInput {
    static final int MAX_BUF_SIZE = 8192;
    private static final boolean useNative = VM.useNatives();
    static boolean useShared = true;
    static byte[] byteBuf = new byte[0];
    static char[] charBuf = new char[0];
    static /* synthetic */ Class class$0;

    public DataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] byArray) throws IOException {
        return this.in.read(byArray, 0, byArray.length);
    }

    public final int read(byte[] byArray, int n, int n2) throws IOException {
        return this.in.read(byArray, n, n2);
    }

    public final boolean readBoolean() throws IOException {
        int n = this.in.read();
        if (n >= 0) {
            return n != 0;
        }
        throw new EOFException();
    }

    public final byte readByte() throws IOException {
        int n = this.in.read();
        if (n >= 0) {
            return (byte)n;
        }
        throw new EOFException();
    }

    public final char readChar() throws IOException {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (char)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    public final void readFully(byte[] byArray) throws IOException {
        this.readFully(byArray, 0, byArray.length);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void readFully(byte[] byArray, int n, int n2) throws IOException {
        if (byArray == null) throw new NullPointerException(Msg.getString("K0047"));
        if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) throw new IndexOutOfBoundsException();
        while (n2 > 0) {
            int n3 = this.in.read(byArray, n, n2);
            if (n3 < 0) throw new EOFException();
            n += n3;
            n2 -= n3;
        }
    }

    public final int readInt() throws IOException {
        int n;
        int n2;
        int n3;
        int n4 = this.in.read();
        if ((n4 | (n3 = this.in.read()) | (n2 = this.in.read()) | (n = this.in.read())) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }

    public final String readLine() throws IOException {
        StringBuffer stringBuffer = new StringBuffer(80);
        boolean bl = false;
        block7: while (true) {
            int n = this.in.read();
            switch (n) {
                case -1: {
                    if (stringBuffer.length() == 0 && !bl) {
                        return null;
                    }
                    return stringBuffer.toString();
                }
                case 13: {
                    if (bl) {
                        ((PushbackInputStream)this.in).unread(n);
                        return stringBuffer.toString();
                    }
                    bl = true;
                    Class clazz = this.in.getClass();
                    Class clazz2 = class$0;
                    if (clazz2 == null) {
                        try {
                            clazz2 = Class.forName("java.io.PushbackInputStream");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    if (clazz == clazz2) continue block7;
                    this.in = new PushbackInputStream(this.in);
                    continue block7;
                }
                case 10: {
                    return stringBuffer.toString();
                }
            }
            if (bl) {
                ((PushbackInputStream)this.in).unread(n);
                return stringBuffer.toString();
            }
            stringBuffer.append((char)n);
        }
    }

    public final long readLong() throws IOException {
        int n;
        int n2;
        int n3;
        int n4 = this.readInt();
        int n5 = this.in.read();
        if ((n5 | (n3 = this.in.read()) | (n2 = this.in.read()) | (n = this.in.read())) >= 0) {
            return ((long)n4 << 32) + ((long)n5 << 24) + (long)(n3 << 16) + (long)(n2 << 8) + (long)n;
        }
        throw new EOFException();
    }

    public final short readShort() throws IOException {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (short)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    public final int readUnsignedByte() throws IOException {
        int n = this.in.read();
        if (n >= 0) {
            return n;
        }
        throw new EOFException();
    }

    public final int readUnsignedShort() throws IOException {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (n2 << 8) + n;
        }
        throw new EOFException();
    }

    public final String readUTF() throws IOException {
        int n = this.readUnsignedShort();
        return this.decodeUTF(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    String decodeUTF(int n) throws IOException {
        byte[] byArray;
        Object object;
        char[] cArray = null;
        boolean bl = true;
        if (n <= 8192 && useShared) {
            object = byteBuf;
            // MONITORENTER : byteBuf
            if (useShared) {
                useShared = false;
                bl = false;
            }
            // MONITOREXIT : object
        }
        if (bl) {
            byArray = new byte[n];
            if (!useNative) {
                cArray = new char[n];
            }
        } else {
            if (byteBuf.length < n) {
                byteBuf = new byte[n];
            }
            if (!useNative && charBuf.length < n) {
                charBuf = new char[n];
            }
            byArray = byteBuf;
            cArray = charBuf;
        }
        this.readFully(byArray, 0, n);
        object = useNative ? (Object)Util.convertFromUTF8(byArray, 0, n) : (Object)Util.convertUTF8WithBuf(byArray, cArray, 0, n);
        if (bl) return object;
        useShared = true;
        return object;
    }

    public static final String readUTF(DataInput dataInput) throws IOException {
        return dataInput.readUTF();
    }

    public final int skipBytes(int n) throws IOException {
        long l;
        int n2 = 0;
        while (n2 < n && (l = this.in.skip(n - n2)) != 0L) {
            n2 = (int)((long)n2 + l);
        }
        if (n2 >= 0) {
            return n2;
        }
        throw new EOFException();
    }
}

