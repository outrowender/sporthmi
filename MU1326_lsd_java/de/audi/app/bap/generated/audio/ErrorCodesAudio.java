/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.audio;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.Buffer;

public final class ErrorCodesAudio
implements IErrorCodes {
    private static final String DESCRIPTION_NO_ERROR = "0x0 (NO_ERROR)";
    private static final String DESCRIPTION_BCL_MEDIA_NOT_ACCESSIBLE = "0x11 (BCL_MEDIA_NOT_ACCESSIBLE)";
    private static final String DESCRIPTION_BCL_ILLEGAL_SEQUENCE_SEGMENTATION = "0x12 (BCL_ILLEGAL_SEQUENCE_SEGMENTATION)";
    private static final String DESCRIPTION_BCL_SEQUENCE_ERROR_SEGMENTATION = "0x13 (BCL_SEQUENCE_ERROR_SEGMENTATION)";
    private static final String DESCRIPTION_BCL_TIMEOUT_SEGMENTATION = "0x14 (BCL_TIMEOUT_SEGMENTATION)";
    private static final String DESCRIPTION_BCL_OVERSIZE_SEGMENTATION = "0x15 (BCL_OVERSIZE_SEGMENTATION)";
    private static final String DESCRIPTION_BCL_BAD_DATA_LENGTH = "0x16 (BCL_BAD_DATA_LENGTH)";
    private static final String DESCRIPTION_BCL_RECEIVED_DATA_LOST = "0x17 (BCL_RECEIVED_DATA_LOST)";
    private static final String DESCRIPTION_BPL_HEARTBEAT_TIMEOUT = "0x21 (BPL_HEARTBEAT_TIMEOUT)";
    private static final String DESCRIPTION_BPL_RETRY_TIMEOUT = "0x22 (BPL_RETRY_TIMEOUT)";
    private static final String DESCRIPTION_BPL_BUSY = "0x23 (BPL_BUSY)";
    private static final String DESCRIPTION_BPL_REQUEST_TIMEOUT = "0x24 (BPL_REQUEST_TIMEOUT)";
    private static final String DESCRIPTION_BAL_WRONG_ADDRESSING = "0x31 (BAL_WRONG_ADDRESSING)";
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_PROTOCOL_VERSION = "0x32 (BAL_INCOMPATIBLE_PROTOCOL_VERSION)";
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION = "0x33 (BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION)";
    private static final String DESCRIPTION_BAL_DATA_INVALID = "0x34 (BAL_DATA_INVALID)";
    private static final String DESCRIPTION_BAL_INVALID_STATE = "0x35 (BAL_INVALID_STATE)";
    private static final String DESCRIPTION_BAL_CACHE_NOT_AVAILABLE = "0x36 (BAL_CACHE_NOT_AVAILABLE)";
    private static final String DESCRIPTION_BAL_INVALID_ARGUMENT = "0x37 (BAL_INVALID_ARGUMENT)";
    private static final String DESCRIPTION_APPL_OUT_OF_RANGE = "0x41 (APPL_OUT_OF_RANGE)";
    private static final String DESCRIPTION_APPL_TEMPORARY_NOT_AVAILABLE = "0x42 (APPL_TEMPORARY_NOT_AVAILABLE)";
    private static final String DESCRIPTION_APPL_MAX_DATA_LENGTH_EXCEEDED = "0x43 (APPL_MAX_DATA_LENGTH_EXCEEDED)";
    private static final String DESCRIPTION_APPL_UNIT_MISMATCH = "0x44 (APPL_UNIT_MISMATCH)";
    private static final String DESCRIPTION_METHOD_ABORTED = "0x50 (METHOD_ABORTED)";
    private static final String ERROR_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 0: {
                return DESCRIPTION_NO_ERROR;
            }
            case 17: {
                return DESCRIPTION_BCL_MEDIA_NOT_ACCESSIBLE;
            }
            case 18: {
                return DESCRIPTION_BCL_ILLEGAL_SEQUENCE_SEGMENTATION;
            }
            case 19: {
                return DESCRIPTION_BCL_SEQUENCE_ERROR_SEGMENTATION;
            }
            case 20: {
                return DESCRIPTION_BCL_TIMEOUT_SEGMENTATION;
            }
            case 21: {
                return DESCRIPTION_BCL_OVERSIZE_SEGMENTATION;
            }
            case 22: {
                return DESCRIPTION_BCL_BAD_DATA_LENGTH;
            }
            case 23: {
                return DESCRIPTION_BCL_RECEIVED_DATA_LOST;
            }
            case 33: {
                return DESCRIPTION_BPL_HEARTBEAT_TIMEOUT;
            }
            case 34: {
                return DESCRIPTION_BPL_RETRY_TIMEOUT;
            }
            case 35: {
                return DESCRIPTION_BPL_BUSY;
            }
            case 36: {
                return DESCRIPTION_BPL_REQUEST_TIMEOUT;
            }
            case 49: {
                return DESCRIPTION_BAL_WRONG_ADDRESSING;
            }
            case 50: {
                return DESCRIPTION_BAL_INCOMPATIBLE_PROTOCOL_VERSION;
            }
            case 51: {
                return DESCRIPTION_BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION;
            }
            case 52: {
                return DESCRIPTION_BAL_DATA_INVALID;
            }
            case 53: {
                return DESCRIPTION_BAL_INVALID_STATE;
            }
            case 54: {
                return DESCRIPTION_BAL_CACHE_NOT_AVAILABLE;
            }
            case 55: {
                return DESCRIPTION_BAL_INVALID_ARGUMENT;
            }
            case 65: {
                return DESCRIPTION_APPL_OUT_OF_RANGE;
            }
            case 66: {
                return DESCRIPTION_APPL_TEMPORARY_NOT_AVAILABLE;
            }
            case 67: {
                return DESCRIPTION_APPL_MAX_DATA_LENGTH_EXCEEDED;
            }
            case 68: {
                return DESCRIPTION_APPL_UNIT_MISMATCH;
            }
            case 80: {
                return DESCRIPTION_METHOD_ABORTED;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(ERROR_ID_UNKNOWN);
        return buffer.toString();
    }
}

