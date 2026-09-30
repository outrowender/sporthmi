/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.SoundSourceEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class SoundVolumeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_SOUND_VOLUME = 27;
    private static final int ELEMENT_ID_SOURCE = 55;
    private static final int ELEMENT_ID_VOLUME = 56;
    private static final int ELEMENT_ID_ENTERTAINMENT_MUTED = 59;
    private Map map = new HashMap();

    public SoundVolumeContainer(SoundSourceEnumeration soundSourceEnumeration, int n, boolean bl) {
        this.map.put(new Integer(55), soundSourceEnumeration);
        this.map.put(new Integer(56), new Long(n));
        this.map.put(new Integer(59), new Boolean(bl));
    }

    public SoundVolumeContainer(SoundVolumeContainer soundVolumeContainer) {
        this.map.putAll(soundVolumeContainer.map);
    }

    public SoundVolumeContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 55: {
                    this.map.put(new Integer(55), SoundSourceEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 56: {
                    this.map.put(new Integer(56), new Long(hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 59: {
                    this.map.put(new Integer(59), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block5;
                }
            }
        }
    }

    public SoundSourceEnumeration getSource() {
        return (SoundSourceEnumeration)this.map.get(new Integer(55));
    }

    public int getVolume() {
        return ((Long)this.map.get(new Integer(56))).intValue();
    }

    public boolean getEntertainmentMuted() {
        return (Boolean)this.map.get(new Integer(59));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(27, n2, n, this.createElements(), n3));
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
                case 55: {
                    hASDataElementArray[n++] = new IntegerElement(55, ((SoundSourceEnumeration)entry.getValue()).ordinal());
                    break;
                }
                case 56: {
                    hASDataElementArray[n++] = new IntegerElement(56, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 59: {
                    hASDataElementArray[n++] = new BooleanElement(59, (boolean)((Boolean)entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("SoundVolumeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 55: {
                    if (entry.getValue() == null) {
                        stringWriter.write("source(SoundSourceEnumeration)=null");
                        break;
                    }
                    stringWriter.write("source(SoundSourceEnumeration)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 56: {
                    if (entry.getValue() == null) {
                        stringWriter.write("volume(int)=null");
                        break;
                    }
                    stringWriter.write("volume(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 59: {
                    if (entry.getValue() == null) {
                        stringWriter.write("entertainmentMuted(boolean)=null");
                        break;
                    }
                    stringWriter.write("entertainmentMuted(boolean)='");
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
        SoundVolumeContainer soundVolumeContainer = new SoundVolumeContainer(this);
        return soundVolumeContainer;
    }
}

