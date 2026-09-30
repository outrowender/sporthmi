/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class AcknowledgeTypes {
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATA = "PROPERTY_DATA (0)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATAACK = "PROPERTY_DATAACK (1)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_ERROR = "PROPERTY_ERROR (2)";
    private static final String ACKNOWLEDGETYPE_ARRAY_DATA = "ARRAY_DATA (3)";
    private static final String ACKNOWLEDGETYPE_ARRAY_CHANGED = "ARRAY_CHANGED (4)";
    private static final String ACKNOWLEDGETYPE_ARRAY_ERROR = "ARRAY_ERROR (5)";
    private static final String ACKNOWLEDGETYPE_METHOD_PROCESSING = "METHOD_PROCESSING (6)";
    private static final String ACKNOWLEDGETYPE_METHOD_RESULT = "METHOD_RESULT (7)";
    private static final String ACKNOWLEDGETYPE_METHOD_ERROR = "METHOD_ERROR (8)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATASETGET = "PROPERTY_DATASETGET (9)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATASET = "PROPERTY_DATASET (10)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_DATAGET = "PROPERTY_DATAGET (11)";
    private static final String ACKNOWLEDGETYPE_PROPERTY_ACK = "PROPERTY_ACK (12)";
    private static final String ACKNOWLEDGETYPE_ARRAY_DATASETGET = "ARRAY_DATASETGET (13)";
    private static final String ACKNOWLEDGETYPE_ARRAY_DATASET = "ARRAY_DATASET (14)";
    private static final String ACKNOWLEDGETYPE_ARRAY_DATAGET = "ARRAY_DATAGET (15)";
    private static final String ACKNOWLEDGETYPE_METHOD_START = "METHOD_START (16)";
    private static final String ACKNOWLEDGETYPE_METHOD_STARTRESULT = "METHOD_STARTRESULT (17)";
    private static final String ACKNOWLEDGETYPE_METHOD_ABORT = "METHOD_ABORT (18)";
    private static final String ACKNOWLEDGETYPE_CACHE_DATAGET = "CACHE_DATAGET (19)";
    private static final String ACKNOWLEDGETYPE_SET_HMI_STATE = "SET_HMI_STATE (20)";
    private static final String ACKNOWLEDGETYPE_INVALID = "INVALID";

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return ACKNOWLEDGETYPE_PROPERTY_DATA;
            }
            case 1: {
                return ACKNOWLEDGETYPE_PROPERTY_DATAACK;
            }
            case 2: {
                return ACKNOWLEDGETYPE_PROPERTY_ERROR;
            }
            case 3: {
                return ACKNOWLEDGETYPE_ARRAY_DATA;
            }
            case 4: {
                return ACKNOWLEDGETYPE_ARRAY_CHANGED;
            }
            case 5: {
                return ACKNOWLEDGETYPE_ARRAY_ERROR;
            }
            case 6: {
                return ACKNOWLEDGETYPE_METHOD_PROCESSING;
            }
            case 7: {
                return ACKNOWLEDGETYPE_METHOD_RESULT;
            }
            case 8: {
                return ACKNOWLEDGETYPE_METHOD_ERROR;
            }
            case 9: {
                return ACKNOWLEDGETYPE_PROPERTY_DATASETGET;
            }
            case 10: {
                return ACKNOWLEDGETYPE_PROPERTY_DATASET;
            }
            case 11: {
                return ACKNOWLEDGETYPE_PROPERTY_DATAGET;
            }
            case 12: {
                return ACKNOWLEDGETYPE_PROPERTY_ACK;
            }
            case 13: {
                return ACKNOWLEDGETYPE_ARRAY_DATASETGET;
            }
            case 14: {
                return ACKNOWLEDGETYPE_ARRAY_DATASET;
            }
            case 15: {
                return ACKNOWLEDGETYPE_ARRAY_DATAGET;
            }
            case 16: {
                return ACKNOWLEDGETYPE_METHOD_START;
            }
            case 17: {
                return ACKNOWLEDGETYPE_METHOD_STARTRESULT;
            }
            case 18: {
                return ACKNOWLEDGETYPE_METHOD_ABORT;
            }
            case 19: {
                return ACKNOWLEDGETYPE_CACHE_DATAGET;
            }
            case 20: {
                return ACKNOWLEDGETYPE_SET_HMI_STATE;
            }
        }
        Buffer buffer = new Buffer(ACKNOWLEDGETYPE_INVALID);
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

