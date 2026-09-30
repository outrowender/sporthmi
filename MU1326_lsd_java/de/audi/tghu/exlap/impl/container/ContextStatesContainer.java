/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import de.audi.tghu.exlap.impl.container.ContextStateContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ContextStatesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_CONTEXT_STATES = 0x1000001;
    private List states;

    public ContextStatesContainer() {
    }

    public ContextStatesContainer(ContextStatesContainer contextStatesContainer) {
        if (contextStatesContainer.states.size() > 0) {
            this.states = new ArrayList();
            Iterator iterator = contextStatesContainer.states.iterator();
            while (iterator.hasNext()) {
                this.states.add(((AbstractContainer)iterator.next()).clone());
            }
        }
    }

    public ContextStatesContainer(HASDataElement[] hASDataElementArray) {
    }

    public ContextStatesContainer addState(ContextStateContainer contextStateContainer) {
        if (this.states == null) {
            this.states = new ArrayList();
        }
        this.states.add(contextStateContainer);
        return this;
    }

    public List getStates() {
        if (this.states == null) {
            this.states = new ArrayList();
        }
        return this.states;
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        int n4 = n2 + 1;
        arrayList.add(new HASDataContainer(0x1000001, n2, n, null, n3));
        if (this.states != null) {
            Iterator iterator = this.states.iterator();
            while (iterator.hasNext()) {
                ContextStateContainer contextStateContainer = (ContextStateContainer)iterator.next();
                List list = contextStateContainer.createContainer(n2, n4, 0x1000002);
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
        stringWriter.write("ContextStatesContainer(");
        if (this.states != null) {
            Iterator iterator = this.states.iterator();
            stringWriter.write("states(List<ContextStateContainer>)=[");
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
        ContextStatesContainer contextStatesContainer = new ContextStatesContainer(this);
        return contextStatesContainer;
    }
}

