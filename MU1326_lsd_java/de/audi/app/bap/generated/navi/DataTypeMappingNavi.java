/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.navi;

import de.audi.app.bap.fw.request.IDataTypeMapping;

public final class DataTypeMappingNavi
implements IDataTypeMapping {
    public int getRequestDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 15: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 17: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 26: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 27: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 31: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 34: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 35: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 36: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 38: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 39: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 40: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 54: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            default: {
                n3 = 3;
            }
        }
        return n3;
    }

    public int getIndicationDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 26: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 27: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 36: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 39: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 54: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            default: {
                n3 = 3;
            }
        }
        return n3;
    }
}

