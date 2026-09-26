/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.AbstractWindow$NativeWindowUpdater;
import de.audi.atip.hmi.AbstractWindow$RepaintEvent;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.LanguageAware;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.CombiInfoEvent;
import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.EnablePartialPopupsEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.HidePartialPopupEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.LanguageChangedEvent;
import de.audi.atip.hmi.event.MergeKZBAsyncEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.PersonalPoiDatabaseUpdateEvent;
import de.audi.atip.hmi.event.RemoveScreenEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.hmi.event.ScreenShotEvent;
import de.audi.atip.hmi.event.ShowPartialPopupEvent;
import de.audi.atip.hmi.event.ShowScreenEvent;
import de.audi.atip.hmi.event.StateMachineEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.event.VRAMEvent;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IStatistics;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class AbstractWindow
implements IRootWindow {
    private static final String PRAEFIX_SCREEN;
    private static final String PRAEFIX_POPIN;
    protected static final boolean ENABLE_MULTI_OS_SUPPORT;
    private static final boolean BENCHMARK;
    protected final LogChannel logHMIServiceHMI;
    protected final LogChannel logDiashow;
    protected final LogChannel logATIPEvent;
    protected final LogChannel logRepaintCause;
    protected final int terminalID;
    protected int width = 640;
    protected int height = 480;
    protected int x;
    protected int y;
    private final Vector hardkeyListeners;
    private IFrameworkAccess framework;
    protected Thread nativeWindowUpdaterThread;
    protected Screen currentScreen;
    private int[] pixelBuffer;

    protected AbstractWindow(int n, IFrameworkAccess iFrameworkAccess) {
        if (System.getProperty("os.name").indexOf("QNX") >= 0) {
            this.x = 0;
            this.y = 15;
            this.width = 800;
            this.height = 450;
        } else {
            this.x = 50;
            this.y = 50;
            this.width = 800;
            this.height = 450;
        }
        this.framework = iFrameworkAccess;
        this.terminalID = n;
        this.logHMIServiceHMI = iFrameworkAccess.getLogChannel("Fw.HMIService.HMI");
        this.logDiashow = iFrameworkAccess.getLogChannel("Ext.Diashow");
        this.logATIPEvent = iFrameworkAccess.getLogChannel("Fw.ATIPEvent");
        this.logRepaintCause = iFrameworkAccess.getLogChannel("Fw.Widgets.RepaintCause");
        this.hardkeyListeners = new Vector();
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    protected boolean isRepaintTerminal() {
        return this.terminalID == 0 || this.terminalID == 2 || this.terminalID == 3 || this.terminalID == 4;
    }

    protected void startNativeWindowUpdater(int n) {
        if (this.isRepaintTerminal()) {
            this.nativeWindowUpdaterThread = new Thread(new AbstractWindow$NativeWindowUpdater(this, n));
            this.nativeWindowUpdaterThread.start();
            AbstractWindow$NativeWindowUpdater.startUpdating();
        }
    }

    protected abstract void paintGUI() {
    }

    protected HMIService getHMIService() {
        return this.framework.getHMIService();
    }

    @Override
    public void addHardkeyListener(KeyListener keyListener) {
        this.hardkeyListeners.addElement(keyListener);
    }

    @Override
    public void add(IScreenData iScreenData, Screen screen) {
        this.currentScreen = screen;
    }

    @Override
    public void remove(Screen screen) {
        this.currentScreen = null;
    }

    @Override
    public Screen getCurrentScreen() {
        if (this.terminalID == 1) {
            return this.getFwHMI().getCurrentlyActiveCombiScreen();
        }
        return this.currentScreen;
    }

    private Screen[] getCurrentlyActiveCombiScreens() {
        if (this.terminalID == 1) {
            return this.getFwHMI().getCurrentlyActiveCombiScreens();
        }
        this.logHMIServiceHMI.log(10000, "ERR: RootWindow.getCurrentlyActiveCombiScreens(): not instanceCombi");
        return null;
    }

    protected void processSDSEventOnScreens(ATIPEvent aTIPEvent) {
        Screen screen;
        if (this.currentScreen != null) {
            this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to current screen", (Object)aTIPEvent);
            this.currentScreen.processSDSEvent((SDSEvent)aTIPEvent);
        }
        if (this.terminalID == 1 && this.framework.isShowDDP2Combi() && (screen = this.getCurrentScreen()) != null) {
            screen.processSDSEvent((SDSEvent)aTIPEvent);
        }
    }

    protected void processAsyncBitmapEventOnScreens(ATIPEvent aTIPEvent) {
        if (this.currentScreen != null) {
            this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to current screen", (Object)aTIPEvent);
            this.currentScreen.bitmapLoaded((AsyncBitmapEvent)aTIPEvent);
        }
    }

    protected void processEventImpl(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof ModelUpdateEvent) {
            this.processModelUpdateEvent((ModelUpdateEvent)aTIPEvent);
        } else if (aTIPEvent instanceof StateMachineEvent) {
            try {
                this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to smInterpreter", (Object)aTIPEvent);
                this.getFramework().getSMInterpreter().processEvent((StateMachineEvent)aTIPEvent);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else if (aTIPEvent instanceof SDSEvent) {
            this.processSDSEventOnScreens(aTIPEvent);
        } else if (aTIPEvent instanceof ShowScreenEvent) {
            if (((ShowScreenEvent)aTIPEvent).isPopin()) {
                this.getFwHMI().showPartialPopup(this.getTerminalID(), ((ShowScreenEvent)aTIPEvent).getPopinID());
            } else {
                Object object;
                if (((ShowScreenEvent)aTIPEvent).takeScreenshot()) {
                    object = ((ShowScreenEvent)aTIPEvent).getScreenShotPath();
                    boolean bl = ((ShowScreenEvent)aTIPEvent).saveAsZip();
                    this.saveScreenShot(this.getCurrentScreen().getID(), (String)object, false, bl);
                }
                object = new ScreenData(((ShowScreenEvent)aTIPEvent).getScreenId(), true, false, new int[]{((ShowScreenEvent)aTIPEvent).getScreenId()}, false, null, null, null, -1L, -1L, 0, ((ShowScreenEvent)aTIPEvent).getColorScheme(), 0, null);
                this.getHMITerminalContext(((ShowScreenEvent)aTIPEvent).getTerminalId()).getScreenManager().showScreen((IScreenData)object);
            }
        } else if (aTIPEvent instanceof RemoveScreenEvent) {
            if (((RemoveScreenEvent)aTIPEvent).isPopin()) {
                if (((RemoveScreenEvent)aTIPEvent).takeScreenshot()) {
                    String string = ((RemoveScreenEvent)aTIPEvent).getScreenShotPath();
                    boolean bl = ((RemoveScreenEvent)aTIPEvent).saveAsZip();
                    this.saveScreenShot(((RemoveScreenEvent)aTIPEvent).getPopinID(), string, true, bl);
                }
                this.getFwHMI().removePartialPopup(this.getTerminalID(), ((RemoveScreenEvent)aTIPEvent).getPopinID());
            }
        } else if (aTIPEvent instanceof ShowPartialPopupEvent) {
            this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getPartialPopupManager().showPopupAndRepaintScreen(((ShowPartialPopupEvent)aTIPEvent).getPartialPopupID());
        } else if (aTIPEvent instanceof HidePartialPopupEvent) {
            this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getPartialPopupManager().hidePopupAndRepaintScreen(((HidePartialPopupEvent)aTIPEvent).getPartialPopupID());
        } else if (aTIPEvent instanceof ScreenShotEvent) {
            IPartialPopupManager iPartialPopupManager;
            ScreenShotEvent screenShotEvent = (ScreenShotEvent)aTIPEvent;
            String string = screenShotEvent.getScreenShotPath();
            boolean bl = this.getFwHMI().isPartialPopupVisibleInSlot(this.terminalID, 1) || this.getFwHMI().isPartialPopupVisibleInSlot(this.terminalID, 2);
            boolean bl2 = screenShotEvent.saveWithCompression();
            boolean bl3 = screenShotEvent.saveToClipboard();
            String string2 = screenShotEvent.getFileName();
            int n = 0;
            n = bl ? ((iPartialPopupManager = this.getHMITerminalContext(this.getTerminalID()).getPartialPopupManager()).hasVisiblePopupInSlot(1) ? ((Screen)((Object)iPartialPopupManager.getCurrentVisiblePopup(1))).getID() : ((Screen)((Object)iPartialPopupManager.getCurrentVisiblePopup(2))).getID()) : this.getCurrentScreen().getID();
            this.saveScreenShot(n, string, bl, bl2, bl3, string2);
        } else if (!(aTIPEvent instanceof CombiInfoEvent)) {
            if (aTIPEvent instanceof AsyncBitmapEvent) {
                this.processAsyncBitmapEventOnScreens(aTIPEvent);
            } else if (aTIPEvent instanceof EALMergeEvent) {
                IGUIManager iGUIManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getGUIManager();
                iGUIManager.processEvent((EALMergeEvent)aTIPEvent);
            } else if (aTIPEvent instanceof MergeKZBAsyncEvent) {
                IGUIManager iGUIManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getGUIManager();
                iGUIManager.processEvent((MergeKZBAsyncEvent)aTIPEvent);
            } else if (aTIPEvent instanceof PersonalPoiDatabaseUpdateEvent) {
                IGUIManager iGUIManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getGUIManager();
                iGUIManager.processEvent((PersonalPoiDatabaseUpdateEvent)aTIPEvent);
            }
        }
    }

    protected void processModelUpdateEventOnScreens(ModelUpdateEvent modelUpdateEvent) {
        if (this.currentScreen != null) {
            this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to current screen", (Object)modelUpdateEvent);
            this.currentScreen.processModelUpdateEvent(modelUpdateEvent);
        }
    }

    protected void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.getTerminalID() == 1) {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: CLUSTER - Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else if (modelUpdateEvent.getTerminalID() == -1 || modelUpdateEvent.getTerminalID() == this.getTerminalID()) {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: Processing allowed for ModelUpdateEvent with terminalID == %2.", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
        } else {
            this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: ModelUpdateEvent with terminalID == %2 ignored", (long)this.getTerminalID(), (long)modelUpdateEvent.getTerminalID());
            return;
        }
        if (this.getTerminalID() == 1 && this.framework.isShowDDP2Combi()) {
            Screen[] screenArray = this.getCurrentlyActiveCombiScreens();
            if (screenArray != null) {
                for (int i2 = 0; i2 < screenArray.length; ++i2) {
                    if (screenArray[i2] == null) continue;
                    screenArray[i2].processModelUpdateEvent(modelUpdateEvent);
                }
            } else {
                this.logATIPEvent.log(1078071040, "IRootWindowImpl[%1]#processEventImpl: No currently active combi screen => event ignored", (long)this.getTerminalID());
            }
        } else {
            this.processModelUpdateEventOnScreens(modelUpdateEvent);
        }
        this.logATIPEvent.log(-2137614336, "RootWindow: sending %1 to smInterpreter", (Object)modelUpdateEvent);
        this.getFramework().getSMInterpreter().processUpdate(modelUpdateEvent);
    }

    protected void processUnitsChangedEventOnScreens(UnitChangedEvent unitChangedEvent) {
        Screen screen = this.getCurrentScreen();
        if (screen != null) {
            screen.unitsChanged(unitChangedEvent);
            unitChangedEvent.setConsumed(false);
        }
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        this.logATIPEvent.log(-2137614336, "RootWindow.processEvent: event = %1", (Object)aTIPEvent);
        if (aTIPEvent.getID() == 10801) {
            this.logRepaintCause.log(-2137614336, "AbstractWindow#processEvent: update native window");
            this.updateNativeWindow();
            return;
        }
        if (!(aTIPEvent instanceof KeyEvent) && !(aTIPEvent instanceof TouchEvent)) {
            if (aTIPEvent instanceof EnablePartialPopupsEvent) {
                IPartialPopupManager iPartialPopupManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getPartialPopupManager();
                if (iPartialPopupManager != null) {
                    iPartialPopupManager.setPartialPopupsEnabled(((EnablePartialPopupsEvent)aTIPEvent).getStatus());
                }
            } else if (aTIPEvent instanceof LanguageChangedEvent) {
                HMITerminal hMITerminal = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID());
                if (hMITerminal instanceof LanguageAware) {
                    ((LanguageAware)((Object)hMITerminal)).languageChanged((LanguageChangedEvent)aTIPEvent);
                }
            } else if (aTIPEvent instanceof UnitChangedEvent) {
                this.processUnitsChangedEventOnScreens((UnitChangedEvent)aTIPEvent);
            } else if (aTIPEvent instanceof ScreenDebugInfoEvent) {
                IStatistics iStatistics = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getStatistics();
                if (iStatistics != null) {
                    String[] stringArray = ((ScreenDebugInfoEvent)aTIPEvent).getDebugInfo();
                    int n = ((ScreenDebugInfoEvent)aTIPEvent).getInfoType();
                    iStatistics.showStatistics(n, stringArray, true);
                    aTIPEvent.setConsumed(false);
                }
            } else if (aTIPEvent instanceof VRAMEvent) {
                IGUIManager iGUIManager = this.getFramework().getHMITerminalRegistry().getTerminal(this.getTerminalID()).getGUIManager();
                this.framework.getLogChannel("Ext.JavaHeap").log(-1601830656, "Video memory used: %1", (Object)iGUIManager.getVRAMStatus());
                this.framework.getLogChannel("Ext.JavaHeap").log(-1601830656, "RAM memory used: %1", (Object)iGUIManager.getRAMStatus());
            } else {
                this.processEventImpl(aTIPEvent);
            }
        }
    }

    protected abstract void writeBMPPixelData(int[] nArray, int n, int n2, OutputStream outputStream) {
    }

    protected void updateNativeWindow() {
        HMITerminal hMITerminal = this.getFramework().getHMITerminalRegistry().getTerminal(this.terminalID);
        if (hMITerminal == null) {
            return;
        }
        if (this.currentScreen != null) {
            IGUIManager iGUIManager = hMITerminal.getGUIManager();
            if (this.terminalID != 1) {
                this.currentScreen.paint();
            }
            iGUIManager.draw();
            iGUIManager.swapBuffers();
        }
    }

    private void saveScreenShot(int n, String string, boolean bl, boolean bl2) {
        this.saveScreenShot(n, string, bl, bl2, false, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void saveScreenShot(int n, String string, boolean bl, boolean bl2, boolean bl3, String string2) {
        long l = this.getFramework().getMonotonicTime();
        IGUIManager iGUIManager = this.getFramework().getHMITerminalRegistry().getTerminal(0).getGUIManager();
        if (string == null) {
            string = System.getProperty("os.name").indexOf("QNX") >= 0 ? "/HBextended/" : "c:\\temp\\";
        }
        iGUIManager.draw();
        iGUIManager.swapBuffers();
        if (this.pixelBuffer == null) {
            if (this.framework.getScreenRes() == 0) {
                this.pixelBuffer = new int[0x770100];
            } else if (this.framework.getScreenRes() == 1) {
                this.pixelBuffer = new int[14419200];
            } else if (this.framework.getScreenRes() == 2) {
                this.pixelBuffer = new int[0x800700];
            } else if (this.framework.getScreenRes() == 4) {
                this.pixelBuffer = this.framework.isEvoHighMMIKombi() ? new int[-1058534656] : new int[-2132997376];
            } else {
                this.logDiashow.log(10000, "IRootWindowImpl#saveScreenshot() - screen res not supported");
                return;
            }
        }
        iGUIManager.readPixels(this.pixelBuffer);
        if (bl3) {
            this.saveScreenShotToClipboard(this.pixelBuffer);
        } else {
            this.logDiashow.log(-2137614336, "IRootWindowImpl#saveScreenshot() - time for reading pixel buffer (ms): %1", this.getFramework().getMonotonicTime() - l);
            String string3 = bl ? "popin_" : "screen_";
            long l2 = this.getFramework().getMonotonicTime();
            File file = new File(string);
            file.mkdirs();
            OutputStream outputStream = null;
            try {
                int n2;
                int n3;
                Buffer buffer = new Buffer(128);
                buffer.append(string);
                if (Boolean.getBoolean("useNameForScreenshotFile")) {
                    if (string2 == null) {
                        buffer.append(this.getScreenName(new Integer(n)));
                    } else {
                        buffer.append(string2);
                    }
                } else if (string2 == null) {
                    buffer.append(string3).append(n);
                } else {
                    buffer.append(string3).append(string2);
                }
                if (bl2) {
                    buffer.append(".zip");
                } else {
                    buffer.append(".bmp");
                }
                outputStream = new BufferedOutputStream(new FileOutputStream(buffer.toString()), 16384);
                if (bl2) {
                    outputStream = new ZipOutputStream(outputStream);
                    ((ZipOutputStream)outputStream).putNextEntry(new ZipEntry(new StringBuffer().append(string3).append(n).append(".bmp").toString()));
                }
                if (this.framework.getScreenRes() == 0) {
                    n3 = 400;
                    n2 = 240;
                } else if (this.framework.getScreenRes() == 1) {
                    n3 = 800;
                    n2 = 480;
                } else if (this.framework.getScreenRes() == 2) {
                    n3 = 1024;
                    n2 = 480;
                } else if (this.framework.getScreenRes() == 4) {
                    if (this.framework.isEvoHighMMIKombi()) {
                        n3 = 1440;
                        n2 = 542;
                    } else {
                        n3 = 1440;
                        n2 = 540;
                    }
                } else {
                    return;
                }
                byte[] byArray = new byte[]{66, 77, 54, -108, 17, 0, 0, 0, 0, 0, 54, 0, 0, 0, 40, 0, 0, 0, (byte)(n3 & 0xFF), (byte)(n3 >>> 8 & 0xFF), (byte)(n3 >>> 16 & 0xFF), (byte)(n3 >>> 24 & 0xFF), (byte)(n2 & 0xFF), (byte)(n2 >>> 8 & 0xFF), (byte)(n2 >>> 16 & 0xFF), (byte)(n2 >>> 24 & 0xFF), 1, 0, 24, 0, 0, 0, 0, 0, 0, -108, 17, 0, 18, 11, 0, 0, 18, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                outputStream.write(byArray);
                this.writeBMPPixelData(this.pixelBuffer, n3, n2, outputStream);
            }
            catch (IOException iOException) {
                this.logDiashow.log(10000, "IRootWindowImpl#saveScreenshot: Exception while saving BMP-File with Screenshot to Path: %1", (Object)string, (Throwable)iOException);
            }
            finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    }
                    catch (IOException iOException) {
                        this.logDiashow.log(10000, "IRootWindowImpl#saveScreenshot: Exception while closing BMP-File with Screenshot to Path: %1", (Object)string, (Throwable)iOException);
                    }
                }
            }
            this.logDiashow.log(-2137614336, "IRootWindowImpl#saveScreenshot() - time for saving (ms): %1", this.getFramework().getMonotonicTime() - l2);
            this.logDiashow.log(-2137614336, "IRootWindowImpl#saveScreenshot() - time for overall process (ms): %1", this.getFramework().getMonotonicTime() - l);
        }
    }

    protected void saveScreenShotToClipboard(int[] nArray) {
    }

    private final String getScreenName(Integer n) {
        try {
            Class clazz = Class.forName("de.audi.atip.diag.HMIDiagScreenNameMapping");
            Method method = clazz.getDeclaredMethod("getScreenName", new Class[]{Integer.TYPE});
            return (String)method.invoke(null, new Object[]{n});
        }
        catch (Exception exception) {
            return n.toString();
        }
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected ITerminalContext getHMITerminalContext(int n) {
        return this.getFramework().getHMITerminalRegistry().getTerminalContext(n);
    }

    protected HMIService getFwHMI() {
        return this.getHMIService();
    }

    public void postRepaintEvent() {
        if (this.getHMIService() != null) {
            EventDispatcher eventDispatcher = this.getHMIService().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.postEvent(new AbstractWindow$RepaintEvent((ATIPEventListener)this, null));
            } else {
                this.logRepaintCause.log(-1601830656, "AbstractWindow#postRepaintEvent: could not post event because no eventdispatcher available");
            }
        } else {
            this.logRepaintCause.log(-1601830656, "AbstractWindow#postRepaintEvent: could not post event because no hmiservice available");
        }
    }
}

