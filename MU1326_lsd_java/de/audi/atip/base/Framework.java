/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.FrameworkAccess;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IVersionInfo;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.event.VRAMEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TimeZone;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Framework
implements BundleActivator {
    private FrameworkAccess frameworkAccess;
    private ServiceRegistration sRegFramework;
    private ServiceRegistration sRegPowerEvent;
    private Timer memTimer;
    private LogChannel memLog;
    private static long MIN_FREE_MEMORY;
    private boolean firstTry = true;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    private FwServices getFwServices() {
        return this.frameworkAccess.getFwServices();
    }

    private final void initProperties() {
        this.loadPropsFromStream(this.getResourceCL().getResourceAsStream("resources/version.properties"), "version");
        this.loadPropsFromStream(this.getResourceCL().getResourceAsStream("resources/TTVersion.properties"), "TTVersion");
        this.loadPropsFromFile(System.getProperty("atip.properties"));
        this.loadPropsFromStream(this.getResourceCL().getResourceAsStream("resources/atip.properties"), "atip");
        this.loadPropsFromFile(System.getProperty("sys_const.properties"));
        this.loadPropsFromStream(this.getResourceCL().getResourceAsStream("resources/sys_const.properties"), "sys_const");
        Security.setProperty("networkaddress.cache.ttl", "60");
        Security.setProperty("networkaddress.cache.negative.ttl", "2");
    }

    private void logVersion() {
        IVersionInfo iVersionInfo = this.frameworkAccess.getVersionInfo();
        Buffer buffer = new Buffer(512);
        String string = Formatter.LINE_SEPARATOR;
        buffer.append("#################  Version Info  #####################").append(string).append("# HMI         : ").append(iVersionInfo.getHMIVersion()).append(string).append("# TextTool    : ").append(iVersionInfo.getTextToolVersion()).append(string).append("# TextToolSDS : ").append(iVersionInfo.getTextToolSDSVersion()).append(string).append("# DSI_IFC     : ").append(iVersionInfo.getDsiIfcVersion()).append(string).append("# Framework   : ").append(iVersionInfo.getFrameworkVersion()).append(string).append("# Kanzi       : ").append(iVersionInfo.getKanziVersion()).append(string).append("# HudsonBuild : ").append(iVersionInfo.getHudsonBuildTag()).append(string).append("######################################################");
        System.out.println(buffer);
    }

    private final void setupMemoryLogger() {
        if (Boolean.getBoolean("log.jvm.heap.to.slog")) {
            final FrameworkAccess frameworkAccess = this.frameworkAccess;
            this.memLog = this.frameworkAccess.getLogChannel("Ext.JavaHeap");
            this.memTimer = new Timer("HMI FreeMem", Long.getLong("log.jvm.heap.watchdog.time", 5000L), false, new TimerListener(){

                public void fireTimer(Timer timer) {
                    Framework.this.memLog.log(100000, "free j9 Heap: %1", Runtime.getRuntime().freeMemory());
                    IRootWindow iRootWindow = frameworkAccess.getHMIService().getRootWindow(0);
                    frameworkAccess.getHMIService().getEventDispatcher().postEvent(new VRAMEvent(iRootWindow));
                    Framework.this.checkLowMemory();
                }

                public void cancelTimer(Timer timer) {
                }
            });
            this.memTimer.restart();
        }
    }

    private final void checkLowMemory() {
        long l = Runtime.getRuntime().freeMemory();
        if (l < MIN_FREE_MEMORY) {
            if (this.firstTry) {
                this.firstTry = false;
                this.memLog.log(100000, "Memory is too low: %1. Trying to call garbage collector", l);
                Runtime.getRuntime().gc();
                return;
            }
            this.memLog.log(100000, "Memory is too low: %1. Writing errorDump and reseting the system", l);
            this.getFwServices().getErrorManager().handleError(new Exception("Low Memory Error"), "The free memory is too low", 0, 3, 2);
        }
        this.firstTry = true;
    }

    public void start(BundleContext bundleContext) {
        this.initProperties();
        this.frameworkAccess = new FrameworkAccess(bundleContext);
        this.sRegFramework = bundleContext.registerService((class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = Framework.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName(), (Object)this.frameworkAccess, null);
        long l = this.frameworkAccess.getMonotonicTime();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        this.getFwServices().createLogChannelFactory();
        this.getFwServices().createErrorManager();
        TimerDispatcher.init(this.frameworkAccess);
        this.frameworkAccess.initLogChannelFactory();
        this.getFwServices().setLog(this.frameworkAccess.getLogChannel("Fw.Services"));
        TimerDispatcher.setLog(this.frameworkAccess.getLogChannel("Fw.Timer"));
        this.logVersion();
        this.getFwServices().createSysApp();
        MIN_FREE_MEMORY = Long.getLong("log.jvm.heap.min.free.memory", 512000L);
        this.setupMemoryLogger();
        StartupManager startupManager = this.getFwServices().getStartupManager();
        this.sRegPowerEvent = bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = Framework.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)startupManager, null);
        startupManager.setStartOfFrameworkTimestamp(l);
        startupManager.start();
    }

    public void stop(BundleContext bundleContext) {
        this.getFwServices().getStartupManager().stop();
        if (this.sRegFramework != null) {
            this.sRegFramework.unregister();
            this.sRegFramework = null;
        }
        if (this.sRegPowerEvent != null) {
            this.sRegPowerEvent.unregister();
            this.sRegPowerEvent = null;
        }
    }

    private ClassLoader getResourceCL() {
        return this.getClass().getClassLoader() != null ? this.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    private void loadProperties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        Enumeration enumeration = properties.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            if (string == null || System.getProperty(string) != null) continue;
            System.setProperty(string, properties.getProperty(string));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadPropsFromStream(InputStream inputStream, String string) {
        if (inputStream != null) {
            try {
                this.loadProperties(inputStream);
            }
            catch (IOException iOException) {
                System.out.println(new StringBuffer().append("Failed to load \"").append(string).append("\"").toString());
            }
            finally {
                try {
                    inputStream.close();
                }
                catch (Exception exception) {}
                inputStream = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadPropsFromFile(String string) {
        if (string != null) {
            BufferedInputStream bufferedInputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(string));
                this.loadProperties(bufferedInputStream);
            }
            catch (IOException iOException) {
                System.out.println(new StringBuffer().append("Failed to load \"atip.properties\" from file ").append(string).toString());
            }
            finally {
                try {
                    bufferedInputStream.close();
                }
                catch (Exception exception) {}
                bufferedInputStream = null;
                string = null;
            }
        }
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

