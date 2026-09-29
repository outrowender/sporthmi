.version 50 0 
.class public super [193] 
.super [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 
.field private [200] [201] 
.field private [202] [203] 
.field private [204] [205] 
.field private [206] [207] 

.method public [209] : [210] 
    .attribute [208] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [40] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [41] 
L14:    aload_0 
L15:    new [42] 
L18:    dup 
L19:    new [43] 
L22:    dup 
L23:    invokespecial [35] 
L26:    invokespecial [36] 
L29:    putfield [40] 
L32:    aload_0 
L33:    new [44] 
L36:    dup 
L37:    bipush 32 
L39:    invokespecial [37] 
L42:    putfield [41] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [208] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [45] 
L5:     aload_0 
L6:     aconst_null 
L7:     putfield [46] 
L10:    aload_1 
L11:    ifnonnull L25 
L14:    getstatic [5] 
L17:    ldc [6] 
L19:    ldc [7] 
L21:    invokevirtual [28] 
L24:    pop 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [208] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L22 
L7:     aload_0 
L8:     getfield [26] 
L11:    arraylength 
L12:    ifle L22 
L15:    aload_0 
L16:    getfield [26] 
L19:    iconst_0 
L20:    iaload 
L21:    areturn 
L22:    getstatic [5] 
L25:    ldc [6] 
L27:    ldc [8] 
L29:    invokevirtual [28] 
L32:    pop 
L33:    iconst_m1 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [208] .code stack 2 locals 1 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [27] 
L6:     ifnonnull L29 
L9:     aload_0 
L10:    getfield [24] 
L13:    aload_0 
L14:    getfield [26] 
L17:    invokeinterface [47] 0 
L22:    checkcast [9] 
L25:    astore_1 
L26:    goto L37 
L29:    aload_0 
L30:    getfield [27] 
L33:    invokevirtual [29] 
L36:    astore_1 
L37:    aload_1 
L38:    ifnull L48 
L41:    aload_0 
L42:    aload_1 
L43:    putfield [46] 
L46:    aload_1 
L47:    areturn 
L48:    aconst_null 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [208] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifnonnull L24 
L7:     aload_0 
L8:     getfield [24] 
L11:    aload_0 
L12:    getfield [26] 
L15:    invokeinterface [47] 0 
L20:    checkcast [9] 
L23:    areturn 
L24:    aload_0 
L25:    getfield [27] 
L28:    invokevirtual [29] 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [208] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [46] 
L5:     aload_0 
L6:     aload_1 
L7:     putfield [45] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [208] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [26] 
L5:     aload_1 
L6:     invokespecial [38] 
L9:     ifne L27 
L12:    getstatic [5] 
L15:    ldc [6] 
L17:    ldc [10] 
L19:    aload_1 
L20:    aload_0 
L21:    getfield [26] 
L24:    invokevirtual [30] 
L27:    aload_0 
L28:    aconst_null 
L29:    putfield [46] 
L32:    aload_0 
L33:    aconst_null 
L34:    putfield [45] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [223] : [224] 
    .attribute [208] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L14 
L4:     aload_2 
L5:     ifnonnull L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    aload_2 
L15:    ifnonnull L20 
L18:    iconst_0 
L19:    areturn 
L20:    aload_1 
L21:    aload_2 
L22:    invokestatic [11] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [208] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L48 
L7:     aload_0 
L8:     getfield [27] 
L11:    ifnonnull L32 
L14:    aload_0 
L15:    getfield [24] 
L18:    aload_0 
L19:    getfield [26] 
L22:    aload_1 
L23:    invokeinterface [48] 0 
L28:    pop 
L29:    goto L40 
L32:    aload_0 
L33:    getfield [27] 
L36:    aload_1 
L37:    invokevirtual [31] 
L40:    aload_0 
L41:    aload_1 
L42:    putfield [46] 
L45:    goto L59 
L48:    getstatic [5] 
L51:    ldc [6] 
L53:    ldc [12] 
L55:    invokevirtual [28] 
L58:    pop 
L59:    return 
L60:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [208] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnull L64 
L4:     new [49] 
L7:     dup 
L8:     invokespecial [39] 
L11:    astore_3 
L12:    iconst_0 
L13:    istore 4 
L15:    iload 4 
L17:    aload_1 
L18:    arraylength 
L19:    if_icmpge L37 
L22:    aload_3 
L23:    aload_1 
L24:    iload 4 
L26:    iaload 
L27:    invokevirtual [32] 
L30:    pop 
L31:    iinc 4 1 
L34:    goto L15 
L37:    getstatic [5] 
L40:    ldc [14] 
L42:    ldc [15] 
L44:    aload_3 
L45:    aload_2 
L46:    invokevirtual [30] 
L49:    aload_0 
L50:    getfield [25] 
L53:    aload_3 
L54:    invokevirtual [33] 
L57:    aload_2 
L58:    invokeinterface [48] 0 
L63:    pop 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [208] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnull L65 
L4:     new [49] 
L7:     dup 
L8:     invokespecial [39] 
L11:    astore_2 
L12:    iconst_0 
L13:    istore_3 
L14:    iload_3 
L15:    aload_1 
L16:    arraylength 
L17:    if_icmpge L34 
L20:    aload_2 
L21:    aload_1 
L22:    iload_3 
L23:    iaload 
L24:    invokevirtual [32] 
L27:    pop 
L28:    iinc 3 1 
L31:    goto L14 
L34:    aload_0 
L35:    getfield [25] 
L38:    aload_2 
L39:    invokevirtual [33] 
L42:    invokeinterface [47] 0 
L47:    checkcast [16] 
L50:    astore_3 
L51:    getstatic [5] 
L54:    ldc [14] 
L56:    ldc [17] 
L58:    aload_2 
L59:    aload_3 
L60:    invokevirtual [30] 
L63:    aload_3 
L64:    areturn 
L65:    aconst_null 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = Class [51] 
.const [4] = Class [52] 
.const [5] = Field [53] [54] 
.const [6] = Int -1601830656 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = Class [57] 
.const [10] = String [58] 
.const [11] = Method [59] [60] 
.const [12] = String [61] 
.const [13] = Class [62] 
.const [14] = Int -2137614336 
.const [15] = String [63] 
.const [16] = Class [64] 
.const [17] = String [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Field [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Field [104] [105] 
.const [41] = Field [106] [107] 
.const [42] = Class [108] 
.const [43] = Class [109] 
.const [44] = Class [110] 
.const [45] = Field [111] [112] 
.const [46] = Field [113] [114] 
.const [47] = InterfaceMethod [115] [116] 
.const [48] = InterfaceMethod [117] [118] 
.const [49] = Class [119] 
.const [50] = Utf8 java/util/TreeMap 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceComparator 
.const [52] = Utf8 java/util/HashMap 
.const [53] = Class [120] 
.const [54] = NameAndType [121] [122] 
.const [55] = Utf8 'WidgetPersistence#setScreenState screen state null is set - nothing can be stored or read for this screen' 
.const [56] = Utf8 'WidgetPersistence#getScreenState screen states is null, or states.length == 0 - return screenState: -1' 
.const [57] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject 
.const [58] = Utf8 'WidgetPersistence#storeEnd: states are not as expected: expected: %1, but was: %2' 
.const [59] = Class [123] 
.const [60] = NameAndType [124] [125] 
.const [61] = Utf8 'WidgetPersistence#store cannot store data because states are null' 
.const [62] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [63] = Utf8 'WidgetPersistence#setDrawerState key: %1  drawerpersistence %2' 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager$DrawerPersistence 
.const [65] = Utf8 'WidgetPersistence#getDrawerState key: %1  drawerpersistence %2' 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 java/util/Map 
.const [71] = Utf8 java/util/Arrays 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Utf8 java/util/TreeMap 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceComparator 
.const [110] = Utf8 java/util/HashMap 
.const [111] = Class [180] 
.const [112] = NameAndType [181] [182] 
.const [113] = Class [183] 
.const [114] = NameAndType [184] [185] 
.const [115] = Class [186] 
.const [116] = NameAndType [187] [188] 
.const [117] = Class [189] 
.const [118] = NameAndType [190] [191] 
.const [119] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [121] = Utf8 logChannel 
.const [122] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [123] = Utf8 java/util/Arrays 
.const [124] = Utf8 equals 
.const [125] = Utf8 ([I[I)Z 
.const [126] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [127] = Utf8 persistenceMap 
.const [128] = Utf8 Ljava/util/Map; 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [130] = Utf8 drawerStateMap 
.const [131] = Utf8 Ljava/util/Map; 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [133] = Utf8 states 
.const [134] = Utf8 [I 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [136] = Utf8 lastEntryPointer 
.const [137] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;)Z 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject 
.const [142] = Utf8 getNext 
.const [143] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject 
.const [148] = Utf8 setNext 
.const [149] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject;)V 
.const [150] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [153] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [154] = Utf8 toString 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 java/lang/Object 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceComparator 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 java/util/TreeMap 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/util/Comparator;)V 
.const [165] = Utf8 java/util/HashMap 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [169] = Utf8 equalStates 
.const [170] = Utf8 ([I[I)Z 
.const [171] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [175] = Utf8 persistenceMap 
.const [176] = Utf8 Ljava/util/Map; 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [178] = Utf8 drawerStateMap 
.const [179] = Utf8 Ljava/util/Map; 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [181] = Utf8 states 
.const [182] = Utf8 [I 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [184] = Utf8 lastEntryPointer 
.const [185] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [186] = Utf8 java/util/Map 
.const [187] = Utf8 get 
.const [188] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [189] = Utf8 java/util/Map 
.const [190] = Utf8 put 
.const [191] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager 
.const [193] = Class [192] 
.const [194] = Utf8 java/lang/Object 
.const [195] = Class [194] 
.const [196] = Utf8 STATE_CLOSED 
.const [197] = Utf8 I 
.const [198] = Utf8 STATE_OPEN 
.const [199] = Utf8 I 
.const [200] = Utf8 persistenceMap 
.const [201] = Utf8 Ljava/util/Map; 
.const [202] = Utf8 states 
.const [203] = Utf8 [I 
.const [204] = Utf8 lastEntryPointer 
.const [205] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [206] = Utf8 drawerStateMap 
.const [207] = Utf8 Ljava/util/Map; 
.const [208] = Utf8 Code 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 readBegin 
.const [212] = Utf8 ([I)V 
.const [213] = Utf8 getScreenState 
.const [214] = Utf8 ()I 
.const [215] = Utf8 read 
.const [216] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [217] = Utf8 peek 
.const [218] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject; 
.const [219] = Utf8 storeBegin 
.const [220] = Utf8 ([I)V 
.const [221] = Utf8 storeEnd 
.const [222] = Utf8 ([I)V 
.const [223] = Utf8 equalStates 
.const [224] = Utf8 ([I[I)Z 
.const [225] = Utf8 store 
.const [226] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidgetStorageObject;)V 
.const [227] = Utf8 setDrawerState 
.const [228] = Utf8 ([ILde/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager$DrawerPersistence;)V 
.const [229] = Utf8 getDrawerState 
.const [230] = Utf8 ([I)Lde/esolutions/hmi/widgets/audi/base/WidgetPersistenceManager$DrawerPersistence; 
.end class 
