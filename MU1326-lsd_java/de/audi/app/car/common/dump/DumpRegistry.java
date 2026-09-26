/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dump;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.dump.DumpHandler;
import de.audi.app.car.common.dump.IDumpHandler;
import de.audi.app.car.common.dump.IDumpHandlerComponentAccess;
import de.audi.app.car.common.dump.IDumpRegistry;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map$Entry;

public class DumpRegistry
implements IDumpRegistry,
DumpInfoProvider {
    private final LinkedList dumpProviders;
    private final String name;
    private final ICarApplication application;

    public DumpRegistry(ICarApplication iCarApplication) {
        this.application = iCarApplication;
        this.name = iCarApplication.getApplicationName();
        this.dumpProviders = new LinkedList();
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
        if (!this.dumpProviders.isEmpty()) {
            this.deregister();
            this.dumpProviders.clear();
        }
    }

    private void register() {
        this.application.getLogChannel().log(1078071040, "[DumpRegistry#register] '%1' registering as dumpInfoProvider ", (Object)this.getName());
        this.application.getFrameworkAccess().getErrorMgr().registerDumpInfoProvider(this);
    }

    private void deregister() {
        this.application.getLogChannel().log(1078071040, "[DumpRegistry#deregister] '%1' unregistering as dumpInfoProvider ", (Object)this.getName());
        this.application.getFrameworkAccess().getErrorMgr().unregisterDumpInfoProvider(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        this.application.getLogChannel().log(1078071040, "[DumpRegistry#dump] called for '%1'", (Object)this.getName());
        try {
            LinkedList linkedList = (LinkedList)this.dumpProviders.clone();
            printStream.print("=== ");
            printStream.print(this.getName());
            printStream.println("===");
            printStream.println();
            Iterator iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                IDumpHandler iDumpHandler = (IDumpHandler)iterator.next();
                String string2 = iDumpHandler.getName();
                printStream.print("---");
                printStream.print(string2);
                printStream.println("---");
                printStream.println();
                HashMap hashMap = iDumpHandler.getData();
                Iterator iterator2 = hashMap.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map$Entry map$Entry = (Map$Entry)iterator2.next();
                    String string3 = (String)map$Entry.getKey();
                    String string4 = (String)map$Entry.getValue();
                    printStream.print(string3);
                    printStream.print(" : ");
                    printStream.println(string4);
                }
                printStream.println();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.application.getLogChannel().log(1000, "[DumpRegistry#dump] exception occured", (Throwable)exception);
            printStream.print(new StringBuffer().append("Exception occured during writing dump data of application ").append(this.getName()).toString());
        }
    }

    @Override
    public IDumpHandlerComponentAccess registerAsProvider(String string) {
        this.application.getLogChannel().log(1078071040, "[DumpRegistry#registerAsProvider] registry='%1', provider='%2'", (Object)this.getName(), (Object)string);
        DumpHandler dumpHandler = new DumpHandler(string);
        if (this.dumpProviders.isEmpty()) {
            this.register();
        }
        this.dumpProviders.add(dumpHandler);
        return dumpHandler;
    }

    @Override
    public void deRegisterAsProvider(IDumpHandlerComponentAccess iDumpHandlerComponentAccess) {
        this.application.getLogChannel().log(1078071040, "[DumpRegistry#deRegisterAsProvider] registry='%1', provider='%2'", (Object)this.getName(), (Object)((IDumpHandler)iDumpHandlerComponentAccess).getName());
        this.dumpProviders.remove(iDumpHandlerComponentAccess);
        if (this.dumpProviders.isEmpty()) {
            this.deregister();
        }
    }
}

