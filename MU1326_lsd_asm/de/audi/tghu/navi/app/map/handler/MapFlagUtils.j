.version 50 0 
.class public super [256] 
.super [258] 
.field protected static [259] [260] 
.field public static volatile [261] [262] 

.method public annotation [264] : [265] 
    .attribute [263] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static [266] : [267] 
    .attribute [263] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public static [268] : [269] 
    .attribute [263] .code stack 1 locals 0 
L0:     aload_0 
L1:     putstatic [53] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [270] : [271] 
    .attribute [263] .code stack 7 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aconst_null 
L7:     astore_2 
L8:     aload_0 
L9:     invokevirtual [31] 
L12:    iconst_1 
L13:    invokestatic [3] 
L16:    astore_3 
L17:    aload_3 
L18:    ifnull L78 
L21:    aload_1 
L22:    aload_3 
L23:    invokevirtual [32] 
L26:    invokevirtual [33] 
L29:    astore 4 
L31:    invokestatic [4] 
L34:    ldc [5] 
L36:    ldc [6] 
L38:    aload 4 
L40:    invokevirtual [34] 
L43:    pop 
L44:    new [58] 
L47:    dup 
L48:    aload 4 
L50:    invokevirtual [35] 
L53:    aload 4 
L55:    invokevirtual [36] 
L58:    iconst_1 
L59:    ldc2_w [62] 
L62:    invokespecial [54] 
L65:    astore_2 
L66:    invokestatic [4] 
L69:    ldc [5] 
L71:    ldc [8] 
L73:    aload_2 
L74:    invokevirtual [34] 
L77:    pop 
L78:    aload_2 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public static [272] : [273] 
    .attribute [263] .code stack 7 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aconst_null 
L7:     astore_2 
L8:     aload_0 
L9:     invokevirtual [31] 
L12:    iconst_2 
L13:    invokestatic [3] 
L16:    astore_3 
L17:    aload_3 
L18:    ifnull L78 
L21:    aload_1 
L22:    aload_3 
L23:    invokevirtual [32] 
L26:    invokevirtual [33] 
L29:    astore 4 
L31:    invokestatic [4] 
L34:    ldc [5] 
L36:    ldc [9] 
L38:    aload 4 
L40:    invokevirtual [34] 
L43:    pop 
L44:    new [58] 
L47:    dup 
L48:    aload 4 
L50:    invokevirtual [35] 
L53:    aload 4 
L55:    invokevirtual [36] 
L58:    iconst_0 
L59:    ldc2_w [62] 
L62:    invokespecial [54] 
L65:    astore_2 
L66:    invokestatic [4] 
L69:    ldc [5] 
L71:    ldc [10] 
L73:    aload_2 
L74:    invokevirtual [34] 
L77:    pop 
L78:    aload_2 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public static [274] : [275] 
    .attribute [263] .code stack 7 locals 0 
L0:     new [58] 
L3:     dup 
L4:     aload_0 
L5:     getfield [37] 
L8:     aload_0 
L9:     getfield [38] 
L12:    aload_0 
L13:    getfield [39] 
L16:    aload_0 
L17:    getfield [40] 
L20:    invokespecial [54] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public static [276] : [277] 
    .attribute [263] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokestatic [11] 
L4:     ifeq L12 
L7:     iconst_0 
L8:     anewarray [7] 
L11:    areturn 
L12:    aload_0 
L13:    arraylength 
L14:    anewarray [7] 
L17:    astore_1 
L18:    iconst_0 
L19:    istore_2 
L20:    iload_2 
L21:    aload_0 
L22:    arraylength 
L23:    if_icmpge L41 
L26:    aload_1 
L27:    iload_2 
L28:    aload_0 
L29:    iload_2 
L30:    aaload 
L31:    getfield [41] 
L34:    aastore 
L35:    iinc 2 1 
L38:    goto L20 
L41:    aload_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [278] : [279] 
    .attribute [263] .code stack 8 locals 4 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     ifnull L99 
