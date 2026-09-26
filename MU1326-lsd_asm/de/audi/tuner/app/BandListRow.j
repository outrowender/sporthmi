.version 50 0 
.class public super [49] 
.super [51] 

.method public [53] : [54] 
    .attribute [52] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     i2l 
L3:     iconst_1 
L4:     invokespecial [7] 
L7:     aload_0 
L8:     iconst_0 
L9:     iload_1 
L10:    invokevirtual [5] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [55] : [56] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [8] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [52] .code stack 3 locals 0 
L0:     new [11] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [9] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokevirtual [6] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokevirtual [6] 
L5:     iload_1 
L6:     if_icmpne L11 
L9:     iconst_0 
L10:    areturn 
L11:    aload_0 
L12:    iconst_0 
L13:    invokevirtual [6] 
L16:    tableswitch 1 
            L92 
            L102 
            L102 
            L94 
            L96 
            L102 
            L98 
            L102 
            L102 
            L102 
            L102 
            L102 
            L102 
            L102 
            L100 
            default : L102 

L92:    iconst_1 
L93:    areturn 
L94:    iconst_2 
L95:    areturn 
L96:    iconst_3 
L97:    areturn 
L98:    iconst_4 
L99:    areturn 
L100:   iconst_5 
L101:   areturn 
L102:   new [12] 
L105:   dup 
L106:   invokespecial [10] 
L109:   athrow 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Method [16] [17] 
.const [6] = Method [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Class [28] 
.const [12] = Class [29] 
.const [13] = Utf8 de/audi/tuner/app/BandListRow 
.const [14] = Utf8 java/lang/IllegalArgumentException 
.const [15] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [16] = Class [30] 
.const [17] = NameAndType [31] [32] 
.const [18] = Class [33] 
.const [19] = NameAndType [34] [35] 
.const [20] = Class [36] 
.const [21] = NameAndType [37] [38] 
.const [22] = Class [39] 
.const [23] = NameAndType [40] [41] 
.const [24] = Class [42] 
.const [25] = NameAndType [43] [44] 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Utf8 de/audi/tuner/app/BandListRow 
.const [29] = Utf8 java/lang/IllegalArgumentException 
.const [30] = Utf8 de/audi/tuner/app/BandListRow 
.const [31] = Utf8 setInteger 
.const [32] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [33] = Utf8 de/audi/tuner/app/BandListRow 
.const [34] = Utf8 getInteger 
.const [35] = Utf8 (I)I 
.const [36] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [37] = Utf8 <init> 
.const [38] = Utf8 (JI)V 
.const [39] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [40] = Utf8 <init> 
.const [41] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;)V 
.const [42] = Utf8 de/audi/tuner/app/BandListRow 
.const [43] = Utf8 <init> 
.const [44] = Utf8 (Lde/audi/tuner/app/BandListRow;)V 
.const [45] = Utf8 java/lang/IllegalArgumentException 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 de/audi/tuner/app/BandListRow 
.const [49] = Class [48] 
.const [50] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [51] = Class [50] 
.const [52] = Utf8 Code 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Lde/audi/tuner/app/BandListRow;)V 
.const [57] = Utf8 copy 
.const [58] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [59] = Utf8 getBand 
.const [60] = Utf8 ()I 
.const [61] = Utf8 getPrio 
.const [62] = Utf8 (I)I 
.end class 
