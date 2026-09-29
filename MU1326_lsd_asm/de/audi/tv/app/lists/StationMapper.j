.version 50 0 
.class public super [216] 
.super [218] 
.field private final [219] [220] 
.field private [221] [222] 
.field public static final [223] [224] 
.field private static final [225] [226] 
.field private static final [227] [228] 

.method public [230] : [231] 
    .attribute [229] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     lconst_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    new [34] 
L13:    dup 
L14:    sipush 300 
L17:    invokespecial [25] 
L20:    putfield [35] 
L23:    return 
L24:    
    .end code 
.end method 

.method public synchronized [232] : [233] 
    .attribute [229] .code stack 8 locals 3 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_0 
L5:     newarray long 
L7:     areturn 
L8:     aload_1 
L9:     arraylength 
L10:    newarray long 
L12:    astore_2 
L13:    iconst_0 
L14:    istore 4 
L16:    iload 4 
L18:    aload_1 
L19:    arraylength 
L20:    if_icmpge L86 
L23:    aload_1 
L24:    iload 4 
L26:    aaload 
L27:    ifnull L75 
L30:    new [36] 
L33:    dup 
L34:    aload_1 
L35:    iload 4 
L37:    aaload 
L38:    getfield [17] 
L41:    aload_1 
L42:    iload 4 
L44:    aaload 
L45:    getfield [18] 
L48:    aload_1 
L49:    iload 4 
L51:    aaload 
L52:    getfield [19] 
L55:    aload_0 
L56:    getfield [15] 
L59:    invokespecial [26] 
L62:    astore_3 
L63:    aload_2 
L64:    iload 4 
L66:    aload_0 
L67:    aload_3 
L68:    invokespecial [27] 
L71:    lastore 
L72:    goto L80 
L75:    aload_2 
L76:    iload 4 
L78:    lconst_0 
L79:    lastore 
L80:    iinc 4 1 
L83:    goto L16 
L86:    aload_2 
L87:    areturn 
L88:    
    .end code 
.end method 

.method public synchronized [234] : [235] 
    .attribute [229] .code stack 8 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     lconst_0 
L5:     return 
L6:     new [36] 
L9:     dup 
L10:    aload_1 
L11:    getfield [17] 
L14:    aload_1 
L15:    getfield [18] 
L18:    aload_1 
L19:    getfield [19] 
L22:    aload_0 
L23:    getfield [15] 
L26:    invokespecial [26] 
L29:    astore_2 
L30:    aload_0 
L31:    aload_2 
L32:    invokespecial [27] 
L35:    return 
L36:    
    .end code 
.end method 

.method protected synchronized [236] : [237] 
    .attribute [229] .code stack 5 locals 4 
L0:     aconst_null 
L1:     astore_3 
L2:     iconst_0 
L3:     istore 4 
L5:     iload 4 
L7:     aload_0 
L8:     getfield [16] 
L11:    invokeinterface [37] 0 
L16:    if_icmpge L57 
L19:    aload_0 
L20:    getfield [16] 
L23:    iload 4 
L25:    invokeinterface [38] 0 
L30:    checkcast [3] 
L33:    astore 5 
L35:    aload 5 
L37:    getfield [20] 
L40:    lload_1 
L41:    lcmp 
L42:    ifne L51 
L45:    aload 5 
L47:    astore_3 
L48:    goto L57 
L51:    iinc 4 1 
L54:    goto L5 
L57:    aload_3 
L58:    ifnonnull L71 
L61:    new [39] 
L64:    dup 
L65:    ldc [5] 
L67:    invokespecial [28] 
L70:    athrow 
L71:    new [34] 
L74:    dup 
L75:    invokespecial [29] 
L78:    astore 4 
L80:    iconst_0 
L81:    istore 5 
L83:    iload 5 
L85:    aload_0 
L86:    getfield [16] 
L89:    invokeinterface [37] 0 
L94:    if_icmpge L148 
L97:    aload_0 
L98:    getfield [16] 
L101:   iload 5 
L103:   invokeinterface [38] 0 
L108:   checkcast [3] 
L111:   astore 6 
L113:   aload_3 
L114:   aload 6 
L116:   invokevirtual [21] 
L119:   ifeq L142 
L122:   aload 4 
L124:   new [40] 
L127:   dup 
L128:   aload 6 
L130:   getfield [20] 
L133:   invokespecial [30] 
L136:   invokeinterface [41] 0 
L141:   pop 
L142:   iinc 5 1 
L145:   goto L83 
L148:   aload 4 
L150:   aload 4 
L152:   invokeinterface [37] 0 
L157:   anewarray [6] 
L160:   invokeinterface [42] 0 
L165:   checkcast [7] 
L168:   checkcast [7] 
L171:   areturn 
L172:   
    .end code 
