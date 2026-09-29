/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.util.Enum;

public class SmartphoneIntegrationDSILifecycleController$ErrorCode
extends Enum {
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_UNKNOWN = new SmartphoneIntegrationDSILifecycleController$ErrorCode(0, "ERRORCODE_UNKNOWN");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_CODING = new SmartphoneIntegrationDSILifecycleController$ErrorCode(1, "ERRORCODE_CODING");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_SWAP = new SmartphoneIntegrationDSILifecycleController$ErrorCode(2, "ERRORCODE_SWAP");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_USBSTACK = new SmartphoneIntegrationDSILifecycleController$ErrorCode(3, "ERRORCODE_USBSTACK");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_DEVICE = new SmartphoneIntegrationDSILifecycleController$ErrorCode(4, "ERRORCODE_DEVICE");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_APP = new SmartphoneIntegrationDSILifecycleController$ErrorCode(5, "ERRORCODE_APP");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_BUSY = new SmartphoneIntegrationDSILifecycleController$ErrorCode(6, "ERRORCODE_BUSY");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_STATE = new SmartphoneIntegrationDSILifecycleController$ErrorCode(7, "ERRORCODE_STATE");
    public static final SmartphoneIntegrationDSILifecycleController$ErrorCode ERRORCODE_LAUNCH = new SmartphoneIntegrationDSILifecycleController$ErrorCode(8, "ERRORCODE_LAUNCH");

    private SmartphoneIntegrationDSILifecycleController$ErrorCode(int n, String string) {
        super(n, string);
    }

    public static SmartphoneIntegrationDSILifecycleController$ErrorCode valueOf(int n) {
        switch (n) {
            case 1: {
                return ERRORCODE_CODING;
            }
            case 2: {
                return ERRORCODE_SWAP;
            }
            case 3: {
                return ERRORCODE_USBSTACK;
            }
            case 4: {
                return ERRORCODE_DEVICE;
            }
            case 5: {
                return ERRORCODE_APP;
            }
            case 6: {
                return ERRORCODE_BUSY;
            }
            case 7: {
                return ERRORCODE_STATE;
            }
            case 8: {
                return ERRORCODE_LAUNCH;
            }
        }
        return ERRORCODE_UNKNOWN;
    }
}

