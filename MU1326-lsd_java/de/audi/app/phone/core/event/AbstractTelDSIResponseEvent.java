/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.dsi.utils.DSIMobileEquipmentFieldNameAccess;
import de.audi.app.phone.core.event.AbstractTelEvent;

public abstract class AbstractTelDSIResponseEvent
extends AbstractTelEvent {
    public AbstractTelDSIResponseEvent(int n) {
        super("AbstractTelDSIResponseEvent", DSIMobileEquipmentFieldNameAccess.getResponseName(n));
    }
}

