/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ContextManagerComponentEvo$1;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.util.Util;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.Iterator;
import java.util.Map$Entry;

public class ContextManagerComponentEvo
extends ContextManagerComponent {
    public static final int AUDICONNECT_TITLE;
    public static final int MEDIA_TITLE;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(350352645, new ContextManagerComponentEvo$1(this, "INTERPRETER_RESUMPTION_FAILED", logChannel, remoteHMIService));
    }

    @Override
    public void setContext(String string, int n) {
        if (string == null || string.equals("")) {
            this.logChannel.log(-2137614336, "ContextManagerComponentEvo#setContext: context name is null or empty");
            return;
        }
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#setContext: called for context '%1' while current entryPoint is '%2'", (Object)string, this.currentEntryPoint == null ? -1L : (long)this.currentEntryPoint.getEntryPointId());
        RightDrawerHandler rightDrawerHandler = ((RemoteHMIServiceEvo)this.remoteHmiService).getRightDrawerHandler();
        LeftDrawerHandler leftDrawerHandler = ((RemoteHMIServiceEvo)this.remoteHmiService).getLeftDrawerHandler();
        boolean bl = false;
        Iterator iterator = this.entryPointMap.values().iterator();
        while (iterator.hasNext()) {
            EntryPoint entryPoint = (EntryPoint)iterator.next();
            if (entryPoint.getEntryPointId() == 4) {
                Map$Entry map$Entry;
                MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
                if (mediaSubEntryPointsContainer == null) {
                    this.logChannel.log(-2137614336, "ContextManagerComponentEvo#setContext: MediaSubEntryPointsContainer is null so skipping it");
                    continue;
                }
                Iterator iterator2 = mediaSubEntryPointsContainer.getEntryPoints().iterator();
                while (iterator2.hasNext() && !(bl = this.updateEntryPoint(entryPoint = (EntryPoint)(map$Entry = (Map$Entry)iterator2.next()).getValue(), string))) {
                }
            } else {
                bl = this.updateEntryPoint(entryPoint, string);
            }
            if (!bl) continue;
            if (this.currentEntryPoint != null && this.currentEntryPoint.getEntryPointId() == entryPoint.getEntryPointId()) {
                this.logChannel.log(1078071040, "ContextManagerComponentEvo#setContext: set '%1' as current context for entrypoint id '%2' which is current entrypoint", (Object)string, (long)entryPoint.getEntryPointId());
                rightDrawerHandler.setRightDrawerForContext(string);
                leftDrawerHandler.setLeftDrawerForContext(string);
                super.setContext(string, 1);
                continue;
            }
            this.logChannel.log(1078071040, "ContextManagerComponentEvo#setContext: set '%1' as current context for entrypoint id '%2' which is not a current entrypoint", (Object)string, (long)entryPoint.getEntryPointId());
        }
    }

    @Override
    public void setEntryPoint(int n) {
        Object object;
        Object object2;
        Object object3;
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#setEntryPoint: called for entryPointId %1", (long)n);
        this.setWaitingAndErrorScreenTitle(n);
        Object object4 = this.getEntryPointFromMap(n);
        if (object4 == null) {
            this.logChannel.log(-1601830656, "ContextManagerComponentEvo#setEntryPoint: unknown entry point '%1' provided by GUIDE", (long)n);
            return;
        }
        if (n == 4) {
            object3 = ((EntryPoint)object4).getSubEntryPointContainer();
            Object object5 = object2 = object3 != null ? ((MediaSubEntryPointsContainer)object3).getCurrentEntryPoint() : null;
            if (object2 == null) {
                this.logChannel.log(-1601830656, "ContextManagerComponentEvo#setEntryPoint: no current entry point defined for OnlineMedia");
                this.setCurrentEntryPoint((EntryPoint)object4);
                return;
            }
            object4 = object2;
        }
        n = ((EntryPoint)object4).getEntryPointId();
        object3 = ((EntryPoint)object4).getNameOfContextToBeStarted();
        object2 = ((EntryPoint)object4).getCurrentContext();
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(1025254144);
        if (n == 2 || n == 3) {
            choiceModelApp.setValue(1);
        } else {
            choiceModelApp.setValue(0);
        }
        this.remoteHmiService.flushModelGroup();
        this.setCurrentEntryPoint((EntryPoint)object4);
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#setEntryPoint: current entrypoint = %1, REMOTEHMI_SCREEN_TYPE_CHOICE = '%2', nameOfContextToBeStarted = '%3'", (Object)new Integer(n), (Object)new Integer(choiceModelApp.getValue()), object3);
        if (n == 1) {
            Object object6 = object = object3 == null || ((String)object3).equals("") ? null : object3;
            if (object2 == null && object == null) {
                this.logChannel.log(-1601830656, "ContextManagerComponentEvo#setEntryPoint: AudiConnect has current context null so setting top wizard as current context");
                object2 = this.addContext("top_wizard", 1);
                ((EntryPoint)object4).setCurrentContext((RemoteHMIContext)object2);
            }
        }
        if (object2 == null) {
            this.logChannel.log(1078071040, "ContextManagerComponentEvo#setEntryPoint: entry point %1 has current context null ", (long)n);
            object = this.getContext((String)object3);
            if (object != null) {
                ((EntryPoint)object4).setCurrentContext((RemoteHMIContext)object);
                this.logChannel.log(1078071040, "ContextManagerComponentEvo#setEntryPoint: setting Context %1 to entryPoint %2", (Object)((RemoteHMIContext)object).getContextName(), (long)n);
                this.setContext(((RemoteHMIContext)object).getContextName(), 1);
                return;
            }
            this.logChannel.log(1078071040, "ContextManagerComponentEvo#setEntryPoint: contextToBeStarted not existed in map for entrypoint %1 so waiting for southside", (long)n);
        } else {
            object = ((RemoteHMIContext)object2).getContextName();
            this.logChannel.log(-2137614336, "ContextManagerComponentEvo#setEntryPoint: entry point %1 has current context %2", (Object)Util.createInteger(n), object);
            this.setContext((String)object, 1);
        }
    }

    public void setWaitingAndErrorScreenTitle(int n) {
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(-1810095360);
        if (n == 4) {
            choiceModelApp.setValue(1);
        } else {
            choiceModelApp.setValue(0);
        }
    }

    @Override
    public void contextRemoved(String string) {
        boolean bl = this.removeContextFromEntryPoints(string);
        if (bl) {
            super.contextRemoved(string);
        }
    }

    @Override
    public void setWaitForApplicationValue(int n) {
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(1696277248);
        int n2 = choiceModelApp.getValue();
        if (n2 != n) {
            choiceModelApp.setValue(n);
            this.logChannel.log(1078071040, "ContextManagerComponentEvo#setWaitForApplicationValue: Old Value: %1 - New Value: %2", (long)n2, (long)n);
        }
    }

    @Override
    public int getWaitForApplicationValue() {
        return this.remoteHmiService.getModelBankAccess().getChoiceModel(1696277248).getValue();
    }

    @Override
    public void contextSuspended(String string) {
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#contextSuspended: Called for context name '%1'", (Object)string);
        this.removeContextFromEntryPoints(string);
        RemoteHMIContext remoteHMIContext = this.getContext(string);
        if (remoteHMIContext == null) {
            this.logChannel.log(-2137614336, "ContextManagerComponentEvo#contextSuspended: context is not present in contextMap");
            return;
        }
        remoteHMIContext.setCurrentlySelectedLeftDrawerEntryId(null);
        remoteHMIContext.setCurrentlySelectedLeftDrawerSubEntryId(null);
    }

    @Override
    public void setLoadingTitleValue(int n) {
        this.logChannel.log(-2137614336, "ContextManagerComponentEvo#setLoadingTitleValue: new value for IEvoOnlineModelBank.RHMI_WAITING_ERROR_TITLE_AVAILABLE_CHOICE is %1", (long)n);
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(-1038343424);
        choiceModelApp.setValue(n);
    }

    @Override
    public boolean isAppMediaCxt(String string) {
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#isAppMediaCxt: checking whether '%1' is media context", (Object)string);
        if (string == null) {
            return false;
        }
        EntryPoint entryPoint = this.getEntryPointFromMap(4);
        MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
        if (mediaSubEntryPointsContainer == null) {
            return false;
        }
        EntryPoint entryPoint2 = mediaSubEntryPointsContainer.getCurrentEntryPoint();
        if (entryPoint2 == null) {
            return false;
        }
        RemoteHMIContext remoteHMIContext = entryPoint2.getCurrentContext();
        if (remoteHMIContext == null) {
            return false;
        }
        return string.equals(remoteHMIContext.getContextName());
    }

    public void setLeftDrawerAvailability(int n) {
        int n2;
        this.logChannel.log(1078071040, "ContextManagerComponentEvo#setLeftDrawerAvailability: called for entryPointId = %1", (long)n);
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getModelBankAccess().getChoiceModel(1226646272);
        if (n == 1) {
            EntryPoint entryPoint = this.getEntryPointFromMap(n);
            RemoteHMIContext remoteHMIContext = entryPoint.getCurrentContext();
            if (remoteHMIContext == null) {
                this.logChannel.log(-1601830656, "ContextManagerComponentEvo#setLeftDrawerAvailability: no context for ENTRY_POINT_AUDI_CONNECT so checking nameOfContextToBeStarted");
                remoteHMIContext = this.getContext(entryPoint.getNameOfContextToBeStarted());
            }
            if (remoteHMIContext == null) {
                this.logChannel.log(-1601830656, "ContextManagerComponentEvo#setLeftDrawerAvailability: nameOfContextToBeStarted not existing so setting top wizard");
                return;
            }
            n2 = remoteHMIContext.isLeftDrawerAvailable() ? 0 : 1;
        } else {
            n2 = 1;
        }
        choiceModelApp.setValue(n2);
    }

    static /* synthetic */ EntryPoint access$000(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }

    static /* synthetic */ EntryPoint access$100(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }

    static /* synthetic */ EntryPoint access$200(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }

    static /* synthetic */ EntryPoint access$300(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }

    static /* synthetic */ EntryPoint access$400(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }

    static /* synthetic */ EntryPoint access$500(ContextManagerComponentEvo contextManagerComponentEvo) {
        return contextManagerComponentEvo.currentEntryPoint;
    }
}

