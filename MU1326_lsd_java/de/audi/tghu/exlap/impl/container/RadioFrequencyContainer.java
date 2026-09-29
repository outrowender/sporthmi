/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.LongElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.RadioBandEnumeration;
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

public class RadioFrequencyContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_FREQUENCY;
    private static final int ELEMENT_ID_BAND;
    private static final int ELEMENT_ID_FREQUENCY;
    private static final int ELEMENT_ID_FREQUENCY_LABEL;
    private Map map = new HashMap();

    public RadioFrequencyContainer() {
    }

    public RadioFrequencyContainer(RadioFrequencyContainer radioFrequencyContainer) {
        this.map.putAll(radioFrequencyContainer.map);
    }

    public RadioFrequencyContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 94: {
                    this.map.put(new Integer(94), RadioBandEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 95: {
                    this.map.put(new Integer(95), new Long(hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 96: {
                    this.map.put(new Integer(96), hASDataElementArray[i2].stringData);
                    continue block5;
                }
            }
        }
    }

    public RadioFrequencyContainer setBand(RadioBandEnumeration radioBandEnumeration) {
        this.map.put(new Integer(94), radioBandEnumeration);
        return this;
    }

    public boolean isSetBand() {
        return this.map.containsKey(new Integer(94));
    }

    public RadioBandEnumeration getBand() {
        return (RadioBandEnumeration)this.map.get(new Integer(94));
    }

    public RadioFrequencyContainer setFrequency(long l) {
        this.map.put(new Integer(95), new Long(l));
        return this;
    }

    public boolean isSetFrequency() {
        return this.map.containsKey(new Integer(95));
    }

    public long getFrequency() {
        return (Long)this.map.get(new Integer(95));
    }

    public RadioFrequencyContainer setFrequencyLabel(String string) {
        this.map.put(new Integer(96), string);
        return this;
    }

    public boolean isSetFrequencyLabel() {
        return this.map.containsKey(new Integer(96));
    }

    public String getFrequencyLabel() {
        return (String)this.map.get(new Integer(96));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(43, n2, n, this.createElements(), n3));
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
                case 94: {
                    hASDataElementArray[n++] = new IntegerElement(94, ((RadioBandEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 95: {
                    hASDataElementArray[n++] = new LongElement(95, (long)((Long)map$Entry.getValue()));
                    break;
                }
                case 96: {
                    hASDataElementArray[n++] = new StringElement(96, (String)map$Entry.getValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioFrequencyContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 94: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("band(RadioBandEnumeration)=null");
                        break;
                    }
                    stringWriter.write("band(RadioBandEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 95: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("frequency(long)=null");
                        break;
                    }
                    stringWriter.write("frequency(long)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 96: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("frequencyLabel(String)=null");
                        break;
                    }
                    stringWriter.write("frequencyLabel(String)='");
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
        RadioFrequencyContainer radioFrequencyContainer = new RadioFrequencyContainer(this);
        return radioFrequencyContainer;
    }
}

