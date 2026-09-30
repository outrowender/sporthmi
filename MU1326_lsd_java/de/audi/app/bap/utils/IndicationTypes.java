/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class IndicationTypes {
    private static final String BAPINDICATIONTYPE_DATASETGET_IND = "DATASETGET_IND (0)";
    private static final String BAPINDICATIONTYPE_DATASET_IND = "DATASET_IND (1)";
    private static final String BAPINDICATIONTYPE_DATAGET_IND = "DATAGET_IND (2)";
    private static final String BAPINDICATIONTYPE_START_IND = "START_IND (3)";
    private static final String BAPINDICATIONTYPE_STARTRESULT_IND = "STARTRESULT_IND (4)";
    private static final String BAPINDICATIONTYPE_ABORT_IND = "ABORT_IND (5)";
    private static final String BAPINDICATIONTYPE_PROCESSING_CNF = "PROCESSING_CNF (6)";
    private static final String BAPINDICATIONTYPE_ACK_IND = "ACK_IND (7)";
    private static final String BAPINDICATIONTYPE_DATAACK_RSP = "DATAACK_RSP (8)";
    private static final String BAPINDICATIONTYPE_DATA_RSP = "DATA_RSP (9)";
    private static final String BAPINDICATIONTYPE_PROCESSING_IND = "PROCESSING_IND (10)";
    private static final String BAPINDICATIONTYPE_RESULT_IND = "RESULT_IND (11)";
    private static final String BAPINDICATIONTYPE_CHANGED_IND = "CHANGED_IND (12)";
    private static final String BAPINDICATIONTYPE_RESET_IND = "RESET_IND (13)";
    private static final String BAPINDICATIONTYPE_INVALID = "INVALID";

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return BAPINDICATIONTYPE_DATASETGET_IND;
            }
            case 1: {
                return BAPINDICATIONTYPE_DATASET_IND;
            }
            case 2: {
                return BAPINDICATIONTYPE_DATAGET_IND;
            }
            case 3: {
                return BAPINDICATIONTYPE_START_IND;
            }
            case 4: {
                return BAPINDICATIONTYPE_STARTRESULT_IND;
            }
            case 5: {
                return BAPINDICATIONTYPE_ABORT_IND;
            }
            case 6: {
                return BAPINDICATIONTYPE_PROCESSING_CNF;
            }
            case 7: {
                return BAPINDICATIONTYPE_ACK_IND;
            }
            case 8: {
                return BAPINDICATIONTYPE_DATAACK_RSP;
            }
            case 9: {
                return BAPINDICATIONTYPE_DATA_RSP;
            }
            case 10: {
                return BAPINDICATIONTYPE_PROCESSING_IND;
            }
            case 11: {
                return BAPINDICATIONTYPE_RESULT_IND;
            }
            case 12: {
                return BAPINDICATIONTYPE_CHANGED_IND;
            }
            case 13: {
                return BAPINDICATIONTYPE_RESET_IND;
            }
        }
        Buffer buffer = new Buffer(BAPINDICATIONTYPE_INVALID);
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

