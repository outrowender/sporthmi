.version 50 0 
.class public super [147] 
.super [149] 
.field private [150] [151] 
.field protected [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [29] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [24] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [159] : [160] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [161] : [162] 
    .attribute [154] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [23] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [29] 
L21:    aload_0 
L22:    getfield [24] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [30] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [154] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
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

.method public [165] : [166] 
    .attribute [154] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [3] 
L5:     aload_1 
L6:     aload_2 
L7:     invokestatic [4] 
L10:    aload_2 
L11:    invokestatic [5] 
L14:    iconst_1 
L15:    invokespecial [27] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [154] .code stack 14 locals 2 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [7] 
L9:     aload_1 
L10:    lload_2 
L11:    lload 4 
L13:    aload 6 
L15:    invokestatic [8] 
L18:    aload 6 
L20:    iload 7 
L22:    invokestatic [9] 
L25:    lstore 8 
L27:    lload 8 
L29:    lconst_0 
L30:    lcmp 
L31:    ifne L38 
L34:    aconst_null 
L35:    goto L48 
L38:    new [31] 
L41:    dup 
L42:    lload 8 
L44:    iconst_0 
L45:    invokespecial [28] 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [154] .code stack 15 locals 2 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [7] 
L9:     aload_1 
L10:    lload_2 
L11:    lload 4 
L13:    aload 6 
L15:    invokestatic [8] 
L18:    aload 6 
L20:    iload 7 
L22:    iload 8 
L24:    invokestatic [11] 
L27:    lstore 9 
L29:    lload 9 
L31:    lconst_0 
L32:    lcmp 
L33:    ifne L40 
L36:    aconst_null 
L37:    goto L50 
L40:    new [31] 
L43:    dup 
L44:    lload 9 
L46:    iconst_0 
L47:    invokespecial [28] 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [154] .code stack 10 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [7] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [12] 
L14:    aload_2 
L15:    iload_3 
L16:    invokestatic [13] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [154] .code stack 11 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [7] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [12] 
L14:    aload_2 
L15:    iload_3 
L16:    iload 4 
L18:    invokestatic [14] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [154] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [7] 
L9:     aload_1 
L10:    invokestatic [15] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Method [34] [35] 
.const [4] = Method [36] [37] 
.const [5] = Method [38] [39] 
.const [6] = Method [40] [41] 
.const [7] = Method [42] [43] 
.const [8] = Method [44] [45] 
.const [9] = Method [46] [47] 
.const [10] = Class [48] 
.const [11] = Method [49] [50] 
.const [12] = Method [51] [52] 
.const [13] = Method [53] [54] 
.const [14] = Method [55] [56] 
.const [15] = Method [57] [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Field [66] [67] 
.const [24] = Field [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = Class [82] 
.const [32] = Class [83] 
.const [33] = NameAndType [84] [85] 
.const [34] = Class [86] 
.const [35] = NameAndType [87] [88] 
.const [36] = Class [89] 
.const [37] = NameAndType [90] [91] 
.const [38] = Class [92] 
.const [39] = NameAndType [93] [94] 
.const [40] = Class [95] 
.const [41] = NameAndType [96] [97] 
.const [42] = Class [98] 
.const [43] = NameAndType [99] [100] 
.const [44] = Class [101] 
.const [45] = NameAndType [102] [103] 
.const [46] = Class [104] 
.const [47] = NameAndType [105] [106] 
.const [48] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [49] = Class [107] 
.const [50] = NameAndType [108] [109] 
.const [51] = Class [110] 
.const [52] = NameAndType [111] [112] 
.const [53] = Class [113] 
.const [54] = NameAndType [114] [115] 
.const [55] = Class [116] 
.const [56] = NameAndType [117] [118] 
.const [57] = Class [119] 
.const [58] = NameAndType [120] [121] 
.const [59] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [62] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [63] = Utf8 de/esolutions/graphics/eal/api/INode2DManaged 
.const [64] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [65] = Utf8 de/esolutions/graphics/eal/FlagTexture 
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
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [83] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [84] = Utf8 delete_eal_utility_COffscreenHelper 
.const [85] = Utf8 (J)V 
.const [86] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [87] = Utf8 getCPtr 
.const [88] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [89] = Utf8 de/esolutions/graphics/eal/api/INode2DManaged 
.const [90] = Utf8 getCPtr 
.const [91] = Utf8 (Lde/esolutions/graphics/eal/api/INode2DManaged;)J 
.const [92] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [93] = Utf8 new_eal_utility_COffscreenHelper 
.const [94] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;JLde/esolutions/graphics/eal/api/INode2DManaged;)J 
.const [95] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [96] = Utf8 eal_utility_COffscreenHelper_dispose 
.const [97] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;)V 
.const [98] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [99] = Utf8 getCPtr 
.const [100] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;)J 
.const [101] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [102] = Utf8 getCPtr 
.const [103] = Utf8 (Lde/esolutions/graphics/eal/FlagTexture;)J 
.const [104] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [105] = Utf8 eal_utility_COffscreenHelper_enableOffscreen__SWIG_0 
.const [106] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;JLde/esolutions/graphics/eal/api/INode2D;JJJLde/esolutions/graphics/eal/FlagTexture;I)J 
.const [107] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [108] = Utf8 eal_utility_COffscreenHelper_enableOffscreen__SWIG_1 
.const [109] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;JLde/esolutions/graphics/eal/api/INode2D;JJJLde/esolutions/graphics/eal/FlagTexture;IZ)J 
.const [110] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [111] = Utf8 getCPtr 
.const [112] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)J 
.const [113] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [114] = Utf8 eal_utility_COffscreenHelper_enableOffscreen__SWIG_2 
.const [115] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;JLde/esolutions/graphics/eal/api/INode2D;JLde/esolutions/graphics/eal/api/ITexture;I)Z 
.const [116] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [117] = Utf8 eal_utility_COffscreenHelper_enableOffscreen__SWIG_3 
.const [118] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;JLde/esolutions/graphics/eal/api/INode2D;JLde/esolutions/graphics/eal/api/ITexture;IZ)Z 
.const [119] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [120] = Utf8 eal_utility_COffscreenHelper_disableOffscreen 
.const [121] = Utf8 (JLde/esolutions/graphics/eal/utility/COffscreenHelper;JLde/esolutions/graphics/eal/api/INode2D;)Z 
.const [122] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [123] = Utf8 swigCMemOwn 
.const [124] = Utf8 Z 
.const [125] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [126] = Utf8 swigCPtr 
.const [127] = Utf8 J 
.const [128] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [129] = Utf8 delete 
.const [130] = Utf8 ()V 
.const [131] = Utf8 java/lang/Object 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (JZ)V 
.const [137] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (JZ)V 
.const [140] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [141] = Utf8 swigCMemOwn 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [144] = Utf8 swigCPtr 
.const [145] = Utf8 J 
.const [146] = Utf8 de/esolutions/graphics/eal/utility/COffscreenHelper 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 swigCPtr 
.const [151] = Utf8 J 
.const [152] = Utf8 swigCMemOwn 
.const [153] = Utf8 Z 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (JZ)V 
.const [157] = Utf8 getCPtr 
.const [158] = Utf8 (Lde/esolutions/graphics/eal/utility/COffscreenHelper;)J 
.const [159] = Utf8 finalize 
.const [160] = Utf8 ()V 
.const [161] = Utf8 delete 
.const [162] = Utf8 ()V 
.const [163] = Utf8 isDeleted 
.const [164] = Utf8 ()Z 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Lde/esolutions/graphics/eal/api/INode2DManaged;)V 
.const [167] = Utf8 dispose 
.const [168] = Utf8 ()V 
.const [169] = Utf8 enableOffscreen 
.const [170] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;JJLde/esolutions/graphics/eal/FlagTexture;I)Lde/esolutions/graphics/eal/api/ITexture; 
.const [171] = Utf8 enableOffscreen 
.const [172] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;JJLde/esolutions/graphics/eal/FlagTexture;IZ)Lde/esolutions/graphics/eal/api/ITexture; 
.const [173] = Utf8 enableOffscreen 
.const [174] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;Lde/esolutions/graphics/eal/api/ITexture;I)Z 
.const [175] = Utf8 enableOffscreen 
.const [176] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;Lde/esolutions/graphics/eal/api/ITexture;IZ)Z 
.const [177] = Utf8 disableOffscreen 
.const [178] = Utf8 (Lde/esolutions/graphics/eal/api/INode2D;)Z 
.end class 
