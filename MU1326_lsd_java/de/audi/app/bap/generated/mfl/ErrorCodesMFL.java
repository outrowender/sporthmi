/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.mfl;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.Buffer;

public final class ErrorCodesMFL
implements IErrorCodes {
    private static final String DESCRIPTION_NO_ERROR;
    private static final String DESCRIPTION_BCL_MEDIA_NOT_ACCESSIBLE;
    private static final String DESCRIPTION_BCL_ILLEGAL_SEQUENCE_SEGMENTATION;
    private static final String DESCRIPTION_BCL_SEQUENCE_ERROR_SEGMENTATION;
    private static final String DESCRIPTION_BCL_TIMEOUT_SEGMENTATION;
    private static final String DESCRIPTION_BCL_OVERSIZE_SEGMENTATION;
    private static final String DESCRIPTION_BCL_BAD_DATA_LENGTH;
    private static final String DESCRIPTION_BCL_RECEIVED_DATA_LOST;
    private static final String DESCRIPTION_BPL_HEARTBEAT_TIMEOUT;
    private static final String DESCRIPTION_BPL_RETRY_TIMEOUT;
    private static final String DESCRIPTION_BPL_BUSY;
    private static final String DESCRIPTION_BPL_REQUEST_TIMEOUT;
    private static final String DESCRIPTION_BAL_WRONG_ADDRESSING;
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_PROTOCOL_VERSION;
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION;
    private static final String DESCRIPTION_BAL_DATA_INVALID;
    private static final String DESCRIPTION_BAL_INVALID_STATE;
    private static final String DESCRIPTION_BAL_CACHE_NOT_AVAILABLE;
    private static final String DESCRIPTION_BAL_INVALID_ARGUMENT;
    private static final String DESCRIPTION_APPL_OUT_OF_RANGE;
    private static final String DESCRIPTION_APPL_TEMPORARY_NOT_AVAILABLE;
    private static final String DESCRIPTION_APPL_MAX_DATA_LENGTH_EXCEEDED;
    private static final String DESCRIPTION_APPL_UNIT_MISMATCH;
    private static final String ERROR_ID_UNKNOWN;

    @Override
    public String getDescription(int n) {
        switch (n) {
            case 0: {
                return "0x0 (NO_ERROR)";
            }
            case 17: {
                return "0x11 (BCL_MEDIA_NOT_ACCESSIBLE)";
            }
            case 18: {
                return "0x12 (BCL_ILLEGAL_SEQUENCE_SEGMENTATION)";
            }
            case 19: {
                return "0x13 (BCL_SEQUENCE_ERROR_SEGMENTATION)";
            }
            case 20: {
                return "0x14 (BCL_TIMEOUT_SEGMENTATION)";
            }
            case 21: {
                return "0x15 (BCL_OVERSIZE_SEGMENTATION)";
            }
            case 22: {
                return "0x16 (BCL_BAD_DATA_LENGTH)";
            }
            case 23: {
                return "0x17 (BCL_RECEIVED_DATA_LOST)";
            }
            case 33: {
                return "0x21 (BPL_HEARTBEAT_TIMEOUT)";
            }
            case 34: {
                return "0x22 (BPL_RETRY_TIMEOUT)";
            }
            case 35: {
                return "0x23 (BPL_BUSY)";
            }
            case 36: {
                return "0x24 (BPL_REQUEST_TIMEOUT)";
            }
            case 49: {
                return "0x31 (BAL_WRONG_ADDRESSING)";
            }
            case 50: {
                return "0x32 (BAL_INCOMPATIBLE_PROTOCOL_VERSION)";
            }
            case 51: {
                return "0x33 (BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION)";
            }
            case 52: {
                return "0x34 (BAL_DATA_INVALID)";
            }
            case 53: {
                return "0x35 (BAL_INVALID_STATE)";
            }
            case 54: {
                return "0x36 (BAL_CACHE_NOT_AVAILABLE)";
            }
            case 55: {
                return "0x37 (BAL_INVALID_ARGUMENT)";
            }
            case 65: {
                return "0x41 (APPL_OUT_OF_RANGE)";
            }
            case 66: {
                return "0x42 (APPL_TEMPORARY_NOT_AVAILABLE)";
            }
            case 67: {
                return "0x43 (APPL_MAX_DATA_LENGTH_EXCEEDED)";
            }
            case 68: {
                return "0x44 (APPL_UNIT_MISMATCH)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

