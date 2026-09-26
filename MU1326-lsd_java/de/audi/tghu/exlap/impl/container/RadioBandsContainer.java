/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.RadioBandContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioBandsContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_RADIO_BANDS;
    private List bands;

    public RadioBandsContainer() {
    }

    public RadioBandsContainer(RadioBandsContainer radioBandsContainer) {
        if (radioBandsContainer.bands.size() > 0) {
            this.bands = new ArrayList();
            Iterator iterator = radioBandsContainer.bands.iterator();
            while (iterator.hasNext()) {
                this.bands.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public RadioBandsContainer(HASDataElement[] hASDataElementArray) {
    }

    public RadioBandsContainer addBand(RadioBandContainer radioBandContainer) {
        if (this.bands == null) {
            this.bands = new ArrayList();
        }
        this.bands.add(radioBandContainer);
        return this;
    }

    public List getBands() {
        if (this.bands == null) {
            this.bands = new ArrayList();
        }
        return this.bands;
    }

    @Override
    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(35, n2, n, null, n3));
        if (this.bands != null) {
            Iterator iterator = this.bands.iterator();
            while (iterator.hasNext()) {
                RadioBandContainer radioBandContainer = (RadioBandContainer)iterator.next();
                List list = radioBandContainer.createContainer(n2, n4, 73);
                n4 += list.size();
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    @Override
    public HASDataContainer[] createContainer() {
        List list = this.createContainer(-1, 1, -1);
        return (HASDataContainer[])list.toArray(new HASDataContainer[list.size()]);
    }

    @Override
    public void toString(StringWriter stringWriter) {
        stringWriter.write("RadioBandsContainer(");
        if (this.bands != null) {
            Iterator iterator = this.bands.iterator();
            stringWriter.write("bands(List<RadioBandContainer>)=[");
            while (iterator.hasNext()) {
                ((Container)iterator.next()).toString(stringWriter);
                if (!iterator.hasNext()) continue;
                stringWriter.write(", ");
            }
            stringWriter.write("]");
        }
        stringWriter.write(")");
    }

    @Override
    protected Object clone() {
        RadioBandsContainer radioBandsContainer = new RadioBandsContainer(this);
        return radioBandsContainer;
    }
}

