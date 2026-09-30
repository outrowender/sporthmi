/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapCrosshairRenderer;

public class MapCrosshairController
extends AbstractWidgetController {
    public static final String KZB_NAME_MODE_CROSSHAIR = "crosshair_mode";
    public static final String KZB_NAME_ANGLE_CROSSHAIR = "crosshair_angle";
    public static final String KZB_NAME_ACTIVE_PASSIVE_CROSSHAIR = "passive";
    public static final String KZB_NAME_COLOR = "color";
    boolean isCrosshairFunctionEnabled = false;
    protected int currentCrosshairMode = 0;
    protected boolean hasCrosshairChanged = false;
    protected float lastAngle = 0.0f;
    protected boolean active;
    protected MapCrosshairRenderer renderer;

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.enableCrosshair();
        this.processModelUpdateEvent(null);
    }

    public void disconnecting() {
        super.disconnecting();
        this.disableCrosshair();
    }

    public void enableCrosshair() {
        if (!this.isCrosshairFunctionEnabled) {
            this.isCrosshairFunctionEnabled = true;
        }
    }

    public void disableCrosshair() {
        if (this.isCrosshairFunctionEnabled) {
            this.isCrosshairFunctionEnabled = false;
        }
    }

    public float getCurrentAngle() {
        return this.lastAngle;
    }

    public int getCurrentMode() {
        return this.currentCrosshairMode;
    }

    public boolean isCrosshairActive() {
        return this.active;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        ListModelGUI listModelGUI;
        sideBarLogChannel.log(10000000, "MapCrosshairController#processModelUpdateEvent %1", (Object)modelUpdateEvent);
        if (this.model instanceof ListModelGUI && (listModelGUI = (ListModelGUI)this.model).getLength() > 0 && listModelGUI.getMaxColumns() > 0) {
            int n = listModelGUI.getMaxColumns();
            ListCell[] listCellArray = new ListCell[n];
            listModelGUI.getRow(0, listCellArray);
            ListCell listCell = listCellArray[0];
            ListCell listCell2 = listCellArray[1];
            ListCell listCell3 = listCellArray[2];
            int n2 = 0;
            int n3 = 0;
            boolean bl = false;
            if (listCell instanceof IntegerListCell) {
                n2 = ((IntegerListCell)listCell).getValue();
            }
            if (listCell2 instanceof IntegerListCell) {
                n3 = ((IntegerListCell)listCell2).getValue();
            }
            if (listCell3 instanceof IntegerListCell) {
                bl = ((IntegerListCell)listCell3).getValue() == 1;
            }
            this.setX(n2);
            this.setY(n3);
            this.setVisible(bl);
            this.hasCrosshairChanged = true;
            sideBarLogChannel.log(10000000, "MapCrosshairController#processModelUpdateEvent x = %1, y = %2, visible = %3", (long)n2, (long)n3, bl);
        }
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public boolean hasCrosshairChanged() {
        return this.hasCrosshairChanged;
    }

    public boolean isDirectionArrowVisible() {
        return this.currentCrosshairMode == 1;
    }

    public void resetCrosshairChanged() {
        this.hasCrosshairChanged = false;
    }

    public void setCurrentCrosshairMode(int n) {
        if (this.currentCrosshairMode != n) {
            this.currentCrosshairMode = n;
            this.hasCrosshairChanged = true;
            if (this.isCrosshairFunctionEnabled) {
                this.setCompositesDirty(true);
            }
        }
    }

    public void setCurrentAngle(float f2) {
        if (this.lastAngle != f2) {
            this.lastAngle = f2;
            this.hasCrosshairChanged = true;
            if (this.isCrosshairFunctionEnabled) {
                this.setCompositesDirty(true);
                this.triggerRepaint();
            }
        }
    }

    public void setCrosshairActive(boolean bl) {
        if (bl != this.active) {
            this.active = bl;
            this.hasCrosshairChanged = true;
            if (this.isCrosshairFunctionEnabled) {
                this.setCompositesDirty(true);
            }
        }
    }

    public void setRenderer(MapCrosshairRenderer mapCrosshairRenderer) {
        this.renderer = mapCrosshairRenderer;
    }
}

