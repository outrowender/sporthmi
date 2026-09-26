.version 50 0 
.class public super [207] 
.super [209] 
.field private static final [210] [211] 
.field private [212] [213] 
.field private [214] [215] 
.field private [216] [217] 
.field private [218] [219] 
.field private [220] [221] 

.method public [223] : [224] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aconst_null 
L3:     invokespecial [36] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [222] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aconst_null 
L3:     invokespecial [36] 
L6:     aload_2 
L7:     ifnull L75 
L10:    iconst_0 
L11:    iload_3 
L12:    if_icmpgt L75 
L15:    iload_3 
L16:    aload_2 
L17:    invokevirtual [22] 
L20:    if_icmpge L75 
L23:    aload_1 
L24:    ldc [2] 
L26:    ldc [3] 
L28:    iload_3 
L29:    i2l 
L30:    invokevirtual [23] 
L33:    pop 
L34:    aload_0 
L35:    iload 4 
L37:    ifeq L47 
L40:    aload_2 
L41:    getfield [24] 
L44:    goto L48 
L47:    aconst_null 
L48:    putfield [42] 
L51:    aload_0 
L52:    iconst_1 
L53:    anewarray [4] 
L56:    dup 
L57:    iconst_0 
L58:    aload_2 
L59:    iload_3 
L60:    invokespecial [37] 
L63:    aastore 
L64:    putfield [44] 
L67:    aload_0 
L68:    aload_2 
L69:    invokevirtual [26] 
L72:    putfield [45] 
L75:    return 
L76:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [222] .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [46] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [44] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [42] 
L19:    aload_2 
L20:    ifnull L95 
L23:    aload_0 
L24:    aload_2 
L25:    getfield [24] 
L28:    putfield [42] 
L31:    aload_0 
L32:    aload_2 
L33:    invokevirtual [26] 
L36:    putfield [45] 
L39:    aload_2 
L40:    invokevirtual [22] 
L43:    istore_3 
L44:    aload_0 
L45:    iload_3 
L46:    anewarray [4] 
L49:    putfield [44] 
L52:    aload_1 
L53:    ldc [2] 
L55:    ldc [5] 
L57:    iload_3 
L58:    i2l 
L59:    invokevirtual [23] 
L62:    pop 
L63:    iconst_0 
L64:    istore 4 
L66:    iload 4 
L68:    aload_0 
L69:    getfield [25] 
L72:    arraylength 
L73:    if_icmpge L95 
L76:    aload_0 
L77:    getfield [25] 
L80:    iload 4 
L82:    aload_2 
L83:    iload 4 
L85:    invokespecial [37] 
L88:    aastore 
L89:    iinc 4 1 
L92:    goto L66 
L95:    return 
L96:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [222] .code stack 6 locals 3 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [44] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [42] 
L10:    aload_1 
L11:    ifnull L64 
L14:    aload_1 
L15:    arraylength 
L16:    istore_3 
L17:    aload_0 
L18:    iload_3 
L19:    anewarray [4] 
L22:    putfield [44] 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L64 
L34:    bipush 28 
L36:    istore 5 
L38:    aload_0 
L39:    getfield [25] 
L42:    iload 4 
L44:    new [43] 
L47:    dup 
L48:    aload_1 
L49:    iload 4 
L51:    aaload 
L52:    iload 5 
L54:    invokespecial [39] 
L57:    aastore 
L58:    iinc 4 1 
L61:    goto L28 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public interface [231] : [232] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [222] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [37] 
L7:     astore_3 
L8:     aload_3 
L9:     ifnull L17 
L12:    aload_3 
L13:    invokevirtual [29] 
L16:    astore_2 
L17:    aload_2 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [222] .code stack 2 locals 2 
L0:     iconst_2 
L1:     istore_2 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [37] 
L7:     astore_3 
L8:     aload_3 
L9:     ifnull L17 
L12:    aload_3 
L13:    invokevirtual [30] 
L16:    istore_2 
L17:    iload_2 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [222] .code stack 5 locals 2 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [37] 
L7:     astore_3 
L8:     aload_3 
L9:     ifnull L17 
L12:    aload_3 
L13:    invokevirtual [31] 
L16:    astore_2 
L17:    aload_2 
L18:    ifnonnull L35 
L21:    aload_0 
L22:    getfield [28] 
L25:    ldc [6] 
L27:    ldc [7] 
L29:    iload_1 
L30:    i2l 
L31:    invokevirtual [23] 
L34:    pop 
L35:    aload_2 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [222] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [8] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [23] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [37] 
L19:    astore_3 
L20:    aconst_null 
L21:    astore 4 
L23:    aload_3 
L24:    ifnull L112 
L27:    aload_3 
L28:    invokevirtual [31] 
L31:    ifnonnull L95 
L34:    aload_3 
L35:    invokevirtual [29] 
L38:    astore 5 
L40:    aload 5 
L42:    getfield [32] 
L45:    aload 5 
L47:    getfield [33] 
L50:    invokestatic [9] 
L53:    astore 6 
L55:    aload_2 
L56:    invokeinterface [47] 0 
L61:    astore 4 
L63:    aload 4 
L65:    new [48] 
L68:    dup 
L69:    aload 6 
L71:    invokespecial [40] 
L74:    invokevirtual [34] 
L77:    pop 
L78:    aload 4 
L80:    new [49] 
L83:    dup 
L84:    aload_3 
L85:    invokespecial [41] 
L88:    invokevirtual [34] 
L91:    pop 
L92:    goto L126 
L95:    aload_0 
L96:    getfield [28] 
L99:    ldc [2] 
L101:   ldc [12] 
L103:   iload_1 
L104:   i2l 
L105:   invokevirtual [23] 
L108:   pop 
L109:   goto L126 
L112:   aload_0 
L113:   getfield [28] 
L116:   ldc [6] 
L118:   ldc [13] 
L120:   iload_1 
L121:   i2l 
L122:   invokevirtual [23] 
L125:   pop 
L126:   aload 4 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [222] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [25] 
L6:     ifnull L15 
L9:     aload_0 
L10:    getfield [25] 
L13:    arraylength 
L14:    istore_1 
L15:    iload_1 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [243] : [244] 
    .attribute [222] .code stack 5 locals 1 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     getfield [25] 
