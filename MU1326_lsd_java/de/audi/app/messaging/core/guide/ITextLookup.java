/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

import de.audi.app.messaging.core.component.IMessagingComponent;

public interface ITextLookup
extends IMessagingComponent {
    public String getForwardPrefix();

    public String getReplyPrefix();

    public String getTemplate1();

    public String getTemplate2();

    public String getTemplate3();

    public String getTemplate4();

    public String getTemplate5();

    public String getTemplate6();

    public String getTemplate7();

    public String getTemplate8();

    public String getTemplate9();

    public String getTemplate10();

    public String getFolderInbox();

    public String getFolderDrafts();

    public String getFolderSent();

    public String getFolderDeleted();

    public String getFolderOutbox();

    public String getSubjectNoneSms();

    public String getSubjectNoneEmail();

    public String getRecipientNone();

    public String getSenderNone();

    public String getTimeToday();

    public String getTimeYesterday();

    public String getQuoteSeparator();

    public String getTimeOfDayNone();

    public String getDateNone();

    public String getAttachmentsDiscardedHint();
}

