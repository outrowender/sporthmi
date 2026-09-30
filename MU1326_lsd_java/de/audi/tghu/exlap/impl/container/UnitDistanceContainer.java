/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

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

public class UnitDistanceContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_UNIT_DISTANCE = 14;
    private static final int ELEMENT_ID_UNIT_DISTANCE = 27;
    private Map map = new HashMap();

    public UnitDistanceContainer(String string) {
        this.map.put(new Integer(27), string);
    }

    public UnitDistanceContainer(UnitDistanceContainer unitDistanceContainer) {
        this.map.putAll(unitDistanceContainer.map);
    }

    public UnitDistanceContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 27: {
                    this.map.put(new Integer(27), hASDataElementArray[i2].stringData);
                    continue block3;
                }
            }
        }
    }

    public String getUnitDistance() {
        return (String)this.map.get(new Integer(27));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(14, n2, n, this.createElements(), n3));
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
                case 27: {
                    hASDataElementArray[n++] = new StringElement(27, (String)entry.getValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("UnitDistanceContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 27: {
                    if (entry.getValue() == null) {
                        stringWriter.write("unitDistance(String)=null");
                        break;
                    }
                    stringWriter.write("unitDistance(String)='");
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
        UnitDistanceContainer unitDistanceContainer = new UnitDistanceContainer(this);
        return unitDistanceContainer;
    }
}

