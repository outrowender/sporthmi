/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.folderbrowsing;

public final class IFolderBrowsingService$MessageType {
    public static final IFolderBrowsingService$MessageType SMS = new IFolderBrowsingService$MessageType("SMS");
    public static final IFolderBrowsingService$MessageType EMAIL = new IFolderBrowsingService$MessageType("EMAIL");
    private final String name;

    private IFolderBrowsingService$MessageType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

