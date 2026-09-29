/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.TextfieldModel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputRenderer;

public class FormfieldInputController
extends AbstractWidgetController {
    private FormfieldInputRenderer renderer;
    private String text;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.readDataFromModel();
    }

    @Override
    public int getPreferredHeight() {
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    @Override
    public int getPreferredWidth() {
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public String getText() {
        if (this.text != null) {
            return this.text;
        }
        return "";
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.readDataFromModel();
    }

    private void readDataFromModel() {
        if (this.model instanceof TextfieldModel) {
            this.text = ((TextfieldModel)this.model).getText1();
            this.setCompositesDirty(true);
        }
    }

    public void setRenderer(FormfieldInputRenderer formfieldInputRenderer) {
        this.renderer = formfieldInputRenderer;
    }
}

