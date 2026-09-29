/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class AcknowledgeTypes {
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATA;
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATAACK;
    private static final String ACKNOWLEDGETYPE_PROPERTY_ERROR;
    private static final String ACKNOWLEDGETYPE_ARRAY_DATA;
    private static final String ACKNOWLEDGETYPE_ARRAY_CHANGED;
    private static final String ACKNOWLEDGETYPE_ARRAY_ERROR;
    private static final String ACKNOWLEDGETYPE_METHOD_PROCESSING;
    private static final String ACKNOWLEDGETYPE_METHOD_RESULT;
    private static final String ACKNOWLEDGETYPE_METHOD_ERROR;
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATASETGET;
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATASET;
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATAGET;
    private static final String ACKNOWLEDGETYPE_PROPERTY_ACK;
    private static final String ACKNOWLEDGETYPE_ARRAY_DATASETGET;
    private static final String ACKNOWLEDGETYPE_ARRAY_DATASET;
    private static final String ACKNOWLEDGETYPE_ARRAY_DATAGET;
    private static final String ACKNOWLEDGETYPE_METHOD_START;
    private static final String ACKNOWLEDGETYPE_METHOD_STARTRESULT;
    private static final String ACKNOWLEDGETYPE_METHOD_ABORT;
    private static final String ACKNOWLEDGETYPE_CACHE_DATAGET;
    private static final String ACKNOWLEDGETYPE_SET_HMI_STATE;
    private static final String ACKNOWLEDGETYPE_INVALID;

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return "PROPERTY_DATA (0)";
            }
            case 1: {
                return "PROPERTY_DATAACK (1)";
            }
            case 2: {
                return "PROPERTY_ERROR (2)";
            }
            case 3: {
                return "ARRAY_DATA (3)";
            }
            case 4: {
                return "ARRAY_CHANGED (4)";
            }
            case 5: {
                return "ARRAY_ERROR (5)";
            }
            case 6: {
                return "METHOD_PROCESSING (6)";
            }
            case 7: {
                return "METHOD_RESULT (7)";
            }
            case 8: {
                return "METHOD_ERROR (8)";
            }
            case 9: {
                return "PROPERTY_DATASETGET (9)";
            }
            case 10: {
                return "PROPERTY_DATASET (10)";
            }
            case 11: {
                return "PROPERTY_DATAGET (11)";
            }
            case 12: {
                return "PROPERTY_ACK (12)";
            }
            case 13: {
                return "ARRAY_DATASETGET (13)";
            }
            case 14: {
                return "ARRAY_DATASET (14)";
            }
            case 15: {
                return "ARRAY_DATAGET (15)";
            }
            case 16: {
                return "METHOD_START (16)";
            }
            case 17: {
                return "METHOD_STARTRESULT (17)";
            }
            case 18: {
                return "METHOD_ABORT (18)";
            }
            case 19: {
                return "CACHE_DATAGET (19)";
            }
            case 20: {
                return "SET_HMI_STATE (20)";
            }
        }
        Buffer buffer = new Buffer("INVALID");
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

