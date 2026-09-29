.version 50 0 
.class public super [174] 
.super [176] 
.field private static final [177] [178] 
.field private final [179] [180] 
.field private final [181] [182] 
.field private final [183] [184] 
.field private [185] [186] 

.method public [188] : [189] 
    .attribute [187] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     new [26] 
L8:     dup 
L9:     invokespecial [21] 
L12:    putfield [27] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [28] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [29] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [187] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [30] 
L5:     dup 
L6:     invokespecial [22] 
L9:     invokespecial [23] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [192] : [193] 
    .attribute [187] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     new [26] 
L8:     dup 
L9:     invokespecial [21] 
L12:    putfield [27] 
L15:    aload_0 
L16:    aload_1 
L17:    getfield [17] 
L20:    putfield [28] 
L23:    aload_0 
L24:    aload_1 
L25:    getfield [19] 
L28:    putfield [31] 
L31:    aload_0 
L32:    new [30] 
L35:    dup 
L36:    aload_1 
L37:    getfield [18] 
L40:    invokespecial [24] 
L43:    putfield [29] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [187] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L48 using L53 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [18] 
L25:    aload_1 
L26:    invokeinterface [32] 0 
L31:    ifne L49 
L34:    aload_0 
L35:    getfield [18] 
L38:    aload_1 
L39:    invokeinterface [33] 0 
L44:    pop 
L45:    iconst_1 
L46:    aload_2 
L47:    monitorexit 
L48:    areturn 
        .catch [0] from L49 to L52 using L53 
L49:    iconst_0 
L50:    aload_2 
L51:    monitorexit 
L52:    areturn 
        .catch [0] from L53 to L56 using L53 
L53:    astore_3 
L54:    aload_2 
L55:    monitorexit 
L56:    aload_3 
L57:    athrow 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [187] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L34 using L37 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [7] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [18] 
L25:    aload_1 
L26:    invokeinterface [34] 0 
L31:    pop 
L32:    aload_2 
L33:    monitorexit 
L34:    goto L42 
        .catch [0] from L37 to L40 using L37 
L37:    astore_3 
L38:    aload_2 
L39:    monitorexit 
L40:    aload_3 
L41:    athrow 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [187] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L50 using L53 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [8] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [18] 
L25:    aload_1 
L26:    invokeinterface [35] 0 
L31:    istore_3 
L32:    iload_3 
L33:    iflt L48 
L36:    aload_0 
L37:    getfield [18] 
L40:    iload_3 
L41:    aload_1 
L42:    invokeinterface [36] 0 
L47:    pop 
L48:    aload_2 
L49:    monitorexit 
L50:    goto L60 
        .catch [0] from L53 to L57 using L53 
L53:    astore 4 
L55:    aload_2 
L56:    monitorexit 
L57:    aload 4 
L59:    athrow 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [187] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L43 using L46 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [9] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [18] 
L25:    iload_2 
L26:    aload_0 
L27:    getfield [18] 
L30:    iload_1 
L31:    invokeinterface [37] 0 
L36:    invokeinterface [38] 0 
L41:    aload_3 
L42:    monitorexit 
L43:    goto L53 
        .catch [0] from L46 to L50 using L46 
L46:    astore 4 
L48:    aload_3 
L49:    monitorexit 
L50:    aload 4 
L52:    athrow 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [187] .code stack 2 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [16] 
L6:     dup 
L7:     astore_2 
L8:     monitorenter 
        .catch [0] from L9 to L21 using L24 
L9:     aload_0 
L10:    getfield [18] 
L13:    invokeinterface [39] 0 
L18:    istore_1 
L19:    aload_2 
L20:    monitorexit 
L21:    goto L29 
        .catch [0] from L24 to L27 using L24 
L24:    astore_3 
L25:    aload_2 
L26:    monitorexit 
L27:    aload_3 
L28:    athrow 
L29:    iload_1 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [187] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L22 using L23 
L7:     aload_0 
L8:     getfield [18] 
L11:    iload_1 
L12:    invokeinterface [40] 0 
L17:    checkcast [10] 
L20:    aload_2 
L21:    monitorexit 
L22:    areturn 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [187] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L21 
L7:     new [30] 
L10:    dup 
L11:    aload_0 
L12:    getfield [18] 
L15:    invokespecial [24] 
L18:    aload_1 
L19:    monitorexit 
L20:    areturn 
        .catch [0] from L21 to L24 using L21 
