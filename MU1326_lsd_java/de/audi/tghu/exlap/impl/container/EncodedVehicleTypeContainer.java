/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.StringElement;
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

public class EncodedVehicleTypeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_ENCODED_VEHICLE_TYPE;
    private static final int ELEMENT_ID_TYPE;
    private static final int ELEMENT_ID_STICKER_BITS;
    private Map map = new HashMap();

    public EncodedVehicleTypeContainer(String string) {
        this.map.put(new Integer(123), string);
    }

    public EncodedVehicleTypeContainer(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        this.map.putAll(encodedVehicleTypeContainer.map);
    }

    public EncodedVehicleTypeContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 123: {
                    this.map.put(new Integer(123), hASDataElementArray[i2].stringData);
                    continue block4;
                }
                case 145: {
                    this.map.put(new Integer(145), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public String getType() {
        return (String)this.map.get(new Integer(123));
    }

    public EncodedVehicleTypeContainer setStickerBits(int n) {
        this.map.put(new Integer(145), new Long(n));
        return this;
    }

    public boolean isSetStickerBits() {
        return this.map.containsKey(new Integer(145));
    }

    public int getStickerBits() {
        return ((Long)this.map.get(new Integer(145))).intValue();
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(53, n2, n, this.createElements(), n3));
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
                case 123: {
                    hASDataElementArray[n++] = new StringElement(123, (String)map$Entry.getValue());
                    break;
                }
                case 145: {
                    hASDataElementArray[n++] = new IntegerElement(145, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("EncodedVehicleTypeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 123: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("type(String)=null");
                        break;
                    }
                    stringWriter.write("type(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 145: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("stickerBits(int)=null");
                        break;
                    }
                    stringWriter.write("stickerBits(int)='");
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
        EncodedVehicleTypeContainer encodedVehicleTypeContainer = new EncodedVehicleTypeContainer(this);
        return encodedVehicleTypeContainer;
    }
}

