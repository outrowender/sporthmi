/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;

public class ComboBoxBackgroundRendererHigh
extends AbstractKanziTemplateRenderer
implements ComboBoxBackgroundRenderer {
    private ComboBoxBackgroundController controller;
    private float openValue;

    public ComboBoxBackgroundRendererHigh(ComboBoxBackgroundController comboBoxBackgroundController) {
        this.controller = comboBoxBackgroundController;
    }

    @Override
    public void setClipping(boolean bl) {
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.controller.getParent() instanceof ComboBoxController && ((ComboBoxController)this.controller.getParent()).getType() == 1) {
            int n = EALManager.createColorCode(0);
            this.setColorProperty("if_fieldColor", n);
            this.setProperty("if_width", this.controller.getWidth());
            this.setProperty("if_height", this.controller.getHeight());
            this.setProperty("dropdown_open", this.openValue);
            this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            return;
        }
        int n = EALManager.createColorCode(redrawContextHigh.getColor(5));
        this.setColorProperty("if_fieldColor", n);
        this.setProperty("if_width", this.controller.getWidth());
        this.setProperty("if_height", this.controller.getHeight());
        this.setProperty("dropdown_open", this.openValue);
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/dropdownBox";
    }

    @Override
    protected String getEALNodeName() {
        return "dropdownBox";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void setDropDownOpen(boolean bl) {
    }

    @Override
    public void setOpenValue(float f2) {
        this.openValue = f2;
    }

    @Override
    protected int getKzbConstant() {
        return 7;
    }
}

