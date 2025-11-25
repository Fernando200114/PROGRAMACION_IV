import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

import ToolsMenuScreen from "../screens/ToolsMenuScreen";
import CalculatorScreen from "../screens/CalculatorScreen";
import TriangleAreaScreen from "../screens/TriangleAreaScreen";
import CircleAreaScreen from "../screens/CircleAreaScreen";
import SquareAreaScreen from "../screens/SquareAreaScreen";
import colors from "../theme/colors";

export type RootStackParamList = {
  Users: undefined;
  UserDetail: { id: number };
  Posts: undefined;
  Tools: undefined;
  Calculator: undefined;
  TriangleArea: undefined;
  CircleArea: undefined;
  SquareArea: undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerStyle: { backgroundColor: "#002b5c" },     // Azul aeronáutico
          headerTintColor: "#ffffff",                    // Texto blanco
          contentStyle: { backgroundColor: "#001f3f" },   // Fondo oscuro elegante
        }}
      >

        <Stack.Screen 
          name="Tools" 
          component={ToolsMenuScreen} 
          options={{ title: "Herramientas de Vuelo" }} 
        />

        <Stack.Screen 
          name="Calculator" 
          component={CalculatorScreen} 
          options={{ title: "Calculadora de Reserva de Vuelo" }} 
        />

        <Stack.Screen 
          name="TriangleArea" 
          component={TriangleAreaScreen} 
          options={{ title: "Cálculo de Distancia Aérea (Triángulo)" }} 
        />

        <Stack.Screen 
          name="CircleArea" 
          component={CircleAreaScreen} 
          options={{ title: "Área Circular de Zona Aérea" }} 
        />

        <Stack.Screen 
          name="SquareArea" 
          component={SquareAreaScreen} 
          options={{ title: "Área Cuadrada de Zona Aérea" }} 
        />

      </Stack.Navigator>
    </NavigationContainer>
  );
}
