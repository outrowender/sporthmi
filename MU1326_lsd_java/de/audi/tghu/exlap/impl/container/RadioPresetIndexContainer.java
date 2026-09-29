/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.RadioBandEnumeration;
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

public class RadioPresetIndexContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_PRESET_INDEX;
    private static final int ELEMENT_ID_BAND;
    private static final int ELEMENT_ID_INDEX;
    private Map map = new HashMap();

    public RadioPresetIndexContainer(RadioBandEnumeration radioBandEnumeration, int n) {
        this.map.put(new Integer(100), radioBandEnumeration);
        this.map.put(new Integer(101), new Long(n));
    }

    public RadioPresetIndexContainer(RadioPresetIndexContainer radioPresetIndexContainer) {
        this.map.putAll(radioPresetIndexContainer.map);
    }

    public RadioPresetIndexContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 100: {
                    this.map.put(new Integer(100), RadioBandEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block4;
                }
                case 101: {
                    this.map.put(new Integer(101), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public RadioBandEnumeration getBand() {
        return (RadioBandEnumeration)this.map.get(new Integer(100));
    }

    public int getIndex() {
        return ((Long)this.map.get(new Integer(101))).intValue();
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(45, n2, n, this.createElements(), n3));
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
                case 100: {
                    hASDataElementArray[n++] = new IntegerElement(100, ((RadioBandEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 101: {
                    hASDataElementArray[n++] = new IntegerElement(101, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioPresetIndexContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 100: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("band(RadioBandEnumeration)=null");
                        break;
                    }
                    stringWriter.write("band(RadioBandEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 101: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("index(int)=null");
                        break;
                    }
                    stringWriter.write("index(int)='");
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
        RadioPresetIndexContainer radioPresetIndexContainer = new RadioPresetIndexContainer(this);
        return radioPresetIndexContainer;
    }
}

