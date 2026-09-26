/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.event;

import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class TelChoiceModelSetValueEvent
extends AbstractTelEvent {
    private final ChoiceModelApp model;
    private final int value;

    public TelChoiceModelSetValueEvent(ChoiceModelApp choiceModelApp, int n) {
        super("TelChoiceModelSetValueEvent", new Buffer().append("model=").append(choiceModelApp.getID()).append(", ").append("value=").append(n).append(")").toString());
        this.model = choiceModelApp;
        this.value = n;
    }

    @Override
    public void run() {
        this.model.setValue(this.value);
    }
}

