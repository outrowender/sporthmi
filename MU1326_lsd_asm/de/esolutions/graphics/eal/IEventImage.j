.version 50 0 
.class public super [85] 
.super [87] 
.field private [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [13] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [16] 
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
L9:     getfield [10] 
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
L1:     invokevirtual [11] 
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
L1:     getfield [10] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [12] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [17] 
L21:    aload_0 
L22:    getfield [10] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [16] 
L33:    aload_0 
L34:    invokespecial [14] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [90] .code stack 4 locals 0 
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

.method public [101] : [102] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     invokestatic [4] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [90] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [18] 
L22:    dup 
L23:    lload_1 
L24:    iconst_0 
L25:    invokespecial [15] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [19] [20] 
.const [3] = Method [21] [22] 
.const [4] = Method [23] [24] 
.const [5] = Method [25] [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Field [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Class [47] 
.const [19] = Class [48] 
.const [20] = NameAndType [49] [50] 
.const [21] = Class [51] 
.const [22] = NameAndType [52] [53] 
.const [23] = Class [54] 
.const [24] = NameAndType [55] [56] 
.const [25] = Class [57] 
.const [26] = NameAndType [58] [59] 
.const [27] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [28] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [29] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [30] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Class [63] 
.const [34] = NameAndType [64] [65] 
.const [35] = Class [66] 
.const [36] = NameAndType [67] [68] 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [48] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [49] = Utf8 eal_IEventImage_SWIGUpcast 
.const [50] = Utf8 (J)J 
.const [51] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [52] = Utf8 delete_eal_IEventImage 
.const [53] = Utf8 (J)V 
.const [54] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [55] = Utf8 eal_IEventImage_getFile 
.const [56] = Utf8 (JLde/esolutions/graphics/eal/IEventImage;)Ljava/lang/String; 
.const [57] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [58] = Utf8 eal_IEventImage_getImage 
.const [59] = Utf8 (JLde/esolutions/graphics/eal/IEventImage;)J 
.const [60] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [61] = Utf8 swigCPtr 
.const [62] = Utf8 J 
.const [63] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [64] = Utf8 delete 
.const [65] = Utf8 ()V 
.const [66] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [67] = Utf8 swigCMemOwn 
.const [68] = Utf8 Z 
.const [69] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (JZ)V 
.const [72] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [73] = Utf8 delete 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/esolutions/graphics/eal/api/IImage 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (JZ)V 
.const [78] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [79] = Utf8 swigCPtr 
.const [80] = Utf8 J 
.const [81] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [82] = Utf8 swigCMemOwn 
.const [83] = Utf8 Z 
.const [84] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [85] = Class [84] 
.const [86] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [87] = Class [86] 
.const [88] = Utf8 swigCPtr 
.const [89] = Utf8 J 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (JZ)V 
.const [93] = Utf8 getCPtr 
.const [94] = Utf8 (Lde/esolutions/graphics/eal/IEventImage;)J 
.const [95] = Utf8 finalize 
.const [96] = Utf8 ()V 
.const [97] = Utf8 delete 
.const [98] = Utf8 ()V 
.const [99] = Utf8 isDeleted 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 getFile 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 getImage 
.const [104] = Utf8 ()Lde/esolutions/graphics/eal/api/IImage; 
.end class 
