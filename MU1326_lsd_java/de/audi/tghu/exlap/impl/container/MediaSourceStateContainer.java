/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.dsi.IntegerElement;
import de.audi.tghu.exlap.ifc.enumeration.MediaSourceEnumeration;
import de.audi.tghu.exlap.ifc.enumeration.MediaSourceStateEnumeration;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.MediaCapabilitiesContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaSourceStateContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_SOURCE_STATE;
    private static final int ELEMENT_ID_SOURCE;
    private static final int ELEMENT_ID_STATE;
    private static final int ELEMENT_ID_DATABASE_SYNCED;
    private Map map = new HashMap();
    private MediaCapabilitiesContainer capabilities;

    public MediaSourceStateContainer(MediaSourceEnumeration mediaSourceEnumeration, MediaSourceStateEnumeration mediaSourceStateEnumeration) {
        this.map.put(new Integer(69), mediaSourceEnumeration);
        this.map.put(new Integer(70), mediaSourceStateEnumeration);
    }

    public MediaSourceStateContainer(MediaSourceStateContainer mediaSourceStateContainer) {
        this.map.putAll(mediaSourceStateContainer.map);
        this.capabilities = (MediaCapabilitiesContainer)mediaSourceStateContainer.capabilities.clone();
    }

    public MediaSourceStateContainer(HASDataElement[] hASDataElementArray) {
        block5: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 69: {
                    this.map.put(new Integer(69), MediaSourceEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 70: {
                    this.map.put(new Integer(70), MediaSourceStateEnumeration.valueOf((int)hASDataElementArray[i2].numericData));
                    continue block5;
                }
                case 125: {
                    this.map.put(new Integer(125), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block5;
                }
            }
        }
    }

    public MediaSourceEnumeration getSource() {
        return (MediaSourceEnumeration)this.map.get(new Integer(69));
    }

    public MediaSourceStateEnumeration getState() {
        return (MediaSourceStateEnumeration)this.map.get(new Integer(70));
    }

    public MediaSourceStateContainer setDatabaseSynced(boolean bl) {
        this.map.put(new Integer(125), new Boolean(bl));
        return this;
    }

    public boolean isSetDatabaseSynced() {
        return this.map.containsKey(new Integer(125));
    }

    public boolean getDatabaseSynced() {
        return (Boolean)this.map.get(new Integer(125));
    }

    public MediaSourceStateContainer setCapabilities(MediaCapabilitiesContainer mediaCapabilitiesContainer) {
        this.capabilities = mediaCapabilitiesContainer;
        return this;
    }

    public MediaCapabilitiesContainer getCapabilities() {
        return this.capabilities;
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(32, n2, n, this.createElements(), n3));
        if (this.capabilities != null) {
            List list = this.capabilities.createContainer(n2, n4, 151);
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
                case 69: {
                    hASDataElementArray[n++] = new IntegerElement(69, ((MediaSourceEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 70: {
                    hASDataElementArray[n++] = new IntegerElement(70, ((MediaSourceStateEnumeration)map$Entry.getValue()).ordinal());
                    break;
                }
                case 125: {
                    hASDataElementArray[n++] = new BooleanElement(125, (boolean)((Boolean)map$Entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaSourceStateContainer(");
        stringWriter.write("capabilities(MediaCapabilitiesContainer)='");
        if (this.capabilities != null) {
            this.capabilities.toString(stringWriter);
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
                case 69: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("source(MediaSourceEnumeration)=null");
                        break;
                    }
                    stringWriter.write("source(MediaSourceEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 70: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("state(MediaSourceStateEnumeration)=null");
                        break;
                    }
                    stringWriter.write("state(MediaSourceStateEnumeration)='");
                    stringWriter.write(map$Entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 125: {
                    if (map$Entry.getValue() == null) {
                        stringWriter.write("databaseSynced(boolean)=null");
                        break;
                    }
                    stringWriter.write("databaseSynced(boolean)='");
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
        MediaSourceStateContainer mediaSourceStateContainer = new MediaSourceStateContainer(this);
        return mediaSourceStateContainer;
    }
}

