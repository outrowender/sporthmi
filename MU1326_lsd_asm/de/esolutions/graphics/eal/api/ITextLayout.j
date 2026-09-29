.version 50 0 
.class public super [205] 
.super [207] 
.field private [208] [209] 
.field static synthetic [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [5] 
L5:     iload_3 
L6:     invokespecial [35] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [40] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [215] : [216] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [30] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [217] : [218] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [219] : [220] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [32] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [41] 
L21:    aload_0 
L22:    getfield [30] 
L25:    invokestatic [6] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [40] 
L33:    aload_0 
L34:    invokespecial [36] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [30] 
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

.method public [223] : [224] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [7] 
L4:     iconst_1 
L5:     invokespecial [37] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [212] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [8] 
L5:     aload_1 
L6:     iload_2 
L7:     invokestatic [9] 
L10:    iconst_1 
L11:    invokespecial [37] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokestatic [10] 
L5:     iconst_1 
L6:     invokespecial [37] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     invokestatic [11] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [212] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     lload_1 
L6:     lload_3 
L7:     invokestatic [13] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [212] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [212] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [15] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [212] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [16] 
L9:     lstore_3 
L10:    lload_3 
L11:    lconst_0 
L12:    lcmp 
L13:    ifne L20 
L16:    aconst_null 
L17:    goto L29 
L20:    new [42] 
L23:    dup 
L24:    lload_3 
L25:    iconst_1 
L26:    invokespecial [38] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     invokestatic [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     invokestatic [19] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     invokestatic [20] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     iload_1 
L6:     invokestatic [21] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [33] 
L9:     invokestatic [22] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [251] : [252] 
    .attribute [212] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [39] 
L9:     dup 
L10:    invokespecial [34] 
L13:    aload_1 
L14:    invokevirtual [29] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [43] [44] 
.const [3] = Class [45] 
.const [4] = Class [46] 
.const [5] = Method [47] [48] 
.const [6] = Method [49] [50] 
.const [7] = Method [51] [52] 
.const [8] = Method [53] [54] 
.const [9] = Method [55] [56] 
.const [10] = Method [57] [58] 
.const [11] = Method [59] [60] 
.const [12] = Method [61] [62] 
.const [13] = Method [63] [64] 
.const [14] = Method [65] [66] 
.const [15] = Method [67] [68] 
.const [16] = Method [69] [70] 
.const [17] = Class [71] 
.const [18] = Method [72] [73] 
.const [19] = Method [74] [75] 
.const [20] = Method [76] [77] 
.const [21] = Method [78] [79] 
.const [22] = Method [80] [81] 
.const [23] = Class [82] 
.const [24] = Class [83] 
.const [25] = Class [84] 
.const [26] = Class [85] 
.const [27] = Class [86] 
.const [28] = Class [87] 
.const [29] = Method [88] [89] 
.const [30] = Field [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Field [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Class [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Class [113] 
.const [43] = Class [114] 
.const [44] = NameAndType [115] [116] 
.const [45] = Utf8 java/lang/ClassNotFoundException 
.const [46] = Utf8 java/lang/NoClassDefFoundError 
.const [47] = Class [117] 
.const [48] = NameAndType [118] [119] 
.const [49] = Class [120] 
.const [50] = NameAndType [121] [122] 
.const [51] = Class [123] 
.const [52] = NameAndType [124] [125] 
.const [53] = Class [126] 
.const [54] = NameAndType [127] [128] 
.const [55] = Class [129] 
.const [56] = NameAndType [130] [131] 
.const [57] = Class [132] 
.const [58] = NameAndType [133] [134] 
.const [59] = Class [135] 
.const [60] = NameAndType [136] [137] 
.const [61] = Class [138] 
.const [62] = NameAndType [139] [140] 
.const [63] = Class [141] 
.const [64] = NameAndType [142] [143] 
.const [65] = Class [144] 
.const [66] = NameAndType [145] [146] 
.const [67] = Class [147] 
.const [68] = NameAndType [148] [149] 
.const [69] = Class [150] 
.const [70] = NameAndType [151] [152] 
.const [71] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutSection 
.const [72] = Class [153] 
.const [73] = NameAndType [154] [155] 
.const [74] = Class [156] 
.const [75] = NameAndType [157] [158] 
.const [76] = Class [159] 
.const [77] = NameAndType [160] [161] 
.const [78] = Class [162] 
.const [79] = NameAndType [163] [164] 
.const [80] = Class [165] 
.const [81] = NameAndType [166] [167] 
.const [82] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [83] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [84] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [85] = Utf8 java/lang/Class 
.const [86] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [87] = Utf8 de/esolutions/graphics/eal/api/IFont 
.const [88] = Class [168] 
.const [89] = NameAndType [169] [170] 
.const [90] = Class [171] 
.const [91] = NameAndType [172] [173] 
.const [92] = Class [174] 
.const [93] = NameAndType [175] [176] 
.const [94] = Class [177] 
.const [95] = NameAndType [178] [179] 
.const [96] = Class [180] 
.const [97] = NameAndType [181] [182] 
.const [98] = Class [183] 
.const [99] = NameAndType [184] [185] 
.const [100] = Class [186] 
.const [101] = NameAndType [187] [188] 
.const [102] = Class [189] 
.const [103] = NameAndType [190] [191] 
.const [104] = Class [192] 
.const [105] = NameAndType [193] [194] 
.const [106] = Class [195] 
.const [107] = NameAndType [196] [197] 
.const [108] = Utf8 java/lang/NoClassDefFoundError 
.const [109] = Class [198] 
.const [110] = NameAndType [199] [200] 
.const [111] = Class [201] 
.const [112] = NameAndType [202] [203] 
.const [113] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutSection 
.const [114] = Utf8 java/lang/Class 
.const [115] = Utf8 forName 
.const [116] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [117] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [118] = Utf8 eal_api_ITextLayout_SWIGUpcast 
.const [119] = Utf8 (J)J 
.const [120] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [121] = Utf8 delete_eal_api_ITextLayout 
.const [122] = Utf8 (J)V 
.const [123] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [124] = Utf8 new_eal_api_ITextLayout__SWIG_0 
.const [125] = Utf8 ()J 
.const [126] = Utf8 de/esolutions/graphics/eal/api/IFont 
.const [127] = Utf8 getCPtr 
.const [128] = Utf8 (Lde/esolutions/graphics/eal/api/IFont;)J 
.const [129] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [130] = Utf8 new_eal_api_ITextLayout__SWIG_1 
.const [131] = Utf8 (JLde/esolutions/graphics/eal/api/IFont;I)J 
.const [132] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [133] = Utf8 new_eal_api_ITextLayout__SWIG_2 
.const [134] = Utf8 (I)J 
.const [135] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [136] = Utf8 eal_api_ITextLayout_isValid 
.const [137] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;)Z 
.const [138] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [139] = Utf8 eal_api_ITextLayout_setTruncation 
.const [140] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;Z)V 
.const [141] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [142] = Utf8 eal_api_ITextLayout_setMaximumSize 
.const [143] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;JJ)V 
.const [144] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [145] = Utf8 eal_api_ITextLayout_setMaximumLineCount 
.const [146] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;J)V 
.const [147] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [148] = Utf8 eal_api_ITextLayout_setTextLayoutSectionNum 
.const [149] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;J)Z 
.const [150] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [151] = Utf8 eal_api_ITextLayout_getLayoutSection 
.const [152] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;J)J 
.const [153] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [154] = Utf8 eal_api_ITextLayout_print 
.const [155] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;)V 
.const [156] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [157] = Utf8 eal_api_ITextLayout_destroy 
.const [158] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;)Z 
.const [159] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [160] = Utf8 eal_api_ITextLayout_dispose 
.const [161] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;)V 
.const [162] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [163] = Utf8 eal_api_ITextLayout_setPreformattedText 
.const [164] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;Z)Z 
.const [165] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [166] = Utf8 eal_api_ITextLayout_setKerning 
.const [167] = Utf8 (JLde/esolutions/graphics/eal/api/ITextLayout;I)Z 
.const [168] = Utf8 java/lang/NoClassDefFoundError 
.const [169] = Utf8 initCause 
.const [170] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [171] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [172] = Utf8 swigCPtr 
.const [173] = Utf8 J 
.const [174] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [175] = Utf8 delete 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [178] = Utf8 swigCMemOwn 
.const [179] = Utf8 Z 
.const [180] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [181] = Utf8 swigValue 
.const [182] = Utf8 ()I 
.const [183] = Utf8 java/lang/NoClassDefFoundError 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (JZ)V 
.const [189] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [190] = Utf8 delete 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (JZ)V 
.const [195] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutSection 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (JZ)V 
.const [198] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [199] = Utf8 swigCPtr 
.const [200] = Utf8 J 
.const [201] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [202] = Utf8 swigCMemOwn 
.const [203] = Utf8 Z 
.const [204] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [205] = Class [204] 
.const [206] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [207] = Class [206] 
.const [208] = Utf8 swigCPtr 
.const [209] = Utf8 J 
.const [210] = Utf8 class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t 
.const [211] = Utf8 Ljava/lang/Class; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (JZ)V 
.const [215] = Utf8 getCPtr 
.const [216] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout;)J 
.const [217] = Utf8 finalize 
.const [218] = Utf8 ()V 
.const [219] = Utf8 delete 
.const [220] = Utf8 ()V 
.const [221] = Utf8 isDeleted 
.const [222] = Utf8 ()Z 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/graphics/eal/api/IFont;I)V 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (I)V 
.const [229] = Utf8 isValid 
.const [230] = Utf8 ()Z 
.const [231] = Utf8 setTruncation 
.const [232] = Utf8 (Z)V 
.const [233] = Utf8 setMaximumSize 
.const [234] = Utf8 (JJ)V 
.const [235] = Utf8 setMaximumLineCount 
.const [236] = Utf8 (J)V 
.const [237] = Utf8 setTextLayoutSectionNum 
.const [238] = Utf8 (J)Z 
.const [239] = Utf8 getLayoutSection 
.const [240] = Utf8 (J)Lde/esolutions/graphics/eal/api/ITextLayoutSection; 
.const [241] = Utf8 print 
.const [242] = Utf8 ()V 
.const [243] = Utf8 destroy 
.const [244] = Utf8 ()Z 
.const [245] = Utf8 dispose 
.const [246] = Utf8 ()V 
.const [247] = Utf8 setPreformattedText 
.const [248] = Utf8 (Z)Z 
.const [249] = Utf8 setKerning 
.const [250] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t;)Z 
.const [251] = Utf8 class$ 
.const [252] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
