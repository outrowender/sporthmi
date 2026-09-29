/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import org.dsi.ifc.global.NavRectangle;

public class ResponseContainer {
    private long[] childrenTrafficEvents;
    private NavRectangle rectangle;

    public long[] getChildrenTrafficEvents() {
        return this.childrenTrafficEvents;
    }

    public void setChildrenTrafficEvents(long[] lArray) {
        this.childrenTrafficEvents = lArray;
    }

    public NavRectangle getRectangle() {
        return this.rectangle;
    }

    public void setRectangle(NavRectangle navRectangle) {
        this.rectangle = navRectangle;
    }
}

