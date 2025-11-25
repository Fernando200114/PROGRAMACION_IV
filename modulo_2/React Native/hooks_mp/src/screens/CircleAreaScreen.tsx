import React, { useMemo, useState } from "react";
import { View, Text, TextInput } from "react-native";
import colors from "../theme/colors";

// Convertir texto a número
function n(s: string): number | null {
  if (!s.trim()) return null;
  const v = Number(s.replace(",", "."));
  return Number.isFinite(v) ? v : null;
}

export default function CircleAreaScreen() {
  const [x1, setX1] = useState("");
  const [y1, setY1] = useState("");
  const [x2, setX2] = useState("");
  const [y2, setY2] = useState("");

  // Cálculo de distancia entre dos puntos
  const distance = useMemo(() => {
    const a = n(x1);
    const b = n(y1);
    const c = n(x2);
    const d = n(y2);

    if (a === null || b === null || c === null || d === null) return "—";

    const dx = c - a;
    const dy = d - b;

    return Math.sqrt(dx * dx + dy * dy).toFixed(4);
  }, [x1, y1, x2, y2]);

  return (
    <View style={{ flex: 1, backgroundColor: "#111827", padding: 16 }}>
      <Text style={{ color: "#3b82f6", fontSize: 22, marginBottom: 12 }}>
        Distancia entre dos puntos
      </Text>

      <TextInput
        keyboardType="decimal-pad"
        placeholder="X1"
        placeholderTextColor="#6b7280"
        value={x1}
        onChangeText={setX1}
        style={{
          color: colors.text,
          borderColor: "#374151",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#1f2937",
          marginBottom: 10,
        }}
      />

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Y1"
        placeholderTextColor="#6b7280"
        value={y1}
        onChangeText={setY1}
        style={{
          color: colors.text,
          borderColor: "#374151",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#1f2937",
          marginBottom: 10,
        }}
      />

      <TextInput
        keyboardType="decimal-pad"
        placeholder="X2"
        placeholderTextColor="#6b7280"
        value={x2}
        onChangeText={setX2}
        style={{
          color: colors.text,
          borderColor: "#374151",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#1f2937",
          marginBottom: 10,
        }}
      />

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Y2"
        placeholderTextColor="#6b7280"
        value={y2}
        onChangeText={setY2}
        style={{
          color: colors.text,
          borderColor: "#374151",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#1f2937",
          marginBottom: 10,
        }}
      />

      <Text style={{ color: colors.text, fontSize: 18 }}>
        Distancia:{" "}
        <Text style={{ color: "#3b82f6", fontWeight: "bold" }}>
          {distance}
        </Text>
      </Text>
    </View>
  );
}
