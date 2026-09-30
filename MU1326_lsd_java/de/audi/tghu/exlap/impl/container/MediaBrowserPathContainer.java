/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserEntryContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaBrowserPathContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_BROWSER_PATH = 50;
    private List entries;

    public MediaBrowserPathContainer() {
    }

    public MediaBrowserPathContainer(MediaBrowserPathContainer mediaBrowserPathContainer) {
        if (mediaBrowserPathContainer.entries.size() > 0) {
            this.entries = new ArrayList();
            Iterator iterator = mediaBrowserPathContainer.entries.iterator();
            while (iterator.hasNext()) {
                this.entries.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public MediaBrowserPathContainer(HASDataElement[] hASDataElementArray) {
    }

    public MediaBrowserPathContainer addEntry(MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        if (this.entries == null) {
            this.entries = new ArrayList();
        }
        this.entries.add(mediaBrowserEntryContainer);
        return this;
    }

    public List getEntries() {
        if (this.entries == null) {
            this.entries = new ArrayList();
        }
        return this.entries;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(50, n2, n, null, n3));
        if (this.entries != null) {
            Iterator iterator = this.entries.iterator();
            while (iterator.hasNext()) {
                MediaBrowserEntryContainer mediaBrowserEntryContainer = (MediaBrowserEntryContainer)iterator.next();
                List list = mediaBrowserEntryContainer.createContainer(n2, n4, 110);
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
        stringWriter.write("MediaBrowserPathContainer(");
        if (this.entries != null) {
            Iterator iterator = this.entries.iterator();
            stringWriter.write("entries(List<MediaBrowserEntryContainer>)=[");
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
        MediaBrowserPathContainer mediaBrowserPathContainer = new MediaBrowserPathContainer(this);
        return mediaBrowserPathContainer;
    }
}

