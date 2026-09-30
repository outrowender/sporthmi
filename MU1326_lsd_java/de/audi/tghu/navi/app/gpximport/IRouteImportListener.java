/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.gpximport;

public interface IRouteImportListener {
    public static final int ROUTE_IMPORT_FAILED = 0;
    public static final int ROUTE_IMPORT_SUCCESSFUL = 1;
    public static final int ROUTE_IMPORT_ABORTED = 2;
    public static final int ROUTE_IMPORT_STARTED = 3;

    public void updateStatus(int var1);
}

