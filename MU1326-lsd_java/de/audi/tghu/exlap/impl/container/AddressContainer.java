/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.DoubleElement;
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

public class AddressContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_ADDRESS;
    private static final int ELEMENT_ID_LATITUDE;
    private static final int ELEMENT_ID_LONGITUDE;
    private static final int ELEMENT_ID_FORMATTED_STRING;
    private static final int ELEMENT_ID_STREET;
    private static final int ELEMENT_ID_CITY;
    private static final int ELEMENT_ID_COUNTRY;
    private static final int ELEMENT_ID_HOUSENUMBER;
    private static final int ELEMENT_ID_ZIP;
    private static final int ELEMENT_ID_STATE;
    private static final int ELEMENT_ID_ALTITUDE;
    private Map map = new HashMap();

    public AddressContainer() {
    }

    public AddressContainer(AddressContainer addressContainer) {
        this.map.putAll(addressContainer.map);
    }

    public AddressContainer(HASDataElement[] hASDataElementArray) {
        block12: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 1: {
                    this.map.put(new Integer(1), new Double(hASDataElementArray[i2].doubleData));
                    continue block12;
                }
                case 2: {
                    this.map.put(new Integer(2), new Double(hASDataElementArray[i2].doubleData));
                    continue block12;
                }
                case 3: {
                    this.map.put(new Integer(3), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 4: {
                    this.map.put(new Integer(4), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 5: {
                    this.map.put(new Integer(5), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 6: {
                    this.map.put(new Integer(6), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 7: {
                    this.map.put(new Integer(7), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 8: {
                    this.map.put(new Integer(8), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 10: {
                    this.map.put(new Integer(10), hASDataElementArray[i2].stringData);
                    continue block12;
                }
                case 21: {
                    this.map.put(new Integer(21), new Double(hASDataElementArray[i2].doubleData));
                    continue block12;
                }
            }
        }
    }

    public AddressContainer setLatitude(double d2) {
        this.map.put(new Integer(1), new Double(d2));
        return this;
    }

    public boolean isSetLatitude() {
        return this.map.containsKey(new Integer(1));
    }

    public double getLatitude() {
        return (Double)this.map.get(new Integer(1));
    }

    public AddressContainer setLongitude(double d2) {
        this.map.put(new Integer(2), new Double(d2));
        return this;
    }

    public boolean isSetLongitude() {
        return this.map.containsKey(new Integer(2));
    }

    public double getLongitude() {
        return (Double)this.map.get(new Integer(2));
    }

    public AddressContainer setFormattedString(String string) {
        this.map.put(new Integer(3), string);
        return this;
    }

    public boolean isSetFormattedString() {
        return this.map.containsKey(new Integer(3));
    }

    public String getFormattedString() {
        return (String)this.map.get(new Integer(3));
    }

    public AddressContainer setStreet(String string) {
        this.map.put(new Integer(4), string);
        return this;
    }

    public boolean isSetStreet() {
        return this.map.containsKey(new Integer(4));
    }

    public String getStreet() {
        return (String)this.map.get(new Integer(4));
    }

    public AddressContainer setCity(String string) {
        this.map.put(new Integer(5), string);
        return this;
    }

    public boolean isSetCity() {
        return this.map.containsKey(new Integer(5));
    }

    public String getCity() {
        return (String)this.map.get(new Integer(5));
    }

    public AddressContainer setCountry(String string) {
        this.map.put(new Integer(6), string);
        return this;
    }

    public boolean isSetCountry() {
        return this.map.containsKey(new Integer(6));
    }

    public String getCountry() {
        return (String)this.map.get(new Integer(6));
    }

    public AddressContainer setHousenumber(String string) {
        this.map.put(new Integer(7), string);
        return this;
    }

    public boolean isSetHousenumber() {
        return this.map.containsKey(new Integer(7));
    }

    public String getHousenumber() {
        return (String)this.map.get(new Integer(7));
    }

    public AddressContainer setZip(String string) {
        this.map.put(new Integer(8), string);
        return this;
    }

    public boolean isSetZip() {
        return this.map.containsKey(new Integer(8));
    }

    public String getZip() {
        return (String)this.map.get(new Integer(8));
    }

    public AddressContainer setState(String string) {
        this.map.put(new Integer(10), string);
        return this;
    }

    public boolean isSetState() {
        return this.map.containsKey(new Integer(10));
    }

    public String getState() {
        return (String)this.map.get(new Integer(10));
    }

    public AddressContainer setAltitude(double d2) {
        this.map.put(new Integer(21), new Double(d2));
        return this;
    }

    public boolean isSetAltitude() {
        return this.map.containsKey(new Integer(21));
    }

    public double getAltitude() {
        return (Double)this.map.get(new Integer(21));
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(1, n2, n, this.createElements(), n3));
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
                case 1: {
                    hASDataElementArray[n++] = new DoubleElement(1, (double)((Double)map$Entry.getValue()));
                    break;
                }
                case 2: {
                    hASDataElementArray[n++] = new DoubleElement(2, (double)((Double)map$Entry.getValue()));
                    break;
                }
                case 3: {
                    hASDataElementArray[n++] = new StringElement(3, (String)map$Entry.getValue());
                    break;
                }
                case 4: {
                    hASDataElementArray[n++] = new StringElement(4, (String)map$Entry.getValue());
                    break;
                }
                case 5: {
                    hASDataElementArray[n++] = new StringElement(5, (String)map$Entry.getValue());
                    break;
                }
                case 6: {
                    hASDataElementArray[n++] = new StringElement(6, (String)map$Entry.getValue());
                    break;
                }
                case 7: {
                    hASDataElementArray[n++] = new StringElement(7, (String)map$Entry.getValue());
                    break;
                }
                case 8: {
                    hASDataElementArray[n++] = new StringElement(8, (String)map$Entry.getValue());
                    break;
                }
                case 10: {
                    hASDataElementArray[n++] = new StringElement(10, (String)map$Entry.getValue());
                    break;
                }
                case 21: {
                    hASDataElementArray[n++] = new DoubleElement(21, (double)((Double)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("AddressContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 1: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("latitude(double)=null");
                        break;
                    }
                    stringWriter.write("latitude(double)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 2: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("longitude(double)=null");
                        break;
                    }
                    stringWriter.write("longitude(double)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 3: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("formattedString(String)=null");
                        break;
                    }
                    stringWriter.write("formattedString(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 4: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("street(String)=null");
                        break;
                    }
                    stringWriter.write("street(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 5: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("city(String)=null");
                        break;
                    }
                    stringWriter.write("city(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 6: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("country(String)=null");
                        break;
                    }
                    stringWriter.write("country(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 7: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("housenumber(String)=null");
                        break;
                    }
                    stringWriter.write("housenumber(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 8: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("zip(String)=null");
                        break;
                    }
                    stringWriter.write("zip(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 10: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("state(String)=null");
                        break;
                    }
                    stringWriter.write("state(String)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 21: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("altitude(double)=null");
                        break;
                    }
                    stringWriter.write("altitude(double)='");
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
        AddressContainer addressContainer = new AddressContainer(this);
        return addressContainer;
    }
}

