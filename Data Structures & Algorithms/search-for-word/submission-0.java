class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean res = false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (word.charAt(0) == board[i][j]) {
                    res = searchWord(word, board, new Coordinates(i,j));
                    if (res)
                        break;
                }
            }
            if (res)
                break;
        }
        return res;
    }

    private static boolean searchWord(String word, char[][] matrix, Coordinates cur){
        var taken = new HashSet<Coordinates>();
        taken.add(cur);
        boolean res = checkCoords(word, matrix, cur.h-1, cur.w, 1, taken);
        if (!res)
            res = checkCoords(word, matrix, cur.h+1, cur.w, 1, taken);
        if (!res)
            res = checkCoords(word, matrix, cur.h, cur.w-1, 1, taken);
        if (!res)
            res = checkCoords(word, matrix, cur.h, cur.w+1, 1, taken);
        return res;
    }
    private static boolean checkCoords(String word, char[][] matrix, int h, int w, int idx, Set<Coordinates> taken) {
        if (idx == word.length())
            return true;
        else if (h >= 0 && h < matrix.length && w >= 0 && w < matrix[0].length) {
            char symbol = word.charAt(idx);
            Coordinates cur = new Coordinates(h,w);
            if (matrix[h][w] == symbol && !taken.contains(cur)) {
                taken.add(cur);
                idx++;
                boolean res = checkCoords(word, matrix, cur.h-1, cur.w, idx, taken);
                if (!res)
                    res = checkCoords(word, matrix, cur.h+1, cur.w, idx, taken);
                if (!res)
                    res = checkCoords(word, matrix, cur.h, cur.w-1, idx, taken);
                if (!res)
                    res = checkCoords(word, matrix, cur.h, cur.w+1, idx, taken);
                taken.remove(cur);
                return res;
            }
        }
        return false;
    }

    private record Coordinates(int h, int w) {}
}
