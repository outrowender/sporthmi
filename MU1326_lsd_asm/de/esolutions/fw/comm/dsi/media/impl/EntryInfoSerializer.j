.version 50 0 
.class public super [329] 
.super [331] 

.method public annotation [333] : [334] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [335] : [336] 
    .attribute [332] .code stack 3 locals 28 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [33] 0 
L17:    iload_2 
L18:    ifne L283 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [34] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 5 
L39:    aload_0 
L40:    aload 5 
L42:    invokeinterface [35] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    istore 6 
L53:    aload_0 
L54:    iload 6 
L56:    invokeinterface [36] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    astore 7 
L67:    aload_0 
L68:    aload 7 
L70:    invokeinterface [35] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    lstore 8 
L81:    aload_0 
L82:    lload 8 
L84:    invokeinterface [34] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    lstore 10 
L95:    aload_0 
L96:    lload 10 
L98:    invokeinterface [34] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   lstore 12 
L109:   aload_0 
L110:   lload 12 
L112:   invokeinterface [34] 0 
L117:   aload_1 
L118:   invokevirtual [19] 
L121:   lstore 14 
L123:   aload_0 
L124:   lload 14 
L126:   invokeinterface [34] 0 
L131:   aload_1 
L132:   invokevirtual [20] 
L135:   lstore 16 
L137:   aload_0 
L138:   lload 16 
L140:   invokeinterface [34] 0 
L145:   aload_1 
L146:   invokevirtual [21] 
L149:   astore 18 
L151:   aload_0 
L152:   aload 18 
L154:   invokeinterface [35] 0 
L159:   aload_1 
L160:   invokevirtual [22] 
L163:   astore 19 
L165:   aload_0 
L166:   aload 19 
L168:   invokeinterface [35] 0 
L173:   aload_1 
L174:   invokevirtual [23] 
L177:   astore 20 
L179:   aload_0 
L180:   aload 20 
L182:   invokeinterface [35] 0 
L187:   aload_1 
L188:   invokevirtual [24] 
L191:   astore 21 
L193:   aload_0 
L194:   aload 21 
L196:   invokeinterface [35] 0 
L201:   aload_1 
L202:   invokevirtual [25] 
L205:   astore 22 
L207:   aload_0 
L208:   aload 22 
L210:   invokeinterface [35] 0 
L215:   aload_1 
L216:   invokevirtual [26] 
L219:   lstore 23 
L221:   aload_0 
L222:   lload 23 
L224:   invokeinterface [34] 0 
L229:   aload_1 
L230:   invokevirtual [27] 
L233:   lstore 25 
L235:   aload_0 
L236:   lload 25 
L238:   invokeinterface [34] 0 
L243:   aload_1 
L244:   invokevirtual [28] 
L247:   istore 27 
L249:   aload_0 
L250:   iload 27 
L252:   invokeinterface [36] 0 
L257:   aload_1 
L258:   invokevirtual [29] 
L261:   istore 28 
L263:   aload_0 
L264:   iload 28 
L266:   invokeinterface [36] 0 
L271:   aload_1 
L272:   invokevirtual [30] 
L275:   astore 29 
L277:   aload_0 
L278:   aload 29 
L280:   invokestatic [2] 
L283:   return 
L284:   
    .end code 
.end method 

.method public static [337] : [338] 
    .attribute [332] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [33] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [36] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [339] : [340] 
    .attribute [332] .code stack 3 locals 29 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [37] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L283 
