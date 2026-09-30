/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputRenderer;

public class FormfieldInputRendererHigh
extends AbstractKanziTemplateRenderer
implements FormfieldInputRenderer {
    private int vAlign = 4;
    private FormfieldInputController controller;
    private IWrappedNode3DText textNode;
    private static final int TEXT_INSETS_LEFT_RIGHT = 5;
    private static int dropShadowWidth;
    private boolean enableYTranslation = true;
    private boolean enableDropShadowWidth;
    private boolean enableUseControllerHeight = false;
    private IWrappedNode3D formfieldRoot;
    private static int vertInset;

    public void connect(InitializationContext initializationContext) {
        dropShadowWidth = this.getTerminal().getLayout().getIntegerConstant(130);
        vertInset = initializationContext.getTerminal().getLayout().getIntegerConstant(27);
        super.connect(initializationContext);
    }

    public boolean isEnableYTranslation() {
        return this.enableYTranslation;
    }

    public void setEnableYTranslation(boolean bl) {
        this.enableYTranslation = bl;
    }

    public boolean isEnableDropShadowWidth() {
        return this.enableDropShadowWidth;
    }

    public void setEnableDropShadowWidth(boolean bl) {
        this.enableDropShadowWidth = bl;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2 = this.useControllerHeight() ? this.controller.getHeight() : this.getPreferredHeight() + 2 * vertInset;
        int n3 = this.enableDropShadowWidth ? this.controller.getX() : this.controller.getX() - dropShadowWidth;
        if (this.enableYTranslation) {
            n = this.controller.getY() - vertInset;
            if (AbstractWidget.isScreenResolution1440()) {
                ++n;
            }
        } else {
            n = this.controller.getY();
        }
        int n4 = redrawContextHigh.getColor(0);
        int n5 = this.getFormfieldWidth();
        menuItemLogCh.log(10000000, "FormfieldInputRenderer#applyProperties width = %1, height = %2", (long)n5, (long)n2);
        this.setProperty("if_inputWidth", n5);
        this.setProperty("if_inputHeight", n2);
        this.node.setPosition(n3 + 1, n, 0.0f);
        this.setProperty("if_iconVisible", 0.0f);
        int n6 = EALManager.createColorCode(n4);
        this.setColorProperty("if_fieldColor", n6);
        this.setProperty("if_fieldActive", 0.0f);
        this.setProperty("if_languageIndicator", 0.0f);
        int n7 = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getHeight(), this.vAlign);
        this.textNode.setPosition(this.getTextX(), this.controller.getY() + n7, 0.0f);
        this.textNode.setSize(this.getFormfieldWidth(), this.controller.getHeight());
        this.textNode.setOpacity(this.controller.getRenderOpacity());
        this.textNode.setVisible(this.controller.shouldRender());
    }

    protected void applyVisibility(boolean bl) {
        super.applyVisibility(bl);
        this.textNode.setVisible(bl);
    }

    public void disconnect() {
        super.disconnect();
        if (this.getEALManager() != null) {
            if (this.textNode != null) {
                this.getEALManager().destroy(this.textNode);
                this.textNode = null;
            }
            if (this.formfieldRoot != null) {
                this.getEALManager().destroy(this.formfieldRoot);
                this.formfieldRoot = null;
            }
        }
    }

    public FormfieldInputRendererHigh(FormfieldInputController formfieldInputController) {
        this.controller = formfieldInputController;
    }

    private final int getFormfieldWidth() {
        if (this.enableDropShadowWidth) {
            return this.controller.getWidth() - dropShadowWidth;
        }
        return this.controller.getWidth();
    }

    private final int getAvailableTextWidth() {
        return this.getFormfieldWidth() - 10;
    }

    private final int getTextX() {
        return 5 + this.controller.getX() + dropShadowWidth;
    }

    protected String getTemplateNodePath() {
        return "Prefabs/generic_inputField";
    }

    protected String getEALNodeName() {
        return "inputField";
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    public int getPreferredWidth() {
        return 0;
    }

    public void render(RedrawContext redrawContext) {
        int n;
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        EALManager eALManager = this.getEALManager();
        IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNode;
        if (this.formfieldRoot == null) {
            n = redrawContext.getCalculatedNodeIndex(this.getAbstractController().getDepth());
            this.formfieldRoot = eALManager.createNode3D(iWrappedNode3D, EALManager.createNodeName("formfield_root", this), 1.0f, 1.0f, n);
        }
        if (this.textNode == null) {
            this.textNode = eALManager.createText3D(this.formfieldRoot, EALManager.createNodeName("formfield_text", this), this.controller.getText(), this.getInheritedFont(), 1);
        }
        n = EALManager.createColorCode(redrawContextHigh.getColor(this.controller.getCurrentVisState()));
        this.textNode.getInterfaceText().setColor(n);
        String string = this.controller.getText();
        int n2 = this.getAvailableTextWidth();
        int n3 = eALManager.getTextWidth(string, this.getInheritedFont());
        if (n3 > n2) {
            StringUtility stringUtility = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont());
            string = stringUtility.abbreviateTextEllipsis(string, n2, false);
        }
        this.textNode.setText(string, this.getInheritedFont());
        redrawContextHigh.parentNode = this.formfieldRoot;
        redrawContextHigh.setNodeIndex(0);
        super.render(redrawContextHigh);
    }

    public boolean useControllerHeight() {
        return this.enableUseControllerHeight;
    }

    public void setUseControllerHeight(boolean bl) {
        this.enableUseControllerHeight = bl;
    }

    protected int getKzbConstant() {
        return 7;
    }
}

