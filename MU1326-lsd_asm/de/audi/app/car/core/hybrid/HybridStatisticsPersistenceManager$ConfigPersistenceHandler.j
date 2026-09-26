.version 50 0 
.class final super [175] 
.super [177] 
.field private volatile [178] [179] 
.field private final synthetic [180] [181] 

.method private [183] : [184] 
    .attribute [182] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [41] 
L5:     aload_0 
L6:     aload_2 
L7:     iload_3 
L8:     iload 4 
L10:    iload 5 
L12:    invokespecial [38] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [185] : [186] 
    .attribute [182] .code stack 5 locals 0 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_0 
L6:     areturn 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [42] 
L12:    aload_0 
L13:    invokevirtual [24] 
L16:    aload_0 
L17:    getfield [22] 
L20:    invokestatic [2] 
L23:    ldc [3] 
L25:    ldc [4] 
L27:    aload_0 
L28:    invokevirtual [25] 
L31:    i2l 
L32:    invokevirtual [26] 
L35:    pop 
L36:    iconst_1 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [187] : [188] 
    .attribute [182] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     aload_0 
L5:     getfield [22] 
L8:     invokestatic [2] 
L11:    ldc [3] 
L13:    ldc [5] 
L15:    aload_0 
L16:    invokevirtual [25] 
L19:    i2l 
L20:    invokevirtual [26] 
L23:    pop 
L24:    aload_0 
L25:    getfield [23] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [189] : [190] 
    .attribute [182] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokestatic [2] 
L7:     ldc [6] 
L9:     ldc [7] 
L11:    invokevirtual [28] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method protected enum [191] : [192] 
    .attribute [182] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [193] : [194] 
    .attribute [182] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokestatic [2] 
L7:     ldc [6] 
L9:     ldc [8] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [29] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [195] : [196] 
    .attribute [182] .code stack 3 locals 2 
L0:     aload_1 
L1:     iconst_1 
L2:     invokevirtual [30] 
L5:     aload_0 
L6:     getfield [23] 
L9:     astore_2 
L10:    new [43] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [39] 
L18:    astore_3 
L19:    aload_3 
L20:    aload_2 
L21:    invokevirtual [31] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [197] : [198] 
    .attribute [182] .code stack 5 locals 3 
L0:     aload_1 
L1:     invokevirtual [32] 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     invokestatic [2] 
L12:    ldc [3] 
L14:    ldc [10] 
L16:    iload_2 
L17:    i2l 
L18:    invokevirtual [26] 
L21:    pop 
L22:    iconst_1 
L23:    iload_2 
L24:    if_icmpeq L46 
L27:    aload_0 
L28:    getfield [22] 
L31:    invokestatic [2] 
L34:    sipush 10000 
L37:    ldc [11] 
L39:    iload_2 
L40:    i2l 
L41:    invokevirtual [26] 
L44:    pop 
L45:    return 
L46:    new [44] 
L49:    dup 
L50:    aload_1 
L51:    invokespecial [40] 
L54:    astore_3 
        .catch [14] from L55 to L70 using L73 
L55:    aload_3 
L56:    invokevirtual [33] 
L59:    checkcast [13] 
L62:    astore 4 
L64:    aload_0 
L65:    aload 4 
L67:    putfield [42] 
L70:    goto L93 
L73:    astore 4 
L75:    aload_0 
L76:    getfield [22] 
L79:    invokestatic [2] 
L82:    sipush 10000 
L85:    ldc [15] 
L87:    aload 4 
L89:    invokevirtual [34] 
L92:    pop 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method synthetic [199] : [200] 
    .attribute [182] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     iload 4 
L6:     iload 5 
L8:     invokespecial [37] 
L11:    return 
L12:    
    .end code 
.end method 

