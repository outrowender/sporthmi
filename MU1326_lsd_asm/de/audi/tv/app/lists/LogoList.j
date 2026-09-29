.version 50 0 
.class public super [181] 
.super [183] 
.field private final [184] [185] 
.field private final [186] [187] 
.field private final [188] [189] 

.method public [191] : [192] 
    .attribute [190] .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     new [30] 
L8:     dup 
L9:     invokespecial [24] 
L12:    putfield [31] 
L15:    aload_0 
L16:    new [32] 
L19:    dup 
L20:    invokespecial [25] 
L23:    putfield [33] 
L26:    aload_0 
L27:    new [34] 
L30:    dup 
L31:    aload_1 
L32:    aload_2 
L33:    invokespecial [26] 
L36:    putfield [35] 
L39:    aload_0 
L40:    getfield [13] 
L43:    invokevirtual [14] 
L46:    astore_3 
L47:    iconst_0 
L48:    istore 4 
L50:    iload 4 
L52:    aload_3 
L53:    arraylength 
L54:    if_icmpge L101 
L57:    aload_3 
L58:    iload 4 
L60:    aaload 
L61:    ifnull L95 
L64:    aload_0 
L65:    getfield [11] 
L68:    new [36] 
L71:    dup 
L72:    aload_3 
L73:    iload 4 
L75:    aaload 
L76:    getfield [15] 
L79:    invokespecial [27] 
L82:    aload_3 
L83:    iload 4 
L85:    aaload 
L86:    getfield [16] 
L89:    invokeinterface [37] 0 
L94:    pop 
L95:    iinc 4 1 
L98:    goto L50 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method [193] : [194] 
    .attribute [190] .code stack 5 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L43 
L8:     aload_0 
L9:     getfield [11] 
L12:    new [36] 
L15:    dup 
L16:    aload_1 
L17:    iload_2 
L18:    aaload 
L19:    getfield [15] 
L22:    invokespecial [27] 
L25:    aload_1 
L26:    iload_2 
L27:    aaload 
L28:    getfield [16] 
L31:    invokeinterface [37] 0 
L36:    pop 
L37:    iinc 2 1 
L40:    goto L2 
L43:    aload_0 
L44:    invokespecial [28] 
L47:    return 
L48:    
    .end code 
.end method 

.method [195] : [196] 
    .attribute [190] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L38 
L8:     aload_0 
L9:     getfield [12] 
L12:    aload_1 
L13:    iload_2 
L14:    laload 
L15:    invokevirtual [17] 
L18:    ifne L32 
L21:    aload_0 
L22:    getfield [12] 
L25:    aload_1 
L26:    iload_2 
L27:    laload 
L28:    invokevirtual [18] 
L31:    pop 
L32:    iinc 2 1 
L35:    goto L2 
L38:    aload_0 
L39:    invokespecial [28] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method [197] : [198] 
    .attribute [190] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L25 
L8:     aload_0 
L9:     getfield [12] 
L12:    aload_1 
L13:    iload_2 
L14:    laload 
L15:    invokevirtual [19] 
L18:    pop 
L19:    iinc 2 1 
L22:    goto L2 
L25:    aload_0 
L26:    invokespecial [28] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [199] : [200] 
    .attribute [190] .code stack 7 locals 4 
L0:     bipush 50 
L2:     anewarray [6] 
L5:     astore_1 
L6:     iconst_0 
L7:     istore_2 
L8:     iconst_0 
L9:     istore_3 
L10:    iload_3 
L11:    aload_0 
L12:    getfield [12] 
L15:    invokevirtual [20] 
L18:    if_icmpge L84 
L21:    aload_0 
L22:    getfield [11] 
L25:    new [36] 
L28:    dup 
L29:    aload_0 
L30:    getfield [12] 
L33:    iload_3 
L34:    invokevirtual [21] 
L37:    invokespecial [27] 
L40:    invokeinterface [39] 0 
L45:    checkcast [7] 
L48:    astore 4 
L50:    aload 4 
L52:    ifnull L78 
L55:    aload_1 
L56:    iload_2 
L57:    iinc 2 1 
L60:    new [38] 
L63:    dup 
L64:    aload_0 
L65:    getfield [12] 
L68:    iload_3 
L69:    invokevirtual [21] 
L72:    aload 4 
L74:    invokespecial [29] 
L77:    aastore 
L78:    iinc 3 1 
L81:    goto L10 
L84:    aload_0 
L85:    getfield [13] 
L88:    aload_1 
L89:    invokevirtual [22] 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method [201] : [202] 
    .attribute [190] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     new [36] 
