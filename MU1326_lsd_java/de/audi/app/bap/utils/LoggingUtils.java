/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

public class LoggingUtils {
    private static final String BAPSTACKSTATE_READY;
    private static final String BAPSTACKSTATE_NOT_READY;
    private static final String HMISTATE_NOT_READY;
    private static final String HMISTATE_READY_INITIALIZING;
    private static final String HMISTATE_READY_RUNNING;

    public static String getBAPStackStateDescription(int n) {
        switch (n) {
            case 1: {
                return "READY";
            }
            case 0: {
                return "NOT READY";
            }
        }
        return String.valueOf(n);
    }

    public static String getHMIStateDescription(int n) {
        switch (n) {
            case 0: {
                return "HMISTATE_NOT_READY";
            }
            case 1: {
                return "HMISTATE_READY_INITIALIZING";
            }
            case 2: {
                return "HMISTATE_READY_RUNNING";
            }
        }
        return String.valueOf(n);
    }

    public static String getInitStateDescription(int n) {
        switch (n) {
            case -1: {
                return "FAILED";
            }
            case 0: {
                return "WAITING_FOR_BAP_STACK";
            }
            case 1: {
                return "WAITING_FOR_APP_SERVICE";
            }
            case 2: {
                return "WAITING_FOR_HMI_STATE_INITIALIZING_ACKNOWLEDGE";
            }
            case 3: {
                return "WAITING_FOR_FCT_LIST_ACKNOWLEDGE";
            }
            case 4: {
                return "UPDATING_BAP_FUNCTIONS";
            }
            case 5: {
                return "WAITING_FOR_BAPCONFIG";
            }
            case 6: {
                return "WAITING_FOR_STATUSALL";
            }
            case 7: {
                return "WAITING_FOR_FCT_LIST_STATUS";
            }
            case 8: {
                return "UPDATE_PROPERTIES";
            }
            case 9: {
                return "INITIALIZED";
            }
            case 10: {
                return "WAITING_FOR_HMI_STATE_READY_ACKNOWLEDGE";
            }
            case 11: {
                return "COMPLETED";
            }
        }
        return String.valueOf(n);
    }
}