L21:    astore_2 
L22:    aload_1 
L23:    monitorexit 
L24:    aload_2 
L25:    athrow 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [187] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L17 using L18 
L7:     new [41] 
L10:    dup 
L11:    aload_0 
L12:    invokespecial [25] 
L15:    aload_1 
L16:    monitorexit 
L17:    areturn 
        .catch [0] from L18 to L21 using L18 
L18:    astore_2 
L19:    aload_1 
L20:    monitorexit 
L21:    aload_2 
L22:    athrow 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [187] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L28 using L31 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [12] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    aload_1 
L23:    putfield [31] 
L26:    aload_2 
L27:    monitorexit 
L28:    goto L36 
        .catch [0] from L31 to L34 using L31 
L31:    astore_3 
L32:    aload_2 
L33:    monitorexit 
L34:    aload_3 
L35:    athrow 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [187] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L34 using L35 
L7:     aload_0 
L8:     getfield [17] 
L11:    ldc [4] 
L13:    ldc [13] 
L15:    ldc [6] 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [19] 
L25:    astore_2 
L26:    aload_0 
L27:    aconst_null 
L28:    putfield [31] 
L31:    aload_2 
L32:    aload_1 
L33:    monitorexit 
L34:    areturn 
        .catch [0] from L35 to L38 using L35 
L35:    astore_3 
L36:    aload_1 
L37:    monitorexit 
L38:    aload_3 
L39:    athrow 
L40:    
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [187] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L21 using L22 
L7:     aload_0 
L8:     getfield [19] 
L11:    ifnull L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    aload_1 
L20:    monitorexit 
L21:    areturn 
        .catch [0] from L22 to L25 using L22 
