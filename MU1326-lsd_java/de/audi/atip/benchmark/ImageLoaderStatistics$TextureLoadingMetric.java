/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.ImageLoaderStatistics$ImageLoadingMetric;

class ImageLoaderStatistics$TextureLoadingMetric {
    private long start;
    private long end;
    private ImageLoaderStatistics$ImageLoadingMetric imgMetric;
    private boolean cacheInEAL;
    private boolean error;

    public ImageLoaderStatistics$TextureLoadingMetric(ImageLoaderStatistics$ImageLoadingMetric imageLoaderStatistics$ImageLoadingMetric) {
        this.imgMetric = imageLoaderStatistics$ImageLoadingMetric;
    }

    static /* synthetic */ boolean access$602(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric, boolean bl) {
        imageLoaderStatistics$TextureLoadingMetric.cacheInEAL = bl;
        return imageLoaderStatistics$TextureLoadingMetric.cacheInEAL;
    }

    static /* synthetic */ long access$702(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric, long l) {
        imageLoaderStatistics$TextureLoadingMetric.end = l;
        return imageLoaderStatistics$TextureLoadingMetric.end;
    }

    static /* synthetic */ long access$802(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric, long l) {
        imageLoaderStatistics$TextureLoadingMetric.start = l;
        return imageLoaderStatistics$TextureLoadingMetric.start;
    }

    static /* synthetic */ boolean access$902(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric, boolean bl) {
        imageLoaderStatistics$TextureLoadingMetric.error = bl;
        return imageLoaderStatistics$TextureLoadingMetric.error;
    }

    static /* synthetic */ ImageLoaderStatistics$ImageLoadingMetric access$1000(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric) {
        return imageLoaderStatistics$TextureLoadingMetric.imgMetric;
    }

    static /* synthetic */ boolean access$600(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric) {
        return imageLoaderStatistics$TextureLoadingMetric.cacheInEAL;
    }

    static /* synthetic */ boolean access$900(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric) {
        return imageLoaderStatistics$TextureLoadingMetric.error;
    }

    static /* synthetic */ long access$700(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric) {
        return imageLoaderStatistics$TextureLoadingMetric.end;
    }

    static /* synthetic */ long access$800(ImageLoaderStatistics$TextureLoadingMetric imageLoaderStatistics$TextureLoadingMetric) {
        return imageLoaderStatistics$TextureLoadingMetric.start;
    }
}

