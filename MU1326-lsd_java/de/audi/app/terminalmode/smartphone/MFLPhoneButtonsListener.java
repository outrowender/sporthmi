/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.MFLPhoneButtonsListener$1;
import de.audi.app.terminalmode.smartphone.MFLPhoneButtonsListener$2;
import de.audi.atip.log.LogChannel;

public class MFLPhoneButtonsListener
implements ITerminalModeComponent {
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.context.getButtonModel(802435072).setButtonListener(new MFLPhoneButtonsListener$1(this));
        this.context.getButtonModel(819212288).setButtonListener(new MFLPhoneButtonsListener$2(this));
    }

    @Override
    public void deinit() {
        this.context.getButtonModel(819212288).setButtonListener(null);
        this.context.getButtonModel(802435072).setButtonListener(null);
    }

    static /* synthetic */ LogChannel access$000(MFLPhoneButtonsListener mFLPhoneButtonsListener) {
        return mFLPhoneButtonsListener.lc;
    }

    static /* synthetic */ ITerminalModeConfiguration access$100(MFLPhoneButtonsListener mFLPhoneButtonsListener) {
        return mFLPhoneButtonsListener.configuration;
    }

    static /* synthetic */ IPhoneCallController access$200(MFLPhoneButtonsListener mFLPhoneButtonsListener) {
        return mFLPhoneButtonsListener.phoneCallController;
    }
}

