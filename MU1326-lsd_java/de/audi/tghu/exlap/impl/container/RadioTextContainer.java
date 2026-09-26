/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.ResourceElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioTextContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_TEXT;
    private static final int ELEMENT_ID_RADIO_TEXT;
    private static final int ELEMENT_ID_ARTIST;
    private static final int ELEMENT_ID_ALBUM;
    private static final int ELEMENT_ID_TITLE;
    private static final int ELEMENT_ID_RADIO_IMAGE;
    private static final int ELEMENT_ID_RADIO_IMAGE_AVAILABLE;
    private Map map = new HashMap();

    public RadioTextContainer() {
    }

    public RadioTextContainer(RadioTextContainer radioTextContainer) {
        this.map.putAll(radioTextContainer.map);
    }

    public RadioTextContainer(HASDataElement[] hASDataElementArray) {
        block8: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 114: {
                    this.map.put(new Integer(114), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 115: {
                    this.map.put(new Integer(115), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 116: {
                    this.map.put(new Integer(116), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 117: {
                    this.map.put(new Integer(117), hASDataElementArray[i2].stringData);
                    continue block8;
                }
                case 118: {
                    this.map.put(new Integer(118), hASDataElementArray[i2].resourceLocator);
                    continue block8;
                }
                case 119: {
                    this.map.put(new Integer(119), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block8;
                }
            }
        }
    }

    public RadioTextContainer setRadioText(String string) {
        this.map.put(new Integer(114), string);
        return this;
    }

    public boolean isSetRadioText() {
        return this.map.containsKey(new Integer(114));
    }

    public String getRadioText() {
        return (String)this.map.get(new Integer(114));
    }

    public RadioTextContainer setArtist(String string) {
        this.map.put(new Integer(115), string);
        return this;
    }

    public boolean isSetArtist() {
        return this.map.containsKey(new Integer(115));
    }

    public String getArtist() {
        return (String)this.map.get(new Integer(115));
    }

    public RadioTextContainer setAlbum(String string) {
        this.map.put(new Integer(116), string);
        return this;
    }

    public boolean isSetAlbum() {
        return this.map.containsKey(new Integer(116));
    }

    public String getAlbum() {
        return (String)this.map.get(new Integer(116));
    }

    public RadioTextContainer setTitle(String string) {
        this.map.put(new Integer(117), string);
        return this;
    }

    public boolean isSetTitle() {
        return this.map.containsKey(new Integer(117));
    }

    public String getTitle() {
        return (String)this.map.get(new Integer(117));
    }

    public RadioTextContainer setRadioImage(ResourceLocator resourceLocator) {
        this.map.put(new Integer(118), resourceLocator);
        return this;
    }

    public boolean isSetRadioImage() {
        return this.map.containsKey(new Integer(118));
    }

    public ResourceLocator getRadioImage() {
        return (ResourceLocator)this.map.get(new Integer(118));
    }

    public RadioTextContainer setRadioImageAvailable(boolean bl) {
        this.map.put(new Integer(119), new Boolean(bl));
        return this;
    }

    public boolean isSetRadioImageAvailable() {
        return this.map.containsKey(new Integer(119));
    }

    public boolean getRadioImageAvailable() {
        return (Boolean)this.map.get(new Integer(119));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(52, n2, n, this.createElements(), n3));
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
                case 114: {
                    hASDataElementArray[n++] = new StringElement(114, (String)map$Entry.getValue());
                    break;
                }
                case 115: {
                    hASDataElementArray[n++] = new StringElement(115, (String)map$Entry.getValue());
                    break;
                }
                case 116: {
                    hASDataElementArray[n++] = new StringElement(116, (String)map$Entry.getValue());
                    break;
                }
                case 117: {
                    hASDataElementArray[n++] = new StringElement(117, (String)map$Entry.getValue());
                    break;
                }
                case 118: {
                    hASDataElementArray[n++] = new ResourceElement(118, (ResourceLocator)map$Entry.getValue());
                    break;
                }
                case 119: {
                    hASDataElementArray[n++] = new BooleanElement(119, (boolean)((Boolean)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioTextContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 114: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("radioText(String)=null");
                        break;
                    }
                    stringWriter.write("radioText(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 115: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("artist(String)=null");
                        break;
                    }
                    stringWriter.write("artist(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 116: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("album(String)=null");
                        break;
                    }
                    stringWriter.write("album(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 117: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("title(String)=null");
                        break;
                    }
                    stringWriter.write("title(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 118: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("radioImage(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("radioImage(ResourceLocator)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 119: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("radioImageAvailable(boolean)=null");
                        break;
                    }
                    stringWriter.write("radioImageAvailable(boolean)='");
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
        RadioTextContainer radioTextContainer = new RadioTextContainer(this);
        return radioTextContainer;
    }
}

