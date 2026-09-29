.version 50 0 
.class public super [125] 
.super [127] 
.field private [128] [129] 

.method public [131] : [132] 
    .attribute [130] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [21] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [133] : [134] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [17] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [135] : [136] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [137] : [138] 
    .attribute [130] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [19] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [25] 
L21:    aload_0 
L22:    getfield [17] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [24] 
L33:    aload_0 
L34:    invokespecial [22] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [130] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [17] 
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

.method public [141] : [142] 
    .attribute [130] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     invokestatic [4] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [130] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [5] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [6] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [130] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [5] 
L9:     aload_1 
L10:    invokestatic [7] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [130] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [8] 
L9:     lstore_2 
L10:    lload_2 
L11:    lconst_0 
L12:    lcmp 
L13:    ifne L20 
L16:    aconst_null 
L17:    goto L29 
L20:    new [26] 
L23:    dup 
L24:    lload_2 
L25:    iconst_1 
L26:    invokespecial [23] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [130] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     invokestatic [10] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [130] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [20] 
L9:     invokestatic [11] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [27] [28] 
.const [3] = Method [29] [30] 
.const [4] = Method [31] [32] 
.const [5] = Method [33] [34] 
.const [6] = Method [35] [36] 
.const [7] = Method [37] [38] 
.const [8] = Method [39] [40] 
.const [9] = Class [41] 
.const [10] = Method [42] [43] 
.const [11] = Method [44] [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Class [69] 
.const [27] = Class [70] 
.const [28] = NameAndType [71] [72] 
.const [29] = Class [73] 
.const [30] = NameAndType [74] [75] 
.const [31] = Class [76] 
.const [32] = NameAndType [77] [78] 
.const [33] = Class [79] 
.const [34] = NameAndType [80] [81] 
.const [35] = Class [82] 
.const [36] = NameAndType [83] [84] 
.const [37] = Class [85] 
.const [38] = NameAndType [86] [87] 
.const [39] = Class [88] 
.const [40] = NameAndType [89] [90] 
.const [41] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [42] = Class [91] 
.const [43] = NameAndType [92] [93] 
.const [44] = Class [94] 
.const [45] = NameAndType [95] [96] 
.const [46] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [47] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [48] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [49] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [50] = Utf8 de/esolutions/graphics/eal/ealBlendmode_t 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [70] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [71] = Utf8 eal_api_IMaterial_SWIGUpcast 
.const [72] = Utf8 (J)J 
.const [73] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [74] = Utf8 delete_eal_api_IMaterial 
.const [75] = Utf8 (J)V 
.const [76] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [77] = Utf8 eal_api_IMaterial_isValid 
.const [78] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;)Z 
.const [79] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [80] = Utf8 getCPtr 
.const [81] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)J 
.const [82] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [83] = Utf8 eal_api_IMaterial_setTexture__SWIG_0 
.const [84] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;JLde/esolutions/graphics/eal/api/ITexture;Ljava/lang/String;)Z 
.const [85] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [86] = Utf8 eal_api_IMaterial_setTexture__SWIG_1 
.const [87] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;JLde/esolutions/graphics/eal/api/ITexture;)Z 
.const [88] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [89] = Utf8 eal_api_IMaterial_getProperty 
.const [90] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;Ljava/lang/String;)J 
.const [91] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [92] = Utf8 eal_api_IMaterial_dispose 
.const [93] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;)V 
.const [94] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [95] = Utf8 eal_api_IMaterial_setBlendMode 
.const [96] = Utf8 (JLde/esolutions/graphics/eal/api/IMaterial;I)Z 
.const [97] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [98] = Utf8 swigCPtr 
.const [99] = Utf8 J 
.const [100] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [101] = Utf8 delete 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [104] = Utf8 swigCMemOwn 
.const [105] = Utf8 Z 
.const [106] = Utf8 de/esolutions/graphics/eal/ealBlendmode_t 
.const [107] = Utf8 swigValue 
.const [108] = Utf8 ()I 
.const [109] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (JZ)V 
.const [112] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [113] = Utf8 delete 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/esolutions/graphics/eal/api/IProperty 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (JZ)V 
.const [118] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [119] = Utf8 swigCPtr 
.const [120] = Utf8 J 
.const [121] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [122] = Utf8 swigCMemOwn 
.const [123] = Utf8 Z 
.const [124] = Utf8 de/esolutions/graphics/eal/api/IMaterial 
.const [125] = Class [124] 
.const [126] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [127] = Class [126] 
.const [128] = Utf8 swigCPtr 
.const [129] = Utf8 J 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (JZ)V 
.const [133] = Utf8 getCPtr 
.const [134] = Utf8 (Lde/esolutions/graphics/eal/api/IMaterial;)J 
.const [135] = Utf8 finalize 
.const [136] = Utf8 ()V 
.const [137] = Utf8 delete 
.const [138] = Utf8 ()V 
.const [139] = Utf8 isDeleted 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 isValid 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 setTexture 
.const [144] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;Ljava/lang/String;)Z 
.const [145] = Utf8 setTexture 
.const [146] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;)Z 
.const [147] = Utf8 getProperty 
.const [148] = Utf8 (Ljava/lang/String;)Lde/esolutions/graphics/eal/api/IProperty; 
.const [149] = Utf8 dispose 
.const [150] = Utf8 ()V 
.const [151] = Utf8 setBlendMode 
.const [152] = Utf8 (Lde/esolutions/graphics/eal/ealBlendmode_t;)Z 
.end class 
