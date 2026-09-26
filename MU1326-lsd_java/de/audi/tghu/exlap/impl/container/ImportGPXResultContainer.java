/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.ImportGPXResultEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ImportGPXResultContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_IMPORT_GPXRESULT;
    private static final int ELEMENT_ID_NAME;
    private static final int ELEMENT_ID_RESULT;
    private Map map = new HashMap();

    public ImportGPXResultContainer(String string, ImportGPXResultEnumeration importGPXResultEnumeration) {
        this.map.put(new Integer(136), string);
        this.map.put(new Integer(137), importGPXResultEnumeration);
    }

    public ImportGPXResultContainer(ImportGPXResultContainer importGPXResultContainer) {
        this.map.putAll(importGPXResultContainer.map);
    }

    public ImportGPXResultContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 136: {
                    this.map.put(new Integer(136), hASDataElementArray[i2].stringData);
                    continue block4;
                }
                case 137: {
                    this.map.put(new Integer(137), ImportGPXResultEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public String getName() {
        return (String)this.map.get(new Integer(136));
    }

    public ImportGPXResultEnumeration getResult() {
        return (ImportGPXResultEnumeration)this.map.get(new Integer(137));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(60, n2, n, this.createElements(), n3));
        return arrayList;
    }

    @Override
    public HASDataContainer[] createContainer() {
        List list = this.createContainer(-1, 1, -1);
        return (HASDataContainer[])list.toArray(new HASDataContainer[list.size()]);
    }

    private HASDataElement[] createElements() {
        int n = 0;
        HASDataElement[] hASDataElementArray = new HASDataElement[this.map.size()];
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (map$Entry.getValue() == null) continue;
            switch ((Integer)map$Entry.getKey()) {
                case 136: {
                    hASDataElementArray[n++] = new StringElement(136, (String)map$Entry.getValue());
                    break;
                }
                case 137: {
                    hASDataElementArray[n++] = new IntegerElement(137, ((ImportGPXResultEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("ImportGPXResultContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 136: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("name(String)=null");
                        break;
                    }
                    stringWriter.write("name(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 137: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("result(ImportGPXResultEnumeration)=null");
                        break;
                    }
                    stringWriter.write("result(ImportGPXResultEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
            }
            if (!iterator.hasNext()) continue;
            stringWriter.write(", ");
        }
        stringWriter.write(")");
    }

    @Override
    protected Object clone() {
        ImportGPXResultContainer importGPXResultContainer = new ImportGPXResultContainer(this);
        return importGPXResultContainer;
    }
}

