/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.StartGuidanceResultEnumeration;
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

public class StartGuidanceResultContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_START_GUIDANCE_RESULT;
    private static final int ELEMENT_ID_RESULT;
    private Map map = new HashMap();

    public StartGuidanceResultContainer(StartGuidanceResultEnumeration startGuidanceResultEnumeration) {
        this.map.put(new Integer(175), startGuidanceResultEnumeration);
    }

    public StartGuidanceResultContainer(StartGuidanceResultContainer startGuidanceResultContainer) {
        this.map.putAll(startGuidanceResultContainer.map);
    }

    public StartGuidanceResultContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 175: {
                    this.map.put(new Integer(175), StartGuidanceResultEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public StartGuidanceResultEnumeration getResult() {
        return (StartGuidanceResultEnumeration)this.map.get(new Integer(175));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(67, n2, n, this.createElements(), n3));
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
                case 175: {
                    hASDataElementArray[n++] = new IntegerElement(175, ((StartGuidanceResultEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("StartGuidanceResultContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 175: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("result(StartGuidanceResultEnumeration)=null");
                        break;
                    }
                    stringWriter.write("result(StartGuidanceResultEnumeration)='");
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
        StartGuidanceResultContainer startGuidanceResultContainer = new StartGuidanceResultContainer(this);
        return startGuidanceResultContainer;
    }
}

