/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.fw.request.IDataTypeMapping;

public final class DataTypeMappingENI
implements IDataTypeMapping {
    public int getRequestDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 13: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 17: {
                if (n2 != 0) break;
                n3 = 1;
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
            case 13: {
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 14: {
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 15: {
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 17: {
                if (n2 != 9) break;
                n3 = 1;
                break;
            }
            case 18: {
                if (n2 == 10) {
                    n3 = 0;
                }
                if (n2 != 11) break;
                n3 = 0;
                break;
            }
            case 23: {
                if (n2 != 9) break;
                n3 = 2;
                break;
            }
            default: {
                n3 = 3;
            }
        }
        return n3;
    }
}