L13:    new [38] 
L16:    dup 
L17:    invokespecial [32] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [39] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [40] 
L33:    aload_0 
L34:    invokeinterface [41] 0 
L39:    astore 5 
L41:    aload_1 
L42:    aload 5 
L44:    putfield [42] 
L47:    aload_0 
L48:    invokeinterface [43] 0 
L53:    istore 6 
L55:    aload_1 
L56:    iload 6 
L58:    putfield [44] 
L61:    aload_0 
L62:    invokeinterface [41] 0 
L67:    astore 7 
L69:    aload_1 
L70:    aload 7 
L72:    putfield [45] 
L75:    aload_0 
L76:    invokeinterface [39] 0 
L81:    lstore 8 
L83:    aload_1 
L84:    lload 8 
L86:    putfield [46] 
L89:    aload_0 
L90:    invokeinterface [39] 0 
L95:    lstore 10 
L97:    aload_1 
L98:    lload 10 
L100:   putfield [47] 
L103:   aload_0 
L104:   invokeinterface [39] 0 
L109:   lstore 12 
L111:   aload_1 
L112:   lload 12 
L114:   putfield [48] 
L117:   aload_0 
L118:   invokeinterface [39] 0 
L123:   lstore 14 
L125:   aload_1 
L126:   lload 14 
L128:   putfield [49] 
L131:   aload_0 
L132:   invokeinterface [39] 0 
L137:   lstore 16 
L139:   aload_1 
L140:   lload 16 
L142:   putfield [50] 
L145:   aload_0 
L146:   invokeinterface [41] 0 
L151:   astore 18 
L153:   aload_1 
L154:   aload 18 
L156:   putfield [51] 
L159:   aload_0 
L160:   invokeinterface [41] 0 
L165:   astore 19 
L167:   aload_1 
L168:   aload 19 
L170:   putfield [52] 
L173:   aload_0 
L174:   invokeinterface [41] 0 
L179:   astore 20 
L181:   aload_1 
L182:   aload 20 
L184:   putfield [53] 
L187:   aload_0 
L188:   invokeinterface [41] 0 
L193:   astore 21 
L195:   aload_1 
L196:   aload 21 
L198:   putfield [54] 
L201:   aload_0 
L202:   invokeinterface [41] 0 
L207:   astore 22 
L209:   aload_1 
L210:   aload 22 
L212:   putfield [55] 
L215:   aload_0 
L216:   invokeinterface [39] 0 
L221:   lstore 23 
L223:   aload_1 
L224:   lload 23 
L226:   putfield [56] 
L229:   aload_0 
L230:   invokeinterface [39] 0 
L235:   lstore 25 
L237:   aload_1 
L238:   lload 25 
L240:   putfield [57] 
L243:   aload_0 
L244:   invokeinterface [43] 0 
L249:   istore 27 
L251:   aload_1 
L252:   iload 27 
L254:   putfield [58] 
L257:   aload_0 
L258:   invokeinterface [43] 0 
L263:   istore 28 
L265:   aload_1 
L266:   iload 28 
L268:   putfield [59] 
L271:   aload_0 
L272:   invokestatic [5] 
L275:   astore 29 
L277:   aload_1 
L278:   aload 29 
L280:   putfield [60] 
L283:   aload_1 
L284:   areturn 
L285:   nop 
L286:   nop 
L287:   nop 
L288:   
    .end code 
.end method 

.method public static [341] : [342] 
    .attribute [332] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [37] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [43] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [61] [62] 
