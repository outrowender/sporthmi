/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.tghu.hmi.evo.IDrawer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerAnimationState;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;

public class EntertainmentDrawerContentController
extends DrawerController {
    public static final int GLASSPLATE_TYPE_NORMAL = 0;
    public static final int GLASSPLATE_TYPE_SDS = 1;
    public static final int NO_GLASSPLATE_TYPE = 2;
    public static final int MIN_WIDTH = 0;
    public static final int MAX_WIDTH = 1;
    protected int glassplateType = 0;
    private int audioSource = -1;
    private boolean autoComputeHideTransformation = false;
    private boolean isVerticalLineVisible = true;
    private int[] audioDrawerMinMaxWidthOpened;
    private int[] audioDrawerMinMaxWidthClosed;
    private int[] audioDrawerMinMaxWidthMinimized;
    private int requestedDrawerState;
    private boolean hasToRequestDrawerState = false;

    public EntertainmentDrawerContentController(int n) {
        super(n);
    }

    public int getAudioSource() {
        return this.audioSource;
    }

    public void setAudioSource(int n) {
        this.audioSource = n;
    }

    public void relayout() {
        this.layout();
    }

    public int getGlassplateType() {
        return this.glassplateType;
    }

    public void setGlassplateType(int n) {
        this.glassplateType = n;
    }

    public void connected(InitializationContext initializationContext) {
        InitializationContext initializationContext2 = new InitializationContext(initializationContext.getTerminal());
        initializationContext2.setScreen(initializationContext.getScreen());
        initializationContext2.setScreenID(initializationContext.getScreenID());
        initializationContext2.setCompositeID(initializationContext.getCompositeID());
        initializationContext2.setReinit(initializationContext.isReinit());
        initializationContext2.setScreenFactory(this.screenFactory);
        super.connected(initializationContext2);
        this.setConnected(true);
        this.setHasDynamicLayout(true);
        if (this.icon != null) {
            this.icon.setAnimationType(59);
        }
        if (this.main != null) {
            this.main.setAnimationType(58);
        }
        if (this.hasToRequestDrawerState) {
            logDrawerFocusMain.log(10000000, "EntertainmentDrawerContentController#connected: request drawerstate from content, content was not connected before.");
            this.terminal.getDrawerFocusManager().requestDrawerState(32);
            this.hasToRequestDrawerState = false;
        }
    }

    public void setHideTransformation(ContainerController.AnimationTransformation animationTransformation) {
        super.setHideTransformation(animationTransformation);
        this.invalidateParentLayout();
    }

    public void setHideTransformation(float f2, float f3, float f4, float f5, float f6) {
        super.setHideTransformation(f2, f3, f4, f5, f6);
        this.invalidateParentLayout();
    }

    public AbstractWidgetController getMain() {
        return this.main instanceof AbstractWidgetController ? (AbstractWidgetController)((Object)this.main) : null;
    }

    public AbstractWidgetController getIcon() {
        return this.icon instanceof AbstractWidgetController ? (AbstractWidgetController)((Object)this.icon) : null;
    }

    public boolean getAutoComputeHideTransformation() {
        return this.autoComputeHideTransformation;
    }

    public void setAutoComputeHideTransformation(boolean bl) {
        this.autoComputeHideTransformation = bl;
    }

    public ContainerController.AnimationTransformation getHideTransformation(boolean bl) {
        ContainerController.AnimationTransformation animationTransformation = super.getHideTransformation(bl);
        AbstractWidgetController abstractWidgetController = this.getMain();
        AbstractWidgetController abstractWidgetController2 = this.getIcon();
        if (this.autoComputeHideTransformation && abstractWidgetController != null && abstractWidgetController2 != null) {
            int n = abstractWidgetController.getPreferredHeight();
            int n2 = abstractWidgetController2.getPreferredHeight();
            if (n != -1 && n2 != -1) {
                animationTransformation = new ContainerController.MutableAnimationTransformation().setTranslation(0.0f, n - n2, 0.0f);
            }
        }
        return animationTransformation;
    }

    public boolean isVerticalLineVisible() {
        return this.isVerticalLineVisible;
    }

    public void setVerticalLineVisible(boolean bl) {
        this.isVerticalLineVisible = bl;
    }

    public String toString() {
        return super.toString() + " <" + this.audioSource + ">";
    }

    public void setEntertainmentDrawerStateRequest(int n) {
        if (n != 7) {
            this.requestedDrawerState = n;
            IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: cache requested state %1", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
        }
        if (this.getParent() instanceof EntertainmentDrawerOpenCloseController) {
            EntertainmentDrawerState entertainmentDrawerState;
            EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = (EntertainmentDrawerOpenCloseController)this.getParent();
            int n2 = entertainmentDrawerOpenCloseController.getAudioSourceFromModel();
            if (this.audioSource != n2) {
                logEntertainmentDrawerEvents.log(10000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest state " + AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING) + " requested on audioSource " + this.audioSource + " but audioSourceFromModel is " + n2 + ". Reject state request!");
                return;
            }
            EntertainmentDrawerAnimationState entertainmentDrawerAnimationState = entertainmentDrawerOpenCloseController.getAnimationStates();
            if (entertainmentDrawerAnimationState != null && (entertainmentDrawerState = entertainmentDrawerAnimationState.getSourceState()) != null) {
                int n3 = entertainmentDrawerState.getDrawerState();
                if (entertainmentDrawerOpenCloseController.isBlacklisted() && n == 6) {
                    IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: requested state %1", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
                    entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(6, true);
                } else if (!entertainmentDrawerOpenCloseController.isBlacklisted() || n3 == 6) {
                    IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: requested state %1", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
                    switch (n) {
                        case 1: {
                            entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(1, true);
                            break;
                        }
                        case 6: {
                            entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(6, true);
                            break;
                        }
                        case 2: {
                            entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(2, true);
                            break;
                        }
                        case 0: {
                            entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(0, true);
                            break;
                        }
                        default: {
                            IWidgetLogChannel.logEntertainmentDrawerEvents.log(100000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: untreated stateRequest: %1", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
                            break;
                        }
                    }
                } else if (entertainmentDrawerOpenCloseController.isBlacklisted() && n == 1) {
                    IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: requested state DRAWER_STATE_CLOSED");
                    entertainmentDrawerOpenCloseController.setEntertainmentDrawerStateRequest(1, true);
                } else {
                    IWidgetLogChannel.logEntertainmentDrawerEvents.log(10000000, "EntertainmentDrawerContentController#setEntertainmentDrawerStateRequest: requested state %1 was not executed", (Object)AnimUtils.valueToString(n, IDrawer.DRAWER_STATE_TO_STRING));
                }
            }
        }
    }

    public boolean equals(Object object) {
        EntertainmentDrawerContentController entertainmentDrawerContentController;
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof EntertainmentDrawerContentController && this.audioSource == (entertainmentDrawerContentController = (EntertainmentDrawerContentController)object).getAudioSource() && this.getID() == entertainmentDrawerContentController.getID()) {
            return true;
        }
        return super.equals(object);
    }

    public int[] getAudioDrawerMinMaxWidthOpened() {
        return this.audioDrawerMinMaxWidthOpened;
    }

    public void setAudioDrawerMinMaxWidthOpened(int[] nArray) {
        this.audioDrawerMinMaxWidthOpened = nArray;
    }

    public int[] getAudioDrawerMinMaxWidthClosed() {
        return this.audioDrawerMinMaxWidthClosed;
    }

    public void setAudioDrawerMinMaxWidthClosed(int[] nArray) {
        this.audioDrawerMinMaxWidthClosed = nArray;
    }

    public int[] getAudioDrawerMinMaxWidthMinimized() {
        return this.audioDrawerMinMaxWidthMinimized;
    }

    public void setAudioDrawerMinMaxWidthMinimized(int[] nArray) {
        this.audioDrawerMinMaxWidthMinimized = nArray;
    }

    public void updateTargetState() {
        if (this.getParent() instanceof EntertainmentDrawerOpenCloseController) {
            EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = (EntertainmentDrawerOpenCloseController)this.getParent();
            entertainmentDrawerOpenCloseController.updateTargetState();
        }
    }

    public boolean isSDSAudioSource(int n) {
        return EntertainmentDrawerContentManager.isSDSAudioSource(n);
    }

    public boolean isPhoneAudioSource(int n) {
        return EntertainmentDrawerContentManager.isPhoneAudioSource(n);
    }

    public int getMinWidth(int n) {
        switch (n) {
            case 0: {
                return this.audioDrawerMinMaxWidthOpened[0];
            }
            case 1: 
            case 6: {
                return this.audioDrawerMinMaxWidthClosed[0];
            }
        }
        return this.audioDrawerMinMaxWidthMinimized[0];
    }

    public int getRequestedDrawerState() {
        return this.requestedDrawerState;
    }

    public void setHasToRequestDrawerState(boolean bl) {
        this.hasToRequestDrawerState = bl;
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        ContainerController containerController;
        if (this.isHeaderVisible() && this.title instanceof ContainerController && (containerController = (ContainerController)this.title).getPreferredWidth() != n3) {
            containerController.setPreferredWidth(n3);
        }
        super.setBounds(n, n2, n3, n4);
    }

    public boolean isEntertainmentDrawerContent() {
        return true;
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (this.hasToRequestDrawerState) {
            logDrawerFocusMain.log(10000000, "EntertainmentDrawerContentController#setVisible: request drawerstate from content, content was not visible before.");
            this.terminal.getDrawerFocusManager().requestDrawerState(32);
            this.hasToRequestDrawerState = false;
        }
    }
}

