/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public final class ErrorCodes {
    private static final SimpleIntObjectMap ERROR_CODES = new SimpleIntObjectMap();

    public static String getDescription(int n, int n2) {
        IErrorCodes iErrorCodes = (IErrorCodes)ERROR_CODES.get(n);
        if (iErrorCodes == null) {
            return String.valueOf(n2);
        }
        return iErrorCodes.getDescription(n2);
    }

    public static void registerErrorCodes(int n, IErrorCodes iErrorCodes) {
        ERROR_CODES.add(n, iErrorCodes);
    }

    public static String getDescription(int n) {
        switch (n) {
            case 17: {
                return "(ERRORCODE_TRANSPORTMEDIANOTACCESSIBLE)";
            }
            case 18: {
                return "(ERRORCODE_ILLEGALSEQUENCE)";
            }
            case 19: {
                return "(ERRORCODE_SEQUENCENUMBER)";
            }
            case 20: {
                return "(ERRORCODE_TIMEOUTSEGMENTATION)";
            }
            case 21: {
                return "(ERRORCODE_OVERSIZESEGMENTATION)";
            }
            case 22: {
                return "(ERRORCODE_BADDATALENGTH)";
            }
            case 23: {
                return "(ERRORCODE_RECEIVEDDATALOST)";
            }
            case 33: {
                return "(ERRORCODE_HEARTBEATTIMEOUT)";
            }
            case 34: {
                return "(ERRORCODE_RETRYNOTSUCCESSFUL)";
            }
            case 35: {
                return "(ERRORCODE_BUSY)";
            }
            case 36: {
                return "(ERRORCODE_REQUESTTIMEOUT)";
            }
            case 50: {
                return "(ERRORCODE_INCOMPATIBLEPROTOCOLVERSION)";
            }
            case 51: {
                return "(ERRORCODE_INCOMPATIBLEDATASPECIFICATION)";
            }
            case 52: {
                return "(ERRORCODE_CACHEINVALID_SENDBUFFERNOTINITIALIZED_GETALLMESSAGECORRUPTED)";
            }
            case 53: {
                return "(ERRORCODE_INVALIDSTATE)";
            }
            case 54: {
                return "(ERRORCODE_CACHENOTAVAILABLE)";
            }
            case 55: {
                return "(ERRORCODE_INVALIDARG)";
            }
            case 65: {
                return "(ERRORCODE_OUTOFRANGE)";
            }
            case 66: {
                return "(ERRORCODE_NOTIMPLEMENTED_TEMPORARYNOTAVAILABLE)";
            }
            case 67: {
                return "(ERRORCODE_MAXDATALENGTHEXCEEDED)";
            }
            case 68: {
                return "(ERRORCODE_UNITMISMATCH)";
            }
            case 80: {
                return "(ERRORCODE_METHODABORTED)";
            }
        }
        return "(UNKNOWN)";
    }
}

