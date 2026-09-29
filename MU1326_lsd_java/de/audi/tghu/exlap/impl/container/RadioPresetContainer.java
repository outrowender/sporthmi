/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.ResourceElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
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

public class RadioPresetContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_PRESET;
    private static final int ELEMENT_ID_PRESET_LOGO;
    private Map map = new HashMap();
    private RadioStationInfoContainer station;

    public RadioPresetContainer() {
    }

    public RadioPresetContainer(RadioPresetContainer radioPresetContainer) {
        this.map.putAll(radioPresetContainer.map);
        this.station = (RadioStationInfoContainer)radioPresetContainer.station.clone();
    }

    public RadioPresetContainer(HASDataElement[] hASDataElementArray) {
        block3: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 89: {
                    this.map.put(new Integer(89), hASDataElementArray[i2].resourceLocator);
                    continue block3;
                }
            }
        }
    }

    public RadioPresetContainer setPresetLogo(ResourceLocator resourceLocator) {
        this.map.put(new Integer(89), resourceLocator);
        return this;
    }

    public boolean isSetPresetLogo() {
        return this.map.containsKey(new Integer(89));
    }

    public ResourceLocator getPresetLogo() {
        return (ResourceLocator)this.map.get(new Integer(89));
    }

    public RadioPresetContainer setStation(RadioStationInfoContainer radioStationInfoContainer) {
        this.station = radioStationInfoContainer;
        return this;
    }

    public RadioStationInfoContainer getStation() {
        return this.station;
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(40, n2, n, this.createElements(), n3));
        if (this.station != null) {
            List list = this.station.createContainer(n2, n4, 90);
            n4 += list.size();
            arrayList.addAll(list);
        }
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
                case 89: {
                    hASDataElementArray[n++] = new ResourceElement(89, (ResourceLocator)map$Entry.getValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioPresetContainer(");
        stringWriter.write("station(RadioStationInfoContainer)='");
        if (this.station != null) {
            this.station.toString(stringWriter);
        } else {
            stringWriter.write("null");
        }
        stringWriter.write("'");
        if (!this.map.isEmpty()) {
            stringWriter.write(", ");
        }
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 89: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("presetLogo(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("presetLogo(ResourceLocator)='");
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
        RadioPresetContainer radioPresetContainer = new RadioPresetContainer(this);
        return radioPresetContainer;
    }
}

