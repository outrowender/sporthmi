/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.preset.Preset;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.TabLayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.CloseDrawerKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.ExpandableLayoutManager;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyConfig;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.MenuItemBuilder;
import de.esolutions.hmi.widgets.audi.evo.WidgetKeyHandlerFactory;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.listener.ContentEnabledListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultiLayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.TransitionLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.VisibilityProxyWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SubElementMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MenuItemController
extends MultiLayoutContainerController
implements IMenuItemSingle,
IMenuItemMultiLine {
    public static final int TYPE_LABEL;
    public static final int TYPE_ACTION;
    public static final int TYPE_ACTION_MULTILINE;
    public static final int TYPE_SUBMENU;
    public static final int TYPE_SUBMENU_MULTILINE;
    public static final int TYPE_CHECKBOX;
    public static final int TYPE_CHECKBOX_MULTILINE;
    public static final int TYPE_CONFIGURABLE;
    public static final int TYPE_LABEL_MULTILINE;
    public static final int TYPE_COMBO_BOX;
    public static final int TYPE_SUB_ELEMENT;
    public static final int TYPE_ROTARY;
    public static final int TYPE_ROTARY_MULTILINE;
    public static final int TYPE_RADIO_BUTTON;
    public static final int TYPE_RADIO_BUTTON_MULTILINE;
    public static final int TYPE_SUBMENU_PREVIEW;
    public static final int TYPE_SUBMENU_PREVIEW_NO_ARROW;
    public static final int TYPE_FORMFIELD_INPUT;
    public static final int TYPE_TIME_SETTINGS;
    public static final int TYPE_DATE_SETTINGS;
    public static final int TYPE_AUXHEATER_PROGRAMMING;
    public static final int TYPE_SDS_COMMAND;
    public static final int TYPE_ROUTE_BRIEFING_MENU_ITEM;
    public static final int TYPE_ROUTE_BRIEFING_DETAILS_BUTTON;
    public static final int TYPE_SDS_BULLET_LABEL;
    public static final int TYPE_TIME_SETTINGS_DUAL;
    public static final int TYPE_DATE_SETTINGS_MAXDAYS30;
    public static final int TYPE_DATE_SETTINGS_MAXDAYS365;
    public static final int TYPE_GEOCOORDINATE_SETTINGS_LATITUDE;
    public static final int TYPE_GEOCOORDINATE_SETTINGS_LONGITUDE;
    public static final int SCROLL_GRID;
    public static final int SCROLL_LINE_BY_LINE;
    public static final int SCROLL_GRID_IF_FIT;
    protected int type = 1;
    protected int realType = 16;
    private int labelId = -1;
    private int[] textIds;
    private int[][] mapping;
    private int autoWrap = -1;
    private int[] replacementModelIds;
    private int[] replacementTextIds;
    private int widgetID = -1;
    private int internalID = -1;
    private IWidgetKeyHandler keyHandler;
    private int sdsItemSelectedAction = 0;
    private int sdsCommand = -1;
    private boolean selected;
    private FocusedPropertyConfig property;
    private int marginTop = 0;
    private int marginBottom = 0;
    private int glassplateInsetsTop = 0;
    private int glassplateInsetsBottom = 0;
    private int noCursorAreaTop = 0;
    private int noCursorAreaBottom = 0;
    public int topGap = -1;
    public int bottomGap = -1;
    private boolean hasInfolineDisclaimer = true;
    protected boolean autoConfigureChaining = true;
    private String infolineTextEnabled;
    private String infolineTextDisabled;
    private int infolineTextIdEnabled = -1;
    private int[] infolineTextIdsDisabled = null;
    private int infoLineDisabledTextIndex = 0;
    private AbstractWidgetController infoLineModel = null;
    private String infolineText;
    private boolean infoLineEnabled = true;
    private boolean focusable = true;
    private boolean isMoving = false;
    private List contentEnabledListeners;
    private int scrollType = 0;
    private boolean scrollLineByLine = false;
    private int scrollLineHeight = -1;
    private int clippingHeight = -129;
    private int menuContentHeight;
    private int menuContentWidth;
    public Map itemPreCreatedEnableState;
    public Map itemPreCreatedVisibility;
    protected boolean useSmallStageTextForMainLabel;
    private int cashedOptionsIconSpace = -1;
    private int[] textOrientationHints;
    private boolean closeOptionDrawerAfterScreenConnected;
    private boolean lockable = false;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateFromModel();
        this.autoSetup();
        if (this.keyHandler instanceof CloseDrawerKeyHandler) {
            ((CloseDrawerKeyHandler)this.keyHandler).setCloseOptionDrawerAfterScreenConnected(this.closeOptionDrawerAfterScreenConnected);
        }
        if ((this.topGap != -1 || this.bottomGap != -1) && this.layoutManager != null) {
            GridLayout gridLayout = (GridLayout)this.layoutManager;
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getRowConstraints();
            axisConstraints.gaps[0] = this.topGap;
            axisConstraints.gaps[axisConstraints.gaps.length - 1] = this.bottomGap;
        }
    }

    public void addContentEnabledListener(ContentEnabledListener contentEnabledListener) {
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        this.contentEnabledListeners.add(contentEnabledListener);
    }

    public void removeContentEnabledListener(ContentEnabledListener contentEnabledListener) {
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        this.contentEnabledListeners.remove(contentEnabledListener);
    }

    private void saveItemPreCreatedStatus(int n, boolean bl) {
        if (!this.isConnected()) {
            if (this.itemPreCreatedEnableState == null) {
                this.itemPreCreatedEnableState = new HashMap();
            }
            this.itemPreCreatedEnableState.put(Util.createInteger(n), bl);
        }
    }

    private void saveItemPreCreatedVisibility(int n, boolean bl) {
        if (!this.isConnected()) {
            if (this.itemPreCreatedVisibility == null) {
                this.itemPreCreatedVisibility = new HashMap();
            }
            this.itemPreCreatedVisibility.put(Util.createInteger(n), bl);
        }
    }

    public void setContentEnabled(int n) {
        this.saveItemPreCreatedStatus(n, true);
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        if (n > -1) {
            for (int i2 = 0; i2 < this.contentEnabledListeners.size(); ++i2) {
                ((ContentEnabledListener)this.contentEnabledListeners.get(i2)).setContentEnabled(n, true);
            }
        } else {
            menuItemLogCh.log(-2137614336, "MenuItemWidget#setContentEnabled. index: %1 is lt 0", (long)n);
        }
    }

    public void setContentDisabled(int n) {
        this.saveItemPreCreatedStatus(n, false);
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        if (n > -1) {
            for (int i2 = 0; i2 < this.contentEnabledListeners.size(); ++i2) {
                ((ContentEnabledListener)this.contentEnabledListeners.get(i2)).setContentEnabled(n, false);
            }
        } else {
            menuItemLogCh.log(-2137614336, "MenuItemWidget#setContentDisabled. index: %1 is lt 0", (long)n);
        }
    }

    public void setContentVisible(int n) {
        this.saveItemPreCreatedVisibility(n, true);
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        if (n > -1) {
            for (int i2 = 0; i2 < this.contentEnabledListeners.size(); ++i2) {
                ((ContentEnabledListener)this.contentEnabledListeners.get(i2)).setContentVisible(n, true);
            }
        } else {
            menuItemLogCh.log(-2137614336, "MenuItemWidget#setContentEnabled. index: %1 is lt 0", (long)n);
        }
    }

    public void setContentInvisible(int n) {
        this.saveItemPreCreatedVisibility(n, false);
        if (this.contentEnabledListeners == null) {
            this.contentEnabledListeners = new ArrayList();
        }
        if (n > -1) {
            for (int i2 = 0; i2 < this.contentEnabledListeners.size(); ++i2) {
                ((ContentEnabledListener)this.contentEnabledListeners.get(i2)).setContentVisible(n, false);
            }
        } else {
            menuItemLogCh.log(-2137614336, "MenuItemWidget#setContentDisabled. index: %1 is lt 0", (long)n);
        }
    }

    @Override
    protected void afterConnected() {
        this.updateScrollLineByLine();
        super.afterConnected();
    }

    private void updateScrollLineByLine() {
        this.scrollLineByLine = this.calculateScrollLineByLine();
    }

    private boolean calculateScrollLineByLine() {
        switch (this.scrollType) {
            case 0: {
                return false;
            }
            case 1: {
                return this.calculateSubItemCount() > 1;
            }
            case 2: {
                return this.calculateSubItemCount() > 1 && this.getPreferredMultiLineHeight() > this.menuContentHeight;
            }
        }
        menuItemLogCh.log(10000, "MenuItemController#calculateScrollType: unknown scroll type: %1", (long)this.scrollType);
        return false;
    }

    private int getGridRowCount() {
        if (this.layoutManager instanceof GridLayout) {
            return ((GridLayout)this.layoutManager).getRowConstraints().getLength();
        }
        menuItemLogCh.log(-1601830656, "MenuItemController#getGridRowCount: unknown layout: %1", (Object)this.layoutManager);
        return 1;
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof FocusedPropertyConfig) {
            this.property = (FocusedPropertyConfig)abstractWidget;
        }
        if (abstractWidget instanceof VisibilityProxyWidget) {
            this.infoLineModel = (AbstractWidgetController)abstractWidget;
        }
        if (abstractWidget instanceof ModelStubController) {
            this.infoLineModel = (AbstractWidgetController)abstractWidget;
        }
    }

    @Override
    public void remove(AbstractWidget abstractWidget) {
        super.remove(abstractWidget);
        if (abstractWidget == this.property) {
            this.property = null;
        }
    }

    @Override
    protected void autoLayoutSetup() {
        super.autoLayoutSetup();
        if (this.parent instanceof ListController) {
            int[] nArray = new int[]{7, 7, 7, 0, 6, 0, 0};
            int[] nArray2 = new int[]{4, 6, 6, 0, 6, 0, 0};
            int n = framework.getScreenRes();
            this.setGlassplateInsetsTop(nArray[n]);
            this.setGlassplateInsetsBottom(nArray2[n]);
        }
    }

    protected void autoSetup() {
        if (this.type != 16) {
            MenuItemBuilder.configureMenuItem(this, (ExtHMITerminalEvo)((Object)this.getTerminalImpl()));
            if (this.useSmallStageTextForMainLabel) {
                Iterator iterator = this.getChildren().iterator();
                while (iterator.hasNext()) {
                    AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
                    if (!(abstractWidgetController instanceof LabelController)) continue;
                    ((LabelController)abstractWidgetController).setUseSmallStageText(true);
                    break;
                }
            }
        }
        if (this.autoConfigureChaining) {
            MenuItemBuilder.configureChaining(this);
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 14) {
            this.updateFromModel();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void updateFromModel() {
        this.updateInfoLineText();
        if (this.model != null) {
            boolean bl = this.selected;
            this.selected = this.calculateSelected();
            if (bl != this.selected && this.isConnectedSubtree() && this.parent instanceof SelectionProvider) {
                ((SelectionProvider)((Object)this.parent)).selectionChanged(this);
            }
        }
    }

    private boolean calculateSelected() {
        if (this.model == null) {
            return false;
        }
        if (this.model instanceof ChoiceModelGUI && this.widgetID != -1) {
            return ((ChoiceModelGUI)this.model).getValue() == this.widgetID;
        }
        return false;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public IWidgetKeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public void setKeyHandler(IWidgetKeyHandler iWidgetKeyHandler) {
        this.keyHandler = iWidgetKeyHandler;
    }

    public void setKeyHandler(int n) {
        this.setKeyHandler(WidgetKeyHandlerFactory.createKeyHandler(n));
    }

    public void setCloseOptionDrawerAfterScreenConnected(boolean bl) {
        this.closeOptionDrawerAfterScreenConnected = bl;
    }

    public boolean getCloseOptionDrawerAfterScreenConnected() {
        return this.closeOptionDrawerAfterScreenConnected;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        menuItemLogCh.log(-2137614336, "MenuItemWidget#keyPressed. Key code: %2, widget state: %3, model: %1", this.model, (long)keyEvent.getKeyCode(), (long)this.widgetState);
        this.ensureKeyHandlerConfigured();
        boolean bl = this.hasState(36);
        if ((!this.hasInfolineDisclaimer || bl) && this.keyHandler != null) {
            this.keyHandler.keyPressed(this, keyEvent);
            return;
        }
    }

    private void ensureKeyHandlerConfigured() {
        if (this.keyHandler == null) {
            MenuItemBuilder.configureKeyHandler(this);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        this.ensureKeyHandlerConfigured();
        if (this.hasState(36) && this.keyHandler != null) {
            this.keyHandler.keyReleased(this, keyEvent);
        }
        super.keyReleased(keyEvent);
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (wheelButtonEvent.isConsumed()) {
            return;
        }
        this.ensureKeyHandlerConfigured();
        if (this.hasState(36) && this.keyHandler != null) {
            this.keyHandler.keyTurned(this, wheelButtonEvent);
        }
        super.keyTurned(wheelButtonEvent);
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        super.keyMoved(joystickEvent);
        if (joystickEvent.isConsumed()) {
            return;
        }
        this.ensureKeyHandlerConfigured();
        if (this.hasState(36) && this.keyHandler != null) {
            this.keyHandler.keyMoved(this, joystickEvent);
        }
    }

    @Override
    public int getWidgetID() {
        return this.widgetID;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    public void setType(int n) {
        this.type = n;
    }

    public int getType() {
        return this.type;
    }

    public int[] getTextIds() {
        return this.textIds;
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    public void setReplacementModelIds(int[] nArray) {
        this.replacementModelIds = nArray;
    }

    public int[] getReplacementModelIds() {
        return this.replacementModelIds;
    }

    @Override
    public int getSizeForTabulator(int n) {
        if (this.layoutManager instanceof TabLayoutManager) {
            return ((TabLayoutManager)this.layoutManager).calculateTabulator(this, n);
        }
        return -1;
    }

    @Override
    public int getPreferredHeight(boolean bl, int n) {
        int n2 = this.layoutManager instanceof ExpandableLayoutManager && this.preferredHeight == -1 ? ((ExpandableLayoutManager)this.layoutManager).calculateSize(this, bl, n)[1] : (this.layoutManager != null && this.preferredHeight == -1 ? this.layoutManager.calculateSize(this, n)[1] : this.getPreferredHeight());
        return n2 + this.marginTop + this.marginBottom;
    }

    @Override
    public void showExtended(boolean bl) {
        this.propagateExpansionToLayout(this.layoutManager, bl);
        if (this.hasMultipleLayouts()) {
            for (int i2 = 0; i2 < this.layoutChoices.length; ++i2) {
                if (this.layoutChoices[i2] == null) continue;
                this.propagateExpansionToLayout(this.layoutChoices[i2], bl);
            }
        }
        if (this.layoutManager instanceof TransitionLayout) {
            this.setupTransitionBounds((TransitionLayout)this.layoutManager);
        }
    }

    private void propagateExpansionToLayout(LayoutManager layoutManager, boolean bl) {
        if (layoutManager instanceof ExpandableLayoutManager) {
            ((ExpandableLayoutManager)layoutManager).setExpanded(bl);
        }
    }

    @Override
    public IFocusedPropertyObject getProperty() {
        if (this.property != null) {
            IFocusedPropertyObject iFocusedPropertyObject = this.property.getCurrentFocusedPropertyObject();
            if (!this.property.isVisible()) {
                return null;
            }
            if (iFocusedPropertyObject != null) {
                if (this.modelID != -1) {
                    iFocusedPropertyObject.setModelID(this.modelID);
                }
                if (this.widgetID != -1) {
                    iFocusedPropertyObject.setWidgetID(this.widgetID);
                }
            }
            return iFocusedPropertyObject;
        }
        return null;
    }

    public int[][] getMapping() {
        return this.mapping;
    }

    public void setMapping(int[][] nArray) {
        this.mapping = nArray;
    }

    public int getLabelId() {
        return this.labelId;
    }

    public void setLabelId(int n) {
        this.labelId = n;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public void setMarginTop(int n) {
        this.marginTop = n;
    }

    public void setCursorOffsetTop(int n) {
        this.setMarginTop(n);
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public void setMarginBottom(int n) {
        this.marginBottom = n;
    }

    public void setCursorOffsetBottom(int n) {
        this.setMarginBottom(-n);
    }

    public int getGlassplateInsetsTop() {
        return this.glassplateInsetsTop;
    }

    public void setGlassplateInsetsTop(int n) {
        this.glassplateInsetsTop = n;
    }

    public int getGlassplateInsetsBottom() {
        return this.glassplateInsetsBottom;
    }

    public void setGlassplateInsetsBottom(int n) {
        this.glassplateInsetsBottom = n;
    }

    @Override
    public int getGlassplateInsets(boolean bl) {
        return bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
    }

    @Override
    public int getMargin(boolean bl) {
        return bl ? this.marginTop : this.marginBottom;
    }

    @Override
    public void setEnabled(boolean bl) {
        if (!bl) {
            for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
                ComboBoxController comboBoxController;
                if (!(this.getChild(i2) instanceof ComboBoxController) || !(comboBoxController = (ComboBoxController)this.getChild(i2)).isOpen()) continue;
                comboBoxController.close();
                comboBoxController.setEnabled(false);
            }
        }
        if (this.isEnabled() == bl) {
            return;
        }
        super.setEnabled(bl);
        if (this.parent instanceof AbstractPlaceholderMenuController) {
            AbstractPlaceholderMenuController abstractPlaceholderMenuController = (AbstractPlaceholderMenuController)this.parent;
            abstractPlaceholderMenuController.setEnabled(this, bl);
        }
        this.updateInfoLineText(true);
        if (this.getParent() instanceof SubElementMenuController) {
            ((SubElementMenuController)this.getParent()).childEnabledChanged(this);
        }
    }

    @Override
    public IPresetPopupData getPresetPopupData() {
        int n;
        block4: {
            n = -1;
            try {
                int[] nArray = null;
                if (this.parent instanceof MenuController) {
                    AbstractWidget abstractWidget = ((MenuController)this.parent).getChildOfRole(1);
                    if (abstractWidget != null) {
                        nArray = abstractWidget.getColorIndices();
                        n = this.initContext.getScreen().getCurrentColorPalette()[nArray[1]];
                    }
                    break block4;
                }
                return null;
            }
            catch (Exception exception) {
                logPreset.log(-1601830656, "MenuItemController#getPresetPopupData exception occured", (Throwable)exception);
            }
        }
        return new PresetPopupData(0, n, new Preset(1, this.modelID, 0, null, null, 99), null, null, -1, null);
    }

    public void setAutoConfigureChaining(boolean bl) {
        this.autoConfigureChaining = bl;
    }

    public boolean isAutoConfigureChaining() {
        return this.autoConfigureChaining;
    }

    public String getMainLabelText() {
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            String string;
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof LabelController) || (string = ((LabelController)abstractWidgetController).getText()) == null) continue;
            return string;
        }
        return null;
    }

    @Override
    public String getDiagnosisText() {
        return this.getMainLabelText();
    }

    public int getAutoWrap() {
        return this.autoWrap;
    }

    public void setAutoWrap(int n) {
        this.autoWrap = n;
    }

    @Override
    public int getSdsItemSelectedAction() {
        return this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        this.sdsItemSelectedAction = n;
    }

    public int getSdsCommand() {
        return this.sdsCommand;
    }

    public void setSdsCommand(int n) {
        this.sdsCommand = n;
    }

    public int getInternalID() {
        return this.internalID;
    }

    public void setInternalID(int n) {
        this.internalID = n;
    }

    public void setBottomGap(int n) {
        this.bottomGap = n;
    }

    public void setTopGap(int n) {
        this.topGap = n;
    }

    public void updateInfoLineText() {
        this.updateInfoLineText(false);
    }

    private void updateInfoLineText(boolean bl) {
        String string = this.calculateInfolineContent();
        if (!bl && Util.equals(string, this.infolineText)) {
            return;
        }
        this.infolineText = string;
        this.updateInfoline();
        this.setCompositesDirty(true);
        this.invalidateParentLayout();
    }

    public void updateInfoline() {
        AbstractWidget abstractWidget = this.getParent();
        if (abstractWidget instanceof MenuController) {
            MenuController menuController = (MenuController)abstractWidget;
            if (menuController.getInfolineItemIndex() != null && menuController.getInfolineItemIndex().equals(menuController.getMenuItemIndex(this))) {
                menuController.setInfolineText(this.infolineText);
                if (this.infolineText == null || this.infolineText.equals("")) {
                    menuController.hideInfoline(false);
                }
            }
            if (!this.isEnabled()) {
                menuController.restartFocusDetailTimers();
            } else {
                menuController.hideInfoline(false);
            }
        }
    }

    protected String calculateInfolineContent() {
        int[] nArray = null;
        if (this.parent instanceof MenuController) {
            MenuController menuController = (MenuController)this.parent;
            nArray = menuController.getInfolineTextIdsDisabled();
        }
        if (this.isEnabled()) {
            if (this.infolineTextEnabled != null) {
                return this.infolineTextEnabled;
            }
            if (this.infolineTextIdEnabled != -1) {
                return this.getTextForID(this.infolineTextIdEnabled);
            }
            return null;
        }
        if (this.infolineTextDisabled != null) {
            return this.infolineTextDisabled;
        }
        int n = this.getInfolineDisabledIndex();
        if (this.infolineTextIdsDisabled == null || this.infolineTextIdsDisabled.length == 0) {
            if (nArray != null && n >= 0 && n < nArray.length) {
                return this.getTextForID(nArray[n]);
            }
            return null;
        }
        if (n == -1) {
            return null;
        }
        if (n >= 0 && n < this.infolineTextIdsDisabled.length) {
            return this.getTextForID(this.infolineTextIdsDisabled[n]);
        }
        menuItemLogCh.log(10000, "MenuItemWidget#calculateInfolineContent: disabled text index %1 is invalid. textIDs.length: %2", (long)n, (long)this.infolineTextIdsDisabled.length);
        return null;
    }

    protected int getInfolineDisabledIndex() {
        int n = this.getInfolineDisabledIndexFromModel();
        if (n != -1) {
            return n;
        }
        return this.infoLineDisabledTextIndex;
    }

    private int getInfolineDisabledIndexFromModel() {
        if (this.infoLineModel != null && this.infoLineModel.getModel() != null) {
            if (this.infoLineModel instanceof ModelStubController) {
                ModelStubController modelStubController = (ModelStubController)this.infoLineModel;
                return ((ChoiceModelGUI)modelStubController.getModel()).getValue();
            }
            VisibilityProxyWidget visibilityProxyWidget = (VisibilityProxyWidget)this.infoLineModel;
            return ((ChoiceModelGUI)visibilityProxyWidget.getModel()).getValue();
        }
        return -1;
    }

    protected String getTextForID(int n) {
        InitializationContext initializationContext = this.getInitContext();
        AbstractScreenFactory abstractScreenFactory = null;
        if (initializationContext != null) {
            abstractScreenFactory = initializationContext.getScreenFactory();
        }
        if (abstractScreenFactory != null) {
            if (this.terminal != null && this.terminal.getViewSizeManager() != null) {
                return abstractScreenFactory.getText(n, this.terminal.getViewSizeManager().getCurrentViewSize());
            }
            return abstractScreenFactory.getText(n);
        }
        menuItemLogCh.log(-1601830656, "MenuItemWidget#getTextForID: screen factory is null. textID: %1", (long)n);
        return null;
    }

    @Override
    public String getInfolineText() {
        return this.infolineText;
    }

    @Override
    public boolean hasInfolineText() {
        return this.infolineText != null;
    }

    public int getInfolineTextIdEnabled() {
        return this.infolineTextIdEnabled;
    }

    public void setInfolineTextIdEnabled(int n) {
        this.infolineTextIdEnabled = n;
        if (this.isConnected()) {
            this.updateInfoLineText();
        }
    }

    public int[] getInfolineTextIdsDisabled() {
        return this.infolineTextIdsDisabled;
    }

    public void setInfolineTextIdsDisabled(int[] nArray) {
        this.infolineTextIdsDisabled = nArray;
        if (this.isConnected()) {
            this.updateInfoLineText();
        }
    }

    public String getInfolineTextEnabled() {
        return this.infolineTextEnabled;
    }

    public void setInfolineTextEnabled(String string) {
        this.infolineTextEnabled = string;
        if (this.isConnected()) {
            this.updateInfoLineText();
        }
    }

    public String getInfolineTextDisabled() {
        return this.infolineTextDisabled;
    }

    public void setInfolineTextDisabled(String string) {
        this.infolineTextDisabled = string;
        if (this.isConnected()) {
            this.updateInfoLineText();
        }
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public void setMoving(boolean bl) {
        this.isMoving = bl;
    }

    @Override
    public void setOptionsIconSpace(int n) {
        if (n == this.cashedOptionsIconSpace) {
            return;
        }
        this.cashedOptionsIconSpace = n;
        this.setOptionsIconSpace(n, this.layoutManager);
        if (this.layoutChoices != null) {
            for (int i2 = 0; i2 < this.layoutChoices.length; ++i2) {
                if (this.layoutChoices[i2] == null) continue;
                this.setOptionsIconSpace(n, this.layoutChoices[i2]);
            }
        }
        if (this.layoutManager instanceof GridLayout) {
            Iterator iterator = this.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
                if (!(abstractWidget instanceof ComboBoxController)) continue;
                IAxisConstraints iAxisConstraints = ((GridLayout)this.layoutManager).getColumnConstraints();
                int n2 = iAxisConstraints.getGap(iAxisConstraints.getLength());
                ((ComboBoxController)abstractWidget).setAdditionalSpace(n2);
            }
        }
    }

    private void resetCachedOptionsIconSpace() {
        this.cashedOptionsIconSpace = -1;
    }

    @Override
    public void setLayoutManager(LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.resetCachedOptionsIconSpace();
    }

    @Override
    public void setLayoutChoices(LayoutManager[] layoutManagerArray) {
        super.setLayoutChoices(layoutManagerArray);
        this.resetCachedOptionsIconSpace();
    }

    private void setOptionsIconSpace(int n, LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayout) {
            IAxisConstraints iAxisConstraints = ((GridLayout)layoutManager).getColumnConstraints();
            if (iAxisConstraints instanceof MenuItemColumnsConstraints) {
                MenuItemColumnsConstraints menuItemColumnsConstraints = (MenuItemColumnsConstraints)iAxisConstraints;
                if (menuItemColumnsConstraints.rightOptionsIconSpace != n) {
                    menuItemColumnsConstraints.rightOptionsIconSpace = n;
                    this.flushLayoutCache();
                    this.invalidateChildrenBounds();
                }
            } else {
                menuItemLogCh.log(-1601830656, "MenuItemController#setOptionsIconSpace: columnConstraints have no optionsIconSpace. Space: %2, Constraints: %1", (Object)iAxisConstraints, (long)n);
            }
        }
    }

    @Override
    public boolean isFocusable() {
        return this.focusable;
    }

    public void setFocusable(boolean bl) {
        this.focusable = bl;
    }

    public int[] getReplacementTextIds() {
        return this.replacementTextIds;
    }

    public void setReplacementTextIds(int[] nArray) {
        this.replacementTextIds = nArray;
    }

    @Override
    public int getSubItemCount() {
        return this.scrollLineByLine ? this.calculateSubItemCount() : 1;
    }

    private int calculateSubItemCount() {
        if (this.scrollLineHeight > 0) {
            return this.getFixedHeightRowCount();
        }
        return this.getGridRowCount();
    }

    private int getFixedHeightRowCount() {
        float f2 = (float)this.getPreferredMultiLineHeight() / (float)this.scrollLineHeight;
        return (int)Math.ceil(f2);
    }

    @Override
    public void setMenuSize(int n, int n2, int n3) {
        this.menuContentHeight = n2;
        this.menuContentWidth = n;
        this.setOptionsIconSpace(n3);
        if (this.isConnectedSubtree()) {
            this.updateScrollLineByLine();
        }
    }

    @Override
    public int getPreferredLineHeight(int n) {
        if (this.scrollLineHeight > 0) {
            return this.getFixedRowHeight(n);
        }
        return this.getGridRowHeight(n);
    }

    private int getGridRowHeight(int n) {
        int n2;
        int n3;
        int n4 = this.getPreferredMultiLineHeight();
        if (!(this.layoutManager instanceof GridLayout)) {
            return n4;
        }
        GridLayout gridLayout = (GridLayout)this.layoutManager;
        int[] nArray = gridLayout.calculateRows(this.menuContentWidth, n4);
        int n5 = nArray[n * 2];
        int n6 = nArray[n * 2 + 1];
        int n7 = n6 - n5 + 1;
        if (n > 0) {
            n3 = (n - 1) * 2 + 1;
            n2 = nArray[n3];
            n7 += this.getHalfGap(n2, n5, false);
        } else {
            n7 += n5;
        }
        n3 = (n + 1) * 2;
        if (n3 < nArray.length) {
            n2 = nArray[n3];
            n7 += this.getHalfGap(n6, n2, true);
        } else {
            n2 = n4 - n6 - 1;
            n7 += n2;
        }
        return n7;
    }

    private int getFixedRowHeight(int n) {
        int n2 = (n + 1) * this.scrollLineHeight;
        int n3 = this.getPreferredMultiLineHeight();
        if (n2 <= n3) {
            return this.scrollLineHeight;
        }
        return n3 % this.scrollLineHeight;
    }

    @Override
    public void setVisibleAreaBounds(int n, int n2, int n3) {
        this.setY(n - this.getSpaceAbove(n2));
        this.setHeight(this.getPreferredMultiLineHeight());
    }

    private int getSpaceAbove(int n) {
        if (n == 0) {
            return 0;
        }
        if (this.scrollLineHeight > 0) {
            return n * this.scrollLineHeight;
        }
        if (!(this.layoutManager instanceof GridLayout)) {
            menuItemLogCh.log(10000, "MenuItemController#getSpaceAbove: layout is not a gridLayout: %1, widget: %2", (Object)this.layoutManager, (Object)this);
            return 0;
        }
        GridLayout gridLayout = (GridLayout)this.layoutManager;
        int[] nArray = gridLayout.calculateRows(this.menuContentWidth, this.getPreferredMultiLineHeight());
        int n2 = nArray[n * 2];
        int n3 = (n - 1) * 2 + 1;
        int n4 = nArray[n3];
        int n5 = this.getHalfGap(n4, n2, true);
        return n4 + 1 + n5;
    }

    private int getPreferredMultiLineHeight() {
        return this.getPreferredHeight(false, this.menuContentWidth);
    }

    private int getHalfGap(int n, int n2, boolean bl) {
        int n3 = n2 - n - 1;
        double d2 = (double)n3 / 2.0;
        if (bl) {
            return (int)Math.floor(d2);
        }
        return (int)Math.ceil(d2);
    }

    @Override
    public int getFilledInsets(boolean bl) {
        if (bl) {
            return 0;
        }
        if (this.parent instanceof MenuController) {
            return ((MenuController)this.parent).getLayout().getItemsGap();
        }
        menuItemLogCh.log(10000, "MenuItemController#getFilledInsets: parent is not a menu: %1", (Object)this.parent);
        return 0;
    }

    public void setInfoLineEnabled(boolean bl) {
        this.infoLineEnabled = bl;
        if (!this.infoLineEnabled) {
            this.infoLineDisabledTextIndex = -1;
        }
    }

    @Override
    public void setFocused(boolean bl) {
        super.setFocused(bl);
        if (this.realType == 64 && !bl) {
            for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
                if (!(this.getChild(i2) instanceof ComboBoxController)) continue;
                ((ComboBoxController)this.getChild(i2)).close();
            }
        }
    }

    @Override
    public boolean isScrollLineByLine() {
        return this.scrollLineByLine;
    }

    public int getScrollType() {
        return this.scrollType;
    }

    public void setScrollType(int n) {
        this.scrollType = n;
    }

    public int getScrollLineHeight() {
        return this.scrollLineHeight;
    }

    public void setScrollLineHeight(int n) {
        this.scrollLineHeight = n;
    }

    @Override
    public int getOptionIconYOffset() {
        if (AbstractWidget.framework.getScreenRes() == 0) {
            return 1;
        }
        return 0;
    }

    public int getInfoLineDisabledTextIndex() {
        return this.infoLineDisabledTextIndex;
    }

    public void setInfoLineDisabledTextIndex(int n) {
        this.infoLineDisabledTextIndex = this.infoLineEnabled ? n : -1;
    }

    @Override
    public void disconnecting() {
        if (this.itemPreCreatedEnableState != null) {
            this.itemPreCreatedEnableState.clear();
            this.itemPreCreatedEnableState = null;
        }
        if (this.itemPreCreatedVisibility != null) {
            this.itemPreCreatedVisibility.clear();
            this.itemPreCreatedVisibility = null;
        }
        super.disconnecting();
    }

    public boolean isHasInfolineDisclaimer() {
        return this.hasInfolineDisclaimer;
    }

    public void setHasInfolineDisclaimer(boolean bl) {
        this.hasInfolineDisclaimer = bl;
    }

    public int getClippingHeight() {
        return this.clippingHeight;
    }

    public void setClippingHeight(int n) {
        if (this.clippingHeight == n) {
            return;
        }
        this.clippingHeight = n;
        this.setCompositesDirty(true);
    }

    public void setUseSmallStageTextForMainLabel(boolean bl) {
        this.useSmallStageTextForMainLabel = bl;
    }

    public boolean isUseSmallStageTextForMainLabel() {
        return this.useSmallStageTextForMainLabel;
    }

    @Override
    public int getSdsItemSelectedAction(int n) {
        if (n == 0) {
            return this.sdsItemSelectedAction;
        }
        return 0;
    }

    public int getNoCursorAreaTop() {
        return this.noCursorAreaTop;
    }

    public void setNoCursorAreaTop(int n) {
        this.noCursorAreaTop = n;
    }

    public int getNoCursorAreaBottom() {
        return this.noCursorAreaBottom;
    }

    public void setNoCursorAreaBottom(int n) {
        this.noCursorAreaBottom = n;
    }

    @Override
    public int getNoCursorArea(boolean bl) {
        return bl ? this.noCursorAreaTop : this.noCursorAreaBottom;
    }

    public int[] getTextOrientationHints() {
        return this.textOrientationHints;
    }

    public void setTextOrientationHints(int[] nArray) {
        this.textOrientationHints = nArray;
    }

    public void setRealType(int n) {
        this.realType = n;
    }

    public void setLockable(boolean bl) {
        this.lockable = bl;
    }

    public boolean isLockable() {
        return this.lockable;
    }
}

