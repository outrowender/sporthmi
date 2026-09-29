.version 50 0 
.class public super abstract [53] 
.super [55] 

.method public annotation [57] : [58] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [59] : [60] 
    .attribute [56] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [56] .code stack 8 locals 3 
L0:     aload_0 
L1:     invokevirtual [5] 
L4:     astore_2 
L5:     aconst_null 
L6:     astore_3 
L7:     iconst_0 
L8:     istore 4 
L10:    iload 4 
L12:    aload_2 
L13:    arraylength 
L14:    if_icmpge L85 
L17:    iload_1 
L18:    aload_2 
L19:    iload 4 
L21:    aaload 
L22:    invokevirtual [6] 
L25:    if_icmplt L79 
L28:    iload_1 
L29:    aload_2 
L30:    iload 4 
L32:    aaload 
L33:    invokevirtual [7] 
L36:    if_icmpgt L79 
L39:    new [12] 
L42:    dup 
L43:    aload_0 
L44:    aload_2 
L45:    iload 4 
L47:    aaload 
L48:    invokevirtual [8] 
L51:    aload_2 
L52:    iload 4 
L54:    aaload 
L55:    invokevirtual [9] 
L58:    aload_2 
L59:    iload 4 
L61:    aaload 
L62:    invokevirtual [6] 
L65:    aload_2 
L66:    iload 4 
L68:    aaload 
L69:    invokevirtual [7] 
L72:    invokespecial [11] 
L75:    astore_3 
L76:    goto L85 
L79:    iinc 4 1 
L82:    goto L10 
L85:    aload_3 
L86:    areturn 
L87:    nop 
L88:    
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
.const [11] = Method [28] [29] 
.const [12] = Class [30] 
.const [13] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [14] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition 
.const [15] = Utf8 java/lang/Object 
.const [16] = Class [31] 
.const [17] = NameAndType [32] [33] 
.const [18] = Class [34] 
.const [19] = NameAndType [35] [36] 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [31] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition 
.const [32] = Utf8 getSectorDefinition 
.const [33] = Utf8 ()[Lde/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector; 
.const [34] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [35] = Utf8 getLowerBorder 
.const [36] = Utf8 ()I 
.const [37] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [38] = Utf8 getUpperBoarder 
.const [39] = Utf8 ()I 
.const [40] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [41] = Utf8 getUniqueID 
.const [42] = Utf8 ()I 
.const [43] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [44] = Utf8 getRepresentative 
.const [45] = Utf8 ()I 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector 
.const [50] = Utf8 <init> 
.const [51] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition;IIII)V 
.const [52] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition 
.const [53] = Class [52] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Class [54] 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ()V 
.const [59] = Utf8 getSectorDefinition 
.const [60] = Utf8 ()[Lde/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector; 
.const [61] = Utf8 getSector 
.const [62] = Utf8 (I)Lde/audi/app/car/core/aircondition/AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector; 
.end class 