L6:     aload_0 
L7:     invokevirtual [42] 
L10:    ifle L99 
L13:    aload_0 
L14:    invokevirtual [42] 
L17:    istore_3 
L18:    iload_3 
L19:    anewarray [12] 
L22:    astore_2 
L23:    iconst_0 
L24:    istore 4 
L26:    iload 4 
L28:    iload_3 
L29:    if_icmpge L99 
L32:    new [58] 
L35:    dup 
L36:    aload_0 
L37:    iload 4 
L39:    invokevirtual [43] 
L42:    getfield [44] 
L45:    aload_0 
L46:    iload 4 
L48:    invokevirtual [43] 
L51:    getfield [45] 
L54:    aload_0 
L55:    iload 4 
L57:    invokevirtual [46] 
L60:    ldc2_w [62] 
L63:    invokespecial [54] 
L66:    astore 5 
L68:    aload_2 
L69:    iload 4 
L71:    new [59] 
L74:    dup 
L75:    aload 5 
L77:    iload 4 
L79:    aload_0 
L80:    iload 4 
L82:    invokevirtual [43] 
L85:    getfield [47] 
L88:    iload_1 
L89:    invokespecial [55] 
L92:    aastore 
L93:    iinc 4 1 
L96:    goto L26 
L99:    aload_2 
L100:   areturn 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public static [280] : [281] 
    .attribute [263] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L10 
L4:     aload_1 
L5:     ifnonnull L10 
L8:     iconst_1 
L9:     areturn 
L10:    aload_0 
L11:    ifnull L20 
L14:    aload_1 
L15:    ifnonnull L20 
L18:    iconst_0 
L19:    areturn 
L20:    aload_0 
L21:    ifnonnull L30 
L24:    aload_1 
L25:    ifnull L30 
L28:    iconst_0 
L29:    areturn 
L30:    aload_0 
L31:    aload_1 
L32:    invokevirtual [48] 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public static [282] : [283] 
    .attribute [263] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     iconst_m1 
L4:     invokestatic [13] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public static [284] : [285] 
    .attribute [263] .code stack 6 locals 0 
L0:     new [59] 
L3:     dup 
L4:     aload_0 
L5:     iload_1 
L6:     aload_2 
L7:     iload_3 
L8:     invokespecial [55] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [286] : [287] 
    .attribute [263] .code stack 7 locals 4 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [42] 
L10:    istore_2 
L11:    iload_2 
L12:    anewarray [12] 
L15:    astore_3 
L16:    iconst_0 
L17:    istore 4 
L19:    iload 4 
L21:    iload_2 
L22:    if_icmpge L106 
L25:    new [58] 
L28:    dup 
L29:    aload_0 
L30:    iload 4 
L32:    invokevirtual [43] 
L35:    getfield [44] 
L38:    aload_0 
L39:    iload 4 
L41:    invokevirtual [43] 
L44:    getfield [45] 
L47:    aload_0 
L48:    iload 4 
L50:    invokevirtual [46] 
L53:    ldc2_w [62] 
L56:    invokespecial [54] 
L59:    astore 5 
L61:    aload_3 
L62:    iload 4 
L64:    aload 5 
L66:    iload 4 
L68:    aload_0 
L69:    iload 4 
L71:    invokevirtual [43] 
L74:    getfield [47] 
L77:    iload_1 
L78:    invokestatic [13] 
L81:    aastore 
L82:    invokestatic [4] 
L85:    ldc [5] 
L87:    ldc [14] 
L89:    aload_3 
L90:    iload 4 
L92:    aaload 
L93:    iload 4 
L95:    i2l 
L96:    invokevirtual [49] 
L99:    pop 
L100:   iinc 4 1 
L103:   goto L19 
L106:   aload_3 
L107:   areturn 
L108:   
    .end code 
.end method 

.method public static [288] : [289] 
    .attribute [263] .code stack 9 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [42] 
