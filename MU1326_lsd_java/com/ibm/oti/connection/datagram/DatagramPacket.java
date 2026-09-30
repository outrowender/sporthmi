/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.datagram;

import com.ibm.oti.connection.socket.SocketHelper;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.microedition.io.Datagram;

public class DatagramPacket
implements Datagram {
    private java.net.DatagramPacket packet;
    private String address;
    private int pos;
    private boolean changeLength;

    String getHost() {
        return this.packet.getAddress().getHostName();
    }

    java.net.DatagramPacket getNetPacket() {
        return this.packet;
    }

    public String getAddress() {
        return this.address;
    }

    public byte[] getData() {
        return this.packet.getData();
    }

    public int getLength() {
        return this.packet.getLength();
    }

    public int getOffset() {
        return this.packet.getOffset();
    }

    public void reset() {
        this.packet.setData(this.packet.getData(), 0, 0);
        this.pos = 0;
        this.changeLength = true;
    }

    public void setAddress(Datagram datagram) {
        if (datagram == null) {
            throw new IllegalArgumentException();
        }
        String string = datagram.getAddress();
        if (string == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.setAddress(string);
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException(iOException.getMessage());
        }
    }

    public void setAddress(String string) throws IOException {
        if (string == null || !string.startsWith("datagram:")) {
            throw new IllegalArgumentException(Msg.getString("K00a0"));
        }
        String string2 = string.substring(9);
        if (!string2.startsWith("//")) {
            throw new IllegalArgumentException(Msg.getString("K00a1"));
        }
        int[] nArray = new int[1];
        String string3 = SocketHelper.parseURL(string2, nArray, true, false);
        this.packet.setPort(nArray[0]);
        try {
            this.packet.setAddress(InetAddress.getByName(string3));
        }
        catch (UnknownHostException unknownHostException) {
            throw new IOException(unknownHostException.getMessage());
        }
        this.address = string;
    }

    public void setData(byte[] byArray, int n, int n2) {
        if (byArray == null || n < 0 || n2 < 0 || byArray.length - n < n2) {
            throw new IllegalArgumentException();
        }
        if (this.packet == null) {
            this.packet = new java.net.DatagramPacket(byArray, n, n2);
        } else {
            this.packet.setData(byArray, n, n2);
        }
        this.pos = n;
        this.changeLength = false;
    }

    public void setLength(int n) {
        if (n < 0 || n > this.getData().length - this.getOffset()) {
            throw new IllegalArgumentException();
        }
        this.packet.setLength(n);
        this.changeLength = false;
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
            throw new IndexOutOfBoundsException();
        }
        if (this.changeLength ? n2 > this.getData().length - this.pos : n2 > this.getLength() - (this.pos - n)) {
            throw new EOFException();
        }
        byte[] byArray2 = this.packet.getData();
        System.arraycopy((Object)byArray, n, (Object)byArray2, this.pos, n2);
        this.pos += n2;
        if (this.changeLength) {
            this.packet.setLength(this.pos - this.packet.getOffset());
        }
    }

    public void write(int n) throws IOException {
        if (this.changeLength ? this.pos == this.getData().length : this.pos - this.getOffset() == this.getLength()) {
            throw new EOFException();
        }
        byte[] byArray = this.packet.getData();
        byArray[this.pos++] = (byte)n;
        if (this.changeLength) {
            this.packet.setLength(this.pos - this.packet.getOffset());
        }
    }

    public void writeBoolean(boolean bl) throws IOException {
        this.write(bl ? 1 : 0);
    }

    public void writeByte(int n) throws IOException {
        this.write(n);
    }

    public void writeChar(int n) throws IOException {
        this.write(n >> 8);
        this.write(n);
    }

    public void writeChars(String string) throws IOException {
        int n = 0;
        byte[] byArray = new byte[string.length() * 2];
        int n2 = 0;
        while (n2 < string.length()) {
            byArray[n++] = (byte)(string.charAt(n2) >> 8);
            byArray[n++] = (byte)string.charAt(n2);
            ++n2;
        }
        this.write(byArray);
    }

    public void writeInt(int n) throws IOException {
        this.write(n >> 24);
        this.write(n >> 16);
        this.write(n >> 8);
        this.write(n);
    }

    public void writeLong(long l) throws IOException {
        this.writeInt((int)(l >> 32));
        this.writeInt((int)l);
    }

    public void writeShort(int n) throws IOException {
        this.writeChar(n);
    }

    public final void writeUTF(String string) throws IOException {
        int n;
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        while (n4 < n3) {
            n = string.charAt(n4);
            n2 = n > 0 && n <= 127 ? ++n2 : (n <= 2047 ? (n2 += 2) : (n2 += 3));
            ++n4;
        }
        if (n2 > 65535) {
            throw new UTFDataFormatException(Msg.getString("K0068"));
        }
        byte[] byArray = new byte[n2];
        n = 0;
        int n5 = 0;
        while (n5 < n3) {
            char c2 = string.charAt(n5);
            if (c2 > '\u0000' && c2 <= '\u007f') {
                byArray[n++] = (byte)c2;
            } else if (c2 <= '\u07ff') {
                byArray[n++] = (byte)(0xC0 | 0x1F & c2 >> 6);
                byArray[n++] = (byte)(0x80 | 0x3F & c2);
            } else {
                byArray[n++] = (byte)(0xE0 | 0xF & c2 >> 12);
                byArray[n++] = (byte)(0x80 | 0x3F & c2 >> 6);
                byArray[n++] = (byte)(0x80 | 0x3F & c2);
            }
            ++n5;
        }
        this.writeShort(n2);
        if (n2 > 0) {
            this.write(byArray);
        }
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public boolean readBoolean() throws IOException {
        return this.readUnsignedByte() != 0;
    }

    public byte readByte() throws IOException {
        if (this.pos - this.getOffset() == this.getLength()) {
            throw new EOFException();
        }
        byte[] byArray = this.packet.getData();
        return byArray[this.pos++];
    }

    public char readChar() throws IOException {
        int n = this.readUnsignedByte();
        int n2 = this.readUnsignedByte();
        return (char)((n << 8) + n2);
    }

    public void readFully(byte[] byArray) throws IOException {
        this.readFully(byArray, 0, byArray.length);
    }

    public void readFully(byte[] byArray, int n, int n2) throws IOException {
        if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
            throw new IndexOutOfBoundsException();
        }
        if (n2 > this.getLength() - (this.pos - this.getOffset())) {
            throw new EOFException();
        }
        byte[] byArray2 = this.packet.getData();
        System.arraycopy((Object)byArray2, this.pos, (Object)byArray, n, n2);
        this.pos += n2;
    }

    public int readInt() throws IOException {
        int n = this.readUnsignedByte();
        int n2 = this.readUnsignedByte();
        int n3 = this.readUnsignedByte();
        int n4 = this.readUnsignedByte();
        return (n << 24) + (n2 << 16) + (n3 << 8) + n4;
    }

    public long readLong() throws IOException {
        int n = this.readInt();
        int n2 = this.readInt();
        return ((long)n << 32) + ((long)n2 & 0xFFFFFFFFL);
    }

    public short readShort() throws IOException {
        return (short)this.readUnsignedShort();
    }

    public final int readUnsignedByte() throws IOException {
        if (this.pos - this.getOffset() == this.getLength()) {
            throw new EOFException();
        }
        byte[] byArray = this.packet.getData();
        return byArray[this.pos++] & 0xFF;
    }

    public final int readUnsignedShort() throws IOException {
        int n = this.readUnsignedByte();
        int n2 = this.readUnsignedByte();
        return (n << 8) + n2;
    }

    public final String readUTF() throws IOException {
        int n = this.readUnsignedShort();
        byte[] byArray = new byte[n];
        this.readFully(byArray, 0, n);
        return Util.convertFromUTF8(byArray, 0, n);
    }

    public int skipBytes(int n) throws IOException {
        int n2 = this.getLength() - (this.pos - this.getOffset());
        if (n > n2) {
            n = n2;
        }
        this.pos += n;
        return n;
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    public final void writeFloat(float f2) throws IOException {
        this.writeInt(Float.floatToIntBits(f2));
    }

    public final void writeDouble(double d2) throws IOException {
        this.writeLong(Double.doubleToLongBits(d2));
    }

    public final void writeBytes(String string) throws IOException {
        int n = string.length();
        if (this.changeLength ? n > this.getData().length - this.pos : n > this.getLength() - (this.pos - this.getOffset())) {
            throw new EOFException();
        }
        byte[] byArray = this.packet.getData();
        int n2 = 0;
        while (n2 < n) {
            byArray[this.pos++] = (byte)string.charAt(n2);
            ++n2;
        }
        if (this.changeLength) {
            this.packet.setLength(this.pos - this.packet.getOffset());
        }
    }

    public final String readLine() throws IOException {
        StringBuffer stringBuffer = new StringBuffer(80);
        boolean bl = false;
        block5: while (true) {
            byte by = this.readByte();
            switch (by) {
                case -1: {
                    if (stringBuffer.length() == 0 && !bl) {
                        return null;
                    }
                    return stringBuffer.toString();
                }
                case 13: {
                    if (bl) {
                        --this.pos;
                        return stringBuffer.toString();
                    }
                    bl = true;
                    continue block5;
                }
                case 10: {
                    return stringBuffer.toString();
                }
            }
            if (bl) {
                --this.pos;
                return stringBuffer.toString();
            }
            stringBuffer.append((char)by);
        }
    }
}

