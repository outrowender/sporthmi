/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.MediaRepeatModeEnumeration;
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

public class MediaPlayModeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_PLAY_MODE;
    private static final int ELEMENT_ID_REPEAT_MODE;
    private static final int ELEMENT_ID_MIX_MODE;
    private static final int ELEMENT_ID_PMLTMODE;
    private Map map = new HashMap();

    public MediaPlayModeContainer(MediaRepeatModeEnumeration mediaRepeatModeEnumeration, boolean bl, boolean bl2) {
        this.map.put(new Integer(63), mediaRepeatModeEnumeration);
        this.map.put(new Integer(64), new Boolean(bl));
        this.map.put(new Integer(78), new Boolean(bl2));
    }

    public MediaPlayModeContainer(MediaPlayModeContainer mediaPlayModeContainer) {
        this.map.putAll(mediaPlayModeContainer.map);
    }

    public MediaPlayModeContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 63: {
                    this.map.put(new Integer(63), MediaRepeatModeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 64: {
                    this.map.put(new Integer(64), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block5;
                }
                case 78: {
                    this.map.put(new Integer(78), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block5;
                }
            }
        }
    }

    public MediaRepeatModeEnumeration getRepeatMode() {
        return (MediaRepeatModeEnumeration)this.map.get(new Integer(63));
    }

    public boolean getMixMode() {
        return (Boolean)this.map.get(new Integer(64));
    }

    public boolean getPMLTMode() {
        return (Boolean)this.map.get(new Integer(78));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(24, n2, n, this.createElements(), n3));
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
                case 63: {
                    hASDataElementArray[n++] = new IntegerElement(63, ((MediaRepeatModeEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 64: {
                    hASDataElementArray[n++] = new BooleanElement(64, (boolean)((Boolean)map$Entry.getValue()));
                    break;
                }
                case 78: {
                    hASDataElementArray[n++] = new BooleanElement(78, (boolean)((Boolean)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaPlayModeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 63: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("repeatMode(MediaRepeatModeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("repeatMode(MediaRepeatModeEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 64: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("mixMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("mixMode(boolean)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 78: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("pMLTMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("pMLTMode(boolean)='");
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
        MediaPlayModeContainer mediaPlayModeContainer = new MediaPlayModeContainer(this);
        return mediaPlayModeContainer;
    }
}

