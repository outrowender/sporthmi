/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.TouchPadEventListener;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IWidgetDiagnosis;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractWidget
implements WidgetConstants,
KeyListener,
TouchPadEventListener,
HMIView,
IWidgetDiagnosis,
IWidgetLogChannel {
    public static final int STATE_INITIAL;
    public static IFrameworkAccess framework;
    public static IHMIServiceEvo hmiService;
    public static SDSService sdsService;
    protected static TTSSessionBasedService ttsService;
    public static WidgetsActivator widgetsActivator;
    protected AbstractScreenFactory screenFactory = null;
    protected AbstractWidget parent;
    protected int[] bitmapIndices = null;
    protected int[] conditionIDs = null;
    protected int[] colorIndices = null;
    protected float opacity = 1.0f;
    protected float viewSizeOpacity = 1.0f;
    protected boolean hasChainedChildren = false;
    protected int chainedActions = 0;
    protected int chainedTriggers = 0;
    protected int event = 0;
    protected int height = 0;
    protected int modelID = -1;
    public static final int UNKNOWN;
    public static final int CLOSED_OPTION_DRAWER;
    public static final int OPEN_OPTION_DRAWER;
    private int partOfOptionDrawer = 0;
    protected int role = 0;
    protected int widgetState = 615;
    protected int width = 0;
    protected int x = 0;
    protected int y = 0;
    protected HMITerminalImpl terminal;
    protected int depth;
    public static final int FOCUS_LOST;
    public static final int FOCUS_GAINED;
    protected InitializationContext initContext;

    public void setActive(boolean bl) {
        this.widgetState = bl ? this.widgetState | 0x20 : this.widgetState & 0xFFFFFFDF;
    }

    @Override
    public boolean isActive() {
        return (this.widgetState & 0x20) != 0;
    }

    public void setBitmaps(int[] nArray) {
        this.bitmapIndices = nArray;
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public void setChained(boolean bl) {
        this.role = bl ? this.role | 0x10 : this.role & 0xFFFFFFEF;
    }

    public boolean isChained() {
        return (this.role & 0x10) != 0;
    }

    public void setChainedAction(int n, int n2) {
        this.chainedTriggers = n;
        this.chainedActions = n2;
        this.setChained(true);
    }

    public void setChainedChildren(boolean bl) {
        this.hasChainedChildren = bl;
    }

    public void setInvalid(boolean bl) {
        if (this.isInvalid() == bl) {
            return;
        }
        int n = this.widgetState = bl ? this.widgetState | 0x40 : this.widgetState & 0xFFFFFFBF;
        if (bl && this.parent != null) {
            this.parent.setInvalid(true);
        }
    }

    public boolean isInvalid() {
        return (this.widgetState & 0x40) != 0;
    }

    public void setEnabled(boolean bl) {
        int n = this.widgetState = bl ? this.widgetState | 4 : this.widgetState & 0xFFFFFFFB;
        if (this.hasChainedChildren) {
            this.notifyChained(1, this.isEnabled());
        }
    }

    @Override
    public boolean isEnabled() {
        return (this.widgetState & 4) != 0;
    }

    public void setFocused(boolean bl) {
        this.widgetState = bl ? this.widgetState | 0x80 : this.widgetState & 0xFFFFFF7F;
    }

    @Override
    public boolean isFocused() {
        return (this.widgetState & 0x80) != 0;
    }

    public void setEvent(int n) {
        this.event = n;
    }

    public static void setHMIService(IHMIServiceEvo iHMIServiceEvo) {
        hmiService = iHMIServiceEvo;
    }

    public static void setFrameworkAccess(IFrameworkAccess iFrameworkAccess) {
        framework = iFrameworkAccess;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHighlighted(boolean bl) {
        int n = this.widgetState = bl ? this.widgetState | 8 : this.widgetState & 0xFFFFFFF7;
        if (this.hasChainedChildren) {
            this.notifyChained(2, this.isHighlighted());
        }
    }

    @Override
    public boolean isHighlighted() {
        return (this.widgetState & 8) != 0;
    }

    public void setFunctional(boolean bl) {
        this.widgetState = bl ? this.widgetState | 0x100 : this.widgetState & 0xFFFFFEFF;
    }

    @Override
    public boolean isFunctional() {
        return (this.widgetState & 0x100) != 0;
    }

    public static void setSDSService(SDSService sDSService) {
        sdsService = sDSService;
    }

    public static void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        logChannel.log(-2137614336, "AbstractWidget#setTTSService ttsService: %1", (Object)ttsService);
        ttsService = tTSSessionBasedService;
    }

    public int getCurrentVisState() {
        int n = 2;
        if ((this.widgetState & 4) != 0 && (this.widgetState & 0x20) != 0) {
            n = (this.widgetState & 0x80) != 0 ? 3 : ((this.widgetState & 8) != 0 ? 3 : 1);
        }
        return n;
    }

    public boolean isInstance(int n) {
        int n2 = this.role & n;
        return n2 == n;
    }

    public void setModelID(int n) {
        this.modelID = n;
    }

    @Override
    public int getModelID() {
        return this.modelID;
    }

    public void setOnScreen(boolean bl) {
        this.widgetState = bl ? this.widgetState | 2 : this.widgetState & 0xFFFFFFFD;
    }

    public boolean isOnScreen() {
        return (this.widgetState & 2) != 0;
    }

    public void setVisibleOnCurrentStage(boolean bl) {
        this.widgetState = bl ? this.widgetState | 0x200 : this.widgetState & 0xFFFFFDFF;
    }

    public boolean isVisibleOnCurrentStage() {
        return (this.widgetState & 0x200) != 0;
    }

    public boolean shouldRender() {
        return this.hasState(515);
    }

    public void setColorIndices(int[] nArray) {
        this.colorIndices = nArray;
    }

    @Override
    public int[] getColorIndices() {
        return this.colorIndices;
    }

    public void setNightColors(int[][] nArray) {
    }

    public void setParent(AbstractWidget abstractWidget) {
        this.parent = abstractWidget;
    }

    public void removeParent() {
        this.parent = null;
    }

    @Override
    public void setStatus(int n) {
    }

    public void setTransparent(boolean bl) {
        this.widgetState = bl ? this.widgetState | 0x10 : this.widgetState & 0xFFFFFFEF;
    }

    public boolean isTransparent() {
        return (this.widgetState & 0x10) != 0;
    }

    public void setVisible(boolean bl) {
        int n = this.widgetState = bl ? this.widgetState | 1 : this.widgetState & 0xFFFFFFFE;
        if (this.hasChainedChildren) {
            this.notifyChained(4, this.isVisible());
        }
    }

    @Override
    public boolean isVisible() {
        return (this.widgetState & 1) != 0;
    }

    public boolean isVisibleInHierarchy() {
        if (!this.isVisible()) {
            return false;
        }
        return this.parent == null || this.parent.isVisibleInHierarchy();
    }

    public void setWidth(int n) {
        this.width = n;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public void setX(int n) {
        this.x = n;
    }

    @Override
    public int getX() {
        return this.x;
    }

    public void setY(int n) {
        this.y = n;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public abstract void add(AbstractWidget abstractWidget) {
    }

    public void setOpacity(float f2) {
        if (this.opacity != f2) {
            this.setCompositesDirty(true);
            this.opacity = f2;
        }
    }

    public void setViewSizeOpacity(float f2) {
        this.setOpacity(f2);
    }

    public float getViewSizeOpacity() {
        return this.viewSizeOpacity;
    }

    public void connected(InitializationContext initializationContext) {
        this.initConnect(initializationContext);
        this.initializeWidget();
        this.propagateConnected(initializationContext);
    }

    protected void initializeWidget() {
    }

    protected void initConnect(InitializationContext initializationContext) {
        this.initContext = initializationContext;
        this.opacity = 1.0f;
        this.viewSizeOpacity = 1.0f;
        this.terminal = initializationContext.getTerminal();
        this.screenFactory = initializationContext.getScreenFactory();
    }

    public void disconnecting() {
        this.propagateDisconnecting();
    }

    public void predisconnecting() {
        this.propagatePreDisconnecting();
    }

    public final void focusChanged(int n, int n2, int n3) {
        this.propagateFocusChanged(n, n2, n3);
        this.handleFocusChanged(n, n2, n3);
    }

    protected void handleFocusChanged(int n, int n2, int n3) {
    }

    protected void propagateFocusChanged(int n, int n2, int n3) {
        List list = this.getChildren();
        if (list != null) {
            AbstractWidget abstractWidget = null;
            int n4 = list.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                abstractWidget = (AbstractWidget)list.get(i2);
                abstractWidget.focusChanged(n, n2, n3);
            }
        }
    }

    public boolean hasBitmap(int n) {
        return this.bitmapIndices != null && n >= 0 && n < this.bitmapIndices.length && this.bitmapIndices[n] != -1;
    }

    public boolean hasState(int n) {
        int n2 = this.widgetState & n;
        return n2 == n;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !keyEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).keyPressed(keyEvent);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !keyEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).keyReleased(keyEvent);
            }
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !wheelButtonEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).keyTurned(wheelButtonEvent);
            }
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !joystickEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).keyMoved(joystickEvent);
            }
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadPressed(touchEvent);
            }
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadReleased(touchEvent);
            }
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadPositionMoved(touchEvent);
            }
        }
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadCharactersRecognized(touchEvent);
            }
        }
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadPalmRecognized(touchEvent);
            }
        }
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadApproached(touchEvent);
            }
        }
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n && !touchEvent.isConsumed(); ++i2) {
                ((AbstractWidget)list.get(i2)).touchPadAbandoned(touchEvent);
            }
        }
    }

    public abstract void render(RedrawContext redrawContext) {
    }

    public abstract void renderIfDirty(RedrawContext redrawContext) {
    }

    public void managePaint(RedrawContext redrawContext) {
        if (this.isInvalid()) {
            int[] nArray = null;
            if (this.colorIndices != null) {
                nArray = redrawContext.setColorIndices(this.colorIndices);
            }
            this.renderIfDirty(redrawContext);
            if (this.shouldPropagatePaint()) {
                this.propagatePaint(redrawContext);
            }
            if (nArray != this.colorIndices) {
                redrawContext.setColorIndices(nArray);
            }
        }
        this.afterPaint(redrawContext);
    }

    protected boolean shouldPropagatePaint() {
        return this.shouldRender();
    }

    protected void propagatePaint(RedrawContext redrawContext) {
        List list = this.getChildren();
        if (list != null) {
            AbstractWidget abstractWidget = null;
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                abstractWidget = (AbstractWidget)list.get(i2);
                if (!abstractWidget.shouldRender() || !abstractWidget.isInvalid()) continue;
                abstractWidget.managePaint(redrawContext);
            }
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    public boolean canProcessModelGroupEvent() {
        return false;
    }

    public void processTextReplacementUpdateEvent() {
    }

    public abstract void remove(AbstractWidget abstractWidget) {
    }

    public void triggerRepaint() {
        if (this.parent != null) {
            this.parent.triggerRepaint();
        }
    }

    protected void fireSMEvent(int n, int n2) {
        if (hmiService != null) {
            hmiService.fireSMEvent(n, n2);
        }
    }

    protected void notifyChained(int n, boolean bl) {
        List list = this.getChildren();
        if (list != null) {
            AbstractWidget abstractWidget = null;
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                abstractWidget = (AbstractWidget)list.get(i2);
                if (!abstractWidget.isChained()) continue;
                abstractWidget.triggerChained(n, bl);
            }
        }
    }

    protected void propagateConnected(InitializationContext initializationContext) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
                if (abstractWidget.isInstance(128)) {
                    abstractWidget.setParent(this);
                }
                if (abstractWidget.isChained()) {
                    this.setChainedChildren(true);
                }
                this.notifyChainedChild(abstractWidget);
                abstractWidget.connected(initializationContext);
            }
        }
    }

    protected void notifyChainedChild(AbstractWidget abstractWidget) {
        abstractWidget.triggerChained(1, this.isEnabled());
        abstractWidget.triggerChained(2, this.isHighlighted());
        abstractWidget.triggerChained(4, this.isVisible());
    }

    protected void propagateDisconnecting() {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((AbstractWidget)list.get(i2)).disconnecting();
            }
        }
    }

    protected void propagatePreDisconnecting() {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((AbstractWidget)list.get(i2)).predisconnecting();
            }
        }
    }

    protected void afterPaint(RedrawContext redrawContext) {
    }

    private void executeChainedAction(int n, boolean bl) {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < 4 && (n >>= 1) != 0; ++n2) {
            n3 += 3;
        }
        n2 = this.chainedActions >> n3;
        if (((n2 &= 7) & 1) != 0) {
            this.setEnabled(bl);
        }
        if ((n2 & 2) != 0) {
            this.setHighlighted(bl);
        }
        if ((n2 & 4) != 0) {
            this.setVisible(bl);
        }
    }

    public void triggerChained(int n, boolean bl) {
        int n2 = n & this.chainedTriggers;
        if (n2 != 0) {
            switch (n2) {
                case 1: {
                    this.executeChainedAction(n2, bl);
                    break;
                }
                case 2: {
                    this.executeChainedAction(n2, bl);
                    break;
                }
                case 4: {
                    this.executeChainedAction(n2, bl);
                    break;
                }
                case 8: {
                    this.executeChainedAction(n2, bl);
                    break;
                }
                default: {
                    logChannel.log(10000, "AbstractWidget#triggerChainedAction There's no chained action specified for trigger %1", (long)n2);
                }
            }
        }
    }

    protected static int getHexOpacityFromFloat(float f2) {
        return (int)(f2 * 32579);
    }

    public int getRole() {
        return this.role;
    }

    @Override
    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int n) {
        this.depth = n;
    }

    public void setNight(boolean bl) {
    }

    public boolean isNight() {
        return false;
    }

    @Override
    public List getDiagnosisChildren() {
        return this.getChildren();
    }

    public abstract List getChildren() {
    }

    public void setTerminal(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    @Override
    public int[] getBitmapIndices() {
        if (this.bitmapIndices == null) {
            return null;
        }
        int[] nArray = new int[this.bitmapIndices.length];
        System.arraycopy((Object)this.bitmapIndices, 0, (Object)nArray, 0, this.bitmapIndices.length);
        return nArray;
    }

    @Override
    public String getDiagnosisText() {
        return null;
    }

    @Override
    public String getInternalInfo() {
        return null;
    }

    @Override
    public String getClassName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            return string.substring(n + 1);
        }
        return string;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public float getRenderOpacity() {
        return this.getOpacity() * this.getViewSizeOpacity();
    }

    public void unitsChanged(UnitChangedEvent unitChangedEvent) {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((AbstractWidget)list.get(i2)).unitsChanged(unitChangedEvent);
            }
        }
    }

    public InitializationContext getInitContext() {
        return this.initContext;
    }

    public void setInitContext(InitializationContext initializationContext) {
        this.initContext = initializationContext;
    }

    public void bitmapLoaded(AsyncBitmapEvent asyncBitmapEvent) {
        List list = this.getChildren();
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
                abstractWidget.bitmapLoaded(asyncBitmapEvent);
            }
        }
    }

    protected void forceRepaintInPartialPopup() {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((AbstractWidget)list.get(i2)).forceRepaintInPartialPopup();
            }
        }
    }

    public AbstractWidget getParent() {
        return this.parent;
    }

    public HMITerminal getTerminal() {
        return this.terminal;
    }

    public void setCompositesDirty(boolean bl) {
        this.setInvalid(bl);
    }

    public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
        this.screenFactory = abstractScreenFactory;
    }

    public AbstractScreenFactory getScreenFactory() {
        return this.screenFactory;
    }

    public int getEvent() {
        return this.event;
    }

    public IPresetPopupData getPresetPopupData() {
        List list = this.getChildren();
        if (list != null) {
            int n = list.size();
            IPresetPopupData iPresetPopupData = null;
            for (int i2 = 0; i2 < n && (iPresetPopupData = ((AbstractWidget)list.get(i2)).getPresetPopupData()) == null; ++i2) {
            }
            return iPresetPopupData;
        }
        return null;
    }

    public static boolean isAsia() {
        int n = AbstractWidget.getRegionCode();
        boolean bl = n == 2 || n == 3 || n == 4 || n == 5;
        return bl;
    }

    public static boolean isKr() {
        int n = AbstractWidget.getRegionCode();
        return n == 4;
    }

    public static boolean isCN() {
        int n = AbstractWidget.getRegionCode();
        return n == 2;
    }

    public static boolean isTW() {
        int n = AbstractWidget.getRegionCode();
        return n == 5;
    }

    public static boolean isArabia() {
        if (hmiService == null) {
            logChannel.log(10000, "AbstractWidget#isArabia hmiService is null, returning false");
            return false;
        }
        SysConstModel sysConstModel = (SysConstModel)hmiService.getModel(4306);
        if (sysConstModel != null) {
            return sysConstModel.getValue() == 1;
        }
        logChannel.log(10000, "AbstractWidget#isArabia cannot get model ICoreSysConfig.IS_ARABIC_LANGUAGE_AVAILABLE, returning false");
        return false;
    }

    public boolean isLTR() {
        boolean bl = true;
        if (this.terminal != null && this.terminal.getFramework() != null && this.terminal.getFramework().getLanguageMgr() != null) {
            bl = this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
        }
        return bl;
    }

    public static boolean isJp() {
        int n = AbstractWidget.getRegionCode();
        return n == 3;
    }

    public static int getRegionCode() {
        if (hmiService == null) {
            logChannel.log(10000, "AbstractWidget#getRegionCode hmiService is null, returning false");
            return -1;
        }
        HMIModel hMIModel = hmiService.getModel(442);
        if (hMIModel == null) {
            logChannel.log(10000, "AbstractWidget#getRegionCode cannot get model ICoreSysConfig.HU_REGION, returning false");
            return -1;
        }
        return ((SysConstModel)hMIModel).getValue();
    }

    public static boolean isRightHandDrive() {
        if (hmiService == null) {
            logChannel.log(10000, "AbstractWidget#isRightHandDrive hmiService is null, returning false");
            return false;
        }
        HMIModel hMIModel = hmiService.getModel(464);
        if (hMIModel == null) {
            logChannel.log(10000, "AbstractWidget#isRightHandDrive cannot get model ICoreSysConfig.STEERING_WHEEL, returning false");
            return false;
        }
        return ((SysConstModel)hMIModel).getValue() == 1;
    }

    public boolean isOptionDrawerDirection(int n) {
        if (this.isLTR()) {
            return n == 4;
        }
        return n == 8;
    }

    public boolean isSelectionDrawerDirection(int n) {
        if (this.isLTR()) {
            return n == 8;
        }
        return n == 4;
    }

    public boolean isTurnForwardDirection(WheelButtonEvent wheelButtonEvent) {
        if (wheelButtonEvent.isVerticalDirection()) {
            return wheelButtonEvent.getDirection() == 0;
        }
        return this.terminal.getLayout().getRotationalDirection(wheelButtonEvent.getDirection()) == (this.isLTR() ? 1 : 2);
    }

    public boolean isTurnBackwardDirection(WheelButtonEvent wheelButtonEvent) {
        if (wheelButtonEvent.isVerticalDirection()) {
            return wheelButtonEvent.getDirection() == 1;
        }
        return this.terminal.getLayout().getRotationalDirection(wheelButtonEvent.getDirection()) == (this.isLTR() ? 2 : 1);
    }

    public int getPartOfOptionDrawer() {
        return this.partOfOptionDrawer;
    }

    public void setPartOfOptionDrawer(int n) {
        this.partOfOptionDrawer = n;
    }

    public static boolean isScreenResolution400() {
        return framework.getScreenRes() == 0;
    }

    public static boolean isScreenResolution800() {
        return framework.getScreenRes() == 1;
    }

    public static boolean isScreenResolution1024() {
        return framework.getScreenRes() == 2;
    }

    public static boolean isScreenResolution1440() {
        return framework.getScreenRes() == 4;
    }

    public static boolean isVariantHigh() {
        return framework.getSysConst(523) == 1;
    }

    public static boolean isVariantStd() {
        return framework.getSysConst(523) == 0;
    }

    static {
        framework = null;
        hmiService = null;
        sdsService = null;
        ttsService = null;
    }
}

