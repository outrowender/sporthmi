/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureFrameRenderer;

public class PictureFrameController
extends AbstractWidgetController {
    public static final int TYP_3PLUS1;
    public static final int TYP_STREET_VIEW;
    public static final int TYP_BITMAP;
    public static final int TYP_KANBAN;
    private int type = 1;
    private int value = 50;
    private int updateInterval = 500;
    private int[] captureRect;
    private PictureFrameRenderer renderer;

    @Override
    public void disconnecting() {
        super.disconnecting();
    }

    public int[] getCaptureRect() {
        return this.captureRect;
    }

    public int getDisplayableID() {
        return this.getValue();
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int getType() {
        return this.type;
    }

    public int getUpdateInterval() {
        return this.updateInterval;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isUpdateFromDisplayable() {
        return this.type == 1;
    }

    public void setCaptureRect(int n, int n2, int n3, int n4) {
        if (this.captureRect == null) {
            this.captureRect = new int[4];
        }
        this.captureRect[0] = n;
        this.captureRect[1] = n2;
        this.captureRect[2] = n3;
        this.captureRect[3] = n4;
    }

    public void setDisplayableID(int n) {
        this.setValue(n);
    }

    public void setRenderer(PictureFrameRenderer pictureFrameRenderer) {
        this.renderer = pictureFrameRenderer;
    }

    public void setType(int n) {
        this.type = n;
    }

    public void setUpdateInterval(int n) {
        this.updateInterval = n;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public boolean useCaptureRect() {
        return this.captureRect != null;
    }
}

