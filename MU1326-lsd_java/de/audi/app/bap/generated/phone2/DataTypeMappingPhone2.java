/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.fw.request.IDataTypeMapping;

public final class DataTypeMappingPhone2
implements IDataTypeMapping {
    @Override
    public int getRequestDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 15: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 18: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 20: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 25: {
                if (n2 != 7) break;
                n3 = 1;
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
            default: 
        }
        n3 = 3;
        return n3;
    }
}

