/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import org.dsi.ifc.messaging.FolderEntry;

public final class Folders {
    public static boolean isPredefinedFolderId(int n) {
        return n == -6 || n == -7 || n == -3 || n == -8 || n == -4 || n == -2 || n == -1 || n == -9 || n == -5;
    }

    public static boolean isOutboundFolder(int n) {
        return n == 3 || n == 5 || n == 6;
    }

    public static boolean isStandardFolder(int n) {
        return n == 4 || n == 5 || n == 3 || n == 6 || n == 2;
    }

    public static boolean isFolderTypeEqual(FolderEntry folderEntry, int n) {
        int n2 = Folders.mapToHmiFolderType(folderEntry);
        if (!Folders.isStandardFolder(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Not a standard folder: standardFolderEntry = ").append(folderEntry).toString());
        }
        if (!Folders.isPredefinedFolderId(n) || n == -2) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal folder ID: predefinedFolderId = ").append(n).toString());
        }
        return n2 == Folders.mapToHmiFolderType(n);
    }

    public static int mapToHmiFolderType(int n) {
        int n2 = 0;
        switch (n) {
            case -6: {
                n2 = 2;
                break;
            }
            case -7: {
                n2 = 3;
                break;
            }
            case -8: 
            case -3: {
                n2 = 4;
                break;
            }
            case -4: {
                n2 = 5;
                break;
            }
            case -9: 
            case -1: {
                n2 = 1;
                break;
            }
            case -5: {
                n2 = 6;
                break;
            }
            default: {
                throw new IllegalArgumentException("Illegal folder ID: %1");
            }
        }
        return n2;
    }

    public static int mapToHmiFolderType(FolderEntry folderEntry) {
        int n = 7;
        int n2 = folderEntry.getFolderType();
        switch (n2) {
            case 7: {
                n = 2;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            case 1: {
                n = 4;
                break;
            }
            case 2: {
                n = 5;
                break;
            }
            case 4: {
                n = 6;
                break;
            }
            case 5: {
                n = 7;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown folderEntry.getFolderType() = ").append(n2).toString());
            }
        }
        return n;
    }

    public static boolean equals(FolderEntry folderEntry, FolderEntry folderEntry2) {
        boolean bl = false;
        if (folderEntry == null && folderEntry2 == null) {
            bl = true;
        } else if (folderEntry != null && folderEntry2 != null) {
            bl = folderEntry.getFolderID() == folderEntry2.getFolderID() && folderEntry.getFolderName().equals(folderEntry2.getFolderName()) && folderEntry.getFolderType() == folderEntry2.getFolderType() && folderEntry.getParentFolderID() == folderEntry2.getParentFolderID() && folderEntry.getUnreadMessageCount() == folderEntry2.getUnreadMessageCount();
        }
        return bl;
    }
}

