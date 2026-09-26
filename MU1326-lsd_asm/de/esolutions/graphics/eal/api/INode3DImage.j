.version 50 0 
.class public super [207] 
.super [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [35] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [39] 
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
L9:     getfield [32] 
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
L1:     invokevirtual [33] 
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
L1:     getfield [32] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [34] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [40] 
L21:    aload_0 
L22:    getfield [32] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [39] 
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
L1:     getfield [32] 
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
L1:     aload_1 
L2:     invokestatic [4] 
L5:     aload_1 
L6:     invokestatic [5] 
L9:     iconst_1 
L10:    invokespecial [37] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [212] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [6] 
L5:     aload_1 
L6:     aload_2 
L7:     invokestatic [7] 
L10:    iconst_1 
L11:    invokespecial [37] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [212] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [6] 
L5:     aload_1 
L6:     aload_2 
L7:     aload_3 
L8:     invokestatic [8] 
L11:    aload_3 
L12:    invokestatic [9] 
L15:    iconst_1 
L16:    invokespecial [37] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [212] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [8] 
L9:     aload_1 
L10:    invokestatic [10] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [11] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [12] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [212] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [13] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [41] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [38] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [15] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [212] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [16] 
L9:     aload_1 
L10:    invokestatic [17] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [212] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [18] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [212] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [19] 
L9:     aload_1 
L10:    invokestatic [20] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [21] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [22] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     invokestatic [23] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [212] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_0 
L5:     fload_1 
L6:     fload_2 
L7:     fload_3 
L8:     fload 4 
L10:    invokestatic [24] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [42] [43] 
.const [3] = Method [44] [45] 
.const [4] = Method [46] [47] 
.const [5] = Method [48] [49] 
.const [6] = Method [50] [51] 
.const [7] = Method [52] [53] 
.const [8] = Method [54] [55] 
.const [9] = Method [56] [57] 
.const [10] = Method [58] [59] 
.const [11] = Method [60] [61] 
.const [12] = Method [62] [63] 
.const [13] = Method [64] [65] 
.const [14] = Class [66] 
.const [15] = Method [67] [68] 
.const [16] = Method [69] [70] 
.const [17] = Method [71] [72] 
.const [18] = Method [73] [74] 
.const [19] = Method [75] [76] 
.const [20] = Method [77] [78] 
.const [21] = Method [79] [80] 
.const [22] = Method [81] [82] 
.const [23] = Method [83] [84] 
.const [24] = Method [85] [86] 
.const [25] = Class [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Class [90] 
.const [29] = Class [91] 
.const [30] = Class [92] 
.const [31] = Class [93] 
.const [32] = Field [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Field [110] [111] 
.const [41] = Class [112] 
.const [42] = Class [113] 
.const [43] = NameAndType [114] [115] 
.const [44] = Class [116] 
.const [45] = NameAndType [117] [118] 
.const [46] = Class [119] 
.const [47] = NameAndType [120] [121] 
.const [48] = Class [122] 
.const [49] = NameAndType [123] [124] 
.const [50] = Class [125] 
.const [51] = NameAndType [126] [127] 
.const [52] = Class [128] 
.const [53] = NameAndType [129] [130] 
.const [54] = Class [131] 
.const [55] = NameAndType [132] [133] 
.const [56] = Class [134] 
.const [57] = NameAndType [135] [136] 
.const [58] = Class [137] 
.const [59] = NameAndType [138] [139] 
.const [60] = Class [140] 
.const [61] = NameAndType [141] [142] 
.const [62] = Class [143] 
.const [63] = NameAndType [144] [145] 
.const [64] = Class [146] 
.const [65] = NameAndType [147] [148] 
.const [66] = Utf8 de/esolutions/graphics/eal/api/IINodeImage 
.const [67] = Class [149] 
.const [68] = NameAndType [150] [151] 
.const [69] = Class [152] 
.const [70] = NameAndType [153] [154] 
.const [71] = Class [155] 
.const [72] = NameAndType [156] [157] 
.const [73] = Class [158] 
.const [74] = NameAndType [159] [160] 
.const [75] = Class [161] 
.const [76] = NameAndType [162] [163] 
.const [77] = Class [164] 
.const [78] = NameAndType [165] [166] 
.const [79] = Class [167] 
.const [80] = NameAndType [168] [169] 
.const [81] = Class [170] 
.const [82] = NameAndType [171] [172] 
.const [83] = Class [173] 
.const [84] = NameAndType [174] [175] 
.const [85] = Class [176] 
.const [86] = NameAndType [177] [178] 
.const [87] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [88] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [89] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [90] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [91] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [92] = Utf8 de/esolutions/graphics/eal/colorRGBAf 
.const [93] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [94] = Class [179] 
.const [95] = NameAndType [180] [181] 
.const [96] = Class [182] 
.const [97] = NameAndType [183] [184] 
.const [98] = Class [185] 
.const [99] = NameAndType [186] [187] 
.const [100] = Class [188] 
.const [101] = NameAndType [189] [190] 
.const [102] = Class [191] 
.const [103] = NameAndType [192] [193] 
.const [104] = Class [194] 
.const [105] = NameAndType [195] [196] 
.const [106] = Class [197] 
.const [107] = NameAndType [198] [199] 
.const [108] = Class [200] 
.const [109] = NameAndType [201] [202] 
.const [110] = Class [203] 
.const [111] = NameAndType [204] [205] 
.const [112] = Utf8 de/esolutions/graphics/eal/api/IINodeImage 
.const [113] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [114] = Utf8 eal_api_INode3DImage_SWIGUpcast 
.const [115] = Utf8 (J)J 
.const [116] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [117] = Utf8 delete_eal_api_INode3DImage 
.const [118] = Utf8 (J)V 
.const [119] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [120] = Utf8 getCPtr 
.const [121] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;)J 
.const [122] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [123] = Utf8 new_eal_api_INode3DImage__SWIG_0 
.const [124] = Utf8 (JLde/esolutions/graphics/eal/api/INode3D;)J 
.const [125] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [126] = Utf8 getCPtr 
.const [127] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [128] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [129] = Utf8 new_eal_api_INode3DImage__SWIG_1 
.const [130] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)J 
.const [131] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [132] = Utf8 getCPtr 
.const [133] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)J 
.const [134] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [135] = Utf8 new_eal_api_INode3DImage__SWIG_2 
.const [136] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JLde/esolutions/graphics/eal/api/ITexture;)J 
.const [137] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [138] = Utf8 eal_api_INode3DImage_setTexture 
.const [139] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;JLde/esolutions/graphics/eal/api/ITexture;)Z 
.const [140] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [141] = Utf8 eal_api_INode3DImage_getWidth 
.const [142] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)J 
.const [143] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [144] = Utf8 eal_api_INode3DImage_getHeight 
.const [145] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)J 
.const [146] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [147] = Utf8 eal_api_INode3DImage_getInterfaceImage 
.const [148] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)J 
.const [149] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [150] = Utf8 eal_api_INode3DImage_dispose 
.const [151] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)V 
.const [152] = Utf8 de/esolutions/graphics/eal/colorRGBAf 
.const [153] = Utf8 getCPtr 
.const [154] = Utf8 (Lde/esolutions/graphics/eal/colorRGBAf;)J 
.const [155] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [156] = Utf8 eal_api_INode3DImage_setModulateColor__SWIG_0 
.const [157] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;JLde/esolutions/graphics/eal/colorRGBAf;)Z 
.const [158] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [159] = Utf8 eal_api_INode3DImage_setModulateColor__SWIG_1 
.const [160] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;J)Z 
.const [161] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [162] = Utf8 getCPtr 
.const [163] = Utf8 (Lde/esolutions/graphics/eal/api/IMaterial;)J 
.const [164] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [165] = Utf8 eal_api_INode3DImage_setMaterial 
.const [166] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;JLde/esolutions/graphics/eal/api/IMaterial;)Z 
.const [167] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [168] = Utf8 eal_api_INode3DImage_flipX 
.const [169] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)Z 
.const [170] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [171] = Utf8 eal_api_INode3DImage_flipY 
.const [172] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)Z 
.const [173] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [174] = Utf8 eal_api_INode3DImage_flipXY 
.const [175] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;)Z 
.const [176] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [177] = Utf8 eal_api_INode3DImage_clipImage 
.const [178] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DImage;FFFF)Z 
.const [179] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [180] = Utf8 swigCPtr 
.const [181] = Utf8 J 
.const [182] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [183] = Utf8 delete 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [186] = Utf8 swigCMemOwn 
.const [187] = Utf8 Z 
.const [188] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (JZ)V 
.const [191] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [192] = Utf8 delete 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (JZ)V 
.const [197] = Utf8 de/esolutions/graphics/eal/api/IINodeImage 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (JZ)V 
.const [200] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [201] = Utf8 swigCPtr 
.const [202] = Utf8 J 
.const [203] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [204] = Utf8 swigCMemOwn 
.const [205] = Utf8 Z 
.const [206] = Utf8 de/esolutions/graphics/eal/api/INode3DImage 
.const [207] = Class [206] 
.const [208] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [209] = Class [208] 
.const [210] = Utf8 swigCPtr 
.const [211] = Utf8 J 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (JZ)V 
.const [215] = Utf8 getCPtr 
.const [216] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DImage;)J 
.const [217] = Utf8 finalize 
.const [218] = Utf8 ()V 
.const [219] = Utf8 delete 
.const [220] = Utf8 ()V 
.const [221] = Utf8 isDeleted 
.const [222] = Utf8 ()Z 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;)V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)V 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;Lde/esolutions/graphics/eal/api/ITexture;)V 
.const [229] = Utf8 setTexture 
.const [230] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)Z 
.const [231] = Utf8 getWidth 
.const [232] = Utf8 ()J 
.const [233] = Utf8 getHeight 
.const [234] = Utf8 ()J 
.const [235] = Utf8 getInterfaceImage 
.const [236] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeImage; 
.const [237] = Utf8 dispose 
.const [238] = Utf8 ()V 
.const [239] = Utf8 setModulateColor 
.const [240] = Utf8 (Lde/esolutions/graphics/eal/colorRGBAf;)Z 
.const [241] = Utf8 setModulateColor 
.const [242] = Utf8 (J)Z 
.const [243] = Utf8 setMaterial 
.const [244] = Utf8 (Lde/esolutions/graphics/eal/api/IMaterial;)Z 
.const [245] = Utf8 flipX 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 flipY 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 flipXY 
.const [250] = Utf8 ()Z 
.const [251] = Utf8 clipImage 
.const [252] = Utf8 (FFFF)Z 
.end class 
