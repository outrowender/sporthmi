.version 50 0 
.class super [163] 
.super [165] 
.field private [166] [167] 
.field private final synthetic [168] [169] 

.method public [171] : [172] 
    .attribute [170] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     aload_1 
L7:     invokestatic [2] 
L10:    iconst_1 
L11:    sipush 1001 
L14:    iload_2 
L15:    invokespecial [30] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [173] : [174] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [170] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [36] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [177] : [178] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [3] 
L7:     ldc [4] 
L9:     ldc [5] 
L11:    invokevirtual [23] 
L14:    pop 
L15:    aload_0 
L16:    new [37] 
L19:    dup 
L20:    invokespecial [31] 
L23:    putfield [36] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [179] : [180] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [3] 
L7:     ldc [4] 
L9:     ldc [7] 
L11:    invokevirtual [23] 
L14:    pop 
L15:    aload_0 
L16:    new [37] 
L19:    dup 
L20:    invokespecial [31] 
L23:    putfield [36] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [181] : [182] 
    .attribute [170] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [3] 
L7:     ldc [8] 
L9:     ldc [9] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [24] 
L18:    pop 
L19:    aload_0 
L20:    new [37] 
L23:    dup 
L24:    invokespecial [31] 
L27:    putfield [36] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [183] : [184] 
    .attribute [170] .code stack 3 locals 1 
L0:     new [38] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [32] 
L8:     astore_2 
L9:     aload_2 
L10:    aload_0 
L11:    getfield [22] 
L14:    invokevirtual [25] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [185] : [186] 
    .attribute [170] .code stack 4 locals 4 
L0:     new [39] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [33] 
L8:     astore_2 
        .catch [13] from L9 to L66 using L69 
