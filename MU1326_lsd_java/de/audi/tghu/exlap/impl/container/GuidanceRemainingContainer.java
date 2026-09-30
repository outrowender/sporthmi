/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class GuidanceRemainingContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_GUIDANCE_REMAINING = 25;
    private static final int ELEMENT_ID_TIME_TO_DESTINATION = 49;
    private static final int ELEMENT_ID_DISTANCE_TO_DESTINATION = 50;
    private Map map = new HashMap();

    public GuidanceRemainingContainer(int n, int n2) {
        this.map.put(new Integer(49), new Long(n));
        this.map.put(new Integer(50), new Long(n2));
    }

    public GuidanceRemainingContainer(GuidanceRemainingContainer guidanceRemainingContainer) {
        this.map.putAll(guidanceRemainingContainer.map);
    }

    public GuidanceRemainingContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 49: {
                    this.map.put(new Integer(49), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
                case 50: {
                    this.map.put(new Integer(50), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public int getTimeToDestination() {
        return ((Long)this.map.get(new Integer(49))).intValue();
    }

    public int getDistanceToDestination() {
        return ((Long)this.map.get(new Integer(50))).intValue();
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(25, n2, n, this.createElements(), n3));
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
                case 49: {
                    hASDataElementArray[n++] = new IntegerElement(49, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 50: {
                    hASDataElementArray[n++] = new IntegerElement(50, ((Long)entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("GuidanceRemainingContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 49: {
                    if (entry.getValue() == null) {
                        stringWriter.write("timeToDestination(int)=null");
                        break;
                    }
                    stringWriter.write("timeToDestination(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 50: {
                    if (entry.getValue() == null) {
                        stringWriter.write("distanceToDestination(int)=null");
                        break;
                    }
                    stringWriter.write("distanceToDestination(int)='");
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
        GuidanceRemainingContainer guidanceRemainingContainer = new GuidanceRemainingContainer(this);
        return guidanceRemainingContainer;
    }
}

