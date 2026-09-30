/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IAbstractCursorBarWidget;
import de.esolutions.hmi.widgets.audi.base.IDisplayControllerWidget;
import de.esolutions.hmi.widgets.audi.base.IGroupOpacity;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.animation.CombinedAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public abstract class AnimationController
extends AbstractAnimationController {
    private static final String TEXT_POPUP_BOUND = "POPUP_BOUND";
    protected static final String TEXT_UNKNOWN_SCREENTYPE = "UNKNOWN SCREENTYPE";
    protected static final String TEXT_REARVIEW = "REARVIEW";
    protected static final String TEXT_VIDEO = "VIDEO";
    protected static final String TEXT_MEDIA_FULLSCREEN = "MEDIA FULLSCREEN";
    protected static final String TEXT_TV = "TV";
    protected static final String TEXT_BROWSER = "BROWSER";
    protected static final String TEXT_BROWSER_BOOKMARK = "BROWSER BOOKMARK";
    protected static final String TEXT_MAP = "MAP";
    protected static final String TEXT_MAP_RCCI = "MAP RCCI";
    protected static final String TEXT_HMI_ONLY = "HMI_ONLY";
    protected static final String TEXT_STANDBY = "STANDBY";
    protected static final String TEXT_WIZARD = "WIZARD";
    protected static final String TEXT_FULLSCREEN_SDS_POPUP = "FULLSCREEN SDS POPUP";
    private final Buffer statisticsBuffer;
    protected static final boolean SHOW_SCREEN_CHANGE_ANIMATION_INFO = Boolean.getBoolean("showScreenChangeAnimationInfo");
    protected static final boolean LOG_SCREEN_CHANGE = System.getProperty("logScreenChange", "true").equals("true");
    protected static final int[] COMPUTED_ANIMATION_INFO_NO_ANIMATION = new int[]{0, 0, 0, 0};
    protected int[] modelledAnimationInfo;
    protected int[] currentAnimationInfo = new int[]{0, 0, 0, 0};
    protected int[] computedAnimationInfo = new int[]{0, 0, 0, 0};
    protected IScreenData currentScreenData;
    protected IScreenData targetScreenData;
    protected Screen currentScreen;
    protected Screen targetScreen;
    protected int currentScreenType = 0;
    protected int targetScreenType = 0;
    protected int currentContextID = 0;
    protected int targetContextID = 0;
    protected AbstractScreenWidget connectedMainScreen;
    protected boolean firstScreenWasShown = false;
    protected WidgetRegistry widgetRegistry;
    private AbstractWidgetController sportskinSmallStageMapGrid;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IAnimationController;

    public AnimationController(int n) {
        super(n);
        this.statisticsBuffer = SHOW_SCREEN_CHANGE_ANIMATION_INFO ? new Buffer() : null;
    }

    public void startWaitAnimation(int n) {
        IAbstractCursorBarWidget iAbstractCursorBarWidget = (IAbstractCursorBarWidget)((Object)this.widgetRegistry.getWidget(1, n, this.connectedMainScreen));
        if (iAbstractCursorBarWidget != null) {
            iAbstractCursorBarWidget.startWaitAnimation(0);
        } else {
            this.logAnimation.log(10000000, "Animation#startWaitAnimation no cursor to fade");
        }
    }

    public List getRunningAnimation(int n) {
        if (this.isAnimationRunning(n)) {
            return this.actualAnimations[n];
        }
        return null;
    }

    public void setGroupOpacityEnabled(boolean bl, Screen screen) {
        List list = this.widgetRegistry.getGroupOpacityWidgets(screen);
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((IGroupOpacity)list.get(i2)).setGroupOpacityEnabled(bl);
            }
        }
    }

    public void start(IFrameworkAccess iFrameworkAccess) {
        this.connectedMainScreen = null;
        for (int i2 = 0; i2 < this.actualAnimations.length; ++i2) {
            this.actualAnimations[i2] = new ArrayList(1);
        }
    }

    public void registerService(IFrameworkAccess iFrameworkAccess) {
        if (this.terminal.getTerminalID() == 0) {
            Hashtable hashtable = new Hashtable();
            iFrameworkAccess.getBundleCxt().registerService(new String[]{(class$de$audi$atip$hmi$view$IAnimationController == null ? (class$de$audi$atip$hmi$view$IAnimationController = AnimationController.class$("de.audi.atip.hmi.view.IAnimationController")) : class$de$audi$atip$hmi$view$IAnimationController).getName()}, (Object)this, (Dictionary)hashtable);
        }
    }

    public void stop() {
        this.connectedMainScreen = null;
        for (int i2 = 0; i2 < this.actualAnimations.length; ++i2) {
            this.actualAnimations[i2] = null;
        }
    }

    public AbstractAnimation getAnimation(int n) {
        AbstractAnimation abstractAnimation = this.createAnimation(n);
        abstractAnimation.setController(this);
        return abstractAnimation;
    }

    public void newMainScreenConnected(Screen screen) {
        if (!this.firstScreenWasShown) {
            this.firstScreenWasShown = true;
        }
        if (this.connectedMainScreen != null) {
            this.widgetRegistry.screenDisconnected(this.connectedMainScreen);
        }
        this.connectedMainScreen = (AbstractScreenWidget)screen;
        this.widgetRegistry.newScreenConnected(screen);
    }

    public IAnimation getIAnimation(int n) {
        return this.getAnimation(n);
    }

    protected abstract AbstractAnimation createAnimation(int var1);

    public abstract CombinedAnimation getCombinedAnimation(int var1);

    protected void logScreenChangeEngine(int[] nArray, Screen screen, Screen screen2, int[] nArray2, int[] nArray3) {
        if (!this.logAnimation.isDebug()) {
            return;
        }
        String string = this.getAnimationName(nArray2[0]);
        int n = AbstractWidget.hmiService.getDisplayManager().getCurrentContextID(this.getTerminal().getTerminalID());
        int n2 = screen.getID();
        String string2 = this.getScreenTypeName(((AbstractScreenWidget)screen).getScreenType());
        IDisplayControllerWidget iDisplayControllerWidget = ((AbstractScreenWidget)screen).getDisplayController();
        int n3 = screen2.getID();
        String string3 = this.getScreenTypeName(((AbstractScreenWidget)screen2).getScreenType());
        IDisplayControllerWidget iDisplayControllerWidget2 = ((AbstractScreenWidget)screen2).getDisplayController();
        String string4 = this.getAnimationName(nArray3[0]);
        String string5 = this.getAnimationName(nArray3[2]);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine calculated new animationtypes for terminal: %1", (long)this.terminal.getTerminalID());
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine current screen-leave-type: %1", (Object)string);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine modelled info bitfield current screen: %1", (long)nArray[0]);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine modelled info bitfield target screen: %1", (long)nArray[1]);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine currentContext: %1", (long)n);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine currentScreenID: %1", (long)n2);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine currentScreenType: %1", (Object)string2);
        if (iDisplayControllerWidget != null) {
            this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine currentScreen has displayController with contextID: %1", (long)iDisplayControllerWidget.getTargetContextID());
        } else {
            this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine currentScreen has no displayController, its context must be HMI_ONLY");
        }
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine targetScreenID: %1", (long)n3);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine targetScreenType: %1", (Object)string3);
        if (iDisplayControllerWidget2 != null) {
            this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine targetScreen has displayController with contextID: %1", (long)iDisplayControllerWidget2.getTargetContextID());
        } else {
            this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine targetScreen has no displayController, its context must be HMI_ONLY");
        }
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine ########computedAnimationType for currentScreen: %1", (Object)string4);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine computed additional info bitfield current screen: %1", (long)nArray3[1]);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine ########computedAnimationType for targetScreen: %1", (Object)string5);
        this.logAnimation.log(10000000, "AnimationController#logScreenChangeEngine computed additional info bitfield target screen: %1", (long)nArray3[3]);
    }

    protected String[] getScreenChangeEngineInfo(int[] nArray, Screen screen, Screen screen2, int[] nArray2, int[] nArray3) {
        String[] stringArray = new String[11];
        String string = this.getAnimationName(nArray2[0]);
        int n = AbstractWidget.hmiService.getDisplayManager().getCurrentContextID(this.getTerminal().getTerminalID());
        int n2 = screen.getID();
        String string2 = this.getScreenTypeName(((AbstractScreenWidget)screen).getScreenType());
        int n3 = screen2.getID();
        String string3 = this.getScreenTypeName(((AbstractScreenWidget)screen2).getScreenType());
        String string4 = this.getAnimationName(nArray3[0]);
        String string5 = this.getAnimationName(nArray3[2]);
        int n4 = 0;
        stringArray[n4++] = "Terminal, context, screen, type:";
        this.statisticsBuffer.clear();
        this.statisticsBuffer.append(this.terminal.getTerminalID());
        this.statisticsBuffer.append(", ");
        this.statisticsBuffer.append(n);
        this.statisticsBuffer.append(", ");
        this.statisticsBuffer.append(n2);
        this.statisticsBuffer.append(", ");
        this.statisticsBuffer.append(string2);
        stringArray[n4++] = this.statisticsBuffer.toString();
        stringArray[n4++] = "Target screen, type:";
        this.statisticsBuffer.clear();
        this.statisticsBuffer.append(n3);
        this.statisticsBuffer.append(", ");
        this.statisticsBuffer.append(string3);
        stringArray[n4++] = this.statisticsBuffer.toString();
        stringArray[n4++] = new StringBuffer().append("Leave type: ").append(string).toString();
        stringArray[n4++] = new StringBuffer().append("Current modelled bitfield ").append(Integer.toBinaryString(nArray[0])).toString();
        stringArray[n4++] = new StringBuffer().append("Target  modelled bitfield ").append(Integer.toBinaryString(nArray[1])).toString();
        stringArray[n4++] = new StringBuffer().append("Current computed anim type ").append(string4).toString();
        stringArray[n4++] = new StringBuffer().append("Current computed bitfield ").append(Integer.toBinaryString(nArray3[1])).toString();
        stringArray[n4++] = new StringBuffer().append("Target computed anim type ").append(string5).toString();
        stringArray[n4++] = new StringBuffer().append("Target computed bitfield ").append(Integer.toBinaryString(nArray3[3])).toString();
        return stringArray;
    }

    protected boolean checkParameters(int[] nArray, Screen screen, Screen screen2, int[] nArray2) {
        if (this.connectedMainScreen != null && screen == null) {
            this.logAnimation.log(10000000, "AnimationController#checkParameters currentScreen is null");
            return false;
        }
        if (screen2 == null) {
            this.logAnimation.log(10000000, "AnimationController#checkParameters targetScreen is null");
            return false;
        }
        if (nArray == null || nArray.length != 2) {
            this.logAnimation.log(10000000, "AnimationController#checkParameters modelledTypes == null or length != 2");
            return false;
        }
        if (nArray2[0] != 0 && !this.isScreenChangeType(nArray2[0])) {
            this.logAnimation.log(10000000, "AnimationController#checkParameters type for currentScreenLeaveAnimation is unknown");
            return false;
        }
        return true;
    }

    protected String getScreenTypeName(int n) {
        switch (n) {
            case 0: {
                return TEXT_HMI_ONLY;
            }
            case 1: {
                return TEXT_MAP;
            }
            case 4: {
                return TEXT_BROWSER;
            }
            case 2: {
                return TEXT_TV;
            }
            case 3: {
                return TEXT_VIDEO;
            }
            case 5: {
                return TEXT_REARVIEW;
            }
            case 8: {
                return TEXT_POPUP_BOUND;
            }
            case 6: {
                return TEXT_STANDBY;
            }
            case 9: {
                return TEXT_FULLSCREEN_SDS_POPUP;
            }
        }
        return TEXT_UNKNOWN_SCREENTYPE;
    }

    protected void initialize(int[] nArray, IScreenData iScreenData, IScreenData iScreenData2, int[] nArray2) {
        this.currentScreenData = iScreenData;
        this.targetScreenData = iScreenData2;
        this.currentScreen = iScreenData.getScreen();
        this.targetScreen = iScreenData2.getScreen();
        this.modelledAnimationInfo = nArray;
        this.logAnimation.log(10000000, "AnimationController#initialize currentAnimationInfo Exit: %1", (long)nArray2[0]);
        System.arraycopy((Object)nArray2, 0, (Object)this.currentAnimationInfo, 0, nArray2.length);
        System.arraycopy((Object)COMPUTED_ANIMATION_INFO_NO_ANIMATION, 0, (Object)this.computedAnimationInfo, 0, COMPUTED_ANIMATION_INFO_NO_ANIMATION.length);
        if (this.currentScreen != null) {
            this.currentScreenType = ((AbstractScreenWidget)this.currentScreen).getScreenType();
        }
        if (this.targetScreen != null) {
            AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.targetScreen;
            this.targetScreenType = abstractScreenWidget.getScreenType();
            this.targetContextID = 0;
            IDisplayControllerWidget iDisplayControllerWidget = abstractScreenWidget.getDisplayController();
            if (iDisplayControllerWidget != null) {
                iDisplayControllerWidget.setTerminal(this.getTerminal());
                this.targetContextID = iDisplayControllerWidget.getTargetContextID();
            }
        }
        this.currentContextID = AbstractWidget.hmiService.getDisplayManager().getCurrentContextID(this.getTerminal().getTerminalID());
        if (this.currentContextID == -1) {
            this.currentContextID = 0;
        }
        if (this.currentContextID >= 79) {
            this.currentContextID -= 79;
        }
    }

    public Screen getConnectedMainScreen() {
        return this.connectedMainScreen;
    }

    public WidgetRegistry getWidgetRegistry() {
        return this.widgetRegistry;
    }

    public void setWidgetRegistry(WidgetRegistry widgetRegistry) {
        this.widgetRegistry = widgetRegistry;
    }

    public boolean isFirstScreenShown() {
        return this.firstScreenWasShown;
    }

    public AbstractWidgetController getSportskinSmallStageMapGrid() {
        return this.sportskinSmallStageMapGrid;
    }

    public void setSportskinSmallStageMapGrid(AbstractWidgetController abstractWidgetController) {
        this.sportskinSmallStageMapGrid = abstractWidgetController;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

