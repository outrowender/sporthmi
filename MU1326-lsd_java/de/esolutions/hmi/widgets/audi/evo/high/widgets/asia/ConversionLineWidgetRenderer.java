/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.AbstractConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.GridCell;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$ConversionLineButtonType;
import java.util.Iterator;

public class ConversionLineWidgetRenderer
extends AbstractConversionWidgetRenderer {
    public static final float GRID_LEFT_MARGIN;
    public static final String NODE_NAME_PREFIX_BOX;
    public static final String NODE_NAME_PREFIX_INPUT_DESCRIPTION;
    public static final String NODE_NAME_PREFIX_INPUT_DESCRIPTION_CELL;
    public static final String NODE_NAME_PREFIX_HIGHLIGHT_MATRIX_BUTTON;
    public static final String NODE_NAME_PREFIX_CANDIDATE_MATRIX_BUTTON;
    public static final String NODE_NAME_PREFIX_HIGHLIGHT_TRUFFLE_BUTTON;
    private static final int VERTICAL_SEPARATOR_Y_OFFSET_RELATIVE_TO_GRID_CELL;
    private static final int PADDING_LEFT_RIGHT_GRID_CELL;
    private static final int BITMAP_INDEX_SEPARATOR;
    private static final int BOX_BORDER_THICKNESS;
    public static final String PROPERTY_NAME_IF_DDSARROW_STATE;
    public static final float PROPERTY_VALUE_IF_DDSARROW_STATE_INVISIBLE;
    public static final float PROPERTY_VALUE_IF_DDSARROW_STATE_VISIBLE_UP;
    public static final float PROPERTY_VALUE_IF_DDSARROW_STATE_VISIBLE_DOWN;
    private static final String PROPERTY_IF_SPELLER_WIDTH;
    private static final String PROPERTY_IF_HEIGHT;
    private static final int FONT_PREVIEW;
    private static final int FONT_RIBBON;
    private static int cursorBoxHeight;
    private static int templateNodeOffsetY;
    private static int yTopOffsetAboveSpeller;
    private GridCell inputDescriptionCell = null;
    private IWrappedNode3DImage matrixHighlightButtonNode = null;
    private IWrappedNode3D boxNode;
    private ConversionLineController conversionLineController;
    protected final SimpleIntObjectMap itemfindbackcache = new SimpleIntObjectMap(20);
    protected final SimpleIntObjectMap separatorCache = new SimpleIntObjectMap(20);
    private GridCell[] gridCellsSingleRow;
    private int columnsWithoutButton;
    private float cellWidthMatrixButton;

    public ConversionLineWidgetRenderer(ConversionLineController conversionLineController) {
        super(conversionLineController, 1, -1, 0);
        this.conversionLineController = conversionLineController;
        this.gridCellPaddingLeftRight = 2;
    }

    @Override
    protected float calculateCursorHeight(GridCell gridCell) {
        return gridCell.cellNode.getHeight();
    }

    @Override
    protected float calculateCursorY(GridCell gridCell) {
        return gridCell.cellNode.getY();
    }

    @Override
    protected void createHighlightMatrixButtonNode() {
        this.highlightedMatrixButtonNode = this.getEALManager().createImage3D(this.cursorNode, EALManager.createNodeName("highlight_matrixButton", this), this.getEALManager().createTextureDescription(ConversionLineController$ConversionLineButtonType.MATRIX_BUTTON.getBitmapIdHighlighted(), true, this.getAbstractController().getScreenId()), 0, true, (Object)this);
        if (this.highlightedMatrixButtonNode == null) {
            tpLogChannelInternal.log(10000, "ConversionLineWidgetRenderer#createHighlightMatrixButtonNode: Could not create highlightedMatrixButtonNode!");
            this.highlightedMatrixButtonNode = (IWrappedNode3DImage)NULL_NODE;
        }
    }

    @Override
    protected void createHighlightTruffleButtonNode() {
        this.highlightedTruffleButtonNode = this.getEALManager().createImage3D(this.cursorNode, EALManager.createNodeName("highlight_truffleButton", this), this.getEALManager().createTextureDescription(ConversionLineController$ConversionLineButtonType.TRUFFLE_BUTTON.getBitmapIdHighlighted(), true, this.getAbstractController().getScreenId()), 0, true, (Object)this);
        if (this.highlightedTruffleButtonNode == null) {
            tpLogChannelInternal.log(10000, "ConversionLineWidgetRenderer#createHighlightMatrixButtonNode: Could not create highlightedMatrixButtonNode!");
            this.highlightedTruffleButtonNode = (IWrappedNode3DImage)NULL_NODE;
        }
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.controller.isSizeChanged()) {
            this.setupGridDimensions();
            this.forceUpdateLayoutByCurrentData();
            this.controller.setSizeChanged(false);
        }
        this.nodeMain.setVisible(this.controller.shouldRender());
        if (!this.controller.shouldRender()) {
            return;
        }
        boolean bl = this.conversionLineController.hasTouchControllerFocus();
        boolean bl2 = this.conversionLineController.operationAvailableFromConversionLine();
        int n = this.conversionLineController.getMode();
        this.cursorNode.setVisible(bl);
        this.setDdsArrowState(bl, bl2, n);
        if (n == 0) {
            this.adaptDescriptionCell(false);
            this.adaptGridToControllerData();
            this.adaptItemColorsToFocusState();
        } else if (n == 1) {
            this.adaptDescriptionCell(true);
        } else {
            tpLogChannelInternal.log(10000, "ConversionLineWidgetRenderer#applyProperties: unkown conversion line mode %1", (long)n);
        }
    }

    protected final void forceUpdateLayoutByCurrentData() {
        this.controller.setDataChanged(true);
        this.adaptGridToControllerData();
    }

    private void setDdsArrowState(boolean bl, boolean bl2, int n) {
        float f2 = 0.0f;
        if (n == 0) {
            f2 = bl ? 2.0f : (bl2 ? 1.0f : 0.0f);
        }
        this.propertyCache.setProperty(this.boxNode, "if_ddsArrowState", f2);
    }

    @Override
    protected float calculateSpannedCellWidth(int n) {
        boolean bl;
        boolean bl2 = bl = n == this.columns;
        if (!bl) {
            return super.calculateSpannedCellWidth(n);
        }
        float f2 = this.cellWidth * (float)(n - 1) + (float)(n - 2) * 1.0f;
        return f2 += this.cellWidthMatrixButton + 1.0f;
    }

    @Override
    protected void handleAdditionGridDataUpdateCalculationsHook(int n, int n2) {
        if (n > 0 && n + n2 < this.columnsWithoutButton) {
            GridCell gridCell = this.gridCellsSingleRow[n + n2];
            gridCell.setVisible(true);
        }
        for (int i2 = n + n2 + 1; i2 < this.columns; ++i2) {
            this.gridCellsSingleRow[i2].setVisible(false);
        }
    }

    @Override
    protected Iterator getCandidateIterator() {
        return this.controller.getCandidateIterator();
    }

    @Override
    protected int getTopRowIndex() {
        return 0;
    }

    @Override
    protected void resetCellSize(int n, int n2, GridCell gridCell) {
        if (n2 == this.columns - 1) {
            gridCell.setSize(this.cellWidthMatrixButton, this.cellHeight);
        } else {
            gridCell.setSize(this.cellWidth, this.cellHeight);
        }
    }

    @Override
    protected void performFillInLayoutData(Iterator iterator, int n) {
        if (n == 1) {
            AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = (AbstractConversionWidgetController$ICandidateItem)iterator.next();
            this.calculateContentWidthAndColumnSpan(abstractConversionWidgetController$ICandidateItem, this.getNormalFont());
            ConversionLineWidgetRenderer.stretchToEndOfRow(abstractConversionWidgetController$ICandidateItem, this.columns);
        } else {
            super.performFillInLayoutData(iterator, n);
        }
    }

    @Override
    protected int getAmountColumnsForTextItems() {
        return this.columnsWithoutButton;
    }

    private void adaptDescriptionCell(boolean bl) {
        this.inputDescriptionCell.setVisible(bl);
        if (bl) {
            this.hideGrid();
            String string = this.conversionLineController.getInputDescription();
            int n = this.calculateTextWidth(string, this.getNormalFont());
            AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = (AbstractConversionWidgetController$MultiCharItem)this.inputDescriptionCell.getCurrentCandidate();
            abstractConversionWidgetController$MultiCharItem.setChars(string);
            abstractConversionWidgetController$MultiCharItem.setWidth(n);
            this.inputDescriptionCell.setCandidateItem(abstractConversionWidgetController$MultiCharItem);
        }
    }

    private void hideGrid() {
        for (int i2 = 0; i2 < this.gridCellsSingleRow.length; ++i2) {
            this.gridCellsSingleRow[i2].setVisible(false);
        }
    }

    @Override
    protected void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.boxNode);
            eALManager.destroy(this.matrixHighlightButtonNode);
            if (this.inputDescriptionCell != null) {
                this.inputDescriptionCell.destroy(eALManager);
            }
            for (int i2 = 0; i2 < this.columns; ++i2) {
                if (this.gridCellsSingleRow[i2] == null) continue;
                this.gridCellsSingleRow[i2].destroy(eALManager);
                this.gridCellsSingleRow[i2] = null;
            }
        }
        this.boxNode = null;
        this.matrixHighlightButtonNode = null;
        this.inputDescriptionCell = null;
        super.destroyNode();
    }

    @Override
    protected void initializeLayoutValues(Layout layout) {
        this.rows = 1;
        this.columns = layout.getIntegerConstant(113);
        this.columnsWithoutButton = this.columns - 1;
        cursorBoxHeight = layout.getDistance(224);
        yTopOffsetAboveSpeller = layout.getDistance(225);
        templateNodeOffsetY = layout.getDistance(226);
    }

    @Override
    protected void initializeNodes(RedrawContextHigh redrawContextHigh) {
        this.nodeMain.setPosition(this.controller.getX(), this.controller.getY() - yTopOffsetAboveSpeller, 0.0f);
        this.boxNode = this.getEALManager().createTemplateInstanceNode(this.nodeMain, EALManager.createNodeName("conversion_line_box", this), 0.0f, 0.0f, 7, "Prefabs/if_asiaSpeller", this.getInitContext().getScreenID());
        this.boxNode.setPosition(0.0f, templateNodeOffsetY, 0.0f);
        this.propertyCache.setProperty(this.boxNode, "if_height", (float)(cursorBoxHeight - 2));
        this.propertyCache.setProperty(this.boxNode, "if_spellerWidth", (float)(this.conversionLineController.getWidth() - 2));
        this.setCursorNodeProperty("spl_height", cursorBoxHeight);
    }

    @Override
    protected void createGrid() {
        super.createGrid();
        this.gridRoot.setPosition(16449, 0.0f, 0.0f);
        this.gridCellsSingleRow = this.gridCells[0];
        this.createDescriptionCellNode();
    }

    protected void createDescriptionCellNode() {
        IWrappedNode3D iWrappedNode3D = this.getEALManager().createNode3D(this.gridRoot, EALManager.createNodeName("inputDescriptionCell", this), 0.0f, 0.0f);
        IWrappedNode3DText iWrappedNode3DText = this.getEALManager().createText3D(iWrappedNode3D, EALManager.createNodeName("inputDescriptionText", this), "", this.getNormalFont());
        iWrappedNode3DText.setColor(this.disabledColor);
        this.inputDescriptionCell = new GridCell(iWrappedNode3D, iWrappedNode3DText, null, null, null);
        AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = new AbstractConversionWidgetController$MultiCharItem();
        abstractConversionWidgetController$MultiCharItem.setColumnSpan(this.columns);
        this.inputDescriptionCell.setCandidateItem(abstractConversionWidgetController$MultiCharItem);
        this.inputDescriptionCell.setVisible(false);
    }

    protected boolean useHorizontalSeparators() {
        return false;
    }

    @Override
    protected float getGridHeight() {
        return cursorBoxHeight;
    }

    @Override
    protected float getGridWidth() {
        return this.controller.getWidth();
    }

    @Override
    protected void handleAdditionGridDimensionCalculationsHook(float f2, float f3, float f4) {
        float f5 = f4 - (float)this.columns * this.cellWidth;
        GridCell gridCell = this.gridCellsSingleRow[this.columns - 1];
        this.cellWidthMatrixButton = this.cellWidth + f5;
        gridCell.setSize(this.cellWidthMatrixButton, this.cellHeight);
        this.inputDescriptionCell.setSize(f2, f3);
    }

    @Override
    protected int getCandidateColor() {
        if (this.conversionLineController.hasTouchControllerFocus() || this.conversionLineController.isSingleTruffleButtonShowed() && ConversionLineController.TRUFFLE_BUTTON_ITEM.isEnabled()) {
            return this.whiteColor;
        }
        return this.disabledColor;
    }

    private void adaptItemColorsToFocusState() {
        int n = this.getCandidateColor();
        for (int i2 = 0; i2 < this.gridCellsSingleRow.length; ++i2) {
            if (this.gridCellsSingleRow[i2].getCurrentCandidate() != null && this.gridCellsSingleRow[i2].getCurrentCandidate().isEnabled()) {
                this.gridCellsSingleRow[i2].setCandidateColor(n);
                continue;
            }
            this.gridCellsSingleRow[i2].setCandidateColor(this.disabledColor);
        }
    }

    @Override
    protected IWrappedFont getHighlightFont(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.getFont(3);
    }

    @Override
    protected IWrappedFont getNormalFont(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.getFont(2);
    }

    static {
        NODE_NAME_PREFIX_CANDIDATE_MATRIX_BUTTON = ConversionLineController$ConversionLineButtonType.MATRIX_BUTTON.getImageNodeName();
        templateNodeOffsetY = 0;
        yTopOffsetAboveSpeller = 52;
    }
}