.end method 

.method private [238] : [239] 
    .attribute [229] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_1 
L5:     invokeinterface [43] 0 
L10:    ifne L42 
L13:    aload_0 
L14:    getfield [15] 
L17:    lstore_2 
L18:    aload_0 
L19:    getfield [16] 
L22:    aload_1 
L23:    invokeinterface [41] 0 
L28:    pop 
L29:    aload_0 
L30:    dup 
L31:    getfield [15] 
L34:    lconst_1 
L35:    ladd 
L36:    putfield [33] 
L39:    goto L48 
L42:    aload_0 
L43:    aload_1 
L44:    invokespecial [31] 
L47:    lstore_2 
L48:    lload_2 
L49:    freturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [240] : [241] 
    .attribute [229] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokeinterface [44] 0 
L9:     ifeq L22 
L12:    new [45] 
L15:    dup 
L16:    ldc [9] 
L18:    invokespecial [32] 
L21:    athrow 
L22:    aload_0 
L23:    getfield [16] 
L26:    invokeinterface [46] 0 
L31:    astore_2 
L32:    aload_2 
L33:    invokeinterface [47] 0 
L38:    ifeq L67 
L41:    aload_2 
L42:    invokeinterface [48] 0 
L47:    checkcast [3] 
L50:    astore_3 
L51:    aload_3 
L52:    aload_1 
L53:    invokevirtual [22] 
L56:    ifeq L64 
L59:    aload_3 
L60:    getfield [20] 
L63:    freturn 
L64:    goto L32 
L67:    lconst_0 
L68:    freturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method [242] : [243] 
    .attribute [229] .code stack 4 locals 4 
L0:     aload_1 
L1:     arraylength 
L2:     newarray long 
L4:     astore_2 
L5:     iconst_0 
L6:     istore_3 
L7:     iload_3 
L8:     aload_2 
L9:     arraylength 
L10:    if_icmpge L78 
L13:    aload_0 
L14:    getfield [16] 
L17:    invokeinterface [46] 0 
L22:    astore 4 
L24:    aload 4 
L26:    invokeinterface [47] 0 
L31:    ifeq L72 
L34:    aload 4 
L36:    invokeinterface [48] 0 
L41:    checkcast [3] 
L44:    astore 5 
L46:    aload 5 
L48:    getfield [20] 
L51:    aload_1 
L52:    iload_3 
L53:    laload 
L54:    lcmp 
L55:    ifne L69 
L58:    aload_2 
L59:    iload_3 
L60:    aload 5 
L62:    getfield [23] 
L65:    lastore 
L66:    goto L72 
L69:    goto L24 
L72:    iinc 3 1 
L75:    goto L7 
L78:    aload_2 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public static [244] : [245] 
    .attribute [229] .code stack 4 locals 0 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     land 
L5:     l2i 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [246] : [247] 
    .attribute [229] .code stack 4 locals 0 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     land 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [248] : [249] 
    .attribute [229] .code stack 4 locals 0 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     land 
L5:     ldc_w [1] 
L8:     lcmp 
L9:     ifne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [250] : [251] 
    .attribute [229] .code stack 4 locals 0 