L10:    istore_1 
L11:    iload_1 
L12:    anewarray [7] 
L15:    astore_2 
L16:    iconst_0 
L17:    istore_3 
L18:    iload_3 
L19:    iload_1 
L20:    if_icmpge L63 
L23:    aload_2 
L24:    iload_3 
L25:    new [58] 
L28:    dup 
L29:    aload_0 
L30:    iload_3 
L31:    invokevirtual [43] 
L34:    getfield [44] 
L37:    aload_0 
L38:    iload_3 
L39:    invokevirtual [43] 
L42:    getfield [45] 
L45:    aload_0 
L46:    iload_3 
L47:    invokevirtual [46] 
L50:    ldc2_w [62] 
L53:    invokespecial [54] 
L56:    aastore 
L57:    iinc 3 1 
L60:    goto L18 
L63:    aload_2 
L64:    areturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public static [290] : [291] 
    .attribute [263] .code stack 9 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [42] 
L10:    istore_1 
L11:    iload_1 
L12:    anewarray [15] 
L15:    astore_2 
L16:    iconst_0 
L17:    istore_3 
L18:    iload_3 
L19:    iload_1 
L20:    if_icmpge L62 
L23:    aload_2 
L24:    iload_3 
L25:    new [60] 
L28:    dup 
L29:    aload_0 
L30:    iload_3 
L31:    invokevirtual [43] 
L34:    getfield [44] 
L37:    aload_0 
L38:    iload_3 
L39:    invokevirtual [43] 
L42:    getfield [45] 
L45:    aload_0 
L46:    iload_3 
L47:    invokevirtual [46] 
L50:    iload_3 
L51:    iconst_2 
L52:    invokespecial [56] 
L55:    aastore 
L56:    iinc 3 1 
L59:    goto L18 
L62:    aload_2 
L63:    areturn 
L64:    
    .end code 
.end method 

.method public static [292] : [293] 
    .attribute [263] .code stack 7 locals 1 
L0:     invokestatic [4] 
L3:     ldc [5] 
L5:     ldc [16] 
L7:     aload_0 
L8:     invokevirtual [34] 
L11:    pop 
L12:    aload_0 
L13:    ifnonnull L18 
L16:    aconst_null 
L17:    areturn 
L18:    new [58] 
L21:    dup 
L22:    aload_0 
L23:    invokevirtual [50] 
L26:    aload_0 
L27:    invokevirtual [51] 
L30:    bipush 35 
L32:    ldc2_w [62] 
L35:    invokespecial [54] 
L38:    astore_1 
L39:    aload_1 
L40:    iconst_m1 
L41:    ldc [17] 
L43:    invokestatic [18] 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method static [294] : [295] 
    .attribute [263] .code stack 2 locals 0 
