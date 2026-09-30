/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ListCell;
import de.esolutions.fw.util.commons.Buffer;

public class IconCell
implements ListCell {
    public static final int TYPE_ICON_SIMPLE = 0;
    public static final int TYPE_ICON_TEXT = 1;
    public static final int FONT_SIZE_IN_POINTS = 0;
    public static final int FONT_SIZE_IN_PIXELS = 1;
    private int type;
    private int resourceId;
    private String resourcePath;
    private String iconText;
    private int fontReference;
    private int fontSize;
    private int fontSizeType = 1;
    private int textColor;
    private int deltaX;
    private int deltaY;
    private HMIResourceLocator resourceLocator;

    public IconCell(int n, String string, int n2, int n3, int n4, int n5, int n6) {
        this.resourceId = n;
        this.resourcePath = null;
        this.resourceLocator = null;
        this.iconText = string;
        this.fontReference = n2;
        this.fontSize = n3;
        this.textColor = n4;
        this.deltaX = n5;
        this.deltaY = n6;
        this.type = 1;
    }

    public IconCell(HMIResourceLocator hMIResourceLocator, String string, int n, int n2, int n3, int n4, int n5) {
        this.resourceId = -1;
        this.resourcePath = null;
        this.resourceLocator = hMIResourceLocator;
        this.iconText = string;
        this.fontReference = n;
        this.fontSize = n2;
        this.textColor = n3;
        this.deltaX = n4;
        this.deltaY = n5;
        this.type = 1;
    }

    public IconCell(String string, String string2, int n, int n2, int n3, int n4, int n5) {
        this.resourceId = -1;
        this.resourcePath = string;
        this.resourceLocator = null;
        this.iconText = string2;
        this.fontReference = n;
        this.fontSize = n2;
        this.textColor = n3;
        this.deltaX = n4;
        this.deltaY = n5;
        this.type = 1;
    }

    public IconCell(int n) {
        this.resourceId = n;
        this.type = 0;
    }

    public IconCell(String string) {
        this.resourcePath = string;
        this.type = 0;
    }

    public IconCell(HMIResourceLocator hMIResourceLocator) {
        this.resourceLocator = hMIResourceLocator;
        this.type = 0;
    }

    public IconCell(IconCell iconCell) {
        if (iconCell != null) {
            this.resourceId = iconCell.resourceId;
            this.resourcePath = iconCell.resourcePath;
            this.resourceLocator = iconCell.resourceLocator;
            this.iconText = iconCell.iconText;
            this.fontReference = iconCell.fontReference;
            this.fontSize = iconCell.fontSize;
            this.textColor = iconCell.textColor;
            this.deltaX = iconCell.deltaX;
            this.deltaY = iconCell.deltaY;
            this.type = iconCell.type;
        }
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof IconCell)) {
            return false;
        }
        IconCell iconCell = (IconCell)object;
        return this.resourceId == iconCell.resourceId && this.type == iconCell.type && this.iconText == iconCell.iconText && this.fontReference == iconCell.fontReference && this.fontSize == iconCell.fontSize && this.textColor == iconCell.textColor && this.deltaY == iconCell.deltaY && this.deltaX == iconCell.deltaX && this.resourceLocator == iconCell.resourceLocator;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.resourceId;
        n = 31 * n + this.deltaX;
        n = 31 * n + this.deltaY;
        n = 31 * n + this.type;
        n = 31 * n + this.fontReference;
        n = 31 * n + this.fontSize;
        n = 31 * n + this.textColor;
        n = 31 * n + this.type;
        n = 31 * n + (this.iconText == null ? 0 : this.iconText.hashCode());
        n = 31 * n + (this.resourceLocator == null ? 0 : this.resourceLocator.hashCode());
        return n;
    }

    public int getDeltaX() {
        return this.deltaX;
    }

    public int getDeltaY() {
        return this.deltaY;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getFontReference() {
        return this.fontReference;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getIconText() {
        return this.iconText;
    }

    public int getResourceId() {
        return this.resourceLocator != null ? this.resourceLocator.getResourceID() : this.resourceId;
    }

    public int getType() {
        return this.type;
    }

    public int getFontSizeType() {
        return this.fontSizeType;
    }

    public void setFontSizeType(int n) {
        this.fontSizeType = n;
    }

    public boolean loadIconViaPath() {
        return this.resourcePath != null;
    }

    public void initializeIconTextID(int n, String string, int n2, int n3, int n4, int n5, int n6) {
        this.resourceId = n;
        this.resourcePath = null;
        this.resourceLocator = null;
        this.iconText = string;
        this.fontReference = n2;
        this.fontSize = n3;
        this.textColor = n4;
        this.deltaX = n5;
        this.deltaY = n6;
        this.type = 1;
    }

    public void initializeIconTextLocator(HMIResourceLocator hMIResourceLocator, String string, int n, int n2, int n3, int n4, int n5) {
        this.resourceId = -1;
        this.resourcePath = null;
        this.resourceLocator = hMIResourceLocator;
        this.iconText = string;
        this.fontReference = n;
        this.fontSize = n2;
        this.textColor = n3;
        this.deltaX = n4;
        this.deltaY = n5;
        this.type = 1;
    }

    public void initializeIconSimpleLocator(HMIResourceLocator hMIResourceLocator) {
        this.resourceId = -1;
        this.resourcePath = null;
        this.resourceLocator = hMIResourceLocator;
        this.iconText = null;
        this.fontReference = -1;
        this.fontSize = -1;
        this.textColor = -1;
        this.deltaX = -1;
        this.deltaY = -1;
        this.type = 0;
    }

    public String getResourcePath() {
        return this.resourceLocator != null ? this.resourceLocator.getResourceURI() : this.resourcePath;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("resourceLocator: ").append(this.getResourceLocator() != null ? this.getResourceLocator().toString() : "null");
        buffer.append(", resourceId: ").append(this.resourceId);
        buffer.append(", resourcePath: ").append(this.resourcePath);
        if (this.type == 1) {
            buffer.append(", iconText: ").append(this.iconText);
            buffer.append(", fontReference: ").append(this.fontReference);
            buffer.append(", fontSize: ").append(this.fontSize);
            buffer.append(", textColor: ").append(this.textColor);
            buffer.append(", deltaX: ").append(this.deltaX);
            buffer.append(", deltaY: ").append(this.deltaY);
        }
        return buffer.toString();
    }

    public HMIResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public void setResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.resourceLocator = hMIResourceLocator;
    }
}

