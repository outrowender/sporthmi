/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.calllist.AbstractCallListBaseListModelHandler;
import de.audi.app.phone.evo.intellicall.PhoneCallEvoListRow;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

public abstract class AbstractIntellicallCallListModelHandler
extends AbstractCallListBaseListModelHandler
implements OptionModelListener {
    public AbstractIntellicallCallListModelHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    @Override
    public void init() {
        super.init();
        int n = this.getCallListList().getID();
        this.getOptionModel(-1835727872).setListener(this, n);
        this.getOptionModel(-1818950656).setListener(this, n);
        this.getOptionModel(-1802173440).setListener(this, n);
        this.getOptionModel(-1751841792).setListener(this, n);
        this.getOptionModel(-1735064576).setListener(this, n);
        this.getOptionModel(-1768619008).setListener(this, n);
        this.getOptionModel(-1785396224).setListener(this, n);
        this.getOptionModel(-1902836736).setListener(this, n);
        this.getOptionModel(-1886059520).setListener(this, n);
        this.getOptionModel(395838464).setListener(this, n);
        this.getOptionModel(-1852505088).setListener(this, n);
    }

    @Override
    public void deinit() {
        super.deinit();
        int n = this.getCallListList().getID();
        this.getOptionModel(-1835727872).removeListener(n);
        this.getOptionModel(-1818950656).removeListener(n);
        this.getOptionModel(-1802173440).removeListener(n);
        this.getOptionModel(-1751841792).removeListener(n);
        this.getOptionModel(-1735064576).removeListener(n);
        this.getOptionModel(-1768619008).removeListener(n);
        this.getOptionModel(-1785396224).removeListener(n);
        this.getOptionModel(-1902836736).removeListener(n);
        this.getOptionModel(-1886059520).removeListener(n);
        this.getOptionModel(395838464).removeListener(n);
        this.getOptionModel(-1852505088).removeListener(n);
    }

    @Override
    protected EvoListRow getNewListRow(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, int n, LogChannel logChannel) {
        return new PhoneCallEvoListRow(abstractPhoneCall, iGlobalTelephoneStateStruct.getCallLeadingDevice(), iGlobalTelephoneStateStruct.getNonCallLeadingDevice(), n, logChannel, 16, this.getApplication());
    }

    @Override
    protected void callSelected(EvoListRow evoListRow, int n) {
        if (evoListRow == null) {
            this.log.log(10000, "[AbstractIntellicallCallListModelHandler#callSelected] row is null.");
            return;
        }
        PhoneCallEvoListRow phoneCallEvoListRow = (PhoneCallEvoListRow)evoListRow;
        int n2 = phoneCallEvoListRow.getPrimaryAction();
        this.log.log(-2137614336, "[AbstractIntellicallCallListModelHandler#itemSelected] call=%1", (Object)phoneCallEvoListRow);
        switch (n2) {
            case 0: {
                int n3 = phoneCallEvoListRow.getCallID();
                this.log.log(-2137614336, "[AbstractIntellicallCallListModelHandler#itemSelected] hanging up call with id %1", (long)n3);
                this.getApplication().getCallControl().hangupCall(n3, n);
                break;
            }
            case 1: {
                if (phoneCallEvoListRow.call.telCallState == 8) {
                    this.getApplication().getTelephoneDSIAccess().acceptCall(n);
                    break;
                }
                this.getApplication().getTelephoneDSIAccess().swapCalls(n);
                break;
            }
            default: {
                this.log.log(-2137614336, "[AbstractIntellicallCallListModelHandler#itemSelected] No action for call with id %1", (long)phoneCallEvoListRow.getCallID());
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        switch (n) {
            case 300434: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] hangup call via RSL.");
                this.getApplication().getCallControl().hangupCall(((PhoneCallEvoListRow)this.getCallListList().getRow(n3)).getCallID(), n5);
                break;
            }
            case 300436: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] join calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().joinCallsToConference(n5);
                break;
            }
            case 300435: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] hold call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300439: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] resume call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300440: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] swap calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300430: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANSFREEMODE_HANDSFREE via RSL");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(0, n5);
                break;
            }
            case 300431: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_BTHS1");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(1, n5);
                break;
            }
            case 301079: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_BTHS2");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(2, n5);
                break;
            }
            case 300433: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_HFP");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(4, n5);
                break;
            }
            case 300437: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] demuting the microphone");
                this.getApplication().getAudio().switchMicMuteOff(n5);
                break;
            }
            case 300438: {
                this.log.log(1078071040, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] muting the microphone");
                this.getApplication().getAudio().switchMicMuteOn(n5);
                break;
            }
            default: {
                this.log.log(-2137614336, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] no handling for model %1", (long)n);
            }
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

