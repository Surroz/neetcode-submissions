class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> curRaw = new HashSet<>();
        var squares = new ArrayList<Set<Character>>();
        var columns = new ArrayList<Set<Character>>();
        for (int i = 0; i < 9; i++) {
            squares.add(new HashSet<>());
            columns.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            curRaw = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char symbol = board[i][j];
                if (symbol == '.')
                    continue;
                if (curRaw.contains(symbol))
                    return false;
                curRaw.add(symbol);

                var curColumn = columns.get(j);
                if (curColumn.contains(symbol))
                    return false;
                curColumn.add(symbol);

//                int dovz = j/3;
//                int vis = i/3 *3;
                var curSquare = squares.get(i/3 *3 + j/3);
                if (curSquare.contains(symbol))
                    return false;
                curSquare.add(symbol);
            }

//            0. 1. 2
//            3. 4. 5
//            6. 7. 8
        }
        return true;
    }
}
