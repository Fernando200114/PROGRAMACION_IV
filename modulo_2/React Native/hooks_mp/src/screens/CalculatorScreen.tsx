import React, { useMemo, useState } from "react";
import { View, Text, TextInput, Pressable } from "react-native";
import colors from "../theme/colors";

function toNumber(s: string): number | null {
  if (s.trim() === "") return null;
  const n = Number(s.replace(",", ".")); // permite "1,5"
  return Number.isFinite(n) ? n : null;
}

export default function CalculatorScreen() {
  const [a, setA] = useState("");
  const [b, setB] = useState("");
  const [op, setOp] = useState<"+" | "-" | "*" | "/">("+");

  const result = useMemo(() => {
    const x = toNumber(a);
    const y = toNumber(b);
    if (x === null || y === null) return "—";
    switch (op) {
      case "+": return (x + y).toString();
      case "-": return (x - y).toString();
      case "*": return (x * y).toString();
      case "/": return y === 0 ? "∞ (no definido)" : (x / y).toString();
      default: return "—";
    }
  }, [a, b, op]);

  const Input = (props: any) => (
    <TextInput
      keyboardType="decimal-pad"
      placeholder={props.placeholder}
      placeholderTextColor="#7faad9"
      value={props.value}
      onChangeText={props.onChangeText}
      style={{
        color: "#ffffff",
        borderColor: "#1e3a5f",
        borderWidth: 1,
        paddingHorizontal: 12,
        paddingVertical: 10,
        borderRadius: 10,
        backgroundColor: "#002b5c",   // azul aeronáutico
        marginBottom: 10,
      }}
    />
  );

  const OpBtn = ({ value }: { value: typeof op }) => (
    <Pressable
      onPress={() => setOp(value)}
      style={({ pressed }) => ({
        paddingVertical: 10,
        paddingHorizontal: 16,
        borderRadius: 10,
        borderWidth: 1,
        borderColor: op === value ? "#4da6ff" : "#1e3a5f",
        backgroundColor: pressed ? "#003f7f" : "#002b5c",
        marginRight: 8,
      })}
    >
      <Text
        style={{
          color: op === value ? "#4da6ff" : "#ffffff",
          fontWeight: "bold",
        }}
      >
        {value}
      </Text>
    </Pressable>
  );

  return (
    <View style={{ flex: 1, backgroundColor: "#001933", padding: 16 }}>
      <Text
        style={{
          color: "#4da6ff",
          fontSize: 22,
          marginBottom: 12,
          fontWeight: "bold",
        }}
      >
        Calculadora de Reserva de Vuelo
      </Text>

      <Input placeholder="Valor A" value={a} onChangeText={setA} />
      <Input placeholder="Valor B" value={b} onChangeText={setB} />

      <View style={{ flexDirection: "row", marginVertical: 8 }}>
        <OpBtn value="+" />
        <OpBtn value="-" />
        <OpBtn value="*" />
        <OpBtn value="/" />
      </View>

      <Text style={{ color: "#ffffff", fontSize: 18, marginTop: 12 }}>
        Resultado:{" "}
        <Text style={{ color: "#4da6ff", fontWeight: "bold" }}>{result}</Text>
      </Text>
    </View>
  );
}