L9:     aload_0 
L10:    aload_2 
L11:    invokevirtual [26] 
L14:    checkcast [6] 
L17:    putfield [36] 
L20:    bipush 10 
L22:    istore_3 
L23:    aload_0 
L24:    getfield [22] 
L27:    invokevirtual [27] 
L30:    astore 4 
L32:    aload 4 
L34:    invokeinterface [40] 0 
L39:    ifeq L66 
L42:    aload 4 
L44:    invokeinterface [41] 0 
L49:    checkcast [12] 
L52:    astore 5 
L54:    aload 5 
L56:    iload_3 
L57:    iinc 3 1 
L60:    invokevirtual [28] 
L63:    goto L32 
L66:    goto L97 
L69:    astore_3 
L70:    aload_0 
L71:    getfield [21] 
L74:    invokestatic [3] 
L77:    sipush 10000 
L80:    ldc [14] 
L82:    aload_3 
L83:    invokevirtual [29] 
L86:    pop 
L87:    new [42] 
L90:    dup 
L91:    ldc [14] 
L93:    invokespecial [34] 
L96:    athrow 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [43] [44] 
.const [3] = Method [45] [46] 
.const [4] = Int -1601830656 
.const [5] = String [47] 
.const [6] = Class [48] 
.const [7] = String [49] 
.const [8] = Int 1078071040 
.const [9] = String [50] 
.const [10] = Class [51] 
.const [11] = Class [52] 
.const [12] = Class [53] 
.const [13] = Class [54] 
.const [14] = String [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Class [60] 
.const [20] = Class [61] 
.const [21] = Field [62] [63] 
.const [22] = Field [64] [65] 
.const [23] = Method [66] [67] 
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
.const [35] = Field [90] [91] 
.const [36] = Field [92] [93] 
.const [37] = Class [94] 
.const [38] = Class [95] 
.const [39] = Class [96] 
.const [40] = InterfaceMethod [97] [98] 
.const [41] = InterfaceMethod [99] [100] 
.const [42] = Class [101] 
.const [43] = Class [102] 
.const [44] = NameAndType [103] [104] 
.const [45] = Class [105] 
.const [46] = NameAndType [106] [107] 
.const [47] = Utf8 '[TaggingListStorage.handleCRC32Error]' 
.const [48] = Utf8 java/util/LinkedList 
.const [49] = Utf8 '[TaggingListStorage.handleStorageReadError]' 
.const [50] = Utf8 '[TaggingListStorage.convertContainer] persisted:%1 container:%2' 
.const [51] = Utf8 java/io/ObjectOutputStream 
.const [52] = Utf8 java/io/ObjectInputStream 
.const [53] = Utf8 de/audi/tuner/itunes/TaggingData 
.const [54] = Utf8 java/lang/ClassNotFoundException 
.const [55] = Utf8 '[TaggingListStorage.StorageDataContainer.deserialize]' 
.const [56] = Utf8 java/io/IOException 
.const [57] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [58] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [59] = Utf8 de/audi/tuner/app/storage/TaggingListStorage 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 java/util/Iterator 
.const [62] = Class [108] 
.const [63] = NameAndType [109] [110] 
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
.const [94] = Utf8 java/util/LinkedList 
.const [95] = Utf8 java/io/ObjectOutputStream 
.const [96] = Utf8 java/io/ObjectInputStream 
.const [97] = Class [156] 
.const [98] = NameAndType [157] [158] 
.const [99] = Class [159] 
.const [100] = NameAndType [160] [161] 
.const [101] = Utf8 java/io/IOException 
.const [102] = Utf8 de/audi/tuner/app/storage/TaggingListStorage 
.const [103] = Utf8 access$000 
.const [104] = Utf8 (Lde/audi/tuner/app/storage/TaggingListStorage;)Lde/audi/atip/storage/IStorageAccess; 
.const [105] = Utf8 de/audi/tuner/app/storage/TaggingListStorage 
.const [106] = Utf8 access$100 
.const [107] = Utf8 (Lde/audi/tuner/app/storage/TaggingListStorage;)Lde/audi/atip/log/LogChannel; 
.const [108] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [109] = Utf8 this$0 
.const [110] = Utf8 Lde/audi/tuner/app/storage/TaggingListStorage; 
.const [111] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [112] = Utf8 list 
.const [113] = Utf8 Ljava/util/LinkedList; 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;)Z 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 log 
.const [119] = Utf8 (ILjava/lang/String;JJ)Z 
.const [120] = Utf8 java/io/ObjectOutputStream 
.const [121] = Utf8 writeObject 
.const [122] = Utf8 (Ljava/lang/Object;)V 
.const [123] = Utf8 java/io/ObjectInputStream 
.const [124] = Utf8 readObject 
.const [125] = Utf8 ()Ljava/lang/Object; 
.const [126] = Utf8 java/util/LinkedList 
.const [127] = Utf8 iterator 
.const [128] = Utf8 ()Ljava/util/Iterator; 
.const [129] = Utf8 de/audi/tuner/itunes/TaggingData 
.const [130] = Utf8 setId 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [135] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [138] = Utf8 java/util/LinkedList 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 java/io/ObjectOutputStream 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Ljava/io/OutputStream;)V 
.const [144] = Utf8 java/io/ObjectInputStream 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Ljava/io/InputStream;)V 
.const [147] = Utf8 java/io/IOException 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Ljava/lang/String;)V 
.const [150] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [151] = Utf8 this$0 
.const [152] = Utf8 Lde/audi/tuner/app/storage/TaggingListStorage; 
.const [153] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [154] = Utf8 list 
.const [155] = Utf8 Ljava/util/LinkedList; 
.const [156] = Utf8 java/util/Iterator 
.const [157] = Utf8 hasNext 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 java/util/Iterator 
.const [160] = Utf8 next 
.const [161] = Utf8 ()Ljava/lang/Object; 
.const [162] = Utf8 de/audi/tuner/app/storage/TaggingListStorage$StorageDataContainer 
.const [163] = Class [162] 
.const [164] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [165] = Class [164] 
.const [166] = Utf8 list 
.const [167] = Utf8 Ljava/util/LinkedList; 
.const [168] = Utf8 this$0 
.const [169] = Utf8 Lde/audi/tuner/app/storage/TaggingListStorage; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/tuner/app/storage/TaggingListStorage;I)V 
.const [173] = Utf8 getData 
.const [174] = Utf8 ()Ljava/util/LinkedList; 
.const [175] = Utf8 setData 
.const [176] = Utf8 (Ljava/util/LinkedList;)V 
.const [177] = Utf8 handleCRC32Error 
.const [178] = Utf8 ()V 
.const [179] = Utf8 handleStorageReadError 
.const [180] = Utf8 (Ljava/lang/Exception;)V 
.const [181] = Utf8 convertContainer 
.const [182] = Utf8 (IILjava/io/DataInputStream;)V 
.const [183] = Utf8 serialize 
.const [184] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [185] = Utf8 deserialize 
.const [186] = Utf8 (Ljava/io/DataInputStream;)V 
.end class 
