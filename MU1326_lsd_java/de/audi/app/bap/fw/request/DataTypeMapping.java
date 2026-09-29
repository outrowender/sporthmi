/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class DataTypeMapping {
    private static final SimpleIntObjectMap DATA_TYPE_MAPPINGS = new SimpleIntObjectMap();

    public static int getRequestDataType(int n, int n2, int n3) {
        IDataTypeMapping iDataTypeMapping = (IDataTypeMapping)DATA_TYPE_MAPPINGS.get(n);
        if (iDataTypeMapping == null) {
            return 3;
        }
        return iDataTypeMapping.getRequestDataType(n2, n3);
    }

    public static int getIndicationDataType(int n, int n2, int n3) {
        IDataTypeMapping iDataTypeMapping = (IDataTypeMapping)DATA_TYPE_MAPPINGS.get(n);
        if (iDataTypeMapping == null) {
            return 3;
        }
        return iDataTypeMapping.getIndicationDataType(n2, n3);
    }

    public static void registerDataTypeMapping(int n, IDataTypeMapping iDataTypeMapping) {
        DATA_TYPE_MAPPINGS.add(n, iDataTypeMapping);
    }
}

