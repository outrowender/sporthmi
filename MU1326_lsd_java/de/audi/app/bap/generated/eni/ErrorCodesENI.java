/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.Buffer;

public final class ErrorCodesENI
implements IErrorCodes {
    private static final String DESCRIPTION_NO_ERROR = "0x0 (NO_ERROR)";
    private static final String ERROR_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 0: {
                return DESCRIPTION_NO_ERROR;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(ERROR_ID_UNKNOWN);
        return buffer.toString();
    }
}