L6:     ifnull L33 
L9:     iconst_0 
L10:    iload_1 
L11:    if_icmpgt L33 
L14:    iload_1 
L15:    aload_0 
L16:    getfield [25] 
L19:    arraylength 
L20:    if_icmpge L33 
L23:    aload_0 
L24:    getfield [25] 
L27:    iload_1 
L28:    aaload 
L29:    astore_2 
L30:    goto L47 
L33:    aload_0 
L34:    getfield [28] 
L37:    ldc [6] 
L39:    ldc [14] 
L41:    iload_1 
L42:    i2l 
L43:    invokevirtual [23] 
L46:    pop 
L47:    aload_2 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [50] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [247] : [248] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [45] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [251] : [252] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [51] 
.const [4] = Class [52] 
.const [5] = String [53] 
.const [6] = Int -1601830656 
.const [7] = String [54] 
.const [8] = String [55] 
.const [9] = Method [56] [57] 
.const [10] = Class [58] 
.const [11] = Class [59] 
.const [12] = String [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Field [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Field [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Field [110] [111] 
.const [43] = Class [112] 
.const [44] = Field [113] [114] 
.const [45] = Field [115] [116] 
.const [46] = Field [117] [118] 
.const [47] = InterfaceMethod [119] [120] 
.const [48] = Class [121] 
.const [49] = Class [122] 
.const [50] = Field [123] [124] 
.const [51] = Utf8 'OnlinePOIResultList#OnlinePOIResultList() - copy element at index %1.' 
.const [52] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [53] = Utf8 'OnlinePOIResultList#OnlinePOIResultList() - copy %1 elements.' 
.const [54] = Utf8 'OnlinePOIResultList#getTransfomedLocationAt() - no transformed location found at: %1!' 
.const [55] = Utf8 'OnlinePOIResultList#resolveEntry( %1 )' 
.const [56] = Class [125] 
.const [57] = NameAndType [126] [127] 
.const [58] = Utf8 de/audi/tghu/navi/app/command/LIGetLocationDescriptionTransformCommand 
.const [59] = Utf8 de/audi/tghu/navi/app/poi/online/RefreshResolvedEntryCommand 
.const [60] = Utf8 'OnlinePOIResultList#resolveEntry() - index: %1 already resolved! ' 
.const [61] = Utf8 'OnlinePOIResultList#resolveEntry() - no element found at index: %1' 
.const [62] = Utf8 'OnlinePOIResultList#getResultElement() - no element found at index: %1' 
.const [63] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [67] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [68] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [69] = Utf8 de/audi/tghu/command/CommandList 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Class [155] 
.const [89] = NameAndType [156] [157] 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [113] = Class [191] 
.const [114] = NameAndType [192] [193] 
.const [115] = Class [194] 
.const [116] = NameAndType [195] [196] 
.const [117] = Class [197] 
.const [118] = NameAndType [198] [199] 
.const [119] = Class [200] 
.const [120] = NameAndType [201] [202] 
.const [121] = Utf8 de/audi/tghu/navi/app/command/LIGetLocationDescriptionTransformCommand 
.const [122] = Utf8 de/audi/tghu/navi/app/poi/online/RefreshResolvedEntryCommand 
.const [123] = Class [203] 
.const [124] = NameAndType [204] [205] 
.const [125] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [126] = Utf8 getLocationFromGeoPos 
.const [127] = Utf8 (II)Lorg/dsi/ifc/global/NavLocation; 
.const [128] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [129] = Utf8 length 
.const [130] = Utf8 ()I 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;J)Z 
.const [134] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [135] = Utf8 searchContext 
.const [136] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [137] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [138] = Utf8 resultList 
.const [139] = Utf8 [Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement; 
.const [140] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [141] = Utf8 getForcedLocation 
.const [142] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [143] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [144] = Utf8 forcedLocation 
.const [145] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [146] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [147] = Utf8 logChannel 
.const [148] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [149] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [150] = Utf8 getElement 
.const [151] = Utf8 ()Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement; 
.const [152] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [153] = Utf8 getStyleType 
.const [154] = Utf8 ()I 
.const [155] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [156] = Utf8 getTransformedLocation 
.const [157] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [158] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [159] = Utf8 longitude 
.const [160] = Utf8 I 
.const [161] = Utf8 org/dsi/ifc/online/PoiOnlineSearchValuelistElement 
.const [162] = Utf8 latitude 
.const [163] = Utf8 I 
.const [164] = Utf8 de/audi/tghu/command/CommandList 
.const [165] = Utf8 add 
.const [166] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [167] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [168] = Utf8 forcedZoomLevel 
.const [169] = Utf8 I 
.const [170] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)V 
.const [173] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [174] = Utf8 getResultElement 
.const [175] = Utf8 (I)Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement; 
.const [176] = Utf8 java/lang/Object 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement;I)V 
.const [182] = Utf8 de/audi/tghu/navi/app/command/LIGetLocationDescriptionTransformCommand 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [185] = Utf8 de/audi/tghu/navi/app/poi/online/RefreshResolvedEntryCommand 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement;)V 
.const [188] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [189] = Utf8 searchContext 
.const [190] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [191] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [192] = Utf8 resultList 
.const [193] = Utf8 [Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement; 
.const [194] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [195] = Utf8 forcedLocation 
.const [196] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [197] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [198] = Utf8 logChannel 
.const [199] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [200] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [201] = Utf8 createCommandList 
.const [202] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [203] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [204] = Utf8 forcedZoomLevel 
.const [205] = Utf8 I 
.const [206] = Utf8 de/audi/tghu/navi/app/poi/online/OnlinePOIResultList 
.const [207] = Class [206] 
.const [208] = Utf8 java/lang/Object 
.const [209] = Class [208] 
.const [210] = Utf8 USE_PINS_A_TO_J 
.const [211] = Utf8 Z 
.const [212] = Utf8 logChannel 
.const [213] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [214] = Utf8 resultList 
.const [215] = Utf8 [Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement; 
.const [216] = Utf8 searchContext 
.const [217] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [218] = Utf8 forcedZoomLevel 
.const [219] = Utf8 I 
.const [220] = Utf8 forcedLocation 
.const [221] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [222] = Utf8 Code 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;IZ)V 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList;)V 
.const [229] = Utf8 updateResultList 
.const [230] = Utf8 ([Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement;Lorg/dsi/ifc/global/NavLocation;)V 
.const [231] = Utf8 getSearchContext 
.const [232] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [233] = Utf8 getPOIElementAt 
.const [234] = Utf8 (I)Lorg/dsi/ifc/online/PoiOnlineSearchValuelistElement; 
.const [235] = Utf8 getStyleTypeAt 
.const [236] = Utf8 (I)I 
.const [237] = Utf8 getTransformedLocationAt 
.const [238] = Utf8 (I)Lorg/dsi/ifc/global/NavLocation; 
.const [239] = Utf8 resolveEntry 
.const [240] = Utf8 (ILde/audi/tghu/command/ICommandListFactory;)Lde/audi/tghu/command/CommandList; 
.const [241] = Utf8 length 
.const [242] = Utf8 ()I 
.const [243] = Utf8 getResultElement 
.const [244] = Utf8 (I)Lde/audi/tghu/navi/app/poi/online/OnlinePOIResultList$ResultElement; 
.const [245] = Utf8 setForcedZoomLevel 
.const [246] = Utf8 (I)V 
.const [247] = Utf8 getForcedZoomLevel 
.const [248] = Utf8 ()I 
.const [249] = Utf8 setForcedLocation 
.const [250] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [251] = Utf8 getForcedLocation 
.const [252] = Utf8 ()Lorg/dsi/ifc/global/NavLocationWgs84; 
.end class 
