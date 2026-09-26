.version 50 0 
.class public super [179] 
.super [181] 
.field private final [182] [183] 
.field private [184] [185] 

.method public [187] : [188] 
    .attribute [186] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iload 4 
L6:     invokespecial [42] 
L9:     aload_0 
L10:    aload 5 
L12:    putfield [45] 
L15:    return 
L16:    
    .end code 
.end method 

.method [189] : [190] 
    .attribute [186] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     ifnull L9 
L5:     aload_1 
L6:     goto L13 
L9:     iconst_0 
L10:    anewarray [2] 
L13:    putfield [46] 
L16:    aload_0 
L17:    getfield [26] 
L20:    invokevirtual [28] 
L23:    ifeq L63 
L26:    iconst_0 
L27:    istore_2 
L28:    iload_2 
L29:    aload_0 
L30:    getfield [27] 
L33:    arraylength 
L34:    if_icmpge L63 
L37:    aload_0 
L38:    getfield [26] 
L41:    ldc [3] 
L43:    ldc [4] 
L45:    aload_0 
L46:    getfield [27] 
L49:    iload_2 
L50:    aaload 
L51:    iload_2 
L52:    i2l 
L53:    invokevirtual [29] 
L56:    pop 
L57:    iinc 2 1 
L60:    goto L28 
L63:    aload_0 
L64:    invokevirtual [30] 
L67:    aload_0 
L68:    getfield [26] 
L71:    ldc [3] 
L73:    ldc [5] 
L75:    aload_0 
L76:    invokevirtual [31] 
L79:    i2l 
L80:    invokevirtual [32] 
L83:    pop 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method [191] : [192] 
    .attribute [186] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     aload_0 
L5:     getfield [26] 
L8:     invokevirtual [28] 
L11:    ifeq L58 
L14:    aload_0 
L15:    getfield [27] 
L18:    ifnull L58 
L21:    iconst_0 
L22:    istore_1 
L23:    iload_1 
L24:    aload_0 
L25:    getfield [27] 
L28:    arraylength 
L29:    if_icmpge L58 
L32:    aload_0 
L33:    getfield [26] 
L36:    ldc [3] 
L38:    ldc [6] 
L40:    aload_0 
L41:    getfield [27] 
L44:    iload_1 
L45:    aaload 
L46:    iload_1 
L47:    i2l 
L48:    invokevirtual [29] 
L51:    pop 
L52:    iinc 1 1 
L55:    goto L23 
L58:    aload_0 
L59:    getfield [26] 
L62:    ldc [3] 
L64:    ldc [7] 
L66:    aload_0 
L67:    invokevirtual [31] 
L70:    i2l 
L71:    invokevirtual [32] 
L74:    pop 
L75:    aload_0 
L76:    getfield [27] 
L79:    areturn 
L80:    
    .end code 
.end method 

.method protected [193] : [194] 
    .attribute [186] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected enum [195] : [196] 
    .attribute [186] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [197] : [198] 
    .attribute [186] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [8] 
L6:     ldc [10] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [35] 
L15:    pop 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [199] : [200] 
    .attribute [186] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [27] 
L4:     arraylength 
L5:     istore_2 
L6:     aload_0 
L7:     getfield [26] 
L10:    ldc [3] 
L12:    ldc [11] 
L14:    iload_2 
L15:    i2l 
L16:    invokevirtual [32] 
L19:    pop 
L20:    aload_1 
L21:    iload_2 
L22:    invokevirtual [36] 
L25:    new [47] 
L28:    dup 
L29:    aload_1 
L30:    invokespecial [43] 
L33:    astore_3 
L34:    iconst_0 
L35:    istore 4 
L37:    iload 4 
L39:    aload_0 
L40:    getfield [27] 
L43:    arraylength 
L44:    if_icmpge L82 
L47:    aload_0 
L48:    getfield [27] 
L51:    iload 4 
L53:    aaload 
L54:    astore 5 
L56:    aload_0 
L57:    getfield [26] 
L60:    ldc [3] 
L62:    ldc [13] 
L64:    aload 5 
L66:    invokevirtual [37] 
L69:    pop 
L70:    aload_3 
L71:    aload 5 
L73:    invokevirtual [38] 
L76:    iinc 4 1 
L79:    goto L37 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method protected [201] : [202] 
    .attribute [186] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [14] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    aload_1 
