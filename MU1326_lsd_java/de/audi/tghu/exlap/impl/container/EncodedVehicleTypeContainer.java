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
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class EncodedVehicleTypeContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_ENCODED_VEHICLE_TYPE = 53;
    private static final int ELEMENT_ID_TYPE = 123;
    private static final int ELEMENT_ID_STICKER_BITS = 145;
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

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(53, n2, n, this.createElements(), n3));
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
                case 123: {
                    hASDataElementArray[n++] = new StringElement(123, (String)entry.getValue());
                    break;
                }
                case 145: {
                    hASDataElementArray[n++] = new IntegerElement(145, ((Long)entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("EncodedVehicleTypeContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 123: {
                    if (entry.getValue() == null) {
                        stringWriter.write("type(String)=null");
                        break;
                    }
                    stringWriter.write("type(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 145: {
                    if (entry.getValue() == null) {
                        stringWriter.write("stickerBits(int)=null");
                        break;
                    }
                    stringWriter.write("stickerBits(int)='");
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
        EncodedVehicleTypeContainer encodedVehicleTypeContainer = new EncodedVehicleTypeContainer(this);
        return encodedVehicleTypeContainer;
    }
}

