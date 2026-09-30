/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangeContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class SoundVolumeRangesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_SOUND_VOLUME_RANGES = 29;
    private List volumeRanges;

    public SoundVolumeRangesContainer() {
    }

    public SoundVolumeRangesContainer(SoundVolumeRangesContainer soundVolumeRangesContainer) {
        if (soundVolumeRangesContainer.volumeRanges.size() > 0) {
            this.volumeRanges = new ArrayList();
            Iterator iterator = soundVolumeRangesContainer.volumeRanges.iterator();
            while (iterator.hasNext()) {
                this.volumeRanges.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public SoundVolumeRangesContainer(HASDataElement[] hASDataElementArray) {
    }

    public SoundVolumeRangesContainer addVolumeRange(SoundVolumeRangeContainer soundVolumeRangeContainer) {
        if (this.volumeRanges == null) {
            this.volumeRanges = new ArrayList();
        }
        this.volumeRanges.add(soundVolumeRangeContainer);
        return this;
    }

    public List getVolumeRanges() {
        if (this.volumeRanges == null) {
            this.volumeRanges = new ArrayList();
        }
        return this.volumeRanges;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(29, n2, n, null, n3));
        if (this.volumeRanges != null) {
            Iterator iterator = this.volumeRanges.iterator();
            while (iterator.hasNext()) {
                SoundVolumeRangeContainer soundVolumeRangeContainer = (SoundVolumeRangeContainer)iterator.next();
                List list = soundVolumeRangeContainer.createContainer(n2, n4, 62);
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
        stringWriter.write("SoundVolumeRangesContainer(");
        if (this.volumeRanges != null) {
            Iterator iterator = this.volumeRanges.iterator();
            stringWriter.write("volumeRanges(List<SoundVolumeRangeContainer>)=[");
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
        SoundVolumeRangesContainer soundVolumeRangesContainer = new SoundVolumeRangesContainer(this);
        return soundVolumeRangesContainer;
    }
}

