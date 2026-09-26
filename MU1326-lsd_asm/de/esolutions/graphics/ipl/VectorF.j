.version 50 0 
.class public super [105] 
.super [107] 
.field private [108] [109] 
.field protected [110] [111] 

.method public [113] : [114] 
    .attribute [112] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [19] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [115] : [116] 
    .attribute [112] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [15] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [117] : [118] 
    .attribute [112] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [119] : [120] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [14] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [19] 
L21:    aload_0 
L22:    getfield [15] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [20] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
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

.method public [123] : [124] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokestatic [3] 
L4:     iconst_1 
L5:     invokespecial [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [4] 
L5:     iconst_1 
L6:     invokespecial [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [112] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [112] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [112] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     lload_1 
L6:     invokestatic [7] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [112] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     invokestatic [8] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [112] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     invokestatic [9] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     fload_1 
L6:     invokestatic [10] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [21] [22] 
.const [3] = Method [23] [24] 
.const [4] = Method [25] [26] 
.const [5] = Method [27] [28] 
.const [6] = Method [29] [30] 
.const [7] = Method [31] [32] 
.const [8] = Method [33] [34] 
.const [9] = Method [35] [36] 
.const [10] = Method [37] [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Class [56] 
.const [22] = NameAndType [57] [58] 
.const [23] = Class [59] 
.const [24] = NameAndType [60] [61] 
.const [25] = Class [62] 
.const [26] = NameAndType [63] [64] 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Class [68] 
.const [30] = NameAndType [69] [70] 
.const [31] = Class [71] 
.const [32] = NameAndType [72] [73] 
.const [33] = Class [74] 
.const [34] = NameAndType [75] [76] 
.const [35] = Class [77] 
.const [36] = NameAndType [78] [79] 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [57] = Utf8 delete_ipl_VectorF 
.const [58] = Utf8 (J)V 
.const [59] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [60] = Utf8 new_ipl_VectorF__SWIG_0 
.const [61] = Utf8 ()J 
.const [62] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [63] = Utf8 new_ipl_VectorF__SWIG_1 
.const [64] = Utf8 (J)J 
.const [65] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [66] = Utf8 ipl_VectorF_size 
.const [67] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;)J 
.const [68] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [69] = Utf8 ipl_VectorF_capacity 
.const [70] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;)J 
.const [71] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [72] = Utf8 ipl_VectorF_reserve 
.const [73] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;J)V 
.const [74] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [75] = Utf8 ipl_VectorF_isEmpty 
.const [76] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;)Z 
.const [77] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [78] = Utf8 ipl_VectorF_clear 
.const [79] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;)V 
.const [80] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [81] = Utf8 ipl_VectorF_add 
.const [82] = Utf8 (JLde/esolutions/graphics/ipl/VectorF;F)V 
.const [83] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [84] = Utf8 swigCMemOwn 
.const [85] = Utf8 Z 
.const [86] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [87] = Utf8 swigCPtr 
.const [88] = Utf8 J 
.const [89] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [90] = Utf8 delete 
.const [91] = Utf8 ()V 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (JZ)V 
.const [98] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [99] = Utf8 swigCMemOwn 
.const [100] = Utf8 Z 
.const [101] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [102] = Utf8 swigCPtr 
.const [103] = Utf8 J 
.const [104] = Utf8 de/esolutions/graphics/ipl/VectorF 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 swigCPtr 
.const [109] = Utf8 J 
.const [110] = Utf8 swigCMemOwn 
.const [111] = Utf8 Z 
.const [112] = Utf8 Code 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (JZ)V 
.const [115] = Utf8 getCPtr 
.const [116] = Utf8 (Lde/esolutions/graphics/ipl/VectorF;)J 
.const [117] = Utf8 finalize 
.const [118] = Utf8 ()V 
.const [119] = Utf8 delete 
.const [120] = Utf8 ()V 
.const [121] = Utf8 isDeleted 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (J)V 
.const [127] = Utf8 size 
.const [128] = Utf8 ()J 
.const [129] = Utf8 capacity 
.const [130] = Utf8 ()J 
.const [131] = Utf8 reserve 
.const [132] = Utf8 (J)V 
.const [133] = Utf8 isEmpty 
.const [134] = Utf8 ()Z 
.const [135] = Utf8 clear 
.const [136] = Utf8 ()V 
.const [137] = Utf8 add 
.const [138] = Utf8 (F)V 
.end class 
