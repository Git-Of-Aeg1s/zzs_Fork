package org.example;
//以下是2022211880王梓霁提出的优化建议:
//1.避免修改输入数组:
//在DFS函数中，代码直接修改了输入的grid数组，将访问过的陆地标记为1。这可能会影响到其他依赖于原始数据的操作。
//为了避免这种情况，可以使用一个额外的数组来记录访问状态。
//2.优化DFS的终止条件: 在DFS函数中，如果遇到边界或者遇到水，函数会返回。
//这没有问题，但是可以稍微优化一下，比如可以直接在遇到边界或水的情况下立即返回，而不是先标记为1。
//3.减少参数传递: 在DFS函数中，参数nr和nc每次调用时都被传递，但实际上它们的值是不变的。
//可以将它们作为类变量或局部变量存储起来，避免每次调用都传递。
//4.使用栈替代递归: DFS可以通过递归实现，也可以使用栈来实现非递归的方式。
//对于大型网格，递归可能导致堆栈溢出，而非递归方式可以避免这个问题。
//5.测试用例的完善: 测试类中的测试用例可以更加全面，比如包含不同大小、形状和分布的岛屿，以及边缘情况。
/**
 * @description:
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 */
class Solution8 {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 检查边界条件和是否访问过（或是否为水）
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '1'; // 标记为已访问
        dfs(grid, r - 1, c); // 上
        dfs(grid, r + 1, c); // 下
        dfs(grid, r, c - 1); // 左
        dfs(grid, r, c + 1); // 右
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) { // 这里修正了循环条件
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }
}