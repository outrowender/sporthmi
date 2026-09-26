/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

public final class BAPPropertyRegisterStateUtil {
    public static final int PACKET_DATA_NETWORK_TYPE;

    public static int getCombiRegisterState(int n) {
        switch (n) {
            case 5: {
                return 3;
            }
            case 0: 
            case 4: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 2;
            }
        }
        return 255;
    }

    public static int getCombiDataNetworkType(int n) {
        switch (n) {
            case 2: {
                return 5;
            }
            case 1: {
                return 2;
            }
            case 5: {
                return 6;
            }
            case 3: {
                return 4;
            }
        }
        return 255;
    }

    public static int getCombiNetworkType(int n) {
        switch (n) {
            case 2: {
                return 3;
            }
            case 1: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 4;
            }
        }
        return 0;
    }
}

