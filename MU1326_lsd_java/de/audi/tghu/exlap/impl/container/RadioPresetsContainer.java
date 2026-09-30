/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioPresetsContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_PRESETS = 41;
    private List stations;

    public RadioPresetsContainer() {
    }

    public RadioPresetsContainer(RadioPresetsContainer radioPresetsContainer) {
        if (radioPresetsContainer.stations.size() > 0) {
            this.stations = new ArrayList();
            Iterator iterator = radioPresetsContainer.stations.iterator();
            while (iterator.hasNext()) {
                this.stations.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public RadioPresetsContainer(HASDataElement[] hASDataElementArray) {
    }

    public RadioPresetsContainer addStation(RadioPresetContainer radioPresetContainer) {
        if (this.stations == null) {
            this.stations = new ArrayList();
        }
        this.stations.add(radioPresetContainer);
        return this;
    }

    public List getStations() {
        if (this.stations == null) {
            this.stations = new ArrayList();
        }
        return this.stations;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(41, n2, n, null, n3));
        if (this.stations != null) {
            Iterator iterator = this.stations.iterator();
            while (iterator.hasNext()) {
                RadioPresetContainer radioPresetContainer = (RadioPresetContainer)iterator.next();
                List list = radioPresetContainer.createContainer(n2, n4, 91);
                n4 += list.size();
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public HASDataContainer[] createContainer() {
        List list = this.createContainer(-1, 1, -1);
        return (HASDataContainer[])list.toArray(new HASDataContainer[list.size()]);
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioPresetsContainer(");
        if (this.stations != null) {
            Iterator iterator = this.stations.iterator();
            stringWriter.write("stations(List<RadioPresetContainer>)=[");
            while (iterator.hasNext()) {
                ((Container)iterator.next()).toString(stringWriter);
                if (!iterator.hasNext()) continue;
                stringWriter.write(", ");
            }
            stringWriter.write("]");
        }
        stringWriter.write(")");
    }

    protected Object clone() {
        RadioPresetsContainer radioPresetsContainer = new RadioPresetsContainer(this);
        return radioPresetsContainer;
    }
}

