.version 50 0 
.class public super [113] 
.super [115] 
.field [116] [117] 
.field [118] [119] 
.field [120] [121] 
.field [122] [123] 

.method public [125] : [126] 
    .attribute [124] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     ldc2_w [26] 
L8:     putfield [21] 
L11:    aload_0 
L12:    ldc2_w [26] 
L15:    putfield [22] 
L18:    aload_0 
L19:    iconst_0 
L20:    putfield [23] 
L23:    aload_0 
L24:    iconst_0 
L25:    anewarray [2] 
L28:    putfield [24] 
L31:    return 
L32:    
    .end code 
.end method 

.method public interface [127] : [128] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [124] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [13] 
L11:    arraylength 
L12:    ifle L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [131] : [132] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [124] .code stack 2 locals 0 
L0:     lconst_0 
L1:     freturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [124] .code stack 2 locals 0 
L0:     lconst_0 
L1:     freturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [124] .code stack 3 locals 1 
L0:     new [25] 
L3:     dup 
L4:     ldc [4] 
L6:     invokespecial [20] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [5] 
L13:    invokevirtual [14] 
L16:    aload_0 
L17:    getfield [10] 
L20:    invokevirtual [15] 
L23:    pop 
L24:    aload_1 
L25:    ldc [6] 
L27:    invokevirtual [14] 
L30:    aload_0 
L31:    getfield [11] 
L34:    invokevirtual [15] 
L37:    pop 
L38:    aload_1 
L39:    ldc [7] 
L41:    invokevirtual [14] 
L44:    aload_0 
L45:    getfield [12] 
L48:    invokevirtual [16] 
L51:    pop 
L52:    aload_1 
L53:    bipush 41 
L55:    invokevirtual [17] 
L58:    pop 
L59:    aload_1 
L60:    invokevirtual [18] 
L63:    areturn 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = String [30] 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = String [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Field [36] [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Class [66] 
.const [26] = Long -1L 
.const [28] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Utf8 TravelData( 
.const [31] = Utf8 'distCarToFinalDest: ' 
.const [32] = Utf8 'm, rttCarToFinalDest: ' 
.const [33] = Utf8 's, currentDestIndex: ' 
.const [34] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [35] = Utf8 java/lang/Object 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [67] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [68] = Utf8 mDistCarToFinalDest 
.const [69] = Utf8 J 
.const [70] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [71] = Utf8 mRttCarToFinalDest 
.const [72] = Utf8 J 
.const [73] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [74] = Utf8 indexOfCurrentDestination 
.const [75] = Utf8 I 
.const [76] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [77] = Utf8 rgDestinationInfo 
.const [78] = Utf8 [Lorg/dsi/ifc/navigation/NavRouteListData; 
.const [79] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [80] = Utf8 append 
.const [81] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [82] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Utf8 append 
.const [87] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 append 
.const [90] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [91] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [92] = Utf8 toString 
.const [93] = Utf8 ()Ljava/lang/String; 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Ljava/lang/String;)V 
.const [100] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [101] = Utf8 mDistCarToFinalDest 
.const [102] = Utf8 J 
.const [103] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [104] = Utf8 mRttCarToFinalDest 
.const [105] = Utf8 J 
.const [106] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [107] = Utf8 indexOfCurrentDestination 
.const [108] = Utf8 I 
.const [109] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [110] = Utf8 rgDestinationInfo 
.const [111] = Utf8 [Lorg/dsi/ifc/navigation/NavRouteListData; 
.const [112] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 mDistCarToFinalDest 
.const [117] = Utf8 J 
.const [118] = Utf8 mRttCarToFinalDest 
.const [119] = Utf8 J 
.const [120] = Utf8 indexOfCurrentDestination 
.const [121] = Utf8 I 
.const [122] = Utf8 rgDestinationInfo 
.const [123] = Utf8 [Lorg/dsi/ifc/navigation/NavRouteListData; 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 getDistCarToDest 
.const [128] = Utf8 ()J 
.const [129] = Utf8 isTravelDataValid 
.const [130] = Utf8 ()Z 
.const [131] = Utf8 getRttCarToDest 
.const [132] = Utf8 ()J 
.const [133] = Utf8 getDistCarToEvent 
.const [134] = Utf8 (JI)J 
.const [135] = Utf8 getRttCarToEvent 
.const [136] = Utf8 (JI)J 
.const [137] = Utf8 toString 
.const [138] = Utf8 ()Ljava/lang/String; 
.end class 
