/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

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

public class VehicleIdentificationNumberContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_VEHICLE_IDENTIFICATION_NUMBER = 10;
    private static final int ELEMENT_ID_VEHICLE_IDENTIFICATION_NUMBER = 22;
    private Map map = new HashMap();

    public VehicleIdentificationNumberContainer(String string) {
        this.map.put(new Integer(22), string);
    }

    public VehicleIdentificationNumberContainer(VehicleIdentificationNumberContainer vehicleIdentificationNumberContainer) {
        this.map.putAll(vehicleIdentificationNumberContainer.map);
    }

    public VehicleIdentificationNumberContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 22: {
                    this.map.put(new Integer(22), hASDataElementArray[i2].stringData);
                    continue block3;
                }
            }
        }
    }

    public String getVehicleIdentificationNumber() {
        return (String)this.map.get(new Integer(22));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(10, n2, n, this.createElements(), n3));
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
                case 22: {
                    hASDataElementArray[n++] = new StringElement(22, (String)entry.getValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("VehicleIdentificationNumberContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 22: {
                    if (entry.getValue() == null) {
                        stringWriter.write("vehicleIdentificationNumber(String)=null");
                        break;
                    }
                    stringWriter.write("vehicleIdentificationNumber(String)='");
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
        VehicleIdentificationNumberContainer vehicleIdentificationNumberContainer = new VehicleIdentificationNumberContainer(this);
        return vehicleIdentificationNumberContainer;
    }
}

