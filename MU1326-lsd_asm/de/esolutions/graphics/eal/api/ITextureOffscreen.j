.version 50 0 
.class public super [103] 
.super [105] 
.field private [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [111] : [112] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [14] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [115] : [116] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [16] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [21] 
L21:    aload_0 
L22:    getfield [14] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [20] 
L33:    aload_0 
L34:    invokespecial [18] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
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

.method public [119] : [120] 
    .attribute [108] .code stack 9 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [4] 
L5:     aload_1 
L6:     aload_2 
L7:     lload_3 
L8:     lload 5 
L10:    invokestatic [5] 
L13:    iconst_1 
L14:    invokespecial [19] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [108] .code stack 12 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [4] 
L5:     aload_1 
L6:     aload_2 
L7:     lload_3 
L8:     lload 5 
L10:    aload 7 
L12:    invokestatic [6] 
L15:    aload 7 
L17:    invokestatic [7] 
L20:    iconst_1 
L21:    invokespecial [19] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [108] .code stack 13 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [4] 
L5:     aload_1 
L6:     aload_2 
L7:     lload_3 
L8:     lload 5 
L10:    aload 7 
L12:    invokestatic [6] 
L15:    aload 7 
L17:    iload 8 
L19:    invokestatic [8] 
L22:    iconst_1 
L23:    invokespecial [19] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Method [24] [25] 
.const [4] = Method [26] [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = Method [32] [33] 
.const [8] = Method [34] [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Class [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Field [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = Class [57] 
.const [23] = NameAndType [58] [59] 
.const [24] = Class [60] 
.const [25] = NameAndType [61] [62] 
.const [26] = Class [63] 
.const [27] = NameAndType [64] [65] 
.const [28] = Class [66] 
.const [29] = NameAndType [67] [68] 
.const [30] = Class [69] 
.const [31] = NameAndType [70] [71] 
.const [32] = Class [72] 
.const [33] = NameAndType [73] [74] 
.const [34] = Class [75] 
.const [35] = NameAndType [76] [77] 
.const [36] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [37] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [38] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [39] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [40] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [58] = Utf8 eal_api_ITextureOffscreen_SWIGUpcast 
.const [59] = Utf8 (J)J 
.const [60] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [61] = Utf8 delete_eal_api_ITextureOffscreen 
.const [62] = Utf8 (J)V 
.const [63] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [64] = Utf8 getCPtr 
.const [65] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [66] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [67] = Utf8 new_eal_api_ITextureOffscreen__SWIG_0 
.const [68] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJ)J 
.const [69] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [70] = Utf8 getCPtr 
.const [71] = Utf8 (Lde/esolutions/graphics/eal/FlagTexture;)J 
.const [72] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [73] = Utf8 new_eal_api_ITextureOffscreen__SWIG_1 
.const [74] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJJLde/esolutions/graphics/eal/FlagTexture;)J 
.const [75] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [76] = Utf8 new_eal_api_ITextureOffscreen__SWIG_2 
.const [77] = Utf8 (JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJJLde/esolutions/graphics/eal/FlagTexture;Z)J 
.const [78] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [79] = Utf8 swigCPtr 
.const [80] = Utf8 J 
.const [81] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [82] = Utf8 delete 
.const [83] = Utf8 ()V 
.const [84] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [85] = Utf8 swigCMemOwn 
.const [86] = Utf8 Z 
.const [87] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (JZ)V 
.const [90] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [91] = Utf8 delete 
.const [92] = Utf8 ()V 
.const [93] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (JZ)V 
.const [96] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [97] = Utf8 swigCPtr 
.const [98] = Utf8 J 
.const [99] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [100] = Utf8 swigCMemOwn 
.const [101] = Utf8 Z 
.const [102] = Utf8 de/esolutions/graphics/eal/api/ITextureOffscreen 
.const [103] = Class [102] 
.const [104] = Utf8 de/esolutions/graphics/eal/api/ITexture 
.const [105] = Class [104] 
.const [106] = Utf8 swigCPtr 
.const [107] = Utf8 J 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (JZ)V 
.const [111] = Utf8 getCPtr 
.const [112] = Utf8 (Lde/esolutions/graphics/eal/api/ITextureOffscreen;)J 
.const [113] = Utf8 finalize 
.const [114] = Utf8 ()V 
.const [115] = Utf8 delete 
.const [116] = Utf8 ()V 
.const [117] = Utf8 isDeleted 
.const [118] = Utf8 ()Z 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJ)V 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJLde/esolutions/graphics/eal/FlagTexture;)V 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;JJLde/esolutions/graphics/eal/FlagTexture;Z)V 
.end class 
