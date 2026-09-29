/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap;

import de.audi.app.addressbook.core.common.ADBModelUtils;

public class CombiADBUtils {
    public static int getCombiStorageType(int n) {
        switch (n) {
            case 0: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 4: {
                return 3;
            }
        }
        return 0;
    }

    public static int getCombiPhoneType(int n) {
        switch (ADBModelUtils.getIconTypeForPhoneNumber(n)) {
            case 4: {
                return 12;
            }
            case 5: {
                return 11;
            }
            case 3: {
                return 2;
            }
            case 1: {
                return 10;
            }
            case 2: {
                return 9;
            }
            case 0: {
                return 1;
            }
            case 7: {
                return 14;
            }
            case 8: {
                return 13;
            }
            case 6: {
                return 5;
            }
            case 10: {
                return 4;
            }
            case 11: {
                return 3;
            }
        }
        return 0;
    }
}