L13:    invokevirtual [39] 
L16:    istore_2 
L17:    aload_0 
L18:    getfield [26] 
L21:    ldc [3] 
L23:    ldc [15] 
L25:    iload_2 
L26:    i2l 
L27:    invokevirtual [32] 
L30:    pop 
L31:    iload_2 
L32:    iflt L41 
L35:    iload_2 
L36:    bipush 50 
L38:    if_icmple L57 
L41:    aload_0 
L42:    getfield [26] 
L45:    sipush 10000 
L48:    ldc [16] 
L50:    iload_2 
L51:    i2l 
L52:    invokevirtual [32] 
L55:    pop 
L56:    return 
L57:    aload_0 
L58:    iload_2 
L59:    anewarray [2] 
L62:    putfield [46] 
L65:    new [48] 
L68:    dup 
L69:    aload_1 
L70:    invokespecial [44] 
L73:    astore_3 
L74:    iconst_0 
L75:    istore 4 
L77:    iload 4 
L79:    iload_2 
L80:    if_icmpge L141 
        .catch [19] from L83 to L115 using L118 
L83:    aload_3 
L84:    invokevirtual [40] 
L87:    checkcast [2] 
L90:    astore 5 
L92:    aload_0 
L93:    getfield [26] 
L96:    ldc [3] 
L98:    ldc [18] 
L100:   aload 5 
L102:   invokevirtual [37] 
L105:   pop 
L106:   aload_0 
L107:   getfield [27] 
L110:   iload 4 
L112:   aload 5 
L114:   aastore 
L115:   goto L135 
L118:   astore 5 
L120:   aload_0 
L121:   getfield [26] 
L124:   sipush 10000 
L127:   ldc [20] 
L129:   aload 5 
L131:   invokevirtual [41] 
L134:   pop 
L135:   iinc 4 1 
L138:   goto L77 
L141:   return 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = Int -2137614336 
.const [4] = String [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = String [53] 
.const [8] = Int -1601830656 
.const [9] = String [54] 
.const [10] = String [55] 
.const [11] = String [56] 
.const [12] = Class [57] 
.const [13] = String [58] 
.const [14] = String [59] 
.const [15] = String [60] 
.const [16] = String [61] 
.const [17] = Class [62] 
.const [18] = String [63] 
.const [19] = Class [64] 
.const [20] = String [65] 
.const [21] = Class [66] 
.const [22] = Class [67] 
.const [23] = Class [68] 
.const [24] = Class [69] 
.const [25] = Class [70] 
.const [26] = Field [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Method [93] [94] 
.const [38] = Method [95] [96] 
.const [39] = Method [97] [98] 
.const [40] = Method [99] [100] 
.const [41] = Method [101] [102] 
.const [42] = Method [103] [104] 
.const [43] = Method [105] [106] 
.const [44] = Method [107] [108] 
.const [45] = Field [109] [110] 
.const [46] = Field [111] [112] 
.const [47] = Class [113] 
.const [48] = Class [114] 
.const [49] = Utf8 de/audi/atip/favorite/IFavoriteStorage 
.const [50] = Utf8 '[FavoritePersistenceHandlerBase#storeFavorites] favorites[%2] %1' 
.const [51] = Utf8 '[FavoritePersistenceHandlerBase#storeFavorites] favorite size: %1' 
.const [52] = Utf8 '[FavoritePersistenceHandlerBase#readFavorites] favorites[%2] %1' 
.const [53] = Utf8 '[FavoritePersistenceHandlerBase#readFavorites] favorite size: %1' 
.const [54] = Utf8 '[FavoritePersistenceHandlerBase#handleCRC32Error]' 
.const [55] = Utf8 '[FavoritePersistenceHandlerBase#convertContainer] persistedVersion=%1, containerVersion=%2' 
.const [56] = Utf8 '[FavoritePersistenceHandlerBase#serialize] favoritesLength=%1' 
.const [57] = Utf8 java/io/ObjectOutputStream 
.const [58] = Utf8 '[FavoritePersistenceHandlerBase#serialize] favorite=%1' 
.const [59] = Utf8 '[FavoritePersistenceHandlerBase#deserialize]' 
.const [60] = Utf8 '[FavoritePersistenceHandlerBase#deserialize] arrayLength=%1' 
.const [61] = Utf8 '[FavoritePersistenceHandlerBase#deserialize] array length not valid: %1' 
.const [62] = Utf8 java/io/ObjectInputStream 
.const [63] = Utf8 '[FavoritePersistenceHandlerBase#deserialize] favorite=%1' 
.const [64] = Utf8 java/lang/ClassNotFoundException 
.const [65] = Utf8 '[FavoritePersistenceHandlerBase#deserialize] %1' 
.const [66] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [67] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 java/io/DataOutputStream 
.const [70] = Utf8 java/io/DataInputStream 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Class [121] 
.const [76] = NameAndType [122] [123] 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Class [127] 
.const [80] = NameAndType [128] [129] 
.const [81] = Class [130] 
.const [82] = NameAndType [131] [132] 
.const [83] = Class [133] 
.const [84] = NameAndType [134] [135] 
.const [85] = Class [136] 
.const [86] = NameAndType [137] [138] 
.const [87] = Class [139] 
.const [88] = NameAndType [140] [141] 
.const [89] = Class [142] 
.const [90] = NameAndType [143] [144] 
.const [91] = Class [145] 
.const [92] = NameAndType [146] [147] 
.const [93] = Class [148] 
.const [94] = NameAndType [149] [150] 
.const [95] = Class [151] 
.const [96] = NameAndType [152] [153] 
.const [97] = Class [154] 
.const [98] = NameAndType [155] [156] 
.const [99] = Class [157] 
.const [100] = NameAndType [158] [159] 
.const [101] = Class [160] 
.const [102] = NameAndType [161] [162] 
.const [103] = Class [163] 
.const [104] = NameAndType [164] [165] 
.const [105] = Class [166] 
.const [106] = NameAndType [167] [168] 
.const [107] = Class [169] 
.const [108] = NameAndType [170] [171] 
.const [109] = Class [172] 
.const [110] = NameAndType [173] [174] 
.const [111] = Class [175] 
.const [112] = NameAndType [176] [177] 
.const [113] = Utf8 java/io/ObjectOutputStream 
.const [114] = Utf8 java/io/ObjectInputStream 
.const [115] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [116] = Utf8 log 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [119] = Utf8 favorites 
.const [120] = Utf8 [Lde/audi/atip/favorite/IFavoriteStorage; 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 isDebug 
.const [123] = Utf8 ()Z 
.const [124] = Utf8 de/audi/atip/log/LogChannel 
.const [125] = Utf8 log 
.const [126] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [127] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [128] = Utf8 serializeAndWrite 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [131] = Utf8 getSize 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;J)Z 
.const [136] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [137] = Utf8 readAndDeserialize 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/atip/log/LogChannel 
.const [140] = Utf8 log 
.const [141] = Utf8 (ILjava/lang/String;)Z 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;JJ)Z 
.const [145] = Utf8 java/io/DataOutputStream 
.const [146] = Utf8 writeInt 
.const [147] = Utf8 (I)V 
.const [148] = Utf8 de/audi/atip/log/LogChannel 
.const [149] = Utf8 log 
.const [150] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [151] = Utf8 java/io/ObjectOutputStream 
.const [152] = Utf8 writeObject 
.const [153] = Utf8 (Ljava/lang/Object;)V 
.const [154] = Utf8 java/io/DataInputStream 
.const [155] = Utf8 readInt 
.const [156] = Utf8 ()I 
.const [157] = Utf8 java/io/ObjectInputStream 
.const [158] = Utf8 readObject 
.const [159] = Utf8 ()Ljava/lang/Object; 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [163] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [166] = Utf8 java/io/ObjectOutputStream 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Ljava/io/OutputStream;)V 
.const [169] = Utf8 java/io/ObjectInputStream 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Ljava/io/InputStream;)V 
.const [172] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [173] = Utf8 log 
.const [174] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [175] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [176] = Utf8 favorites 
.const [177] = Utf8 [Lde/audi/atip/favorite/IFavoriteStorage; 
.const [178] = Utf8 de/audi/atip/favorite/FavoritePersistenceHandlerBase 
.const [179] = Class [178] 
.const [180] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [181] = Class [180] 
.const [182] = Utf8 log 
.const [183] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [184] = Utf8 favorites 
.const [185] = Utf8 [Lde/audi/atip/favorite/IFavoriteStorage; 
.const [186] = Utf8 Code 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [189] = Utf8 storeFavorites 
.const [190] = Utf8 ([Lde/audi/atip/favorite/IFavoriteStorage;)V 
.const [191] = Utf8 readFavorites 
.const [192] = Utf8 ()[Lde/audi/atip/favorite/IFavoriteStorage; 
.const [193] = Utf8 handleCRC32Error 
.const [194] = Utf8 ()V 
.const [195] = Utf8 handleStorageReadError 
.const [196] = Utf8 (Ljava/lang/Exception;)V 
.const [197] = Utf8 convertContainer 
.const [198] = Utf8 (IILjava/io/DataInputStream;)V 
.const [199] = Utf8 serialize 
.const [200] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [201] = Utf8 deserialize 
.const [202] = Utf8 (Ljava/io/DataInputStream;)V 
.end class 
