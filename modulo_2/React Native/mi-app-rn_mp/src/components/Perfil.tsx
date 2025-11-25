import React, { useState } from "react";
import { View, Text, Pressable } from "react-native";

export default function Perfil() {
  const [edad, setEdad] = useState(25);

  return (
    <View
      style={{
        flex: 1,
        backgroundColor: "#0f172a",
        justifyContent: "center",
        alignItems: "center",
        padding: 20,
      }}
    >
      <Text
        style={{
          color: "#3b82f6",
          fontSize: 24,
          fontWeight: "bold",
          marginBottom: 10,
        }}
      >
        Perfil del pasajero
      </Text>

      <Text style={{ color: "#e2e8f0", fontSize: 20, marginBottom: 4 }}>
        Nombre: Fernando
      </Text>

      <Text style={{ color: "#cbd5e1", fontSize: 18, marginBottom: 20 }}>
        Edad: <Text style={{ color: "#3b82f6" }}>{edad}</Text>
      </Text>

      <Pressable
        onPress={() => setEdad(edad + 1)}
        style={({ pressed }) => ({
          backgroundColor: pressed ? "#1e40af" : "#3b82f6",
          paddingVertical: 12,
          paddingHorizontal: 25,
          borderRadius: 10,
        })}
      >
        <Text style={{ color: "white", fontSize: 16, fontWeight: "bold" }}>
          Cumplir año 🎉
        </Text>
      </Pressable>
    </View>
  );
}
