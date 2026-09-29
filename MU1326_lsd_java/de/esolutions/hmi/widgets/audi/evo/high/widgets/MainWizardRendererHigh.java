/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Cursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Slot;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MainWizardController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuRenderer;
import java.util.List;

public class MainWizardRendererHigh
extends AbstractRendererHigh
implements PlaceholderMenuRenderer,
IKanziTemplateRenderer {
    private final MainWizardController controller;
    private static final int PLACEHOLDER_COUNT;
    private static IWrappedNode3D animNode;
    private static IWrappedNode3D cursorNode;
    private static final IWrappedNode3D[] ITEM_NODES_3D;
    private static final INode3D[] ITEM_PARENT_NODES;
    private static final INode3DText[] LABELS;
    private static final String[] LABEL_TEXTS;
    private static final int SCROLL_ARROW_BEFORE;
    private static final int SCROLL_ARROW_AFTER;
    private static final INode2D[] SCROLL_ARROWS;
    private static INode2D decorator;
    private static boolean resourcesLoaded;
    private static boolean projectMerged;
    private IWrappedFont font;
    private static final String PROPERTY_KEY_ITEM_POS;
    private static final int COLOR_COUNT;
    private final int[] ealColors = new int[4];
    private static final int COLOR_INDEX_FOCUS_CURSOR;
    private boolean colorsInitialized;
    private int colorWhite;
    private int colorLocked;
    private final EALPropertyCache propertyCache = new EALPropertyCache();
    public static final float BASELINE_OFFSET_DEFAULT;
    private float baselineOffset = 0.0f;
    private Buffer stringBuilder = new Buffer();

    public MainWizardRendererHigh(MainWizardController mainWizardController) {
        this.controller = mainWizardController;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender()) {
            if (resourcesLoaded) {
                this.setAnimNodes();
            }
            return;
        }
        if (!resourcesLoaded) {
            this.loadResources();
            if (!resourcesLoaded) {
                return;
            }
        }
        if (!this.colorsInitialized) {
            for (int i2 = 0; i2 < 4; ++i2) {
                int n = redrawContext.getColor(i2);
                this.ealColors[i2] = EALManager.createColorCode(n);
            }
            this.colorWhite = EALManager.createColorCode(-1);
            this.colorLocked = EALManager.createColorCode(redrawContext.getColor(2));
            this.colorsInitialized = true;
        }
        this.applyProperties(redrawContext);
    }

    private void setAnimNodes() {
        this.propertyCache.setProperty(animNode, "mw_RingPos", 0.0f);
        if (animNode.isVisible()) {
            animNode.setVisible(false);
        }
    }

    private void applyProperties(RedrawContext redrawContext) {
        Object object;
        int n;
        boolean bl;
        boolean bl2;
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#applyProperties");
        float f2 = this.controller.getInOutPosition();
        if (animNode.isVisible() != f2 > 0.0f) {
            animNode.setVisible(f2 > 0.0f);
        }
        animNode.setOpacity(this.controller.getRenderOpacity());
        animNode.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.propertyCache.setProperty(animNode, "mw_RingPos", f2);
        this.propertyCache.setProperty(animNode, "mw_scale", this.controller.getMainWizardScaling());
        this.propertyCache.setProperty(animNode, "mw_desaturate", this.controller.getMainWizardDesaturation());
        this.propertyCache.setProperty(animNode, "mw_darken", this.controller.getMainWizardDarkening());
        if (this.controller.isBouncing()) {
            this.propertyCache.setProperty(cursorNode, "mw_CursorPos", this.controller.getFocusCursor().getCurrentPosition() + this.controller.getBounceOffset());
        } else {
            this.propertyCache.setProperty(cursorNode, "mw_CursorPos", this.controller.getFocusCursor().getCurrentPosition());
        }
        float f3 = this.controller.getScrollbarLength();
        if (f3 <= 0.0f) {
            bl2 = false;
            bl = false;
        } else {
            float f4 = this.controller.getScrollbarPosition();
            bl2 = f4 > 0.0f;
            boolean bl3 = bl = f4 + f3 < 1.0f;
            if (logChannelWizardRenderer.isDebug()) {
                logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#applyProperties viewport position %1, length %2", (Object)new Float(f4), (Object)new Float(f3));
            }
        }
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#applyProperties scroll arrows visible ? before=%1, after=%2", bl2, bl);
        this.propertyCache.setProperty((INode)SCROLL_ARROWS[0], "Visible", bl2);
        this.propertyCache.setProperty((INode)SCROLL_ARROWS[0], "ealOpacity", bl2 ? f2 : 0.0f);
        this.propertyCache.setProperty((INode)SCROLL_ARROWS[1], "Visible", bl);
        this.propertyCache.setProperty((INode)SCROLL_ARROWS[1], "ealOpacity", bl ? f2 : 0.0f);
        List list = this.controller.getSlots();
        for (n = 0; n < 9; ++n) {
            object = ITEM_NODES_3D[n];
            this.propertyCache.setProperty((IWrappedNode3D)object, "mw_CursorPos", 0.0f);
            INode3DText iNode3DText = LABELS[n];
            if (!iNode3DText.isVisible()) continue;
            iNode3DText.setVisible(false);
        }
        n = Math.min(9, list.size());
        this.font.getFontGroup().activate();
        object = this.controller.getFocusCursor();
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)list.get(i2);
            IWrappedNode3D iWrappedNode3D = ITEM_NODES_3D[i2];
            INode3DText iNode3DText = LABELS[i2];
            if (abstractPlaceholderMenuController$Slot.isEnabled()) {
                int n2;
                boolean bl4;
                int n3;
                int n4;
                int[] nArray;
                float f5 = abstractPlaceholderMenuController$Slot.getPosition();
                this.propertyCache.setProperty(iWrappedNode3D, "mw_CursorPos", f5);
                if (f5 > 0.0f && f5 < 4161) {
                    if (!iNode3DText.isVisible()) {
                        iNode3DText.setVisible(true);
                    }
                    String string = abstractPlaceholderMenuController$Slot.getItemEntry().getLabelText();
                    if (logChannelWizardRenderer.isDebug2()) {
                        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#applyProperties Setting label at position %1 to '%2'", (Object)String.valueOf(f5), (Object)string);
                    }
                    iNode3DText.setColor(this.controller.isLocked(abstractPlaceholderMenuController$Slot.getItem()) ? (long)this.colorLocked : (long)this.colorWhite);
                    if (LABEL_TEXTS[i2] == null || !LABEL_TEXTS[i2].equals(string)) {
                        iNode3DText.setText(this.font.getLayout(), string);
                        MainWizardRendererHigh.LABEL_TEXTS[i2] = string;
                    }
                    int n5 = 63;
                    int n6 = this.font.getSize();
                    nArray = this.controller.getMainWizardTextOffset();
                    n4 = 0;
                    this.baselineOffset = 0.0f;
                    if ((double)f5 >= 2.5 && (double)f5 < 7.5) {
                        n4 = Math.round(f5) - 3;
                        this.baselineOffset = nArray[n4];
                    }
                    float f6 = this.flipTextAndReturnTranslationX(iNode3DText);
                    n3 = (int)((float)n6 * n5 + this.baselineOffset);
                    if (iNode3DText.getTranslationY() != (float)n3 || iNode3DText.getTranslationX() != f6) {
                        iNode3DText.setTranslation(f6, n3, 0.0f);
                    }
                }
                this.propertyCache.setProperty(iWrappedNode3D, "icon_highlight", (bl4 = abstractPlaceholderMenuController$Slot.isFocused()) && !this.controller.isLocked(abstractPlaceholderMenuController$Slot.getItem()) ? 1.0f : 0.0f);
                iWrappedNode3D.setOpacity(this.controller.isLocked(abstractPlaceholderMenuController$Slot.getItem()) ? this.controller.getLockingShadingOpacity() : this.controller.getRenderOpacity());
                Object object2 = abstractPlaceholderMenuController$Slot.getItemEntry().getIconData(bl4 ? 0 : 1);
                if (object2 == null) {
                    logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties no icon data found for itemEntry %1", (Object)abstractPlaceholderMenuController$Slot.getItemEntry());
                    n2 = -1;
                } else {
                    n2 = (Integer)object2;
                }
                if (n2 >= 0) {
                    int n7 = 0;
                    n4 = 0;
                    int[][] nArray2 = this.controller.getMainWizardIconDecoratorMapping();
                    if (nArray2 != null) {
                        if (n2 < nArray2.length) {
                            n4 = nArray2[n2][0];
                            if (n4 >= 0) {
                                this.propertyCache.setProperty(iWrappedNode3D, "AtlasIndex", (float)n4);
                            } else {
                                logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties no mapping found for iconIndex %1 ", (long)n4);
                            }
                            n7 = nArray2[n2][1];
                            if (bl4) {
                                if (n7 >= 0) {
                                    this.propertyCache.setProperty((INode)decorator, "AtlasIndex", (float)n7);
                                } else {
                                    logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties no mapping found for decoratorIndex %1 ", (long)n7);
                                }
                            }
                        } else {
                            logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties no mapping found for atlasIndex %1 ", (long)n2);
                        }
                    } else {
                        logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties no icon/decorator mapping available, configure it in the layout class");
                    }
                }
                if (!bl4) continue;
                if (!((AbstractPlaceholderMenuController$Cursor)object).isCursorWidthInitialized()) {
                    int n8 = this.calculateCurrentFocusWidth((AbstractPlaceholderMenuController$Cursor)object, (int)iNode3DText.getWidth());
                    ((AbstractPlaceholderMenuController$Cursor)object).setTargetWidth(n8);
                }
                if ((nArray = abstractPlaceholderMenuController$Slot.getItem().getColorIndices()) != null && nArray.length > 0) {
                    int[] nArray3 = redrawContext.getActiveColorPlate();
                    int n9 = nArray[0];
                    if (nArray3 != null && nArray3.length > n9) {
                        n3 = this.controller.isLocked(abstractPlaceholderMenuController$Slot.getItem()) ? this.colorLocked : EALManager.createColorCode(nArray3[n9]);
                        this.propertyCache.setColorProperty(cursorNode, "Color", n3);
                        continue;
                    }
                    logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties color index %2 not in activeColorPlate %1", (Object)nArray3, (long)n9);
                    continue;
                }
                logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#applyProperties color index %2 not set at menu item %1", (Object)abstractPlaceholderMenuController$Slot.getItemEntry(), 0L);
                continue;
            }
            if (!iNode3DText.isVisible()) continue;
            iNode3DText.setVisible(false);
        }
        if (((AbstractPlaceholderMenuController$Cursor)object).isVisible() && ((AbstractPlaceholderMenuController$Cursor)object).isCursorWidthInitialized()) {
            this.propertyCache.setProperty(animNode, "mw_bracket_width", ((AbstractPlaceholderMenuController$Cursor)object).getCurrentWidth());
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
        return this.getEALManager().getTextWidth(string, this.font);
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        this.font = this.getInheritedFont();
        super.connect(initializationContext);
    }

    private void loadResources() {
        Object object;
        int n;
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#loadResources: loading resources");
        EALManager eALManager = this.getEALManager();
        if (projectMerged) {
            logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#loadResources: project already merged");
        } else {
            logChannelWizardRenderer.log(1078071040, "MainWizardRendererHigh#loadResources: merging project");
            n = this.getInitContext().getScreenID();
            object = eALManager.mergeProject(9, 170, n);
            if (object == null) {
                return;
            }
            this.disposeNode((INode)object);
            projectMerged = true;
            logChannelWizardRenderer.log(1078071040, "MainWizardRendererHigh#loadResources: project merged");
        }
        animNode = new WrappedNode3D(eALManager.getShortcutNode3D("mw_animControls"), 1.0f, 1.0f, false, 0, this.isLTR());
        if (animNode == null) {
            return;
        }
        decorator = eALManager.getShortcutNode2D("mw_decorator");
        if (decorator == null) {
            this.clearResources();
            return;
        }
        cursorNode = new WrappedNode3D(eALManager.getShortcutNode3D("mw_cursor"), 1.0f, 1.0f, false, 0, this.isLTR());
        if (cursorNode == null) {
            this.clearResources();
            return;
        }
        MainWizardRendererHigh.SCROLL_ARROWS[0] = eALManager.getShortcutNode2D("scroll_arrow_top");
        if (SCROLL_ARROWS[0] == null) {
            this.clearResources();
            return;
        }
        MainWizardRendererHigh.SCROLL_ARROWS[1] = eALManager.getShortcutNode2D("scroll_arrow_bottom");
        if (SCROLL_ARROWS[1] == null) {
            this.clearResources();
            return;
        }
        for (n = 0; n < 9; ++n) {
            object = this.concat("mw_item", n);
            INode3D iNode3D = eALManager.getShortcutNode3D((String)object);
            if (iNode3D == null) {
                this.clearResources();
                return;
            }
            MainWizardRendererHigh.ITEM_NODES_3D[n] = new WrappedNode3D(iNode3D, 1.0f, 1.0f, false, 0, this.isLTR());
            String string = this.concat("mw_item", n, "_label");
            INode3D iNode3D2 = eALManager.getShortcutNode3D(string);
            if (iNode3D2 == null) {
                logChannelWizardRenderer.log(10000, "MainWizardRendererHigh#loadResources: can not get shortcutNode3D");
                this.clearResources();
                return;
            }
            MainWizardRendererHigh.ITEM_PARENT_NODES[n] = iNode3D2;
            String string2 = this.concat("textnode", n);
            logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#loadResources: creating label node '%1'", (Object)string2);
            INode3DText iNode3DText = this.createTextNode(string2);
            if (iNode3DText == null) {
                this.clearResources();
                return;
            }
            iNode3D2.add(iNode3DText);
            MainWizardRendererHigh.LABELS[n] = iNode3DText;
        }
        resourcesLoaded = true;
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#loadResources: resources loaded");
    }

    private void clearResources() {
        int n;
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: clearing resources");
        if (animNode != null) {
            this.propertyCache.setProperty(animNode, "mw_RingPos", 0.0f);
        }
        this.propertyCache.clearAll();
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: disposing labels");
        for (n = 0; n < LABELS.length; ++n) {
            INode3DText iNode3DText = LABELS[n];
            if (iNode3DText == null) continue;
            ITEM_PARENT_NODES[n].remove(iNode3DText);
            this.getEALManager().destroy(iNode3DText);
            MainWizardRendererHigh.LABELS[n] = null;
            MainWizardRendererHigh.LABEL_TEXTS[n] = null;
        }
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: disposing item nodes");
        for (n = 0; n < ITEM_NODES_3D.length; ++n) {
            this.disposeNode(ITEM_NODES_3D[n]);
            MainWizardRendererHigh.ITEM_NODES_3D[n] = null;
        }
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: disposing item layers");
        for (n = 0; n < ITEM_PARENT_NODES.length; ++n) {
            this.disposeNode(ITEM_PARENT_NODES[n]);
            MainWizardRendererHigh.ITEM_PARENT_NODES[n] = null;
        }
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: disposing scroll arrows");
        for (n = 0; n < SCROLL_ARROWS.length; ++n) {
            this.disposeNode(SCROLL_ARROWS[n]);
            MainWizardRendererHigh.SCROLL_ARROWS[n] = null;
        }
        this.font = null;
        this.disposeNode(decorator);
        decorator = null;
        this.disposeNode(cursorNode);
        cursorNode = null;
        this.colorsInitialized = false;
        this.disposeNode(animNode);
        animNode = null;
        resourcesLoaded = false;
        logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#clearResources: resources cleared");
    }

    private void disposeNode(IWrappedNode3D iWrappedNode3D) {
        if (iWrappedNode3D == null) {
            return;
        }
        iWrappedNode3D.dispose();
        this.disposeNode(iWrappedNode3D.getNode());
    }

    private void disposeNode(INode iNode) {
        if (iNode == null) {
            return;
        }
        iNode.dispose();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        this.clearResources();
    }

    @Override
    public void inOutPositionChanged() {
        float f2 = this.controller.getInOutPosition();
        if (animNode != null) {
            this.propertyCache.setProperty(animNode, "mw_RingPos", f2);
        }
        if (animNode != null && animNode.isVisible() != f2 > 0.0f) {
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

    public void setBaselineOffset(float f2) {
        this.baselineOffset = f2;
    }

    private String concat(String string, int n) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(n);
        return this.stringBuilder.toString();
    }

    private String concat(String string, int n, String string2) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(n).append(string2);
        return this.stringBuilder.toString();
    }

    private INode3DText createTextNode(String string) {
        INode3DText iNode3DText = new INode3DText(this.getEALManager().getProject(), string);
        if (!iNode3DText.isValid()) {
            logChannelWizardRenderer.log(-2137614336, "MainWizardRendererHigh#createTextNode could not create text node '%1'", (Object)string);
            iNode3DText.dispose();
            return null;
        }
        iNode3DText.rotateX(13379);
        return iNode3DText;
    }

    static {
        ITEM_NODES_3D = new IWrappedNode3D[9];
        ITEM_PARENT_NODES = new INode3D[9];
        LABELS = new INode3DText[9];
        LABEL_TEXTS = new String[9];
        SCROLL_ARROWS = new INode2D[2];
    }
}

