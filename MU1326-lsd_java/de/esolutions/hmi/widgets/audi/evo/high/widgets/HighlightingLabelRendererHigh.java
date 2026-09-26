/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.eal.api.ITextLayoutSection$style_t;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh$LayoutSection;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighlightingLabelRendererHigh
extends LabelRendererHigh {
    private IWrappedNode3DTextMultiSection textNode;
    private int[] highlighting;
    private List layoutSections;
    private static final boolean HIGHLIGHTED;
    private int previousX = 0;
    private int previousY = 0;

    public HighlightingLabelRendererHigh(LabelController labelController) {
        super(labelController);
    }

    @Override
    public String calculateDisplayData(String string, boolean bl) {
        return string;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender() || this.controller.getWidth() <= 0) {
            if (this.textNode != null) {
                this.textNode.setVisible(false);
            }
            return;
        }
        String string = this.getAbbreviatedText();
        int[] nArray = this.controller.getHighlightArea();
        if (!this.equalDisplayData(this.text, string) || this.previousWidth != this.controller.getWidth() || !Util.equals(this.highlighting, nArray) || this.hasPositionChanged()) {
            this.updateContent(string, nArray);
            this.previousWidth = this.controller.getWidth();
        }
        this.renderNode((RedrawContextHigh)redrawContext);
        if (this.textNode == null) {
            return;
        }
        this.textNode.setNodeIndex(redrawContext.getCalculatedNodeIndex(this.controller.getDepth()));
        this.textNode.setVisible(true);
    }

    private boolean hasPositionChanged() {
        boolean bl = false;
        if (this.controller.getX() != this.previousX) {
            this.previousX = this.controller.getX();
            bl = true;
        }
        if (this.controller.getY() != this.previousY) {
            this.previousY = this.controller.getY();
            bl = true;
        }
        return bl;
    }

    private void updateContent(String string, int[] nArray) {
        this.highlighting = string != null && (string.startsWith("\u200f") || string.startsWith("\u200e")) ? this.shiftHighlighting(nArray, 1) : nArray;
        this.text = string;
        this.layoutSections = this.initSections(this.text, this.highlighting);
    }

    private int[] shiftHighlighting(int[] nArray, int n) {
        if (nArray == null) {
            return nArray;
        }
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            nArray2[i2] = nArray[i2] + n;
        }
        return nArray2;
    }

    protected List initSections(String string, int[] nArray) {
        if (string == null || string.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.checkHighlightingAreas(nArray)) {
            arrayList.add(new HighlightingLabelRendererHigh$LayoutSection(this, 0, string.length(), false));
            return arrayList;
        }
        boolean[] blArray = this.getBooleanHihglightingArray(string.length(), nArray);
        HighlightingLabelRendererHigh$LayoutSection highlightingLabelRendererHigh$LayoutSection = new HighlightingLabelRendererHigh$LayoutSection(this);
        highlightingLabelRendererHigh$LayoutSection.start = 0;
        highlightingLabelRendererHigh$LayoutSection.highlighted = blArray[0];
        for (int i2 = 1; i2 < blArray.length; ++i2) {
            if (blArray[i2] == highlightingLabelRendererHigh$LayoutSection.highlighted) continue;
            highlightingLabelRendererHigh$LayoutSection.end = i2 - 1;
            arrayList.add(highlightingLabelRendererHigh$LayoutSection);
            highlightingLabelRendererHigh$LayoutSection = new HighlightingLabelRendererHigh$LayoutSection(this);
            highlightingLabelRendererHigh$LayoutSection.start = i2;
            highlightingLabelRendererHigh$LayoutSection.highlighted = blArray[i2];
        }
        highlightingLabelRendererHigh$LayoutSection.end = string.length();
        arrayList.add(highlightingLabelRendererHigh$LayoutSection);
        return arrayList;
    }

    public List getLayoutSections() {
        return this.layoutSections;
    }

    private void renderNode(RedrawContextHigh redrawContextHigh) {
        EALManager eALManager = this.getEALManager();
        IWrappedFont iWrappedFont = this.getInheritedFont();
        if (this.textNode == null) {
            this.textNode = eALManager.createText3DMultiSection(redrawContextHigh.parentNode, EALManager.createNodeName("highligtingtextnode", this), "", iWrappedFont, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        }
        if (this.textNode == null) {
            logChannel.log(10000, "HighlightingLabelRendererHigh#renderNode() could not create text node for text:%1", (Object)this.text);
            return;
        }
        this.textNode.getInterfaceText().setColor(EALManager.createColorCode(-1));
        StringUtility stringUtility = ((HMITerminalEAL)((Object)this.controller.getTerminalImpl())).getStringUtility(iWrappedFont);
        int n = stringUtility.calculateBaselineY(this.controller.getHeight(), this.vAlign);
        int n2 = eALManager.getTextWidth(this.text, iWrappedFont);
        int n3 = HighlightingLabelRendererHigh.getAlignmentOffsetX(n2, this.controller.getWidth(), this.hAlign);
        this.textNode.setPosition(this.controller.getX() + n3, this.controller.getY() + n, 0.0f);
        this.textNode.setOpacity(this.controller.getRenderOpacity());
        this.updateTextLayout(redrawContextHigh);
        this.textNode.notifyLayoutChanged(false);
        this.textNode.setText(this.text);
    }

    private void updateTextLayout(RedrawContextHigh redrawContextHigh) {
        int n = EALManager.createColorCode(redrawContextHigh.getColor(3));
        int n2 = EALManager.createColorCode(redrawContextHigh.getColor(this.controller.getCurrentVisState()));
        if (logChannel.isDebug()) {
            this.logSections(this.layoutSections);
        }
        ITextLayout iTextLayout = this.textNode.getLayout();
        iTextLayout.setTextLayoutSectionNum(this.layoutSections.size());
        IWrappedFont iWrappedFont = this.getInheritedFont();
        for (int i2 = 0; i2 < this.layoutSections.size(); ++i2) {
            HighlightingLabelRendererHigh$LayoutSection highlightingLabelRendererHigh$LayoutSection = (HighlightingLabelRendererHigh$LayoutSection)this.layoutSections.get(i2);
            ITextLayoutSection iTextLayoutSection = iTextLayout.getLayoutSection(i2);
            iTextLayoutSection.setColor(highlightingLabelRendererHigh$LayoutSection.highlighted ? n : n2);
            iTextLayoutSection.setStyle(new FlagFontStyle(ITextLayoutSection$style_t.STYLE_REGULAR));
            iTextLayoutSection.setBasicFontGroup(iWrappedFont.getSize(), highlightingLabelRendererHigh$LayoutSection.end);
            iTextLayoutSection.setStartEndIndex(highlightingLabelRendererHigh$LayoutSection.start, highlightingLabelRendererHigh$LayoutSection.end);
        }
    }

    private void logSections(List list) {
        if (list == null) {
            return;
        }
        logChannel.log(-2137614336, "HighlightingLabelRendererHigh#updateHighlighting() sections:");
        for (int i2 = 0; i2 < list.size(); ++i2) {
            logChannel.log(14808325, "%1", list.get(i2));
        }
    }

    private boolean[] getBooleanHihglightingArray(int n, int[] nArray) {
        boolean[] blArray = new boolean[n];
        for (int i2 = 0; i2 < nArray.length - 1; i2 += 2) {
            int n2 = nArray[i2];
            int n3 = nArray[i2 + 1];
            for (int i3 = n2; i3 < n3; ++i3) {
                if (n2 >= n || i3 < 0 || i3 >= n) {
                    return blArray;
                }
                blArray[i3] = true;
            }
        }
        return blArray;
    }

    private boolean checkHighlightingAreas(int[] nArray) {
        boolean bl = true;
        if (nArray == null || nArray.length == 0 || nArray.length % 2 != 0) {
            bl = false;
        } else {
            int n = -1;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] < 0 || nArray[i2] < n) {
                    bl = false;
                    break;
                }
                n = nArray[i2];
            }
        }
        return bl;
    }

    @Override
    public int getPreferredWidth() {
        String string = this.calculateText();
        if (string == null || string.length() == 0) {
            return 0;
        }
        return this.getEALManager().getTextWidth(string, this.getInheritedFont());
    }

    @Override
    public int getPreferredHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    @Override
    public String getText() {
        return this.calculateText();
    }

    private String getAbbreviatedText() {
        String string = this.calculateText();
        if (string == null) {
            return null;
        }
        IWrappedFont iWrappedFont = this.getInheritedFont();
        if (iWrappedFont == null) {
            return string;
        }
        StringUtility stringUtility = ((HMITerminalEAL)((Object)this.controller.getTerminalImpl())).getStringUtility(iWrappedFont);
        int n = this.controller.getWidth();
        return stringUtility.abbreviateTextEllipsis(string, n, false);
    }

    private String calculateText() {
        return this.controller.getText();
    }

    @Override
    public void disconnect() {
        EALManager eALManager = this.getEALManager();
        if (this.textNode != null) {
            eALManager.destroy(this.textNode);
        }
        this.text = null;
        this.textNode = null;
    }
}

