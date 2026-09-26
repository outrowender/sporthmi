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
import java.util.Map$Entry;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class TrackPositionContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_TRACK_POSITION;
    private static final int ELEMENT_ID_POSITION;
    private Map map = new HashMap();

    public TrackPositionContainer(int n) {
        this.map.put(new Integer(68), new Long(n));
    }

    public TrackPositionContainer(TrackPositionContainer trackPositionContainer) {
        this.map.putAll(trackPositionContainer.map);
    }

    public TrackPositionContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 68: {
                    this.map.put(new Integer(68), new Long(hASDataElementArray[i2].numericData));
                    continue block3;
                }
            }
        }
    }

    public int getPosition() {
        return ((Long)this.map.get(new Integer(68))).intValue();
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(31, n2, n, this.createElements(), n3));
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
                case 68: {
                    hASDataElementArray[n++] = new IntegerElement(68, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("TrackPositionContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 68: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("position(int)=null");
                        break;
                    }
                    stringWriter.write("position(int)='");
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
        TrackPositionContainer trackPositionContainer = new TrackPositionContainer(this);
        return trackPositionContainer;
    }
}

