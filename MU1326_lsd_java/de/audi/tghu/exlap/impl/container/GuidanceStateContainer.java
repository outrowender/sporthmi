/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.GuidanceStateEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class GuidanceStateContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_GUIDANCE_STATE = 7;
    private static final int ELEMENT_ID_GUIDANCE_STATE = 16;
    private Map map = new HashMap();

    public GuidanceStateContainer(GuidanceStateEnumeration guidanceStateEnumeration) {
        this.map.put(new Integer(16), guidanceStateEnumeration);
    }

    public GuidanceStateContainer(GuidanceStateContainer guidanceStateContainer) {
        this.map.putAll(guidanceStateContainer.map);
    }

    public GuidanceStateContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 16: {
                    this.map.put(new Integer(16), GuidanceStateEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public GuidanceStateEnumeration getGuidanceState() {
        return (GuidanceStateEnumeration)this.map.get(new Integer(16));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(7, n2, n, this.createElements(), n3));
        return arrayList;
    }

    public HASDataContainer[] createContainer() {
        List list = this.createContainer(-1, 1, -1);
        return (HASDataContainer[])list.toArray(new HASDataContainer[list.size()]);
    }

    private HASDataElement[] createElements() {
        int n = 0;
        HASDataElement[] hASDataElementArray = new HASDataElement[this.map.size()];
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (entry.getValue() == null) continue;
            switch ((Integer)entry.getKey()) {
                case 16: {
                    hASDataElementArray[n++] = new IntegerElement(16, ((GuidanceStateEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("GuidanceStateContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 16: {
                    if (entry.getValue() == null) {
                        stringWriter.write("guidanceState(GuidanceStateEnumeration)=null");
                        break;
                    }
                    stringWriter.write("guidanceState(GuidanceStateEnumeration)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
            }
            if (!iterator.hasNext()) continue;
            stringWriter.write(", ");
        }
        stringWriter.write(")");
    }

    protected Object clone() {
        GuidanceStateContainer guidanceStateContainer = new GuidanceStateContainer(this);
        return guidanceStateContainer;
    }
}

