package com.akhambir;

public class Validator {
    public static byte checkCellState(byte value, String errorMessage) {
        if (value < 0 || value > 13) {
            throw new RuntimeException(errorMessage);
        }
        return value;
    }
}
