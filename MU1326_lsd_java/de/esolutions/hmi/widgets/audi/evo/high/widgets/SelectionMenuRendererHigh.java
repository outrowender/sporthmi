/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.SystemProperties;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Cursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Slot;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

public class SelectionMenuRendererHigh
extends AbstractRendererHigh
implements PlaceholderMenuRenderer,
IKanziTemplateRenderer {
    private static final boolean LOAD_RESSOURCES_ON_DEMAND = SystemProperties.getBoolean("mergeSelectionDrawerOnDemand", false);
    private final SelectionMenuController controller;
    private static final int MAIN_PLACEHOLDER_COUNT;
    private static final int SUB_PLACEHOLDER_COUNT;
    private static final String PROPERTY_KEY_MAIN_ARROW_DOWN;
    private static final String PROPERTY_KEY_MAIN_ARROW_UP;
    private static final String PROPERTY_KEY_POS_MAIN_C1;
    private static final String PROPERTY_KEY_POS_MAIN_C2;
    private static final String PROPERTY_KEY_POS_MAIN_ITEM;
    private static final String PROPERTY_KEY_IN_OUT_POSITION;
    private static final String PROPERTY_KEY_STAGE;
    private static final String PROPERTY_KEY_SUB_MENU_VISIBILITY;
    private static final String PROPERTY_KEY_SUB_ARROW_DOWN;
    private static final String PROPERTY_KEY_SUB_ARROW_UP;
    private static final String PROPERTY_KEY_POS_SUB_C1;
    private static final String PROPERTY_KEY_POS_SUB_C2;
    private static final String PROPERTY_KEY_POS_SUB_ITEM;
    private static final String PROPERTY_KEY_REFLEX_STRENGTH;
    private static final String PROPERTY_KEY_DARKEN;
    private static final String PROPERTY_KEY_DESATURATE;
    private static final String PROPERTY_KEY_WIDTH_C1;
    private static final String PROPERTY_KEY_WIDTH_C2;
    private static final String PROPERTY_KEY_TEXTURE;
    private static final String PROPERTY_KEY_REFLEX_TEXTURE;
    private static final String PROPERTY_KEY_INACTIVE;
    private static final String PROPERTY_KEY_COLOR;
    private static INode3D animNode;
    private static INode mainFocusCursorNode;
    private static INode mainSelectionCursorNode;
    private static INode subFocusCursorNode;
    private static INode subSelectionCursorNode;
    private static final INode[] mainItemNodes;
    private static final INode[] mainItemLabelParents;
    private static final INode3DText[] mainItemlabels;
    private static final String[] mainItemlabelTexts;
    private static final long[] lastMainItemLabelColors;
    private static final INode[] subItemNodes;
    private static final INode[] subItemLabelParents;
    private static final INode3DText[] subItemlabels;
    private static final String[] subItemlabelTexts;
    private static final long[] lastSubItemLabelColors;
    private static boolean resourcesLoaded;
    private static boolean projectMerged;
    private final EALPropertyCache propertyCache = new EALPropertyCache();
    private IWrappedFont font;
    private static final int COLOR_COUNT;
    private final int[] ealColors = new int[4];
    private static final int COLOR_INDEX_CURSOR;
    private static final int COLOR_INDEX_TEXT_ENABLED;
    private static final int COLOR_INDEX_DISABLED;
    private static final int COLOR_INDEX_TEXT_HIGHLIGHTED;
    private int colorWhite;
    private boolean colorsInitialized;
    private static final LogChannel lc;
    public static final float DEFAULT_ICON_WIDTH;
    protected float iconWidth = 43074;
    public static final float DEFAULT_RIGHT_PADDING;
    protected float rightPadding = 24641;
    public static final float DEFAULT_REFLEX_STRENGTH;
    private float reflexStrength = 1.0f;
    private int yTextOffset;
    private static final float ITEM_INVISIBLE_POSITION;
    private static final int ICON_INDEX_NORMAL;
    private static final int ICON_INDEX_NORMAL_REFLEX;
    private final Map textureMap = new HashMap();
    private boolean isColorInitialized = false;

    public SelectionMenuRendererHigh(SelectionMenuController selectionMenuController) {
        this.controller = selectionMenuController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.registerAsKzbMergeListener();
    }

    private void registerAsKzbMergeListener() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null && !EALManager.isSelectionDrawerMerged()) {
            eALManager.registerAsKzbListener(8, this.controller);
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender()) {
            if (resourcesLoaded) {
                this.propertyCache.setProperty((INode)animNode, "ds_RingPos", 0.0f);
                if (animNode.isVisible()) {
                    animNode.setVisible(false);
                }
            }
            return;
        }
        this.getFont();
        if (!resourcesLoaded) {
            if (LOAD_RESSOURCES_ON_DEMAND && this.controller.getInOutPosition() <= 0.0f) {
                return;
            }
            this.loadResources();
            if (!resourcesLoaded) {
                return;
            }
        }
        if (this.colorsInitialized) {
            this.destroyColors();
        }
        if (!this.colorsInitialized) {
            for (int i2 = 0; i2 < 4; ++i2) {
                int n = redrawContext.getColor(i2);
                this.ealColors[i2] = EALManager.createColorCode(n);
            }
            this.colorWhite = EALManager.createColorCode(-1);
            this.colorsInitialized = true;
        }
        this.applyProperties();
    }

    private void reinitializeViewSize() {
        HMITerminalImpl hMITerminalImpl = this.getTerminal();
        if (hMITerminalImpl instanceof HMITerminalEvo) {
            ((HMITerminalEvo)((Object)hMITerminalImpl)).initializeDrawerViewSize();
        }
    }

    private void applyProperties() {
        lc.log(1078071040, "SelectionMenuRendererHigh#applyProperties");
        float f2 = this.controller.getInOutPosition();
        if (!this.controller.isConnected()) {
            animNode.setVisible(false);
        } else if (animNode.isVisible() != f2 > 0.0f) {
            animNode.setVisible(f2 > 0.0f);
        }
        this.propertyCache.setProperty((INode)animNode, "ds_RingPos", f2);
        this.propertyCache.setProperty((INode)animNode, "ds_Stage", this.controller.getDrawerStage());
        if (f2 <= 0.0f) {
            lc.log(1078071040, "SelectionMenuRendererHigh#applyProperties selection drawer closed");
            return;
        }
        this.propertyCache.setProperty((INode)animNode, "reflectionStrength", this.reflexStrength);
        float f3 = this.controller.getSubPosition();
        if (f3 <= 0.0f) {
            lc.log(1078071040, "SelectionMenuRendererHigh#applyProperties sub ring closed");
            this.propertyCache.setProperty((INode)animNode, "ds_Sub", 0.0f);
        } else {
            lc.log(1078071040, "SelectionMenuRendererHigh#applyProperties sub ring opened at %1", (double)f3);
            this.propertyCache.setProperty((INode)animNode, "ds_Sub", f3);
        }
        this.propertyCache.setProperty((INode)animNode, "ds_desaturate", this.controller.getDesaturation());
        this.propertyCache.setProperty((INode)animNode, "ds_darken", this.controller.getDarkening());
        if (!this.isColorInitialized) {
            this.propertyCache.setColorProperty(subSelectionCursorNode, "Color", this.ealColors[0]);
            this.isColorInitialized = true;
        }
        this.applyPropertiesMain();
        this.applyPropertiesSub();
    }

    private void applyPropertiesMain() {
        boolean bl;
        boolean bl2;
        float f2;
        this.propertyCache.setProperty((INode)animNode, "ds_main_arrow_up", 0.0f);
        this.propertyCache.setProperty((INode)animNode, "ds_main_arrow_down", 0.0f);
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor = this.controller.getFocusCursor();
        if (abstractPlaceholderMenuController$Cursor.isVisible()) {
            float f3 = abstractPlaceholderMenuController$Cursor.getCurrentPosition();
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain main focus cursor pos %1", (double)f3);
            if (!mainFocusCursorNode.isVisible()) {
                mainFocusCursorNode.setVisible(true);
            }
            if (this.controller.isBouncing()) {
                this.propertyCache.setProperty((INode)animNode, "ds_mainC1", f3 + this.controller.getBounceOffset());
            } else {
                this.propertyCache.setProperty((INode)animNode, "ds_mainC1", f3);
            }
            this.propertyCache.setColorProperty(mainFocusCursorNode, "Color", this.ealColors[0]);
        } else {
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain main focus invisible");
            if (mainFocusCursorNode.isVisible()) {
                mainFocusCursorNode.setVisible(false);
            }
        }
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor2 = this.controller.getSelectionCursor();
        if (abstractPlaceholderMenuController$Cursor2.isVisible()) {
            f2 = abstractPlaceholderMenuController$Cursor2.getCurrentPosition();
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain main selection cursor pos %1", (double)f2);
            if (!mainSelectionCursorNode.isVisible()) {
                mainSelectionCursorNode.setVisible(true);
            }
            this.propertyCache.setProperty((INode)animNode, "ds_mainC2", f2);
            this.propertyCache.setColorProperty(mainSelectionCursorNode, "Color", this.ealColors[0]);
        } else {
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain main selection invisible");
            if (mainSelectionCursorNode.isVisible()) {
                mainSelectionCursorNode.setVisible(false);
            }
        }
        f2 = this.controller.getScrollbarLength();
        if (f2 <= 0.0f) {
            bl2 = false;
            bl = false;
        } else {
            float f4 = this.controller.getScrollbarPosition();
            bl2 = f4 > 0.0f;
            boolean bl3 = bl = f4 + f2 < 1.0f;
            if (lc.isDebug()) {
                lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain viewport position %1, length %2", (Object)new Float(f4), (Object)new Float(f2));
            }
        }
        boolean bl4 = this.getTerminal().getViewSizeManager().isSportskinSmallStage();
        lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesMain scroll arrows visible ? up=%1, down=%2", bl2 && !bl4, bl && !bl4);
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor3 = this.controller.getSubFocusCursor();
        if (abstractPlaceholderMenuController$Cursor3 == null || !abstractPlaceholderMenuController$Cursor3.isVisible()) {
            this.propertyCache.setProperty((INode)animNode, "ds_main_arrow_up", bl2 && !bl4 ? 1.0f : 0.0f);
            this.propertyCache.setProperty((INode)animNode, "ds_main_arrow_down", bl && !bl4 ? 1.0f : 0.0f);
        }
        List list = this.controller.getSlots();
        int n = Math.min(6, list.size());
        int n2 = this.getInitContext().getScreenID();
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)list.get(i2);
            INode iNode = mainItemNodes[i2];
            if (abstractPlaceholderMenuController$Slot.isEnabled()) {
                IWrappedTexture iWrappedTexture;
                Object object;
                IWrappedTexture iWrappedTexture2;
                long l;
                if (!iNode.isVisible()) {
                    iNode.setVisible(true);
                }
                float f5 = abstractPlaceholderMenuController$Slot.getPosition();
                this.propertyCache.setProperty((INode)animNode, new StringBuffer().append("ds_mainItemPos").append(i2).toString(), f5);
                INode3DText iNode3DText = mainItemlabels[i2];
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = abstractPlaceholderMenuController$Slot.getItemEntry();
                boolean bl5 = abstractPlaceholderMenuController$PlaceholderItemEntry.equals(abstractPlaceholderMenuController$Cursor2.getTargetItemEntry());
                boolean bl6 = abstractPlaceholderMenuController$PlaceholderItemEntry.isEnabled();
                boolean bl7 = abstractPlaceholderMenuController$PlaceholderItemEntry.isFocused();
                String string = abstractPlaceholderMenuController$PlaceholderItemEntry.getLabelText();
                if (string == null) {
                    string = " ";
                }
                if (!string.equals(mainItemlabelTexts[i2])) {
                    SelectionMenuRendererHigh.mainItemlabelTexts[i2] = string;
                    this.font.getFontGroup().activate();
                    iNode3DText.setText(this.font.getSize(), string);
                }
                if (bl5 || bl7) {
                    int n3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getTextWidth();
                    if (bl5) {
                        this.propertyCache.setProperty(mainSelectionCursorNode, "c2_width", (float)n3);
                    }
                    if (bl7 && !abstractPlaceholderMenuController$Cursor.isCursorWidthInitialized()) {
                        abstractPlaceholderMenuController$Cursor.setTargetWidth(this.calculateCurrentFocusWidth(abstractPlaceholderMenuController$Cursor, n3));
                    }
                }
                SelectionMenuRendererHigh.lastMainItemLabelColors[i2] = l = this.getTextColor(bl6, bl5);
                iNode3DText.setColor(l);
                iNode3DText.invalidateObject();
                float f6 = this.flipTextAndReturnTranslationX(iNode3DText);
                int n4 = this.font.getSize() - this.font.getFontGroup().getAscent(this.font.getSize()) + this.yTextOffset;
                if (iNode3DText.getTranslationY() != (float)n4 || iNode3DText.getTranslationX() != f6) {
                    iNode3DText.setTranslation(f6, n4, 0.0f);
                }
                IWrappedTexture iWrappedTexture3 = iWrappedTexture2 = (object = abstractPlaceholderMenuController$PlaceholderItemEntry.getIconData(0)) instanceof Integer ? this.getGuideTexture((Integer)object, n2) : this.getTexture(object, n2);
                if (iWrappedTexture2 == null) {
                    this.propertyCache.setProperty(iNode, "Texture", (ITexture)null);
                } else {
                    this.propertyCache.setProperty(iNode, "Texture", iWrappedTexture2.getTexture());
                    this.propertyCache.setColorProperty(iNode, "Color", bl5 && bl6 ? this.ealColors[0] : this.colorWhite);
                    float f7 = bl6 ? (bl5 ? 0.0f : this.controller.getSubPosition()) : 1.0f;
                    this.propertyCache.setProperty(iNode, "ds_inactive", f7);
                }
                Object object2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getIconData(1);
                IWrappedTexture iWrappedTexture4 = iWrappedTexture = object2 instanceof Integer ? this.getGuideTexture((Integer)object2, n2) : this.getTexture(object2, n2);
                if (iWrappedTexture == null) {
                    this.propertyCache.setProperty(iNode, "ReflexTexture", (ITexture)null);
                    continue;
                }
                this.propertyCache.setProperty(iNode, "ReflexTexture", iWrappedTexture.getTexture());
                this.propertyCache.setColorProperty(iNode, "Color", bl5 && bl6 ? this.ealColors[0] : this.colorWhite);
                continue;
            }
            this.propertyCache.setProperty((INode)animNode, new StringBuffer().append("ds_mainItemPos").append(i2).toString(), 0.0f);
            if (!iNode.isVisible()) continue;
            iNode.setVisible(false);
        }
        if (abstractPlaceholderMenuController$Cursor.isVisible() && abstractPlaceholderMenuController$Cursor.isCursorWidthInitialized()) {
            this.propertyCache.setProperty(mainFocusCursorNode, "c1_width", abstractPlaceholderMenuController$Cursor.getCurrentWidth());
        }
    }

    private float flipTextAndReturnTranslationX(INode3DText iNode3DText) {
        boolean bl = this.isLTR();
        if (bl) {
            iNode3DText.setScale(1.0f, 1.0f, 1.0f);
            return 0.0f;
        }
        iNode3DText.setScale(32959, 1.0f, 1.0f);
        return Math.abs(iNode3DText.getWidth());
    }

    private int calculateCurrentFocusWidth(AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor, int n) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry;
        float f2 = abstractPlaceholderMenuController$Cursor.getHddsOffset();
        if (f2 == 0.0f) {
            return n;
        }
        boolean bl = f2 > 0.0f;
        for (abstractPlaceholderMenuController$PlaceholderItemEntry = abstractPlaceholderMenuController$Cursor.getTargetItemEntry().getNextIteratedEntry(bl); abstractPlaceholderMenuController$PlaceholderItemEntry != null && !abstractPlaceholderMenuController$PlaceholderItemEntry.isVisible(); abstractPlaceholderMenuController$PlaceholderItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry.getNextIteratedEntry(bl)) {
        }
        int n2 = this.getLabelWidth(abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (n2 == -1) {
            return n;
        }
        return (int)((float)n + (float)(n2 - n) * Math.abs(f2));
    }

    private int getLabelWidth(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return -1;
        }
        String string = abstractPlaceholderMenuController$PlaceholderItemEntry.getLabelText();
        return this.getEALManager().getTextWidth(string, this.getFont());
    }

    private void applyPropertiesSub() {
        boolean bl;
        boolean bl2;
        float f2;
        this.propertyCache.setProperty((INode)animNode, "ds_sub_arrow_up", 0.0f);
        this.propertyCache.setProperty((INode)animNode, "ds_sub_arrow_down", 0.0f);
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor = this.controller.getSubFocusCursor();
        if (abstractPlaceholderMenuController$Cursor.isVisible()) {
            float f3 = abstractPlaceholderMenuController$Cursor.getCurrentPosition();
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub sub focus cursor pos %1", (double)f3);
            if (!subFocusCursorNode.isVisible()) {
                subFocusCursorNode.setVisible(true);
            }
            if (this.controller.isBouncing()) {
                this.propertyCache.setProperty((INode)animNode, "ds_subC1", f3 + this.controller.getBounceOffset());
            } else {
                this.propertyCache.setProperty((INode)animNode, "ds_subC1", f3);
            }
        } else {
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub sub focus cursor invisible");
            if (subFocusCursorNode.isVisible()) {
                subFocusCursorNode.setVisible(false);
            }
            return;
        }
        this.propertyCache.setColorProperty(subFocusCursorNode, "Color", this.ealColors[0]);
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor2 = this.controller.getSubSelectionCursor();
        if (abstractPlaceholderMenuController$Cursor2.isVisible()) {
            f2 = abstractPlaceholderMenuController$Cursor2.getCurrentPosition();
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub sub selection cursor pos=%1", (double)f2);
            if (!subSelectionCursorNode.isVisible()) {
                subSelectionCursorNode.setVisible(true);
            }
            this.propertyCache.setProperty((INode)animNode, "ds_subC2", f2);
            this.propertyCache.setColorProperty(subSelectionCursorNode, "Color", this.ealColors[0]);
        } else {
            lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub sub selection cursor invisible");
            if (subSelectionCursorNode.isVisible()) {
                subSelectionCursorNode.setVisible(false);
            }
        }
        f2 = this.controller.getSubScrollbarLength();
        if (f2 <= 0.0f) {
            bl2 = false;
            bl = false;
        } else {
            float f4 = this.controller.getSubScrollbarPosition();
            bl2 = f4 > 0.0f;
            boolean bl3 = bl = f4 + f2 < 1.0f;
            if (lc.isDebug()) {
                lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub viewport position %1, length %2", (Object)new Float(f4), (Object)new Float(f2));
            }
        }
        boolean bl4 = this.getTerminal().getViewSizeManager().isSportskinSmallStage();
        lc.log(-2137614336, "SelectionMenuRendererHigh#applyPropertiesSub scroll arrows visible ? up=%1, down=%2", bl2 && !bl4, bl && !bl4);
        this.propertyCache.setProperty((INode)animNode, "ds_sub_arrow_up", bl2 && !bl4 ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)animNode, "ds_sub_arrow_down", bl && !bl4 ? 1.0f : 0.0f);
        if (this.controller.getSubPosition() <= 0.0f) {
            return;
        }
        int n = this.getInitContext().getScreenID();
        List list = this.controller.getSubSlots();
        int n2 = Math.min(5, list.size());
        for (int i2 = 0; i2 < n2; ++i2) {
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)list.get(i2);
            INode iNode = subItemNodes[i2];
            if (abstractPlaceholderMenuController$Slot.isEnabled()) {
                IWrappedTexture iWrappedTexture;
                Object object;
                IWrappedTexture iWrappedTexture2;
                long l;
                if (!iNode.isVisible()) {
                    iNode.setVisible(true);
                }
                float f5 = abstractPlaceholderMenuController$Slot.getPosition();
                this.propertyCache.setProperty((INode)animNode, new StringBuffer().append("ds_subItemPos").append(i2).toString(), f5);
                INode3DText iNode3DText = subItemlabels[i2];
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = abstractPlaceholderMenuController$Slot.getItemEntry();
                boolean bl5 = abstractPlaceholderMenuController$PlaceholderItemEntry.equals(abstractPlaceholderMenuController$Cursor2.getTargetItemEntry());
                boolean bl6 = abstractPlaceholderMenuController$PlaceholderItemEntry.isEnabled();
                boolean bl7 = abstractPlaceholderMenuController$PlaceholderItemEntry.isFocused();
                String string = abstractPlaceholderMenuController$PlaceholderItemEntry.getLabelText();
                if (string == null) {
                    string = " ";
                }
                if (lc.isDebug()) {
                    lc.log(-2137614336, new StringBuffer().append("SelectionMenuRendererHigh#applyPropertiesSub sub icon %1, pos=%2, text='%3' selected=%4, focused=").append(bl7).toString(), (Object)Util.createInteger(i2), (Object)new Float(f5), (Object)string, (Object)bl5);
                }
                if (!string.equals(subItemlabelTexts[i2])) {
                    SelectionMenuRendererHigh.subItemlabelTexts[i2] = string;
                    this.font.getFontGroup().activate();
                    iNode3DText.setText(this.font.getSize(), string);
                }
                if (bl5 || bl7) {
                    int n3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getTextWidth();
                    if (bl5) {
                        this.propertyCache.setProperty(subSelectionCursorNode, "c2_width", (float)n3);
                    }
                    if (bl7 && !abstractPlaceholderMenuController$Cursor.isCursorWidthInitialized()) {
                        abstractPlaceholderMenuController$Cursor.setTargetWidth(this.calculateCurrentFocusWidth(abstractPlaceholderMenuController$Cursor, n3));
                    }
                }
                SelectionMenuRendererHigh.lastSubItemLabelColors[i2] = l = this.getTextColor(bl6, bl5);
                iNode3DText.setColor(l);
                iNode3DText.invalidateObject();
                float f6 = this.flipTextAndReturnTranslationX(iNode3DText);
                int n4 = this.font.getSize() - this.font.getFontGroup().getAscent(this.font.getSize());
                if (iNode3DText.getTranslationY() != (float)n4 || iNode3DText.getTranslationX() != f6) {
                    iNode3DText.setTranslation(f6, n4, 0.0f);
                }
                IWrappedTexture iWrappedTexture3 = iWrappedTexture2 = (object = abstractPlaceholderMenuController$PlaceholderItemEntry.getIconData(0)) instanceof Integer ? this.getGuideTexture((Integer)object, n) : this.getTexture(object, n);
                if (iWrappedTexture2 == null) {
                    this.propertyCache.setProperty(iNode, "Texture", (ITexture)null);
                } else {
                    this.propertyCache.setProperty(iNode, "Texture", iWrappedTexture2.getTexture());
                    this.propertyCache.setColorProperty(iNode, "Color", bl5 && bl6 ? this.ealColors[0] : this.colorWhite);
                }
                Object object2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getIconData(1);
                IWrappedTexture iWrappedTexture4 = iWrappedTexture = object2 instanceof Integer ? this.getGuideTexture((Integer)object2, n) : this.getTexture(object2, n);
                if (iWrappedTexture == null) {
                    this.propertyCache.setProperty(iNode, "ReflexTexture", (ITexture)null);
                    continue;
                }
                this.propertyCache.setProperty(iNode, "ReflexTexture", iWrappedTexture.getTexture());
                this.propertyCache.setColorProperty(iNode, "Color", bl5 && bl6 ? this.ealColors[0] : this.colorWhite);
                continue;
            }
            this.propertyCache.setProperty((INode)animNode, new StringBuffer().append("ds_subItemPos").append(i2).toString(), 0.0f);
            if (!iNode.isVisible()) continue;
            iNode.setVisible(false);
        }
        if (abstractPlaceholderMenuController$Cursor.isVisible() && abstractPlaceholderMenuController$Cursor.isCursorWidthInitialized()) {
            this.propertyCache.setProperty(subFocusCursorNode, "c1_width", abstractPlaceholderMenuController$Cursor.getCurrentWidth());
        }
    }

    private IWrappedTexture getGuideTexture(Integer n, int n2) {
        if (n == null) {
            return null;
        }
        IWrappedTexture iWrappedTexture = (IWrappedTexture)this.textureMap.get(n);
        if (iWrappedTexture != null) {
            return iWrappedTexture;
        }
        TextureDescription textureDescription = this.getTextureDescription(n, n2);
        if (textureDescription == null) {
            return null;
        }
        IWrappedTexture iWrappedTexture2 = textureDescription.getTexture(this);
        if (iWrappedTexture2 == null) {
            return null;
        }
        this.textureMap.put(n, iWrappedTexture2);
        return iWrappedTexture2;
    }

    private IWrappedTexture getTexture(Object object, int n) {
        if (object == null) {
            return null;
        }
        TextureDescription textureDescription = this.getTextureDescription(object, n);
        if (textureDescription == null) {
            return null;
        }
        Object object2 = textureDescription.getCacheKey();
        IWrappedTexture iWrappedTexture = (IWrappedTexture)this.textureMap.get(object2);
        if (iWrappedTexture != null) {
            return iWrappedTexture;
        }
        IWrappedTexture iWrappedTexture2 = textureDescription.getTexture(this);
        if (iWrappedTexture2 == null) {
            return null;
        }
        this.textureMap.put(object2, iWrappedTexture2);
        return iWrappedTexture2;
    }

    private TextureDescription getTextureDescription(Object object, int n) {
        EALManager eALManager = this.getEALManager();
        if (object instanceof Integer) {
            int n2 = (Integer)object;
            return eALManager.createTextureDescription(n2, false, n);
        }
        if (object instanceof String) {
            HMIImage hMIImage = new HMIImage((String)object, 6);
            return eALManager.createTextureDescription(hMIImage, eALManager.getCache(1), false);
        }
        if (object instanceof HMIResourceLocator) {
            HMIImage hMIImage = eALManager.getHMIImage((HMIResourceLocator)object, n, false);
            if (hMIImage == null) {
                return null;
            }
            return eALManager.createTextureDescription(hMIImage, eALManager.getCache(1), false);
        }
        lc.log(10000, "SelectionMenuRendererHigh#getImagePath Unsupported image data type %1", object);
        return null;
    }

    private long getTextColor(boolean bl, boolean bl2) {
        if (!bl) {
            return this.ealColors[2];
        }
        if (bl2) {
            return this.ealColors[3];
        }
        return this.ealColors[1];
    }

    private IWrappedFont getFont() {
        if (this.font != null) {
            return this.font;
        }
        this.font = this.getInheritedFont();
        return this.font;
    }

    private void loadResources() {
        INode3DText iNode3DText;
        String string;
        INode3D iNode3D;
        INode3D iNode3D2;
        int n;
        lc.log(-2137614336, "SelectionMenuRendererHigh#loadResources: loading resources");
        if (!projectMerged) {
            if (EALManager.isSelectionDrawerMerged()) {
                this.finishAsyncMerge("Layers/ds_root");
                projectMerged = true;
            } else {
                lc.log(-2137614336, "SelectionMenuRendererHigh#loadResources: project not merged");
                return;
            }
        }
        if (animNode == null) {
            animNode = this.getNode3D("ds_animControls");
        }
        if (animNode == null) {
            return;
        }
        mainFocusCursorNode = this.getNode3D("ds_main_c1");
        if (mainFocusCursorNode == null) {
            this.clearResources();
            return;
        }
        mainSelectionCursorNode = this.getNode3D("ds_main_c2");
        if (mainSelectionCursorNode == null) {
            this.clearResources();
            return;
        }
        subFocusCursorNode = this.getNode3D("ds_sub_c1");
        if (subFocusCursorNode == null) {
            this.clearResources();
            return;
        }
        subSelectionCursorNode = this.getNode3D("ds_sub_c2");
        if (subSelectionCursorNode == null) {
            this.clearResources();
            return;
        }
        for (n = 0; n < 6; ++n) {
            iNode3D2 = this.getNode3D(new StringBuffer().append("ds_main_item").append(n).toString());
            if (iNode3D2 == null) {
                this.clearResources();
                return;
            }
            SelectionMenuRendererHigh.mainItemNodes[n] = iNode3D2;
            iNode3D = this.getNode3D(new StringBuffer().append("ds_main_label").append(n).toString());
            if (iNode3D == null) {
                this.clearResources();
                return;
            }
            SelectionMenuRendererHigh.mainItemLabelParents[n] = iNode3D;
            string = EALManager.createNodeName("maintextnode", n, (AbstractRenderer)this);
            lc.log(-2137614336, "SelectionMenuRendererHigh#loadResources: creating label node %2: '%1'", (Object)string, (long)n);
            iNode3DText = this.createTextNode(string);
            if (iNode3DText == null) {
                this.clearResources();
                return;
            }
            iNode3D.add(iNode3DText);
            SelectionMenuRendererHigh.mainItemlabels[n] = iNode3DText;
        }
        for (n = 0; n < 5; ++n) {
            iNode3D2 = this.getNode3D(new StringBuffer().append("ds_sub_item").append(n).toString());
            if (iNode3D2 == null) {
                this.clearResources();
                return;
            }
            SelectionMenuRendererHigh.subItemNodes[n] = iNode3D2;
            iNode3D = this.getNode3D(new StringBuffer().append("ds_sub_label").append(n).toString());
            if (iNode3D == null) {
                this.clearResources();
                return;
            }
            SelectionMenuRendererHigh.subItemLabelParents[n] = iNode3D;
            string = EALManager.createNodeName("subtextnode", n, (AbstractRenderer)this);
            lc.log(-2137614336, "SelectionMenuRendererHigh#loadResources: creating label node %2: '%1'", (Object)string, (long)n);
            iNode3DText = this.createTextNode(string);
            if (iNode3DText == null) {
                this.clearResources();
                return;
            }
            iNode3D.add(iNode3DText);
            SelectionMenuRendererHigh.subItemlabels[n] = iNode3DText;
        }
        this.reinitializeViewSize();
        resourcesLoaded = true;
        lc.log(-2137614336, "SelectionMenuRendererHigh#loadResources: resources loaded");
    }

    private INode3DText createTextNode(String string) {
        INode3DText iNode3DText = new INode3DText(this.getEALManager().getProject(), string);
        if (!iNode3DText.isValid()) {
            lc.log(-2137614336, "SelectionMenuRendererHigh#createTextNode could not create text node '%1'", (Object)string);
            iNode3DText.dispose();
            return null;
        }
        iNode3DText.rotateX(13379);
        return iNode3DText;
    }

    private void clearResources() {
        INode iNode;
        INode iNode2;
        INode3DText iNode3DText;
        int n;
        lc.log(-2137614336, "SelectionMenuRendererHigh#clearResources: clearing properties");
        this.propertyCache.clearAll();
        lc.log(-2137614336, "SelectionMenuRendererHigh#clearResources: disposing item nodes");
        for (n = 0; n < mainItemlabels.length; ++n) {
            iNode3DText = mainItemlabels[n];
            iNode2 = mainItemLabelParents[n];
            iNode = mainItemNodes[n];
            if (iNode2 != null && iNode3DText != null) {
                iNode2.remove(iNode3DText);
            }
            this.getEALManager().destroy(iNode3DText);
            this.disposeNode(iNode2);
            this.disposeNode(iNode);
            SelectionMenuRendererHigh.mainItemlabels[n] = null;
            SelectionMenuRendererHigh.mainItemLabelParents[n] = null;
            SelectionMenuRendererHigh.mainItemNodes[n] = null;
            SelectionMenuRendererHigh.mainItemlabelTexts[n] = null;
        }
        for (n = 0; n < subItemlabels.length; ++n) {
            iNode3DText = subItemlabels[n];
            iNode2 = subItemLabelParents[n];
            iNode = subItemNodes[n];
            if (iNode2 != null && iNode3DText != null) {
                iNode2.remove(iNode3DText);
            }
            this.getEALManager().destroy(iNode3DText);
            this.disposeNode(iNode2);
            this.disposeNode(iNode);
            SelectionMenuRendererHigh.subItemlabels[n] = null;
            SelectionMenuRendererHigh.subItemLabelParents[n] = null;
            SelectionMenuRendererHigh.subItemNodes[n] = null;
            SelectionMenuRendererHigh.subItemlabelTexts[n] = null;
        }
        this.font = null;
        this.disposeNode(mainFocusCursorNode);
        mainFocusCursorNode = null;
        this.disposeNode(mainSelectionCursorNode);
        mainSelectionCursorNode = null;
        this.disposeNode(subFocusCursorNode);
        subFocusCursorNode = null;
        this.disposeNode(subSelectionCursorNode);
        subSelectionCursorNode = null;
        this.destroyColors();
        resourcesLoaded = false;
        lc.log(-2137614336, "SelectionMenuRendererHigh#clearResources: resources cleared");
    }

    private void destroyColors() {
        this.colorsInitialized = false;
    }

    private void disposeNode(INode iNode) {
        if (iNode == null) {
            return;
        }
        iNode.dispose();
    }

    private INode3D getNode3D(String string) {
        lc.log(-2137614336, "SelectionMenuRendererHigh#getNode3D: getting node '%1'", (Object)string);
        INode3D iNode3D = this.getEALManager().getProject().getNode3D(string);
        if (!iNode3D.isValid()) {
            lc.log(10000, "SelectionMenuRendererHigh#getNode3D: Could not get node '%1'", (Object)string);
            iNode3D.dispose();
            return null;
        }
        return iNode3D;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        this.clearResources();
        Iterator iterator = this.textureMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            IWrappedTexture iWrappedTexture = (IWrappedTexture)map$Entry.getValue();
            if (iWrappedTexture == null) continue;
            iWrappedTexture.releaseTexture(true, this);
        }
        this.textureMap.clear();
    }

    @Override
    public void inOutPositionChanged() {
        if (animNode == null) {
            return;
        }
        float f2 = this.controller.getInOutPosition();
        if (!this.controller.isConnected()) {
            lc.log(-1601830656, "SelectionMenuRendererHigh#inOutPositionChanged controller not connected, explicitly set animNode to visible=false, was %1, inOutPosition=%2", animNode.isVisible(), (Object)Float.toString(f2));
            animNode.setVisible(false);
            return;
        }
        this.propertyCache.setProperty((INode)animNode, "ds_RingPos", f2);
        if (animNode.isVisible() != f2 > 0.0f) {
            animNode.setVisible(f2 > 0.0f);
        }
    }

    @Override
    public StringUtility getStringUtility() {
        return ((HMITerminalImplMIB2High)this.getTerminal()).getStringUtility(this.font);
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }

    public void setIconWidth(float f2) {
        this.iconWidth = f2;
    }

    public void setRightPadding(float f2) {
        this.rightPadding = f2;
    }

    public float getReflexStrength() {
        return this.reflexStrength;
    }

    public void setReflexStrength(float f2) {
        this.reflexStrength = f2;
    }

    public int getYTextOffset() {
        return this.yTextOffset;
    }

    public void setYTextOffset(int n) {
        this.yTextOffset = n;
    }

    public void finishAsyncMerge(String string) {
        EALManager eALManager = this.getEALManager();
        INode2D iNode2D = eALManager.getShortcutNode2D(string);
        if (iNode2D == null) {
            logChannelParking.log(10000, "SelectionMenuRendererHigh#mergeFinished: unable to get async merged node \"%1\" from project", (Object)string);
            return;
        }
        eALManager.getMasterRoot().addAuto(iNode2D, 200);
        iNode2D.dispose();
        logChannelParking.log(1078071040, "SelectionMenuRendererHigh#mergeFinished: asynchronous merge finalized");
    }

    static {
        mainItemNodes = new INode[6];
        mainItemLabelParents = new INode[6];
        mainItemlabels = new INode3DText[6];
        mainItemlabelTexts = new String[6];
        lastMainItemLabelColors = new long[6];
        subItemNodes = new INode[5];
        subItemLabelParents = new INode[5];
        subItemlabels = new INode3DText[5];
        subItemlabelTexts = new String[5];
        lastSubItemLabelColors = new long[5];
        lc = logSelectionDrawerRenderer;
    }
}

