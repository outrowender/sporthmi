/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

public class FileTransferError {
    public static final byte ERROR_IN_OPERATION = 10;
    public static final byte ERROR_SENDING_OPERATION_DOWNLOAD = 20;
    public static final byte ERROR_SENDING_OPERATION_STATUS = 21;
    public static final byte ERROR_SEND_REQUEST_FAILED = 30;
    public static final byte ERROR_RECEIVED_INVALID_DATA = 40;
    public static final byte ERROR_SESSION_END_DETECTED = 60;
    private Exception exception = null;
    private byte errorCode = (byte)-1;
    private String errorMessage = null;

    private String getErrorMessage(byte by) {
        switch (by) {
            case 10: {
                return "Error in operation";
            }
            case 20: {
                return "Error in sending operation download";
            }
            case 21: {
                return "Error in sending operation status";
            }
            case 30: {
                return "send request failed";
            }
            case 40: {
                return "received unexpected or invalid data";
            }
            case 60: {
                return "Exit or Init Message received, Transfer canceled ";
            }
        }
        return "no error message found for errorcode : " + by;
    }

    public FileTransferError(byte by) {
        this.errorCode = by;
        this.errorMessage = this.getErrorMessage(this.errorCode);
    }

    public FileTransferError(byte by, Exception exception) {
        this.errorCode = by;
        this.exception = exception;
        this.errorMessage = exception.getMessage();
    }

    public FileTransferError(byte by, String string) {
        this.errorCode = by;
        this.errorMessage = string;
    }

    public FileTransferError(Exception exception) {
        this.exception = exception;
        this.errorMessage = exception.getMessage();
    }

    public Exception getException() {
        return this.exception;
    }

    public byte getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        String string = "FileTransferError: ";
        if (this.exception != null) {
            string = string + "Exception: " + this.exception.getClass() + ", " + this.exception.getMessage();
        }
        if (this.errorCode != -1) {
            string = string + "ErrorCode: " + this.errorCode + " ";
        }
        if (this.errorMessage != null) {
            string = string + "ErrorMessage: " + this.errorMessage;
        }
        return string;
    }
}

