package ActividadCorregido;

import java.util.*;

public class BuggyActividadCorregido {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Corrección: usar índice válido, se cambia de 3 a 2
        System.out.println("Elemento en posición 2: " + nombres.get(2));

        // Corrección: comparar cadenas con equals
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
         Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Ana", "0993333333"); // Sobrescribe la entrada anterior de "Ana"

        // Error corregido: Se valida que la clave exista antes de intentar acceder a su valor.
        // Si la clave "Bea" no existe, .get("Bea") devuelve null, y .toString() lanza una excepción NullPointerException.
        String telefonoDeBea = telefonos.get("Bea");
        if (telefonoDeBea != null) {
            System.out.println("Teléfono de Bea: " + telefonoDeBea);
        } else {
            System.out.println("Bea no tiene teléfono registrado.");
        }

        // SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico ahora no entra

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

// Clase Alumno con equals y hashCode → evita duplicados lógicos
class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }
}
