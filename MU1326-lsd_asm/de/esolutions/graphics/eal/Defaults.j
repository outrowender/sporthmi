.version 50 0 
.class public super [83] 
.super [85] 
.field private [86] [87] 
.field protected [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [16] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [93] : [94] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [11] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [95] : [96] 
    .attribute [90] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [97] : [98] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [10] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [16] 
L21:    aload_0 
L22:    getfield [11] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [17] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
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

.method public static [101] : [102] 
    .attribute [90] .code stack 5 locals 0 
L0:     new [18] 
L3:     dup 
L4:     invokestatic [4] 
L7:     iconst_1 
L8:     invokespecial [14] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [103] : [104] 
    .attribute [90] .code stack 5 locals 0 
L0:     new [19] 
L3:     dup 
L4:     invokestatic [6] 
L7:     iconst_1 
L8:     invokespecial [15] 
L11:    areturn 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = Class [22] 
.const [4] = Method [23] [24] 
.const [5] = Class [25] 
.const [6] = Method [26] [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Field [31] [32] 
.const [11] = Field [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Class [47] 
.const [19] = Class [48] 
.const [20] = Class [49] 
.const [21] = NameAndType [50] [51] 
.const [22] = Utf8 de/esolutions/graphics/eal/FlagImage 
.const [23] = Class [52] 
.const [24] = NameAndType [53] [54] 
.const [25] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [31] = Class [58] 
.const [32] = NameAndType [59] [60] 
.const [33] = Class [61] 
.const [34] = NameAndType [62] [63] 
.const [35] = Class [64] 
.const [36] = NameAndType [65] [66] 
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
.const [47] = Utf8 de/esolutions/graphics/eal/FlagImage 
.const [48] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [49] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [50] = Utf8 delete_eal_Defaults 
.const [51] = Utf8 (J)V 
.const [52] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [53] = Utf8 eal_Defaults_getFlagsImage 
.const [54] = Utf8 ()J 
.const [55] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [56] = Utf8 eal_Defaults_getFlagsTexture 
.const [57] = Utf8 ()J 
.const [58] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [59] = Utf8 swigCMemOwn 
.const [60] = Utf8 Z 
.const [61] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [62] = Utf8 swigCPtr 
.const [63] = Utf8 J 
.const [64] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [65] = Utf8 delete 
.const [66] = Utf8 ()V 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/esolutions/graphics/eal/FlagImage 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (JZ)V 
.const [73] = Utf8 de/esolutions/graphics/eal/FlagTexture 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (JZ)V 
.const [76] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [77] = Utf8 swigCMemOwn 
.const [78] = Utf8 Z 
.const [79] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [80] = Utf8 swigCPtr 
.const [81] = Utf8 J 
.const [82] = Utf8 de/esolutions/graphics/eal/Defaults 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 swigCPtr 
.const [87] = Utf8 J 
.const [88] = Utf8 swigCMemOwn 
.const [89] = Utf8 Z 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (JZ)V 
.const [93] = Utf8 getCPtr 
.const [94] = Utf8 (Lde/esolutions/graphics/eal/Defaults;)J 
.const [95] = Utf8 finalize 
.const [96] = Utf8 ()V 
.const [97] = Utf8 delete 
.const [98] = Utf8 ()V 
.const [99] = Utf8 isDeleted 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 getFlagsImage 
.const [102] = Utf8 ()Lde/esolutions/graphics/eal/FlagImage; 
.const [103] = Utf8 getFlagsTexture 
.const [104] = Utf8 ()Lde/esolutions/graphics/eal/FlagTexture; 
.end class 
