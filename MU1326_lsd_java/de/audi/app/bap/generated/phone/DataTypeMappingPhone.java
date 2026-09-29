/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone;

import de.audi.app.bap.fw.request.IDataTypeMapping;

public final class DataTypeMappingPhone
implements IDataTypeMapping {
    @Override
    public int getRequestDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 19: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 21: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 25: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 26: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 27: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 28: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 29: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 30: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 31: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 32: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 33: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 34: {
                if (n2 != 7) break;
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
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 37: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 38: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 39: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 40: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 41: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 42: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 50: {
                if (n2 == 8) {
                    n3 = 0;
                }
                if (n2 != 9) break;
                n3 = 0;
                break;
            }
            case 56: {
                if (n2 != 7) break;
                n3 = 0;
                break;
            }
            case 57: {
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

    @Override
    public int getIndicationDataType(int n, int n2) {
        int n3 = 3;
        switch (n) {
            case 27: {
                if (n2 != 4) break;
                n3 = 0;
                break;
            }
            case 28: {
                if (n2 != 4) break;
                n3 = 0;
                break;
            }
            case 29: {
                if (n2 != 4) break;
                n3 = 0;
                break;
            }
            case 33: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 34: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 41: {
                if (n2 != 4) break;
                n3 = 0;
                break;
            }
            case 50: {
                if (n2 != 4) break;
                n3 = 0;
                break;
            }
            case 56: {
                if (n2 != 0) break;
                n3 = 0;
                break;
            }
            case 57: {
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

