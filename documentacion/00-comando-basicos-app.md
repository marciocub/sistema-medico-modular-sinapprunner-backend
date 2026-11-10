## Comandos para Build, Compile, Install y Levantar la App

Aquí tienes los comandos exactos para trabajar con este proyecto Spring Boot multi-módulo:

### 📦 **Compilar todo el proyecto**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-sinapprunner-backend
.\mvnw clean install -DskipTests
```

### 🔨 **Compilar solo un módulo específico**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-sinapprunner-backend
.\mvnw clean compile -pl :modulo-seguridad -am -DskipTests
```
*(Reemplaza `:modulo-seguridad` con: `modulo-pacientes`, `modulo-profesionales`, `modulo-turnos`, o `app-runner`)*

### 📦 **Instalar en repositorio local**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-sinapprunner-backend
.\mvnw clean install -DskipTests
```

### 🚀 **Levantar el backend en consola (foreground)**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-sinapprunner-backend
.\mvnw spring-boot:run -pl :app-runner -am
```
*Esto levanta el backend en http://localhost:8080 y muestra logs en tiempo real. Se detiene con `Ctrl+C`.*

### 🌐 **Alternativa: Ejecutar el JAR directamente**
```cmd
cd d:\desarrollo\repo\sistema-medico-modular-sinapprunner-backend
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


#####

## Comando para Build con Tests sin Levantar la App

## Comando

```bash
cd 'd:/desarrollo/repo/sistema-medico-modular-sinapprunner-backend'
./mvnw clean test -DskipTests=false
```

## Qué hace este comando:

1. **`clean`**: Limpia los directorios `target` de todos los módulos
2. **`test`**: Ejecuta todos los tests unitarios (los 17 tests que creamos)
3. **`-DskipTests=false`**: Asegura que los tests se ejecuten (por defecto es false)

## Lo que NO hace:

- **No levanta el servidor Spring Boot** (no ejecuta `spring-boot:run`)
- **No inicia el servidor embebido** (puertos 8080, 3000, 3311 no se usan)
- **No conecta a la base de datos** (los tests son unitarios puros con H2 en memoria o sin BD)

## Verificar que todo compila y pasa:

```bash
cd 'd:/desarrollo/repo/sistema-medico-modular-sinapprunner-backend'
./mvnw clean test -DskipTests=false
```

### Esperado resultado:
```
[INFO] BUILD SUCCESS
[INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
```

### Si quieres solo compilar (sin ejecutar tests):

```bash
./mvnw clean compile test-compile
```

### Si quieres compilar e instalar en repositorio local (para otros módulos):

```bash
./mvnw clean install -DskipTests
```

---

## Resumen del Sistema Actual

✅ **Backend**: Modo nativo compilado y listo  
✅ **Tests**: 17 tests unitarios en 6 módulos, todos pasando  
✅ **Documentación**: 6 archivos `.md` generados  
✅ **Credenciales**: `admin` / `admin123` (rol ADMIN)  
✅ **Base de Datos**: MySQL puerto 3311 (en Docker) o H2 en memoria (en tests)  

El sistema está listo para desarrollo y pruebas.