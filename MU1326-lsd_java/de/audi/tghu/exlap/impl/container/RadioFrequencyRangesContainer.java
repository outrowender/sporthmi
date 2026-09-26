/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.RadioAMFrequenciesEnumeration;
import de.audi.tghu.exlap.ifc.enumeration.RadioFMFrequenciesEnumeration;
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

public class RadioFrequencyRangesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_FREQUENCY_RANGES;
    private static final int ELEMENT_ID_AMRANGE;
    private static final int ELEMENT_ID_FMRANGE;
    private Map map = new HashMap();

    public RadioFrequencyRangesContainer() {
    }

    public RadioFrequencyRangesContainer(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        this.map.putAll(radioFrequencyRangesContainer.map);
    }

    public RadioFrequencyRangesContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 92: {
                    this.map.put(new Integer(92), RadioAMFrequenciesEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block4;
                }
                case 93: {
                    this.map.put(new Integer(93), RadioFMFrequenciesEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public RadioFrequencyRangesContainer setAMRange(RadioAMFrequenciesEnumeration radioAMFrequenciesEnumeration) {
        this.map.put(new Integer(92), radioAMFrequenciesEnumeration);
        return this;
    }

    public boolean isSetAMRange() {
        return this.map.containsKey(new Integer(92));
    }

    public RadioAMFrequenciesEnumeration getAMRange() {
        return (RadioAMFrequenciesEnumeration)this.map.get(new Integer(92));
    }

    public RadioFrequencyRangesContainer setFMRange(RadioFMFrequenciesEnumeration radioFMFrequenciesEnumeration) {
        this.map.put(new Integer(93), radioFMFrequenciesEnumeration);
        return this;
    }

    public boolean isSetFMRange() {
        return this.map.containsKey(new Integer(93));
    }

    public RadioFMFrequenciesEnumeration getFMRange() {
        return (RadioFMFrequenciesEnumeration)this.map.get(new Integer(93));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(42, n2, n, this.createElements(), n3));
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
                case 92: {
                    hASDataElementArray[n++] = new IntegerElement(92, ((RadioAMFrequenciesEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 93: {
                    hASDataElementArray[n++] = new IntegerElement(93, ((RadioFMFrequenciesEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioFrequencyRangesContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 92: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("aMRange(RadioAMFrequenciesEnumeration)=null");
                        break;
                    }
                    stringWriter.write("aMRange(RadioAMFrequenciesEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 93: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("fMRange(RadioFMFrequenciesEnumeration)=null");
                        break;
                    }
                    stringWriter.write("fMRange(RadioFMFrequenciesEnumeration)='");
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
        RadioFrequencyRangesContainer radioFrequencyRangesContainer = new RadioFrequencyRangesContainer(this);
        return radioFrequencyRangesContainer;
    }
}

