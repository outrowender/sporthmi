/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.UpdatingIconComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ContextManagerComponent
extends AbstractRemoteHMIComponent {
    public static final String EMPTY_STRING = "";
    public static final int APP_STATUS_DISABLED = 0;
    public static final int APP_STATUS_WAITING_SCREEN = 1;
    public static final int APP_STATUS_ERROR_SCREEN = 2;
    public static final int NORMAL_SCREEN = 0;
    public static final int POPUP_SCREEN = 1;
    protected Map contextMap;
    private RemoteHMIContext currentContext;
    private boolean isPreviousContextRootContext;
    private boolean ignoreScreenConnect = false;
    protected Map entryPointMap;
    protected EntryPoint currentEntryPoint;
    private boolean isRemoteHMIActive;
    private boolean transitionToInclude = false;
    private UpdatingIconComponent updatingIconComponent;

    public void init(final LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        if (logChannel == null) {
            throw new IllegalArgumentException("ContextManagerComponent#ContextManagerComponent: logChannel is null");
        }
        logChannel.log(10000000, "ContextManagerComponent#init: called");
        this.logChannel = logChannel;
        this.contextMap = new HashMap();
        this.entryPointMap = new HashMap();
        this.addContext("top_wizard", 1);
        EntryPoint entryPoint = new EntryPoint(1, logChannel);
        entryPoint.setCurrentContext(this.getContext("top_wizard"));
        this.addEntryPoint(entryPoint);
        this.addEntryPoint(new EntryPoint(2, logChannel));
        this.addEntryPoint(new EntryPoint(3, logChannel));
        this.addEntryPoint(new EntryPoint(4, logChannel));
        this.addEntryPoint(new EntryPoint(5, logChannel));
        this.addEntryPoint(new EntryPoint(6, logChannel));
        remoteHMIService.addCommandHandler(100000018, new AbstractCommandHandler("SET_CONTEXT_TO_BE_STARTED_FOR_AUDICONNECT"){

            protected LogAppender getParamsForDebugging(Object object) {
                return LogAppender.Factory.fromString((String)object);
            }

            public void indicateCommand(int n, Object object) {
                if (!(object instanceof String)) {
                    logChannel.log(10000, "ContextManagerComponent#indicateCommand: wrong payload provided");
                    return;
                }
                ContextManagerComponent.this.setAudiConnectContextToBeStarted((String)object);
            }
        });
    }

    private void addEntryPoint(EntryPoint entryPoint) {
        this.entryPointMap.put(new Integer(entryPoint.getEntryPointId()), entryPoint);
    }

    public Map getEntryPointMap() {
        return this.entryPointMap;
    }

    public final RemoteHMIContext getCurrentContext() {
        return this.currentContext;
    }

    protected final void setCurrentContext(RemoteHMIContext remoteHMIContext) {
        this.logChannel.log(1000000, "ContextManagerComponent#setCurrentContext: current context provided is %1", (Object)remoteHMIContext);
        this.currentContext = remoteHMIContext;
        if (remoteHMIContext != null) {
            this.remoteHmiService.getDiagnosisComponent().update(remoteHMIContext.getContextName(), 0);
            this.updatingIconComponent.refresh();
        }
    }

    protected void performCursorCorrection(EntryPoint entryPoint, RemoteHMIContext remoteHMIContext) {
        this.logChannel.log(1000000, "ContextManagerComponent#performCursorCorrection: called for context name %1", (Object)remoteHMIContext.getContextName());
        RemoteHMIContext remoteHMIContext2 = this.getContext("top_wizard");
        if (remoteHMIContext2 != null) {
            this.logChannel.log(10000000, "ContextManagerComponent#performCursorCorrection: setting top wizard last action to TYPE_RETURN");
            RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(104);
            remoteHMIContext2.setLastAction(remoteHMIAction);
        }
    }

    public final RemoteHMIContext getContext(String string) {
        this.logChannel.log(1000000, "ContextManagerComponent#getContext: called for context name '%1'", (Object)string);
        RemoteHMIContext remoteHMIContext = (RemoteHMIContext)this.contextMap.get(string);
        if (remoteHMIContext == null) {
            this.logChannel.log(10000000, "ContextManagerComponent#getContext: context %1 not found", (Object)string);
        }
        return remoteHMIContext;
    }

    public boolean isContextActive(RemoteHMIContext remoteHMIContext) {
        return this.getCurrentContext() == remoteHMIContext;
    }

    public RemoteHMIContext addContext(String string, int n) {
        if (!this.contextMap.containsKey(string)) {
            this.logChannel.log(1000000, "ContextManagerComponent#addContext: adding context %1", (Object)string);
            this.contextMap.put(string, new RemoteHMIContext(string));
        }
        return (RemoteHMIContext)this.contextMap.get(string);
    }

    public void setContext(String string, int n) {
        RemoteHMIContext remoteHMIContext = this.getContext(string);
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "ContextManagerComponent#setContext: 1- Context passed is null");
            return;
        }
        this.setCurrentContext(remoteHMIContext);
        this.remoteHmiService.getASR().indicateCurrentSpeechHelpContext(string);
    }

    public void setCurrentEntryPoint(EntryPoint entryPoint) {
        this.currentEntryPoint = entryPoint;
    }

    public EntryPoint getEntryPointFromMap(int n) {
        return (EntryPoint)this.entryPointMap.get(new Integer(n));
    }

    public EntryPoint getCurrentEntryPoint() {
        return this.currentEntryPoint;
    }

    public void setEntryPoint(int n) {
        this.logChannel.log(10000, "ContextManagerComponent#setEntryPoint: override the method in the derived class");
    }

    public void setWaitForApplicationValue(int n) {
        this.logChannel.log(10000, "ContextManagerComponent#setWaitForApplicationValue: override the method in the derived class");
    }

    public int getWaitForApplicationValue() {
        this.logChannel.log(10000, "ContextManagerComponent#getWaitForApplicationValue: returns default value, override the method in the derived classes");
        return 0;
    }

    public void setLoadingTitleValue(int n) {
        this.logChannel.log(10000, "ContextManagerComponent#setLoadingTitleValue: override the method in the derived class");
    }

    public void contextRemoved(String string) {
        this.logChannel.log(1000000, "ContextManagerComponent#contextRemoved: Called for context name %1", (Object)string);
        RemoteHMIContext remoteHMIContext = this.getCurrentContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName().equals(string)) {
            this.logChannel.log(1000000, "ContextManagerComponent#contextRemoved: Context %1 is active", (Object)string);
            this.setCurrentContext(null);
        }
        if (this.contextMap.containsKey(string)) {
            this.logChannel.log(1000000, "ContextManagerComponent#contextRemoved: context %1 removed from list", (Object)string);
            this.contextMap.remove(string);
            this.updatingIconComponent.removeContext(string);
        }
    }

    public void contextCreated(String string, int n) {
        this.addContext(string, n);
    }

    public void onExit() {
        this.logChannel.log(1000000, "ContextManagerComponent#onExit: Called");
        super.onExit();
        if (this.currentContext != null) {
            this.currentContext.onContextExit();
        } else {
            this.logChannel.log(100000, "ContextManagerComponent#onExit: Context is null");
        }
        this.isRemoteHMIActive = false;
    }

    public void onEnter() {
        this.logChannel.log(1000000, "ContextManagerComponent#onEnter: Called");
        super.onEnter();
        this.isRemoteHMIActive = true;
    }

    public Set getContextNames() {
        return this.contextMap.keySet();
    }

    public void contextSuspended(String string) {
    }

    public boolean isPreviousContextRootContext() {
        return this.isPreviousContextRootContext;
    }

    public void setPreviousContextRootContext(boolean bl) {
        this.isPreviousContextRootContext = bl;
    }

    public boolean isRemoteHMIActive() {
        return this.isRemoteHMIActive;
    }

    public boolean isTransitionToInclude() {
        return this.transitionToInclude;
    }

    public void setTransitionToInclude(boolean bl) {
        this.transitionToInclude = bl;
    }

    public boolean isAppMediaCxt(String string) {
        this.logChannel.log(1000000, "ContextManagerComponent#isAppMediaCxt: called");
        return false;
    }

    public void setContextChangeListener(UpdatingIconComponent updatingIconComponent) {
        this.updatingIconComponent = updatingIconComponent;
    }

    public void setAudiConnectContextToBeStarted(String string) {
        RemoteHMIContext remoteHMIContext;
        String string2;
        if (string == null || string.equals(EMPTY_STRING)) {
            this.logChannel.log(100000, "ContextManagerComponent#setAudiConnectContextToBeStarted: nameOfContextToBeStarted '%1' provided not valid", (Object)string);
            return;
        }
        this.logChannel.log(1000000, "ContextManagerComponent#setAudiConnectContextToBeStarted: context to be set for AudiConnect is '%1'", (Object)string);
        EntryPoint entryPoint = this.getEntryPointFromMap(1);
        RemoteHMIContext remoteHMIContext2 = entryPoint.getCurrentContext();
        String string3 = string2 = remoteHMIContext2 == null ? EMPTY_STRING : remoteHMIContext2.getContextName();
        if (!string.equals(string2)) {
            entryPoint.setCurrentContext(null);
        }
        entryPoint.setNameOfContextToBeStarted(string);
        if (string == "top_wizard" && (remoteHMIContext = this.getContext("top_wizard")) != null) {
            RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(104);
            remoteHMIContext.setLastAction(remoteHMIAction);
        }
    }

    public void replaceExitView() {
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(2300070);
        this.logChannel.log(10000000, "ContextManagerComponent#replaceExitView: called. REMOTE_HMI_CURRENT_VIEW_CHOICE status is %1.", (long)choiceModelApp.getStatus());
        if (choiceModelApp.getStatus() == 90000) {
            this.logChannel.log(1000000, "ContextManagerComponent#replaceExitView: EXIT view replaced with WAITING");
            choiceModelApp.setStatus(14000);
        }
    }

    public EntryPoint findAssociatedEntryPoint(String string, Set set) {
        this.logChannel.log(1000000, "ContextManagerComponent#findAssociatedEntryPoint: called for context '%1'", (Object)string);
        if (string == null || set == null) {
            this.logChannel.log(100000, "ContextManagerComponent#findAssociatedEntryPoint: either context or entryPoints is null");
            return null;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            EntryPoint entryPoint = (EntryPoint)entry.getValue();
            RemoteHMIContext remoteHMIContext = entryPoint.getCurrentContext();
            if (remoteHMIContext == null || !remoteHMIContext.getContextName().equals(string)) continue;
            this.logChannel.log(10000000, "ContextManagerComponent#findAssociatedEntryPoint: associated with entryPoint %1", (long)entryPoint.getEntryPointId());
            return entryPoint;
        }
        return null;
    }

    protected boolean removeContextFromEntryPoints(String string) {
        this.logChannel.log(1000000, "ContextManagerComponent#removeContextFromEntryPoints: called for context %1", (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(4);
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
        EntryPoint entryPoint2 = this.findAssociatedEntryPoint(string, this.entryPointMap.entrySet());
        if (entryPoint2 == null) {
            entryPoint2 = this.findAssociatedEntryPoint(string, mediaSubEntryPointsContainer.getEntryPoints());
        }
        if (entryPoint2 == null) {
            this.logChannel.log(1000000, "ContextManagerComponent#removeContextFromEntryPoints: context %1 is not associated with any entrypoint", (Object)string);
            return true;
        }
        int n = entryPoint2.getEntryPointId();
        EntryPoint entryPoint3 = mediaSubEntryPointsContainer.getCurrentEntryPoint();
        if (entryPoint3 != null && entryPoint3.getEntryPointId() == n) {
            this.logChannel.log(100000, "ContextManagerComponent#removeContextFromEntryPoints: context %1 can't be removed because it belongs to media current entry point", (Object)string);
            return false;
        }
        entryPoint2.setCurrentContext(null);
        if (string != null && string.equals(entryPoint2.getNameOfContextToBeStarted())) {
            entryPoint2.setNameOfContextToBeStarted(null);
        }
        this.logChannel.log(1000000, "ContextManagerComponent#removeContextFromEntryPoints: context %1 associated with entrypoint %2 is removed", (Object)string, (long)n);
        return true;
    }

    public boolean isCurrentEntrypointMedia() {
        this.logChannel.log(1000000, "ContextManagerComponent#isCurrentEntrypointMedia: called");
        EntryPoint entryPoint = this.getCurrentEntryPoint();
        if (entryPoint == null) {
            return false;
        }
        return entryPoint.getEntryPointId() == 4 || entryPoint.getEntryPointId() > 10;
    }

    public boolean updateEntryPoint(EntryPoint entryPoint, String string) {
        String string2 = entryPoint.getNameOfContextToBeStarted();
        String string3 = entryPoint.getCurrentContext() == null ? EMPTY_STRING : entryPoint.getCurrentContext().getContextName();
        this.logChannel.log(10000000, "ContextManagerComponent#updateEntryPoint: entryPointId '%1', entryPointContextToBeStarted '%2', entryPointCurrentContext '%3'", (Object)new Integer(entryPoint.getEntryPointId()), (Object)string2, (Object)string3);
        if (string.equals(string2) || string.equals(string3)) {
            entryPoint.setCurrentContext(this.getContext(string));
            return true;
        }
        return false;
    }

    public boolean isIgnoreScreenConnect() {
        return this.ignoreScreenConnect;
    }

    public void setIgnoreScreenConnect(boolean bl) {
        this.ignoreScreenConnect = bl;
    }

    public void showProviderLogo(String string) {
        String string2;
        int n;
        if (string == null || string.length() == 0) {
            n = 0;
            string2 = EMPTY_STRING;
        } else {
            n = 1;
            string2 = string;
        }
        ResourceLocatorModelApp resourceLocatorModelApp = this.getModelBank().getResourceLocatorModel(3838);
        resourceLocatorModelApp.setStatus(n);
        resourceLocatorModelApp.setResourceLocator(-1, string2);
    }

    protected ChoiceModelApp getViewChoiceModel() {
        return this.remoteHmiService.getModelBankAccess().getChoiceModel(2300070);
    }
}

