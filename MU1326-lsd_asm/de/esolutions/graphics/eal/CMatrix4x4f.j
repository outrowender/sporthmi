.version 50 0 
.class public super [77] 
.super [79] 
.field private [80] [81] 
.field protected [82] [83] 

.method public [85] : [86] 
    .attribute [84] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [14] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [15] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [87] : [88] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [10] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [89] : [90] 
    .attribute [84] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [91] : [92] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [9] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [14] 
L21:    aload_0 
L22:    getfield [10] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [15] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
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

.method public [95] : [96] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [3] 
L4:     iconst_1 
L5:     invokespecial [13] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [84] .code stack 9 locals 0 
L0:     new [16] 
L3:     dup 
L4:     aload_0 
L5:     getfield [10] 
L8:     aload_0 
L9:     aload_1 
L10:    invokestatic [5] 
L13:    aload_1 
L14:    fload_2 
L15:    invokestatic [6] 
L18:    iconst_1 
L19:    invokespecial [13] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [17] [18] 
.const [3] = Method [19] [20] 
.const [4] = Class [21] 
.const [5] = Method [22] [23] 
.const [6] = Method [24] [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Field [28] [29] 
.const [10] = Field [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Class [42] 
.const [17] = Class [43] 
.const [18] = NameAndType [44] [45] 
.const [19] = Class [46] 
.const [20] = NameAndType [47] [48] 
.const [21] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [22] = Class [49] 
.const [23] = NameAndType [50] [51] 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [28] = Class [55] 
.const [29] = NameAndType [56] [57] 
.const [30] = Class [58] 
.const [31] = NameAndType [59] [60] 
.const [32] = Class [61] 
.const [33] = NameAndType [62] [63] 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [43] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [44] = Utf8 delete_eal_CMatrix4x4f 
.const [45] = Utf8 (J)V 
.const [46] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [47] = Utf8 new_eal_CMatrix4x4f 
.const [48] = Utf8 ()J 
.const [49] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [50] = Utf8 getCPtr 
.const [51] = Utf8 (Lde/esolutions/graphics/eal/CMatrix4x4f;)J 
.const [52] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [53] = Utf8 eal_CMatrix4x4f_interpolate 
.const [54] = Utf8 (JLde/esolutions/graphics/eal/CMatrix4x4f;JLde/esolutions/graphics/eal/CMatrix4x4f;F)J 
.const [55] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [56] = Utf8 swigCMemOwn 
.const [57] = Utf8 Z 
.const [58] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [59] = Utf8 swigCPtr 
.const [60] = Utf8 J 
.const [61] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [62] = Utf8 delete 
.const [63] = Utf8 ()V 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [68] = Utf8 <init> 
.const [69] = Utf8 (JZ)V 
.const [70] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [71] = Utf8 swigCMemOwn 
.const [72] = Utf8 Z 
.const [73] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [74] = Utf8 swigCPtr 
.const [75] = Utf8 J 
.const [76] = Utf8 de/esolutions/graphics/eal/CMatrix4x4f 
.const [77] = Class [76] 
.const [78] = Utf8 java/lang/Object 
.const [79] = Class [78] 
.const [80] = Utf8 swigCPtr 
.const [81] = Utf8 J 
.const [82] = Utf8 swigCMemOwn 
.const [83] = Utf8 Z 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (JZ)V 
.const [87] = Utf8 getCPtr 
.const [88] = Utf8 (Lde/esolutions/graphics/eal/CMatrix4x4f;)J 
.const [89] = Utf8 finalize 
.const [90] = Utf8 ()V 
.const [91] = Utf8 delete 
.const [92] = Utf8 ()V 
.const [93] = Utf8 isDeleted 
.const [94] = Utf8 ()Z 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 interpolate 
.const [98] = Utf8 (Lde/esolutions/graphics/eal/CMatrix4x4f;F)Lde/esolutions/graphics/eal/CMatrix4x4f; 
.end class 
