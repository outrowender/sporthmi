/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.ExlapRestrictionModeEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ExlapRestrictionModeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_EXLAP_RESTRICTION_MODE = 38;
    private static final int ELEMENT_ID_MODE = 77;
    private Map map = new HashMap();

    public ExlapRestrictionModeContainer(ExlapRestrictionModeEnumeration exlapRestrictionModeEnumeration) {
        this.map.put(new Integer(77), exlapRestrictionModeEnumeration);
    }

    public ExlapRestrictionModeContainer(ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
        this.map.putAll(exlapRestrictionModeContainer.map);
    }

    public ExlapRestrictionModeContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 77: {
                    this.map.put(new Integer(77), ExlapRestrictionModeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public ExlapRestrictionModeEnumeration getMode() {
        return (ExlapRestrictionModeEnumeration)this.map.get(new Integer(77));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(38, n2, n, this.createElements(), n3));
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
                case 77: {
                    hASDataElementArray[n++] = new IntegerElement(77, ((ExlapRestrictionModeEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("ExlapRestrictionModeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 77: {
                    if (entry.getValue() == null) {
                        stringWriter.write("mode(ExlapRestrictionModeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("mode(ExlapRestrictionModeEnumeration)='");
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
        ExlapRestrictionModeContainer exlapRestrictionModeContainer = new ExlapRestrictionModeContainer(this);
        return exlapRestrictionModeContainer;
    }
}

