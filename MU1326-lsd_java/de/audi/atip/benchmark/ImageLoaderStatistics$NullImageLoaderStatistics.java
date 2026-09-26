/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.ImageLoaderStatistics$1;
import java.io.PrintStream;

final class ImageLoaderStatistics$NullImageLoaderStatistics
implements IImageLoaderStatistics {
    private ImageLoaderStatistics$NullImageLoaderStatistics() {
    }

    @Override
    public void reset() {
    }

    @Override
    public String getName() {
        return "ImageLoaderStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
    }

    @Override
    public void imageLoadEnd(String string, boolean bl) {
    }

    @Override
    public void imageLoadStart() {
    }

    @Override
    public void textureCreateEnd(String string, boolean bl, boolean bl2) {
    }

    @Override
    public void textureCreateStart() {
    }

    /* synthetic */ ImageLoaderStatistics$NullImageLoaderStatistics(ImageLoaderStatistics$1 imageLoaderStatistics$1) {
        this();
    }
}

