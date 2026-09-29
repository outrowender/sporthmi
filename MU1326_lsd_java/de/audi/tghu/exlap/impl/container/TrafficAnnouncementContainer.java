/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.LongElement;
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

public class TrafficAnnouncementContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_TRAFFIC_ANNOUNCEMENT;
    private static final int ELEMENT_ID_ACTIVE;
    private static final int ELEMENT_ID_STATION_NAME;
    private static final int ELEMENT_ID_FREQUENCY;
    private Map map = new HashMap();

    public TrafficAnnouncementContainer(boolean bl) {
        this.map.put(new Integer(111), new Boolean(bl));
    }

    public TrafficAnnouncementContainer(TrafficAnnouncementContainer trafficAnnouncementContainer) {
        this.map.putAll(trafficAnnouncementContainer.map);
    }

    public TrafficAnnouncementContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 111: {
                    this.map.put(new Integer(111), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block5;
                }
                case 112: {
                    this.map.put(new Integer(112), hASDataElementArray[i2].stringData);
                    continue block5;
                }
                case 113: {
                    this.map.put(new Integer(113), new Long(hASDataElementArray[i2].numericData));
                    continue block5;
                }
            }
        }
    }

    public boolean getActive() {
        return (Boolean)this.map.get(new Integer(111));
    }

    public TrafficAnnouncementContainer setStationName(String string) {
        this.map.put(new Integer(112), string);
        return this;
    }

    public boolean isSetStationName() {
        return this.map.containsKey(new Integer(112));
    }

    public String getStationName() {
        return (String)this.map.get(new Integer(112));
    }

    public TrafficAnnouncementContainer setFrequency(long l) {
        this.map.put(new Integer(113), new Long(l));
        return this;
    }

    public boolean isSetFrequency() {
        return this.map.containsKey(new Integer(113));
    }

    public long getFrequency() {
        return (Long)this.map.get(new Integer(113));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(51, n2, n, this.createElements(), n3));
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
                case 111: {
                    hASDataElementArray[n++] = new BooleanElement(111, (boolean)((Boolean)map$Entry.getValue()));
                    break;
                }
                case 112: {
                    hASDataElementArray[n++] = new StringElement(112, (String)map$Entry.getValue());
                    break;
                }
                case 113: {
                    hASDataElementArray[n++] = new LongElement(113, (long)((Long)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("TrafficAnnouncementContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 111: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("active(boolean)=null");
                        break;
                    }
                    stringWriter.write("active(boolean)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 112: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("stationName(String)=null");
                        break;
                    }
                    stringWriter.write("stationName(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 113: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("frequency(long)=null");
                        break;
                    }
                    stringWriter.write("frequency(long)='");
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
        TrafficAnnouncementContainer trafficAnnouncementContainer = new TrafficAnnouncementContainer(this);
        return trafficAnnouncementContainer;
    }
}

