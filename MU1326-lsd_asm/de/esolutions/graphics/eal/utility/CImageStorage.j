.version 50 0 
.class public super [139] 
.super [141] 
.field private [142] [143] 
.field protected [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [27] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [28] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [149] : [150] 
    .attribute [146] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [22] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [151] : [152] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [153] : [154] 
    .attribute [146] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [21] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [27] 
L21:    aload_0 
L22:    getfield [22] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [28] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [146] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [22] 
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

.method public [157] : [158] 
    .attribute [146] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [3] 
L5:     aload_1 
L6:     aload_2 
L7:     invokestatic [4] 
L10:    aload_2 
L11:    invokestatic [5] 
L14:    iconst_1 
L15:    invokespecial [25] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [146] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     lload_1 
L6:     aload_3 
L7:     aload 4 
L9:     invokestatic [6] 
L12:    aload 4 
L14:    invokestatic [7] 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [146] .code stack 13 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     lload_1 
L6:     aload_3 
L7:     aload 4 
L9:     invokestatic [6] 
L12:    aload 4 
L14:    lload 5 
L16:    lload 7 
L18:    invokestatic [8] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [146] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [9] 
L9:     lstore_3 
L10:    lload_3 
L11:    lconst_0 
L12:    lcmp 
L13:    ifne L20 
L16:    aconst_null 
L17:    goto L29 
L20:    new [29] 
L23:    dup 
L24:    lload_3 
L25:    iconst_0 
L26:    invokespecial [26] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     invokestatic [11] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     invokestatic [12] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     invokestatic [13] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [146] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [14] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [30] [31] 
.const [3] = Method [32] [33] 
.const [4] = Method [34] [35] 
.const [5] = Method [36] [37] 
.const [6] = Method [38] [39] 
.const [7] = Method [40] [41] 
.const [8] = Method [42] [43] 
.const [9] = Method [44] [45] 
.const [10] = Class [46] 
.const [11] = Method [47] [48] 
.const [12] = Method [49] [50] 
.const [13] = Method [51] [52] 
.const [14] = Method [53] [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Field [61] [62] 
.const [22] = Field [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Class [77] 
.const [30] = Class [78] 
.const [31] = NameAndType [79] [80] 
.const [32] = Class [81] 
.const [33] = NameAndType [82] [83] 
.const [34] = Class [84] 
.const [35] = NameAndType [85] [86] 
.const [36] = Class [87] 
.const [37] = NameAndType [88] [89] 
.const [38] = Class [90] 
.const [39] = NameAndType [91] [92] 
.const [40] = Class [93] 
.const [41] = NameAndType [94] [95] 
.const [42] = Class [96] 
.const [43] = NameAndType [97] [98] 
.const [44] = Class [99] 
.const [45] = NameAndType [100] [101] 
.const [46] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [47] = Class [102] 
.const [48] = NameAndType [103] [104] 
.const [49] = Class [105] 
.const [50] = NameAndType [106] [107] 
.const [51] = Class [108] 
.const [52] = NameAndType [109] [110] 
.const [53] = Class [111] 
.const [54] = NameAndType [112] [113] 
.const [55] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [58] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [59] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [60] = Utf8 de/esolutions/graphics/eal/FlagImage 
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
.const [77] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [78] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [79] = Utf8 delete_eal_utility_CImageStorage 
.const [80] = Utf8 (J)V 
.const [81] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [82] = Utf8 getCPtr 
.const [83] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;)J 
.const [84] = Utf8 de/esolutions/graphics/eal/utility/IImageStorageListener 
.const [85] = Utf8 getCPtr 
.const [86] = Utf8 (Lde/esolutions/graphics/eal/utility/IImageStorageListener;)J 
.const [87] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [88] = Utf8 new_eal_utility_CImageStorage 
.const [89] = Utf8 (JLde/esolutions/graphics/eal/api/IManager;JLde/esolutions/graphics/eal/utility/IImageStorageListener;)J 
.const [90] = Utf8 de/esolutions/graphics/eal/FlagImage 
.const [91] = Utf8 getCPtr 
.const [92] = Utf8 (Lde/esolutions/graphics/eal/FlagImage;)J 
.const [93] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [94] = Utf8 eal_utility_CImageStorage_add__SWIG_0 
.const [95] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;JLjava/lang/String;JLde/esolutions/graphics/eal/FlagImage;)Z 
.const [96] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [97] = Utf8 eal_utility_CImageStorage_add__SWIG_1 
.const [98] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;JLjava/lang/String;JLde/esolutions/graphics/eal/FlagImage;JJ)Z 
.const [99] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [100] = Utf8 eal_utility_CImageStorage_get 
.const [101] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;J)J 
.const [102] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [103] = Utf8 eal_utility_CImageStorage_flush 
.const [104] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;)Z 
.const [105] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [106] = Utf8 eal_utility_CImageStorage_clear 
.const [107] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;)Z 
.const [108] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [109] = Utf8 eal_utility_CImageStorage_destroy 
.const [110] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;)Z 
.const [111] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [112] = Utf8 eal_utility_CImageStorage_remove 
.const [113] = Utf8 (JLde/esolutions/graphics/eal/utility/CImageStorage;J)Z 
.const [114] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [115] = Utf8 swigCMemOwn 
.const [116] = Utf8 Z 
.const [117] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [118] = Utf8 swigCPtr 
.const [119] = Utf8 J 
.const [120] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [121] = Utf8 delete 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Object 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (JZ)V 
.const [129] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (JZ)V 
.const [132] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [133] = Utf8 swigCMemOwn 
.const [134] = Utf8 Z 
.const [135] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [136] = Utf8 swigCPtr 
.const [137] = Utf8 J 
.const [138] = Utf8 de/esolutions/graphics/eal/utility/CImageStorage 
.const [139] = Class [138] 
.const [140] = Utf8 java/lang/Object 
.const [141] = Class [140] 
.const [142] = Utf8 swigCPtr 
.const [143] = Utf8 J 
.const [144] = Utf8 swigCMemOwn 
.const [145] = Utf8 Z 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (JZ)V 
.const [149] = Utf8 getCPtr 
.const [150] = Utf8 (Lde/esolutions/graphics/eal/utility/CImageStorage;)J 
.const [151] = Utf8 finalize 
.const [152] = Utf8 ()V 
.const [153] = Utf8 delete 
.const [154] = Utf8 ()V 
.const [155] = Utf8 isDeleted 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;Lde/esolutions/graphics/eal/utility/IImageStorageListener;)V 
.const [159] = Utf8 add 
.const [160] = Utf8 (JLjava/lang/String;Lde/esolutions/graphics/eal/FlagImage;)Z 
.const [161] = Utf8 add 
.const [162] = Utf8 (JLjava/lang/String;Lde/esolutions/graphics/eal/FlagImage;JJ)Z 
.const [163] = Utf8 get 
.const [164] = Utf8 (J)Lde/esolutions/graphics/eal/api/IImage; 
.const [165] = Utf8 flush 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 clear 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 destroy 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 remove 
.const [172] = Utf8 (J)Z 
.end class 
