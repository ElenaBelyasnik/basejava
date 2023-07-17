import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(storage[i].uuid, uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < size; j++) {
                    if (j + 1 < size && storage[j+1] != null){
                        storage[j] = storage[j+1];
                    } else {
                        storage[j] = null;
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
