/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.StringUtilityEAL;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer$1Tag;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITextDescriptorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import java.util.ArrayList;
import java.util.List;

public class TextDescriptorLabelRenderer
extends AbstractRendererHigh
implements LabelRenderer,
Alignment {
    protected int tabulator = 0;
    private int tabulatorLineElementIndex = -1;
    protected int spacing = 0;
    protected int right = 0;
    protected int left = 0;
    private int vAlign = 4;
    private int hAlign = 1;
    protected AbstractWidgetController controller;
    protected IWrappedNode3D[] textNodes;
    private int numLines;
    private int[] numElementsPerLine;
    private int[] preferredWidths;
    private int cachedPreferredWidth;
    protected LineElement[] LineElements;
    private LineElement[][] LineElements2D;
    protected List currentLineDescription;
    protected int textVerticalOffset;
    private int xMax = -1;
    private int xMin = -1;
    private boolean abbreviateText = true;
    private int lastColor = 0;
    private boolean allowLineBreak = false;
    private int lineHeight;
    private boolean updateInPreferredWidth;

    private int calculateActualWidth(LineElement[] lineElementArray) {
        if (lineElementArray != null && lineElementArray.length > 0) {
            int n = lineElementArray.length - 1;
            LineElement lineElement = lineElementArray[n];
            while (!lineElement.nodeVisible && n > 0) {
                lineElement = lineElementArray[--n];
            }
            int n2 = n >= 0 ? lineElement.nodeX + lineElement.widthActual : 0;
            return n2;
        }
        return 0;
    }

    private int[] calculateActualWidths(LineElement[][] lineElementArray) {
        int[] nArray = new int[lineElementArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = this.calculateActualWidth(lineElementArray[i2]);
        }
        return nArray;
    }

    @Override
    public String calculateDisplayData(String string, boolean bl) {
        return string;
    }

    private int calculateNumberOfLines(List list) {
        if (this.allowLineBreak) {
            int n = 1;
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                LineElement lineElement = (LineElement)list.get(i2);
                if (!lineElement.lineBreak || i2 >= n2 - 1) continue;
                ++n;
            }
            return n;
        }
        return 1;
    }

    private int calculatePreferredWidth() {
        if (this.LineElements2D != null) {
            this.preferredWidths = new int[this.LineElements2D.length];
            int n = 0;
            for (int i2 = 0; i2 < this.LineElements2D.length; ++i2) {
                LineElement[] lineElementArray = this.LineElements2D[i2];
                if (lineElementArray.length <= 0) continue;
                LineElement lineElement = lineElementArray[lineElementArray.length - 1];
                int n2 = lineElement.nodeX + lineElement.widthActual + this.left + this.right;
                if (n2 > n) {
                    n = n2;
                }
                this.preferredWidths[i2] = n2;
            }
            return n;
        }
        return 0;
    }

    private int[] calculateXAlignOffset(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            int n;
            nArray2[i2] = n = this.getXAlignOffset(nArray[i2]);
        }
        return nArray2;
    }

    private void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.textNodes != null) {
            int n = this.getYOffset();
            for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                IWrappedNode3D iWrappedNode3D = this.textNodes[i2];
                int n2 = this.controller.getX() + this.left;
                iWrappedNode3D.setPosition(n2, n + this.lineHeight * i2, 0.0f);
                iWrappedNode3D.setSize(this.controller.getWidth(), this.controller.getHeight());
                iWrappedNode3D.setOpacity(this.controller.getRenderOpacity());
                iWrappedNode3D.setVisible(this.controller.shouldRender());
            }
        } else {
            textDescriptorLogCh.log(10000, "TextDescriptorLabelRenderer#applyProperties textNode is null.");
        }
    }

    private void applyXAlignOffset(LineElement[][] lineElementArray, int[] nArray) {
        for (int i2 = 0; i2 < lineElementArray.length; ++i2) {
            LineElement[] lineElementArray2 = lineElementArray[i2];
            int n = nArray[i2];
            for (int i3 = 0; i3 < lineElementArray2.length; ++i3) {
                LineElement lineElement = lineElementArray2[i3];
                lineElement.nodeX += n;
            }
        }
    }

    private void applyHorizontalBounds() {
        for (int i2 = 0; i2 < this.LineElements2D.length; ++i2) {
            this.applyHorizontalBoundsPerLine(this.LineElements2D[i2]);
        }
    }

    private void applyHorizontalBoundsPerLine(LineElement[] lineElementArray) {
        String string;
        int n;
        int n2;
        boolean bl;
        StringUtilityEAL stringUtilityEAL = (StringUtilityEAL)this.getInitContext().getStringUtility();
        if (this.xMin != -1) {
            bl = false;
            for (n2 = 0; n2 < lineElementArray.length; ++n2) {
                LineElement lineElement = lineElementArray[n2];
                int n3 = lineElement.nodeX;
                if (n3 >= this.xMin && !bl) break;
                if (n3 + lineElement.widthActual >= this.xMin) {
                    n = lineElement.widthActual - (this.xMin - n3);
                    IWrappedFont iWrappedFont = (IWrappedFont)lineElement.font;
                    stringUtilityEAL.setCurrentFont(iWrappedFont);
                    int n4 = stringUtilityEAL.getCharWidth('\u2026');
                    if (n >= n4) {
                        String string2 = lineElement.nodeText;
                        if (bl) {
                            string2 = new StringBuffer().append('\u2026').append(string2).toString();
                        }
                        string = stringUtilityEAL.abbreviateTextEllipsis(string2, n, true);
                        int n5 = stringUtilityEAL.getStringWidth(string);
                        lineElement.nodeText = string;
                        int n6 = lineElement.widthActual - n5;
                        lineElement.nodeX += n6;
                        lineElement.widthActual = n5;
                        break;
                    }
                    bl = true;
                }
                lineElement.nodeVisible = false;
                lineElement.widthActual = 0;
            }
        }
        if (this.xMax != -1) {
            bl = false;
            for (int i2 = lineElementArray.length - 1; i2 >= n2; --i2) {
                LineElement lineElement = lineElementArray[i2];
                n = lineElement.nodeX + lineElement.widthActual;
                if (n <= this.xMax && !bl) break;
                if (lineElement.nodeX <= this.xMax) {
                    int n7 = lineElement.widthActual - (n - this.xMax);
                    IWrappedFont iWrappedFont = (IWrappedFont)lineElement.font;
                    stringUtilityEAL.setCurrentFont(iWrappedFont);
                    int n8 = stringUtilityEAL.getCharWidth('\u2026');
                    if (n7 >= n8) {
                        string = lineElement.nodeText;
                        if (bl) {
                            string = new StringBuffer().append(string).append('\u2026').toString();
                        }
                        String string3 = stringUtilityEAL.abbreviateTextEllipsis(string, n7, false);
                        lineElement.widthActual = stringUtilityEAL.getStringWidth(string3);
                        lineElement.nodeText = string3;
                        break;
                    }
                    bl = true;
                }
                lineElement.nodeVisible = false;
                lineElement.widthActual = 0;
            }
        }
    }

    private void createLineElementNodes(LineElement[][] lineElementArray, IWrappedNode3D[] iWrappedNode3DArray, EALManager eALManager, int n) {
        for (int i2 = 0; i2 < lineElementArray.length; ++i2) {
            LineElement[] lineElementArray2 = lineElementArray[i2];
            IWrappedNode3D iWrappedNode3D = iWrappedNode3DArray[i2];
            for (int i3 = 0; i3 < lineElementArray2.length; ++i3) {
                LineElement lineElement = lineElementArray2[i3];
                if (lineElement.node != null) {
                    eALManager.destroy((IWrappedNode3D)lineElement.node);
                }
                IWrappedNode3D iWrappedNode3D2 = null;
                if (lineElement.bitmapIndex != -1) {
                    iWrappedNode3D2 = eALManager.createImage3D(iWrappedNode3D, EALManager.createNodeName("element_bitmap", lineElement.bitmapIndex, (AbstractRenderer)this), this.getTextureDescription(lineElement.bitmapIndex, true), 0, true, (Object)this);
                } else {
                    IWrappedNode3DText iWrappedNode3DText = eALManager.createText3D(iWrappedNode3D, EALManager.createNodeName("element_text", i2, (AbstractRenderer)this), lineElement.nodeText, (IWrappedFont)lineElement.font);
                    iWrappedNode3DText.setText(lineElement.nodeText, (IWrappedFont)lineElement.font);
                    textDescriptorLogCh.log(-2137614336, "TextDescriptorLabelRenderer#createLineElementsNodes Create textNode with text = %1, font = %2", (Object)lineElement.text, lineElement.font);
                    iWrappedNode3DText.getInterfaceText().setColor(n);
                    iWrappedNode3D2 = iWrappedNode3DText;
                }
                lineElement.node = iWrappedNode3D2;
                iWrappedNode3D2.setPosition(lineElement.nodeX, lineElement.nodeY, 0.0f);
                iWrappedNode3D2.setVisible(lineElement.nodeVisible);
            }
        }
    }

    private void calculateLineElementBounds(LineElement[] lineElementArray, IWrappedFont[] iWrappedFontArray, EALManager eALManager) {
        if (lineElementArray == null) {
            return;
        }
        int n = 0;
        this.setMaxExtends(0, this.controller.getWidth());
        this.numElementsPerLine = new int[this.numLines];
        int n2 = 0;
        for (int i2 = 0; i2 < lineElementArray.length; ++i2) {
            int n3;
            LineElement lineElement = lineElementArray[i2];
            int n4 = -1;
            if (lineElement.bitmapIndex != -1) {
                textDescriptorLogCh.log(1078071040, "TextDescriptorLabelRenderer#createLineElementNodes e.bitmapIndex ", (long)lineElement.bitmapIndex);
            } else {
                for (n3 = lineElement.fontIndex; iWrappedFontArray.length <= n3; --n3) {
                }
                IWrappedFont iWrappedFont = iWrappedFontArray[n3];
                lineElement.font = iWrappedFont;
                n4 = eALManager.getTextWidth(lineElement.text, iWrappedFont);
            }
            lineElement.x = n2;
            n3 = n2;
            if (lineElement.getWidth() != -1) {
                switch (lineElement.h_align) {
                    case 3: {
                        n3 += lineElement.getWidth() - n4;
                        break;
                    }
                    case 2: {
                        n3 += (lineElement.getWidth() - n4) / 2;
                        break;
                    }
                    case 1: {
                        break;
                    }
                }
                n2 += lineElement.getWidth();
                lineElement.widthActual = lineElement.getWidth();
            } else {
                if (lineElement.h_align == 20 && this.hAlign == 20) {
                    this.tabulatorLineElementIndex = i2;
                }
                n2 += n4;
                lineElement.widthActual = n4;
            }
            int n5 = 0;
            switch (lineElement.v_align) {
                case 4: {
                    int n6;
                    for (n6 = lineElement.fontIndex; n6 >= iWrappedFontArray.length; --n6) {
                    }
                    if (n6 < lineElement.fontIndex) {
                        textDescriptorLogCh.log(-1601830656, "TextDescriptorLabelRenderer#createLineElementNodes Font with index %1 has not been set.", (long)lineElement.fontIndex);
                    }
                    n5 = -EALManager.getFontHeightUppercase(iWrappedFontArray[0]) + EALManager.getFontHeightUppercase(iWrappedFontArray[n6]);
                    break;
                }
            }
            n2 += this.spacing + lineElement.space;
            lineElement.nodeX = n3;
            lineElement.nodeY = n5;
            lineElement.nodeText = lineElement.text;
            lineElement.nodeVisible = true;
            lineElement.setLineIndex(n);
            int n7 = n++;
            this.numElementsPerLine[n7] = this.numElementsPerLine[n7] + 1;
            if (!this.allowLineBreak || !lineElement.lineBreak) continue;
            n2 = 0;
        }
    }

    protected IWrappedNode3D destroyNode(IWrappedNode3D iWrappedNode3D) {
        EALManager eALManager = this.getEALManager();
        if (iWrappedNode3D != null) {
            eALManager.destroy(iWrappedNode3D);
        }
        return null;
    }

    protected void destroyTextElementNodes() {
        if (this.LineElements != null) {
            for (int i2 = 0; i2 < this.LineElements.length; ++i2) {
                if (this.LineElements[i2] == null || this.LineElements[i2].node == null) continue;
                this.LineElements[i2].node = this.destroyNode((IWrappedNode3D)this.LineElements[i2].node);
            }
        }
    }

    private void destroyTextNodes() {
        if (this.textNodes != null) {
            for (int i2 = 0; i2 < this.textNodes.length; ++i2) {
                this.destroyNode(this.textNodes[i2]);
            }
            this.textNodes = null;
        }
    }

    @Override
    public void disconnect() {
        this.destroyTextElementNodes();
        this.destroyTextNodes();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected static LineElement[] parseTextDescriptor(StringBuffer stringBuffer) {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        if (stringBuffer == null) {
            textDescriptorLogCh.log(-1601830656, "TextDescriptorRenderer#parseTextDescriptor Text descriptor is null.");
            return null;
        }
        String string = stringBuffer.toString();
        textDescriptorLogCh.log(-2137614336, "TextDescriptorRenderer#parseTextDescriptor Text descriptor = %1", (Object)string);
        int n = 0;
        int n2 = string.indexOf(36);
        while (n2 != -1) {
            objectArray = new LineElement();
            arrayList.add(objectArray);
            String string2 = string.substring(n, n2);
            int n3 = string2.lastIndexOf(91);
            if (n3 != -1) {
                int n4 = string2.lastIndexOf(93);
                String string3 = string2.substring(n3 + 1, n4);
                TextDescriptorLabelRenderer.parseArguments(string3, (LineElement)objectArray);
                string2 = string2.substring(0, n3);
            }
            if (string2.length() == 0) {
                n = n2 + 1;
                n2 = string.indexOf(36, n);
                continue;
            }
            objectArray.text = string2;
            n = n2 + 1;
            n2 = string.indexOf(36, n);
        }
        objectArray = new LineElement[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public static List parseTextDescriptorAsList(StringBuffer stringBuffer) {
        LineElement[] lineElementArray = TextDescriptorLabelRenderer.parseTextDescriptor(stringBuffer);
        ArrayList arrayList = new ArrayList();
        if (lineElementArray != null) {
            for (int i2 = 0; i2 < lineElementArray.length; ++i2) {
                arrayList.add(lineElementArray[i2]);
            }
        }
        return arrayList;
    }

    protected static void parseArguments(String string, LineElement lineElement) {
        ArrayList arrayList = new ArrayList();
        int n = 0;
        int n2 = string.indexOf(44);
        while (n2 != -1) {
            arrayList.add(string.substring(n, n2));
            n = n2 + 1;
            n2 = string.indexOf(44, n);
        }
        arrayList.add(string.substring(n, string.length()));
        while (arrayList.size() > 0) {
            String string2 = (String)arrayList.remove(0);
            int n3 = string2.indexOf(61);
            String string3 = string2.substring(0, n3);
            String string4 = string2.substring(n3 + 1, string2.length());
            if (string3.equals("w")) {
                lineElement.setWidth(Integer.parseInt(string4));
                continue;
            }
            if (string3.equals("a")) {
                if (string4.equals("center")) {
                    lineElement.h_align = 2;
                    continue;
                }
                if (string4.equals("right")) {
                    lineElement.h_align = 3;
                    continue;
                }
                if (string4.equals("left")) {
                    lineElement.h_align = 1;
                    continue;
                }
                if (!string4.equals("top")) continue;
                lineElement.v_align = 4;
                continue;
            }
            if (string3.equals("bmp")) {
                lineElement.bitmapIndex = Integer.parseInt(string4);
                continue;
            }
            if (string3.equals("font")) {
                lineElement.fontIndex = Integer.parseInt(string4);
                continue;
            }
            if (string3.equals("space")) {
                lineElement.space = Integer.parseInt(string4);
                continue;
            }
            if (string3.equals("tab")) {
                lineElement.h_align = 20;
                lineElement.tabulatorIndex = Integer.parseInt(string4);
                continue;
            }
            if (!string3.equals("nl")) continue;
            lineElement.lineBreak = true;
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        int n;
        EALManager eALManager = ((HMITerminalEAL)((Object)this.getTerminal())).getEALManager();
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNode;
        List list = ((ITextDescriptorController)((Object)this.controller)).getLineDescription();
        if (list == null) {
            textDescriptorLogCh.log(10000, "TextDescriptorRenderer#render Line description is null.");
            list = new ArrayList();
        }
        this.numLines = this.calculateNumberOfLines(list);
        if (this.textNodes != null && this.textNodes.length != this.numLines) {
            this.destroyTextElementNodes();
            this.destroyTextNodes();
        }
        boolean bl = false;
        if (this.textNodes == null) {
            this.textNodes = new IWrappedNode3D[this.numLines];
            for (n = 0; n < this.numLines; ++n) {
                Buffer buffer = new Buffer();
                buffer.append("textDescriptorRootLine");
                buffer.append(n);
                this.textNodes[n] = eALManager.createNode3D(iWrappedNode3D, EALManager.createNodeName(buffer.toString(), this), 0.0f, 0.0f);
            }
            bl = true;
        }
        n = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        int n2 = EALManager.createColorCode(n);
        if (!TextDescriptorLabelRenderer.equalLineDescription(this.currentLineDescription, list) || bl || this.updateInPreferredWidth) {
            int[] nArray;
            this.destroyTextElementNodes();
            this.lineDescriptionListToArray(list);
            this.currentLineDescription = list;
            this.numLines = this.calculateNumberOfLines(list);
            this.calculateLineElementBounds(this.LineElements, redrawContextHigh.getFonts(), eALManager);
            this.LineElements2D = this.splitLines(this.LineElements, this.numElementsPerLine.length, this.numElementsPerLine);
            this.cachedPreferredWidth = this.calculatePreferredWidth();
            if (this.hAlign == 20) {
                nArray = this.calculateXAlignOffset(this.preferredWidths);
                this.applyXAlignOffset(this.LineElements2D, nArray);
            }
            if (this.abbreviateText) {
                this.applyHorizontalBounds();
            }
            if (this.hAlign != 20) {
                nArray = this.calculateActualWidths(this.LineElements2D);
                int[] nArray2 = this.calculateXAlignOffset(nArray);
                this.applyXAlignOffset(this.LineElements2D, nArray2);
            }
            this.createLineElementNodes(this.LineElements2D, this.textNodes, eALManager, n2);
            this.updateInPreferredWidth = false;
        } else if (this.lastColor != n) {
            int n3 = this.LineElements.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!(this.LineElements[i2].node instanceof IWrappedNode3DText)) continue;
                ((IWrappedNode3DText)this.LineElements[i2].node).setColor(n2);
            }
            this.lastColor = n;
        }
        this.applyProperties((RedrawContextHigh)redrawContext);
    }

    public TextDescriptorLabelRenderer(AbstractWidgetController abstractWidgetController) {
        this.controller = abstractWidgetController;
        if (!(abstractWidgetController instanceof ITextDescriptorController)) {
            textDescriptorLogCh.log(-1601830656, "TextDescriptorRenderer#TextDescriptorRenderer Supplied Controller ist not an instance of ITextDescriptorController!");
        }
    }

    @Override
    public int getPreferredWidth() {
        EALManager eALManager = this.getEALManager();
        List list = ((ITextDescriptorController)((Object)this.controller)).getLineDescription();
        if (list != null && !TextDescriptorLabelRenderer.equalLineDescription(this.currentLineDescription, list)) {
            this.destroyTextElementNodes();
            this.lineDescriptionListToArray(list);
            this.currentLineDescription = list;
            this.numLines = this.calculateNumberOfLines(list);
            this.calculateLineElementBounds(this.LineElements, this.getInheritedFonts(), eALManager);
            this.LineElements2D = this.splitLines(this.LineElements, this.numElementsPerLine.length, this.numElementsPerLine);
            this.cachedPreferredWidth = this.calculatePreferredWidth();
            this.updateInPreferredWidth = true;
        }
        return this.cachedPreferredWidth;
    }

    @Override
    public int getPreferredHeight() {
        return EALManager.getFontHeightUppercase(this.getInheritedFont());
    }

    @Override
    public int getNumberOfRows(int n) {
        return 0;
    }

    @Override
    public String getText() {
        if (this.LineElements != null) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < this.LineElements.length; ++i2) {
                if (this.LineElements[i2].text == null) continue;
                buffer.append(this.LineElements[i2].text);
            }
            return buffer.toString();
        }
        return "";
    }

    private int getXAlignOffset(int n) {
        int n2 = 0;
        if (this.hAlign != 20) {
            n2 = LabelRendererHigh.getAlignmentOffsetX(n, this.controller.getWidth(), this.hAlign);
        } else if (this.tabulatorLineElementIndex != -1) {
            n2 = this.tabulator - this.LineElements[this.tabulatorLineElementIndex].nodeX;
        }
        return n2;
    }

    private int getYOffset() {
        int n = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getHeight(), this.vAlign);
        return this.controller.getY() + n + this.textVerticalOffset;
    }

    public void setAbbreviateText(boolean bl) {
        this.abbreviateText = bl;
    }

    @Override
    public void setAlignment(int n, int n2) {
        this.vAlign = n2;
        this.hAlign = n;
    }

    public void setAllowLineBreak(boolean bl) {
        this.allowLineBreak = bl;
    }

    @Override
    public int getBaseline() {
        return 0;
    }

    @Override
    public boolean hasContent() {
        return true;
    }

    private static boolean equalLineDescription(List list, List list2) {
        int n;
        int n2;
        if (Util.equals(list, list2)) {
            return true;
        }
        if (list != null && list2 != null && (n2 = list.size()) == (n = list2.size())) {
            for (int i2 = 0; i2 < n2; ++i2) {
                LineElement lineElement;
                LineElement lineElement2 = (LineElement)list.get(i2);
                if (lineElement2.identical(lineElement = (LineElement)list2.get(i2))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isTextDescriptorSupported() {
        return true;
    }

    private void lineDescriptionListToArray(List list) {
        textDescriptorLogCh.log(-2137614336, "TextDescriptorLabelRenderer#lineDescriptionListToArray t = %1", (Object)list);
        if (list != null) {
            this.LineElements = new LineElement[list.size()];
            list.toArray(this.LineElements);
        } else {
            this.LineElements = new LineElement[0];
        }
    }

    @Override
    public int getPreferredLineHeight() {
        return this.getPreferredHeight();
    }

    @Override
    public int getFontHeight() {
        return this.getPreferredHeight();
    }

    @Override
    public void setFirstVisibleLine(int n) {
        textDescriptorLogCh.log(10000, "TextDescriptorLabelRenderer#setFirstVisibleLine: firstRendereredLine is not supported in this renderer");
    }

    public void setTabulator(int n) {
        this.tabulator = n;
    }

    public void setTextVerticalOffset(int n) {
        this.textVerticalOffset = n;
    }

    private LineElement[][] splitLines(LineElement[] lineElementArray, int n, int[] nArray) {
        if (this.allowLineBreak) {
            LineElement[][] lineElementArray2 = new LineElement[n][];
            int n2 = 0;
            int n3 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                lineElementArray2[i2] = new LineElement[nArray[i2]];
                n2 = 0;
                while (n3 < lineElementArray.length && lineElementArray[n3].getLineIndex() == i2) {
                    lineElementArray2[i2][n2] = lineElementArray[n3];
                    ++n2;
                    ++n3;
                }
            }
            return lineElementArray2;
        }
        return new LineElement[][]{lineElementArray};
    }

    public static StringBuffer createTextDescriptorFromMetricsData(String string) {
        Object object;
        TextDescriptorLabelRenderer$1Tag textDescriptorLabelRenderer$1Tag;
        int n;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = string.length();
        boolean bl3 = bl;
        int n3 = 0;
        ArrayList arrayList = new ArrayList();
        for (n = 0; n < n2; ++n) {
            char c2 = string.charAt(n);
            if (!('0' <= c2 && c2 <= ':' || c2 == '-' || '\u00bc' <= c2 && c2 <= '\u00be')) {
                if (bl3 != bl) continue;
                arrayList.add(new TextDescriptorLabelRenderer$1Tag(n3, n, bl3));
                n3 = n;
                bl3 = bl2;
                continue;
            }
            if (bl3 != bl2) continue;
            arrayList.add(new TextDescriptorLabelRenderer$1Tag(n3, n, bl3));
            n3 = n;
            bl3 = bl;
        }
        arrayList.add(new TextDescriptorLabelRenderer$1Tag(n3, n, bl3));
        if (arrayList.size() >= 2) {
            TextDescriptorLabelRenderer$1Tag textDescriptorLabelRenderer$1Tag2 = null;
            textDescriptorLabelRenderer$1Tag = (TextDescriptorLabelRenderer$1Tag)arrayList.get(0);
            object = (TextDescriptorLabelRenderer$1Tag)arrayList.get(1);
            for (n = 2; n < arrayList.size(); ++n) {
                CharSequence charSequence;
                textDescriptorLabelRenderer$1Tag2 = textDescriptorLabelRenderer$1Tag;
                textDescriptorLabelRenderer$1Tag = object;
                object = (TextDescriptorLabelRenderer$1Tag)arrayList.get(n);
                if (textDescriptorLabelRenderer$1Tag.x1 - textDescriptorLabelRenderer$1Tag.x0 != 1 || textDescriptorLabelRenderer$1Tag2.font != bl || ((TextDescriptorLabelRenderer$1Tag)object).font != bl || !(charSequence = string.subSequence(textDescriptorLabelRenderer$1Tag.x0, textDescriptorLabelRenderer$1Tag.x1)).equals(",") && !charSequence.equals(".") && !charSequence.equals(":")) continue;
                textDescriptorLabelRenderer$1Tag2.x1 = ((TextDescriptorLabelRenderer$1Tag)object).x1;
                textDescriptorLabelRenderer$1Tag.valid = false;
                ((TextDescriptorLabelRenderer$1Tag)object).valid = false;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (arrayList.size() > 0) {
            textDescriptorLabelRenderer$1Tag = (TextDescriptorLabelRenderer$1Tag)arrayList.remove(0);
            if (!textDescriptorLabelRenderer$1Tag.valid) continue;
            object = string.substring(textDescriptorLabelRenderer$1Tag.x0, textDescriptorLabelRenderer$1Tag.x1);
            stringBuffer.append((String)object);
            int n4 = textDescriptorLabelRenderer$1Tag.font ? 0 : 1;
            stringBuffer.append(new StringBuffer().append("[font=").append(n4).toString());
            if (((String)object).indexOf("am") != -1 || ((String)object).indexOf("AM") != -1) {
                stringBuffer.append(',');
                stringBuffer.append("a=top");
            }
            stringBuffer.append("]");
            stringBuffer.append('$');
        }
        return stringBuffer;
    }

    @Override
    public void setAutoWrap(int n) {
        logChannel.log(-2137614336, "TextDescriptorLabelRenderer#setAutoWrap: wrapMode = %1", (long)n);
        this.setAllowLineBreak(n == 0);
    }

    private void setMaxExtends(int n, int n2) {
        this.xMin = n;
        this.xMax = n2;
    }

    public void setMaxLines(int n) {
        logChannel.log(10000, "TextDescriptorLabelRenderer#setMaxLines: not supported in this renderer");
    }

    @Override
    public void setLineHeight(int n) {
        this.lineHeight = n;
    }

    @Override
    public int getLineHeight() {
        return this.lineHeight;
    }
}

