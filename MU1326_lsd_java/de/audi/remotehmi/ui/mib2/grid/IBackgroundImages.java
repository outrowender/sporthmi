/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.RemoteHMIGuideIcon;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public interface IBackgroundImages {
    public ImageContent getTop();

    public ImageContent getCenter();

    public ImageContent getBottom();

    public boolean isStretchTopBottomVertically();

    public boolean isTopGenerateRow();

    public boolean isBottomGenerateRow();

    public static final class ImageContent {
        private final Integer cellType;
        private final String url;
        private final RemoteHMIGuideIcon guideIcon;

        public ImageContent(String string) {
            this(string, null, null);
        }

        public ImageContent(Integer n, RemoteHMIGuideIcon remoteHMIGuideIcon) {
            this(null, n, remoteHMIGuideIcon);
        }

        private ImageContent(String string, Integer n, RemoteHMIGuideIcon remoteHMIGuideIcon) {
            this.url = string;
            this.cellType = n;
            this.guideIcon = remoteHMIGuideIcon;
        }

        public Integer getCellType() {
            return this.cellType;
        }

        public String getUrl() {
            return this.url;
        }

        public IGridCell createGridCell(IGridFactory iGridFactory) {
            if (this.cellType != null) {
                IGridCell iGridCell = iGridFactory.createGridCell(0, 0, this.cellType);
                if (this.cellType == 16 && this.guideIcon != null) {
                    iGridCell.setStringValue(this.guideIcon.getName());
                }
                return iGridCell;
            }
            IGridCell iGridCell = iGridFactory.createGridCell(0, 0, 1);
            iGridCell.setStringValue(Util.useFileLocationOrEmptyIfNotExist(this.url));
            iGridCell.setLocalLocation(this.url);
            return iGridCell;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("ImageContent:");
            if (this.cellType != null) {
                buffer.append("cellType=");
                buffer.append(this.cellType.toString());
            }
            if (this.url != null) {
                buffer.append("url=");
                buffer.append(this.url);
            }
            return buffer.toString();
        }
    }
}

