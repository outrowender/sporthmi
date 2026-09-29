.version 50 0 
.class super [49] 
.super [51] 
.implements [53] 
.field private final [54] [55] 
.field private final [56] [57] 
.field private [58] [59] 
.field private static final [60] [61] 

.method [63] : [64] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [8] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [9] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [10] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     sipush 255 
L7:     if_icmple L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [62] .code stack 4 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [6] 
L5:     aload_0 
L6:     getfield [4] 
L9:     irem 
L10:    putfield [10] 
L13:    aload_0 
L14:    dup 
L15:    getfield [6] 
L18:    dup_x1 
L19:    iconst_1 
L20:    iadd 
L21:    putfield [10] 
L24:    aload_0 
L25:    getfield [5] 
L28:    iadd 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [10] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [62] .code stack 2 locals 0 
L0:     iload_1 
L1:     sipush 255 
L4:     if_icmple L17 
L7:     aload_0 
L8:     getfield [6] 
L11:    sipush 255 
L14:    if_icmplt L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Class [12] 
.const [4] = Field [13] [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Field [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [27] 
.const [14] = NameAndType [28] [29] 
.const [15] = Class [30] 
.const [16] = NameAndType [31] [32] 
.const [17] = Class [33] 
.const [18] = NameAndType [34] [35] 
.const [19] = Class [36] 
.const [20] = NameAndType [37] [38] 
.const [21] = Class [39] 
.const [22] = NameAndType [40] [41] 
.const [23] = Class [42] 
.const [24] = NameAndType [43] [44] 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [28] = Utf8 maxID 
.const [29] = Utf8 I 
.const [30] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [31] = Utf8 minID 
.const [32] = Utf8 I 
.const [33] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [34] = Utf8 nextID 
.const [35] = Utf8 I 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 <init> 
.const [38] = Utf8 ()V 
.const [39] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [40] = Utf8 maxID 
.const [41] = Utf8 I 
.const [42] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [43] = Utf8 minID 
.const [44] = Utf8 I 
.const [45] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [46] = Utf8 nextID 
.const [47] = Utf8 I 
.const [48] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListGenericIdGenerator 
.const [49] = Class [48] 
.const [50] = Utf8 java/lang/Object 
.const [51] = Class [50] 
.const [52] = Utf8 de/vw/mib/bap/array/fsg/FsgArrayListIdGenerator 
.const [53] = Class [52] 
.const [54] = Utf8 maxID 
.const [55] = Utf8 I 
.const [56] = Utf8 minID 
.const [57] = Utf8 I 
.const [58] = Utf8 nextID 
.const [59] = Utf8 I 
.const [60] = Utf8 TRANSMIT_LONG_ID_THRESHOLD 
.const [61] = Utf8 I 
.const [62] = Utf8 Code 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (II)V 
.const [65] = Utf8 isLongID 
.const [66] = Utf8 ()Z 
.const [67] = Utf8 createBAPPosID 
.const [68] = Utf8 (J)I 
.const [69] = Utf8 reset 
.const [70] = Utf8 ()V 
.const [71] = Utf8 isBAPPosIDValid 
.const [72] = Utf8 (IJ)Z 
.end class 
