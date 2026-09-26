/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.TransactionId;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.atip.interapp.combi.bap.PartialPopupBAPService;
import de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent;
import de.audi.atip.interapp.combi.bap.data.PartialPopupBAPContent$SelectionOption;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.mfl.serializer.PU_Action_Result;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status;

public class PartialPopupHandler
implements PartialPopupBAPService,
IAcknowledgeListener {
    private static final int INITIAL_TRANSACTION_ID;
    private static final int MAX_TRANSACTION_ID;
    private final LogChannel logChannel;
    private final CombiModuleMFL module;
    private final BAPFunctionPropertyFSG puContent;
    private final BAPFunctionMethodFSG puAction;
    private PartialPopupBAPServiceListener partialPopupListener;
    private final TransactionId taID = new TransactionId(1, 255);
    private volatile int currentPopupID = -1;
    private volatile PartialPopupBAPContent requestedContent;
    private volatile PartialPopupBAPContent currentContent = new PartialPopupBAPContent();

    public PartialPopupHandler(CombiModuleMFL combiModuleMFL) {
        this.module = combiModuleMFL;
        this.logChannel = combiModuleMFL.getLogChannel();
        this.puContent = combiModuleMFL.getBAPFunctionPropertyFSG(19);
        this.puAction = combiModuleMFL.getBAPFunctionMethodFSG(20);
    }

    @Override
    public void showPartialPopup(int n, PartialPopupBAPContent partialPopupBAPContent) {
        this.logChannel.log(1078071040, "[PartialPopupHandler#showPartialPopup] id=%2, content=%1", (Object)partialPopupBAPContent, (long)n);
        this.currentPopupID = n;
        this.requestPartialPopupContent(this.taID.getAndIncrement(), partialPopupBAPContent);
    }

    @Override
    public void hidePartialPopup(int n) {
        this.logChannel.log(1078071040, "[PartialPopupHandler#hidePartialPopup]");
        if (this.currentPopupID == n) {
            this.currentPopupID = -1;
            this.requestPartialPopupContent(this.taID.expectedValue(), new PartialPopupBAPContent());
        } else {
            this.logChannel.log(10000, "[PartialPopupHandler#hidePartialPopup] id mismatch: currentPopupID=%1, hidePopupID=%2", (long)this.currentPopupID, (long)n);
        }
    }

    private void requestPartialPopupContent(int n, PartialPopupBAPContent partialPopupBAPContent) {
        PU_Content_Status pU_Content_Status = new PU_Content_Status();
        pU_Content_Status.taid = n;
        pU_Content_Status.priority = partialPopupBAPContent.getPriority();
        pU_Content_Status.logicalContext = partialPopupBAPContent.getContext();
        pU_Content_Status.cursorPosition = partialPopupBAPContent.getInitialCursorPosition();
        pU_Content_Status.option_1.optionType = partialPopupBAPContent.getSelectionOption1().getOptionType();
        pU_Content_Status.option_1.optionString.setContent(partialPopupBAPContent.getSelectionOption1().getOptionString());
        pU_Content_Status.option_2.optionType = partialPopupBAPContent.getSelectionOption2().getOptionType();
        pU_Content_Status.option_2.optionString.setContent(partialPopupBAPContent.getSelectionOption2().getOptionString());
        pU_Content_Status.option_3.optionType = partialPopupBAPContent.getSelectionOption3().getOptionType();
        pU_Content_Status.option_3.optionString.setContent(partialPopupBAPContent.getSelectionOption3().getOptionString());
        pU_Content_Status.option_4.optionType = partialPopupBAPContent.getSelectionOption4().getOptionType();
        pU_Content_Status.option_4.optionString.setContent(partialPopupBAPContent.getSelectionOption4().getOptionString());
        pU_Content_Status.text.setContent(partialPopupBAPContent.getText());
        pU_Content_Status.icon = partialPopupBAPContent.getIcon();
        pU_Content_Status.maximumDisplayTime = partialPopupBAPContent.getMaximumDisplayTime();
        this.requestedContent = partialPopupBAPContent;
        this.puContent.addAcknowledgeListener(this);
        this.puContent.sendStatusIfChanged(pU_Content_Status);
    }

    public void popupActionPerformed(int n, int n2) {
        this.logChannel.log(1078071040, "[PartialPopupHandler#popupActionPerformed] actionTAID=%1, selectedOption=%2", (long)n, (long)n2);
        if (this.partialPopupListener != null) {
            if (n == this.taID.expectedValue()) {
                PartialPopupBAPContent$SelectionOption partialPopupBAPContent$SelectionOption;
                switch (n2) {
                    case 0: {
                        this.logChannel.log(-2137614336, "[PartialPopupHandler#popupActionPerformed] call partialPopupListener.cancelPopup()");
                        this.sendPUActionResult(0);
                        this.partialPopupListener.cancelPopup(this.currentPopupID);
                        return;
                    }
                    case 1: {
                        partialPopupBAPContent$SelectionOption = this.currentContent.getSelectionOption1();
                        break;
                    }
                    case 2: {
                        partialPopupBAPContent$SelectionOption = this.currentContent.getSelectionOption2();
                        break;
                    }
                    case 3: {
                        partialPopupBAPContent$SelectionOption = this.currentContent.getSelectionOption3();
                        break;
                    }
                    case 4: {
                        partialPopupBAPContent$SelectionOption = this.currentContent.getSelectionOption4();
                        break;
                    }
                    default: {
                        this.logChannel.log(10000, "[PartialPopupHandler#popupActionPerformed] invalid option selected: option=%1", (long)n2);
                        this.sendPUActionResult(1);
                        return;
                    }
                }
                if (partialPopupBAPContent$SelectionOption.isAvailable()) {
                    this.partialPopupListener.optionSelected(this.currentPopupID, partialPopupBAPContent$SelectionOption.getOptionID());
                    this.sendPUActionResult(0);
                } else {
                    this.logChannel.log(10000, "[PartialPopupHandler#popupActionPerformed] selected option is not available: option=%1", (long)n2);
                    this.sendPUActionResult(1);
                }
            } else {
                this.logChannel.log(10000, "[PartialPopupHandler#popupActionPerformed] taID mismatch: current taID=%1, action taID=%2", (long)this.taID.expectedValue(), (long)n);
                this.sendPUActionResult(1);
            }
        } else {
            this.logChannel.log(10000, "[PartialPopupHandler#popupActionPerformed] partial popup listener not available");
            this.sendPUActionResult(1);
        }
    }

    private void sendPUActionResult(int n) {
        PU_Action_Result pU_Action_Result = (PU_Action_Result)this.module.createResultSerializer(20);
        pU_Action_Result.pu_ActionResult = n;
        this.puAction.resultREQ(pU_Action_Result);
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        if (n == this.puContent.getFctID() && n2 == 0) {
            this.logChannel.log(-2137614336, "[PartialPopupHandler#processAcknowledge]");
            if (this.requestedContent != null) {
                this.currentContent = this.requestedContent;
                this.requestedContent = null;
            }
        }
    }

    public void setPartialPopupBAPServiceListener(PartialPopupBAPServiceListener partialPopupBAPServiceListener) {
        this.partialPopupListener = partialPopupBAPServiceListener;
    }
}

