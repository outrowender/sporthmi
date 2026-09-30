/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DTextMultiSection;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.AbstractConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.GridCell;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixController;
import java.util.Iterator;

public class ConversionWidgetRenderer
extends AbstractConversionWidgetRenderer {
    public static final String NODE_NAME_PREFIX_UNCONVERTED_CHARACTERS = "unconvertedCharacters";
    public static final String NODE_NAME_PREFIX_BACK_ARROW_IMAGE = "backArrowImageNode";
    private static final int VERTICAL_SEPARATOR_Y_OFFSET_RELATIVE_TO_GRID_CELL = 0;
    private static float verticalSeparatorHeight = 36.0f;
    private static int marginLeftGrid = 21;
    private static int marginRightGrid = 35;
    private static int marginBottomGrid = 19;
    public static final int ROWS = 3;
    private static final int BITMAP_BACK_ARROW_HEIGHT = 15;
    private static final int BITMAP_INDEX_BACK_ARROW = 0;
    private static final int BITMAP_INDEX_HORIZONTAL_SEPARATOR = 2;
    private static final int BITMAP_INDEX_VERTICAL_SEPARATOR = 1;
    private static final int TITLE_LINE_GAP_X = 16;
    private static final int TITLE_LINE_MARGIN_TOP_ARROW_IMAGE = 43;
    private static final int TITLE_LINE_BASELINE_OFFSET_TEXT = 58;
    private static final int Y_OFFSET_FOR_TITLE = -75;
    private static final int FONT_NORMAL = 0;
    private static final int FONT_HIGHLIGHT = 1;
    private IWrappedNode3DTextMultiSection unconvertedInputTextNode;
    private IWrappedNode3DImage backArrowImageNode;
    private final ConversionMatrixController conversionMatrixController;

    public ConversionWidgetRenderer(ConversionMatrixController conversionMatrixController) {
        super(conversionMatrixController, 0, 2, 1);
        this.conversionMatrixController = conversionMatrixController;
    }

    protected void initializeLayoutValues(Layout layout) {
        this.rows = 3;
        this.columns = layout.getIntegerConstant(105);
        marginLeftGrid = layout.getDistance(216);
        marginRightGrid = layout.getDistance(217);
        marginBottomGrid = layout.getDistance(218);
        verticalSeparatorHeight = layout.getDistance(223);
        this.gridCellPaddingLeftRight = layout.getDistance(229);
    }

    protected void initializeNodes(RedrawContextHigh redrawContextHigh) {
        this.nodeMain.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.createTitleLine(this.getNormalFont(redrawContextHigh));
        float f2 = marginLeftGrid;
        float f3 = (float)this.controller.getHeight() - this.gridRoot.getHeight() - (float)marginBottomGrid;
        this.gridRoot.setPosition(f2, f3, 0.0f);
    }

    protected boolean useHorizontalSeparators() {
        return true;
    }

    protected float getGridHeight() {
        return verticalSeparatorHeight * 3.0f + 4.0f;
    }

    protected float getGridWidth() {
        return this.controller.getWidth() - marginLeftGrid - marginRightGrid;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.conversionMatrixController.isModuleColorRefreshNeeded()) {
            this.cursorColor = EALManager.createColorCode(redrawContextHigh.getColor(0));
            this.setCursorNodeColorProperty("Color", this.cursorColor);
            this.backArrowColor = EALManager.createColorCode(redrawContextHigh.getColor(5));
            this.backArrowImageNode.setModulateColor(this.backArrowColor);
            this.conversionMatrixController.onModuleColorRefreshed();
        }
        if (this.conversionMatrixController.getViewPort().hasChanged()) {
            this.adaptGridToControllerData();
            this.conversionMatrixController.getViewPort().onChangeRendered();
        }
        this.cursorNode.setVisible(true);
        this.highlightedTextNode.setVisible(true);
        this.updateUnconvertedDataTitle(this.getNormalFont(redrawContextHigh));
    }

    protected int getTopRowIndex() {
        return this.conversionMatrixController.getViewPort().getTopRowIndex();
    }

    protected Iterator getCandidateIterator() {
        return this.conversionMatrixController.getViewPort().getCandidates().iterator();
    }

    protected void resetCellSize(int n, int n2, GridCell gridCell) {
        gridCell.setSize(this.cellWidth, this.cellHeight);
    }

    protected int getAmountColumnsForTextItems() {
        return this.columns;
    }

    private void updateUnconvertedDataTitle(IWrappedFont iWrappedFont) {
        if (this.unconvertedInputTextNode != null) {
            String string = this.controller.getUnconvertedCharacters();
            int n = (int)((float)this.controller.getWidth() - this.unconvertedInputTextNode.getX() - 16.0f);
            String string2 = this.abbreviateTextRight(iWrappedFont, n, string);
            this.unconvertedInputTextNode.setText(string2);
        }
    }

    protected float calculateCursorHeight(GridCell gridCell) {
        return gridCell.cellNode.getHeight() + 2.0f;
    }

    protected float calculateCursorY(GridCell gridCell) {
        return gridCell.cellNode.getY() - 1.0f;
    }

    private void createTitleLine(IWrappedFont iWrappedFont) {
        this.createBackArrowImageNode();
        this.createUnconvertedCharsTitleNode(iWrappedFont);
    }

    protected void createHighlightMatrixButtonNode() {
        this.highlightedMatrixButtonNode = (IWrappedNode3DImage)NULL_NODE;
    }

    private void createBackArrowImageNode() {
        if (this.backArrowImageNode == null) {
            TextureDescription textureDescription = this.getTextureDescription(0, true);
            if (textureDescription == null) {
                canditateMatrixLogChannel.log(10000, "ConversionWidgetRenderer#createBackArrowImageNode: Could not create TextureDescription for back arrow bitmap (index %1).", 0L);
                return;
            }
            String string = EALManager.createNodeName(NODE_NAME_PREFIX_BACK_ARROW_IMAGE, this);
            this.backArrowImageNode = this.getEALManager().createImage3D(this.nodeMain, string, textureDescription, 1, true, (Object)this);
            if (this.backArrowImageNode == null) {
                canditateMatrixLogChannel.log(10000, "ConversionWidgetRenderer#createBackArrowImageNode: Could not create backArrowImageNode.");
                return;
            }
            this.backArrowImageNode.setModulateColor(this.backArrowColor);
            this.backArrowImageNode.setPosition(16.0f, -32.0f, 0.0f);
            this.backArrowImageNode.setVisible(true);
        }
    }

    private void createUnconvertedCharsTitleNode(IWrappedFont iWrappedFont) {
        if (this.unconvertedInputTextNode == null) {
            String string = EALManager.createNodeName(NODE_NAME_PREFIX_UNCONVERTED_CHARACTERS, this);
            this.unconvertedInputTextNode = this.getEALManager().createText3DMultiSection(this.nodeMain, string, "", iWrappedFont, 0);
            if (this.unconvertedInputTextNode == null) {
                canditateMatrixLogChannel.log(10000, "ConversionWidgetRenderer#createUnconvertedCharsTextTitleNode: Could not create unconvertedInputTextNode");
                return;
            }
            this.unconvertedInputTextNode.getLayout().setTextLayoutSectionNum(1L);
            ITextLayoutSection iTextLayoutSection = this.unconvertedInputTextNode.getLayout().getLayoutSection(0L);
            iTextLayoutSection.setStyle(new FlagFontStyle(ITextLayoutSection.style_t.STYLE_UNDERLINE));
            iTextLayoutSection.setColor(this.getCandidateColor());
            this.unconvertedInputTextNode.notifyLayoutChanged(false);
            this.unconvertedInputTextNode.setPosition(32.0f + this.backArrowImageNode.getWidth(), -17.0f, 0.0f);
            this.unconvertedInputTextNode.setVisible(true);
        }
        this.updateUnconvertedDataTitle(iWrappedFont);
    }

    protected void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.unconvertedInputTextNode);
            eALManager.destroy(this.backArrowImageNode);
            for (int i2 = 0; i2 < 3; ++i2) {
                for (int i3 = 0; i3 < this.columns; ++i3) {
                    if (this.gridCells[i2][i3] == null) continue;
                    this.gridCells[i2][i3].destroy(eALManager);
                    this.gridCells[i2][i3] = null;
                }
            }
        }
        this.unconvertedInputTextNode = null;
        this.backArrowImageNode = null;
        super.destroyNode();
    }

    public void setFocused(boolean bl) {
    }

    protected int getCandidateColor() {
        return this.whiteColor;
    }

    protected IWrappedFont getHighlightFont(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.getFont(1);
    }

    protected IWrappedFont getNormalFont(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.getFont(0);
    }

    protected void createHighlightTruffleButtonNode() {
        this.highlightedTruffleButtonNode = (IWrappedNode3DImage)NULL_NODE;
    }
}

