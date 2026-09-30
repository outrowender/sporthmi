/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

public interface CTags {

    public static interface HasPosition {
    }

    public static interface HasZoomArea {
    }

    public static interface HasDefaultZoom {
        public float getDefaultZoomLevel();
    }

    public static interface IsDependentOnRegion {
    }

    public static interface IsDependentOnMapInstance {
    }
}

