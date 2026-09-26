/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.AbstractNaviServiceComponent;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.sds.ISDSStateObserver;
import java.util.ArrayList;
import java.util.Iterator;

public class SDSController
extends AbstractNaviServiceComponent
implements ISDSController,
ISDSServiceStatusListener {
    private ArrayList observersList = new ArrayList(1);
    private SDSService sdsService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public SDSController(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public void abortSDSSession(boolean bl) {
        this.logChannel.log(-2137614336, "SDSController#abortSDSSession( %1 )", bl);
        if (this.sdsService != null) {
            try {
                this.sdsService.abortSDSSession(bl, (byte)6);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSHandlerImpl#abortSDSSession() - ERROR=%1 ", (Throwable)exception);
            }
        } else {
            this.logChannel.log(-1601830656, "SDSController#abortSDSSession() - no service registered!");
        }
        this.notifyAbort();
    }

    @Override
    public void notifyAbort() {
        this.logChannel.log(-2137614336, "SDSController#notifyAbort()");
        Iterator iterator = this.observersList.iterator();
        while (iterator.hasNext()) {
            try {
                ISDSStateObserver iSDSStateObserver = (ISDSStateObserver)iterator.next();
                iSDSStateObserver.sdsSessionAborted();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSController#notifyAbort() - observer failed: %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void notifySDSDialogStarted() {
        this.logChannel.log(-2137614336, "SDSController#notifySDSDialogStarted()");
        Iterator iterator = this.observersList.iterator();
        while (iterator.hasNext()) {
            try {
                ISDSStateObserver iSDSStateObserver = (ISDSStateObserver)iterator.next();
                iSDSStateObserver.sdsDialogStarted();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSController#notifySDSDialogStarted() - observer failed: %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void notifySDSDialogAborting() {
        this.logChannel.log(-2137614336, "SDSController#notifySDSDialogAborting()");
        Iterator iterator = this.observersList.iterator();
        while (iterator.hasNext()) {
            try {
                ISDSStateObserver iSDSStateObserver = (ISDSStateObserver)iterator.next();
                iSDSStateObserver.sdsDialogAborting();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSController#notifySDSDialogAborting() - observer failed: %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void notifySDSDialogEnded() {
        this.logChannel.log(-2137614336, "SDSController#notifySDSDialogEnded()");
        Iterator iterator = this.observersList.iterator();
        while (iterator.hasNext()) {
            try {
                ISDSStateObserver iSDSStateObserver = (ISDSStateObserver)iterator.next();
                iSDSStateObserver.sdsDialogEnded();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSController#notifySDSDialogEnded() - observer failed: %1", (Throwable)exception);
            }
        }
    }

    @Override
    public boolean isSDSActive() {
        this.logChannel.log(-2137614336, "SDSController#isSDSActive()");
        if (this.sdsService != null) {
            boolean bl = false;
            try {
                bl = this.sdsService.isSDSActive();
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSHandlerImpl#isSDSActive() - ERROR=%1 ", (Throwable)exception);
                bl = false;
            }
            return bl;
        }
        this.logChannel.log(-1601830656, "SDSController#isSDSActive() - no service registered!");
        return false;
    }

    @Override
    public void itemSelected(int n, int n2) {
        this.logChannel.log(-2137614336, "SDSController#itemSelected( %1 )", (long)n2);
        if (this.sdsService != null) {
            try {
                this.sdsService.itemSelected(n, n2);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSHandlerImpl#itemSelected() - ERROR=%1 ", (Throwable)exception);
            }
        } else {
            this.logChannel.log(-1601830656, "SDSController#itemSelected() - no service registered!");
        }
    }

    @Override
    public void keyTyped(int n) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#keyTyped( %1 )", (long)n);
        if (this.sdsService != null) {
            try {
                this.sdsService.keyTyped(n, -1);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "SDSHandlerImpl#keyTyped() - ERROR=%1 ", (Throwable)exception);
            }
        } else {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#keyTyped() - no service registered!");
        }
    }

    @Override
    public void registerListener(ISDSStateObserver iSDSStateObserver) {
        if (iSDSStateObserver == null) {
            throw new IllegalArgumentException();
        }
        this.observersList.add(iSDSStateObserver);
    }

    @Override
    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSController.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName()};
    }

    @Override
    protected boolean trackedServiceAdded(Object object) {
        if (object instanceof SDSService) {
            this.sdsService = (SDSService)object;
            if (this.sdsService != null) {
                try {
                    this.sdsService.registerStatusListener(this);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "SDSHandlerImpl#trackedServiceAdded() - ERROR=%1 ", (Throwable)exception);
                }
            } else {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#trackedServiceAdded() - no service registered!");
            }
            return true;
        }
        return false;
    }

    @Override
    protected boolean trackedServiceRemoved(Object object) {
        if (object instanceof SDSService) {
            this.sdsService = null;
            this.notifySDSDialogEnded();
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
    }

    @Override
    protected void onStop() {
        this.sdsService = null;
        this.observersList.clear();
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

