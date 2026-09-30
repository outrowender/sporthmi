/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.buffer;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.exception.TransportException;

public class ReadableDumper {
    public static void dump(IReadable iReadable, int n) {
        System.out.println("Buffer: size=" + n);
        try {
            byte[] byArray = iReadable.getData();
            int n2 = 0;
            while (n2 < n) {
                int n3 = n - n2;
                if (n3 > 16) {
                    n3 = 16;
                }
                String string = "00000000" + Integer.toHexString(n2);
                int n4 = string.length();
                string = string.substring(n4 - 8, n4) + ": ";
                StringBuffer stringBuffer = new StringBuffer(string);
                for (int i2 = 0; i2 < n3; ++i2) {
                    String string2 = "00" + Integer.toHexString(byArray[n2]);
                    n4 = string2.length();
                    string2 = string2.substring(n4 - 2, n4);
                    stringBuffer.append(string2 + " ");
                    ++n2;
                }
                string = stringBuffer.toString();
                System.out.println(string);
            }
        }
        catch (TransportException transportException) {
            // empty catch block
        }
    }
}

