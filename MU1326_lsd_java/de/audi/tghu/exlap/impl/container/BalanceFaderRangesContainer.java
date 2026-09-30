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
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class BalanceFaderRangesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_BALANCE_FADER_RANGES = 49;
    private static final int ELEMENT_ID_BALANCE_LEFT = 106;
    private static final int ELEMENT_ID_BALANCE_RIGHT = 107;
    private static final int ELEMENT_ID_FADER_REAR = 108;
    private static final int ELEMENT_ID_FADER_FRONT = 109;
    private Map map = new HashMap();

    public BalanceFaderRangesContainer(int n, int n2, int n3, int n4) {
        this.map.put(new Integer(106), new Long(n));
        this.map.put(new Integer(107), new Long(n2));
        this.map.put(new Integer(108), new Long(n3));
        this.map.put(new Integer(109), new Long(n4));
    }

    public BalanceFaderRangesContainer(BalanceFaderRangesContainer balanceFaderRangesContainer) {
        this.map.putAll(balanceFaderRangesContainer.map);
    }

    public BalanceFaderRangesContainer(HASDataElement[] hASDataElementArray) {
        block6: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 106: {
                    this.map.put(new Integer(106), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 107: {
                    this.map.put(new Integer(107), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 108: {
                    this.map.put(new Integer(108), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
                case 109: {
                    this.map.put(new Integer(109), new Long(hASDataElementArray[i2].numericData));
                    continue block6;
                }
            }
        }
    }

    public int getBalanceLeft() {
        return ((Long)this.map.get(new Integer(106))).intValue();
    }

    public int getBalanceRight() {
        return ((Long)this.map.get(new Integer(107))).intValue();
    }

    public int getFaderRear() {
        return ((Long)this.map.get(new Integer(108))).intValue();
    }

    public int getFaderFront() {
        return ((Long)this.map.get(new Integer(109))).intValue();
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(49, n2, n, this.createElements(), n3));
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
                case 106: {
                    hASDataElementArray[n++] = new IntegerElement(106, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 107: {
                    hASDataElementArray[n++] = new IntegerElement(107, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 108: {
                    hASDataElementArray[n++] = new IntegerElement(108, ((Long)entry.getValue()).intValue());
                    break;
                }
                case 109: {
                    hASDataElementArray[n++] = new IntegerElement(109, ((Long)entry.getValue()).intValue());
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("BalanceFaderRangesContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 106: {
                    if (entry.getValue() == null) {
                        stringWriter.write("balanceLeft(int)=null");
                        break;
                    }
                    stringWriter.write("balanceLeft(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 107: {
                    if (entry.getValue() == null) {
                        stringWriter.write("balanceRight(int)=null");
                        break;
                    }
                    stringWriter.write("balanceRight(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 108: {
                    if (entry.getValue() == null) {
                        stringWriter.write("faderRear(int)=null");
                        break;
                    }
                    stringWriter.write("faderRear(int)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 109: {
                    if (entry.getValue() == null) {
                        stringWriter.write("faderFront(int)=null");
                        break;
                    }
                    stringWriter.write("faderFront(int)='");
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
        BalanceFaderRangesContainer balanceFaderRangesContainer = new BalanceFaderRangesContainer(this);
        return balanceFaderRangesContainer;
    }
}

