// src/types/index.ts

// INTERFACE para DTOs (extensible con 'extends')
export interface UserDTO {
  id: string;
  email: string;
  fullName: string;
  createdAt?: Date; // Propiedad opcional
}

// TYPE para uniones discriminadas
export type ApiState<T> =
  | { status: "IDLE"; data: null; error: null }
  | { status: "LOADING"; data: null; error: null }
  | { status: "SUCCESS"; data: T; error: null }
  | { status: "ERROR"; data: null; error: string };

// TYPE para composición
export type Product = {
  id: string;
  name: string;
  price: number;
  inStock: boolean;
};

// INTERFACE que extiende otra
export interface AdminUser extends UserDTO {
  role: "admin" | "superadmin";
  permissions: string[];
}

// Ejemplo de uso en componente
export const exampleState: ApiState<UserDTO> = {
  status: "SUCCESS",
  data: {
    id: "user-123",
    email: "ejemplo@mail.com",
    fullName: "Juan Pérez"
  },
  error: null
};