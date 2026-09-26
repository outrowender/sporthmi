.version 50 0 
.class public super [271] 
.super [273] 
.implements [275] 
.field private static final [276] [277] 
.field private [278] [279] 
.field static synthetic [280] [281] 

.method public [283] : [284] 
    .attribute [282] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     aload_3 
L3:     aload 4 
L5:     iload_1 
L6:     invokespecial [47] 
L9:     aload_0 
L10:    invokevirtual [16] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [285] : [286] 
    .attribute [282] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [282] .code stack 2 locals 0 
L0:     getstatic [6] 
L3:     ifnonnull L18 
L6:     ldc [7] 
L8:     invokestatic [8] 
L11:    dup 
L12:    putstatic [49] 
L15:    goto L21 
L18:    getstatic [6] 
L21:    invokevirtual [17] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [289] : [290] 
    .attribute [282] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [19] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [291] : [292] 
    .attribute [282] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [53] 
L4:     dup 
L5:     aload_0 
L6:     getfield [20] 
L9:     aload_0 
L10:    getfield [21] 
L13:    checkcast [10] 
L16:    invokespecial [50] 
L19:    putfield [52] 
L22:    aload_0 
L23:    getfield [18] 
L26:    invokevirtual [19] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [282] .code stack 6 locals 1 
        .catch [11] from L0 to L14 using L17 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     iload_2 
L6:     iload_3 
L7:     iload 4 
L9:     iload 5 
L11:    invokevirtual [22] 
L14:    goto L25 
L17:    astore 6 
L19:    aload_0 
L20:    aload 6 
L22:    invokevirtual [23] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [282] .code stack 4 locals 1 
        .catch [11] from L0 to L10 using L13 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokevirtual [24] 
L10:    goto L21 
L13:    astore 4 
L15:    aload_0 
L16:    aload 4 
L18:    invokevirtual [23] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [25] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [26] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [282] .code stack 3 locals 1 
        .catch [11] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     iload_2 
L6:     invokevirtual [27] 
L9:     goto L18 
L12:    astore_3 
L13:    aload_0 
L14:    aload_3 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [303] : [304] 
    .attribute [282] .code stack 8 locals 1 
        .catch [11] from L0 to L18 using L21 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     iload_2 
L6:     aload_3 
L7:     aload 4 
L9:     aload 5 
L11:    aload 6 
L13:    iload 7 
L15:    invokevirtual [28] 
L18:    goto L29 
L21:    astore 8 
L23:    aload_0 
L24:    aload 8 
L26:    invokevirtual [23] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [282] .code stack 4 locals 1 
        .catch [11] from L0 to L10 using L13 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     aload_2 
L6:     iload_3 
L7:     invokevirtual [29] 
L10:    goto L21 
L13:    astore 4 
L15:    aload_0 
L16:    aload 4 
L18:    invokevirtual [23] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [307] : [308] 
    .attribute [282] .code stack 3 locals 1 
        .catch [11] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     iload_2 
L6:     invokevirtual [30] 
L9:     goto L18 
L12:    astore_3 
L13:    aload_0 
L14:    aload_3 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [282] .code stack 8 locals 1 
        .catch [11] from L0 to L18 using L21 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     iload_2 
L6:     aload_3 
L7:     aload 4 
L9:     aload 5 
L11:    iload 6 
L13:    aload 7 
L15:    invokevirtual [31] 
L18:    goto L29 
L21:    astore 8 
L23:    aload_0 
L24:    aload 8 
L26:    invokevirtual [23] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [311] : [312] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [32] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [282] .code stack 3 locals 1 
        .catch [11] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     aload_2 
L6:     invokevirtual [33] 
L9:     goto L18 
L12:    astore_3 
L13:    aload_0 
L14:    aload_3 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [315] : [316] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [34] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L7 using L10 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [35] 
L7:     goto L16 
L10:    astore_1 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [23] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [319] : [320] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [36] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [321] : [322] 
    .attribute [282] .code stack 3 locals 1 
        .catch [11] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     iload_2 
L6:     invokevirtual [37] 
L9:     goto L18 
L12:    astore_3 
L13:    aload_0 
L14:    aload_3 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [38] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [39] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [40] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L7 using L10 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [41] 
L7:     goto L16 
L10:    astore_1 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [23] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [42] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [43] 
L8:     goto L17 
L11:    astore_2 
L12:    aload_0 
L13:    aload_2 
L14:    invokevirtual [23] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [282] .code stack 2 locals 1 
        .catch [11] from L0 to L7 using L10 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [44] 
L7:     goto L16 
L10:    astore_1 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [23] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [337] : [338] 
    .attribute [282] .code stack 3 locals 1 
        .catch [11] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [45] 