L22:    astore_2 
L23:    aload_1 
L24:    monitorexit 
L25:    aload_2 
L26:    athrow 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Class [43] 
.const [4] = Int 1078071040 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = String [46] 
.const [8] = String [47] 
.const [9] = String [48] 
.const [10] = Class [49] 
.const [11] = Class [50] 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Field [59] [60] 
.const [19] = Field [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Class [75] 
.const [27] = Field [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = Class [82] 
.const [31] = Field [83] [84] 
.const [32] = InterfaceMethod [85] [86] 
.const [33] = InterfaceMethod [87] [88] 
.const [34] = InterfaceMethod [89] [90] 
.const [35] = InterfaceMethod [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = Class [103] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 java/util/ArrayList 
.const [44] = Utf8 '[%1.addFavorite]' 
.const [45] = Utf8 FavoritesList 
.const [46] = Utf8 '[%1.removeFavorite]' 
.const [47] = Utf8 '[%1.updateFavorite]' 
.const [48] = Utf8 '[%1.moveFavorite]' 
.const [49] = Utf8 de/audi/app/media/evo/content/data/favorites/MediaFavorite 
.const [50] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [51] = Utf8 '[%1.addTrigger]' 
.const [52] = Utf8 '[%1.getAndRemoveTrigger]' 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 java/util/List 
.const [55] = Class [104] 
.const [56] = NameAndType [105] [106] 
.const [57] = Class [107] 
.const [58] = NameAndType [108] [109] 
.const [59] = Class [110] 
.const [60] = NameAndType [111] [112] 
.const [61] = Class [113] 
.const [62] = NameAndType [114] [115] 
.const [63] = Class [116] 
.const [64] = NameAndType [117] [118] 
.const [65] = Class [119] 
.const [66] = NameAndType [120] [121] 
.const [67] = Class [122] 
.const [68] = NameAndType [123] [124] 
.const [69] = Class [125] 
.const [70] = NameAndType [126] [127] 
.const [71] = Class [128] 
.const [72] = NameAndType [129] [130] 
.const [73] = Class [131] 
.const [74] = NameAndType [132] [133] 
.const [75] = Utf8 java/lang/Object 
.const [76] = Class [134] 
.const [77] = NameAndType [135] [136] 
.const [78] = Class [137] 
.const [79] = NameAndType [138] [139] 
.const [80] = Class [140] 
.const [81] = NameAndType [141] [142] 
.const [82] = Utf8 java/util/ArrayList 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Class [152] 
.const [90] = NameAndType [153] [154] 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Class [164] 
.const [98] = NameAndType [165] [166] 
.const [99] = Class [167] 
.const [100] = NameAndType [168] [169] 
.const [101] = Class [170] 
.const [102] = NameAndType [171] [172] 
.const [103] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [104] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [105] = Utf8 listMutex 
.const [106] = Utf8 Ljava/lang/Object; 
.const [107] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [108] = Utf8 logger 
.const [109] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [110] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [111] = Utf8 mediaFavorites 
.const [112] = Utf8 Ljava/util/List; 
.const [113] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [114] = Utf8 trigger 
.const [115] = Utf8 Lde/audi/atip/hmi/model/update/ModelTrigger; 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 java/util/ArrayList 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/util/List;)V 
.const [128] = Utf8 java/util/ArrayList 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/util/Collection;)V 
.const [131] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/FavoritesList;)V 
.const [134] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [135] = Utf8 listMutex 
.const [136] = Utf8 Ljava/lang/Object; 
.const [137] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [138] = Utf8 logger 
.const [139] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [141] = Utf8 mediaFavorites 
.const [142] = Utf8 Ljava/util/List; 
.const [143] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [144] = Utf8 trigger 
.const [145] = Utf8 Lde/audi/atip/hmi/model/update/ModelTrigger; 
.const [146] = Utf8 java/util/List 
.const [147] = Utf8 contains 
.const [148] = Utf8 (Ljava/lang/Object;)Z 
.const [149] = Utf8 java/util/List 
.const [150] = Utf8 add 
.const [151] = Utf8 (Ljava/lang/Object;)Z 
.const [152] = Utf8 java/util/List 
.const [153] = Utf8 remove 
.const [154] = Utf8 (Ljava/lang/Object;)Z 
.const [155] = Utf8 java/util/List 
.const [156] = Utf8 indexOf 
.const [157] = Utf8 (Ljava/lang/Object;)I 
.const [158] = Utf8 java/util/List 
.const [159] = Utf8 set 
.const [160] = Utf8 (ILjava/lang/Object;)Ljava/lang/Object; 
.const [161] = Utf8 java/util/List 
.const [162] = Utf8 remove 
.const [163] = Utf8 (I)Ljava/lang/Object; 
.const [164] = Utf8 java/util/List 
.const [165] = Utf8 add 
.const [166] = Utf8 (ILjava/lang/Object;)V 
.const [167] = Utf8 java/util/List 
.const [168] = Utf8 size 
.const [169] = Utf8 ()I 
.const [170] = Utf8 java/util/List 
.const [171] = Utf8 get 
.const [172] = Utf8 (I)Ljava/lang/Object; 
.const [173] = Utf8 de/audi/app/media/evo/content/data/favorites/FavoritesList 
.const [174] = Class [173] 
.const [175] = Utf8 java/lang/Object 
.const [176] = Class [175] 
.const [177] = Utf8 LOGCLASS 
.const [178] = Utf8 Ljava/lang/String; 
.const [179] = Utf8 logger 
.const [180] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [181] = Utf8 mediaFavorites 
.const [182] = Utf8 Ljava/util/List; 
.const [183] = Utf8 listMutex 
.const [184] = Utf8 Ljava/lang/Object; 
.const [185] = Utf8 trigger 
.const [186] = Utf8 Lde/audi/atip/hmi/model/update/ModelTrigger; 
.const [187] = Utf8 Code 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/util/List;)V 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/FavoritesList;)V 
.const [194] = Utf8 addFavorite 
.const [195] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/MediaFavorite;)Z 
.const [196] = Utf8 removeFavorite 
.const [197] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/MediaFavorite;)V 
.const [198] = Utf8 updateFavorite 
.const [199] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/MediaFavorite;)V 
.const [200] = Utf8 moveFavorite 
.const [201] = Utf8 (II)V 
.const [202] = Utf8 getListSize 
.const [203] = Utf8 ()I 
.const [204] = Utf8 getFavorite 
.const [205] = Utf8 (I)Lde/audi/app/media/evo/content/data/favorites/MediaFavorite; 
.const [206] = Utf8 getFavoritesList 
.const [207] = Utf8 ()Ljava/util/List; 
.const [208] = Utf8 getCopy 
.const [209] = Utf8 ()Lde/audi/app/media/evo/content/data/favorites/FavoritesList; 
.const [210] = Utf8 addTrigger 
.const [211] = Utf8 (Lde/audi/atip/hmi/model/update/ModelTrigger;)V 
.const [212] = Utf8 getAndRemoveTrigger 
.const [213] = Utf8 ()Lde/audi/atip/hmi/model/update/ModelTrigger; 
.const [214] = Utf8 isTriggerAvailable 
.const [215] = Utf8 ()Z 
.end class 
