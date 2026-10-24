
import java.util.*;

public class Main {
    static class Patient {
        String name;
        int priority;
        int order;

        Patient(String name, int priority, int order) {
            this.name = name;
            this.priority = priority;
            this.order = order;
        }
    }

    static PriorityQueue<Patient> queue = new PriorityQueue<>(
        (a, b) -> {
            if (a.priority != b.priority)
                return a.priority - b.priority;
            return a.order - b.order;
        }
    );

    static int count = 0;

    static void addPatient(String name, int priority) {
        queue.add(new Patient(name, priority, count++));
    }

    static void treatNext() {
        if (queue.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }

        Patient p = queue.poll();
        System.out.println(p.name + " treated (Priority " 
                           + p.priority + ")");
    }

    public static void main(String[] args) {
        addPatient("P1", 3);
        addPatient("P2", 1);
        addPatient("P3", 2);
        addPatient("P4", 1);
        addPatient("P5", 3);
        addPatient("P6", 2);

        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            treatNext();
        }

        System.out.println("\nTesting new Emergency:");
        addPatient("P7", 3);
        addPatient("P8", 2);
        addPatient("P9", 1);

        treatNext();
        addPatient("P10", 1);
        treatNext();
        treatNext();
        treatNext();
    }
}
