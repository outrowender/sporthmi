.version 50 0 
.class public super [61] 
.super [63] 
.field public static final [64] [65] 
.field private [66] [67] 

.method public [69] : [70] 
    .attribute [68] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     sipush 1004 
L6:     iload_3 
L7:     aload_2 
L8:     invokespecial [13] 
L11:    aload_0 
L12:    iconst_1 
L13:    newarray int 
L15:    dup 
L16:    iconst_0 
L17:    iconst_m1 
L18:    iastore 
L19:    putfield [14] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [71] : [72] 
    .attribute [68] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     newarray int 
L4:     putfield [14] 
L7:     aload_0 
L8:     getfield [7] 
L11:    iconst_0 
L12:    iconst_m1 
L13:    iastore 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected enum [73] : [74] 
    .attribute [68] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [75] : [76] 
    .attribute [68] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [8] 
        .catch [2] from L4 to L17 using L20 
L4:     iload_1 
L5:     ifle L17 
L8:     aload_0 
L9:     aload_0 
L10:    aload_3 
L11:    invokevirtual [9] 
L14:    putfield [14] 
L17:    goto L37 
L20:    astore 4 
L22:    aload_0 
L23:    invokevirtual [10] 
L26:    sipush 10000 
L29:    ldc [3] 
L31:    aload 4 
L33:    invokevirtual [11] 
L36:    pop 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [77] : [78] 
    .attribute [68] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [7] 
L5:     aload_1 
L6:     invokevirtual [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [79] : [80] 
    .attribute [68] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     aload_1 
L3:     invokevirtual [9] 
L6:     putfield [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [83] : [84] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = String [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Field [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Utf8 java/io/IOException 
.const [16] = Utf8 'PoiWarningPersistenceHelper.Items#convertContainer - error on converting the persistent state format' 
.const [17] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [18] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [19] = Utf8 de/audi/atip/log/LogChannel 
.const [20] = Class [36] 
.const [21] = NameAndType [37] [38] 
.const [22] = Class [39] 
.const [23] = NameAndType [40] [41] 
.const [24] = Class [42] 
.const [25] = NameAndType [43] [44] 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [37] = Utf8 serializedItems 
.const [38] = Utf8 [I 
.const [39] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [40] = Utf8 initWithDefaultValues 
.const [41] = Utf8 ()V 
.const [42] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [43] = Utf8 deserializeIntArray 
.const [44] = Utf8 (Ljava/io/DataInputStream;)[I 
.const [45] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [46] = Utf8 getLogChannel 
.const [47] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 log 
.const [50] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [51] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [52] = Utf8 serializeIntArray 
.const [53] = Utf8 ([ILjava/io/DataOutputStream;)V 
.const [54] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Lde/audi/atip/storage/IStorageAccess;IIILde/audi/atip/log/LogChannel;)V 
.const [57] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [58] = Utf8 serializedItems 
.const [59] = Utf8 [I 
.const [60] = Utf8 de/audi/tghu/navi/app/poi/poiwarning/PoiWarningPersistenceHelper$Items 
.const [61] = Class [60] 
.const [62] = Utf8 de/audi/tghu/navi/app/PersistentState 
.const [63] = Class [62] 
.const [64] = Utf8 VERSION 
.const [65] = Utf8 I 
.const [66] = Utf8 serializedItems 
.const [67] = Utf8 [I 
.const [68] = Utf8 Code 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;I)V 
.const [71] = Utf8 initWithDefaultValues 
.const [72] = Utf8 ()V 
.const [73] = Utf8 initFromOldKeys 
.const [74] = Utf8 (Lde/audi/atip/storage/IStorageAccess;)V 
.const [75] = Utf8 convertContainer 
.const [76] = Utf8 (IILjava/io/DataInputStream;)V 
.const [77] = Utf8 serialize 
.const [78] = Utf8 (Ljava/io/DataOutputStream;)V 
.const [79] = Utf8 deserialize 
.const [80] = Utf8 (Ljava/io/DataInputStream;)V 
.const [81] = Utf8 setSelectedPoiCategories 
.const [82] = Utf8 ([I)V 
.const [83] = Utf8 getSelectedPoiCategories 
.const [84] = Utf8 ()[I 
.end class 
