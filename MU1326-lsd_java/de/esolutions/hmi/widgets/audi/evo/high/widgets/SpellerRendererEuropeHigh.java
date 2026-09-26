/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh$SpellerLayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$CharSet;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerIterator;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerArabia;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SpellerRendererEuropeHigh
extends AbstractKanziTemplateRenderer
implements ISpellerRenderer {
    private static final int CURSOR_NODE_INDEX_HIGHLIGHT;
    private static final int CURSOR_NODE_INDEX_NO_HIGHLIGHT;
    private Map separatorNodes;
    public static final String NODE_NAME_SPELLER_CLIP;
    public static final float OPACITY_DISABLED_NONTEXT_ITEMS;
    private static final String PROPERTY_COLOR;
    private static final String PROPERTY_CURSOR_WIDTH;
    private static final String PROPERTY_COMPLETION_ARROW;
    private static final int FONT_RIBBON;
    private static final int FONT_PREVIEW;
    private static final int FONT_AUTO_COMPLETION;
    private static final int BITMAP_CLOSE_PREVIEW_BACKGROUND;
    private static final int OFFSET_CHARSET_IMAGES;
    private static final int OFFSET_BUTTON_IMAGES;
    private static final int GAP_BEFORE_CHAR;
    private static final int GAP_BEFORE_BUTTON;
    private static final int Y_OFFSET_RIBBON;
    public static final int Y_OFFSET_TOP;
    private static final int Y_OFFSET_BIG_BUTTON_NODES;
    private static final int SCROLL_BOUNDARY;
    private static final int AUTO_COMPLETION_TEXT_BASELINE;
    private static final int AUTO_COMPLETION_Y_OFFSET;
    public static final int X_OFFSET_LEFT;
    private static final int X_OFFSET_RIGHT_GENERAL;
    private static final int X_OFFSET_RIGHT_MULTILINE;
    public static final int EXTRA_Y_OFFSET;
    private static final float BUTTON_CENTER_LINE;
    private static final int G22_BOX_EXTRA_HEIGHT;
    private final SpellerController controller;
    private IWrappedNode3D nodeForClipping;
    private IWrappedNode3D nodeRibbon;
    private IWrappedNode3D cursorNode;
    private IWrappedNode3D backgroundWordAlternatives;
    private float backgroundWordAlternativesWidth = 0.0f;
    private IWrappedNode3DText highlightNode;
    private static final float ALTERNATIVES_HEIGHT;
    private static final float ARROW_UP;
    private static final float ARROW_DOWN;
    private static final int AUTOCOMPLETION_HIGHT;
    private IWrappedNode3DText nodeAutoCompletionText;
    private IWrappedNode3D nodeAutoCompletion;
    private static final String SUGGESTION_NAME;
    private static final String SMS_ALTERNATIVES_BACKGROUND;
    private static final String SMS_ALTERNATIVES_PREFAB;
    private IWrappedNode3DImage suggestionBackground;
    private float suggestionX;
    private float suggestionY;
    private float suggestionW;
    private float suggestionH;
    protected final Map layoutData;
    private int xOffsetRight = 0;
    private float relPosCursor;
    private boolean bandStructureChanged;
    private boolean needsRelayout;
    private boolean isColorRefreshNeeded;
    private boolean caseSwitchHappened;
    private float startCursorWidth;
    private float currentCursorWidth;
    private float startCursorPos;
    private int baseline;
    private int endPosLastItem = -1;
    private SpellerController$ISpellerItem targetItem;
    private int startXOpeningItem = -1;
    private int endXOpeningItem = -1;
    private IWrappedNode3D boxNode;
    private IWrappedNode3D boxNodeClipp;
    private IWrappedNode3DImage closePreviewBackgroundNode;
    private IWrappedNode3DImage closePreviewButton;
    private IWrappedNode3D closePreviewNode;
    private int[] colorCache;
    private boolean isDeleteIconFlipped = false;
    private static final int COLOR_MULTILINE_SELECTED;
    private static final int COLOR_MULTILINE_NOT_SELECTED;
    private static final int COLOR_BLACK;
    private Object lastFocusedItem = null;

    public SpellerRendererEuropeHigh(SpellerController spellerController) {
        this.controller = spellerController;
        this.layoutData = new HashMap();
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.layoutData.clear();
        this.bandStructureChanged = false;
        this.needsRelayout = true;
        this.isColorRefreshNeeded = true;
        this.relPosCursor = 0.0f;
        this.endPosLastItem = -1;
        this.caseSwitchHappened = false;
        this.startXOpeningItem = -1;
        this.endXOpeningItem = -1;
        this.isDeleteIconFlipped = false;
    }

    @Override
    public final void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.nodeForClipping != null) {
                this.nodeForClipping.setVisible(false);
            }
            if (this.boxNodeClipp != null) {
                this.boxNodeClipp.setVisible(false);
            }
            if (this.backgroundWordAlternatives != null) {
                this.backgroundWordAlternatives.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.nodeForClipping == null) {
            this.initColors(redrawContext);
            this.initializeNodes(redrawContextHigh);
        }
        if (this.caseSwitchHappened) {
            this.handleCaseSwitch(redrawContextHigh);
            this.caseSwitchHappened = false;
        }
        if (this.nodeForClipping == null) {
            return;
        }
        this.applyProperties(redrawContextHigh);
        this.nodeForClipping.setPosition(this.controller.getX() - 0, this.controller.getY() - 12 - 28, 0.0f);
    }

    protected void initColors(RedrawContext redrawContext) {
        this.colorCache = new int[7];
        this.colorCache[0] = EALManager.createColorCode(redrawContext.getColor(0));
        this.colorCache[1] = EALManager.createColorCode(redrawContext.getColor(1));
        this.colorCache[2] = EALManager.createColorCode(redrawContext.getColor(2));
        this.colorCache[3] = EALManager.createColorCode(redrawContext.getColor(3));
        this.colorCache[4] = EALManager.createColorCode(11166975);
        this.colorCache[5] = EALManager.setBrightness(0x6666E63E, this.colorCache[4]);
        this.colorCache[6] = 255;
    }

    private static IWrappedNode3D getPaintNode(RedrawContext redrawContext) {
        IWrappedNode3D iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNodeSecondary;
        if (iWrappedNode3D == null) {
            iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNode;
        }
        return iWrappedNode3D;
    }

    private void handleCaseSwitch(RedrawContextHigh redrawContextHigh) {
        boolean bl = this.controller.isUpperCase();
        IWrappedFont iWrappedFont = redrawContextHigh.getFont(0);
        SpellerIterator spellerIterator = this.controller.getSpellerIterator(null, false);
        while (spellerIterator.hasNext()) {
            Object object;
            Object object2;
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
            if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem) {
                object2 = ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(bl);
                this.setCharacter(spellerController$ISpellerItem, (String)object2, iWrappedFont);
                continue;
            }
            if (!(spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem)) continue;
            object2 = (SpellerController$AbstractExpandableItem)spellerController$ISpellerItem;
            if (object2 instanceof SpellerController$AbstractExpandableItem$Char) {
                object = new StringBuffer().append("").append(((SpellerController$AbstractExpandableItem$Char)object2).getChar(bl)).toString();
                this.setCharacter(spellerController$ISpellerItem, (String)object, iWrappedFont);
            }
            object = ((SpellerController$AbstractExpandableItem)object2).getSubBand().iterator();
            while (object.hasNext()) {
                SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)object.next();
                String string = spellerController$SingleCharItem.getChar(bl);
                this.setCharacter(spellerController$SingleCharItem, string, iWrappedFont);
            }
        }
    }

    private void setCharacter(SpellerController$ISpellerItem spellerController$ISpellerItem, String string, IWrappedFont iWrappedFont) {
        Object object;
        if (this.layoutData != null && (object = this.layoutData.get(spellerController$ISpellerItem)) != null && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000((SpellerRendererEuropeHigh$SpellerLayoutContainer)object) instanceof IWrappedNode3DText) {
            ((IWrappedNode3DText)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000((SpellerRendererEuropeHigh$SpellerLayoutContainer)object)).setText(string, iWrappedFont);
        }
    }

    private void initializeNodes(RedrawContextHigh redrawContextHigh) {
        this.baseline = EALManager.getFontHeightUppercase(redrawContextHigh.getFont(0));
        this.xOffsetRight = this.controller.getSpellerMode() == 4 ? -18 : 0;
        this.nodeForClipping = this.getEALManager().createNode3D(null, EALManager.createNodeName("spellerClip", this), this.controller.getWidth() + 0 + this.xOffsetRight, this.controller.getHeight() + 12, 100);
        this.nodeForClipping.setClippingInheritance(17);
        this.nodeForClipping.setClipping(true);
        this.nodeForClipping.setPosition(this.controller.getX() - 0, this.controller.getY() - 12 - 28, 0.0f);
        SpellerRendererEuropeHigh.getPaintNode(redrawContextHigh).add(this.nodeForClipping);
        this.initAutoCompletionNodes(redrawContextHigh);
        this.nodeRibbon = this.getEALManager().createNode3D(this.nodeForClipping, EALManager.createNodeName("spellerBand", this), this.controller.getWidth(), this.controller.getHeight(), 2);
        this.nodeRibbon.setPosition(0.0f, 12354, 41024);
        this.highlightNode = this.getEALManager().createText3D(null, EALManager.createNodeName("highlightChar", this), "A", redrawContextHigh.getFont(1), 1);
        this.highlightNode.setColor(this.colorCache[3]);
        this.highlightNode.setVisible(false);
        this.node = this.cursorNode = this.createNode(this.nodeRibbon, 0);
        SpellerIterator spellerIterator = this.controller.getSpellerIterator(null, false);
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
            this.createItemNode(spellerController$ISpellerItem, redrawContextHigh, this.nodeRibbon);
        }
        this.nodeRibbon.add(this.highlightNode);
        this.initializeSpellerBox(redrawContextHigh);
        this.initialisePreviewCloseIcon();
        this.bandStructureChanged = false;
        this.isColorRefreshNeeded = true;
    }

    private void initializeSpellerBox(RedrawContextHigh redrawContextHigh) {
        this.boxNodeClipp = this.getEALManager().createNode3D(null, EALManager.createNodeName("box_node_clip", this), 44868, this.controller.getHeight() * 3 + 100, 100);
        this.boxNodeClipp.setClipping(true);
        SpellerRendererEuropeHigh.getPaintNode(redrawContextHigh).add(this.boxNodeClipp);
        int n = 6;
        this.boxNode = this.getEALManager().createTemplateInstanceNode(this.boxNodeClipp, EALManager.createNodeName("cursor_box_clip", this), 0.0f, 0.0f, n, "Prefabs/c1", this.getInitContext().getScreenID());
        this.propertyCache.setProperty(this.boxNode, "c1_options_icon", (float)(this.controller.shallShowOptionIcon() ? 1 : 0));
        this.propertyCache.setProperty(this.boxNode, "c1_borderTop", 1.0f);
        this.propertyCache.setProperty(this.boxNode, "c1_borderBottom", 1.0f);
        this.propertyCache.setProperty(this.boxNode, "c1_spellerMode", 1.0f);
        this.propertyCache.setColorProperty(this.boxNode, "Color", this.colorCache[0]);
        this.boxNode.setVisible(this.controller.showBox());
        this.boxNode.setPosition(8257, 8257, 0.0f);
    }

    private void initialisePreviewCloseIcon() {
        this.closePreviewNode = this.getEALManager().createNode3D(null, EALManager.createNodeName("closePreview_node", this), 18499, 18499, -100);
        TextureDescription textureDescription = this.getTextureDescription(0, true);
        if (textureDescription != null) {
            this.closePreviewBackgroundNode = this.getEALManager().createImage3D(this.closePreviewNode, EALManager.createNodeName("closePreview_background", this), textureDescription, 0, true, (Object)this);
        }
        this.closePreviewButton = this.getEALManager().createImage3D(this.closePreviewNode, EALManager.createNodeName("closePreview_icon", this), this.getBitmapForButton(SpellerController$SpellerButtonType.CLOSE, false), 0, true, (Object)this);
        this.closePreviewButton.setPosition(8257, 28737, 0.0f);
        this.closePreviewNode.setPosition(8257, 65, 0.0f);
        this.boxNodeClipp.add(this.closePreviewNode);
        this.closePreviewNode.setVisible(false);
    }

    private void initAutoCompletionNodes(RedrawContextHigh redrawContextHigh) {
        if (this.nodeForClipping == null) {
            logChannel.log(10000, "Initialisation of AutoCompletion nodes does not make sense as the top level node does not exist");
            return;
        }
        this.nodeAutoCompletion = this.getEALManager().createNode3D(this.nodeForClipping, EALManager.createNodeName("spellerAutocompletion", this), this.controller.getWidth(), 8258);
        this.nodeAutoCompletion.setClipping(true);
        if (this.suggestionBackground == null) {
            this.suggestionBackground = this.createSuggestionBackground(this.nodeAutoCompletion, "Suggestion-Background-speller");
        }
        this.nodeAutoCompletionText = this.getEALManager().createText3D(this.nodeAutoCompletion, EALManager.createNodeName("autocompletionText", this), "Autocompletion", redrawContextHigh.getFont(2));
        float f2 = this.getTerminal() != null ? (float)this.getTerminal().getLayout().getIntegerConstant(117) : 0.0f;
        this.nodeAutoCompletionText.setPosition(0.0f, 55361 - f2, 0.0f);
        this.nodeAutoCompletionText.setColor(this.colorCache[3]);
        this.nodeAutoCompletion.setVisible(false);
    }

    private void createItemNode(SpellerController$ISpellerItem spellerController$ISpellerItem, RedrawContextHigh redrawContextHigh, IWrappedNode3D iWrappedNode3D) {
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = new SpellerRendererEuropeHigh$SpellerLayoutContainer(this);
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$102(spellerRendererEuropeHigh$SpellerLayoutContainer, spellerController$ISpellerItem);
        if (spellerController$ISpellerItem instanceof SpellerController$ButtonItem) {
            SpellerController$SpellerButtonType spellerController$SpellerButtonType = ((SpellerController$ButtonItem)spellerController$ISpellerItem).getButtonType();
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$002(spellerRendererEuropeHigh$SpellerLayoutContainer, this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName("item_button", spellerController$SpellerButtonType.getName(), (AbstractRenderer)this), this.getBitmapForButton(spellerController$SpellerButtonType, false), 0, true, (Object)this));
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$202(spellerRendererEuropeHigh$SpellerLayoutContainer, this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName("item_buttonBig", spellerController$SpellerButtonType.getName(), (AbstractRenderer)this), this.getBitmapForButton(spellerController$SpellerButtonType, true), 0, true, (Object)this));
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$302(spellerRendererEuropeHigh$SpellerLayoutContainer, (int)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth());
        } else if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem) {
            Object object;
            String string;
            SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem = (SpellerController$AbstractExpandableItem)spellerController$ISpellerItem;
            if (spellerController$AbstractExpandableItem.type == 1) {
                int n = ((SpellerController$AbstractExpandableItem$CharSet)spellerController$AbstractExpandableItem).getCharsetType();
                string = EALManager.createNodeName("charSet_clippingParent", n, (AbstractRenderer)this);
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$002(spellerRendererEuropeHigh$SpellerLayoutContainer, this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName("item_charset", n, (AbstractRenderer)this), this.getTextureDescription(SpellerRendererEuropeHigh.getBitmapForCharset(n, false), true), 0, true, (Object)this));
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$202(spellerRendererEuropeHigh$SpellerLayoutContainer, this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName("item_charsetBig", n, (AbstractRenderer)this), this.getTextureDescription(SpellerRendererEuropeHigh.getBitmapForCharset(n, true), false), 0, true, (Object)this));
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$302(spellerRendererEuropeHigh$SpellerLayoutContainer, (int)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth());
            } else if (spellerController$AbstractExpandableItem.type == 0) {
                String string2 = ((SpellerController$AbstractExpandableItem$Char)spellerController$AbstractExpandableItem).getChar(this.controller.isUpperCase());
                string = EALManager.createNodeName("char_clippingParent", string2, (AbstractRenderer)this);
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$002(spellerRendererEuropeHigh$SpellerLayoutContainer, this.createCharacterNode(redrawContextHigh, string2, iWrappedNode3D, "item_char", string2));
                object = this.createCharacterNodeBig(string2, iWrappedNode3D, "item_charBig", string2);
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$202(spellerRendererEuropeHigh$SpellerLayoutContainer, (IWrappedNode3D)(object != null ? object : this.highlightNode));
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$302(spellerRendererEuropeHigh$SpellerLayoutContainer, (int)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth());
            } else {
                logChannel.log(-1601830656, "SpellerRendererEuropeHigh#createItemNode: unknown type for Expandable item (type=%1). Will not create a node", (long)spellerController$AbstractExpandableItem.type);
                return;
            }
            IWrappedNode3D iWrappedNode3D2 = this.getEALManager().createNode3D(iWrappedNode3D, string, 4201542, this.controller.getHeight() + 28);
            object = this.controller.getCurrentSpellerBand();
            List list = spellerController$AbstractExpandableItem.getSubBand();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                SpellerController$ISpellerItem spellerController$ISpellerItem2 = (SpellerController$ISpellerItem)iterator.next();
                if (object.hasMovingDeleteButton() && spellerController$ISpellerItem2.equals(object.getDeleteButtonNeighbor())) {
                    this.createItemNode(object.getDeleteButton(), redrawContextHigh, iWrappedNode3D);
                }
                this.createItemNode(spellerController$ISpellerItem2, redrawContextHigh, iWrappedNode3D2);
            }
            iWrappedNode3D2.setClipping(true);
            iWrappedNode3D2.setClippingInheritance(1);
            iWrappedNode3D2.setVisible(false);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$402(spellerRendererEuropeHigh$SpellerLayoutContainer, iWrappedNode3D2);
        } else if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem) {
            String string = ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(this.controller.isUpperCase());
            IWrappedNode3D iWrappedNode3D3 = this.createCharacterNode(redrawContextHigh, string, iWrappedNode3D, "item_singleChar", string);
            iWrappedNode3D3.setVisible(false);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$002(spellerRendererEuropeHigh$SpellerLayoutContainer, iWrappedNode3D3);
            IWrappedNode3D iWrappedNode3D4 = this.createCharacterNodeBig(string, iWrappedNode3D, "item_singleCharBig", string);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$202(spellerRendererEuropeHigh$SpellerLayoutContainer, iWrappedNode3D4 != null ? iWrappedNode3D4 : this.highlightNode);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$302(spellerRendererEuropeHigh$SpellerLayoutContainer, (int)iWrappedNode3D3.getWidth());
        }
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setVisible(false);
        this.layoutData.put(spellerController$ISpellerItem, spellerRendererEuropeHigh$SpellerLayoutContainer);
    }

    private IWrappedNode3D createCharacterNodeBig(String string, IWrappedNode3D iWrappedNode3D, String string2, String string3) {
        if (string.equals(" ")) {
            TextureDescription textureDescription = this.getBitmapForButton(SpellerController$SpellerButtonType.SPACE, false);
            if (textureDescription == null) {
                return null;
            }
            return this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName(string2, string3, (AbstractRenderer)this), textureDescription, 0, true, (Object)this);
        }
        return null;
    }

    private IWrappedNode3D createCharacterNode(RedrawContextHigh redrawContextHigh, String string, IWrappedNode3D iWrappedNode3D, String string2, String string3) {
        if (string.equals(" ")) {
            TextureDescription textureDescription = this.getBitmapForButton(SpellerController$SpellerButtonType.SPACE, false);
            if (textureDescription == null) {
                return null;
            }
            return this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName(string2, string3, (AbstractRenderer)this), textureDescription, 0, true, (Object)this);
        }
        IWrappedNode3DText iWrappedNode3DText = this.getEALManager().createText3D(iWrappedNode3D, EALManager.createNodeName(string2, string3, (AbstractRenderer)this), string, redrawContextHigh.getFont(0));
        iWrappedNode3DText.setColor(this.colorCache[1]);
        return iWrappedNode3DText;
    }

    private TextureDescription getBitmapForButton(SpellerController$SpellerButtonType spellerController$SpellerButtonType, boolean bl) {
        if (bl && spellerController$SpellerButtonType.getHighlightedBitmapIndex() != -1) {
            return this.getEALManager().createTextureDescription(spellerController$SpellerButtonType.getHighlightedBitmapIndex(), true, this.getInitContext().getScreenID());
        }
        if (!bl && spellerController$SpellerButtonType.getBitmapIndex() != -1) {
            return this.getEALManager().createTextureDescription(spellerController$SpellerButtonType.getBitmapIndex(), true, this.getInitContext().getScreenID());
        }
        if (this.controller.isMultilineAlternative() && spellerController$SpellerButtonType == SpellerController$SpellerButtonType.CLOSE) {
            return this.getEALManager().createTextureDescription(HMIImageConstantsSystem.mib2_speller_button_WordAlternatives_close, true, this.getInitContext().getScreenID());
        }
        int n = 9 + spellerController$SpellerButtonType.getEnumValue() * 2 + (bl ? 1 : 0);
        return this.getTextureDescription(n, true);
    }

    private static int getBitmapForCharset(int n, boolean bl) {
        return 1 + n * 2 + (bl ? 1 : 0);
    }

    private void destroyNode() {
        this.destroyProperties();
        this.clearSpellerBandNodes();
        this.clearSeparators();
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.nodeAutoCompletionText);
            eALManager.destroy(this.nodeAutoCompletion);
            eALManager.destroy(this.suggestionBackground);
            eALManager.destroy(this.cursorNode);
            eALManager.destroy(this.nodeRibbon);
            eALManager.destroy(this.nodeForClipping);
            eALManager.destroy(this.boxNode);
            eALManager.destroy(this.closePreviewButton);
            eALManager.destroy(this.closePreviewBackgroundNode);
            eALManager.destroy(this.closePreviewNode);
            eALManager.destroy(this.boxNodeClipp);
            eALManager.destroy(this.backgroundWordAlternatives);
        }
        this.nodeForClipping = null;
        this.boxNodeClipp = null;
        this.nodeRibbon = null;
        this.cursorNode = null;
        this.nodeAutoCompletionText = null;
        this.nodeAutoCompletion = null;
        this.boxNode = null;
        this.suggestionBackground = null;
        this.backgroundWordAlternatives = null;
        this.closePreviewNode = null;
        this.closePreviewBackgroundNode = null;
        this.closePreviewButton = null;
        this.node = null;
    }

    private void clearSpellerBandNodes() {
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer;
        if (this.layoutData == null || this.layoutData.values() == null) {
            return;
        }
        Iterator iterator = this.layoutData.values().iterator();
        while (iterator.hasNext()) {
            spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)iterator.next();
            if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer) != null && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer) != this.highlightNode) {
                this.getEALManager().destroy(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer));
            }
            if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer) == null) continue;
            this.getEALManager().destroy(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer));
        }
        iterator = this.layoutData.values().iterator();
        while (iterator.hasNext()) {
            spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)iterator.next();
            if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer) == null) continue;
            this.getEALManager().destroy(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer));
        }
        this.getEALManager().destroy(this.highlightNode);
        this.highlightNode = null;
        this.layoutData.clear();
    }

    private void clearSeparators() {
        this.lastFocusedItem = null;
        if (this.separatorNodes == null) {
            return;
        }
        Iterator iterator = this.separatorNodes.values().iterator();
        while (iterator.hasNext()) {
            this.getEALManager().destroy((IWrappedNode3DImage)iterator.next());
        }
        this.separatorNodes.clear();
        this.separatorNodes = null;
    }

    public void layoutMainBand() {
        int n = this.layout(this.controller.getSpellerIterator(null, false), this.nodeRibbon);
        this.endPosLastItem = n + 12;
        this.needsRelayout = false;
    }

    public int layout(Iterator iterator, IWrappedNode3D iWrappedNode3D) {
        if (iterator == null || iWrappedNode3D == null) {
            spellerLogChannel.log(1000, "SpellerRendererEuropeHigh#layout: params may not be null (iterator=%1, parentNode=%2)", (Object)iterator, (Object)iWrappedNode3D);
            return 0;
        }
        int n = 0;
        while (iterator.hasNext()) {
            boolean bl;
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer;
            Object object = iterator.next();
            if (object == null) {
                spellerLogChannel.log(1000, "SpellerRendererEuropeHigh#layout: null item in speller!");
            }
            if ((spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(object)) == null) {
                spellerLogChannel.log(10000, "SpellerRendererEuropeHigh#layout: cannot find layoutItem for entry in the speller (spellerItem = %1)", object);
                continue;
            }
            int n2 = SpellerController.isButtonItem(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer)) ? 12 : 15;
            n += n2;
            if (this.controller.hasMovingDeleteButton() && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getParent() != iWrappedNode3D) {
                this.setPosition(spellerRendererEuropeHigh$SpellerLayoutContainer, (int)((float)n + iWrappedNode3D.getX()));
            } else {
                this.setPosition(spellerRendererEuropeHigh$SpellerLayoutContainer, n);
            }
            n += SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer);
            boolean bl2 = bl = SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer) == this.controller.getItemToClose();
            if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer) == null || ((SpellerController$AbstractExpandableItem)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer)).isClosed() && !bl) continue;
            IWrappedNode3D iWrappedNode3D2 = SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer);
            iWrappedNode3D2.setPosition(n, 0.0f, 0.0f);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$502(spellerRendererEuropeHigh$SpellerLayoutContainer, this.layout(this.controller.getSubBandIterator((SpellerController$AbstractExpandableItem)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer)), SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer)));
            iWrappedNode3D2.setVisible(true);
            float f2 = this.controller.getOpenProgress();
            if (f2 != 32959) {
                if (bl) {
                    f2 = 1.0f - f2;
                }
                float f3 = f2 / -842249153;
                f3 = Math.min(1.0f, f3);
                int n3 = (int)((this.currentCursorWidth - (float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer)) / 2.0f + 63);
                float f4 = (1.0f - f3) * (float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$500(spellerRendererEuropeHigh$SpellerLayoutContainer);
                float f5 = f3 * (float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$500(spellerRendererEuropeHigh$SpellerLayoutContainer);
                iWrappedNode3D2.setClippingRectangle(f4 + (float)n3, 8385, f5, iWrappedNode3D2.getHeight());
                iWrappedNode3D2.useClippingRectangle(true);
                iWrappedNode3D2.setPosition((float)n - f4, 0.0f, 0.0f);
                float f6 = (f2 - -842249153) * 41024;
                f6 = Math.max((float)-842249154, f6);
                iWrappedNode3D2.setOpacity(f6);
                if (!bl) {
                    this.startXOpeningItem = n;
                    this.endXOpeningItem = (int)((float)n + f5);
                }
                n = (int)((float)n + f5);
                continue;
            }
            iWrappedNode3D2.setClippingRectangle(0.0f, 8385, SpellerRendererEuropeHigh$SpellerLayoutContainer.access$500(spellerRendererEuropeHigh$SpellerLayoutContainer), iWrappedNode3D2.getHeight());
            n += SpellerRendererEuropeHigh$SpellerLayoutContainer.access$500(spellerRendererEuropeHigh$SpellerLayoutContainer);
            this.startXOpeningItem = -1;
            this.endXOpeningItem = -1;
        }
        return n;
    }

    private void setPosition(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, int n) {
        int n2;
        n = (int)((float)n + ((float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer) - SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth()) / 2.0f);
        int n22 = this.baseline;
        if (!(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer) instanceof IWrappedNode3DText)) {
            n2 = 8257 - SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getHeight() / 2.0f + 63;
        }
        if (SpellerRendererEuropeHigh.isDeleteButton(spellerRendererEuropeHigh$SpellerLayoutContainer) && this.isTouchControllerArabia()) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).setHorizontalFlip(this.isDeleteIconFlipped);
        }
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).setPosition(n, n2, 0.0f);
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).setVisible(true);
        if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer) != null) {
            n = (int)((float)n + (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth() - SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth()) / 2.0f);
            if (SpellerRendererEuropeHigh.isDeleteButton(spellerRendererEuropeHigh$SpellerLayoutContainer) && this.isTouchControllerArabia()) {
                SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setHorizontalFlip(this.isDeleteIconFlipped);
            }
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setPosition(n, n2 - 1, 0.0f);
        }
    }

    protected boolean isTouchControllerArabia() {
        return this.controller.getParent() != null && this.controller.getParent() instanceof TouchControllerArabia;
    }

    protected static boolean isDeleteButton(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        return spellerRendererEuropeHigh$SpellerLayoutContainer != null && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer) instanceof SpellerController$ButtonItem && ((SpellerController$ButtonItem)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer)).getButtonType() == SpellerController$SpellerButtonType.DELETE;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2 = this.controller.getWidth() + 0 + this.xOffsetRight;
        float f3 = this.controller.getHeight() + 12 + 28;
        this.setNodeForClippingProperties(f2 += this.controller.isMultilineAlternative() ? 41025 : (int)0.0f, f3 += this.controller.isMultilineAlternative() ? 8257 : (int)0.0f);
        this.setDeleteDirection();
        this.setBoxNodeClippProperties();
        this.updateLayoutAndColors();
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.controller.getCurrentFocus();
        float f4 = this.handleCursorPositioning(spellerController$ISpellerItem);
        this.setNodeRibbonPosition();
        this.handleRibbonScrolling(f4);
        this.relPosCursor = this.cursorNode.getX() + this.nodeRibbon.getX();
        this.setIfCursorAnimating(spellerController$ISpellerItem, redrawContextHigh);
        this.setIfMultilineAlternative(f2, f3);
        this.nodeForClipping.setOpacity(this.controller.getRenderOpacity());
        if (this.boxNode != null) {
            this.boxNode.setOpacity(this.controller.getRenderOpacity());
        }
        this.setClosePreviewNodeProperties();
    }

    private void setClosePreviewNodeProperties() {
        if (this.closePreviewNode != null) {
            if (this.closePreviewButton != null) {
                this.closePreviewButton.setModulateColor(this.controller.isCloseButtonEnabled() ? this.colorCache[1] : this.colorCache[2]);
            }
            if (this.controller.isCloseButtonAvailable()) {
                this.closePreviewNode.setOpacity(this.controller.getRenderOpacity());
            }
        }
    }

    private void setIfCursorAnimating(SpellerController$ISpellerItem spellerController$ISpellerItem, RedrawContextHigh redrawContextHigh) {
        if (!this.controller.isCursorAnimating()) {
            this.setPropertiesOfLayoutItem(spellerController$ISpellerItem, redrawContextHigh);
            if (this.controller.isMultilineAlternative() && !this.controller.isFocused()) {
                this.cursorNode.setVisible(false);
            } else {
                this.cursorNode.setVisible(true);
            }
            this.setAutoCompletionProperties(redrawContextHigh);
        } else {
            this.nodeAutoCompletion.setVisible(false);
            this.setProperty("spl_completionArrowVisible", 0.0f);
        }
    }

    private void setIfMultilineAlternative(float f2, float f3) {
        if (this.controller.isMultilineAlternative()) {
            this.createBackgroundAlternatives(this.nodeForClipping);
            this.createSeparator(this.nodeForClipping);
            this.nodeForClipping.setSize(f2, f3);
            this.cursorNode.setVisible(false);
        }
    }

    private void setAutoCompletionProperties(RedrawContextHigh redrawContextHigh) {
        String string = this.controller.getAutoCompletion();
        if (this.controller.shallShowAutoCompletion()) {
            this.setProperty("spl_completionArrowVisible", 1.0f);
            this.nodeAutoCompletion.setVisible(true);
            int n = (int)this.nodeForClipping.getWidth();
            if (SpellerController.isArabia() && this.controller.getParent() != null) {
                TouchControllerArabia touchControllerArabia = (TouchControllerArabia)this.controller.getParent();
                string = touchControllerArabia.getCurrentOrientationMark().concat(string);
            }
            this.nodeAutoCompletionText.setText(string, redrawContextHigh.getFont(2), n, this.getEALManager());
            float f2 = this.nodeAutoCompletionText.getWidth();
            float f3 = this.relPosCursor - f2 / 2.0f;
            f3 = Math.max(0.0f, f3);
            f3 = Math.min(this.nodeForClipping.getWidth() - f2, f3);
            this.nodeAutoCompletion.setPosition(f3, -21 + SpellerRendererEuropeHigh.getResolutionBasedOffset(), 0.0f);
            this.showSuggestionBackground(true);
        } else {
            this.nodeAutoCompletion.setVisible(false);
            this.setProperty("spl_completionArrowVisible", 0.0f);
            this.showSuggestionBackground(false);
        }
    }

    private void setPropertiesOfLayoutItem(SpellerController$ISpellerItem spellerController$ISpellerItem, RedrawContextHigh redrawContextHigh) {
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$ISpellerItem);
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setVisible(true);
        SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).setVisible(false);
        if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).getParent() == this.nodeRibbon) {
            this.cursorNode.setNodeIndex(10);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setNodeIndex(11);
        }
        this.setNodeColoring(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer), SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer).isEnabled());
        if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer) == this.highlightNode && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer) instanceof IWrappedNode3DText) {
            String string = ((IWrappedNode3DText)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer)).getText();
            if (this.controller.isMultilineAlternative()) {
                this.highlightNode.setText(string, redrawContextHigh.getFont(0));
            } else {
                this.highlightNode.setText(string, redrawContextHigh.getFont(1));
            }
            int n = (int)(spellerRendererEuropeHigh$SpellerLayoutContainer.getAbsoluteX() + ((float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer) - SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth()) / 2.0f);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).setPosition(n, this.baseline, 0.0f);
        }
    }

    private void updateLayoutAndColors() {
        if (this.needsRelayout()) {
            this.layoutMainBand();
        }
        if (this.isColorRefreshNeeded) {
            this.refreshColors();
        }
    }

    private void setNodeRibbonPosition() {
        if (this.bandStructureChanged) {
            float f2 = this.relPosCursor - this.cursorNode.getX();
            this.nodeRibbon.setPosition(f2, 12354, 0.0f);
            this.bandStructureChanged = false;
        }
    }

    private void setBoxNodeClippProperties() {
        if (this.boxNodeClipp != null) {
            this.boxNodeClipp.setVisible(true);
            this.boxNodeClipp.setPosition(this.controller.getX() - 9, this.controller.getY() - 19, 0.0f);
            int n = this.controller.getWidth() - 2;
            int n2 = this.controller.getHeight() + SpellerRendererEuropeHigh.getVariantYOffset();
            this.propertyCache.setProperty(this.boxNode, "c1_options_icon_offset", this.controller.getSpellerMode() != 4 ? (float)((int)Math.floor((float)n2 / 32832)) : 0.0f);
            this.propertyCache.setProperty(this.boxNode, "c1_width", (float)n);
            this.propertyCache.setProperty(this.boxNode, "c1_height", (float)n2);
            this.propertyCache.setColorProperty(this.boxNode, "c1_options_icon_color", this.colorCache[this.controller.isLockingActive() ? 2 : 0]);
        }
    }

    private void setDeleteDirection() {
        if (this.isTouchControllerArabia()) {
            ITouchInputDataArabia iTouchInputDataArabia = (ITouchInputDataArabia)((TouchControllerArabia)this.controller.getParent()).getInputData();
            if (!iTouchInputDataArabia.getCurrentDisplayString().equalsIgnoreCase("")) {
                boolean bl = iTouchInputDataArabia.isDeleteDirectionFromRightToLeft();
                if (bl != this.isDeleteIconFlipped) {
                    this.needsRelayout = true;
                    this.isDeleteIconFlipped = bl;
                }
            } else {
                this.isDeleteIconFlipped = !this.controller.isDeleteDirectionRTL();
            }
        }
    }

    private void setNodeForClippingProperties(float f2, float f3) {
        if (!this.nodeForClipping.isValid()) {
            logChannel3DEngine.log(10000, "SpellerRendererHigh#applyProperties: clipping node is invalid!");
            return;
        }
        this.nodeForClipping.setVisible(true);
        this.nodeForClipping.setClipping(true);
        this.nodeForClipping.setSize(f2, f3);
    }

    private void createSeparator(IWrappedNode3D iWrappedNode3D) {
        if (this.separatorNodes == null) {
            this.createInitialSeparator(iWrappedNode3D);
        } else {
            this.changeFocusedSeparator(iWrappedNode3D);
        }
    }

    void changeFocusedSeparator(IWrappedNode3D iWrappedNode3D) {
        Object object;
        if (this.lastFocusedItem != null) {
            object = (IWrappedNode3DImage)this.separatorNodes.get(this.lastFocusedItem);
            object.setModulateColor(this.colorCache[5]);
        }
        if ((object = this.controller.getCurrentFocus()) == null || !this.controller.isFocused()) {
            return;
        }
        IWrappedNode3DImage iWrappedNode3DImage = (IWrappedNode3DImage)this.separatorNodes.get(object);
        float f2 = iWrappedNode3DImage.getHeight();
        float f3 = iWrappedNode3DImage.getWidth();
        float f4 = iWrappedNode3DImage.getX();
        float f5 = iWrappedNode3DImage.getY();
        this.getEALManager().destroy(iWrappedNode3DImage);
        this.separatorNodes.remove(object);
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.white_pixel, false, this.getInitContext().getScreenID());
        IWrappedNode3DImage iWrappedNode3DImage2 = this.getEALManager().createImage3D(iWrappedNode3D, "MULTILINE_SEPARATOR", textureDescription, 0, true, (Object)this);
        iWrappedNode3DImage2.setModulateColor(this.colorCache[4]);
        iWrappedNode3DImage2.setScale(f3, f2, 1.0f);
        iWrappedNode3DImage2.setPosition(f4, f5, 0.0f);
        iWrappedNode3DImage2.setVisible(true);
        this.lastFocusedItem = object;
        this.separatorNodes.put(object, iWrappedNode3DImage2);
    }

    void createInitialSeparator(IWrappedNode3D iWrappedNode3D) {
        float f2;
        this.separatorNodes = new HashMap();
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.white_pixel, false, this.getInitContext().getScreenID());
        float f3 = f2 = this.nodeRibbon.getX() + 41024;
        SpellerIterator spellerIterator = this.controller.getSpellerIterator(false);
        while (spellerIterator.hasNext()) {
            Object object = spellerIterator.next();
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(object);
            IWrappedNode3DImage iWrappedNode3DImage = this.getEALManager().createImage3D(iWrappedNode3D, "MULTILINE_SEPARATOR", textureDescription, 0, true, (Object)this);
            iWrappedNode3DImage.setModulateColor(this.colorCache[5]);
            float f4 = this.baseline + 18;
            iWrappedNode3DImage.setScale(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth() + 20545, f4, 1.0f);
            float f5 = f4 - 1.0f;
            iWrappedNode3DImage.setPosition(f2, f5, 0.0f);
            f2 += SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth() + 28737;
            iWrappedNode3DImage.setVisible(true);
            this.separatorNodes.put(object, iWrappedNode3DImage);
        }
        this.backgroundWordAlternativesWidth = f2 - f3;
        if (this.backgroundWordAlternatives != null) {
            this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_spellerWidth", this.backgroundWordAlternativesWidth);
        }
    }

    private void createBackgroundAlternatives(IWrappedNode3D iWrappedNode3D) {
        if (this.backgroundWordAlternatives == null) {
            this.backgroundWordAlternatives = this.createAlternativesNode(this.nodeForClipping.getParent());
            this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_cursorWidth", 0.0f);
            this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_height", (float)8258);
            this.propertyCache.setColorProperty(this.backgroundWordAlternatives, "if_fieldColor", this.colorCache[6]);
        }
        if (this.controller.isAlternativeArrowDown()) {
            this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_ddsArrowState", 2.0f);
        } else {
            this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_ddsArrowState", 1.0f);
        }
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(this.controller.getFirstItem());
        this.propertyCache.setProperty(this.backgroundWordAlternatives, "if_spellerWidth", this.backgroundWordAlternativesWidth);
        this.backgroundWordAlternatives.setPosition(this.nodeRibbon.getX() + 32833, (float)this.controller.getY() + spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeNormal().getHeight() + (float)this.baseline - 49216, 0.0f);
        this.backgroundWordAlternatives.setVisible(true);
    }

    private IWrappedNode3D createAlternativesNode(IWrappedNode3D iWrappedNode3D) {
        return this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName("sms_alternatives_background_texture", this), 0.0f, 0.0f, this.getKzbConstant(), "Prefabs/if_wordCompletion", this.getInitContext().getScreenID());
    }

    private static int getResolutionBasedOffset() {
        int n = -13;
        if (SpellerRendererEuropeHigh.isG24MMIKombi()) {
            n = 0;
        }
        return n;
    }

    protected static boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    private void showSuggestionBackground(boolean bl) {
        if (bl) {
            float f2 = 0.0f;
            this.suggestionX = 32960 + this.nodeAutoCompletionText.getX();
            this.suggestionY = this.nodeAutoCompletion.getY() + 28737 - (float)SpellerRendererEuropeHigh.getResolutionBasedOffset();
            this.suggestionW = this.nodeAutoCompletionText.getWidth() + 65;
            String string = this.nodeAutoCompletionText.getText();
            if (string.charAt(string.length() - 1) == ' ') {
                this.suggestionW -= 49216;
            }
            this.suggestionH = this.nodeAutoCompletionText.getHeight() + 8257;
            this.suggestionBackground.setPosition(this.suggestionX, this.suggestionY, f2);
            this.suggestionBackground.setScale(this.suggestionW, this.suggestionH, f2);
            this.nodeAutoCompletion.useClippingRectangle(true);
            this.nodeAutoCompletion.setClippingRectangle(this.suggestionX, this.suggestionY + 32832, this.suggestionW, this.suggestionH);
        }
        this.suggestionBackground.setVisible(bl);
    }

    private static int getVariantYOffset() {
        return SpellerRendererEuropeHigh.isG24MMIKombi() ? 12 : 4;
    }

    private void refreshColors() {
        SpellerIterator spellerIterator = this.controller.getSpellerIterator(null, true);
        while (spellerIterator.hasNext()) {
            Object object = spellerIterator.next();
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(object);
            boolean bl = SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer).isEnabled();
            this.setNodeColoring(SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000(spellerRendererEuropeHigh$SpellerLayoutContainer), bl);
        }
        this.setColorProperty("Color", this.colorCache[this.controller.isEnabled() ? 0 : 2]);
        this.isColorRefreshNeeded = false;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void setNodeColoring(IWrappedNode3D iWrappedNode3D, boolean bl) {
        if (iWrappedNode3D instanceof IWrappedNode3DText) {
            int n = this.colorCache[1];
            if (!this.controller.isMultilineAlternative()) {
                n = bl ? this.colorCache[1] : this.colorCache[2];
            }
            ((IWrappedNode3DText)iWrappedNode3D).setColor(n);
        } else {
            iWrappedNode3D.setOpacity(bl ? 1.0f : (float)-1701209794);
        }
    }

    private boolean needsRelayout() {
        return this.needsRelayout;
    }

    private float handleCursorPositioning(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (this.cursorNode != null) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            if (this.controller.isCursorAnimating()) {
                float f4 = this.calculateCursorWidth(this.targetItem);
                float f5 = this.calculateCursorPos(this.targetItem);
                float f6 = this.controller.getCursorAnimationProgress();
                f3 = this.startCursorPos + (f5 - this.startCursorPos) * f6;
                f2 = this.startCursorWidth + (f4 - this.startCursorWidth) * f6;
            } else {
                f2 = this.calculateCursorWidth(spellerController$ISpellerItem);
                f3 = this.calculateCursorPos(spellerController$ISpellerItem);
            }
            this.cursorNode.setVisible(true);
            this.cursorNode.setPosition(f3, 28865, 0.0f);
            this.setProperty("spl_width", f2);
            this.currentCursorWidth = f2;
            return f2;
        }
        return 0.0f;
    }

    private float calculateCursorPos(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$ISpellerItem);
        float f2 = 0.0f;
        if (spellerRendererEuropeHigh$SpellerLayoutContainer != null) {
            f2 = spellerRendererEuropeHigh$SpellerLayoutContainer.getAbsoluteX();
            f2 += (float)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer) / 2.0f - 1.0f;
        } else {
            spellerLogChannel.log(10000, "SpellerRenderer#calculateCursorPos: cannot find layoutInformation for spellerItem: %1!", (Object)spellerController$ISpellerItem);
        }
        return f2;
    }

    private void handleRibbonScrolling(float f2) {
        if (this.nodeRibbon != null) {
            float f3 = this.nodeRibbon.getX();
            int n = this.endPosLastItem;
            if (this.startXOpeningItem != -1 && this.endXOpeningItem != -1) {
                boolean bl = false;
                if (this.nodeForClipping.getWidth() - (float)this.endXOpeningItem - this.nodeRibbon.getX() < 0.0f) {
                    f3 = this.nodeForClipping.getWidth() - (float)this.endXOpeningItem;
                    bl = true;
                }
                if (bl && (float)this.startXOpeningItem < (float)(-((int)f3)) + this.nodeForClipping.getWidth() / 2.0f) {
                    f3 = (float)(-this.startXOpeningItem) + this.nodeForClipping.getWidth() / 2.0f;
                }
            } else {
                int n2;
                int n3 = (int)(this.cursorNode.getX() - f2 / 2.0f);
                int n4 = (int)((float)n3 + f2);
                if (!this.controller.isMultilineAlternative()) {
                    n = Math.max(this.endPosLastItem, n4 + 3);
                }
                if (this.nodeForClipping.getWidth() - (float)n4 - this.nodeRibbon.getX() < 8258) {
                    f3 = this.nodeForClipping.getWidth() - (float)n4 - 8258;
                }
                int n5 = n2 = this.closePreviewNode.isVisible() ? 20 : 0;
                if (n3 < -((int)f3) + 40 + n2) {
                    f3 = -n3 + 40 + n2;
                }
            }
            f3 = this.nodeForClipping.getWidth() > (float)n ? (this.controller.isSmallBandCentered() ? (this.nodeForClipping.getWidth() - (float)n) / 2.0f : 0.0f) : (f3 > 0.0f ? 0.0f : Math.max(f3, this.nodeForClipping.getWidth() - (float)n));
            if (f3 < 8385) {
                this.closePreviewNode.setVisible(this.controller.isCloseButtonAvailable());
            } else {
                this.closePreviewNode.setVisible(false);
            }
            this.nodeRibbon.setPosition((int)f3, 12354, 0.0f);
        }
    }

    private float calculateCursorWidth(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        int n = 10;
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$ISpellerItem);
        if (spellerRendererEuropeHigh$SpellerLayoutContainer != null) {
            n = this.calculateHighlightedItemSize(spellerRendererEuropeHigh$SpellerLayoutContainer);
        } else {
            spellerLogChannel.log(10000, "SpellerRenderer#calculateCursorWidth: cannot find layoutInformation for spellerItem: %1!", (Object)spellerController$ISpellerItem);
        }
        n += SpellerController.isButtonItem(spellerController$ISpellerItem) ? 10 : 18;
        n = Math.max(n, 32);
        return n;
    }

    private int calculateHighlightedItemSize(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer) {
        int n = 0;
        if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer) != this.highlightNode) {
            n = (int)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200(spellerRendererEuropeHigh$SpellerLayoutContainer).getWidth();
        } else if (SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer) instanceof SpellerController$ICharacterSpellerItem) {
            String string = ((SpellerController$ICharacterSpellerItem)SpellerRendererEuropeHigh$SpellerLayoutContainer.access$100(spellerRendererEuropeHigh$SpellerLayoutContainer)).getChar(this.controller.isUpperCase());
            n = this.getEALManager().getTextWidth(string, this.highlightNode.getFont());
        } else {
            n = SpellerRendererEuropeHigh$SpellerLayoutContainer.access$300(spellerRendererEuropeHigh$SpellerLayoutContainer);
        }
        return n;
    }

    @Override
    public void disconnect() {
        this.destroyNode();
        this.destroyColors();
        super.disconnect();
    }

    protected void destroyColors() {
        this.colorCache = null;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredWidth() {
        return 800;
    }

    public int getPreferredHeight() {
        return 100;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/speller_bracket";
    }

    @Override
    protected String getEALNodeName() {
        return "speller_cursor_";
    }

    @Override
    public void startCursorAnimation(SpellerController$ISpellerItem spellerController$ISpellerItem, SpellerController$ISpellerItem spellerController$ISpellerItem2) {
        if (this.nodeForClipping == null) {
            return;
        }
        this.targetItem = spellerController$ISpellerItem2;
        if (spellerController$ISpellerItem != null) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$200((SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$ISpellerItem)).setVisible(false);
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$000((SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$ISpellerItem)).setVisible(true);
            this.cursorNode.setNodeIndex(-10);
            this.startCursorWidth = this.calculateCursorWidth(spellerController$ISpellerItem);
            this.startCursorPos = this.calculateCursorPos(spellerController$ISpellerItem);
        } else {
            this.startCursorWidth = this.currentCursorWidth;
            this.startCursorPos = this.cursorNode.getX();
        }
    }

    @Override
    public void closeItem(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        if (this.layoutData == null) {
            return;
        }
        this.bandStructureChanged = true;
        this.needsRelayout = true;
        this.startXOpeningItem = -1;
        this.endXOpeningItem = -1;
        SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)this.layoutData.get(spellerController$AbstractExpandableItem);
        if (spellerRendererEuropeHigh$SpellerLayoutContainer != null && SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer) != null) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer.access$400(spellerRendererEuropeHigh$SpellerLayoutContainer).setVisible(false);
        }
    }

    @Override
    public void openItem() {
        this.bandStructureChanged = true;
        this.needsRelayout = true;
        this.isColorRefreshNeeded = true;
    }

    @Override
    public void switchCase() {
        this.caseSwitchHappened = true;
    }

    @Override
    public void deleteMoved() {
        this.bandStructureChanged = true;
        this.needsRelayout = true;
    }

    @Override
    public void refreshItemColors() {
        this.isColorRefreshNeeded = true;
    }

    @Override
    public void switchCharSet() {
        this.destroyNode();
    }

    protected final IWrappedNode3D getCursorNode() {
        return this.cursorNode;
    }

    protected final IWrappedNode3D getClosePreviewButton() {
        return this.closePreviewButton;
    }

    protected IWrappedNode3DImage getClosePreviewBackgroundNode() {
        return this.closePreviewBackgroundNode;
    }

    private IWrappedNode3DImage createSuggestionBackground(IWrappedNode3D iWrappedNode3D, String string) {
        IWrappedNode3DImage iWrappedNode3DImage = null;
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.white_pixel, false, this.getInitContext().getScreenID());
        iWrappedNode3DImage = this.getEALManager().createImage3D(iWrappedNode3D, string, textureDescription, 0, true, (Object)this);
        iWrappedNode3DImage.setModulateColor(this.colorCache[0]);
        return iWrappedNode3DImage;
    }

    @Override
    protected int getKzbConstant() {
        return 7;
    }
}

