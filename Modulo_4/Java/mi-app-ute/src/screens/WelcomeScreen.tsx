import { StyleSheet, Text, View } from "react-native";

export function WelcomeScreen() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Bienvenido</Text>
      <Text style={styles.subtitle}>React Native + TypeScript</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
    alignItems: "center",
    justifyContent: "center",
    padding: 16,
  },
  title: {
    fontSize: 22,
    fontWeight: "700",
    color: "#58a6ff",
    marginBottom: 6,
  },
  subtitle: {
    fontSize: 14,
    color: "#c9d1d9",
    opacity: 0.85,
  },
});