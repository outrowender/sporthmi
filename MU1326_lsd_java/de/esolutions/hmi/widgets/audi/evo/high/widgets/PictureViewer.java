/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FocusCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.List;

public class PictureViewer
extends LayoutContainerController {
    private boolean isSetUp = false;
    private PictureWallController pictureWall;
    private LayoutContainerController foreground;
    private LayoutContainerController[] lines;
    private FocusCursorController[] magnifierCursor;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof LayoutContainerController) {
            List list = abstractWidget.getChildren();
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidget abstractWidget2 = (AbstractWidget)list.get(i2);
                if (!(abstractWidget2 instanceof PictureWallController)) continue;
                this.pictureWall = (PictureWallController)abstractWidget2;
                this.pictureWall.setParentController(this);
                break;
            }
        }
        super.add(abstractWidget);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.setUpWidget();
    }

    public LayoutContainerController getLineOnFrontLayer(int n) {
        return this.lines[n];
    }

    public FocusCursorController getMagnifierCursor(int n) {
        return this.magnifierCursor[n];
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.pictureWall.processModelUpdateEvent(modelUpdateEvent);
    }

    @Override
    public void setModel(HMIModelGUI hMIModelGUI) {
        super.setModel(hMIModelGUI);
        if (this.pictureWall != null) {
            this.pictureWall.setModel(hMIModelGUI);
        }
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            Object object;
            int n;
            this.isSetUp = true;
            this.foreground = new LayoutContainerController();
            CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(this.foreground);
            this.foreground.setRenderer(compositeRendererHigh);
            this.foreground.setBounds(this.pictureWall.getX(), this.pictureWall.getY(), this.pictureWall.getWidth(), this.pictureWall.getHeight());
            super.add(this.foreground);
            int[][] nArray = this.pictureWall.getLinesCoordinates();
            this.lines = new LayoutContainerController[3];
            for (n = 0; n < 3; ++n) {
                object = nArray[n];
                this.lines[n] = new LayoutContainerController();
                this.lines[n].setRenderer(new CompositeRendererHigh(this.lines[n]));
                this.lines[n].setBounds((int)object[0], (int)object[1], (int)object[2], (int)object[3]);
                this.foreground.add(this.lines[n]);
            }
            this.magnifierCursor = new FocusCursorController[4];
            for (n = 0; n < 4; ++n) {
                object = new FocusCursorController();
                ((AbstractWidgetController)object).setVisible(true);
                FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh((CursorController)object);
                ((CursorController)object).setRenderer(focusCursorRendererHigh);
                this.magnifierCursor[n] = object;
            }
        }
    }
}

