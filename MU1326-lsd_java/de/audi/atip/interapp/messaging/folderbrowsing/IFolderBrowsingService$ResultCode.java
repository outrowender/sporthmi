/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.folderbrowsing;

public final class IFolderBrowsingService$ResultCode {
    public static final IFolderBrowsingService$ResultCode OK = new IFolderBrowsingService$ResultCode("OK");
    public static final IFolderBrowsingService$ResultCode ERROR_GENERAL = new IFolderBrowsingService$ResultCode("ERROR_GENERAL");
    public static final IFolderBrowsingService$ResultCode ERROR_ILLEGAL_ARGUMENT = new IFolderBrowsingService$ResultCode("ERROR_ILLEGAL_ARGUMENT");
    public static final IFolderBrowsingService$ResultCode ERROR_ILLEGAL_STATE = new IFolderBrowsingService$ResultCode("ERROR_ILLEGAL_STATE");
    private final String name;

    private IFolderBrowsingService$ResultCode(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (object instanceof IFolderBrowsingService$ResultCode) {
            IFolderBrowsingService$ResultCode iFolderBrowsingService$ResultCode = (IFolderBrowsingService$ResultCode)object;
            return iFolderBrowsingService$ResultCode.name.equals(this.name);
        }
        return false;
    }
}

