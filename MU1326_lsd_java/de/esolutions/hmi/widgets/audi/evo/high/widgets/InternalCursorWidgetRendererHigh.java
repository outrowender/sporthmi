/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.InternalCursorWidgetRendererHigh$1;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractInternalCursorWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;

public class InternalCursorWidgetRendererHigh
extends TextDescriptorLabelRenderer
implements ITimeDateSetttingsRenderer,
IKanziTemplateRenderer {
    private AbstractWidgetController formfieldController;
    private IWrappedNode3D formfield;
    private EALPropertyCache propertyCache = new EALPropertyCache();
    private static int vertInset;
    private boolean colorsInitialized = false;
    private int ealCol1;
    private int ealCol2;
    private int ealCol3;
    private int ealCol4;
    private int backgroundVerticalOffset;
    private int backgroundHeight;
    private boolean autoConfig = true;

    @Override
    public void connect(InitializationContext initializationContext) {
        vertInset = initializationContext.getTerminal().getLayout().getIntegerConstant(27);
        this.left = 10;
        this.right = 10;
        this.spacing = 0;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        this.formfield = this.destroyNode(this.formfield);
        if (this.colorsInitialized) {
            this.colorsInitialized = false;
        }
    }

    private AbstractInternalCursorWidgetController getController() {
        return (AbstractInternalCursorWidgetController)this.controller;
    }

    @Override
    public int getBaseline() {
        return 0;
    }

    @Override
    public AbstractWidgetController getFormfieldStub() {
        if (this.formfieldController == null) {
            this.formfieldController = new InternalCursorWidgetRendererHigh$1(this);
        }
        return this.formfieldController;
    }

    public int getSelectedIndex() {
        int n = this.getController().getCursorIndex();
        for (int i2 = 0; i2 < this.LineElements.length; ++i2) {
            if (!this.LineElements[i2].focusable) continue;
            if (n == 0) {
                return i2;
            }
            --n;
        }
        return -1;
    }

    public String getText(int n) {
        return this.getAbstractController().getInitContext().getScreenFactory().getText(n);
    }

    @Override
    public int getTextWidth(String string) {
        return this.getEALManager().getTextWidth(string, this.getInheritedFont());
    }

    public static int getVerticalInset() {
        return vertInset;
    }

    public InternalCursorWidgetRendererHigh(AbstractInternalCursorWidgetController abstractInternalCursorWidgetController) {
        super(abstractInternalCursorWidgetController);
    }

    @Override
    public void render(RedrawContext redrawContext) {
        IWrappedNode3D iWrappedNode3D;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        super.render(redrawContextHigh);
        if (this.textNodes != null) {
            for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                this.textNodes[i2].setNodeIndex(1);
            }
        }
        EALManager eALManager = this.getEALManager();
        if (this.formfieldController != null) {
            n5 = this.formfieldController.getX();
            n4 = this.formfieldController.getY();
            n3 = this.formfieldController.getWidth();
            n2 = this.formfieldController.getHeight();
        } else {
            n5 = this.controller.getX();
            n4 = this.backgroundVerticalOffset;
            n3 = this.controller.getWidth();
            n2 = this.backgroundHeight;
            if (this.autoConfig) {
                n2 = this.getPreferredHeight() + 2 * vertInset;
                n4 = this.controller.getY() - vertInset;
            }
        }
        if (!this.colorsInitialized) {
            this.ealCol1 = EALManager.createColorCode(redrawContextHigh.getColor(0));
            this.ealCol2 = EALManager.createColorCode(redrawContextHigh.getColor(4));
            this.ealCol3 = EALManager.createColorCode(redrawContextHigh.getColor(2));
            this.ealCol4 = EALManager.createColorCode(redrawContextHigh.getColor(1));
            this.colorsInitialized = true;
        }
        boolean bl = this.getController().isInEditableMode();
        IWrappedNode3D iWrappedNode3D2 = redrawContextHigh.parentNode;
        if (this.formfield == null) {
            this.formfield = eALManager.createTemplateInstanceNode(iWrappedNode3D2, EALManager.createNodeName("formfield", this), 0.0f, 0.0f, 7, "Prefabs/generic_inputFieldSettings", this.getInitContext().getScreenID());
        }
        if (this.formfield != null) {
            this.setProperty(this.formfield, "if_width", n3);
            this.setProperty(this.formfield, "if_height", n2);
            this.formfield.setPosition(n5, n4, 0.0f);
            this.setProperty(this.formfield, "if_cursorActive", this.getController().isInEditableMode() ? 1.0f : 0.0f);
            this.setProperty(this.formfield, "if_fieldActive", this.getController().isInEditableMode() ? 1.0f : 0.0f);
            this.setColorProperty(this.formfield, "if_fieldColor", this.ealCol1);
            this.setColorProperty(this.formfield, "if_cursorColor", this.ealCol2);
            if (bl && (n = this.getSelectedIndex()) != -1) {
                LineElement lineElement = this.LineElements[n];
                iWrappedNode3D = (IWrappedNode3D)lineElement.node;
                int n6 = (int)iWrappedNode3D.getX() + 10 - 1;
                int n7 = (int)iWrappedNode3D.getY() + 2;
                int n8 = (int)iWrappedNode3D.getWidth() + 2;
                int n9 = (int)iWrappedNode3D.getHeight() + 2;
                this.setProperty(this.formfield, "if_cursorPosX", n6);
                this.setProperty(this.formfield, "if_cursorPosY", n7);
                this.setProperty(this.formfield, "if_cursorWidth", n8);
                this.setProperty(this.formfield, "if_cursorHeight", n9);
            }
        }
        n = this.getSelectedIndex();
        for (int i3 = 0; i3 < this.LineElements.length; ++i3) {
            iWrappedNode3D = (IWrappedNode3DText)this.LineElements[i3].node;
            if (iWrappedNode3D == null) continue;
            iWrappedNode3D.getInterfaceText().setColor(bl && i3 != n || !this.controller.isEnabled() ? (long)this.ealCol3 : (long)this.ealCol4);
        }
    }

    @Override
    public void setAutoConfig(boolean bl) {
        this.autoConfig = bl;
    }

    @Override
    public void setBackgroundHeight(int n) {
        this.backgroundHeight = n;
    }

    @Override
    public void setBackgroundVerticalOffset(int n) {
        this.backgroundVerticalOffset = n;
    }

    @Override
    public void setClipping(boolean bl) {
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }

    private void setProperty(IWrappedNode3D iWrappedNode3D, String string, float f2) {
        this.propertyCache.setProperty(iWrappedNode3D, string, f2);
    }

    private void setColorProperty(IWrappedNode3D iWrappedNode3D, String string, int n) {
        this.propertyCache.setColorProperty(iWrappedNode3D, string, n);
    }

    protected void setProperty(IWrappedNode3D iWrappedNode3D, String string, colorRGBAf colorRGBAf2) {
        this.propertyCache.setProperty(iWrappedNode3D, string, colorRGBAf2);
    }
}

