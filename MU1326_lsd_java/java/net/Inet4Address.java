/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.ObjectStreamException;
import java.net.InetAddress;

public final class Inet4Address
extends InetAddress {
    private static final long serialVersionUID = 3286316764910316507L;

    Inet4Address(byte[] byArray) {
        this.ipaddress = byArray;
    }

    Inet4Address(byte[] byArray, String string) {
        this.ipaddress = byArray;
        this.hostName = string;
    }

    public boolean isMulticastAddress() {
        return (this.ipaddress[0] & 0xF0) == 224;
    }

    public boolean isAnyLocalAddress() {
        int n = 0;
        while (n < this.ipaddress.length) {
            if (this.ipaddress[n] != 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public boolean isLoopbackAddress() {
        return (this.ipaddress[0] & 0xFF) == 127;
    }

    public boolean isLinkLocalAddress() {
        return (this.ipaddress[0] & 0xFF) == 169 && (this.ipaddress[1] & 0xFF) == 254;
    }

    public boolean isSiteLocalAddress() {
        return (this.ipaddress[0] & 0xFF) == 10 || (this.ipaddress[0] & 0xFF) == 172 && (this.ipaddress[1] & 0xFF) > 15 && (this.ipaddress[1] & 0xFF) < 32 || (this.ipaddress[0] & 0xFF) == 192 && (this.ipaddress[1] & 0xFF) == 168;
    }

    public boolean isMCGlobal() {
        if (!this.isMulticastAddress()) {
            return false;
        }
        int n = InetAddress.bytesToInt(this.ipaddress, 0);
        if (n >>> 8 < 0xE00001) {
            return false;
        }
        return n >>> 24 <= 238;
    }

    public boolean isMCNodeLocal() {
        return false;
    }

    public boolean isMCLinkLocal() {
        return InetAddress.bytesToInt(this.ipaddress, 0) >>> 8 == 0xE00000;
    }

    public boolean isMCSiteLocal() {
        return InetAddress.bytesToInt(this.ipaddress, 0) >>> 16 == 61439;
    }

    public boolean isMCOrgLocal() {
        int n = InetAddress.bytesToInt(this.ipaddress, 0) >>> 16;
        return n >= 61376 && n <= 61379;
    }

    public String getHostAddress() {
        String string = "";
        int n = 0;
        while (n < 4) {
            string = String.valueOf(string) + (this.ipaddress[n] & 0xFF);
            if (n != 3) {
                string = String.valueOf(string) + ".";
            }
            ++n;
        }
        return string;
    }

    public int hashCode() {
        return InetAddress.bytesToInt(this.ipaddress, 0);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new InetAddress(this.ipaddress, this.hostName);
    }
}

