/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSDSSearchStartCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSDSSearchVoiceDataAvailableCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSDSSearchVoiceSearchActiveCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchSetLanguageCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlineSDSSearchSequence
implements NaviSDSPOIOnlineService {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected NaviSDSPOIOnlineServiceListener sdsServiceListener;
    private boolean lastSDSSearchIsOneshot;
    protected OnlineSearchSequence onlineSearchSequence = null;
    protected final ICommandListFactory commandListFactory;
    private DSIPoiOnlineSearch dsi;
    protected final IOnlineSearchForm form;
    private boolean isSearchCanceled = false;
    private boolean isDUMBlocked;

    public OnlineSDSSearchSequence(NavigationEnv navigationEnv, LogChannel logChannel, ICommandListFactory iCommandListFactory, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.onlineSearchSequence = onlineSearchSequence;
        this.form = iOnlineSearchForm;
    }

    public void setLanguage(Language language) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#setLanguage: %1", (Object)language);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new OnlineSearchSetLanguageCommand(this.logChannel, language));
        commandList.execute("OnlineSDSSearchSequence#setLanguage");
    }

    public byte poiOnlineSearchInit(boolean bl, int n, String string) {
        if (this.onlineSearchSequence == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - OnlineSearchService is null");
            return 1;
        }
        if (this.dsi == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - DSI is null");
            return 1;
        }
        try {
            this.setLanguage(this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI"));
            this.setLanguage(this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI"));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - Error setting language");
        }
        this.setSearchCanceled(false);
        this.form.setResultLengthValue(4160, 0, 0);
        this.blockDUM(false);
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - calling poiVoiceSearchActive, oneshot=%1", bl);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.setErrorCommand(new AbstractOnlineSearchCommand(this.logChannel, this.form, this.onlineSearchSequence.getSearchContext()){

            public void execute() {
                OnlineSDSSearchSequence.this.indicateError(46);
                this.form.setResultLengthValue(4160, 0, 2);
            }
        });
        commandList.add(new OnlineSDSSearchVoiceSearchActiveCommand(this.logChannel));
        NavLocation navLocation = this.onlineSearchSequence.getSearchContext().getSearchArea().getNavLocation();
        if (navLocation == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - searchContext is null");
            return 1;
        }
        int n2 = navLocation.latitude;
        int n3 = navLocation.longitude;
        this.logChannel.log(10000000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - calling poiStartVoiceSelection with lat=%1 and lon=%2", (long)n2, (long)n3);
        commandList.add(new OnlineSDSSearchStartCommand(this.logChannel, n2, n3, bl, this.form));
        this.setLastSDSSearchIsOneshot(bl);
        if (bl) {
            this.logChannel.log(10000000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - oneshot, calling poiRawVoiceDataAvailable, path is %1, format is %2", (Object)string, (Object)Integer.toString(n));
            commandList.add(new OnlineSDSSearchVoiceDataAvailableCommand(this.logChannel, this.form, this.onlineSearchSequence.getSearchContext(), this, string, n, true));
        }
        commandList.execute("OnlineSDSSearchSequence#poiOnlineSearchInit");
        return 0;
    }

    private void setLastSDSSearchIsOneshot(boolean bl) {
        this.lastSDSSearchIsOneshot = bl;
    }

    public boolean getLastSDSSearchIsOneshot() {
        return this.lastSDSSearchIsOneshot;
    }

    public byte poiOnlineVoiceDataAvailable(String string, int n) {
        if (this.onlineSearchSequence == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineVoiceDataAvailable() - OnlineSearchService is null");
            return 1;
        }
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineVoiceDataAvailable() - calling poiOnlineVoiceDataAvailable(%1, %2)", (Object)string, (Object)Integer.toString(n));
        if (this.dsi == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineVoiceDataAvailable() - DSIPoiOnlineSearch is null");
            return 1;
        }
        this.setSearchCanceled(false);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new OnlineSDSSearchVoiceDataAvailableCommand(this.logChannel, this.form, this.onlineSearchSequence.getSearchContext(), this, string, n, true));
        commandList.setErrorCommand(new AbstractOnlineSearchCommand(this.logChannel, this.form, this.onlineSearchSequence.getSearchContext()){

            public void execute() {
                OnlineSDSSearchSequence.this.indicateError(46);
                this.form.setResultLengthValue(4160, 0, 2);
            }
        });
        commandList.execute("OnlineSDSSearchSequence#poiOnlineVoiceDataAvailable");
        return 0;
    }

    public void setNaviSDSPOIOnlineServiceListener(NaviSDSPOIOnlineServiceListener naviSDSPOIOnlineServiceListener) {
        this.logChannel.log(10000000, "OnlineSDSSearchSequence#poiOnlineVoiceDataAvailable() - got instance %1", (Object)naviSDSPOIOnlineServiceListener);
        this.sdsServiceListener = naviSDSPOIOnlineServiceListener;
    }

    public void poiValueList(PoiOnlineSearchValuelist poiOnlineSearchValuelist, String[] stringArray) {
        if (this.sdsServiceListener == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiValueList() - SDS service is null");
            return;
        }
        if (poiOnlineSearchValuelist == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiValueList() - valuelist is null");
            return;
        }
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = poiOnlineSearchValuelist.getList();
        if (poiOnlineSearchValuelistElementArray == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiValueList() - valuelist.getList() is null");
            return;
        }
        String string = "";
        if (poiOnlineSearchValuelist.recognitionList != null && poiOnlineSearchValuelist.recognitionList.length > 0 && poiOnlineSearchValuelist.recognitionList[0].recognizedTerm != null) {
            string = poiOnlineSearchValuelist.recognitionList[0].recognizedTerm;
            this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiValueList() - search term '%1' found", (Object)string);
            String string2 = null;
            try {
                string2 = URLDecoder.decode(string, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiValueList() - could not decode recognizedTerm %1", (Object)string);
            }
            if (string2 != null && string2.length() > 0) {
                string2 = string;
            }
            this.form.setSearchTextLabel(string2);
            this.form.addToSearchHistorySDS(string2);
        } else {
            this.logChannel.log(100000, "OnlineSDSSearchSequence#poiValueList() - no recognized term found in valuelist");
        }
        this.sdsServiceListener.updatePOIOnlineSearchResults((byte)0, string, stringArray);
    }

    public byte poiOnlineSearchCancel() {
        return 0;
    }

    public boolean indicateError(int n) {
        return false;
    }

    protected byte getSDSReturnCode(int n) {
        switch (n) {
            case 57: 
            case 61: {
                return 6;
            }
            case 59: {
                return 4;
            }
            case 58: 
            case 62: {
                return 5;
            }
            case 41: 
            case 51: {
                return 3;
            }
            case 10: 
            case 11: 
            case 12: {
                return 0;
            }
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: {
                return 2;
            }
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: {
                return 9;
            }
            case 63: {
                return 8;
            }
        }
        return 1;
    }

    private void notifySetSearchAreaResult(boolean bl) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#notifySetSearchAreaResult(%1)", bl);
        if (this.sdsServiceListener == null) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#notifySetSearchAreaResult(): no SDS service listener");
            return;
        }
        this.sdsServiceListener.poiOnlineSetSearchAreaResult(bl ? (byte)0 : 1);
    }

    public void poiOnlineSetSearchArea(byte by) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineSetSearchArea(%1)", (long)by);
        try {
            if (this.onlineSearchSequence == null) {
                this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSetSearchArea(): onlineSearchSequence is null");
                return;
            }
            boolean bl = true;
            if (by == 0) {
                bl = this.onlineSearchSequence.setSearchArea(0);
            } else if (by == 1) {
                bl = this.onlineSearchSequence.setSearchArea(1);
            } else if (by == 6) {
                bl = this.onlineSearchSequence.setSearchArea(2);
            } else if (by == 2) {
                NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
                if (navLocation == null) {
                    this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineSetSearchArea(%1): location is null", (long)by);
                    bl = false;
                } else {
                    bl = this.onlineSearchSequence.setSearchArea(3, navLocation);
                }
            }
            this.notifySetSearchAreaResult(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineSetSearchArea(): Exception %1", (Throwable)exception);
        }
    }

    public void markCurrentPOIUsedFor(byte by) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#markCurrentPOIUsedFor(%1)", (long)by);
        int n = -1;
        switch (by) {
            case 3: {
                n = 12;
                break;
            }
            case 2: {
                n = 10;
                break;
            }
            case 1: {
                n = 11;
                break;
            }
            default: {
                n = 0;
            }
        }
        this.onlineSearchSequence.markCurrentResultUsedFor(n);
    }

    public void poiOnlineSearchDidYouMean() {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineSearchDidYouMean()");
        this.form.startSearchWithSpellingSuggestion();
    }

    public int getCurrentPOIOnlineListSize() {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#getCurrentPOIOnlineListSize()");
        PoiOnlineSearchValuelist poiOnlineSearchValuelist = this.onlineSearchSequence.getCurrentPOIOnlineList();
        if (poiOnlineSearchValuelist == null) {
            return 0;
        }
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = poiOnlineSearchValuelist.getList();
        if (poiOnlineSearchValuelistElementArray == null) {
            return 0;
        }
        return poiOnlineSearchValuelistElementArray.length;
    }

    public void resetCurrentPOIOnlineList() {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#resetCurrentPOIOnlineList: clearing result list");
        this.form.clearResultList();
    }

    public void setDSIPoiOnlineSearch(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineSearchInit() - setting DSI to %1", (Object)dSIPoiOnlineSearch);
        this.dsi = dSIPoiOnlineSearch;
    }

    public void poiOnlineShowList(byte by) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineShowList() - list type %1", (long)by);
        if (by == 0) {
            this.form.showList(0);
        } else if (by == 1) {
            this.form.showList(1);
        } else if (by == 2) {
            if (this.isDUMBlocked) {
                this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineShowList() - DUM is blocked, not showing PP");
                return;
            }
            this.logChannel.log(1000000, "OnlineSDSSearchSequence#poiOnlineShowList() - clearing list -> show PP");
            this.form.clearResultList();
        } else {
            this.logChannel.log(10000, "OnlineSDSSearchSequence#poiOnlineShowList() - invalid param %1", (long)by);
        }
    }

    public void selectDestination(int n) {
    }

    public void blockDUM(boolean bl) {
        this.logChannel.log(1000000, "OnlineSDSSearchSequence#blockDUM() - %1 DUM", (Object)(bl ? "blocking" : "unblocking"));
        this.isDUMBlocked = bl;
    }

    public boolean isSearchCanceled() {
        return this.isSearchCanceled;
    }

    public void setSearchCanceled(boolean bl) {
        this.isSearchCanceled = bl;
    }
}

