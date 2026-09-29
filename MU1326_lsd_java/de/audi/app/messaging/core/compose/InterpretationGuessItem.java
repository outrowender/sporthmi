/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;

public final class InterpretationGuessItem
extends AbstractMessagingComponent {
    private final LabelModelApp interpretationGuessItemLabel;

    public InterpretationGuessItem(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.interpretationGuessItemLabel = this.framework.getHmiServiceApp().getLabelModel(-678289152);
    }

    public void update(String string) {
        this.log.log(-2137614336, "[InterpretationGuessItem#update] text = %1", (Object)string);
        String string2 = this.computeInterpretationGuessItem(string);
        this.interpretationGuessItemLabel.setText(string2);
        int n = this.isValid() ? 1 : 0;
        this.interpretationGuessItemLabel.setStatus(n);
    }

    public String get() {
        return this.interpretationGuessItemLabel.getText();
    }

    public boolean isValid() {
        return !Strings.isNullOrEmpty(this.get());
    }

    private String computeInterpretationGuessItem(String string) {
        String string2;
        String string3 = "";
        boolean bl = this.msgApp.getAccountManager().isEmailMode();
        String string4 = string2 = Strings.isNullOrEmpty(string) ? "" : string.trim();
        if (bl) {
            int n;
            if (string2.length() >= 3 && (n = string2.indexOf(64, 1)) > 0 && n < string2.length() - 1) {
                string3 = string2;
            }
        } else {
            String string5 = TelIntellicallIGIUtil.getValidPhoneNumber(string);
            string3 = Strings.isNullOrEmpty(string5) ? "" : string5;
        }
        return string3;
    }
}

