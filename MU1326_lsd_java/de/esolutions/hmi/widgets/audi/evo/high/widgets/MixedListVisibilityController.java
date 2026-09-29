/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import java.util.List;

public class MixedListVisibilityController
extends AbstractWidgetController {
    @Override
    public void connected(InitializationContext initializationContext) {
        mixedListLogChannel.log(-2137614336, "MixedListVisibilityController#connected");
        super.connected(initializationContext);
        this.refreshVisibilityStatus();
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    public boolean isParentVisible() {
        if (this.model != null) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            return choiceModelGUI.getStatus() == 1;
        }
        return false;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getUpdateType() == 1) {
            this.refreshVisibilityStatus();
        }
    }

    private void refreshVisibilityStatus() {
        if (this.model instanceof ChoiceModelGUI && this.parent != null) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            boolean bl = choiceModelGUI.getStatus() == 1 && choiceModelGUI.getValue() == 1;
            mixedListLogChannel.log(-2137614336, "MixedListVisibilityController#processModelUpdateEvent set parent to %1", (Object)(bl ? "visible" : "invisible"));
            this.parent.setVisible(bl);
        }
    }

    @Override
    public List getDiagnosisChildren() {
        return null;
    }
}

