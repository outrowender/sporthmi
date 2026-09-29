.version 50 0 
.class public super [301] 
.super [303] 
.field private final [304] [305] 
.field private final [306] [307] 
.field private final [308] [309] 

.method public [311] : [312] 
    .attribute [310] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     aload_3 
L3:     aload_1 
L4:     invokeinterface [50] 0 
L9:     invokeinterface [51] 0 
L14:    ldc [2] 
L16:    invokeinterface [52] 0 
L21:    aload 4 
L23:    invokespecial [46] 
L26:    aload_0 
L27:    aload 4 
L29:    putfield [53] 
L32:    aload_0 
L33:    aload_1 
L34:    putfield [54] 
L37:    aload_0 
L38:    aload 5 
L40:    putfield [55] 
L43:    return 
L44:    
    .end code 
.end method 

.method [313] : [314] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_0 
L5:     invokeinterface [56] 0 
L10:    aload_0 
L11:    invokevirtual [35] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method [315] : [316] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     invokeinterface [57] 0 
L9:     aload_0 
L10:    getfield [34] 
L13:    iconst_0 
L14:    invokeinterface [58] 0 
L19:    aload_0 
L20:    getfield [34] 
L23:    invokeinterface [59] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [310] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     invokeinterface [60] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [319] : [320] 
    .attribute [310] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     iload_1 
L9:     invokevirtual [36] 
L12:    pop 
L13:    aload_0 
L14:    getfield [32] 
L17:    invokeinterface [50] 0 
L22:    invokeinterface [61] 0 
L27:    ldc [5] 
L29:    invokeinterface [62] 0 
L34:    iload_1 
L35:    ifeq L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    invokeinterface [63] 0 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method [321] : [322] 
    .attribute [310] .code stack 7 locals 1 
L0:     new [64] 
L3:     dup 
L4:     aload_1 
L5:     aload_2 
L6:     invokestatic [7] 
L9:     iload_3 
L10:    invokespecial [47] 
L13:    astore 4 
L15:    aload_0 
L16:    aload 4 
L18:    iconst_1 
L19:    invokevirtual [37] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method [323] : [324] 
    .attribute [310] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [35] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [325] : [326] 
    .attribute [310] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     lload_1 
L5:     invokeinterface [65] 0 
L10:    checkcast [6] 
L13:    astore_3 
L14:    aload_0 
L15:    aload_3 
L16:    iconst_1 
L17:    invokevirtual [38] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method [327] : [328] 
    .attribute [310] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     iload_1 
L5:     invokeinterface [66] 0 
L10:    checkcast [6] 
L13:    astore_3 
L14:    new [64] 
L17:    dup 
L18:    aload_2 
L19:    aload_3 
L20:    invokevirtual [39] 
L23:    invokestatic [7] 
L26:    aload_3 
L27:    invokevirtual [40] 
L30:    invokespecial [47] 
L33:    astore 4 
L35:    aload_0 
L36:    iload_1 
L37:    aload 4 
L39:    iconst_1 
L40:    invokevirtual [41] 
L43:    return 
L44:    
    .end code 
.end method 

.method [329] : [330] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [42] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [310] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     aload_1 
L9:     iload_2 
L10:    iload_3 
L11:    iload 4 
L13:    iload 5 
L15:    invokestatic [10] 
L18:    invokevirtual [43] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [310] .code stack 11 locals 1 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [3] 
L6:     ldc [11] 
L8:     aload_1 
L9:     iload_2 
L10:    iload_3 
L11:    iload 4 
L13:    iload 5 
L15:    invokestatic [12] 
L18:    invokevirtual [43] 
L21:    pop 
L22:    aload_1 
L23:    instanceof [6] 
L26:    ifeq L75 
L29:    aload_1 
L30:    checkcast [6] 
L33:    astore 6 
L35:    aload_0 
L36:    getfield [32] 
L39:    invokeinterface [67] 0 
L44:    aload 6 
L46:    invokevirtual [39] 
L49:    lconst_0 
L50:    aload 6 
L52:    invokevirtual [44] 
L55:    aload 6 
L57:    invokevirtual [40] 
L60:    i2s 
L61:    iconst_0 
L62:    aconst_null 
L63:    iconst_0 
L64:    iconst_0 
L65:    iload 5 
L67:    invokeinterface [68] 0 
L72:    goto L88 
L75:    aload_0 
L76:    getfield [31] 
L79:    ldc [13] 
L81:    ldc [14] 
L83:    aload_1 
L84:    invokevirtual [43] 
L87:    pop 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [335] : [336] 
    .attribute [310] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [8] 
