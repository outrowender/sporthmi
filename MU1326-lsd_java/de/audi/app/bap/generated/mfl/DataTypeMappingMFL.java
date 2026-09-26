/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.mfl;

import de.audi.app.bap.fw.request.IDataTypeMapping;

public final class DataTypeMappingMFL
implements IDataTypeMapping {
    @Override
    public int getRequestDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 14: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 15: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 16: {
                if (n2 != 7) break;
                n3 = 1;
                break;
            }
            case 20: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            default: {
                n3 = 3;
            }
        }
        return n3;
    }

    @Override
    public int getIndicationDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 16: {
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
}

