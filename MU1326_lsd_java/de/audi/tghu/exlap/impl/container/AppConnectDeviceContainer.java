/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.dsi.StringElement;
import de.audi.tghu.exlap.ifc.enumeration.AppConnectDeviceTypeEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class AppConnectDeviceContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_APP_CONNECT_DEVICE = 64;
    private static final int ELEMENT_ID_AVAILABLE = 146;
    private static final int ELEMENT_ID_ENTERTAINMENT_ACTIVE = 147;
    private static final int ELEMENT_ID_TYPE = 148;
    private static final int ELEMENT_ID_DEVICE_NAME = 149;
    private Map map = new HashMap();

    public AppConnectDeviceContainer(boolean bl) {
        this.map.put(new Integer(146), new Boolean(bl));
    }

    public AppConnectDeviceContainer(AppConnectDeviceContainer appConnectDeviceContainer) {
        this.map.putAll(appConnectDeviceContainer.map);
    }

    public AppConnectDeviceContainer(HASDataElement[] hASDataElementArray) {
        block6: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 146: {
                    this.map.put(new Integer(146), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block6;
                }
                case 147: {
                    this.map.put(new Integer(147), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block6;
                }
                case 148: {
                    this.map.put(new Integer(148), AppConnectDeviceTypeEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 149: {
                    this.map.put(new Integer(149), hASDataElementArray[i2].stringData);
                    continue block6;
                }
            }
        }
    }

    public boolean getAvailable() {
        return (Boolean)this.map.get(new Integer(146));
    }

    public AppConnectDeviceContainer setEntertainmentActive(boolean bl) {
        this.map.put(new Integer(147), new Boolean(bl));
        return this;
    }

    public boolean isSetEntertainmentActive() {
        return this.map.containsKey(new Integer(147));
    }

    public boolean getEntertainmentActive() {
        return (Boolean)this.map.get(new Integer(147));
    }

    public AppConnectDeviceContainer setType(AppConnectDeviceTypeEnumeration appConnectDeviceTypeEnumeration) {
        this.map.put(new Integer(148), appConnectDeviceTypeEnumeration);
        return this;
    }

    public boolean isSetType() {
        return this.map.containsKey(new Integer(148));
    }

    public AppConnectDeviceTypeEnumeration getType() {
        return (AppConnectDeviceTypeEnumeration)this.map.get(new Integer(148));
    }

    public AppConnectDeviceContainer setDeviceName(String string) {
        this.map.put(new Integer(149), string);
        return this;
    }

    public boolean isSetDeviceName() {
        return this.map.containsKey(new Integer(149));
    }

    public String getDeviceName() {
        return (String)this.map.get(new Integer(149));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(64, n2, n, this.createElements(), n3));
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
                case 146: {
                    hASDataElementArray[n++] = new BooleanElement(146, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 147: {
                    hASDataElementArray[n++] = new BooleanElement(147, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 148: {
                    hASDataElementArray[n++] = new IntegerElement(148, ((AppConnectDeviceTypeEnumeration)entry.getValue()).ordinal());
                    break;
                }
                case 149: {
                    hASDataElementArray[n++] = new StringElement(149, (String)entry.getValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("AppConnectDeviceContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 146: {
                    if (entry.getValue() == null) {
                        stringWriter.write("available(boolean)=null");
                        break;
                    }
                    stringWriter.write("available(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 147: {
                    if (entry.getValue() == null) {
                        stringWriter.write("entertainmentActive(boolean)=null");
                        break;
                    }
                    stringWriter.write("entertainmentActive(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 148: {
                    if (entry.getValue() == null) {
                        stringWriter.write("type(AppConnectDeviceTypeEnumeration)=null");
                        break;
                    }
                    stringWriter.write("type(AppConnectDeviceTypeEnumeration)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 149: {
                    if (entry.getValue() == null) {
                        stringWriter.write("deviceName(String)=null");
                        break;
                    }
                    stringWriter.write("deviceName(String)='");
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
        AppConnectDeviceContainer appConnectDeviceContainer = new AppConnectDeviceContainer(this);
        return appConnectDeviceContainer;
    }
}

