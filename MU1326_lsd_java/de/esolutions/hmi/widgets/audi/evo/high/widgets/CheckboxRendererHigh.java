/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxRenderer;

public class CheckboxRendererHigh
extends AbstractKanziTemplateRenderer
implements CheckboxRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/checkbox";
    private static final String EAL_NODE_NAME = "checkbox";
    private final CheckboxController controller;

    public CheckboxRendererHigh(CheckboxController checkboxController) {
        this.controller = checkboxController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        this.setProperty("cb_state", this.controller.getCheckMarkState());
        this.setProperty("cb_partialSelection", this.controller.getOpaqueness());
        this.setProperty("itemDisabled", this.controller.getItemDisabled());
        this.node.setOpacity(this.controller.getRenderOpacity());
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredWidth() {
        return this.getTerminal().getLayout().getIntegerConstant(52);
    }

    public int getPreferredHeight() {
        return this.getTerminal().getLayout().getIntegerConstant(53);
    }

    protected int getKzbConstant() {
        return 6;
    }
}

