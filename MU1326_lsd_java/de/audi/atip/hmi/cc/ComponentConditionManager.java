/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.cc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.cc.ComponentConditionTable;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.cc.PendingCCIDs;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.modelaccess.ModelInternals;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.IntList;
import java.util.NoSuchElementException;

public class ComponentConditionManager
implements IComponentConditionManager {
    private final HMIBundle[] hmiBundles = new HMIBundle[100];
    private final LogChannel lc;
    private final ComponentConditionTable ccTable = new ComponentConditionTable();
    private final PendingCCIDs pendingCCIDs = new PendingCCIDs();
    static /* synthetic */ Class class$de$audi$atip$hmi$cc$IComponentConditionManager;

    public ComponentConditionManager(IFrameworkAccess iFrameworkAccess) {
        this.lc = iFrameworkAccess.getLogChannel("Fw.HMIService.Conditions");
        iFrameworkAccess.getBundleCxt().registerService((class$de$audi$atip$hmi$cc$IComponentConditionManager == null ? (class$de$audi$atip$hmi$cc$IComponentConditionManager = ComponentConditionManager.class$("de.audi.atip.hmi.cc.IComponentConditionManager")) : class$de$audi$atip$hmi$cc$IComponentConditionManager).getName(), (Object)this, null);
    }

    public void add(HMIBundle hMIBundle) {
        this.hmiBundles[hMIBundle.getId()] = hMIBundle;
        int[] nArray = this.pendingCCIDs.toArray();
        this.lc.log(10000000, "[CCM.add] HMIBundle ID:%2 %1", (Object)hMIBundle, (long)hMIBundle.getId());
        if (nArray.length > 0) {
            this.lc.log(10000000, "[CCM.add] Activate pending ccIDs %1", (Object)nArray);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.activateCC(nArray[i2]);
            }
        }
    }

    public void remove(HMIBundle hMIBundle) {
        this.lc.log(10000000, "[CCM.remove] ID:%2 HMIBundle:%1", (Object)hMIBundle, (long)hMIBundle.getId());
        if (hMIBundle == this.hmiBundles[hMIBundle.getId()]) {
            this.hmiBundles[hMIBundle.getId()] = null;
        }
    }

    public void activateCC(int n) {
        int[] nArray = this.getModelsByCondition(n);
        try {
            this.ccTable.add(n, nArray);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (this.getBundle(nArray[i2]) != null) {
                    ((ModelInternals)((Object)this.getHMIService().getModel(nArray[i2]))).addCondition(n, this);
                    continue;
                }
                this.lc.log(10000000, "[CCM.activateCC] ccID:%1 No HMI bundle registered yet for model %2", (long)n, (long)nArray[i2]);
                this.pendingCCIDs.add(n);
            }
        }
        catch (Exception exception) {
            this.lc.log(1000, "[CCM.activateCC] CCID:%2 modelIDs:%1", (Object)nArray, (long)n);
            this.lc.log(1000, "[CCM.activateCC]", (Throwable)exception);
        }
    }

    public void deactivateCC(int n) {
        try {
            int[] nArray = this.getModelsByCondition(n);
            this.pendingCCIDs.remove(n);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                ModelInternals modelInternals = (ModelInternals)((Object)this.getHMIService().getModel(nArray[i2]));
                if (modelInternals != null) {
                    modelInternals.removeCondition(n);
                    continue;
                }
                this.lc.log(10000, "[CCM.deactivateCC] ccID:%1 model %2 not found!", (long)n, (long)nArray[i2]);
            }
            this.lc.log(10000000, "[CCM.deactivateCC] ccID:%2 modelIDs:%1", (Object)nArray, (long)n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[CCM.deactivateCC] ccID:%1", (long)n, (Throwable)exception);
        }
    }

    public boolean isTrue(int n, int n2) {
        return this.evaluate(this.getCondition(n), n2);
    }

    public void modelStateChanged(int n, int n2) {
        int[] nArray = this.ccTable.getConditionIDs(n);
        IntList intList = new IntList(nArray.length);
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "[CCM.modelStateChanged] model:%2 conditionIDs:%1", (Object)Converter.array2String(nArray), (long)n);
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n3 = nArray[i2];
            AbstractCondition abstractCondition = this.getCondition(n3);
            boolean bl = this.evaluate(abstractCondition, n2);
            boolean bl2 = this.ccTable.updateConditionState(n3, bl);
            if (!bl2) continue;
            intList.add(n3);
        }
        if (!intList.isEmpty()) {
            int[] nArray2 = intList.toArray();
            this.lc.log(10000000, "[CCM.modelStateChanged] model:%2 changedCCIDs:%1", (Object)nArray2, (long)n);
            this.getHMIService().postComponentConditionEvent(nArray2);
        }
    }

    private boolean evaluate(AbstractCondition abstractCondition, int n) {
        try {
            return abstractCondition.evaluate(n);
        }
        catch (NoSuchElementException noSuchElementException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (Exception exception) {
            this.lc.log(10000000, "[CCM.evaluate] Call failed!", (Throwable)exception);
            return false;
        }
    }

    private int[] getModelsByCondition(int n) {
        return this.getCondition(n).getModelIds();
    }

    private AbstractCondition getCondition(int n) {
        HMIBundle hMIBundle = this.getBundle(n);
        if (hMIBundle == null) {
            this.lc.log(10000, "[ConditionsObserver.getCondition] No HMIBundle found for condition ID %1!", (long)n);
            return new NullCondition(n);
        }
        HMIConditionBank hMIConditionBank = hMIBundle.getConditionBank();
        if (hMIConditionBank == null) {
            this.lc.log(10000, "[ConditionsObserver.getCondition] No HMIConditionBank found for condition ID %1!", (long)n);
            return new NullCondition(n);
        }
        AbstractCondition abstractCondition = hMIConditionBank.getCondition(n);
        if (abstractCondition == null) {
            this.lc.log(10000, "[ConditionsObserver.getCondition] Condition %1 not found!", (long)n);
            return new NullCondition(n);
        }
        return abstractCondition;
    }

    private HMIBundle getBundle(int n) {
        int n2 = n / 100000;
        if (n2 < 0 || n2 >= this.hmiBundles.length || this.hmiBundles[n2] == null) {
            return null;
        }
        return this.hmiBundles[n2];
    }

    private HMIService getHMIService() {
        return AbstractModelBank.getHMIservice();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static class NullCondition
    extends AbstractCondition {
        public NullCondition(int n) {
        }

        public int[] getModelIds() {
            return new int[0];
        }

        public boolean evaluate(int n) {
            return false;
        }
    }
}

