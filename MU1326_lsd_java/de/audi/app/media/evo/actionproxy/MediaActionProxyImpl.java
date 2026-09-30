/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.actionproxy;

import de.audi.app.media.actionproxy.IActionProxyDispatcher;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.MediaActionProxy;
import de.audi.atip.util.Util;
import java.util.HashMap;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class MediaActionProxyImpl
implements MediaActionProxy {
    private static final String LOGCLASS = "MediaActionProxyImpl";
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IActionProxyDispatcher actionProxyDispatcher;
    private ServiceRegistration apServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public MediaActionProxyImpl(IFrameworkAccess iFrameworkAccess, IServiceManager iServiceManager, IActionProxyDispatcher iActionProxyDispatcher) {
        this.logger = iActionProxyDispatcher.getLogChannel();
        this.serviceManager = iServiceManager;
        this.actionProxyDispatcher = iActionProxyDispatcher;
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("moduleID", new Integer(6));
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.apServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = MediaActionProxyImpl.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy, this, hashtable);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        if (this.apServiceRegistration != null) {
            this.apServiceRegistration.unregister();
        }
    }

    public void hmiActivated(int n) {
        this.logger.log(1000000, "[%1.hmiActivated] '%2'.", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(1001, n, new HashMap(0));
    }

    public void hmiDeactivated(int n) {
        this.logger.log(1000000, "[%1.hmiDeactivated] '%2'.", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(1002, n, new HashMap(0));
    }

    public void mergeCursor(int n) {
        this.logger.log(1000000, "[%1.mergeCursor] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(28, n, new HashMap(0));
    }

    public void mediaToggleSource(int n) {
        this.logger.log(1000000, "[%1.mediaToggleSource] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(34, n, new HashMap(0));
    }

    public void mediaToggleSourceEntered(int n) {
        this.logger.log(1000000, "[%1.mediaToggleSourceEntered] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(33, n, new HashMap(0));
    }

    public void mediaStartBrowsing(int n, int n2, boolean bl) {
        this.logger.log(1000000, "[%1.mediaStartBrowsing] '%2',type='%3',playingContext='%4'", (Object)LOGCLASS, (Object)new Integer(n), (Object)new Integer(n2), (Object)bl);
        HashMap hashMap = new HashMap(1);
        hashMap.put("BROWSETYPE", new Integer(n2));
        this.actionProxyDispatcher.notifyActionProxyCall(23, n, hashMap);
    }

    public void mediaChangeToParentFolder(int n) {
        this.logger.log(1000000, "[%1.mediaChangeToParentFolder] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(9, n, new HashMap(0));
    }

    public void mediaManualSeekEnter(int n) {
        this.logger.log(1000000, "[%1.mediaManualSeekEnter] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(30, n, new HashMap(0));
    }

    public void mediaManualSeekLeft(int n) {
        this.logger.log(1000000, "[%1.mediaManualSeekLeft] '%2'", (Object)LOGCLASS, (long)n);
        this.actionProxyDispatcher.notifyActionProxyCall(31, n, new HashMap(0));
    }

    public void mediaBrowserTrufflesDisable(int n) {
        this.logger.log(1000000, "[%1.mediaBrowserTruffleDisable]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(26, n, new HashMap(0));
    }

    public void mediaBrowserTrufflesDisableAnimWait(int n) {
        this.logger.log(1000000, "[%1.mediaBrowserTrufflesDisableAnimWait]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(29, n, new HashMap(0));
    }

    public void mediaBrowserRestoreSelectionPath(int n) {
        this.logger.log(1000000, "[%1.mediaBrowserRestoreSelectionPath]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(27, n, new HashMap(0));
    }

    public void mediaPlayerNewSearch(int n) {
        this.logger.log(1000000, "[%1.mediaNewPlayerSearch]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(25, n, new HashMap(0));
    }

    public void mediaStartSearchBrowser(int n, int n2) {
        this.logger.log(1000000, "[%1.mediaStartSearchBrowser]", (Object)LOGCLASS);
        HashMap hashMap = new HashMap(1);
        hashMap.put("BROWSETYPE", new Integer(n2));
        this.actionProxyDispatcher.notifyActionProxyCall(39, n, hashMap);
    }

    public void mediaDataSetSelectedList(int n, int n2) {
        this.logger.log(1000000, "[%1.mediaDataSetSelectedList] '%2'", (Object)LOGCLASS, (long)n2);
        HashMap hashMap = new HashMap(1);
        hashMap.put("LISTTYPE", new Integer(n2));
        this.actionProxyDispatcher.notifyActionProxyCall(32, n, hashMap);
    }

    public void mediaBrowserFavoritesRestoreSelectionPath(int n) {
        this.logger.log(1000000, "[%1.mediaBrowserFavoritesRestoreSelectionPath]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(35, n, new HashMap(0));
    }

    public void medialoadingFinished(int n) {
        this.logger.log(1000000, "[%1.medialoadingFinished]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(36, n, new HashMap(0));
    }

    public void setBrowserActive(int n, int n2) {
        this.logger.log(1000000, "[%1.setBrowserActive]", (Object)LOGCLASS);
        HashMap hashMap = new HashMap(1);
        hashMap.put("BROWSER_STATE", Util.createInteger(n2));
        this.actionProxyDispatcher.notifyActionProxyCall(38, n, hashMap);
    }

    public void setOptionOpenInNextScreen(int n, int n2) {
        this.logger.log(1000000, "[%1.setOptionOpenInNextScreen] '%2'", (Object)LOGCLASS, (long)n2);
        HashMap hashMap = new HashMap(1);
        hashMap.put(new Integer(40), Util.createInteger(n2));
        this.actionProxyDispatcher.notifyActionProxyCall(40, n, hashMap);
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

