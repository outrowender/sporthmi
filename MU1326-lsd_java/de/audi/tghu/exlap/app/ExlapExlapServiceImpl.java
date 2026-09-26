/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.tghu.exlap.ifc.enumeration.ContextStateEnumeration;
import de.audi.tghu.exlap.impl.container.ContextStateContainer;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractExlapService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public class ExlapExlapServiceImpl
extends ExlapAbstractExlapService {
    private static final String SERVICE_PACKAGE;
    private static final String EXLAP_VERSION;
    private static final String VERSION_PREFIX;
    private final Map contextStates = new HashMap();

    @Override
    public void init() {
        this.contextStates.put("ExlapVersion_1.0", ContextStateEnumeration.READY);
        this.sendUpdates();
    }

    public void setContextState(String string, ContextStateEnumeration contextStateEnumeration) {
        if (string == null || !string.startsWith("de.audi.tghu.exlap.ifc.service")) {
            return;
        }
        if ((string = string.substring("de.audi.tghu.exlap.ifc.service".length() + 1)).length() < "ExlapService".length()) {
            return;
        }
        string = string.substring("Exlap".length(), string.length() - "Service".length());
        ContextStateEnumeration contextStateEnumeration2 = (ContextStateEnumeration)this.contextStates.get(string);
        if (contextStateEnumeration != null && contextStateEnumeration2 != contextStateEnumeration) {
            this.contextStates.put(string, contextStateEnumeration);
            this.sendUpdates();
        }
    }

    private void sendUpdates() {
        ContextStatesContainer contextStatesContainer = new ContextStatesContainer();
        Iterator iterator = this.contextStates.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            contextStatesContainer.addState(new ContextStateContainer((String)map$Entry.getKey(), (ContextStateEnumeration)map$Entry.getValue()));
        }
        super.updateContextStates(contextStatesContainer);
    }
}

