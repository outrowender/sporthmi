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

    @Override
    public String getForwardPrefix() {
        return this.get(-1013767936);
    }

    @Override
    public String getReplyPrefix() {
        return this.get(-996990720);
    }

    @Override
    public String getTemplate1() {
        return this.get(-1517084416);
    }

    @Override
    public String getTemplate2() {
        return this.get(-1500307200);
    }

    @Override
    public String getTemplate3() {
        return this.get(-1483529984);
    }

    @Override
    public String getTemplate4() {
        return this.get(-1466752768);
    }

    @Override
    public String getTemplate5() {
        return this.get(-1449975552);
    }

    @Override
    public String getTemplate6() {
        return this.get(-1433198336);
    }

    @Override
    public String getTemplate7() {
        return this.get(-1416421120);
    }

    @Override
    public String getTemplate8() {
        return this.get(-1399643904);
    }

    @Override
    public String getTemplate9() {
        return this.get(-1382866688);
    }

    @Override
    public String getTemplate10() {
        return this.get(-1366089472);
    }

    @Override
    public String getFolderInbox() {
        return this.get(445915392);
    }

    @Override
    public String getFolderDrafts() {
        return this.get(462692608);
    }

    @Override
    public String getFolderSent() {
        return this.get(479469824);
    }

    @Override
    public String getFolderDeleted() {
        return this.get(496247040);
    }

    @Override
    public String getFolderOutbox() {
        return this.get(513024256);
    }

    @Override
    public String getSubjectNoneSms() {
        return this.get(127213824);
    }

    @Override
    public String getSubjectNoneEmail() {
        return this.get(529801472);
    }

    @Override
    public String getRecipientNone() {
        return this.get(546578688);
    }

    @Override
    public String getSenderNone() {
        return this.get(563355904);
    }

    @Override
    public String getTimeToday() {
        return this.get(580133120);
    }

    @Override
    public String getTimeYesterday() {
        return "";
    }

    @Override
    public String getQuoteSeparator() {
        return this.get(1704206592);
    }

    @Override
    public String getTimeOfDayNone() {
        return this.get(26550528);
    }

    @Override
    public String getDateNone() {
        return this.get(43327744);
    }

    @Override
    public String getAttachmentsDiscardedHint() {
        return this.get(-1248452352);
    }
}

