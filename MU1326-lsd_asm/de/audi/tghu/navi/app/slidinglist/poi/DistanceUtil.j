.version 50 0 
.class public super [81] 
.super [83] 

.method public annotation [85] : [86] 
    .attribute [84] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [87] : [88] 
    .attribute [84] .code stack 4 locals 4 
L0:     aload_1 
L1:     ifnull L81 
L4:     iload_2 
L5:     iflt L18 
L8:     aload_1 
L9:     iload_2 
L10:    invokeinterface [17] 0 
L15:    goto L90 
L18:    aload_0 
L19:    ldc [2] 
L21:    ldc [3] 
L23:    invokevirtual [13] 
L26:    pop 
L27:    aload_3 
L28:    invokeinterface [18] 0 
L33:    astore 4 
L35:    aload_1 
L36:    invokeinterface [19] 0 
L41:    istore 5 
L43:    aload_1 
L44:    invokeinterface [20] 0 
L49:    istore 6 
L51:    aload 4 
L53:    getfield [14] 
L56:    aload 4 
L58:    getfield [15] 
L61:    iload 5 
L63:    iload 6 
L65:    invokestatic [4] 
L68:    istore 7 
L70:    aload_1 
L71:    iload 7 
L73:    invokeinterface [21] 0 
L78:    goto L90 
L81:    aload_0 
L82:    ldc [5] 
L84:    ldc [6] 
L86:    invokevirtual [13] 
L89:    pop 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [22] 
.const [4] = Method [23] [24] 
.const [5] = Int -1601830656 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Class [31] 
.const [13] = Method [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Field [36] [37] 
.const [16] = Method [38] [39] 
.const [17] = InterfaceMethod [40] [41] 
.const [18] = InterfaceMethod [42] [43] 
.const [19] = InterfaceMethod [44] [45] 
.const [20] = InterfaceMethod [46] [47] 
.const [21] = InterfaceMethod [48] [49] 
.const [22] = Utf8 'DistanceUtil#updateRRDfor() - invalid rrd. Air distance calculation started. ' 
.const [23] = Class [50] 
.const [24] = NameAndType [51] [52] 
.const [25] = Utf8 'DistanceUtil#updateRRDfor() - row is null! ' 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [30] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [31] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Class [74] 
.const [47] = NameAndType [75] [76] 
.const [48] = Class [77] 
.const [49] = NameAndType [78] [79] 
.const [50] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [51] = Utf8 computeAirDistance 
.const [52] = Utf8 (IIII)I 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 log 
.const [55] = Utf8 (ILjava/lang/String;)Z 
.const [56] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [57] = Utf8 longitude 
.const [58] = Utf8 I 
.const [59] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [60] = Utf8 latitude 
.const [61] = Utf8 I 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [66] = Utf8 setRRDDistance 
.const [67] = Utf8 (I)V 
.const [68] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [69] = Utf8 getPosition 
.const [70] = Utf8 ()Lorg/dsi/ifc/navigation/PosPosition; 
.const [71] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [72] = Utf8 getLongitude 
.const [73] = Utf8 ()I 
.const [74] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [75] = Utf8 getLatitude 
.const [76] = Utf8 ()I 
.const [77] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [78] = Utf8 setAirDistance 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceUtil 
.const [81] = Class [80] 
.const [82] = Utf8 java/lang/Object 
.const [83] = Class [82] 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 updateRRDfor 
.const [88] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow;ILde/audi/tghu/navi/app/guidance/IVehicle;)V 
.end class 
