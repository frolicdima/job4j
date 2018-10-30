package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int external = 0; external < unique; external++) {
            for (int internal = external + 1; internal < unique; internal++) {
                if (array[external].equals(array[internal])) {
                    array[internal] = array[unique - 1];
                    unique--;
                    internal--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