L0:     new [61] 
L3:     dup 
L4:     invokespecial [52] 
L7:     putstatic [57] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [64] [65] 
.const [3] = Method [66] [67] 
.const [4] = Method [68] [69] 
.const [5] = Int 14808325 
.const [6] = String [70] 
.const [7] = Class [71] 
.const [8] = String [72] 
.const [9] = String [73] 
.const [10] = String [74] 
.const [11] = Method [75] [76] 
.const [12] = Class [77] 
.const [13] = Method [78] [79] 
.const [14] = String [80] 
.const [15] = Class [81] 
.const [16] = String [82] 
.const [17] = String [83] 
.const [18] = Method [84] [85] 
.const [19] = Class [86] 
.const [20] = Class [87] 
.const [21] = Class [88] 
.const [22] = Class [89] 
.const [23] = Class [90] 
.const [24] = Class [91] 
.const [25] = Class [92] 
.const [26] = Class [93] 
.const [27] = Class [94] 
.const [28] = Class [95] 
.const [29] = Class [96] 
.const [30] = Class [97] 
.const [31] = Method [98] [99] 
.const [32] = Method [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Method [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Field [110] [111] 
.const [38] = Field [112] [113] 
.const [39] = Field [114] [115] 
.const [40] = Field [116] [117] 
.const [41] = Field [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Method [122] [123] 
.const [44] = Field [124] [125] 
.const [45] = Field [126] [127] 
.const [46] = Method [128] [129] 
.const [47] = Field [130] [131] 
.const [48] = Method [132] [133] 
.const [49] = Method [134] [135] 
.const [50] = Method [136] [137] 
.const [51] = Method [138] [139] 
.const [52] = Method [140] [141] 
.const [53] = Field [142] [143] 
.const [54] = Method [144] [145] 
.const [55] = Method [146] [147] 
.const [56] = Method [148] [149] 
.const [57] = Field [150] [151] 
.const [58] = Class [152] 
.const [59] = Class [153] 
.const [60] = Class [154] 
.const [61] = Class [155] 
.const [62] = Long -1L 
.const [64] = Class [156] 
.const [65] = NameAndType [157] [158] 
.const [66] = Class [159] 
.const [67] = NameAndType [160] [161] 
.const [68] = Class [162] 
.const [69] = NameAndType [163] [164] 
.const [70] = Utf8 'MapFlagUtils#convertAdbEntryToTopDestBusiness: loc = %1' 
.const [71] = Utf8 org/dsi/ifc/map/MapFlag 
.const [72] = Utf8 'MapFlagUtils#convertAdbEntryToTopDestBusiness: mf = %1' 
.const [73] = Utf8 'MapFlagUtils#convertAdbEntryToTopDestPrivate: loc = %1' 
.const [74] = Utf8 'MapFlagUtils#convertAdbEntryToTopDestPrivate: mf = %1' 
.const [75] = Class [165] 
.const [76] = NameAndType [166] [167] 
.const [77] = Utf8 de/audi/tghu/navi/app/map/handler/MapUserFlag 
.const [78] = Class [168] 
.const [79] = NameAndType [169] [170] 
.const [80] = Utf8 'MapFlagUtils#convertResultListToUserFlags(): result[%2]=%1' 
.const [81] = Utf8 de/audi/tghu/navi/app/map/utils/MapPin 
.const [82] = Utf8 'MapFlagUtils#convertPicNavCoordinateToUserFlag(): picNavCoordinate: %1' 
.const [83] = Utf8 '' 
.const [84] = Class [171] 
.const [85] = NameAndType [172] [173] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [88] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [89] = Utf8 de/audi/tghu/navi/app/map/utils/MapUtils 
.const [90] = Utf8 org/dsi/ifc/organizer/AddressData 
.const [91] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 org/dsi/ifc/global/NavLocation 
.const [94] = Utf8 de/audi/tghu/navi/app/map/utils/MapArrayUtils 
.const [95] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [96] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [97] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Class [192] 
.const [111] = NameAndType [193] [194] 
.const [112] = Class [195] 
.const [113] = NameAndType [196] [197] 
.const [114] = Class [198] 
.const [115] = NameAndType [199] [200] 
.const [116] = Class [201] 
.const [117] = NameAndType [202] [203] 
.const [118] = Class [204] 
.const [119] = NameAndType [205] [206] 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Class [210] 
.const [123] = NameAndType [211] [212] 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Class [216] 
.const [127] = NameAndType [217] [218] 
.const [128] = Class [219] 
.const [129] = NameAndType [220] [221] 
.const [130] = Class [222] 
.const [131] = NameAndType [223] [224] 
.const [132] = Class [225] 
.const [133] = NameAndType [226] [227] 
.const [134] = Class [228] 
.const [135] = NameAndType [229] [230] 
.const [136] = Class [231] 
.const [137] = NameAndType [232] [233] 
.const [138] = Class [234] 
.const [139] = NameAndType [235] [236] 
.const [140] = Class [237] 
.const [141] = NameAndType [238] [239] 
.const [142] = Class [240] 
.const [143] = NameAndType [241] [242] 
.const [144] = Class [243] 
.const [145] = NameAndType [244] [245] 
.const [146] = Class [246] 
.const [147] = NameAndType [247] [248] 
.const [148] = Class [249] 
.const [149] = NameAndType [250] [251] 
.const [150] = Class [252] 
.const [151] = NameAndType [253] [254] 
.const [152] = Utf8 org/dsi/ifc/map/MapFlag 
.const [153] = Utf8 de/audi/tghu/navi/app/map/handler/MapUserFlag 
.const [154] = Utf8 de/audi/tghu/navi/app/map/utils/MapPin 
.const [155] = Utf8 java/lang/Object 
.const [156] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [157] = Utf8 sLogChannel 
.const [158] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 de/audi/tghu/navi/app/map/utils/MapUtils 
.const [160] = Utf8 extractAddressDataOfEntryType 
.const [161] = Utf8 ([Lorg/dsi/ifc/organizer/AddressData;I)Lorg/dsi/ifc/organizer/AddressData; 
.const [162] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [163] = Utf8 getLogChannel 
.const [164] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 de/audi/tghu/navi/app/map/utils/MapArrayUtils 
.const [166] = Utf8 isEmpty 
.const [167] = Utf8 ([Ljava/lang/Object;)Z 
.const [168] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [169] = Utf8 createUserFlag 
.const [170] = Utf8 (Lorg/dsi/ifc/map/MapFlag;ILjava/lang/String;I)Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [171] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [172] = Utf8 createUserFlag 
.const [173] = Utf8 (Lorg/dsi/ifc/map/MapFlag;ILjava/lang/String;)Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [174] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [175] = Utf8 getAddressData 
.const [176] = Utf8 ()[Lorg/dsi/ifc/organizer/AddressData; 
.const [177] = Utf8 org/dsi/ifc/organizer/AddressData 
.const [178] = Utf8 getNavLocation 
.const [179] = Utf8 ()[B 
.const [180] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [181] = Utf8 streamToLocation 
.const [182] = Utf8 ([B)Lorg/dsi/ifc/global/NavLocation; 
.const [183] = Utf8 de/audi/atip/log/LogChannel 
.const [184] = Utf8 log 
.const [185] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [186] = Utf8 org/dsi/ifc/global/NavLocation 
.const [187] = Utf8 getLongitude 
.const [188] = Utf8 ()I 
.const [189] = Utf8 org/dsi/ifc/global/NavLocation 
.const [190] = Utf8 getLatitude 
.const [191] = Utf8 ()I 
.const [192] = Utf8 org/dsi/ifc/map/MapFlag 
.const [193] = Utf8 geoX 
.const [194] = Utf8 I 
.const [195] = Utf8 org/dsi/ifc/map/MapFlag 
.const [196] = Utf8 geoY 
.const [197] = Utf8 I 
.const [198] = Utf8 org/dsi/ifc/map/MapFlag 
.const [199] = Utf8 styleIndex 
.const [200] = Utf8 I 
.const [201] = Utf8 org/dsi/ifc/map/MapFlag 
.const [202] = Utf8 handle 
.const [203] = Utf8 J 
.const [204] = Utf8 de/audi/tghu/navi/app/map/handler/MapUserFlag 
.const [205] = Utf8 mMapFlag 
.const [206] = Utf8 Lorg/dsi/ifc/map/MapFlag; 
.const [207] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [208] = Utf8 length 
.const [209] = Utf8 ()I 
.const [210] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [211] = Utf8 getPOIElementAt 
.const [212] = Utf8 (I)Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement; 
.const [213] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [214] = Utf8 longitude 
.const [215] = Utf8 I 
.const [216] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [217] = Utf8 latitude 
.const [218] = Utf8 I 
.const [219] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [220] = Utf8 getStyleTypeAt 
.const [221] = Utf8 (I)I 
.const [222] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [223] = Utf8 name 
.const [224] = Utf8 Ljava/lang/String; 
.const [225] = Utf8 java/lang/Object 
.const [226] = Utf8 equals 
.const [227] = Utf8 (Ljava/lang/Object;)Z 
.const [228] = Utf8 de/audi/atip/log/LogChannel 
.const [229] = Utf8 log 
.const [230] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [231] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [232] = Utf8 getLongitude 
.const [233] = Utf8 ()I 
.const [234] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [235] = Utf8 getLatitude 
.const [236] = Utf8 ()I 
.const [237] = Utf8 java/lang/Object 
.const [238] = Utf8 <init> 
.const [239] = Utf8 ()V 
.const [240] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [241] = Utf8 sLogChannel 
.const [242] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [243] = Utf8 org/dsi/ifc/map/MapFlag 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (IIIJ)V 
.const [246] = Utf8 de/audi/tghu/navi/app/map/handler/MapUserFlag 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Lorg/dsi/ifc/map/MapFlag;ILjava/lang/String;I)V 
.const [249] = Utf8 de/audi/tghu/navi/app/map/utils/MapPin 
.const [250] = Utf8 <init> 
.const [251] = Utf8 (IIIII)V 
.const [252] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [253] = Utf8 sUserFlagsMutex 
.const [254] = Utf8 Ljava/lang/Object; 
.const [255] = Utf8 de/audi/tghu/navi/app/map/handler/MapFlagUtils 
.const [256] = Class [255] 
.const [257] = Utf8 java/lang/Object 
.const [258] = Class [257] 
.const [259] = Utf8 sLogChannel 
.const [260] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [261] = Utf8 sUserFlagsMutex 
.const [262] = Utf8 Ljava/lang/Object; 
.const [263] = Utf8 Code 
.const [264] = Utf8 <init> 
.const [265] = Utf8 ()V 
.const [266] = Utf8 getLogChannel 
.const [267] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [268] = Utf8 setLogChannel 
.const [269] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [270] = Utf8 convertAdbEntryToTopDestBusiness 
.const [271] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Lde/audi/tghu/navi/app/LocationSerializer;)Lorg/dsi/ifc/map/MapFlag; 
.const [272] = Utf8 convertAdbEntryToTopDestPrivate 
.const [273] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Lde/audi/tghu/navi/app/LocationSerializer;)Lorg/dsi/ifc/map/MapFlag; 
.const [274] = Utf8 clone 
.const [275] = Utf8 (Lorg/dsi/ifc/map/MapFlag;)Lorg/dsi/ifc/map/MapFlag; 
.const [276] = Utf8 getMapFlags 
.const [277] = Utf8 ([Lde/audi/tghu/navi/app/map/handler/MapUserFlag;)[Lorg/dsi/ifc/map/MapFlag; 
.const [278] = Utf8 convert2MapUserFlags 
.const [279] = Utf8 (Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;I)[Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [280] = Utf8 isEqual 
.const [281] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [282] = Utf8 createUserFlag 
.const [283] = Utf8 (Lorg/dsi/ifc/map/MapFlag;ILjava/lang/String;)Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [284] = Utf8 createUserFlag 
.const [285] = Utf8 (Lorg/dsi/ifc/map/MapFlag;ILjava/lang/String;I)Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [286] = Utf8 convertResultListToUserFlags 
.const [287] = Utf8 (Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;I)[Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [288] = Utf8 convertResultListToMapFlags 
.const [289] = Utf8 (Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)[Lorg/dsi/ifc/map/MapFlag; 
.const [290] = Utf8 convertResultListToMapPins 
.const [291] = Utf8 (Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)[Lde/audi/tghu/navi/app/map/utils/MapPin; 
.const [292] = Utf8 convertPicNavCoordinateToUserFlag 
.const [293] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;)Lde/audi/tghu/navi/app/map/handler/MapUserFlag; 
.const [294] = Utf8 <clinit> 
.const [295] = Utf8 ()V 
.end class 
