/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.IntegerElement;
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

public class BalanceFaderContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_BALANCE_FADER;
    private static final int ELEMENT_ID_BALANCE;
    private static final int ELEMENT_ID_FADER;
    private Map map = new HashMap();

    public BalanceFaderContainer(int n, int n2) {
        this.map.put(new Integer(104), new Long(n));
        this.map.put(new Integer(105), new Long(n2));
    }

    public BalanceFaderContainer(BalanceFaderContainer balanceFaderContainer) {
        this.map.putAll(balanceFaderContainer.map);
    }

    public BalanceFaderContainer(HASDataElement[] hASDataElementArray) {
        block4: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 104: {
                    this.map.put(new Integer(104), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
                case 105: {
                    this.map.put(new Integer(105), new Long(hASDataElementArray[i2].numericData));
                    continue block4;
                }
            }
        }
    }

    public int getBalance() {
        return ((Long)this.map.get(new Integer(104))).intValue();
    }

    public int getFader() {
        return ((Long)this.map.get(new Integer(105))).intValue();
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(48, n2, n, this.createElements(), n3));
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
                case 104: {
                    hASDataElementArray[n++] = new IntegerElement(104, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
                case 105: {
                    hASDataElementArray[n++] = new IntegerElement(105, ((Long)map$Entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("BalanceFaderContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            switch ((Integer)map$Entry.getKey()) {
                case 104: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("balance(int)=null");
                        break;
                    }
                    stringWriter.write("balance(int)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 105: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("fader(int)=null");
                        break;
                    }
                    stringWriter.write("fader(int)='");
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
        BalanceFaderContainer balanceFaderContainer = new BalanceFaderContainer(this);
        return balanceFaderContainer;
    }
}

