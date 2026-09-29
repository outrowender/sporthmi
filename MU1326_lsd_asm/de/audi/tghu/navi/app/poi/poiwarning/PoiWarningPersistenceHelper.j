.version 50 0 
.class public super [175] 
.super [177] 
.field private final [178] [179] 
.field private final [180] [181] 
.field private final [182] [183] 

.method public [185] : [186] 
    .attribute [184] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [34] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [35] 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [18] 
L19:    putfield [36] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [184] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [17] 
L12:    i2l 
L13:    invokevirtual [20] 
L16:    pop 
L17:    aload_0 
L18:    getfield [16] 
L21:    invokevirtual [21] 
L24:    invokeinterface [37] 0 
L29:    astore_2 
L30:    new [38] 
L33:    dup 
L34:    aload_2 
L35:    aload_0 
L36:    getfield [19] 
L39:    aload_0 
L40:    getfield [17] 
L43:    invokespecial [32] 
L46:    astore_3 
L47:    aload_3 
L48:    aload_1 
L49:    invokevirtual [22] 
L52:    aload_3 
L53:    invokevirtual [23] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [184] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [17] 
L12:    i2l 
L13:    invokevirtual [20] 
L16:    pop 
L17:    aload_0 
L18:    aload_0 
L19:    aload_1 
L20:    invokespecial [33] 
L23:    invokevirtual [24] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [191] : [192] 
    .attribute [184] .code stack 3 locals 3 
L0:     aload_1 
L1:     invokevirtual [25] 
L4:     newarray int 
L6:     astore_2 
L7:     aload_1 
L8:     invokevirtual [26] 
L11:    astore_3 
L12:    iconst_0 
L13:    istore 4 
L15:    aload_3 
L16:    invokeinterface [39] 0 
L21:    ifeq L46 
L24:    aload_2 
L25:    iload 4 
L27:    aload_3 
L28:    invokeinterface [40] 0 
L33:    checkcast [6] 
L36:    invokevirtual [27] 
L39:    iastore 
L40:    iinc 4 1 
L43:    goto L15 
L46:    aload_2 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [184] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [28] 
L7:     ifeq L27 
L10:    aload_0 
L11:    getfield [19] 
L14:    ldc [7] 
L16:    ldc [8] 
L18:    aload_0 
L19:    getfield [17] 
L22:    i2l 
L23:    invokevirtual [20] 
L26:    pop 
L27:    aload_0 
L28:    getfield [16] 
L31:    invokevirtual [21] 
L34:    invokeinterface [37] 0 
L39:    astore_1 
L40:    aload_1 
L41:    ifnonnull L52 
L44:    iconst_1 
L45:    newarray int 
L47:    dup 
L48:    iconst_0 
L49:    iconst_m1 
L50:    iastore 
L51:    areturn 
L52:    new [38] 
L55:    dup 
L56:    aload_1 
L57:    aload_0 
L58:    getfield [19] 
L61:    aload_0 
L62:    getfield [17] 
L65:    invokespecial [32] 
L68:    astore_2 
L69:    aload_2 
L70:    invokevirtual [29] 
L73:    aload_2 
L74:    invokevirtual [30] 
L77:    ifnull L85 
L80:    aload_2 
L81:    invokevirtual [30] 
L84:    areturn 
L85:    iconst_1 
L86:    newarray int 
L88:    dup 
L89:    iconst_0 
L90:    iconst_m1 
L91:    iastore 
L92:    areturn 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [41] 
.const [4] = Class [42] 
.const [5] = String [43] 
.const [6] = Class [44] 
.const [7] = Int 14808325 
.const [8] = String [45] 
.const [9] = Class [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Field [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Field [89] [90] 
.const [35] = Field [91] [92] 
.const [36] = Field [93] [94] 
.const [37] = InterfaceMethod [95] [96] 
.const [38] = Class [97] 
.const [39] = InterfaceMethod [98] [99] 
.const [40] = InterfaceMethod [100] [101] 
.const [41] = Utf8 'PoiWarningPersistenceHelper#saveItems(int[]) - for key: %1' 
.const [42] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [43] = Utf8 'PoiWarningPersistenceHelper#saveItems(LinkedList) - for key: %1' 
.const [44] = Utf8 java/lang/Integer 
.const [45] = Utf8 'PoiWarningPersistenceHelper#loadItems() - for key: %1' 
.const [46] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [51] = Utf8 java/util/LinkedList 
.const [52] = Utf8 java/util/Iterator 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [103] = Utf8 env 
.const [104] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [105] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [106] = Utf8 key 
.const [107] = Utf8 I 
.const [108] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [109] = Utf8 getPoiApproachWarningLogChannel 
.const [110] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [112] = Utf8 logChannel 
.const [113] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;J)Z 
.const [117] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [118] = Utf8 getFramework 
.const [119] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [120] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [121] = Utf8 setSelectedPoiCategories 
.const [122] = Utf8 ([I)V 
.const [123] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [124] = Utf8 serializeAndWrite 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [127] = Utf8 saveItems 
.const [128] = Utf8 ([I)V 
.const [129] = Utf8 java/util/LinkedList 
.const [130] = Utf8 size 
.const [131] = Utf8 ()I 
.const [132] = Utf8 java/util/LinkedList 
.const [133] = Utf8 iterator 
.const [134] = Utf8 ()Ljava/util/Iterator; 
.const [135] = Utf8 java/lang/Integer 
.const [136] = Utf8 intValue 
.const [137] = Utf8 ()I 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 isDebug2 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [142] = Utf8 readAndDeserialize 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [145] = Utf8 getSelectedPoiCategories 
.const [146] = Utf8 ()[I 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;I)V 
.const [153] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [154] = Utf8 convertLinkedListToArray 
.const [155] = Utf8 (Ljava/util/LinkedList;)[I 
.const [156] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [157] = Utf8 env 
.const [158] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [159] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [160] = Utf8 key 
.const [161] = Utf8 I 
.const [162] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [163] = Utf8 logChannel 
.const [164] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [166] = Utf8 getStorageMgr 
.const [167] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [168] = Utf8 java/util/Iterator 
.const [169] = Utf8 hasNext 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 java/util/Iterator 
.const [172] = Utf8 next 
.const [173] = Utf8 ()Ljava/lang/Object; 
.const [174] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper 
.const [175] = Class [174] 
.const [176] = Utf8 java/lang/Object 
.const [177] = Class [176] 
.const [178] = Utf8 env 
.const [179] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [180] = Utf8 logChannel 
.const [181] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [182] = Utf8 key 
.const [183] = Utf8 I 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;I)V 
.const [187] = Utf8 saveItems 
.const [188] = Utf8 ([I)V 
.const [189] = Utf8 saveItems 
.const [190] = Utf8 (Ljava/util/LinkedList;)V 
.const [191] = Utf8 convertLinkedListToArray 
.const [192] = Utf8 (Ljava/util/LinkedList;)[I 
.const [193] = Utf8 loadItems 
.const [194] = Utf8 ()[I 
.end class 
