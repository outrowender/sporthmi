/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.interapp.media.DVDVideoSettingsLanguageMapping;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.tvtuner.AudioChannel;

public final class AudioLanguageCodes
extends DVDVideoSettingsLanguageMapping {
    private static final Map MAP = new HashMap(288);

    static int getTextID(AudioChannel audioChannel) {
        if (audioChannel == null || audioChannel.audioLanguage == null) {
            return 0;
        }
        Integer n = (Integer)MAP.get(audioChannel.audioLanguage.toLowerCase());
        if (n == null) {
            return 0;
        }
        return n;
    }

    private AudioLanguageCodes() {
    }

    static {
        MAP.put("afr", new Integer(1));
        MAP.put("ara", new Integer(2));
        MAP.put("aze", new Integer(3));
        MAP.put("bel", new Integer(4));
        MAP.put("bul", new Integer(5));
        MAP.put("bre", new Integer(6));
        MAP.put("cat", new Integer(7));
        MAP.put("cze", new Integer(8));
        MAP.put("ces", new Integer(8));
        MAP.put("wel", new Integer(9));
        MAP.put("cym", new Integer(9));
        MAP.put("dan", new Integer(10));
        MAP.put("ger", new Integer(11));
        MAP.put("deu", new Integer(11));
        MAP.put("gre", new Integer(12));
        MAP.put("ell", new Integer(12));
        MAP.put("eng", new Integer(13));
        MAP.put("epo", new Integer(14));
        MAP.put("spa", new Integer(15));
        MAP.put("est", new Integer(16));
        MAP.put("baq", new Integer(17));
        MAP.put("eus", new Integer(17));
        MAP.put("fin", new Integer(18));
        MAP.put("fao", new Integer(19));
        MAP.put("fre", new Integer(20));
        MAP.put("fra", new Integer(20));
        MAP.put("fry", new Integer(21));
        MAP.put("gle", new Integer(22));
        MAP.put("gla", new Integer(23));
        MAP.put("glv", new Integer(24));
        MAP.put("heb", new Integer(25));
        MAP.put("hrv", new Integer(26));
        MAP.put("hun", new Integer(27));
        MAP.put("ind", new Integer(28));
        MAP.put("ice", new Integer(29));
        MAP.put("isl", new Integer(29));
        MAP.put("ita", new Integer(30));
        MAP.put("jpn", new Integer(31));
        MAP.put("kal", new Integer(32));
        MAP.put("kur", new Integer(33));
        MAP.put("lat", new Integer(34));
        MAP.put("ltz", new Integer(35));
        MAP.put("lit", new Integer(36));
        MAP.put("lav", new Integer(37));
        MAP.put("mac", new Integer(38));
        MAP.put("mkd", new Integer(38));
        MAP.put("mlt", new Integer(39));
        MAP.put("dut", new Integer(40));
        MAP.put("nld", new Integer(40));
        MAP.put("nor", new Integer(41));
        MAP.put("pol", new Integer(42));
        MAP.put("por", new Integer(43));
        MAP.put("roh", new Integer(44));
        MAP.put("rum", new Integer(45));
        MAP.put("ron", new Integer(45));
        MAP.put("rus", new Integer(46));
        MAP.put("sme", new Integer(47));
        MAP.put("slo", new Integer(48));
        MAP.put("slk", new Integer(48));
        MAP.put("slv", new Integer(49));
        MAP.put("som", new Integer(50));
        MAP.put("alb", new Integer(51));
        MAP.put("sqi", new Integer(51));
        MAP.put("srp", new Integer(52));
        MAP.put("swe", new Integer(53));
        MAP.put("swa", new Integer(54));
        MAP.put("tur", new Integer(55));
        MAP.put("ukr", new Integer(56));
        MAP.put("vie", new Integer(57));
        MAP.put("yid", new Integer(58));
        MAP.put("chi", new Integer(59));
        MAP.put("zho", new Integer(59));
        MAP.put("aar", new Integer(62));
        MAP.put("abk", new Integer(63));
        MAP.put("amh", new Integer(64));
        MAP.put("asm", new Integer(65));
        MAP.put("aym", new Integer(66));
        MAP.put("bak", new Integer(67));
        MAP.put("bih", new Integer(68));
        MAP.put("bis", new Integer(69));
        MAP.put("ben", new Integer(70));
        MAP.put("tib", new Integer(71));
        MAP.put("bod", new Integer(71));
        MAP.put("cos", new Integer(72));
        MAP.put("dzo", new Integer(73));
        MAP.put("per", new Integer(74));
        MAP.put("fas", new Integer(74));
        MAP.put("fij", new Integer(75));
        MAP.put("glg", new Integer(76));
        MAP.put("grn", new Integer(77));
        MAP.put("guj", new Integer(78));
        MAP.put("hau", new Integer(79));
        MAP.put("hin", new Integer(80));
        MAP.put("arm", new Integer(81));
        MAP.put("hye", new Integer(81));
        MAP.put("ina", new Integer(82));
        MAP.put("ile", new Integer(83));
        MAP.put("ipk", new Integer(84));
        MAP.put("jav", new Integer(86));
        MAP.put("jaw", new Integer(86));
        MAP.put("geo", new Integer(87));
        MAP.put("kat", new Integer(87));
        MAP.put("kaz", new Integer(88));
        MAP.put("khm", new Integer(89));
        MAP.put("kan", new Integer(90));
        MAP.put("kor", new Integer(91));
        MAP.put("kas", new Integer(92));
        MAP.put("kir", new Integer(93));
        MAP.put("lin", new Integer(94));
        MAP.put("lao", new Integer(95));
        MAP.put("mlg", new Integer(96));
        MAP.put("mao", new Integer(97));
        MAP.put("mri", new Integer(97));
        MAP.put("mal", new Integer(98));
        MAP.put("mon", new Integer(99));
        MAP.put("mol", new Integer(100));
        MAP.put("mar", new Integer(101));
        MAP.put("may", new Integer(102));
        MAP.put("msa", new Integer(102));
        MAP.put("bur", new Integer(103));
        MAP.put("mya", new Integer(103));
        MAP.put("nau", new Integer(104));
        MAP.put("nep", new Integer(105));
        MAP.put("oci", new Integer(106));
        MAP.put("ori", new Integer(107));
        MAP.put("orm", new Integer(108));
        MAP.put("que", new Integer(109));
        MAP.put("pan", new Integer(110));
        MAP.put("pus", new Integer(111));
        MAP.put("run", new Integer(112));
        MAP.put("kin", new Integer(113));
        MAP.put("san", new Integer(114));
        MAP.put("snd", new Integer(115));
        MAP.put("sag", new Integer(116));
        MAP.put("scr", new Integer(117));
        MAP.put("sin", new Integer(118));
        MAP.put("smo", new Integer(119));
        MAP.put("sna", new Integer(120));
        MAP.put("ssw", new Integer(121));
        MAP.put("sot", new Integer(122));
        MAP.put("sun", new Integer(123));
        MAP.put("tam", new Integer(124));
        MAP.put("tel", new Integer(125));
        MAP.put("tgk", new Integer(126));
        MAP.put("tha", new Integer(127));
        MAP.put("tir", new Integer(128));
        MAP.put("tuk", new Integer(129));
        MAP.put("tgl", new Integer(130));
        MAP.put("tsn", new Integer(131));
        MAP.put("ton", new Integer(132));
        MAP.put("tso", new Integer(133));
        MAP.put("tat", new Integer(134));
        MAP.put("twi", new Integer(135));
        MAP.put("urd", new Integer(136));
        MAP.put("uzb", new Integer(137));
        MAP.put("vol", new Integer(138));
        MAP.put("wol", new Integer(139));
        MAP.put("xho", new Integer(140));
        MAP.put("yor", new Integer(141));
        MAP.put("zul", new Integer(142));
    }
}

