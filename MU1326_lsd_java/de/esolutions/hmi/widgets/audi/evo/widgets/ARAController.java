/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IARARenderer;

public class ARAController
extends AbstractWidgetController {
    private IARARenderer renderer;
    private float currentAngle;
    private boolean currentAngleAvailable;
    private float targetAngle;
    private boolean targetAngleAvailable;
    private float hazinessAngle;
    private boolean hazinessAngleAvailable;
    private float maxAngle;
    private boolean maxAngleAvailable;
    private float clipAngle;
    private boolean clipAngleAvailable;

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IARARenderer iARARenderer) {
        this.renderer = iARARenderer;
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.model == null || !(this.model instanceof TiledListModelGUI)) {
            logChannelParking.log(10000, "ARAController#initializeWidget: only models of type TiledListModelGUI are supported");
            return;
        }
        this.updateValues();
        if (this.renderer != null) {
            this.renderer.setVisible(this.isVisible());
        }
    }

    private int getListModelRowIntValue(TiledListModelGUI tiledListModelGUI, int n) {
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n);
        if (guiListRow != null) {
            return guiListRow.getInteger(0);
        }
        logChannelParking.log(10000, "ARAController#getListModelRowIntValue: listmodel row %1 is null", (long)n);
        return 0;
    }

    private boolean getListModelRowBooleanValue(TiledListModelGUI tiledListModelGUI, int n) {
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n);
        if (guiListRow != null) {
            return guiListRow.getInteger(0) > 0;
        }
        logChannelParking.log(10000, "ARAController#getListModelRowBooleanValue: listmodel row %1 is null", (long)n);
        return false;
    }

    private void updateValues() {
        if (this.model == null || !(this.model instanceof TiledListModelGUI)) {
            return;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        this.currentAngle = this.getListModelRowIntValue(tiledListModelGUI, 0);
        this.currentAngleAvailable = this.getListModelRowBooleanValue(tiledListModelGUI, 1);
        this.targetAngle = this.getListModelRowIntValue(tiledListModelGUI, 2);
        this.targetAngleAvailable = this.getListModelRowBooleanValue(tiledListModelGUI, 3);
        this.hazinessAngle = this.getListModelRowIntValue(tiledListModelGUI, 4);
        this.hazinessAngleAvailable = this.getListModelRowBooleanValue(tiledListModelGUI, 5);
        this.maxAngle = this.getListModelRowIntValue(tiledListModelGUI, 6);
        this.maxAngleAvailable = this.getListModelRowBooleanValue(tiledListModelGUI, 7);
        this.clipAngle = this.getListModelRowIntValue(tiledListModelGUI, 8);
        this.clipAngleAvailable = this.getListModelRowBooleanValue(tiledListModelGUI, 9);
        logChannelParking.log(-2137614336, "ARAController#updateValues: values updated");
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!(this.model instanceof TiledListModelGUI)) {
            logChannelParking.log(10000, "ARAController#processModelUpdateEvent: only models of type TiledListModelGUI are supported");
            return;
        }
        this.updateValues();
        this.setCompositesDirty(true);
        modelUpdateEvent.consume();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (this.renderer != null) {
            this.renderer.setVisible(bl);
        }
    }

    @Override
    public void predisconnecting() {
        super.predisconnecting();
        if (this.renderer != null) {
            this.renderer.setVisible(false);
        }
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        if (this.renderer != null) {
            this.renderer.setVisible(false);
        }
    }

    public float getCurrentAngle() {
        return this.currentAngle;
    }

    public boolean isCurrentAngleAvailable() {
        return this.currentAngleAvailable;
    }

    public float getTargetAngle() {
        return this.targetAngle;
    }

    public boolean isTargetAngleAvailable() {
        return this.targetAngleAvailable;
    }

    public float getHazinessAngle() {
        return this.hazinessAngle;
    }

    public boolean isHazinessAngleAvailable() {
        return this.hazinessAngleAvailable;
    }

    public float getMaxAngle() {
        return this.maxAngle;
    }

    public boolean isMaxAngleAvailable() {
        return this.maxAngleAvailable;
    }

    public float getClipAngle() {
        return this.clipAngle;
    }

    public boolean isClipAngleAvailable() {
        return this.clipAngleAvailable;
    }
}

