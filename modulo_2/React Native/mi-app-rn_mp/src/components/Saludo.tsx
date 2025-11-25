import React from "react";
import { View, Text } from "react-native";

export default function Saludo() {
  return (
    <View style={{ padding: 20 }}>
      <Text style={{ fontSize: 20, color: "red" }}>
        ¡Hola esta es mi app de la reserva de vuelos!
      </Text>
    </View>
  );
}