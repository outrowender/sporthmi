/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class LastDestinationsContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_LAST_DESTINATIONS = 37;
    private List destinations;

    public LastDestinationsContainer() {
    }

    public LastDestinationsContainer(LastDestinationsContainer lastDestinationsContainer) {
        if (lastDestinationsContainer.destinations.size() > 0) {
            this.destinations = new ArrayList();
            Iterator iterator = lastDestinationsContainer.destinations.iterator();
            while (iterator.hasNext()) {
                this.destinations.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public LastDestinationsContainer(HASDataElement[] hASDataElementArray) {
    }

    public LastDestinationsContainer addDestination(LastDestinationContainer lastDestinationContainer) {
        if (this.destinations == null) {
            this.destinations = new ArrayList();
        }
        this.destinations.add(lastDestinationContainer);
        return this;
    }

    public List getDestinations() {
        if (this.destinations == null) {
            this.destinations = new ArrayList();
        }
        return this.destinations;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(37, n2, n, null, n3));
        if (this.destinations != null) {
            Iterator iterator = this.destinations.iterator();
            while (iterator.hasNext()) {
                LastDestinationContainer lastDestinationContainer = (LastDestinationContainer)iterator.next();
                List list = lastDestinationContainer.createContainer(n2, n4, 76);
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
        stringWriter.write("LastDestinationsContainer(");
        if (this.destinations != null) {
            Iterator iterator = this.destinations.iterator();
            stringWriter.write("destinations(List<LastDestinationContainer>)=[");
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
        LastDestinationsContainer lastDestinationsContainer = new LastDestinationsContainer(this);
        return lastDestinationsContainer;
    }
}

