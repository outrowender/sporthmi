/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class ModelStubController
extends AbstractWidgetController {
    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.parent != null) {
            this.parent.processModelUpdateEvent(modelUpdateEvent);
        }
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }
}

