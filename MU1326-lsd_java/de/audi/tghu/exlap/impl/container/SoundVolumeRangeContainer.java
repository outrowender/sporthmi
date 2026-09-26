/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.SoundSourceEnumeration;
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

public class SoundVolumeRangeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_SOUND_VOLUME_RANGE;
    private static final int ELEMENT_ID_SOURCE;
    private static final int ELEMENT_ID_MIN_VOLUME;
    private static final int ELEMENT_ID_MAX_VOLUME;
    private Map map = new HashMap();

    public SoundVolumeRangeContainer(SoundSourceEnumeration soundSourceEnumeration, int n, int n2) {
        this.map.put(new Integer(61), soundSourceEnumeration);
        this.map.put(new Integer(57), new Long(n));
        this.map.put(new Integer(58), new Long(n2));
    }

    public SoundVolumeRangeContainer(SoundVolumeRangeContainer soundVolumeRangeContainer) {
        this.map.putAll(soundVolumeRangeContainer.map);
    }

    public SoundVolumeRangeContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 61: {
                    this.map.put(new Integer(61), SoundSourceEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 57: {
                    this.map.put(new Integer(57), new Long(hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 58: {
                    this.map.put(new Integer(58), new Long(hASDataElementArray[i2].numericData));
                    continue block5;
                }
            }
        }
    }

    public SoundSourceEnumeration getSource() {
        return (SoundSourceEnumeration)this.map.get(new Integer(61));
    }

    public int getMinVolume() {
        return ((Long)this.map.get(new Integer(57))).intValue();
    }

    public int getMaxVolume() {
        return ((Long)this.map.get(new Integer(58))).intValue();
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(28, n2, n, this.createElements(), n3));
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
                case 61: {
                    hASDataElementArray[n++] = new IntegerElement(61, ((SoundSourceEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 57: {
                    hASDataElementArray[n++] = new IntegerElement(57, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
                case 58: {
                    hASDataElementArray[n++] = new IntegerElement(58, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("SoundVolumeRangeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 61: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("source(SoundSourceEnumeration)=null");
                        break;
                    }
                    stringWriter.write("source(SoundSourceEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 57: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("minVolume(int)=null");
                        break;
                    }
                    stringWriter.write("minVolume(int)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 58: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("maxVolume(int)=null");
                        break;
                    }
                    stringWriter.write("maxVolume(int)='");
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
        SoundVolumeRangeContainer soundVolumeRangeContainer = new SoundVolumeRangeContainer(this);
        return soundVolumeRangeContainer;
    }
}

