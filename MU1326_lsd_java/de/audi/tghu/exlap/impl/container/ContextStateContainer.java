/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.ContextStateEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ContextStateContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_CONTEXT_STATE = 0x1000000;
    private static final int ELEMENT_ID_CONTEXT = 0x1000000;
    private static final int ELEMENT_ID_STATE = 0x1000001;
    private Map map = new HashMap();

    public ContextStateContainer(String string, ContextStateEnumeration contextStateEnumeration) {
        this.map.put(new Integer(0x1000000), string);
        this.map.put(new Integer(0x1000001), contextStateEnumeration);
    }

    public ContextStateContainer(ContextStateContainer contextStateContainer) {
        this.map.putAll(contextStateContainer.map);
    }

    public ContextStateContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 0x1000000: {
                    this.map.put(new Integer(0x1000000), hASDataElementArray[i2].stringData);
                    continue block4;
                }
                case 0x1000001: {
                    this.map.put(new Integer(0x1000001), ContextStateEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public String getContext() {
        return (String)this.map.get(new Integer(0x1000000));
    }

    public ContextStateEnumeration getState() {
        return (ContextStateEnumeration)this.map.get(new Integer(0x1000001));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(0x1000000, n2, n, this.createElements(), n3));
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
                case 0x1000000: {
                    hASDataElementArray[n++] = new StringElement(0x1000000, (String)entry.getValue());
                    break;
                }
                case 0x1000001: {
                    hASDataElementArray[n++] = new IntegerElement(0x1000001, ((ContextStateEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("ContextStateContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 0x1000000: {
                    if (entry.getValue() == null) {
                        stringWriter.write("context(String)=null");
                        break;
                    }
                    stringWriter.write("context(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 0x1000001: {
                    if (entry.getValue() == null) {
                        stringWriter.write("state(ContextStateEnumeration)=null");
                        break;
                    }
                    stringWriter.write("state(ContextStateEnumeration)='");
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
        ContextStateContainer contextStateContainer = new ContextStateContainer(this);
        return contextStateContainer;
    }
}

