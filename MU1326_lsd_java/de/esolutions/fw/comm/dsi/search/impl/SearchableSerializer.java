/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.Searchable;

public class SearchableSerializer {
    public static void putOptionalSearchable(ISerializer iSerializer, Searchable searchable) throws SerializerException {
        boolean bl = searchable == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = searchable.getWordType();
            iSerializer.putInt32(n);
            String string = searchable.getToken();
            iSerializer.putOptionalString(string);
            int n2 = searchable.getTokenPostProcessing();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSearchableVarArray(ISerializer iSerializer, Searchable[] searchableArray) throws SerializerException {
        boolean bl = searchableArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchableArray.length);
            for (int i2 = 0; i2 < searchableArray.length; ++i2) {
                SearchableSerializer.putOptionalSearchable(iSerializer, searchableArray[i2]);
            }
        }
    }

    public static Searchable getOptionalSearchable(IDeserializer iDeserializer) throws SerializerException {
        Searchable searchable = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            searchable = new Searchable();
            searchable.wordType = n2 = iDeserializer.getInt32();
            searchable.token = string = iDeserializer.getOptionalString();
            searchable.tokenPostProcessing = n = iDeserializer.getInt32();
        }
        return searchable;
    }

    public static Searchable[] getOptionalSearchableVarArray(IDeserializer iDeserializer) throws SerializerException {
        Searchable[] searchableArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchableArray = new Searchable[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchableArray[i2] = SearchableSerializer.getOptionalSearchable(iDeserializer);
            }
        }
        return searchableArray;
    }
}