.const [3] = Method [63] [64] 
.const [4] = Class [65] 
.const [5] = Method [66] [67] 
.const [6] = Method [68] [69] 
.const [7] = Class [70] 
.const [8] = Class [71] 
.const [9] = Class [72] 
.const [10] = Class [73] 
.const [11] = Class [74] 
.const [12] = Method [75] [76] 
.const [13] = Method [77] [78] 
.const [14] = Method [79] [80] 
.const [15] = Method [81] [82] 
.const [16] = Method [83] [84] 
.const [17] = Method [85] [86] 
.const [18] = Method [87] [88] 
.const [19] = Method [89] [90] 
.const [20] = Method [91] [92] 
.const [21] = Method [93] [94] 
.const [22] = Method [95] [96] 
.const [23] = Method [97] [98] 
.const [24] = Method [99] [100] 
.const [25] = Method [101] [102] 
.const [26] = Method [103] [104] 
.const [27] = Method [105] [106] 
.const [28] = Method [107] [108] 
.const [29] = Method [109] [110] 
.const [30] = Method [111] [112] 
.const [31] = Method [113] [114] 
.const [32] = Method [115] [116] 
.const [33] = InterfaceMethod [117] [118] 
.const [34] = InterfaceMethod [119] [120] 
.const [35] = InterfaceMethod [121] [122] 
.const [36] = InterfaceMethod [123] [124] 
.const [37] = InterfaceMethod [125] [126] 
.const [38] = Class [127] 
.const [39] = InterfaceMethod [128] [129] 
.const [40] = Field [130] [131] 
.const [41] = InterfaceMethod [132] [133] 
.const [42] = Field [134] [135] 
.const [43] = InterfaceMethod [136] [137] 
.const [44] = Field [138] [139] 
.const [45] = Field [140] [141] 
.const [46] = Field [142] [143] 
.const [47] = Field [144] [145] 
.const [48] = Field [146] [147] 
.const [49] = Field [148] [149] 
.const [50] = Field [150] [151] 
.const [51] = Field [152] [153] 
.const [52] = Field [154] [155] 
.const [53] = Field [156] [157] 
.const [54] = Field [158] [159] 
.const [55] = Field [160] [161] 
.const [56] = Field [162] [163] 
.const [57] = Field [164] [165] 
.const [58] = Field [166] [167] 
.const [59] = Field [168] [169] 
.const [60] = Field [170] [171] 
.const [61] = Class [172] 
.const [62] = NameAndType [173] [174] 
.const [63] = Class [175] 
.const [64] = NameAndType [176] [177] 
.const [65] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [66] = Class [178] 
.const [67] = NameAndType [179] [180] 
.const [68] = Class [181] 
.const [69] = NameAndType [182] [183] 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/media/impl/EntryInfoSerializer 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ChapterInfoSerializer 
.const [74] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [75] = Class [184] 
.const [76] = NameAndType [185] [186] 
.const [77] = Class [187] 
.const [78] = NameAndType [188] [189] 
.const [79] = Class [190] 
.const [80] = NameAndType [191] [192] 
.const [81] = Class [193] 
.const [82] = NameAndType [194] [195] 
.const [83] = Class [196] 
.const [84] = NameAndType [197] [198] 
.const [85] = Class [199] 
.const [86] = NameAndType [200] [201] 
.const [87] = Class [202] 
.const [88] = NameAndType [203] [204] 
.const [89] = Class [205] 
.const [90] = NameAndType [206] [207] 
.const [91] = Class [208] 
.const [92] = NameAndType [209] [210] 
.const [93] = Class [211] 
.const [94] = NameAndType [212] [213] 
.const [95] = Class [214] 
.const [96] = NameAndType [215] [216] 
.const [97] = Class [217] 
.const [98] = NameAndType [218] [219] 
.const [99] = Class [220] 
.const [100] = NameAndType [221] [222] 
.const [101] = Class [223] 
.const [102] = NameAndType [224] [225] 
.const [103] = Class [226] 
.const [104] = NameAndType [227] [228] 
.const [105] = Class [229] 
.const [106] = NameAndType [230] [231] 
.const [107] = Class [232] 
.const [108] = NameAndType [233] [234] 
.const [109] = Class [235] 
.const [110] = NameAndType [236] [237] 
.const [111] = Class [238] 
.const [112] = NameAndType [239] [240] 
.const [113] = Class [241] 
.const [114] = NameAndType [242] [243] 
.const [115] = Class [244] 
.const [116] = NameAndType [245] [246] 
.const [117] = Class [247] 
.const [118] = NameAndType [248] [249] 
.const [119] = Class [250] 
.const [120] = NameAndType [251] [252] 
.const [121] = Class [253] 
.const [122] = NameAndType [254] [255] 
.const [123] = Class [256] 
.const [124] = NameAndType [257] [258] 
.const [125] = Class [259] 
.const [126] = NameAndType [260] [261] 
.const [127] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [128] = Class [262] 
.const [129] = NameAndType [263] [264] 
.const [130] = Class [265] 
.const [131] = NameAndType [266] [267] 
.const [132] = Class [268] 
.const [133] = NameAndType [269] [270] 
.const [134] = Class [271] 
.const [135] = NameAndType [272] [273] 
.const [136] = Class [274] 
.const [137] = NameAndType [275] [276] 
.const [138] = Class [277] 
.const [139] = NameAndType [278] [279] 
.const [140] = Class [280] 
.const [141] = NameAndType [281] [282] 
.const [142] = Class [283] 
.const [143] = NameAndType [284] [285] 
.const [144] = Class [286] 
.const [145] = NameAndType [287] [288] 
.const [146] = Class [289] 
.const [147] = NameAndType [290] [291] 
.const [148] = Class [292] 
.const [149] = NameAndType [293] [294] 
.const [150] = Class [295] 
.const [151] = NameAndType [296] [297] 
.const [152] = Class [298] 
.const [153] = NameAndType [299] [300] 
.const [154] = Class [301] 
.const [155] = NameAndType [302] [303] 
.const [156] = Class [304] 
.const [157] = NameAndType [305] [306] 
.const [158] = Class [307] 
.const [159] = NameAndType [308] [309] 
.const [160] = Class [310] 
.const [161] = NameAndType [311] [312] 
.const [162] = Class [313] 
.const [163] = NameAndType [314] [315] 
.const [164] = Class [316] 
.const [165] = NameAndType [317] [318] 
.const [166] = Class [319] 
.const [167] = NameAndType [320] [321] 
.const [168] = Class [322] 
.const [169] = NameAndType [323] [324] 
.const [170] = Class [325] 
.const [171] = NameAndType [326] [327] 
.const [172] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ChapterInfoSerializer 
.const [173] = Utf8 putOptionalChapterInfo 
.const [174] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/media/ChapterInfo;)V 
.const [175] = Utf8 de/esolutions/fw/comm/dsi/media/impl/EntryInfoSerializer 
.const [176] = Utf8 putOptionalEntryInfo 
.const [177] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/media/EntryInfo;)V 
.const [178] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ChapterInfoSerializer 
.const [179] = Utf8 getOptionalChapterInfo 
.const [180] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/ChapterInfo; 
.const [181] = Utf8 de/esolutions/fw/comm/dsi/media/impl/EntryInfoSerializer 
.const [182] = Utf8 getOptionalEntryInfo 
.const [183] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/EntryInfo; 
.const [184] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [185] = Utf8 getEntryID 
.const [186] = Utf8 ()J 
.const [187] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [188] = Utf8 getFilename 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [191] = Utf8 getContentType 
.const [192] = Utf8 ()I 
.const [193] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [194] = Utf8 getTitle 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [197] = Utf8 getTrackNo 
.const [198] = Utf8 ()J 
.const [199] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [200] = Utf8 getNumTracks 
.const [201] = Utf8 ()J 
.const [202] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [203] = Utf8 getAlbumID 
.const [204] = Utf8 ()J 
.const [205] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [206] = Utf8 getArtistID 
.const [207] = Utf8 ()J 
.const [208] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [209] = Utf8 getGenreID 
.const [210] = Utf8 ()J 
.const [211] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [212] = Utf8 getAlbum 
.const [213] = Utf8 ()Ljava/lang/String; 
.const [214] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [215] = Utf8 getArtist 
.const [216] = Utf8 ()Ljava/lang/String; 
.const [217] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [218] = Utf8 getGenre 
.const [219] = Utf8 ()Ljava/lang/String; 
.const [220] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [221] = Utf8 getYear 
.const [222] = Utf8 ()Ljava/lang/String; 
.const [223] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [224] = Utf8 getComments 
.const [225] = Utf8 ()Ljava/lang/String; 
.const [226] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [227] = Utf8 getAvgBitrate 
.const [228] = Utf8 ()J 
.const [229] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [230] = Utf8 getSamplingrate 
.const [231] = Utf8 ()J 
.const [232] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [233] = Utf8 getRating 
.const [234] = Utf8 ()I 
.const [235] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [236] = Utf8 getFlags 
.const [237] = Utf8 ()I 
.const [238] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [239] = Utf8 getChapterInfo 
.const [240] = Utf8 ()Lorg/dsi/ifc/media/ChapterInfo; 
.const [241] = Utf8 java/lang/Object 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [245] = Utf8 <init> 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [248] = Utf8 putBool 
.const [249] = Utf8 (Z)V 
.const [250] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [251] = Utf8 putInt64 
.const [252] = Utf8 (J)V 
.const [253] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [254] = Utf8 putOptionalString 
.const [255] = Utf8 (Ljava/lang/String;)V 
.const [256] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [257] = Utf8 putInt32 
.const [258] = Utf8 (I)V 
.const [259] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [260] = Utf8 getBool 
.const [261] = Utf8 ()Z 
.const [262] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [263] = Utf8 getInt64 
.const [264] = Utf8 ()J 
.const [265] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [266] = Utf8 entryID 
.const [267] = Utf8 J 
.const [268] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [269] = Utf8 getOptionalString 
.const [270] = Utf8 ()Ljava/lang/String; 
.const [271] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [272] = Utf8 filename 
.const [273] = Utf8 Ljava/lang/String; 
.const [274] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [275] = Utf8 getInt32 
.const [276] = Utf8 ()I 
.const [277] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [278] = Utf8 contentType 
.const [279] = Utf8 I 
.const [280] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [281] = Utf8 title 
.const [282] = Utf8 Ljava/lang/String; 
.const [283] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [284] = Utf8 trackNo 
.const [285] = Utf8 J 
.const [286] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [287] = Utf8 numTracks 
.const [288] = Utf8 J 
.const [289] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [290] = Utf8 albumID 
.const [291] = Utf8 J 
.const [292] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [293] = Utf8 artistID 
.const [294] = Utf8 J 
.const [295] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [296] = Utf8 genreID 
.const [297] = Utf8 J 
.const [298] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [299] = Utf8 album 
.const [300] = Utf8 Ljava/lang/String; 
.const [301] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [302] = Utf8 artist 
.const [303] = Utf8 Ljava/lang/String; 
.const [304] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [305] = Utf8 genre 
.const [306] = Utf8 Ljava/lang/String; 
.const [307] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [308] = Utf8 year 
.const [309] = Utf8 Ljava/lang/String; 
.const [310] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [311] = Utf8 comments 
.const [312] = Utf8 Ljava/lang/String; 
.const [313] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [314] = Utf8 avgBitrate 
.const [315] = Utf8 J 
.const [316] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [317] = Utf8 samplingrate 
.const [318] = Utf8 J 
.const [319] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [320] = Utf8 rating 
.const [321] = Utf8 I 
.const [322] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [323] = Utf8 flags 
.const [324] = Utf8 I 
.const [325] = Utf8 org/dsi/ifc/media/EntryInfo 
.const [326] = Utf8 chapterInfo 
.const [327] = Utf8 Lorg/dsi/ifc/media/ChapterInfo; 
.const [328] = Utf8 de/esolutions/fw/comm/dsi/media/impl/EntryInfoSerializer 
.const [329] = Class [328] 
.const [330] = Utf8 java/lang/Object 
.const [331] = Class [330] 
.const [332] = Utf8 Code 
.const [333] = Utf8 <init> 
.const [334] = Utf8 ()V 
.const [335] = Utf8 putOptionalEntryInfo 
.const [336] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/media/EntryInfo;)V 
.const [337] = Utf8 putOptionalEntryInfoVarArray 
.const [338] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/media/EntryInfo;)V 
.const [339] = Utf8 getOptionalEntryInfo 
.const [340] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/EntryInfo; 
.const [341] = Utf8 getOptionalEntryInfoVarArray 
.const [342] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/media/EntryInfo; 
.end class 
