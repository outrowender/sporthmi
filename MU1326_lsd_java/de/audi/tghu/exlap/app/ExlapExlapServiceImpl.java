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

public class ExlapExlapServiceImpl
extends ExlapAbstractExlapService {
    private static final String SERVICE_PACKAGE = "de.audi.tghu.exlap.ifc.service";
    private static final String EXLAP_VERSION = "1.0";
    private static final String VERSION_PREFIX = "ExlapVersion_";
    private final Map contextStates = new HashMap();

    public void init() {
        this.contextStates.put("ExlapVersion_1.0", ContextStateEnumeration.READY);
        this.sendUpdates();
    }

    public void setContextState(String string, ContextStateEnumeration contextStateEnumeration) {
        if (string == null || !string.startsWith(SERVICE_PACKAGE)) {
            return;
        }
        if ((string = string.substring(SERVICE_PACKAGE.length() + 1)).length() < "ExlapService".length()) {
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
            Map.Entry entry = (Map.Entry)iterator.next();
            contextStatesContainer.addState(new ContextStateContainer((String)entry.getKey(), (ContextStateEnumeration)entry.getValue()));
        }
        super.updateContextStates(contextStatesContainer);
    }
}

