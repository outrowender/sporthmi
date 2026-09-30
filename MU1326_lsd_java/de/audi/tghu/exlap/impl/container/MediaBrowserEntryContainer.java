/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.LongElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.MediaEntryTypeEnumeration;
import de.audi.tghu.exlap.ifc.enumeration.NotPlayableReasonEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaBrowserEntryContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_BROWSER_ENTRY = 21;
    private static final int ELEMENT_ID_DISPLAY_TEXT = 35;
    private static final int ELEMENT_ID_ENTRY_TYPE = 36;
    private static final int ELEMENT_ID_ENTRY_ID = 37;
    private static final int ELEMENT_ID_FILENAME = 99;
    private static final int ELEMENT_ID_NOT_PLAYABLE_REASON = 126;
    private Map map = new HashMap();
    private TrackInfoContainer trackInfo;

    public MediaBrowserEntryContainer(String string, MediaEntryTypeEnumeration mediaEntryTypeEnumeration, long l) {
        this.map.put(new Integer(35), string);
        this.map.put(new Integer(36), mediaEntryTypeEnumeration);
        this.map.put(new Integer(37), new Long(l));
    }

    public MediaBrowserEntryContainer(MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        this.map.putAll(mediaBrowserEntryContainer.map);
        this.trackInfo = (TrackInfoContainer)mediaBrowserEntryContainer.trackInfo.clone();
    }

    public MediaBrowserEntryContainer(HASDataElement[] hASDataElementArray) {
        block7: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 35: {
                    this.map.put(new Integer(35), hASDataElementArray[i2].stringData);
                    continue block7;
                }
                case 36: {
                    this.map.put(new Integer(36), MediaEntryTypeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block7;
                }
                case 37: {
                    this.map.put(new Integer(37), new Long(hASDataElementArray[i2].numericData));
                    continue block7;
                }
                case 99: {
                    this.map.put(new Integer(99), hASDataElementArray[i2].stringData);
                    continue block7;
                }
                case 126: {
                    this.map.put(new Integer(126), NotPlayableReasonEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block7;
                }
            }
        }
    }

    public String getDisplayText() {
        return (String)this.map.get(new Integer(35));
    }

    public MediaEntryTypeEnumeration getEntryType() {
        return (MediaEntryTypeEnumeration)this.map.get(new Integer(36));
    }

    public long getEntryId() {
        return (Long)this.map.get(new Integer(37));
    }

    public MediaBrowserEntryContainer setFilename(String string) {
        this.map.put(new Integer(99), string);
        return this;
    }

    public boolean isSetFilename() {
        return this.map.containsKey(new Integer(99));
    }

    public String getFilename() {
        return (String)this.map.get(new Integer(99));
    }

    public MediaBrowserEntryContainer setNotPlayableReason(NotPlayableReasonEnumeration notPlayableReasonEnumeration) {
        this.map.put(new Integer(126), notPlayableReasonEnumeration);
        return this;
    }

    public boolean isSetNotPlayableReason() {
        return this.map.containsKey(new Integer(126));
    }

    public NotPlayableReasonEnumeration getNotPlayableReason() {
        return (NotPlayableReasonEnumeration)this.map.get(new Integer(126));
    }

    public MediaBrowserEntryContainer setTrackInfo(TrackInfoContainer trackInfoContainer) {
        this.trackInfo = trackInfoContainer;
        return this;
    }

    public TrackInfoContainer getTrackInfo() {
        return this.trackInfo;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(21, n2, n, this.createElements(), n3));
        if (this.trackInfo != null) {
            List list = this.trackInfo.createContainer(n2, n4, 38);
            n4 += list.size();
            arrayList.addAll(list);
        }
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
                case 35: {
                    hASDataElementArray[n++] = new StringElement(35, (String)entry.getValue());
                    break;
                }
                case 36: {
                    hASDataElementArray[n++] = new IntegerElement(36, ((MediaEntryTypeEnumeration)entry.getValue()).ordinal());
                    break;
                }
                case 37: {
                    hASDataElementArray[n++] = new LongElement(37, (long)((Long)entry.getValue()));
                    break;
                }
                case 99: {
                    hASDataElementArray[n++] = new StringElement(99, (String)entry.getValue());
                    break;
                }
                case 126: {
                    hASDataElementArray[n++] = new IntegerElement(126, ((NotPlayableReasonEnumeration)entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaBrowserEntryContainer(");
        stringWriter.write("trackInfo(TrackInfoContainer)='");
        if (this.trackInfo != null) {
            this.trackInfo.toString(stringWriter);
        } else {
            stringWriter.write("null");
        }
        stringWriter.write("'");
        if (!this.map.isEmpty()) {
            stringWriter.write(", ");
        }
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 35: {
                    if (entry.getValue() == null) {
                        stringWriter.write("displayText(String)=null");
                        break;
                    }
                    stringWriter.write("displayText(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 36: {
                    if (entry.getValue() == null) {
                        stringWriter.write("entryType(MediaEntryTypeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("entryType(MediaEntryTypeEnumeration)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 37: {
                    if (entry.getValue() == null) {
                        stringWriter.write("entryId(long)=null");
                        break;
                    }
                    stringWriter.write("entryId(long)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 99: {
                    if (entry.getValue() == null) {
                        stringWriter.write("filename(String)=null");
                        break;
                    }
                    stringWriter.write("filename(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 126: {
                    if (entry.getValue() == null) {
                        stringWriter.write("notPlayableReason(NotPlayableReasonEnumeration)=null");
                        break;
                    }
                    stringWriter.write("notPlayableReason(NotPlayableReasonEnumeration)='");
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
        MediaBrowserEntryContainer mediaBrowserEntryContainer = new MediaBrowserEntryContainer(this);
        return mediaBrowserEntryContainer;
    }
}

