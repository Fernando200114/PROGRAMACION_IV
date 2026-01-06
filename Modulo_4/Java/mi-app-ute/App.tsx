import { StyleSheet, View, SafeAreaView } from "react-native";
import { UseEffectAsyncDemo } from "@/screens/UseEffectAsyncDemo";
import { Parte09Lab } from "@/screens/Parte09Lab";
import { CallbackDemo } from "@/screens/src/screens/CallbackDemo";
import { Parte10Lab } from "@/screens/Parte10Lab";
import { RefCounter } from "@/screens/RefCounter";
import { FocusDemo } from "@/screens/FocusDemo";
import { TimerRefDemo } from "@/screens/TimerRefDemo";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      {/* Solo dejamos la pantalla que te interesa probar */}
      <View style={styles.content}>
        <TimerRefDemo />
      </View>
    </SafeAreaView>
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