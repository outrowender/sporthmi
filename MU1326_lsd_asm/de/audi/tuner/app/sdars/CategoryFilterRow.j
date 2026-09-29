.version 50 0 
.class public super [77] 
.super [79] 
.field private static final [80] [81] 
.field public static final [82] [83] 
.field private static final [84] [85] 
.field private static final [86] [87] 
.field private volatile [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [5] 
L5:     i2l 
L6:     iconst_3 
L7:     invokespecial [12] 
L10:    aload_0 
L11:    iconst_0 
L12:    aload_1 
L13:    getfield [6] 
L16:    invokevirtual [7] 
L19:    pop 
L20:    aload_0 
L21:    iconst_2 
L22:    iconst_1 
L23:    invokevirtual [8] 
L26:    pop 
L27:    aload_0 
L28:    iconst_1 
L29:    iload_2 
L30:    invokevirtual [8] 
L33:    pop 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [93] : [94] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [13] 
L5:     aload_0 
L6:     aload_1 
L7:     getfield [9] 
L10:    putfield [15] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 3 locals 0 
L0:     new [16] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [14] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     ifeq L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    invokevirtual [8] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [10] 
L5:     iconst_1 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [101] : [102] 
    .attribute [90] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     l2i 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Field [20] [21] 
.const [6] = Field [22] [23] 
.const [7] = Method [24] [25] 
.const [8] = Method [26] [27] 
.const [9] = Field [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Class [42] 
.const [17] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [18] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [19] = Utf8 org/dsi/ifc/sdars/CategoryInfo 
.const [20] = Class [43] 
.const [21] = NameAndType [44] [45] 
.const [22] = Class [46] 
.const [23] = NameAndType [47] [48] 
.const [24] = Class [49] 
.const [25] = NameAndType [50] [51] 
.const [26] = Class [52] 
.const [27] = NameAndType [53] [54] 
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
.const [42] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [43] = Utf8 org/dsi/ifc/sdars/CategoryInfo 
.const [44] = Utf8 categoryNumber 
.const [45] = Utf8 S 
.const [46] = Utf8 org/dsi/ifc/sdars/CategoryInfo 
.const [47] = Utf8 fullLabel 
.const [48] = Utf8 Ljava/lang/String; 
.const [49] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [50] = Utf8 setText 
.const [51] = Utf8 (ILjava/lang/String;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [52] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [53] = Utf8 setInteger 
.const [54] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [55] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [56] = Utf8 hasSubscribedStations 
.const [57] = Utf8 Z 
.const [58] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [59] = Utf8 getInteger 
.const [60] = Utf8 (I)I 
.const [61] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [62] = Utf8 getUniqueID 
.const [63] = Utf8 ()J 
.const [64] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (JI)V 
.const [67] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [68] = Utf8 <init> 
.const [69] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;)V 
.const [70] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Lde/audi/tuner/app/sdars/CategoryFilterRow;)V 
.const [73] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [74] = Utf8 hasSubscribedStations 
.const [75] = Utf8 Z 
.const [76] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [77] = Class [76] 
.const [78] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [79] = Class [78] 
.const [80] = Utf8 MAX_COLS 
.const [81] = Utf8 I 
.const [82] = Utf8 INDEX_FULL_NAME 
.const [83] = Utf8 I 
.const [84] = Utf8 INDEX_FILTER_CHECKED 
.const [85] = Utf8 I 
.const [86] = Utf8 INDEX_FILTER_DISABLED 
.const [87] = Utf8 I 
.const [88] = Utf8 hasSubscribedStations 
.const [89] = Utf8 Z 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Lorg/dsi/ifc/sdars/CategoryInfo;I)V 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/tuner/app/sdars/CategoryFilterRow;)V 
.const [95] = Utf8 copy 
.const [96] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [97] = Utf8 setChecked 
.const [98] = Utf8 (Z)V 
.const [99] = Utf8 isChecked 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 containsSubscribedStations 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 setContainsSubscribedStations 
.const [104] = Utf8 (Z)V 
.const [105] = Utf8 getCategory 
.const [106] = Utf8 ()I 
.end class 
