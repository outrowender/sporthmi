.version 50 0 
.class public super [74] 
.super [76] 
.implements [78] 
.field private [79] [80] 
.field private [81] [82] 
.field private static final [83] [84] 
.field private final [85] [86] 

.method public [88] : [89] 
    .attribute [87] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [90] : [91] 
    .attribute [87] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_3 
L5:     iload_1 
L6:     invokevirtual [13] 
L9:     iload_2 
L10:    invokeinterface [18] 0 
L15:    invokeinterface [19] 0 
L20:    astore 4 
L22:    aload_0 
L23:    getfield [11] 
L26:    ldc [2] 
L28:    ldc [3] 
L30:    aload 4 
L32:    invokevirtual [14] 
L35:    pop 
L36:    aload 4 
L38:    ifnull L44 
L41:    aload 4 
L43:    areturn 
L44:    aconst_null 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = String [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Field [38] [39] 
.const [17] = Field [40] [41] 
.const [18] = InterfaceMethod [42] [43] 
.const [19] = InterfaceMethod [44] [45] 
.const [20] = Utf8 'GeoCoordinatesTruffle#extractGeoCoordinates: position is %1' 
.const [21] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [22] = Utf8 java/lang/Object 
.const [23] = Utf8 GeoCoordinatesTruffle 
.const [24] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [25] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [26] = Utf8 de/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [47] = Utf8 logChannel 
.const [48] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [49] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [50] = Utf8 locationExtractor 
.const [51] = Utf8 Lde/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor; 
.const [52] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [53] = Utf8 getBaseListModel 
.const [54] = Utf8 (I)Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 log 
.const [57] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [62] = Utf8 logChannel 
.const [63] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [65] = Utf8 locationExtractor 
.const [66] = Utf8 Lde/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor; 
.const [67] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [68] = Utf8 getRow 
.const [69] = Utf8 (I)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [70] = Utf8 de/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor 
.const [71] = Utf8 extractNavLocationFromRow 
.const [72] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;)Lorg/dsi/ifc/global/NavLocation; 
.const [73] = Utf8 de/audi/app/navi/evo/online/GeoCoordinatesTruffle 
.const [74] = Class [73] 
.const [75] = Utf8 java/lang/Object 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/app/navi/evo/online/GeoCoordinates 
.const [78] = Class [77] 
.const [79] = Utf8 latitudeLongitude 
.const [80] = Utf8 [I 
.const [81] = Utf8 logChannel 
.const [82] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [83] = Utf8 LOGCLASS 
.const [84] = Utf8 Ljava/lang/String; 
.const [85] = Utf8 locationExtractor 
.const [86] = Utf8 Lde/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor; 
.const [87] = Utf8 Code 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/navlocationextractor/NavLocationExctractor;)V 
.const [90] = Utf8 extractGeoCoordinates 
.const [91] = Utf8 (IILde/audi/tghu/navi/app/NavigationEnv;)Lorg/dsi/ifc/global/NavLocation; 
.end class 
