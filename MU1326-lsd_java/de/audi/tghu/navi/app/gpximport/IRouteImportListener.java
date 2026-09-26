/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.gpximport;

public interface IRouteImportListener {
    public static final int ROUTE_IMPORT_FAILED;
    public static final int ROUTE_IMPORT_SUCCESSFUL;
    public static final int ROUTE_IMPORT_ABORTED;
    public static final int ROUTE_IMPORT_STARTED;

    default public void updateStatus(int n) {
    }
}

