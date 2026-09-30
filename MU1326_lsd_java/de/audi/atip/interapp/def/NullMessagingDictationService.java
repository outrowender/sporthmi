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

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public TextEditorModelDDApp getSubjectEditorModel() {
        return null;
    }

    public TextEditorModelDDApp getBodyEditorModel() {
        return null;
    }

    public ChoiceModelApp getSubjectEditorInputModeModel() {
        return null;
    }

    public ChoiceModelApp getBodyEditorInputModeModel() {
        return null;
    }

    public void indicateSubjectEditorModelWrite() {
        super.log();
    }

    public void indicateBodyEditorModelWrite() {
        super.log();
    }

    public void requestBeginDialog(int n, int n2, boolean bl) {
        super.log();
    }

    public void requestEndDialog() {
        super.log();
    }

    public void requestDialogStep(int n) {
        super.log();
    }

    public void requestAddRecipient(int n, String string, long l, String string2) {
        super.log();
    }

    public void requestClearRecipients(int n) {
        super.log();
    }

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

