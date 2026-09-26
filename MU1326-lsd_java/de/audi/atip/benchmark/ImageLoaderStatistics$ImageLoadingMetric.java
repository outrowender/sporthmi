/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.ImageLoaderStatistics$1;

class ImageLoaderStatistics$ImageLoadingMetric {
    private long start;
    private long end;
    private String imgPath;
    private boolean error;

    private ImageLoaderStatistics$ImageLoadingMetric() {
    }

    /* synthetic */ ImageLoaderStatistics$ImageLoadingMetric(ImageLoaderStatistics$1 imageLoaderStatistics$1) {
        this();
    }

    static /* synthetic */ long access$202(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric, long l) {
        imageLoaderStatistics$ImageLoadingMetric.start = l;
        return imageLoaderStatistics$ImageLoadingMetric.start;
    }

    static /* synthetic */ long access$302(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric, long l) {
        imageLoaderStatistics$ImageLoadingMetric.end = l;
        return imageLoaderStatistics$ImageLoadingMetric.end;
    }

    static /* synthetic */ String access$402(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric, String string) {
        imageLoaderStatistics$ImageLoadingMetric.imgPath = string;
        return imageLoaderStatistics$ImageLoadingMetric.imgPath;
    }

    static /* synthetic */ boolean access$502(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric, boolean bl) {
        imageLoaderStatistics$ImageLoadingMetric.error = bl;
        return imageLoaderStatistics$ImageLoadingMetric.error;
    }

    static /* synthetic */ String access$400(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric) {
        return imageLoaderStatistics$ImageLoadingMetric.imgPath;
    }

    static /* synthetic */ boolean access$500(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric) {
        return imageLoaderStatistics$ImageLoadingMetric.error;
    }

    static /* synthetic */ long access$300(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric) {
        return imageLoaderStatistics$ImageLoadingMetric.end;
    }

    static /* synthetic */ long access$200(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric) {
        return imageLoaderStatistics$ImageLoadingMetric.start;
    }
}

