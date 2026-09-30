/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class LastDestinationContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_LAST_DESTINATION = 36;
    private static final int ELEMENT_ID_DESCRIPTOR = 74;
    private static final int ELEMENT_ID_ID = 75;
    private Map map = new HashMap();

    public LastDestinationContainer(String string, int n) {
        this.map.put(new Integer(74), string);
        this.map.put(new Integer(75), new Long(n));
    }

    public LastDestinationContainer(LastDestinationContainer lastDestinationContainer) {
        this.map.putAll(lastDestinationContainer.map);
    }

    public LastDestinationContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 74: {
                    this.map.put(new Integer(74), hASDataElementArray[i2].stringData);
                    continue block4;
                }
                case 75: {
                    this.map.put(new Integer(75), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public String getDescriptor() {
        return (String)this.map.get(new Integer(74));
    }

    public int getId() {
        return ((Long)this.map.get(new Integer(75))).intValue();
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(36, n2, n, this.createElements(), n3));
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
                case 74: {
                    hASDataElementArray[n++] = new StringElement(74, (String)entry.getValue());
                    break;
                }
                case 75: {
                    hASDataElementArray[n++] = new IntegerElement(75, ((Long)entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("LastDestinationContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 74: {
                    if (entry.getValue() == null) {
                        stringWriter.write("descriptor(String)=null");
                        break;
                    }
                    stringWriter.write("descriptor(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 75: {
                    if (entry.getValue() == null) {
                        stringWriter.write("id(int)=null");
                        break;
                    }
                    stringWriter.write("id(int)='");
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
        LastDestinationContainer lastDestinationContainer = new LastDestinationContainer(this);
        return lastDestinationContainer;
    }
}

