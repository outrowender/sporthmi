.version 50 0 
.class public super abstract [113] 
.super [115] 
.field private final [116] [117] 
.field protected final [118] [119] 

.method public [121] : [122] 
    .attribute [120] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iload 4 
L6:     invokespecial [25] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [26] 
L14:    aload_0 
L15:    aload 5 
L17:    putfield [27] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected interface [123] : [124] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [125] : [126] 
    .attribute [120] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [127] : [128] 
    .attribute [120] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [129] : [130] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     sipush 10000 
L7:     ldc [2] 
L9:     invokevirtual [15] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [16] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [131] : [132] 
    .attribute [120] .code stack 7 locals 0 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifeq L30 
L7:     aload_0 
L8:     getfield [14] 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    invokevirtual [15] 
L18:    pop 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [13] 
L24:    invokevirtual [17] 
L27:    goto L56 
L30:    aload_0 
L31:    getfield [14] 
L34:    ldc [6] 
L36:    ldc [7] 
L38:    aload_0 
L39:    invokevirtual [18] 
L42:    i2l 
L43:    aload_0 
L44:    invokevirtual [19] 
L47:    i2l 
L48:    invokevirtual [20] 
L51:    pop 
L52:    aload_0 
L53:    invokevirtual [16] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method protected static [133] : [134] 
    .attribute [120] .code stack 3 locals 1 
L0:     aload_0 
L1:     ifnonnull L10 
L4:     aload_1 
L5:     iconst_m1 
L6:     invokevirtual [21] 
L9:     return 
L10:    aload_1 
L11:    aload_0 
L12:    arraylength 
L13:    invokevirtual [21] 
L16:    iconst_0 
L17:    istore_2 
L18:    iload_2 
L19:    aload_0 
L20:    arraylength 
L21:    if_icmpge L37 
L24:    aload_1 
L25:    aload_0 
L26:    iload_2 
L27:    baload 
L28:    invokevirtual [22] 
L31:    iinc 2 1 
L34:    goto L18 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected static [135] : [136] 
    .attribute [120] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     istore_1 
L5:     iload_1 
L6:     iconst_m1 
L7:     if_icmpne L12 
L10:    aconst_null 
L11:    areturn 
L12:    iload_1 
L13:    newarray byte 
L15:    astore_2 
L16:    iconst_0 
L17:    istore_3 
L18:    iload_3 
L19:    iload_1 
L20:    if_icmpge L36 
L23:    aload_2 
L24:    iload_3 
L25:    aload_0 
L26:    invokevirtual [24] 
L29:    bastore 
L30:    iinc 3 1 
L33:    goto L18 
L36:    aload_2 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [28] 
.const [3] = Class [29] 
.const [4] = Int 1078071040 
.const [5] = String [30] 
.const [6] = Int -1601830656 
.const [7] = String [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Field [37] [38] 
.const [14] = Field [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Method [61] [62] 
.const [26] = Field [63] [64] 
.const [27] = Field [65] [66] 
.const [28] = Utf8 'PersistentState#handleCRC32Error - invalid persistent state, using default values' 
.const [29] = Utf8 de/audi/atip/storage/ValueMissingException 
.const [30] = Utf8 'PersistentState#handleStorageReadError - no persistent state available, trying old keys' 
.const [31] = Utf8 'PersistentState#handleStorageReadError - cannot read persistent state, using default values (namespace: %1, key: %2)' 
.const [32] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [33] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [34] = Utf8 de/audi/atip/log/LogChannel 
.const [35] = Utf8 java/io/DataOutputStream 
.const [36] = Utf8 java/io/DataInputStream 
.const [37] = Class [67] 
.const [38] = NameAndType [68] [69] 
.const [39] = Class [70] 
.const [40] = NameAndType [71] [72] 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [68] = Utf8 storageAccess 
.const [69] = Utf8 Lde/audi/atip/storage/IStorageAccess; 
.const [70] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [71] = Utf8 logChannel 
.const [72] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;)Z 
.const [76] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [77] = Utf8 initWithDefaultValues 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [80] = Utf8 initFromOldKeys 
.const [81] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [82] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [83] = Utf8 getNamespace 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [86] = Utf8 getKey 
.const [87] = Utf8 ()I 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;JJ)Z 
.const [91] = Utf8 java/io/DataOutputStream 
.const [92] = Utf8 writeInt 
.const [93] = Utf8 (I)V 
.const [94] = Utf8 java/io/DataOutputStream 
.const [95] = Utf8 writeByte 
.const [96] = Utf8 (I)V 
.const [97] = Utf8 java/io/DataInputStream 
.const [98] = Utf8 readInt 
.const [99] = Utf8 ()I 
.const [100] = Utf8 java/io/DataInputStream 
.const [101] = Utf8 readByte 
.const [102] = Utf8 ()B 
.const [103] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/atip/storage/IStorageAccess;III)V 
.const [106] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [107] = Utf8 storageAccess 
.const [108] = Utf8 Lde/audi/atip/storage/IStorageAccess; 
.const [109] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [110] = Utf8 logChannel 
.const [111] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [112] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [113] = Class [112] 
.const [114] = Utf8 de/audi/atip/storage/AbstractStorageDataContainer 
.const [115] = Class [114] 
.const [116] = Utf8 storageAccess 
.const [117] = Utf8 Lde/audi/atip/storage/IStorageAccess; 
.const [118] = Utf8 logChannel 
.const [119] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [120] = Utf8 Code 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [123] = Utf8 getLogChannel 
.const [124] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 initWithDefaultValues 
.const [126] = Utf8 ()V 
.const [127] = Utf8 initFromOldKeys 
.const [128] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [129] = Utf8 handleCRC32Error 
.const [130] = Utf8 ()V 
.const [131] = Utf8 handleStorageReadError 
.const [132] = Utf8 (Ljava/lang/Exception;)V 
.const [133] = Utf8 serializeByteArray 
.const [134] = Utf8 ([BLjava/io/DataOutputStream;)V 
.const [135] = Utf8 deserializeByteArray 
.const [136] = Utf8 (Ljava/io/DataInputStream;)[B 
.end class 
