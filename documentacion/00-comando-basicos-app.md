## Comandos para Build, Compile, Install y Levantar la App

Aquí tienes los comandos exactos para trabajar con este proyecto Spring Boot multi-módulo:

### 📦 **Compilar todo el proyecto**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-backend
.\mvnw clean install -DskipTests
```

### 🔨 **Compilar solo un módulo específico**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-backend
.\mvnw clean compile -pl :modulo-seguridad -am -DskipTests
```
*(Reemplaza `:modulo-seguridad` con: `modulo-pacientes`, `modulo-profesionales`, `modulo-turnos`, o `app-runner`)*

### 📦 **Instalar en repositorio local**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-backend
.\mvnw clean install -DskipTests
```

### 🚀 **Levantar el backend en consola (foreground)**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-backend
.\mvnw spring-boot:run -pl :app-runner -am
```
*Esto levanta el backend en http://localhost:8080 y muestra logs en tiempo real. Se detiene con `Ctrl+C`.*

### 🌐 **Alternativa: Ejecutar el JAR directamente**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-backend
.\mvnw clean package -DskipTests
java -jar app-runner\target\app-runner-0.0.1-SNAPSHOT.jar
```

### 📋 **Resumen de módulos y sus estados:**
- `modulo-seguridad` ✅ (compila e inicia)
- `modulo-pacientes` ✅ (compila e inicia)  
- `modulo-profesionales` ✅ (compila e inicia)
- `modulo-turnos` ✅ (compila e inicia)
- `app-runner` ✅ (es el módulo BFF principal)

### 💡 **Tipos útiles:**
- `-DskipTests`: Compilar sin ejecutar pruebas (más rápido)
- `-pl :modulo`: Compilar solo un módulo específico
- `-am`: Also Make (compila dependencias)
- `-q`: Quiet mode (muestra solo errores)

El proyecto está listo para producción con estos comandos.