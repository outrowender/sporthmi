/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;

public class MFLPhoneButtonsListener
implements ITerminalModeComponent {
    private static final String LOGCLASS = "MFLPhoneButtonsListener";
    private final LogChannel lc;
    private final ITerminalModeConfiguration configuration;
    private final IContext context;
    private final IPhoneCallController phoneCallController;

    public MFLPhoneButtonsListener(LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, ITerminalModeConfiguration iTerminalModeConfiguration) {
        this.lc = logChannel;
        this.configuration = iTerminalModeConfiguration;
        this.context = iContext;
        this.phoneCallController = iDSISmartphoneManager.getPhoneCallController();
    }

    public void init() {
        this.context.getButtonModel(3200047).setButtonListener(new DefaultButtonListener(){

            public void keyPressed(int n, int n2, int n3) {
                MFLPhoneButtonsListener.this.lc.log(10000000, "<<- [%1.keyPressed] HOOK", (Object)MFLPhoneButtonsListener.LOGCLASS);
                if (MFLPhoneButtonsListener.this.configuration.hasBothPhoneMFLKeys()) {
                    MFLPhoneButtonsListener.this.phoneCallController.hook(false);
                } else {
                    MFLPhoneButtonsListener.this.phoneCallController.flash(false);
                }
            }

            public void keyReleased(int n, int n2, int n3) {
                MFLPhoneButtonsListener.this.lc.log(10000000, "<<- [%1.keyReleased] HOOK", (Object)MFLPhoneButtonsListener.LOGCLASS);
                if (MFLPhoneButtonsListener.this.configuration.hasBothPhoneMFLKeys()) {
                    MFLPhoneButtonsListener.this.phoneCallController.hook(true);
                } else {
                    MFLPhoneButtonsListener.this.phoneCallController.flash(true);
                }
            }
        });
        this.context.getButtonModel(3200048).setButtonListener(new DefaultButtonListener(){

            public void keyPressed(int n, int n2, int n3) {
                MFLPhoneButtonsListener.this.lc.log(10000000, "<<- [%1.keyPressed] HANGUP", (Object)MFLPhoneButtonsListener.LOGCLASS);
                if (MFLPhoneButtonsListener.this.configuration.hasBothPhoneMFLKeys()) {
                    MFLPhoneButtonsListener.this.phoneCallController.hangup(false);
                } else {
                    MFLPhoneButtonsListener.this.phoneCallController.flash(false);
                }
            }

            public void keyReleased(int n, int n2, int n3) {
                MFLPhoneButtonsListener.this.lc.log(10000000, "<<- [%1.keyReleased] HANGUP", (Object)MFLPhoneButtonsListener.LOGCLASS);
                if (MFLPhoneButtonsListener.this.configuration.hasBothPhoneMFLKeys()) {
                    MFLPhoneButtonsListener.this.phoneCallController.hangup(true);
                } else {
                    MFLPhoneButtonsListener.this.phoneCallController.flash(true);
                }
            }
        });
    }

    public void deinit() {
        this.context.getButtonModel(3200048).setButtonListener(null);
        this.context.getButtonModel(3200047).setButtonListener(null);
    }
}

