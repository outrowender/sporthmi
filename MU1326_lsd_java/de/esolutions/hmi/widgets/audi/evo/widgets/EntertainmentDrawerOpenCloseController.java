/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IContentChangeListener;
import de.esolutions.hmi.widgets.audi.base.IEntertainmentDrawerGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IStatusbarGapEventHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SplitGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerAnimationState;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerEventType;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerStateUpdater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntertainmentDrawerOpenCloseController
extends ContainerController
implements LayoutContainer,
IEntertainmentDrawerGapEventHandler,
IDrawer,
IContentChangeListener,
EntertainmentDrawerEventType,
AnimationListener {
    private int horizontalGapGlassplateContent = 0;
    private int verticalGapGlassplateContent = 0;
    private AbstractWidgetController glassplate = null;
    private final int GAP_GLASS_PLATE_BORDER;
    private ContainerController.AnimationTransformation originalAnimationTransformation = null;
    private EntertainmentDrawerStateUpdater stateUpdater = null;
    private EntertainmentDrawerAnimationState animationStates = new EntertainmentDrawerAnimationState();
    private EntertainmentDrawerAnimationManager animationManager;
    private DrawerAnimationManager drawerAnimationManager;
    private EntertainmentDrawerContentController activeContentController = null;
    private List blacklistedAudioSource;
    private boolean visible = true;
    private boolean isLayoutDirty = true;
    private IStatusbarGapEventHandler statusbarEventHandler = null;
    private float progressScreenFadeOutAnimation;
    private float progressOpenCloseAnimation;
    int lastAudioSourceForListener = -1;
    int lastTargetStateForListener = -1;
    private BlacklistingTimer timer;

    public EntertainmentDrawerOpenCloseController() {
        this.GAP_GLASS_PLATE_BORDER = 9;
    }

    public void connected(InitializationContext initializationContext) {
        logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#connected called");
        super.connected(initializationContext);
        this.initBlacklistedAudioSource();
        int n = this.terminal.getLayout().getDistance(2);
        this.stateUpdater = new EntertainmentDrawerStateUpdater(this, this.animationStates, n);
        this.updateAndSyncStatusline();
        this.terminal.getWidgetRegistry().setEntertainmentDrawerGapEventHandler(this);
        this.invalidate();
        this.animationManager = new EntertainmentDrawerAnimationManager(this);
        this.drawerAnimationManager = ((DrawerFocusManager)this.terminal.getDrawerFocusManager()).getDrawerAnimationManager();
        this.timer = new BlacklistingTimer(logEntertainmentDrawer);
        this.add(this.timer);
    }

    public void disconnecting() {
        logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#disconnecting called");
        super.disconnecting();
        this.terminal.getWidgetRegistry().setEntertainmentDrawerGapEventHandler(null);
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        this.invalidate();
    }

    public void remove(AbstractWidget abstractWidget) {
        super.remove(abstractWidget);
        this.invalidateLayout(null);
    }

    public boolean canOpen() {
        boolean bl;
        if (this.animationManager == null) {
            IWidgetLogChannel.logEntertainmentDrawer.log(10000, "EntertainmentDrawerOpenCloseController#canOpen: animationManager is null");
            return false;
        }
        this.updateTargetState();
        this.animationManager.updateContent();
        boolean bl2 = this.animationStates.getCurrentDrawerState() != 6;
        boolean bl3 = this.animationStates.getCurrentState().isVisible();
        boolean bl4 = this.getContent().isConnected();
        boolean bl5 = bl = (bl2 || this.isIncomingCallDuringClosedDisabled()) && bl3 && bl4;
        if (!bl4) {
            logDrawerFocusMain.log(10000, "EntertainmentDrawerOpenCloseController#canOpen: content is not connected yet -> canOpen = %1 -> DrawerFocusManager#requestDrawerState will be called from content, again.", bl);
            this.getContent().setHasToRequestDrawerState(true);
        }
        if (!bl) {
            IWidgetLogChannel.logEntertainmentDrawer.log(10000, new StringBuffer().append("EntertainmentDrawerOpenCloseController#canOpen: cannot open entertainment drawer: current drawer state=").append(this.animationStates.getCurrentDrawerState()).append(", current state visible=").append(bl3).toString());
        } else {
            IWidgetLogChannel.logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#canOpen: %1", bl);
        }
        return bl;
    }

    private boolean isIncomingCallDuringClosedDisabled() {
        return this.animationStates.getCurrentDrawerState() == 6 && this.animationStates.getTargetState().getAudioSource() == 5003;
    }

    public boolean canClose() {
        if (this.activeContentController != null) {
            boolean bl = !framework.getHMIService().getHMITerminal(0).getKbdService().isPanelWithJoystick();
            boolean bl2 = this.terminal.getFramework().getHMIService().getChoiceModel(138).getValue() == 3;
            int n = this.activeContentController.getAudioSource();
            if (n == 5003 && bl && bl2) {
                IWidgetLogChannel.logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#canClose: false");
                return false;
            }
        }
        IWidgetLogChannel.logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#canClose: true");
        return true;
    }

    private void initBlacklistedAudioSource() {
        int n = this.terminal.getDrawerManager().getBlackListedConnection();
        if (this.blacklistedAudioSource == null) {
            this.blacklistedAudioSource = new ArrayList();
        }
        if (n != -1) {
            if (!this.blacklistedAudioSource.contains(new Integer(n))) {
                this.blacklistedAudioSource.add(Util.createInteger(n));
            }
        } else {
            this.blacklistedAudioSource.clear();
        }
    }

    private void updateAndSyncStatusline() {
        if (this.isConnected() && this.getStatusbarGapEventHandler() != null) {
            EntertainmentDrawerState entertainmentDrawerState = this.animationStates.getCurrentState();
            if (this.statusbarEventHandler.getGapHeight() != entertainmentDrawerState.getGapHeight()) {
                this.statusbarEventHandler.setGapHeight(entertainmentDrawerState.getGapHeight());
            }
            if (this.statusbarEventHandler.getCurrentGapWidth() != entertainmentDrawerState.getWidth()) {
                this.statusbarEventHandler.setGapWidth(entertainmentDrawerState.getWidth(), false);
            }
        }
    }

    public EntertainmentDrawerAnimationState getAnimationStates() {
        return this.animationStates;
    }

    public List getBlacklistedAudioSource() {
        return this.blacklistedAudioSource;
    }

    public EntertainmentDrawerContentController getContent() {
        return this.animationStates.getCurrentState().getContent();
    }

    public int getDisplayDrawerState() {
        return this.animationStates.getCurrentDrawerState();
    }

    public IStatusbarGapEventHandler getStatusbarGapEventHandler() {
        if (this.statusbarEventHandler == null && this.isConnected() && this.terminal.getWidgetRegistry() != null) {
            this.statusbarEventHandler = this.terminal.getWidgetRegistry().getStatusbarGapEventHandler();
        }
        return this.statusbarEventHandler;
    }

    public int getIndentHorizontal() {
        return this.horizontalGapGlassplateContent;
    }

    public int getIndentVertical() {
        return this.verticalGapGlassplateContent;
    }

    public int getAudioSourceFromModel() {
        int n = -1;
        if (this.model instanceof ChoiceModelGUI) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            if (choiceModelGUI.getStatus() != 3) {
                n = choiceModelGUI.getValue();
            }
        } else if (this.isConnected()) {
            if (this.model instanceof TiledListModelGUI) {
                n = EntertainmentDrawerContentManager.getContentIDForAppReq((TiledListModelGUI)this.model, this.terminal.getDrawerManager());
            } else if (this.model instanceof ListModelGUI) {
                n = EntertainmentDrawerContentManager.getContentIDForAppReq((ListModelGUI)this.model, this.terminal.getDrawerManager());
            } else {
                logEntertainmentDrawer.log(10000, "EntertainmentDrawerOpenCloseController#getAudioSourceFromModel: unknown model type: %1", this.model);
            }
        }
        if (n == -1) {
            n = 9999;
            logEntertainmentDrawer.log(100000, "EntertainmentDrawerOpenCloseController#getAudioSourceFromModel: no value set in model, default audio source (%1) was set", (long)n);
        }
        return n;
    }

    public ContainerController.AnimationTransformation getOriginalAnimationTransformation() {
        return this.originalAnimationTransformation;
    }

    public int getPreferredHeight() {
        return this.animationStates.getCurrentState().getHeight();
    }

    public int getPreferredWidth() {
        return this.animationStates.getCurrentState().getWidth() + this.horizontalGapGlassplateContent * 2;
    }

    public int getMinWidth() {
        if (this.activeContentController != null) {
            int n = this.animationStates.getCurrentState().getDrawerState();
            return this.activeContentController.getMinWidth(n);
        }
        return 0;
    }

    public int getY() {
        return this.animationStates.getCurrentState().getYScreenOffset();
    }

    public void setHideTransformation(ContainerController.AnimationTransformation animationTransformation) {
        super.setHideTransformation(animationTransformation);
        if (this.originalAnimationTransformation == null) {
            this.originalAnimationTransformation = animationTransformation;
        }
    }

    public void setHideTransformation(float f2, float f3, float f4, float f5, float f6) {
        this.setHideTransformation(new ContainerController.MutableAnimationTransformation(f2, f3, f4, f6));
    }

    public void setIndentHorizontal(int n) {
        this.horizontalGapGlassplateContent = n;
    }

    public void setIndentVertical(int n) {
        this.verticalGapGlassplateContent = n;
    }

    public boolean isDrawerVisible() {
        return this.visible;
    }

    public boolean isBlacklisted() {
        int n = this.animationStates.getCurrentState().getAudioSource();
        for (int i2 = 0; i2 < this.blacklistedAudioSource.size(); ++i2) {
            if (n != (Integer)this.blacklistedAudioSource.get(i2)) continue;
            return true;
        }
        return false;
    }

    public void invalidate() {
        this.invalidateLayout(null);
        this.setCompositesDirty(true);
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        if (abstractWidget != null && abstractWidget == this.activeContentController) {
            this.onContentDimensionsChanged();
        }
        this.isLayoutDirty = true;
        this.setInvalid(true);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.onActiveAudioSourceChange();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void setDisplayDrawerState(int n, boolean bl, boolean bl2) {
        this.onSetDisplayDrawerState(n, bl);
    }

    public void setEntertainmentDrawerStateRequest(int n, boolean bl) {
        if (this.stateUpdater != null) {
            this.stateUpdater.updateTargetState(n, true);
            if (this.animationManager != null) {
                this.animationManager.updateContent();
                hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, new Runnable(){

                    public void run() {
                        if (EntertainmentDrawerOpenCloseController.this.animationManager != null) {
                            EntertainmentDrawerOpenCloseController.this.animationManager.processAnimation(200, -1.0f, 1);
                        } else {
                            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#setEntertainmentDrawerStateRequest/RunnableEvent: animationManager is null");
                        }
                    }
                }));
            } else {
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#setEntertainmentDrawerStateRequest: animationManager is null");
            }
        }
    }

    private void onActiveAudioSourceChange() {
        this.updateTargetState();
        if (this.animationManager != null) {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#processModelUpdateEvent: Audio source changed from %1 to %2", (long)this.animationStates.getSourceState().getAudioSource(), (long)this.animationStates.getTargetState().getAudioSource());
            this.animationManager.updateContent();
            this.animationManager.processAnimation(200, -1.0f, 0);
        } else {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onActiveAudioSourceChange: animationManager is null");
        }
    }

    public void onBlacklistAudioSource(int n, int n2) {
        if (this.blacklistedAudioSource == null) {
            this.blacklistedAudioSource = new ArrayList();
        }
        if (n2 == -1) {
            if (this.blacklistedAudioSource.size() > 0) {
                Integer n3 = (Integer)this.blacklistedAudioSource.remove(0);
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onBlacklistAudioSource: Removed blacklisting, audioSource: %1, remaining amount of blacklisted audio sources: %2", (Object)n3.toString(), (long)this.blacklistedAudioSource.size());
                if (this.animationManager != null && this.timer != null) {
                    this.animationManager.setDelayForDeblacklistingActive(true);
                    this.timer.restartTimer();
                }
            } else {
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(1000000, "EntertainmentDrawerOpenCloseController#onBlacklistAudioSource: Tried to remove blacklisting, but no audioSource was blacklisted anymore.");
            }
        } else {
            if (!this.blacklistedAudioSource.contains(new Integer(n2))) {
                this.blacklistedAudioSource.add(Util.createInteger(n2));
            }
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onBlacklistAudioSource: blacklisted audio source=%1, amount of blacklisted audio sources:%2", (long)n2, (long)this.blacklistedAudioSource.size());
        }
        this.updateTargetState();
    }

    public void onContentDimensionsChanged() {
        this.updateTargetState();
        IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onContentDimensionsChanged called");
        if (this.animationManager != null) {
            this.animationManager.updateContent();
            this.animationManager.processAnimation(200, -1.0f, 6);
        } else {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onContentDimensionsChanged: animationManager is null");
        }
    }

    public void onDrawerVisibiltyChange(boolean bl) {
        if (this.visible != bl) {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onDrawerVisibiltyChange visible=%1", bl);
            this.visible = bl;
            this.updateTargetState();
            if (this.animationManager != null) {
                this.animationManager.processAnimation(200, -1.0f, 3);
            } else {
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onDrawerVisibiltyChange: animationManager is null");
            }
            if (this.drawerAnimationManager != null) {
                this.drawerAnimationManager.setIsEntertainmentDrawerVisible(bl);
            }
        }
    }

    public boolean onGapDataChanged(int n) {
        switch (n) {
            case 1: {
                this.updateTargetState();
                break;
            }
            case 0: {
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onGapDataChanged VALUE_CHANGED_MAX_GAP_WIDTH");
                if (this.animationManager != null) {
                    this.animationManager.processAnimation(200, -1.0f, 4);
                    break;
                }
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onGapDataChanged: animationManager is null");
                break;
            }
        }
        return false;
    }

    public void onNewContentAvalabilityChanged() {
        this.updateTargetState();
    }

    private void onSetDisplayDrawerState(int n, boolean bl) {
        if (this.stateUpdater != null) {
            this.stateUpdater.updateTargetState(n, true);
            this.invalidate();
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerOpenCloseController#onSetDisplayDrawerState state=%1", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
        }
    }

    public boolean updateTargetState() {
        if (this.stateUpdater != null) {
            int n;
            boolean bl = this.stateUpdater.updateTargetState(false);
            this.invalidate();
            int n2 = this.getAudioSourceFromModel();
            if (this.terminal != null && this.terminal.getDrawerManager() != null && this.animationStates != null && (this.lastTargetStateForListener != (n = this.animationStates.getTargetDrawerState()) || this.lastAudioSourceForListener != n2)) {
                this.terminal.getDrawerManager().notifyADCListeners(n2, n);
                this.lastTargetStateForListener = n;
                this.lastAudioSourceForListener = n2;
            }
            return bl;
        }
        return false;
    }

    public void render(RedrawContext redrawContext) {
        if (this.isConnected()) {
            EntertainmentDrawerState entertainmentDrawerState;
            if (this.isLayoutDirty && (entertainmentDrawerState = this.animationStates.getCurrentState()).getContent() != null) {
                this.setContent(entertainmentDrawerState.getContent());
                if (this.activeContentController != null) {
                    int n = this.animationStates.getCurrentState().getDrawerState();
                    this.activeContentController.setDisplayDrawerState(n, false, true);
                }
                this.updateRenderProperties();
                this.isLayoutDirty = false;
            }
            super.render(redrawContext);
        }
    }

    private void setContent(EntertainmentDrawerContentController entertainmentDrawerContentController) {
        if (entertainmentDrawerContentController != null) {
            if (!entertainmentDrawerContentController.equals(this.activeContentController)) {
                if (this.activeContentController != null) {
                    this.remove(this.activeContentController);
                    this.activeContentController = null;
                }
                this.terminal.getDrawerManager().activateEntertainmentDrawerContent(null);
                if (entertainmentDrawerContentController.getParent() != null) {
                    entertainmentDrawerContentController.getParent().remove(entertainmentDrawerContentController);
                }
                this.terminal.getDrawerManager().activateEntertainmentDrawerContent(entertainmentDrawerContentController);
                this.activeContentController = entertainmentDrawerContentController;
                IWidgetLogChannel.logEntertainmentDrawer.log(10000000, "EntertainmentDrawerOpenCloseController#setContent newContent=%1 ", (Object)entertainmentDrawerContentController);
                this.add(entertainmentDrawerContentController);
                entertainmentDrawerContentController.setConnected(true);
                this.activeContentController.setCompositesDirty(true);
                EntertainmentDrawerState entertainmentDrawerState = this.animationStates.getTargetState();
                if (entertainmentDrawerState != null) {
                    boolean bl;
                    boolean bl2 = entertainmentDrawerState.getHeight() != this.activeContentController.getHeight();
                    boolean bl3 = bl = entertainmentDrawerState.getWidth() != this.activeContentController.getWidth();
                    if (bl2 || bl) {
                        this.activeContentController.invalidateChildrenBounds();
                        this.activeContentController.invalidateParentLayout();
                        this.onContentDimensionsChanged();
                    }
                }
            }
        } else {
            IWidgetLogChannel.logEntertainmentDrawer.log(10000, "EntertainmentDrawerOpenCloseController#setContent new content is null [%1]", (Object)entertainmentDrawerContentController);
        }
    }

    public void setGlassplate(AbstractWidgetController abstractWidgetController) {
        if (this.glassplate != null) {
            this.remove(this.glassplate);
        }
        this.glassplate = abstractWidgetController;
        if (this.glassplate != null) {
            this.add(this.glassplate);
        }
    }

    private void updateContent(int n, int n2, EntertainmentDrawerState entertainmentDrawerState) {
        EntertainmentDrawerContentController entertainmentDrawerContentController = entertainmentDrawerState.getContent();
        if (entertainmentDrawerContentController != null) {
            int n3;
            entertainmentDrawerContentController.setOpacity(entertainmentDrawerState.getOpacity());
            boolean bl = false;
            if (entertainmentDrawerContentController != null && (n3 = entertainmentDrawerContentController.getGlassplateType()) == 1) {
                bl = true;
            }
            float f2 = entertainmentDrawerState.getYTranslation();
            int n4 = (int)((float)this.verticalGapGlassplateContent - (bl ? f2 : 0.0f));
            int n5 = n2;
            int n6 = this.getPreferredHeight() - 9 - this.verticalGapGlassplateContent * 2;
            entertainmentDrawerContentController.setBounds(n, n4, n5, n6);
            entertainmentDrawerContentController.setCompositesDirty(true);
            entertainmentDrawerContentController.setInvalid(true);
            boolean bl2 = false;
            if (this.animationStates.getTargetState() != null) {
                bl2 = f2 == this.animationStates.getTargetState().getYTranslation();
            }
            boolean bl3 = !bl || bl && bl2;
            entertainmentDrawerContentController.setVisible(bl3);
        }
    }

    private void updateGlassplate(int n, int n2) {
        if (this.glassplate instanceof SplitGlassplateController) {
            if (n2 == -1) {
                this.glassplate.setHeight(this.getPreferredHeight());
            } else {
                this.glassplate.setBounds(n, 0, n2, this.getPreferredHeight());
            }
            int n3 = -1;
            EntertainmentDrawerState entertainmentDrawerState = this.animationStates.getCurrentState();
            EntertainmentDrawerContentController entertainmentDrawerContentController = entertainmentDrawerState.getContent();
            if (entertainmentDrawerState.getOpacity() > 0.0f && this.isDrawerOrMainAreaShown() && entertainmentDrawerContentController != null && entertainmentDrawerContentController.getDrawerMain() != null) {
                DrawerMain drawerMain = entertainmentDrawerContentController.getDrawerMain();
                int n4 = -1;
                int n5 = 0;
                Iterator iterator = ((AbstractWidgetController)((Object)drawerMain)).getChildren().iterator();
                while (iterator.hasNext()) {
                    AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
                    if (!abstractWidgetController.shouldRender()) continue;
                    if (entertainmentDrawerContentController instanceof LayoutContainerController && drawerMain instanceof LayoutContainerController) {
                        entertainmentDrawerContentController.manageLayout();
                        ((LayoutContainerController)((Object)drawerMain)).manageLayout();
                    }
                    if (++n5 == 1) {
                        n4 = abstractWidgetController.getY() + abstractWidgetController.getHeight();
                        continue;
                    }
                    if (n5 != 2) continue;
                    n3 = n4;
                }
            }
            if (n3 == -1) {
                n3 = this.glassplate.getHeight();
            }
            ((SplitGlassplateController)this.glassplate).setSeparatorPosition(n3);
            this.glassplate.setVisible(n2 != 0);
            boolean bl = this.activeContentController != null ? this.activeContentController.isVerticalLineVisible() : false;
            ((SplitGlassplateController)this.glassplate).setVerticalLineVisible(bl);
            this.glassplate.setCompositesDirty(true);
        }
    }

    private void updateRenderProperties() {
        EntertainmentDrawerState entertainmentDrawerState = this.animationStates.getCurrentState();
        if (this.getStatusbarGapEventHandler() != null) {
            this.statusbarEventHandler.setGapHeight(entertainmentDrawerState.getGapHeight());
        }
        int n = entertainmentDrawerState.getWidth() + this.horizontalGapGlassplateContent * 2;
        int n2 = (this.getWidth() - n) / 2;
        this.setTransY(entertainmentDrawerState.getYTranslation());
        this.updateContent(n2, n, entertainmentDrawerState);
        this.updateGlassplate(n2, n);
    }

    public int getDrawerAnimationMask() {
        return 4112;
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (this.animationManager == null) {
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000, "EntertainmentDrawerOpenCloseController#setDrawerAnimation: animationManager is null");
            return;
        }
        if (DrawerAnimationManager.Helper.hasFlag(n, 4)) {
            this.progressOpenCloseAnimation = fArray[4];
            float f2 = fArray2[4];
            if (f2 == 0.0f) {
                this.progressOpenCloseAnimation = 1.0f - this.progressOpenCloseAnimation;
            }
            this.animationManager.processAnimation(100, this.calculateFinalProgress(), 7);
        } else if (DrawerAnimationManager.Helper.hasFlag(n, 12)) {
            if (fArray2[12] == 1.0f) {
                this.progressScreenFadeOutAnimation = fArray[12];
                this.animationManager.processAnimation(100, this.calculateFinalProgress(), 7);
            } else {
                this.progressScreenFadeOutAnimation = 0.0f;
            }
        }
        if (this.calculateFinalProgress() >= 1.0f) {
            this.animationManager.setGlobalAnimationIsAnimating(false);
            IWidgetLogChannel.logEntertainmentDrawerAnimationManager.log(10000000, "EntertainmentDrawerOpenCloseController#setDrawerAnimation: global animation finished");
        }
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        if (this.terminal != null && this.terminal.getDrawerManager() != null && this.animationStates != null) {
            int n2 = this.animationStates.getTargetState().getDrawerState();
            if (n2 == 0 || n2 == 3) {
                this.terminal.getDrawerManager().entertainmentDrawerOpened();
            } else if (n2 == 1 || n2 == 6 || n2 == 2 || n2 == 4) {
                this.terminal.getDrawerManager().entertainmentDrawerClosed();
            }
        }
        super.drawerAnimationFinished(fArray, fArray2, n);
    }

    private float calculateFinalProgress() {
        float f2 = 0.0f;
        f2 = this.progressOpenCloseAnimation == 0.0f ? this.progressScreenFadeOutAnimation : (this.progressScreenFadeOutAnimation == 0.0f ? this.progressOpenCloseAnimation : this.progressScreenFadeOutAnimation * this.progressOpenCloseAnimation);
        return f2;
    }

    public boolean isHeaderVisible() {
        return this.activeContentController != null && this.activeContentController.isHeaderVisible();
    }

    public boolean isDelayForDeblacklistingActive() {
        if (this.animationManager != null) {
            return this.animationManager.getDelayForDeblacklistingActive();
        }
        return false;
    }

    public static final class TypeOfCall {
        static final int NO_CALL = 1;
        static final int ACTIVE = 2;
        static final int INCOMING = 3;
    }

    private class BlacklistingTimer
    extends AbstractIdleTimerController {
        public BlacklistingTimer(LogChannel logChannel) {
            super(logChannel);
            this.startTimerAutomatically = false;
            this.fireWhenOptionDrawerOpen = true;
            this.fireWhenSelectionDrawerOpen = true;
            this.deactivateOnKeyReleased = false;
            this.idleTime = 300;
        }

        protected void timerFired() {
            EntertainmentDrawerOpenCloseController.this.animationManager.setDelayForDeblacklistingActive(false);
            EntertainmentDrawerOpenCloseController.this.animationManager.processAnimation(200, -1.0f, 1);
        }
    }
}