L6:     ldc [15] 
L8:     aload_1 
L9:     iload_2 
L10:    iload_3 
L11:    iload 4 
L13:    iload 5 
L15:    invokestatic [16] 
L18:    invokevirtual [43] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [337] : [338] 
    .attribute [310] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [8] 
L6:     ldc [17] 
L8:     aload_1 
L9:     iload_2 
L10:    iload_3 
L11:    iload 4 
L13:    iload 5 
L15:    invokestatic [16] 
L18:    invokevirtual [43] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [339] : [340] 
    .attribute [310] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     getfield [33] 
L8:     invokevirtual [45] 
L11:    return 
L12:    
    .end code 
.end method 

.method protected [341] : [342] 
    .attribute [310] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     getfield [33] 
L8:     invokevirtual [45] 
L11:    return 
L12:    
    .end code 
.end method 

.method [343] : [344] 
    .attribute [310] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     lload_1 
L5:     invokeinterface [69] 0 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [345] : [346] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokeinterface [50] 0 
L9:     invokeinterface [61] 0 
L14:    ldc [18] 
L16:    invokeinterface [62] 0 
L21:    iconst_1 
L22:    invokeinterface [63] 0 
L27:    return 
L28:    
    .end code 
.end method 

.method public [347] : [348] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokeinterface [50] 0 
L9:     invokeinterface [61] 0 
L14:    ldc [18] 
L16:    invokeinterface [62] 0 
L21:    iconst_0 
L22:    invokeinterface [63] 0 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -426376192 
.const [3] = Int 1078071040 
.const [4] = String [70] 
.const [5] = Int -1684667392 
.const [6] = Class [71] 
.const [7] = Method [72] [73] 
.const [8] = Int -2137614336 
.const [9] = String [74] 
.const [10] = Method [75] [76] 
.const [11] = String [77] 
.const [12] = Method [78] [79] 
.const [13] = Int -1601830656 
.const [14] = String [80] 
.const [15] = String [81] 
.const [16] = Method [82] [83] 
.const [17] = String [84] 
.const [18] = Int 1217856512 
.const [19] = Class [85] 
.const [20] = Class [86] 
.const [21] = Class [87] 
.const [22] = Class [88] 
.const [23] = Class [89] 
.const [24] = Class [90] 
.const [25] = Class [91] 
.const [26] = Class [92] 
.const [27] = Class [93] 
.const [28] = Class [94] 
.const [29] = Class [95] 
.const [30] = Class [96] 
.const [31] = Field [97] [98] 
.const [32] = Field [99] [100] 
.const [33] = Field [101] [102] 
.const [34] = Field [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Method [113] [114] 
.const [40] = Method [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Method [119] [120] 
.const [43] = Method [121] [122] 
.const [44] = Method [123] [124] 
.const [45] = Method [125] [126] 
.const [46] = Method [127] [128] 
.const [47] = Method [129] [130] 
.const [48] = Method [131] [132] 
.const [49] = Method [133] [134] 
.const [50] = InterfaceMethod [135] [136] 
.const [51] = InterfaceMethod [137] [138] 
.const [52] = InterfaceMethod [139] [140] 
.const [53] = Field [141] [142] 
.const [54] = Field [143] [144] 
.const [55] = Field [145] [146] 
.const [56] = InterfaceMethod [147] [148] 
.const [57] = InterfaceMethod [149] [150] 
.const [58] = InterfaceMethod [151] [152] 
.const [59] = InterfaceMethod [153] [154] 
.const [60] = InterfaceMethod [155] [156] 
.const [61] = InterfaceMethod [157] [158] 
.const [62] = InterfaceMethod [159] [160] 
.const [63] = InterfaceMethod [161] [162] 
.const [64] = Class [163] 
.const [65] = InterfaceMethod [164] [165] 
.const [66] = InterfaceMethod [166] [167] 
.const [67] = InterfaceMethod [168] [169] 
.const [68] = InterfaceMethod [170] [171] 
.const [69] = InterfaceMethod [172] [173] 
.const [70] = Utf8 '[TelFavoriteListHandler#capacityReached] reached=%1' 
.const [71] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [72] = Class [174] 
.const [73] = NameAndType [175] [176] 
.const [74] = Utf8 '[TelFavoriteListHandler#itemReleased] %1' 
.const [75] = Class [177] 
.const [76] = NameAndType [178] [179] 
.const [77] = Utf8 '[TelFavoriteListHandler#favoriteSelected] %1' 
.const [78] = Class [180] 
.const [79] = NameAndType [181] [182] 
.const [80] = Utf8 '[TelFavoriteListHandler#favoriteSelected] row not a TelEvoFavoriteListRow: %1' 
.const [81] = Utf8 '[TelFavoriteListHandler#itemLongSelected] %1' 
.const [82] = Class [183] 
.const [83] = NameAndType [184] [185] 
.const [84] = Utf8 '[TelFavoriteListHandler#itemFocused] %1' 
.const [85] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [86] = Utf8 de/audi/atip/favorite/AbstractFavoriteListHandler 
.const [87] = Utf8 de/audi/app/phone/evo/ITelEvoApplication 
.const [88] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [89] = Utf8 de/audi/atip/hmi/HMIService 
.const [90] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [93] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [94] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteHandler 
.const [95] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [96] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [97] = Class [186] 
.const [98] = NameAndType [187] [188] 
.const [99] = Class [189] 
.const [100] = NameAndType [190] [191] 
.const [101] = Class [192] 
.const [102] = NameAndType [193] [194] 
.const [103] = Class [195] 
.const [104] = NameAndType [196] [197] 
.const [105] = Class [198] 
.const [106] = NameAndType [199] [200] 
.const [107] = Class [201] 
.const [108] = NameAndType [202] [203] 
.const [109] = Class [204] 
.const [110] = NameAndType [205] [206] 
.const [111] = Class [207] 
.const [112] = NameAndType [208] [209] 
.const [113] = Class [210] 
.const [114] = NameAndType [211] [212] 
.const [115] = Class [213] 
.const [116] = NameAndType [214] [215] 
.const [117] = Class [216] 
.const [118] = NameAndType [217] [218] 
.const [119] = Class [219] 
.const [120] = NameAndType [220] [221] 
.const [121] = Class [222] 
.const [122] = NameAndType [223] [224] 
.const [123] = Class [225] 
.const [124] = NameAndType [226] [227] 
.const [125] = Class [228] 
.const [126] = NameAndType [229] [230] 
.const [127] = Class [231] 
.const [128] = NameAndType [232] [233] 
.const [129] = Class [234] 
.const [130] = NameAndType [235] [236] 
.const [131] = Class [237] 
.const [132] = NameAndType [238] [239] 
.const [133] = Class [240] 
.const [134] = NameAndType [241] [242] 
.const [135] = Class [243] 
.const [136] = NameAndType [244] [245] 
.const [137] = Class [246] 
.const [138] = NameAndType [247] [248] 
.const [139] = Class [249] 
.const [140] = NameAndType [250] [251] 
.const [141] = Class [252] 
.const [142] = NameAndType [253] [254] 
.const [143] = Class [255] 
.const [144] = NameAndType [256] [257] 
.const [145] = Class [258] 
.const [146] = NameAndType [259] [260] 
.const [147] = Class [261] 
.const [148] = NameAndType [262] [263] 
.const [149] = Class [264] 
.const [150] = NameAndType [265] [266] 
.const [151] = Class [267] 
.const [152] = NameAndType [268] [269] 
.const [153] = Class [270] 
.const [154] = NameAndType [271] [272] 
.const [155] = Class [273] 
.const [156] = NameAndType [274] [275] 
.const [157] = Class [276] 
.const [158] = NameAndType [277] [278] 
.const [159] = Class [279] 
.const [160] = NameAndType [280] [281] 
.const [161] = Class [282] 
.const [162] = NameAndType [283] [284] 
.const [163] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [164] = Class [285] 
.const [165] = NameAndType [286] [287] 
.const [166] = Class [288] 
.const [167] = NameAndType [289] [290] 
.const [168] = Class [291] 
.const [169] = NameAndType [292] [293] 
.const [170] = Class [294] 
.const [171] = NameAndType [295] [296] 
.const [172] = Class [297] 
.const [173] = NameAndType [298] [299] 
.const [174] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteHandler 
.const [175] = Utf8 getNextUniqueID 
.const [176] = Utf8 ()J 
.const [177] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [178] = Utf8 itemReleased 
.const [179] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)Lde/esolutions/fw/util/commons/Buffer; 
.const [180] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [181] = Utf8 itemSelectedBaseList 
.const [182] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)Lde/esolutions/fw/util/commons/Buffer; 
.const [183] = Utf8 de/audi/app/phone/core/util/TelLoggingUtils 
.const [184] = Utf8 itemLongSelected 
.const [185] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)Lde/esolutions/fw/util/commons/Buffer; 
.const [186] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [187] = Utf8 log 
.const [188] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [189] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [190] = Utf8 application 
.const [191] = Utf8 Lde/audi/app/phone/evo/ITelEvoApplication; 
.const [192] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [193] = Utf8 favoritesHandler 
.const [194] = Utf8 Lde/audi/app/phone/evo/favorite/TelFavoriteHandler; 
.const [195] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [196] = Utf8 favoriteListModel 
.const [197] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [198] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [199] = Utf8 loadFavoritesFromPersistence 
.const [200] = Utf8 ()V 
.const [201] = Utf8 de/audi/atip/log/LogChannel 
.const [202] = Utf8 log 
.const [203] = Utf8 (ILjava/lang/String;Z)Z 
.const [204] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [205] = Utf8 addToFavorites 
.const [206] = Utf8 (Lde/audi/atip/favorite/FavoriteListRow;Z)V 
.const [207] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [208] = Utf8 removeFavorite 
.const [209] = Utf8 (Lde/audi/atip/favorite/FavoriteListRow;Z)V 
.const [210] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [211] = Utf8 getNumber 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [214] = Utf8 getPhoneNumberType 
.const [215] = Utf8 ()I 
.const [216] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [217] = Utf8 replaceFavorite 
.const [218] = Utf8 (ILde/audi/atip/favorite/FavoriteListRow;Z)V 
.const [219] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [220] = Utf8 removeAllFavorites 
.const [221] = Utf8 (Z)V 
.const [222] = Utf8 de/audi/atip/log/LogChannel 
.const [223] = Utf8 log 
.const [224] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [225] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [226] = Utf8 getName 
.const [227] = Utf8 ()Ljava/lang/String; 
.const [228] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteHandler 
.const [229] = Utf8 favoritesListUpdated 
.const [230] = Utf8 ()V 
.const [231] = Utf8 de/audi/atip/favorite/AbstractFavoriteListHandler 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (Lde/audi/atip/favorite/FavoritePersistenceHandlerBase;Lde/audi/atip/hmi/model/list/BaseListModelApp;Lde/audi/atip/hmi/modelaccess/OptionModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [234] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [235] = Utf8 <init> 
.const [236] = Utf8 (Ljava/lang/String;Ljava/lang/String;JI)V 
.const [237] = Utf8 de/audi/atip/favorite/AbstractFavoriteListHandler 
.const [238] = Utf8 updatePersistence 
.const [239] = Utf8 ()V 
.const [240] = Utf8 de/audi/atip/favorite/AbstractFavoriteListHandler 
.const [241] = Utf8 loadFavoritesFromPersistence 
.const [242] = Utf8 ()V 
.const [243] = Utf8 de/audi/app/phone/evo/ITelEvoApplication 
.const [244] = Utf8 getFrameworkAccess 
.const [245] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [246] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [247] = Utf8 getHMIService 
.const [248] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [249] = Utf8 de/audi/atip/hmi/HMIService 
.const [250] = Utf8 getOptionModel 
.const [251] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/OptionModelApp; 
.const [252] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [253] = Utf8 log 
.const [254] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [255] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [256] = Utf8 application 
.const [257] = Utf8 Lde/audi/app/phone/evo/ITelEvoApplication; 
.const [258] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [259] = Utf8 favoritesHandler 
.const [260] = Utf8 Lde/audi/app/phone/evo/favorite/TelFavoriteHandler; 
.const [261] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [262] = Utf8 setListener 
.const [263] = Utf8 (Lde/audi/atip/hmi/model/list/BaseListModelListener;)V 
.const [264] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [265] = Utf8 clearAll 
.const [266] = Utf8 ()V 
.const [267] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [268] = Utf8 setLength 
.const [269] = Utf8 (I)V 
.const [270] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [271] = Utf8 resetListener 
.const [272] = Utf8 ()V 
.const [273] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [274] = Utf8 getCopy 
.const [275] = Utf8 ()Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [276] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [277] = Utf8 getHmiServiceApp 
.const [278] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [279] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [280] = Utf8 getChoiceModel 
.const [281] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [282] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [283] = Utf8 setValue 
.const [284] = Utf8 (I)V 
.const [285] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [286] = Utf8 getRowByUniqueID 
.const [287] = Utf8 (J)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [288] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [289] = Utf8 getRow 
.const [290] = Utf8 (I)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [291] = Utf8 de/audi/app/phone/evo/ITelEvoApplication 
.const [292] = Utf8 getTelephoneDSIAccess 
.const [293] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [294] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [295] = Utf8 dialNumberFromDBEntry 
.const [296] = Utf8 (Ljava/lang/String;JLjava/lang/String;SSLorg/dsi/ifc/global/ResourceLocator;III)V 
.const [297] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [298] = Utf8 getIndexForUniqueID 
.const [299] = Utf8 (J)I 
.const [300] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteListHandler 
.const [301] = Class [300] 
.const [302] = Utf8 de/audi/atip/favorite/AbstractFavoriteListHandler 
.const [303] = Class [302] 
.const [304] = Utf8 log 
.const [305] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [306] = Utf8 application 
.const [307] = Utf8 Lde/audi/app/phone/evo/ITelEvoApplication; 
.const [308] = Utf8 favoritesHandler 
.const [309] = Utf8 Lde/audi/app/phone/evo/favorite/TelFavoriteHandler; 
.const [310] = Utf8 Code 
.const [311] = Utf8 <init> 
.const [312] = Utf8 (Lde/audi/app/phone/evo/ITelEvoApplication;Lde/audi/atip/favorite/FavoritePersistenceHandlerBase;Lde/audi/atip/hmi/model/list/BaseListModelApp;Lde/audi/atip/log/LogChannel;Lde/audi/app/phone/evo/favorite/TelFavoriteHandler;)V 
.const [313] = Utf8 init 
.const [314] = Utf8 ()V 
.const [315] = Utf8 deinit 
.const [316] = Utf8 ()V 
.const [317] = Utf8 getListModelCopy 
.const [318] = Utf8 ()Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [319] = Utf8 capacityReached 
.const [320] = Utf8 (Z)V 
.const [321] = Utf8 addToFavorites 
.const [322] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [323] = Utf8 loadFavoriteListFromPersistence 
.const [324] = Utf8 ()V 
.const [325] = Utf8 removeFavorite 
.const [326] = Utf8 (J)V 
.const [327] = Utf8 renameFavorite 
.const [328] = Utf8 (ILjava/lang/String;)V 
.const [329] = Utf8 deleteAll 
.const [330] = Utf8 ()V 
.const [331] = Utf8 itemReleased 
.const [332] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)V 
.const [333] = Utf8 favoriteSelected 
.const [334] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)V 
.const [335] = Utf8 itemLongSelected 
.const [336] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)V 
.const [337] = Utf8 itemFocused 
.const [338] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;IIII)V 
.const [339] = Utf8 updatePersistence 
.const [340] = Utf8 ()V 
.const [341] = Utf8 loadFavoritesFromPersistence 
.const [342] = Utf8 ()V 
.const [343] = Utf8 getIndexForUniqueID 
.const [344] = Utf8 (J)I 
.const [345] = Utf8 moveModeActivated 
.const [346] = Utf8 ()V 
.const [347] = Utf8 moveModeDeactivated 
.const [348] = Utf8 ()V 
.end class 
