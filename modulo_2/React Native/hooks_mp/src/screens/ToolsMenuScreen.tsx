import React from "react";
import { View, Text, Pressable } from "react-native";
import colors from "../theme/colors";

function Item({ label, onPress }: { label: string; onPress: () => void }) {
  return (
    <Pressable
      onPress={onPress}
      style={({ pressed }) => ({
        backgroundColor: pressed ? "#1f2937" : "#1e293b",
        padding: 16,
        borderRadius: 12,
        borderWidth: 1,
        borderColor: "#334155",
        marginBottom: 12,
      })}
    >
      <Text style={{ color: "#3b82f6", fontWeight: "bold" }}>{label}</Text>
    </Pressable>
  );
}

export default function ToolsMenuScreen({ navigation }: any) {
  return (
    <View style={{ flex: 1, backgroundColor: "#0f172a", padding: 16 }}>
      <Text style={{ color: "#3b82f6", fontSize: 22, marginBottom: 16 }}>
        Herramientas para tu reserva
      </Text>

      <Item
        label="Calculadora de tarifas"
        onPress={() => navigation.navigate("Calculator")}
      />
      <Item
        label="Distancia entre ciudades (triángulo)"
        onPress={() => navigation.navigate("TriangleArea")}
      />
      <Item
        label="Cálculo de equipaje circular"
        onPress={() => navigation.navigate("CircleArea")}
      />
      <Item
        label="Cálculo de equipaje cuadrado"
        onPress={() => navigation.navigate("SquareArea")}
      />
    </View>
  );
}
