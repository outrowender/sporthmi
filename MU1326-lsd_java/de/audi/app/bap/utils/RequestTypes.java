/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class RequestTypes {
    private static final String BAPREQUESTTYPE_DATASETGET_REQ;
    private static final String BAPREQUESTTYPE_DATASET_REQ;
    private static final String BAPREQUESTTYPE_DATAGET_REQ;
    private static final String BAPREQUESTTYPE_START_REQ;
    private static final String BAPREQUESTTYPE_STARTRESULT_REQ;
    private static final String BAPREQUESTTYPE_ABORT_REQ;
    private static final String BAPREQUESTTYPE_DATAACK_REQ;
    private static final String BAPREQUESTTYPE_DATA_CNF;
    private static final String BAPREQUESTTYPE_PROCESSING_REQ;
    private static final String BAPREQUESTTYPE_RESULT_REQ;
    private static final String BAPREQUESTTYPE_CHANGED_REQ;
    private static final String BAPREQUESTTYPE_DATAACK_CNF;
    private static final String BAPREQUESTTYPE_INVALID;

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return "DATASETGET_REQ (0)";
            }
            case 1: {
                return "DATASET_REQ (1)";
            }
            case 2: {
                return "DATAGET_REQ (2)";
            }
            case 3: {
                return "START_REQ (3)";
            }
            case 4: {
                return "STARTRESULT_REQ (4)";
            }
            case 5: {
                return "ABORT_REQ (5)";
            }
            case 6: {
                return "DATAACK_REQ (6)";
            }
            case 7: {
                return "DATA_CNF (7)";
            }
            case 8: {
                return "PROCESSING_REQ (8)";
            }
            case 9: {
                return "RESULT_REQ (9)";
            }
            case 10: {
                return "CHANGED_REQ (10)";
            }
            case 11: {
                return "DATAACK_CNF (11)";
            }
        }
        Buffer buffer = new Buffer("INVALID");
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

