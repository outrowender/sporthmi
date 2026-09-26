/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.tuner.app.Utilities;

class SearchUtil {
    SearchUtil() {
    }

    static int getSourceByBand(int n) {
        switch (n) {
            case 4: {
                return 17;
            }
            case 1: {
                return 23;
            }
            case 10: 
            case 11: {
                return 24;
            }
            case 5: {
                return 25;
            }
            case 7: {
                return 26;
            }
            case 13: {
                return 10017;
            }
            case 12: {
                return 20017;
            }
        }
        throw new IllegalArgumentException();
    }

    static int getBandBySource(int n) {
        switch (n) {
            case 17: {
                return 4;
            }
            case 23: {
                return 1;
            }
            case 24: {
                if (Utilities.isJapan()) {
                    return 10;
                }
                return 11;
            }
            case 25: {
                return 5;
            }
            case 26: {
                return 7;
            }
            case 10017: {
                return 13;
            }
            case 20017: {
                return 12;
            }
        }
        throw new IllegalArgumentException();
    }
}

