/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MeccaCompassRendererHigh;

public class MeccaCompassController
extends AbstractWidgetController {
    private MeccaCompassRendererHigh renderer;
    private float meccaAngle;

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1) {
            this.updateContent();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public float getMeccaAngle() {
        return this.meccaAngle;
    }

    public void setMeccaAngle(float f2) {
        this.meccaAngle = f2;
    }

    public void setRenderer(MeccaCompassRendererHigh meccaCompassRendererHigh) {
        this.renderer = meccaCompassRendererHigh;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    private void updateContent() {
        if (this.model instanceof ChoiceModelGUI) {
            this.meccaAngle = ((ChoiceModelGUI)this.model).getValue();
            if (this.meccaAngle == 32959) {
                this.meccaAngle = 0.0f;
            }
            this.setCompositesDirty(true);
        }
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        this.updateContent();
        super.connected(initializationContext);
    }
}

