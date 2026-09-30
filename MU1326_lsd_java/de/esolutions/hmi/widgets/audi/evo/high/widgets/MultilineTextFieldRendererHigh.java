/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.multiline.TextNodeManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.IMultilineTextFiledRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.GhostCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MLDisplayData;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.SChar;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ViewPort;
import java.util.ArrayList;
import java.util.HashMap;

public class MultilineTextFieldRendererHigh
extends AbstractKanziTemplateRenderer
implements IMultilineTextFiledRenderer {
    private static final int PROPER_CLIPPING_MODE = 17;
    public static final int WORD_SELECTED_COLOR = -1;
    public static final int WORD_NOT_SELECTED_COLOR = -7368817;
    public static final int WORD_CURSOR_COLOR = -10180096;
    public static final int CHAR_CURSOR_COLOR = -1;
    public static final int IDX_COLOR_WORD_SELECTED = 0;
    public static final int IDX_COLOR_WORD_NOT_SELECTED = 1;
    public static final int SPACE_FROM_RIGHT_BORDER = 30;
    public static final int CHAR_CURSOR_WIDTH = 2;
    private int posYMagicOffset = 1;
    private int heightMagicOffset = this.posYMagicOffset * 2;
    private int posXMagicOffset = 1;
    private int widthMagicOffset = this.posXMagicOffset * 2;
    private int cursorCharModeStringDisplacement = 5;
    private int cursorCharAdditionalHeightOverflow = 7;
    public static final int[] CURSOR_HEIGHT_PADDING = new int[]{3, 3};
    private static int layoutCursorHeightPadding = CURSOR_HEIGHT_PADDING[0];
    private IWrappedNode3D rootNode;
    private IWrappedNode3D clipNode;
    private IWrappedNode3DQuickDraw cursorNodeChar;
    private MultilineTextFieldController controller;
    private MLDisplayData displayData = null;
    private int currW = 0;
    private int currH = 0;
    private int fontHight = 0;
    private int currsorOffsetFromChar = 1;
    private int[] colors;
    private int[] colors2;
    private int charCursorColor;
    private int wordCursorColor;
    private ArrayList cursorLines;
    private ArrayList prefabCursorNodes = new ArrayList();
    private int previousChar = -1;
    private int previousCursorMode = -1;
    private boolean previousSpellerStateActive = false;
    private TextNodeManager textNodeManager;
    private int fontSize;
    private int fontAscent;
    private int fontDescent;
    private int lineHeight;
    private EALManager ealManager = null;
    private IWrappedFont font = null;
    private HashMap charWidthMap = null;
    private int lineStartXOffset = 0;
    private IWrappedNode3DText textNodeDescriptiveText;
    private static final int DESCRIPTIVE_TEXT_OFFSET = 25;

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        layoutCursorHeightPadding = CURSOR_HEIGHT_PADDING[MultilineTextFieldController.layoutConfigIDX()];
        this.font = this.getInheritedFont();
        this.ealManager = this.getEALManager();
        this.initColors();
        this.charWidthMap = new HashMap();
        this.fontSize = this.font.getSize();
        this.fontAscent = this.font.getFontGroup().getAscent(this.fontSize);
        this.fontDescent = this.font.getFontGroup().getDescent(this.fontSize);
        this.lineHeight = this.fontAscent - this.fontDescent + 1;
        if (this.textNodeManager != null) {
            this.textNodeManager.init();
        }
    }

    public MultilineTextFieldRendererHigh(MultilineTextFieldController multilineTextFieldController) {
        this.controller = multilineTextFieldController;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

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
        GhostCursor ghostCursor = null;
        this.displayData = this.controller.getLinifiedData();
        ghostCursor = this.displayData.ghostCursor;
        if (ghostCursor != null) {
            this.cursorLines = this.computeCursoredLines(ghostCursor);
            this.initAndUpdateNodes(redrawContextHigh, ghostCursor);
            this.applyProperties(redrawContextHigh);
        }
    }

    public void disconnect() {
        if (this.ealManager != null) {
            if (this.textNodeManager != null) {
                this.textNodeManager.deinit();
            }
            this.deinitCursorNodes();
            this.ealManager.destroy(this.clipNode);
            this.ealManager.destroy(this.textNodeDescriptiveText);
            super.disconnect();
            this.ealManager.destroy(this.rootNode);
        } else {
            super.disconnect();
        }
        this.deinitColors();
        this.charWidthMap = null;
        this.rootNode = null;
        this.displayData = null;
        this.ealManager = null;
        this.clipNode = null;
        this.textNodeManager = null;
        this.textNodeDescriptiveText = null;
    }

    protected String getTemplateNodePath() {
        return "Prefabs/generic_inputField";
    }

    protected String getEALNodeName() {
        return "MultiLineTextField" + this.hashCode();
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (!(this.rootNode != null && this.rootNode.isValid() && this.node != null && this.node.isValid() && this.clipNode != null && this.clipNode.isValid())) {
            return;
        }
        this.rootNode.setPosition(-this.posXMagicOffset, this.controller.getY() - this.posYMagicOffset, 0.0f);
        this.rootNode.setSize(this.controller.getWidth() + this.controller.getX() + this.widthMagicOffset, this.controller.getHeight() + this.heightMagicOffset + 1);
        this.rootNode.setClipping(true);
        this.rootNode.setVisible(true);
        this.node.setPosition(this.controller.getOffsetBecauseOfLabel(), 0.0f, 0.0f);
        this.node.setClipping(false);
        this.node.setClippingRectangle(this.controller.getX(), 0.0f, this.controller.getWidth() + this.controller.getX(), this.controller.getHeight() + this.heightMagicOffset);
        this.node.useClippingRectangle(true);
        this.node.setVisible(true);
        int n = (int)this.controller.currentAnim.viewPort.y;
        int n2 = (int)this.controller.currentAnim.viewPort.h;
        this.clipNode.setClippingRectangle(this.controller.getX(), n, this.controller.getWidth() + this.controller.getX(), n2);
        int n3 = ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(this.getInheritedFont()).calculateBaselineY(this.controller.getHeight(), 5) - 5;
        int n4 = this.renderDescriptiveText(redrawContextHigh, n3);
        this.node.setPosition(this.node.getX() + (float)n4, this.node.getY(), this.node.getZ());
        int n5 = this.controller.getDescriptiveText() != null ? 25 : 0;
        this.setProperty("if_inputWidth", this.controller.getInputFieldWidth() - n5 - this.controller.getOffsetBecauseOfLabel());
        this.setProperty("if_inputHeight", this.controller.getHeight() - (this.controller.isSpellerActive() ? this.controller.getSpeller().getHeight() + 6 : -this.heightMagicOffset));
        this.setProperty("if_iconVisible", 0.0f);
        this.setProperty("if_languageIndicator", this.controller.getLanguageIndicatorIconIndex());
        this.setProperty("if_languageIndicatorPos2", 1.0f);
        this.setProperty("if_spellerWidth", this.controller.getInputFieldWidth() - n5 - this.controller.getOffsetBecauseOfLabel());
        this.setProperty("if_spellerHeight", this.controller.getHeight() + this.heightMagicOffset);
        this.setProperty("if_spellerActive", this.controller.currentAnim.spellerOpeningProgress);
    }

    public int getLineHeight() {
        return this.lineHeight;
    }

    public int getLineOffsetY() {
        return this.fontAscent - 1;
    }

    public int getYTranslation() {
        return 0;
    }

    public int getCharWidth(char c2) {
        Character c3 = new Character(c2);
        CharWidthValue charWidthValue = (CharWidthValue)this.charWidthMap.get(c3);
        if (charWidthValue == null) {
            charWidthValue = new CharWidthValue((byte)this.ealManager.getTextWidth(String.valueOf(c2), this.font));
            this.charWidthMap.put(c3, charWidthValue);
        }
        return charWidthValue.width;
    }

    public int getStringW(String string) {
        return this.ealManager.getTextWidth(string, this.font);
    }

    public float getAbsLineIdxPos(int n) {
        ViewPort viewPort = this.controller.getViewPort();
        return (float)this.getLineOffsetY() + viewPort.y + (float)(n * this.getLineHeight()) - viewPort.vpY;
    }

    private void initColors() {
        int[] nArray;
        int[] nArray2;
        if (this.colors == null) {
            int[] nArray3 = new int[4];
            nArray3[0] = EALManager.createColorCode(-7368817);
            nArray3[1] = EALManager.createColorCode(-1);
            nArray3[2] = EALManager.createColorCode(-1);
            nArray2 = nArray3;
            nArray3[3] = EALManager.createColorCode(-7368817);
        } else {
            nArray2 = this.colors = this.colors;
        }
        if (this.colors2 == null) {
            int[] nArray4 = new int[3];
            nArray4[0] = EALManager.createColorCode(-7368817);
            nArray4[1] = EALManager.createColorCode(-1);
            nArray = nArray4;
            nArray4[2] = EALManager.createColorCode(-7368817);
        } else {
            nArray = this.colors2;
        }
        this.colors2 = nArray;
        this.charCursorColor = EALManager.createColorCode(-1);
        this.wordCursorColor = EALManager.createColorCode(-10180096);
    }

    private void deinitColors() {
        if (this.colors != null) {
            this.colors = null;
        }
        if (this.colors2 != null) {
            this.colors2 = null;
        }
    }

    private void initAndUpdateNodes(RedrawContextHigh redrawContextHigh, GhostCursor ghostCursor) {
        int n;
        int n2;
        if (this.displayData == null) {
            return;
        }
        int n3 = redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth());
        if (this.rootNode == null) {
            this.lineStartXOffset = this.controller.getX() + this.controller.getLineOffsetX();
            redrawContextHigh.parentNode.setClippingInheritance(17);
            this.rootNode = this.ealManager.createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("multilineTextfield", this), 0.0f, 0.0f, n3);
            this.rootNode.setClippingInheritance(17);
            this.fontHight = EALManager.getFontHeightUppercase(this.font);
        } else {
            this.rootNode.setNodeIndex(n3);
        }
        if (this.node == null) {
            this.node = this.createNode(this.rootNode, 0);
            if (this.node != null && this.node.isValid()) {
                this.node.setClippingInheritance(17);
                this.setProperty("if_spellerSingleline", false);
            }
        }
        if (this.clipNode == null) {
            this.clipNode = this.ealManager.createNode3D(this.node, EALManager.createNodeName("multilineTextfield_clipNode", this), 0.0f, 0.0f);
            if (this.clipNode != null && this.clipNode.isValid()) {
                this.clipNode.setClippingInheritance(17);
                this.clipNode.useClippingRectangle(true);
                this.clipNode.setClipping(true);
                n2 = (int)this.controller.targetAnim.viewPort.y;
                n = (int)this.controller.targetAnim.viewPort.h;
                this.clipNode.setClippingRectangle(this.controller.getX(), n2, this.controller.getWidth() + this.controller.getX(), n);
            }
            this.textNodeManager = TextNodeManager.newInstance(this.ealManager, this, this.font, this.clipNode);
            this.textNodeManager.init();
        }
        n2 = ghostCursor.currentCharIdx();
        n = ghostCursor.getCursorMode();
        boolean bl = this.controller.isSpellerActive();
        boolean bl2 = this.previousChar != n2 || this.previousCursorMode != n || this.previousSpellerStateActive != bl;
        this.displayData.setNeedsRendering(this.displayData.needsRendering || bl2);
        this.displayData.setLinesNeedRepos(this.displayData.linesNeedRepos || bl2);
        this.previousChar = n2;
        this.previousCursorMode = n;
        this.previousSpellerStateActive = bl;
        if (this.cursorNodeChar != null && (this.currW < this.controller.getWidth() || this.currH < this.controller.getHeight())) {
            this.ealManager.destroy(this.cursorNodeChar);
            this.cursorNodeChar = null;
        }
        if (this.cursorNodeChar == null) {
            this.currW = this.controller.getWidth();
            this.currH = this.controller.getHeight();
            this.cursorNodeChar = this.ealManager.createQuickDrawNode3D(this.clipNode, EALManager.createNodeName("multilineTextField_Cursor", this), this.currW, this.currH, 0);
            this.cursorNodeChar.setClippingInheritance(17);
            this.cursorNodeChar.setLineWidth(2.0f);
        }
        if (this.displayData.needsRendering || this.displayData.linesNeedRepos) {
            if (this.controller.isFocused() && !this.controller.isDisableInput()) {
                this.updateCursorNodes(ghostCursor);
            } else {
                this.makeLineCursorsInvisible(0);
                this.cursorNodeChar.setVisible(false);
            }
            if (this.displayData.linesNeedRepos) {
                this.updateTextNodes(ghostCursor, this.displayData);
                this.displayData.linesNeedRepos = false;
            }
            this.displayData.needsRendering = false;
        }
    }

    private void updateTextNodes(GhostCursor ghostCursor, MLDisplayData mLDisplayData) {
        ArrayList arrayList = this.cursorLines;
        HashMap hashMap = new HashMap();
        int n = Math.max(0, this.controller.getViewPort().vpFirstVisibleLine);
        int n2 = Math.min(mLDisplayData.sCharLines.size(), this.controller.getViewPort().vpLastVisibleLine);
        int n3 = ghostCursor.getCurrentWordType() == 0 && arrayList != null && arrayList.size() == 1 ? (int)((SChar[])arrayList.get((int)0))[0].line : -1;
        int n4 = n3 == -1 && ghostCursor.getCurrentWordType() == 3 ? (int)((SChar[])arrayList.get((int)0))[0].line : -1;
        for (int i2 = n; i2 <= n2; ++i2) {
            SChar[] sCharArray = null;
            if (n3 != i2 && n4 != i2 && arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                    sCharArray = (SChar[])arrayList.get(i3);
                    if (sCharArray[0].line == i2) break;
                    sCharArray = null;
                }
            }
            float f2 = this.getAbsLineIdxPos(i2);
            if (sCharArray != null && this.controller.isFocused() && !this.controller.isDisableInput()) {
                this.updatePartitionedLine(i2, f2, mLDisplayData, sCharArray, hashMap);
                continue;
            }
            this.updateSimpleLine(i2, f2, mLDisplayData, n3, 0, hashMap);
        }
        if (this.textNodeManager != null) {
            this.textNodeManager.purgeUsedNodes(hashMap);
        }
    }

    private void updatePartitionedLine(int n, float f2, MLDisplayData mLDisplayData, SChar[] sCharArray, HashMap hashMap) {
        int[] nArray;
        int[] nArray2;
        GhostCursor ghostCursor = mLDisplayData.ghostCursor;
        int n2 = ghostCursor.currentCharIdx();
        SChar sChar = n2 > -1 ? (SChar)mLDisplayData.charMetaData.get(n2) : null;
        boolean bl = ghostCursor.getCursorMode() == 1 && sChar != null && sChar.line == n;
        short[] sArray = (short[])mLDisplayData.sCharLines.get(n);
        if (bl) {
            int[] nArray3 = new int[4];
            nArray3[0] = sCharArray[0].idx - sArray[0];
            nArray3[1] = n2 - sCharArray[0].idx + 1;
            nArray3[2] = sCharArray[1].idx - n2;
            nArray2 = nArray3;
            nArray3[3] = sArray[1] - sCharArray[1].idx;
        } else {
            int[] nArray4 = new int[3];
            nArray4[0] = sCharArray[0].idx - sArray[0];
            nArray4[1] = sCharArray[1].idx - sCharArray[0].idx + 1;
            nArray2 = nArray4;
            nArray4[2] = sArray[1] - sCharArray[1].idx;
        }
        int[] nArray5 = nArray2;
        if (bl) {
            int[] nArray6 = new int[4];
            nArray6[0] = 0;
            nArray6[1] = sCharArray[0].x;
            nArray6[2] = sChar.x + sChar.w + this.cursorCharModeStringDisplacement;
            nArray = nArray6;
            nArray6[3] = sCharArray[1].x + sCharArray[1].w + this.cursorCharModeStringDisplacement;
        } else {
            int[] nArray7 = new int[3];
            nArray7[0] = 0;
            nArray7[1] = sCharArray[0].x;
            nArray = nArray7;
            nArray7[2] = sCharArray[1].x + sCharArray[1].w;
        }
        int[] nArray8 = nArray;
        String string = ghostCursor.getString();
        int n3 = nArray5.length;
        int n4 = sArray[0];
        for (int i2 = 0; i2 < n3; ++i2) {
            if (nArray5[i2] <= 0) continue;
            String string2 = string.substring(n4, n4 + nArray5[i2]);
            n4 += nArray5[i2];
            if (this.textNodeManager == null) continue;
            this.textNodeManager.addTextNode(string2, hashMap, bl ? (long)this.colors[i2] : (long)this.colors2[i2], this.lineStartXOffset + nArray8[i2], f2);
        }
    }

    private void updateSimpleLine(int n, float f2, MLDisplayData mLDisplayData, int n2, int n3, HashMap hashMap) {
        GhostCursor ghostCursor = mLDisplayData.ghostCursor;
        if (n < mLDisplayData.sCharLines.size()) {
            int n4;
            short[] sArray = (short[])mLDisplayData.sCharLines.get(n);
            String string = ghostCursor.getString().substring(sArray[0], sArray[1] + 1);
            int n5 = n4 = n == n2 ? n3 : 0;
            if (this.textNodeManager != null) {
                this.textNodeManager.addTextNode(string, hashMap, this.colors[0], n4 + this.lineStartXOffset, f2);
            }
        }
    }

    private ArrayList computeCursoredLines(GhostCursor ghostCursor) {
        ArrayList arrayList = new ArrayList();
        int[] nArray = ghostCursor.currentWordIdx();
        if (nArray[0] != -1) {
            SChar sChar;
            SChar sChar2 = sChar = (SChar)this.displayData.charMetaData.get(nArray[0]);
            int n = nArray[1];
            if (nArray[0] == nArray[1]) {
                arrayList.add(new SChar[]{sChar, sChar2});
            } else {
                for (int i2 = nArray[0] + 1; i2 <= n; ++i2) {
                    SChar sChar3 = (SChar)this.displayData.charMetaData.get(i2);
                    if (sChar3.line != sChar.line) {
                        arrayList.add(new SChar[]{sChar, sChar2});
                        sChar = sChar2 = sChar3;
                        if (i2 != n) continue;
                        arrayList.add(new SChar[]{sChar, sChar2});
                        continue;
                    }
                    sChar2 = sChar3;
                    if (i2 != n) continue;
                    arrayList.add(new SChar[]{sChar, sChar2});
                }
            }
        }
        return arrayList;
    }

    private void updateCursorNodes(GhostCursor ghostCursor) {
        int n = ghostCursor.getCursorMode();
        if (n == 0) {
            int n2 = this.cursorLines.size();
            this.cursorNodeChar.setVisible(false);
            this.makeLineCursorsInvisible(n2);
            int n3 = ghostCursor.getCurrentWordType();
            if (n2 == 1 && n3 != 2) {
                this.updateGhostWordCursor(n2, n3);
            } else if (n2 > 0) {
                this.updateWordCursor(ghostCursor);
            } else {
                this.updateCharCursor(ghostCursor);
            }
        } else {
            this.updateCharCursor(ghostCursor);
        }
    }

    private void updateGhostWordCursor(int n, int n2) {
        SChar sChar = ((SChar[])this.cursorLines.get(0))[0];
        float f2 = this.getAbsLineIdxPos(sChar.line) + (float)layoutCursorHeightPadding;
        int n3 = sChar.x + (n2 == 3 ? sChar.w : (short)0);
        this.updateCursorNodesPrefabs(n3 + this.lineStartXOffset, f2, 8, this.fontHight + layoutCursorHeightPadding, 0, n, false, false);
    }

    private void updateWordCursor(GhostCursor ghostCursor) {
        int n = this.cursorLines.size();
        for (int i2 = 0; i2 < n; ++i2) {
            SChar[] sCharArray = (SChar[])this.cursorLines.get(i2);
            short s = ((short[])this.displayData.sCharLines.get(sCharArray[0].line))[1];
            if (sCharArray[0].line + (this.controller.getViewPort().vpNoVisibleLines == 0 ? (short)1 : 0) >= this.controller.getViewPort().vpFirstVisibleLine) {
                boolean bl = MLUtils.getCharType(ghostCursor.getCharArray()[sCharArray[0].idx]) == 3;
                float f2 = this.getAbsLineIdxPos(sCharArray[0].line) + (float)layoutCursorHeightPadding;
                short s2 = sCharArray[0].x;
                int n2 = s == sCharArray[1].idx && n > 1 && i2 != n - 1 || bl ? this.controller.getWidth() - 30 : sCharArray[1].x + sCharArray[1].w;
                this.updateCursorNodesPrefabs(this.lineStartXOffset + s2, f2, n2 - s2, this.fontHight + layoutCursorHeightPadding + 2, i2, n, bl, 0 != MLUtils.getCharType(ghostCursor.getCharArray()[sCharArray[0].idx]));
                continue;
            }
            if (this.prefabCursorNodes.size() <= i2) continue;
            ((IWrappedNode3D)this.prefabCursorNodes.get(i2)).setVisible(false);
        }
    }

    private void updateCharCursor(GhostCursor ghostCursor) {
        boolean bl = this.controller.isBlinkCursorVisible();
        this.makeLineCursorsInvisible(0);
        this.cursorNodeChar.setVisible(bl);
        if (!bl) {
            return;
        }
        this.cursorNodeChar.clearArea();
        this.cursorNodeChar.setLineColor(this.charCursorColor);
        int n = ghostCursor.currentCharIdx();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (n != -1) {
            SChar sChar = (SChar)this.displayData.charMetaData.get(n);
            if (this.displayData.cursor.currentChar() == '\n' || this.displayData.cursor.currentChar() == '\r') {
                n2 = sChar.line + 1;
                n4 = 0;
                n3 = 0;
            } else {
                n2 = sChar.line;
                n4 = sChar.w;
                n3 = sChar.x;
            }
        }
        float f2 = MLUtils.specialRound(this.getAbsLineIdxPos(n2));
        float f3 = f2 + (float)this.cursorCharAdditionalHeightOverflow;
        float f4 = f2 - (float)this.getLineOffsetY();
        float f5 = this.lineStartXOffset + n3 + n4 + this.currsorOffsetFromChar * 2;
        this.cursorNodeChar.getQuickDrawNode().addSeparator();
        this.cursorNodeChar.add(f5, f3);
        this.cursorNodeChar.add(f5, f4);
    }

    private void updateCursorNodesPrefabs(int n, float f2, int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
        IWrappedNode3D iWrappedNode3D;
        IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D = n4 < this.prefabCursorNodes.size() ? (IWrappedNode3D)this.prefabCursorNodes.get(n4) : null;
        if (iWrappedNode3D == null && (iWrappedNode3D = this.ealManager.createTemplateInstanceNode(this.node, EALManager.createNodeName("MultilineTextfield", n4, (AbstractRenderer)this), n2, n3, 7, "Prefabs/generic_textFieldCursor", this.getInitContext().getScreenID())) != null && iWrappedNode3D.isValid()) {
            this.prefabCursorNodes.add(iWrappedNode3D);
            iWrappedNode3D.setOpacity(1.0f);
        }
        if (iWrappedNode3D != null && iWrappedNode3D.isValid()) {
            iWrappedNode3D.setPosition(n + (bl2 ? -2 : 0), MLUtils.specialRound(f2 - (float)n3 - 6.0f), 1.0f);
            iWrappedNode3D.setSize(n2, n3);
            iWrappedNode3D.setVisible(true);
            this.propertyCache.setProperty(iWrappedNode3D, "if_width", (float)(n2 + (bl2 ? 4 : 0)));
            this.propertyCache.setProperty(iWrappedNode3D, "if_height", (float)(n3 + 13));
            this.propertyCache.setProperty(iWrappedNode3D, "if_cursorActive", 1.0f);
            this.propertyCache.setProperty(iWrappedNode3D, "if_borderLeft", n4 == 0 || bl ? 1.0f : 0.0f);
            this.propertyCache.setProperty(iWrappedNode3D, "if_borderRight", n4 == n5 - 1 || bl ? 1.0f : 0.0f);
            this.propertyCache.setProperty(iWrappedNode3D, "if_borderTop", 1.0f);
            this.propertyCache.setColorProperty(iWrappedNode3D, "if_cursorColor", this.controller.isSpellerActive() ? this.charCursorColor : this.wordCursorColor);
        }
    }

    private void makeLineCursorsInvisible(int n) {
        for (int i2 = n; i2 < this.prefabCursorNodes.size(); ++i2) {
            ((IWrappedNode3D)this.prefabCursorNodes.get(i2)).setVisible(false);
        }
    }

    private void deinitCursorNodes() {
        if (this.ealManager != null) {
            if (this.prefabCursorNodes != null) {
                for (int i2 = 0; i2 < this.prefabCursorNodes.size(); ++i2) {
                    this.ealManager.destroy((IWrappedNode3D)this.prefabCursorNodes.get(i2));
                }
                this.prefabCursorNodes.clear();
            }
            this.ealManager.destroy(this.cursorNodeChar);
            this.cursorNodeChar = null;
        }
    }

    protected int getKzbConstant() {
        return 7;
    }

    protected final int renderDescriptiveText(RedrawContextHigh redrawContextHigh, int n) {
        String string = this.controller.getDescriptiveText();
        if (string != null) {
            String string2 = this.controller.getDescriptiveText2();
            int n2 = 0;
            if (string2 != null) {
                n2 = this.getEALManager().getTextWidth(string2, redrawContextHigh.getCurrentFont());
            }
            if (this.textNodeDescriptiveText == null) {
                this.textNodeDescriptiveText = this.getEALManager().createText3D(this.node, EALManager.createNodeName("touchTextNodeDescriptive", this), string, redrawContextHigh.getFont(0));
            }
            if (this.controller.isDisableInput()) {
                this.textNodeDescriptiveText.setOpacity(0.5f);
            }
            int n3 = -1;
            int n4 = EALManager.createColorCode(n3);
            this.textNodeDescriptiveText.getInterfaceText().setColor(n4);
            int n5 = this.getEALManager().getTextWidth(string, redrawContextHigh.getCurrentFont());
            int n6 = Math.max(n5, n2) + 25;
            this.controller.setDescriptiveTextLenght(n6);
            this.textNodeDescriptiveText.setPosition(20 - n6, n + 5, 0.0f);
            return n6;
        }
        return 0;
    }

    public int getTextLength(String string) {
        return this.getEALManager().getTextWidth(string, this.font);
    }

    private class CharWidthValue {
        public byte width;

        public CharWidthValue(byte by) {
            this.width = by;
        }
    }
}

