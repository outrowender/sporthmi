/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;

public class LabelRendererHigh
extends AbstractRendererHigh
implements LabelRenderer,
Alignment {
    protected final LabelController controller;
    private IWrappedNode3DText node;
    protected String text;
    protected int vAlign = 4;
    protected int hAlign = 1;
    private int preferredWidth = 0;
    private String preferredWidthText = null;
    private int abreviatedWidth = 0;
    private int abreviationWidth = 0;
    private String abreviatedWidthText = null;
    private String unAbreviatedWidthText = null;
    private int lastColor;
    private boolean lastColorValid = false;
    protected int previousWidth = -1;

    public LabelRendererHigh(LabelController labelController) {
        this.controller = labelController;
    }

    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender() || this.controller.getWidth() <= 0) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        String string = this.controller.getText();
        if (!this.equalDisplayData(this.text, string) || this.previousWidth != this.controller.getWidth()) {
            this.text = string;
            this.previousWidth = this.controller.getWidth();
            if (this.node == null) {
                this.renderNode(redrawContextHigh);
            } else if (this.text == null) {
                this.node.setVisible(false);
                return;
            }
            if (this.node != null) {
                this.node.setText(string, redrawContextHigh.getCurrentFont(), this.previousWidth, this.getEALManager());
            }
        }
        if (this.node == null) {
            return;
        }
        this.node.setNodeIndex(redrawContext.getCalculatedNodeIndex(this.controller.getDepth()));
        this.applyProperties(redrawContextHigh);
    }

    public String calculateDisplayData(String string, boolean bl) {
        if (!this.controller.isConnected()) {
            return null;
        }
        if (string == null) {
            return null;
        }
        if (bl) {
            int n = this.controller.getWidth();
            if (this.equalDisplayData(string, this.unAbreviatedWidthText) && this.abreviationWidth == n && this.abreviatedWidth <= n) {
                return this.abreviatedWidthText;
            }
            if (this.equalDisplayData(string, this.preferredWidthText) && this.preferredWidth <= n) {
                return string;
            }
            IWrappedFont iWrappedFont = this.getInheritedFont();
            this.preferredWidthText = string;
            this.preferredWidth = this.getEALManager().getTextWidth(this.preferredWidthText, iWrappedFont);
            if (this.preferredWidth <= n) {
                return string;
            }
            this.abreviatedWidthText = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(iWrappedFont).abbreviateTextEllipsis(string, n, false);
            this.abreviatedWidth = this.getEALManager().getTextWidth(string, iWrappedFont);
            this.abreviationWidth = n;
            this.unAbreviatedWidthText = string;
            return this.abreviatedWidthText;
        }
        return string;
    }

    protected boolean equalDisplayData(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    private void renderNode(RedrawContextHigh redrawContextHigh) {
        if (this.text == null) {
            return;
        }
        this.node = this.getEALManager().createText3D(redrawContextHigh.parentNode, EALManager.createNodeName("label", this), this.text, redrawContextHigh.getCurrentFont(), redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        this.lastColorValid = false;
    }

    private void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.node);
        }
        this.text = null;
        this.node = null;
        this.lastColorValid = false;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "LabelRendererHigh#applyProperties: text node is invalid with text: %1", (Object)this.text);
            return;
        }
        this.node.setVisible(true);
        int n = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getHeight(), this.vAlign);
        int n2 = LabelRendererHigh.getAlignmentOffsetX((int)this.node.getWidth(), this.controller.getWidth(), this.hAlign);
        this.node.setPosition((float)this.controller.getX() + this.x0 + (float)n2, (float)this.controller.getY() + this.y0 + (float)n, 0.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        int n3 = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        if (n3 != this.lastColor || !this.lastColorValid) {
            int n4 = EALManager.createColorCode(n3);
            this.node.getInterfaceText().setColor(n4);
            this.lastColor = n3;
            this.lastColorValid = true;
        }
        this.applyMirrorStatus(this.node);
    }

    public static int getAlignmentOffsetX(int n, int n2, int n3) {
        int n4 = n;
        int n5 = 0;
        switch (n3) {
            case 1: {
                break;
            }
            case 2: {
                n5 = (n2 - n4) / 2;
                break;
            }
            case 3: {
                n5 = n2 - n4;
                break;
            }
        }
        return n5;
    }

    public void disconnect() {
        this.destroyNode();
        super.disconnect();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public IWrappedNode3DText getNode() {
        return this.node;
    }

    public void setMetricsFormat(int n) {
        this.controller.setMetricsFormat(n);
    }

    public void setDateFormatMode(int n) {
        this.controller.setDateFormatMode(n);
    }

    public int getPreferredWidth() {
        String string = this.controller.getText();
        if (string == null || string.length() == 0) {
            return 0;
        }
        if (this.equalDisplayData(string, this.preferredWidthText)) {
            return this.preferredWidth;
        }
        if (this.equalDisplayData(string, this.abreviatedWidthText)) {
            return this.abreviatedWidth;
        }
        this.preferredWidth = this.getEALManager().getTextWidth(string, this.getInheritedFont());
        this.preferredWidthText = string;
        return this.preferredWidth;
    }

    public int getPreferredHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    public int getPreferredLineHeight() {
        return this.getPreferredHeight();
    }

    public int getFontHeight() {
        return this.getPreferredHeight();
    }

    public String getText() {
        return this.text;
    }

    public void setAlignment(int n, int n2) {
        this.vAlign = n2;
        this.hAlign = n;
    }

    public void setFirstVisibleLine(int n) {
        logChannel.log(10000, "LabelRendererHigh#setFirstVisibleLine: firstRendereredLine is not supported in this renderer");
    }

    public int getBaseline() {
        IWrappedFont iWrappedFont = this.getInheritedFont();
        if ((HMITerminalEAL)this.controller.getTerminal() != null) {
            return ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(iWrappedFont).calculateBaselineY(this.controller.getHeight(), this.vAlign);
        }
        int n = EALManager.getFontHeightUppercase(iWrappedFont);
        return this.calculateBaselineY(n, this.controller.getHeight(), this.vAlign);
    }

    private int calculateBaselineY(int n, int n2, int n3) {
        switch (n3) {
            case 6: {
                return n2 - 1;
            }
            case 5: {
                return Math.round((float)(n2 + n) / 2.0f) - 1;
            }
            case 4: {
                return n - 1;
            }
        }
        AbstractWidget.logChannel.log(10000, "LabelRendererHigh#calculateBaseLineY: unssupported alignment typ: %1", (long)n3);
        return n - 1;
    }

    public int getNumberOfRows(int n) {
        return 1;
    }

    public boolean hasContent() {
        String string = this.controller.getText();
        return string != null && string.length() > 0;
    }

    public boolean isTextDescriptorSupported() {
        return false;
    }

    public void setAutoWrap(int n) {
        logChannel.log(10000, "LabelRendererHigh#setAutoWrap: not supported in this renderer");
    }

    public void setMaxLines(int n) {
        logChannel.log(10000, "LabelRendererHigh#setMaxLines: not supported in this renderer");
    }

    public void setLineHeight(int n) {
    }

    public int getLineHeight() {
        return 0;
    }
}

