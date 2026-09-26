.version 50 0 
.class super [151] 
.super [153] 
.field private [154] [155] 
.field private final synthetic [156] [157] 

.method private [159] : [160] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [19] 
L9:     aload_0 
L10:    new [26] 
L13:    dup 
L14:    invokespecial [20] 
L17:    putfield [27] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [161] : [162] 
    .attribute [158] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     new [28] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [21] 
L12:    invokeinterface [29] 0 
L17:    checkcast [2] 
L20:    astore_2 
L21:    aload_2 
L22:    ifnonnull L52 
L25:    new [26] 
L28:    dup 
L29:    invokespecial [20] 
L32:    astore_2 
L33:    aload_0 
L34:    getfield [16] 
L37:    new [28] 
L40:    dup 
L41:    iload_1 
L42:    invokespecial [21] 
L45:    aload_2 
L46:    invokeinterface [30] 0 
L51:    pop 
L52:    aload_2 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method [163] : [164] 
    .attribute [158] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L47 using L50 
L7:     aload_1 
L8:     invokestatic [4] 
L11:    pop 
L12:    aload_1 
L13:    invokestatic [5] 
L16:    ifne L45 
L19:    aload_0 
L20:    aload_1 
L21:    invokestatic [6] 
L24:    invokespecial [22] 
L27:    new [31] 
L30:    dup 
L31:    aload_1 
L32:    invokestatic [8] 
L35:    i2l 
L36:    invokespecial [23] 
L39:    invokeinterface [32] 0 
L44:    pop 
L45:    aload_2 
L46:    monitorexit 
L47:    goto L55 
        .catch [0] from L50 to L53 using L50 
L50:    astore_3 
L51:    aload_2 
L52:    monitorexit 
L53:    aload_3 
L54:    athrow 
L55:    return 
L56:    
    .end code 
.end method 

.method [165] : [166] 
    .attribute [158] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore 4 
L7:     monitorenter 
        .catch [0] from L8 to L32 using L33 
L8:     aload_0 
L9:     iload_1 
L10:    invokespecial [22] 
L13:    new [31] 
L16:    dup 
L17:    lload_2 
L18:    invokespecial [23] 
L21:    invokeinterface [29] 0 
L26:    checkcast [9] 
L29:    aload 4 
L31:    monitorexit 
L32:    areturn 
        .catch [0] from L33 to L38 using L33 
L33:    astore 5 
L35:    aload 4 
L37:    monitorexit 
L38:    aload 5 
L40:    athrow 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method [167] : [168] 
    .attribute [158] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L72 using L73 
L7:     aload_0 
L8:     iload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [17] 
L14:    astore 4 
L16:    aload 4 
L18:    ifnonnull L62 
L21:    new [33] 
L24:    dup 
L25:    aload_0 
L26:    getfield [15] 
L29:    aconst_null 
L30:    invokespecial [24] 
L33:    iload_1 
L34:    iload_2 
L35:    invokestatic [10] 
L38:    astore 4 
L40:    aload_0 
L41:    iload_1 
L42:    invokespecial [22] 
L45:    new [31] 
L48:    dup 
L49:    iload_2 
L50:    i2l 
L51:    invokespecial [23] 
L54:    aload 4 
L56:    invokeinterface [30] 0 
L61:    pop 
L62:    aload 4 
L64:    invokestatic [11] 
L67:    pop 
L68:    aload 4 
L70:    aload_3 
L71:    monitorexit 
L72:    areturn 
        .catch [0] from L73 to L77 using L73 
L73:    astore 5 
L75:    aload_3 
L76:    monitorexit 
L77:    aload 5 
L79:    athrow 
L80:    
    .end code 
.end method 

