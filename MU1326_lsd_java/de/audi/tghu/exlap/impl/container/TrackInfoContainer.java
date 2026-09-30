/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.ResourceElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class TrackInfoContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_TRACK_INFO = 22;
    private static final int ELEMENT_ID_TITLE = 39;
    private static final int ELEMENT_ID_ARTIST = 40;
    private static final int ELEMENT_ID_ALBUM = 41;
    private static final int ELEMENT_ID_COVER = 42;
    private static final int ELEMENT_ID_LENGTH = 43;
    private static final int ELEMENT_ID_TRACK_NUMBER = 67;
    private Map map = new HashMap();

    public TrackInfoContainer() {
    }

    public TrackInfoContainer(TrackInfoContainer trackInfoContainer) {
        this.map.putAll(trackInfoContainer.map);
    }

    public TrackInfoContainer(HASDataElement[] hASDataElementArray) {
        block8: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 39: {
                    this.map.put(new Integer(39), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 40: {
                    this.map.put(new Integer(40), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 41: {
                    this.map.put(new Integer(41), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 42: {
                    this.map.put(new Integer(42), hASDataElementArray[i2].resourceLocator);
                    continue block8;
                }
                case 43: {
                    this.map.put(new Integer(43), new Long(hASDataElementArray[i2].numericData));
                    continue block8;
                }
                case 67: {
                    this.map.put(new Integer(67), new Long(hASDataElementArray[i2].numericData));
                    continue block8;
                }
            }
        }
    }

    public TrackInfoContainer setTitle(String string) {
        this.map.put(new Integer(39), string);
        return this;
    }

    public boolean isSetTitle() {
        return this.map.containsKey(new Integer(39));
    }

    public String getTitle() {
        return (String)this.map.get(new Integer(39));
    }

    public TrackInfoContainer setArtist(String string) {
        this.map.put(new Integer(40), string);
        return this;
    }

    public boolean isSetArtist() {
        return this.map.containsKey(new Integer(40));
    }

    public String getArtist() {
        return (String)this.map.get(new Integer(40));
    }

    public TrackInfoContainer setAlbum(String string) {
        this.map.put(new Integer(41), string);
        return this;
    }

    public boolean isSetAlbum() {
        return this.map.containsKey(new Integer(41));
    }

    public String getAlbum() {
        return (String)this.map.get(new Integer(41));
    }

    public TrackInfoContainer setCover(ResourceLocator resourceLocator) {
        this.map.put(new Integer(42), resourceLocator);
        return this;
    }

    public boolean isSetCover() {
        return this.map.containsKey(new Integer(42));
    }

    public ResourceLocator getCover() {
        return (ResourceLocator)this.map.get(new Integer(42));
    }

    public TrackInfoContainer setLength(int n) {
        this.map.put(new Integer(43), new Long(n));
        return this;
    }

    public boolean isSetLength() {
        return this.map.containsKey(new Integer(43));
    }

    public int getLength() {
        return ((Long)this.map.get(new Integer(43))).intValue();
    }

    public TrackInfoContainer setTrackNumber(int n) {
        this.map.put(new Integer(67), new Long(n));
        return this;
    }

    public boolean isSetTrackNumber() {
        return this.map.containsKey(new Integer(67));
    }

    public int getTrackNumber() {
        return ((Long)this.map.get(new Integer(67))).intValue();
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(22, n2, n, this.createElements(), n3));
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
                case 39: {
                    hASDataElementArray[n++] = new StringElement(39, (String)entry.getValue());
                    break;
                }
                case 40: {
                    hASDataElementArray[n++] = new StringElement(40, (String)entry.getValue());
                    break;
                }
                case 41: {
                    hASDataElementArray[n++] = new StringElement(41, (String)entry.getValue());
                    break;
                }
                case 42: {
                    hASDataElementArray[n++] = new ResourceElement(42, (ResourceLocator)entry.getValue());
                    break;
                }
                case 43: {
                    hASDataElementArray[n++] = new IntegerElement(43, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 67: {
                    hASDataElementArray[n++] = new IntegerElement(67, ((Long)entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("TrackInfoContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 39: {
                    if (entry.getValue() == null) {
                        stringWriter.write("title(String)=null");
                        break;
                    }
                    stringWriter.write("title(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 40: {
                    if (entry.getValue() == null) {
                        stringWriter.write("artist(String)=null");
                        break;
                    }
                    stringWriter.write("artist(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 41: {
                    if (entry.getValue() == null) {
                        stringWriter.write("album(String)=null");
                        break;
                    }
                    stringWriter.write("album(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 42: {
                    if (entry.getValue() == null) {
                        stringWriter.write("cover(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("cover(ResourceLocator)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 43: {
                    if (entry.getValue() == null) {
                        stringWriter.write("length(int)=null");
                        break;
                    }
                    stringWriter.write("length(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 67: {
                    if (entry.getValue() == null) {
                        stringWriter.write("trackNumber(int)=null");
                        break;
                    }
                    stringWriter.write("trackNumber(int)='");
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
        TrackInfoContainer trackInfoContainer = new TrackInfoContainer(this);
        return trackInfoContainer;
    }
}

