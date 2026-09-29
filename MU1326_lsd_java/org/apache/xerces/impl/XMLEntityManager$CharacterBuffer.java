/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

final class XMLEntityManager$CharacterBuffer {
    private char[] ch;
    private boolean isExternal;

    public XMLEntityManager$CharacterBuffer(boolean bl, int n) {
        this.isExternal = bl;
        this.ch = new char[n];
    }

    static /* synthetic */ char[] access$300(XMLEntityManager$CharacterBuffer xMLEntityManager$CharacterBuffer) {
        return xMLEntityManager$CharacterBuffer.ch;
    }

    static /* synthetic */ boolean access$500(XMLEntityManager$CharacterBuffer xMLEntityManager$CharacterBuffer) {
        return xMLEntityManager$CharacterBuffer.isExternal;
    }
}

