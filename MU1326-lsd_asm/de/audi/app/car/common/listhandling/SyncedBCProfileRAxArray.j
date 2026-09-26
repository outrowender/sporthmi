.version 50 0 
.class public super [47] 
.super [49] 
.field [50] [51] 
.field private [52] [53] 

.method public [55] : [56] 
    .attribute [54] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [9] 
L9:     aload_0 
L10:    new [10] 
L13:    dup 
L14:    invokespecial [8] 
L17:    putfield [11] 
L20:    aload_0 
L21:    iload_1 
L22:    anewarray [3] 
L25:    putfield [9] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [54] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L23 using L28 
L7:     aload_0 
L8:     invokevirtual [7] 
L11:    iload_1 
L12:    if_icmple L24 
L15:    aload_0 
L16:    getfield [5] 
L19:    iload_1 
L20:    aaload 
L21:    aload_2 
L22:    monitorexit 
L23:    areturn 
        .catch [0] from L24 to L27 using L28 
L24:    aconst_null 
L25:    aload_2 
L26:    monitorexit 
L27:    areturn 
        .catch [0] from L28 to L31 using L28 
L28:    astore_3 
L29:    aload_2 
L30:    monitorexit 
L31:    aload_3 
L32:    athrow 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [54] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L24 using L27 
L7:     aload_0 
L8:     invokevirtual [7] 
L11:    iload_2 
L12:    if_icmple L22 
L15:    aload_0 
L16:    getfield [5] 
L19:    iload_2 
L20:    aload_1 
L21:    aastore 
L22:    aload_3 
L23:    monitorexit 
L24:    goto L34 
        .catch [0] from L27 to L31 using L27 
L27:    astore 4 
L29:    aload_3 
L30:    monitorexit 
L31:    aload 4 
L33:    athrow 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [54] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [6] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L14 using L15 
L7:     aload_0 
L8:     getfield [5] 
L11:    arraylength 
L12:    aload_1 
L13:    monitorexit 
L14:    areturn 
        .catch [0] from L15 to L18 using L15 
L15:    astore_2 
L16:    aload_1 
L17:    monitorexit 
L18:    aload_2 
L19:    athrow 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Field [23] [24] 
.const [10] = Class [25] 
.const [11] = Field [26] [27] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Utf8 de/audi/app/car/common/listhandling/BatteryControlProfileRAx 
.const [14] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [15] = Class [28] 
.const [16] = NameAndType [29] [30] 
.const [17] = Class [31] 
.const [18] = NameAndType [32] [33] 
.const [19] = Class [34] 
.const [20] = NameAndType [35] [36] 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Utf8 java/lang/Object 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [29] = Utf8 array 
.const [30] = Utf8 [Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [31] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [32] = Utf8 mutex 
.const [33] = Utf8 Ljava/lang/Object; 
.const [34] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [35] = Utf8 length 
.const [36] = Utf8 ()I 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 <init> 
.const [39] = Utf8 ()V 
.const [40] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [41] = Utf8 array 
.const [42] = Utf8 [Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [43] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [44] = Utf8 mutex 
.const [45] = Utf8 Ljava/lang/Object; 
.const [46] = Utf8 de/audi/app/car/common/listhandling/SyncedBCProfileRAxArray 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 array 
.const [51] = Utf8 [Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [52] = Utf8 mutex 
.const [53] = Utf8 Ljava/lang/Object; 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 get 
.const [58] = Utf8 (I)Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx; 
.const [59] = Utf8 set 
.const [60] = Utf8 (Lde/audi/app/car/common/listhandling/BatteryControlProfileRAx;I)V 
.const [61] = Utf8 length 
.const [62] = Utf8 ()I 
.end class 
