package JavaAssignment_June07.LibraryManagement.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Repository<T> {
    private Map<String, T> items = new HashMap<>();

    public void add(String id, T item) {
        items.put(id, item);
    }

    public T get(String id) {
        return items.get(id);
    }

    public void remove(String id) {
        items.remove(id);
    }

    public Collection<T> getAll() {
        return items.values();
    }
}

