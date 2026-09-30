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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioTextContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_TEXT = 52;
    private static final int ELEMENT_ID_RADIO_TEXT = 114;
    private static final int ELEMENT_ID_ARTIST = 115;
    private static final int ELEMENT_ID_ALBUM = 116;
    private static final int ELEMENT_ID_TITLE = 117;
    private static final int ELEMENT_ID_RADIO_IMAGE = 118;
    private static final int ELEMENT_ID_RADIO_IMAGE_AVAILABLE = 119;
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

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(52, n2, n, this.createElements(), n3));
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
                case 114: {
                    hASDataElementArray[n++] = new StringElement(114, (String)entry.getValue());
                    break;
                }
                case 115: {
                    hASDataElementArray[n++] = new StringElement(115, (String)entry.getValue());
                    break;
                }
                case 116: {
                    hASDataElementArray[n++] = new StringElement(116, (String)entry.getValue());
                    break;
                }
                case 117: {
                    hASDataElementArray[n++] = new StringElement(117, (String)entry.getValue());
                    break;
                }
                case 118: {
                    hASDataElementArray[n++] = new ResourceElement(118, (ResourceLocator)entry.getValue());
                    break;
                }
                case 119: {
                    hASDataElementArray[n++] = new BooleanElement(119, (boolean)((Boolean)entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioTextContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 114: {
                    if (entry.getValue() == null) {
                        stringWriter.write("radioText(String)=null");
                        break;
                    }
                    stringWriter.write("radioText(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 115: {
                    if (entry.getValue() == null) {
                        stringWriter.write("artist(String)=null");
                        break;
                    }
                    stringWriter.write("artist(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 116: {
                    if (entry.getValue() == null) {
                        stringWriter.write("album(String)=null");
                        break;
                    }
                    stringWriter.write("album(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 117: {
                    if (entry.getValue() == null) {
                        stringWriter.write("title(String)=null");
                        break;
                    }
                    stringWriter.write("title(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 118: {
                    if (entry.getValue() == null) {
                        stringWriter.write("radioImage(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("radioImage(ResourceLocator)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 119: {
                    if (entry.getValue() == null) {
                        stringWriter.write("radioImageAvailable(boolean)=null");
                        break;
                    }
                    stringWriter.write("radioImageAvailable(boolean)='");
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
        RadioTextContainer radioTextContainer = new RadioTextContainer(this);
        return radioTextContainer;
    }
}

