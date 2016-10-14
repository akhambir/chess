package com.akhambir.util;

import com.akhambir.model.Cell;

public class Validator {

    public static byte checkCellState(byte value, String errorMessage) {
        if (value < 0 || value > 13) {
            throw new RuntimeException(errorMessage);
        }
        return value;
    }

    public static void checkRowAndColumnState(int row, int column) {
        if (column < 1 || column > 8) {
            throw new RuntimeException("Wrong column value. Passed value: " + column);
        }
        if (row < 1 || row > 8) {
            throw new RuntimeException("Wrong row value. Passed value: " + row);
        }
    }

    public static void checkFigureValue(byte value) {
        if (value < 0 || value > 13) {
            throw new RuntimeException("Wrong figure value. Passed value: " + value);
        }
    }

    public static boolean isOddRowAndOddColumn(Cell cell) {
        return cell.getRow() % 2 == 1 && cell.getColumn() - 'a' % 2 == 1;
    }

    public static boolean isEvenRowAndEvenColumn(Cell cell) {
        return !isOddRowAndOddColumn(cell);                       // TODO is it good idea? im not sure...
    }
}
