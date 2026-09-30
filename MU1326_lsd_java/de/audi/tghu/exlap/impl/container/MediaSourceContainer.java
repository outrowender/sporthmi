/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.MediaSourceEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaSourceContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_SOURCE = 34;
    private static final int ELEMENT_ID_SOURCE = 72;
    private Map map = new HashMap();

    public MediaSourceContainer(MediaSourceEnumeration mediaSourceEnumeration) {
        this.map.put(new Integer(72), mediaSourceEnumeration);
    }

    public MediaSourceContainer(MediaSourceContainer mediaSourceContainer) {
        this.map.putAll(mediaSourceContainer.map);
    }

    public MediaSourceContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 72: {
                    this.map.put(new Integer(72), MediaSourceEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public MediaSourceEnumeration getSource() {
        return (MediaSourceEnumeration)this.map.get(new Integer(72));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(34, n2, n, this.createElements(), n3));
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
                case 72: {
                    hASDataElementArray[n++] = new IntegerElement(72, ((MediaSourceEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaSourceContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 72: {
                    if (entry.getValue() == null) {
                        stringWriter.write("source(MediaSourceEnumeration)=null");
                        break;
                    }
                    stringWriter.write("source(MediaSourceEnumeration)='");
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
        MediaSourceContainer mediaSourceContainer = new MediaSourceContainer(this);
        return mediaSourceContainer;
    }
}

