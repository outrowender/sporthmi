/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IImageDecoratorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public final class ImageDecoratorController
extends AbstractWidgetController
implements ListItemWidget,
IEmptyableWidget {
    private IImageDecoratorRenderer renderer = null;
    private HMIResourceLocator resLocator = null;
    private int modelColumn = -1;
    private float scaleFactor = 1.0f;

    public boolean hasContent() {
        if (this.resLocator == null) {
            logImageDecorator.log(10000000, "ImageDecoratorController#hasContent() - ResourceLocator is null, returning with 'false'.");
            return this.modelColumn != -1;
        }
        boolean bl = this.resLocator.containsResourceID() || this.resLocator.containsResourceURI();
        logImageDecorator.log(10000000, "ImageDecoratorController#hasContent() - Returning with '%1'", bl);
        return bl;
    }

    public void setModelColumn(int n) {
        logImageDecorator.log(10000000, "ImageDecoratorController#setModelColumn(%1) - Called", (long)n);
        this.modelColumn = n;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }

    public void setScaleFactor(float f2) {
        logImageDecorator.log(10000000, "ImageDecoratorController#setScaleFactor(%1) - Called", (double)f2);
        this.scaleFactor = f2;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IImageDecoratorRenderer iImageDecoratorRenderer) {
        logImageDecorator.log(10000000, "ImageDecoratorController#setRenderer(%1) - Called", (Object)iImageDecoratorRenderer);
        this.renderer = iImageDecoratorRenderer;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        logImageDecorator.log(10000000, "ImageDecoratorController#processModelUpdateEvent(%1) - Called", (Object)modelUpdateEvent);
        super.processModelUpdateEvent(modelUpdateEvent);
        this.updateFromModel();
        this.setCompositesDirty(true);
    }

    public HMIResourceLocator getResourceLocator() {
        return this.resLocator;
    }

    protected void initializeWidget() {
        logImageDecorator.log(10000000, "ImageDecoratorController#initializeWidget() - Called");
        super.initializeWidget();
        this.updateFromModel();
    }

    private void updateFromModel() {
        if (this.model instanceof HMIResourceLocator) {
            logImageDecorator.log(10000000, "ImageDecoratorController#initializeWidget() - Fetching ResourceLocator from model (%1).", (long)this.modelID);
            this.resLocator = (HMIResourceLocator)this.model;
        } else if (this.model instanceof ResourceLocatorModelGUI) {
            logImageDecorator.log(10000000, "ImageDecoratorController#initializeWidget() - Fetching ResourceLocator from model (%1).", (long)this.modelID);
            this.resLocator = ((ResourceLocatorModelGUI)this.model).getResourceLocator();
        } else {
            logImageDecorator.log(10000, "ImageDecoratorController#updateFromModel: unknown model type. ModelID: %2, Model: %1", this.model, (long)this.modelID);
        }
        if (this.modelColumn != -1) {
            logImageDecorator.log(10000000, "ImageDecoratorController#updateFromModel update via modelColumn (%1)", (long)this.modelColumn);
        }
    }
}

