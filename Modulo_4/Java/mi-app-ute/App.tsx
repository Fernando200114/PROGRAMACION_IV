import { StyleSheet, View, SafeAreaView, StatusBar } from "react-native";
import { UseEffectAsyncDemo } from "@/screens/UseEffectAsyncDemo";
import { Parte09Lab } from "@/screens/Parte09Lab";
import { CallbackDemo } from "@/screens/CallbackDemo";
import { Parte10Lab } from "@/screens/Parte10Lab";
import { RefCounter } from "@/screens/RefCounter";
import { FocusDemo } from "@/screens/FocusDemo";
import { TimerRefDemo } from "@/screens/TimerRefDemo";
import { Parte12Lab } from "@/screens/Parte12Lab";
import { NavigationContainer } from "@react-navigation/native";
import { AppNavigator } from "@/navigation/AppNavigator";


export default function App() {
  return (
    <NavigationContainer>
      <AppNavigator />
      <StatusBar style="light" />
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0d1117', // Fondo oscuro (puedes cambiarlo a white)
  },
  content: {
    flex: 1,
    padding: 20,
    justifyContent: 'center', // Centra el contenido si es necesario
  },
});