.version 50 0 
.class public super [147] 
.super [149] 
.field private [150] [151] 
.field protected [152] [153] 
.field static synthetic [154] [155] 
.field static synthetic [156] [157] 
.field static synthetic [158] [159] 

.method public [161] : [162] 
    .attribute [160] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [30] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [31] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [163] : [164] 
    .attribute [160] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [21] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [165] : [166] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [167] : [168] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [20] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [30] 
L21:    aload_0 
L22:    getfield [21] 
L25:    invokestatic [5] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [31] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [169] : [170] 
    .attribute [160] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [30] 
L5:     aload_0 
L6:     invokevirtual [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [30] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [21] 
L10:    iconst_0 
L11:    invokestatic [6] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [30] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [21] 
L10:    iconst_1 
L11:    invokestatic [6] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [160] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [160] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokestatic [7] 
L4:     iconst_1 
L5:     invokespecial [26] 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [21] 
L13:    aload_0 
L14:    getfield [20] 
L17:    iconst_1 
L18:    invokestatic [8] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [160] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     getstatic [9] 
L7:     ifnonnull L22 
L10:    ldc [10] 
L12:    invokestatic [11] 
L15:    dup 
L16:    putstatic [28] 
L19:    goto L25 
L22:    getstatic [9] 
L25:    if_acmpne L44 
L28:    aload_0 
L29:    getfield [21] 
L32:    aload_0 
L33:    aload_1 
L34:    invokevirtual [23] 
L37:    lload_2 
L38:    invokestatic [12] 
L41:    goto L57 
L44:    aload_0 
L45:    getfield [21] 
L48:    aload_0 
L49:    aload_1 
L50:    invokevirtual [23] 
L53:    lload_2 
L54:    invokestatic [13] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method static synthetic [181] : [182] 
    .attribute [160] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [29] 
L9:     dup 
L10:    invokespecial [24] 
L13:    aload_1 
L14:    invokevirtual [19] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Class [34] 
.const [4] = Class [35] 
.const [5] = Method [36] [37] 
.const [6] = Method [38] [39] 
.const [7] = Method [40] [41] 
.const [8] = Method [42] [43] 
.const [9] = Field [44] [45] 
.const [10] = String [46] 
.const [11] = Method [47] [48] 
.const [12] = Method [49] [50] 
.const [13] = Method [51] [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Class [57] 
.const [19] = Method [58] [59] 
.const [20] = Field [60] [61] 
.const [21] = Field [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Field [76] [77] 
.const [29] = Class [78] 
.const [30] = Field [79] [80] 
.const [31] = Field [81] [82] 
.const [32] = Class [83] 
.const [33] = NameAndType [84] [85] 
.const [34] = Utf8 java/lang/ClassNotFoundException 
.const [35] = Utf8 java/lang/NoClassDefFoundError 
.const [36] = Class [86] 
.const [37] = NameAndType [87] [88] 
.const [38] = Class [89] 
.const [39] = NameAndType [90] [91] 
.const [40] = Class [92] 
.const [41] = NameAndType [93] [94] 
.const [42] = Class [95] 
.const [43] = NameAndType [96] [97] 
.const [44] = Class [98] 
.const [45] = NameAndType [99] [100] 
.const [46] = Utf8 'de.esolutions.graphics.eal.utility.IImageStorageListener' 
.const [47] = Class [101] 
.const [48] = NameAndType [102] [103] 
.const [49] = Class [104] 
.const [50] = NameAndType [105] [106] 
.const [51] = Class [107] 
.const [52] = NameAndType [108] [109] 
.const [53] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener$enType_t 
.const [56] = Utf8 java/lang/Class 
.const [57] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [58] = Class [110] 
.const [59] = NameAndType [111] [112] 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Utf8 java/lang/NoClassDefFoundError 
.const [79] = Class [140] 
.const [80] = NameAndType [141] [142] 
.const [81] = Class [143] 
.const [82] = NameAndType [144] [145] 
.const [83] = Utf8 java/lang/Class 
.const [84] = Utf8 forName 
.const [85] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [86] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [87] = Utf8 delete_eal_utility_IImageStorageListener 
.const [88] = Utf8 (J)V 
.const [89] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [90] = Utf8 eal_utility_IImageStorageListener_change_ownership 
.const [91] = Utf8 (Lde/esolutions/graphics/eal/utility/IImageStorageListener;JZ)V 
.const [92] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [93] = Utf8 new_eal_utility_IImageStorageListener 
.const [94] = Utf8 ()J 
.const [95] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [96] = Utf8 eal_utility_IImageStorageListener_director_connect 
.const [97] = Utf8 (Lde/esolutions/graphics/eal/utility/IImageStorageListener;JZZ)V 
.const [98] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [99] = Utf8 class$de$esolutions$graphics$eal$utility$IImageStorageListener 
.const [100] = Utf8 Ljava/lang/Class; 
.const [101] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [102] = Utf8 class$ 
.const [103] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [104] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [105] = Utf8 eal_utility_IImageStorageListener_process 
.const [106] = Utf8 (JLde/esolutions/graphics/eal/utility/IImageStorageListener;IJ)V 
.const [107] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [108] = Utf8 eal_utility_IImageStorageListener_processSwigExplicitIImageStorageListener 
.const [109] = Utf8 (JLde/esolutions/graphics/eal/utility/IImageStorageListener;IJ)V 
.const [110] = Utf8 java/lang/NoClassDefFoundError 
.const [111] = Utf8 initCause 
.const [112] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [113] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [114] = Utf8 swigCMemOwn 
.const [115] = Utf8 Z 
.const [116] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [117] = Utf8 swigCPtr 
.const [118] = Utf8 J 
.const [119] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [120] = Utf8 delete 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener$enType_t 
.const [123] = Utf8 swigValue 
.const [124] = Utf8 ()I 
.const [125] = Utf8 java/lang/NoClassDefFoundError 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 java/lang/Object 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (JZ)V 
.const [134] = Utf8 java/lang/Object 
.const [135] = Utf8 getClass 
.const [136] = Utf8 ()Ljava/lang/Class; 
.const [137] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [138] = Utf8 class$de$esolutions$graphics$eal$utility$IImageStorageListener 
.const [139] = Utf8 Ljava/lang/Class; 
.const [140] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [141] = Utf8 swigCMemOwn 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [144] = Utf8 swigCPtr 
.const [145] = Utf8 J 
.const [146] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 swigCPtr 
.const [151] = Utf8 J 
.const [152] = Utf8 swigCMemOwn 
.const [153] = Utf8 Z 
.const [154] = Utf8 class$de$esolutions$graphics$eal$utility$IImageStorageListener 
.const [155] = Utf8 Ljava/lang/Class; 
.const [156] = Utf8 class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t 
.const [157] = Utf8 Ljava/lang/Class; 
.const [158] = Utf8 class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t 
.const [159] = Utf8 Ljava/lang/Class; 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (JZ)V 
.const [163] = Utf8 getCPtr 
.const [164] = Utf8 (Lde/esolutions/graphics/eal/utility/IImageStorageListener;)J 
.const [165] = Utf8 finalize 
.const [166] = Utf8 ()V 
.const [167] = Utf8 delete 
.const [168] = Utf8 ()V 
.const [169] = Utf8 swigDirectorDisconnect 
.const [170] = Utf8 ()V 
.const [171] = Utf8 swigReleaseOwnership 
.const [172] = Utf8 ()V 
.const [173] = Utf8 swigTakeOwnership 
.const [174] = Utf8 ()V 
.const [175] = Utf8 isDeleted 
.const [176] = Utf8 ()Z 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 process 
.const [180] = Utf8 (Lde/esolutions/graphics/eal/utility/IImageStorageListener$enType_t;J)V 
.const [181] = Utf8 class$ 
.const [182] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