L7:     dup 
L8:     lload_1 
L9:     invokespecial [27] 
L12:    invokeinterface [39] 0 
L17:    checkcast [7] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokeinterface [40] 0 
L9:     aload_0 
L10:    getfield [13] 
L13:    bipush 50 
L15:    anewarray [6] 
L18:    invokevirtual [22] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = Class [43] 
.const [5] = Class [44] 
.const [6] = Class [45] 
.const [7] = Class [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Class [49] 
.const [11] = Field [50] [51] 
.const [12] = Field [52] [53] 
.const [13] = Field [54] [55] 
.const [14] = Method [56] [57] 
.const [15] = Field [58] [59] 
.const [16] = Field [60] [61] 
.const [17] = Method [62] [63] 
.const [18] = Method [64] [65] 
.const [19] = Method [66] [67] 
.const [20] = Method [68] [69] 
.const [21] = Method [70] [71] 
.const [22] = Method [72] [73] 
.const [23] = Method [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Class [88] 
.const [31] = Field [89] [90] 
.const [32] = Class [91] 
.const [33] = Field [92] [93] 
.const [34] = Class [94] 
.const [35] = Field [95] [96] 
.const [36] = Class [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = Class [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = Utf8 java/util/HashMap 
.const [42] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [43] = Utf8 de/audi/tv/app/storage/LogoListStorage 
.const [44] = Utf8 java/lang/Long 
.const [45] = Utf8 org/dsi/ifc/tvtuner/LogoInfo 
.const [46] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [47] = Utf8 de/audi/tv/app/lists/LogoList 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 java/util/Map 
.const [50] = Class [105] 
.const [51] = NameAndType [106] [107] 
.const [52] = Class [108] 
.const [53] = NameAndType [109] [110] 
.const [54] = Class [111] 
.const [55] = NameAndType [112] [113] 
.const [56] = Class [114] 
.const [57] = NameAndType [115] [116] 
.const [58] = Class [117] 
.const [59] = NameAndType [118] [119] 
.const [60] = Class [120] 
.const [61] = NameAndType [121] [122] 
.const [62] = Class [123] 
.const [63] = NameAndType [124] [125] 
.const [64] = Class [126] 
.const [65] = NameAndType [127] [128] 
.const [66] = Class [129] 
.const [67] = NameAndType [130] [131] 
.const [68] = Class [132] 
.const [69] = NameAndType [133] [134] 
.const [70] = Class [135] 
.const [71] = NameAndType [136] [137] 
.const [72] = Class [138] 
.const [73] = NameAndType [139] [140] 
.const [74] = Class [141] 
.const [75] = NameAndType [142] [143] 
.const [76] = Class [144] 
.const [77] = NameAndType [145] [146] 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Utf8 java/util/HashMap 
.const [89] = Class [162] 
.const [90] = NameAndType [163] [164] 
.const [91] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Utf8 de/audi/tv/app/storage/LogoListStorage 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Utf8 java/lang/Long 
.const [98] = Class [171] 
.const [99] = NameAndType [172] [173] 
.const [100] = Utf8 org/dsi/ifc/tvtuner/LogoInfo 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Utf8 de/audi/tv/app/lists/LogoList 
.const [106] = Utf8 logoMap 
.const [107] = Utf8 Ljava/util/Map; 
.const [108] = Utf8 de/audi/tv/app/lists/LogoList 
.const [109] = Utf8 favoriteNamePIDs 
.const [110] = Utf8 Lde/esolutions/fw/util/commons/LongList; 
.const [111] = Utf8 de/audi/tv/app/lists/LogoList 
.const [112] = Utf8 storage 
.const [113] = Utf8 Lde/audi/tv/app/storage/LogoListStorage; 
.const [114] = Utf8 de/audi/tv/app/storage/LogoListStorage 
.const [115] = Utf8 read 
.const [116] = Utf8 ()[Lorg/dsi/ifc/tvtuner/LogoInfo; 
.const [117] = Utf8 org/dsi/ifc/tvtuner/LogoInfo 
.const [118] = Utf8 namePID 
.const [119] = Utf8 J 
.const [120] = Utf8 org/dsi/ifc/tvtuner/LogoInfo 
.const [121] = Utf8 channelLogo 
.const [122] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [123] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [124] = Utf8 contains 
.const [125] = Utf8 (J)Z 
.const [126] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [127] = Utf8 add 
.const [128] = Utf8 (J)Z 
.const [129] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [130] = Utf8 removeElement 
.const [131] = Utf8 (J)Z 
.const [132] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [133] = Utf8 size 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [136] = Utf8 get 
.const [137] = Utf8 (I)J 
.const [138] = Utf8 de/audi/tv/app/storage/LogoListStorage 
.const [139] = Utf8 write 
.const [140] = Utf8 ([Lorg/dsi/ifc/tvtuner/LogoInfo;)V 
.const [141] = Utf8 java/lang/Object 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 java/util/HashMap 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/esolutions/fw/util/commons/LongList 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/tv/app/storage/LogoListStorage 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [153] = Utf8 java/lang/Long 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (J)V 
.const [156] = Utf8 de/audi/tv/app/lists/LogoList 
.const [157] = Utf8 saveLogoList 
.const [158] = Utf8 ()V 
.const [159] = Utf8 org/dsi/ifc/tvtuner/LogoInfo 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (JLorg/dsi/ifc/global/ResourceLocator;)V 
.const [162] = Utf8 de/audi/tv/app/lists/LogoList 
.const [163] = Utf8 logoMap 
.const [164] = Utf8 Ljava/util/Map; 
.const [165] = Utf8 de/audi/tv/app/lists/LogoList 
.const [166] = Utf8 favoriteNamePIDs 
.const [167] = Utf8 Lde/esolutions/fw/util/commons/LongList; 
.const [168] = Utf8 de/audi/tv/app/lists/LogoList 
.const [169] = Utf8 storage 
.const [170] = Utf8 Lde/audi/tv/app/storage/LogoListStorage; 
.const [171] = Utf8 java/util/Map 
.const [172] = Utf8 put 
.const [173] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [174] = Utf8 java/util/Map 
.const [175] = Utf8 get 
.const [176] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [177] = Utf8 java/util/Map 
.const [178] = Utf8 clear 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/tv/app/lists/LogoList 
.const [181] = Class [180] 
.const [182] = Utf8 java/lang/Object 
.const [183] = Class [182] 
.const [184] = Utf8 logoMap 
.const [185] = Utf8 Ljava/util/Map; 
.const [186] = Utf8 favoriteNamePIDs 
.const [187] = Utf8 Lde/esolutions/fw/util/commons/LongList; 
.const [188] = Utf8 storage 
.const [189] = Utf8 Lde/audi/tv/app/storage/LogoListStorage; 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [193] = Utf8 updateLogoMap 
.const [194] = Utf8 ([Lorg/dsi/ifc/tvtuner/LogoInfo;)V 
.const [195] = Utf8 addFavoriteNamePids 
.const [196] = Utf8 ([J)V 
.const [197] = Utf8 removeFavoriteNamePids 
.const [198] = Utf8 ([J)V 
.const [199] = Utf8 saveLogoList 
.const [200] = Utf8 ()V 
.const [201] = Utf8 getLogoForNamePID 
.const [202] = Utf8 (J)Lorg/dsi/ifc/global/ResourceLocator; 
.const [203] = Utf8 resetToDefault 
.const [204] = Utf8 ()V 
.end class 
