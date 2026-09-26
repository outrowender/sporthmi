/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandList;
import de.audi.tghu.navi.app.command.poi.online.SpellingSuggestionCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public abstract class AbstractOnlineSearchCommand
extends Command
implements DSIPoiOnlineSearchListener {
    protected DSIPoiOnlineSearch dsiOnlineSearch;
    public static final int SEARCH_RADIUS_KM;
    public static final int ERRORCODE_UNDEFINED;
    public static final int ERRORCODE_NOSIGNAL;
    public static final int ERRORCODE_CONNECTIONFAILED;
    public static final int ERRORCODE_PROXYDOWN;
    public static final int ERRORCODE_THIRDPARTYDOWN;
    protected int returnCode = 0;
    protected boolean spellingSuggestion;
    protected IOnlineSearchForm form;
    private OnlineSearchContext onlineSearchStatus;

    public AbstractOnlineSearchCommand(LogChannel logChannel) {
        super(logChannel);
    }

    public AbstractOnlineSearchCommand(LogChannel logChannel, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        super(logChannel);
        this.form = iOnlineSearchForm;
        this.onlineSearchStatus = onlineSearchContext;
    }

    @Override
    public void setCommandList(ICommandList iCommandList) {
        this.logger.log(1078071040, "OnlinePoiCommand#setCommandList()");
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof OnlinePoiCommandList)) {
            throw new ClassCastException("Expected OnlinePoiCommandList!");
        }
        OnlinePoiCommandList onlinePoiCommandList = (OnlinePoiCommandList)iCommandList;
        this.init(onlinePoiCommandList.getOnlineSearch());
    }

    protected void init(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.logger.log(1078071040, "OnlinePoiCommand#init()");
        this.dsiOnlineSearch = dSIPoiOnlineSearch;
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        this.logger.log(-2137614336, "AbstractOnlineSearchCommand#poiResult( %1, %2 )", (long)n2, (long)n3);
        this.returnCode = n3;
        if (n3 == 10 || n3 == 11 || n3 == 12) {
            return;
        }
        this.spellingSuggestion = false;
        try {
            this.form.indicateError(this.statusToErrorCode(n3), Integer.toString(n3));
        }
        catch (Exception exception) {
            this.logger.log(-2137614336, "AbstractOnlineSearchCommand#poiResult: exception occured %1", (Throwable)exception);
        }
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.logger.log(1078071040, "AbstractOnlineSearchCommand#poiValueList()");
        Buffer buffer = new Buffer();
        buffer.append("AbstractOnlineSearchCommand#poiValueList  valueList='").append(poiOnlineSearchValuelist.toString()).append("',totalItems='").append(n4).append("', indexOfFirstItem='").append(n3).append("', returnCode='").append(this.returnCode).append("'");
        this.logger.log(-2137614336, buffer.toString());
        int n5 = -1;
        if (this.returnCode == 11) {
            this.form.updateProvider(n2, poiOnlineSearchValuelist.sourceName, poiOnlineSearchValuelist.imageUrl, poiOnlineSearchValuelist.imageCheckSum, poiOnlineSearchValuelist.imageMapUrl, poiOnlineSearchValuelist.imageMapCheckSum, poiOnlineSearchValuelist.imageVoiceUrl, poiOnlineSearchValuelist.imageVoiceCheckSum);
            this.onlineSearchStatus.updateResults(n2, poiOnlineSearchValuelist, n3, n4, true, this.onlineSearchStatus.getResultList());
            n5 = this.form.updateResults(n2, poiOnlineSearchValuelist, n3, n4, true, this.onlineSearchStatus.getResultList());
            this.onlineSearchStatus.setResultsLength(n5);
            if (this.spellingSuggestion) {
                this.logger.log(-2137614336, "AbstractOnlineSearchCommand#poiValueList() Sending spelling suggestion request.");
                this.getCommandList().commandFinishedWithPostCommand(new SpellingSuggestionCommand(this.logger, this.form));
            } else {
                this.form.setResultsComplete();
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandFinished();
        }
        this.form.setResultLengthValue(4160, n5 <= 0 ? 0 : 1, 1);
    }

    protected int statusToErrorCode(int n) {
        int n2;
        this.logger.log(-2137614336, "AbstractOnlineSearchCommand#statusToErrorCode() status : %1", (long)n);
        if (n == 44) {
            return 4;
        }
        int n3 = n / 10;
        switch (n3) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            case 5: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    @Override
    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
    }
}

