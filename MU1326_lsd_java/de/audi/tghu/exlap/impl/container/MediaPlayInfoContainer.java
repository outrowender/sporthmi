/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.LongElement;
import de.audi.tghu.exlap.ifc.enumeration.MediaEntryTypeEnumeration;
import de.audi.tghu.exlap.ifc.enumeration.MediaPlayStateEnumeration;
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

public class MediaPlayInfoContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_PLAY_INFO;
    private static final int ELEMENT_ID_STATE;
    private static final int ELEMENT_ID_TRACK_POSITION;
    private static final int ELEMENT_ID_ENTRY_TYPE;
    private static final int ELEMENT_ID_ENTRY_ID;
    private Map map = new HashMap();

    public MediaPlayInfoContainer(MediaPlayStateEnumeration mediaPlayStateEnumeration) {
        this.map.put(new Integer(66), mediaPlayStateEnumeration);
    }

    public MediaPlayInfoContainer(MediaPlayInfoContainer mediaPlayInfoContainer) {
        this.map.putAll(mediaPlayInfoContainer.map);
    }

    public MediaPlayInfoContainer(HASDataElement[] hASDataElementArray) {
        block6: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 66: {
                    this.map.put(new Integer(66), MediaPlayStateEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 45: {
                    this.map.put(new Integer(45), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 60: {
                    this.map.put(new Integer(60), MediaEntryTypeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 46: {
                    this.map.put(new Integer(46), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
            }
        }
    }

    public MediaPlayStateEnumeration getState() {
        return (MediaPlayStateEnumeration)this.map.get(new Integer(66));
    }

    public MediaPlayInfoContainer setTrackPosition(int n) {
        this.map.put(new Integer(45), new Long(n));
        return this;
    }

    public boolean isSetTrackPosition() {
        return this.map.containsKey(new Integer(45));
    }

    public int getTrackPosition() {
        return ((Long)this.map.get(new Integer(45))).intValue();
    }

    public MediaPlayInfoContainer setEntryType(MediaEntryTypeEnumeration mediaEntryTypeEnumeration) {
        this.map.put(new Integer(60), mediaEntryTypeEnumeration);
        return this;
    }

    public boolean isSetEntryType() {
        return this.map.containsKey(new Integer(60));
    }

    public MediaEntryTypeEnumeration getEntryType() {
        return (MediaEntryTypeEnumeration)this.map.get(new Integer(60));
    }

    public MediaPlayInfoContainer setEntryId(long l) {
        this.map.put(new Integer(46), new Long(l));
        return this;
    }

    public boolean isSetEntryId() {
        return this.map.containsKey(new Integer(46));
    }

    public long getEntryId() {
        return (Long)this.map.get(new Integer(46));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(23, n2, n, this.createElements(), n3));
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
                case 66: {
                    hASDataElementArray[n++] = new IntegerElement(66, ((MediaPlayStateEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 45: {
                    hASDataElementArray[n++] = new IntegerElement(45, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
                case 60: {
                    hASDataElementArray[n++] = new IntegerElement(60, ((MediaEntryTypeEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 46: {
                    hASDataElementArray[n++] = new LongElement(46, (long)((Long)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaPlayInfoContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 66: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("state(MediaPlayStateEnumeration)=null");
                        break;
                    }
                    stringWriter.write("state(MediaPlayStateEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 45: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("trackPosition(int)=null");
                        break;
                    }
                    stringWriter.write("trackPosition(int)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 60: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("entryType(MediaEntryTypeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("entryType(MediaEntryTypeEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 46: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("entryId(long)=null");
                        break;
                    }
                    stringWriter.write("entryId(long)='");
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
        MediaPlayInfoContainer mediaPlayInfoContainer = new MediaPlayInfoContainer(this);
        return mediaPlayInfoContainer;
    }
}

