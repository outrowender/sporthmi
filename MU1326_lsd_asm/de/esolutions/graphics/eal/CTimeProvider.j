.version 50 0 
.class public super [75] 
.super [77] 
.field private [78] [79] 
.field protected [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 3 locals 0 
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

.method public static [85] : [86] 
    .attribute [82] .code stack 2 locals 0 
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

.method protected [87] : [88] 
    .attribute [82] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [89] : [90] 
    .attribute [82] .code stack 4 locals 0 
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

.method public [91] : [92] 
    .attribute [82] .code stack 4 locals 0 
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

.method public static [93] : [94] 
    .attribute [82] .code stack 1 locals 0 
L0:     invokestatic [3] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public static [95] : [96] 
    .attribute [82] .code stack 1 locals 0 
L0:     invokestatic [4] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [82] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [5] 
L4:     iconst_1 
L5:     invokespecial [13] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [16] [17] 
.const [3] = Method [18] [19] 
.const [4] = Method [20] [21] 
.const [5] = Method [22] [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Field [27] [28] 
.const [10] = Field [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Class [41] 
.const [17] = NameAndType [42] [43] 
.const [18] = Class [44] 
.const [19] = NameAndType [45] [46] 
.const [20] = Class [47] 
.const [21] = NameAndType [48] [49] 
.const [22] = Class [50] 
.const [23] = NameAndType [51] [52] 
.const [24] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [27] = Class [53] 
.const [28] = NameAndType [54] [55] 
.const [29] = Class [56] 
.const [30] = NameAndType [57] [58] 
.const [31] = Class [59] 
.const [32] = NameAndType [60] [61] 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [42] = Utf8 delete_eal_CTimeProvider 
.const [43] = Utf8 (J)V 
.const [44] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [45] = Utf8 eal_CTimeProvider_getTime 
.const [46] = Utf8 ()Ljava/math/BigInteger; 
.const [47] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [48] = Utf8 eal_CTimeProvider_getDeltaTime 
.const [49] = Utf8 ()Ljava/math/BigInteger; 
.const [50] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [51] = Utf8 new_eal_CTimeProvider 
.const [52] = Utf8 ()J 
.const [53] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [54] = Utf8 swigCMemOwn 
.const [55] = Utf8 Z 
.const [56] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [57] = Utf8 swigCPtr 
.const [58] = Utf8 J 
.const [59] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [60] = Utf8 delete 
.const [61] = Utf8 ()V 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (JZ)V 
.const [68] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [69] = Utf8 swigCMemOwn 
.const [70] = Utf8 Z 
.const [71] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [72] = Utf8 swigCPtr 
.const [73] = Utf8 J 
.const [74] = Utf8 de/esolutions/graphics/eal/CTimeProvider 
.const [75] = Class [74] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [76] 
.const [78] = Utf8 swigCPtr 
.const [79] = Utf8 J 
.const [80] = Utf8 swigCMemOwn 
.const [81] = Utf8 Z 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (JZ)V 
.const [85] = Utf8 getCPtr 
.const [86] = Utf8 (Lde/esolutions/graphics/eal/CTimeProvider;)J 
.const [87] = Utf8 finalize 
.const [88] = Utf8 ()V 
.const [89] = Utf8 delete 
.const [90] = Utf8 ()V 
.const [91] = Utf8 isDeleted 
.const [92] = Utf8 ()Z 
.const [93] = Utf8 getTime 
.const [94] = Utf8 ()Ljava/math/BigInteger; 
.const [95] = Utf8 getDeltaTime 
.const [96] = Utf8 ()Ljava/math/BigInteger; 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.end class 
