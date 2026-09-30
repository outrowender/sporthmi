/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ImageLoaderStatistics
implements IImageLoaderStatistics {
    static final String HEADER = "Type(T=texture & I=image);Image Path;Img Start(ms);Img End(ms);Img Duration(ms);Img Load Error;Img Length(bytes);Texture Start(ms);Texture End(ms);Texture Duration(ms);Texture Load Error;Cache in EAL?;Texture Total Time(ms)";
    static final IImageLoaderStatistics NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new NullImageLoaderStatistics() : null;
    private final ITimeSource timeSource;
    private final List imgLoadingMetrics;
    private long start;

    public ImageLoaderStatistics(StatisticsManager statisticsManager) {
        this.timeSource = statisticsManager.getTimeSource();
        this.imgLoadingMetrics = new LinkedList();
    }

    public void imageLoadStart() {
        this.start = this.timeSource.getCurrentTime();
    }

    public void imageLoadEnd(String string, boolean bl) {
        long l = this.timeSource.getCurrentTime();
        ImageLoadingMetric imageLoadingMetric = new ImageLoadingMetric();
        this.imgLoadingMetrics.add(imageLoadingMetric);
        imageLoadingMetric.start = this.start;
        imageLoadingMetric.end = l;
        imageLoadingMetric.imgPath = string;
        imageLoadingMetric.error = bl;
    }

    public void textureCreateStart() {
        this.start = this.timeSource.getCurrentTime();
    }

    public void textureCreateEnd(String string, boolean bl, boolean bl2) {
        Object object;
        long l = this.timeSource.getCurrentTime();
        if (!this.imgLoadingMetrics.isEmpty() && (object = this.imgLoadingMetrics.get(this.imgLoadingMetrics.size() - 1)) instanceof ImageLoadingMetric) {
            TextureLoadingMetric textureLoadingMetric = new TextureLoadingMetric((ImageLoadingMetric)object);
            textureLoadingMetric.cacheInEAL = bl;
            textureLoadingMetric.end = l;
            textureLoadingMetric.start = this.start;
            textureLoadingMetric.error = bl2;
            this.imgLoadingMetrics.set(this.imgLoadingMetrics.size() - 1, textureLoadingMetric);
        }
    }

    public void doDump(PrintStream printStream) {
        if (this.imgLoadingMetrics.isEmpty()) {
            printStream.println("No measurements taken!");
            return;
        }
        printStream.println(HEADER);
        Iterator iterator = this.imgLoadingMetrics.iterator();
        while (iterator.hasNext()) {
            Object object;
            Buffer buffer = new Buffer(128);
            Object object2 = iterator.next();
            if (object2 instanceof ImageLoadingMetric) {
                object = (ImageLoadingMetric)object2;
                buffer.append('I').append(";").append(((ImageLoadingMetric)object).imgPath).append(";").append(((ImageLoadingMetric)object).start).append(";").append(((ImageLoadingMetric)object).end).append(";").append(((ImageLoadingMetric)object).end - ((ImageLoadingMetric)object).start).append(";").append(((ImageLoadingMetric)object).error).append(";").append(ImageLoaderStatistics.getFileSize(((ImageLoadingMetric)object).imgPath)).append(";-;-;-;-;-;-");
            } else if (object2 instanceof TextureLoadingMetric) {
                object = (TextureLoadingMetric)object2;
                buffer.append('T').append(";");
                long l = 0L;
                if (null == ((TextureLoadingMetric)object).imgMetric) {
                    buffer.append("-;-;-;-;-;-;");
                } else {
                    l = ((TextureLoadingMetric)object).imgMetric.end - ((TextureLoadingMetric)object).imgMetric.start;
                    buffer.append(((TextureLoadingMetric)object).imgMetric.imgPath).append(";").append(((TextureLoadingMetric)object).imgMetric.start).append(";").append(((TextureLoadingMetric)object).imgMetric.end).append(";").append(l).append(";").append(((TextureLoadingMetric)object).imgMetric.error).append(";").append(ImageLoaderStatistics.getFileSize(((TextureLoadingMetric)object).imgMetric.imgPath)).append(";");
                }
                long l2 = 0L;
                l2 = ((TextureLoadingMetric)object).end - ((TextureLoadingMetric)object).start;
                buffer.append(((TextureLoadingMetric)object).start).append(";").append(((TextureLoadingMetric)object).end).append(";").append(l2).append(";").append(((TextureLoadingMetric)object).error).append(";").append(((TextureLoadingMetric)object).cacheInEAL).append(";").append(l + l2);
            }
            printStream.println(buffer);
        }
    }

    private static long getFileSize(String string) {
        File file = new File(string);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return -1L;
    }

    public void reset() {
        this.imgLoadingMetrics.clear();
    }

    public String getName() {
        return "ImageLoaderStatistics.csv";
    }

    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            printStream.println("Exception while printing image loading statistics: " + exception);
        }
    }

    private static class ImageLoadingMetric {
        private long start;
        private long end;
        private String imgPath;
        private boolean error;

        private ImageLoadingMetric() {
        }
    }

    private static class TextureLoadingMetric {
        private long start;
        private long end;
        private ImageLoadingMetric imgMetric;
        private boolean cacheInEAL;
        private boolean error;

        public TextureLoadingMetric(ImageLoadingMetric imageLoadingMetric) {
            this.imgMetric = imageLoadingMetric;
        }
    }

    private static final class NullImageLoaderStatistics
    implements IImageLoaderStatistics {
        private NullImageLoaderStatistics() {
        }

        public void reset() {
        }

        public String getName() {
            return "ImageLoaderStatistics.csv";
        }

        public void dump(PrintStream printStream, String string) {
        }

        public void imageLoadEnd(String string, boolean bl) {
        }

        public void imageLoadStart() {
        }

        public void textureCreateEnd(String string, boolean bl, boolean bl2) {
        }

        public void textureCreateStart() {
        }
    }
}

