/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import java.util.ArrayList;

public class InterappKeyPanelHandler {
    static short mapToDSI(byte by) {
        switch (by) {
            case 3: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
            case 27: {
                return 5;
            }
            case 4: {
                return 6;
            }
            case 5: {
                return 7;
            }
            case 28: {
                return 8;
            }
            case 29: {
                return 9;
            }
            case 30: {
                return 10;
            }
            case 31: {
                return 11;
            }
            case 6: {
                return 12;
            }
            case 7: {
                return 13;
            }
            case 8: {
                return 14;
            }
            case 9: {
                return 15;
            }
            case 32: {
                return 16;
            }
            case 33: {
                return 17;
            }
            case 34: {
                return 18;
            }
            case 35: {
                return 19;
            }
            case 10: {
                return 20;
            }
            case 11: {
                return 21;
            }
            case 12: {
                return 22;
            }
            case 13: {
                return 23;
            }
            case 14: {
                return 24;
            }
            case 15: {
                return 25;
            }
            case 16: {
                return 26;
            }
            case 17: {
                return 27;
            }
            case 18: {
                return 28;
            }
            case 19: {
                return 29;
            }
            case 36: {
                return 30;
            }
            case 37: {
                return 31;
            }
            case 20: {
                return 32;
            }
            case 21: {
                return 33;
            }
            case 38: {
                return 34;
            }
            case 39: {
                return 35;
            }
            case 40: {
                return 36;
            }
            case 41: {
                return 37;
            }
            case 22: {
                return 38;
            }
            case 42: {
                return 39;
            }
            case 23: {
                return 40;
            }
            case 24: {
                return 41;
            }
            case 25: {
                return 42;
            }
            case 26: {
                return 43;
            }
            case 43: {
                return 44;
            }
            case 44: {
                return 45;
            }
            case 45: {
                return 46;
            }
            case 46: {
                return 47;
            }
            case 47: {
                return 48;
            }
            case 48: {
                return 49;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown SDIS keypanel ID: ").append(by).toString());
    }

    static byte mapToSDIS(short s) {
        switch (s) {
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 0;
            }
            case 5: {
                return 27;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
            case 8: {
                return 28;
            }
            case 9: {
                return 29;
            }
            case 10: {
                return 30;
            }
            case 11: {
                return 31;
            }
            case 12: {
                return 6;
            }
            case 13: {
                return 7;
            }
            case 14: {
                return 8;
            }
            case 15: {
                return 9;
            }
            case 16: {
                return 32;
            }
            case 17: {
                return 33;
            }
            case 18: {
                return 34;
            }
            case 19: {
                return 35;
            }
            case 20: {
                return 10;
            }
            case 21: {
                return 11;
            }
            case 22: {
                return 12;
            }
            case 23: {
                return 13;
            }
            case 24: {
                return 14;
            }
            case 25: {
                return 15;
            }
            case 26: {
                return 16;
            }
            case 27: {
                return 17;
            }
            case 28: {
                return 18;
            }
            case 29: {
                return 19;
            }
            case 30: {
                return 36;
            }
            case 31: {
                return 37;
            }
            case 32: {
                return 20;
            }
            case 33: {
                return 21;
            }
            case 34: {
                return 38;
            }
            case 35: {
                return 39;
            }
            case 36: {
                return 40;
            }
            case 37: {
                return 41;
            }
            case 38: {
                return 22;
            }
            case 39: {
                return 42;
            }
            case 40: {
                return 23;
            }
            case 41: {
                return 24;
            }
            case 42: {
                return 25;
            }
            case 43: {
                return 26;
            }
            case 44: {
                return 43;
            }
            case 45: {
                return 44;
            }
            case 46: {
                return 45;
            }
            case 47: {
                return 46;
            }
            case 48: {
                return 47;
            }
            case 49: {
                return 48;
            }
        }
        return -1;
    }

    static KeySet createKeySet(short s, short[] sArray) {
        ArrayList arrayList = new ArrayList(sArray.length);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            byte by = InterappKeyPanelHandler.mapToSDIS(sArray[i2]);
            if (by < 0) continue;
            arrayList.add(new Byte(by));
        }
        byte[] byArray = new byte[arrayList.size()];
        for (int i3 = 0; i3 < byArray.length; ++i3) {
            byArray[i3] = (Byte)arrayList.get(i3);
        }
        return new KeySet(InterappKeyPanelHandler.getSdisTerminalID(s), byArray);
    }

    private static byte getSdisTerminalID(short s) {
        switch (s) {
            case 0: {
                return 2;
            }
            case 1: {
                return 4;
            }
            case 2: {
                return 6;
            }
            case 3: {
                return 7;
            }
            case 4: {
                return 8;
            }
            case 5: {
                return 9;
            }
            case 6: {
                return 10;
            }
            case 7: {
                return 11;
            }
            case 8: {
                return 12;
            }
            case 9: {
                return 13;
            }
            case 10: {
                return 14;
            }
            case 11: {
                return 15;
            }
            case 12: {
                return 16;
            }
            case 13: {
                return 3;
            }
            case 14: {
                return 17;
            }
            case 15: {
                return 18;
            }
        }
        return 127;
    }
}

