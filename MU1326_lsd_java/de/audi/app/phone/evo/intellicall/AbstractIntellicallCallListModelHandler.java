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

    public void init() {
        super.init();
        int n = this.getCallListList().getID();
        this.getOptionModel(300434).setListener(this, n);
        this.getOptionModel(300435).setListener(this, n);
        this.getOptionModel(300436).setListener(this, n);
        this.getOptionModel(300439).setListener(this, n);
        this.getOptionModel(300440).setListener(this, n);
        this.getOptionModel(300438).setListener(this, n);
        this.getOptionModel(300437).setListener(this, n);
        this.getOptionModel(300430).setListener(this, n);
        this.getOptionModel(300431).setListener(this, n);
        this.getOptionModel(301079).setListener(this, n);
        this.getOptionModel(300433).setListener(this, n);
    }

    public void deinit() {
        super.deinit();
        int n = this.getCallListList().getID();
        this.getOptionModel(300434).removeListener(n);
        this.getOptionModel(300435).removeListener(n);
        this.getOptionModel(300436).removeListener(n);
        this.getOptionModel(300439).removeListener(n);
        this.getOptionModel(300440).removeListener(n);
        this.getOptionModel(300438).removeListener(n);
        this.getOptionModel(300437).removeListener(n);
        this.getOptionModel(300430).removeListener(n);
        this.getOptionModel(300431).removeListener(n);
        this.getOptionModel(301079).removeListener(n);
        this.getOptionModel(300433).removeListener(n);
    }

    protected EvoListRow getNewListRow(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, int n, LogChannel logChannel) {
        return new PhoneCallEvoListRow(abstractPhoneCall, iGlobalTelephoneStateStruct.getCallLeadingDevice(), iGlobalTelephoneStateStruct.getNonCallLeadingDevice(), n, logChannel, 16, this.getApplication());
    }

    protected void callSelected(EvoListRow evoListRow, int n) {
        if (evoListRow == null) {
            this.log.log(10000, "[AbstractIntellicallCallListModelHandler#callSelected] row is null.");
            return;
        }
        PhoneCallEvoListRow phoneCallEvoListRow = (PhoneCallEvoListRow)evoListRow;
        int n2 = phoneCallEvoListRow.getPrimaryAction();
        this.log.log(10000000, "[AbstractIntellicallCallListModelHandler#itemSelected] call=%1", (Object)phoneCallEvoListRow);
        switch (n2) {
            case 0: {
                int n3 = phoneCallEvoListRow.getCallID();
                this.log.log(10000000, "[AbstractIntellicallCallListModelHandler#itemSelected] hanging up call with id %1", (long)n3);
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
                this.log.log(10000000, "[AbstractIntellicallCallListModelHandler#itemSelected] No action for call with id %1", (long)phoneCallEvoListRow.getCallID());
            }
        }
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        switch (n) {
            case 300434: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] hangup call via RSL.");
                this.getApplication().getCallControl().hangupCall(((PhoneCallEvoListRow)this.getCallListList().getRow(n3)).getCallID(), n5);
                break;
            }
            case 300436: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] join calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().joinCallsToConference(n5);
                break;
            }
            case 300435: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] hold call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300439: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] resume call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300440: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] swap calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300430: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANSFREEMODE_HANDSFREE via RSL");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(0, n5);
                break;
            }
            case 300431: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_BTHS1");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(1, n5);
                break;
            }
            case 301079: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_BTHS2");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(2, n5);
                break;
            }
            case 300433: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_HFP");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(4, n5);
                break;
            }
            case 300437: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel] demuting the microphone");
                this.getApplication().getAudio().switchMicMuteOff(n5);
                break;
            }
            case 300438: {
                this.log.log(1000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] muting the microphone");
                this.getApplication().getAudio().switchMicMuteOn(n5);
                break;
            }
            default: {
                this.log.log(10000000, "[AbstractIntellicallCallListModelHandler#keyTyped(OptionModel)] no handling for model %1", (long)n);
            }
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

