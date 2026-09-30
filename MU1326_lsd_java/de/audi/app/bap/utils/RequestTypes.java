/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class RequestTypes {
    private static final String BAPREQUESTTYPE_DATASETGET_REQ = "DATASETGET_REQ (0)";
    private static final String BAPREQUESTTYPE_DATASET_REQ = "DATASET_REQ (1)";
    private static final String BAPREQUESTTYPE_DATAGET_REQ = "DATAGET_REQ (2)";
    private static final String BAPREQUESTTYPE_START_REQ = "START_REQ (3)";
    private static final String BAPREQUESTTYPE_STARTRESULT_REQ = "STARTRESULT_REQ (4)";
    private static final String BAPREQUESTTYPE_ABORT_REQ = "ABORT_REQ (5)";
    private static final String BAPREQUESTTYPE_DATAACK_REQ = "DATAACK_REQ (6)";
    private static final String BAPREQUESTTYPE_DATA_CNF = "DATA_CNF (7)";
    private static final String BAPREQUESTTYPE_PROCESSING_REQ = "PROCESSING_REQ (8)";
    private static final String BAPREQUESTTYPE_RESULT_REQ = "RESULT_REQ (9)";
    private static final String BAPREQUESTTYPE_CHANGED_REQ = "CHANGED_REQ (10)";
    private static final String BAPREQUESTTYPE_DATAACK_CNF = "DATAACK_CNF (11)";
    private static final String BAPREQUESTTYPE_INVALID = "INVALID";

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return BAPREQUESTTYPE_DATASETGET_REQ;
            }
            case 1: {
                return BAPREQUESTTYPE_DATASET_REQ;
            }
            case 2: {
                return BAPREQUESTTYPE_DATAGET_REQ;
            }
            case 3: {
                return BAPREQUESTTYPE_START_REQ;
            }
            case 4: {
                return BAPREQUESTTYPE_STARTRESULT_REQ;
            }
            case 5: {
                return BAPREQUESTTYPE_ABORT_REQ;
            }
            case 6: {
                return BAPREQUESTTYPE_DATAACK_REQ;
            }
            case 7: {
                return BAPREQUESTTYPE_DATA_CNF;
            }
            case 8: {
                return BAPREQUESTTYPE_PROCESSING_REQ;
            }
            case 9: {
                return BAPREQUESTTYPE_RESULT_REQ;
            }
            case 10: {
                return BAPREQUESTTYPE_CHANGED_REQ;
            }
            case 11: {
                return BAPREQUESTTYPE_DATAACK_CNF;
            }
        }
        Buffer buffer = new Buffer(BAPREQUESTTYPE_INVALID);
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

