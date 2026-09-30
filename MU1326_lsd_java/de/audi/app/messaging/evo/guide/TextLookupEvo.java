/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.guide;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;

public final class TextLookupEvo
extends AbstractMessagingComponent
implements ITextLookup {
    public TextLookupEvo(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    private String get(int n) {
        return this.framework.getHmiServiceApp().getText(n);
    }

    public String getForwardPrefix() {
        return this.get(2200515);
    }

    public String getReplyPrefix() {
        return this.get(2200516);
    }

    public String getTemplate1() {
        return this.get(2200485);
    }

    public String getTemplate2() {
        return this.get(2200486);
    }

    public String getTemplate3() {
        return this.get(2200487);
    }

    public String getTemplate4() {
        return this.get(2200488);
    }

    public String getTemplate5() {
        return this.get(2200489);
    }

    public String getTemplate6() {
        return this.get(2200490);
    }

    public String getTemplate7() {
        return this.get(2200491);
    }

    public String getTemplate8() {
        return this.get(2200492);
    }

    public String getTemplate9() {
        return this.get(2200493);
    }

    public String getTemplate10() {
        return this.get(2200494);
    }

    public String getFolderInbox() {
        return this.get(2200602);
    }

    public String getFolderDrafts() {
        return this.get(2200603);
    }

    public String getFolderSent() {
        return this.get(2200604);
    }

    public String getFolderDeleted() {
        return this.get(2200605);
    }

    public String getFolderOutbox() {
        return this.get(2200606);
    }

    public String getSubjectNoneSms() {
        return this.get(2200839);
    }

    public String getSubjectNoneEmail() {
        return this.get(2200607);
    }

    public String getRecipientNone() {
        return this.get(2200608);
    }

    public String getSenderNone() {
        return this.get(2200609);
    }

    public String getTimeToday() {
        return this.get(2200610);
    }

    public String getTimeYesterday() {
        return "";
    }

    public String getQuoteSeparator() {
        return this.get(2200677);
    }

    public String getTimeOfDayNone() {
        return this.get(2200833);
    }

    public String getDateNone() {
        return this.get(2200834);
    }

    public String getAttachmentsDiscardedHint() {
        return this.get(2201269);
    }
}

