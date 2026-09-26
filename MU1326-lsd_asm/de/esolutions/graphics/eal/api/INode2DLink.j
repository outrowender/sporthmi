.version 50 0 
.class public super [145] 
.super [147] 
.field private [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [24] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [28] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [153] : [154] 
    .attribute [150] .code stack 2 locals 0 
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

.method protected [155] : [156] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [157] : [158] 
    .attribute [150] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
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
L22:    getfield [21] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [28] 
L33:    aload_0 
L34:    invokespecial [25] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [150] .code stack 4 locals 0 
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

.method public [161] : [162] 
    .attribute [150] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [4] 
L5:     aload_1 
L6:     aload_2 
L7:     invokestatic [5] 
L10:    iconst_1 
L11:    invokespecial [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [150] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [6] 
L9:     aload_1 
L10:    invokestatic [7] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [150] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [6] 
L9:     aload_1 
L10:    iload_2 
L11:    invokestatic [8] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     invokestatic [9] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     invokestatic [10] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [150] .code stack 10 locals 2 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     fload_1 
L6:     fload_2 
L7:     fload_3 
L8:     fload 4 
L10:    aload 5 
L12:    invokestatic [11] 
L15:    aload 5 
L17:    invokestatic [12] 
L20:    lstore 6 
L22:    lload 6 
L24:    lconst_0 
L25:    lcmp 
L26:    ifne L33 
L29:    aconst_null 
L30:    goto L43 
L33:    new [30] 
L36:    dup 
L37:    lload 6 
L39:    iconst_1 
L40:    invokespecial [27] 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [150] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     invokestatic [14] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Method [33] [34] 
.const [4] = Method [35] [36] 
.const [5] = Method [37] [38] 
.const [6] = Method [39] [40] 
.const [7] = Method [41] [42] 
.const [8] = Method [43] [44] 
.const [9] = Method [45] [46] 
.const [10] = Method [47] [48] 
.const [11] = Method [49] [50] 
.const [12] = Method [51] [52] 
.const [13] = Class [53] 
.const [14] = Method [54] [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Class [60] 
.const [20] = Class [61] 
.const [21] = Field [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Field [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Field [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Class [80] 
.const [31] = Class [81] 
.const [32] = NameAndType [82] [83] 
.const [33] = Class [84] 
.const [34] = NameAndType [85] [86] 
.const [35] = Class [87] 
.const [36] = NameAndType [88] [89] 
.const [37] = Class [90] 
.const [38] = NameAndType [91] [92] 
.const [39] = Class [93] 
.const [40] = NameAndType [94] [95] 
.const [41] = Class [96] 
.const [42] = NameAndType [97] [98] 
.const [43] = Class [99] 
.const [44] = NameAndType [100] [101] 
.const [45] = Class [102] 
.const [46] = NameAndType [103] [104] 
.const [47] = Class [105] 
.const [48] = NameAndType [106] [107] 
.const [49] = Class [108] 
.const [50] = NameAndType [109] [110] 
.const [51] = Class [111] 
.const [52] = NameAndType [112] [113] 
.const [53] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [54] = Class [114] 
.const [55] = NameAndType [115] [116] 
.const [56] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [57] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [58] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [59] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [60] = Utf8 de/esolutions/graphics/eal/api/INode3DScene 
.const [61] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [62] = Class [117] 
.const [63] = NameAndType [118] [119] 
.const [64] = Class [120] 
.const [65] = NameAndType [121] [122] 
.const [66] = Class [123] 
.const [67] = NameAndType [124] [125] 
.const [68] = Class [126] 
.const [69] = NameAndType [127] [128] 
.const [70] = Class [129] 
.const [71] = NameAndType [130] [131] 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [81] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [82] = Utf8 eal_api_INode2DLink_SWIGUpcast 
.const [83] = Utf8 (J)J 
.const [84] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [85] = Utf8 delete_eal_api_INode2DLink 
.const [86] = Utf8 (J)V 
.const [87] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [88] = Utf8 getCPtr 
.const [89] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [90] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [91] = Utf8 new_eal_api_INode2DLink 
.const [92] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)J 
.const [93] = Utf8 de/esolutions/graphics/eal/api/INode3DScene 
.const [94] = Utf8 getCPtr 
.const [95] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DScene;)J 
.const [96] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [97] = Utf8 eal_api_INode2DLink_setScene__SWIG_0 
.const [98] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;JLde/esolutions/graphics/eal/api/INode3DScene;)Z 
.const [99] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [100] = Utf8 eal_api_INode2DLink_setScene__SWIG_1 
.const [101] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;JLde/esolutions/graphics/eal/api/INode3DScene;Z)Z 
.const [102] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [103] = Utf8 eal_api_INode2DLink_unsetScene 
.const [104] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;)Z 
.const [105] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [106] = Utf8 eal_api_INode2DLink_dispose 
.const [107] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;)V 
.const [108] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [109] = Utf8 getCPtr 
.const [110] = Utf8 (Lde/esolutions/graphics/eal/FlagTexture;)J 
.const [111] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [112] = Utf8 eal_api_INode2DLink_enablePortal 
.const [113] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;FFFFJLde/esolutions/graphics/eal/FlagTexture;)J 
.const [114] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [115] = Utf8 eal_api_INode2DLink_disablePortal 
.const [116] = Utf8 (JLde/esolutions/graphics/eal/api/INode2DLink;)Z 
.const [117] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [118] = Utf8 swigCPtr 
.const [119] = Utf8 J 
.const [120] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [121] = Utf8 delete 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [124] = Utf8 swigCMemOwn 
.const [125] = Utf8 Z 
.const [126] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (JZ)V 
.const [129] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [130] = Utf8 delete 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (JZ)V 
.const [135] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (JZ)V 
.const [138] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [139] = Utf8 swigCPtr 
.const [140] = Utf8 J 
.const [141] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [142] = Utf8 swigCMemOwn 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/esolutions/graphics/eal/api/INode2DLink 
.const [145] = Class [144] 
.const [146] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [147] = Class [146] 
.const [148] = Utf8 swigCPtr 
.const [149] = Utf8 J 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (JZ)V 
.const [153] = Utf8 getCPtr 
.const [154] = Utf8 (Lde/esolutions/graphics/eal/api/INode2DLink;)J 
.const [155] = Utf8 finalize 
.const [156] = Utf8 ()V 
.const [157] = Utf8 delete 
.const [158] = Utf8 ()V 
.const [159] = Utf8 isDeleted 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)V 
.const [163] = Utf8 setScene 
.const [164] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DScene;)Z 
.const [165] = Utf8 setScene 
.const [166] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DScene;Z)Z 
.const [167] = Utf8 unsetScene 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 dispose 
.const [170] = Utf8 ()V 
.const [171] = Utf8 enablePortal 
.const [172] = Utf8 (FFFFLde/esolutions/graphics/eal/FlagTexture;)Lde/esolutions/graphics/eal/api/ITexture; 
.const [173] = Utf8 disablePortal 
.const [174] = Utf8 ()Z 
.end class 
