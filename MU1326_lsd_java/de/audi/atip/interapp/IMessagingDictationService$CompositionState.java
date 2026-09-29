/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public final class IMessagingDictationService$CompositionState {
    private final boolean isDialogActive;
    private final boolean hasFailed;
    private final boolean hasAccount;
    private final int accountType;
    private final int templateCount;
    private final boolean hasRecipients;
    private final String primaryRecipientName;
    private final boolean hasSubject;
    private final boolean hasBody;

    public IMessagingDictationService$CompositionState(boolean bl, boolean bl2, boolean bl3, int n, int n2, boolean bl4, String string, boolean bl5, boolean bl6) {
        this.isDialogActive = bl;
        this.hasFailed = bl2;
        this.hasAccount = bl3;
        this.accountType = n;
        this.templateCount = n2;
        this.hasRecipients = bl4;
        this.primaryRecipientName = string != null ? string : "";
        this.hasSubject = bl5;
        this.hasBody = bl6;
    }

    public boolean isDialogActive() {
        return this.isDialogActive;
    }

    public boolean hasDialogFailed() {
        return this.hasFailed;
    }

    public boolean hasAccount() {
        return this.hasAccount;
    }

    public int getAccountType() {
        return this.hasAccount() ? this.accountType : 0;
    }

    public int getTemplateCount() {
        return this.templateCount;
    }

    public boolean hasRecipients() {
        return this.hasRecipients;
    }

    public String getPrimaryRecipientName() {
        return this.primaryRecipientName;
    }

    public boolean hasSubject() {
        return this.hasSubject;
    }

    public boolean hasBody() {
        return this.hasBody;
    }

    public String toString() {
        Buffer buffer = new Buffer(256);
        buffer.append("CompositionState {isDialogActive = ");
        buffer.append(this.isDialogActive);
        buffer.append(", hasFailed = ");
        buffer.append(this.hasFailed);
        buffer.append(", hasAccount = ");
        buffer.append(this.hasAccount);
        buffer.append(", accountType = ");
        buffer.append(this.accountType);
        buffer.append(", templateCount = ");
        buffer.append(this.templateCount);
        buffer.append(", hasRecipients = ");
        buffer.append(this.hasRecipients);
        buffer.append(", primaryRecipientName = ");
        buffer.append(this.primaryRecipientName);
        buffer.append(", hasSubject = ");
        buffer.append(this.hasSubject);
        buffer.append(", hasBody = ");
        buffer.append(this.hasBody);
        buffer.append('}');
        return buffer.toString();
    }
}

