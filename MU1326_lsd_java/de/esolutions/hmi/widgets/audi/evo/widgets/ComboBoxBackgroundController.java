/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;

public class ComboBoxBackgroundController
extends AbstractWidgetController {
    IRenderer renderer;

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void open() {
        try {
            ((ComboBoxBackgroundRenderer)this.renderer).setDropDownOpen(true);
        }
        catch (Exception exception) {
            logChannel.log(10000, "No Renderer set for ComboBoxBackgroundController");
        }
    }

    public void close() {
        try {
            ((ComboBoxBackgroundRenderer)this.renderer).setDropDownOpen(false);
        }
        catch (Exception exception) {
            logChannel.log(10000, "No Renderer set for ComboBoxBackgroundController");
        }
    }

    public int getDepth() {
        ComboBoxController comboBoxController;
        if (this.getParent() instanceof ComboBoxController && (comboBoxController = (ComboBoxController)this.getParent()).getType() == 1) {
            return super.getDepth();
        }
        return -1000;
    }
}

