.version 50 0 
.class public super [41] 
.super [43] 
.implements [45] 
.field private [46] [47] 

.method public [49] : [50] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     iload_1 
L6:     anewarray [2] 
L9:     putfield [10] 
L12:    aload_0 
L13:    invokespecial [9] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [51] : [52] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     ifnull L19 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [7] 
L12:    arraylength 
L13:    anewarray [2] 
L16:    putfield [10] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [53] : [54] 
    .attribute [48] .code stack 2 locals 1 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     getfield [7] 
L6:     ifnull L30 
L9:     iconst_0 
L10:    iload_1 
L11:    if_icmpgt L30 
L14:    iload_1 
L15:    aload_0 
L16:    getfield [7] 
L19:    arraylength 
L20:    if_icmpge L30 
L23:    aload_0 
L24:    getfield [7] 
L27:    iload_1 
L28:    aaload 
L29:    astore_2 
L30:    aload_2 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [55] : [56] 
    .attribute [48] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [7] 
L5:     arraylength 
L6:     anewarray [2] 
L9:     putfield [10] 
L12:    aload_1 
L13:    iconst_0 
L14:    aload_0 
L15:    getfield [7] 
L18:    iconst_0 
L19:    aload_1 
L20:    arraylength 
L21:    aload_0 
L22:    getfield [7] 
L25:    arraylength 
L26:    if_icmplt L37 
L29:    aload_0 
L30:    getfield [7] 
L33:    arraylength 
L34:    goto L39 
L37:    aload_1 
L38:    arraylength 
L39:    invokestatic [3] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Method [12] [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Class [16] 
.const [7] = Field [17] [18] 
.const [8] = Method [19] [20] 
.const [9] = Method [21] [22] 
.const [10] = Field [23] [24] 
.const [11] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [12] = Class [25] 
.const [13] = NameAndType [26] [27] 
.const [14] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/DistanceContainer 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 java/lang/System 
.const [17] = Class [28] 
.const [18] = NameAndType [29] [30] 
.const [19] = Class [31] 
.const [20] = NameAndType [32] [33] 
.const [21] = Class [34] 
.const [22] = NameAndType [35] [36] 
.const [23] = Class [37] 
.const [24] = NameAndType [38] [39] 
.const [25] = Utf8 java/lang/System 
.const [26] = Utf8 arraycopy 
.const [27] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [28] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/DistanceContainer 
.const [29] = Utf8 distances 
.const [30] = Utf8 [Lorg/dsi/ifc/navigation/RrdCalculationInfo; 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 <init> 
.const [33] = Utf8 ()V 
.const [34] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/DistanceContainer 
.const [35] = Utf8 resetDistances 
.const [36] = Utf8 ()V 
.const [37] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/DistanceContainer 
.const [38] = Utf8 distances 
.const [39] = Utf8 [Lorg/dsi/ifc/navigation/RrdCalculationInfo; 
.const [40] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/DistanceContainer 
.const [41] = Class [40] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [42] 
.const [44] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/IDistanceContainer 
.const [45] = Class [44] 
.const [46] = Utf8 distances 
.const [47] = Utf8 [Lorg/dsi/ifc/navigation/RrdCalculationInfo; 
.const [48] = Utf8 Code 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (I)V 
.const [51] = Utf8 resetDistances 
.const [52] = Utf8 ()V 
.const [53] = Utf8 getDistance 
.const [54] = Utf8 (I)Lorg/dsi/ifc/navigation/RrdCalculationInfo; 
.const [55] = Utf8 storeRRDDistances 
.const [56] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.end class 
