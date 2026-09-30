/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.ListStateEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ListStateContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_LIST_STATE = 0x1000002;
    private static final int ELEMENT_ID_PAGE_SIZE = 0x1000004;
    private static final int ELEMENT_ID_LIST_SIZE = 0x1000005;
    private static final int ELEMENT_ID_MOD_COUNT = 0x1000006;
    private static final int ELEMENT_ID_STATE = 0x100000D;
    private Map map = new HashMap();

    public ListStateContainer(int n, int n2, int n3, ListStateEnumeration listStateEnumeration) {
        this.map.put(new Integer(0x1000004), new Long(n));
        this.map.put(new Integer(0x1000005), new Long(n2));
        this.map.put(new Integer(0x1000006), new Long(n3));
        this.map.put(new Integer(0x100000D), listStateEnumeration);
    }

    public ListStateContainer(ListStateContainer listStateContainer) {
        this.map.putAll(listStateContainer.map);
    }

    public ListStateContainer(HASDataElement[] hASDataElementArray) {
        block6: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 0x1000004: {
                    this.map.put(new Integer(0x1000004), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 0x1000005: {
                    this.map.put(new Integer(0x1000005), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 0x1000006: {
                    this.map.put(new Integer(0x1000006), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 0x100000D: {
                    this.map.put(new Integer(0x100000D), ListStateEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block6;
                }
            }
        }
    }

    public int getPageSize() {
        return ((Long)this.map.get(new Integer(0x1000004))).intValue();
    }

    public int getListSize() {
        return ((Long)this.map.get(new Integer(0x1000005))).intValue();
    }

    public int getModCount() {
        return ((Long)this.map.get(new Integer(0x1000006))).intValue();
    }

    public ListStateEnumeration getState() {
        return (ListStateEnumeration)this.map.get(new Integer(0x100000D));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(0x1000002, n2, n, this.createElements(), n3));
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
                case 0x1000004: {
                    hASDataElementArray[n++] = new IntegerElement(0x1000004, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 0x1000005: {
                    hASDataElementArray[n++] = new IntegerElement(0x1000005, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 0x1000006: {
                    hASDataElementArray[n++] = new IntegerElement(0x1000006, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 0x100000D: {
                    hASDataElementArray[n++] = new IntegerElement(0x100000D, ((ListStateEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("ListStateContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 0x1000004: {
                    if (entry.getValue() == null) {
                        stringWriter.write("pageSize(int)=null");
                        break;
                    }
                    stringWriter.write("pageSize(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 0x1000005: {
                    if (entry.getValue() == null) {
                        stringWriter.write("listSize(int)=null");
                        break;
                    }
                    stringWriter.write("listSize(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 0x1000006: {
                    if (entry.getValue() == null) {
                        stringWriter.write("modCount(int)=null");
                        break;
                    }
                    stringWriter.write("modCount(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 0x100000D: {
                    if (entry.getValue() == null) {
                        stringWriter.write("state(ListStateEnumeration)=null");
                        break;
                    }
                    stringWriter.write("state(ListStateEnumeration)='");
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
        ListStateContainer listStateContainer = new ListStateContainer(this);
        return listStateContainer;
    }
}

