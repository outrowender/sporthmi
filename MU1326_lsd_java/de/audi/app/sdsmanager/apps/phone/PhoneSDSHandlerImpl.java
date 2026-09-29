/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSPicklistListener;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceHandler;
import de.audi.app.sdsmanager.apps.phone.commands.AbstractPhoneCallCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneCallMailboxCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneLineDataGetTypeCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneListEntrySelectCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneListHideCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneListShowCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneNumberAddCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneNumberDeleteCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneNumberDialCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneNumberGetCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneRedialNumberCommand;
import de.audi.app.sdsmanager.apps.phone.commands.PhoneSiriActivateCommand;
import de.audi.app.sdsmanager.common.Const;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.PhoneServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.ITelServiceSDSListener$TelFavoriteSDSListEntry;
import de.audi.atip.phone.NullITelServiceSDS;
import de.audi.atip.phone.TelServiceCallStackEntry;
import de.audi.tghu.command.CommandList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneSDSHandlerImpl
extends AbstractSDSApplication
implements PhoneSDSHandler,
PhoneServiceListener,
ITelServiceSDSListener {
    private static final int[] commands = new int[]{30000, 30002, 30003, 30004, 30005, 30006, 30007, 30008, 30011, 30009, 30010, 30012, 1055};
    private final LogChannel lc = Logger.getAppPhoneLog();
    private ITelServiceSDS phoneService = new NullITelServiceSDS(this.lc);
    private final HMIService hmi;
    private final PhoneSequenceHandler sequenceHandler;
    private final IDynamicLists dynamicLists;
    private final SDSAppFactory factory;
    private ILanguageManager languageManager;
    private final ISDSPopupHelper sdsPopupHelper;
    private final MobileSpeechRecognitionHandler mobileSRHandler;
    private TelServiceCallStackEntry[] csEntries = new TelServiceCallStackEntry[0];
    private ITelServiceSDSListener$TelFavoriteSDSListEntry[] favEntries = new ITelServiceSDSListener$TelFavoriteSDSListEntry[0];
    private Map adbToCallStackMapping;

    public PhoneSDSHandlerImpl(HMIService hMIService, SDSHandlerService sDSHandlerService, IDynamicLists iDynamicLists, NBestStorageAccess nBestStorageAccess, SDSAppFactory sDSAppFactory, ILanguageManager iLanguageManager, ISDSPopupHelper iSDSPopupHelper, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler) {
        super(sDSHandlerService, nBestStorageAccess);
        this.hmi = hMIService;
        this.sequenceHandler = new PhoneSequenceHandler();
        this.dynamicLists = iDynamicLists;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.factory = sDSAppFactory;
        this.languageManager = iLanguageManager;
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
        new PhoneSDSPicklistListener(hMIService, this);
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl initialized.");
        this.adbToCallStackMapping = new HashMap();
    }

    @Override
    public int[] getCommands() {
        return commands;
    }

    @Override
    public Map getAdbToCallStackMapping() {
        return this.adbToCallStackMapping;
    }

    @Override
    public void sessionStarted() {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#sessionStarted: called");
        this.setPhoneSpeller((byte)0, this.phoneService.getNumberSpellerContent(), true);
        this.setPhoneSpeller((byte)2, this.phoneService.getMailboxSpellerContent(), true);
        this.setPhoneSpeller((byte)1, this.phoneService.getPINSpellerContent(), true);
    }

    @Override
    public boolean freezeLists() {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#freezeLists: called");
        return this.phoneService.freezeDynamicLists() == 0;
    }

    @Override
    public boolean unfreezeLists() {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#unfreezeLists: called");
        return this.phoneService.unfreezeDynamicLists() == 0;
    }

    @Override
    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 30000: {
                commandList.add(new PhoneCallMailboxCommand(this.lc, "PHONE_CALLMAILBOX", this.sdsHandlerService, this.phoneService, this.hmi, this));
                commandList.execute("SYSTEMCALL PHONE_CALLMAILBOX");
                break;
            }
            case 30002: {
                commandList.add(new PhoneNumberAddCommand(this.lc, "PHONE_NUMBERADD", this.sdsHandlerService, this.phoneService, this.nBestStorage, this.sequenceHandler, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_NUMBERADD");
                break;
            }
            case 30003: {
                commandList.add(new PhoneNumberDeleteCommand(this.lc, "PHONE_NUMBERDELETE", this.sdsHandlerService, this.sequenceHandler, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_NUMBERDELETE");
                break;
            }
            case 30004: {
                commandList.add(new PhoneNumberDialCommand(this.lc, "PHONE_NUMBERDIAL", this.sdsHandlerService, this.hmi, this.phoneService, this.factory, this.languageManager, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_NUMBERDIAL");
                break;
            }
            case 30005: {
                commandList.add(new PhoneNumberGetCommand(this.lc, "PHONE_NUMBERGET", this.sdsHandlerService, this.sequenceHandler, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_NUMBERGET");
                break;
            }
            case 30006: {
                commandList.add(new PhoneRedialNumberCommand(this.lc, "PHONE_REDIALNUMBER", this.sdsHandlerService, this.phoneService, this.factory.getSDSHandlerADB()));
                commandList.execute("SYSTEMCALL PHONE_REDIALNUMBER");
                break;
            }
            case 30007: {
                commandList.add(new PhoneListEntrySelectCommand(this.lc, "PHONE_LISTENTRYSELECT", this.sdsHandlerService, this, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_LISTENTRYSELECT");
                break;
            }
            case 30008: {
                commandList.add(new PhoneLineDataGetTypeCommand(this.lc, "PHONE_LINEDATAGETTYPE", this.sdsHandlerService, this, this.nBestStorage, this.factory.getSDSHandlerADB(), iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_LINEDATAGETTYPE");
                break;
            }
            case 30009: {
                commandList.add(new PhoneListShowCommand(this.lc, "PHONE_LISTSHOW", this.sdsHandlerService, iSystemCallParameterArray, this.nBestStorage, this.sdsPopupHelper, this.phoneService, this, this.hmi));
                commandList.execute("SYSTEMCALL PHONE_LISTSHOW");
                break;
            }
            case 30010: {
                commandList.add(new PhoneListHideCommand(this.lc, "PHONE_LISTHIDE", this.sdsHandlerService, this.sdsPopupHelper, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL PHONE_LISTHIDE");
                break;
            }
            case 30011: {
                commandList.add(new PhoneListLineDataGetCommand(this.lc, "PHONE_LISTLINEDATAGET", this.sdsHandlerService, this.nBestStorage, this.hmi));
                commandList.execute("SYSTEMCALL PHONE_LISTLINEDATAGET");
                break;
            }
            case 30012: {
                commandList.add(new PhoneSiriActivateCommand(this.lc, "PHONE_SIRIACTIVATE", this.sdsHandlerService, this.mobileSRHandler));
                commandList.execute("SYSTEMCALL PHONE_SIRIACTIVATE");
                break;
            }
            case 1055: {
                this.factory.getSDSHandlerSystem().processCommand(n, iSystemCallParameterArray);
                break;
            }
            default: {
                this.lc.log(-1601830656, "PhoneSDSHandlerImpl#processCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    @Override
    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof PhoneListLineDataGetCommand;
    }

    @Override
    public void sdsListLineDataGet(int n, int n2) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#sdsListLineDataGet: absLine=%1", (long)n2);
        try {
            ((PhoneListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "PhoneSDSHandlerImpl#sdsListLineDataGet: Active command is no PhoneListLineDataGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "PhoneSDSHandlerImpl#sdsListLineDataGet: NullpointerException. No active command!");
        }
    }

    @Override
    public void matchTextWithNumberSequenceDirect(String string) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#matchTextWithNumberSequenceDirect: number=%1", (Object)string);
        this.sequenceHandler.matchTextWithSequence(string, (byte)0);
    }

    @Override
    public void matchTextWithPINSequenceDirect(String string) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#matchTextWithPINSequenceDirect: code=%1", (Object)string);
        this.sequenceHandler.matchTextWithSequence(string, (byte)1);
    }

    @Override
    public void matchTextWithMailboxSequenceDirect(String string) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#matchTextWithMailboxSequenceDirect: number=%1", (Object)string);
        this.sequenceHandler.matchTextWithSequence(string, (byte)2);
    }

    @Override
    public void setPhoneService(ITelServiceSDS iTelServiceSDS) {
        if (iTelServiceSDS != null) {
            this.phoneService = iTelServiceSDS;
        }
    }

    @Override
    public ITelServiceSDS getPhoneService() {
        return this.phoneService;
    }

    @Override
    public void unsetPhoneService() {
        this.phoneService = new NullITelServiceSDS(this.lc);
    }

    @Override
    public void setPhoneSpeller(byte by, String string, boolean bl) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#setPhoneSpeller: type=%3, value=%1, clearAndMatchSequence=%2", (Object)string, (Object)bl, (long)by);
        switch (by) {
            case 0: {
                this.phoneService.setNumberSpeller(string);
                break;
            }
            case 1: {
                this.phoneService.setPINSpeller(string);
                break;
            }
            case 2: {
                this.phoneService.setMailboxSpeller(string);
                break;
            }
            default: {
                this.lc.log(-1601830656, "PhoneSDSHandlerImpl#setPhoneSpeller: Unhandled type %1!", (long)by);
                return;
            }
        }
        if (!bl) {
            return;
        }
        this.sequenceHandler.clearSequence(by);
        this.sequenceHandler.matchTextWithSequence(string, by);
    }

    @Override
    public int getCallStackLength() {
        return SDSUtils.isEmpty(this.csEntries) ? 0 : this.csEntries.length;
    }

    @Override
    public int getFavoritesLength() {
        return SDSUtils.isEmpty(this.favEntries) ? 0 : this.favEntries.length;
    }

    @Override
    public String getCallStackNumber(int n) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackNumber: csIndex=%1", (long)n);
        if (n < 0 || n >= this.csEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackNumber: Unhandled csIndex %1!", (long)n);
            return "";
        }
        return this.csEntries[n].getNumber();
    }

    @Override
    public long getCallStackAdbId(int n) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackAdbId: csIndex=%1", (long)n);
        if (n < 0 || n >= this.csEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackAdbId: Unhandled csIndex %1!", (long)n);
            return -1L;
        }
        return this.csEntries[n].getAdbEntryID();
    }

    @Override
    public short getCallStackPhoneType(int n) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackPhoneType: csIndex=%1", (long)n);
        if (n < 0 || n >= this.csEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackPhoneType: Unhandled csIndex %1!", (long)n);
            return -1;
        }
        return this.csEntries[n].getPhoneType();
    }

    @Override
    public int getCallStackIndexById(long l) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexById: csID=%1", l);
        if (SDSUtils.isEmpty(this.csEntries)) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackIndexById: No csEntries!");
            return -1;
        }
        int n = this.csEntries.length;
        for (int i2 = 0; i2 < n; ++i2) {
            TelServiceCallStackEntry telServiceCallStackEntry = this.csEntries[i2];
            if (telServiceCallStackEntry == null) {
                this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexById: entry #%1 is null!", (long)i2);
                continue;
            }
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexById: name[%2]=%1!", (Object)telServiceCallStackEntry.getName(), (long)i2);
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexById: entryID[%1]=%2, adbID[%1]=%3!", (long)i2, (long)telServiceCallStackEntry.getClEntryID(), telServiceCallStackEntry.getAdbEntryID());
            if ((long)telServiceCallStackEntry.getClEntryID() != l) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int getCallStackIndexByADBId(long l) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexByADBId: adbID=%1", l);
        if (SDSUtils.isEmpty(this.csEntries)) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackIndexByADBId: No csEntries!");
            return -1;
        }
        int n = this.csEntries.length;
        for (int i2 = 0; i2 < n; ++i2) {
            TelServiceCallStackEntry telServiceCallStackEntry = this.csEntries[i2];
            if (telServiceCallStackEntry == null) {
                this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexByADBId: entry #%1 is null!", (long)i2);
                continue;
            }
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexByADBId: name[%2]=%1!", (Object)telServiceCallStackEntry.getName(), (long)i2);
            long l2 = telServiceCallStackEntry.getAdbEntryID();
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackIndexByADBId: entryID[%1]=%2, adbID[%1]=%3!", (long)i2, (long)telServiceCallStackEntry.getClEntryID(), l2);
            if (l2 != l) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public String getCallStackName(int n) {
        if (n < 0 || n >= this.csEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getCallStackName: Unhandled csIndex %1!", (long)n);
            return "";
        }
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getCallStackName, index=%2: %1!", (Object)this.csEntries[n].toString(), (long)n);
        return this.csEntries[n].getName();
    }

    @Override
    public String getFavoriteNumber(int n) {
        if (n < 0 || n >= this.favEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getFavoriteNumber: Unhandled favIndex %1!", (long)n);
            return "";
        }
        return this.favEntries[n].getNumber();
    }

    @Override
    public String getFavoriteName(int n) {
        if (n < 0 || n >= this.favEntries.length) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#getFavoriteNumber: Unhandled favIndex %1!", (long)n);
            return "";
        }
        return this.favEntries[n].getName();
    }

    @Override
    public int getFavoriteIndexById(long l) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getFavoriteIndexById(%1) called", l);
        if (SDSUtils.isEmpty(this.favEntries)) {
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getFavoriteIndexById(), no csEntries");
            return -1;
        }
        int n = this.favEntries.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ITelServiceSDSListener$TelFavoriteSDSListEntry iTelServiceSDSListener$TelFavoriteSDSListEntry = this.favEntries[i2];
            if (iTelServiceSDSListener$TelFavoriteSDSListEntry == null) {
                this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getFavoriteIndexById() entry %1 = null", (long)i2);
                continue;
            }
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#getFavoriteIndexById() entry %2, name = %1, id = %3", (Object)iTelServiceSDSListener$TelFavoriteSDSListEntry.getName(), (long)i2, iTelServiceSDSListener$TelFavoriteSDSListEntry.getId());
            if (iTelServiceSDSListener$TelFavoriteSDSListEntry.getId() != l) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public void pauseSDS() {
        boolean bl = Boolean.getBoolean("sdsPauseActive");
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#pauseSDS: sdsPauseActive=%1", bl);
        if (!bl) {
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#pauseSDS: Pause deactivated, ignoring pauseSDS!");
            return;
        }
        if (this.sdsHandlerService.isSDSPaused()) {
            this.lc.log(-2137614336, "PhoneSDSHandlerImpl#pauseSDS: Already paused -> NOP!");
            return;
        }
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#pauseSDS: Pause activated, sending SDS_PAUSE!");
        this.sdsHandlerService.sendEvent(2);
    }

    @Override
    public void resumeSDS(boolean bl) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#resumeSDS: triggeredByUser=%1", bl);
        if (!this.sdsHandlerService.isSDSPaused()) {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#resumeSDS: SDS not paused => NOP!");
            return;
        }
        this.sdsHandlerService.sendResumeEvent(bl);
    }

    @Override
    public void switchEntertainment(boolean bl) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#switchEntertainment: switchOn=%1", bl);
        this.sdsHandlerService.switchEntertainment(bl);
    }

    @Override
    public void phoneStateChanged() {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#phoneStateChanged: called");
        this.sdsHandlerService.sendEvent(1008);
    }

    @Override
    public void favoritesListSelected(int n, boolean bl) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#favoritesListSelected: called");
    }

    @Override
    public void dialNumberResponse(int n) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#dialNumberResponse: result=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof AbstractPhoneCallCommand) {
            ((AbstractPhoneCallCommand)abstractSystemCallCommand).dialNumberResponse(n);
        } else {
            this.lc.log(-1601830656, "PhoneSDSHandlerImpl#dialNumberResponse: Call response not found!");
        }
    }

    @Override
    public void unlockSIMResponse(int n) {
    }

    @Override
    public void setMailboxResponse(int n) {
    }

    @Override
    public void updateCallStacks(TelServiceCallStackEntry[] telServiceCallStackEntryArray) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateCallStacks: called");
        this.csEntries = telServiceCallStackEntryArray == null ? new TelServiceCallStackEntry[]{} : telServiceCallStackEntryArray;
        int n = this.csEntries.length;
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateCallStacks: len=%1!", (long)n);
        HashSet hashSet = new HashSet();
        boolean bl = false;
        this.adbToCallStackMapping.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            TelServiceCallStackEntry telServiceCallStackEntry = this.csEntries[i2];
            if (telServiceCallStackEntry == null) {
                this.lc.log(-1601830656, "PhoneSDSHandlerImpl#updateCallStacks: Empty csEntries[%1]!", (long)i2);
                continue;
            }
            long l = telServiceCallStackEntry.getAdbEntryID();
            SDSListEntry sDSListEntry = new SDSListEntry(telServiceCallStackEntry.getName(), l);
            if (this.adbToCallStackMapping.containsKey(new Long(l))) continue;
            this.adbToCallStackMapping.put(new Long(l), sDSListEntry);
            int n2 = 1;
            if (hashSet.size() > Const.CALLSTACK_ENTRY_LIMIT) {
                this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateCallStacks: Limit (%1) for entries is reached!", (long)Const.CALLSTACK_ENTRY_LIMIT);
                hashSet.add(sDSListEntry);
                n2 = 0;
            } else if (hashSet.size() > Const.CALLSTACK_ENTRY_LIMIT / 2) {
                hashSet.add(sDSListEntry);
                n2 = 2;
            }
            String[] stringArray = SDSUtils.expandName(telServiceCallStackEntry.getName(), n2);
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                hashSet.add(new SDSListEntry(stringArray[i3], l));
            }
            if (l <= 0L) continue;
            bl = true;
        }
        SDSListEntry[] sDSListEntryArray = (SDSListEntry[])hashSet.toArray(new SDSListEntry[hashSet.size()]);
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateCallStacks: isMixedList=%1!", bl);
        SDSModelAccess.setPhoneCallStackContentModel(bl ? 1 : 0);
        this.dynamicLists.addToLookup(31, new DynamicSlotContent("phone call stack entries", sDSListEntryArray, 0));
    }

    @Override
    public void updateFavorites(ITelServiceSDSListener$TelFavoriteSDSListEntry[] iTelServiceSDSListener$TelFavoriteSDSListEntryArray) {
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateFavorites: called");
        this.favEntries = iTelServiceSDSListener$TelFavoriteSDSListEntryArray == null ? new ITelServiceSDSListener$TelFavoriteSDSListEntry[]{} : iTelServiceSDSListener$TelFavoriteSDSListEntryArray;
        switch (this.favEntries.length) {
            case 0: {
                SDSModelAccess.setPhoneFavoritesChoice(0);
                break;
            }
            case 1: {
                SDSModelAccess.setPhoneFavoritesChoice(1);
                break;
            }
            default: {
                SDSModelAccess.setPhoneFavoritesChoice(2);
            }
        }
        this.lc.log(-2137614336, "PhoneSDSHandlerImpl#updateFavorites, length=%1", (long)this.favEntries.length);
        this.dynamicLists.addToLookup(32, new DynamicSlotContent("phone favorites", this.favEntries, 0));
    }

    public static String getSpellerType(byte by) {
        switch (by) {
            case 0: {
                return "number";
            }
            case 2: {
                return "mailbox";
            }
            case 1: {
                return "pin";
            }
        }
        return "";
    }

    public String toString() {
        return "PhoneSDSHandlerImpl";
    }
}

