/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSContext;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SDSDispatcher
implements ISDSDispatcher {
    private static final int INIT_BUCKETS = 200;
    private LogChannel lc = Logger.getMainLog();
    private Map idMap = new HashMap();
    private Map commandMap = new HashMap(200);

    public void registerApplication(ISDSApplication iSDSApplication, byte by) {
        this.lc.log(10000000, "SDSDispatcher#registerApplication: application=%1, appID=%2", (Object)iSDSApplication, (long)by);
        Integer n = new Integer(by);
        if (this.idMap.containsKey(n)) {
            this.lc.log(100000, "SDSDispatcher#registerApplication: Double registration of appID %1!", (long)by);
            return;
        }
        if (this.idMap.containsValue(iSDSApplication)) {
            this.lc.log(100000, "SDSDispatcher#registerApplication: Double registration of application %1!", (Object)iSDSApplication);
            return;
        }
        this.idMap.put(n, iSDSApplication);
        int[] nArray = iSDSApplication.getCommands();
        if (nArray == null || nArray.length == 0) {
            this.lc.log(100000, "SDSDispatcher#registerApplication: No commands for application %1 found!", (Object)iSDSApplication);
            return;
        }
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Integer n3 = new Integer(nArray[i2]);
            List list = (List)this.commandMap.get(n3);
            String string = SDSManagerBaseActivator.getSystemCallNames().getName(n3);
            if (list == null) {
                list = new ArrayList(2);
                this.commandMap.put(n3, list);
            } else {
                this.lc.log(10000000, "SDSDispatcher#registerApplication: Existing %1 (ID %2) requested again!", (Object)string, (Object)n3);
            }
            if (list.contains(iSDSApplication)) {
                this.lc.log(100000, "SDSDispatcher#registerApplication: Double registration of application %1 for %2 (ID %3)!", (Object)iSDSApplication, (Object)string, (Object)n3);
                continue;
            }
            this.lc.log(10000000, "SDSDispatcher#registerApplication: Adding application %1 to %2 (ID %3)!", (Object)iSDSApplication, (Object)string, (Object)n3);
            list.add(iSDSApplication);
        }
    }

    public ISDSApplication determineSyscallHandler(ISystemCall iSystemCall) {
        ISDSApplication iSDSApplication;
        int n = iSystemCall.getId();
        List list = (List)this.commandMap.get(new Integer(n));
        if (list == null || list.isEmpty()) {
            this.lc.log(10000, "SDSDispatcher#dispatchSDSCommand: No application registered for systemCall %1!", (Object)iSystemCall.getName());
            return null;
        }
        int n2 = list.size();
        if (n2 == 1) {
            iSDSApplication = (ISDSApplication)list.get(0);
        } else {
            this.lc.log(10000000, "SDSDispatcher#dispatchSDSCommand: %3 application(s) registered for systemCall %1: %2", (Object)iSystemCall.getName(), (Object)SDSUtils.toString(list, false), (long)n2);
            iSDSApplication = this.getActiveApplication();
            if (iSDSApplication == null) {
                this.lc.log(100000, "SDSDispatcher#dispatchSDSCommand: No active application!");
                return null;
            }
            if (!list.contains(iSDSApplication)) {
                this.lc.log(100000, "SDSDispatcher#dispatchSDSCommand: Active application %2 not in appList for systemCall %1!", (Object)iSystemCall.getName(), (Object)iSDSApplication.getClass().getName());
                return null;
            }
        }
        return iSDSApplication;
    }

    public ISDSApplication getActiveApplication() {
        int n = SDSDispatcher.retrieveApplicationContext();
        return this.getApplication(n);
    }

    private ISDSApplication getApplication(int n) {
        SDSContext sDSContext = new SDSContext(n);
        int n2 = 14;
        if (sDSContext.isMediaContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Returning media application!");
            n2 = 2;
        } else if (sDSContext.isNaviContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Returning navi application!");
            n2 = 4;
        } else if (sDSContext.isPhoneContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Returning phone application!");
            n2 = 3;
        } else if (sDSContext.isTunerContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Returning tuner application!");
            n2 = 1;
        } else if (sDSContext.isCarContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Returning car application!");
            n2 = 6;
        } else if (sDSContext.isToneContext()) {
            this.lc.log(10000000, "SDSDispatcher#getApplication: Tone requested, returning default application!");
        } else {
            this.lc.log(100000, "SDSDispatcher#getApplication: No matching application found for videoContextID %1, returning default application!", (long)n);
        }
        return (ISDSApplication)this.idMap.get(new Integer(n2));
    }

    public int[] getSDSCallIDs() {
        Set set = this.commandMap.keySet();
        int n = set.size();
        int[] nArray = new int[n];
        int n2 = 0;
        Iterator iterator = set.iterator();
        boolean bl = iterator.hasNext();
        while (bl) {
            nArray[n2++] = (Integer)iterator.next();
            bl = iterator.hasNext();
        }
        return nArray;
    }

    public String[] getSDSCallNames() {
        Set set = this.commandMap.keySet();
        int n = set.size();
        Object[] objectArray = new String[n];
        int n2 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            objectArray[n2++] = SDSManagerBaseActivator.getSystemCallNames().getName((Integer)iterator.next());
        }
        Arrays.sort(objectArray);
        return objectArray;
    }

    public ISDSApplication[] getRegisteredApplications() {
        Collection collection = this.idMap.values();
        return (ISDSApplication[])collection.toArray(new ISDSApplication[collection.size()]);
    }

    public ISDSApplication[] getRegisteredApplications(int n) {
        List list = (List)this.commandMap.get(new Integer(n));
        return (ISDSApplication[])list.toArray(new ISDSApplication[list.size()]);
    }

    public static int retrieveApplicationContext() {
        return SDSModelAccess.getContextChoice();
    }

    public void checkAbortCurrentCommand(ISystemCall iSystemCall) {
        CommandList commandList = SDSManagerBaseActivator.getSysCallCmdListManager().getActiveCommandList();
        if (commandList == null) {
            return;
        }
        AbstractSystemCallCommand abstractSystemCallCommand = (AbstractSystemCallCommand)commandList.getActiveCommand();
        if (abstractSystemCallCommand == null) {
            return;
        }
        if (abstractSystemCallCommand.getActionOnNewSystemCall(iSystemCall) == 1) {
            this.lc.log(1000000, "SDSDispatcher#checkAbortCurrentCommand: abort %1 due to %2", (Object)abstractSystemCallCommand.getName(), (Object)iSystemCall);
            abstractSystemCallCommand.processingFinished();
        }
    }
}

