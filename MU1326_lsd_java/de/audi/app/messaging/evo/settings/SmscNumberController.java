/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.settings.SetSmscNumberCommand;
import de.audi.app.messaging.core.settings.SetSmscNumberCommand$Result;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.evo.settings.SmscNumberController$1;
import de.audi.app.messaging.evo.settings.SmscNumberController$MyButtonListener;
import de.audi.app.messaging.evo.settings.SmscNumberController$MyDsiMessagingConfigListener;
import de.audi.app.messaging.evo.settings.SmscNumberController$MySpellerListener;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public class SmscNumberController
extends AbstractMessagingComponent {
    private final TextfieldModelApp smscNumberTextfield;
    private final SpellerModelApp smscNumberSpeller;
    private final SpellerModelApp smscNumberDirectWritingSpeller;
    private final ButtonModelApp smscNumberOkButton;
    private final ICommandCallback setSmscNumberCallback = new SmscNumberController$1(this);

    public SmscNumberController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        this.smscNumberTextfield = iHMIServiceApp.getTextfieldModel(2073239808);
        this.smscNumberSpeller = iHMIServiceApp.getSpellerModel(2039685376);
        this.smscNumberDirectWritingSpeller = iHMIServiceApp.getSpellerModel(2056462592);
        this.smscNumberOkButton = iHMIServiceApp.getButtonModel(2090017024);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getModelAccess().initSpellerModel(2056462592, 1, 40);
        this.setSmscNumber(null);
        SmscNumberController$MySpellerListener smscNumberController$MySpellerListener = new SmscNumberController$MySpellerListener(this, null);
        SmscNumberController$MyButtonListener smscNumberController$MyButtonListener = new SmscNumberController$MyButtonListener(this, null);
        this.smscNumberTextfield.setButtonListener(smscNumberController$MyButtonListener);
        this.smscNumberSpeller.setSpellerListener(smscNumberController$MySpellerListener);
        this.smscNumberDirectWritingSpeller.setSpellerListener(smscNumberController$MySpellerListener);
        this.smscNumberOkButton.setButtonListener(smscNumberController$MyButtonListener);
        abstractMsgApplication.getDsiMessagingConfigPrimaryListener().addSubscriber(new SmscNumberController$MyDsiMessagingConfigListener(this, null));
    }

    @Override
    public void dispose() {
        super.dispose();
        this.setSmscNumber(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleSetSmscNumberResult(Command command) {
        this.log.log(-2137614336, "[SmscNumberController#handleSetSmscNumberResult] command = %1", (Object)command);
        SetSmscNumberCommand setSmscNumberCommand = null;
        boolean bl = false;
        try {
            setSmscNumberCommand = (SetSmscNumberCommand)command;
            SetSmscNumberCommand$Result setSmscNumberCommand$Result = (SetSmscNumberCommand$Result)setSmscNumberCommand.getResult();
            int n = setSmscNumberCommand$Result.getResultCode();
            bl = n != 0;
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SmscNumberController#handleSetSmscNumberResult]");
            bl = true;
        }
        finally {
            if (bl) {
                this.setSmscNumber(this.smscNumberTextfield.getText1());
            }
        }
    }

    private void setSmscNumber(String string) {
        this.log.log(-2137614336, "[SmscNumberController#setSmscNumber] smscNumber = %1", (Object)string);
        boolean bl = !Strings.isNullOrEmpty(string);
        String string2 = bl ? string : "";
        int n = bl ? 1 : 0;
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        iHMIServiceApp.getChoiceModel(2106794240).setValue(n);
        this.smscNumberTextfield.setText1(string2);
    }

    private void requestSetSmscNumber() {
        this.log.log(-2137614336, "[SmscNumberController#requestSetSmscNumber]");
        String string = this.smscNumberDirectWritingSpeller.getText();
        boolean bl = ADBUtils.isEmpty(string);
        if (!bl) {
            String string2 = this.smscNumberTextfield.getText1();
            new SetSmscNumberCommand(this.msgApp, this.setSmscNumberCallback, string, string2).schedule();
            this.setSmscNumber(string);
        }
    }

    private void setOkButtonStates() {
        this.smscNumberDirectWritingSpeller.setExitButtonText(0);
        boolean bl = !ADBUtils.isEmpty(this.smscNumberDirectWritingSpeller.getText());
        int n = bl ? 1 : 0;
        this.smscNumberDirectWritingSpeller.setControlButtonStates(1, n);
        this.log.log(-2137614336, "[SmscNumberController#setOkButtonStates] setSpellerOKButtonStatus to %1", (long)n);
        int n2 = bl ? 1 : 0;
        this.smscNumberOkButton.setStatus(n2);
        this.log.log(-2137614336, "[SmscNumberController#setOkButtonStates] setOkButtonStatus to %1", (long)n2);
    }

    private void clearSpellers() {
        this.log.log(-2137614336, "[SmscNumberController#clearSpellers]");
        this.smscNumberSpeller.clear();
        this.smscNumberDirectWritingSpeller.clear();
    }

    private void setSpellerText(String string) {
        this.log.log(-2137614336, "[SmscNumberController#setSpellerText] text = %1", (Object)string);
        this.smscNumberSpeller.setText(string);
        this.smscNumberDirectWritingSpeller.setText(string);
        this.setOkButtonStates();
    }

    static /* synthetic */ void access$000(SmscNumberController smscNumberController, Command command) {
        smscNumberController.handleSetSmscNumberResult(command);
    }

    static /* synthetic */ LogChannel access$400(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ void access$500(SmscNumberController smscNumberController, String string) {
        smscNumberController.setSmscNumber(string);
    }

    static /* synthetic */ LogChannel access$600(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ TextfieldModelApp access$700(SmscNumberController smscNumberController) {
        return smscNumberController.smscNumberTextfield;
    }

    static /* synthetic */ void access$800(SmscNumberController smscNumberController, String string) {
        smscNumberController.setSpellerText(string);
    }

    static /* synthetic */ LogChannel access$900(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ void access$1000(SmscNumberController smscNumberController) {
        smscNumberController.requestSetSmscNumber();
    }

    static /* synthetic */ ButtonModelApp access$1100(SmscNumberController smscNumberController) {
        return smscNumberController.smscNumberOkButton;
    }

    static /* synthetic */ LogChannel access$1200(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ LogChannel access$1300(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ LogChannel access$1400(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ LogChannel access$1500(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ void access$1600(SmscNumberController smscNumberController) {
        smscNumberController.clearSpellers();
    }

    static /* synthetic */ LogChannel access$1700(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }

    static /* synthetic */ LogChannel access$1800(SmscNumberController smscNumberController) {
        return smscNumberController.log;
    }
}

