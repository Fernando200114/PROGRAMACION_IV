import { createNativeStackNavigator } from "@react-navigation/native-stack";
import type { RootStackParamList } from "@/navigation/types";
import { HomeScreen } from "@/screens/HomeScreen";
import { DetailsScreen } from "@/screens/DetailsScreen";
import { SettingsScreen } from "@/screens/SettingsScreen";
import { FocusDemo } from "@/screens/FocusDemo";
import { LoginFormScreen } from "@/screens/LoginFormScreen";
import { PantallaNueva } from "@/screens/PantallaNueva";
import { ProductsListScreen } from "@/screens/ProductsListScreen";
import { ProfileScreen } from "@/screens/ProfileScreen";
import { DisplayName} from "@/screens/DisplayName";
import { FuerzaScreen } from "@/screens/Fuerza";

const Stack = createNativeStackNavigator<RootStackParamList>();

export function AppNavigator() {
  return (
    <Stack.Navigator
      screenOptions={{
        headerStyle: { backgroundColor: "#0d1117" },
        headerTintColor: "#58a6ff",
        headerTitleStyle: { fontWeight: "900" },
        contentStyle: { backgroundColor: "#0d1117" },
      }}
    >
      <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Inicio" }} />
      <Stack.Screen name="Details" component={DetailsScreen} options={{ title: "Detalles" }} />
      <Stack.Screen name="Settings" component={SettingsScreen} options={{ title: "Settings" }} />
      <Stack.Screen name="Focus" component={FocusDemo} options={{ title: "Focus" }} />
      <Stack.Screen name="LoginForm" component={LoginFormScreen} options={{ title: "Login Form" }} />
      <Stack.Screen name="Pantalla" component={PantallaNueva} options={{ title: "Pantalla" }} />
      <Stack.Screen name="Products" component={ProductsListScreen} options={{ title: "Productos" }} />
      <Stack.Screen name="Profile" component={ProfileScreen} options={{ title: "Perfil" }}/>
      <Stack.Screen name="DisplayName" component={DisplayName} options={{ title: "DisplayName" }}/>
      <Stack.Screen name="Fuerza" component={FuerzaScreen} options={{ title: "Fuerza" }}/>
      
      
    </Stack.Navigator>
  );
}