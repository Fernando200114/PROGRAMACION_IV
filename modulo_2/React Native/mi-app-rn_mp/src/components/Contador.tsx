import React, { useState } from "react";
import { View, Text, Pressable } from "react-native";

export default function Contador() {
  const [count, setCount] = useState(0);

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
          fontSize: 22,
          color: "#3b82f6",
          marginBottom: 20,
          fontWeight: "bold",
        }}
      >
        Contador de reservas
      </Text>

      <Text style={{ fontSize: 20, color: "#e2e8f0", marginBottom: 20 }}>
        Valor actual: <Text style={{ color: "#3b82f6" }}>{count}</Text>
      </Text>

      <Pressable
        onPress={() => setCount(count + 1)}
        style={({ pressed }) => ({
          backgroundColor: pressed ? "#1e40af" : "#3b82f6",
          paddingVertical: 12,
          paddingHorizontal: 25,
          borderRadius: 10,
        })}
      >
        <Text style={{ color: "white", fontSize: 16, fontWeight: "bold" }}>
          Incrementar
        </Text>
      </Pressable>
    </View>
  );
}
