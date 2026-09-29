/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.ResourceElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.GPXDataTypeEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ImportGPXDataContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_IMPORT_GPXDATA;
    private static final int ELEMENT_ID_RESOURCE;
    private static final int ELEMENT_ID_NAME;
    private static final int ELEMENT_ID_TYPE;
    private Map map = new HashMap();

    public ImportGPXDataContainer(ResourceLocator resourceLocator, String string, GPXDataTypeEnumeration gPXDataTypeEnumeration) {
        this.map.put(new Integer(134), resourceLocator);
        this.map.put(new Integer(135), string);
        this.map.put(new Integer(138), gPXDataTypeEnumeration);
    }

    public ImportGPXDataContainer(ImportGPXDataContainer importGPXDataContainer) {
        this.map.putAll(importGPXDataContainer.map);
    }

    public ImportGPXDataContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 134: {
                    this.map.put(new Integer(134), hASDataElementArray[i2].resourceLocator);
                    continue block5;
                }
                case 135: {
                    this.map.put(new Integer(135), hASDataElementArray[i2].stringData);
                    continue block5;
                }
                case 138: {
                    this.map.put(new Integer(138), GPXDataTypeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
            }
        }
    }

    public ResourceLocator getResource() {
        return (ResourceLocator)this.map.get(new Integer(134));
    }

    public String getName() {
        return (String)this.map.get(new Integer(135));
    }

    public GPXDataTypeEnumeration getType() {
        return (GPXDataTypeEnumeration)this.map.get(new Integer(138));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(59, n2, n, this.createElements(), n3));
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
                case 134: {
                    hASDataElementArray[n++] = new ResourceElement(134, (ResourceLocator)map$Entry.getValue());
                    break;
                }
                case 135: {
                    hASDataElementArray[n++] = new StringElement(135, (String)map$Entry.getValue());
                    break;
                }
                case 138: {
                    hASDataElementArray[n++] = new IntegerElement(138, ((GPXDataTypeEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("ImportGPXDataContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 134: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("resource(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("resource(ResourceLocator)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 135: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("name(String)=null");
                        break;
                    }
                    stringWriter.write("name(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 138: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("type(GPXDataTypeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("type(GPXDataTypeEnumeration)='");
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
        ImportGPXDataContainer importGPXDataContainer = new ImportGPXDataContainer(this);
        return importGPXDataContainer;
    }
}

