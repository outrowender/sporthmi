/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.LongElement;
import de.audi.tghu.exlap.dsi.ResourceElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.RadioBandEnumeration;
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

public class RadioStationInfoContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_STATION_INFO = 26;
    private static final int ELEMENT_ID_NAME = 51;
    private static final int ELEMENT_ID_FREQUENCY = 52;
    private static final int ELEMENT_ID_BAND = 53;
    private static final int ELEMENT_ID_PICODE = 54;
    private static final int ELEMENT_ID_SHORT_NAME = 79;
    private static final int ELEMENT_ID_RDS = 80;
    private static final int ELEMENT_ID_TP = 81;
    private static final int ELEMENT_ID_FREQUENCY_LABEL = 82;
    private static final int ELEMENT_ID_SERVICE_ID = 83;
    private static final int ELEMENT_ID_ENSEMBLE_ID = 84;
    private static final int ELEMENT_ID_EXTENDED_COUNTRY_CODE = 85;
    private static final int ELEMENT_ID_SERVICE_COMPONENT_ID = 86;
    private static final int ELEMENT_ID_STATION_LOGO = 87;
    private static final int ELEMENT_ID_FMLINKING_ACTIVE = 120;
    private Map map = new HashMap();

    public RadioStationInfoContainer() {
    }

    public RadioStationInfoContainer(RadioStationInfoContainer radioStationInfoContainer) {
        this.map.putAll(radioStationInfoContainer.map);
    }

    public RadioStationInfoContainer(HASDataElement[] hASDataElementArray) {
        block16: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 51: {
                    this.map.put(new Integer(51), hASDataElementArray[i2].stringData);
                    continue block16;
                }
                case 52: {
                    this.map.put(new Integer(52), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 53: {
                    this.map.put(new Integer(53), RadioBandEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 54: {
                    this.map.put(new Integer(54), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 79: {
                    this.map.put(new Integer(79), hASDataElementArray[i2].stringData);
                    continue block16;
                }
                case 80: {
                    this.map.put(new Integer(80), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block16;
                }
                case 81: {
                    this.map.put(new Integer(81), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block16;
                }
                case 82: {
                    this.map.put(new Integer(82), hASDataElementArray[i2].stringData);
                    continue block16;
                }
                case 83: {
                    this.map.put(new Integer(83), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 84: {
                    this.map.put(new Integer(84), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 85: {
                    this.map.put(new Integer(85), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 86: {
                    this.map.put(new Integer(86), new Long(hASDataElementArray[i2].numericData));
                    continue block16;
                }
                case 87: {
                    this.map.put(new Integer(87), hASDataElementArray[i2].resourceLocator);
                    continue block16;
                }
                case 120: {
                    this.map.put(new Integer(120), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block16;
                }
            }
        }
    }

    public RadioStationInfoContainer setName(String string) {
        this.map.put(new Integer(51), string);
        return this;
    }

    public boolean isSetName() {
        return this.map.containsKey(new Integer(51));
    }

    public String getName() {
        return (String)this.map.get(new Integer(51));
    }

    public RadioStationInfoContainer setFrequency(long l) {
        this.map.put(new Integer(52), new Long(l));
        return this;
    }

    public boolean isSetFrequency() {
        return this.map.containsKey(new Integer(52));
    }

    public long getFrequency() {
        return (Long)this.map.get(new Integer(52));
    }

    public RadioStationInfoContainer setBand(RadioBandEnumeration radioBandEnumeration) {
        this.map.put(new Integer(53), radioBandEnumeration);
        return this;
    }

    public boolean isSetBand() {
        return this.map.containsKey(new Integer(53));
    }

    public RadioBandEnumeration getBand() {
        return (RadioBandEnumeration)this.map.get(new Integer(53));
    }

    public RadioStationInfoContainer setPICode(int n) {
        this.map.put(new Integer(54), new Long(n));
        return this;
    }

    public boolean isSetPICode() {
        return this.map.containsKey(new Integer(54));
    }

    public int getPICode() {
        return ((Long)this.map.get(new Integer(54))).intValue();
    }

    public RadioStationInfoContainer setShortName(String string) {
        this.map.put(new Integer(79), string);
        return this;
    }

    public boolean isSetShortName() {
        return this.map.containsKey(new Integer(79));
    }

    public String getShortName() {
        return (String)this.map.get(new Integer(79));
    }

    public RadioStationInfoContainer setRDS(boolean bl) {
        this.map.put(new Integer(80), new Boolean(bl));
        return this;
    }

    public boolean isSetRDS() {
        return this.map.containsKey(new Integer(80));
    }

    public boolean getRDS() {
        return (Boolean)this.map.get(new Integer(80));
    }

    public RadioStationInfoContainer setTP(boolean bl) {
        this.map.put(new Integer(81), new Boolean(bl));
        return this;
    }

    public boolean isSetTP() {
        return this.map.containsKey(new Integer(81));
    }

    public boolean getTP() {
        return (Boolean)this.map.get(new Integer(81));
    }

    public RadioStationInfoContainer setFrequencyLabel(String string) {
        this.map.put(new Integer(82), string);
        return this;
    }

    public boolean isSetFrequencyLabel() {
        return this.map.containsKey(new Integer(82));
    }

    public String getFrequencyLabel() {
        return (String)this.map.get(new Integer(82));
    }

    public RadioStationInfoContainer setServiceId(long l) {
        this.map.put(new Integer(83), new Long(l));
        return this;
    }

    public boolean isSetServiceId() {
        return this.map.containsKey(new Integer(83));
    }

    public long getServiceId() {
        return (Long)this.map.get(new Integer(83));
    }

    public RadioStationInfoContainer setEnsembleId(int n) {
        this.map.put(new Integer(84), new Long(n));
        return this;
    }

    public boolean isSetEnsembleId() {
        return this.map.containsKey(new Integer(84));
    }

    public int getEnsembleId() {
        return ((Long)this.map.get(new Integer(84))).intValue();
    }

    public RadioStationInfoContainer setExtendedCountryCode(int n) {
        this.map.put(new Integer(85), new Long(n));
        return this;
    }

    public boolean isSetExtendedCountryCode() {
        return this.map.containsKey(new Integer(85));
    }

    public int getExtendedCountryCode() {
        return ((Long)this.map.get(new Integer(85))).intValue();
    }

    public RadioStationInfoContainer setServiceComponentId(int n) {
        this.map.put(new Integer(86), new Long(n));
        return this;
    }

    public boolean isSetServiceComponentId() {
        return this.map.containsKey(new Integer(86));
    }

    public int getServiceComponentId() {
        return ((Long)this.map.get(new Integer(86))).intValue();
    }

    public RadioStationInfoContainer setStationLogo(ResourceLocator resourceLocator) {
        this.map.put(new Integer(87), resourceLocator);
        return this;
    }

    public boolean isSetStationLogo() {
        return this.map.containsKey(new Integer(87));
    }

    public ResourceLocator getStationLogo() {
        return (ResourceLocator)this.map.get(new Integer(87));
    }

    public RadioStationInfoContainer setFMLinkingActive(boolean bl) {
        this.map.put(new Integer(120), new Boolean(bl));
        return this;
    }

    public boolean isSetFMLinkingActive() {
        return this.map.containsKey(new Integer(120));
    }

    public boolean getFMLinkingActive() {
        return (Boolean)this.map.get(new Integer(120));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(26, n2, n, this.createElements(), n3));
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
                case 51: {
                    hASDataElementArray[n++] = new StringElement(51, (String)entry.getValue());
                    break;
                }
                case 52: {
                    hASDataElementArray[n++] = new LongElement(52, (long)((Long)entry.getValue()));
                    break;
                }
                case 53: {
                    hASDataElementArray[n++] = new IntegerElement(53, ((RadioBandEnumeration)entry.getValue()).ordinal());
                    break;
                }
                case 54: {
                    hASDataElementArray[n++] = new IntegerElement(54, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 79: {
                    hASDataElementArray[n++] = new StringElement(79, (String)entry.getValue());
                    break;
                }
                case 80: {
                    hASDataElementArray[n++] = new BooleanElement(80, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 81: {
                    hASDataElementArray[n++] = new BooleanElement(81, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 82: {
                    hASDataElementArray[n++] = new StringElement(82, (String)entry.getValue());
                    break;
                }
                case 83: {
                    hASDataElementArray[n++] = new LongElement(83, (long)((Long)entry.getValue()));
                    break;
                }
                case 84: {
                    hASDataElementArray[n++] = new IntegerElement(84, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 85: {
                    hASDataElementArray[n++] = new IntegerElement(85, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 86: {
                    hASDataElementArray[n++] = new IntegerElement(86, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 87: {
                    hASDataElementArray[n++] = new ResourceElement(87, (ResourceLocator)entry.getValue());
                    break;
                }
                case 120: {
                    hASDataElementArray[n++] = new BooleanElement(120, (boolean)((Boolean)entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioStationInfoContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 51: {
                    if (entry.getValue() == null) {
                        stringWriter.write("name(String)=null");
                        break;
                    }
                    stringWriter.write("name(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 52: {
                    if (entry.getValue() == null) {
                        stringWriter.write("frequency(long)=null");
                        break;
                    }
                    stringWriter.write("frequency(long)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 53: {
                    if (entry.getValue() == null) {
                        stringWriter.write("band(RadioBandEnumeration)=null");
                        break;
                    }
                    stringWriter.write("band(RadioBandEnumeration)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 54: {
                    if (entry.getValue() == null) {
                        stringWriter.write("pICode(int)=null");
                        break;
                    }
                    stringWriter.write("pICode(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 79: {
                    if (entry.getValue() == null) {
                        stringWriter.write("shortName(String)=null");
                        break;
                    }
                    stringWriter.write("shortName(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 80: {
                    if (entry.getValue() == null) {
                        stringWriter.write("rDS(boolean)=null");
                        break;
                    }
                    stringWriter.write("rDS(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 81: {
                    if (entry.getValue() == null) {
                        stringWriter.write("tP(boolean)=null");
                        break;
                    }
                    stringWriter.write("tP(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 82: {
                    if (entry.getValue() == null) {
                        stringWriter.write("frequencyLabel(String)=null");
                        break;
                    }
                    stringWriter.write("frequencyLabel(String)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 83: {
                    if (entry.getValue() == null) {
                        stringWriter.write("serviceId(long)=null");
                        break;
                    }
                    stringWriter.write("serviceId(long)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 84: {
                    if (entry.getValue() == null) {
                        stringWriter.write("ensembleId(int)=null");
                        break;
                    }
                    stringWriter.write("ensembleId(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 85: {
                    if (entry.getValue() == null) {
                        stringWriter.write("extendedCountryCode(int)=null");
                        break;
                    }
                    stringWriter.write("extendedCountryCode(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 86: {
                    if (entry.getValue() == null) {
                        stringWriter.write("serviceComponentId(int)=null");
                        break;
                    }
                    stringWriter.write("serviceComponentId(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 87: {
                    if (entry.getValue() == null) {
                        stringWriter.write("stationLogo(ResourceLocator)=null");
                        break;
                    }
                    stringWriter.write("stationLogo(ResourceLocator)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 120: {
                    if (entry.getValue() == null) {
                        stringWriter.write("fMLinkingActive(boolean)=null");
                        break;
                    }
                    stringWriter.write("fMLinkingActive(boolean)='");
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
        RadioStationInfoContainer radioStationInfoContainer = new RadioStationInfoContainer(this);
        return radioStationInfoContainer;
    }
}

