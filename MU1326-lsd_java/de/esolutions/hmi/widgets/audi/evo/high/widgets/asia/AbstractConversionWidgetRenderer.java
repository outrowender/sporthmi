/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.GridCell;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.IImageNodeCreator;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.NullWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICharacterItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$IButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConversionWidgetRenderer
extends AbstractRendererHigh
implements IConversionWidgetRenderer,
IWidgetLogChannel,
IKanziTemplateRenderer,
IImageNodeCreator {
    public static final String NODE_NAME_PREFIX_CURSOR;
    public static final String NODE_NAME_PREFIX_SEPARATOR_VERTICAL;
    public static final String NODE_NAME_PREFIX_MAINNODE;
    public static final String NODE_NAME_PREFIX_CANDIDATE_TEXT;
    public static final String NODE_NAME_PREFIX_HIGHLIGHT;
    public static final String NODE_NAME_PREFIX_GRID_ROOT;
    public static final String NODE_NAME_PREFIX_GRID_CELL;
    public static final String NODE_NAME_PREFIX_SEPARATOR_HORIZONTAL;
    public static final float SEPARATOR_THICKNESS;
    protected static final int BACK_ARROW_COLOR_ARRAY_INDEX;
    private static final String SPELLER_TEMPLATE_PATH;
    protected static final String PROPERTY_CURSOR_COLOR;
    protected static final String PROPERTY_CURSOR_WIDTH;
    protected static final String PROPERTY_CURSOR_HEIGHT;
    private static final String PROPERTY_COMPLETION_ARROW;
    protected static final IWrappedNode3D NULL_NODE;
    protected int columns;
    protected int rows;
    protected IWrappedNode3D nodeMain;
    protected IWrappedNode3D cursorNode;
    protected IWrappedNode3DText highlightedTextNode;
    protected IWrappedNode3DImage highlightedMatrixButtonNode;
    protected IWrappedNode3DImage highlightedTruffleButtonNode;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    protected final AbstractConversionWidgetController controller;
    protected AbstractConversionWidgetController$ICandidateItem lastFocusItem = null;
    protected boolean hasMatrixButton = false;
    protected float conversionLineOffsetWithMatrixButton = 0.0f;
    protected int cursorColor;
    protected int whiteColor;
    protected int highlightedTextColor;
    protected int backArrowColor;
    protected int disabledColor;
    protected IWrappedNode3D gridRoot;
    private IWrappedNode3DImage bottomSeparatorNode = (IWrappedNode3DImage)NULL_NODE;
    protected float cellWidth = 0.0f;
    protected float cellHeight = 0.0f;
    protected GridCell[][] gridCells;
    private static int cachedAsiaCharWidth;
    private static IWrappedFont cachedFont;
    protected int gridCellPaddingLeftRight = 12;
    private final int verticalSeparatorToCellOffsetY;
    private final int horizontalSeparatorBitmapIndex;
    private final int verticalSeparatorBitmapIndex;

    public AbstractConversionWidgetRenderer(AbstractConversionWidgetController abstractConversionWidgetController, int n, int n2, int n3) {
        this.controller = abstractConversionWidgetController;
        this.verticalSeparatorToCellOffsetY = n;
        this.horizontalSeparatorBitmapIndex = n2;
        this.verticalSeparatorBitmapIndex = n3;
    }

    @Override
    public final void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.nodeMain != null) {
                this.nodeMain.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.nodeMain == null) {
            this.initialize(redrawContextHigh);
            if (this.nodeMain == null) {
                tpLogChannelInternal.log(10000, "ConversionWidgetRenderer#render: The conversion line main node is null!");
                return;
            }
        }
        this.applyProperties(redrawContextHigh);
        this.adaptCursor();
    }

    private void initialize(RedrawContextHigh redrawContextHigh) {
        this.initializeColors(redrawContextHigh);
        this.initializeLayoutValues(this.getTerminal().getLayout());
        if (this.gridRoot == null) {
            this.initializeGrid();
            this.performFillInLayoutData(this.controller.getCandidateIterator(), this.controller.getCandidatesSize());
        }
        this.initializeMainNodes(redrawContextHigh);
        this.initializeNodes(redrawContextHigh);
    }

    @Override
    public void fillInLayoutData(List list) {
        if (this.getTerminal() == null) {
            tpLogChannelInternal.log(-1601830656, "AbstractConversionWidgetRenderer#fillInLayoutData: Terminal is null, could not initialize layout data.");
            return;
        }
        if (this.gridRoot == null) {
            this.initializeLayoutValues(this.getTerminal().getLayout());
            this.initializeGrid();
        }
        this.performFillInLayoutData(list.iterator(), list.size());
    }

    private void initializeGrid() {
        this.createGrid();
        this.setupGridDimensions();
    }

    protected final void setupGridDimensions() {
        float f2 = this.getGridWidth();
        float f3 = this.getGridHeight();
        this.setGridDimensions(f2, f3);
    }

    protected final void setGridDimensions(float f2, float f3) {
        this.gridRoot.setSize(f2, f3);
        float f4 = f2 - (float)(this.columns - 1) * 1.0f;
        float f5 = f3 - (float)(this.rows - 1) * 1.0f;
        this.cellWidth = (float)Math.floor(f4 / (float)this.columns);
        this.cellHeight = (float)Math.floor(f5 / (float)this.rows);
        for (int i2 = 0; i2 < this.rows; ++i2) {
            for (int i3 = 0; i3 < this.columns; ++i3) {
                GridCell gridCell = this.gridCells[i2][i3];
                gridCell.setSize(this.cellWidth, this.cellHeight);
                float f6 = (float)i3 * (this.cellWidth + 1.0f);
                float f7 = this.useHorizontalSeparators() ? 1.0f + (float)i2 * (this.cellHeight + 1.0f) : 0.0f;
                gridCell.setPosition(f6, f7);
            }
            GridCell gridCell = this.gridCells[i2][0];
            float f8 = AbstractConversionWidgetRenderer.calculateHorizontalSeparatorXOffset(f2, gridCell.separatorNodeHorizontal);
            gridCell.separatorNodeHorizontal.setPosition(f8, 32959, 0.0f);
        }
        if (this.useHorizontalSeparators()) {
            this.bottomSeparatorNode.setPosition(AbstractConversionWidgetRenderer.calculateHorizontalSeparatorXOffset(f2, this.bottomSeparatorNode), f3 - 1.0f, 0.0f);
        }
        this.handleAdditionGridDimensionCalculationsHook(f2, f3, f4);
    }

    private boolean useHorizontalSeparators() {
        return this.horizontalSeparatorBitmapIndex != -1;
    }

    protected void handleAdditionGridDimensionCalculationsHook(float f2, float f3, float f4) {
    }

    private static float calculateHorizontalSeparatorXOffset(float f2, IWrappedNode3DImage iWrappedNode3DImage) {
        return (f2 - iWrappedNode3DImage.getWidth()) / 2.0f;
    }

    protected void performFillInLayoutData(Iterator iterator, int n) {
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = null;
        int n2 = 0;
        int n3 = 0;
        while (iterator.hasNext()) {
            AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem2 = (AbstractConversionWidgetController$ICandidateItem)iterator.next();
            this.calculateContentWidthAndColumnSpan(abstractConversionWidgetController$ICandidateItem2, this.getNormalFont());
            int n4 = abstractConversionWidgetController$ICandidateItem2.getColumnSpan();
            int n5 = n2++;
            int n6 = n3;
            if (n4 > 1) {
                int n7 = this.getAmountColumnsForTextItems() - n3;
                if (n7 < n4) {
                    n5 = n2;
                    n3 = 0;
                    n6 = 0;
                    AbstractConversionWidgetRenderer.stretchToEndOfRow(abstractConversionWidgetController$ICandidateItem, this.getAmountColumnsForTextItems());
                }
                n3 += n4 - 1;
            }
            abstractConversionWidgetController$ICandidateItem2.setRowIndex(n5);
            abstractConversionWidgetController$ICandidateItem2.setColumnIndex(n6);
            if (n3 == this.getAmountColumnsForTextItems() - 1) {
                ++n2;
                n3 = 0;
            } else {
                ++n3;
            }
            abstractConversionWidgetController$ICandidateItem = abstractConversionWidgetController$ICandidateItem2;
        }
    }

    protected abstract int getAmountColumnsForTextItems() {
    }

    protected static void stretchToEndOfRow(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, int n) {
        if (abstractConversionWidgetController$ICandidateItem != null) {
            int n2 = abstractConversionWidgetController$ICandidateItem.getColumnSpan();
            int n3 = abstractConversionWidgetController$ICandidateItem.getColumnIndex() + n2 - 1;
            int n4 = n - n3 - 1;
            abstractConversionWidgetController$ICandidateItem.setColumnSpan(n2 + n4);
        }
    }

    protected final void calculateContentWidthAndColumnSpan(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, IWrappedFont iWrappedFont) {
        int n;
        int n2 = (int)this.cellWidth - 2 * this.gridCellPaddingLeftRight;
        if (abstractConversionWidgetController$ICandidateItem instanceof AbstractConversionWidgetController$ICharacterItem) {
            n = this.calculateTextWidth(((AbstractConversionWidgetController$ICharacterItem)abstractConversionWidgetController$ICandidateItem).getChars(), iWrappedFont);
        } else if (abstractConversionWidgetController$ICandidateItem instanceof ConversionLineController$IButtonItem) {
            if (abstractConversionWidgetController$ICandidateItem.getWidth() != 32959) {
                n = (int)abstractConversionWidgetController$ICandidateItem.getWidth();
            } else {
                HMIImage hMIImage = this.getEALManager().getHMIImage(((ConversionLineController$IButtonItem)abstractConversionWidgetController$ICandidateItem).getButtonType().getBitmapId(), this.getAbstractController().getScreenId());
                n = this.getEALManager().getImageHeaderInformation(hMIImage.getPath())[0];
            }
        } else {
            tpLogChannelInternal.log(10000, "AbstractConversionWidgetRenderer#calculateContentWidthAndColumnSpan: unkown item %1 with type %2", (Object)abstractConversionWidgetController$ICandidateItem, (Object)super.getClass());
            n = -1;
        }
        int n3 = 1;
        if (n > n2 && (n3 = (int)Math.ceil((double)n / (double)n2)) > this.columns) {
            n3 = this.columns;
            AbstractConversionWidgetController$ICharacterItem abstractConversionWidgetController$ICharacterItem = (AbstractConversionWidgetController$ICharacterItem)abstractConversionWidgetController$ICandidateItem;
            String string = this.abbreviateTextLeft(iWrappedFont, (int)this.gridRoot.getWidth() - 2 * this.gridCellPaddingLeftRight, abstractConversionWidgetController$ICharacterItem.getChars());
            abstractConversionWidgetController$ICharacterItem.setAbbreviatedCharacters(string);
            n = this.getEALManager().getTextWidth(string, iWrappedFont);
        }
        abstractConversionWidgetController$ICandidateItem.setWidth(n);
        abstractConversionWidgetController$ICandidateItem.setColumnSpan(n3);
    }

    protected void createGrid() {
        this.gridRoot = this.getEALManager().createNode3D(null, EALManager.createNodeName("gridRoot", this), 0.0f, 0.0f);
        this.gridCells = new GridCell[this.rows][this.columns];
        for (int i2 = 0; i2 < this.rows; ++i2) {
            for (int i3 = 0; i3 < this.columns; ++i3) {
                Object object;
                String string = this.createGridCellNodeName(i2, i3, "gridCell");
                IWrappedNode3D iWrappedNode3D = this.getEALManager().createNode3D(this.gridRoot, string, 0.0f, 0.0f);
                String string2 = this.createGridCellNodeName(i2, i3, "candidate_textNode");
                IWrappedNode3DText iWrappedNode3DText = this.getEALManager().createText3D(iWrappedNode3D, string2, "", this.getNormalFont());
                iWrappedNode3DText.setColor(this.getCandidateColor());
                IWrappedNode3DImage iWrappedNode3DImage = null;
                if (i3 != 0) {
                    object = this.createGridCellNodeName(i2, i3, "separator_vertical");
                    iWrappedNode3DImage = this.createImageNodeByIndex(iWrappedNode3D, (String)object, this.verticalSeparatorBitmapIndex);
                    iWrappedNode3DImage.setPosition(32959, this.verticalSeparatorToCellOffsetY, 0.0f);
                }
                object = null;
                if (this.useHorizontalSeparators() && i3 == 0) {
                    String string3 = EALManager.createNodeName("separator_horizontal", new Buffer("row").append(i2).toString(), (AbstractRenderer)this);
                    object = this.createImageNodeByIndex(iWrappedNode3D, string3, this.horizontalSeparatorBitmapIndex);
                    object.setPosition(0.0f, 32959, 0.0f);
                }
                this.gridCells[i2][i3] = new GridCell(iWrappedNode3D, iWrappedNode3DText, this, iWrappedNode3DImage, (IWrappedNode3DImage)object);
            }
        }
        if (this.useHorizontalSeparators()) {
            String string = EALManager.createNodeName("separator_horizontal", "bottom", (AbstractRenderer)this);
            this.bottomSeparatorNode = this.createImageNodeByIndex(this.gridRoot, string, this.horizontalSeparatorBitmapIndex);
        }
    }

    protected final String createGridCellNodeName(int n, int n2, String string) {
        String string2 = new Buffer("row").append(n).append("_col").append(n2).toString();
        return EALManager.createNodeName(string, string2, (AbstractRenderer)this);
    }

    protected abstract float getGridWidth() {
    }

    protected abstract float getGridHeight() {
    }

    protected abstract void initializeLayoutValues(Layout layout) {
    }

    private void initializeColors(RedrawContextHigh redrawContextHigh) {
        this.cursorColor = EALManager.createColorCode(redrawContextHigh.getColor(0));
        this.backArrowColor = EALManager.createColorCode(redrawContextHigh.getColor(5));
        this.whiteColor = EALManager.createColorCode(-1);
        this.highlightedTextColor = EALManager.createColorCode(-1);
        this.disabledColor = EALManager.createColorCode(redrawContextHigh.getColor(2));
    }

    protected abstract void applyProperties(RedrawContextHigh redrawContextHigh) {
    }

    private void initializeMainNodes(RedrawContextHigh redrawContextHigh) {
        this.nodeMain = this.getEALManager().createNode3D(AbstractConversionWidgetRenderer.getPaintNode(redrawContextHigh), EALManager.createNodeName("conversionWidgetMain", this), this.controller.getWidth(), this.controller.getHeight(), 0);
        this.nodeMain.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        if (this.nodeMain == null) {
            tpLogChannelInternal.log(10000, "ConversionWidgetRenderer#initializeNodes: The root node for clipping is null!");
            return;
        }
        this.createCursorNode(this.gridRoot);
        this.createHighlightNodes(redrawContextHigh);
        this.nodeMain.addByIndex(this.gridRoot, 100);
    }

    protected abstract void initializeNodes(RedrawContextHigh redrawContextHigh) {
    }

    private void createHighlightNodes(RedrawContextHigh redrawContextHigh) {
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = this.controller.getCurrentFocus();
        String string = abstractConversionWidgetController$ICandidateItem instanceof AbstractConversionWidgetController$MultiCharItem ? ((AbstractConversionWidgetController$MultiCharItem)abstractConversionWidgetController$ICandidateItem).getChars() : this.controller.getUnconvertedCharacters();
        this.highlightedTextNode = this.getEALManager().createText3D(this.cursorNode, EALManager.createNodeName("highlightedCandidate", this), string, this.getHighlightFont(redrawContextHigh));
        this.highlightedTextNode.setColor(this.highlightedTextColor);
        this.highlightedTextNode.setVisible(false);
        if (this.highlightedTextNode == null) {
            tpLogChannelInternal.log(10000, "AbstractConversionWidgetRenderer#createHighlightNode: Could not create highlightedTextNode!");
            this.highlightedTextNode = (IWrappedNode3DText)NULL_NODE;
        }
        this.createHighlightMatrixButtonNode();
        this.createHighlightTruffleButtonNode();
        this.highlightedMatrixButtonNode.setVisible(false);
    }

    protected abstract void createHighlightMatrixButtonNode() {
    }

    protected abstract void createHighlightTruffleButtonNode() {
    }

    protected abstract IWrappedFont getHighlightFont(RedrawContextHigh redrawContextHigh) {
    }

    protected abstract IWrappedFont getNormalFont(RedrawContextHigh redrawContextHigh) {
    }

    private void createCursorNode(IWrappedNode3D iWrappedNode3D) {
        this.cursorNode = this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName("cursor", this), 0.0f, 0.0f, 7, "Prefabs/speller_bracket", this.getInitContext().getScreenID(), 0);
        if (this.cursorNode == null) {
            canditateMatrixLogChannel.log(10000, "ConversionWidgetRenderer#createCursorNode: The cursor node is null!");
            return;
        }
        this.setCursorNodeColorProperty("Color", this.cursorColor);
        this.setCursorNodeProperty("spl_completionArrowVisible", 0.0f);
        this.cursorNode.setVisible(false);
        this.cursorNode.setNodeIndex(99);
    }

    protected abstract int getCandidateColor() {
    }

    private static IWrappedNode3D getPaintNode(RedrawContext redrawContext) {
        IWrappedNode3D iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNodeSecondary;
        if (iWrappedNode3D == null) {
            iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNode;
        }
        return iWrappedNode3D;
    }

    protected final void adaptGridToControllerData() {
        if (this.controller.isDataChanged()) {
            int n;
            for (n = 0; n < this.rows; ++n) {
                for (int i2 = 0; i2 < this.columns; ++i2) {
                    GridCell gridCell = this.gridCells[n][i2];
                    gridCell.setVisible(true);
                    gridCell.setCandidateItem(null);
                    this.resetCellSize(n, i2, gridCell);
                }
            }
            n = this.getTopRowIndex();
            Iterator iterator = this.getCandidateIterator();
            int n2 = -1;
            int n3 = 0;
            while (iterator.hasNext()) {
                AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = (AbstractConversionWidgetController$ICandidateItem)iterator.next();
                int n4 = abstractConversionWidgetController$ICandidateItem.getRowIndex() - n;
                n2 = abstractConversionWidgetController$ICandidateItem.getColumnIndex();
                n3 = abstractConversionWidgetController$ICandidateItem.getColumnSpan();
                GridCell gridCell = this.gridCells[n4][n2];
                gridCell.setCandidateItem(abstractConversionWidgetController$ICandidateItem);
                if (n3 <= 1) continue;
                for (int i3 = n2 + 1; i3 < n2 + n3; ++i3) {
                    this.gridCells[n4][i3].setVisible(false);
                }
                gridCell.setSize(this.calculateSpannedCellWidth(n3), this.cellHeight);
            }
            this.handleAdditionGridDataUpdateCalculationsHook(n2, n3);
            this.controller.setDataChanged(false);
        }
    }

    protected void handleAdditionGridDataUpdateCalculationsHook(int n, int n2) {
    }

    protected float calculateSpannedCellWidth(int n) {
        return this.cellWidth * (float)n + (float)(n - 1) * 1.0f;
    }

    protected abstract int getTopRowIndex() {
    }

    protected abstract Iterator getCandidateIterator() {
    }

    protected abstract void resetCellSize(int n, int n2, GridCell gridCell) {
    }

    private void adaptCursor() {
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = this.controller.getCurrentFocus();
        if (abstractConversionWidgetController$ICandidateItem != null) {
            this.moveCursorOnCandidate(abstractConversionWidgetController$ICandidateItem);
            this.updateHighlightingNode(abstractConversionWidgetController$ICandidateItem);
        }
    }

    private void moveCursorOnCandidate(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        GridCell gridCell = this.findCellWithCandidate(abstractConversionWidgetController$ICandidateItem);
        if (gridCell == null) {
            this.cursorNode.setPosition(0.0f, 64195, 0.0f);
            return;
        }
        int n = (int)(gridCell.cellNode.getWidth() + 2.0f);
        float f2 = this.calculateCursorHeight(gridCell);
        float f3 = gridCell.cellNode.getX() + (float)(n / 2) - 1.0f - 1.0f;
        float f4 = this.calculateCursorY(gridCell);
        this.setCursorNodeProperty("spl_width", n);
        this.setCursorNodeProperty("spl_height", f2);
        this.cursorNode.setPosition(f3, f4, 0.0f);
    }

    private GridCell findCellWithCandidate(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        for (int i2 = 0; i2 < this.rows; ++i2) {
            for (int i3 = 0; i3 < this.columns; ++i3) {
                if (this.gridCells[i2][i3].getCurrentCandidateId() != abstractConversionWidgetController$ICandidateItem.getId()) continue;
                return this.gridCells[i2][i3];
            }
        }
        return null;
    }

    protected abstract float calculateCursorHeight(GridCell gridCell) {
    }

    protected abstract float calculateCursorY(GridCell gridCell) {
    }

    protected final void updateHighlightingNode(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        if (abstractConversionWidgetController$ICandidateItem instanceof AbstractConversionWidgetController$MultiCharItem) {
            this.highlightedTextNode.setVisible(true);
            this.highlightedMatrixButtonNode.setVisible(false);
            this.highlightedTruffleButtonNode.setVisible(false);
            this.highlightedTextNode.setText(((AbstractConversionWidgetController$MultiCharItem)abstractConversionWidgetController$ICandidateItem).getChars(), this.highlightedTextNode.getFont());
            this.centerOnCursor(this.highlightedTextNode);
        } else if (abstractConversionWidgetController$ICandidateItem == ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM) {
            this.highlightedTextNode.setVisible(false);
            this.highlightedTruffleButtonNode.setVisible(false);
            this.highlightedMatrixButtonNode.setVisible(true);
            this.centerOnCursor(this.highlightedMatrixButtonNode);
        } else if (abstractConversionWidgetController$ICandidateItem == ConversionLineController.TRUFFLE_BUTTON_ITEM) {
            this.highlightedTextNode.setVisible(false);
            this.highlightedTextNode.setVisible(false);
            this.highlightedTruffleButtonNode.setVisible(true);
            if (!(this.highlightedTruffleButtonNode instanceof NullWrappedNode3D)) {
                this.centerOnCursor(this.highlightedTruffleButtonNode);
            }
        }
    }

    protected final void centerOnCursor(IWrappedNode3D iWrappedNode3D) {
        float f2;
        float f3;
        float f4 = this.getCursorHeight();
        float f5 = this.getCursorWidth();
        if (iWrappedNode3D instanceof IWrappedNode3DText) {
            f3 = ((IWrappedNode3DText)iWrappedNode3D).getTextNode().getWidth();
            f2 = EALManager.getFontHeightUppercase(((IWrappedNode3DText)iWrappedNode3D).getFont());
        } else {
            f3 = iWrappedNode3D.getWidth() - 1.0f;
            f2 = -iWrappedNode3D.getHeight();
        }
        float f6 = 0.0f;
        if (f5 % 2.0f != 0.0f && f3 % 2.0f == 0.0f) {
            f6 = 63;
        }
        if (f5 % 2.0f == 0.0f && f3 % 2.0f != 0.0f) {
            f6 = 191;
        }
        float f7 = -((float)Math.floor(f3 / 2.0f)) + 1.0f + f6;
        float f8 = (float)Math.floor((f4 + f2) / 2.0f);
        iWrappedNode3D.setPosition((int)f7, (int)f8, 0.0f);
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public final void disconnect() {
        this.destroyNode();
        super.disconnect();
    }

    protected void destroyNode() {
        this.destroyProperties();
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.highlightedTextNode);
            eALManager.destroy(this.cursorNode);
            eALManager.destroy(this.nodeMain);
            eALManager.destroy(this.gridRoot);
            eALManager.destroy(this.bottomSeparatorNode);
        }
        this.gridRoot = null;
        this.nodeMain = null;
        this.cursorNode = null;
        this.highlightedTextNode = null;
        this.bottomSeparatorNode = null;
    }

    private void destroyProperties() {
        this.propertyCache.clearAll();
    }

    protected final float getCursorWidth() {
        return this.propertyCache.getFloatProperty(this.cursorNode, "spl_width");
    }

    protected final float getCursorHeight() {
        return this.propertyCache.getFloatProperty(this.cursorNode, "spl_height");
    }

    protected colorRGBAf getCursorColor() {
        return this.propertyCache.getColorProperty(this.cursorNode, "Color");
    }

    protected final boolean setCursorNodeProperty(String string, float f2) {
        return this.propertyCache.setProperty(this.cursorNode, string, f2);
    }

    protected final boolean setCursorNodeColorProperty(String string, int n) {
        return this.propertyCache.setColorProperty(this.cursorNode, string, n);
    }

    protected final boolean setCursorNodeProperty(String string, colorRGBAf colorRGBAf2) {
        return this.propertyCache.setProperty(this.cursorNode, string, colorRGBAf2);
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }

    protected final String abbreviateTextLeft(IWrappedFont iWrappedFont, int n, String string) {
        return ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(iWrappedFont).abbreviateTextEllipsis(string, n, true);
    }

    protected final String abbreviateTextRight(IWrappedFont iWrappedFont, int n, String string) {
        return ((HMITerminalEAL)this.controller.getTerminal()).getStringUtility(iWrappedFont).abbreviateTextEllipsis(string, n, false);
    }

    protected IWrappedNode3DImage createImageNodeByIndex(IWrappedNode3D iWrappedNode3D, String string, int n) {
        TextureDescription textureDescription = this.getTextureDescription(n, true);
        return this.createImageNode(iWrappedNode3D, string, n, textureDescription);
    }

    protected IWrappedNode3DImage createImageNodeById(IWrappedNode3D iWrappedNode3D, String string, int n) {
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(n, true, this.getAbstractController().getScreenId());
        return this.createImageNode(iWrappedNode3D, string, n, textureDescription);
    }

    @Override
    public IWrappedNode3DImage createButtonImageNodeById(IWrappedNode3D iWrappedNode3D, ConversionLineController$IButtonItem conversionLineController$IButtonItem) {
        String string = this.createGridCellNodeName(conversionLineController$IButtonItem.getRowIndex(), conversionLineController$IButtonItem.getColumnIndex(), conversionLineController$IButtonItem.getButtonType().getImageNodeName());
        return this.createImageNodeById(iWrappedNode3D, string, conversionLineController$IButtonItem.getButtonType().getBitmapId());
    }

    private IWrappedNode3DImage createImageNode(IWrappedNode3D iWrappedNode3D, String string, int n, TextureDescription textureDescription) {
        IWrappedNode3DImage iWrappedNode3DImage = null;
        if (textureDescription != null) {
            iWrappedNode3DImage = this.getEALManager().createImage3D(iWrappedNode3D, string, textureDescription, 0, true, (Object)this);
            if (iWrappedNode3DImage == null) {
                tpLogChannelInternal.log(10000, "AbstractConversionWidgetRenderer#createImageNode: Could not create node %1.", (Object)string);
            }
        } else {
            tpLogChannelInternal.log(10000, "AbstractConversionWidgetRenderer#createImageNode: Could not create TextureDescription for bitmap %2 (node %1).", (Object)string, (long)n);
        }
        if (iWrappedNode3DImage == null) {
            return (IWrappedNode3DImage)NULL_NODE;
        }
        return iWrappedNode3DImage;
    }

    protected IWrappedFont getNormalFont() {
        RedrawContextHigh redrawContextHigh = new RedrawContextHigh();
        redrawContextHigh.setFonts(this.getFonts());
        return this.getNormalFont(redrawContextHigh);
    }

    protected int calculateTextWidth(String string, IWrappedFont iWrappedFont) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return 0;
        }
        if (AbstractConversionWidgetRenderer.containNoneFullWidthAsiaChar(string)) {
            return this.getTextWidth(string, iWrappedFont);
        }
        if (0 == cachedAsiaCharWidth || null == cachedFont || !Util.equals(cachedFont, iWrappedFont)) {
            cachedAsiaCharWidth = this.getTextWidth(String.valueOf(string.charAt(0)), iWrappedFont);
            cachedFont = iWrappedFont;
        }
        return cachedAsiaCharWidth * string.length();
    }

    private int getTextWidth(String string, IWrappedFont iWrappedFont) {
        return this.getEALManager().getTextWidth(string, iWrappedFont);
    }

    public static boolean containNoneFullWidthAsiaChar(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return false;
        }
        char[] cArray = string.toCharArray();
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (StringUtility.isFullWidthAsiaCharacter(cArray[i2])) continue;
            return true;
        }
        return false;
    }

    static {
        NULL_NODE = new NullWrappedNode3D();
        cachedAsiaCharWidth = 0;
        cachedFont = null;
    }
}

