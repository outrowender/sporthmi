/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketImpl;

class SocketOutputStream
extends OutputStream {
    SocketImpl socket;

    public SocketOutputStream(SocketImpl socketImpl) {
        this.socket = socketImpl;
    }

    public void close() throws IOException {
        this.socket.close();
        super.close();
    }

    public void write(byte[] byArray) throws IOException {
        this.socket.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (byArray != null) {
            if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) {
                throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
            }
        } else {
            throw new NullPointerException(Msg.getString("K0047"));
        }
        this.socket.write(byArray, n, n2);
    }

    public void write(int n) throws IOException {
        byte[] byArray = new byte[]{(byte)(n & 0xFF)};
        this.socket.write(byArray, 0, 1);
    }
}

