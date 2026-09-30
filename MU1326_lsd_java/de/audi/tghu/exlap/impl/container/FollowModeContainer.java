/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class FollowModeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_FOLLOW_MODE = 46;
    private static final int ELEMENT_ID_FOLLOW_MODE = 102;
    private Map map = new HashMap();

    public FollowModeContainer(boolean bl) {
        this.map.put(new Integer(102), new Boolean(bl));
    }

    public FollowModeContainer(FollowModeContainer followModeContainer) {
        this.map.putAll(followModeContainer.map);
    }

    public FollowModeContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 102: {
                    this.map.put(new Integer(102), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block3;
                }
            }
        }
    }

    public boolean getFollowMode() {
        return (Boolean)this.map.get(new Integer(102));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(46, n2, n, this.createElements(), n3));
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
                case 102: {
                    hASDataElementArray[n++] = new BooleanElement(102, (boolean)((Boolean)entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("FollowModeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 102: {
                    if (entry.getValue() == null) {
                        stringWriter.write("followMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("followMode(boolean)='");
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
        FollowModeContainer followModeContainer = new FollowModeContainer(this);
        return followModeContainer;
    }
}

