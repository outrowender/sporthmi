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
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConversionWidgetRenderer
extends AbstractRendererHigh
implements IConversionWidgetRenderer,
IWidgetLogChannel,
IKanziTemplateRenderer,
IImageNodeCreator {
    public static final String NODE_NAME_PREFIX_CURSOR = "cursor";
    public static final String NODE_NAME_PREFIX_SEPARATOR_VERTICAL = "separator_vertical";
    public static final String NODE_NAME_PREFIX_MAINNODE = "conversionWidgetMain";
    public static final String NODE_NAME_PREFIX_CANDIDATE_TEXT = "candidate_textNode";
    public static final String NODE_NAME_PREFIX_HIGHLIGHT = "highlightedCandidate";
    public static final String NODE_NAME_PREFIX_GRID_ROOT = "gridRoot";
    public static final String NODE_NAME_PREFIX_GRID_CELL = "gridCell";
    public static final String NODE_NAME_PREFIX_SEPARATOR_HORIZONTAL = "separator_horizontal";
    public static final float SEPARATOR_THICKNESS = 1.0f;
    protected static final int BACK_ARROW_COLOR_ARRAY_INDEX = 5;
    private static final String SPELLER_TEMPLATE_PATH = "Prefabs/speller_bracket";
    protected static final String PROPERTY_CURSOR_COLOR = "Color";
    protected static final String PROPERTY_CURSOR_WIDTH = "spl_width";
    protected static final String PROPERTY_CURSOR_HEIGHT = "spl_height";
    private static final String PROPERTY_COMPLETION_ARROW = "spl_completionArrowVisible";
    protected static final IWrappedNode3D NULL_NODE = new NullWrappedNode3D();
    protected int columns;
    protected int rows;
    protected IWrappedNode3D nodeMain;
    protected IWrappedNode3D cursorNode;
    protected IWrappedNode3DText highlightedTextNode;
    protected IWrappedNode3DImage highlightedMatrixButtonNode;
    protected IWrappedNode3DImage highlightedTruffleButtonNode;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    protected final AbstractConversionWidgetController controller;
    protected AbstractConversionWidgetController.ICandidateItem lastFocusItem = null;
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
    private static int cachedAsiaCharWidth = 0;
    private static IWrappedFont cachedFont = null;
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

    public void fillInLayoutData(List list) {
        if (this.getTerminal() == null) {
            tpLogChannelInternal.log(100000, "AbstractConversionWidgetRenderer#fillInLayoutData: Terminal is null, could not initialize layout data.");
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
            gridCell.separatorNodeHorizontal.setPosition(f8, -1.0f, 0.0f);
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
        AbstractConversionWidgetController.ICandidateItem iCandidateItem = null;
        int n2 = 0;
        int n3 = 0;
        while (iterator.hasNext()) {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem2 = (AbstractConversionWidgetController.ICandidateItem)iterator.next();
            this.calculateContentWidthAndColumnSpan(iCandidateItem2, this.getNormalFont());
            int n4 = iCandidateItem2.getColumnSpan();
            int n5 = n2++;
            int n6 = n3;
            if (n4 > 1) {
                int n7 = this.getAmountColumnsForTextItems() - n3;
                if (n7 < n4) {
                    n5 = n2;
                    n3 = 0;
                    n6 = 0;
                    AbstractConversionWidgetRenderer.stretchToEndOfRow(iCandidateItem, this.getAmountColumnsForTextItems());
                }
                n3 += n4 - 1;
            }
            iCandidateItem2.setRowIndex(n5);
            iCandidateItem2.setColumnIndex(n6);
            if (n3 == this.getAmountColumnsForTextItems() - 1) {
                ++n2;
                n3 = 0;
            } else {
                ++n3;
            }
            iCandidateItem = iCandidateItem2;
        }
    }

    protected abstract int getAmountColumnsForTextItems();

    protected static void stretchToEndOfRow(AbstractConversionWidgetController.ICandidateItem iCandidateItem, int n) {
        if (iCandidateItem != null) {
            int n2 = iCandidateItem.getColumnSpan();
            int n3 = iCandidateItem.getColumnIndex() + n2 - 1;
            int n4 = n - n3 - 1;
            iCandidateItem.setColumnSpan(n2 + n4);
        }
    }

    protected final void calculateContentWidthAndColumnSpan(AbstractConversionWidgetController.ICandidateItem iCandidateItem, IWrappedFont iWrappedFont) {
        int n;
        int n2 = (int)this.cellWidth - 2 * this.gridCellPaddingLeftRight;
        if (iCandidateItem instanceof AbstractConversionWidgetController.ICharacterItem) {
            n = this.calculateTextWidth(((AbstractConversionWidgetController.ICharacterItem)iCandidateItem).getChars(), iWrappedFont);
        } else if (iCandidateItem instanceof ConversionLineController.IButtonItem) {
            if (iCandidateItem.getWidth() != -1.0f) {
                n = (int)iCandidateItem.getWidth();
            } else {
                HMIImage hMIImage = this.getEALManager().getHMIImage(((ConversionLineController.IButtonItem)iCandidateItem).getButtonType().getBitmapId(), this.getAbstractController().getScreenId());
                n = this.getEALManager().getImageHeaderInformation(hMIImage.getPath())[0];
            }
        } else {
            tpLogChannelInternal.log(10000, "AbstractConversionWidgetRenderer#calculateContentWidthAndColumnSpan: unkown item %1 with type %2", (Object)iCandidateItem, (Object)iCandidateItem.getClass());
            n = -1;
        }
        int n3 = 1;
        if (n > n2 && (n3 = (int)Math.ceil((double)n / (double)n2)) > this.columns) {
            n3 = this.columns;
            AbstractConversionWidgetController.ICharacterItem iCharacterItem = (AbstractConversionWidgetController.ICharacterItem)iCandidateItem;
            String string = this.abbreviateTextLeft(iWrappedFont, (int)this.gridRoot.getWidth() - 2 * this.gridCellPaddingLeftRight, iCharacterItem.getChars());
            iCharacterItem.setAbbreviatedCharacters(string);
            n = this.getEALManager().getTextWidth(string, iWrappedFont);
        }
        iCandidateItem.setWidth(n);
        iCandidateItem.setColumnSpan(n3);
    }

    protected void createGrid() {
        this.gridRoot = this.getEALManager().createNode3D(null, EALManager.createNodeName(NODE_NAME_PREFIX_GRID_ROOT, this), 0.0f, 0.0f);
        this.gridCells = new GridCell[this.rows][this.columns];
        for (int i2 = 0; i2 < this.rows; ++i2) {
            for (int i3 = 0; i3 < this.columns; ++i3) {
                Object object;
                String string = this.createGridCellNodeName(i2, i3, NODE_NAME_PREFIX_GRID_CELL);
                IWrappedNode3D iWrappedNode3D = this.getEALManager().createNode3D(this.gridRoot, string, 0.0f, 0.0f);
                String string2 = this.createGridCellNodeName(i2, i3, NODE_NAME_PREFIX_CANDIDATE_TEXT);
                IWrappedNode3DText iWrappedNode3DText = this.getEALManager().createText3D(iWrappedNode3D, string2, "", this.getNormalFont());
                iWrappedNode3DText.setColor(this.getCandidateColor());
                IWrappedNode3DImage iWrappedNode3DImage = null;
                if (i3 != 0) {
                    object = this.createGridCellNodeName(i2, i3, NODE_NAME_PREFIX_SEPARATOR_VERTICAL);
                    iWrappedNode3DImage = this.createImageNodeByIndex(iWrappedNode3D, (String)object, this.verticalSeparatorBitmapIndex);
                    iWrappedNode3DImage.setPosition(-1.0f, this.verticalSeparatorToCellOffsetY, 0.0f);
                }
                object = null;
                if (this.useHorizontalSeparators() && i3 == 0) {
                    String string3 = EALManager.createNodeName(NODE_NAME_PREFIX_SEPARATOR_HORIZONTAL, new Buffer("row").append(i2).toString(), (AbstractRenderer)this);
                    object = this.createImageNodeByIndex(iWrappedNode3D, string3, this.horizontalSeparatorBitmapIndex);
                    object.setPosition(0.0f, -1.0f, 0.0f);
                }
                this.gridCells[i2][i3] = new GridCell(iWrappedNode3D, iWrappedNode3DText, this, iWrappedNode3DImage, (IWrappedNode3DImage)object);
            }
        }
        if (this.useHorizontalSeparators()) {
            String string = EALManager.createNodeName(NODE_NAME_PREFIX_SEPARATOR_HORIZONTAL, "bottom", (AbstractRenderer)this);
            this.bottomSeparatorNode = this.createImageNodeByIndex(this.gridRoot, string, this.horizontalSeparatorBitmapIndex);
        }
    }

    protected final String createGridCellNodeName(int n, int n2, String string) {
        String string2 = new Buffer("row").append(n).append("_col").append(n2).toString();
        return EALManager.createNodeName(string, string2, (AbstractRenderer)this);
    }

    protected abstract float getGridWidth();

    protected abstract float getGridHeight();

    protected abstract void initializeLayoutValues(Layout var1);

    private void initializeColors(RedrawContextHigh redrawContextHigh) {
        this.cursorColor = EALManager.createColorCode(redrawContextHigh.getColor(0));
        this.backArrowColor = EALManager.createColorCode(redrawContextHigh.getColor(5));
        this.whiteColor = EALManager.createColorCode(-1);
        this.highlightedTextColor = EALManager.createColorCode(-1);
        this.disabledColor = EALManager.createColorCode(redrawContextHigh.getColor(2));
    }

    protected abstract void applyProperties(RedrawContextHigh var1);

    private void initializeMainNodes(RedrawContextHigh redrawContextHigh) {
        this.nodeMain = this.getEALManager().createNode3D(AbstractConversionWidgetRenderer.getPaintNode(redrawContextHigh), EALManager.createNodeName(NODE_NAME_PREFIX_MAINNODE, this), this.controller.getWidth(), this.controller.getHeight(), 0);
        this.nodeMain.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        if (this.nodeMain == null) {
            tpLogChannelInternal.log(10000, "ConversionWidgetRenderer#initializeNodes: The root node for clipping is null!");
            return;
        }
        this.createCursorNode(this.gridRoot);
        this.createHighlightNodes(redrawContextHigh);
        this.nodeMain.addByIndex(this.gridRoot, 100);
    }

    protected abstract void initializeNodes(RedrawContextHigh var1);

    private void createHighlightNodes(RedrawContextHigh redrawContextHigh) {
        AbstractConversionWidgetController.ICandidateItem iCandidateItem = this.controller.getCurrentFocus();
        String string = iCandidateItem instanceof AbstractConversionWidgetController.MultiCharItem ? ((AbstractConversionWidgetController.MultiCharItem)iCandidateItem).getChars() : this.controller.getUnconvertedCharacters();
        this.highlightedTextNode = this.getEALManager().createText3D(this.cursorNode, EALManager.createNodeName(NODE_NAME_PREFIX_HIGHLIGHT, this), string, this.getHighlightFont(redrawContextHigh));
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

    protected abstract void createHighlightMatrixButtonNode();

    protected abstract void createHighlightTruffleButtonNode();

    protected abstract IWrappedFont getHighlightFont(RedrawContextHigh var1);

    protected abstract IWrappedFont getNormalFont(RedrawContextHigh var1);

    private void createCursorNode(IWrappedNode3D iWrappedNode3D) {
        this.cursorNode = this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName(NODE_NAME_PREFIX_CURSOR, this), 0.0f, 0.0f, 7, SPELLER_TEMPLATE_PATH, this.getInitContext().getScreenID(), 0);
        if (this.cursorNode == null) {
            canditateMatrixLogChannel.log(10000, "ConversionWidgetRenderer#createCursorNode: The cursor node is null!");
            return;
        }
        this.setCursorNodeColorProperty(PROPERTY_CURSOR_COLOR, this.cursorColor);
        this.setCursorNodeProperty(PROPERTY_COMPLETION_ARROW, 0.0f);
        this.cursorNode.setVisible(false);
        this.cursorNode.setNodeIndex(99);
    }

    protected abstract int getCandidateColor();

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
                AbstractConversionWidgetController.ICandidateItem iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)iterator.next();
                int n4 = iCandidateItem.getRowIndex() - n;
                n2 = iCandidateItem.getColumnIndex();
                n3 = iCandidateItem.getColumnSpan();
                GridCell gridCell = this.gridCells[n4][n2];
                gridCell.setCandidateItem(iCandidateItem);
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

    protected abstract int getTopRowIndex();

    protected abstract Iterator getCandidateIterator();

    protected abstract void resetCellSize(int var1, int var2, GridCell var3);

    private void adaptCursor() {
        AbstractConversionWidgetController.ICandidateItem iCandidateItem = this.controller.getCurrentFocus();
        if (iCandidateItem != null) {
            this.moveCursorOnCandidate(iCandidateItem);
            this.updateHighlightingNode(iCandidateItem);
        }
    }

    private void moveCursorOnCandidate(AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        GridCell gridCell = this.findCellWithCandidate(iCandidateItem);
        if (gridCell == null) {
            this.cursorNode.setPosition(0.0f, -500.0f, 0.0f);
            return;
        }
        int n = (int)(gridCell.cellNode.getWidth() + 2.0f);
        float f2 = this.calculateCursorHeight(gridCell);
        float f3 = gridCell.cellNode.getX() + (float)(n / 2) - 1.0f - 1.0f;
        float f4 = this.calculateCursorY(gridCell);
        this.setCursorNodeProperty(PROPERTY_CURSOR_WIDTH, n);
        this.setCursorNodeProperty(PROPERTY_CURSOR_HEIGHT, f2);
        this.cursorNode.setPosition(f3, f4, 0.0f);
    }

    private GridCell findCellWithCandidate(AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        for (int i2 = 0; i2 < this.rows; ++i2) {
            for (int i3 = 0; i3 < this.columns; ++i3) {
                if (this.gridCells[i2][i3].getCurrentCandidateId() != iCandidateItem.getId()) continue;
                return this.gridCells[i2][i3];
            }
        }
        return null;
    }

    protected abstract float calculateCursorHeight(GridCell var1);

    protected abstract float calculateCursorY(GridCell var1);

    protected final void updateHighlightingNode(AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        if (iCandidateItem instanceof AbstractConversionWidgetController.MultiCharItem) {
            this.highlightedTextNode.setVisible(true);
            this.highlightedMatrixButtonNode.setVisible(false);
            this.highlightedTruffleButtonNode.setVisible(false);
            this.highlightedTextNode.setText(((AbstractConversionWidgetController.MultiCharItem)iCandidateItem).getChars(), this.highlightedTextNode.getFont());
            this.centerOnCursor(this.highlightedTextNode);
        } else if (iCandidateItem == ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM) {
            this.highlightedTextNode.setVisible(false);
            this.highlightedTruffleButtonNode.setVisible(false);
            this.highlightedMatrixButtonNode.setVisible(true);
            this.centerOnCursor(this.highlightedMatrixButtonNode);
        } else if (iCandidateItem == ConversionLineController.TRUFFLE_BUTTON_ITEM) {
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
            f6 = 0.5f;
        }
        if (f5 % 2.0f == 0.0f && f3 % 2.0f != 0.0f) {
            f6 = -0.5f;
        }
        float f7 = -((float)Math.floor(f3 / 2.0f)) + 1.0f + f6;
        float f8 = (float)Math.floor((f4 + f2) / 2.0f);
        iWrappedNode3D.setPosition((int)f7, (int)f8, 0.0f);
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

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
        return this.propertyCache.getFloatProperty(this.cursorNode, PROPERTY_CURSOR_WIDTH);
    }

    protected final float getCursorHeight() {
        return this.propertyCache.getFloatProperty(this.cursorNode, PROPERTY_CURSOR_HEIGHT);
    }

    protected colorRGBAf getCursorColor() {
        return this.propertyCache.getColorProperty(this.cursorNode, PROPERTY_CURSOR_COLOR);
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

    public IWrappedNode3DImage createButtonImageNodeById(IWrappedNode3D iWrappedNode3D, ConversionLineController.IButtonItem iButtonItem) {
        String string = this.createGridCellNodeName(iButtonItem.getRowIndex(), iButtonItem.getColumnIndex(), iButtonItem.getButtonType().getImageNodeName());
        return this.createImageNodeById(iWrappedNode3D, string, iButtonItem.getButtonType().getBitmapId());
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
}

