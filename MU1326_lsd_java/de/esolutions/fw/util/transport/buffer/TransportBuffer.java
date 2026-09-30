/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.buffer;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.WriteableWindow;
import de.esolutions.fw.util.transport.buffer.TransportSubBuffer;
import de.esolutions.fw.util.transport.exception.TransportBufferException;

public class TransportBuffer
implements Cloneable,
IReadable,
IWriteable {
    protected int size;
    protected byte[] data;
    protected WriteableWindow window;
    private Object debugTag;

    public TransportBuffer(int n) {
        this.size = n;
        this.data = new byte[n];
        this.window = new WriteableWindow(0, n);
    }

    public TransportBuffer(byte[] byArray) {
        this.size = byArray.length;
        this.data = byArray;
        this.window = new WriteableWindow(0, this.size);
    }

    public Object clone() {
        try {
            TransportBuffer transportBuffer = (TransportBuffer)super.clone();
            transportBuffer.data = new byte[this.data.length];
            System.arraycopy((Object)this.data, 0, (Object)transportBuffer.data, 0, this.data.length);
            return transportBuffer;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public int size() {
        return this.window.getSize();
    }

    public byte[] data() {
        return this.data;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getData(int n, int n2) throws TransportBufferException {
        if (n + n2 > this.size) {
            throw new TransportBufferException("getData out of range: data=(@" + n + "," + n2 + ") size=" + this.size);
        }
        byte[] byArray = new byte[n2];
        System.arraycopy((Object)this.data, n, (Object)byArray, 0, n2);
        return byArray;
    }

    public byte[] getDirectData() {
        return this.data;
    }

    public int getDirectOffset() {
        return this.window.getOffset();
    }

    public IReadable createSubBuffer(int n, int n2) throws TransportBufferException {
        if (n + n2 > this.size()) {
            throw new TransportBufferException("Invalid window for sub buffer: new=(@" + n + "," + n2 + ") size=" + this.size());
        }
        return new TransportSubBuffer(this, n, n2);
    }

    public void setData(byte[] byArray) throws TransportBufferException {
        int n = this.window.getSize();
        if (byArray.length != n) {
            throw new TransportBufferException("Invalid data size: expected=" + n + " found: " + byArray.length);
        }
        if (this.size == n) {
            this.data = byArray;
        } else {
            System.arraycopy((Object)byArray, 0, (Object)this.data, this.window.getOffset(), n);
        }
    }

    public void setData(int n, byte[] byArray) throws TransportBufferException {
        int n2 = this.window.getSize();
        int n3 = this.window.getOffset();
        int n4 = byArray.length;
        if (n4 + n > n2) {
            throw new TransportBufferException("Data out of window");
        }
        System.arraycopy((Object)byArray, 0, (Object)this.data, n3 + n, n4);
    }

    public void setData(int n, byte[] byArray, int n2) throws TransportBufferException {
        int n3 = this.window.getSize();
        int n4 = this.window.getOffset();
        if (n2 + n > n3) {
            throw new TransportBufferException("Data out of window");
        }
        System.arraycopy((Object)byArray, 0, (Object)this.data, n4 + n, n2);
    }

    public WriteableWindow setWindow(WriteableWindow writeableWindow) throws TransportBufferException {
        if (!writeableWindow.isInside(this.size)) {
            throw new TransportBufferException("Invalid window (" + writeableWindow.getOffset() + "," + writeableWindow.getSize() + ") current (" + this.window.getOffset() + "," + this.window.getSize() + ")");
        }
        WriteableWindow writeableWindow2 = this.window;
        this.window = writeableWindow;
        return writeableWindow2;
    }

    public WriteableWindow setLocalWindow(int n, int n2) throws TransportBufferException {
        WriteableWindow writeableWindow = new WriteableWindow(this.window.getOffset() + n, n2);
        if (!writeableWindow.isInside(this.size)) {
            throw new TransportBufferException("Invalid window (" + writeableWindow.getOffset() + "," + writeableWindow.getSize() + ") current (" + this.window.getOffset() + "," + this.window.getSize() + ")");
        }
        WriteableWindow writeableWindow2 = this.window;
        this.window = writeableWindow;
        return writeableWindow2;
    }

    public void resetWindow() {
        this.window = new WriteableWindow(0, this.data.length);
    }

    public void setDebugTag(Object object) {
        this.debugTag = object;
    }

    public Object getDebugTag() {
        return this.debugTag;
    }
}

