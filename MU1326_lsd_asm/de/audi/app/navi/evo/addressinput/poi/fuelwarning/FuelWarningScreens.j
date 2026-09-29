.version 50 0 
.class public super [39] 
.super [41] 

.method public annotation [43] : [44] 
    .attribute [42] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [45] : [46] 
    .attribute [42] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [42] .code stack 1 locals 0 
L0:     ldc [3] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public static [49] : [50] 
    .attribute [42] .code stack 8 locals 0 
L0:     new [12] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     aload 5 
L9:     aload_0 
L10:    aload 6 
L12:    invokestatic [5] 
L15:    iload_3 
L16:    iload 4 
L18:    invokespecial [11] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [51] : [52] 
    .attribute [42] .code stack 1 locals 0 
L0:     aload_0 
L1:     instanceof [6] 
L4:     ifne L9 
L7:     aconst_null 
L8:     areturn 
L9:     aload_0 
L10:    checkcast [6] 
L13:    invokevirtual [9] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2061564416 
.const [3] = Int -2095118848 
.const [4] = Class [13] 
.const [5] = Method [14] [15] 
.const [6] = Class [16] 
.const [7] = Class [17] 
.const [8] = Class [18] 
.const [9] = Method [19] [20] 
.const [10] = Method [21] [22] 
.const [11] = Method [23] [24] 
.const [12] = Class [25] 
.const [13] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [14] = Class [26] 
.const [15] = NameAndType [27] [28] 
.const [16] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedResultsListRow 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedResultsListRowBuilder 
.const [19] = Class [29] 
.const [20] = NameAndType [30] [31] 
.const [21] = Class [32] 
.const [22] = NameAndType [33] [34] 
.const [23] = Class [35] 
.const [24] = NameAndType [36] [37] 
.const [25] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [26] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedResultsListRowBuilder 
.const [27] = Utf8 createPoiIconedResultsListRowBuilderDistanceFromCCP 
.const [28] = Utf8 (Lde/audi/tghu/navi/app/IconHandler;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/IVehicle;)Lde/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedResultsListRowBuilder; 
.const [29] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedResultsListRow 
.const [30] = Utf8 getElement 
.const [31] = Utf8 ()Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [36] = Utf8 <init> 
.const [37] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/hmi/model/list/BaseListModelListener;Lde/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder;II)V 
.const [38] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningScreens 
.const [39] = Class [38] 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [40] 
.const [42] = Utf8 Code 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 getVicinityListModel 
.const [46] = Utf8 ()I 
.const [47] = Utf8 getAlongRouteListModel 
.const [48] = Utf8 ()I 
.const [49] = Utf8 createFuelWarningModelAccess 
.const [50] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/hmi/model/list/BaseListModelListener;Lde/audi/tghu/navi/app/IconHandler;IILde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/guidance/IVehicle;)Lde/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess; 
.const [51] = Utf8 getFuelWarningListSelectedElement 
.const [52] = Utf8 (Lde/audi/atip/hmi/model/list/EvoListRow;)Lorg/dsi/ifc/navigation/LIValueListElement; 
.end class 
