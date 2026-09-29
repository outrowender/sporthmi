/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.dsi.IntegerElement;
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

public class ListPageDataContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_LIST_PAGE_DATA;
    private static final int ELEMENT_ID_MOD_COUNT;
    private static final int ELEMENT_ID_OFFSET;
    private Map map = new HashMap();
    private List pageData;

    public ListPageDataContainer(int n, int n2) {
        this.map.put(new Integer(0xA000001), new Long(n));
        this.map.put(new Integer(0xB000001), new Long(n2));
    }

    public ListPageDataContainer(ListPageDataContainer listPageDataContainer) {
        this.map.putAll(listPageDataContainer.map);
        if (listPageDataContainer.pageData.size() > 0) {
            this.pageData = new ArrayList();
            Iterator iterator = listPageDataContainer.pageData.iterator();
            while (iterator.hasNext()) {
                this.pageData.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public ListPageDataContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 0x100000A: {
                    this.map.put(new Integer(0xA000001), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
                case 0x100000B: {
                    this.map.put(new Integer(0xB000001), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public int getModCount() {
        return ((Long)this.map.get(new Integer(0xA000001))).intValue();
    }

    public int getOffset() {
        return ((Long)this.map.get(new Integer(0xB000001))).intValue();
    }

    public ListPageDataContainer addPageData(Container container) {
        if (this.pageData == null) {
            this.pageData = new ArrayList();
        }
        this.pageData.add(container);
        return this;
    }

    public List getPageData() {
        if (this.pageData == null) {
            this.pageData = new ArrayList();
        }
        return this.pageData;
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(0x4000001, n2, n, this.createElements(), n3));
        if (this.pageData != null) {
            Iterator iterator = this.pageData.iterator();
            while (iterator.hasNext()) {
                Container container = (Container)iterator.next();
                List list = container.createContainer(n2, n4, 0xC000001);
                n4 += list.size();
                arrayList.addAll(list);
            }
        }
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
                case 0x100000A: {
                    hASDataElementArray[n++] = new IntegerElement(0xA000001, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
                case 0x100000B: {
                    hASDataElementArray[n++] = new IntegerElement(0xB000001, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        Iterator iterator;
        stringWriter.write("ListPageDataContainer(");
        if (this.pageData != null) {
            iterator = this.pageData.iterator();
            stringWriter.write("pageData(List<Container>)=[");
            while (iterator.hasNext()) {
                ((Container)iterator.next()).toString(stringWriter);
                if (!iterator.hasNext()) continue;
                stringWriter.write(", ");
            }
            stringWriter.write("]");
        }
        if (!this.map.isEmpty()) {
            stringWriter.write(", ");
        }
        iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 0x100000A: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("modCount(int)=null");
                        break;
                    }
                    stringWriter.write("modCount(int)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 0x100000B: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("offset(int)=null");
                        break;
                    }
                    stringWriter.write("offset(int)='");
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
        ListPageDataContainer listPageDataContainer = new ListPageDataContainer(this);
        return listPageDataContainer;
    }
}

