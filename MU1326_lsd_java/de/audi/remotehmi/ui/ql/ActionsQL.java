/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.ql;

import de.audi.remotehmi.ui.core.ActionsCore;

public interface ActionsQL
extends ActionsCore {
    public static final int TYPE_SKEY_NE = 100;
    public static final int TYPE_SKEY_SE = 101;
    public static final int TYPE_SKEY_SW = 102;
    public static final int TYPE_SKEY_NW = 103;
    public static final int TYPE_SPELLER_FINISH = 200;
    public static final int TYPE_BROWSER_CLOSE = 400;
    public static final int TYPE_BROWSER_OPENLINK = 401;
    public static final int TYPE_BROWSER_NOTFOUND = 402;
    public static final int TYPE_BROWSER_COMPLETE = 403;
    public static final int TYPE_BROWSER_MESSAGE = 404;
    public static final int TYPE_MEDIA_FINISHED = 500;
    public static final int TYPE_MEDIA_ABORTED = 501;
    public static final int TYPE_MEDIA_PAUSED = 502;
    public static final int TYPE_MEDIA_PLAYING = 503;
    public static final int TYPE_MEDIA_PLAY_POSITION = 550;
    public static final int TYPE_MEDIA_HARDKEY_PREV = 580;
    public static final int TYPE_MEDIA_HARDKEY_PREV_PRESSED = 581;
    public static final int TYPE_MEDIA_HARDKEY_PREV_RELEASED = 582;
    public static final int TYPE_MEDIA_HARDKEY_NEXT = 590;
    public static final int TYPE_MEDIA_HARDKEY_NEXT_PRESSED = 591;
    public static final int TYPE_MEDIA_HARDKEY_NEXT_RELEASED = 592;
    public static final int TYPE_REQUEST_INFINITE_LIST_DATA = 600;
    public static final int TYPE_ASR = 900;
    public static final int TYPE_ASR_HELP = 901;
    public static final int TYPE_EFI_LINK_SUCCESS = 1500;
    public static final int TYPE_EFI_LINK_ERROR = 1501;
    public static final int TYPE_APPLIST_INVALIDATE = 1600;
    public static final int TYPE_SEND_LICENSES = 1700;
}

