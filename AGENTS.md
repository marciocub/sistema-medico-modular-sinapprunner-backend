# Contexto y Reglas de Desarrollo - Sistema Médico Modular

## 📂 Estructura de Rutas del Proyecto
* **Raíz del Monodular:**  `D:/desarrollo/repo/sistema-medico-modular-backend`
* **Backend (Java / Spring Boot Multi-módulo):** 
  * Carpeta Backend: `[D:/desarrollo/repo/sistema-medico-modular-backend]`
  * Módulo BFF (App-Runner): `D:\desarrollo\repo\sistema-medico-modular-backend\app-runner]`
* **Frontend (React + Vite):** 
  * Carpeta Frontend: `[D:/desarrollo/repo/sistema-medico-modular-frontend]`

---

## 🛠️ Comandos Obligatorios por Entorno (PROHIBIDO MEZCLAR)

### 1. Backend (Spring Boot)
* **Modo de Ejecución:** EXCLUSIVAMENTE NATIVO y local (NO usar Docker para levantar la app, solo para la base de datos MySQL).
* **Comando para compilar todo:** 
  `.\mvnw clean install` (ejecutar siempre desde la raíz del backend).
* **Comando para arrancar el BFF:** 
  `.\mvnw spring-boot:run -pl :app-runner` (ejecutar estrictamente desde la raíz del backend).

### 2. Frontend (React + Vite)
* **Entorno:** Trabaja de forma independiente en su propia carpeta.
* **Comando para instalar dependencias:** 
  `npm install` (dentro de la carpeta del frontend).
* **Comando para desarrollo local:** 
  `npm run dev` (jamás ejecutar comandos de Node.js o NPM dentro de la carpeta del backend).

---

## 🛑 Restricciones Críticas para el Asistente (Cline)
1. **Separación de dominios:** Nunca ejecutes comandos de Maven o Java dentro de la carpeta del frontend, ni comandos de Node.js/npm dentro de la carpeta del backend.
2. **Cero Docker para la App:** No intentes construir imágenes de Docker ni correr contenedores para la app durante el desarrollo local; usa siempre el arranque nativo de Spring Boot.
3. **Gestión de Procesos:** No dejes procesos colgados en segundo plano (background) si no es estrictamente necesario; prioriza la ejecución directa en terminal para ver los logs en tiempo real.
4. **Gestión de git:** No commitees el codigo