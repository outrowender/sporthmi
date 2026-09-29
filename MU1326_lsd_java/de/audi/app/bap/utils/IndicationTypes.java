/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class IndicationTypes {
    private static final String BAPINDICATIONTYPE_DATASETGET_IND;
    private static final String BAPINDICATIONTYPE_DATASET_IND;
    private static final String BAPINDICATIONTYPE_DATAGET_IND;
    private static final String BAPINDICATIONTYPE_START_IND;
    private static final String BAPINDICATIONTYPE_STARTRESULT_IND;
    private static final String BAPINDICATIONTYPE_ABORT_IND;
    private static final String BAPINDICATIONTYPE_PROCESSING_CNF;
    private static final String BAPINDICATIONTYPE_ACK_IND;
    private static final String BAPINDICATIONTYPE_DATAACK_RSP;
    private static final String BAPINDICATIONTYPE_DATA_RSP;
    private static final String BAPINDICATIONTYPE_PROCESSING_IND;
    private static final String BAPINDICATIONTYPE_RESULT_IND;
    private static final String BAPINDICATIONTYPE_CHANGED_IND;
    private static final String BAPINDICATIONTYPE_RESET_IND;
    private static final String BAPINDICATIONTYPE_INVALID;

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return "DATASETGET_IND (0)";
            }
            case 1: {
                return "DATASET_IND (1)";
            }
            case 2: {
                return "DATAGET_IND (2)";
            }
            case 3: {
                return "START_IND (3)";
            }
            case 4: {
                return "STARTRESULT_IND (4)";
            }
            case 5: {
                return "ABORT_IND (5)";
            }
            case 6: {
                return "PROCESSING_CNF (6)";
            }
            case 7: {
                return "ACK_IND (7)";
            }
            case 8: {
                return "DATAACK_RSP (8)";
            }
            case 9: {
                return "DATA_RSP (9)";
            }
            case 10: {
                return "PROCESSING_IND (10)";
            }
            case 11: {
                return "RESULT_IND (11)";
            }
            case 12: {
                return "CHANGED_IND (12)";
            }
            case 13: {
                return "RESET_IND (13)";
            }
        }
        Buffer buffer = new Buffer("INVALID");
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