.method synthetic [169] : [170] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Method [36] [37] 
.const [5] = Method [38] [39] 
.const [6] = Method [40] [41] 
.const [7] = Class [42] 
.const [8] = Method [43] [44] 
.const [9] = Class [45] 
.const [10] = Method [46] [47] 
.const [11] = Method [48] [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Field [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Method [57] [58] 
.const [18] = Method [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Field [73] [74] 
.const [26] = Class [75] 
.const [27] = Field [76] [77] 
.const [28] = Class [78] 
.const [29] = InterfaceMethod [79] [80] 
.const [30] = InterfaceMethod [81] [82] 
.const [31] = Class [83] 
.const [32] = InterfaceMethod [84] [85] 
.const [33] = Class [86] 
.const [34] = Utf8 java/util/HashMap 
.const [35] = Utf8 java/lang/Integer 
.const [36] = Class [87] 
.const [37] = NameAndType [88] [89] 
.const [38] = Class [90] 
.const [39] = NameAndType [91] [92] 
.const [40] = Class [93] 
.const [41] = NameAndType [94] [95] 
.const [42] = Utf8 java/lang/Long 
.const [43] = Class [96] 
.const [44] = NameAndType [97] [98] 
.const [45] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [46] = Class [99] 
.const [47] = NameAndType [100] [101] 
.const [48] = Class [102] 
.const [49] = NameAndType [103] [104] 
.const [50] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 java/util/Map 
.const [53] = Class [105] 
.const [54] = NameAndType [106] [107] 
.const [55] = Class [108] 
.const [56] = NameAndType [109] [110] 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Class [114] 
.const [60] = NameAndType [115] [116] 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Class [132] 
.const [72] = NameAndType [133] [134] 
.const [73] = Class [135] 
.const [74] = NameAndType [136] [137] 
.const [75] = Utf8 java/util/HashMap 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Utf8 java/lang/Integer 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Utf8 java/lang/Long 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [87] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [88] = Utf8 access$1410 
.const [89] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)I 
.const [90] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [91] = Utf8 access$1400 
.const [92] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)I 
.const [93] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [94] = Utf8 access$400 
.const [95] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)I 
.const [96] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [97] = Utf8 access$500 
.const [98] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)I 
.const [99] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [100] = Utf8 access$1600 
.const [101] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;II)Lde/audi/tghu/storage/DSIStorageProvider$Request; 
.const [102] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [103] = Utf8 access$1408 
.const [104] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)I 
.const [105] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [106] = Utf8 this$0 
.const [107] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [108] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [109] = Utf8 namespaces 
.const [110] = Utf8 Ljava/util/Map; 
.const [111] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [112] = Utf8 lookupRequest 
.const [113] = Utf8 (IJ)Lde/audi/tghu/storage/DSIStorageProvider$Request; 
.const [114] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider;)V 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 java/util/HashMap 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Integer 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [127] = Utf8 getNamespace 
.const [128] = Utf8 (I)Ljava/util/Map; 
.const [129] = Utf8 java/lang/Long 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (J)V 
.const [132] = Utf8 de/audi/tghu/storage/DSIStorageProvider$Request 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider;Lde/audi/tghu/storage/DSIStorageProvider$1;)V 
.const [135] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [136] = Utf8 this$0 
.const [137] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [138] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [139] = Utf8 namespaces 
.const [140] = Utf8 Ljava/util/Map; 
.const [141] = Utf8 java/util/Map 
.const [142] = Utf8 get 
.const [143] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [144] = Utf8 java/util/Map 
.const [145] = Utf8 put 
.const [146] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [147] = Utf8 java/util/Map 
.const [148] = Utf8 remove 
.const [149] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [150] = Utf8 de/audi/tghu/storage/DSIStorageProvider$RequestRegistry 
.const [151] = Class [150] 
.const [152] = Utf8 java/lang/Object 
.const [153] = Class [152] 
.const [154] = Utf8 namespaces 
.const [155] = Utf8 Ljava/util/Map; 
.const [156] = Utf8 this$0 
.const [157] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider;)V 
.const [161] = Utf8 getNamespace 
.const [162] = Utf8 (I)Ljava/util/Map; 
.const [163] = Utf8 releaseRequest 
.const [164] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider$Request;)V 
.const [165] = Utf8 lookupRequest 
.const [166] = Utf8 (IJ)Lde/audi/tghu/storage/DSIStorageProvider$Request; 
.const [167] = Utf8 getRequest 
.const [168] = Utf8 (II)Lde/audi/tghu/storage/DSIStorageProvider$Request; 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/audi/tghu/storage/DSIStorageProvider;Lde/audi/tghu/storage/DSIStorageProvider$1;)V 
.end class 
