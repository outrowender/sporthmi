/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.tuner.TunerSDSHandler;
import de.audi.app.sdsmanager.apps.tuner.TunerSDSPicklistListener;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerCategorySetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerFrequencySetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerGenreSetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerListHideCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerListLineSetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerListShowCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerStationSetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerTrafficProgramSetCommand;
import de.audi.app.sdsmanager.apps.tuner.commands.TunerWaveBandSetCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.TunerServiceListener;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunerSDSHandlerImpl
extends AbstractSDSApplication
implements TunerSDSHandler,
TunerServiceListener,
TimerListener {
    protected final LogChannel lc = Logger.getAppTunerLog();
    protected final IDynamicLists dynamicLists;
    private ITTSASR ttsASR;
    private final int[] commands = new int[]{10003, 10006, 10007, 10009, 10002, 10001, 10005, 10000, 10004, 10008};
    private TunerService tunerService = new NullTunerService(this.lc);
    private int[] waveBands = new int[0];
    private final Map tunerStationLists = new HashMap();
    private SDSListEntry[] tunerGenreList = new SDSListEntry[0];
    private SDSListEntry[] tunerEnsembleListEntries = new SDSListEntry[0];
    protected Timer tunerListUpdateTimer;
    protected boolean pendingStationList = false;
    private boolean pendingEnsembleList = false;
    private boolean pendingGenreList = false;
    protected boolean pendingChannelNumberList = false;
    private final HMIService hmiService;
    private final ISDSPopupHelper sdsPopupHelper;
    private final SDSAppFactory appFactory;
    private long selectedStationID = -1L;

    public TunerSDSHandlerImpl(SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, HMIService hMIService, SDSAppFactory sDSAppFactory, ISDSPopupHelper iSDSPopupHelper) {
        super(sDSHandlerService, nBestStorageAccess);
        this.dynamicLists = iDynamicLists;
        new TunerSDSPicklistListener(hMIService, this);
        this.hmiService = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.tunerListUpdateTimer = new Timer("TunerListUpdateTimer", 5, this.lc, this, 10000L, true);
        this.appFactory = sDSAppFactory;
    }

    public void cancelTimer(Timer timer) {
        this.lc.log(10000000, "TunerSDSHandlerImpl#cancelTimer: timer=%1", (Object)timer);
    }

    public void fireTimer(Timer timer) {
        if (timer != this.tunerListUpdateTimer) {
            return;
        }
        this.lc.log(10000000, "[TunerSDSHandlerImpl#fireTimer] Updating all slot grammars!");
        if (this.pendingStationList) {
            this.updateSlotGrammars(-1000, 52);
        }
        this.pendingStationList = false;
        if (this.pendingEnsembleList) {
            this.updateSlotGrammars(-1001, 51);
        }
        this.pendingEnsembleList = false;
        if (this.pendingGenreList) {
            this.updateSlotGrammars(-1002, 53);
        }
        this.pendingGenreList = false;
        if (this.pendingChannelNumberList) {
            this.updateSlotGrammars(-1003, 55);
        }
        this.pendingChannelNumberList = false;
    }

    public void setTTSASR(ITTSASR iTTSASR) {
        this.ttsASR = iTTSASR;
    }

    public int[] getCommands() {
        return this.commands;
    }

    public void setTunerService(TunerService tunerService) {
        if (tunerService != null) {
            this.tunerService = tunerService;
        }
    }

    public TunerService getTunerService() {
        return this.tunerService;
    }

    public void unsetTunerService() {
        this.tunerService = new NullTunerService(this.lc);
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(10000000, "TunerSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 10003: {
                commandList.add(new TunerGenreSetCommand(this.lc, "TUNER_GENRESET", this.sdsHandlerService, this.nBestStorage, this.tunerService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL TUNER_GENRESET");
                break;
            }
            case 10006: {
                commandList.add(new TunerListHideCommand(this.lc, "TUNER_LISTHIDE", this.sdsHandlerService, iSystemCallParameterArray, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL TUNER_LISTHIDE");
                break;
            }
            case 10007: {
                commandList.add(new TunerListShowCommand(this.lc, "TUNER_LISTSHOW", this.sdsHandlerService, iSystemCallParameterArray, this.nBestStorage, this.tunerService, this.sdsPopupHelper, this.hmiService));
                commandList.execute("SYSTEMCALL TUNER_LISTSHOW");
                break;
            }
            case 10009: {
                commandList.add(new TunerListLineDataGetCommand(this.lc, "TUNER_LISTLINEDATAGET", this.sdsHandlerService, this.nBestStorage, this.hmiService));
                commandList.execute("SYSTEMCALL TUNER_LISTLINEDATAGET");
                break;
            }
            case 10002: {
                commandList.add(new TunerStationSetCommand(this.lc, "TUNER_STATIONSET", this.sdsHandlerService, this.nBestStorage, this.tunerService, this.appFactory.getSDSHandlerTuner(), iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL TUNER_STATIONSET");
                break;
            }
            case 10001: {
                commandList.add(new TunerFrequencySetCommand(this.lc, "TUNER_FREQUENCYSET", this.sdsHandlerService, this.nBestStorage, this.tunerService));
                commandList.execute("SYSTEMCALL TUNER_FREQUENCYSET");
                break;
            }
            case 10005: {
                commandList.add(new TunerWaveBandSetCommand(this.lc, "TUNER_WAVEBANDSET", this.sdsHandlerService, this.tunerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL TUNER_WAVEBANDSET");
                break;
            }
            case 10000: {
                commandList.add(new TunerCategorySetCommand(this.lc, "TUNER_CATEGORYSET", this.sdsHandlerService, this.nBestStorage, this.tunerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL TUNER_CATEGORYSET");
                break;
            }
            case 10004: {
                commandList.add(new TunerTrafficProgramSetCommand(this.lc, "TUNER_TRAFFICPROGRAMSET", this.sdsHandlerService, this.tunerService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL TUNER_TRAFFICPROGRAMSET");
                break;
            }
            case 10008: {
                commandList.add(new TunerListLineSetCommand(this.lc, "TUNER_LISTLINESET", this.sdsHandlerService, this.hmiService, this.tunerService));
                commandList.execute("SYSTEMCALL TUNER_LISTLINESET");
                break;
            }
            default: {
                this.lc.log(10000, "TunerSDSHandlerImpl#processCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    public String getName() {
        return "TunerSDSHandler";
    }

    public void updateBandList(int[] nArray) {
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateBandList] list=%1", (Object)nArray);
        if (nArray == null) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateBandList] Empty list!");
            return;
        }
        this.waveBands = nArray;
    }

    public void updateEnsembleList(SDSListEntry[] sDSListEntryArray) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "[TunerSDSHandlerImpl#updateEnsembleList] list=%1", (Object)SDSUtils.toString((Object[])sDSListEntryArray, false));
        }
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateEnsembleList] Empty list!");
            return;
        }
        boolean bl = this.tunerListUpdateTimer.isRunning();
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateEnsembleList] updateTimerRunning=%1", bl);
        this.tunerEnsembleListEntries = sDSListEntryArray;
        this.updateSpeakableEnsembleList();
        if (bl) {
            this.pendingEnsembleList = true;
            return;
        }
        this.updateSlotGrammars(-1001, 51);
    }

    public void updateGenreList(SDSListEntry[] sDSListEntryArray) {
        boolean bl = this.tunerListUpdateTimer.isRunning();
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateGenreList] updateTimerRunning=%1", bl);
        if (sDSListEntryArray == null || sDSListEntryArray.length == 0) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateGenreList] Empty entries!");
            this.tunerGenreList = new SDSListEntry[0];
            this.dynamicLists.removeFromLookup(53);
            return;
        }
        this.tunerGenreList = sDSListEntryArray;
        this.dynamicLists.addToLookup(53, new DynamicSlotContent("tuner genres", sDSListEntryArray, 0));
        if (bl) {
            this.pendingGenreList = true;
            return;
        }
        this.updateSlotGrammars(-1002, 53);
    }

    public void updateStationList(SDSListEntry[] sDSListEntryArray, int n) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "[TunerSDSHandlerImpl#updateStationList] list=%1, waveBand=%2", (Object)SDSUtils.toString((Object[])sDSListEntryArray, false), (long)n);
        }
        if (SDSUtils.isEmpty(sDSListEntryArray)) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateStationList] Empty list!");
            this.tunerStationLists.remove(new Integer(n));
            return;
        }
        boolean bl = this.tunerListUpdateTimer.isRunning();
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateStationList] updateTimerRunning=%1", bl);
        this.tunerStationLists.put(new Integer(n), sDSListEntryArray);
        this.updateSpeakableStationList();
        if (bl) {
            this.lc.log(10000000, "[TunerSDSHandlerImpl#updateStationList] Storing tuner station list grammar update due to running ignore timer!");
            this.pendingStationList = true;
            return;
        }
        this.updateSlotGrammars(-1000, 52);
    }

    protected void updateSlotGrammars(int n, int n2) {
        int n3 = SDSManagerBaseActivator.getMapping().getHMISlotGrammar(n2);
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateSlotGrammars] slotMappingID=%1, slotID=%2", (long)n2, (long)n3);
        if (!this.dynamicLists.contains(n3)) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateSlotGrammars] No slot entries available!");
            return;
        }
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateSlotGrammars] Restarting tuner list update timer!");
        this.tunerListUpdateTimer.restart();
        ITTSASRContext iTTSASRContext = this.ttsASR.createGrammarContext();
        iTTSASRContext.addToGrammar(n, new int[]{n3}, 8);
        this.ttsASR.setSlotGrammarContext(iTTSASRContext);
    }

    protected void updateSpeakableStationList() {
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateSpeakableStationList] called");
        SDSListEntry[] sDSListEntryArray = this.mergeAllEntries();
        if (sDSListEntryArray == null || sDSListEntryArray.length == 0) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateSpeakableStationList] Empty entries!");
            this.dynamicLists.removeFromLookup(52);
            return;
        }
        DynamicSlotContent dynamicSlotContent = new DynamicSlotContent("tuner stations", sDSListEntryArray, 0);
        this.dynamicLists.addToLookup(52, dynamicSlotContent);
    }

    private SDSListEntry[] mergeAllEntries() {
        this.lc.log(10000000, "[TunerSDSHandlerImpl#mergeAllEntries] called");
        List list = this.mergeListsFromSources(this.waveBands, this.tunerStationLists);
        this.lc.log(10000000, "[TunerSDSHandlerImpl#mergeAllEntries] Final entries array=%1", (Object)list);
        return (SDSListEntry[])list.toArray(new SDSListEntry[list.size()]);
    }

    protected List mergeListsFromSources(int[] nArray, Map map) {
        ArrayList arrayList = new ArrayList();
        int n = nArray.length;
        boolean bl = this.sdsHandlerService.getFramework().isNar();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            if (bl && n2 != 7 && n2 != 10) {
                this.lc.log(10000000, "[TunerSDSHandlerImpl#mergeListsFromSources] curSource=%1; ignore non-Sirius-stations because of NAR!", (long)n2);
                continue;
            }
            this.lc.log(10000000, "[TunerSDSHandlerImpl#mergeListsFromSources] curSource=%1!", (long)n2);
            Object[] objectArray = (SDSListEntry[])map.get(new Integer(n2));
            if (objectArray == null) {
                this.lc.log(100000, "[TunerSDSHandlerImpl#mergeListsFromSources] Empty list #%1!", (long)i2);
                continue;
            }
            if (this.lc.isDebug2()) {
                this.lc.log(100000000, "[TunerSDSHandlerImpl#mergeListsFromSources] curList=%1!", (Object)SDSUtils.toString(objectArray, false));
            }
            arrayList.addAll(Arrays.asList(objectArray));
        }
        return arrayList;
    }

    private void updateSpeakableEnsembleList() {
        this.lc.log(10000000, "[TunerSDSHandlerImpl#updateSpeakableEnsembleList] called");
        if (this.tunerEnsembleListEntries == null || this.tunerEnsembleListEntries.length == 0) {
            this.lc.log(100000, "[TunerSDSHandlerImpl#updateSpeakableEnsembleList] Empty tunerEnsembleEntries!");
            this.dynamicLists.removeFromLookup(51);
            return;
        }
        this.dynamicLists.addToLookup(51, new DynamicSlotContent("tuner ensembles", this.tunerEnsembleListEntries, 0));
    }

    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof TunerListLineDataGetCommand;
    }

    public void sdsListLineDataGet(int n, int n2) {
        this.lc.log(10000000, "TunerSDSHandlerImpl#sdsListLineDataGet: modelID=%1, absLine=%2", (long)n, (long)n2);
        try {
            ((TunerListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "TunerSDSHandlerImpl#sdsListLineDataGet: Active command is no TunerListLineDataGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "TunerSDSHandlerImpl#sdsListLineDataGet: NullpointerException. No active command!");
        }
    }

    public boolean freezeLists() {
        this.lc.log(10000000, "TunerSDSHandlerImpl#freezeLists: called");
        return this.tunerService.freezeDynamicLists() == 0;
    }

    public boolean unfreezeLists() {
        this.lc.log(10000000, "TunerSDSHandlerImpl#unfreezeLists: called");
        return this.tunerService.unfreezeDynamicLists() == 0;
    }

    public String toString() {
        return "TunerSDSHandlerImpl";
    }

    public long getSelectedStationID() {
        return this.selectedStationID;
    }

    public void setSelectedStationID(long l) {
        this.selectedStationID = l;
    }

    public SDSListEntry getGenreById(long l) {
        if (SDSUtils.isEmpty(this.tunerGenreList)) {
            return null;
        }
        int n = this.tunerGenreList.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (this.tunerGenreList[i2] == null || this.tunerGenreList[i2].getId() != l) continue;
            return this.tunerGenreList[i2];
        }
        return null;
    }

    public SDSListEntry[] getFavoritesList() {
        return (SDSListEntry[])this.tunerStationLists.get(new Integer(10));
    }

    public void updateChannelNumberList(SDSListEntry[] sDSListEntryArray) {
    }
}

