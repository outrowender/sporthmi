/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.MediaSourceStateContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaSourcesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_SOURCES = 33;
    private List sources;

    public MediaSourcesContainer() {
    }

    public MediaSourcesContainer(MediaSourcesContainer mediaSourcesContainer) {
        if (mediaSourcesContainer.sources.size() > 0) {
            this.sources = new ArrayList();
            Iterator iterator = mediaSourcesContainer.sources.iterator();
            while (iterator.hasNext()) {
                this.sources.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public MediaSourcesContainer(HASDataElement[] hASDataElementArray) {
    }

    public MediaSourcesContainer addSource(MediaSourceStateContainer mediaSourceStateContainer) {
        if (this.sources == null) {
            this.sources = new ArrayList();
        }
        this.sources.add(mediaSourceStateContainer);
        return this;
    }

    public List getSources() {
        if (this.sources == null) {
            this.sources = new ArrayList();
        }
        return this.sources;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(33, n2, n, null, n3));
        if (this.sources != null) {
            Iterator iterator = this.sources.iterator();
            while (iterator.hasNext()) {
                MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)iterator.next();
                List list = mediaSourceStateContainer.createContainer(n2, n4, 71);
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
        stringWriter.write("MediaSourcesContainer(");
        if (this.sources != null) {
            Iterator iterator = this.sources.iterator();
            stringWriter.write("sources(List<MediaSourceStateContainer>)=[");
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
        MediaSourcesContainer mediaSourcesContainer = new MediaSourcesContainer(this);
        return mediaSourcesContainer;
    }
}

