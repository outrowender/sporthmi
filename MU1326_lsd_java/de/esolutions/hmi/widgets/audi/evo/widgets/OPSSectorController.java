/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController;

public class OPSSectorController
extends AbstractWidgetController {
    private int value = 0;
    private boolean highlighted = false;
    private OPSController opsController;
    private LogChannel logChannel = IWidgetLogChannel.logChannelParking;

    public IRenderer getRenderer() {
        return null;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.parent instanceof OPSController) {
            this.opsController = (OPSController)this.parent;
        } else {
            this.logChannel.log(10000, "OPSSectorController#initializeWidget parent is not an OPSController");
        }
        this.getModelData();
    }

    private void notifyParent() {
        if (this.opsController != null) {
            this.opsController.setDataChanged();
        }
    }

    private void getModelData() {
        if (!(this.model instanceof ChoiceModelGUI)) {
            this.logChannel.log(10000, "OPSSectorController#processModelUpdateEvent only choicemodels are allowed");
        }
        this.value = ((ChoiceModelGUI)this.model).getValue();
        this.highlighted = ((ChoiceModelGUI)this.model).getStatus() == 1;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.getModelData();
        this.notifyParent();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public int getValue() {
        return this.value;
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        this.notifyParent();
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }
}