.method static synthetic [201] : [202] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [36] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [203] : [204] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [45] [46] 
.const [3] = Int -2137614336 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = Int -1601830656 
.const [7] = String [49] 
.const [8] = String [50] 
.const [9] = Class [51] 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = String [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Class [62] 
.const [21] = Class [63] 
.const [22] = Field [64] [65] 
.const [23] = Field [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Method [88] [89] 
.const [35] = Method [90] [91] 
.const [36] = Method [92] [93] 
.const [37] = Method [94] [95] 
.const [38] = Method [96] [97] 
.const [39] = Method [98] [99] 
.const [40] = Method [100] [101] 
.const [41] = Field [102] [103] 
.const [42] = Field [104] [105] 
.const [43] = Class [106] 
.const [44] = Class [107] 
.const [45] = Class [108] 
.const [46] = NameAndType [109] [110] 
.const [47] = Utf8 '[ConfigPersistenceHandler#write] storage size: %1' 
.const [48] = Utf8 '[ConfigPersistenceHandler#read] storage size: %1' 
.const [49] = Utf8 '[ConfigPersistenceHandler#handleCRC32Error]' 
.const [50] = Utf8 '[ConfigPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2' 
.const [51] = Utf8 java/io/ObjectOutputStream 
.const [52] = Utf8 '[ConfigPersistenceHandler#deserialize] arrayLength=%1' 
.const [53] = Utf8 '[ConfigPersistenceHandler#deserialize] array length not valid: %1' 
.const [54] = Utf8 java/io/ObjectInputStream 
.const [55] = Utf8 de/audi/app/car/core/hybrid/IHybridStatisticsConfig 
.const [56] = Utf8 java/lang/ClassNotFoundException 
.const [57] = Utf8 '[ConfigPersistenceHandler#deserialize] %1' 
.const [58] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [59] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [60] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 java/io/DataOutputStream 
.const [63] = Utf8 java/io/DataInputStream 
.const [64] = Class [111] 
.const [65] = NameAndType [112] [113] 
.const [66] = Class [114] 
.const [67] = NameAndType [115] [116] 
.const [68] = Class [117] 
.const [69] = NameAndType [118] [119] 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Class [141] 
.const [85] = NameAndType [142] [143] 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Class [150] 
.const [91] = NameAndType [151] [152] 
.const [92] = Class [153] 
.const [93] = NameAndType [154] [155] 
.const [94] = Class [156] 
.const [95] = NameAndType [157] [158] 
.const [96] = Class [159] 
.const [97] = NameAndType [160] [161] 
.const [98] = Class [162] 
.const [99] = NameAndType [163] [164] 
.const [100] = Class [165] 
.const [101] = NameAndType [166] [167] 
.const [102] = Class [168] 
.const [103] = NameAndType [169] [170] 
.const [104] = Class [171] 
.const [105] = NameAndType [172] [173] 
.const [106] = Utf8 java/io/ObjectOutputStream 
.const [107] = Utf8 java/io/ObjectInputStream 
.const [108] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager 
.const [109] = Utf8 access$600 
.const [110] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;)Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [112] = Utf8 this$0 
.const [113] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [114] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [115] = Utf8 storageData 
.const [116] = Utf8 Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.const [117] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [118] = Utf8 serializeAndWrite 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [121] = Utf8 getSize 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/audi/atip/log/LogChannel 
.const [124] = Utf8 log 
.const [125] = Utf8 (ILjava/lang/String;J)Z 
.const [126] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [127] = Utf8 readAndDeserialize 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (ILjava/lang/String;)Z 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;JJ)Z 
.const [135] = Utf8 java/io/DataOutputStream 
.const [136] = Utf8 writeInt 
.const [137] = Utf8 (I)V 
.const [138] = Utf8 java/io/ObjectOutputStream 
.const [139] = Utf8 writeObject 
.const [140] = Utf8 (Ljava/lang/Object;)V 
.const [141] = Utf8 java/io/DataInputStream 
.const [142] = Utf8 readInt 
.const [143] = Utf8 ()I 
.const [144] = Utf8 java/io/ObjectInputStream 
.const [145] = Utf8 readObject 
.const [146] = Utf8 ()Ljava/lang/Object; 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [150] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [151] = Utf8 read 
.const [152] = Utf8 ()Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.const [153] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [154] = Utf8 write 
.const [155] = Utf8 (Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig;)Z 
.const [156] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;III)V 
.const [159] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [162] = Utf8 java/io/ObjectOutputStream 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/io/OutputStream;)V 
.const [165] = Utf8 java/io/ObjectInputStream 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (Ljava/io/InputStream;)V 
.const [168] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [169] = Utf8 this$0 
.const [170] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [171] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [172] = Utf8 storageData 
.const [173] = Utf8 Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.const [174] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler 
.const [175] = Class [174] 
.const [176] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [177] = Class [176] 
.const [178] = Utf8 storageData 
.const [179] = Utf8 Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.const [180] = Utf8 this$0 
.const [181] = Utf8 Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;III)V 
.const [185] = Utf8 write 
.const [186] = Utf8 (Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig;)Z 
.const [187] = Utf8 read 
.const [188] = Utf8 ()Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.const [189] = Utf8 handleCRC32Error 
.const [190] = Utf8 ()V 
.const [191] = Utf8 handleStorageReadError 
.const [192] = Utf8 (Ljava/lang/Exception;)V 
.const [193] = Utf8 convertContainer 
.const [194] = Utf8 (IILjava/io/DataInputStream;)V 
.const [195] = Utf8 serialize 
.const [196] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [197] = Utf8 deserialize 
.const [198] = Utf8 (Ljava/io/DataInputStream;)V 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager;Lde/audi/atip/storage/IStorageAccess;IIILde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$1;)V 
.const [201] = Utf8 access$200 
.const [202] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler;Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig;)Z 
.const [203] = Utf8 access$300 
.const [204] = Utf8 (Lde/audi/app/car/core/hybrid/HybridStatisticsPersistenceManager$ConfigPersistenceHandler;)Lde/audi/app/car/core/hybrid/IHybridStatisticsConfig; 
.end class 
