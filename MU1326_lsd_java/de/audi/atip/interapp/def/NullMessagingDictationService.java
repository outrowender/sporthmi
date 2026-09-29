/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullMessagingDictationService
extends NullService
implements IMessagingDictationService {
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingDictationService;

    public NullMessagingDictationService(LogChannel logChannel) {
        super(logChannel, class$de$audi$atip$interapp$IMessagingDictationService == null ? (class$de$audi$atip$interapp$IMessagingDictationService = NullMessagingDictationService.class$("de.audi.atip.interapp.IMessagingDictationService")) : class$de$audi$atip$interapp$IMessagingDictationService);
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public TextEditorModelDDApp getSubjectEditorModel() {
        return null;
    }

    @Override
    public TextEditorModelDDApp getBodyEditorModel() {
        return null;
    }

    @Override
    public ChoiceModelApp getSubjectEditorInputModeModel() {
        return null;
    }

    @Override
    public ChoiceModelApp getBodyEditorInputModeModel() {
        return null;
    }

    @Override
    public void indicateSubjectEditorModelWrite() {
        super.log();
    }

    @Override
    public void indicateBodyEditorModelWrite() {
        super.log();
    }

    @Override
    public void requestBeginDialog(int n, int n2, boolean bl) {
        super.log();
    }

    @Override
    public void requestEndDialog() {
        super.log();
    }

    @Override
    public void requestDialogStep(int n) {
        super.log();
    }

    @Override
    public void requestAddRecipient(int n, String string, long l, String string2) {
        super.log();
    }

    @Override
    public void requestClearRecipients(int n) {
        super.log();
    }

    @Override
    public void requestSendMessage() {
        super.log();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

