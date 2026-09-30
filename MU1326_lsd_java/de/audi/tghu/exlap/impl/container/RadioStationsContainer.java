/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioStationsContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_STATIONS = 39;
    private List stations;

    public RadioStationsContainer() {
    }

    public RadioStationsContainer(RadioStationsContainer radioStationsContainer) {
        if (radioStationsContainer.stations.size() > 0) {
            this.stations = new ArrayList();
            Iterator iterator = radioStationsContainer.stations.iterator();
            while (iterator.hasNext()) {
                this.stations.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public RadioStationsContainer(HASDataElement[] hASDataElementArray) {
    }

    public RadioStationsContainer addStation(RadioStationInfoContainer radioStationInfoContainer) {
        if (this.stations == null) {
            this.stations = new ArrayList();
        }
        this.stations.add(radioStationInfoContainer);
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
        arrayList.add(new HASDataContainer(39, n2, n, null, n3));
        if (this.stations != null) {
            Iterator iterator = this.stations.iterator();
            while (iterator.hasNext()) {
                RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)iterator.next();
                List list = radioStationInfoContainer.createContainer(n2, n4, 88);
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
        stringWriter.write("RadioStationsContainer(");
        if (this.stations != null) {
            Iterator iterator = this.stations.iterator();
            stringWriter.write("stations(List<RadioStationInfoContainer>)=[");
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
        RadioStationsContainer radioStationsContainer = new RadioStationsContainer(this);
        return radioStationsContainer;
    }
}

