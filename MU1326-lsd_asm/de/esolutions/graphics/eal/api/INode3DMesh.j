.version 50 0 
.class public super [97] 
.super [99] 
.field private [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [15] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [105] : [106] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [12] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [107] : [108] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [109] : [110] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [12] 
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
L22:    getfield [12] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [18] 
L33:    aload_0 
L34:    invokespecial [16] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [12] 
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

.method public [113] : [114] 
    .attribute [102] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_0 
L5:     invokestatic [4] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [20] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [17] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [102] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [12] 
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

.method public [117] : [118] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_0 
L5:     invokestatic [8] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [21] [22] 
.const [3] = Method [23] [24] 
.const [4] = Method [25] [26] 
.const [5] = Class [27] 
.const [6] = Method [28] [29] 
.const [7] = Method [30] [31] 
.const [8] = Method [32] [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Field [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Class [53] 
.const [21] = Class [54] 
.const [22] = NameAndType [55] [56] 
.const [23] = Class [57] 
.const [24] = NameAndType [58] [59] 
.const [25] = Class [60] 
.const [26] = NameAndType [61] [62] 
.const [27] = Utf8 de/esolutions/graphics/eal/api/IMeshData 
.const [28] = Class [63] 
.const [29] = NameAndType [64] [65] 
.const [30] = Class [66] 
.const [31] = NameAndType [67] [68] 
.const [32] = Class [69] 
.const [33] = NameAndType [70] [71] 
.const [34] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [35] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [36] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [37] = Class [72] 
.const [38] = NameAndType [73] [74] 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
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
.const [53] = Utf8 de/esolutions/graphics/eal/api/IMeshData 
.const [54] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [55] = Utf8 eal_api_INode3DMesh_SWIGUpcast 
.const [56] = Utf8 (J)J 
.const [57] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [58] = Utf8 delete_eal_api_INode3DMesh 
.const [59] = Utf8 (J)V 
.const [60] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [61] = Utf8 eal_api_INode3DMesh_getData 
.const [62] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DMesh;)J 
.const [63] = Utf8 de/esolutions/graphics/eal/api/IMeshData 
.const [64] = Utf8 getCPtr 
.const [65] = Utf8 (Lde/esolutions/graphics/eal/api/IMeshData;)J 
.const [66] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [67] = Utf8 eal_api_INode3DMesh_setData 
.const [68] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DMesh;JLde/esolutions/graphics/eal/api/IMeshData;)Z 
.const [69] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [70] = Utf8 eal_api_INode3DMesh_dispose 
.const [71] = Utf8 (JLde/esolutions/graphics/eal/api/INode3DMesh;)V 
.const [72] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [73] = Utf8 swigCPtr 
.const [74] = Utf8 J 
.const [75] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [76] = Utf8 delete 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [79] = Utf8 swigCMemOwn 
.const [80] = Utf8 Z 
.const [81] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (JZ)V 
.const [84] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [85] = Utf8 delete 
.const [86] = Utf8 ()V 
.const [87] = Utf8 de/esolutions/graphics/eal/api/IMeshData 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (JZ)V 
.const [90] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [91] = Utf8 swigCPtr 
.const [92] = Utf8 J 
.const [93] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [94] = Utf8 swigCMemOwn 
.const [95] = Utf8 Z 
.const [96] = Utf8 de/esolutions/graphics/eal/api/INode3DMesh 
.const [97] = Class [96] 
.const [98] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [99] = Class [98] 
.const [100] = Utf8 swigCPtr 
.const [101] = Utf8 J 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (JZ)V 
.const [105] = Utf8 getCPtr 
.const [106] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DMesh;)J 
.const [107] = Utf8 finalize 
.const [108] = Utf8 ()V 
.const [109] = Utf8 delete 
.const [110] = Utf8 ()V 
.const [111] = Utf8 isDeleted 
.const [112] = Utf8 ()Z 
.const [113] = Utf8 getData 
.const [114] = Utf8 ()Lde/esolutions/graphics/eal/api/IMeshData; 
.const [115] = Utf8 setData 
.const [116] = Utf8 (Lde/esolutions/graphics/eal/api/IMeshData;)Z 
.const [117] = Utf8 dispose 
.const [118] = Utf8 ()V 
.end class 