L9:     goto L18 
L12:    astore_3 
L13:    aload_0 
L14:    aload_3 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [339] : [340] 
    .attribute [282] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [51] 
L9:     dup 
L10:    invokespecial [46] 
L13:    aload_1 
L14:    invokevirtual [15] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [341] : [342] 
    .attribute [282] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_4 
L6:     iastore 
L7:     dup 
L8:     iconst_1 
L9:     iconst_5 
L10:    iastore 
L11:    putstatic [48] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [54] [55] 
.const [3] = Class [56] 
.const [4] = Class [57] 
.const [5] = Field [58] [59] 
.const [6] = Field [60] [61] 
.const [7] = String [62] 
.const [8] = Method [63] [64] 
.const [9] = Class [65] 
.const [10] = Class [66] 
.const [11] = Class [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = Class [70] 
.const [15] = Method [71] [72] 
.const [16] = Method [73] [74] 
.const [17] = Method [75] [76] 
.const [18] = Field [77] [78] 
.const [19] = Method [79] [80] 
.const [20] = Field [81] [82] 
.const [21] = Field [83] [84] 
.const [22] = Method [85] [86] 
.const [23] = Method [87] [88] 
.const [24] = Method [89] [90] 
.const [25] = Method [91] [92] 
.const [26] = Method [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Method [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Method [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Method [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Field [137] [138] 
.const [49] = Field [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Class [143] 
.const [52] = Field [144] [145] 
.const [53] = Class [146] 
.const [54] = Class [147] 
.const [55] = NameAndType [148] [149] 
.const [56] = Utf8 java/lang/ClassNotFoundException 
.const [57] = Utf8 java/lang/NoClassDefFoundError 
.const [58] = Class [150] 
.const [59] = NameAndType [151] [152] 
.const [60] = Class [153] 
.const [61] = NameAndType [154] [155] 
.const [62] = Utf8 'org.dsi.ifc.messaging.DSIMessaging' 
.const [63] = Class [156] 
.const [64] = NameAndType [157] [158] 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/messaging/DSIMessagingReply 
.const [67] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [68] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [69] = Utf8 de/esolutions/fw/dsi/base/AbstractProvider 
.const [70] = Utf8 java/lang/Class 
.const [71] = Class [159] 
.const [72] = NameAndType [160] [161] 
.const [73] = Class [162] 
.const [74] = NameAndType [163] [164] 
.const [75] = Class [165] 
.const [76] = NameAndType [166] [167] 
.const [77] = Class [168] 
.const [78] = NameAndType [169] [170] 
.const [79] = Class [171] 
.const [80] = NameAndType [172] [173] 
.const [81] = Class [174] 
.const [82] = NameAndType [175] [176] 
.const [83] = Class [177] 
.const [84] = NameAndType [178] [179] 
.const [85] = Class [180] 
.const [86] = NameAndType [181] [182] 
.const [87] = Class [183] 
.const [88] = NameAndType [184] [185] 
.const [89] = Class [186] 
.const [90] = NameAndType [187] [188] 
.const [91] = Class [189] 
.const [92] = NameAndType [190] [191] 
.const [93] = Class [192] 
.const [94] = NameAndType [193] [194] 
.const [95] = Class [195] 
.const [96] = NameAndType [196] [197] 
.const [97] = Class [198] 
.const [98] = NameAndType [199] [200] 
.const [99] = Class [201] 
.const [100] = NameAndType [202] [203] 
.const [101] = Class [204] 
.const [102] = NameAndType [205] [206] 
.const [103] = Class [207] 
.const [104] = NameAndType [208] [209] 
.const [105] = Class [210] 
.const [106] = NameAndType [211] [212] 
.const [107] = Class [213] 
.const [108] = NameAndType [214] [215] 
.const [109] = Class [216] 
.const [110] = NameAndType [217] [218] 
.const [111] = Class [219] 
.const [112] = NameAndType [220] [221] 
.const [113] = Class [222] 
.const [114] = NameAndType [223] [224] 
.const [115] = Class [225] 
.const [116] = NameAndType [226] [227] 
.const [117] = Class [228] 
.const [118] = NameAndType [229] [230] 
.const [119] = Class [231] 
.const [120] = NameAndType [232] [233] 
.const [121] = Class [234] 
.const [122] = NameAndType [235] [236] 
.const [123] = Class [237] 
.const [124] = NameAndType [238] [239] 
.const [125] = Class [240] 
.const [126] = NameAndType [241] [242] 
.const [127] = Class [243] 
.const [128] = NameAndType [244] [245] 
.const [129] = Class [246] 
.const [130] = NameAndType [247] [248] 
.const [131] = Class [249] 
.const [132] = NameAndType [250] [251] 
.const [133] = Class [252] 
.const [134] = NameAndType [253] [254] 
.const [135] = Class [255] 
.const [136] = NameAndType [256] [257] 
.const [137] = Class [258] 
.const [138] = NameAndType [259] [260] 
.const [139] = Class [261] 
.const [140] = NameAndType [262] [263] 
.const [141] = Class [264] 
.const [142] = NameAndType [265] [266] 
.const [143] = Utf8 java/lang/NoClassDefFoundError 
.const [144] = Class [267] 
.const [145] = NameAndType [268] [269] 
.const [146] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [147] = Utf8 java/lang/Class 
.const [148] = Utf8 forName 
.const [149] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [150] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [151] = Utf8 attributeIDs 
.const [152] = Utf8 [I 
.const [153] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [154] = Utf8 class$org$dsi$ifc$messaging$DSIMessaging 
.const [155] = Utf8 Ljava/lang/Class; 
.const [156] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [157] = Utf8 class$ 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [159] = Utf8 java/lang/NoClassDefFoundError 
.const [160] = Utf8 initCause 
.const [161] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [162] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [163] = Utf8 createNewProxy 
.const [164] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [165] = Utf8 java/lang/Class 
.const [166] = Utf8 getName 
.const [167] = Utf8 ()Ljava/lang/String; 
.const [168] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [169] = Utf8 proxy 
.const [170] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy; 
.const [171] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [172] = Utf8 getProxy 
.const [173] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [174] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [175] = Utf8 instance 
.const [176] = Utf8 I 
.const [177] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [178] = Utf8 dispatcher 
.const [179] = Utf8 Lde/esolutions/fw/dsi/base/IDispatcher; 
.const [180] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [181] = Utf8 changeFolderRequest 
.const [182] = Utf8 (IIIII)V 
.const [183] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [184] = Utf8 traceException 
.const [185] = Utf8 (Ljava/lang/Exception;)V 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [187] = Utf8 listEntriesRequest 
.const [188] = Utf8 (III)V 
.const [189] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [190] = Utf8 getPositionOfMessageRequest 
.const [191] = Utf8 (Ljava/lang/String;)V 
.const [192] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [193] = Utf8 getPositionOfFolderRequest 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [196] = Utf8 deleteMessageRequest 
.const [197] = Utf8 ([Ljava/lang/String;Z)V 
.const [198] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [199] = Utf8 sendMessageRequest 
.const [200] = Utf8 (IILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [201] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [202] = Utf8 getMessageContentsRequest 
.const [203] = Utf8 (ILjava/lang/String;I)V 
.const [204] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [205] = Utf8 setMessageReadStatusRequest 
.const [206] = Utf8 (Ljava/lang/String;Z)V 
.const [207] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [208] = Utf8 saveAsDraftRequest 
.const [209] = Utf8 (Ljava/lang/String;ILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;I[Lorg/dsi/ifc/messaging/AttachmentInformation;)V 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [211] = Utf8 extractInformationRequest 
.const [212] = Utf8 (Ljava/lang/String;)V 
.const [213] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [214] = Utf8 changeTemplateRequest 
.const [215] = Utf8 (ILjava/lang/String;)V 
.const [216] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [217] = Utf8 getTemplateRequest 
.const [218] = Utf8 (I)V 
.const [219] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [220] = Utf8 getTemplatesRequest 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [223] = Utf8 deleteTemplateRequest 
.const [224] = Utf8 ([I)V 
.const [225] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [226] = Utf8 deleteSimCardMessagesRequest 
.const [227] = Utf8 (II)V 
.const [228] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [229] = Utf8 decodeAttachmentRequest 
.const [230] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)V 
.const [231] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [232] = Utf8 setNotification 
.const [233] = Utf8 ([I)V 
.const [234] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [235] = Utf8 setNotification 
.const [236] = Utf8 (I)V 
.const [237] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [238] = Utf8 setNotification 
.const [239] = Utf8 ()V 
.const [240] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [241] = Utf8 clearNotification 
.const [242] = Utf8 ([I)V 
.const [243] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [244] = Utf8 clearNotification 
.const [245] = Utf8 (I)V 
.const [246] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [247] = Utf8 clearNotification 
.const [248] = Utf8 ()V 
.const [249] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [250] = Utf8 yySet 
.const [251] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [252] = Utf8 java/lang/NoClassDefFoundError 
.const [253] = Utf8 <init> 
.const [254] = Utf8 ()V 
.const [255] = Utf8 de/esolutions/fw/dsi/base/AbstractProvider 
.const [256] = Utf8 <init> 
.const [257] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/esolutions/fw/comm/agent/Agent;Lde/esolutions/fw/dsi/base/IDispatcher;I)V 
.const [258] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [259] = Utf8 attributeIDs 
.const [260] = Utf8 [I 
.const [261] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [262] = Utf8 class$org$dsi$ifc$messaging$DSIMessaging 
.const [263] = Utf8 Ljava/lang/Class; 
.const [264] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (ILde/esolutions/fw/comm/dsi/messaging/DSIMessagingReply;)V 
.const [267] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [268] = Utf8 proxy 
.const [269] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy; 
.const [270] = Utf8 de/esolutions/fw/dsi/messaging/DSIMessagingProvider 
.const [271] = Class [270] 
.const [272] = Utf8 de/esolutions/fw/dsi/base/AbstractProvider 
.const [273] = Class [272] 
.const [274] = Utf8 org/dsi/ifc/messaging/DSIMessaging 
.const [275] = Class [274] 
.const [276] = Utf8 attributeIDs 
.const [277] = Utf8 [I 
.const [278] = Utf8 proxy 
.const [279] = Utf8 Lde/esolutions/fw/comm/dsi/messaging/impl/DSIMessagingProxy; 
.const [280] = Utf8 class$org$dsi$ifc$messaging$DSIMessaging 
.const [281] = Utf8 Ljava/lang/Class; 
.const [282] = Utf8 Code 
.const [283] = Utf8 <init> 
.const [284] = Utf8 (ILorg/osgi/framework/BundleContext;Lde/esolutions/fw/comm/agent/Agent;Lde/esolutions/fw/dsi/base/IDispatcher;)V 
.const [285] = Utf8 getAttributeIDs 
.const [286] = Utf8 ()[I 
.const [287] = Utf8 getName 
.const [288] = Utf8 ()Ljava/lang/String; 
.const [289] = Utf8 getProxy 
.const [290] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [291] = Utf8 createNewProxy 
.const [292] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [293] = Utf8 changeFolderRequest 
.const [294] = Utf8 (IIIII)V 
.const [295] = Utf8 listEntriesRequest 
.const [296] = Utf8 (III)V 
.const [297] = Utf8 getPositionOfMessageRequest 
.const [298] = Utf8 (Ljava/lang/String;)V 
.const [299] = Utf8 getPositionOfFolderRequest 
.const [300] = Utf8 (I)V 
.const [301] = Utf8 deleteMessageRequest 
.const [302] = Utf8 ([Ljava/lang/String;Z)V 
.const [303] = Utf8 sendMessageRequest 
.const [304] = Utf8 (IILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [305] = Utf8 getMessageContentsRequest 
.const [306] = Utf8 (ILjava/lang/String;I)V 
.const [307] = Utf8 setMessageReadStatusRequest 
.const [308] = Utf8 (Ljava/lang/String;Z)V 
.const [309] = Utf8 saveAsDraftRequest 
.const [310] = Utf8 (Ljava/lang/String;ILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;I[Lorg/dsi/ifc/messaging/AttachmentInformation;)V 
.const [311] = Utf8 extractInformationRequest 
.const [312] = Utf8 (Ljava/lang/String;)V 
.const [313] = Utf8 changeTemplateRequest 
.const [314] = Utf8 (ILjava/lang/String;)V 
.const [315] = Utf8 getTemplateRequest 
.const [316] = Utf8 (I)V 
.const [317] = Utf8 getTemplatesRequest 
.const [318] = Utf8 ()V 
.const [319] = Utf8 deleteTemplateRequest 
.const [320] = Utf8 ([I)V 
.const [321] = Utf8 deleteSimCardMessagesRequest 
.const [322] = Utf8 (II)V 
.const [323] = Utf8 decodeAttachmentRequest 
.const [324] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)V 
.const [325] = Utf8 setNotification 
.const [326] = Utf8 ([I)V 
.const [327] = Utf8 setNotification 
.const [328] = Utf8 (I)V 
.const [329] = Utf8 setNotification 
.const [330] = Utf8 ()V 
.const [331] = Utf8 clearNotification 
.const [332] = Utf8 ([I)V 
.const [333] = Utf8 clearNotification 
.const [334] = Utf8 (I)V 
.const [335] = Utf8 clearNotification 
.const [336] = Utf8 ()V 
.const [337] = Utf8 yySet 
.const [338] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [339] = Utf8 class$ 
.const [340] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [341] = Utf8 <clinit> 
.const [342] = Utf8 ()V 
.end class 
