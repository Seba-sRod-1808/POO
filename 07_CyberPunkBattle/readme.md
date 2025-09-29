# Cyberpunk Battle simulador de juego por turnos.
---

## Mecánicas del Juego

### 1. Jugador
- El jugador por defecto es combatiente, pero tocando el codigo puede ser tambien explorador
- Acciones por turno:
  1. **Atacar** a un enemigo.
  2. **Usar ítem en sí mismo** 
  3. **Usar ítem en un enemigo**
  4. **Pasar turno**.

### 2. Enemigos
- Siempre se generan **de uno a tres enemigos distintos**:
  - **Arasaka** → estilo tecnológico 
  - **Biotechnica** → estilo biológico
  - **Militech** → estilo militar
- Cada enemigo tiene **1/3 de probabilidad** de aparecer como **jefe**:
  - Más vida y ataque.
  - Una habilidad especial más poderosa.

- Acciones por turno:
  1. Atacar al jugador.
  2. Usar habilidad especial.
  3. Pasar turno.

- En cada ciclo de batalla: un turno el jugador y luego un enemigo aleatorio vivo.

### 3. Ítems del Jugador
- **Poción de Vida**: restaura vida al jugador.
- **Botas de Salto**: evitan el siguiente ataque enemigo (OP).
- **Francotirador**: inflige más daño de lo normal a un enemigo seleccionado.

### 4. Registro de Acciones
- El sistema guarda y muestra siempre las **últimas 3 acciones** realizadas, por ejemplo:
- **V ataco a Biotechnica (-15 HP)**
- **Biotechnica uso Virus contra V (-10 HP)**
- **V usó Botas de Salto en si mismo**


### 5. Condiciones de Fin
- El juego termina cuando:
- El jugador llega a 0 de vida → derrota.
- Todos los enemigos llegan a 0 de vida → victoria.

---

## Compilación y Ejecución

El proyecto usa **paquetes** es decir subcarpetas ya que todo se veia desordenado, por lo que hay compilar respetando la estructura de carpetas.

### En bash
```bash
javac -d . cyberpunkbattle/**/*.java
java cyberpunkbattle.Main
```
O en Powershell se ejecuta
javac -d . (Get-ChildItem -Recurse -Filter *.java).FullName
java cyberpunkbattle.Main

Siempre dentro de la carpeta raiz del proyecto
