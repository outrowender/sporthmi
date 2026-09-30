/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigEmptyListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.settings.SetSmscNumberCommand;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.tghu.command.Command;

public class SmscNumberController
extends AbstractMessagingComponent {
    private final TextfieldModelApp smscNumberTextfield;
    private final SpellerModelApp smscNumberSpeller;
    private final SpellerModelApp smscNumberDirectWritingSpeller;
    private final ButtonModelApp smscNumberOkButton;
    private final ICommandCallback setSmscNumberCallback = new ICommandCallback(){

        public void terminating(Command command) {
            SmscNumberController.this.handleSetSmscNumberResult(command);
        }
    };

    public SmscNumberController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        this.smscNumberTextfield = iHMIServiceApp.getTextfieldModel(2200443);
        this.smscNumberSpeller = iHMIServiceApp.getSpellerModel(2200441);
        this.smscNumberDirectWritingSpeller = iHMIServiceApp.getSpellerModel(2200442);
        this.smscNumberOkButton = iHMIServiceApp.getButtonModel(2200444);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getModelAccess().initSpellerModel(2200442, 1, 40);
        this.setSmscNumber(null);
        MySpellerListener mySpellerListener = new MySpellerListener();
        MyButtonListener myButtonListener = new MyButtonListener();
        this.smscNumberTextfield.setButtonListener(myButtonListener);
        this.smscNumberSpeller.setSpellerListener(mySpellerListener);
        this.smscNumberDirectWritingSpeller.setSpellerListener(mySpellerListener);
        this.smscNumberOkButton.setButtonListener(myButtonListener);
        abstractMsgApplication.getDsiMessagingConfigPrimaryListener().addSubscriber(new MyDsiMessagingConfigListener());
    }

    public void dispose() {
        super.dispose();
        this.setSmscNumber(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleSetSmscNumberResult(Command command) {
        this.log.log(10000000, "[SmscNumberController#handleSetSmscNumberResult] command = %1", (Object)command);
        SetSmscNumberCommand setSmscNumberCommand = null;
        boolean bl = false;
        try {
            setSmscNumberCommand = (SetSmscNumberCommand)command;
            SetSmscNumberCommand.Result result = (SetSmscNumberCommand.Result)setSmscNumberCommand.getResult();
            int n = result.getResultCode();
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
        this.log.log(10000000, "[SmscNumberController#setSmscNumber] smscNumber = %1", (Object)string);
        boolean bl = !Strings.isNullOrEmpty(string);
        String string2 = bl ? string : "";
        int n = bl ? 1 : 0;
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        iHMIServiceApp.getChoiceModel(2200445).setValue(n);
        this.smscNumberTextfield.setText1(string2);
    }

    private void requestSetSmscNumber() {
        this.log.log(10000000, "[SmscNumberController#requestSetSmscNumber]");
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
        this.log.log(10000000, "[SmscNumberController#setOkButtonStates] setSpellerOKButtonStatus to %1", (long)n);
        int n2 = bl ? 1 : 0;
        this.smscNumberOkButton.setStatus(n2);
        this.log.log(10000000, "[SmscNumberController#setOkButtonStates] setOkButtonStatus to %1", (long)n2);
    }

    private void clearSpellers() {
        this.log.log(10000000, "[SmscNumberController#clearSpellers]");
        this.smscNumberSpeller.clear();
        this.smscNumberDirectWritingSpeller.clear();
    }

    private void setSpellerText(String string) {
        this.log.log(10000000, "[SmscNumberController#setSpellerText] text = %1", (Object)string);
        this.smscNumberSpeller.setText(string);
        this.smscNumberDirectWritingSpeller.setText(string);
        this.setOkButtonStates();
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 2200443: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MyButtonListener#keyTyped] modelID = SMSC_NUMBER_TEXTFIELD");
                    SmscNumberController.this.setSpellerText(SmscNumberController.this.smscNumberTextfield.getText1());
                    SmscNumberController.this.smscNumberTextfield.fireEvent(n3);
                    break;
                }
                case 2200444: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MyButtonListener#keyTyped] modelID = SMSC_NUMBER_OK_BUTTON");
                    SmscNumberController.this.requestSetSmscNumber();
                    SmscNumberController.this.smscNumberOkButton.fireEvent(n3);
                    break;
                }
                default: {
                    SmscNumberController.this.log.log(10000, "[SmscNumberController#MyButtonListener#keyTyped] Unexpected modelID = %1", (long)n);
                }
            }
        }
    }

    private class MySpellerListener
    extends DefaultSpellerListener {
        private MySpellerListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 2200442: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MySpellerListener#keyTyped] id = SMSC_NUMBER_DIRECT_WRITING_SPELLER, keyID = %1", (long)n2);
                    SmscNumberController.this.requestSetSmscNumber();
                    SmscNumberController.this.smscNumberOkButton.fireEvent(n3);
                    break;
                }
                default: {
                    SmscNumberController.this.log.log(10000, "[SmscNumberController#MySpellerListener#keyTyped] Unexpected modelID = %1", (long)n);
                }
            }
        }

        public void textChanged(int n, String string, char c2, int n2) {
            switch (n) {
                case 2200441: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MySpellerListener#textChanged] id = SMSC_NUMBER_SPELLER, latestChar = %1", c2);
                    SmscNumberController.this.clearSpellers();
                    SmscNumberController.this.setSpellerText(String.valueOf(c2));
                    SmscNumberController.this.smscNumberTextfield.fireEvent(n2);
                    break;
                }
                case 2200442: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MySpellerListener#textChanged] id = SMSC_NUMBER_DIRECT_WRITING_SPELLER, latestChar = %1", c2);
                    SmscNumberController.this.setSpellerText(string);
                    break;
                }
                default: {
                    SmscNumberController.this.log.log(1000000, "[SmscNumberController#MySpellerListener#textChanged] Unexpected modelID = %1", (long)n);
                }
            }
        }
    }

    private class MyDsiMessagingConfigListener
    extends DsiMessagingConfigEmptyListener {
        private MyDsiMessagingConfigListener() {
        }

        public void updateSMSCNumber(String string, int n) {
            SmscNumberController.this.log.log(10000000, "[SmscNumberController#updateSMSCNumber]");
            SmscNumberController.this.setSmscNumber(string);
        }
    }
}

