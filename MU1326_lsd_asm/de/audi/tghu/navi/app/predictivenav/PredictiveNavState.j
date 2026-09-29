.version 50 0 
.class public super [90] 
.super [92] 
.field private static final [93] [94] 
.field public static final [95] [96] 
.field private static final [97] [98] 
.field private [99] [100] 

.method public [102] : [103] 
    .attribute [101] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_4 
L3:     sipush 1004 
L6:     sipush 988 
L9:     aload_2 
L10:    invokespecial [22] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [104] : [105] 
    .attribute [101] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected enum [106] : [107] 
    .attribute [101] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [108] : [109] 
    .attribute [101] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [14] 
        .catch [2] from L4 to L13 using L16 
L4:     iload_1 
L5:     ifle L13 
L8:     aload_0 
L9:     aload_3 
L10:    invokevirtual [15] 
L13:    goto L33 
L16:    astore 4 
L18:    aload_0 
L19:    invokevirtual [16] 
L22:    sipush 10000 
L25:    ldc [3] 
L27:    aload 4 
L29:    invokevirtual [17] 
L32:    pop 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [110] : [111] 
    .attribute [101] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [13] 
L12:    i2l 
L13:    invokevirtual [19] 
L16:    pop 
L17:    aload_0 
L18:    getfield [13] 
L21:    ifeq L48 
L24:    aload_0 
L25:    getfield [13] 
L28:    iconst_1 
L29:    if_icmpeq L48 
L32:    aload_0 
L33:    getfield [13] 
L36:    iconst_2 
L37:    if_icmpeq L48 
L40:    aload_1 
L41:    iconst_m1 
L42:    invokevirtual [20] 
L45:    goto L56 
L48:    aload_1 
L49:    aload_0 
L50:    getfield [13] 
L53:    invokevirtual [20] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method protected [112] : [113] 
    .attribute [101] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [21] 
L4:     istore_2 
L5:     iload_2 
L6:     iconst_m1 
L7:     if_icmpne L35 
L10:    aload_0 
L11:    getfield [18] 
L14:    ldc [4] 
L16:    ldc [6] 
L18:    aload_0 
L19:    getfield [13] 
L22:    i2l 
L23:    invokevirtual [19] 
L26:    pop 
L27:    aload_0 
L28:    iconst_0 
L29:    putfield [23] 
L32:    goto L57 
L35:    aload_0 
L36:    getfield [18] 
L39:    ldc [4] 
L41:    ldc [7] 
L43:    aload_0 
L44:    getfield [13] 
L47:    i2l 
L48:    invokevirtual [19] 
L51:    pop 
L52:    aload_0 
L53:    iload_2 
L54:    putfield [23] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public interface [114] : [115] 
    .attribute [101] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [101] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = String [25] 
.const [4] = Int -2137614336 
.const [5] = String [26] 
.const [6] = String [27] 
.const [7] = String [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Field [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Method [52] [53] 
.const [23] = Field [54] [55] 
.const [24] = Utf8 java/io/IOException 
.const [25] = Utf8 'LocalPersistNavLocationHelper.NavLocationState#convertContainer - error on converting the persistent state format' 
.const [26] = Utf8 'PredictiveNavState serialize: operationMode=%1' 
.const [27] = Utf8 'PredictiveNavState deserialize: ERROR operationMode=%1' 
.const [28] = Utf8 'PredictiveNavState deserialize: operationMode=%1' 
.const [29] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [30] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 java/io/DataOutputStream 
.const [33] = Utf8 java/io/DataInputStream 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Class [74] 
.const [47] = NameAndType [75] [76] 
.const [48] = Class [77] 
.const [49] = NameAndType [78] [79] 
.const [50] = Class [80] 
.const [51] = NameAndType [81] [82] 
.const [52] = Class [83] 
.const [53] = NameAndType [84] [85] 
.const [54] = Class [86] 
.const [55] = NameAndType [87] [88] 
.const [56] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [57] = Utf8 operationMode 
.const [58] = Utf8 I 
.const [59] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [60] = Utf8 initWithDefaultValues 
.const [61] = Utf8 ()V 
.const [62] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [63] = Utf8 deserialize 
.const [64] = Utf8 (Ljava/io/DataInputStream;)V 
.const [65] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [66] = Utf8 getLogChannel 
.const [67] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 log 
.const [70] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [71] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [72] = Utf8 logChannel 
.const [73] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;J)Z 
.const [77] = Utf8 java/io/DataOutputStream 
.const [78] = Utf8 writeInt 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 java/io/DataInputStream 
.const [81] = Utf8 readInt 
.const [82] = Utf8 ()I 
.const [83] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [86] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [87] = Utf8 operationMode 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/tghu/navi/app/predictivenav/PredictiveNavState 
.const [90] = Class [89] 
.const [91] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [92] = Class [91] 
.const [93] = Utf8 VERSION 
.const [94] = Utf8 I 
.const [95] = Utf8 DEFAULT_OPERATION_MODE 
.const [96] = Utf8 I 
.const [97] = Utf8 OPERATION_MODE_ERROR 
.const [98] = Utf8 I 
.const [99] = Utf8 operationMode 
.const [100] = Utf8 I 
.const [101] = Utf8 Code 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [104] = Utf8 initWithDefaultValues 
.const [105] = Utf8 ()V 
.const [106] = Utf8 initFromOldKeys 
.const [107] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [108] = Utf8 convertContainer 
.const [109] = Utf8 (IILjava/io/DataInputStream;)V 
.const [110] = Utf8 serialize 
.const [111] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [112] = Utf8 deserialize 
.const [113] = Utf8 (Ljava/io/DataInputStream;)V 
.const [114] = Utf8 getOperationMode 
.const [115] = Utf8 ()I 
.const [116] = Utf8 setOperationMode 
.const [117] = Utf8 (I)V 
.end class 