L0:     lload_0 
L1:     ldc_w [1] 
L4:     lor 
L5:     freturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = Class [52] 
.const [4] = Class [53] 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Class [56] 
.const [8] = Class [57] 
.const [9] = String [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = Class [61] 
.const [13] = Class [62] 
.const [14] = Class [63] 
.const [15] = Field [64] [65] 
.const [16] = Field [66] [67] 
.const [17] = Field [68] [69] 
.const [18] = Field [70] [71] 
.const [19] = Field [72] [73] 
.const [20] = Field [74] [75] 
.const [21] = Method [76] [77] 
.const [22] = Method [78] [79] 
.const [23] = Field [80] [81] 
.const [24] = Method [82] [83] 
.const [25] = Method [84] [85] 
.const [26] = Method [86] [87] 
.const [27] = Method [88] [89] 
.const [28] = Method [90] [91] 
.const [29] = Method [92] [93] 
.const [30] = Method [94] [95] 
.const [31] = Method [96] [97] 
.const [32] = Method [98] [99] 
.const [33] = Field [100] [101] 
.const [34] = Class [102] 
.const [35] = Field [103] [104] 
.const [36] = Class [105] 
.const [37] = InterfaceMethod [106] [107] 
.const [38] = InterfaceMethod [108] [109] 
.const [39] = Class [110] 
.const [40] = Class [111] 
.const [41] = InterfaceMethod [112] [113] 
.const [42] = InterfaceMethod [114] [115] 
.const [43] = InterfaceMethod [116] [117] 
.const [44] = InterfaceMethod [118] [119] 
.const [45] = Class [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = Int -129 
.const [50] = String [127] 
.const [51] = Utf8 java/util/ArrayList 
.const [52] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [53] = Utf8 java/lang/IllegalArgumentException 
.const [54] = Utf8 "[StationMapper.getNamePidServiceIDs] A unique ID was used that doesn't exist!" 
.const [55] = Utf8 java/lang/Long 
.const [56] = Utf8 [Ljava/lang/Long; 
.const [57] = Utf8 java/lang/IndexOutOfBoundsException 
.const [58] = Utf8 'The list should not be empty for mapping search!' 
.const [59] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [62] = Utf8 java/util/List 
.const [63] = Utf8 java/util/Iterator 
.const [64] = Class [128] 
.const [65] = NameAndType [129] [130] 
.const [66] = Class [131] 
.const [67] = NameAndType [132] [133] 
.const [68] = Class [134] 
.const [69] = NameAndType [135] [136] 
.const [70] = Class [137] 
.const [71] = NameAndType [138] [139] 
.const [72] = Class [140] 
.const [73] = NameAndType [141] [142] 
.const [74] = Class [143] 
.const [75] = NameAndType [144] [145] 
.const [76] = Class [146] 
.const [77] = NameAndType [147] [148] 
.const [78] = Class [149] 
.const [79] = NameAndType [150] [151] 
.const [80] = Class [152] 
.const [81] = NameAndType [153] [154] 
.const [82] = Class [155] 
.const [83] = NameAndType [156] [157] 
.const [84] = Class [158] 
.const [85] = NameAndType [159] [160] 
.const [86] = Class [161] 
.const [87] = NameAndType [162] [163] 
.const [88] = Class [164] 
.const [89] = NameAndType [165] [166] 
.const [90] = Class [167] 
.const [91] = NameAndType [168] [169] 
.const [92] = Class [170] 
.const [93] = NameAndType [171] [172] 
.const [94] = Class [173] 
.const [95] = NameAndType [174] [175] 
.const [96] = Class [176] 
.const [97] = NameAndType [177] [178] 
.const [98] = Class [179] 
.const [99] = NameAndType [180] [181] 
.const [100] = Class [182] 
.const [101] = NameAndType [183] [184] 
.const [102] = Utf8 java/util/ArrayList 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Utf8 java/lang/IllegalArgumentException 
.const [111] = Utf8 java/lang/Long 
.const [112] = Class [194] 
.const [113] = NameAndType [195] [196] 
.const [114] = Class [197] 
.const [115] = NameAndType [198] [199] 
.const [116] = Class [200] 
.const [117] = NameAndType [201] [202] 
.const [118] = Class [203] 
.const [119] = NameAndType [204] [205] 
.const [120] = Utf8 java/lang/IndexOutOfBoundsException 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Utf8 '' 
.const [128] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [129] = Utf8 indexCounter 
.const [130] = Utf8 J 
.const [131] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [132] = Utf8 mappedList 
.const [133] = Utf8 Ljava/util/List; 
.const [134] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [135] = Utf8 namePID 
.const [136] = Utf8 J 
.const [137] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [138] = Utf8 servicePID 
.const [139] = Utf8 I 
.const [140] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [141] = Utf8 sType 
.const [142] = Utf8 I 
.const [143] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [144] = Utf8 mappedID 
.const [145] = Utf8 J 
.const [146] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [147] = Utf8 equalsNamePID 
.const [148] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)Z 
.const [149] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [150] = Utf8 equals 
.const [151] = Utf8 (Ljava/lang/Object;)Z 
.const [152] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [153] = Utf8 namePID 
.const [154] = Utf8 J 
.const [155] = Utf8 java/lang/Object 
.const [156] = Utf8 <init> 
.const [157] = Utf8 ()V 
.const [158] = Utf8 java/util/ArrayList 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 de/audi/tv/app/lists/StationIDMapping 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (JIIJ)V 
.const [164] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [165] = Utf8 checkMapping 
.const [166] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)J 
.const [167] = Utf8 java/lang/IllegalArgumentException 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Ljava/lang/String;)V 
.const [170] = Utf8 java/util/ArrayList 
.const [171] = Utf8 <init> 
.const [172] = Utf8 ()V 
.const [173] = Utf8 java/lang/Long 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (J)V 
.const [176] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [177] = Utf8 getMappingUniqueID 
.const [178] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)J 
.const [179] = Utf8 java/lang/IndexOutOfBoundsException 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;)V 
.const [182] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [183] = Utf8 indexCounter 
.const [184] = Utf8 J 
.const [185] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [186] = Utf8 mappedList 
.const [187] = Utf8 Ljava/util/List; 
.const [188] = Utf8 java/util/List 
.const [189] = Utf8 size 
.const [190] = Utf8 ()I 
.const [191] = Utf8 java/util/List 
.const [192] = Utf8 get 
.const [193] = Utf8 (I)Ljava/lang/Object; 
.const [194] = Utf8 java/util/List 
.const [195] = Utf8 add 
.const [196] = Utf8 (Ljava/lang/Object;)Z 
.const [197] = Utf8 java/util/List 
.const [198] = Utf8 toArray 
.const [199] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [200] = Utf8 java/util/List 
.const [201] = Utf8 contains 
.const [202] = Utf8 (Ljava/lang/Object;)Z 
.const [203] = Utf8 java/util/List 
.const [204] = Utf8 isEmpty 
.const [205] = Utf8 ()Z 
.const [206] = Utf8 java/util/List 
.const [207] = Utf8 iterator 
.const [208] = Utf8 ()Ljava/util/Iterator; 
.const [209] = Utf8 java/util/Iterator 
.const [210] = Utf8 hasNext 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 java/util/Iterator 
.const [213] = Utf8 next 
.const [214] = Utf8 ()Ljava/lang/Object; 
.const [215] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [216] = Class [215] 
.const [217] = Utf8 java/lang/Object 
.const [218] = Class [217] 
.const [219] = Utf8 mappedList 
.const [220] = Utf8 Ljava/util/List; 
.const [221] = Utf8 indexCounter 
.const [222] = Utf8 J 
.const [223] = Utf8 INDEX_FOR_NULL_SERVICES 
.const [224] = Utf8 J 
.const [225] = Utf8 UNIQUE_ID_FILTER 
.const [226] = Utf8 J 
.const [227] = Utf8 FLAG_IS_FAVORITE 
.const [228] = Utf8 J 
.const [229] = Utf8 Code 
.const [230] = Utf8 <init> 
.const [231] = Utf8 ()V 
.const [232] = Utf8 getServicesIDs 
.const [233] = Utf8 ([Lorg/dsi/ifc/tvtuner/ServiceInfo;)[J 
.const [234] = Utf8 getServiceID 
.const [235] = Utf8 (Lorg/dsi/ifc/tvtuner/ServiceInfo;)J 
.const [236] = Utf8 getMatchingNamePidServiceIDs 
.const [237] = Utf8 (J)[Ljava/lang/Long; 
.const [238] = Utf8 checkMapping 
.const [239] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)J 
.const [240] = Utf8 getMappingUniqueID 
.const [241] = Utf8 (Lde/audi/tv/app/lists/StationIDMapping;)J 
.const [242] = Utf8 getNamePidForUniqueIds 
.const [243] = Utf8 ([J)[J 
.const [244] = Utf8 getCombiID 
.const [245] = Utf8 (J)I 
.const [246] = Utf8 getPureUniqueID 
.const [247] = Utf8 (J)J 
.const [248] = Utf8 isFavorite 
.const [249] = Utf8 (J)Z 
.const [250] = Utf8 flagUniqueIDAsFavorite 
.const [251] = Utf8 (J)J 
.end class 
