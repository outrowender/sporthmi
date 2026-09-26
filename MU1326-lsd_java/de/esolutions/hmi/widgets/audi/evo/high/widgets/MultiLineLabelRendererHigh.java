/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import java.util.Arrays;
import java.util.List;

public class MultiLineLabelRendererHigh
extends AbstractRendererHigh
implements LabelRenderer,
Alignment,
PreferredDynamicHeight {
    protected final LabelController controller;
    protected IWrappedNode3D node;
    private IWrappedNode3DText[] textNodes;
    protected int autoWrap = -1;
    protected int firstVisibleLine = 0;
    private String[] texts;
    protected int hAlign = 1;
    private int vAlign = 4;
    protected int lineHeight = -1;
    private String cachedText1;
    private String cachedText2;
    private int cachedEffectiveWidth;
    private int cachedAutoWrap;
    private int cachedPreferredHeight;
    private int cachedPreferredWidth;
    private int cachedMaxLines;
    protected int cachedNumberOfRows;
    protected String cachedNumberOfRowsText;
    protected int cachedNumberOfRowsWidthHint;
    private String[] cachedRenderContent;
    private String cachedRenderContentText;
    private int cachedRenderContentWidth;
    private int cachedRenderContentMaxLines;
    private String cashedTextContent;
    private int cashedEffectiveWidth;
    private String[] cashedDisplayData;
    protected boolean hasCachedNumberOfRowsChanged;

    @Override
    public String calculateDisplayData(String string, boolean bl) {
        return string;
    }

    public MultiLineLabelRendererHigh(LabelController labelController) {
        this.controller = labelController;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        String[] stringArray = this.calculateRenderContent();
        String[] stringArray2 = this.calculatedRenderedLines(stringArray);
        if (!this.equalDisplayData(this.texts, stringArray2)) {
            this.destroyNode();
            this.texts = stringArray2;
            this.createRootNode(redrawContextHigh);
        }
        if (this.node == null) {
            return;
        }
        this.applyProperties(redrawContextHigh);
    }

    protected String[] calculateRenderContent() {
        int n;
        int n2;
        String string = this.controller.getText();
        if (string != null) {
            string = string.replace('\r', ' ');
        }
        if (this.changedRenderContent(string, n2 = this.controller.getWidth(), n = this.controller.getMaxLines())) {
            this.cachedRenderContent = this.calculateDisplayData(string, this.autoWrap, n2);
            this.cachedRenderContentText = string;
            this.cachedRenderContentWidth = n2;
            this.cachedRenderContentMaxLines = n;
        }
        return this.cachedRenderContent;
    }

    private boolean changedRenderContent(String string, int n, int n2) {
        return n != this.cachedRenderContentWidth || !Util.equals(string, this.cachedRenderContentText) || n2 != this.cachedRenderContentMaxLines;
    }

    protected String[] calculatedRenderedLines(String[] stringArray) {
        if (stringArray == null) {
            return null;
        }
        if (this.firstVisibleLine == 0) {
            return stringArray;
        }
        if (this.firstVisibleLine >= stringArray.length) {
            return null;
        }
        String[] stringArray2 = new String[stringArray.length - this.firstVisibleLine];
        System.arraycopy((Object)stringArray, this.firstVisibleLine, (Object)stringArray2, 0, stringArray2.length);
        return stringArray2;
    }

    protected String[] calculateDisplayData(String string, int n, int n2) {
        String[] stringArray;
        if (string == null) {
            return null;
        }
        if (string.equals(this.cashedTextContent) && n2 == this.cashedEffectiveWidth && this.cachedMaxLines == this.controller.getMaxLines()) {
            return this.cashedDisplayData;
        }
        StringUtility stringUtility = this.getStringUtility();
        int n3 = this.controller.getMaxLines();
        if (n3 > 0 && string.length() > 90 * n3) {
            string = string.substring(0, 90 * n3);
        }
        if (n == -1) {
            List list = stringUtility.wrapOnLineBreak(string, '\n');
            stringArray = (String[])list.toArray(new String[list.size()]);
            stringArray = this.applyMaxLines(stringArray);
        } else {
            stringArray = stringUtility.wrapText(string, n2, n2, n);
            stringArray = this.applyMaxLines(stringArray);
        }
        if (n2 != 0) {
            this.cashedTextContent = string;
            this.cashedEffectiveWidth = n2;
            this.cashedDisplayData = stringArray;
        }
        for (int i2 = 1; i2 < stringArray.length; ++i2) {
            stringArray[i2] = this.controller.getOrientaionHintedText(stringArray[i2]);
        }
        return stringArray;
    }

    private StringUtility getStringUtility() {
        HMITerminalEAL hMITerminalEAL = (HMITerminalEAL)((Object)this.controller.getTerminalImpl());
        return hMITerminalEAL.getStringUtility(this.getInheritedFont());
    }

    private String[] applyMaxLines(String[] stringArray) {
        int n = this.controller.getMaxLines();
        if (n < 1 || n >= stringArray.length) {
            return stringArray;
        }
        String[] stringArray2 = new String[n];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, n);
        int n2 = n - 1;
        stringArray2[n2] = new Buffer(stringArray[n2].length() + 1).append(stringArray[n2]).append('\u2026').toString();
        return stringArray2;
    }

    protected boolean equalDisplayData(String[] stringArray, String[] stringArray2) {
        if (stringArray == null) {
            return stringArray2 == null;
        }
        return Arrays.equals(stringArray, stringArray2);
    }

    protected void createRootNode(RedrawContextHigh redrawContextHigh) {
        if (this.texts == null || this.texts.length == 0) {
            return;
        }
        this.node = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("multilineLabel", this), 0.0f, 0.0f, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        this.textNodes = new IWrappedNode3DText[this.texts.length];
    }

    protected void destroyNode() {
        if (this.getEALManager() != null) {
            if (this.textNodes != null) {
                for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                    this.getEALManager().destroy(this.textNodes[i2]);
                }
            }
            this.getEALManager().destroy(this.node);
        }
        this.texts = null;
        this.node = null;
        this.textNodes = null;
    }

    private boolean changedPreferredHeightParams(String string, int n, int n2, int n3) {
        return !Util.equals(string, this.cachedText1) || n != this.cachedEffectiveWidth || n2 != this.cachedAutoWrap || n3 != this.cachedRenderContentMaxLines || n3 != this.cachedMaxLines || this.hasCachedNumberOfRowsChanged;
    }

    private boolean changedPreferredWidthParams(String string) {
        return !Util.equals(string, this.cachedText2);
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        if (this.lineHeight == -1) {
            int[] nArray = new int[]{23, 37, 37, 0, 35, 0, 0};
            int n = AbstractWidget.framework.getScreenRes();
            this.lineHeight = nArray[n];
        }
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2;
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "LabelRendererHigh#applyProperties: text node is invalid with text: %1", (Object)this.texts);
            return;
        }
        this.node.setVisible(true);
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        int n3 = this.getFontHeight();
        int n4 = this.controller.getHeight() - 1;
        int n5 = this.getAlignmentOffsetY();
        for (n2 = 0; n2 < this.textNodes.length; ++n2) {
            if (n5 <= n4) {
                if (this.textNodes[n2] == null) {
                    this.textNodes[n2] = this.getEALManager().createText3D(this.node, EALManager.createNodeName("multiLineText", n2, (AbstractRenderer)this), this.texts[n2], redrawContextHigh.getCurrentFont());
                }
            } else if (this.textNodes[n2] != null) {
                this.getEALManager().destroy(this.textNodes[n2]);
                this.textNodes[n2] = null;
            }
            if (this.textNodes[n2] == null) continue;
            this.textNodes[n2].setText(this.texts[n2], redrawContextHigh.getCurrentFont(), this.controller.getWidth(), this.getEALManager());
            n = this.getAlignmentOffsetX(n2);
            this.textNodes[n2].setPosition(n, n5 + n3 - 1, 0.0f);
            n5 += this.lineHeight;
        }
        this.node.setOpacity(this.controller.getRenderOpacity());
        n2 = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        n = EALManager.createColorCode(n2);
        for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
            if (this.textNodes[i2] == null) continue;
            this.textNodes[i2].getInterfaceText().setColor(n);
        }
    }

    protected int getAlignmentOffsetY() {
        int n = 0;
        int n2 = this.controller.getHeight();
        switch (this.vAlign) {
            case 4: {
                break;
            }
            case 5: {
                int n3 = this.autoWrap == -1 ? this.getPreferredHeight() : this.getPreferredHeight(this.controller.getWidth());
                n = (n2 - n3) / 2;
                break;
            }
            case 6: {
                n = n2 - this.getPreferredHeight();
                break;
            }
        }
        return n;
    }

    protected int getAlignmentOffsetX(int n) {
        int n2 = (int)this.textNodes[n].getWidth();
        int n3 = 0;
        switch (this.hAlign) {
            case 1: {
                break;
            }
            case 2: {
                n3 = (this.controller.getWidth() - n2) / 2;
                break;
            }
            case 3: {
                n3 = this.controller.getWidth() - n2;
                break;
            }
        }
        return n3;
    }

    @Override
    public void disconnect() {
        this.destroyNode();
        this.firstVisibleLine = 0;
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public int getPreferredWidth() {
        String string = this.controller.getText();
        if (this.changedPreferredWidthParams(string)) {
            String[] stringArray = this.calculateDisplayData(string, -1, 0);
            if (stringArray == null || stringArray.length == 0) {
                this.cachedPreferredWidth = 0;
            } else {
                boolean bl = this.equalDisplayData(this.texts, stringArray) && this.textNodes != null;
                int n = 0;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    int n2 = bl && this.textNodes[i2] != null ? (int)this.textNodes[i2].getWidth() : this.getEALManager().getTextWidth(stringArray[i2], this.getInheritedFont());
                    n = Math.max(n, n2);
                }
                this.cachedPreferredWidth = n;
            }
            this.cachedText2 = string;
        }
        return this.cachedPreferredWidth;
    }

    @Override
    public int getNumberOfRows(int n) {
        String string = this.controller.getText();
        if (this.changedNumberOfRows(string, n)) {
            String[] stringArray = this.calculateDisplayData(string, this.autoWrap, n);
            int n2 = stringArray == null ? 0 : stringArray.length;
            this.hasCachedNumberOfRowsChanged = n2 != this.cachedNumberOfRows;
            this.cachedNumberOfRows = n2;
            this.cachedNumberOfRowsWidthHint = n;
            this.cachedNumberOfRowsText = string;
        } else {
            this.hasCachedNumberOfRowsChanged = false;
        }
        return Math.max(this.controller.getMinLines(), this.cachedNumberOfRows);
    }

    protected boolean changedNumberOfRows(String string, int n) {
        return n != this.cachedNumberOfRowsWidthHint || !Util.equals(string, this.cachedNumberOfRowsText) || this.hasCachedNumberOfRowsChanged;
    }

    public int getPreferredHeightInternal(int n, int n2) {
        String string = this.controller.getText();
        if (this.changedPreferredHeightParams(string, n, n2, this.controller.getMaxLines())) {
            String[] stringArray = this.calculateDisplayData(string, n2, n);
            int n3 = stringArray == null ? 0 : stringArray.length;
            this.cachedPreferredHeight = (n3 - 1) * this.lineHeight + this.getFontHeight();
            this.cachedText1 = string;
            this.cachedEffectiveWidth = n;
            this.cachedAutoWrap = n2;
            this.cachedMaxLines = this.controller.getMaxLines();
        }
        return this.cachedPreferredHeight;
    }

    @Override
    public int getPreferredHeight(int n) {
        return this.getPreferredHeightInternal(n, this.autoWrap);
    }

    @Override
    public int getPreferredHeight() {
        return this.getPreferredHeightInternal(0, -1);
    }

    @Override
    public int getPreferredLineHeight() {
        return this.lineHeight;
    }

    @Override
    public int getFontHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    @Override
    public String getText() {
        if (this.texts == null) {
            return "";
        }
        Buffer buffer = new Buffer(30);
        for (int i2 = 0; i2 < this.texts.length; ++i2) {
            buffer.append(this.texts[i2]);
            if (i2 >= this.texts.length - 1) continue;
            buffer.append('\n');
        }
        return buffer.toString();
    }

    @Override
    public void setAutoWrap(int n) {
        this.autoWrap = n;
    }

    @Override
    public void setAlignment(int n, int n2) {
        this.hAlign = n;
        this.vAlign = n2;
    }

    @Override
    public int getBaseline() {
        return this.getFontHeight();
    }

    @Override
    public boolean hasContent() {
        String string = this.controller.getText();
        return string != null && string.length() > 0;
    }

    @Override
    public boolean isTextDescriptorSupported() {
        return false;
    }

    public int getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    @Override
    public void setFirstVisibleLine(int n) {
        this.firstVisibleLine = n;
    }

    @Override
    public int getLineHeight() {
        return this.lineHeight;
    }

    @Override
    public void setLineHeight(int n) {
        this.lineHeight = n;
    }

    public int getAutoWrap() {
        return this.autoWrap;
    }

    @Override
    public boolean isHeightDependentFromWidth() {
        return this.autoWrap != -1;
    }
}

