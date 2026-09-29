/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.EntertainmentContextEnumeration;
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

public class EntertainmentContextContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_ENTERTAINMENT_CONTEXT;
    private static final int ELEMENT_ID_ENTERTAINMENT_CONTEXT;
    private Map map = new HashMap();

    public EntertainmentContextContainer(EntertainmentContextEnumeration entertainmentContextEnumeration) {
        this.map.put(new Integer(150), entertainmentContextEnumeration);
    }

    public EntertainmentContextContainer(EntertainmentContextContainer entertainmentContextContainer) {
        this.map.putAll(entertainmentContextContainer.map);
    }

    public EntertainmentContextContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 150: {
                    this.map.put(new Integer(150), EntertainmentContextEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public EntertainmentContextEnumeration getEntertainmentContext() {
        return (EntertainmentContextEnumeration)this.map.get(new Integer(150));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(65, n2, n, this.createElements(), n3));
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
                case 150: {
                    hASDataElementArray[n++] = new IntegerElement(150, ((EntertainmentContextEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("EntertainmentContextContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 150: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("entertainmentContext(EntertainmentContextEnumeration)=null");
                        break;
                    }
                    stringWriter.write("entertainmentContext(EntertainmentContextEnumeration)='");
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
        EntertainmentContextContainer entertainmentContextContainer = new EntertainmentContextContainer(this);
        return entertainmentContextContainer;
    }
}

