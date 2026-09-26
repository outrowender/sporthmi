/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.OptionalSerializer;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;
import de.audi.app.combi.bap.functionsync.CommandUpdateFunctions$1;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.requests.StatusProperty;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandUpdateFunctions
extends AbstractFunctionSynchronizationCommand
implements BAPFunctionDataListener,
IAcknowledgeListener {
    private static final Integer WAITING_FOR_UPDATE = new Integer(0);
    private static final Integer WAITING_FOR_ACKNOWLEDGE = new Integer(1);
    private static final int INCOMPLETE_SYNC_TIMEOUT_DELAY;
    private final Timer incompleteSyncTimeoutTimer;
    private final Map bapPropertiesToBeSynced = new HashMap(10);
    private final ConcurrentMap queuedPropertiesUpdates = new ConcurrentHashMap();
    private volatile boolean queuedPropertiesSent = false;
    private boolean commandFinished = false;

    public CommandUpdateFunctions(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandUpdateFunctions");
        this.init();
        this.incompleteSyncTimeoutTimer = new Timer("IncompleteSynchronizationTimeoutTimer", 0, true, new TimerSyncer(new CommandUpdateFunctions$1(this)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void init() {
        int[] nArray = this.functionSync.getFunctionsToBeSynchronized();
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (this.moduleFsg.getFunctionList().isFunctionSupported(nArray[i2])) {
                    BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(nArray[i2]);
                    this.bapPropertiesToBeSynced.put(bAPFunctionPropertyFSG, WAITING_FOR_UPDATE);
                    bAPFunctionPropertyFSG.setControlledByFunctionSync(true);
                    bAPFunctionPropertyFSG.addDataListener(this);
                    continue;
                }
                this.logger.log(-2137614336, "[CommandUpdateFunctions#init] [%1] fctID=%2 not supported -> don't add to function sync", (Object)this.functionSync.getSyncTypeDescription(), (long)nArray[i2]);
            }
        }
    }

    @Override
    public void execute() {
        if (this.functionSync.isCanceled()) {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#execute] [%1], functionSync was canceled -> finish command immediately", (Object)this.functionSync.getSyncTypeDescription());
            this.commandList.commandFinished();
        } else {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#execute] [%1] called", (Object)this.functionSync.getSyncTypeDescription());
            this.sendQueuedRequests();
            this.incompleteSyncTimeoutTimer.restart();
        }
    }

    @Override
    public void abort() {
        this.logger.log(-2137614336, "[CommandUpdateFunctions#abort] [%1] called", (Object)this.functionSync.getSyncTypeDescription());
        this.reset();
        this.sendQueuedRequests();
        super.abort();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void reset() {
        this.incompleteSyncTimeoutTimer.cancel();
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#reset] [%1] called", (Object)this.functionSync.getSyncTypeDescription());
            if (!this.bapPropertiesToBeSynced.isEmpty()) {
                this.removeAllListeners();
                this.bapPropertiesToBeSynced.clear();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeAllListeners() {
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#removeAllListeners] [%1] called", (Object)this.functionSync.getSyncTypeDescription());
            Iterator iterator = this.bapPropertiesToBeSynced.keySet().iterator();
            while (iterator.hasNext()) {
                BAPFunctionPropertyFSG bAPFunctionPropertyFSG = (BAPFunctionPropertyFSG)iterator.next();
                if (bAPFunctionPropertyFSG == null) continue;
                bAPFunctionPropertyFSG.removeDataListener(this);
                bAPFunctionPropertyFSG.removeAcknowledgeListener(this);
                bAPFunctionPropertyFSG.setControlledByFunctionSync(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyDataChanged(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(n);
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            if (this.bapPropertiesToBeSynced.containsKey(bAPFunctionPropertyFSG) && this.bapPropertiesToBeSynced.get(bAPFunctionPropertyFSG).equals(WAITING_FOR_UPDATE)) {
                this.logger.log(-2137614336, "[CommandUpdateFunctions#notifyDataChanged] [%1] received update of property (lsgID=%2, fctID=%3) -> wait for acknowledge", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n));
                this.bapPropertiesToBeSynced.put(bAPFunctionPropertyFSG, WAITING_FOR_ACKNOWLEDGE);
                bAPFunctionPropertyFSG.addAcknowledgeListener(this);
            }
        }
    }

    @Override
    public void notifyDataValidChanged(int n, boolean bl) {
    }

    @Override
    public void notifyDataUpdatedNoChange(int n) {
        this.logger.log(-2137614336, "[CommandUpdateFunctions#notifyDataUpdatedNoChange] [%1] update received for fctID=%2", (Object)this.functionSync.getSyncTypeDescription(), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n));
        if (this.functionSync.getSyncState() == 2) {
            this.removeFunction(n);
        } else {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#notifyDataUpdatedNoChange] [%1] function sync state is %2 -> enqueue update", (Object)this.functionSync.getSyncTypeDescription(), (long)this.functionSync.getSyncState());
            this.markPropertyUpdated(this.moduleFsg.getBAPFunctionPropertyFSG(n), OptionalSerializer.withoutValue());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processAcknowledge(int n, int n2) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(n);
        if (n2 == 0) {
            boolean bl;
            Map map = this.bapPropertiesToBeSynced;
            synchronized (map) {
                if (this.bapPropertiesToBeSynced.containsKey(bAPFunctionPropertyFSG) && this.bapPropertiesToBeSynced.get(bAPFunctionPropertyFSG).equals(WAITING_FOR_ACKNOWLEDGE)) {
                    this.logger.log(-2137614336, "[CommandUpdateFunctions#processAcknowledge] [%1] received acknowledge of property (lsgID=%2, fctID=%3) -> update of property finished", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n));
                    bl = true;
                } else {
                    this.logger.log(-1601830656, "[CommandUpdateFunctions#processAcknowledge] [%1] received acknowledge of property (lsgID=%2, fctID=%3) -> prior update not received", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n));
                    bl = false;
                }
            }
            if (bl) {
                this.removeFunction(n);
            }
        }
    }

    public boolean enqueuePropertyUpdate(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, StatusProperty statusProperty) {
        return this.markPropertyUpdated(bAPFunctionPropertyFSG, OptionalSerializer.withValue(statusProperty));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean markPropertyUpdated(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, OptionalSerializer optionalSerializer) {
        ConcurrentMap concurrentMap = this.queuedPropertiesUpdates;
        synchronized (concurrentMap) {
            if (this.queuedPropertiesSent) {
                return false;
            }
            this.logger.log(-2137614336, "[CommandUpdateFunctions#enqueuePropertyUpdate] [%1] fctID=%2", (Object)this.functionSync.getSyncTypeDescription(), (Object)bAPFunctionPropertyFSG.getFctIDDescription());
            this.queuedPropertiesUpdates.put(bAPFunctionPropertyFSG, optionalSerializer);
            return true;
        }
    }

    public boolean isQueuedPropertiesSent() {
        return this.queuedPropertiesSent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendQueuedRequests() {
        ConcurrentMap concurrentMap = this.queuedPropertiesUpdates;
        synchronized (concurrentMap) {
            Object object;
            Object object2;
            if (this.logger.isDebug()) {
                object2 = new Buffer();
                object = this.queuedPropertiesUpdates.keySet().iterator();
                while (object.hasNext()) {
                    BAPFunctionPropertyFSG bAPFunctionPropertyFSG = (BAPFunctionPropertyFSG)object.next();
                    ((Buffer)object2).append("\n");
                    ((Buffer)object2).append(bAPFunctionPropertyFSG.getFctIDDescription());
                    ((Buffer)object2).append(" -> update=");
                    ((Buffer)object2).append(this.queuedPropertiesUpdates.get(bAPFunctionPropertyFSG) != null);
                }
                this.logger.log(-2137614336, "[CommandUpdateFunctions#sendQueuedRequests] [%1] %2", (Object)this.functionSync.getSyncTypeDescription(), object2);
            }
            object2 = this.queuedPropertiesUpdates.keySet().iterator();
            while (object2.hasNext()) {
                object = (BAPFunctionPropertyFSG)object2.next();
                this.processQueued((BAPFunctionPropertyFSG)object, (OptionalSerializer)this.queuedPropertiesUpdates.get(object));
                this.queuedPropertiesUpdates.remove(object);
            }
            this.queuedPropertiesSent = true;
        }
    }

    private void processQueued(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, OptionalSerializer optionalSerializer) {
        if (optionalSerializer.hasValue()) {
            bAPFunctionPropertyFSG.sendQueued((StatusProperty)optionalSerializer.getValue());
        } else {
            this.removeFunction(bAPFunctionPropertyFSG.getFctID());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeFunction(int n) {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(n);
        boolean bl = false;
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            if (this.bapPropertiesToBeSynced.keySet().contains(bAPFunctionPropertyFSG)) {
                bAPFunctionPropertyFSG.removeDataListener(this);
                bAPFunctionPropertyFSG.removeAcknowledgeListener(this);
                this.bapPropertiesToBeSynced.remove(bAPFunctionPropertyFSG);
                bAPFunctionPropertyFSG.setControlledByFunctionSync(false);
                this.logger.log(-2137614336, "[CommandUpdateFunctions#removeFunction] [%1] fctID=%2, still pending: %3", (Object)this.functionSync.getSyncTypeDescription(), (Object)bAPFunctionPropertyFSG.getFctIDDescription(), (Object)this.logPendingFunctions());
                bl = this.bapPropertiesToBeSynced.isEmpty();
            }
        }
        if (bl) {
            this.logger.log(-2137614336, "[CommandUpdateFunctions#removeFunction] [%1] all relevant data updated -> perform auto complete of synchronization (lsgID=%2)", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()));
            this.finishCommand();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String logPendingFunctions() {
        Buffer buffer = new Buffer();
        Map map = this.bapPropertiesToBeSynced;
        synchronized (map) {
            Iterator iterator = this.bapPropertiesToBeSynced.keySet().iterator();
            while (iterator.hasNext()) {
                buffer.append(((BAPFunctionPropertyFSG)iterator.next()).getFctIDDescription());
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
        }
        return buffer.length() == 0 ? "[NONE]" : buffer.toString();
    }

    private void finishCommand() {
        this.logger.log(-2137614336, "[CommandUpdateFunctions#finishCommand] [%1] lsgID=%2", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()));
        this.commandFinished = true;
        this.reset();
        this.commandList.commandFinished();
    }

    static /* synthetic */ Timer access$000(CommandUpdateFunctions commandUpdateFunctions) {
        return commandUpdateFunctions.incompleteSyncTimeoutTimer;
    }

    static /* synthetic */ boolean access$100(CommandUpdateFunctions commandUpdateFunctions) {
        return commandUpdateFunctions.commandFinished;
    }

    static /* synthetic */ LogChannel access$200(CommandUpdateFunctions commandUpdateFunctions) {
        return commandUpdateFunctions.logger;
    }

    static /* synthetic */ void access$300(CommandUpdateFunctions commandUpdateFunctions) {
        commandUpdateFunctions.finishCommand();
    }
}

