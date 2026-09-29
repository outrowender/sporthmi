/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.dsi.utils.DSIMobileEquipmentTopologyFieldNameAccess;
import de.audi.app.phone.core.event.AbstractTelEvent;

public abstract class AbstractTelDSIRequestEvent
extends AbstractTelEvent {
    public AbstractTelDSIRequestEvent(int n) {
        super("AbstractTelDSIRequestEvent", DSIMobileEquipmentTopologyFieldNameAccess.getRequestName(n));
    }
}

